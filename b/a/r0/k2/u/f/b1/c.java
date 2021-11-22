package b.a.r0.k2.u.f.b1;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import b.a.q0.c1.e0;
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
/* loaded from: classes5.dex */
public class c {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    @NonNull

    /* renamed from: a  reason: collision with root package name */
    public View f20571a;

    /* renamed from: b  reason: collision with root package name */
    public ViewGroup f20572b;

    /* renamed from: c  reason: collision with root package name */
    public EMTextView f20573c;
    @NonNull

    /* renamed from: d  reason: collision with root package name */
    public e0<String> f20574d;

    /* renamed from: e  reason: collision with root package name */
    public boolean f20575e;

    /* loaded from: classes5.dex */
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
        this.f20574d = e0.b();
        this.f20575e = false;
        this.f20571a = LayoutInflater.from(context).inflate(b.a.r0.k2.j.new_pb_notice_bar, (ViewGroup) null);
        b();
    }

    public void a(@NonNull BdTypeListView bdTypeListView) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048576, this, bdTypeListView) == null) || this.f20575e) {
            return;
        }
        this.f20575e = true;
        this.f20571a.setVisibility(0);
        bdTypeListView.addHeaderView(this.f20571a, 1);
    }

    public final void b() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            this.f20572b = (ViewGroup) this.f20571a.findViewById(b.a.r0.k2.i.container);
            EMTextView eMTextView = (EMTextView) this.f20571a.findViewById(b.a.r0.k2.i.tv_pb_notice_bar);
            this.f20573c = eMTextView;
            b.a.q0.s.u.c d2 = b.a.q0.s.u.c.d(eMTextView);
            d2.w(b.a.r0.k2.g.M_H_X003);
            d2.v(b.a.r0.k2.f.CAM_X0109);
            d2.A(b.a.r0.k2.l.F_X01);
        }
    }

    public void c() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            b.a.q0.s.u.c d2 = b.a.q0.s.u.c.d(this.f20572b);
            d2.n(b.a.r0.k2.l.J_X05);
            d2.f(b.a.r0.k2.f.CAM_X0206);
            SkinManager.setViewTextColor(this.f20573c, b.a.r0.k2.f.CAM_X0109);
        }
    }

    public void d(@NonNull BdTypeListView bdTypeListView) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048579, this, bdTypeListView) == null) && this.f20575e) {
            this.f20575e = false;
            this.f20571a.setVisibility(8);
            bdTypeListView.removeHeaderView(this.f20571a);
        }
    }

    public void e(@Nullable b.a.r0.k2.r.f fVar, int i2, @Nullable a aVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLIL(1048580, this, fVar, i2, aVar) == null) {
            boolean z = i2 == 4;
            boolean o0 = fVar.o0(z);
            if (o0) {
                this.f20573c.setText(fVar.x());
                this.f20571a.setVisibility(0);
                f(fVar.Q(), fVar.m(), fVar.n(), z);
            } else {
                this.f20571a.setVisibility(8);
            }
            if (aVar != null) {
                aVar.a(o0);
            }
        }
    }

    public final void f(@NonNull String str, @NonNull String str2, @NonNull String str3, boolean z) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeCommon(1048581, this, new Object[]{str, str2, str3, Boolean.valueOf(z)}) == null) && this.f20574d.a(CommonStatisticKey.KEY_SHOW_PB_HEAD_NOTICE_BAR)) {
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
        this.f20574d = e0.b();
        this.f20575e = false;
        this.f20571a = view;
        b();
    }
}
