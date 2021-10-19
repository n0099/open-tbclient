package c.a.r0.k2.k.e.a1;

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
    public View f19982a;

    /* renamed from: b  reason: collision with root package name */
    public ViewGroup f19983b;

    /* renamed from: c  reason: collision with root package name */
    public EMTextView f19984c;
    @NonNull

    /* renamed from: d  reason: collision with root package name */
    public e0<String> f19985d;

    /* renamed from: e  reason: collision with root package name */
    public boolean f19986e;

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
        this.f19985d = e0.b();
        this.f19986e = false;
        this.f19982a = LayoutInflater.from(context).inflate(R.layout.new_pb_notice_bar, (ViewGroup) null);
        b();
    }

    public void a(@NonNull BdTypeListView bdTypeListView) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048576, this, bdTypeListView) == null) || this.f19986e) {
            return;
        }
        this.f19986e = true;
        this.f19982a.setVisibility(0);
        bdTypeListView.addHeaderView(this.f19982a, 1);
    }

    public final void b() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            this.f19983b = (ViewGroup) this.f19982a.findViewById(R.id.container);
            EMTextView eMTextView = (EMTextView) this.f19982a.findViewById(R.id.tv_pb_notice_bar);
            this.f19984c = eMTextView;
            c.a.q0.s.u.c d2 = c.a.q0.s.u.c.d(eMTextView);
            d2.w(R.dimen.M_H_X003);
            d2.v(R.color.CAM_X0109);
            d2.A(R.string.F_X01);
        }
    }

    public void c() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            c.a.q0.s.u.c d2 = c.a.q0.s.u.c.d(this.f19983b);
            d2.n(R.string.J_X05);
            d2.f(R.color.CAM_X0206);
            SkinManager.setViewTextColor(this.f19984c, R.color.CAM_X0109);
        }
    }

    public void d(@NonNull BdTypeListView bdTypeListView) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048579, this, bdTypeListView) == null) && this.f19986e) {
            this.f19986e = false;
            this.f19982a.setVisibility(8);
            bdTypeListView.removeHeaderView(this.f19982a);
        }
    }

    public void e(@Nullable c.a.r0.k2.h.e eVar, int i2, @Nullable a aVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLIL(1048580, this, eVar, i2, aVar) == null) {
            boolean z = i2 == 4;
            boolean n0 = eVar.n0(z);
            if (n0) {
                this.f19984c.setText(eVar.x());
                this.f19982a.setVisibility(0);
                f(eVar.Q(), eVar.n(), eVar.o(), z);
            } else {
                this.f19982a.setVisibility(8);
            }
            if (aVar != null) {
                aVar.a(n0);
            }
        }
    }

    public final void f(@NonNull String str, @NonNull String str2, @NonNull String str3, boolean z) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeCommon(1048581, this, new Object[]{str, str2, str3, Boolean.valueOf(z)}) == null) && this.f19985d.a(CommonStatisticKey.KEY_SHOW_PB_HEAD_NOTICE_BAR)) {
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
        this.f19985d = e0.b();
        this.f19986e = false;
        this.f19982a = view;
        b();
    }
}
