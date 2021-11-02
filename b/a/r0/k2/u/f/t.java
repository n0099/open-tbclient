package b.a.r0.k2.u.f;

import android.content.Intent;
import android.view.View;
import android.widget.RelativeLayout;
import androidx.core.view.InputDeviceCompat;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tieba.pb.pb.main.view.PbFakeFloorModel;
import com.baidu.tieba.tbadkCore.writeModel.NewWriteModel;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes5.dex */
public class t {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public b.a.q0.x.x.h f19476a;

    /* renamed from: b  reason: collision with root package name */
    public TbPageContext f19477b;

    /* renamed from: c  reason: collision with root package name */
    public RelativeLayout f19478c;

    /* renamed from: d  reason: collision with root package name */
    public PbFakeFloorModel f19479d;

    /* renamed from: e  reason: collision with root package name */
    public String f19480e;

    /* renamed from: f  reason: collision with root package name */
    public String f19481f;

    /* renamed from: g  reason: collision with root package name */
    public NewWriteModel.g f19482g;

    /* renamed from: h  reason: collision with root package name */
    public b.a.r0.k2.r.f f19483h;

    /* renamed from: i  reason: collision with root package name */
    public View.OnClickListener f19484i;

    public t(TbPageContext tbPageContext, PbFakeFloorModel pbFakeFloorModel, RelativeLayout relativeLayout) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {tbPageContext, pbFakeFloorModel, relativeLayout};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f19477b = tbPageContext;
        this.f19478c = relativeLayout;
        this.f19479d = pbFakeFloorModel;
    }

    public final void a() {
        b.a.q0.x.x.h hVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048576, this) == null) || this.f19478c == null || (hVar = this.f19476a) == null || hVar.a() == null) {
            return;
        }
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, -2);
        layoutParams.addRule(12);
        this.f19478c.addView(this.f19476a.a(), layoutParams);
        h(TbadkCoreApplication.getInst().getSkinType());
    }

    public b.a.q0.x.x.h b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.f19476a : (b.a.q0.x.x.h) invokeV.objValue;
    }

    public void c() {
        b.a.q0.x.x.h hVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) || (hVar = this.f19476a) == null) {
            return;
        }
        hVar.y();
        if (StringUtils.isNull(this.f19480e)) {
            this.f19476a.D();
        }
        this.f19476a.a().resetChangeToLauncher();
    }

    public void d() {
        b.a.q0.x.x.h hVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048579, this) == null) || (hVar = this.f19476a) == null || hVar.a() == null) {
            return;
        }
        this.f19476a.a().hideTools();
    }

    public final void e(String str, boolean z) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLZ(1048580, this, str, z) == null) && this.f19478c != null && this.f19476a == null) {
            b.a.q0.x.x.i iVar = new b.a.q0.x.x.i(z);
            iVar.i(str);
            b.a.q0.x.x.h hVar = (b.a.q0.x.x.h) iVar.a(this.f19477b.getPageActivity());
            this.f19476a = hVar;
            hVar.N(this.f19477b);
            this.f19476a.a0(this.f19479d);
            this.f19476a.O(1);
            b.a.r0.k2.r.f fVar = this.f19483h;
            if (fVar != null) {
                this.f19476a.b0(fVar.O());
            }
            this.f19476a.a().showLinePositionBottom(true);
            this.f19476a.a().setOnCancelClickListener(this.f19484i);
            this.f19476a.z(this.f19477b);
            a();
            this.f19476a.Q(this.f19482g);
        }
    }

    public boolean f() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) {
            b.a.q0.x.x.h hVar = this.f19476a;
            if (hVar == null || hVar.a() == null) {
                return false;
            }
            return this.f19476a.a().isToolVisible();
        }
        return invokeV.booleanValue;
    }

    public void g(int i2, int i3, Intent intent) {
        b.a.q0.x.x.h hVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeIIL(1048582, this, i2, i3, intent) == null) || (hVar = this.f19476a) == null) {
            return;
        }
        hVar.C(i2, i3, intent);
    }

    public void h(int i2) {
        b.a.q0.x.x.h hVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeI(1048583, this, i2) == null) || (hVar = this.f19476a) == null || hVar.a() == null) {
            return;
        }
        this.f19476a.a().onChangeSkinType(i2);
    }

    public void i() {
        b.a.q0.x.x.h hVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this) == null) || (hVar = this.f19476a) == null) {
            return;
        }
        hVar.E();
    }

    public void j(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048585, this, str) == null) {
            this.f19481f = str;
        }
    }

    public void k(View.OnClickListener onClickListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048586, this, onClickListener) == null) {
            this.f19484i = onClickListener;
        }
    }

    public void l(b.a.r0.k2.r.f fVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048587, this, fVar) == null) {
            this.f19483h = fVar;
        }
    }

    public void m(NewWriteModel.g gVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048588, this, gVar) == null) {
            this.f19482g = gVar;
            b.a.q0.x.x.h hVar = this.f19476a;
            if (hVar != null) {
                hVar.Q(gVar);
            }
        }
    }

    public void n(String str, String str2, String str3, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048589, this, new Object[]{str, str2, str3, Boolean.valueOf(z)}) == null) {
            this.f19480e = str2;
            b.a.q0.x.x.h hVar = this.f19476a;
            if (hVar == null) {
                e(str3, z);
            } else {
                hVar.a0(this.f19479d);
                if (StringUtils.isNull(this.f19480e)) {
                    this.f19476a.z(this.f19477b);
                }
            }
            this.f19476a.W(str);
            this.f19476a.V(str2, "");
            this.f19476a.p(this.f19481f);
            if (this.f19476a.x()) {
                this.f19476a.v(null);
            }
        }
    }
}
