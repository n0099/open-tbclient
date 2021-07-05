package androidx.appcompat.graphics.drawable;

import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Outline;
import android.graphics.PorterDuff;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.os.SystemClock;
import android.util.SparseArray;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import androidx.annotation.RestrictTo;
import androidx.core.graphics.drawable.DrawableCompat;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
/* loaded from: classes.dex */
public class DrawableContainer extends Drawable implements Drawable.Callback {
    public static /* synthetic */ Interceptable $ic = null;
    public static final boolean DEBUG = false;
    public static final boolean DEFAULT_DITHER = true;
    public static final String TAG = "DrawableContainer";
    public transient /* synthetic */ FieldHolder $fh;
    public int mAlpha;
    public Runnable mAnimationRunnable;
    public BlockInvalidateCallback mBlockInvalidateCallback;
    public int mCurIndex;
    public Drawable mCurrDrawable;
    public DrawableContainerState mDrawableContainerState;
    public long mEnterAnimationEnd;
    public long mExitAnimationEnd;
    public boolean mHasAlpha;
    public Rect mHotspotBounds;
    public Drawable mLastDrawable;
    public boolean mMutated;

    /* loaded from: classes.dex */
    public static class BlockInvalidateCallback implements Drawable.Callback {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public Drawable.Callback mCallback;

        public BlockInvalidateCallback() {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                }
            }
        }

        @Override // android.graphics.drawable.Drawable.Callback
        public void invalidateDrawable(@NonNull Drawable drawable) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, drawable) == null) {
            }
        }

        @Override // android.graphics.drawable.Drawable.Callback
        public void scheduleDrawable(@NonNull Drawable drawable, @NonNull Runnable runnable, long j) {
            Drawable.Callback callback;
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeCommon(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, new Object[]{drawable, runnable, Long.valueOf(j)}) == null) || (callback = this.mCallback) == null) {
                return;
            }
            callback.scheduleDrawable(drawable, runnable, j);
        }

        @Override // android.graphics.drawable.Drawable.Callback
        public void unscheduleDrawable(@NonNull Drawable drawable, @NonNull Runnable runnable) {
            Drawable.Callback callback;
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeLL(Constants.METHOD_SEND_USER_MSG, this, drawable, runnable) == null) || (callback = this.mCallback) == null) {
                return;
            }
            callback.unscheduleDrawable(drawable, runnable);
        }

        public Drawable.Callback unwrap() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
                Drawable.Callback callback = this.mCallback;
                this.mCallback = null;
                return callback;
            }
            return (Drawable.Callback) invokeV.objValue;
        }

        public BlockInvalidateCallback wrap(Drawable.Callback callback) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048580, this, callback)) == null) {
                this.mCallback = callback;
                return this;
            }
            return (BlockInvalidateCallback) invokeL.objValue;
        }
    }

    /* loaded from: classes.dex */
    public static abstract class DrawableContainerState extends Drawable.ConstantState {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public boolean mAutoMirrored;
        public boolean mCanConstantState;
        public int mChangingConfigurations;
        public boolean mCheckedConstantSize;
        public boolean mCheckedConstantState;
        public boolean mCheckedOpacity;
        public boolean mCheckedPadding;
        public boolean mCheckedStateful;
        public int mChildrenChangingConfigurations;
        public ColorFilter mColorFilter;
        public int mConstantHeight;
        public int mConstantMinimumHeight;
        public int mConstantMinimumWidth;
        public Rect mConstantPadding;
        public boolean mConstantSize;
        public int mConstantWidth;
        public int mDensity;
        public boolean mDither;
        public SparseArray<Drawable.ConstantState> mDrawableFutures;
        public Drawable[] mDrawables;
        public int mEnterFadeDuration;
        public int mExitFadeDuration;
        public boolean mHasColorFilter;
        public boolean mHasTintList;
        public boolean mHasTintMode;
        public int mLayoutDirection;
        public boolean mMutated;
        public int mNumChildren;
        public int mOpacity;
        public final DrawableContainer mOwner;
        public Resources mSourceRes;
        public boolean mStateful;
        public ColorStateList mTintList;
        public PorterDuff.Mode mTintMode;
        public boolean mVariablePadding;

        public DrawableContainerState(DrawableContainerState drawableContainerState, DrawableContainer drawableContainer, Resources resources) {
            Resources resources2;
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {drawableContainerState, drawableContainer, resources};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.mDensity = 160;
            this.mVariablePadding = false;
            this.mConstantSize = false;
            this.mDither = true;
            this.mEnterFadeDuration = 0;
            this.mExitFadeDuration = 0;
            this.mOwner = drawableContainer;
            if (resources != null) {
                resources2 = resources;
            } else {
                resources2 = drawableContainerState != null ? drawableContainerState.mSourceRes : null;
            }
            this.mSourceRes = resources2;
            int resolveDensity = DrawableContainer.resolveDensity(resources, drawableContainerState != null ? drawableContainerState.mDensity : 0);
            this.mDensity = resolveDensity;
            if (drawableContainerState != null) {
                this.mChangingConfigurations = drawableContainerState.mChangingConfigurations;
                this.mChildrenChangingConfigurations = drawableContainerState.mChildrenChangingConfigurations;
                this.mCheckedConstantState = true;
                this.mCanConstantState = true;
                this.mVariablePadding = drawableContainerState.mVariablePadding;
                this.mConstantSize = drawableContainerState.mConstantSize;
                this.mDither = drawableContainerState.mDither;
                this.mMutated = drawableContainerState.mMutated;
                this.mLayoutDirection = drawableContainerState.mLayoutDirection;
                this.mEnterFadeDuration = drawableContainerState.mEnterFadeDuration;
                this.mExitFadeDuration = drawableContainerState.mExitFadeDuration;
                this.mAutoMirrored = drawableContainerState.mAutoMirrored;
                this.mColorFilter = drawableContainerState.mColorFilter;
                this.mHasColorFilter = drawableContainerState.mHasColorFilter;
                this.mTintList = drawableContainerState.mTintList;
                this.mTintMode = drawableContainerState.mTintMode;
                this.mHasTintList = drawableContainerState.mHasTintList;
                this.mHasTintMode = drawableContainerState.mHasTintMode;
                if (drawableContainerState.mDensity == resolveDensity) {
                    if (drawableContainerState.mCheckedPadding) {
                        this.mConstantPadding = new Rect(drawableContainerState.mConstantPadding);
                        this.mCheckedPadding = true;
                    }
                    if (drawableContainerState.mCheckedConstantSize) {
                        this.mConstantWidth = drawableContainerState.mConstantWidth;
                        this.mConstantHeight = drawableContainerState.mConstantHeight;
                        this.mConstantMinimumWidth = drawableContainerState.mConstantMinimumWidth;
                        this.mConstantMinimumHeight = drawableContainerState.mConstantMinimumHeight;
                        this.mCheckedConstantSize = true;
                    }
                }
                if (drawableContainerState.mCheckedOpacity) {
                    this.mOpacity = drawableContainerState.mOpacity;
                    this.mCheckedOpacity = true;
                }
                if (drawableContainerState.mCheckedStateful) {
                    this.mStateful = drawableContainerState.mStateful;
                    this.mCheckedStateful = true;
                }
                Drawable[] drawableArr = drawableContainerState.mDrawables;
                this.mDrawables = new Drawable[drawableArr.length];
                this.mNumChildren = drawableContainerState.mNumChildren;
                SparseArray<Drawable.ConstantState> sparseArray = drawableContainerState.mDrawableFutures;
                if (sparseArray != null) {
                    this.mDrawableFutures = sparseArray.clone();
                } else {
                    this.mDrawableFutures = new SparseArray<>(this.mNumChildren);
                }
                int i4 = this.mNumChildren;
                for (int i5 = 0; i5 < i4; i5++) {
                    if (drawableArr[i5] != null) {
                        Drawable.ConstantState constantState = drawableArr[i5].getConstantState();
                        if (constantState != null) {
                            this.mDrawableFutures.put(i5, constantState);
                        } else {
                            this.mDrawables[i5] = drawableArr[i5];
                        }
                    }
                }
                return;
            }
            this.mDrawables = new Drawable[10];
            this.mNumChildren = 0;
        }

        private void createAllFutures() {
            SparseArray<Drawable.ConstantState> sparseArray;
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeV(65537, this) == null) || (sparseArray = this.mDrawableFutures) == null) {
                return;
            }
            int size = sparseArray.size();
            for (int i2 = 0; i2 < size; i2++) {
                this.mDrawables[this.mDrawableFutures.keyAt(i2)] = prepareDrawable(this.mDrawableFutures.valueAt(i2).newDrawable(this.mSourceRes));
            }
            this.mDrawableFutures = null;
        }

        private Drawable prepareDrawable(Drawable drawable) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(65538, this, drawable)) == null) {
                if (Build.VERSION.SDK_INT >= 23) {
                    drawable.setLayoutDirection(this.mLayoutDirection);
                }
                Drawable mutate = drawable.mutate();
                mutate.setCallback(this.mOwner);
                return mutate;
            }
            return (Drawable) invokeL.objValue;
        }

        public final int addChild(Drawable drawable) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, drawable)) == null) {
                int i2 = this.mNumChildren;
                if (i2 >= this.mDrawables.length) {
                    growArray(i2, i2 + 10);
                }
                drawable.mutate();
                drawable.setVisible(false, true);
                drawable.setCallback(this.mOwner);
                this.mDrawables[i2] = drawable;
                this.mNumChildren++;
                this.mChildrenChangingConfigurations = drawable.getChangingConfigurations() | this.mChildrenChangingConfigurations;
                invalidateCache();
                this.mConstantPadding = null;
                this.mCheckedPadding = false;
                this.mCheckedConstantSize = false;
                this.mCheckedConstantState = false;
                return i2;
            }
            return invokeL.intValue;
        }

        @RequiresApi(21)
        public final void applyTheme(Resources.Theme theme) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, theme) == null) || theme == null) {
                return;
            }
            createAllFutures();
            int i2 = this.mNumChildren;
            Drawable[] drawableArr = this.mDrawables;
            for (int i3 = 0; i3 < i2; i3++) {
                if (drawableArr[i3] != null && drawableArr[i3].canApplyTheme()) {
                    drawableArr[i3].applyTheme(theme);
                    this.mChildrenChangingConfigurations |= drawableArr[i3].getChangingConfigurations();
                }
            }
            updateDensity(theme.getResources());
        }

        @Override // android.graphics.drawable.Drawable.ConstantState
        @RequiresApi(21)
        public boolean canApplyTheme() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
                int i2 = this.mNumChildren;
                Drawable[] drawableArr = this.mDrawables;
                for (int i3 = 0; i3 < i2; i3++) {
                    Drawable drawable = drawableArr[i3];
                    if (drawable != null) {
                        if (drawable.canApplyTheme()) {
                            return true;
                        }
                    } else {
                        Drawable.ConstantState constantState = this.mDrawableFutures.get(i3);
                        if (constantState != null && constantState.canApplyTheme()) {
                            return true;
                        }
                    }
                }
                return false;
            }
            return invokeV.booleanValue;
        }

        public synchronized boolean canConstantState() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
                synchronized (this) {
                    if (this.mCheckedConstantState) {
                        return this.mCanConstantState;
                    }
                    createAllFutures();
                    this.mCheckedConstantState = true;
                    int i2 = this.mNumChildren;
                    Drawable[] drawableArr = this.mDrawables;
                    for (int i3 = 0; i3 < i2; i3++) {
                        if (drawableArr[i3].getConstantState() == null) {
                            this.mCanConstantState = false;
                            return false;
                        }
                    }
                    this.mCanConstantState = true;
                    return true;
                }
            }
            return invokeV.booleanValue;
        }

        public final void clearMutated() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
                this.mMutated = false;
            }
        }

        public void computeConstantSize() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048581, this) == null) {
                this.mCheckedConstantSize = true;
                createAllFutures();
                int i2 = this.mNumChildren;
                Drawable[] drawableArr = this.mDrawables;
                this.mConstantHeight = -1;
                this.mConstantWidth = -1;
                this.mConstantMinimumHeight = 0;
                this.mConstantMinimumWidth = 0;
                for (int i3 = 0; i3 < i2; i3++) {
                    Drawable drawable = drawableArr[i3];
                    int intrinsicWidth = drawable.getIntrinsicWidth();
                    if (intrinsicWidth > this.mConstantWidth) {
                        this.mConstantWidth = intrinsicWidth;
                    }
                    int intrinsicHeight = drawable.getIntrinsicHeight();
                    if (intrinsicHeight > this.mConstantHeight) {
                        this.mConstantHeight = intrinsicHeight;
                    }
                    int minimumWidth = drawable.getMinimumWidth();
                    if (minimumWidth > this.mConstantMinimumWidth) {
                        this.mConstantMinimumWidth = minimumWidth;
                    }
                    int minimumHeight = drawable.getMinimumHeight();
                    if (minimumHeight > this.mConstantMinimumHeight) {
                        this.mConstantMinimumHeight = minimumHeight;
                    }
                }
            }
        }

        public final int getCapacity() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) ? this.mDrawables.length : invokeV.intValue;
        }

        @Override // android.graphics.drawable.Drawable.ConstantState
        public int getChangingConfigurations() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) ? this.mChangingConfigurations | this.mChildrenChangingConfigurations : invokeV.intValue;
        }

        public final Drawable getChild(int i2) {
            InterceptResult invokeI;
            int indexOfKey;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeI = interceptable.invokeI(InputDeviceCompat.SOURCE_TOUCHPAD, this, i2)) == null) {
                Drawable drawable = this.mDrawables[i2];
                if (drawable != null) {
                    return drawable;
                }
                SparseArray<Drawable.ConstantState> sparseArray = this.mDrawableFutures;
                if (sparseArray == null || (indexOfKey = sparseArray.indexOfKey(i2)) < 0) {
                    return null;
                }
                Drawable prepareDrawable = prepareDrawable(this.mDrawableFutures.valueAt(indexOfKey).newDrawable(this.mSourceRes));
                this.mDrawables[i2] = prepareDrawable;
                this.mDrawableFutures.removeAt(indexOfKey);
                if (this.mDrawableFutures.size() == 0) {
                    this.mDrawableFutures = null;
                }
                return prepareDrawable;
            }
            return (Drawable) invokeI.objValue;
        }

        public final int getChildCount() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048585, this)) == null) ? this.mNumChildren : invokeV.intValue;
        }

        public final int getConstantHeight() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048586, this)) == null) {
                if (!this.mCheckedConstantSize) {
                    computeConstantSize();
                }
                return this.mConstantHeight;
            }
            return invokeV.intValue;
        }

        public final int getConstantMinimumHeight() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048587, this)) == null) {
                if (!this.mCheckedConstantSize) {
                    computeConstantSize();
                }
                return this.mConstantMinimumHeight;
            }
            return invokeV.intValue;
        }

        public final int getConstantMinimumWidth() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048588, this)) == null) {
                if (!this.mCheckedConstantSize) {
                    computeConstantSize();
                }
                return this.mConstantMinimumWidth;
            }
            return invokeV.intValue;
        }

        public final Rect getConstantPadding() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048589, this)) == null) {
                Rect rect = null;
                if (this.mVariablePadding) {
                    return null;
                }
                if (this.mConstantPadding == null && !this.mCheckedPadding) {
                    createAllFutures();
                    Rect rect2 = new Rect();
                    int i2 = this.mNumChildren;
                    Drawable[] drawableArr = this.mDrawables;
                    for (int i3 = 0; i3 < i2; i3++) {
                        if (drawableArr[i3].getPadding(rect2)) {
                            if (rect == null) {
                                rect = new Rect(0, 0, 0, 0);
                            }
                            int i4 = rect2.left;
                            if (i4 > rect.left) {
                                rect.left = i4;
                            }
                            int i5 = rect2.top;
                            if (i5 > rect.top) {
                                rect.top = i5;
                            }
                            int i6 = rect2.right;
                            if (i6 > rect.right) {
                                rect.right = i6;
                            }
                            int i7 = rect2.bottom;
                            if (i7 > rect.bottom) {
                                rect.bottom = i7;
                            }
                        }
                    }
                    this.mCheckedPadding = true;
                    this.mConstantPadding = rect;
                    return rect;
                }
                return this.mConstantPadding;
            }
            return (Rect) invokeV.objValue;
        }

        public final int getConstantWidth() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048590, this)) == null) {
                if (!this.mCheckedConstantSize) {
                    computeConstantSize();
                }
                return this.mConstantWidth;
            }
            return invokeV.intValue;
        }

        public final int getEnterFadeDuration() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048591, this)) == null) ? this.mEnterFadeDuration : invokeV.intValue;
        }

        public final int getExitFadeDuration() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048592, this)) == null) ? this.mExitFadeDuration : invokeV.intValue;
        }

        public final int getOpacity() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048593, this)) == null) {
                if (this.mCheckedOpacity) {
                    return this.mOpacity;
                }
                createAllFutures();
                int i2 = this.mNumChildren;
                Drawable[] drawableArr = this.mDrawables;
                int opacity = i2 > 0 ? drawableArr[0].getOpacity() : -2;
                for (int i3 = 1; i3 < i2; i3++) {
                    opacity = Drawable.resolveOpacity(opacity, drawableArr[i3].getOpacity());
                }
                this.mOpacity = opacity;
                this.mCheckedOpacity = true;
                return opacity;
            }
            return invokeV.intValue;
        }

        public void growArray(int i2, int i3) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeII(1048594, this, i2, i3) == null) {
                Drawable[] drawableArr = new Drawable[i3];
                System.arraycopy(this.mDrawables, 0, drawableArr, 0, i2);
                this.mDrawables = drawableArr;
            }
        }

        public void invalidateCache() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048595, this) == null) {
                this.mCheckedOpacity = false;
                this.mCheckedStateful = false;
            }
        }

        public final boolean isConstantSize() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048596, this)) == null) ? this.mConstantSize : invokeV.booleanValue;
        }

        public final boolean isStateful() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048597, this)) == null) {
                if (this.mCheckedStateful) {
                    return this.mStateful;
                }
                createAllFutures();
                int i2 = this.mNumChildren;
                Drawable[] drawableArr = this.mDrawables;
                boolean z = false;
                int i3 = 0;
                while (true) {
                    if (i3 >= i2) {
                        break;
                    } else if (drawableArr[i3].isStateful()) {
                        z = true;
                        break;
                    } else {
                        i3++;
                    }
                }
                this.mStateful = z;
                this.mCheckedStateful = true;
                return z;
            }
            return invokeV.booleanValue;
        }

        public void mutate() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048598, this) == null) {
                int i2 = this.mNumChildren;
                Drawable[] drawableArr = this.mDrawables;
                for (int i3 = 0; i3 < i2; i3++) {
                    if (drawableArr[i3] != null) {
                        drawableArr[i3].mutate();
                    }
                }
                this.mMutated = true;
            }
        }

        public final void setConstantSize(boolean z) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeZ(1048599, this, z) == null) {
                this.mConstantSize = z;
            }
        }

        public final void setEnterFadeDuration(int i2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeI(1048600, this, i2) == null) {
                this.mEnterFadeDuration = i2;
            }
        }

        public final void setExitFadeDuration(int i2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeI(1048601, this, i2) == null) {
                this.mExitFadeDuration = i2;
            }
        }

        public final boolean setLayoutDirection(int i2, int i3) {
            InterceptResult invokeII;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeII = interceptable.invokeII(1048602, this, i2, i3)) == null) {
                int i4 = this.mNumChildren;
                Drawable[] drawableArr = this.mDrawables;
                boolean z = false;
                for (int i5 = 0; i5 < i4; i5++) {
                    if (drawableArr[i5] != null) {
                        boolean layoutDirection = Build.VERSION.SDK_INT >= 23 ? drawableArr[i5].setLayoutDirection(i2) : false;
                        if (i5 == i3) {
                            z = layoutDirection;
                        }
                    }
                }
                this.mLayoutDirection = i2;
                return z;
            }
            return invokeII.booleanValue;
        }

        public final void setVariablePadding(boolean z) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeZ(1048603, this, z) == null) {
                this.mVariablePadding = z;
            }
        }

        public final void updateDensity(Resources resources) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048604, this, resources) == null) || resources == null) {
                return;
            }
            this.mSourceRes = resources;
            int resolveDensity = DrawableContainer.resolveDensity(resources, this.mDensity);
            int i2 = this.mDensity;
            this.mDensity = resolveDensity;
            if (i2 != resolveDensity) {
                this.mCheckedConstantSize = false;
                this.mCheckedPadding = false;
            }
        }
    }

    public DrawableContainer() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.mAlpha = 255;
        this.mCurIndex = -1;
    }

    private void initializeDrawableForDisplay(Drawable drawable) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65537, this, drawable) == null) {
            if (this.mBlockInvalidateCallback == null) {
                this.mBlockInvalidateCallback = new BlockInvalidateCallback();
            }
            drawable.setCallback(this.mBlockInvalidateCallback.wrap(drawable.getCallback()));
            try {
                if (this.mDrawableContainerState.mEnterFadeDuration <= 0 && this.mHasAlpha) {
                    drawable.setAlpha(this.mAlpha);
                }
                if (this.mDrawableContainerState.mHasColorFilter) {
                    drawable.setColorFilter(this.mDrawableContainerState.mColorFilter);
                } else {
                    if (this.mDrawableContainerState.mHasTintList) {
                        DrawableCompat.setTintList(drawable, this.mDrawableContainerState.mTintList);
                    }
                    if (this.mDrawableContainerState.mHasTintMode) {
                        DrawableCompat.setTintMode(drawable, this.mDrawableContainerState.mTintMode);
                    }
                }
                drawable.setVisible(isVisible(), true);
                drawable.setDither(this.mDrawableContainerState.mDither);
                drawable.setState(getState());
                drawable.setLevel(getLevel());
                drawable.setBounds(getBounds());
                if (Build.VERSION.SDK_INT >= 23) {
                    drawable.setLayoutDirection(getLayoutDirection());
                }
                if (Build.VERSION.SDK_INT >= 19) {
                    drawable.setAutoMirrored(this.mDrawableContainerState.mAutoMirrored);
                }
                Rect rect = this.mHotspotBounds;
                if (Build.VERSION.SDK_INT >= 21 && rect != null) {
                    drawable.setHotspotBounds(rect.left, rect.top, rect.right, rect.bottom);
                }
            } finally {
                drawable.setCallback(this.mBlockInvalidateCallback.unwrap());
            }
        }
    }

    private boolean needsMirroring() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65538, this)) == null) ? isAutoMirrored() && DrawableCompat.getLayoutDirection(this) == 1 : invokeV.booleanValue;
    }

    public static int resolveDensity(@Nullable Resources resources, int i2) {
        InterceptResult invokeLI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLI = interceptable.invokeLI(65539, null, resources, i2)) == null) {
            if (resources != null) {
                i2 = resources.getDisplayMetrics().densityDpi;
            }
            if (i2 == 0) {
                return 160;
            }
            return i2;
        }
        return invokeLI.intValue;
    }

    /* JADX WARN: Removed duplicated region for block: B:16:0x0043  */
    /* JADX WARN: Removed duplicated region for block: B:22:0x0069  */
    /* JADX WARN: Removed duplicated region for block: B:25:0x006e A[ADDED_TO_REGION] */
    /* JADX WARN: Removed duplicated region for block: B:31:? A[ADDED_TO_REGION, RETURN, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void animate(boolean z) {
        boolean z2;
        Drawable drawable;
        Interceptable interceptable = $ic;
        if (interceptable != null && interceptable.invokeZ(1048576, this, z) != null) {
            return;
        }
        boolean z3 = true;
        this.mHasAlpha = true;
        long uptimeMillis = SystemClock.uptimeMillis();
        Drawable drawable2 = this.mCurrDrawable;
        if (drawable2 != null) {
            long j = this.mEnterAnimationEnd;
            if (j != 0) {
                if (j <= uptimeMillis) {
                    drawable2.setAlpha(this.mAlpha);
                    this.mEnterAnimationEnd = 0L;
                } else {
                    drawable2.setAlpha(((255 - (((int) ((j - uptimeMillis) * 255)) / this.mDrawableContainerState.mEnterFadeDuration)) * this.mAlpha) / 255);
                    z2 = true;
                    drawable = this.mLastDrawable;
                    if (drawable == null) {
                        long j2 = this.mExitAnimationEnd;
                        if (j2 != 0) {
                            if (j2 <= uptimeMillis) {
                                drawable.setVisible(false, false);
                                this.mLastDrawable = null;
                                this.mExitAnimationEnd = 0L;
                            } else {
                                drawable.setAlpha(((((int) ((j2 - uptimeMillis) * 255)) / this.mDrawableContainerState.mExitFadeDuration) * this.mAlpha) / 255);
                                if (z && z3) {
                                    scheduleSelf(this.mAnimationRunnable, uptimeMillis + 16);
                                    return;
                                }
                                return;
                            }
                        }
                    } else {
                        this.mExitAnimationEnd = 0L;
                    }
                    z3 = z2;
                    if (z) {
                        return;
                    }
                    return;
                }
            }
        } else {
            this.mEnterAnimationEnd = 0L;
        }
        z2 = false;
        drawable = this.mLastDrawable;
        if (drawable == null) {
        }
        z3 = z2;
        if (z) {
        }
    }

    @Override // android.graphics.drawable.Drawable
    @RequiresApi(21)
    public void applyTheme(@NonNull Resources.Theme theme) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, theme) == null) {
            this.mDrawableContainerState.applyTheme(theme);
        }
    }

    @Override // android.graphics.drawable.Drawable
    @RequiresApi(21)
    public boolean canApplyTheme() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? this.mDrawableContainerState.canApplyTheme() : invokeV.booleanValue;
    }

    public void clearMutated() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
            this.mDrawableContainerState.clearMutated();
            this.mMutated = false;
        }
    }

    public DrawableContainerState cloneConstantState() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) ? this.mDrawableContainerState : (DrawableContainerState) invokeV.objValue;
    }

    @Override // android.graphics.drawable.Drawable
    public void draw(@NonNull Canvas canvas) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048581, this, canvas) == null) {
            Drawable drawable = this.mCurrDrawable;
            if (drawable != null) {
                drawable.draw(canvas);
            }
            Drawable drawable2 = this.mLastDrawable;
            if (drawable2 != null) {
                drawable2.draw(canvas);
            }
        }
    }

    @Override // android.graphics.drawable.Drawable
    public int getAlpha() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) ? this.mAlpha : invokeV.intValue;
    }

    @Override // android.graphics.drawable.Drawable
    public int getChangingConfigurations() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) ? super.getChangingConfigurations() | this.mDrawableContainerState.getChangingConfigurations() : invokeV.intValue;
    }

    @Override // android.graphics.drawable.Drawable
    public final Drawable.ConstantState getConstantState() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) {
            if (this.mDrawableContainerState.canConstantState()) {
                this.mDrawableContainerState.mChangingConfigurations = getChangingConfigurations();
                return this.mDrawableContainerState;
            }
            return null;
        }
        return (Drawable.ConstantState) invokeV.objValue;
    }

    @Override // android.graphics.drawable.Drawable
    @NonNull
    public Drawable getCurrent() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048585, this)) == null) ? this.mCurrDrawable : (Drawable) invokeV.objValue;
    }

    public int getCurrentIndex() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048586, this)) == null) ? this.mCurIndex : invokeV.intValue;
    }

    @Override // android.graphics.drawable.Drawable
    public void getHotspotBounds(@NonNull Rect rect) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048587, this, rect) == null) {
            Rect rect2 = this.mHotspotBounds;
            if (rect2 != null) {
                rect.set(rect2);
            } else {
                super.getHotspotBounds(rect);
            }
        }
    }

    @Override // android.graphics.drawable.Drawable
    public int getIntrinsicHeight() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048588, this)) == null) {
            if (this.mDrawableContainerState.isConstantSize()) {
                return this.mDrawableContainerState.getConstantHeight();
            }
            Drawable drawable = this.mCurrDrawable;
            if (drawable != null) {
                return drawable.getIntrinsicHeight();
            }
            return -1;
        }
        return invokeV.intValue;
    }

    @Override // android.graphics.drawable.Drawable
    public int getIntrinsicWidth() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048589, this)) == null) {
            if (this.mDrawableContainerState.isConstantSize()) {
                return this.mDrawableContainerState.getConstantWidth();
            }
            Drawable drawable = this.mCurrDrawable;
            if (drawable != null) {
                return drawable.getIntrinsicWidth();
            }
            return -1;
        }
        return invokeV.intValue;
    }

    @Override // android.graphics.drawable.Drawable
    public int getMinimumHeight() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048590, this)) == null) {
            if (this.mDrawableContainerState.isConstantSize()) {
                return this.mDrawableContainerState.getConstantMinimumHeight();
            }
            Drawable drawable = this.mCurrDrawable;
            if (drawable != null) {
                return drawable.getMinimumHeight();
            }
            return 0;
        }
        return invokeV.intValue;
    }

    @Override // android.graphics.drawable.Drawable
    public int getMinimumWidth() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048591, this)) == null) {
            if (this.mDrawableContainerState.isConstantSize()) {
                return this.mDrawableContainerState.getConstantMinimumWidth();
            }
            Drawable drawable = this.mCurrDrawable;
            if (drawable != null) {
                return drawable.getMinimumWidth();
            }
            return 0;
        }
        return invokeV.intValue;
    }

    @Override // android.graphics.drawable.Drawable
    public int getOpacity() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048592, this)) == null) {
            Drawable drawable = this.mCurrDrawable;
            if (drawable == null || !drawable.isVisible()) {
                return -2;
            }
            return this.mDrawableContainerState.getOpacity();
        }
        return invokeV.intValue;
    }

    @Override // android.graphics.drawable.Drawable
    @RequiresApi(21)
    public void getOutline(@NonNull Outline outline) {
        Drawable drawable;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048593, this, outline) == null) || (drawable = this.mCurrDrawable) == null) {
            return;
        }
        drawable.getOutline(outline);
    }

    @Override // android.graphics.drawable.Drawable
    public boolean getPadding(@NonNull Rect rect) {
        InterceptResult invokeL;
        boolean padding;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048594, this, rect)) == null) {
            Rect constantPadding = this.mDrawableContainerState.getConstantPadding();
            if (constantPadding != null) {
                rect.set(constantPadding);
                padding = (constantPadding.right | ((constantPadding.left | constantPadding.top) | constantPadding.bottom)) != 0;
            } else {
                Drawable drawable = this.mCurrDrawable;
                if (drawable != null) {
                    padding = drawable.getPadding(rect);
                } else {
                    padding = super.getPadding(rect);
                }
            }
            if (needsMirroring()) {
                int i2 = rect.left;
                rect.left = rect.right;
                rect.right = i2;
            }
            return padding;
        }
        return invokeL.booleanValue;
    }

    public void invalidateDrawable(@NonNull Drawable drawable) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048595, this, drawable) == null) {
            DrawableContainerState drawableContainerState = this.mDrawableContainerState;
            if (drawableContainerState != null) {
                drawableContainerState.invalidateCache();
            }
            if (drawable != this.mCurrDrawable || getCallback() == null) {
                return;
            }
            getCallback().invalidateDrawable(this);
        }
    }

    @Override // android.graphics.drawable.Drawable
    public boolean isAutoMirrored() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048596, this)) == null) ? this.mDrawableContainerState.mAutoMirrored : invokeV.booleanValue;
    }

    @Override // android.graphics.drawable.Drawable
    public boolean isStateful() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048597, this)) == null) ? this.mDrawableContainerState.isStateful() : invokeV.booleanValue;
    }

    @Override // android.graphics.drawable.Drawable
    public void jumpToCurrentState() {
        boolean z;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048598, this) == null) {
            Drawable drawable = this.mLastDrawable;
            boolean z2 = true;
            if (drawable != null) {
                drawable.jumpToCurrentState();
                this.mLastDrawable = null;
                z = true;
            } else {
                z = false;
            }
            Drawable drawable2 = this.mCurrDrawable;
            if (drawable2 != null) {
                drawable2.jumpToCurrentState();
                if (this.mHasAlpha) {
                    this.mCurrDrawable.setAlpha(this.mAlpha);
                }
            }
            if (this.mExitAnimationEnd != 0) {
                this.mExitAnimationEnd = 0L;
                z = true;
            }
            if (this.mEnterAnimationEnd != 0) {
                this.mEnterAnimationEnd = 0L;
            } else {
                z2 = z;
            }
            if (z2) {
                invalidateSelf();
            }
        }
    }

    @Override // android.graphics.drawable.Drawable
    @NonNull
    public Drawable mutate() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048599, this)) == null) {
            if (!this.mMutated && super.mutate() == this) {
                DrawableContainerState cloneConstantState = cloneConstantState();
                cloneConstantState.mutate();
                setConstantState(cloneConstantState);
                this.mMutated = true;
            }
            return this;
        }
        return (Drawable) invokeV.objValue;
    }

    @Override // android.graphics.drawable.Drawable
    public void onBoundsChange(Rect rect) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048600, this, rect) == null) {
            Drawable drawable = this.mLastDrawable;
            if (drawable != null) {
                drawable.setBounds(rect);
            }
            Drawable drawable2 = this.mCurrDrawable;
            if (drawable2 != null) {
                drawable2.setBounds(rect);
            }
        }
    }

    @Override // android.graphics.drawable.Drawable
    public boolean onLayoutDirectionChanged(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeI = interceptable.invokeI(1048601, this, i2)) == null) ? this.mDrawableContainerState.setLayoutDirection(i2, getCurrentIndex()) : invokeI.booleanValue;
    }

    @Override // android.graphics.drawable.Drawable
    public boolean onLevelChange(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048602, this, i2)) == null) {
            Drawable drawable = this.mLastDrawable;
            if (drawable != null) {
                return drawable.setLevel(i2);
            }
            Drawable drawable2 = this.mCurrDrawable;
            if (drawable2 != null) {
                return drawable2.setLevel(i2);
            }
            return false;
        }
        return invokeI.booleanValue;
    }

    @Override // android.graphics.drawable.Drawable
    public boolean onStateChange(int[] iArr) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048603, this, iArr)) == null) {
            Drawable drawable = this.mLastDrawable;
            if (drawable != null) {
                return drawable.setState(iArr);
            }
            Drawable drawable2 = this.mCurrDrawable;
            if (drawable2 != null) {
                return drawable2.setState(iArr);
            }
            return false;
        }
        return invokeL.booleanValue;
    }

    public void scheduleDrawable(@NonNull Drawable drawable, @NonNull Runnable runnable, long j) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeCommon(1048604, this, new Object[]{drawable, runnable, Long.valueOf(j)}) == null) && drawable == this.mCurrDrawable && getCallback() != null) {
            getCallback().scheduleDrawable(this, runnable, j);
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:35:0x006f  */
    /* JADX WARN: Removed duplicated region for block: B:36:0x0077  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public boolean selectDrawable(int i2) {
        InterceptResult invokeI;
        Runnable runnable;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048605, this, i2)) == null) {
            if (i2 == this.mCurIndex) {
                return false;
            }
            long uptimeMillis = SystemClock.uptimeMillis();
            if (this.mDrawableContainerState.mExitFadeDuration > 0) {
                Drawable drawable = this.mLastDrawable;
                if (drawable != null) {
                    drawable.setVisible(false, false);
                }
                Drawable drawable2 = this.mCurrDrawable;
                if (drawable2 != null) {
                    this.mLastDrawable = drawable2;
                    this.mExitAnimationEnd = this.mDrawableContainerState.mExitFadeDuration + uptimeMillis;
                } else {
                    this.mLastDrawable = null;
                    this.mExitAnimationEnd = 0L;
                }
            } else {
                Drawable drawable3 = this.mCurrDrawable;
                if (drawable3 != null) {
                    drawable3.setVisible(false, false);
                }
            }
            if (i2 >= 0) {
                DrawableContainerState drawableContainerState = this.mDrawableContainerState;
                if (i2 < drawableContainerState.mNumChildren) {
                    Drawable child = drawableContainerState.getChild(i2);
                    this.mCurrDrawable = child;
                    this.mCurIndex = i2;
                    if (child != null) {
                        int i3 = this.mDrawableContainerState.mEnterFadeDuration;
                        if (i3 > 0) {
                            this.mEnterAnimationEnd = uptimeMillis + i3;
                        }
                        initializeDrawableForDisplay(child);
                    }
                    if (this.mEnterAnimationEnd == 0 || this.mExitAnimationEnd != 0) {
                        runnable = this.mAnimationRunnable;
                        if (runnable != null) {
                            this.mAnimationRunnable = new Runnable(this) { // from class: androidx.appcompat.graphics.drawable.DrawableContainer.1
                                public static /* synthetic */ Interceptable $ic;
                                public transient /* synthetic */ FieldHolder $fh;
                                public final /* synthetic */ DrawableContainer this$0;

                                {
                                    Interceptable interceptable2 = $ic;
                                    if (interceptable2 != null) {
                                        InitContext newInitContext = TitanRuntime.newInitContext();
                                        newInitContext.initArgs = r2;
                                        Object[] objArr = {this};
                                        interceptable2.invokeUnInit(65536, newInitContext);
                                        int i4 = newInitContext.flag;
                                        if ((i4 & 1) != 0) {
                                            int i5 = i4 & 2;
                                            newInitContext.thisArg = this;
                                            interceptable2.invokeInitBody(65536, newInitContext);
                                            return;
                                        }
                                    }
                                    this.this$0 = this;
                                }

                                @Override // java.lang.Runnable
                                public void run() {
                                    Interceptable interceptable2 = $ic;
                                    if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                                        this.this$0.animate(true);
                                        this.this$0.invalidateSelf();
                                    }
                                }
                            };
                        } else {
                            unscheduleSelf(runnable);
                        }
                        animate(true);
                    }
                    invalidateSelf();
                    return true;
                }
            }
            this.mCurrDrawable = null;
            this.mCurIndex = -1;
            if (this.mEnterAnimationEnd == 0) {
            }
            runnable = this.mAnimationRunnable;
            if (runnable != null) {
            }
            animate(true);
            invalidateSelf();
            return true;
        }
        return invokeI.booleanValue;
    }

    @Override // android.graphics.drawable.Drawable
    public void setAlpha(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048606, this, i2) == null) {
            if (this.mHasAlpha && this.mAlpha == i2) {
                return;
            }
            this.mHasAlpha = true;
            this.mAlpha = i2;
            Drawable drawable = this.mCurrDrawable;
            if (drawable != null) {
                if (this.mEnterAnimationEnd == 0) {
                    drawable.setAlpha(i2);
                } else {
                    animate(false);
                }
            }
        }
    }

    @Override // android.graphics.drawable.Drawable
    public void setAutoMirrored(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048607, this, z) == null) {
            DrawableContainerState drawableContainerState = this.mDrawableContainerState;
            if (drawableContainerState.mAutoMirrored != z) {
                drawableContainerState.mAutoMirrored = z;
                Drawable drawable = this.mCurrDrawable;
                if (drawable != null) {
                    DrawableCompat.setAutoMirrored(drawable, z);
                }
            }
        }
    }

    @Override // android.graphics.drawable.Drawable
    public void setColorFilter(ColorFilter colorFilter) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048608, this, colorFilter) == null) {
            DrawableContainerState drawableContainerState = this.mDrawableContainerState;
            drawableContainerState.mHasColorFilter = true;
            if (drawableContainerState.mColorFilter != colorFilter) {
                drawableContainerState.mColorFilter = colorFilter;
                Drawable drawable = this.mCurrDrawable;
                if (drawable != null) {
                    drawable.setColorFilter(colorFilter);
                }
            }
        }
    }

    public void setConstantState(DrawableContainerState drawableContainerState) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048609, this, drawableContainerState) == null) {
            this.mDrawableContainerState = drawableContainerState;
            int i2 = this.mCurIndex;
            if (i2 >= 0) {
                Drawable child = drawableContainerState.getChild(i2);
                this.mCurrDrawable = child;
                if (child != null) {
                    initializeDrawableForDisplay(child);
                }
            }
            this.mLastDrawable = null;
        }
    }

    public void setCurrentIndex(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048610, this, i2) == null) {
            selectDrawable(i2);
        }
    }

    @Override // android.graphics.drawable.Drawable
    public void setDither(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048611, this, z) == null) {
            DrawableContainerState drawableContainerState = this.mDrawableContainerState;
            if (drawableContainerState.mDither != z) {
                drawableContainerState.mDither = z;
                Drawable drawable = this.mCurrDrawable;
                if (drawable != null) {
                    drawable.setDither(z);
                }
            }
        }
    }

    public void setEnterFadeDuration(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048612, this, i2) == null) {
            this.mDrawableContainerState.mEnterFadeDuration = i2;
        }
    }

    public void setExitFadeDuration(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048613, this, i2) == null) {
            this.mDrawableContainerState.mExitFadeDuration = i2;
        }
    }

    @Override // android.graphics.drawable.Drawable
    public void setHotspot(float f2, float f3) {
        Drawable drawable;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeCommon(1048614, this, new Object[]{Float.valueOf(f2), Float.valueOf(f3)}) == null) || (drawable = this.mCurrDrawable) == null) {
            return;
        }
        DrawableCompat.setHotspot(drawable, f2, f3);
    }

    @Override // android.graphics.drawable.Drawable
    public void setHotspotBounds(int i2, int i3, int i4, int i5) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIIII(1048615, this, i2, i3, i4, i5) == null) {
            Rect rect = this.mHotspotBounds;
            if (rect == null) {
                this.mHotspotBounds = new Rect(i2, i3, i4, i5);
            } else {
                rect.set(i2, i3, i4, i5);
            }
            Drawable drawable = this.mCurrDrawable;
            if (drawable != null) {
                DrawableCompat.setHotspotBounds(drawable, i2, i3, i4, i5);
            }
        }
    }

    @Override // android.graphics.drawable.Drawable, androidx.core.graphics.drawable.TintAwareDrawable
    public void setTintList(ColorStateList colorStateList) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048616, this, colorStateList) == null) {
            DrawableContainerState drawableContainerState = this.mDrawableContainerState;
            drawableContainerState.mHasTintList = true;
            if (drawableContainerState.mTintList != colorStateList) {
                drawableContainerState.mTintList = colorStateList;
                DrawableCompat.setTintList(this.mCurrDrawable, colorStateList);
            }
        }
    }

    @Override // android.graphics.drawable.Drawable, androidx.core.graphics.drawable.TintAwareDrawable
    public void setTintMode(@NonNull PorterDuff.Mode mode) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048617, this, mode) == null) {
            DrawableContainerState drawableContainerState = this.mDrawableContainerState;
            drawableContainerState.mHasTintMode = true;
            if (drawableContainerState.mTintMode != mode) {
                drawableContainerState.mTintMode = mode;
                DrawableCompat.setTintMode(this.mCurrDrawable, mode);
            }
        }
    }

    @Override // android.graphics.drawable.Drawable
    public boolean setVisible(boolean z, boolean z2) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048618, this, new Object[]{Boolean.valueOf(z), Boolean.valueOf(z2)})) == null) {
            boolean visible = super.setVisible(z, z2);
            Drawable drawable = this.mLastDrawable;
            if (drawable != null) {
                drawable.setVisible(z, z2);
            }
            Drawable drawable2 = this.mCurrDrawable;
            if (drawable2 != null) {
                drawable2.setVisible(z, z2);
            }
            return visible;
        }
        return invokeCommon.booleanValue;
    }

    public void unscheduleDrawable(@NonNull Drawable drawable, @NonNull Runnable runnable) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLL(1048619, this, drawable, runnable) == null) && drawable == this.mCurrDrawable && getCallback() != null) {
            getCallback().unscheduleDrawable(this, runnable);
        }
    }

    public final void updateDensity(Resources resources) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048620, this, resources) == null) {
            this.mDrawableContainerState.updateDensity(resources);
        }
    }
}
