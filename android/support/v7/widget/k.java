package android.support.v7.widget;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;
import java.util.ArrayList;
import java.util.List;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes2.dex */
public class k {
    final b NN;
    final a NP = new a();
    final List<View> NQ = new ArrayList();

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
        this.NN = bVar;
    }

    private void X(View view) {
        this.NQ.add(view);
        this.NN.ad(view);
    }

    private boolean Y(View view) {
        if (this.NQ.remove(view)) {
            this.NN.ae(view);
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
            bh = this.NN.getChildCount();
        } else {
            bh = bh(i);
        }
        this.NP.m(bh, z);
        if (z) {
            X(view);
        }
        this.NN.addView(view, bh);
    }

    private int bh(int i) {
        if (i < 0) {
            return -1;
        }
        int childCount = this.NN.getChildCount();
        int i2 = i;
        while (i2 < childCount) {
            int bk = i - (i2 - this.NP.bk(i2));
            if (bk == 0) {
                while (this.NP.get(i2)) {
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
        int indexOfChild = this.NN.indexOfChild(view);
        if (indexOfChild >= 0) {
            if (this.NP.bj(indexOfChild)) {
                Y(view);
            }
            this.NN.removeViewAt(indexOfChild);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void removeViewAt(int i) {
        int bh = bh(i);
        View childAt = this.NN.getChildAt(bh);
        if (childAt != null) {
            if (this.NP.bj(bh)) {
                Y(childAt);
            }
            this.NN.removeViewAt(bh);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public View getChildAt(int i) {
        return this.NN.getChildAt(bh(i));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void fS() {
        this.NP.reset();
        for (int size = this.NQ.size() - 1; size >= 0; size--) {
            this.NN.ae(this.NQ.get(size));
            this.NQ.remove(size);
        }
        this.NN.removeAllViews();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public View F(int i, int i2) {
        int size = this.NQ.size();
        for (int i3 = 0; i3 < size; i3++) {
            View view = this.NQ.get(i3);
            RecyclerView.ViewHolder childViewHolder = this.NN.getChildViewHolder(view);
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
            bh = this.NN.getChildCount();
        } else {
            bh = bh(i);
        }
        this.NP.m(bh, z);
        if (z) {
            X(view);
        }
        this.NN.attachViewToParent(view, bh, layoutParams);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public int getChildCount() {
        return this.NN.getChildCount() - this.NQ.size();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public int fT() {
        return this.NN.getChildCount();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public View bi(int i) {
        return this.NN.getChildAt(i);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void detachViewFromParent(int i) {
        int bh = bh(i);
        this.NP.bj(bh);
        this.NN.detachViewFromParent(bh);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public int indexOfChild(View view) {
        int indexOfChild = this.NN.indexOfChild(view);
        if (indexOfChild == -1 || this.NP.get(indexOfChild)) {
            return -1;
        }
        return indexOfChild - this.NP.bk(indexOfChild);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean Z(View view) {
        return this.NQ.contains(view);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void aa(View view) {
        int indexOfChild = this.NN.indexOfChild(view);
        if (indexOfChild < 0) {
            throw new IllegalArgumentException("view is not a child, cannot hide " + view);
        }
        this.NP.set(indexOfChild);
        X(view);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void ab(View view) {
        int indexOfChild = this.NN.indexOfChild(view);
        if (indexOfChild < 0) {
            throw new IllegalArgumentException("view is not a child, cannot hide " + view);
        }
        if (!this.NP.get(indexOfChild)) {
            throw new RuntimeException("trying to unhide a view that was not hidden" + view);
        }
        this.NP.clear(indexOfChild);
        Y(view);
    }

    public String toString() {
        return this.NP.toString() + ", hidden list:" + this.NQ.size();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean ac(View view) {
        int indexOfChild = this.NN.indexOfChild(view);
        if (indexOfChild == -1) {
            if (Y(view)) {
            }
            return true;
        } else if (this.NP.get(indexOfChild)) {
            this.NP.bj(indexOfChild);
            if (!Y(view)) {
            }
            this.NN.removeViewAt(indexOfChild);
            return true;
        } else {
            return false;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes2.dex */
    public static class a {
        long NR = 0;
        a NT;

        a() {
        }

        void set(int i) {
            if (i >= 64) {
                fU();
                this.NT.set(i - 64);
                return;
            }
            this.NR |= 1 << i;
        }

        private void fU() {
            if (this.NT == null) {
                this.NT = new a();
            }
        }

        void clear(int i) {
            if (i >= 64) {
                if (this.NT != null) {
                    this.NT.clear(i - 64);
                    return;
                }
                return;
            }
            this.NR &= (1 << i) ^ (-1);
        }

        boolean get(int i) {
            if (i < 64) {
                return (this.NR & (1 << i)) != 0;
            }
            fU();
            return this.NT.get(i - 64);
        }

        void reset() {
            this.NR = 0L;
            if (this.NT != null) {
                this.NT.reset();
            }
        }

        void m(int i, boolean z) {
            if (i >= 64) {
                fU();
                this.NT.m(i - 64, z);
                return;
            }
            boolean z2 = (this.NR & Long.MIN_VALUE) != 0;
            long j = (1 << i) - 1;
            this.NR = (((j ^ (-1)) & this.NR) << 1) | (this.NR & j);
            if (z) {
                set(i);
            } else {
                clear(i);
            }
            if (z2 || this.NT != null) {
                fU();
                this.NT.m(0, z2);
            }
        }

        boolean bj(int i) {
            if (i >= 64) {
                fU();
                return this.NT.bj(i - 64);
            }
            long j = 1 << i;
            boolean z = (this.NR & j) != 0;
            this.NR &= j ^ (-1);
            long j2 = j - 1;
            this.NR = Long.rotateRight((j2 ^ (-1)) & this.NR, 1) | (this.NR & j2);
            if (this.NT != null) {
                if (this.NT.get(0)) {
                    set(63);
                }
                this.NT.bj(0);
                return z;
            }
            return z;
        }

        int bk(int i) {
            if (this.NT == null) {
                if (i >= 64) {
                    return Long.bitCount(this.NR);
                }
                return Long.bitCount(this.NR & ((1 << i) - 1));
            } else if (i < 64) {
                return Long.bitCount(this.NR & ((1 << i) - 1));
            } else {
                return this.NT.bk(i - 64) + Long.bitCount(this.NR);
            }
        }

        public String toString() {
            return this.NT == null ? Long.toBinaryString(this.NR) : this.NT.toString() + "xx" + Long.toBinaryString(this.NR);
        }
    }
}
