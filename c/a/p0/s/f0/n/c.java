package c.a.p0.s.f0.n;

import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
import androidx.annotation.ColorInt;
import androidx.annotation.ColorRes;
import c.a.e.e.p.l;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tbadk.core.view.commonBtn.TBSpecificationButtonConfig;
import com.baidu.tieba.R;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes3.dex */
public class c extends TBSpecificationButtonConfig {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public boolean t;

    public c() {
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
        this.f47817b = R.color.CAM_X0302;
        this.t = false;
    }

    @Override // com.baidu.tbadk.core.view.commonBtn.TBSpecificationButtonConfig
    public Drawable a(float f2) {
        InterceptResult invokeF;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeF = interceptable.invokeF(1048576, this, f2)) == null) ? s(f2) : (Drawable) invokeF.objValue;
    }

    public void o(@ColorRes int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i2) == null) {
            this.f47817b = i2;
            this.t = false;
            this.p = true;
            TBSpecificationButtonConfig.a aVar = this.s;
            if (aVar != null) {
                aVar.c();
            }
        }
    }

    public void p(@ColorInt int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(Constants.METHOD_SEND_USER_MSG, this, i2) == null) {
            this.f47817b = i2;
            this.t = false;
            this.p = false;
            TBSpecificationButtonConfig.a aVar = this.s;
            if (aVar != null) {
                aVar.c();
            }
        }
    }

    public void q(@ColorRes int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048579, this, i2) == null) {
            this.f47817b = i2;
            this.f47818c = R.color.CAM_X0902;
            this.t = true;
            this.p = true;
            TBSpecificationButtonConfig.a aVar = this.s;
            if (aVar != null) {
                aVar.c();
            }
        }
    }

    public void r() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
            this.f47817b = R.color.CAM_X0101;
            this.t = false;
            this.p = true;
            TBSpecificationButtonConfig.a aVar = this.s;
            if (aVar != null) {
                aVar.c();
            }
        }
    }

    public final Drawable s(float f2) {
        InterceptResult invokeF;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeF = interceptable.invokeF(1048581, this, f2)) == null) {
            GradientDrawable gradientDrawable = new GradientDrawable();
            if (this.t) {
                gradientDrawable.setStroke(l.g(TbadkCoreApplication.getInst().getContext(), R.dimen.tbds1), SkinManager.getColor(this.q, this.f47818c));
            } else {
                gradientDrawable.setStroke(l.g(TbadkCoreApplication.getInst().getContext(), R.dimen.tbds1), c.a.q0.i3.c.a(this.p ? SkinManager.getColor(this.q, this.f47817b) : this.f47817b, c.a.p0.s.u.a.a(R.string.A_X07)));
            }
            gradientDrawable.setShape(0);
            gradientDrawable.setCornerRadius(f2);
            return gradientDrawable;
        }
        return (Drawable) invokeF.objValue;
    }
}
