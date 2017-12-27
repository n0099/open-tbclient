package android.support.v7.util;

import android.support.v7.widget.RecyclerView;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
/* loaded from: classes2.dex */
public class DiffUtil {
    private static final Comparator<c> FG = new Comparator<c>() { // from class: android.support.v7.util.DiffUtil.1
        /* JADX DEBUG: Method merged with bridge method */
        @Override // java.util.Comparator
        /* renamed from: a */
        public int compare(c cVar, c cVar2) {
            int i = cVar.x - cVar2.x;
            return i == 0 ? cVar.y - cVar2.y : i;
        }
    };

    private DiffUtil() {
    }

    public static DiffResult calculateDiff(Callback callback) {
        return calculateDiff(callback, true);
    }

    public static DiffResult calculateDiff(Callback callback, boolean z) {
        int oldListSize = callback.getOldListSize();
        int newListSize = callback.getNewListSize();
        ArrayList arrayList = new ArrayList();
        ArrayList arrayList2 = new ArrayList();
        arrayList2.add(new b(0, oldListSize, 0, newListSize));
        int abs = oldListSize + newListSize + Math.abs(oldListSize - newListSize);
        int[] iArr = new int[abs * 2];
        int[] iArr2 = new int[abs * 2];
        ArrayList arrayList3 = new ArrayList();
        while (!arrayList2.isEmpty()) {
            b bVar = (b) arrayList2.remove(arrayList2.size() - 1);
            c a2 = a(callback, bVar.FU, bVar.FV, bVar.FW, bVar.FX, iArr, iArr2, abs);
            if (a2 != null) {
                if (a2.size > 0) {
                    arrayList.add(a2);
                }
                a2.x += bVar.FU;
                a2.y += bVar.FW;
                b bVar2 = arrayList3.isEmpty() ? new b() : (b) arrayList3.remove(arrayList3.size() - 1);
                bVar2.FU = bVar.FU;
                bVar2.FW = bVar.FW;
                if (a2.FY) {
                    bVar2.FV = a2.x;
                    bVar2.FX = a2.y;
                } else if (a2.FT) {
                    bVar2.FV = a2.x - 1;
                    bVar2.FX = a2.y;
                } else {
                    bVar2.FV = a2.x;
                    bVar2.FX = a2.y - 1;
                }
                arrayList2.add(bVar2);
                if (a2.FY) {
                    if (a2.FT) {
                        bVar.FU = a2.x + a2.size + 1;
                        bVar.FW = a2.y + a2.size;
                    } else {
                        bVar.FU = a2.x + a2.size;
                        bVar.FW = a2.y + a2.size + 1;
                    }
                } else {
                    bVar.FU = a2.x + a2.size;
                    bVar.FW = a2.y + a2.size;
                }
                arrayList2.add(bVar);
            } else {
                arrayList3.add(bVar);
            }
        }
        Collections.sort(arrayList, FG);
        return new DiffResult(callback, arrayList, iArr, iArr2, z);
    }

    private static c a(Callback callback, int i, int i2, int i3, int i4, int[] iArr, int[] iArr2, int i5) {
        int i6;
        boolean z;
        int i7;
        boolean z2;
        int i8 = i2 - i;
        int i9 = i4 - i3;
        if (i2 - i < 1 || i4 - i3 < 1) {
            return null;
        }
        int i10 = i8 - i9;
        int i11 = ((i8 + i9) + 1) / 2;
        Arrays.fill(iArr, (i5 - i11) - 1, i5 + i11 + 1, 0);
        Arrays.fill(iArr2, ((i5 - i11) - 1) + i10, i5 + i11 + 1 + i10, i8);
        boolean z3 = i10 % 2 != 0;
        for (int i12 = 0; i12 <= i11; i12++) {
            for (int i13 = -i12; i13 <= i12; i13 += 2) {
                if (i13 == (-i12) || (i13 != i12 && iArr[(i5 + i13) - 1] < iArr[i5 + i13 + 1])) {
                    i7 = iArr[i5 + i13 + 1];
                    z2 = false;
                } else {
                    i7 = iArr[(i5 + i13) - 1] + 1;
                    z2 = true;
                }
                int i14 = i7;
                for (int i15 = i7 - i13; i14 < i8 && i15 < i9 && callback.areItemsTheSame(i + i14, i3 + i15); i15++) {
                    i14++;
                }
                iArr[i5 + i13] = i14;
                if (z3 && i13 >= (i10 - i12) + 1 && i13 <= (i10 + i12) - 1 && iArr[i5 + i13] >= iArr2[i5 + i13]) {
                    c cVar = new c();
                    cVar.x = iArr2[i5 + i13];
                    cVar.y = cVar.x - i13;
                    cVar.size = iArr[i5 + i13] - iArr2[i5 + i13];
                    cVar.FT = z2;
                    cVar.FY = false;
                    return cVar;
                }
            }
            for (int i16 = -i12; i16 <= i12; i16 += 2) {
                int i17 = i16 + i10;
                if (i17 == i12 + i10 || (i17 != (-i12) + i10 && iArr2[(i5 + i17) - 1] < iArr2[i5 + i17 + 1])) {
                    i6 = iArr2[(i5 + i17) - 1];
                    z = false;
                } else {
                    i6 = iArr2[(i5 + i17) + 1] - 1;
                    z = true;
                }
                int i18 = i6;
                for (int i19 = i6 - i17; i18 > 0 && i19 > 0 && callback.areItemsTheSame((i + i18) - 1, (i3 + i19) - 1); i19--) {
                    i18--;
                }
                iArr2[i5 + i17] = i18;
                if (!z3 && i16 + i10 >= (-i12) && i16 + i10 <= i12 && iArr[i5 + i17] >= iArr2[i5 + i17]) {
                    c cVar2 = new c();
                    cVar2.x = iArr2[i5 + i17];
                    cVar2.y = cVar2.x - i17;
                    cVar2.size = iArr[i5 + i17] - iArr2[i5 + i17];
                    cVar2.FT = z;
                    cVar2.FY = true;
                    return cVar2;
                }
            }
        }
        throw new IllegalStateException("DiffUtil hit an unexpected case while trying to calculate the optimal path. Please make sure your data is not changing during the diff calculation.");
    }

    /* loaded from: classes2.dex */
    public static abstract class Callback {
        public abstract boolean areContentsTheSame(int i, int i2);

        public abstract boolean areItemsTheSame(int i, int i2);

        public abstract int getNewListSize();

        public abstract int getOldListSize();

        public Object getChangePayload(int i, int i2) {
            return null;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes2.dex */
    public static class c {
        boolean FT;
        boolean FY;
        int size;
        int x;
        int y;

        c() {
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes2.dex */
    public static class b {
        int FU;
        int FV;
        int FW;
        int FX;

        public b() {
        }

        public b(int i, int i2, int i3, int i4) {
            this.FU = i;
            this.FV = i2;
            this.FW = i3;
            this.FX = i4;
        }
    }

    /* loaded from: classes2.dex */
    public static class DiffResult {
        private final List<c> FH;
        private final int[] FI;
        private final int[] FJ;
        private final Callback FK;
        private final int FL;
        private final int FM;
        private final boolean FN;

        DiffResult(Callback callback, List<c> list, int[] iArr, int[] iArr2, boolean z) {
            this.FH = list;
            this.FI = iArr;
            this.FJ = iArr2;
            Arrays.fill(this.FI, 0);
            Arrays.fill(this.FJ, 0);
            this.FK = callback;
            this.FL = callback.getOldListSize();
            this.FM = callback.getNewListSize();
            this.FN = z;
            eA();
            eB();
        }

        private void eA() {
            c cVar = this.FH.isEmpty() ? null : this.FH.get(0);
            if (cVar == null || cVar.x != 0 || cVar.y != 0) {
                c cVar2 = new c();
                cVar2.x = 0;
                cVar2.y = 0;
                cVar2.FT = false;
                cVar2.size = 0;
                cVar2.FY = false;
                this.FH.add(0, cVar2);
            }
        }

        private void eB() {
            int i = this.FL;
            int i2 = this.FM;
            for (int size = this.FH.size() - 1; size >= 0; size--) {
                c cVar = this.FH.get(size);
                int i3 = cVar.x + cVar.size;
                int i4 = cVar.y + cVar.size;
                if (this.FN) {
                    while (i > i3) {
                        d(i, i2, size);
                        i--;
                    }
                    while (i2 > i4) {
                        e(i, i2, size);
                        i2--;
                    }
                }
                for (int i5 = 0; i5 < cVar.size; i5++) {
                    int i6 = cVar.x + i5;
                    int i7 = cVar.y + i5;
                    int i8 = this.FK.areContentsTheSame(i6, i7) ? 1 : 2;
                    this.FI[i6] = (i7 << 5) | i8;
                    this.FJ[i7] = i8 | (i6 << 5);
                }
                i = cVar.x;
                i2 = cVar.y;
            }
        }

        private void d(int i, int i2, int i3) {
            if (this.FI[i - 1] == 0) {
                b(i, i2, i3, false);
            }
        }

        private void e(int i, int i2, int i3) {
            if (this.FJ[i2 - 1] == 0) {
                b(i, i2, i3, true);
            }
        }

        private boolean b(int i, int i2, int i3, boolean z) {
            int i4;
            int i5;
            if (z) {
                int i6 = i2 - 1;
                i2--;
                i4 = i6;
                i5 = i;
            } else {
                i4 = i - 1;
                i5 = i - 1;
            }
            int i7 = i5;
            while (i3 >= 0) {
                c cVar = this.FH.get(i3);
                int i8 = cVar.x + cVar.size;
                int i9 = cVar.y + cVar.size;
                if (z) {
                    for (int i10 = i7 - 1; i10 >= i8; i10--) {
                        if (this.FK.areItemsTheSame(i10, i4)) {
                            int i11 = this.FK.areContentsTheSame(i10, i4) ? 8 : 4;
                            this.FJ[i4] = (i10 << 5) | 16;
                            this.FI[i10] = i11 | (i4 << 5);
                            return true;
                        }
                    }
                    continue;
                } else {
                    for (int i12 = i2 - 1; i12 >= i9; i12--) {
                        if (this.FK.areItemsTheSame(i4, i12)) {
                            int i13 = this.FK.areContentsTheSame(i4, i12) ? 8 : 4;
                            this.FI[i - 1] = (i12 << 5) | 16;
                            this.FJ[i12] = ((i - 1) << 5) | i13;
                            return true;
                        }
                    }
                    continue;
                }
                i7 = cVar.x;
                i2 = cVar.y;
                i3--;
            }
            return false;
        }

        public void dispatchUpdatesTo(final RecyclerView.Adapter adapter) {
            dispatchUpdatesTo(new ListUpdateCallback() { // from class: android.support.v7.util.DiffUtil.DiffResult.1
                @Override // android.support.v7.util.ListUpdateCallback
                public void onInserted(int i, int i2) {
                    adapter.notifyItemRangeInserted(i, i2);
                }

                @Override // android.support.v7.util.ListUpdateCallback
                public void onRemoved(int i, int i2) {
                    adapter.notifyItemRangeRemoved(i, i2);
                }

                @Override // android.support.v7.util.ListUpdateCallback
                public void onMoved(int i, int i2) {
                    adapter.notifyItemMoved(i, i2);
                }

                @Override // android.support.v7.util.ListUpdateCallback
                public void onChanged(int i, int i2, Object obj) {
                    adapter.notifyItemRangeChanged(i, i2, obj);
                }
            });
        }

        public void dispatchUpdatesTo(ListUpdateCallback listUpdateCallback) {
            BatchingListUpdateCallback batchingListUpdateCallback;
            if (listUpdateCallback instanceof BatchingListUpdateCallback) {
                batchingListUpdateCallback = (BatchingListUpdateCallback) listUpdateCallback;
            } else {
                batchingListUpdateCallback = new BatchingListUpdateCallback(listUpdateCallback);
            }
            List<a> arrayList = new ArrayList<>();
            int i = this.FL;
            int i2 = this.FM;
            int size = this.FH.size() - 1;
            int i3 = i2;
            while (size >= 0) {
                c cVar = this.FH.get(size);
                int i4 = cVar.size;
                int i5 = cVar.x + i4;
                int i6 = cVar.y + i4;
                if (i5 < i) {
                    b(arrayList, batchingListUpdateCallback, i5, i - i5, i5);
                }
                if (i6 < i3) {
                    a(arrayList, batchingListUpdateCallback, i5, i3 - i6, i6);
                }
                for (int i7 = i4 - 1; i7 >= 0; i7--) {
                    if ((this.FI[cVar.x + i7] & 31) == 2) {
                        batchingListUpdateCallback.onChanged(cVar.x + i7, 1, this.FK.getChangePayload(cVar.x + i7, cVar.y + i7));
                    }
                }
                i = cVar.x;
                size--;
                i3 = cVar.y;
            }
            batchingListUpdateCallback.dispatchLastEvent();
        }

        private static a a(List<a> list, int i, boolean z) {
            int size = list.size() - 1;
            while (size >= 0) {
                a aVar = list.get(size);
                if (aVar.FQ != i || aVar.FT != z) {
                    size--;
                } else {
                    list.remove(size);
                    while (true) {
                        int i2 = size;
                        if (i2 >= list.size()) {
                            return aVar;
                        }
                        a aVar2 = list.get(i2);
                        aVar2.FR = (z ? 1 : -1) + aVar2.FR;
                        size = i2 + 1;
                    }
                }
            }
            return null;
        }

        private void a(List<a> list, ListUpdateCallback listUpdateCallback, int i, int i2, int i3) {
            if (!this.FN) {
                listUpdateCallback.onInserted(i, i2);
                return;
            }
            for (int i4 = i2 - 1; i4 >= 0; i4--) {
                int i5 = this.FJ[i3 + i4] & 31;
                switch (i5) {
                    case 0:
                        listUpdateCallback.onInserted(i, 1);
                        for (a aVar : list) {
                            aVar.FR++;
                        }
                        break;
                    case 4:
                    case 8:
                        int i6 = this.FJ[i3 + i4] >> 5;
                        listUpdateCallback.onMoved(a(list, i6, true).FR, i);
                        if (i5 == 4) {
                            listUpdateCallback.onChanged(i, 1, this.FK.getChangePayload(i6, i3 + i4));
                            break;
                        } else {
                            break;
                        }
                    case 16:
                        list.add(new a(i3 + i4, i, false));
                        break;
                    default:
                        throw new IllegalStateException("unknown flag for pos " + (i4 + i3) + " " + Long.toBinaryString(i5));
                }
            }
        }

        private void b(List<a> list, ListUpdateCallback listUpdateCallback, int i, int i2, int i3) {
            if (!this.FN) {
                listUpdateCallback.onRemoved(i, i2);
                return;
            }
            for (int i4 = i2 - 1; i4 >= 0; i4--) {
                int i5 = this.FI[i3 + i4] & 31;
                switch (i5) {
                    case 0:
                        listUpdateCallback.onRemoved(i + i4, 1);
                        for (a aVar : list) {
                            aVar.FR--;
                        }
                        break;
                    case 4:
                    case 8:
                        int i6 = this.FI[i3 + i4] >> 5;
                        a a = a(list, i6, false);
                        listUpdateCallback.onMoved(i + i4, a.FR - 1);
                        if (i5 == 4) {
                            listUpdateCallback.onChanged(a.FR - 1, 1, this.FK.getChangePayload(i3 + i4, i6));
                            break;
                        } else {
                            break;
                        }
                    case 16:
                        list.add(new a(i3 + i4, i + i4, true));
                        break;
                    default:
                        throw new IllegalStateException("unknown flag for pos " + (i4 + i3) + " " + Long.toBinaryString(i5));
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes2.dex */
    public static class a {
        int FQ;
        int FR;
        boolean FT;

        public a(int i, int i2, boolean z) {
            this.FQ = i;
            this.FR = i2;
            this.FT = z;
        }
    }
}
