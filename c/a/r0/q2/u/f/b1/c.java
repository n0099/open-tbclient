package c.a.r0.q2.u.f.b1;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import c.a.q0.d1.e0;
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
/* loaded from: classes6.dex */
public class c {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    @NonNull
    public View a;

    /* renamed from: b  reason: collision with root package name */
    public ViewGroup f21777b;

    /* renamed from: c  reason: collision with root package name */
    public EMTextView f21778c;
    @NonNull

    /* renamed from: d  reason: collision with root package name */
    public e0<String> f21779d;

    /* renamed from: e  reason: collision with root package name */
    public boolean f21780e;

    /* loaded from: classes6.dex */
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
        this.f21779d = e0.b();
        this.f21780e = false;
        this.a = LayoutInflater.from(context).inflate(c.a.r0.q2.j.new_pb_notice_bar, (ViewGroup) null);
        b();
    }

    public void a(@NonNull BdTypeListView bdTypeListView) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048576, this, bdTypeListView) == null) || this.f21780e) {
            return;
        }
        this.f21780e = true;
        this.a.setVisibility(0);
        bdTypeListView.addHeaderView(this.a, 1);
    }

    public final void b() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            this.f21777b = (ViewGroup) this.a.findViewById(c.a.r0.q2.i.container);
            EMTextView eMTextView = (EMTextView) this.a.findViewById(c.a.r0.q2.i.tv_pb_notice_bar);
            this.f21778c = eMTextView;
            c.a.q0.s.u.c d2 = c.a.q0.s.u.c.d(eMTextView);
            d2.w(c.a.r0.q2.g.M_H_X003);
            d2.v(c.a.r0.q2.f.CAM_X0109);
            d2.A(c.a.r0.q2.l.F_X01);
        }
    }

    public void c() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            c.a.q0.s.u.c d2 = c.a.q0.s.u.c.d(this.f21777b);
            d2.n(c.a.r0.q2.l.J_X05);
            d2.f(c.a.r0.q2.f.CAM_X0206);
            SkinManager.setViewTextColor(this.f21778c, c.a.r0.q2.f.CAM_X0109);
        }
    }

    public void d(@NonNull BdTypeListView bdTypeListView) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048579, this, bdTypeListView) == null) && this.f21780e) {
            this.f21780e = false;
            this.a.setVisibility(8);
            bdTypeListView.removeHeaderView(this.a);
        }
    }

    public void e(@Nullable c.a.r0.q2.r.f fVar, int i2, @Nullable a aVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLIL(1048580, this, fVar, i2, aVar) == null) {
            boolean z = i2 == 4;
            boolean o0 = fVar.o0(z);
            if (o0) {
                this.f21778c.setText(fVar.x());
                this.a.setVisibility(0);
                f(fVar.Q(), fVar.m(), fVar.n(), z);
            } else {
                this.a.setVisibility(8);
            }
            if (aVar != null) {
                aVar.a(o0);
            }
        }
    }

    public final void f(@NonNull String str, @NonNull String str2, @NonNull String str3, boolean z) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeCommon(1048581, this, new Object[]{str, str2, str3, Boolean.valueOf(z)}) == null) && this.f21779d.a(CommonStatisticKey.KEY_SHOW_PB_HEAD_NOTICE_BAR)) {
            TiebaStatic.log(new StatisticItem(CommonStatisticKey.KEY_SHOW_PB_HEAD_NOTICE_BAR).param("tid", str).param("fid", str2).param("fname", str3).param("uid", TbadkCoreApplication.getCurrentAccountId()).param("obj_source", z ? 1 : 2));
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
        this.f21779d = e0.b();
        this.f21780e = false;
        this.a = view;
        b();
    }
}
