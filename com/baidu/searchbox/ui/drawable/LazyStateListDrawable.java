package com.baidu.searchbox.ui.drawable;

import android.content.res.Resources;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Rect;
import android.graphics.drawable.Animatable;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.StateListDrawable;
import android.util.StateSet;
import androidx.annotation.DrawableRes;
import androidx.annotation.IntRange;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.baidu.android.util.sp.SharedPrefsWrapper;
import com.baidu.searchbox.aop.annotation.DebugTrace;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes4.dex */
public class LazyStateListDrawable extends StateListDrawable {
    public static final boolean DEBUG = false;
    public static final String KEY_USE_NEW_STATE_LIST_DRAWABLE = "use_new_state_list_drawable";
    public static final String TAG = "BdDrawable";
    public Drawable mBaseDrawable;
    public WeakReference<Resources> mContext;
    public List<StateSetValue> mStateDrawable = new ArrayList();

    /* loaded from: classes4.dex */
    public static final class DelegateDrawable extends Drawable implements Drawable.Callback {
        public Drawable mCurrDrawable;

        public DelegateDrawable() {
        }

        @Override // android.graphics.drawable.Drawable
        public int getIntrinsicHeight() {
            Drawable drawable = this.mCurrDrawable;
            if (drawable != null) {
                return drawable.getIntrinsicHeight();
            }
            return super.getIntrinsicHeight();
        }

        @Override // android.graphics.drawable.Drawable
        public int getIntrinsicWidth() {
            Drawable drawable = this.mCurrDrawable;
            if (drawable != null) {
                return drawable.getIntrinsicWidth();
            }
            return super.getIntrinsicWidth();
        }

        @Override // android.graphics.drawable.Drawable
        public int getMinimumHeight() {
            Drawable drawable = this.mCurrDrawable;
            if (drawable != null) {
                return drawable.getMinimumHeight();
            }
            return super.getMinimumHeight();
        }

        @Override // android.graphics.drawable.Drawable
        public int getMinimumWidth() {
            Drawable drawable = this.mCurrDrawable;
            if (drawable != null) {
                return drawable.getMinimumWidth();
            }
            return super.getMinimumWidth();
        }

        @Override // android.graphics.drawable.Drawable
        public int getOpacity() {
            Drawable drawable = this.mCurrDrawable;
            if (drawable == null) {
                return 0;
            }
            return drawable.getOpacity();
        }

        @Override // android.graphics.drawable.Drawable
        public void draw(@NonNull Canvas canvas) {
            Drawable drawable = this.mCurrDrawable;
            if (drawable != null) {
                drawable.draw(canvas);
            }
        }

        @Override // android.graphics.drawable.Drawable.Callback
        public void invalidateDrawable(@NonNull Drawable drawable) {
            if (drawable == this.mCurrDrawable) {
                invalidateSelf();
            }
        }

        @Override // android.graphics.drawable.Drawable
        public void setAlpha(@IntRange(from = 0, to = 255) int i) {
            Drawable drawable = this.mCurrDrawable;
            if (drawable != null) {
                drawable.setAlpha(i);
            }
        }

        @Override // android.graphics.drawable.Drawable
        public void setBounds(@NonNull Rect rect) {
            Drawable drawable = this.mCurrDrawable;
            if (drawable != null) {
                drawable.setBounds(rect);
            }
        }

        @Override // android.graphics.drawable.Drawable
        public void setColorFilter(@Nullable ColorFilter colorFilter) {
            Drawable drawable = this.mCurrDrawable;
            if (drawable != null) {
                drawable.setColorFilter(colorFilter);
            }
        }

        public void setDelegate(Drawable drawable) {
            this.mCurrDrawable = drawable;
            if (drawable instanceof Animatable) {
                drawable.setCallback(this);
                drawable.setVisible(true, true);
                ((Animatable) drawable).start();
            }
        }

        @Override // android.graphics.drawable.Drawable.Callback
        public void scheduleDrawable(@NonNull Drawable drawable, @NonNull Runnable runnable, long j) {
            if (drawable == this.mCurrDrawable) {
                scheduleSelf(runnable, j);
            }
        }

        @Override // android.graphics.drawable.Drawable
        public void setBounds(int i, int i2, int i3, int i4) {
            Drawable drawable = this.mCurrDrawable;
            if (drawable != null) {
                drawable.setBounds(i, i2, i3, i4);
            }
        }

        @Override // android.graphics.drawable.Drawable.Callback
        public void unscheduleDrawable(@NonNull Drawable drawable, @NonNull Runnable runnable) {
            if (drawable == this.mCurrDrawable) {
                unscheduleSelf(runnable);
            }
        }
    }

    /* loaded from: classes4.dex */
    public static final class DrawableStateBuilder {
        public static boolean mEnableLazy = new SharedPrefsWrapper("").getBoolean(LazyStateListDrawable.KEY_USE_NEW_STATE_LIST_DRAWABLE, true);
        public LazyStateListDrawable mInnerDrawable;
        public WeakReference<Resources> mResources;
        public StateListDrawable mSysDrawable;

        public Drawable build() {
            StateListDrawable stateListDrawable = this.mSysDrawable;
            if (stateListDrawable != null) {
                return stateListDrawable;
            }
            this.mInnerDrawable.refreshAsyncDrawable();
            return this.mInnerDrawable;
        }

        public DrawableStateBuilder(Resources resources) {
            this.mResources = new WeakReference<>(resources);
            this.mInnerDrawable = new LazyStateListDrawable(resources);
        }

        @DebugTrace
        private void addDrawableToSystemStateList(int[] iArr, int i) {
            if (this.mSysDrawable == null) {
                this.mSysDrawable = new StateListDrawable();
            }
            Resources resources = this.mResources.get();
            if (resources != null) {
                this.mSysDrawable.addState(iArr, resources.getDrawable(i));
            }
        }

        public void addStateDrawable(int[] iArr, int i, boolean z) {
            if (!mEnableLazy) {
                addDrawableToSystemStateList(iArr, i);
            } else if (z) {
                this.mInnerDrawable.addAndDecodeState(iArr, i);
            } else {
                this.mInnerDrawable.addState(iArr, i);
            }
        }
    }

    /* loaded from: classes4.dex */
    public static final class StateSetValue {
        public DelegateDrawable delegateDrawable = new DelegateDrawable();
        public int drawable;
        public int[] state;

        public StateSetValue(int[] iArr, int i) {
            this.state = iArr;
            this.drawable = i;
        }
    }

    public LazyStateListDrawable(Resources resources) {
        this.mContext = new WeakReference<>(resources);
    }

    private Drawable decodeDrawable(@DrawableRes int i) {
        Resources resources = this.mContext.get();
        if (resources != null) {
            return resources.getDrawable(i);
        }
        return null;
    }

    public void addAndDecodeState(int[] iArr, @DrawableRes int i) {
        Drawable decodeDrawable = decodeDrawable(i);
        if (decodeDrawable != null) {
            super.addState(iArr, decodeDrawable);
            if (this.mBaseDrawable == null) {
                this.mBaseDrawable = decodeDrawable;
            }
        }
    }

    public void addState(int[] iArr, @DrawableRes int i) {
        StateSetValue stateSetValue = new StateSetValue(iArr, i);
        super.addState(iArr, stateSetValue.delegateDrawable);
        this.mStateDrawable.add(stateSetValue);
    }

    @Override // android.graphics.drawable.StateListDrawable, android.graphics.drawable.DrawableContainer, android.graphics.drawable.Drawable
    public boolean onStateChange(int[] iArr) {
        int size;
        List<StateSetValue> list = this.mStateDrawable;
        int i = 0;
        if (list == null) {
            size = 0;
        } else {
            size = list.size();
        }
        while (true) {
            if (i >= size) {
                break;
            } else if (StateSet.stateSetMatches(this.mStateDrawable.get(i).state, iArr)) {
                StateSetValue remove = this.mStateDrawable.remove(i);
                Drawable decodeDrawable = decodeDrawable(remove.drawable);
                if (decodeDrawable != null) {
                    remove.delegateDrawable.setDelegate(decodeDrawable);
                }
            } else {
                i++;
            }
        }
        return super.onStateChange(iArr);
    }

    public void refreshAsyncDrawable() {
        if (this.mBaseDrawable == null) {
            return;
        }
        for (StateSetValue stateSetValue : this.mStateDrawable) {
            stateSetValue.delegateDrawable.setDelegate(this.mBaseDrawable);
        }
    }
}
