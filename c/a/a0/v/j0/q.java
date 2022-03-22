package c.a.a0.v.j0;

import android.annotation.SuppressLint;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.nadcore.player.constants.PlayerStatus;
import com.baidu.nadcore.player.utils.BdNetUtils;
import com.baidu.nadcore.video.plugin.videoplayer.model.BdVideoSeries;
import com.baidu.nadcore.video.plugin.videoplayer.model.ClarityUrlList;
import com.baidu.searchbox.player.event.ControlEvent;
import com.baidu.searchbox.player.event.LayerEvent;
import com.baidu.searchbox.player.event.PlayerEvent;
import com.baidu.searchbox.player.event.SystemEvent;
import com.baidu.tieba.R;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
@SuppressLint({"InflateParams"})
/* loaded from: classes.dex */
public class q extends j {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: e  reason: collision with root package name */
    public FrameLayout f1764e;

    /* renamed from: f  reason: collision with root package name */
    public a f1765f;

    /* renamed from: g  reason: collision with root package name */
    public b f1766g;

    /* renamed from: h  reason: collision with root package name */
    public BdNetUtils.NetStatus f1767h;

    /* loaded from: classes.dex */
    public interface a {
        void a(boolean z);

        void b(@NonNull BdVideoSeries bdVideoSeries);

        View c();
    }

    /* loaded from: classes.dex */
    public static class b implements a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final Context a;

        /* renamed from: b  reason: collision with root package name */
        public ViewGroup f1768b;

        /* renamed from: c  reason: collision with root package name */
        public TextView f1769c;

        /* renamed from: d  reason: collision with root package name */
        public TextView f1770d;

        /* renamed from: e  reason: collision with root package name */
        public TextView f1771e;

        /* renamed from: f  reason: collision with root package name */
        public TextView f1772f;

        /* renamed from: g  reason: collision with root package name */
        public Button f1773g;

        /* renamed from: h  reason: collision with root package name */
        public final q f1774h;

        /* loaded from: classes.dex */
        public class a implements View.OnClickListener {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ b a;

            public a(b bVar) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {bVar};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i = newInitContext.flag;
                    if ((i & 1) != 0) {
                        int i2 = i & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.a = bVar;
            }

            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeL(1048576, this, view) == null) {
                    this.a.f1774h.L();
                }
            }
        }

        public b(@NonNull Context context, @NonNull q qVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {context, qVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = context;
            this.f1774h = qVar;
            e();
        }

        @Override // c.a.a0.v.j0.q.a
        public void a(boolean z) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeZ(1048576, this, z) == null) {
            }
        }

        @Override // c.a.a0.v.j0.q.a
        public void b(@NonNull BdVideoSeries bdVideoSeries) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, bdVideoSeries) == null) {
                String string = this.a.getResources().getString(R.string.obfuscated_res_0x7f0f0ba1);
                int a2 = c.a.a0.v.m0.e.a(bdVideoSeries);
                ClarityUrlList clarityList = bdVideoSeries.getClarityList();
                if (a2 >= 0 && clarityList != null && clarityList.size() > 0) {
                    String string2 = this.a.getResources().getString(R.string.obfuscated_res_0x7f0f0be0, String.valueOf(clarityList.get(0).j()));
                    this.f1769c.setText(this.a.getResources().getString(R.string.obfuscated_res_0x7f0f0bdc) + c.a.a0.h0.c.a(a2, false));
                    this.f1770d.setText(string2);
                    this.f1771e.setVisibility(0);
                    this.f1770d.setVisibility(0);
                    this.f1769c.setVisibility(0);
                } else {
                    this.f1771e.setVisibility(8);
                    this.f1770d.setVisibility(8);
                    this.f1769c.setVisibility(8);
                }
                this.f1772f.setText(string);
                this.f1773g.setOnClickListener(new a(this));
            }
        }

        @Override // c.a.a0.v.j0.q.a
        public View c() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? this.f1768b : (View) invokeV.objValue;
        }

        public final void e() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
                ViewGroup viewGroup = (ViewGroup) LayoutInflater.from(this.a).inflate(R.layout.obfuscated_res_0x7f0d059c, (ViewGroup) null);
                this.f1768b = viewGroup;
                this.f1769c = (TextView) viewGroup.findViewById(R.id.obfuscated_res_0x7f0921de);
                this.f1770d = (TextView) this.f1768b.findViewById(R.id.obfuscated_res_0x7f0921df);
                this.f1771e = (TextView) this.f1768b.findViewById(R.id.obfuscated_res_0x7f0914e3);
                this.f1772f = (TextView) this.f1768b.findViewById(R.id.obfuscated_res_0x7f0921e0);
                this.f1773g = (Button) this.f1768b.findViewById(R.id.obfuscated_res_0x7f0903f1);
            }
        }
    }

    public q() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f1767h = BdNetUtils.NetStatus.NET_DOWN;
        FrameLayout frameLayout = new FrameLayout(this.f1743c);
        this.f1764e = frameLayout;
        frameLayout.setVisibility(8);
    }

    public final void K(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, str) == null) {
            String h1 = u().h1();
            StringBuilder sb = new StringBuilder(t().getString(R.string.obfuscated_res_0x7f0f0bad));
            if (!h1.isEmpty()) {
                sb.append("，\n");
                sb.append(str);
                sb.append(h1);
                sb.append("MB");
            }
            c.a.a0.e0.b.a().a(t(), sb.toString());
        }
    }

    public void L() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            F(c.a.a0.v.c0.f.w(LayerEvent.ACTION_CLICK_NET_TIP));
            this.f1764e.setVisibility(8);
            N(true);
        }
    }

    public void M() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            F(c.a.a0.v.c0.f.w(LayerEvent.ACTION_HIDE_CACHE_LOADING));
        }
    }

    public void N(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048579, this, z) == null) {
            c.a.a0.i0.a.c.a().b(z);
        }
    }

    @Override // c.a.a0.v.j0.b, c.a.a0.v.f0.j
    public void d(@NonNull c.a.a0.v.c0.p pVar) {
        char c2;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, pVar) == null) {
            String c3 = pVar.c();
            int hashCode = c3.hashCode();
            if (hashCode != 154871702) {
                if (hashCode == 1370689931 && c3.equals(PlayerEvent.ACTION_ON_INFO)) {
                    c2 = 0;
                }
                c2 = 65535;
            } else {
                if (c3.equals(PlayerEvent.ACTION_ON_COMPLETE)) {
                    c2 = 1;
                }
                c2 = 65535;
            }
            if (c2 != 0) {
                if (c2 != 1) {
                    return;
                }
                this.f1764e.setVisibility(8);
                return;
            }
            int g2 = pVar.g(1);
            if (g2 == 904 || g2 == 956) {
                this.f1764e.setVisibility(8);
            }
        }
    }

    @Override // c.a.a0.v.j0.o
    @NonNull
    public View getContentView() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) ? this.f1764e : (View) invokeV.objValue;
    }

    @Override // c.a.a0.v.f0.j
    @Nullable
    public int[] getSubscribeEvent() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) ? new int[]{2, 4, 1, 3} : (int[]) invokeV.objValue;
    }

    @Override // c.a.a0.v.j0.b, c.a.a0.v.f0.j
    public void h(PlayerStatus playerStatus, PlayerStatus playerStatus2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048583, this, playerStatus, playerStatus2) == null) {
            super.h(playerStatus, playerStatus2);
            if (playerStatus == PlayerStatus.PLAYING) {
                this.f1764e.setVisibility(8);
            }
        }
    }

    @Override // c.a.a0.v.j0.b, c.a.a0.v.f0.j
    public void k(@NonNull c.a.a0.v.c0.p pVar) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, pVar) == null) || this.f1765f == null) {
            return;
        }
        if (LayerEvent.ACTION_SWITCH_FULL.equals(pVar.c())) {
            this.f1765f.a(true);
        } else if (LayerEvent.ACTION_SWITCH_HALF.equals(pVar.c())) {
            this.f1765f.a(false);
        }
    }

    @Override // c.a.a0.v.j0.b, c.a.a0.v.f0.j
    public void n(@NonNull c.a.a0.v.c0.p pVar) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048585, this, pVar) == null) && SystemEvent.ACTION_CONNECT_CHANGED.equals(pVar.c())) {
            BdNetUtils.NetStatus a2 = BdNetUtils.a();
            if (a2 == BdNetUtils.NetStatus.NET_MOBILE && !BdNetUtils.h() && this.f1767h != BdNetUtils.NetStatus.NET_MOBILE) {
                if (u().Y() && u().r() > 0 && u().S()) {
                    K(this.f1743c.getString(R.string.obfuscated_res_0x7f0f0bdf));
                }
            } else {
                BdNetUtils.NetStatus netStatus = BdNetUtils.NetStatus.NET_WIFI;
                if (a2 == netStatus && this.f1767h != netStatus) {
                    this.f1764e.setVisibility(8);
                    if (u().S() && !u().a0()) {
                        if (u().R()) {
                            u().m0();
                        } else if (u().C() == 0) {
                            u().K0();
                        } else {
                            u().l0();
                        }
                        c.a.a0.e0.b.a().b(t(), R.string.obfuscated_res_0x7f0f0baf);
                    }
                }
            }
            this.f1767h = a2;
        }
    }

    @Override // c.a.a0.v.j0.j, c.a.a0.v.j0.b, c.a.a0.v.j0.o
    public void onLayerRelease() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048586, this) == null) {
            super.onLayerRelease();
            this.f1766g = null;
            this.f1765f = null;
        }
    }

    @Override // c.a.a0.v.j0.b, c.a.a0.v.f0.j
    public void q(@NonNull c.a.a0.v.c0.p pVar) {
        BdVideoSeries o1;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048587, this, pVar) == null) || !ControlEvent.ACTION_SHOW_TIP.equals(pVar.c()) || u().U0() || (o1 = u().o1()) == null) {
            return;
        }
        if (this.f1766g == null) {
            this.f1766g = new b(this.f1743c, this);
        }
        b bVar = this.f1766g;
        this.f1765f = bVar;
        if (bVar == null) {
            this.f1764e.removeAllViews();
            this.f1764e.setVisibility(8);
            return;
        }
        if (this.f1764e.getChildAt(0) != this.f1765f.c()) {
            this.f1764e.removeAllViews();
            this.f1764e.addView(this.f1765f.c());
        }
        this.f1765f.c().setVisibility(0);
        this.f1765f.b(o1);
        this.f1764e.setVisibility(0);
        u().y().y(true);
        u().y().j(this);
        M();
    }
}
