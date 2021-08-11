package c.a.p0.i2.k.e.a1;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import c.a.o0.b1.b0;
import com.baidu.adp.widget.ListView.BdTypeListView;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.elementsMaven.view.EMTextView;
import com.baidu.tbadk.core.util.CommonStatisticKey;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tbadk.core.util.StatisticItem;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tieba.R;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes3.dex */
public class c {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    @NonNull

    /* renamed from: a  reason: collision with root package name */
    public View f18916a;

    /* renamed from: b  reason: collision with root package name */
    public ViewGroup f18917b;

    /* renamed from: c  reason: collision with root package name */
    public EMTextView f18918c;
    @NonNull

    /* renamed from: d  reason: collision with root package name */
    public b0<String> f18919d;

    /* renamed from: e  reason: collision with root package name */
    public boolean f18920e;

    /* loaded from: classes3.dex */
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
        this.f18919d = b0.b();
        this.f18920e = false;
        this.f18916a = LayoutInflater.from(context).inflate(R.layout.new_pb_notice_bar, (ViewGroup) null);
        b();
    }

    public void a(@NonNull BdTypeListView bdTypeListView) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048576, this, bdTypeListView) == null) || this.f18920e) {
            return;
        }
        this.f18920e = true;
        this.f18916a.setVisibility(0);
        bdTypeListView.addHeaderView(this.f18916a, 1);
    }

    public final void b() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            this.f18917b = (ViewGroup) this.f18916a.findViewById(R.id.container);
            EMTextView eMTextView = (EMTextView) this.f18916a.findViewById(R.id.tv_pb_notice_bar);
            this.f18918c = eMTextView;
            c.a.o0.s.u.c d2 = c.a.o0.s.u.c.d(eMTextView);
            d2.u(R.dimen.M_H_X003);
            d2.t(R.color.CAM_X0109);
            d2.y(R.string.F_X01);
        }
    }

    public void c() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            c.a.o0.s.u.c d2 = c.a.o0.s.u.c.d(this.f18917b);
            d2.n(R.string.J_X05);
            d2.f(R.color.CAM_X0206);
            SkinManager.setViewTextColor(this.f18918c, R.color.CAM_X0109);
        }
    }

    public void d(@NonNull BdTypeListView bdTypeListView) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048579, this, bdTypeListView) == null) && this.f18920e) {
            this.f18920e = false;
            this.f18916a.setVisibility(8);
            bdTypeListView.removeHeaderView(this.f18916a);
        }
    }

    public void e(@Nullable c.a.p0.i2.h.e eVar, int i2, @Nullable a aVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLIL(1048580, this, eVar, i2, aVar) == null) {
            boolean z = i2 == 4;
            boolean m0 = eVar.m0(z);
            if (m0) {
                this.f18918c.setText(eVar.x());
                this.f18916a.setVisibility(0);
                f(eVar.Q(), eVar.n(), eVar.o(), z);
            } else {
                this.f18916a.setVisibility(8);
            }
            if (aVar != null) {
                aVar.a(m0);
            }
        }
    }

    public final void f(@NonNull String str, @NonNull String str2, @NonNull String str3, boolean z) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeCommon(1048581, this, new Object[]{str, str2, str3, Boolean.valueOf(z)}) == null) && this.f18919d.a(CommonStatisticKey.KEY_SHOW_PB_HEAD_NOTICE_BAR)) {
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
        this.f18919d = b0.b();
        this.f18920e = false;
        this.f18916a = view;
        b();
    }
}
