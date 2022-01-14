package c.a.t0.s2.u.f.b1;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import c.a.s0.e1.g0;
import com.baidu.adp.widget.ListView.BdTypeListView;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.elementsMaven.view.EMTextView;
import com.baidu.tbadk.core.util.CommonStatisticKey;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tbadk.core.util.StatisticItem;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes8.dex */
public class c {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    @NonNull
    public View a;

    /* renamed from: b  reason: collision with root package name */
    public ViewGroup f22651b;

    /* renamed from: c  reason: collision with root package name */
    public EMTextView f22652c;
    @NonNull

    /* renamed from: d  reason: collision with root package name */
    public g0<String> f22653d;

    /* renamed from: e  reason: collision with root package name */
    public boolean f22654e;

    /* loaded from: classes8.dex */
    public interface a {
        void a(boolean z);
    }

    public c(@NonNull Context context) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f22653d = g0.b();
        this.f22654e = false;
        this.a = LayoutInflater.from(context).inflate(c.a.t0.s2.j.new_pb_notice_bar, (ViewGroup) null);
        b();
    }

    public void a(@NonNull BdTypeListView bdTypeListView) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048576, this, bdTypeListView) == null) || this.f22654e) {
            return;
        }
        this.f22654e = true;
        this.a.setVisibility(0);
        bdTypeListView.addHeaderView(this.a, 1);
    }

    public final void b() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            this.f22651b = (ViewGroup) this.a.findViewById(c.a.t0.s2.i.container);
            EMTextView eMTextView = (EMTextView) this.a.findViewById(c.a.t0.s2.i.tv_pb_notice_bar);
            this.f22652c = eMTextView;
            c.a.s0.s.u.c d2 = c.a.s0.s.u.c.d(eMTextView);
            d2.w(c.a.t0.s2.g.M_H_X003);
            d2.v(c.a.t0.s2.f.CAM_X0109);
            d2.A(c.a.t0.s2.l.F_X01);
        }
    }

    public void c() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            c.a.s0.s.u.c d2 = c.a.s0.s.u.c.d(this.f22651b);
            d2.n(c.a.t0.s2.l.J_X05);
            d2.f(c.a.t0.s2.f.CAM_X0206);
            SkinManager.setViewTextColor(this.f22652c, c.a.t0.s2.f.CAM_X0109);
        }
    }

    public void d(@NonNull BdTypeListView bdTypeListView) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048579, this, bdTypeListView) == null) && this.f22654e) {
            this.f22654e = false;
            this.a.setVisibility(8);
            bdTypeListView.removeHeaderView(this.a);
        }
    }

    public void e(@NonNull c.a.t0.s2.r.f fVar, int i2, @Nullable a aVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLIL(1048580, this, fVar, i2, aVar) == null) {
            boolean z = true;
            boolean z2 = i2 == 4;
            boolean z3 = i2 == 25;
            if (!z2 && !z3) {
                z = false;
            }
            boolean o0 = fVar.o0(z);
            if (o0) {
                this.f22652c.setText(fVar.x());
                this.a.setVisibility(0);
                f(fVar.Q(), fVar.m(), fVar.n(), z2, z3);
            } else {
                this.a.setVisibility(8);
            }
            if (aVar != null) {
                aVar.a(o0);
            }
        }
    }

    public final void f(@NonNull String str, @NonNull String str2, @NonNull String str3, boolean z, boolean z2) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeCommon(1048581, this, new Object[]{str, str2, str3, Boolean.valueOf(z), Boolean.valueOf(z2)}) == null) && this.f22653d.a(CommonStatisticKey.KEY_SHOW_PB_HEAD_NOTICE_BAR)) {
            int i2 = z ? 1 : 2;
            if (z2) {
                i2 = 3;
            }
            TiebaStatic.log(new StatisticItem(CommonStatisticKey.KEY_SHOW_PB_HEAD_NOTICE_BAR).param("tid", str).param("fid", str2).param("fname", str3).param("uid", TbadkCoreApplication.getCurrentAccountId()).param("obj_source", i2));
        }
    }

    public c(@NonNull View view) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {view};
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.f22653d = g0.b();
        this.f22654e = false;
        this.a = view;
        b();
    }
}
