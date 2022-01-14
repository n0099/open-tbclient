package c.a.t0.l1;

import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import c.a.s0.g1.q.a.d.f;
import c.a.t0.y2.d;
import c.a.t0.y2.e;
import c.a.t0.y2.g;
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
    public c.a.s0.g1.q.a.f.b f19109b;

    /* renamed from: c  reason: collision with root package name */
    public c f19110c;

    /* renamed from: d  reason: collision with root package name */
    public final f f19111d;

    /* renamed from: c.a.t0.l1.a$a  reason: collision with other inner class name */
    /* loaded from: classes7.dex */
    public class C1192a implements f {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ a a;

        public C1192a(a aVar) {
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

        @Override // c.a.s0.g1.q.a.d.f
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
            if (this.a.f19110c != null) {
                this.a.f19110c.a(date, time);
            }
        }
    }

    /* loaded from: classes7.dex */
    public class b implements c.a.s0.g1.q.a.d.a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ a a;

        /* renamed from: c.a.t0.l1.a$b$a  reason: collision with other inner class name */
        /* loaded from: classes7.dex */
        public class View$OnClickListenerC1193a implements View.OnClickListener {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: e  reason: collision with root package name */
            public final /* synthetic */ b f19112e;

            public View$OnClickListenerC1193a(b bVar) {
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
                this.f19112e = bVar;
            }

            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                Interceptable interceptable = $ic;
                if (!(interceptable == null || interceptable.invokeL(1048576, this, view) == null) || this.f19112e.a.f19109b == null) {
                    return;
                }
                this.f19112e.a.f19109b.f();
            }
        }

        /* renamed from: c.a.t0.l1.a$b$b  reason: collision with other inner class name */
        /* loaded from: classes7.dex */
        public class View$OnClickListenerC1194b implements View.OnClickListener {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: e  reason: collision with root package name */
            public final /* synthetic */ b f19113e;

            public View$OnClickListenerC1194b(b bVar) {
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
                this.f19113e = bVar;
            }

            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                Interceptable interceptable = $ic;
                if (!(interceptable == null || interceptable.invokeL(1048576, this, view) == null) || this.f19113e.a.f19109b == null) {
                    return;
                }
                this.f19113e.a.f19109b.A();
                this.f19113e.a.f19109b.f();
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

        @Override // c.a.s0.g1.q.a.d.a
        public void a(View view) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view) == null) {
                SkinManager.setBackgroundResource(view, c.a.t0.y2.c.person_birthday_select_top_bg);
                TextView textView = (TextView) view.findViewById(d.person_constellation_cancle);
                textView.setOnClickListener(new View$OnClickListenerC1193a(this));
                SkinManager.setViewTextColor(textView, c.a.t0.y2.a.CAM_X0105, 1, TbadkCoreApplication.getInst().getSkinType());
                TextView textView2 = (TextView) view.findViewById(d.person_constellation_birthday_complete);
                SkinManager.setViewTextColor(textView2, c.a.t0.y2.a.CAM_X0302, 1, TbadkCoreApplication.getInst().getSkinType());
                textView2.setOnClickListener(new View$OnClickListenerC1194b(this));
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
        this.f19111d = new C1192a(this);
        this.a = baseActivity;
    }

    public final c.a.s0.g1.q.a.d.a d() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? new b(this) : (c.a.s0.g1.q.a.d.a) invokeV.objValue;
    }

    public void e(c cVar) {
        BaseActivity<?> baseActivity;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, cVar) == null) || (baseActivity = this.a) == null || baseActivity.isFinishing()) {
            return;
        }
        this.f19110c = cVar;
        if (this.f19109b == null) {
            c.a.s0.g1.q.a.b.a aVar = new c.a.s0.g1.q.a.b.a(this.a, this.f19111d);
            aVar.k(e.person_birthday_select_layout, d());
            aVar.p(new boolean[]{true, true, true, false, false, false});
            aVar.j(this.a.getString(g.pickerview_year), this.a.getString(g.pickerview_month), this.a.getString(g.pickerview_day), this.a.getString(g.pickerview_hours), this.a.getString(g.pickerview_minutes), this.a.getString(g.pickerview_seconds));
            aVar.l(2.0f);
            aVar.b(false);
            aVar.i(SkinManager.getColor(c.a.t0.y2.a.CAM_X0206));
            aVar.m(SkinManager.getColor(c.a.t0.y2.a.CAM_X0105));
            aVar.n(SkinManager.getColor(c.a.t0.y2.a.CAM_X0109));
            aVar.d(SkinManager.getColor(c.a.t0.y2.a.black_alpha30));
            aVar.e(SkinManager.getColor(c.a.t0.y2.a.CAM_X0201));
            aVar.c(false);
            aVar.h((ViewGroup) this.a.findViewById(16908290));
            this.f19109b = aVar.a();
        }
        this.f19109b.u();
    }
}
