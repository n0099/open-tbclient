package android.support.v7.widget;

import android.support.v4.util.ArrayMap;
import android.support.v4.util.LongSparseArray;
import android.support.v4.util.Pools;
import android.support.v7.widget.RecyclerView;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes2.dex */
public class v {
    final ArrayMap<RecyclerView.ViewHolder, a> Yn = new ArrayMap<>();
    final LongSparseArray<RecyclerView.ViewHolder> Yo = new LongSparseArray<>();

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes2.dex */
    public interface b {
        void c(RecyclerView.ViewHolder viewHolder, RecyclerView.ItemAnimator.ItemHolderInfo itemHolderInfo, RecyclerView.ItemAnimator.ItemHolderInfo itemHolderInfo2);

        void d(RecyclerView.ViewHolder viewHolder, RecyclerView.ItemAnimator.ItemHolderInfo itemHolderInfo, RecyclerView.ItemAnimator.ItemHolderInfo itemHolderInfo2);

        void e(RecyclerView.ViewHolder viewHolder, RecyclerView.ItemAnimator.ItemHolderInfo itemHolderInfo, RecyclerView.ItemAnimator.ItemHolderInfo itemHolderInfo2);

        void g(RecyclerView.ViewHolder viewHolder);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void clear() {
        this.Yn.clear();
        this.Yo.clear();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void b(RecyclerView.ViewHolder viewHolder, RecyclerView.ItemAnimator.ItemHolderInfo itemHolderInfo) {
        a aVar = this.Yn.get(viewHolder);
        if (aVar == null) {
            aVar = a.iD();
            this.Yn.put(viewHolder, aVar);
        }
        aVar.Yp = itemHolderInfo;
        aVar.flags |= 4;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean o(RecyclerView.ViewHolder viewHolder) {
        a aVar = this.Yn.get(viewHolder);
        return (aVar == null || (aVar.flags & 1) == 0) ? false : true;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public RecyclerView.ItemAnimator.ItemHolderInfo p(RecyclerView.ViewHolder viewHolder) {
        return b(viewHolder, 4);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public RecyclerView.ItemAnimator.ItemHolderInfo q(RecyclerView.ViewHolder viewHolder) {
        return b(viewHolder, 8);
    }

    private RecyclerView.ItemAnimator.ItemHolderInfo b(RecyclerView.ViewHolder viewHolder, int i) {
        a valueAt;
        RecyclerView.ItemAnimator.ItemHolderInfo itemHolderInfo = null;
        int indexOfKey = this.Yn.indexOfKey(viewHolder);
        if (indexOfKey >= 0 && (valueAt = this.Yn.valueAt(indexOfKey)) != null && (valueAt.flags & i) != 0) {
            valueAt.flags &= i ^ (-1);
            if (i == 4) {
                itemHolderInfo = valueAt.Yp;
            } else if (i == 8) {
                itemHolderInfo = valueAt.Yq;
            } else {
                throw new IllegalArgumentException("Must provide flag PRE or POST");
            }
            if ((valueAt.flags & 12) == 0) {
                this.Yn.removeAt(indexOfKey);
                a.a(valueAt);
            }
        }
        return itemHolderInfo;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void a(long j, RecyclerView.ViewHolder viewHolder) {
        this.Yo.put(j, viewHolder);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void c(RecyclerView.ViewHolder viewHolder, RecyclerView.ItemAnimator.ItemHolderInfo itemHolderInfo) {
        a aVar = this.Yn.get(viewHolder);
        if (aVar == null) {
            aVar = a.iD();
            this.Yn.put(viewHolder, aVar);
        }
        aVar.flags |= 2;
        aVar.Yp = itemHolderInfo;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean r(RecyclerView.ViewHolder viewHolder) {
        a aVar = this.Yn.get(viewHolder);
        return (aVar == null || (aVar.flags & 4) == 0) ? false : true;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public RecyclerView.ViewHolder n(long j) {
        return this.Yo.get(j);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void d(RecyclerView.ViewHolder viewHolder, RecyclerView.ItemAnimator.ItemHolderInfo itemHolderInfo) {
        a aVar = this.Yn.get(viewHolder);
        if (aVar == null) {
            aVar = a.iD();
            this.Yn.put(viewHolder, aVar);
        }
        aVar.Yq = itemHolderInfo;
        aVar.flags |= 8;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void s(RecyclerView.ViewHolder viewHolder) {
        a aVar = this.Yn.get(viewHolder);
        if (aVar == null) {
            aVar = a.iD();
            this.Yn.put(viewHolder, aVar);
        }
        aVar.flags |= 1;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void t(RecyclerView.ViewHolder viewHolder) {
        a aVar = this.Yn.get(viewHolder);
        if (aVar != null) {
            aVar.flags &= -2;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void a(b bVar) {
        for (int size = this.Yn.size() - 1; size >= 0; size--) {
            RecyclerView.ViewHolder keyAt = this.Yn.keyAt(size);
            a removeAt = this.Yn.removeAt(size);
            if ((removeAt.flags & 3) == 3) {
                bVar.g(keyAt);
            } else if ((removeAt.flags & 1) != 0) {
                if (removeAt.Yp == null) {
                    bVar.g(keyAt);
                } else {
                    bVar.c(keyAt, removeAt.Yp, removeAt.Yq);
                }
            } else if ((removeAt.flags & 14) == 14) {
                bVar.d(keyAt, removeAt.Yp, removeAt.Yq);
            } else if ((removeAt.flags & 12) == 12) {
                bVar.e(keyAt, removeAt.Yp, removeAt.Yq);
            } else if ((removeAt.flags & 4) != 0) {
                bVar.c(keyAt, removeAt.Yp, null);
            } else if ((removeAt.flags & 8) != 0) {
                bVar.d(keyAt, removeAt.Yp, removeAt.Yq);
            } else if ((removeAt.flags & 2) != 0) {
            }
            a.a(removeAt);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void u(RecyclerView.ViewHolder viewHolder) {
        int size = this.Yo.size() - 1;
        while (true) {
            if (size < 0) {
                break;
            } else if (viewHolder != this.Yo.valueAt(size)) {
                size--;
            } else {
                this.Yo.removeAt(size);
                break;
            }
        }
        a remove = this.Yn.remove(viewHolder);
        if (remove != null) {
            a.a(remove);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void onDetach() {
        a.iE();
    }

    public void v(RecyclerView.ViewHolder viewHolder) {
        t(viewHolder);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes2.dex */
    public static class a {
        static Pools.Pool<a> Yr = new Pools.SimplePool(20);
        RecyclerView.ItemAnimator.ItemHolderInfo Yp;
        RecyclerView.ItemAnimator.ItemHolderInfo Yq;
        int flags;

        private a() {
        }

        static a iD() {
            a acquire = Yr.acquire();
            return acquire == null ? new a() : acquire;
        }

        static void a(a aVar) {
            aVar.flags = 0;
            aVar.Yp = null;
            aVar.Yq = null;
            Yr.release(aVar);
        }

        static void iE() {
            do {
            } while (Yr.acquire() != null);
        }
    }
}
