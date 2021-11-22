package b.a.r0.p3;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.PopupWindow;
import android.widget.TextView;
import b.a.e.f.p.l;
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
/* loaded from: classes5.dex */
public class c {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public MainTabActivity f23929a;

    /* renamed from: b  reason: collision with root package name */
    public PopupWindow f23930b;

    /* renamed from: c  reason: collision with root package name */
    public FragmentTabHost f23931c;

    /* renamed from: d  reason: collision with root package name */
    public String f23932d;

    /* renamed from: e  reason: collision with root package name */
    public long f23933e;

    /* renamed from: f  reason: collision with root package name */
    public View f23934f;

    /* renamed from: g  reason: collision with root package name */
    public TextView f23935g;

    /* renamed from: h  reason: collision with root package name */
    public TextView f23936h;

    /* renamed from: i  reason: collision with root package name */
    public Runnable f23937i;
    public Runnable j;
    public View.OnClickListener k;

    /* loaded from: classes5.dex */
    public class a implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ c f23938e;

        public a(c cVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {cVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f23938e = cVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeV(1048576, this) == null) || this.f23938e.f23931c == null || this.f23938e.f23930b == null || this.f23938e.f23930b.getContentView() == null) {
                return;
            }
            FragmentTabWidget fragmentTabWidget = this.f23938e.f23931c.getFragmentTabWidget();
            int k = l.k(this.f23938e.f23929a.getActivity());
            int g2 = l.g(this.f23938e.f23929a.getActivity(), R.dimen.ds278);
            this.f23938e.f23930b.getContentView().measure(0, 0);
            b.a.e.f.m.g.l(this.f23938e.f23930b, fragmentTabWidget, (k - l.g(this.f23938e.f23929a.getActivity(), R.dimen.ds430)) / 2, -g2);
            b.a.q0.s.e0.b.j().w("home_tip", this.f23938e.f23933e);
            b.a.e.f.m.e.a().postDelayed(this.f23938e.j, 5000L);
            TiebaStatic.log(new StatisticItem("c13016").param("obj_locate", 1));
        }
    }

    /* loaded from: classes5.dex */
    public class b implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ c f23939e;

        public b(c cVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {cVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f23939e = cVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.f23939e.g();
            }
        }
    }

    /* renamed from: b.a.r0.p3.c$c  reason: collision with other inner class name */
    /* loaded from: classes5.dex */
    public class View$OnClickListenerC1160c implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ c f23940e;

        public View$OnClickListenerC1160c(c cVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {cVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f23940e = cVar;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view) == null) {
                this.f23940e.h();
                if (WriteActivityConfig.isAsyncWriting()) {
                    return;
                }
                WriteActivityConfig.newInstance(this.f23940e.f23929a).setType(9).setTitle(this.f23940e.f23932d).setForumId("0").send();
                TiebaStatic.log(new StatisticItem("c13017").param("obj_locate", 1));
            }
        }
    }

    public c(MainTabActivity mainTabActivity) {
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
        this.f23937i = new a(this);
        this.j = new b(this);
        this.k = new View$OnClickListenerC1160c(this);
        this.f23929a = mainTabActivity;
        this.f23931c = (FragmentTabHost) mainTabActivity.findViewById(R.id.tab_host);
    }

    public void g() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            b.a.e.f.m.g.c(this.f23930b);
        }
    }

    public void h() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            b.a.e.f.m.e.a().removeCallbacks(this.f23937i);
            b.a.e.f.m.e.a().removeCallbacks(this.j);
            g();
        }
    }

    public void i() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            h();
        }
    }

    public void j(String str, String str2, long j) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeCommon(1048579, this, new Object[]{str, str2, Long.valueOf(j)}) == null) || b.a.q0.s.e0.b.j().l("home_tip", 0L) == j || StringUtils.isNull(str) || StringUtils.isNull(str2)) {
            return;
        }
        this.f23932d = str2;
        this.f23933e = j;
        if (this.f23934f == null) {
            View inflate = LayoutInflater.from(this.f23929a.getActivity()).inflate(R.layout.tips_blue_twice_line_down, (ViewGroup) null);
            this.f23934f = inflate;
            this.f23935g = (TextView) inflate.findViewById(R.id.tips);
            this.f23936h = (TextView) this.f23934f.findViewById(R.id.tips_content);
            this.f23934f.setOnClickListener(this.k);
        }
        this.f23935g.setText(StringHelper.cutHotTopicShow(str, 24, "..."));
        this.f23936h.setText(R.string.topic_join);
        if (this.f23930b == null) {
            this.f23930b = new PopupWindow(this.f23934f, -2, -2);
        } else {
            h();
        }
        b.a.e.f.m.e.a().removeCallbacks(this.f23937i);
        b.a.e.f.m.e.a().postDelayed(this.f23937i, 100L);
    }
}
