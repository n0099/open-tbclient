package c.a.s0.y3;

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
/* loaded from: classes8.dex */
public class e {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public MainTabActivity a;

    /* renamed from: b  reason: collision with root package name */
    public PopupWindow f26167b;

    /* renamed from: c  reason: collision with root package name */
    public FragmentTabHost f26168c;

    /* renamed from: d  reason: collision with root package name */
    public String f26169d;

    /* renamed from: e  reason: collision with root package name */
    public long f26170e;

    /* renamed from: f  reason: collision with root package name */
    public View f26171f;

    /* renamed from: g  reason: collision with root package name */
    public TextView f26172g;

    /* renamed from: h  reason: collision with root package name */
    public TextView f26173h;

    /* renamed from: i  reason: collision with root package name */
    public Runnable f26174i;

    /* renamed from: j  reason: collision with root package name */
    public Runnable f26175j;

    /* renamed from: k  reason: collision with root package name */
    public View.OnClickListener f26176k;

    /* loaded from: classes8.dex */
    public class a implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ e f26177e;

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
            this.f26177e = eVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeV(1048576, this) == null) || this.f26177e.f26168c == null || this.f26177e.f26167b == null || this.f26177e.f26167b.getContentView() == null) {
                return;
            }
            FragmentTabWidget fragmentTabWidget = this.f26177e.f26168c.getFragmentTabWidget();
            int k2 = c.a.d.f.p.m.k(this.f26177e.a.getActivity());
            int f2 = c.a.d.f.p.m.f(this.f26177e.a.getActivity(), m.ds278);
            this.f26177e.f26167b.getContentView().measure(0, 0);
            c.a.d.f.m.g.l(this.f26177e.f26167b, fragmentTabWidget, (k2 - c.a.d.f.p.m.f(this.f26177e.a.getActivity(), m.ds430)) / 2, -f2);
            c.a.r0.s.g0.b.j().w("home_tip", this.f26177e.f26170e);
            c.a.d.f.m.e.a().postDelayed(this.f26177e.f26175j, 5000L);
            TiebaStatic.log(new StatisticItem("c13016").param("obj_locate", 1));
        }
    }

    /* loaded from: classes8.dex */
    public class b implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ e f26178e;

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
            this.f26178e = eVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.f26178e.g();
            }
        }
    }

    /* loaded from: classes8.dex */
    public class c implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ e f26179e;

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
            this.f26179e = eVar;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view) == null) {
                this.f26179e.h();
                if (WriteActivityConfig.isAsyncWriting()) {
                    return;
                }
                WriteActivityConfig.newInstance(this.f26179e.a).setType(9).setTitle(this.f26179e.f26169d).setForumId("0").send();
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
        this.f26174i = new a(this);
        this.f26175j = new b(this);
        this.f26176k = new c(this);
        this.a = mainTabActivity;
        this.f26168c = (FragmentTabHost) mainTabActivity.findViewById(o.tab_host);
    }

    public void g() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            c.a.d.f.m.g.c(this.f26167b);
        }
    }

    public void h() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            c.a.d.f.m.e.a().removeCallbacks(this.f26174i);
            c.a.d.f.m.e.a().removeCallbacks(this.f26175j);
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
        if (!(interceptable == null || interceptable.invokeCommon(1048579, this, new Object[]{str, str2, Long.valueOf(j2)}) == null) || c.a.r0.s.g0.b.j().l("home_tip", 0L) == j2 || StringUtils.isNull(str) || StringUtils.isNull(str2)) {
            return;
        }
        this.f26169d = str2;
        this.f26170e = j2;
        if (this.f26171f == null) {
            View inflate = LayoutInflater.from(this.a.getActivity()).inflate(p.tips_blue_twice_line_down, (ViewGroup) null);
            this.f26171f = inflate;
            this.f26172g = (TextView) inflate.findViewById(o.tips);
            this.f26173h = (TextView) this.f26171f.findViewById(o.tips_content);
            this.f26171f.setOnClickListener(this.f26176k);
        }
        this.f26172g.setText(StringHelper.cutHotTopicShow(str, 24, "..."));
        this.f26173h.setText(q.topic_join);
        if (this.f26167b == null) {
            this.f26167b = new PopupWindow(this.f26171f, -2, -2);
        } else {
            h();
        }
        c.a.d.f.m.e.a().removeCallbacks(this.f26174i);
        c.a.d.f.m.e.a().postDelayed(this.f26174i, 100L);
    }
}
