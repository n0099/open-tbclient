package c.a.q0.l3;

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
    public MainTabActivity f21831a;

    /* renamed from: b  reason: collision with root package name */
    public PopupWindow f21832b;

    /* renamed from: c  reason: collision with root package name */
    public FragmentTabHost f21833c;

    /* renamed from: d  reason: collision with root package name */
    public String f21834d;

    /* renamed from: e  reason: collision with root package name */
    public long f21835e;

    /* renamed from: f  reason: collision with root package name */
    public View f21836f;

    /* renamed from: g  reason: collision with root package name */
    public TextView f21837g;

    /* renamed from: h  reason: collision with root package name */
    public TextView f21838h;

    /* renamed from: i  reason: collision with root package name */
    public Runnable f21839i;

    /* renamed from: j  reason: collision with root package name */
    public Runnable f21840j;
    public View.OnClickListener k;

    /* loaded from: classes3.dex */
    public class a implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ c f21841e;

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
            this.f21841e = cVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeV(1048576, this) == null) || this.f21841e.f21833c == null || this.f21841e.f21832b == null || this.f21841e.f21832b.getContentView() == null) {
                return;
            }
            FragmentTabWidget fragmentTabWidget = this.f21841e.f21833c.getFragmentTabWidget();
            int k = l.k(this.f21841e.f21831a.getActivity());
            int g2 = l.g(this.f21841e.f21831a.getActivity(), R.dimen.ds278);
            this.f21841e.f21832b.getContentView().measure(0, 0);
            g.l(this.f21841e.f21832b, fragmentTabWidget, (k - l.g(this.f21841e.f21831a.getActivity(), R.dimen.ds430)) / 2, -g2);
            c.a.p0.s.d0.b.j().w("home_tip", this.f21841e.f21835e);
            c.a.e.e.m.e.a().postDelayed(this.f21841e.f21840j, 5000L);
            TiebaStatic.log(new StatisticItem("c13016").param("obj_locate", 1));
        }
    }

    /* loaded from: classes3.dex */
    public class b implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ c f21842e;

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
            this.f21842e = cVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.f21842e.g();
            }
        }
    }

    /* renamed from: c.a.q0.l3.c$c  reason: collision with other inner class name */
    /* loaded from: classes3.dex */
    public class View$OnClickListenerC1013c implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ c f21843e;

        public View$OnClickListenerC1013c(c cVar) {
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
            this.f21843e = cVar;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view) == null) {
                this.f21843e.h();
                if (WriteActivityConfig.isAsyncWriting()) {
                    return;
                }
                WriteActivityConfig.newInstance(this.f21843e.f21831a).setType(9).setTitle(this.f21843e.f21834d).setForumId("0").send();
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
        this.f21839i = new a(this);
        this.f21840j = new b(this);
        this.k = new View$OnClickListenerC1013c(this);
        this.f21831a = mainTabActivity;
        this.f21833c = (FragmentTabHost) mainTabActivity.findViewById(R.id.tab_host);
    }

    public void g() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            g.c(this.f21832b);
        }
    }

    public void h() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            c.a.e.e.m.e.a().removeCallbacks(this.f21839i);
            c.a.e.e.m.e.a().removeCallbacks(this.f21840j);
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
        if (!(interceptable == null || interceptable.invokeCommon(1048579, this, new Object[]{str, str2, Long.valueOf(j2)}) == null) || c.a.p0.s.d0.b.j().l("home_tip", 0L) == j2 || StringUtils.isNull(str) || StringUtils.isNull(str2)) {
            return;
        }
        this.f21834d = str2;
        this.f21835e = j2;
        if (this.f21836f == null) {
            View inflate = LayoutInflater.from(this.f21831a.getActivity()).inflate(R.layout.tips_blue_twice_line_down, (ViewGroup) null);
            this.f21836f = inflate;
            this.f21837g = (TextView) inflate.findViewById(R.id.tips);
            this.f21838h = (TextView) this.f21836f.findViewById(R.id.tips_content);
            this.f21836f.setOnClickListener(this.k);
        }
        this.f21837g.setText(StringHelper.cutHotTopicShow(str, 24, "..."));
        this.f21838h.setText(R.string.topic_join);
        if (this.f21832b == null) {
            this.f21832b = new PopupWindow(this.f21836f, -2, -2);
        } else {
            h();
        }
        c.a.e.e.m.e.a().removeCallbacks(this.f21839i);
        c.a.e.e.m.e.a().postDelayed(this.f21839i, 100L);
    }
}
