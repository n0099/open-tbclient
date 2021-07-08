package androidx.appcompat.widget;

import android.animation.ObjectAnimator;
import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.Canvas;
import android.graphics.PorterDuff;
import android.graphics.Rect;
import android.graphics.Region;
import android.graphics.Typeface;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.text.Layout;
import android.text.StaticLayout;
import android.text.TextPaint;
import android.text.TextUtils;
import android.text.method.TransformationMethod;
import android.util.AttributeSet;
import android.util.Property;
import android.view.ActionMode;
import android.view.MotionEvent;
import android.view.VelocityTracker;
import android.view.ViewConfiguration;
import android.view.accessibility.AccessibilityEvent;
import android.view.accessibility.AccessibilityNodeInfo;
import android.widget.CompoundButton;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.R;
import androidx.appcompat.content.res.AppCompatResources;
import androidx.appcompat.text.AllCapsTransformationMethod;
import androidx.core.graphics.drawable.DrawableCompat;
import androidx.core.view.InputDeviceCompat;
import androidx.core.view.ViewCompat;
import androidx.core.widget.TextViewCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.mobads.container.util.AdIconUtil;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes.dex */
public class SwitchCompat extends CompoundButton {
    public static /* synthetic */ Interceptable $ic = null;
    public static final String ACCESSIBILITY_EVENT_CLASS_NAME = "android.widget.Switch";
    public static final int[] CHECKED_STATE_SET;
    public static final int MONOSPACE = 3;
    public static final int SANS = 1;
    public static final int SERIF = 2;
    public static final int THUMB_ANIMATION_DURATION = 250;
    public static final Property<SwitchCompat, Float> THUMB_POS;
    public static final int TOUCH_MODE_DOWN = 1;
    public static final int TOUCH_MODE_DRAGGING = 2;
    public static final int TOUCH_MODE_IDLE = 0;
    public transient /* synthetic */ FieldHolder $fh;
    public boolean mHasThumbTint;
    public boolean mHasThumbTintMode;
    public boolean mHasTrackTint;
    public boolean mHasTrackTintMode;
    public int mMinFlingVelocity;
    public Layout mOffLayout;
    public Layout mOnLayout;
    public ObjectAnimator mPositionAnimator;
    public boolean mShowText;
    public boolean mSplitTrack;
    public int mSwitchBottom;
    public int mSwitchHeight;
    public int mSwitchLeft;
    public int mSwitchMinWidth;
    public int mSwitchPadding;
    public int mSwitchRight;
    public int mSwitchTop;
    public TransformationMethod mSwitchTransformationMethod;
    public int mSwitchWidth;
    public final Rect mTempRect;
    public ColorStateList mTextColors;
    public final AppCompatTextHelper mTextHelper;
    public CharSequence mTextOff;
    public CharSequence mTextOn;
    public final TextPaint mTextPaint;
    public Drawable mThumbDrawable;
    public float mThumbPosition;
    public int mThumbTextPadding;
    public ColorStateList mThumbTintList;
    public PorterDuff.Mode mThumbTintMode;
    public int mThumbWidth;
    public int mTouchMode;
    public int mTouchSlop;
    public float mTouchX;
    public float mTouchY;
    public Drawable mTrackDrawable;
    public ColorStateList mTrackTintList;
    public PorterDuff.Mode mTrackTintMode;
    public VelocityTracker mVelocityTracker;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-1638903488, "Landroidx/appcompat/widget/SwitchCompat;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-1638903488, "Landroidx/appcompat/widget/SwitchCompat;");
                return;
            }
        }
        THUMB_POS = new Property<SwitchCompat, Float>(Float.class, "thumbPos") { // from class: androidx.appcompat.widget.SwitchCompat.1
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(r8, r9);
                Interceptable interceptable2 = $ic;
                if (interceptable2 != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {r8, r9};
                    interceptable2.invokeUnInit(65536, newInitContext);
                    int i2 = newInitContext.flag;
                    if ((i2 & 1) != 0) {
                        int i3 = i2 & 2;
                        Object[] objArr2 = newInitContext.callArgs;
                        super((Class) objArr2[0], (String) objArr2[1]);
                        newInitContext.thisArg = this;
                        interceptable2.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // android.util.Property
            public Float get(SwitchCompat switchCompat) {
                InterceptResult invokeL;
                Interceptable interceptable2 = $ic;
                return (interceptable2 == null || (invokeL = interceptable2.invokeL(1048576, this, switchCompat)) == null) ? Float.valueOf(switchCompat.mThumbPosition) : (Float) invokeL.objValue;
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // android.util.Property
            public void set(SwitchCompat switchCompat, Float f2) {
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeLL(Constants.METHOD_SEND_USER_MSG, this, switchCompat, f2) == null) {
                    switchCompat.setThumbPosition(f2.floatValue());
                }
            }
        };
        CHECKED_STATE_SET = new int[]{16842912};
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public SwitchCompat(@NonNull Context context) {
        this(context, null);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context};
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                Object[] objArr2 = newInitContext.callArgs;
                this((Context) objArr2[0], (AttributeSet) objArr2[1]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
    }

    private void animateThumbToCheckedState(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(InputDeviceCompat.SOURCE_TRACKBALL, this, z) == null) {
            ObjectAnimator ofFloat = ObjectAnimator.ofFloat(this, THUMB_POS, z ? 1.0f : 0.0f);
            this.mPositionAnimator = ofFloat;
            ofFloat.setDuration(250L);
            if (Build.VERSION.SDK_INT >= 18) {
                this.mPositionAnimator.setAutoCancel(true);
            }
            this.mPositionAnimator.start();
        }
    }

    private void applyThumbTint() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(AdIconUtil.AD_TEXT_ID, this) == null) || this.mThumbDrawable == null) {
            return;
        }
        if (this.mHasThumbTint || this.mHasThumbTintMode) {
            Drawable mutate = DrawableCompat.wrap(this.mThumbDrawable).mutate();
            this.mThumbDrawable = mutate;
            if (this.mHasThumbTint) {
                DrawableCompat.setTintList(mutate, this.mThumbTintList);
            }
            if (this.mHasThumbTintMode) {
                DrawableCompat.setTintMode(this.mThumbDrawable, this.mThumbTintMode);
            }
            if (this.mThumbDrawable.isStateful()) {
                this.mThumbDrawable.setState(getDrawableState());
            }
        }
    }

    private void applyTrackTint() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(AdIconUtil.BAIDU_LOGO_ID, this) == null) || this.mTrackDrawable == null) {
            return;
        }
        if (this.mHasTrackTint || this.mHasTrackTintMode) {
            Drawable mutate = DrawableCompat.wrap(this.mTrackDrawable).mutate();
            this.mTrackDrawable = mutate;
            if (this.mHasTrackTint) {
                DrawableCompat.setTintList(mutate, this.mTrackTintList);
            }
            if (this.mHasTrackTintMode) {
                DrawableCompat.setTintMode(this.mTrackDrawable, this.mTrackTintMode);
            }
            if (this.mTrackDrawable.isStateful()) {
                this.mTrackDrawable.setState(getDrawableState());
            }
        }
    }

    private void cancelPositionAnimator() {
        ObjectAnimator objectAnimator;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(65543, this) == null) || (objectAnimator = this.mPositionAnimator) == null) {
            return;
        }
        objectAnimator.cancel();
    }

    private void cancelSuperTouch(MotionEvent motionEvent) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65544, this, motionEvent) == null) {
            MotionEvent obtain = MotionEvent.obtain(motionEvent);
            obtain.setAction(3);
            super.onTouchEvent(obtain);
            obtain.recycle();
        }
    }

    public static float constrain(float f2, float f3, float f4) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeCommon = interceptable.invokeCommon(65545, null, new Object[]{Float.valueOf(f2), Float.valueOf(f3), Float.valueOf(f4)})) == null) ? f2 < f3 ? f3 : f2 > f4 ? f4 : f2 : invokeCommon.floatValue;
    }

    private boolean getTargetCheckedState() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65546, this)) == null) ? this.mThumbPosition > 0.5f : invokeV.booleanValue;
    }

    private int getThumbOffset() {
        InterceptResult invokeV;
        float f2;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65547, this)) == null) {
            if (ViewUtils.isLayoutRtl(this)) {
                f2 = 1.0f - this.mThumbPosition;
            } else {
                f2 = this.mThumbPosition;
            }
            return (int) ((f2 * getThumbScrollRange()) + 0.5f);
        }
        return invokeV.intValue;
    }

    private int getThumbScrollRange() {
        InterceptResult invokeV;
        Rect rect;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65548, this)) == null) {
            Drawable drawable = this.mTrackDrawable;
            if (drawable != null) {
                Rect rect2 = this.mTempRect;
                drawable.getPadding(rect2);
                Drawable drawable2 = this.mThumbDrawable;
                if (drawable2 != null) {
                    rect = DrawableUtils.getOpticalBounds(drawable2);
                } else {
                    rect = DrawableUtils.INSETS_NONE;
                }
                return ((((this.mSwitchWidth - this.mThumbWidth) - rect2.left) - rect2.right) - rect.left) - rect.right;
            }
            return 0;
        }
        return invokeV.intValue;
    }

    private boolean hitThumb(float f2, float f3) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(65549, this, new Object[]{Float.valueOf(f2), Float.valueOf(f3)})) == null) {
            if (this.mThumbDrawable == null) {
                return false;
            }
            int thumbOffset = getThumbOffset();
            this.mThumbDrawable.getPadding(this.mTempRect);
            int i2 = this.mSwitchTop;
            int i3 = this.mTouchSlop;
            int i4 = i2 - i3;
            int i5 = (this.mSwitchLeft + thumbOffset) - i3;
            Rect rect = this.mTempRect;
            return f2 > ((float) i5) && f2 < ((float) ((((this.mThumbWidth + i5) + rect.left) + rect.right) + i3)) && f3 > ((float) i4) && f3 < ((float) (this.mSwitchBottom + i3));
        }
        return invokeCommon.booleanValue;
    }

    private Layout makeLayout(CharSequence charSequence) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65550, this, charSequence)) == null) {
            TransformationMethod transformationMethod = this.mSwitchTransformationMethod;
            if (transformationMethod != null) {
                charSequence = transformationMethod.getTransformation(charSequence, this);
            }
            CharSequence charSequence2 = charSequence;
            TextPaint textPaint = this.mTextPaint;
            return new StaticLayout(charSequence2, textPaint, charSequence2 != null ? (int) Math.ceil(Layout.getDesiredWidth(charSequence2, textPaint)) : 0, Layout.Alignment.ALIGN_NORMAL, 1.0f, 0.0f, true);
        }
        return (Layout) invokeL.objValue;
    }

    private void setSwitchTypefaceByIndex(int i2, int i3) {
        Typeface typeface;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeII(65551, this, i2, i3) == null) {
            if (i2 == 1) {
                typeface = Typeface.SANS_SERIF;
            } else if (i2 != 2) {
                typeface = i2 != 3 ? null : Typeface.MONOSPACE;
            } else {
                typeface = Typeface.SERIF;
            }
            setSwitchTypeface(typeface, i3);
        }
    }

    private void stopDrag(MotionEvent motionEvent) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65552, this, motionEvent) == null) {
            this.mTouchMode = 0;
            boolean z = true;
            boolean z2 = motionEvent.getAction() == 1 && isEnabled();
            boolean isChecked = isChecked();
            if (z2) {
                this.mVelocityTracker.computeCurrentVelocity(1000);
                float xVelocity = this.mVelocityTracker.getXVelocity();
                if (Math.abs(xVelocity) > this.mMinFlingVelocity) {
                    if (!ViewUtils.isLayoutRtl(this) ? xVelocity <= 0.0f : xVelocity >= 0.0f) {
                        z = false;
                    }
                } else {
                    z = getTargetCheckedState();
                }
            } else {
                z = isChecked;
            }
            if (z != isChecked) {
                playSoundEffect(0);
            }
            setChecked(z);
            cancelSuperTouch(motionEvent);
        }
    }

    @Override // android.view.View
    public void draw(Canvas canvas) {
        Rect rect;
        int i2;
        int i3;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, canvas) == null) {
            Rect rect2 = this.mTempRect;
            int i4 = this.mSwitchLeft;
            int i5 = this.mSwitchTop;
            int i6 = this.mSwitchRight;
            int i7 = this.mSwitchBottom;
            int thumbOffset = getThumbOffset() + i4;
            Drawable drawable = this.mThumbDrawable;
            if (drawable != null) {
                rect = DrawableUtils.getOpticalBounds(drawable);
            } else {
                rect = DrawableUtils.INSETS_NONE;
            }
            Drawable drawable2 = this.mTrackDrawable;
            if (drawable2 != null) {
                drawable2.getPadding(rect2);
                int i8 = rect2.left;
                thumbOffset += i8;
                if (rect != null) {
                    int i9 = rect.left;
                    if (i9 > i8) {
                        i4 += i9 - i8;
                    }
                    int i10 = rect.top;
                    int i11 = rect2.top;
                    i2 = i10 > i11 ? (i10 - i11) + i5 : i5;
                    int i12 = rect.right;
                    int i13 = rect2.right;
                    if (i12 > i13) {
                        i6 -= i12 - i13;
                    }
                    int i14 = rect.bottom;
                    int i15 = rect2.bottom;
                    if (i14 > i15) {
                        i3 = i7 - (i14 - i15);
                        this.mTrackDrawable.setBounds(i4, i2, i6, i3);
                    }
                } else {
                    i2 = i5;
                }
                i3 = i7;
                this.mTrackDrawable.setBounds(i4, i2, i6, i3);
            }
            Drawable drawable3 = this.mThumbDrawable;
            if (drawable3 != null) {
                drawable3.getPadding(rect2);
                int i16 = thumbOffset - rect2.left;
                int i17 = thumbOffset + this.mThumbWidth + rect2.right;
                this.mThumbDrawable.setBounds(i16, i5, i17, i7);
                Drawable background = getBackground();
                if (background != null) {
                    DrawableCompat.setHotspotBounds(background, i16, i5, i17, i7);
                }
            }
            super.draw(canvas);
        }
    }

    @Override // android.widget.CompoundButton, android.widget.TextView, android.view.View
    public void drawableHotspotChanged(float f2, float f3) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, new Object[]{Float.valueOf(f2), Float.valueOf(f3)}) == null) {
            if (Build.VERSION.SDK_INT >= 21) {
                super.drawableHotspotChanged(f2, f3);
            }
            Drawable drawable = this.mThumbDrawable;
            if (drawable != null) {
                DrawableCompat.setHotspot(drawable, f2, f3);
            }
            Drawable drawable2 = this.mTrackDrawable;
            if (drawable2 != null) {
                DrawableCompat.setHotspot(drawable2, f2, f3);
            }
        }
    }

    @Override // android.widget.CompoundButton, android.widget.TextView, android.view.View
    public void drawableStateChanged() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            super.drawableStateChanged();
            int[] drawableState = getDrawableState();
            Drawable drawable = this.mThumbDrawable;
            boolean z = false;
            if (drawable != null && drawable.isStateful()) {
                z = false | drawable.setState(drawableState);
            }
            Drawable drawable2 = this.mTrackDrawable;
            if (drawable2 != null && drawable2.isStateful()) {
                z |= drawable2.setState(drawableState);
            }
            if (z) {
                invalidate();
            }
        }
    }

    @Override // android.widget.CompoundButton, android.widget.TextView
    public int getCompoundPaddingLeft() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
            if (!ViewUtils.isLayoutRtl(this)) {
                return super.getCompoundPaddingLeft();
            }
            int compoundPaddingLeft = super.getCompoundPaddingLeft() + this.mSwitchWidth;
            return !TextUtils.isEmpty(getText()) ? compoundPaddingLeft + this.mSwitchPadding : compoundPaddingLeft;
        }
        return invokeV.intValue;
    }

    @Override // android.widget.CompoundButton, android.widget.TextView
    public int getCompoundPaddingRight() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
            if (ViewUtils.isLayoutRtl(this)) {
                return super.getCompoundPaddingRight();
            }
            int compoundPaddingRight = super.getCompoundPaddingRight() + this.mSwitchWidth;
            return !TextUtils.isEmpty(getText()) ? compoundPaddingRight + this.mSwitchPadding : compoundPaddingRight;
        }
        return invokeV.intValue;
    }

    public boolean getShowText() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) ? this.mShowText : invokeV.booleanValue;
    }

    public boolean getSplitTrack() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) ? this.mSplitTrack : invokeV.booleanValue;
    }

    public int getSwitchMinWidth() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) ? this.mSwitchMinWidth : invokeV.intValue;
    }

    public int getSwitchPadding() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) ? this.mSwitchPadding : invokeV.intValue;
    }

    public CharSequence getTextOff() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048585, this)) == null) ? this.mTextOff : (CharSequence) invokeV.objValue;
    }

    public CharSequence getTextOn() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048586, this)) == null) ? this.mTextOn : (CharSequence) invokeV.objValue;
    }

    public Drawable getThumbDrawable() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048587, this)) == null) ? this.mThumbDrawable : (Drawable) invokeV.objValue;
    }

    public int getThumbTextPadding() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048588, this)) == null) ? this.mThumbTextPadding : invokeV.intValue;
    }

    @Nullable
    public ColorStateList getThumbTintList() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048589, this)) == null) ? this.mThumbTintList : (ColorStateList) invokeV.objValue;
    }

    @Nullable
    public PorterDuff.Mode getThumbTintMode() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048590, this)) == null) ? this.mThumbTintMode : (PorterDuff.Mode) invokeV.objValue;
    }

    public Drawable getTrackDrawable() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048591, this)) == null) ? this.mTrackDrawable : (Drawable) invokeV.objValue;
    }

    @Nullable
    public ColorStateList getTrackTintList() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048592, this)) == null) ? this.mTrackTintList : (ColorStateList) invokeV.objValue;
    }

    @Nullable
    public PorterDuff.Mode getTrackTintMode() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048593, this)) == null) ? this.mTrackTintMode : (PorterDuff.Mode) invokeV.objValue;
    }

    @Override // android.widget.CompoundButton, android.widget.TextView, android.view.View
    public void jumpDrawablesToCurrentState() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048594, this) == null) {
            super.jumpDrawablesToCurrentState();
            Drawable drawable = this.mThumbDrawable;
            if (drawable != null) {
                drawable.jumpToCurrentState();
            }
            Drawable drawable2 = this.mTrackDrawable;
            if (drawable2 != null) {
                drawable2.jumpToCurrentState();
            }
            ObjectAnimator objectAnimator = this.mPositionAnimator;
            if (objectAnimator == null || !objectAnimator.isStarted()) {
                return;
            }
            this.mPositionAnimator.end();
            this.mPositionAnimator = null;
        }
    }

    @Override // android.widget.CompoundButton, android.widget.TextView, android.view.View
    public int[] onCreateDrawableState(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048595, this, i2)) == null) {
            int[] onCreateDrawableState = super.onCreateDrawableState(i2 + 1);
            if (isChecked()) {
                CompoundButton.mergeDrawableStates(onCreateDrawableState, CHECKED_STATE_SET);
            }
            return onCreateDrawableState;
        }
        return (int[]) invokeI.objValue;
    }

    @Override // android.widget.CompoundButton, android.widget.TextView, android.view.View
    public void onDraw(Canvas canvas) {
        int width;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048596, this, canvas) == null) {
            super.onDraw(canvas);
            Rect rect = this.mTempRect;
            Drawable drawable = this.mTrackDrawable;
            if (drawable != null) {
                drawable.getPadding(rect);
            } else {
                rect.setEmpty();
            }
            int i2 = this.mSwitchTop;
            int i3 = this.mSwitchBottom;
            int i4 = i2 + rect.top;
            int i5 = i3 - rect.bottom;
            Drawable drawable2 = this.mThumbDrawable;
            if (drawable != null) {
                if (this.mSplitTrack && drawable2 != null) {
                    Rect opticalBounds = DrawableUtils.getOpticalBounds(drawable2);
                    drawable2.copyBounds(rect);
                    rect.left += opticalBounds.left;
                    rect.right -= opticalBounds.right;
                    int save = canvas.save();
                    canvas.clipRect(rect, Region.Op.DIFFERENCE);
                    drawable.draw(canvas);
                    canvas.restoreToCount(save);
                } else {
                    drawable.draw(canvas);
                }
            }
            int save2 = canvas.save();
            if (drawable2 != null) {
                drawable2.draw(canvas);
            }
            Layout layout = getTargetCheckedState() ? this.mOnLayout : this.mOffLayout;
            if (layout != null) {
                int[] drawableState = getDrawableState();
                ColorStateList colorStateList = this.mTextColors;
                if (colorStateList != null) {
                    this.mTextPaint.setColor(colorStateList.getColorForState(drawableState, 0));
                }
                this.mTextPaint.drawableState = drawableState;
                if (drawable2 != null) {
                    Rect bounds = drawable2.getBounds();
                    width = bounds.left + bounds.right;
                } else {
                    width = getWidth();
                }
                canvas.translate((width / 2) - (layout.getWidth() / 2), ((i4 + i5) / 2) - (layout.getHeight() / 2));
                layout.draw(canvas);
            }
            canvas.restoreToCount(save2);
        }
    }

    @Override // android.view.View
    public void onInitializeAccessibilityEvent(AccessibilityEvent accessibilityEvent) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048597, this, accessibilityEvent) == null) {
            super.onInitializeAccessibilityEvent(accessibilityEvent);
            accessibilityEvent.setClassName(ACCESSIBILITY_EVENT_CLASS_NAME);
        }
    }

    @Override // android.view.View
    public void onInitializeAccessibilityNodeInfo(AccessibilityNodeInfo accessibilityNodeInfo) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048598, this, accessibilityNodeInfo) == null) {
            super.onInitializeAccessibilityNodeInfo(accessibilityNodeInfo);
            accessibilityNodeInfo.setClassName(ACCESSIBILITY_EVENT_CLASS_NAME);
            CharSequence charSequence = isChecked() ? this.mTextOn : this.mTextOff;
            if (TextUtils.isEmpty(charSequence)) {
                return;
            }
            CharSequence text = accessibilityNodeInfo.getText();
            if (TextUtils.isEmpty(text)) {
                accessibilityNodeInfo.setText(charSequence);
                return;
            }
            StringBuilder sb = new StringBuilder();
            sb.append(text);
            sb.append(' ');
            sb.append(charSequence);
            accessibilityNodeInfo.setText(sb);
        }
    }

    @Override // android.widget.TextView, android.view.View
    public void onLayout(boolean z, int i2, int i3, int i4, int i5) {
        int i6;
        int width;
        int i7;
        int i8;
        int paddingTop;
        int i9;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048599, this, new Object[]{Boolean.valueOf(z), Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(i4), Integer.valueOf(i5)}) == null) {
            super.onLayout(z, i2, i3, i4, i5);
            int i10 = 0;
            if (this.mThumbDrawable != null) {
                Rect rect = this.mTempRect;
                Drawable drawable = this.mTrackDrawable;
                if (drawable != null) {
                    drawable.getPadding(rect);
                } else {
                    rect.setEmpty();
                }
                Rect opticalBounds = DrawableUtils.getOpticalBounds(this.mThumbDrawable);
                i6 = Math.max(0, opticalBounds.left - rect.left);
                i10 = Math.max(0, opticalBounds.right - rect.right);
            } else {
                i6 = 0;
            }
            if (ViewUtils.isLayoutRtl(this)) {
                i7 = getPaddingLeft() + i6;
                width = ((this.mSwitchWidth + i7) - i6) - i10;
            } else {
                width = (getWidth() - getPaddingRight()) - i10;
                i7 = (width - this.mSwitchWidth) + i6 + i10;
            }
            int gravity = getGravity() & 112;
            if (gravity == 16) {
                i8 = this.mSwitchHeight;
                paddingTop = (((getPaddingTop() + getHeight()) - getPaddingBottom()) / 2) - (i8 / 2);
            } else if (gravity != 80) {
                paddingTop = getPaddingTop();
                i8 = this.mSwitchHeight;
            } else {
                i9 = getHeight() - getPaddingBottom();
                paddingTop = i9 - this.mSwitchHeight;
                this.mSwitchLeft = i7;
                this.mSwitchTop = paddingTop;
                this.mSwitchBottom = i9;
                this.mSwitchRight = width;
            }
            i9 = i8 + paddingTop;
            this.mSwitchLeft = i7;
            this.mSwitchTop = paddingTop;
            this.mSwitchBottom = i9;
            this.mSwitchRight = width;
        }
    }

    @Override // android.widget.TextView, android.view.View
    public void onMeasure(int i2, int i3) {
        int i4;
        int i5;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeII(1048600, this, i2, i3) == null) {
            if (this.mShowText) {
                if (this.mOnLayout == null) {
                    this.mOnLayout = makeLayout(this.mTextOn);
                }
                if (this.mOffLayout == null) {
                    this.mOffLayout = makeLayout(this.mTextOff);
                }
            }
            Rect rect = this.mTempRect;
            Drawable drawable = this.mThumbDrawable;
            int i6 = 0;
            if (drawable != null) {
                drawable.getPadding(rect);
                i4 = (this.mThumbDrawable.getIntrinsicWidth() - rect.left) - rect.right;
                i5 = this.mThumbDrawable.getIntrinsicHeight();
            } else {
                i4 = 0;
                i5 = 0;
            }
            this.mThumbWidth = Math.max(this.mShowText ? Math.max(this.mOnLayout.getWidth(), this.mOffLayout.getWidth()) + (this.mThumbTextPadding * 2) : 0, i4);
            Drawable drawable2 = this.mTrackDrawable;
            if (drawable2 != null) {
                drawable2.getPadding(rect);
                i6 = this.mTrackDrawable.getIntrinsicHeight();
            } else {
                rect.setEmpty();
            }
            int i7 = rect.left;
            int i8 = rect.right;
            Drawable drawable3 = this.mThumbDrawable;
            if (drawable3 != null) {
                Rect opticalBounds = DrawableUtils.getOpticalBounds(drawable3);
                i7 = Math.max(i7, opticalBounds.left);
                i8 = Math.max(i8, opticalBounds.right);
            }
            int max = Math.max(this.mSwitchMinWidth, (this.mThumbWidth * 2) + i7 + i8);
            int max2 = Math.max(i6, i5);
            this.mSwitchWidth = max;
            this.mSwitchHeight = max2;
            super.onMeasure(i2, i3);
            if (getMeasuredHeight() < max2) {
                setMeasuredDimension(getMeasuredWidthAndState(), max2);
            }
        }
    }

    @Override // android.view.View
    public void onPopulateAccessibilityEvent(AccessibilityEvent accessibilityEvent) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048601, this, accessibilityEvent) == null) {
            super.onPopulateAccessibilityEvent(accessibilityEvent);
            CharSequence charSequence = isChecked() ? this.mTextOn : this.mTextOff;
            if (charSequence != null) {
                accessibilityEvent.getText().add(charSequence);
            }
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:10:0x0016, code lost:
        if (r0 != 3) goto L10;
     */
    @Override // android.widget.TextView, android.view.View
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public boolean onTouchEvent(MotionEvent motionEvent) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048602, this, motionEvent)) == null) {
            this.mVelocityTracker.addMovement(motionEvent);
            int actionMasked = motionEvent.getActionMasked();
            if (actionMasked != 0) {
                if (actionMasked != 1) {
                    if (actionMasked == 2) {
                        int i2 = this.mTouchMode;
                        if (i2 == 1) {
                            float x = motionEvent.getX();
                            float y = motionEvent.getY();
                            if (Math.abs(x - this.mTouchX) > this.mTouchSlop || Math.abs(y - this.mTouchY) > this.mTouchSlop) {
                                this.mTouchMode = 2;
                                getParent().requestDisallowInterceptTouchEvent(true);
                                this.mTouchX = x;
                                this.mTouchY = y;
                                return true;
                            }
                        } else if (i2 == 2) {
                            float x2 = motionEvent.getX();
                            int thumbScrollRange = getThumbScrollRange();
                            float f2 = x2 - this.mTouchX;
                            float f3 = thumbScrollRange != 0 ? f2 / thumbScrollRange : f2 > 0.0f ? 1.0f : -1.0f;
                            if (ViewUtils.isLayoutRtl(this)) {
                                f3 = -f3;
                            }
                            float constrain = constrain(this.mThumbPosition + f3, 0.0f, 1.0f);
                            if (constrain != this.mThumbPosition) {
                                this.mTouchX = x2;
                                setThumbPosition(constrain);
                            }
                            return true;
                        }
                    }
                }
                if (this.mTouchMode == 2) {
                    stopDrag(motionEvent);
                    super.onTouchEvent(motionEvent);
                    return true;
                }
                this.mTouchMode = 0;
                this.mVelocityTracker.clear();
            } else {
                float x3 = motionEvent.getX();
                float y2 = motionEvent.getY();
                if (isEnabled() && hitThumb(x3, y2)) {
                    this.mTouchMode = 1;
                    this.mTouchX = x3;
                    this.mTouchY = y2;
                }
            }
            return super.onTouchEvent(motionEvent);
        }
        return invokeL.booleanValue;
    }

    @Override // android.widget.CompoundButton, android.widget.Checkable
    public void setChecked(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048603, this, z) == null) {
            super.setChecked(z);
            boolean isChecked = isChecked();
            if (getWindowToken() != null && ViewCompat.isLaidOut(this)) {
                animateThumbToCheckedState(isChecked);
                return;
            }
            cancelPositionAnimator();
            setThumbPosition(isChecked ? 1.0f : 0.0f);
        }
    }

    @Override // android.widget.TextView
    public void setCustomSelectionActionModeCallback(ActionMode.Callback callback) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048604, this, callback) == null) {
            super.setCustomSelectionActionModeCallback(TextViewCompat.wrapCustomSelectionActionModeCallback(this, callback));
        }
    }

    public void setShowText(boolean z) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeZ(1048605, this, z) == null) || this.mShowText == z) {
            return;
        }
        this.mShowText = z;
        requestLayout();
    }

    public void setSplitTrack(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048606, this, z) == null) {
            this.mSplitTrack = z;
            invalidate();
        }
    }

    public void setSwitchMinWidth(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048607, this, i2) == null) {
            this.mSwitchMinWidth = i2;
            requestLayout();
        }
    }

    public void setSwitchPadding(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048608, this, i2) == null) {
            this.mSwitchPadding = i2;
            requestLayout();
        }
    }

    public void setSwitchTextAppearance(Context context, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLI(1048609, this, context, i2) == null) {
            TintTypedArray obtainStyledAttributes = TintTypedArray.obtainStyledAttributes(context, i2, R.styleable.TextAppearance);
            ColorStateList colorStateList = obtainStyledAttributes.getColorStateList(R.styleable.TextAppearance_android_textColor);
            if (colorStateList != null) {
                this.mTextColors = colorStateList;
            } else {
                this.mTextColors = getTextColors();
            }
            int dimensionPixelSize = obtainStyledAttributes.getDimensionPixelSize(R.styleable.TextAppearance_android_textSize, 0);
            if (dimensionPixelSize != 0) {
                float f2 = dimensionPixelSize;
                if (f2 != this.mTextPaint.getTextSize()) {
                    this.mTextPaint.setTextSize(f2);
                    requestLayout();
                }
            }
            setSwitchTypefaceByIndex(obtainStyledAttributes.getInt(R.styleable.TextAppearance_android_typeface, -1), obtainStyledAttributes.getInt(R.styleable.TextAppearance_android_textStyle, -1));
            if (obtainStyledAttributes.getBoolean(R.styleable.TextAppearance_textAllCaps, false)) {
                this.mSwitchTransformationMethod = new AllCapsTransformationMethod(getContext());
            } else {
                this.mSwitchTransformationMethod = null;
            }
            obtainStyledAttributes.recycle();
        }
    }

    public void setSwitchTypeface(Typeface typeface, int i2) {
        Typeface create;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLI(1048611, this, typeface, i2) == null) {
            if (i2 > 0) {
                if (typeface == null) {
                    create = Typeface.defaultFromStyle(i2);
                } else {
                    create = Typeface.create(typeface, i2);
                }
                setSwitchTypeface(create);
                int i3 = (~(create != null ? create.getStyle() : 0)) & i2;
                this.mTextPaint.setFakeBoldText((i3 & 1) != 0);
                this.mTextPaint.setTextSkewX((i3 & 2) != 0 ? -0.25f : 0.0f);
                return;
            }
            this.mTextPaint.setFakeBoldText(false);
            this.mTextPaint.setTextSkewX(0.0f);
            setSwitchTypeface(typeface);
        }
    }

    public void setTextOff(CharSequence charSequence) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048612, this, charSequence) == null) {
            this.mTextOff = charSequence;
            requestLayout();
        }
    }

    public void setTextOn(CharSequence charSequence) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048613, this, charSequence) == null) {
            this.mTextOn = charSequence;
            requestLayout();
        }
    }

    public void setThumbDrawable(Drawable drawable) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048614, this, drawable) == null) {
            Drawable drawable2 = this.mThumbDrawable;
            if (drawable2 != null) {
                drawable2.setCallback(null);
            }
            this.mThumbDrawable = drawable;
            if (drawable != null) {
                drawable.setCallback(this);
            }
            requestLayout();
        }
    }

    public void setThumbPosition(float f2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeF(1048615, this, f2) == null) {
            this.mThumbPosition = f2;
            invalidate();
        }
    }

    public void setThumbResource(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048616, this, i2) == null) {
            setThumbDrawable(AppCompatResources.getDrawable(getContext(), i2));
        }
    }

    public void setThumbTextPadding(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048617, this, i2) == null) {
            this.mThumbTextPadding = i2;
            requestLayout();
        }
    }

    public void setThumbTintList(@Nullable ColorStateList colorStateList) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048618, this, colorStateList) == null) {
            this.mThumbTintList = colorStateList;
            this.mHasThumbTint = true;
            applyThumbTint();
        }
    }

    public void setThumbTintMode(@Nullable PorterDuff.Mode mode) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048619, this, mode) == null) {
            this.mThumbTintMode = mode;
            this.mHasThumbTintMode = true;
            applyThumbTint();
        }
    }

    public void setTrackDrawable(Drawable drawable) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048620, this, drawable) == null) {
            Drawable drawable2 = this.mTrackDrawable;
            if (drawable2 != null) {
                drawable2.setCallback(null);
            }
            this.mTrackDrawable = drawable;
            if (drawable != null) {
                drawable.setCallback(this);
            }
            requestLayout();
        }
    }

    public void setTrackResource(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048621, this, i2) == null) {
            setTrackDrawable(AppCompatResources.getDrawable(getContext(), i2));
        }
    }

    public void setTrackTintList(@Nullable ColorStateList colorStateList) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048622, this, colorStateList) == null) {
            this.mTrackTintList = colorStateList;
            this.mHasTrackTint = true;
            applyTrackTint();
        }
    }

    public void setTrackTintMode(@Nullable PorterDuff.Mode mode) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048623, this, mode) == null) {
            this.mTrackTintMode = mode;
            this.mHasTrackTintMode = true;
            applyTrackTint();
        }
    }

    @Override // android.widget.CompoundButton, android.widget.Checkable
    public void toggle() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048624, this) == null) {
            setChecked(!isChecked());
        }
    }

    @Override // android.widget.CompoundButton, android.widget.TextView, android.view.View
    public boolean verifyDrawable(Drawable drawable) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(1048625, this, drawable)) == null) ? super.verifyDrawable(drawable) || drawable == this.mThumbDrawable || drawable == this.mTrackDrawable : invokeL.booleanValue;
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public SwitchCompat(@NonNull Context context, @Nullable AttributeSet attributeSet) {
        this(context, attributeSet, R.attr.switchStyle);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context, attributeSet};
            interceptable.invokeUnInit(65538, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                Object[] objArr2 = newInitContext.callArgs;
                this((Context) objArr2[0], (AttributeSet) objArr2[1], ((Integer) objArr2[2]).intValue());
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65538, newInitContext);
                return;
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public SwitchCompat(@NonNull Context context, @Nullable AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context, attributeSet, Integer.valueOf(i2)};
            interceptable.invokeUnInit(65539, newInitContext);
            int i3 = newInitContext.flag;
            if ((i3 & 1) != 0) {
                int i4 = i3 & 2;
                Object[] objArr2 = newInitContext.callArgs;
                super((Context) objArr2[0], (AttributeSet) objArr2[1], ((Integer) objArr2[2]).intValue());
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65539, newInitContext);
                return;
            }
        }
        this.mThumbTintList = null;
        this.mThumbTintMode = null;
        this.mHasThumbTint = false;
        this.mHasThumbTintMode = false;
        this.mTrackTintList = null;
        this.mTrackTintMode = null;
        this.mHasTrackTint = false;
        this.mHasTrackTintMode = false;
        this.mVelocityTracker = VelocityTracker.obtain();
        this.mTempRect = new Rect();
        ThemeUtils.checkAppCompatTheme(this, getContext());
        this.mTextPaint = new TextPaint(1);
        this.mTextPaint.density = getResources().getDisplayMetrics().density;
        TintTypedArray obtainStyledAttributes = TintTypedArray.obtainStyledAttributes(context, attributeSet, R.styleable.SwitchCompat, i2, 0);
        ViewCompat.saveAttributeDataForStyleable(this, context, R.styleable.SwitchCompat, attributeSet, obtainStyledAttributes.getWrappedTypeArray(), i2, 0);
        Drawable drawable = obtainStyledAttributes.getDrawable(R.styleable.SwitchCompat_android_thumb);
        this.mThumbDrawable = drawable;
        if (drawable != null) {
            drawable.setCallback(this);
        }
        Drawable drawable2 = obtainStyledAttributes.getDrawable(R.styleable.SwitchCompat_track);
        this.mTrackDrawable = drawable2;
        if (drawable2 != null) {
            drawable2.setCallback(this);
        }
        this.mTextOn = obtainStyledAttributes.getText(R.styleable.SwitchCompat_android_textOn);
        this.mTextOff = obtainStyledAttributes.getText(R.styleable.SwitchCompat_android_textOff);
        this.mShowText = obtainStyledAttributes.getBoolean(R.styleable.SwitchCompat_showText, true);
        this.mThumbTextPadding = obtainStyledAttributes.getDimensionPixelSize(R.styleable.SwitchCompat_thumbTextPadding, 0);
        this.mSwitchMinWidth = obtainStyledAttributes.getDimensionPixelSize(R.styleable.SwitchCompat_switchMinWidth, 0);
        this.mSwitchPadding = obtainStyledAttributes.getDimensionPixelSize(R.styleable.SwitchCompat_switchPadding, 0);
        this.mSplitTrack = obtainStyledAttributes.getBoolean(R.styleable.SwitchCompat_splitTrack, false);
        ColorStateList colorStateList = obtainStyledAttributes.getColorStateList(R.styleable.SwitchCompat_thumbTint);
        if (colorStateList != null) {
            this.mThumbTintList = colorStateList;
            this.mHasThumbTint = true;
        }
        PorterDuff.Mode parseTintMode = DrawableUtils.parseTintMode(obtainStyledAttributes.getInt(R.styleable.SwitchCompat_thumbTintMode, -1), null);
        if (this.mThumbTintMode != parseTintMode) {
            this.mThumbTintMode = parseTintMode;
            this.mHasThumbTintMode = true;
        }
        if (this.mHasThumbTint || this.mHasThumbTintMode) {
            applyThumbTint();
        }
        ColorStateList colorStateList2 = obtainStyledAttributes.getColorStateList(R.styleable.SwitchCompat_trackTint);
        if (colorStateList2 != null) {
            this.mTrackTintList = colorStateList2;
            this.mHasTrackTint = true;
        }
        PorterDuff.Mode parseTintMode2 = DrawableUtils.parseTintMode(obtainStyledAttributes.getInt(R.styleable.SwitchCompat_trackTintMode, -1), null);
        if (this.mTrackTintMode != parseTintMode2) {
            this.mTrackTintMode = parseTintMode2;
            this.mHasTrackTintMode = true;
        }
        if (this.mHasTrackTint || this.mHasTrackTintMode) {
            applyTrackTint();
        }
        int resourceId = obtainStyledAttributes.getResourceId(R.styleable.SwitchCompat_switchTextAppearance, 0);
        if (resourceId != 0) {
            setSwitchTextAppearance(context, resourceId);
        }
        AppCompatTextHelper appCompatTextHelper = new AppCompatTextHelper(this);
        this.mTextHelper = appCompatTextHelper;
        appCompatTextHelper.loadFromAttributes(attributeSet, i2);
        obtainStyledAttributes.recycle();
        ViewConfiguration viewConfiguration = ViewConfiguration.get(context);
        this.mTouchSlop = viewConfiguration.getScaledTouchSlop();
        this.mMinFlingVelocity = viewConfiguration.getScaledMinimumFlingVelocity();
        refreshDrawableState();
        setChecked(isChecked());
    }

    public void setSwitchTypeface(Typeface typeface) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048610, this, typeface) == null) {
            if ((this.mTextPaint.getTypeface() == null || this.mTextPaint.getTypeface().equals(typeface)) && (this.mTextPaint.getTypeface() != null || typeface == null)) {
                return;
            }
            this.mTextPaint.setTypeface(typeface);
            requestLayout();
            invalidate();
        }
    }
}
