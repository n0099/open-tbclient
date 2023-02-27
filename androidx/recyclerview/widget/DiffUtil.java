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
            int i = snake.x - snake2.x;
            if (i == 0) {
                return snake.y - snake2.y;
            }
            return i;
        }
    };

    /* loaded from: classes.dex */
    public static abstract class Callback {
        public abstract boolean areContentsTheSame(int i, int i2);

        public abstract boolean areItemsTheSame(int i, int i2);

        @Nullable
        public Object getChangePayload(int i, int i2) {
            return null;
        }

        public abstract int getNewListSize();

        public abstract int getOldListSize();
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
    public static class Snake {
        public boolean removal;
        public boolean reverse;
        public int size;
        public int x;
        public int y;
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
            Snake snake;
            if (this.mSnakes.isEmpty()) {
                snake = null;
            } else {
                snake = this.mSnakes.get(0);
            }
            if (snake == null || snake.x != 0 || snake.y != 0) {
                Snake snake2 = new Snake();
                snake2.x = 0;
                snake2.y = 0;
                snake2.removal = false;
                snake2.size = 0;
                snake2.reverse = false;
                this.mSnakes.add(0, snake2);
            }
        }

        @VisibleForTesting
        public List<Snake> getSnakes() {
            return this.mSnakes;
        }

        private void dispatchAdditions(List<PostponedUpdate> list, ListUpdateCallback listUpdateCallback, int i, int i2, int i3) {
            if (!this.mDetectMoves) {
                listUpdateCallback.onInserted(i, i2);
                return;
            }
            for (int i4 = i2 - 1; i4 >= 0; i4--) {
                int i5 = i3 + i4;
                int i6 = this.mNewItemStatuses[i5] & 31;
                if (i6 != 0) {
                    if (i6 != 4 && i6 != 8) {
                        if (i6 == 16) {
                            list.add(new PostponedUpdate(i5, i, false));
                        } else {
                            throw new IllegalStateException("unknown flag for pos " + i5 + " " + Long.toBinaryString(i6));
                        }
                    } else {
                        int i7 = this.mNewItemStatuses[i5] >> 5;
                        listUpdateCallback.onMoved(removePostponedUpdate(list, i7, true).currentPos, i);
                        if (i6 == 4) {
                            listUpdateCallback.onChanged(i, 1, this.mCallback.getChangePayload(i7, i5));
                        }
                    }
                } else {
                    listUpdateCallback.onInserted(i, 1);
                    for (PostponedUpdate postponedUpdate : list) {
                        postponedUpdate.currentPos++;
                    }
                }
            }
        }

        private void dispatchRemovals(List<PostponedUpdate> list, ListUpdateCallback listUpdateCallback, int i, int i2, int i3) {
            if (!this.mDetectMoves) {
                listUpdateCallback.onRemoved(i, i2);
                return;
            }
            for (int i4 = i2 - 1; i4 >= 0; i4--) {
                int i5 = i3 + i4;
                int i6 = this.mOldItemStatuses[i5] & 31;
                if (i6 != 0) {
                    if (i6 != 4 && i6 != 8) {
                        if (i6 == 16) {
                            list.add(new PostponedUpdate(i5, i + i4, true));
                        } else {
                            throw new IllegalStateException("unknown flag for pos " + i5 + " " + Long.toBinaryString(i6));
                        }
                    } else {
                        int i7 = this.mOldItemStatuses[i5] >> 5;
                        PostponedUpdate removePostponedUpdate = removePostponedUpdate(list, i7, false);
                        listUpdateCallback.onMoved(i + i4, removePostponedUpdate.currentPos - 1);
                        if (i6 == 4) {
                            listUpdateCallback.onChanged(removePostponedUpdate.currentPos - 1, 1, this.mCallback.getChangePayload(i5, i7));
                        }
                    }
                } else {
                    listUpdateCallback.onRemoved(i + i4, 1);
                    for (PostponedUpdate postponedUpdate : list) {
                        postponedUpdate.currentPos--;
                    }
                }
            }
        }

        private void findAddition(int i, int i2, int i3) {
            if (this.mOldItemStatuses[i - 1] != 0) {
                return;
            }
            findMatchingItem(i, i2, i3, false);
        }

        private void findRemoval(int i, int i2, int i3) {
            if (this.mNewItemStatuses[i2 - 1] != 0) {
                return;
            }
            findMatchingItem(i, i2, i3, true);
        }

        private boolean findMatchingItem(int i, int i2, int i3, boolean z) {
            int i4;
            int i5;
            if (z) {
                i2--;
                i5 = i;
                i4 = i2;
            } else {
                i4 = i - 1;
                i5 = i4;
            }
            while (i3 >= 0) {
                Snake snake = this.mSnakes.get(i3);
                int i6 = snake.x;
                int i7 = snake.size;
                int i8 = i6 + i7;
                int i9 = snake.y + i7;
                int i10 = 8;
                if (z) {
                    for (int i11 = i5 - 1; i11 >= i8; i11--) {
                        if (this.mCallback.areItemsTheSame(i11, i4)) {
                            if (!this.mCallback.areContentsTheSame(i11, i4)) {
                                i10 = 4;
                            }
                            this.mNewItemStatuses[i4] = (i11 << 5) | 16;
                            this.mOldItemStatuses[i11] = (i4 << 5) | i10;
                            return true;
                        }
                    }
                    continue;
                } else {
                    for (int i12 = i2 - 1; i12 >= i9; i12--) {
                        if (this.mCallback.areItemsTheSame(i4, i12)) {
                            if (!this.mCallback.areContentsTheSame(i4, i12)) {
                                i10 = 4;
                            }
                            int i13 = i - 1;
                            this.mOldItemStatuses[i13] = (i12 << 5) | 16;
                            this.mNewItemStatuses[i12] = (i13 << 5) | i10;
                            return true;
                        }
                    }
                    continue;
                }
                i5 = snake.x;
                i2 = snake.y;
                i3--;
            }
            return false;
        }

        private void findMatchingItems() {
            int i;
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
                    if (this.mCallback.areContentsTheSame(i9, i10)) {
                        i = 1;
                    } else {
                        i = 2;
                    }
                    this.mOldItemStatuses[i9] = (i10 << 5) | i;
                    this.mNewItemStatuses[i10] = (i9 << 5) | i;
                }
                i2 = snake.x;
                i3 = snake.y;
            }
        }

        public static PostponedUpdate removePostponedUpdate(List<PostponedUpdate> list, int i, boolean z) {
            int i2;
            int size = list.size() - 1;
            while (size >= 0) {
                PostponedUpdate postponedUpdate = list.get(size);
                if (postponedUpdate.posInOwnerList == i && postponedUpdate.removal == z) {
                    list.remove(size);
                    while (size < list.size()) {
                        PostponedUpdate postponedUpdate2 = list.get(size);
                        int i3 = postponedUpdate2.currentPos;
                        if (z) {
                            i2 = 1;
                        } else {
                            i2 = -1;
                        }
                        postponedUpdate2.currentPos = i3 + i2;
                        size++;
                    }
                    return postponedUpdate;
                }
                size--;
            }
            return null;
        }

        public int convertNewPositionToOld(@IntRange(from = 0) int i) {
            if (i >= 0 && i < this.mNewListSize) {
                int i2 = this.mNewItemStatuses[i];
                if ((i2 & 31) == 0) {
                    return -1;
                }
                return i2 >> 5;
            }
            throw new IndexOutOfBoundsException("Index out of bounds - passed position = " + i + ", new list size = " + this.mNewListSize);
        }

        public int convertOldPositionToNew(@IntRange(from = 0) int i) {
            if (i >= 0 && i < this.mOldListSize) {
                int i2 = this.mOldItemStatuses[i];
                if ((i2 & 31) == 0) {
                    return -1;
                }
                return i2 >> 5;
            }
            throw new IndexOutOfBoundsException("Index out of bounds - passed position = " + i + ", old list size = " + this.mOldListSize);
        }

        public void dispatchUpdatesTo(@NonNull ListUpdateCallback listUpdateCallback) {
            BatchingListUpdateCallback batchingListUpdateCallback;
            if (listUpdateCallback instanceof BatchingListUpdateCallback) {
                batchingListUpdateCallback = (BatchingListUpdateCallback) listUpdateCallback;
            } else {
                batchingListUpdateCallback = new BatchingListUpdateCallback(listUpdateCallback);
            }
            ArrayList arrayList = new ArrayList();
            int i = this.mOldListSize;
            int i2 = this.mNewListSize;
            for (int size = this.mSnakes.size() - 1; size >= 0; size--) {
                Snake snake = this.mSnakes.get(size);
                int i3 = snake.size;
                int i4 = snake.x + i3;
                int i5 = snake.y + i3;
                if (i4 < i) {
                    dispatchRemovals(arrayList, batchingListUpdateCallback, i4, i - i4, i4);
                }
                if (i5 < i2) {
                    dispatchAdditions(arrayList, batchingListUpdateCallback, i4, i2 - i5, i5);
                }
                for (int i6 = i3 - 1; i6 >= 0; i6--) {
                    int[] iArr = this.mOldItemStatuses;
                    int i7 = snake.x;
                    if ((iArr[i7 + i6] & 31) == 2) {
                        batchingListUpdateCallback.onChanged(i7 + i6, 1, this.mCallback.getChangePayload(i7 + i6, snake.y + i6));
                    }
                }
                i = snake.x;
                i2 = snake.y;
            }
            batchingListUpdateCallback.dispatchLastEvent();
        }

        public void dispatchUpdatesTo(@NonNull RecyclerView.Adapter adapter) {
            dispatchUpdatesTo(new AdapterListUpdateCallback(adapter));
        }
    }

    /* loaded from: classes.dex */
    public static class PostponedUpdate {
        public int currentPos;
        public int posInOwnerList;
        public boolean removal;

        public PostponedUpdate(int i, int i2, boolean z) {
            this.posInOwnerList = i;
            this.currentPos = i2;
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

        public Range(int i, int i2, int i3, int i4) {
            this.oldListStart = i;
            this.oldListEnd = i2;
            this.newListStart = i3;
            this.newListEnd = i4;
        }
    }

    @NonNull
    public static DiffResult calculateDiff(@NonNull Callback callback) {
        return calculateDiff(callback, true);
    }

    @NonNull
    public static DiffResult calculateDiff(@NonNull Callback callback, boolean z) {
        Range range;
        int oldListSize = callback.getOldListSize();
        int newListSize = callback.getNewListSize();
        ArrayList arrayList = new ArrayList();
        ArrayList arrayList2 = new ArrayList();
        arrayList2.add(new Range(0, oldListSize, 0, newListSize));
        int abs = oldListSize + newListSize + Math.abs(oldListSize - newListSize);
        int i = abs * 2;
        int[] iArr = new int[i];
        int[] iArr2 = new int[i];
        ArrayList arrayList3 = new ArrayList();
        while (!arrayList2.isEmpty()) {
            Range range2 = (Range) arrayList2.remove(arrayList2.size() - 1);
            Snake diffPartial = diffPartial(callback, range2.oldListStart, range2.oldListEnd, range2.newListStart, range2.newListEnd, iArr, iArr2, abs);
            if (diffPartial != null) {
                if (diffPartial.size > 0) {
                    arrayList.add(diffPartial);
                }
                diffPartial.x += range2.oldListStart;
                diffPartial.y += range2.newListStart;
                if (arrayList3.isEmpty()) {
                    range = new Range();
                } else {
                    range = (Range) arrayList3.remove(arrayList3.size() - 1);
                }
                range.oldListStart = range2.oldListStart;
                range.newListStart = range2.newListStart;
                if (diffPartial.reverse) {
                    range.oldListEnd = diffPartial.x;
                    range.newListEnd = diffPartial.y;
                } else if (diffPartial.removal) {
                    range.oldListEnd = diffPartial.x - 1;
                    range.newListEnd = diffPartial.y;
                } else {
                    range.oldListEnd = diffPartial.x;
                    range.newListEnd = diffPartial.y - 1;
                }
                arrayList2.add(range);
                if (diffPartial.reverse) {
                    if (diffPartial.removal) {
                        int i2 = diffPartial.x;
                        int i3 = diffPartial.size;
                        range2.oldListStart = i2 + i3 + 1;
                        range2.newListStart = diffPartial.y + i3;
                    } else {
                        int i4 = diffPartial.x;
                        int i5 = diffPartial.size;
                        range2.oldListStart = i4 + i5;
                        range2.newListStart = diffPartial.y + i5 + 1;
                    }
                } else {
                    int i6 = diffPartial.x;
                    int i7 = diffPartial.size;
                    range2.oldListStart = i6 + i7;
                    range2.newListStart = diffPartial.y + i7;
                }
                arrayList2.add(range2);
            } else {
                arrayList3.add(range2);
            }
        }
        Collections.sort(arrayList, SNAKE_COMPARATOR);
        return new DiffResult(callback, arrayList, iArr, iArr2, z);
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
    public static Snake diffPartial(Callback callback, int i, int i2, int i3, int i4, int[] iArr, int[] iArr2, int i5) {
        boolean z;
        int i6;
        int i7;
        boolean z2;
        int i8;
        int i9;
        int i10;
        boolean z3;
        int i11;
        int i12 = i2 - i;
        int i13 = i4 - i3;
        int i14 = 1;
        if (i12 >= 1 && i13 >= 1) {
            int i15 = i12 - i13;
            int i16 = ((i12 + i13) + 1) / 2;
            int i17 = (i5 - i16) - 1;
            int i18 = i5 + i16 + 1;
            Arrays.fill(iArr, i17, i18, 0);
            Arrays.fill(iArr2, i17 + i15, i18 + i15, i12);
            if (i15 % 2 != 0) {
                z = true;
            } else {
                z = false;
            }
            int i19 = 0;
            while (i19 <= i16) {
                int i20 = -i19;
                int i21 = i20;
                while (i21 <= i19) {
                    if (i21 != i20) {
                        if (i21 != i19) {
                            int i22 = i5 + i21;
                        }
                        i10 = iArr[(i5 + i21) - i14] + i14;
                        z3 = true;
                        for (i11 = i10 - i21; i10 < i12 && i11 < i13 && callback.areItemsTheSame(i + i10, i3 + i11); i11++) {
                            i10++;
                        }
                        int i23 = i5 + i21;
                        iArr[i23] = i10;
                        if (!z && i21 >= (i15 - i19) + 1 && i21 <= (i15 + i19) - 1 && iArr[i23] >= iArr2[i23]) {
                            Snake snake = new Snake();
                            int i24 = iArr2[i23];
                            snake.x = i24;
                            snake.y = i24 - i21;
                            snake.size = iArr[i23] - iArr2[i23];
                            snake.removal = z3;
                            snake.reverse = false;
                            return snake;
                        }
                        i21 += 2;
                        i14 = 1;
                    }
                    i10 = iArr[i5 + i21 + i14];
                    z3 = false;
                    while (i10 < i12) {
                        i10++;
                    }
                    int i232 = i5 + i21;
                    iArr[i232] = i10;
                    if (!z) {
                    }
                    i21 += 2;
                    i14 = 1;
                }
                int i25 = i20;
                while (i25 <= i19) {
                    int i26 = i25 + i15;
                    if (i26 != i19 + i15) {
                        if (i26 != i20 + i15) {
                            int i27 = i5 + i26;
                            i6 = 1;
                        } else {
                            i6 = 1;
                        }
                        i7 = iArr2[(i5 + i26) + i6] - i6;
                        z2 = true;
                        i8 = i7 - i26;
                        while (i7 > 0 && i8 > 0) {
                            i9 = i12;
                            if (callback.areItemsTheSame((i + i7) - 1, (i3 + i8) - 1)) {
                                break;
                            }
                            i7--;
                            i8--;
                            i12 = i9;
                        }
                        i9 = i12;
                        int i28 = i5 + i26;
                        iArr2[i28] = i7;
                        if (z && i26 >= i20 && i26 <= i19 && iArr[i28] >= iArr2[i28]) {
                            Snake snake2 = new Snake();
                            int i29 = iArr2[i28];
                            snake2.x = i29;
                            snake2.y = i29 - i26;
                            snake2.size = iArr[i28] - iArr2[i28];
                            snake2.removal = z2;
                            snake2.reverse = true;
                            return snake2;
                        }
                        i25 += 2;
                        i12 = i9;
                    } else {
                        i6 = 1;
                    }
                    i7 = iArr2[(i5 + i26) - i6];
                    z2 = false;
                    i8 = i7 - i26;
                    while (i7 > 0) {
                        i9 = i12;
                        if (callback.areItemsTheSame((i + i7) - 1, (i3 + i8) - 1)) {
                        }
                    }
                    i9 = i12;
                    int i282 = i5 + i26;
                    iArr2[i282] = i7;
                    if (z) {
                    }
                    i25 += 2;
                    i12 = i9;
                }
                i19++;
                i12 = i12;
                i14 = 1;
            }
            throw new IllegalStateException("DiffUtil hit an unexpected case while trying to calculate the optimal path. Please make sure your data is not changing during the diff calculation.");
        }
        return null;
    }
}
