package androidx.recyclerview.widget;

import android.view.View;
import android.view.ViewGroup;
import androidx.recyclerview.widget.RecyclerView;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes.dex */
public class ChildHelper {
    public static final boolean DEBUG = false;
    public static final String TAG = "ChildrenHelper";
    public final Callback mCallback;
    public final Bucket mBucket = new Bucket();
    public final List<View> mHiddenViews = new ArrayList();

    /* loaded from: classes.dex */
    public interface Callback {
        void addView(View view2, int i);

        void attachViewToParent(View view2, int i, ViewGroup.LayoutParams layoutParams);

        void detachViewFromParent(int i);

        View getChildAt(int i);

        int getChildCount();

        RecyclerView.ViewHolder getChildViewHolder(View view2);

        int indexOfChild(View view2);

        void onEnteredHiddenState(View view2);

        void onLeftHiddenState(View view2);

        void removeAllViews();

        void removeViewAt(int i);
    }

    /* loaded from: classes.dex */
    public static class Bucket {
        public static final int BITS_PER_WORD = 64;
        public static final long LAST_BIT = Long.MIN_VALUE;
        public long mData = 0;
        public Bucket mNext;

        private void ensureNext() {
            if (this.mNext == null) {
                this.mNext = new Bucket();
            }
        }

        public void reset() {
            this.mData = 0L;
            Bucket bucket = this.mNext;
            if (bucket != null) {
                bucket.reset();
            }
        }

        public String toString() {
            if (this.mNext == null) {
                return Long.toBinaryString(this.mData);
            }
            return this.mNext.toString() + "xx" + Long.toBinaryString(this.mData);
        }

        public void clear(int i) {
            if (i >= 64) {
                Bucket bucket = this.mNext;
                if (bucket != null) {
                    bucket.clear(i - 64);
                    return;
                }
                return;
            }
            this.mData &= ~(1 << i);
        }

        public boolean get(int i) {
            if (i >= 64) {
                ensureNext();
                return this.mNext.get(i - 64);
            } else if ((this.mData & (1 << i)) != 0) {
                return true;
            } else {
                return false;
            }
        }

        public void set(int i) {
            if (i >= 64) {
                ensureNext();
                this.mNext.set(i - 64);
                return;
            }
            this.mData |= 1 << i;
        }

        public int countOnesBefore(int i) {
            Bucket bucket = this.mNext;
            if (bucket == null) {
                if (i >= 64) {
                    return Long.bitCount(this.mData);
                }
                return Long.bitCount(this.mData & ((1 << i) - 1));
            } else if (i < 64) {
                return Long.bitCount(this.mData & ((1 << i) - 1));
            } else {
                return bucket.countOnesBefore(i - 64) + Long.bitCount(this.mData);
            }
        }

        public void insert(int i, boolean z) {
            boolean z2;
            if (i >= 64) {
                ensureNext();
                this.mNext.insert(i - 64, z);
                return;
            }
            if ((this.mData & Long.MIN_VALUE) != 0) {
                z2 = true;
            } else {
                z2 = false;
            }
            long j = (1 << i) - 1;
            long j2 = this.mData;
            this.mData = ((j2 & (~j)) << 1) | (j2 & j);
            if (z) {
                set(i);
            } else {
                clear(i);
            }
            if (z2 || this.mNext != null) {
                ensureNext();
                this.mNext.insert(0, z2);
            }
        }

        public boolean remove(int i) {
            boolean z;
            if (i >= 64) {
                ensureNext();
                return this.mNext.remove(i - 64);
            }
            long j = 1 << i;
            if ((this.mData & j) != 0) {
                z = true;
            } else {
                z = false;
            }
            long j2 = this.mData & (~j);
            this.mData = j2;
            long j3 = j - 1;
            this.mData = (j2 & j3) | Long.rotateRight((~j3) & j2, 1);
            Bucket bucket = this.mNext;
            if (bucket != null) {
                if (bucket.get(0)) {
                    set(63);
                }
                this.mNext.remove(0);
            }
            return z;
        }
    }

    public ChildHelper(Callback callback) {
        this.mCallback = callback;
    }

    private int getOffset(int i) {
        if (i < 0) {
            return -1;
        }
        int childCount = this.mCallback.getChildCount();
        int i2 = i;
        while (i2 < childCount) {
            int countOnesBefore = i - (i2 - this.mBucket.countOnesBefore(i2));
            if (countOnesBefore == 0) {
                while (this.mBucket.get(i2)) {
                    i2++;
                }
                return i2;
            }
            i2 += countOnesBefore;
        }
        return -1;
    }

    private void hideViewInternal(View view2) {
        this.mHiddenViews.add(view2);
        this.mCallback.onEnteredHiddenState(view2);
    }

    private boolean unhideViewInternal(View view2) {
        if (this.mHiddenViews.remove(view2)) {
            this.mCallback.onLeftHiddenState(view2);
            return true;
        }
        return false;
    }

    public void detachViewFromParent(int i) {
        int offset = getOffset(i);
        this.mBucket.remove(offset);
        this.mCallback.detachViewFromParent(offset);
    }

    public View findHiddenNonRemovedView(int i) {
        int size = this.mHiddenViews.size();
        for (int i2 = 0; i2 < size; i2++) {
            View view2 = this.mHiddenViews.get(i2);
            RecyclerView.ViewHolder childViewHolder = this.mCallback.getChildViewHolder(view2);
            if (childViewHolder.getLayoutPosition() == i && !childViewHolder.isInvalid() && !childViewHolder.isRemoved()) {
                return view2;
            }
        }
        return null;
    }

    public View getChildAt(int i) {
        return this.mCallback.getChildAt(getOffset(i));
    }

    public View getUnfilteredChildAt(int i) {
        return this.mCallback.getChildAt(i);
    }

    public void hide(View view2) {
        int indexOfChild = this.mCallback.indexOfChild(view2);
        if (indexOfChild >= 0) {
            this.mBucket.set(indexOfChild);
            hideViewInternal(view2);
            return;
        }
        throw new IllegalArgumentException("view is not a child, cannot hide " + view2);
    }

    public int indexOfChild(View view2) {
        int indexOfChild = this.mCallback.indexOfChild(view2);
        if (indexOfChild == -1 || this.mBucket.get(indexOfChild)) {
            return -1;
        }
        return indexOfChild - this.mBucket.countOnesBefore(indexOfChild);
    }

    public boolean isHidden(View view2) {
        return this.mHiddenViews.contains(view2);
    }

    public void removeView(View view2) {
        int indexOfChild = this.mCallback.indexOfChild(view2);
        if (indexOfChild < 0) {
            return;
        }
        if (this.mBucket.remove(indexOfChild)) {
            unhideViewInternal(view2);
        }
        this.mCallback.removeViewAt(indexOfChild);
    }

    public void removeViewAt(int i) {
        int offset = getOffset(i);
        View childAt = this.mCallback.getChildAt(offset);
        if (childAt == null) {
            return;
        }
        if (this.mBucket.remove(offset)) {
            unhideViewInternal(childAt);
        }
        this.mCallback.removeViewAt(offset);
    }

    public boolean removeViewIfHidden(View view2) {
        int indexOfChild = this.mCallback.indexOfChild(view2);
        if (indexOfChild == -1) {
            unhideViewInternal(view2);
            return true;
        } else if (this.mBucket.get(indexOfChild)) {
            this.mBucket.remove(indexOfChild);
            unhideViewInternal(view2);
            this.mCallback.removeViewAt(indexOfChild);
            return true;
        } else {
            return false;
        }
    }

    public void addView(View view2, int i, boolean z) {
        int offset;
        if (i < 0) {
            offset = this.mCallback.getChildCount();
        } else {
            offset = getOffset(i);
        }
        this.mBucket.insert(offset, z);
        if (z) {
            hideViewInternal(view2);
        }
        this.mCallback.addView(view2, offset);
    }

    public void addView(View view2, boolean z) {
        addView(view2, -1, z);
    }

    public void attachViewToParent(View view2, int i, ViewGroup.LayoutParams layoutParams, boolean z) {
        int offset;
        if (i < 0) {
            offset = this.mCallback.getChildCount();
        } else {
            offset = getOffset(i);
        }
        this.mBucket.insert(offset, z);
        if (z) {
            hideViewInternal(view2);
        }
        this.mCallback.attachViewToParent(view2, offset, layoutParams);
    }

    public int getChildCount() {
        return this.mCallback.getChildCount() - this.mHiddenViews.size();
    }

    public int getUnfilteredChildCount() {
        return this.mCallback.getChildCount();
    }

    public void removeAllViewsUnfiltered() {
        this.mBucket.reset();
        for (int size = this.mHiddenViews.size() - 1; size >= 0; size--) {
            this.mCallback.onLeftHiddenState(this.mHiddenViews.get(size));
            this.mHiddenViews.remove(size);
        }
        this.mCallback.removeAllViews();
    }

    public String toString() {
        return this.mBucket.toString() + ", hidden list:" + this.mHiddenViews.size();
    }

    public void unhide(View view2) {
        int indexOfChild = this.mCallback.indexOfChild(view2);
        if (indexOfChild >= 0) {
            if (this.mBucket.get(indexOfChild)) {
                this.mBucket.clear(indexOfChild);
                unhideViewInternal(view2);
                return;
            }
            throw new RuntimeException("trying to unhide a view that was not hidden" + view2);
        }
        throw new IllegalArgumentException("view is not a child, cannot hide " + view2);
    }
}
