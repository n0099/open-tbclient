package c.a.r0.j2.k.e;

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
/* loaded from: classes3.dex */
public class t {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public c.a.q0.x.w.h f20310a;

    /* renamed from: b  reason: collision with root package name */
    public TbPageContext f20311b;

    /* renamed from: c  reason: collision with root package name */
    public RelativeLayout f20312c;

    /* renamed from: d  reason: collision with root package name */
    public PbFakeFloorModel f20313d;

    /* renamed from: e  reason: collision with root package name */
    public String f20314e;

    /* renamed from: f  reason: collision with root package name */
    public String f20315f;

    /* renamed from: g  reason: collision with root package name */
    public NewWriteModel.g f20316g;

    /* renamed from: h  reason: collision with root package name */
    public c.a.r0.j2.h.e f20317h;

    /* renamed from: i  reason: collision with root package name */
    public View.OnClickListener f20318i;

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
        this.f20311b = tbPageContext;
        this.f20312c = relativeLayout;
        this.f20313d = pbFakeFloorModel;
    }

    public final void a() {
        c.a.q0.x.w.h hVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048576, this) == null) || this.f20312c == null || (hVar = this.f20310a) == null || hVar.a() == null) {
            return;
        }
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, -2);
        layoutParams.addRule(12);
        this.f20312c.addView(this.f20310a.a(), layoutParams);
        h(TbadkCoreApplication.getInst().getSkinType());
    }

    public c.a.q0.x.w.h b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.f20310a : (c.a.q0.x.w.h) invokeV.objValue;
    }

    public void c() {
        c.a.q0.x.w.h hVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) || (hVar = this.f20310a) == null) {
            return;
        }
        hVar.z();
        if (StringUtils.isNull(this.f20314e)) {
            this.f20310a.E();
        }
        this.f20310a.a().resetChangeToLauncher();
    }

    public void d() {
        c.a.q0.x.w.h hVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048579, this) == null) || (hVar = this.f20310a) == null || hVar.a() == null) {
            return;
        }
        this.f20310a.a().hideTools();
    }

    public final void e(String str, boolean z) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLZ(1048580, this, str, z) == null) && this.f20312c != null && this.f20310a == null) {
            c.a.q0.x.w.i iVar = new c.a.q0.x.w.i(z);
            iVar.i(str);
            c.a.q0.x.w.h hVar = (c.a.q0.x.w.h) iVar.a(this.f20311b.getPageActivity());
            this.f20310a = hVar;
            hVar.O(this.f20311b);
            this.f20310a.b0(this.f20313d);
            this.f20310a.P(1);
            c.a.r0.j2.h.e eVar = this.f20317h;
            if (eVar != null) {
                this.f20310a.c0(eVar.O());
            }
            this.f20310a.a().showLinePositionBottom(true);
            this.f20310a.a().setOnCancelClickListener(this.f20318i);
            this.f20310a.A(this.f20311b);
            a();
            this.f20310a.R(this.f20316g);
        }
    }

    public boolean f() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) {
            c.a.q0.x.w.h hVar = this.f20310a;
            if (hVar == null || hVar.a() == null) {
                return false;
            }
            return this.f20310a.a().isToolVisible();
        }
        return invokeV.booleanValue;
    }

    public void g(int i2, int i3, Intent intent) {
        c.a.q0.x.w.h hVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeIIL(1048582, this, i2, i3, intent) == null) || (hVar = this.f20310a) == null) {
            return;
        }
        hVar.D(i2, i3, intent);
    }

    public void h(int i2) {
        c.a.q0.x.w.h hVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeI(1048583, this, i2) == null) || (hVar = this.f20310a) == null || hVar.a() == null) {
            return;
        }
        this.f20310a.a().onChangeSkinType(i2);
    }

    public void i() {
        c.a.q0.x.w.h hVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this) == null) || (hVar = this.f20310a) == null) {
            return;
        }
        hVar.F();
    }

    public void j(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048585, this, str) == null) {
            this.f20315f = str;
        }
    }

    public void k(View.OnClickListener onClickListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048586, this, onClickListener) == null) {
            this.f20318i = onClickListener;
        }
    }

    public void l(c.a.r0.j2.h.e eVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048587, this, eVar) == null) {
            this.f20317h = eVar;
        }
    }

    public void m(NewWriteModel.g gVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048588, this, gVar) == null) {
            this.f20316g = gVar;
            c.a.q0.x.w.h hVar = this.f20310a;
            if (hVar != null) {
                hVar.R(gVar);
            }
        }
    }

    public void n(String str, String str2, String str3, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048589, this, new Object[]{str, str2, str3, Boolean.valueOf(z)}) == null) {
            this.f20314e = str2;
            c.a.q0.x.w.h hVar = this.f20310a;
            if (hVar == null) {
                e(str3, z);
            } else {
                hVar.b0(this.f20313d);
                if (StringUtils.isNull(this.f20314e)) {
                    this.f20310a.A(this.f20311b);
                }
            }
            this.f20310a.X(str);
            this.f20310a.W(str2, "");
            this.f20310a.p(this.f20315f);
            if (this.f20310a.y()) {
                this.f20310a.w(null);
            }
        }
    }
}
