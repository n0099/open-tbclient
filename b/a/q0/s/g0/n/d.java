package b.a.q0.s.g0.n;

import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
import android.os.Build;
import androidx.annotation.ColorRes;
import androidx.annotation.DrawableRes;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tbadk.core.view.commonBtn.TBSpecificationButtonConfig;
import com.baidu.tieba.R;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes4.dex */
public class d extends TBSpecificationButtonConfig {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public boolean u;

    public d() {
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
        this.f46386i = true;
        this.f46379b = R.color.CAM_X0101;
        this.f46381d = R.color.CAM_X0302;
        this.u = false;
        this.n = this.o;
        this.m = this.l;
    }

    @Override // com.baidu.tbadk.core.view.commonBtn.TBSpecificationButtonConfig
    public Drawable a(float f2) {
        InterceptResult invokeF;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeF = interceptable.invokeF(1048576, this, f2)) == null) ? q(f2) : (Drawable) invokeF.objValue;
    }

    @Override // com.baidu.tbadk.core.view.commonBtn.TBSpecificationButtonConfig
    @Deprecated
    public void i(int i2, int i3, TBSpecificationButtonConfig.IconType iconType) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIIL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i2, i3, iconType) == null) {
            t(i2, iconType);
        }
    }

    public void p(@ColorRes int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(Constants.METHOD_SEND_USER_MSG, this, i2) == null) {
            this.f46379b = i2;
            this.f46381d = R.color.CAM_X0904;
            this.u = false;
            TBSpecificationButtonConfig.a aVar = this.t;
            if (aVar != null) {
                aVar.c();
            }
        }
    }

    public final Drawable q(float f2) {
        InterceptResult invokeF;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeF = interceptable.invokeF(1048579, this, f2)) == null) {
            if (this.u) {
                return r(f2);
            }
            return s(f2);
        }
        return (Drawable) invokeF.objValue;
    }

    public final Drawable r(float f2) {
        InterceptResult invokeF;
        GradientDrawable gradientDrawable;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeF = interceptable.invokeF(1048580, this, f2)) == null) {
            int color = SkinManager.getColor(this.r, this.f46381d);
            int[] iArr = {b.a.r0.m3.c.b(color), color};
            if (Build.VERSION.SDK_INT >= 16) {
                gradientDrawable = new GradientDrawable();
                gradientDrawable.setOrientation(this.s);
                gradientDrawable.setColors(iArr);
            } else {
                gradientDrawable = new GradientDrawable(this.s, iArr);
            }
            gradientDrawable.setGradientType(0);
            gradientDrawable.setShape(0);
            gradientDrawable.setCornerRadius(f2);
            return gradientDrawable;
        }
        return (Drawable) invokeF.objValue;
    }

    public final Drawable s(float f2) {
        InterceptResult invokeF;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeF = interceptable.invokeF(1048581, this, f2)) == null) {
            GradientDrawable gradientDrawable = new GradientDrawable();
            gradientDrawable.setColor(SkinManager.getColor(this.r, this.f46381d));
            gradientDrawable.setShape(0);
            gradientDrawable.setCornerRadius(f2);
            return gradientDrawable;
        }
        return (Drawable) invokeF.objValue;
    }

    public void t(@DrawableRes int i2, TBSpecificationButtonConfig.IconType iconType) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIL(1048582, this, i2, iconType) == null) {
            this.f46382e[0] = i2;
            this.f46383f = iconType;
        }
    }
}
