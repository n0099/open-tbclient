package androidx.appcompat.widget;

import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.graphics.PorterDuff;
import android.graphics.Typeface;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.os.LocaleList;
import android.text.method.PasswordTransformationMethod;
import android.util.AttributeSet;
import android.widget.TextView;
import androidx.appcompat.R;
import androidx.core.content.res.ResourcesCompat;
import androidx.core.view.InputDeviceCompat;
import androidx.core.view.ViewCompat;
import androidx.core.widget.AutoSizeableTextView;
import androidx.core.widget.TextViewCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.lang.ref.WeakReference;
import java.util.Locale;
/* loaded from: classes.dex */
public class AppCompatTextHelper {
    public static /* synthetic */ Interceptable $ic = null;
    public static final int MONOSPACE = 3;
    public static final int SANS = 1;
    public static final int SERIF = 2;
    public static final int TEXT_FONT_WEIGHT_UNSPECIFIED = -1;
    public transient /* synthetic */ FieldHolder $fh;
    public boolean mAsyncFontPending;
    public final AppCompatTextViewAutoSizeHelper mAutoSizeTextHelper;
    public TintInfo mDrawableBottomTint;
    public TintInfo mDrawableEndTint;
    public TintInfo mDrawableLeftTint;
    public TintInfo mDrawableRightTint;
    public TintInfo mDrawableStartTint;
    public TintInfo mDrawableTint;
    public TintInfo mDrawableTopTint;
    public Typeface mFontTypeface;
    public int mFontWeight;
    public int mStyle;
    public final TextView mView;

    public AppCompatTextHelper(TextView textView) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {textView};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.mStyle = 0;
        this.mFontWeight = -1;
        this.mView = textView;
        this.mAutoSizeTextHelper = new AppCompatTextViewAutoSizeHelper(this.mView);
    }

    private void applyCompoundDrawableTint(Drawable drawable, TintInfo tintInfo) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLL(65537, this, drawable, tintInfo) == null) && drawable != null && tintInfo != null) {
            AppCompatDrawableManager.tintDrawable(drawable, tintInfo, this.mView.getDrawableState());
        }
    }

    private void setTextSizeInternal(int i, float f) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(65541, this, new Object[]{Integer.valueOf(i), Float.valueOf(f)}) == null) {
            this.mAutoSizeTextHelper.setTextSizeInternal(i, f);
        }
    }

    public void onAsyncTypefaceReceived(WeakReference<TextView> weakReference, Typeface typeface) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLL(1048587, this, weakReference, typeface) == null) && this.mAsyncFontPending) {
            this.mFontTypeface = typeface;
            TextView textView = weakReference.get();
            if (textView != null) {
                textView.setTypeface(typeface, this.mStyle);
            }
        }
    }

    public void setAutoSizeTextTypeUniformWithPresetSizes(int[] iArr, int i) throws IllegalArgumentException {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLI(1048593, this, iArr, i) == null) {
            this.mAutoSizeTextHelper.setAutoSizeTextTypeUniformWithPresetSizes(iArr, i);
        }
    }

    public void setTextSize(int i, float f) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeCommon(1048597, this, new Object[]{Integer.valueOf(i), Float.valueOf(f)}) == null) && !AutoSizeableTextView.PLATFORM_SUPPORTS_AUTOSIZE && !isAutoSizeEnabled()) {
            setTextSizeInternal(i, f);
        }
    }

    public static TintInfo createTintInfo(Context context, AppCompatDrawableManager appCompatDrawableManager, int i) {
        InterceptResult invokeLLI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLI = interceptable.invokeLLI(65538, null, context, appCompatDrawableManager, i)) == null) {
            ColorStateList tintList = appCompatDrawableManager.getTintList(context, i);
            if (tintList != null) {
                TintInfo tintInfo = new TintInfo();
                tintInfo.mHasTintList = true;
                tintInfo.mTintList = tintList;
                return tintInfo;
            }
            return null;
        }
        return (TintInfo) invokeLLI.objValue;
    }

    private void setCompoundDrawables(Drawable drawable, Drawable drawable2, Drawable drawable3, Drawable drawable4, Drawable drawable5, Drawable drawable6) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(65539, this, new Object[]{drawable, drawable2, drawable3, drawable4, drawable5, drawable6}) == null) {
            if (Build.VERSION.SDK_INT >= 17 && (drawable5 != null || drawable6 != null)) {
                Drawable[] compoundDrawablesRelative = this.mView.getCompoundDrawablesRelative();
                TextView textView = this.mView;
                if (drawable5 == null) {
                    drawable5 = compoundDrawablesRelative[0];
                }
                if (drawable2 == null) {
                    drawable2 = compoundDrawablesRelative[1];
                }
                if (drawable6 == null) {
                    drawable6 = compoundDrawablesRelative[2];
                }
                if (drawable4 == null) {
                    drawable4 = compoundDrawablesRelative[3];
                }
                textView.setCompoundDrawablesRelativeWithIntrinsicBounds(drawable5, drawable2, drawable6, drawable4);
            } else if (drawable != null || drawable2 != null || drawable3 != null || drawable4 != null) {
                if (Build.VERSION.SDK_INT >= 17) {
                    Drawable[] compoundDrawablesRelative2 = this.mView.getCompoundDrawablesRelative();
                    if (compoundDrawablesRelative2[0] != null || compoundDrawablesRelative2[2] != null) {
                        TextView textView2 = this.mView;
                        Drawable drawable7 = compoundDrawablesRelative2[0];
                        if (drawable2 == null) {
                            drawable2 = compoundDrawablesRelative2[1];
                        }
                        Drawable drawable8 = compoundDrawablesRelative2[2];
                        if (drawable4 == null) {
                            drawable4 = compoundDrawablesRelative2[3];
                        }
                        textView2.setCompoundDrawablesRelativeWithIntrinsicBounds(drawable7, drawable2, drawable8, drawable4);
                        return;
                    }
                }
                Drawable[] compoundDrawables = this.mView.getCompoundDrawables();
                TextView textView3 = this.mView;
                if (drawable == null) {
                    drawable = compoundDrawables[0];
                }
                if (drawable2 == null) {
                    drawable2 = compoundDrawables[1];
                }
                if (drawable3 == null) {
                    drawable3 = compoundDrawables[2];
                }
                if (drawable4 == null) {
                    drawable4 = compoundDrawables[3];
                }
                textView3.setCompoundDrawablesWithIntrinsicBounds(drawable, drawable2, drawable3, drawable4);
            }
        }
    }

    private void setCompoundTints() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(InputDeviceCompat.SOURCE_TRACKBALL, this) == null) {
            TintInfo tintInfo = this.mDrawableTint;
            this.mDrawableLeftTint = tintInfo;
            this.mDrawableTopTint = tintInfo;
            this.mDrawableRightTint = tintInfo;
            this.mDrawableBottomTint = tintInfo;
            this.mDrawableStartTint = tintInfo;
            this.mDrawableEndTint = tintInfo;
        }
    }

    public void autoSizeText() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            this.mAutoSizeTextHelper.autoSizeText();
        }
    }

    public int getAutoSizeMaxTextSize() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            return this.mAutoSizeTextHelper.getAutoSizeMaxTextSize();
        }
        return invokeV.intValue;
    }

    public int getAutoSizeMinTextSize() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
            return this.mAutoSizeTextHelper.getAutoSizeMinTextSize();
        }
        return invokeV.intValue;
    }

    public int getAutoSizeStepGranularity() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
            return this.mAutoSizeTextHelper.getAutoSizeStepGranularity();
        }
        return invokeV.intValue;
    }

    public int[] getAutoSizeTextAvailableSizes() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) {
            return this.mAutoSizeTextHelper.getAutoSizeTextAvailableSizes();
        }
        return (int[]) invokeV.objValue;
    }

    public int getAutoSizeTextType() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) {
            return this.mAutoSizeTextHelper.getAutoSizeTextType();
        }
        return invokeV.intValue;
    }

    public ColorStateList getCompoundDrawableTintList() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) {
            TintInfo tintInfo = this.mDrawableTint;
            if (tintInfo != null) {
                return tintInfo.mTintList;
            }
            return null;
        }
        return (ColorStateList) invokeV.objValue;
    }

    public PorterDuff.Mode getCompoundDrawableTintMode() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) {
            TintInfo tintInfo = this.mDrawableTint;
            if (tintInfo != null) {
                return tintInfo.mTintMode;
            }
            return null;
        }
        return (PorterDuff.Mode) invokeV.objValue;
    }

    public boolean isAutoSizeEnabled() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048585, this)) == null) {
            return this.mAutoSizeTextHelper.isAutoSizeEnabled();
        }
        return invokeV.booleanValue;
    }

    public void onSetCompoundDrawables() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048589, this) == null) {
            applyCompoundDrawablesTints();
        }
    }

    private void updateTypefaceAndStyle(Context context, TintTypedArray tintTypedArray) {
        String string;
        boolean z;
        boolean z2;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65542, this, context, tintTypedArray) == null) {
            this.mStyle = tintTypedArray.getInt(2, this.mStyle);
            boolean z3 = false;
            if (Build.VERSION.SDK_INT >= 28) {
                int i = tintTypedArray.getInt(11, -1);
                this.mFontWeight = i;
                if (i != -1) {
                    this.mStyle = (this.mStyle & 2) | 0;
                }
            }
            int i2 = 10;
            if (!tintTypedArray.hasValue(10) && !tintTypedArray.hasValue(12)) {
                if (tintTypedArray.hasValue(1)) {
                    this.mAsyncFontPending = false;
                    int i3 = tintTypedArray.getInt(1, 1);
                    if (i3 != 1) {
                        if (i3 != 2) {
                            if (i3 == 3) {
                                this.mFontTypeface = Typeface.MONOSPACE;
                                return;
                            }
                            return;
                        }
                        this.mFontTypeface = Typeface.SERIF;
                        return;
                    }
                    this.mFontTypeface = Typeface.SANS_SERIF;
                    return;
                }
                return;
            }
            this.mFontTypeface = null;
            if (tintTypedArray.hasValue(12)) {
                i2 = 12;
            }
            int i4 = this.mFontWeight;
            int i5 = this.mStyle;
            if (!context.isRestricted()) {
                try {
                    Typeface font = tintTypedArray.getFont(i2, this.mStyle, new ResourcesCompat.FontCallback(this, i4, i5, new WeakReference(this.mView)) { // from class: androidx.appcompat.widget.AppCompatTextHelper.1
                        public static /* synthetic */ Interceptable $ic;
                        public transient /* synthetic */ FieldHolder $fh;
                        public final /* synthetic */ AppCompatTextHelper this$0;
                        public final /* synthetic */ int val$fontWeight;
                        public final /* synthetic */ int val$style;
                        public final /* synthetic */ WeakReference val$textViewWeak;

                        @Override // androidx.core.content.res.ResourcesCompat.FontCallback
                        public void onFontRetrievalFailed(int i6) {
                            Interceptable interceptable2 = $ic;
                            if (interceptable2 == null || interceptable2.invokeI(1048576, this, i6) == null) {
                            }
                        }

                        {
                            Interceptable interceptable2 = $ic;
                            if (interceptable2 != null) {
                                InitContext newInitContext = TitanRuntime.newInitContext();
                                newInitContext.initArgs = r2;
                                Object[] objArr = {this, Integer.valueOf(i4), Integer.valueOf(i5), r9};
                                interceptable2.invokeUnInit(65536, newInitContext);
                                int i6 = newInitContext.flag;
                                if ((i6 & 1) != 0) {
                                    int i7 = i6 & 2;
                                    newInitContext.thisArg = this;
                                    interceptable2.invokeInitBody(65536, newInitContext);
                                    return;
                                }
                            }
                            this.this$0 = this;
                            this.val$fontWeight = i4;
                            this.val$style = i5;
                            this.val$textViewWeak = r9;
                        }

                        @Override // androidx.core.content.res.ResourcesCompat.FontCallback
                        public void onFontRetrieved(Typeface typeface) {
                            int i6;
                            boolean z4;
                            Interceptable interceptable2 = $ic;
                            if (interceptable2 == null || interceptable2.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, typeface) == null) {
                                if (Build.VERSION.SDK_INT >= 28 && (i6 = this.val$fontWeight) != -1) {
                                    if ((this.val$style & 2) != 0) {
                                        z4 = true;
                                    } else {
                                        z4 = false;
                                    }
                                    typeface = Typeface.create(typeface, i6, z4);
                                }
                                this.this$0.onAsyncTypefaceReceived(this.val$textViewWeak, typeface);
                            }
                        }
                    });
                    if (font != null) {
                        if (Build.VERSION.SDK_INT >= 28 && this.mFontWeight != -1) {
                            Typeface create = Typeface.create(font, 0);
                            int i6 = this.mFontWeight;
                            if ((this.mStyle & 2) != 0) {
                                z2 = true;
                            } else {
                                z2 = false;
                            }
                            this.mFontTypeface = Typeface.create(create, i6, z2);
                        } else {
                            this.mFontTypeface = font;
                        }
                    }
                    if (this.mFontTypeface == null) {
                        z = true;
                    } else {
                        z = false;
                    }
                    this.mAsyncFontPending = z;
                } catch (Resources.NotFoundException | UnsupportedOperationException unused) {
                }
            }
            if (this.mFontTypeface == null && (string = tintTypedArray.getString(i2)) != null) {
                if (Build.VERSION.SDK_INT >= 28 && this.mFontWeight != -1) {
                    Typeface create2 = Typeface.create(string, 0);
                    int i7 = this.mFontWeight;
                    if ((this.mStyle & 2) != 0) {
                        z3 = true;
                    }
                    this.mFontTypeface = Typeface.create(create2, i7, z3);
                    return;
                }
                this.mFontTypeface = Typeface.create(string, this.mStyle);
            }
        }
    }

    public void applyCompoundDrawablesTints() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            if (this.mDrawableLeftTint != null || this.mDrawableTopTint != null || this.mDrawableRightTint != null || this.mDrawableBottomTint != null) {
                Drawable[] compoundDrawables = this.mView.getCompoundDrawables();
                applyCompoundDrawableTint(compoundDrawables[0], this.mDrawableLeftTint);
                applyCompoundDrawableTint(compoundDrawables[1], this.mDrawableTopTint);
                applyCompoundDrawableTint(compoundDrawables[2], this.mDrawableRightTint);
                applyCompoundDrawableTint(compoundDrawables[3], this.mDrawableBottomTint);
            }
            if (Build.VERSION.SDK_INT >= 17) {
                if (this.mDrawableStartTint != null || this.mDrawableEndTint != null) {
                    Drawable[] compoundDrawablesRelative = this.mView.getCompoundDrawablesRelative();
                    applyCompoundDrawableTint(compoundDrawablesRelative[0], this.mDrawableStartTint);
                    applyCompoundDrawableTint(compoundDrawablesRelative[2], this.mDrawableEndTint);
                }
            }
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:49:0x0101  */
    /* JADX WARN: Removed duplicated region for block: B:50:0x0106  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void loadFromAttributes(AttributeSet attributeSet, int i) {
        boolean z;
        ColorStateList colorStateList;
        String str;
        boolean z2;
        ColorStateList colorStateList2;
        ColorStateList colorStateList3;
        String str2;
        boolean z3;
        int i2;
        Drawable drawable;
        Drawable drawable2;
        int i3;
        Drawable drawable3;
        Drawable drawable4;
        Drawable drawable5;
        Drawable drawable6;
        int i4;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLI(1048586, this, attributeSet, i) == null) {
            Context context = this.mView.getContext();
            AppCompatDrawableManager appCompatDrawableManager = AppCompatDrawableManager.get();
            TintTypedArray obtainStyledAttributes = TintTypedArray.obtainStyledAttributes(context, attributeSet, R.styleable.AppCompatTextHelper, i, 0);
            TextView textView = this.mView;
            ViewCompat.saveAttributeDataForStyleable(textView, textView.getContext(), R.styleable.AppCompatTextHelper, attributeSet, obtainStyledAttributes.getWrappedTypeArray(), i, 0);
            int resourceId = obtainStyledAttributes.getResourceId(0, -1);
            if (obtainStyledAttributes.hasValue(3)) {
                this.mDrawableLeftTint = createTintInfo(context, appCompatDrawableManager, obtainStyledAttributes.getResourceId(3, 0));
            }
            if (obtainStyledAttributes.hasValue(1)) {
                this.mDrawableTopTint = createTintInfo(context, appCompatDrawableManager, obtainStyledAttributes.getResourceId(1, 0));
            }
            if (obtainStyledAttributes.hasValue(4)) {
                this.mDrawableRightTint = createTintInfo(context, appCompatDrawableManager, obtainStyledAttributes.getResourceId(4, 0));
            }
            if (obtainStyledAttributes.hasValue(2)) {
                this.mDrawableBottomTint = createTintInfo(context, appCompatDrawableManager, obtainStyledAttributes.getResourceId(2, 0));
            }
            if (Build.VERSION.SDK_INT >= 17) {
                if (obtainStyledAttributes.hasValue(5)) {
                    this.mDrawableStartTint = createTintInfo(context, appCompatDrawableManager, obtainStyledAttributes.getResourceId(5, 0));
                }
                if (obtainStyledAttributes.hasValue(6)) {
                    this.mDrawableEndTint = createTintInfo(context, appCompatDrawableManager, obtainStyledAttributes.getResourceId(6, 0));
                }
            }
            obtainStyledAttributes.recycle();
            boolean z4 = this.mView.getTransformationMethod() instanceof PasswordTransformationMethod;
            if (resourceId != -1) {
                TintTypedArray obtainStyledAttributes2 = TintTypedArray.obtainStyledAttributes(context, resourceId, R.styleable.TextAppearance);
                if (!z4 && obtainStyledAttributes2.hasValue(14)) {
                    z = obtainStyledAttributes2.getBoolean(14, false);
                    z2 = true;
                } else {
                    z = false;
                    z2 = false;
                }
                updateTypefaceAndStyle(context, obtainStyledAttributes2);
                if (Build.VERSION.SDK_INT < 23) {
                    if (obtainStyledAttributes2.hasValue(3)) {
                        colorStateList = obtainStyledAttributes2.getColorStateList(3);
                    } else {
                        colorStateList = null;
                    }
                    if (obtainStyledAttributes2.hasValue(4)) {
                        colorStateList2 = obtainStyledAttributes2.getColorStateList(4);
                    } else {
                        colorStateList2 = null;
                    }
                    if (obtainStyledAttributes2.hasValue(5)) {
                        colorStateList3 = obtainStyledAttributes2.getColorStateList(5);
                        if (!obtainStyledAttributes2.hasValue(15)) {
                            str2 = obtainStyledAttributes2.getString(15);
                        } else {
                            str2 = null;
                        }
                        if (Build.VERSION.SDK_INT < 26 && obtainStyledAttributes2.hasValue(13)) {
                            str = obtainStyledAttributes2.getString(13);
                        } else {
                            str = null;
                        }
                        obtainStyledAttributes2.recycle();
                    }
                } else {
                    colorStateList = null;
                    colorStateList2 = null;
                }
                colorStateList3 = null;
                if (!obtainStyledAttributes2.hasValue(15)) {
                }
                if (Build.VERSION.SDK_INT < 26) {
                }
                str = null;
                obtainStyledAttributes2.recycle();
            } else {
                z = false;
                colorStateList = null;
                str = null;
                z2 = false;
                colorStateList2 = null;
                colorStateList3 = null;
                str2 = null;
            }
            TintTypedArray obtainStyledAttributes3 = TintTypedArray.obtainStyledAttributes(context, attributeSet, R.styleable.TextAppearance, i, 0);
            if (!z4 && obtainStyledAttributes3.hasValue(14)) {
                z = obtainStyledAttributes3.getBoolean(14, false);
                z3 = true;
            } else {
                z3 = z2;
            }
            if (Build.VERSION.SDK_INT < 23) {
                if (obtainStyledAttributes3.hasValue(3)) {
                    colorStateList = obtainStyledAttributes3.getColorStateList(3);
                }
                if (obtainStyledAttributes3.hasValue(4)) {
                    colorStateList2 = obtainStyledAttributes3.getColorStateList(4);
                }
                if (obtainStyledAttributes3.hasValue(5)) {
                    colorStateList3 = obtainStyledAttributes3.getColorStateList(5);
                }
            }
            ColorStateList colorStateList4 = colorStateList2;
            ColorStateList colorStateList5 = colorStateList3;
            if (obtainStyledAttributes3.hasValue(15)) {
                str2 = obtainStyledAttributes3.getString(15);
            }
            String str3 = str2;
            if (Build.VERSION.SDK_INT >= 26 && obtainStyledAttributes3.hasValue(13)) {
                str = obtainStyledAttributes3.getString(13);
            }
            if (Build.VERSION.SDK_INT >= 28 && obtainStyledAttributes3.hasValue(0) && obtainStyledAttributes3.getDimensionPixelSize(0, -1) == 0) {
                this.mView.setTextSize(0, 0.0f);
            }
            updateTypefaceAndStyle(context, obtainStyledAttributes3);
            obtainStyledAttributes3.recycle();
            if (colorStateList != null) {
                this.mView.setTextColor(colorStateList);
            }
            if (colorStateList4 != null) {
                this.mView.setHintTextColor(colorStateList4);
            }
            if (colorStateList5 != null) {
                this.mView.setLinkTextColor(colorStateList5);
            }
            if (!z4 && z3) {
                setAllCaps(z);
            }
            Typeface typeface = this.mFontTypeface;
            if (typeface != null) {
                if (this.mFontWeight == -1) {
                    this.mView.setTypeface(typeface, this.mStyle);
                } else {
                    this.mView.setTypeface(typeface);
                }
            }
            if (str != null) {
                this.mView.setFontVariationSettings(str);
            }
            if (str3 != null) {
                int i5 = Build.VERSION.SDK_INT;
                if (i5 >= 24) {
                    this.mView.setTextLocales(LocaleList.forLanguageTags(str3));
                } else if (i5 >= 21) {
                    this.mView.setTextLocale(Locale.forLanguageTag(str3.substring(0, str3.indexOf(44))));
                }
            }
            this.mAutoSizeTextHelper.loadFromAttributes(attributeSet, i);
            if (AutoSizeableTextView.PLATFORM_SUPPORTS_AUTOSIZE && this.mAutoSizeTextHelper.getAutoSizeTextType() != 0) {
                int[] autoSizeTextAvailableSizes = this.mAutoSizeTextHelper.getAutoSizeTextAvailableSizes();
                if (autoSizeTextAvailableSizes.length > 0) {
                    if (this.mView.getAutoSizeStepGranularity() != -1.0f) {
                        this.mView.setAutoSizeTextTypeUniformWithConfiguration(this.mAutoSizeTextHelper.getAutoSizeMinTextSize(), this.mAutoSizeTextHelper.getAutoSizeMaxTextSize(), this.mAutoSizeTextHelper.getAutoSizeStepGranularity(), 0);
                    } else {
                        this.mView.setAutoSizeTextTypeUniformWithPresetSizes(autoSizeTextAvailableSizes, 0);
                    }
                }
            }
            TintTypedArray obtainStyledAttributes4 = TintTypedArray.obtainStyledAttributes(context, attributeSet, R.styleable.AppCompatTextView);
            int resourceId2 = obtainStyledAttributes4.getResourceId(8, -1);
            if (resourceId2 != -1) {
                drawable = appCompatDrawableManager.getDrawable(context, resourceId2);
                i2 = 13;
            } else {
                i2 = 13;
                drawable = null;
            }
            int resourceId3 = obtainStyledAttributes4.getResourceId(i2, -1);
            if (resourceId3 != -1) {
                drawable2 = appCompatDrawableManager.getDrawable(context, resourceId3);
            } else {
                drawable2 = null;
            }
            int resourceId4 = obtainStyledAttributes4.getResourceId(9, -1);
            if (resourceId4 != -1) {
                drawable3 = appCompatDrawableManager.getDrawable(context, resourceId4);
                i3 = 6;
            } else {
                i3 = 6;
                drawable3 = null;
            }
            int resourceId5 = obtainStyledAttributes4.getResourceId(i3, -1);
            if (resourceId5 != -1) {
                drawable4 = appCompatDrawableManager.getDrawable(context, resourceId5);
            } else {
                drawable4 = null;
            }
            int resourceId6 = obtainStyledAttributes4.getResourceId(10, -1);
            if (resourceId6 != -1) {
                drawable5 = appCompatDrawableManager.getDrawable(context, resourceId6);
            } else {
                drawable5 = null;
            }
            int resourceId7 = obtainStyledAttributes4.getResourceId(7, -1);
            if (resourceId7 != -1) {
                drawable6 = appCompatDrawableManager.getDrawable(context, resourceId7);
            } else {
                drawable6 = null;
            }
            setCompoundDrawables(drawable, drawable2, drawable3, drawable4, drawable5, drawable6);
            if (obtainStyledAttributes4.hasValue(11)) {
                TextViewCompat.setCompoundDrawableTintList(this.mView, obtainStyledAttributes4.getColorStateList(11));
            }
            if (obtainStyledAttributes4.hasValue(12)) {
                i4 = -1;
                TextViewCompat.setCompoundDrawableTintMode(this.mView, DrawableUtils.parseTintMode(obtainStyledAttributes4.getInt(12, -1), null));
            } else {
                i4 = -1;
            }
            int dimensionPixelSize = obtainStyledAttributes4.getDimensionPixelSize(14, i4);
            int dimensionPixelSize2 = obtainStyledAttributes4.getDimensionPixelSize(17, i4);
            int dimensionPixelSize3 = obtainStyledAttributes4.getDimensionPixelSize(18, i4);
            obtainStyledAttributes4.recycle();
            if (dimensionPixelSize != i4) {
                TextViewCompat.setFirstBaselineToTopHeight(this.mView, dimensionPixelSize);
            }
            if (dimensionPixelSize2 != i4) {
                TextViewCompat.setLastBaselineToBottomHeight(this.mView, dimensionPixelSize2);
            }
            if (dimensionPixelSize3 != i4) {
                TextViewCompat.setLineHeight(this.mView, dimensionPixelSize3);
            }
        }
    }

    public void onLayout(boolean z, int i, int i2, int i3, int i4) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeCommon(1048588, this, new Object[]{Boolean.valueOf(z), Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(i4)}) == null) && !AutoSizeableTextView.PLATFORM_SUPPORTS_AUTOSIZE) {
            autoSizeText();
        }
    }

    public void onSetTextAppearance(Context context, int i) {
        String string;
        ColorStateList colorStateList;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLI(1048590, this, context, i) == null) {
            TintTypedArray obtainStyledAttributes = TintTypedArray.obtainStyledAttributes(context, i, R.styleable.TextAppearance);
            if (obtainStyledAttributes.hasValue(14)) {
                setAllCaps(obtainStyledAttributes.getBoolean(14, false));
            }
            if (Build.VERSION.SDK_INT < 23 && obtainStyledAttributes.hasValue(3) && (colorStateList = obtainStyledAttributes.getColorStateList(3)) != null) {
                this.mView.setTextColor(colorStateList);
            }
            if (obtainStyledAttributes.hasValue(0) && obtainStyledAttributes.getDimensionPixelSize(0, -1) == 0) {
                this.mView.setTextSize(0, 0.0f);
            }
            updateTypefaceAndStyle(context, obtainStyledAttributes);
            if (Build.VERSION.SDK_INT >= 26 && obtainStyledAttributes.hasValue(13) && (string = obtainStyledAttributes.getString(13)) != null) {
                this.mView.setFontVariationSettings(string);
            }
            obtainStyledAttributes.recycle();
            Typeface typeface = this.mFontTypeface;
            if (typeface != null) {
                this.mView.setTypeface(typeface, this.mStyle);
            }
        }
    }

    public void setAllCaps(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048591, this, z) == null) {
            this.mView.setAllCaps(z);
        }
    }

    public void setAutoSizeTextTypeWithDefaults(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048594, this, i) == null) {
            this.mAutoSizeTextHelper.setAutoSizeTextTypeWithDefaults(i);
        }
    }

    public void setCompoundDrawableTintList(ColorStateList colorStateList) {
        boolean z;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048595, this, colorStateList) == null) {
            if (this.mDrawableTint == null) {
                this.mDrawableTint = new TintInfo();
            }
            TintInfo tintInfo = this.mDrawableTint;
            tintInfo.mTintList = colorStateList;
            if (colorStateList != null) {
                z = true;
            } else {
                z = false;
            }
            tintInfo.mHasTintList = z;
            setCompoundTints();
        }
    }

    public void setCompoundDrawableTintMode(PorterDuff.Mode mode) {
        boolean z;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048596, this, mode) == null) {
            if (this.mDrawableTint == null) {
                this.mDrawableTint = new TintInfo();
            }
            TintInfo tintInfo = this.mDrawableTint;
            tintInfo.mTintMode = mode;
            if (mode != null) {
                z = true;
            } else {
                z = false;
            }
            tintInfo.mHasTintMode = z;
            setCompoundTints();
        }
    }

    public void setAutoSizeTextTypeUniformWithConfiguration(int i, int i2, int i3, int i4) throws IllegalArgumentException {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIIII(1048592, this, i, i2, i3, i4) == null) {
            this.mAutoSizeTextHelper.setAutoSizeTextTypeUniformWithConfiguration(i, i2, i3, i4);
        }
    }
}
