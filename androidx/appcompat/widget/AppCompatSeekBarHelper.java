package androidx.appcompat.widget;

import android.content.res.ColorStateList;
import android.graphics.Canvas;
import android.graphics.PorterDuff;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.widget.ProgressBar;
import android.widget.SeekBar;
import androidx.annotation.Nullable;
import androidx.appcompat.R;
import androidx.core.graphics.drawable.DrawableCompat;
import androidx.core.view.InputDeviceCompat;
import androidx.core.view.ViewCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes.dex */
public class AppCompatSeekBarHelper extends AppCompatProgressBarHelper {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public boolean mHasTickMarkTint;
    public boolean mHasTickMarkTintMode;
    public Drawable mTickMark;
    public ColorStateList mTickMarkTintList;
    public PorterDuff.Mode mTickMarkTintMode;
    public final SeekBar mView;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public AppCompatSeekBarHelper(SeekBar seekBar) {
        super(seekBar);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {seekBar};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                super((ProgressBar) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.mTickMarkTintList = null;
        this.mTickMarkTintMode = null;
        this.mHasTickMarkTint = false;
        this.mHasTickMarkTintMode = false;
        this.mView = seekBar;
    }

    private void applyTickMarkTint() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(65537, this) == null) || this.mTickMark == null) {
            return;
        }
        if (this.mHasTickMarkTint || this.mHasTickMarkTintMode) {
            Drawable wrap = DrawableCompat.wrap(this.mTickMark.mutate());
            this.mTickMark = wrap;
            if (this.mHasTickMarkTint) {
                DrawableCompat.setTintList(wrap, this.mTickMarkTintList);
            }
            if (this.mHasTickMarkTintMode) {
                DrawableCompat.setTintMode(this.mTickMark, this.mTickMarkTintMode);
            }
            if (this.mTickMark.isStateful()) {
                this.mTickMark.setState(this.mView.getDrawableState());
            }
        }
    }

    public void drawTickMarks(Canvas canvas) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048576, this, canvas) == null) || this.mTickMark == null) {
            return;
        }
        int max = this.mView.getMax();
        if (max > 1) {
            int intrinsicWidth = this.mTickMark.getIntrinsicWidth();
            int intrinsicHeight = this.mTickMark.getIntrinsicHeight();
            int i = intrinsicWidth >= 0 ? intrinsicWidth / 2 : 1;
            int i2 = intrinsicHeight >= 0 ? intrinsicHeight / 2 : 1;
            this.mTickMark.setBounds(-i, -i2, i, i2);
            float width = ((this.mView.getWidth() - this.mView.getPaddingLeft()) - this.mView.getPaddingRight()) / max;
            int save = canvas.save();
            canvas.translate(this.mView.getPaddingLeft(), this.mView.getHeight() / 2);
            for (int i3 = 0; i3 <= max; i3++) {
                this.mTickMark.draw(canvas);
                canvas.translate(width, 0.0f);
            }
            canvas.restoreToCount(save);
        }
    }

    public void drawableStateChanged() {
        Drawable drawable;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) && (drawable = this.mTickMark) != null && drawable.isStateful() && drawable.setState(this.mView.getDrawableState())) {
            this.mView.invalidateDrawable(drawable);
        }
    }

    @Nullable
    public Drawable getTickMark() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? this.mTickMark : (Drawable) invokeV.objValue;
    }

    @Nullable
    public ColorStateList getTickMarkTintList() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? this.mTickMarkTintList : (ColorStateList) invokeV.objValue;
    }

    @Nullable
    public PorterDuff.Mode getTickMarkTintMode() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) ? this.mTickMarkTintMode : (PorterDuff.Mode) invokeV.objValue;
    }

    public void jumpDrawablesToCurrentState() {
        Drawable drawable;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048581, this) == null) || (drawable = this.mTickMark) == null) {
            return;
        }
        drawable.jumpToCurrentState();
    }

    @Override // androidx.appcompat.widget.AppCompatProgressBarHelper
    public void loadFromAttributes(AttributeSet attributeSet, int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLI(1048582, this, attributeSet, i) == null) {
            super.loadFromAttributes(attributeSet, i);
            TintTypedArray obtainStyledAttributes = TintTypedArray.obtainStyledAttributes(this.mView.getContext(), attributeSet, R.styleable.AppCompatSeekBar, i, 0);
            SeekBar seekBar = this.mView;
            ViewCompat.saveAttributeDataForStyleable(seekBar, seekBar.getContext(), R.styleable.AppCompatSeekBar, attributeSet, obtainStyledAttributes.getWrappedTypeArray(), i, 0);
            Drawable drawableIfKnown = obtainStyledAttributes.getDrawableIfKnown(0);
            if (drawableIfKnown != null) {
                this.mView.setThumb(drawableIfKnown);
            }
            setTickMark(obtainStyledAttributes.getDrawable(1));
            if (obtainStyledAttributes.hasValue(3)) {
                this.mTickMarkTintMode = DrawableUtils.parseTintMode(obtainStyledAttributes.getInt(3, -1), this.mTickMarkTintMode);
                this.mHasTickMarkTintMode = true;
            }
            if (obtainStyledAttributes.hasValue(2)) {
                this.mTickMarkTintList = obtainStyledAttributes.getColorStateList(2);
                this.mHasTickMarkTint = true;
            }
            obtainStyledAttributes.recycle();
            applyTickMarkTint();
        }
    }

    public void setTickMark(@Nullable Drawable drawable) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048583, this, drawable) == null) {
            Drawable drawable2 = this.mTickMark;
            if (drawable2 != null) {
                drawable2.setCallback(null);
            }
            this.mTickMark = drawable;
            if (drawable != null) {
                drawable.setCallback(this.mView);
                DrawableCompat.setLayoutDirection(drawable, ViewCompat.getLayoutDirection(this.mView));
                if (drawable.isStateful()) {
                    drawable.setState(this.mView.getDrawableState());
                }
                applyTickMarkTint();
            }
            this.mView.invalidate();
        }
    }

    public void setTickMarkTintList(@Nullable ColorStateList colorStateList) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, colorStateList) == null) {
            this.mTickMarkTintList = colorStateList;
            this.mHasTickMarkTint = true;
            applyTickMarkTint();
        }
    }

    public void setTickMarkTintMode(@Nullable PorterDuff.Mode mode) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048585, this, mode) == null) {
            this.mTickMarkTintMode = mode;
            this.mHasTickMarkTintMode = true;
            applyTickMarkTint();
        }
    }
}
