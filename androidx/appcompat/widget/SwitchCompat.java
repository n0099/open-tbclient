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
import androidx.appcompat.content.res.AppCompatResources;
import androidx.appcompat.text.AllCapsTransformationMethod;
import androidx.core.graphics.drawable.DrawableCompat;
import androidx.core.view.InputDeviceCompat;
import androidx.core.view.ViewCompat;
import androidx.core.widget.TextViewCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tieba.R;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.google.android.exoplayer2.text.webvtt.WebvttCueParser;
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

    public static float constrain(float f, float f2, float f3) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeCommon = interceptable.invokeCommon(65545, null, new Object[]{Float.valueOf(f), Float.valueOf(f2), Float.valueOf(f3)})) == null) ? f < f2 ? f2 : f > f3 ? f3 : f : invokeCommon.floatValue;
    }

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
                    int i = newInitContext.flag;
                    if ((i & 1) != 0) {
                        int i2 = i & 2;
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
                if (interceptable2 == null || (invokeL = interceptable2.invokeL(1048576, this, switchCompat)) == null) {
                    return Float.valueOf(switchCompat.mThumbPosition);
                }
                return (Float) invokeL.objValue;
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // android.util.Property
            public void set(SwitchCompat switchCompat, Float f) {
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeLL(Constants.METHOD_SEND_USER_MSG, this, switchCompat, f) == null) {
                    switchCompat.setThumbPosition(f.floatValue());
                }
            }
        };
        CHECKED_STATE_SET = new int[]{16842912};
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
            if (objectAnimator != null && objectAnimator.isStarted()) {
                this.mPositionAnimator.end();
                this.mPositionAnimator = null;
            }
        }
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
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                Object[] objArr2 = newInitContext.callArgs;
                this((Context) objArr2[0], (AttributeSet) objArr2[1]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
    }

    private void animateThumbToCheckedState(boolean z) {
        float f;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(InputDeviceCompat.SOURCE_TRACKBALL, this, z) == null) {
            if (z) {
                f = 1.0f;
            } else {
                f = 0.0f;
            }
            ObjectAnimator ofFloat = ObjectAnimator.ofFloat(this, THUMB_POS, f);
            this.mPositionAnimator = ofFloat;
            ofFloat.setDuration(250L);
            if (Build.VERSION.SDK_INT >= 18) {
                this.mPositionAnimator.setAutoCancel(true);
            }
            this.mPositionAnimator.start();
        }
    }

    private Layout makeLayout(CharSequence charSequence) {
        InterceptResult invokeL;
        int i;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65550, this, charSequence)) == null) {
            TransformationMethod transformationMethod = this.mSwitchTransformationMethod;
            if (transformationMethod != null) {
                charSequence = transformationMethod.getTransformation(charSequence, this);
            }
            CharSequence charSequence2 = charSequence;
            TextPaint textPaint = this.mTextPaint;
            if (charSequence2 != null) {
                i = (int) Math.ceil(Layout.getDesiredWidth(charSequence2, textPaint));
            } else {
                i = 0;
            }
            return new StaticLayout(charSequence2, textPaint, i, Layout.Alignment.ALIGN_NORMAL, 1.0f, 0.0f, true);
        }
        return (Layout) invokeL.objValue;
    }

    @Override // android.widget.CompoundButton, android.widget.Checkable
    public void setChecked(boolean z) {
        float f;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048603, this, z) == null) {
            super.setChecked(z);
            boolean isChecked = isChecked();
            if (getWindowToken() != null && ViewCompat.isLaidOut(this)) {
                animateThumbToCheckedState(isChecked);
                return;
            }
            cancelPositionAnimator();
            if (isChecked) {
                f = 1.0f;
            } else {
                f = 0.0f;
            }
            setThumbPosition(f);
        }
    }

    public void setSwitchTypeface(Typeface typeface) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048610, this, typeface) == null) {
            if ((this.mTextPaint.getTypeface() != null && !this.mTextPaint.getTypeface().equals(typeface)) || (this.mTextPaint.getTypeface() == null && typeface != null)) {
                this.mTextPaint.setTypeface(typeface);
                requestLayout();
                invalidate();
            }
        }
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public SwitchCompat(@NonNull Context context, @Nullable AttributeSet attributeSet) {
        this(context, attributeSet, R.attr.obfuscated_res_0x7f04067c);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context, attributeSet};
            interceptable.invokeUnInit(65538, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                Object[] objArr2 = newInitContext.callArgs;
                this((Context) objArr2[0], (AttributeSet) objArr2[1], ((Integer) objArr2[2]).intValue());
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65538, newInitContext);
                return;
            }
        }
    }

    private boolean hitThumb(float f, float f2) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(65549, this, new Object[]{Float.valueOf(f), Float.valueOf(f2)})) == null) {
            if (this.mThumbDrawable == null) {
                return false;
            }
            int thumbOffset = getThumbOffset();
            this.mThumbDrawable.getPadding(this.mTempRect);
            int i = this.mSwitchTop;
            int i2 = this.mTouchSlop;
            int i3 = i - i2;
            int i4 = (this.mSwitchLeft + thumbOffset) - i2;
            Rect rect = this.mTempRect;
            int i5 = this.mThumbWidth + i4 + rect.left + rect.right + i2;
            int i6 = this.mSwitchBottom + i2;
            if (f <= i4 || f >= i5 || f2 <= i3 || f2 >= i6) {
                return false;
            }
            return true;
        }
        return invokeCommon.booleanValue;
    }

    public void setSwitchTypeface(Typeface typeface, int i) {
        Typeface create;
        int i2;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLI(1048611, this, typeface, i) == null) {
            float f = 0.0f;
            boolean z = false;
            if (i > 0) {
                if (typeface == null) {
                    create = Typeface.defaultFromStyle(i);
                } else {
                    create = Typeface.create(typeface, i);
                }
                setSwitchTypeface(create);
                if (create != null) {
                    i2 = create.getStyle();
                } else {
                    i2 = 0;
                }
                int i3 = (~i2) & i;
                TextPaint textPaint = this.mTextPaint;
                if ((i3 & 1) != 0) {
                    z = true;
                }
                textPaint.setFakeBoldText(z);
                TextPaint textPaint2 = this.mTextPaint;
                if ((i3 & 2) != 0) {
                    f = -0.25f;
                }
                textPaint2.setTextSkewX(f);
                return;
            }
            this.mTextPaint.setFakeBoldText(false);
            this.mTextPaint.setTextSkewX(0.0f);
            setSwitchTypeface(typeface);
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public SwitchCompat(@NonNull Context context, @Nullable AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context, attributeSet, Integer.valueOf(i)};
            interceptable.invokeUnInit(65539, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
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
        TintTypedArray obtainStyledAttributes = TintTypedArray.obtainStyledAttributes(context, attributeSet, androidx.appcompat.R.styleable.SwitchCompat, i, 0);
        ViewCompat.saveAttributeDataForStyleable(this, context, androidx.appcompat.R.styleable.SwitchCompat, attributeSet, obtainStyledAttributes.getWrappedTypeArray(), i, 0);
        Drawable drawable = obtainStyledAttributes.getDrawable(2);
        this.mThumbDrawable = drawable;
        if (drawable != null) {
            drawable.setCallback(this);
        }
        Drawable drawable2 = obtainStyledAttributes.getDrawable(11);
        this.mTrackDrawable = drawable2;
        if (drawable2 != null) {
            drawable2.setCallback(this);
        }
        this.mTextOn = obtainStyledAttributes.getText(0);
        this.mTextOff = obtainStyledAttributes.getText(1);
        this.mShowText = obtainStyledAttributes.getBoolean(3, true);
        this.mThumbTextPadding = obtainStyledAttributes.getDimensionPixelSize(8, 0);
        this.mSwitchMinWidth = obtainStyledAttributes.getDimensionPixelSize(5, 0);
        this.mSwitchPadding = obtainStyledAttributes.getDimensionPixelSize(6, 0);
        this.mSplitTrack = obtainStyledAttributes.getBoolean(4, false);
        ColorStateList colorStateList = obtainStyledAttributes.getColorStateList(9);
        if (colorStateList != null) {
            this.mThumbTintList = colorStateList;
            this.mHasThumbTint = true;
        }
        PorterDuff.Mode parseTintMode = DrawableUtils.parseTintMode(obtainStyledAttributes.getInt(10, -1), null);
        if (this.mThumbTintMode != parseTintMode) {
            this.mThumbTintMode = parseTintMode;
            this.mHasThumbTintMode = true;
        }
        if (this.mHasThumbTint || this.mHasThumbTintMode) {
            applyThumbTint();
        }
        ColorStateList colorStateList2 = obtainStyledAttributes.getColorStateList(12);
        if (colorStateList2 != null) {
            this.mTrackTintList = colorStateList2;
            this.mHasTrackTint = true;
        }
        PorterDuff.Mode parseTintMode2 = DrawableUtils.parseTintMode(obtainStyledAttributes.getInt(13, -1), null);
        if (this.mTrackTintMode != parseTintMode2) {
            this.mTrackTintMode = parseTintMode2;
            this.mHasTrackTintMode = true;
        }
        if (this.mHasTrackTint || this.mHasTrackTintMode) {
            applyTrackTint();
        }
        int resourceId = obtainStyledAttributes.getResourceId(7, 0);
        if (resourceId != 0) {
            setSwitchTextAppearance(context, resourceId);
        }
        AppCompatTextHelper appCompatTextHelper = new AppCompatTextHelper(this);
        this.mTextHelper = appCompatTextHelper;
        appCompatTextHelper.loadFromAttributes(attributeSet, i);
        obtainStyledAttributes.recycle();
        ViewConfiguration viewConfiguration = ViewConfiguration.get(context);
        this.mTouchSlop = viewConfiguration.getScaledTouchSlop();
        this.mMinFlingVelocity = viewConfiguration.getScaledMinimumFlingVelocity();
        refreshDrawableState();
        setChecked(isChecked());
    }

    private void applyThumbTint() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(65541, this) == null) && this.mThumbDrawable != null) {
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
    }

    private void applyTrackTint() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(65542, this) == null) && this.mTrackDrawable != null) {
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
    }

    private void cancelPositionAnimator() {
        ObjectAnimator objectAnimator;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(65543, this) == null) && (objectAnimator = this.mPositionAnimator) != null) {
            objectAnimator.cancel();
        }
    }

    private boolean getTargetCheckedState() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65546, this)) == null) {
            if (this.mThumbPosition > 0.5f) {
                return true;
            }
            return false;
        }
        return invokeV.booleanValue;
    }

    private int getThumbOffset() {
        InterceptResult invokeV;
        float f;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65547, this)) == null) {
            if (ViewUtils.isLayoutRtl(this)) {
                f = 1.0f - this.mThumbPosition;
            } else {
                f = this.mThumbPosition;
            }
            return (int) ((f * getThumbScrollRange()) + 0.5f);
        }
        return invokeV.intValue;
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
            if (!TextUtils.isEmpty(getText())) {
                return compoundPaddingLeft + this.mSwitchPadding;
            }
            return compoundPaddingLeft;
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
            if (!TextUtils.isEmpty(getText())) {
                return compoundPaddingRight + this.mSwitchPadding;
            }
            return compoundPaddingRight;
        }
        return invokeV.intValue;
    }

    public boolean getShowText() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) {
            return this.mShowText;
        }
        return invokeV.booleanValue;
    }

    public boolean getSplitTrack() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) {
            return this.mSplitTrack;
        }
        return invokeV.booleanValue;
    }

    public int getSwitchMinWidth() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) {
            return this.mSwitchMinWidth;
        }
        return invokeV.intValue;
    }

    public int getSwitchPadding() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) {
            return this.mSwitchPadding;
        }
        return invokeV.intValue;
    }

    public CharSequence getTextOff() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048585, this)) == null) {
            return this.mTextOff;
        }
        return (CharSequence) invokeV.objValue;
    }

    public CharSequence getTextOn() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048586, this)) == null) {
            return this.mTextOn;
        }
        return (CharSequence) invokeV.objValue;
    }

    public Drawable getThumbDrawable() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048587, this)) == null) {
            return this.mThumbDrawable;
        }
        return (Drawable) invokeV.objValue;
    }

    public int getThumbTextPadding() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048588, this)) == null) {
            return this.mThumbTextPadding;
        }
        return invokeV.intValue;
    }

    @Nullable
    public ColorStateList getThumbTintList() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048589, this)) == null) {
            return this.mThumbTintList;
        }
        return (ColorStateList) invokeV.objValue;
    }

    @Nullable
    public PorterDuff.Mode getThumbTintMode() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048590, this)) == null) {
            return this.mThumbTintMode;
        }
        return (PorterDuff.Mode) invokeV.objValue;
    }

    public Drawable getTrackDrawable() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048591, this)) == null) {
            return this.mTrackDrawable;
        }
        return (Drawable) invokeV.objValue;
    }

    @Nullable
    public ColorStateList getTrackTintList() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048592, this)) == null) {
            return this.mTrackTintList;
        }
        return (ColorStateList) invokeV.objValue;
    }

    @Nullable
    public PorterDuff.Mode getTrackTintMode() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048593, this)) == null) {
            return this.mTrackTintMode;
        }
        return (PorterDuff.Mode) invokeV.objValue;
    }

    @Override // android.widget.CompoundButton, android.widget.Checkable
    public void toggle() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048624, this) == null) {
            setChecked(!isChecked());
        }
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

    @Override // android.widget.CompoundButton, android.widget.TextView, android.view.View
    public int[] onCreateDrawableState(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048595, this, i)) == null) {
            int[] onCreateDrawableState = super.onCreateDrawableState(i + 1);
            if (isChecked()) {
                CompoundButton.mergeDrawableStates(onCreateDrawableState, CHECKED_STATE_SET);
            }
            return onCreateDrawableState;
        }
        return (int[]) invokeI.objValue;
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
    public void onPopulateAccessibilityEvent(AccessibilityEvent accessibilityEvent) {
        CharSequence charSequence;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048601, this, accessibilityEvent) == null) {
            super.onPopulateAccessibilityEvent(accessibilityEvent);
            if (isChecked()) {
                charSequence = this.mTextOn;
            } else {
                charSequence = this.mTextOff;
            }
            if (charSequence != null) {
                accessibilityEvent.getText().add(charSequence);
            }
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
        if ((interceptable == null || interceptable.invokeZ(1048605, this, z) == null) && this.mShowText != z) {
            this.mShowText = z;
            requestLayout();
        }
    }

    public void setSplitTrack(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048606, this, z) == null) {
            this.mSplitTrack = z;
            invalidate();
        }
    }

    public void setSwitchMinWidth(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048607, this, i) == null) {
            this.mSwitchMinWidth = i;
            requestLayout();
        }
    }

    public void setSwitchPadding(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048608, this, i) == null) {
            this.mSwitchPadding = i;
            requestLayout();
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

    public void setThumbPosition(float f) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeF(1048615, this, f) == null) {
            this.mThumbPosition = f;
            invalidate();
        }
    }

    public void setThumbResource(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048616, this, i) == null) {
            setThumbDrawable(AppCompatResources.getDrawable(getContext(), i));
        }
    }

    public void setThumbTextPadding(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048617, this, i) == null) {
            this.mThumbTextPadding = i;
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

    public void setTrackResource(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048621, this, i) == null) {
            setTrackDrawable(AppCompatResources.getDrawable(getContext(), i));
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

    @Override // android.widget.CompoundButton, android.widget.TextView, android.view.View
    public boolean verifyDrawable(Drawable drawable) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048625, this, drawable)) == null) {
            if (!super.verifyDrawable(drawable) && drawable != this.mThumbDrawable && drawable != this.mTrackDrawable) {
                return false;
            }
            return true;
        }
        return invokeL.booleanValue;
    }

    private void setSwitchTypefaceByIndex(int i, int i2) {
        Typeface typeface;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeII(65551, this, i, i2) == null) {
            if (i != 1) {
                if (i != 2) {
                    if (i != 3) {
                        typeface = null;
                    } else {
                        typeface = Typeface.MONOSPACE;
                    }
                } else {
                    typeface = Typeface.SERIF;
                }
            } else {
                typeface = Typeface.SANS_SERIF;
            }
            setSwitchTypeface(typeface, i2);
        }
    }

    private void stopDrag(MotionEvent motionEvent) {
        boolean z;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65552, this, motionEvent) == null) {
            this.mTouchMode = 0;
            boolean z2 = true;
            if (motionEvent.getAction() == 1 && isEnabled()) {
                z = true;
            } else {
                z = false;
            }
            boolean isChecked = isChecked();
            if (z) {
                this.mVelocityTracker.computeCurrentVelocity(1000);
                float xVelocity = this.mVelocityTracker.getXVelocity();
                if (Math.abs(xVelocity) > this.mMinFlingVelocity) {
                    if (!ViewUtils.isLayoutRtl(this) ? xVelocity <= 0.0f : xVelocity >= 0.0f) {
                        z2 = false;
                    }
                } else {
                    z2 = getTargetCheckedState();
                }
            } else {
                z2 = isChecked;
            }
            if (z2 != isChecked) {
                playSoundEffect(0);
            }
            setChecked(z2);
            cancelSuperTouch(motionEvent);
        }
    }

    @Override // android.view.View
    public void draw(Canvas canvas) {
        Rect rect;
        int i;
        int i2;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, canvas) == null) {
            Rect rect2 = this.mTempRect;
            int i3 = this.mSwitchLeft;
            int i4 = this.mSwitchTop;
            int i5 = this.mSwitchRight;
            int i6 = this.mSwitchBottom;
            int thumbOffset = getThumbOffset() + i3;
            Drawable drawable = this.mThumbDrawable;
            if (drawable != null) {
                rect = DrawableUtils.getOpticalBounds(drawable);
            } else {
                rect = DrawableUtils.INSETS_NONE;
            }
            Drawable drawable2 = this.mTrackDrawable;
            if (drawable2 != null) {
                drawable2.getPadding(rect2);
                int i7 = rect2.left;
                thumbOffset += i7;
                if (rect != null) {
                    int i8 = rect.left;
                    if (i8 > i7) {
                        i3 += i8 - i7;
                    }
                    int i9 = rect.top;
                    int i10 = rect2.top;
                    if (i9 > i10) {
                        i = (i9 - i10) + i4;
                    } else {
                        i = i4;
                    }
                    int i11 = rect.right;
                    int i12 = rect2.right;
                    if (i11 > i12) {
                        i5 -= i11 - i12;
                    }
                    int i13 = rect.bottom;
                    int i14 = rect2.bottom;
                    if (i13 > i14) {
                        i2 = i6 - (i13 - i14);
                        this.mTrackDrawable.setBounds(i3, i, i5, i2);
                    }
                } else {
                    i = i4;
                }
                i2 = i6;
                this.mTrackDrawable.setBounds(i3, i, i5, i2);
            }
            Drawable drawable3 = this.mThumbDrawable;
            if (drawable3 != null) {
                drawable3.getPadding(rect2);
                int i15 = thumbOffset - rect2.left;
                int i16 = thumbOffset + this.mThumbWidth + rect2.right;
                this.mThumbDrawable.setBounds(i15, i4, i16, i6);
                Drawable background = getBackground();
                if (background != null) {
                    DrawableCompat.setHotspotBounds(background, i15, i4, i16, i6);
                }
            }
            super.draw(canvas);
        }
    }

    @Override // android.widget.CompoundButton, android.widget.TextView, android.view.View
    public void drawableHotspotChanged(float f, float f2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, new Object[]{Float.valueOf(f), Float.valueOf(f2)}) == null) {
            if (Build.VERSION.SDK_INT >= 21) {
                super.drawableHotspotChanged(f, f2);
            }
            Drawable drawable = this.mThumbDrawable;
            if (drawable != null) {
                DrawableCompat.setHotspot(drawable, f, f2);
            }
            Drawable drawable2 = this.mTrackDrawable;
            if (drawable2 != null) {
                DrawableCompat.setHotspot(drawable2, f, f2);
            }
        }
    }

    @Override // android.widget.CompoundButton, android.widget.TextView, android.view.View
    public void onDraw(Canvas canvas) {
        Layout layout;
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
            int i = this.mSwitchTop;
            int i2 = this.mSwitchBottom;
            int i3 = i + rect.top;
            int i4 = i2 - rect.bottom;
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
            if (getTargetCheckedState()) {
                layout = this.mOnLayout;
            } else {
                layout = this.mOffLayout;
            }
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
                canvas.translate((width / 2) - (layout.getWidth() / 2), ((i3 + i4) / 2) - (layout.getHeight() / 2));
                layout.draw(canvas);
            }
            canvas.restoreToCount(save2);
        }
    }

    @Override // android.view.View
    public void onInitializeAccessibilityNodeInfo(AccessibilityNodeInfo accessibilityNodeInfo) {
        CharSequence charSequence;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048598, this, accessibilityNodeInfo) == null) {
            super.onInitializeAccessibilityNodeInfo(accessibilityNodeInfo);
            accessibilityNodeInfo.setClassName(ACCESSIBILITY_EVENT_CLASS_NAME);
            if (isChecked()) {
                charSequence = this.mTextOn;
            } else {
                charSequence = this.mTextOff;
            }
            if (!TextUtils.isEmpty(charSequence)) {
                CharSequence text = accessibilityNodeInfo.getText();
                if (TextUtils.isEmpty(text)) {
                    accessibilityNodeInfo.setText(charSequence);
                    return;
                }
                StringBuilder sb = new StringBuilder();
                sb.append(text);
                sb.append(WebvttCueParser.CHAR_SPACE);
                sb.append(charSequence);
                accessibilityNodeInfo.setText(sb);
            }
        }
    }

    @Override // android.widget.TextView, android.view.View
    public void onLayout(boolean z, int i, int i2, int i3, int i4) {
        int i5;
        int width;
        int i6;
        int i7;
        int paddingTop;
        int i8;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048599, this, new Object[]{Boolean.valueOf(z), Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(i4)}) == null) {
            super.onLayout(z, i, i2, i3, i4);
            int i9 = 0;
            if (this.mThumbDrawable != null) {
                Rect rect = this.mTempRect;
                Drawable drawable = this.mTrackDrawable;
                if (drawable != null) {
                    drawable.getPadding(rect);
                } else {
                    rect.setEmpty();
                }
                Rect opticalBounds = DrawableUtils.getOpticalBounds(this.mThumbDrawable);
                i5 = Math.max(0, opticalBounds.left - rect.left);
                i9 = Math.max(0, opticalBounds.right - rect.right);
            } else {
                i5 = 0;
            }
            if (ViewUtils.isLayoutRtl(this)) {
                i6 = getPaddingLeft() + i5;
                width = ((this.mSwitchWidth + i6) - i5) - i9;
            } else {
                width = (getWidth() - getPaddingRight()) - i9;
                i6 = (width - this.mSwitchWidth) + i5 + i9;
            }
            int gravity = getGravity() & 112;
            if (gravity != 16) {
                if (gravity != 80) {
                    paddingTop = getPaddingTop();
                    i7 = this.mSwitchHeight;
                } else {
                    i8 = getHeight() - getPaddingBottom();
                    paddingTop = i8 - this.mSwitchHeight;
                    this.mSwitchLeft = i6;
                    this.mSwitchTop = paddingTop;
                    this.mSwitchBottom = i8;
                    this.mSwitchRight = width;
                }
            } else {
                i7 = this.mSwitchHeight;
                paddingTop = (((getPaddingTop() + getHeight()) - getPaddingBottom()) / 2) - (i7 / 2);
            }
            i8 = i7 + paddingTop;
            this.mSwitchLeft = i6;
            this.mSwitchTop = paddingTop;
            this.mSwitchBottom = i8;
            this.mSwitchRight = width;
        }
    }

    @Override // android.widget.TextView, android.view.View
    public void onMeasure(int i, int i2) {
        int i3;
        int i4;
        int i5;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeII(1048600, this, i, i2) == null) {
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
                i3 = (this.mThumbDrawable.getIntrinsicWidth() - rect.left) - rect.right;
                i4 = this.mThumbDrawable.getIntrinsicHeight();
            } else {
                i3 = 0;
                i4 = 0;
            }
            if (this.mShowText) {
                i5 = Math.max(this.mOnLayout.getWidth(), this.mOffLayout.getWidth()) + (this.mThumbTextPadding * 2);
            } else {
                i5 = 0;
            }
            this.mThumbWidth = Math.max(i5, i3);
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
            int max2 = Math.max(i6, i4);
            this.mSwitchWidth = max;
            this.mSwitchHeight = max2;
            super.onMeasure(i, i2);
            if (getMeasuredHeight() < max2) {
                setMeasuredDimension(getMeasuredWidthAndState(), max2);
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
        float f;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048602, this, motionEvent)) == null) {
            this.mVelocityTracker.addMovement(motionEvent);
            int actionMasked = motionEvent.getActionMasked();
            if (actionMasked != 0) {
                if (actionMasked != 1) {
                    if (actionMasked == 2) {
                        int i = this.mTouchMode;
                        if (i != 1) {
                            if (i == 2) {
                                float x = motionEvent.getX();
                                int thumbScrollRange = getThumbScrollRange();
                                float f2 = x - this.mTouchX;
                                if (thumbScrollRange != 0) {
                                    f = f2 / thumbScrollRange;
                                } else if (f2 > 0.0f) {
                                    f = 1.0f;
                                } else {
                                    f = -1.0f;
                                }
                                if (ViewUtils.isLayoutRtl(this)) {
                                    f = -f;
                                }
                                float constrain = constrain(this.mThumbPosition + f, 0.0f, 1.0f);
                                if (constrain != this.mThumbPosition) {
                                    this.mTouchX = x;
                                    setThumbPosition(constrain);
                                }
                                return true;
                            }
                        } else {
                            float x2 = motionEvent.getX();
                            float y = motionEvent.getY();
                            if (Math.abs(x2 - this.mTouchX) > this.mTouchSlop || Math.abs(y - this.mTouchY) > this.mTouchSlop) {
                                this.mTouchMode = 2;
                                getParent().requestDisallowInterceptTouchEvent(true);
                                this.mTouchX = x2;
                                this.mTouchY = y;
                                return true;
                            }
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

    public void setSwitchTextAppearance(Context context, int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLI(1048609, this, context, i) == null) {
            TintTypedArray obtainStyledAttributes = TintTypedArray.obtainStyledAttributes(context, i, androidx.appcompat.R.styleable.TextAppearance);
            ColorStateList colorStateList = obtainStyledAttributes.getColorStateList(3);
            if (colorStateList != null) {
                this.mTextColors = colorStateList;
            } else {
                this.mTextColors = getTextColors();
            }
            int dimensionPixelSize = obtainStyledAttributes.getDimensionPixelSize(0, 0);
            if (dimensionPixelSize != 0) {
                float f = dimensionPixelSize;
                if (f != this.mTextPaint.getTextSize()) {
                    this.mTextPaint.setTextSize(f);
                    requestLayout();
                }
            }
            setSwitchTypefaceByIndex(obtainStyledAttributes.getInt(1, -1), obtainStyledAttributes.getInt(2, -1));
            if (obtainStyledAttributes.getBoolean(14, false)) {
                this.mSwitchTransformationMethod = new AllCapsTransformationMethod(getContext());
            } else {
                this.mSwitchTransformationMethod = null;
            }
            obtainStyledAttributes.recycle();
        }
    }
}
