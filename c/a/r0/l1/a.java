package c.a.r0.l1;

import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import c.a.q0.e1.q.a.d.f;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.BaseActivity;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tieba.R;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.Date;
/* loaded from: classes2.dex */
public class a {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public BaseActivity<?> a;

    /* renamed from: b  reason: collision with root package name */
    public c.a.q0.e1.q.a.f.b f18903b;

    /* renamed from: c  reason: collision with root package name */
    public c f18904c;

    /* renamed from: d  reason: collision with root package name */
    public final f f18905d;

    /* renamed from: c.a.r0.l1.a$a  reason: collision with other inner class name */
    /* loaded from: classes2.dex */
    public class C1182a implements f {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ a a;

        public C1182a(a aVar) {
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

        @Override // c.a.q0.e1.q.a.d.f
        public void a(Date date, View view) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeLL(1048576, this, date, view) == null) || date == null || this.a.a == null) {
                return;
            }
            if (date.getTime() > System.currentTimeMillis()) {
                this.a.a.showToast(R.string.person_center_birthday_time_limit);
                return;
            }
            long time = date.getTime() / 1000;
            if (this.a.f18904c != null) {
                this.a.f18904c.a(date, time);
            }
        }
    }

    /* loaded from: classes2.dex */
    public class b implements c.a.q0.e1.q.a.d.a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ a a;

        /* renamed from: c.a.r0.l1.a$b$a  reason: collision with other inner class name */
        /* loaded from: classes2.dex */
        public class View$OnClickListenerC1183a implements View.OnClickListener {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: e  reason: collision with root package name */
            public final /* synthetic */ b f18906e;

            public View$OnClickListenerC1183a(b bVar) {
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
                this.f18906e = bVar;
            }

            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                Interceptable interceptable = $ic;
                if (!(interceptable == null || interceptable.invokeL(1048576, this, view) == null) || this.f18906e.a.f18903b == null) {
                    return;
                }
                this.f18906e.a.f18903b.f();
            }
        }

        /* renamed from: c.a.r0.l1.a$b$b  reason: collision with other inner class name */
        /* loaded from: classes2.dex */
        public class View$OnClickListenerC1184b implements View.OnClickListener {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: e  reason: collision with root package name */
            public final /* synthetic */ b f18907e;

            public View$OnClickListenerC1184b(b bVar) {
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
                this.f18907e = bVar;
            }

            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                Interceptable interceptable = $ic;
                if (!(interceptable == null || interceptable.invokeL(1048576, this, view) == null) || this.f18907e.a.f18903b == null) {
                    return;
                }
                this.f18907e.a.f18903b.A();
                this.f18907e.a.f18903b.f();
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

        @Override // c.a.q0.e1.q.a.d.a
        public void a(View view) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view) == null) {
                SkinManager.setBackgroundResource(view, R.drawable.person_birthday_select_top_bg);
                TextView textView = (TextView) view.findViewById(R.id.person_constellation_cancle);
                textView.setOnClickListener(new View$OnClickListenerC1183a(this));
                SkinManager.setViewTextColor(textView, R.color.CAM_X0105, 1, TbadkCoreApplication.getInst().getSkinType());
                TextView textView2 = (TextView) view.findViewById(R.id.person_constellation_birthday_complete);
                SkinManager.setViewTextColor(textView2, R.color.CAM_X0302, 1, TbadkCoreApplication.getInst().getSkinType());
                textView2.setOnClickListener(new View$OnClickListenerC1184b(this));
            }
        }
    }

    /* loaded from: classes2.dex */
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
        this.f18905d = new C1182a(this);
        this.a = baseActivity;
    }

    public final c.a.q0.e1.q.a.d.a d() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? new b(this) : (c.a.q0.e1.q.a.d.a) invokeV.objValue;
    }

    public void e(c cVar) {
        BaseActivity<?> baseActivity;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, cVar) == null) || (baseActivity = this.a) == null || baseActivity.isFinishing()) {
            return;
        }
        this.f18904c = cVar;
        if (this.f18903b == null) {
            c.a.q0.e1.q.a.b.a aVar = new c.a.q0.e1.q.a.b.a(this.a, this.f18905d);
            aVar.k(R.layout.person_birthday_select_layout, d());
            aVar.p(new boolean[]{true, true, true, false, false, false});
            aVar.j(this.a.getString(R.string.pickerview_year), this.a.getString(R.string.pickerview_month), this.a.getString(R.string.pickerview_day), this.a.getString(R.string.pickerview_hours), this.a.getString(R.string.pickerview_minutes), this.a.getString(R.string.pickerview_seconds));
            aVar.l(2.0f);
            aVar.b(false);
            aVar.i(SkinManager.getColor(R.color.CAM_X0206));
            aVar.m(SkinManager.getColor(R.color.CAM_X0105));
            aVar.n(SkinManager.getColor(R.color.CAM_X0109));
            aVar.d(SkinManager.getColor(R.color.black_alpha30));
            aVar.e(SkinManager.getColor(R.color.CAM_X0201));
            aVar.c(false);
            aVar.h((ViewGroup) this.a.findViewById(16908290));
            this.f18903b = aVar.a();
        }
        this.f18903b.u();
    }
}
