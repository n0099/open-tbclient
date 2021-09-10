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
    public MainTabActivity f22404a;

    /* renamed from: b  reason: collision with root package name */
    public PopupWindow f22405b;

    /* renamed from: c  reason: collision with root package name */
    public FragmentTabHost f22406c;

    /* renamed from: d  reason: collision with root package name */
    public String f22407d;

    /* renamed from: e  reason: collision with root package name */
    public long f22408e;

    /* renamed from: f  reason: collision with root package name */
    public View f22409f;

    /* renamed from: g  reason: collision with root package name */
    public TextView f22410g;

    /* renamed from: h  reason: collision with root package name */
    public TextView f22411h;

    /* renamed from: i  reason: collision with root package name */
    public Runnable f22412i;

    /* renamed from: j  reason: collision with root package name */
    public Runnable f22413j;
    public View.OnClickListener k;

    /* loaded from: classes3.dex */
    public class a implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ c f22414e;

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
            this.f22414e = cVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeV(1048576, this) == null) || this.f22414e.f22406c == null || this.f22414e.f22405b == null || this.f22414e.f22405b.getContentView() == null) {
                return;
            }
            FragmentTabWidget fragmentTabWidget = this.f22414e.f22406c.getFragmentTabWidget();
            int k = l.k(this.f22414e.f22404a.getActivity());
            int g2 = l.g(this.f22414e.f22404a.getActivity(), R.dimen.ds278);
            this.f22414e.f22405b.getContentView().measure(0, 0);
            g.l(this.f22414e.f22405b, fragmentTabWidget, (k - l.g(this.f22414e.f22404a.getActivity(), R.dimen.ds430)) / 2, -g2);
            c.a.q0.s.d0.b.j().w("home_tip", this.f22414e.f22408e);
            c.a.e.e.m.e.a().postDelayed(this.f22414e.f22413j, 5000L);
            TiebaStatic.log(new StatisticItem("c13016").param("obj_locate", 1));
        }
    }

    /* loaded from: classes3.dex */
    public class b implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ c f22415e;

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
            this.f22415e = cVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.f22415e.g();
            }
        }
    }

    /* renamed from: c.a.r0.m3.c$c  reason: collision with other inner class name */
    /* loaded from: classes3.dex */
    public class View$OnClickListenerC1046c implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ c f22416e;

        public View$OnClickListenerC1046c(c cVar) {
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
            this.f22416e = cVar;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view) == null) {
                this.f22416e.h();
                if (WriteActivityConfig.isAsyncWriting()) {
                    return;
                }
                WriteActivityConfig.newInstance(this.f22416e.f22404a).setType(9).setTitle(this.f22416e.f22407d).setForumId("0").send();
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
        this.f22412i = new a(this);
        this.f22413j = new b(this);
        this.k = new View$OnClickListenerC1046c(this);
        this.f22404a = mainTabActivity;
        this.f22406c = (FragmentTabHost) mainTabActivity.findViewById(R.id.tab_host);
    }

    public void g() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            g.c(this.f22405b);
        }
    }

    public void h() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            c.a.e.e.m.e.a().removeCallbacks(this.f22412i);
            c.a.e.e.m.e.a().removeCallbacks(this.f22413j);
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
        this.f22407d = str2;
        this.f22408e = j2;
        if (this.f22409f == null) {
            View inflate = LayoutInflater.from(this.f22404a.getActivity()).inflate(R.layout.tips_blue_twice_line_down, (ViewGroup) null);
            this.f22409f = inflate;
            this.f22410g = (TextView) inflate.findViewById(R.id.tips);
            this.f22411h = (TextView) this.f22409f.findViewById(R.id.tips_content);
            this.f22409f.setOnClickListener(this.k);
        }
        this.f22410g.setText(StringHelper.cutHotTopicShow(str, 24, "..."));
        this.f22411h.setText(R.string.topic_join);
        if (this.f22405b == null) {
            this.f22405b = new PopupWindow(this.f22409f, -2, -2);
        } else {
            h();
        }
        c.a.e.e.m.e.a().removeCallbacks(this.f22412i);
        c.a.e.e.m.e.a().postDelayed(this.f22412i, 100L);
    }
}
