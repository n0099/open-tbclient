package c.a.p0.w2.m.f;

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
public class x {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public c.a.o0.w.y.h a;

    /* renamed from: b  reason: collision with root package name */
    public TbPageContext f20335b;

    /* renamed from: c  reason: collision with root package name */
    public RelativeLayout f20336c;

    /* renamed from: d  reason: collision with root package name */
    public PbFakeFloorModel f20337d;

    /* renamed from: e  reason: collision with root package name */
    public String f20338e;

    /* renamed from: f  reason: collision with root package name */
    public String f20339f;

    /* renamed from: g  reason: collision with root package name */
    public NewWriteModel.g f20340g;

    /* renamed from: h  reason: collision with root package name */
    public c.a.p0.w2.i.f f20341h;
    public View.OnClickListener i;

    public x(TbPageContext tbPageContext, PbFakeFloorModel pbFakeFloorModel, RelativeLayout relativeLayout) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {tbPageContext, pbFakeFloorModel, relativeLayout};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f20335b = tbPageContext;
        this.f20336c = relativeLayout;
        this.f20337d = pbFakeFloorModel;
    }

    public final void a() {
        c.a.o0.w.y.h hVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048576, this) == null) || this.f20336c == null || (hVar = this.a) == null || hVar.a() == null) {
            return;
        }
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, -2);
        layoutParams.addRule(12);
        this.f20336c.addView(this.a.a(), layoutParams);
        h(TbadkCoreApplication.getInst().getSkinType());
    }

    public c.a.o0.w.y.h b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.a : (c.a.o0.w.y.h) invokeV.objValue;
    }

    public void c() {
        c.a.o0.w.y.h hVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) || (hVar = this.a) == null) {
            return;
        }
        hVar.y();
        if (StringUtils.isNull(this.f20338e)) {
            this.a.D();
        }
        this.a.a().y();
    }

    public void d() {
        c.a.o0.w.y.h hVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048579, this) == null) || (hVar = this.a) == null || hVar.a() == null) {
            return;
        }
        this.a.a().q();
    }

    public final void e(String str, boolean z) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLZ(1048580, this, str, z) == null) && this.f20336c != null && this.a == null) {
            c.a.o0.w.y.i iVar = new c.a.o0.w.y.i(z);
            iVar.i(str);
            c.a.o0.w.y.h hVar = (c.a.o0.w.y.h) iVar.a(this.f20335b.getPageActivity());
            this.a = hVar;
            hVar.N(this.f20335b);
            this.a.a0(this.f20337d);
            this.a.O(1);
            c.a.p0.w2.i.f fVar = this.f20341h;
            if (fVar != null) {
                this.a.b0(fVar.O());
            }
            this.a.a().C(true);
            this.a.a().setOnCancelClickListener(this.i);
            this.a.z(this.f20335b);
            a();
            this.a.Q(this.f20340g);
        }
    }

    public boolean f() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) {
            c.a.o0.w.y.h hVar = this.a;
            if (hVar == null || hVar.a() == null) {
                return false;
            }
            return this.a.a().u();
        }
        return invokeV.booleanValue;
    }

    public void g(int i, int i2, Intent intent) {
        c.a.o0.w.y.h hVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeIIL(1048582, this, i, i2, intent) == null) || (hVar = this.a) == null) {
            return;
        }
        hVar.C(i, i2, intent);
    }

    public void h(int i) {
        c.a.o0.w.y.h hVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeI(1048583, this, i) == null) || (hVar = this.a) == null || hVar.a() == null) {
            return;
        }
        this.a.a().w(i);
    }

    public void i() {
        c.a.o0.w.y.h hVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this) == null) || (hVar = this.a) == null) {
            return;
        }
        hVar.E();
    }

    public void j(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048585, this, str) == null) {
            this.f20339f = str;
        }
    }

    public void k(View.OnClickListener onClickListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048586, this, onClickListener) == null) {
            this.i = onClickListener;
        }
    }

    public void l(int i) {
        c.a.o0.w.y.h hVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeI(1048587, this, i) == null) || (hVar = this.a) == null) {
            return;
        }
        hVar.P(i);
    }

    public void m(c.a.p0.w2.i.f fVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048588, this, fVar) == null) {
            this.f20341h = fVar;
        }
    }

    public void n(NewWriteModel.g gVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048589, this, gVar) == null) {
            this.f20340g = gVar;
            c.a.o0.w.y.h hVar = this.a;
            if (hVar != null) {
                hVar.Q(gVar);
            }
        }
    }

    public void o(String str, String str2, String str3, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048590, this, new Object[]{str, str2, str3, Boolean.valueOf(z)}) == null) {
            this.f20338e = str2;
            c.a.o0.w.y.h hVar = this.a;
            if (hVar == null) {
                e(str3, z);
            } else {
                hVar.a0(this.f20337d);
                if (StringUtils.isNull(this.f20338e)) {
                    this.a.z(this.f20335b);
                }
            }
            this.a.W(str);
            this.a.V(str2, "");
            this.a.p(this.f20339f);
            if (this.a.x()) {
                this.a.v(null);
            }
        }
    }
}
