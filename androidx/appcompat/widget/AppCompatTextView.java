package androidx.appcompat.widget;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.PorterDuff;
import android.graphics.Typeface;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.util.AttributeSet;
import android.view.ActionMode;
import android.view.inputmethod.EditorInfo;
import android.view.inputmethod.InputConnection;
import android.view.textclassifier.TextClassifier;
import android.widget.TextView;
import androidx.annotation.DrawableRes;
import androidx.annotation.IntRange;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.Px;
import androidx.annotation.RequiresApi;
import androidx.annotation.RestrictTo;
import androidx.appcompat.content.res.AppCompatResources;
import androidx.core.graphics.TypefaceCompat;
import androidx.core.text.PrecomputedTextCompat;
import androidx.core.view.InputDeviceCompat;
import androidx.core.view.TintableBackgroundView;
import androidx.core.widget.AutoSizeableTextView;
import androidx.core.widget.TextViewCompat;
import androidx.core.widget.TintableCompoundDrawablesView;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;
/* loaded from: classes.dex */
public class AppCompatTextView extends TextView implements TintableBackgroundView, TintableCompoundDrawablesView, AutoSizeableTextView {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final AppCompatBackgroundHelper mBackgroundTintHelper;
    @Nullable
    public Future<PrecomputedTextCompat> mPrecomputedTextFuture;
    public final AppCompatTextClassifierHelper mTextClassifierHelper;
    public final AppCompatTextHelper mTextHelper;

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public AppCompatTextView(@NonNull Context context) {
        this(context, null);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                Object[] objArr2 = newInitContext.callArgs;
                this((Context) objArr2[0], (AttributeSet) objArr2[1]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
    }

    private void consumeTextFutureAndSetBlocking() {
        Future<PrecomputedTextCompat> future;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(65539, this) == null) || (future = this.mPrecomputedTextFuture) == null) {
            return;
        }
        try {
            this.mPrecomputedTextFuture = null;
            TextViewCompat.setPrecomputedText(this, future.get());
        } catch (InterruptedException | ExecutionException unused) {
        }
    }

    @Override // android.widget.TextView, android.view.View
    public void drawableStateChanged() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            super.drawableStateChanged();
            AppCompatBackgroundHelper appCompatBackgroundHelper = this.mBackgroundTintHelper;
            if (appCompatBackgroundHelper != null) {
                appCompatBackgroundHelper.applySupportBackgroundTint();
            }
            AppCompatTextHelper appCompatTextHelper = this.mTextHelper;
            if (appCompatTextHelper != null) {
                appCompatTextHelper.applyCompoundDrawablesTints();
            }
        }
    }

    @Override // android.widget.TextView, androidx.core.widget.AutoSizeableTextView
    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
    public int getAutoSizeMaxTextSize() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            if (AutoSizeableTextView.PLATFORM_SUPPORTS_AUTOSIZE) {
                return super.getAutoSizeMaxTextSize();
            }
            AppCompatTextHelper appCompatTextHelper = this.mTextHelper;
            if (appCompatTextHelper != null) {
                return appCompatTextHelper.getAutoSizeMaxTextSize();
            }
            return -1;
        }
        return invokeV.intValue;
    }

    @Override // android.widget.TextView, androidx.core.widget.AutoSizeableTextView
    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
    public int getAutoSizeMinTextSize() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            if (AutoSizeableTextView.PLATFORM_SUPPORTS_AUTOSIZE) {
                return super.getAutoSizeMinTextSize();
            }
            AppCompatTextHelper appCompatTextHelper = this.mTextHelper;
            if (appCompatTextHelper != null) {
                return appCompatTextHelper.getAutoSizeMinTextSize();
            }
            return -1;
        }
        return invokeV.intValue;
    }

    @Override // android.widget.TextView, androidx.core.widget.AutoSizeableTextView
    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
    public int getAutoSizeStepGranularity() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
            if (AutoSizeableTextView.PLATFORM_SUPPORTS_AUTOSIZE) {
                return super.getAutoSizeStepGranularity();
            }
            AppCompatTextHelper appCompatTextHelper = this.mTextHelper;
            if (appCompatTextHelper != null) {
                return appCompatTextHelper.getAutoSizeStepGranularity();
            }
            return -1;
        }
        return invokeV.intValue;
    }

    @Override // android.widget.TextView, androidx.core.widget.AutoSizeableTextView
    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
    public int[] getAutoSizeTextAvailableSizes() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
            if (AutoSizeableTextView.PLATFORM_SUPPORTS_AUTOSIZE) {
                return super.getAutoSizeTextAvailableSizes();
            }
            AppCompatTextHelper appCompatTextHelper = this.mTextHelper;
            return appCompatTextHelper != null ? appCompatTextHelper.getAutoSizeTextAvailableSizes() : new int[0];
        }
        return (int[]) invokeV.objValue;
    }

    @Override // android.widget.TextView, androidx.core.widget.AutoSizeableTextView
    @SuppressLint({"WrongConstant"})
    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
    public int getAutoSizeTextType() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) {
            if (AutoSizeableTextView.PLATFORM_SUPPORTS_AUTOSIZE) {
                return super.getAutoSizeTextType() == 1 ? 1 : 0;
            }
            AppCompatTextHelper appCompatTextHelper = this.mTextHelper;
            if (appCompatTextHelper != null) {
                return appCompatTextHelper.getAutoSizeTextType();
            }
            return 0;
        }
        return invokeV.intValue;
    }

    @Override // android.widget.TextView
    public int getFirstBaselineToTopHeight() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) ? TextViewCompat.getFirstBaselineToTopHeight(this) : invokeV.intValue;
    }

    @Override // android.widget.TextView
    public int getLastBaselineToBottomHeight() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) ? TextViewCompat.getLastBaselineToBottomHeight(this) : invokeV.intValue;
    }

    @Override // androidx.core.view.TintableBackgroundView
    @Nullable
    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
    public ColorStateList getSupportBackgroundTintList() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) {
            AppCompatBackgroundHelper appCompatBackgroundHelper = this.mBackgroundTintHelper;
            if (appCompatBackgroundHelper != null) {
                return appCompatBackgroundHelper.getSupportBackgroundTintList();
            }
            return null;
        }
        return (ColorStateList) invokeV.objValue;
    }

    @Override // androidx.core.view.TintableBackgroundView
    @Nullable
    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
    public PorterDuff.Mode getSupportBackgroundTintMode() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048585, this)) == null) {
            AppCompatBackgroundHelper appCompatBackgroundHelper = this.mBackgroundTintHelper;
            if (appCompatBackgroundHelper != null) {
                return appCompatBackgroundHelper.getSupportBackgroundTintMode();
            }
            return null;
        }
        return (PorterDuff.Mode) invokeV.objValue;
    }

    @Override // androidx.core.widget.TintableCompoundDrawablesView
    @Nullable
    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
    public ColorStateList getSupportCompoundDrawablesTintList() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048586, this)) == null) ? this.mTextHelper.getCompoundDrawableTintList() : (ColorStateList) invokeV.objValue;
    }

    @Override // androidx.core.widget.TintableCompoundDrawablesView
    @Nullable
    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
    public PorterDuff.Mode getSupportCompoundDrawablesTintMode() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048587, this)) == null) ? this.mTextHelper.getCompoundDrawableTintMode() : (PorterDuff.Mode) invokeV.objValue;
    }

    @Override // android.widget.TextView
    public CharSequence getText() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048588, this)) == null) {
            consumeTextFutureAndSetBlocking();
            return super.getText();
        }
        return (CharSequence) invokeV.objValue;
    }

    @Override // android.widget.TextView
    @NonNull
    @RequiresApi(api = 26)
    public TextClassifier getTextClassifier() {
        InterceptResult invokeV;
        AppCompatTextClassifierHelper appCompatTextClassifierHelper;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048589, this)) == null) {
            if (Build.VERSION.SDK_INT < 28 && (appCompatTextClassifierHelper = this.mTextClassifierHelper) != null) {
                return appCompatTextClassifierHelper.getTextClassifier();
            }
            return super.getTextClassifier();
        }
        return (TextClassifier) invokeV.objValue;
    }

    @NonNull
    public PrecomputedTextCompat.Params getTextMetricsParamsCompat() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048590, this)) == null) ? TextViewCompat.getTextMetricsParams(this) : (PrecomputedTextCompat.Params) invokeV.objValue;
    }

    @Override // android.widget.TextView, android.view.View
    public InputConnection onCreateInputConnection(EditorInfo editorInfo) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(1048591, this, editorInfo)) == null) ? AppCompatHintHelper.onCreateInputConnection(super.onCreateInputConnection(editorInfo), editorInfo, this) : (InputConnection) invokeL.objValue;
    }

    @Override // android.widget.TextView, android.view.View
    public void onLayout(boolean z, int i2, int i3, int i4, int i5) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048592, this, new Object[]{Boolean.valueOf(z), Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(i4), Integer.valueOf(i5)}) == null) {
            super.onLayout(z, i2, i3, i4, i5);
            AppCompatTextHelper appCompatTextHelper = this.mTextHelper;
            if (appCompatTextHelper != null) {
                appCompatTextHelper.onLayout(z, i2, i3, i4, i5);
            }
        }
    }

    @Override // android.widget.TextView, android.view.View
    public void onMeasure(int i2, int i3) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeII(1048593, this, i2, i3) == null) {
            consumeTextFutureAndSetBlocking();
            super.onMeasure(i2, i3);
        }
    }

    @Override // android.widget.TextView
    public void onTextChanged(CharSequence charSequence, int i2, int i3, int i4) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLIII(1048594, this, charSequence, i2, i3, i4) == null) {
            super.onTextChanged(charSequence, i2, i3, i4);
            AppCompatTextHelper appCompatTextHelper = this.mTextHelper;
            if (appCompatTextHelper == null || AutoSizeableTextView.PLATFORM_SUPPORTS_AUTOSIZE || !appCompatTextHelper.isAutoSizeEnabled()) {
                return;
            }
            this.mTextHelper.autoSizeText();
        }
    }

    @Override // android.widget.TextView, androidx.core.widget.AutoSizeableTextView
    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
    public void setAutoSizeTextTypeUniformWithConfiguration(int i2, int i3, int i4, int i5) throws IllegalArgumentException {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIIII(1048595, this, i2, i3, i4, i5) == null) {
            if (AutoSizeableTextView.PLATFORM_SUPPORTS_AUTOSIZE) {
                super.setAutoSizeTextTypeUniformWithConfiguration(i2, i3, i4, i5);
                return;
            }
            AppCompatTextHelper appCompatTextHelper = this.mTextHelper;
            if (appCompatTextHelper != null) {
                appCompatTextHelper.setAutoSizeTextTypeUniformWithConfiguration(i2, i3, i4, i5);
            }
        }
    }

    @Override // android.widget.TextView, androidx.core.widget.AutoSizeableTextView
    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
    public void setAutoSizeTextTypeUniformWithPresetSizes(@NonNull int[] iArr, int i2) throws IllegalArgumentException {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLI(1048596, this, iArr, i2) == null) {
            if (AutoSizeableTextView.PLATFORM_SUPPORTS_AUTOSIZE) {
                super.setAutoSizeTextTypeUniformWithPresetSizes(iArr, i2);
                return;
            }
            AppCompatTextHelper appCompatTextHelper = this.mTextHelper;
            if (appCompatTextHelper != null) {
                appCompatTextHelper.setAutoSizeTextTypeUniformWithPresetSizes(iArr, i2);
            }
        }
    }

    @Override // android.widget.TextView, androidx.core.widget.AutoSizeableTextView
    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
    public void setAutoSizeTextTypeWithDefaults(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048597, this, i2) == null) {
            if (AutoSizeableTextView.PLATFORM_SUPPORTS_AUTOSIZE) {
                super.setAutoSizeTextTypeWithDefaults(i2);
                return;
            }
            AppCompatTextHelper appCompatTextHelper = this.mTextHelper;
            if (appCompatTextHelper != null) {
                appCompatTextHelper.setAutoSizeTextTypeWithDefaults(i2);
            }
        }
    }

    @Override // android.view.View
    public void setBackgroundDrawable(Drawable drawable) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048598, this, drawable) == null) {
            super.setBackgroundDrawable(drawable);
            AppCompatBackgroundHelper appCompatBackgroundHelper = this.mBackgroundTintHelper;
            if (appCompatBackgroundHelper != null) {
                appCompatBackgroundHelper.onSetBackgroundDrawable(drawable);
            }
        }
    }

    @Override // android.view.View
    public void setBackgroundResource(@DrawableRes int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048599, this, i2) == null) {
            super.setBackgroundResource(i2);
            AppCompatBackgroundHelper appCompatBackgroundHelper = this.mBackgroundTintHelper;
            if (appCompatBackgroundHelper != null) {
                appCompatBackgroundHelper.onSetBackgroundResource(i2);
            }
        }
    }

    @Override // android.widget.TextView
    public void setCompoundDrawables(@Nullable Drawable drawable, @Nullable Drawable drawable2, @Nullable Drawable drawable3, @Nullable Drawable drawable4) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLLL(1048600, this, drawable, drawable2, drawable3, drawable4) == null) {
            super.setCompoundDrawables(drawable, drawable2, drawable3, drawable4);
            AppCompatTextHelper appCompatTextHelper = this.mTextHelper;
            if (appCompatTextHelper != null) {
                appCompatTextHelper.onSetCompoundDrawables();
            }
        }
    }

    @Override // android.widget.TextView
    @RequiresApi(17)
    public void setCompoundDrawablesRelative(@Nullable Drawable drawable, @Nullable Drawable drawable2, @Nullable Drawable drawable3, @Nullable Drawable drawable4) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLLL(1048601, this, drawable, drawable2, drawable3, drawable4) == null) {
            super.setCompoundDrawablesRelative(drawable, drawable2, drawable3, drawable4);
            AppCompatTextHelper appCompatTextHelper = this.mTextHelper;
            if (appCompatTextHelper != null) {
                appCompatTextHelper.onSetCompoundDrawables();
            }
        }
    }

    @Override // android.widget.TextView
    @RequiresApi(17)
    public void setCompoundDrawablesRelativeWithIntrinsicBounds(@Nullable Drawable drawable, @Nullable Drawable drawable2, @Nullable Drawable drawable3, @Nullable Drawable drawable4) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLLL(1048603, this, drawable, drawable2, drawable3, drawable4) == null) {
            super.setCompoundDrawablesRelativeWithIntrinsicBounds(drawable, drawable2, drawable3, drawable4);
            AppCompatTextHelper appCompatTextHelper = this.mTextHelper;
            if (appCompatTextHelper != null) {
                appCompatTextHelper.onSetCompoundDrawables();
            }
        }
    }

    @Override // android.widget.TextView
    public void setCompoundDrawablesWithIntrinsicBounds(@Nullable Drawable drawable, @Nullable Drawable drawable2, @Nullable Drawable drawable3, @Nullable Drawable drawable4) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLLL(1048605, this, drawable, drawable2, drawable3, drawable4) == null) {
            super.setCompoundDrawablesWithIntrinsicBounds(drawable, drawable2, drawable3, drawable4);
            AppCompatTextHelper appCompatTextHelper = this.mTextHelper;
            if (appCompatTextHelper != null) {
                appCompatTextHelper.onSetCompoundDrawables();
            }
        }
    }

    @Override // android.widget.TextView
    public void setCustomSelectionActionModeCallback(ActionMode.Callback callback) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048606, this, callback) == null) {
            super.setCustomSelectionActionModeCallback(TextViewCompat.wrapCustomSelectionActionModeCallback(this, callback));
        }
    }

    @Override // android.widget.TextView
    public void setFirstBaselineToTopHeight(@IntRange(from = 0) @Px int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048607, this, i2) == null) {
            if (Build.VERSION.SDK_INT >= 28) {
                super.setFirstBaselineToTopHeight(i2);
            } else {
                TextViewCompat.setFirstBaselineToTopHeight(this, i2);
            }
        }
    }

    @Override // android.widget.TextView
    public void setLastBaselineToBottomHeight(@IntRange(from = 0) @Px int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048608, this, i2) == null) {
            if (Build.VERSION.SDK_INT >= 28) {
                super.setLastBaselineToBottomHeight(i2);
            } else {
                TextViewCompat.setLastBaselineToBottomHeight(this, i2);
            }
        }
    }

    @Override // android.widget.TextView
    public void setLineHeight(@IntRange(from = 0) @Px int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048609, this, i2) == null) {
            TextViewCompat.setLineHeight(this, i2);
        }
    }

    public void setPrecomputedText(@NonNull PrecomputedTextCompat precomputedTextCompat) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048610, this, precomputedTextCompat) == null) {
            TextViewCompat.setPrecomputedText(this, precomputedTextCompat);
        }
    }

    @Override // androidx.core.view.TintableBackgroundView
    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
    public void setSupportBackgroundTintList(@Nullable ColorStateList colorStateList) {
        AppCompatBackgroundHelper appCompatBackgroundHelper;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048611, this, colorStateList) == null) || (appCompatBackgroundHelper = this.mBackgroundTintHelper) == null) {
            return;
        }
        appCompatBackgroundHelper.setSupportBackgroundTintList(colorStateList);
    }

    @Override // androidx.core.view.TintableBackgroundView
    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
    public void setSupportBackgroundTintMode(@Nullable PorterDuff.Mode mode) {
        AppCompatBackgroundHelper appCompatBackgroundHelper;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048612, this, mode) == null) || (appCompatBackgroundHelper = this.mBackgroundTintHelper) == null) {
            return;
        }
        appCompatBackgroundHelper.setSupportBackgroundTintMode(mode);
    }

    @Override // androidx.core.widget.TintableCompoundDrawablesView
    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
    public void setSupportCompoundDrawablesTintList(@Nullable ColorStateList colorStateList) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048613, this, colorStateList) == null) {
            this.mTextHelper.setCompoundDrawableTintList(colorStateList);
            this.mTextHelper.applyCompoundDrawablesTints();
        }
    }

    @Override // androidx.core.widget.TintableCompoundDrawablesView
    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
    public void setSupportCompoundDrawablesTintMode(@Nullable PorterDuff.Mode mode) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048614, this, mode) == null) {
            this.mTextHelper.setCompoundDrawableTintMode(mode);
            this.mTextHelper.applyCompoundDrawablesTints();
        }
    }

    @Override // android.widget.TextView
    public void setTextAppearance(Context context, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLI(1048615, this, context, i2) == null) {
            super.setTextAppearance(context, i2);
            AppCompatTextHelper appCompatTextHelper = this.mTextHelper;
            if (appCompatTextHelper != null) {
                appCompatTextHelper.onSetTextAppearance(context, i2);
            }
        }
    }

    @Override // android.widget.TextView
    @RequiresApi(api = 26)
    public void setTextClassifier(@Nullable TextClassifier textClassifier) {
        AppCompatTextClassifierHelper appCompatTextClassifierHelper;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048616, this, textClassifier) == null) {
            if (Build.VERSION.SDK_INT < 28 && (appCompatTextClassifierHelper = this.mTextClassifierHelper) != null) {
                appCompatTextClassifierHelper.setTextClassifier(textClassifier);
            } else {
                super.setTextClassifier(textClassifier);
            }
        }
    }

    public void setTextFuture(@Nullable Future<PrecomputedTextCompat> future) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048617, this, future) == null) {
            this.mPrecomputedTextFuture = future;
            if (future != null) {
                requestLayout();
            }
        }
    }

    public void setTextMetricsParamsCompat(@NonNull PrecomputedTextCompat.Params params) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048618, this, params) == null) {
            TextViewCompat.setTextMetricsParams(this, params);
        }
    }

    @Override // android.widget.TextView
    public void setTextSize(int i2, float f2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048619, this, new Object[]{Integer.valueOf(i2), Float.valueOf(f2)}) == null) {
            if (AutoSizeableTextView.PLATFORM_SUPPORTS_AUTOSIZE) {
                super.setTextSize(i2, f2);
                return;
            }
            AppCompatTextHelper appCompatTextHelper = this.mTextHelper;
            if (appCompatTextHelper != null) {
                appCompatTextHelper.setTextSize(i2, f2);
            }
        }
    }

    @Override // android.widget.TextView
    public void setTypeface(@Nullable Typeface typeface, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLI(1048620, this, typeface, i2) == null) {
            Typeface create = (typeface == null || i2 <= 0) ? null : TypefaceCompat.create(getContext(), typeface, i2);
            if (create != null) {
                typeface = create;
            }
            super.setTypeface(typeface, i2);
        }
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public AppCompatTextView(@NonNull Context context, @Nullable AttributeSet attributeSet) {
        this(context, attributeSet, 16842884);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context, attributeSet};
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                Object[] objArr2 = newInitContext.callArgs;
                this((Context) objArr2[0], (AttributeSet) objArr2[1], ((Integer) objArr2[2]).intValue());
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public AppCompatTextView(@NonNull Context context, @Nullable AttributeSet attributeSet, int i2) {
        super(TintContextWrapper.wrap(context), attributeSet, i2);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context, attributeSet, Integer.valueOf(i2)};
            interceptable.invokeUnInit(65538, newInitContext);
            int i3 = newInitContext.flag;
            if ((i3 & 1) != 0) {
                int i4 = i3 & 2;
                Object[] objArr2 = newInitContext.callArgs;
                super((Context) objArr2[0], (AttributeSet) objArr2[1], ((Integer) objArr2[2]).intValue());
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65538, newInitContext);
                return;
            }
        }
        ThemeUtils.checkAppCompatTheme(this, getContext());
        AppCompatBackgroundHelper appCompatBackgroundHelper = new AppCompatBackgroundHelper(this);
        this.mBackgroundTintHelper = appCompatBackgroundHelper;
        appCompatBackgroundHelper.loadFromAttributes(attributeSet, i2);
        AppCompatTextHelper appCompatTextHelper = new AppCompatTextHelper(this);
        this.mTextHelper = appCompatTextHelper;
        appCompatTextHelper.loadFromAttributes(attributeSet, i2);
        this.mTextHelper.applyCompoundDrawablesTints();
        this.mTextClassifierHelper = new AppCompatTextClassifierHelper(this);
    }

    @Override // android.widget.TextView
    @RequiresApi(17)
    public void setCompoundDrawablesRelativeWithIntrinsicBounds(int i2, int i3, int i4, int i5) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIIII(1048602, this, i2, i3, i4, i5) == null) {
            Context context = getContext();
            setCompoundDrawablesRelativeWithIntrinsicBounds(i2 != 0 ? AppCompatResources.getDrawable(context, i2) : null, i3 != 0 ? AppCompatResources.getDrawable(context, i3) : null, i4 != 0 ? AppCompatResources.getDrawable(context, i4) : null, i5 != 0 ? AppCompatResources.getDrawable(context, i5) : null);
            AppCompatTextHelper appCompatTextHelper = this.mTextHelper;
            if (appCompatTextHelper != null) {
                appCompatTextHelper.onSetCompoundDrawables();
            }
        }
    }

    @Override // android.widget.TextView
    public void setCompoundDrawablesWithIntrinsicBounds(int i2, int i3, int i4, int i5) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIIII(1048604, this, i2, i3, i4, i5) == null) {
            Context context = getContext();
            setCompoundDrawablesWithIntrinsicBounds(i2 != 0 ? AppCompatResources.getDrawable(context, i2) : null, i3 != 0 ? AppCompatResources.getDrawable(context, i3) : null, i4 != 0 ? AppCompatResources.getDrawable(context, i4) : null, i5 != 0 ? AppCompatResources.getDrawable(context, i5) : null);
            AppCompatTextHelper appCompatTextHelper = this.mTextHelper;
            if (appCompatTextHelper != null) {
                appCompatTextHelper.onSetCompoundDrawables();
            }
        }
    }
}
