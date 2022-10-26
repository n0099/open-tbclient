package androidx.appcompat.widget;

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
    public Future<PrecomputedTextCompat> mPrecomputedTextFuture;
    public final AppCompatTextClassifierHelper mTextClassifierHelper;
    public final AppCompatTextHelper mTextHelper;

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public AppCompatTextView(Context context) {
        this(context, null);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                Object[] objArr2 = newInitContext.callArgs;
                this((Context) objArr2[0], (AttributeSet) objArr2[1]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public AppCompatTextView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 16842884);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context, attributeSet};
            interceptable.invokeUnInit(65537, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                Object[] objArr2 = newInitContext.callArgs;
                this((Context) objArr2[0], (AttributeSet) objArr2[1], ((Integer) objArr2[2]).intValue());
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public AppCompatTextView(Context context, AttributeSet attributeSet, int i) {
        super(TintContextWrapper.wrap(context), attributeSet, i);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context, attributeSet, Integer.valueOf(i)};
            interceptable.invokeUnInit(65538, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
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
        appCompatBackgroundHelper.loadFromAttributes(attributeSet, i);
        AppCompatTextHelper appCompatTextHelper = new AppCompatTextHelper(this);
        this.mTextHelper = appCompatTextHelper;
        appCompatTextHelper.loadFromAttributes(attributeSet, i);
        this.mTextHelper.applyCompoundDrawablesTints();
        this.mTextClassifierHelper = new AppCompatTextClassifierHelper(this);
    }

    private void consumeTextFutureAndSetBlocking() {
        Future<PrecomputedTextCompat> future;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(65539, this) == null) && (future = this.mPrecomputedTextFuture) != null) {
            try {
                this.mPrecomputedTextFuture = null;
                TextViewCompat.setPrecomputedText(this, future.get());
            } catch (InterruptedException | ExecutionException unused) {
            }
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
    public int[] getAutoSizeTextAvailableSizes() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
            if (AutoSizeableTextView.PLATFORM_SUPPORTS_AUTOSIZE) {
                return super.getAutoSizeTextAvailableSizes();
            }
            AppCompatTextHelper appCompatTextHelper = this.mTextHelper;
            if (appCompatTextHelper != null) {
                return appCompatTextHelper.getAutoSizeTextAvailableSizes();
            }
            return new int[0];
        }
        return (int[]) invokeV.objValue;
    }

    @Override // android.widget.TextView, androidx.core.widget.AutoSizeableTextView
    public int getAutoSizeTextType() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) {
            if (AutoSizeableTextView.PLATFORM_SUPPORTS_AUTOSIZE) {
                if (super.getAutoSizeTextType() != 1) {
                    return 0;
                }
                return 1;
            }
            AppCompatTextHelper appCompatTextHelper = this.mTextHelper;
            if (appCompatTextHelper == null) {
                return 0;
            }
            return appCompatTextHelper.getAutoSizeTextType();
        }
        return invokeV.intValue;
    }

    @Override // android.widget.TextView
    public int getFirstBaselineToTopHeight() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) {
            return TextViewCompat.getFirstBaselineToTopHeight(this);
        }
        return invokeV.intValue;
    }

    @Override // android.widget.TextView
    public int getLastBaselineToBottomHeight() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) {
            return TextViewCompat.getLastBaselineToBottomHeight(this);
        }
        return invokeV.intValue;
    }

    @Override // androidx.core.view.TintableBackgroundView
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
    public ColorStateList getSupportCompoundDrawablesTintList() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048586, this)) == null) {
            return this.mTextHelper.getCompoundDrawableTintList();
        }
        return (ColorStateList) invokeV.objValue;
    }

    @Override // androidx.core.widget.TintableCompoundDrawablesView
    public PorterDuff.Mode getSupportCompoundDrawablesTintMode() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048587, this)) == null) {
            return this.mTextHelper.getCompoundDrawableTintMode();
        }
        return (PorterDuff.Mode) invokeV.objValue;
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

    public PrecomputedTextCompat.Params getTextMetricsParamsCompat() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048590, this)) == null) {
            return TextViewCompat.getTextMetricsParams(this);
        }
        return (PrecomputedTextCompat.Params) invokeV.objValue;
    }

    @Override // android.widget.TextView, android.view.View
    public InputConnection onCreateInputConnection(EditorInfo editorInfo) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048591, this, editorInfo)) == null) {
            return AppCompatHintHelper.onCreateInputConnection(super.onCreateInputConnection(editorInfo), editorInfo, this);
        }
        return (InputConnection) invokeL.objValue;
    }

    @Override // android.widget.TextView, androidx.core.widget.AutoSizeableTextView
    public void setAutoSizeTextTypeWithDefaults(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048597, this, i) == null) {
            if (AutoSizeableTextView.PLATFORM_SUPPORTS_AUTOSIZE) {
                super.setAutoSizeTextTypeWithDefaults(i);
                return;
            }
            AppCompatTextHelper appCompatTextHelper = this.mTextHelper;
            if (appCompatTextHelper != null) {
                appCompatTextHelper.setAutoSizeTextTypeWithDefaults(i);
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
    public void setBackgroundResource(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048599, this, i) == null) {
            super.setBackgroundResource(i);
            AppCompatBackgroundHelper appCompatBackgroundHelper = this.mBackgroundTintHelper;
            if (appCompatBackgroundHelper != null) {
                appCompatBackgroundHelper.onSetBackgroundResource(i);
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
    public void setFirstBaselineToTopHeight(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048607, this, i) == null) {
            if (Build.VERSION.SDK_INT >= 28) {
                super.setFirstBaselineToTopHeight(i);
            } else {
                TextViewCompat.setFirstBaselineToTopHeight(this, i);
            }
        }
    }

    @Override // android.widget.TextView
    public void setLastBaselineToBottomHeight(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048608, this, i) == null) {
            if (Build.VERSION.SDK_INT >= 28) {
                super.setLastBaselineToBottomHeight(i);
            } else {
                TextViewCompat.setLastBaselineToBottomHeight(this, i);
            }
        }
    }

    @Override // android.widget.TextView
    public void setLineHeight(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048609, this, i) == null) {
            TextViewCompat.setLineHeight(this, i);
        }
    }

    public void setPrecomputedText(PrecomputedTextCompat precomputedTextCompat) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048610, this, precomputedTextCompat) == null) {
            TextViewCompat.setPrecomputedText(this, precomputedTextCompat);
        }
    }

    @Override // androidx.core.view.TintableBackgroundView
    public void setSupportBackgroundTintList(ColorStateList colorStateList) {
        AppCompatBackgroundHelper appCompatBackgroundHelper;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048611, this, colorStateList) == null) && (appCompatBackgroundHelper = this.mBackgroundTintHelper) != null) {
            appCompatBackgroundHelper.setSupportBackgroundTintList(colorStateList);
        }
    }

    @Override // androidx.core.view.TintableBackgroundView
    public void setSupportBackgroundTintMode(PorterDuff.Mode mode) {
        AppCompatBackgroundHelper appCompatBackgroundHelper;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048612, this, mode) == null) && (appCompatBackgroundHelper = this.mBackgroundTintHelper) != null) {
            appCompatBackgroundHelper.setSupportBackgroundTintMode(mode);
        }
    }

    @Override // androidx.core.widget.TintableCompoundDrawablesView
    public void setSupportCompoundDrawablesTintList(ColorStateList colorStateList) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048613, this, colorStateList) == null) {
            this.mTextHelper.setCompoundDrawableTintList(colorStateList);
            this.mTextHelper.applyCompoundDrawablesTints();
        }
    }

    @Override // androidx.core.widget.TintableCompoundDrawablesView
    public void setSupportCompoundDrawablesTintMode(PorterDuff.Mode mode) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048614, this, mode) == null) {
            this.mTextHelper.setCompoundDrawableTintMode(mode);
            this.mTextHelper.applyCompoundDrawablesTints();
        }
    }

    @Override // android.widget.TextView
    public void setTextClassifier(TextClassifier textClassifier) {
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

    public void setTextFuture(Future<PrecomputedTextCompat> future) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048617, this, future) == null) {
            this.mPrecomputedTextFuture = future;
            if (future != null) {
                requestLayout();
            }
        }
    }

    public void setTextMetricsParamsCompat(PrecomputedTextCompat.Params params) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048618, this, params) == null) {
            TextViewCompat.setTextMetricsParams(this, params);
        }
    }

    @Override // android.widget.TextView, android.view.View
    public void onLayout(boolean z, int i, int i2, int i3, int i4) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048592, this, new Object[]{Boolean.valueOf(z), Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(i4)}) == null) {
            super.onLayout(z, i, i2, i3, i4);
            AppCompatTextHelper appCompatTextHelper = this.mTextHelper;
            if (appCompatTextHelper != null) {
                appCompatTextHelper.onLayout(z, i, i2, i3, i4);
            }
        }
    }

    @Override // android.widget.TextView, android.view.View
    public void onMeasure(int i, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeII(1048593, this, i, i2) == null) {
            consumeTextFutureAndSetBlocking();
            super.onMeasure(i, i2);
        }
    }

    @Override // android.widget.TextView, androidx.core.widget.AutoSizeableTextView
    public void setAutoSizeTextTypeUniformWithPresetSizes(int[] iArr, int i) throws IllegalArgumentException {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLI(1048596, this, iArr, i) == null) {
            if (AutoSizeableTextView.PLATFORM_SUPPORTS_AUTOSIZE) {
                super.setAutoSizeTextTypeUniformWithPresetSizes(iArr, i);
                return;
            }
            AppCompatTextHelper appCompatTextHelper = this.mTextHelper;
            if (appCompatTextHelper != null) {
                appCompatTextHelper.setAutoSizeTextTypeUniformWithPresetSizes(iArr, i);
            }
        }
    }

    @Override // android.widget.TextView
    public void setTextAppearance(Context context, int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLI(1048615, this, context, i) == null) {
            super.setTextAppearance(context, i);
            AppCompatTextHelper appCompatTextHelper = this.mTextHelper;
            if (appCompatTextHelper != null) {
                appCompatTextHelper.onSetTextAppearance(context, i);
            }
        }
    }

    @Override // android.widget.TextView
    public void setTypeface(Typeface typeface, int i) {
        Typeface typeface2;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLI(1048620, this, typeface, i) == null) {
            if (typeface != null && i > 0) {
                typeface2 = TypefaceCompat.create(getContext(), typeface, i);
            } else {
                typeface2 = null;
            }
            if (typeface2 != null) {
                typeface = typeface2;
            }
            super.setTypeface(typeface, i);
        }
    }

    @Override // android.widget.TextView
    public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLIII(1048594, this, charSequence, i, i2, i3) == null) {
            super.onTextChanged(charSequence, i, i2, i3);
            AppCompatTextHelper appCompatTextHelper = this.mTextHelper;
            if (appCompatTextHelper != null && !AutoSizeableTextView.PLATFORM_SUPPORTS_AUTOSIZE && appCompatTextHelper.isAutoSizeEnabled()) {
                this.mTextHelper.autoSizeText();
            }
        }
    }

    @Override // android.widget.TextView, androidx.core.widget.AutoSizeableTextView
    public void setAutoSizeTextTypeUniformWithConfiguration(int i, int i2, int i3, int i4) throws IllegalArgumentException {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIIII(1048595, this, i, i2, i3, i4) == null) {
            if (AutoSizeableTextView.PLATFORM_SUPPORTS_AUTOSIZE) {
                super.setAutoSizeTextTypeUniformWithConfiguration(i, i2, i3, i4);
                return;
            }
            AppCompatTextHelper appCompatTextHelper = this.mTextHelper;
            if (appCompatTextHelper != null) {
                appCompatTextHelper.setAutoSizeTextTypeUniformWithConfiguration(i, i2, i3, i4);
            }
        }
    }

    @Override // android.widget.TextView
    public void setCompoundDrawables(Drawable drawable, Drawable drawable2, Drawable drawable3, Drawable drawable4) {
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
    public void setCompoundDrawablesRelative(Drawable drawable, Drawable drawable2, Drawable drawable3, Drawable drawable4) {
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
    public void setCompoundDrawablesRelativeWithIntrinsicBounds(Drawable drawable, Drawable drawable2, Drawable drawable3, Drawable drawable4) {
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
    public void setCompoundDrawablesWithIntrinsicBounds(Drawable drawable, Drawable drawable2, Drawable drawable3, Drawable drawable4) {
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
    public void setCompoundDrawablesRelativeWithIntrinsicBounds(int i, int i2, int i3, int i4) {
        Drawable drawable;
        Drawable drawable2;
        Drawable drawable3;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIIII(1048602, this, i, i2, i3, i4) == null) {
            Context context = getContext();
            Drawable drawable4 = null;
            if (i != 0) {
                drawable = AppCompatResources.getDrawable(context, i);
            } else {
                drawable = null;
            }
            if (i2 != 0) {
                drawable2 = AppCompatResources.getDrawable(context, i2);
            } else {
                drawable2 = null;
            }
            if (i3 != 0) {
                drawable3 = AppCompatResources.getDrawable(context, i3);
            } else {
                drawable3 = null;
            }
            if (i4 != 0) {
                drawable4 = AppCompatResources.getDrawable(context, i4);
            }
            setCompoundDrawablesRelativeWithIntrinsicBounds(drawable, drawable2, drawable3, drawable4);
            AppCompatTextHelper appCompatTextHelper = this.mTextHelper;
            if (appCompatTextHelper != null) {
                appCompatTextHelper.onSetCompoundDrawables();
            }
        }
    }

    @Override // android.widget.TextView
    public void setCompoundDrawablesWithIntrinsicBounds(int i, int i2, int i3, int i4) {
        Drawable drawable;
        Drawable drawable2;
        Drawable drawable3;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIIII(1048604, this, i, i2, i3, i4) == null) {
            Context context = getContext();
            Drawable drawable4 = null;
            if (i != 0) {
                drawable = AppCompatResources.getDrawable(context, i);
            } else {
                drawable = null;
            }
            if (i2 != 0) {
                drawable2 = AppCompatResources.getDrawable(context, i2);
            } else {
                drawable2 = null;
            }
            if (i3 != 0) {
                drawable3 = AppCompatResources.getDrawable(context, i3);
            } else {
                drawable3 = null;
            }
            if (i4 != 0) {
                drawable4 = AppCompatResources.getDrawable(context, i4);
            }
            setCompoundDrawablesWithIntrinsicBounds(drawable, drawable2, drawable3, drawable4);
            AppCompatTextHelper appCompatTextHelper = this.mTextHelper;
            if (appCompatTextHelper != null) {
                appCompatTextHelper.onSetCompoundDrawables();
            }
        }
    }

    @Override // android.widget.TextView
    public void setTextSize(int i, float f) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048619, this, new Object[]{Integer.valueOf(i), Float.valueOf(f)}) == null) {
            if (AutoSizeableTextView.PLATFORM_SUPPORTS_AUTOSIZE) {
                super.setTextSize(i, f);
                return;
            }
            AppCompatTextHelper appCompatTextHelper = this.mTextHelper;
            if (appCompatTextHelper != null) {
                appCompatTextHelper.setTextSize(i, f);
            }
        }
    }
}
