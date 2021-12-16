package c.a.s0.l1;

import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import c.a.r0.f1.q.a.d.f;
import c.a.s0.y2.d;
import c.a.s0.y2.e;
import c.a.s0.y2.g;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.BaseActivity;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.Date;
/* loaded from: classes7.dex */
public class a {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public BaseActivity<?> a;

    /* renamed from: b  reason: collision with root package name */
    public c.a.r0.f1.q.a.f.b f19121b;

    /* renamed from: c  reason: collision with root package name */
    public c f19122c;

    /* renamed from: d  reason: collision with root package name */
    public final f f19123d;

    /* renamed from: c.a.s0.l1.a$a  reason: collision with other inner class name */
    /* loaded from: classes7.dex */
    public class C1153a implements f {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ a a;

        public C1153a(a aVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {aVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = aVar;
        }

        @Override // c.a.r0.f1.q.a.d.f
        public void a(Date date, View view) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeLL(1048576, this, date, view) == null) || date == null || this.a.a == null) {
                return;
            }
            if (date.getTime() > System.currentTimeMillis()) {
                this.a.a.showToast(g.person_center_birthday_time_limit);
                return;
            }
            long time = date.getTime() / 1000;
            if (this.a.f19122c != null) {
                this.a.f19122c.a(date, time);
            }
        }
    }

    /* loaded from: classes7.dex */
    public class b implements c.a.r0.f1.q.a.d.a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ a a;

        /* renamed from: c.a.s0.l1.a$b$a  reason: collision with other inner class name */
        /* loaded from: classes7.dex */
        public class View$OnClickListenerC1154a implements View.OnClickListener {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: e  reason: collision with root package name */
            public final /* synthetic */ b f19124e;

            public View$OnClickListenerC1154a(b bVar) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {bVar};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i2 = newInitContext.flag;
                    if ((i2 & 1) != 0) {
                        int i3 = i2 & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.f19124e = bVar;
            }

            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                Interceptable interceptable = $ic;
                if (!(interceptable == null || interceptable.invokeL(1048576, this, view) == null) || this.f19124e.a.f19121b == null) {
                    return;
                }
                this.f19124e.a.f19121b.f();
            }
        }

        /* renamed from: c.a.s0.l1.a$b$b  reason: collision with other inner class name */
        /* loaded from: classes7.dex */
        public class View$OnClickListenerC1155b implements View.OnClickListener {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: e  reason: collision with root package name */
            public final /* synthetic */ b f19125e;

            public View$OnClickListenerC1155b(b bVar) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {bVar};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i2 = newInitContext.flag;
                    if ((i2 & 1) != 0) {
                        int i3 = i2 & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.f19125e = bVar;
            }

            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                Interceptable interceptable = $ic;
                if (!(interceptable == null || interceptable.invokeL(1048576, this, view) == null) || this.f19125e.a.f19121b == null) {
                    return;
                }
                this.f19125e.a.f19121b.A();
                this.f19125e.a.f19121b.f();
            }
        }

        public b(a aVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {aVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = aVar;
        }

        @Override // c.a.r0.f1.q.a.d.a
        public void a(View view) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view) == null) {
                SkinManager.setBackgroundResource(view, c.a.s0.y2.c.person_birthday_select_top_bg);
                TextView textView = (TextView) view.findViewById(d.person_constellation_cancle);
                textView.setOnClickListener(new View$OnClickListenerC1154a(this));
                SkinManager.setViewTextColor(textView, c.a.s0.y2.a.CAM_X0105, 1, TbadkCoreApplication.getInst().getSkinType());
                TextView textView2 = (TextView) view.findViewById(d.person_constellation_birthday_complete);
                SkinManager.setViewTextColor(textView2, c.a.s0.y2.a.CAM_X0302, 1, TbadkCoreApplication.getInst().getSkinType());
                textView2.setOnClickListener(new View$OnClickListenerC1155b(this));
            }
        }
    }

    /* loaded from: classes7.dex */
    public interface c {
        void a(Date date, long j2);
    }

    public a(BaseActivity<?> baseActivity) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {baseActivity};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f19123d = new C1153a(this);
        this.a = baseActivity;
    }

    public final c.a.r0.f1.q.a.d.a d() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? new b(this) : (c.a.r0.f1.q.a.d.a) invokeV.objValue;
    }

    public void e(c cVar) {
        BaseActivity<?> baseActivity;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, cVar) == null) || (baseActivity = this.a) == null || baseActivity.isFinishing()) {
            return;
        }
        this.f19122c = cVar;
        if (this.f19121b == null) {
            c.a.r0.f1.q.a.b.a aVar = new c.a.r0.f1.q.a.b.a(this.a, this.f19123d);
            aVar.k(e.person_birthday_select_layout, d());
            aVar.p(new boolean[]{true, true, true, false, false, false});
            aVar.j(this.a.getString(g.pickerview_year), this.a.getString(g.pickerview_month), this.a.getString(g.pickerview_day), this.a.getString(g.pickerview_hours), this.a.getString(g.pickerview_minutes), this.a.getString(g.pickerview_seconds));
            aVar.l(2.0f);
            aVar.b(false);
            aVar.i(SkinManager.getColor(c.a.s0.y2.a.CAM_X0206));
            aVar.m(SkinManager.getColor(c.a.s0.y2.a.CAM_X0105));
            aVar.n(SkinManager.getColor(c.a.s0.y2.a.CAM_X0109));
            aVar.d(SkinManager.getColor(c.a.s0.y2.a.black_alpha30));
            aVar.e(SkinManager.getColor(c.a.s0.y2.a.CAM_X0201));
            aVar.c(false);
            aVar.h((ViewGroup) this.a.findViewById(16908290));
            this.f19121b = aVar.a();
        }
        this.f19121b.u();
    }
}
