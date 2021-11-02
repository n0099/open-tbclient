package b.a.r0.o3;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.PopupWindow;
import android.widget.TextView;
import b.a.e.e.p.l;
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
    public MainTabActivity f22062a;

    /* renamed from: b  reason: collision with root package name */
    public PopupWindow f22063b;

    /* renamed from: c  reason: collision with root package name */
    public FragmentTabHost f22064c;

    /* renamed from: d  reason: collision with root package name */
    public String f22065d;

    /* renamed from: e  reason: collision with root package name */
    public long f22066e;

    /* renamed from: f  reason: collision with root package name */
    public View f22067f;

    /* renamed from: g  reason: collision with root package name */
    public TextView f22068g;

    /* renamed from: h  reason: collision with root package name */
    public TextView f22069h;

    /* renamed from: i  reason: collision with root package name */
    public Runnable f22070i;
    public Runnable j;
    public View.OnClickListener k;

    /* loaded from: classes5.dex */
    public class a implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ c f22071e;

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
            this.f22071e = cVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeV(1048576, this) == null) || this.f22071e.f22064c == null || this.f22071e.f22063b == null || this.f22071e.f22063b.getContentView() == null) {
                return;
            }
            FragmentTabWidget fragmentTabWidget = this.f22071e.f22064c.getFragmentTabWidget();
            int k = l.k(this.f22071e.f22062a.getActivity());
            int g2 = l.g(this.f22071e.f22062a.getActivity(), R.dimen.ds278);
            this.f22071e.f22063b.getContentView().measure(0, 0);
            b.a.e.e.m.g.l(this.f22071e.f22063b, fragmentTabWidget, (k - l.g(this.f22071e.f22062a.getActivity(), R.dimen.ds430)) / 2, -g2);
            b.a.q0.s.e0.b.j().w("home_tip", this.f22071e.f22066e);
            b.a.e.e.m.e.a().postDelayed(this.f22071e.j, 5000L);
            TiebaStatic.log(new StatisticItem("c13016").param("obj_locate", 1));
        }
    }

    /* loaded from: classes5.dex */
    public class b implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ c f22072e;

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
            this.f22072e = cVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.f22072e.g();
            }
        }
    }

    /* renamed from: b.a.r0.o3.c$c  reason: collision with other inner class name */
    /* loaded from: classes5.dex */
    public class View$OnClickListenerC1076c implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ c f22073e;

        public View$OnClickListenerC1076c(c cVar) {
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
            this.f22073e = cVar;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view) == null) {
                this.f22073e.h();
                if (WriteActivityConfig.isAsyncWriting()) {
                    return;
                }
                WriteActivityConfig.newInstance(this.f22073e.f22062a).setType(9).setTitle(this.f22073e.f22065d).setForumId("0").send();
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
        this.f22070i = new a(this);
        this.j = new b(this);
        this.k = new View$OnClickListenerC1076c(this);
        this.f22062a = mainTabActivity;
        this.f22064c = (FragmentTabHost) mainTabActivity.findViewById(R.id.tab_host);
    }

    public void g() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            b.a.e.e.m.g.c(this.f22063b);
        }
    }

    public void h() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            b.a.e.e.m.e.a().removeCallbacks(this.f22070i);
            b.a.e.e.m.e.a().removeCallbacks(this.j);
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
        this.f22065d = str2;
        this.f22066e = j;
        if (this.f22067f == null) {
            View inflate = LayoutInflater.from(this.f22062a.getActivity()).inflate(R.layout.tips_blue_twice_line_down, (ViewGroup) null);
            this.f22067f = inflate;
            this.f22068g = (TextView) inflate.findViewById(R.id.tips);
            this.f22069h = (TextView) this.f22067f.findViewById(R.id.tips_content);
            this.f22067f.setOnClickListener(this.k);
        }
        this.f22068g.setText(StringHelper.cutHotTopicShow(str, 24, "..."));
        this.f22069h.setText(R.string.topic_join);
        if (this.f22063b == null) {
            this.f22063b = new PopupWindow(this.f22067f, -2, -2);
        } else {
            h();
        }
        b.a.e.e.m.e.a().removeCallbacks(this.f22070i);
        b.a.e.e.m.e.a().postDelayed(this.f22070i, 100L);
    }
}
