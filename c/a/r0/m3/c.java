package c.a.r0.m3;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.PopupWindow;
import android.widget.TextView;
import c.a.e.e.m.g;
import c.a.e.e.p.l;
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
/* loaded from: classes3.dex */
public class c {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public MainTabActivity f22420a;

    /* renamed from: b  reason: collision with root package name */
    public PopupWindow f22421b;

    /* renamed from: c  reason: collision with root package name */
    public FragmentTabHost f22422c;

    /* renamed from: d  reason: collision with root package name */
    public String f22423d;

    /* renamed from: e  reason: collision with root package name */
    public long f22424e;

    /* renamed from: f  reason: collision with root package name */
    public View f22425f;

    /* renamed from: g  reason: collision with root package name */
    public TextView f22426g;

    /* renamed from: h  reason: collision with root package name */
    public TextView f22427h;

    /* renamed from: i  reason: collision with root package name */
    public Runnable f22428i;

    /* renamed from: j  reason: collision with root package name */
    public Runnable f22429j;
    public View.OnClickListener k;

    /* loaded from: classes3.dex */
    public class a implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ c f22430e;

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
            this.f22430e = cVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeV(1048576, this) == null) || this.f22430e.f22422c == null || this.f22430e.f22421b == null || this.f22430e.f22421b.getContentView() == null) {
                return;
            }
            FragmentTabWidget fragmentTabWidget = this.f22430e.f22422c.getFragmentTabWidget();
            int k = l.k(this.f22430e.f22420a.getActivity());
            int g2 = l.g(this.f22430e.f22420a.getActivity(), R.dimen.ds278);
            this.f22430e.f22421b.getContentView().measure(0, 0);
            g.l(this.f22430e.f22421b, fragmentTabWidget, (k - l.g(this.f22430e.f22420a.getActivity(), R.dimen.ds430)) / 2, -g2);
            c.a.q0.s.d0.b.j().w("home_tip", this.f22430e.f22424e);
            c.a.e.e.m.e.a().postDelayed(this.f22430e.f22429j, 5000L);
            TiebaStatic.log(new StatisticItem("c13016").param("obj_locate", 1));
        }
    }

    /* loaded from: classes3.dex */
    public class b implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ c f22431e;

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
            this.f22431e = cVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.f22431e.g();
            }
        }
    }

    /* renamed from: c.a.r0.m3.c$c  reason: collision with other inner class name */
    /* loaded from: classes3.dex */
    public class View$OnClickListenerC1044c implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ c f22432e;

        public View$OnClickListenerC1044c(c cVar) {
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
            this.f22432e = cVar;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view) == null) {
                this.f22432e.h();
                if (WriteActivityConfig.isAsyncWriting()) {
                    return;
                }
                WriteActivityConfig.newInstance(this.f22432e.f22420a).setType(9).setTitle(this.f22432e.f22423d).setForumId("0").send();
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
        this.f22428i = new a(this);
        this.f22429j = new b(this);
        this.k = new View$OnClickListenerC1044c(this);
        this.f22420a = mainTabActivity;
        this.f22422c = (FragmentTabHost) mainTabActivity.findViewById(R.id.tab_host);
    }

    public void g() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            g.c(this.f22421b);
        }
    }

    public void h() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            c.a.e.e.m.e.a().removeCallbacks(this.f22428i);
            c.a.e.e.m.e.a().removeCallbacks(this.f22429j);
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
        if (!(interceptable == null || interceptable.invokeCommon(1048579, this, new Object[]{str, str2, Long.valueOf(j2)}) == null) || c.a.q0.s.d0.b.j().l("home_tip", 0L) == j2 || StringUtils.isNull(str) || StringUtils.isNull(str2)) {
            return;
        }
        this.f22423d = str2;
        this.f22424e = j2;
        if (this.f22425f == null) {
            View inflate = LayoutInflater.from(this.f22420a.getActivity()).inflate(R.layout.tips_blue_twice_line_down, (ViewGroup) null);
            this.f22425f = inflate;
            this.f22426g = (TextView) inflate.findViewById(R.id.tips);
            this.f22427h = (TextView) this.f22425f.findViewById(R.id.tips_content);
            this.f22425f.setOnClickListener(this.k);
        }
        this.f22426g.setText(StringHelper.cutHotTopicShow(str, 24, "..."));
        this.f22427h.setText(R.string.topic_join);
        if (this.f22421b == null) {
            this.f22421b = new PopupWindow(this.f22425f, -2, -2);
        } else {
            h();
        }
        c.a.e.e.m.e.a().removeCallbacks(this.f22428i);
        c.a.e.e.m.e.a().postDelayed(this.f22428i, 100L);
    }
}
