package android.support.v7.widget;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;
import java.util.ArrayList;
import java.util.List;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes2.dex */
public class k {
    final b NP;
    final a NQ = new a();
    final List<View> NR = new ArrayList();

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes2.dex */
    public interface b {
        void ad(View view);

        void addView(View view, int i);

        void ae(View view);

        void attachViewToParent(View view, int i, ViewGroup.LayoutParams layoutParams);

        void detachViewFromParent(int i);

        View getChildAt(int i);

        int getChildCount();

        RecyclerView.ViewHolder getChildViewHolder(View view);

        int indexOfChild(View view);

        void removeAllViews();

        void removeViewAt(int i);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public k(b bVar) {
        this.NP = bVar;
    }

    private void X(View view) {
        this.NR.add(view);
        this.NP.ad(view);
    }

    private boolean Y(View view) {
        if (this.NR.remove(view)) {
            this.NP.ae(view);
            return true;
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void g(View view, boolean z) {
        b(view, -1, z);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void b(View view, int i, boolean z) {
        int bh;
        if (i < 0) {
            bh = this.NP.getChildCount();
        } else {
            bh = bh(i);
        }
        this.NQ.j(bh, z);
        if (z) {
            X(view);
        }
        this.NP.addView(view, bh);
    }

    private int bh(int i) {
        if (i < 0) {
            return -1;
        }
        int childCount = this.NP.getChildCount();
        int i2 = i;
        while (i2 < childCount) {
            int bk = i - (i2 - this.NQ.bk(i2));
            if (bk == 0) {
                while (this.NQ.get(i2)) {
                    i2++;
                }
                return i2;
            }
            i2 += bk;
        }
        return -1;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void removeView(View view) {
        int indexOfChild = this.NP.indexOfChild(view);
        if (indexOfChild >= 0) {
            if (this.NQ.bj(indexOfChild)) {
                Y(view);
            }
            this.NP.removeViewAt(indexOfChild);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void removeViewAt(int i) {
        int bh = bh(i);
        View childAt = this.NP.getChildAt(bh);
        if (childAt != null) {
            if (this.NQ.bj(bh)) {
                Y(childAt);
            }
            this.NP.removeViewAt(bh);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public View getChildAt(int i) {
        return this.NP.getChildAt(bh(i));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void fS() {
        this.NQ.reset();
        for (int size = this.NR.size() - 1; size >= 0; size--) {
            this.NP.ae(this.NR.get(size));
            this.NR.remove(size);
        }
        this.NP.removeAllViews();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public View F(int i, int i2) {
        int size = this.NR.size();
        for (int i3 = 0; i3 < size; i3++) {
            View view = this.NR.get(i3);
            RecyclerView.ViewHolder childViewHolder = this.NP.getChildViewHolder(view);
            if (childViewHolder.getLayoutPosition() == i && !childViewHolder.isInvalid() && !childViewHolder.isRemoved() && (i2 == -1 || childViewHolder.getItemViewType() == i2)) {
                return view;
            }
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void a(View view, int i, ViewGroup.LayoutParams layoutParams, boolean z) {
        int bh;
        if (i < 0) {
            bh = this.NP.getChildCount();
        } else {
            bh = bh(i);
        }
        this.NQ.j(bh, z);
        if (z) {
            X(view);
        }
        this.NP.attachViewToParent(view, bh, layoutParams);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public int getChildCount() {
        return this.NP.getChildCount() - this.NR.size();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public int fT() {
        return this.NP.getChildCount();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public View bi(int i) {
        return this.NP.getChildAt(i);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void detachViewFromParent(int i) {
        int bh = bh(i);
        this.NQ.bj(bh);
        this.NP.detachViewFromParent(bh);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public int indexOfChild(View view) {
        int indexOfChild = this.NP.indexOfChild(view);
        if (indexOfChild == -1 || this.NQ.get(indexOfChild)) {
            return -1;
        }
        return indexOfChild - this.NQ.bk(indexOfChild);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean Z(View view) {
        return this.NR.contains(view);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void aa(View view) {
        int indexOfChild = this.NP.indexOfChild(view);
        if (indexOfChild < 0) {
            throw new IllegalArgumentException("view is not a child, cannot hide " + view);
        }
        this.NQ.set(indexOfChild);
        X(view);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void ab(View view) {
        int indexOfChild = this.NP.indexOfChild(view);
        if (indexOfChild < 0) {
            throw new IllegalArgumentException("view is not a child, cannot hide " + view);
        }
        if (!this.NQ.get(indexOfChild)) {
            throw new RuntimeException("trying to unhide a view that was not hidden" + view);
        }
        this.NQ.clear(indexOfChild);
        Y(view);
    }

    public String toString() {
        return this.NQ.toString() + ", hidden list:" + this.NR.size();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean ac(View view) {
        int indexOfChild = this.NP.indexOfChild(view);
        if (indexOfChild == -1) {
            if (Y(view)) {
            }
            return true;
        } else if (this.NQ.get(indexOfChild)) {
            this.NQ.bj(indexOfChild);
            if (!Y(view)) {
            }
            this.NP.removeViewAt(indexOfChild);
            return true;
        } else {
            return false;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes2.dex */
    public static class a {
        long NT = 0;
        a NU;

        a() {
        }

        void set(int i) {
            if (i >= 64) {
                fU();
                this.NU.set(i - 64);
                return;
            }
            this.NT |= 1 << i;
        }

        private void fU() {
            if (this.NU == null) {
                this.NU = new a();
            }
        }

        void clear(int i) {
            if (i >= 64) {
                if (this.NU != null) {
                    this.NU.clear(i - 64);
                    return;
                }
                return;
            }
            this.NT &= (1 << i) ^ (-1);
        }

        boolean get(int i) {
            if (i < 64) {
                return (this.NT & (1 << i)) != 0;
            }
            fU();
            return this.NU.get(i - 64);
        }

        void reset() {
            this.NT = 0L;
            if (this.NU != null) {
                this.NU.reset();
            }
        }

        void j(int i, boolean z) {
            if (i >= 64) {
                fU();
                this.NU.j(i - 64, z);
                return;
            }
            boolean z2 = (this.NT & Long.MIN_VALUE) != 0;
            long j = (1 << i) - 1;
            this.NT = (((j ^ (-1)) & this.NT) << 1) | (this.NT & j);
            if (z) {
                set(i);
            } else {
                clear(i);
            }
            if (z2 || this.NU != null) {
                fU();
                this.NU.j(0, z2);
            }
        }

        boolean bj(int i) {
            if (i >= 64) {
                fU();
                return this.NU.bj(i - 64);
            }
            long j = 1 << i;
            boolean z = (this.NT & j) != 0;
            this.NT &= j ^ (-1);
            long j2 = j - 1;
            this.NT = Long.rotateRight((j2 ^ (-1)) & this.NT, 1) | (this.NT & j2);
            if (this.NU != null) {
                if (this.NU.get(0)) {
                    set(63);
                }
                this.NU.bj(0);
                return z;
            }
            return z;
        }

        int bk(int i) {
            if (this.NU == null) {
                if (i >= 64) {
                    return Long.bitCount(this.NT);
                }
                return Long.bitCount(this.NT & ((1 << i) - 1));
            } else if (i < 64) {
                return Long.bitCount(this.NT & ((1 << i) - 1));
            } else {
                return this.NU.bk(i - 64) + Long.bitCount(this.NT);
            }
        }

        public String toString() {
            return this.NU == null ? Long.toBinaryString(this.NT) : this.NU.toString() + "xx" + Long.toBinaryString(this.NT);
        }
    }
}
