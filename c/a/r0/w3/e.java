package c.a.r0.w3;

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
import com.baidu.tieba.R;
import com.baidu.tieba.tblauncher.MainTabActivity;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes7.dex */
public class e {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public MainTabActivity a;

    /* renamed from: b  reason: collision with root package name */
    public PopupWindow f25228b;

    /* renamed from: c  reason: collision with root package name */
    public FragmentTabHost f25229c;

    /* renamed from: d  reason: collision with root package name */
    public String f25230d;

    /* renamed from: e  reason: collision with root package name */
    public long f25231e;

    /* renamed from: f  reason: collision with root package name */
    public View f25232f;

    /* renamed from: g  reason: collision with root package name */
    public TextView f25233g;

    /* renamed from: h  reason: collision with root package name */
    public TextView f25234h;

    /* renamed from: i  reason: collision with root package name */
    public Runnable f25235i;

    /* renamed from: j  reason: collision with root package name */
    public Runnable f25236j;

    /* renamed from: k  reason: collision with root package name */
    public View.OnClickListener f25237k;

    /* loaded from: classes7.dex */
    public class a implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ e f25238e;

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
            this.f25238e = eVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeV(1048576, this) == null) || this.f25238e.f25229c == null || this.f25238e.f25228b == null || this.f25238e.f25228b.getContentView() == null) {
                return;
            }
            FragmentTabWidget fragmentTabWidget = this.f25238e.f25229c.getFragmentTabWidget();
            int k2 = c.a.d.f.p.l.k(this.f25238e.a.getActivity());
            int f2 = c.a.d.f.p.l.f(this.f25238e.a.getActivity(), R.dimen.ds278);
            this.f25238e.f25228b.getContentView().measure(0, 0);
            c.a.d.f.m.g.l(this.f25238e.f25228b, fragmentTabWidget, (k2 - c.a.d.f.p.l.f(this.f25238e.a.getActivity(), R.dimen.ds430)) / 2, -f2);
            c.a.q0.s.e0.b.j().w("home_tip", this.f25238e.f25231e);
            c.a.d.f.m.e.a().postDelayed(this.f25238e.f25236j, 5000L);
            TiebaStatic.log(new StatisticItem("c13016").param("obj_locate", 1));
        }
    }

    /* loaded from: classes7.dex */
    public class b implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ e f25239e;

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
            this.f25239e = eVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.f25239e.g();
            }
        }
    }

    /* loaded from: classes7.dex */
    public class c implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ e f25240e;

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
            this.f25240e = eVar;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view) == null) {
                this.f25240e.h();
                if (WriteActivityConfig.isAsyncWriting()) {
                    return;
                }
                WriteActivityConfig.newInstance(this.f25240e.a).setType(9).setTitle(this.f25240e.f25230d).setForumId("0").send();
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
        this.f25235i = new a(this);
        this.f25236j = new b(this);
        this.f25237k = new c(this);
        this.a = mainTabActivity;
        this.f25229c = (FragmentTabHost) mainTabActivity.findViewById(R.id.tab_host);
    }

    public void g() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            c.a.d.f.m.g.c(this.f25228b);
        }
    }

    public void h() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            c.a.d.f.m.e.a().removeCallbacks(this.f25235i);
            c.a.d.f.m.e.a().removeCallbacks(this.f25236j);
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
        if (!(interceptable == null || interceptable.invokeCommon(1048579, this, new Object[]{str, str2, Long.valueOf(j2)}) == null) || c.a.q0.s.e0.b.j().l("home_tip", 0L) == j2 || StringUtils.isNull(str) || StringUtils.isNull(str2)) {
            return;
        }
        this.f25230d = str2;
        this.f25231e = j2;
        if (this.f25232f == null) {
            View inflate = LayoutInflater.from(this.a.getActivity()).inflate(R.layout.tips_blue_twice_line_down, (ViewGroup) null);
            this.f25232f = inflate;
            this.f25233g = (TextView) inflate.findViewById(R.id.tips);
            this.f25234h = (TextView) this.f25232f.findViewById(R.id.tips_content);
            this.f25232f.setOnClickListener(this.f25237k);
        }
        this.f25233g.setText(StringHelper.cutHotTopicShow(str, 24, "..."));
        this.f25234h.setText(R.string.topic_join);
        if (this.f25228b == null) {
            this.f25228b = new PopupWindow(this.f25232f, -2, -2);
        } else {
            h();
        }
        c.a.d.f.m.e.a().removeCallbacks(this.f25235i);
        c.a.d.f.m.e.a().postDelayed(this.f25235i, 100L);
    }
}
