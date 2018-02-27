package android.support.v7.widget;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;
import java.util.ArrayList;
import java.util.List;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes2.dex */
public class k {
    final b NI;
    final a NJ = new a();
    final List<View> NK = new ArrayList();

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
        this.NI = bVar;
    }

    private void X(View view) {
        this.NK.add(view);
        this.NI.ad(view);
    }

    private boolean Y(View view) {
        if (this.NK.remove(view)) {
            this.NI.ae(view);
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
            bh = this.NI.getChildCount();
        } else {
            bh = bh(i);
        }
        this.NJ.m(bh, z);
        if (z) {
            X(view);
        }
        this.NI.addView(view, bh);
    }

    private int bh(int i) {
        if (i < 0) {
            return -1;
        }
        int childCount = this.NI.getChildCount();
        int i2 = i;
        while (i2 < childCount) {
            int bk = i - (i2 - this.NJ.bk(i2));
            if (bk == 0) {
                while (this.NJ.get(i2)) {
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
        int indexOfChild = this.NI.indexOfChild(view);
        if (indexOfChild >= 0) {
            if (this.NJ.bj(indexOfChild)) {
                Y(view);
            }
            this.NI.removeViewAt(indexOfChild);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void removeViewAt(int i) {
        int bh = bh(i);
        View childAt = this.NI.getChildAt(bh);
        if (childAt != null) {
            if (this.NJ.bj(bh)) {
                Y(childAt);
            }
            this.NI.removeViewAt(bh);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public View getChildAt(int i) {
        return this.NI.getChildAt(bh(i));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void fS() {
        this.NJ.reset();
        for (int size = this.NK.size() - 1; size >= 0; size--) {
            this.NI.ae(this.NK.get(size));
            this.NK.remove(size);
        }
        this.NI.removeAllViews();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public View F(int i, int i2) {
        int size = this.NK.size();
        for (int i3 = 0; i3 < size; i3++) {
            View view = this.NK.get(i3);
            RecyclerView.ViewHolder childViewHolder = this.NI.getChildViewHolder(view);
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
            bh = this.NI.getChildCount();
        } else {
            bh = bh(i);
        }
        this.NJ.m(bh, z);
        if (z) {
            X(view);
        }
        this.NI.attachViewToParent(view, bh, layoutParams);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public int getChildCount() {
        return this.NI.getChildCount() - this.NK.size();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public int fT() {
        return this.NI.getChildCount();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public View bi(int i) {
        return this.NI.getChildAt(i);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void detachViewFromParent(int i) {
        int bh = bh(i);
        this.NJ.bj(bh);
        this.NI.detachViewFromParent(bh);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public int indexOfChild(View view) {
        int indexOfChild = this.NI.indexOfChild(view);
        if (indexOfChild == -1 || this.NJ.get(indexOfChild)) {
            return -1;
        }
        return indexOfChild - this.NJ.bk(indexOfChild);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean Z(View view) {
        return this.NK.contains(view);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void aa(View view) {
        int indexOfChild = this.NI.indexOfChild(view);
        if (indexOfChild < 0) {
            throw new IllegalArgumentException("view is not a child, cannot hide " + view);
        }
        this.NJ.set(indexOfChild);
        X(view);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void ab(View view) {
        int indexOfChild = this.NI.indexOfChild(view);
        if (indexOfChild < 0) {
            throw new IllegalArgumentException("view is not a child, cannot hide " + view);
        }
        if (!this.NJ.get(indexOfChild)) {
            throw new RuntimeException("trying to unhide a view that was not hidden" + view);
        }
        this.NJ.clear(indexOfChild);
        Y(view);
    }

    public String toString() {
        return this.NJ.toString() + ", hidden list:" + this.NK.size();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean ac(View view) {
        int indexOfChild = this.NI.indexOfChild(view);
        if (indexOfChild == -1) {
            if (Y(view)) {
            }
            return true;
        } else if (this.NJ.get(indexOfChild)) {
            this.NJ.bj(indexOfChild);
            if (!Y(view)) {
            }
            this.NI.removeViewAt(indexOfChild);
            return true;
        } else {
            return false;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes2.dex */
    public static class a {
        long NL = 0;
        a NM;

        a() {
        }

        void set(int i) {
            if (i >= 64) {
                fU();
                this.NM.set(i - 64);
                return;
            }
            this.NL |= 1 << i;
        }

        private void fU() {
            if (this.NM == null) {
                this.NM = new a();
            }
        }

        void clear(int i) {
            if (i >= 64) {
                if (this.NM != null) {
                    this.NM.clear(i - 64);
                    return;
                }
                return;
            }
            this.NL &= (1 << i) ^ (-1);
        }

        boolean get(int i) {
            if (i < 64) {
                return (this.NL & (1 << i)) != 0;
            }
            fU();
            return this.NM.get(i - 64);
        }

        void reset() {
            this.NL = 0L;
            if (this.NM != null) {
                this.NM.reset();
            }
        }

        void m(int i, boolean z) {
            if (i >= 64) {
                fU();
                this.NM.m(i - 64, z);
                return;
            }
            boolean z2 = (this.NL & Long.MIN_VALUE) != 0;
            long j = (1 << i) - 1;
            this.NL = (((j ^ (-1)) & this.NL) << 1) | (this.NL & j);
            if (z) {
                set(i);
            } else {
                clear(i);
            }
            if (z2 || this.NM != null) {
                fU();
                this.NM.m(0, z2);
            }
        }

        boolean bj(int i) {
            if (i >= 64) {
                fU();
                return this.NM.bj(i - 64);
            }
            long j = 1 << i;
            boolean z = (this.NL & j) != 0;
            this.NL &= j ^ (-1);
            long j2 = j - 1;
            this.NL = Long.rotateRight((j2 ^ (-1)) & this.NL, 1) | (this.NL & j2);
            if (this.NM != null) {
                if (this.NM.get(0)) {
                    set(63);
                }
                this.NM.bj(0);
                return z;
            }
            return z;
        }

        int bk(int i) {
            if (this.NM == null) {
                if (i >= 64) {
                    return Long.bitCount(this.NL);
                }
                return Long.bitCount(this.NL & ((1 << i) - 1));
            } else if (i < 64) {
                return Long.bitCount(this.NL & ((1 << i) - 1));
            } else {
                return this.NM.bk(i - 64) + Long.bitCount(this.NL);
            }
        }

        public String toString() {
            return this.NM == null ? Long.toBinaryString(this.NL) : this.NM.toString() + "xx" + Long.toBinaryString(this.NL);
        }
    }
}
