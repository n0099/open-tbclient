package androidx.recyclerview.widget;

import androidx.annotation.IntRange;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.VisibleForTesting;
import androidx.recyclerview.widget.RecyclerView;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
/* loaded from: classes.dex */
public class DiffUtil {
    public static final Comparator<Snake> SNAKE_COMPARATOR = new Comparator<Snake>() { // from class: androidx.recyclerview.widget.DiffUtil.1
        /* JADX DEBUG: Method merged with bridge method */
        @Override // java.util.Comparator
        public int compare(Snake snake, Snake snake2) {
            int i2 = snake.x - snake2.x;
            return i2 == 0 ? snake.y - snake2.y : i2;
        }
    };

    /* loaded from: classes.dex */
    public static abstract class Callback {
        public abstract boolean areContentsTheSame(int i2, int i3);

        public abstract boolean areItemsTheSame(int i2, int i3);

        @Nullable
        public Object getChangePayload(int i2, int i3) {
            return null;
        }

        public abstract int getNewListSize();

        public abstract int getOldListSize();
    }

    /* loaded from: classes.dex */
    public static class DiffResult {
        public static final int FLAG_CHANGED = 2;
        public static final int FLAG_IGNORE = 16;
        public static final int FLAG_MASK = 31;
        public static final int FLAG_MOVED_CHANGED = 4;
        public static final int FLAG_MOVED_NOT_CHANGED = 8;
        public static final int FLAG_NOT_CHANGED = 1;
        public static final int FLAG_OFFSET = 5;
        public static final int NO_POSITION = -1;
        public final Callback mCallback;
        public final boolean mDetectMoves;
        public final int[] mNewItemStatuses;
        public final int mNewListSize;
        public final int[] mOldItemStatuses;
        public final int mOldListSize;
        public final List<Snake> mSnakes;

        public DiffResult(Callback callback, List<Snake> list, int[] iArr, int[] iArr2, boolean z) {
            this.mSnakes = list;
            this.mOldItemStatuses = iArr;
            this.mNewItemStatuses = iArr2;
            Arrays.fill(iArr, 0);
            Arrays.fill(this.mNewItemStatuses, 0);
            this.mCallback = callback;
            this.mOldListSize = callback.getOldListSize();
            this.mNewListSize = callback.getNewListSize();
            this.mDetectMoves = z;
            addRootSnake();
            findMatchingItems();
        }

        private void addRootSnake() {
            Snake snake = this.mSnakes.isEmpty() ? null : this.mSnakes.get(0);
            if (snake != null && snake.x == 0 && snake.y == 0) {
                return;
            }
            Snake snake2 = new Snake();
            snake2.x = 0;
            snake2.y = 0;
            snake2.removal = false;
            snake2.size = 0;
            snake2.reverse = false;
            this.mSnakes.add(0, snake2);
        }

        private void dispatchAdditions(List<PostponedUpdate> list, ListUpdateCallback listUpdateCallback, int i2, int i3, int i4) {
            if (!this.mDetectMoves) {
                listUpdateCallback.onInserted(i2, i3);
                return;
            }
            for (int i5 = i3 - 1; i5 >= 0; i5--) {
                int i6 = i4 + i5;
                int i7 = this.mNewItemStatuses[i6] & 31;
                if (i7 == 0) {
                    listUpdateCallback.onInserted(i2, 1);
                    for (PostponedUpdate postponedUpdate : list) {
                        postponedUpdate.currentPos++;
                    }
                } else if (i7 == 4 || i7 == 8) {
                    int i8 = this.mNewItemStatuses[i6] >> 5;
                    listUpdateCallback.onMoved(removePostponedUpdate(list, i8, true).currentPos, i2);
                    if (i7 == 4) {
                        listUpdateCallback.onChanged(i2, 1, this.mCallback.getChangePayload(i8, i6));
                    }
                } else if (i7 == 16) {
                    list.add(new PostponedUpdate(i6, i2, false));
                } else {
                    throw new IllegalStateException("unknown flag for pos " + i6 + " " + Long.toBinaryString(i7));
                }
            }
        }

        private void dispatchRemovals(List<PostponedUpdate> list, ListUpdateCallback listUpdateCallback, int i2, int i3, int i4) {
            if (!this.mDetectMoves) {
                listUpdateCallback.onRemoved(i2, i3);
                return;
            }
            for (int i5 = i3 - 1; i5 >= 0; i5--) {
                int i6 = i4 + i5;
                int i7 = this.mOldItemStatuses[i6] & 31;
                if (i7 == 0) {
                    listUpdateCallback.onRemoved(i2 + i5, 1);
                    for (PostponedUpdate postponedUpdate : list) {
                        postponedUpdate.currentPos--;
                    }
                } else if (i7 == 4 || i7 == 8) {
                    int i8 = this.mOldItemStatuses[i6] >> 5;
                    PostponedUpdate removePostponedUpdate = removePostponedUpdate(list, i8, false);
                    listUpdateCallback.onMoved(i2 + i5, removePostponedUpdate.currentPos - 1);
                    if (i7 == 4) {
                        listUpdateCallback.onChanged(removePostponedUpdate.currentPos - 1, 1, this.mCallback.getChangePayload(i6, i8));
                    }
                } else if (i7 == 16) {
                    list.add(new PostponedUpdate(i6, i2 + i5, true));
                } else {
                    throw new IllegalStateException("unknown flag for pos " + i6 + " " + Long.toBinaryString(i7));
                }
            }
        }

        private void findAddition(int i2, int i3, int i4) {
            if (this.mOldItemStatuses[i2 - 1] != 0) {
                return;
            }
            findMatchingItem(i2, i3, i4, false);
        }

        private boolean findMatchingItem(int i2, int i3, int i4, boolean z) {
            int i5;
            int i6;
            int i7;
            if (z) {
                i3--;
                i6 = i2;
                i5 = i3;
            } else {
                i5 = i2 - 1;
                i6 = i5;
            }
            while (i4 >= 0) {
                Snake snake = this.mSnakes.get(i4);
                int i8 = snake.x;
                int i9 = snake.size;
                int i10 = i8 + i9;
                int i11 = snake.y + i9;
                if (z) {
                    for (int i12 = i6 - 1; i12 >= i10; i12--) {
                        if (this.mCallback.areItemsTheSame(i12, i5)) {
                            i7 = this.mCallback.areContentsTheSame(i12, i5) ? 8 : 4;
                            this.mNewItemStatuses[i5] = (i12 << 5) | 16;
                            this.mOldItemStatuses[i12] = (i5 << 5) | i7;
                            return true;
                        }
                    }
                    continue;
                } else {
                    for (int i13 = i3 - 1; i13 >= i11; i13--) {
                        if (this.mCallback.areItemsTheSame(i5, i13)) {
                            i7 = this.mCallback.areContentsTheSame(i5, i13) ? 8 : 4;
                            int i14 = i2 - 1;
                            this.mOldItemStatuses[i14] = (i13 << 5) | 16;
                            this.mNewItemStatuses[i13] = (i14 << 5) | i7;
                            return true;
                        }
                    }
                    continue;
                }
                i6 = snake.x;
                i3 = snake.y;
                i4--;
            }
            return false;
        }

        private void findMatchingItems() {
            int i2 = this.mOldListSize;
            int i3 = this.mNewListSize;
            for (int size = this.mSnakes.size() - 1; size >= 0; size--) {
                Snake snake = this.mSnakes.get(size);
                int i4 = snake.x;
                int i5 = snake.size;
                int i6 = i4 + i5;
                int i7 = snake.y + i5;
                if (this.mDetectMoves) {
                    while (i2 > i6) {
                        findAddition(i2, i3, size);
                        i2--;
                    }
                    while (i3 > i7) {
                        findRemoval(i2, i3, size);
                        i3--;
                    }
                }
                for (int i8 = 0; i8 < snake.size; i8++) {
                    int i9 = snake.x + i8;
                    int i10 = snake.y + i8;
                    int i11 = this.mCallback.areContentsTheSame(i9, i10) ? 1 : 2;
                    this.mOldItemStatuses[i9] = (i10 << 5) | i11;
                    this.mNewItemStatuses[i10] = (i9 << 5) | i11;
                }
                i2 = snake.x;
                i3 = snake.y;
            }
        }

        private void findRemoval(int i2, int i3, int i4) {
            if (this.mNewItemStatuses[i3 - 1] != 0) {
                return;
            }
            findMatchingItem(i2, i3, i4, true);
        }

        public static PostponedUpdate removePostponedUpdate(List<PostponedUpdate> list, int i2, boolean z) {
            int size = list.size() - 1;
            while (size >= 0) {
                PostponedUpdate postponedUpdate = list.get(size);
                if (postponedUpdate.posInOwnerList == i2 && postponedUpdate.removal == z) {
                    list.remove(size);
                    while (size < list.size()) {
                        list.get(size).currentPos += z ? 1 : -1;
                        size++;
                    }
                    return postponedUpdate;
                }
                size--;
            }
            return null;
        }

        public int convertNewPositionToOld(@IntRange(from = 0) int i2) {
            if (i2 >= 0 && i2 < this.mNewListSize) {
                int i3 = this.mNewItemStatuses[i2];
                if ((i3 & 31) == 0) {
                    return -1;
                }
                return i3 >> 5;
            }
            throw new IndexOutOfBoundsException("Index out of bounds - passed position = " + i2 + ", new list size = " + this.mNewListSize);
        }

        public int convertOldPositionToNew(@IntRange(from = 0) int i2) {
            if (i2 >= 0 && i2 < this.mOldListSize) {
                int i3 = this.mOldItemStatuses[i2];
                if ((i3 & 31) == 0) {
                    return -1;
                }
                return i3 >> 5;
            }
            throw new IndexOutOfBoundsException("Index out of bounds - passed position = " + i2 + ", old list size = " + this.mOldListSize);
        }

        public void dispatchUpdatesTo(@NonNull RecyclerView.Adapter adapter) {
            dispatchUpdatesTo(new AdapterListUpdateCallback(adapter));
        }

        @VisibleForTesting
        public List<Snake> getSnakes() {
            return this.mSnakes;
        }

        public void dispatchUpdatesTo(@NonNull ListUpdateCallback listUpdateCallback) {
            BatchingListUpdateCallback batchingListUpdateCallback;
            if (listUpdateCallback instanceof BatchingListUpdateCallback) {
                batchingListUpdateCallback = (BatchingListUpdateCallback) listUpdateCallback;
            } else {
                batchingListUpdateCallback = new BatchingListUpdateCallback(listUpdateCallback);
            }
            ArrayList arrayList = new ArrayList();
            int i2 = this.mOldListSize;
            int i3 = this.mNewListSize;
            for (int size = this.mSnakes.size() - 1; size >= 0; size--) {
                Snake snake = this.mSnakes.get(size);
                int i4 = snake.size;
                int i5 = snake.x + i4;
                int i6 = snake.y + i4;
                if (i5 < i2) {
                    dispatchRemovals(arrayList, batchingListUpdateCallback, i5, i2 - i5, i5);
                }
                if (i6 < i3) {
                    dispatchAdditions(arrayList, batchingListUpdateCallback, i5, i3 - i6, i6);
                }
                for (int i7 = i4 - 1; i7 >= 0; i7--) {
                    int[] iArr = this.mOldItemStatuses;
                    int i8 = snake.x;
                    if ((iArr[i8 + i7] & 31) == 2) {
                        batchingListUpdateCallback.onChanged(i8 + i7, 1, this.mCallback.getChangePayload(i8 + i7, snake.y + i7));
                    }
                }
                i2 = snake.x;
                i3 = snake.y;
            }
            batchingListUpdateCallback.dispatchLastEvent();
        }
    }

    /* loaded from: classes.dex */
    public static abstract class ItemCallback<T> {
        public abstract boolean areContentsTheSame(@NonNull T t, @NonNull T t2);

        public abstract boolean areItemsTheSame(@NonNull T t, @NonNull T t2);

        @Nullable
        public Object getChangePayload(@NonNull T t, @NonNull T t2) {
            return null;
        }
    }

    /* loaded from: classes.dex */
    public static class PostponedUpdate {
        public int currentPos;
        public int posInOwnerList;
        public boolean removal;

        public PostponedUpdate(int i2, int i3, boolean z) {
            this.posInOwnerList = i2;
            this.currentPos = i3;
            this.removal = z;
        }
    }

    /* loaded from: classes.dex */
    public static class Range {
        public int newListEnd;
        public int newListStart;
        public int oldListEnd;
        public int oldListStart;

        public Range() {
        }

        public Range(int i2, int i3, int i4, int i5) {
            this.oldListStart = i2;
            this.oldListEnd = i3;
            this.newListStart = i4;
            this.newListEnd = i5;
        }
    }

    /* loaded from: classes.dex */
    public static class Snake {
        public boolean removal;
        public boolean reverse;
        public int size;
        public int x;
        public int y;
    }

    @NonNull
    public static DiffResult calculateDiff(@NonNull Callback callback) {
        return calculateDiff(callback, true);
    }

    /* JADX WARN: Code restructure failed: missing block: B:17:0x0042, code lost:
        if (r24[r13 - 1] < r24[r13 + r5]) goto L42;
     */
    /* JADX WARN: Code restructure failed: missing block: B:45:0x00b8, code lost:
        if (r25[r12 - 1] < r25[r12 + 1]) goto L77;
     */
    /* JADX WARN: Removed duplicated region for block: B:56:0x00e1 A[LOOP:4: B:52:0x00cd->B:56:0x00e1, LOOP_END] */
    /* JADX WARN: Removed duplicated region for block: B:89:0x00ec A[EDGE_INSN: B:89:0x00ec->B:58:0x00ec ?: BREAK  , SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static Snake diffPartial(Callback callback, int i2, int i3, int i4, int i5, int[] iArr, int[] iArr2, int i6) {
        int i7;
        int i8;
        boolean z;
        int i9;
        int i10;
        int i11;
        boolean z2;
        int i12;
        int i13 = i3 - i2;
        int i14 = i5 - i4;
        int i15 = 1;
        if (i13 < 1 || i14 < 1) {
            return null;
        }
        int i16 = i13 - i14;
        int i17 = ((i13 + i14) + 1) / 2;
        int i18 = (i6 - i17) - 1;
        int i19 = i6 + i17 + 1;
        Arrays.fill(iArr, i18, i19, 0);
        Arrays.fill(iArr2, i18 + i16, i19 + i16, i13);
        boolean z3 = i16 % 2 != 0;
        int i20 = 0;
        while (i20 <= i17) {
            int i21 = -i20;
            int i22 = i21;
            while (i22 <= i20) {
                if (i22 != i21) {
                    if (i22 != i20) {
                        int i23 = i6 + i22;
                    }
                    i11 = iArr[(i6 + i22) - i15] + i15;
                    z2 = true;
                    for (i12 = i11 - i22; i11 < i13 && i12 < i14 && callback.areItemsTheSame(i2 + i11, i4 + i12); i12++) {
                        i11++;
                    }
                    int i24 = i6 + i22;
                    iArr[i24] = i11;
                    if (!z3 && i22 >= (i16 - i20) + 1 && i22 <= (i16 + i20) - 1 && iArr[i24] >= iArr2[i24]) {
                        Snake snake = new Snake();
                        int i25 = iArr2[i24];
                        snake.x = i25;
                        snake.y = i25 - i22;
                        snake.size = iArr[i24] - iArr2[i24];
                        snake.removal = z2;
                        snake.reverse = false;
                        return snake;
                    }
                    i22 += 2;
                    i15 = 1;
                }
                i11 = iArr[i6 + i22 + i15];
                z2 = false;
                while (i11 < i13) {
                    i11++;
                }
                int i242 = i6 + i22;
                iArr[i242] = i11;
                if (!z3) {
                }
                i22 += 2;
                i15 = 1;
            }
            int i26 = i21;
            while (i26 <= i20) {
                int i27 = i26 + i16;
                if (i27 != i20 + i16) {
                    if (i27 != i21 + i16) {
                        int i28 = i6 + i27;
                        i7 = 1;
                    } else {
                        i7 = 1;
                    }
                    i8 = iArr2[(i6 + i27) + i7] - i7;
                    z = true;
                    i9 = i8 - i27;
                    while (i8 > 0 && i9 > 0) {
                        i10 = i13;
                        if (callback.areItemsTheSame((i2 + i8) - 1, (i4 + i9) - 1)) {
                            break;
                        }
                        i8--;
                        i9--;
                        i13 = i10;
                    }
                    i10 = i13;
                    int i29 = i6 + i27;
                    iArr2[i29] = i8;
                    if (z3 && i27 >= i21 && i27 <= i20 && iArr[i29] >= iArr2[i29]) {
                        Snake snake2 = new Snake();
                        int i30 = iArr2[i29];
                        snake2.x = i30;
                        snake2.y = i30 - i27;
                        snake2.size = iArr[i29] - iArr2[i29];
                        snake2.removal = z;
                        snake2.reverse = true;
                        return snake2;
                    }
                    i26 += 2;
                    i13 = i10;
                } else {
                    i7 = 1;
                }
                i8 = iArr2[(i6 + i27) - i7];
                z = false;
                i9 = i8 - i27;
                while (i8 > 0) {
                    i10 = i13;
                    if (callback.areItemsTheSame((i2 + i8) - 1, (i4 + i9) - 1)) {
                    }
                }
                i10 = i13;
                int i292 = i6 + i27;
                iArr2[i292] = i8;
                if (z3) {
                }
                i26 += 2;
                i13 = i10;
            }
            i20++;
            i13 = i13;
            i15 = 1;
        }
        throw new IllegalStateException("DiffUtil hit an unexpected case while trying to calculate the optimal path. Please make sure your data is not changing during the diff calculation.");
    }

    @NonNull
    public static DiffResult calculateDiff(@NonNull Callback callback, boolean z) {
        int oldListSize = callback.getOldListSize();
        int newListSize = callback.getNewListSize();
        ArrayList arrayList = new ArrayList();
        ArrayList arrayList2 = new ArrayList();
        arrayList2.add(new Range(0, oldListSize, 0, newListSize));
        int abs = oldListSize + newListSize + Math.abs(oldListSize - newListSize);
        int i2 = abs * 2;
        int[] iArr = new int[i2];
        int[] iArr2 = new int[i2];
        ArrayList arrayList3 = new ArrayList();
        while (!arrayList2.isEmpty()) {
            Range range = (Range) arrayList2.remove(arrayList2.size() - 1);
            Snake diffPartial = diffPartial(callback, range.oldListStart, range.oldListEnd, range.newListStart, range.newListEnd, iArr, iArr2, abs);
            if (diffPartial != null) {
                if (diffPartial.size > 0) {
                    arrayList.add(diffPartial);
                }
                diffPartial.x += range.oldListStart;
                diffPartial.y += range.newListStart;
                Range range2 = arrayList3.isEmpty() ? new Range() : (Range) arrayList3.remove(arrayList3.size() - 1);
                range2.oldListStart = range.oldListStart;
                range2.newListStart = range.newListStart;
                if (diffPartial.reverse) {
                    range2.oldListEnd = diffPartial.x;
                    range2.newListEnd = diffPartial.y;
                } else if (diffPartial.removal) {
                    range2.oldListEnd = diffPartial.x - 1;
                    range2.newListEnd = diffPartial.y;
                } else {
                    range2.oldListEnd = diffPartial.x;
                    range2.newListEnd = diffPartial.y - 1;
                }
                arrayList2.add(range2);
                if (diffPartial.reverse) {
                    if (diffPartial.removal) {
                        int i3 = diffPartial.x;
                        int i4 = diffPartial.size;
                        range.oldListStart = i3 + i4 + 1;
                        range.newListStart = diffPartial.y + i4;
                    } else {
                        int i5 = diffPartial.x;
                        int i6 = diffPartial.size;
                        range.oldListStart = i5 + i6;
                        range.newListStart = diffPartial.y + i6 + 1;
                    }
                } else {
                    int i7 = diffPartial.x;
                    int i8 = diffPartial.size;
                    range.oldListStart = i7 + i8;
                    range.newListStart = diffPartial.y + i8;
                }
                arrayList2.add(range);
            } else {
                arrayList3.add(range);
            }
        }
        Collections.sort(arrayList, SNAKE_COMPARATOR);
        return new DiffResult(callback, arrayList, iArr, iArr2, z);
    }
}
