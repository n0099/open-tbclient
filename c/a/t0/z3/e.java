package c.a.t0.z3;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.PopupWindow;
import android.widget.TextView;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.atomData.WriteActivityConfig;
import com.baidu.tbadk.core.tabHost.FragmentTabHost;
import com.baidu.tbadk.core.tabHost.FragmentTabWidget;
import com.baidu.tbadk.core.util.StatisticItem;
import com.baidu.tbadk.core.util.StringHelper;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tieba.tblauncher.MainTabActivity;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes9.dex */
public class e {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public MainTabActivity a;

    /* renamed from: b  reason: collision with root package name */
    public PopupWindow f26112b;

    /* renamed from: c  reason: collision with root package name */
    public FragmentTabHost f26113c;

    /* renamed from: d  reason: collision with root package name */
    public String f26114d;

    /* renamed from: e  reason: collision with root package name */
    public long f26115e;

    /* renamed from: f  reason: collision with root package name */
    public View f26116f;

    /* renamed from: g  reason: collision with root package name */
    public TextView f26117g;

    /* renamed from: h  reason: collision with root package name */
    public TextView f26118h;

    /* renamed from: i  reason: collision with root package name */
    public Runnable f26119i;

    /* renamed from: j  reason: collision with root package name */
    public Runnable f26120j;
    public View.OnClickListener k;

    /* loaded from: classes9.dex */
    public class a implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ e f26121e;

        public a(e eVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {eVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f26121e = eVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeV(1048576, this) == null) || this.f26121e.f26113c == null || this.f26121e.f26112b == null || this.f26121e.f26112b.getContentView() == null) {
                return;
            }
            FragmentTabWidget fragmentTabWidget = this.f26121e.f26113c.getFragmentTabWidget();
            int k = c.a.d.f.p.n.k(this.f26121e.a.getActivity());
            int f2 = c.a.d.f.p.n.f(this.f26121e.a.getActivity(), m.ds278);
            this.f26121e.f26112b.getContentView().measure(0, 0);
            c.a.d.f.m.g.l(this.f26121e.f26112b, fragmentTabWidget, (k - c.a.d.f.p.n.f(this.f26121e.a.getActivity(), m.ds430)) / 2, -f2);
            c.a.s0.s.h0.b.k().x("home_tip", this.f26121e.f26115e);
            c.a.d.f.m.e.a().postDelayed(this.f26121e.f26120j, 5000L);
            TiebaStatic.log(new StatisticItem("c13016").param("obj_locate", 1));
        }
    }

    /* loaded from: classes9.dex */
    public class b implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ e f26122e;

        public b(e eVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {eVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f26122e = eVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.f26122e.g();
            }
        }
    }

    /* loaded from: classes9.dex */
    public class c implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ e f26123e;

        public c(e eVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {eVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f26123e = eVar;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view) == null) {
                this.f26123e.h();
                if (WriteActivityConfig.isAsyncWriting()) {
                    return;
                }
                WriteActivityConfig.newInstance(this.f26123e.a).setType(9).setTitle(this.f26123e.f26114d).setForumId("0").send();
                TiebaStatic.log(new StatisticItem("c13017").param("obj_locate", 1));
            }
        }
    }

    public e(MainTabActivity mainTabActivity) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {mainTabActivity};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f26119i = new a(this);
        this.f26120j = new b(this);
        this.k = new c(this);
        this.a = mainTabActivity;
        this.f26113c = (FragmentTabHost) mainTabActivity.findViewById(o.tab_host);
    }

    public void g() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            c.a.d.f.m.g.c(this.f26112b);
        }
    }

    public void h() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            c.a.d.f.m.e.a().removeCallbacks(this.f26119i);
            c.a.d.f.m.e.a().removeCallbacks(this.f26120j);
            g();
        }
    }

    public void i() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            h();
        }
    }

    public void j(String str, String str2, long j2) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeCommon(1048579, this, new Object[]{str, str2, Long.valueOf(j2)}) == null) || c.a.s0.s.h0.b.k().m("home_tip", 0L) == j2 || StringUtils.isNull(str) || StringUtils.isNull(str2)) {
            return;
        }
        this.f26114d = str2;
        this.f26115e = j2;
        if (this.f26116f == null) {
            View inflate = LayoutInflater.from(this.a.getActivity()).inflate(p.tips_blue_twice_line_down, (ViewGroup) null);
            this.f26116f = inflate;
            this.f26117g = (TextView) inflate.findViewById(o.tips);
            this.f26118h = (TextView) this.f26116f.findViewById(o.tips_content);
            this.f26116f.setOnClickListener(this.k);
        }
        this.f26117g.setText(StringHelper.cutHotTopicShow(str, 24, "..."));
        this.f26118h.setText(q.topic_join);
        if (this.f26112b == null) {
            this.f26112b = new PopupWindow(this.f26116f, -2, -2);
        } else {
            h();
        }
        c.a.d.f.m.e.a().removeCallbacks(this.f26119i);
        c.a.d.f.m.e.a().postDelayed(this.f26119i, 100L);
    }
}
