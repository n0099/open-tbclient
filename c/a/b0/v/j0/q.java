package c.a.b0.v.j0;

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

    /* renamed from: i  reason: collision with root package name */
    public FrameLayout f2151i;

    /* renamed from: j  reason: collision with root package name */
    public a f2152j;
    public b k;
    public BdNetUtils.NetStatus l;

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
        public ViewGroup f2153b;

        /* renamed from: c  reason: collision with root package name */
        public TextView f2154c;

        /* renamed from: d  reason: collision with root package name */
        public TextView f2155d;

        /* renamed from: e  reason: collision with root package name */
        public TextView f2156e;

        /* renamed from: f  reason: collision with root package name */
        public TextView f2157f;

        /* renamed from: g  reason: collision with root package name */
        public Button f2158g;

        /* renamed from: h  reason: collision with root package name */
        public final q f2159h;

        /* loaded from: classes.dex */
        public class a implements View.OnClickListener {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: e  reason: collision with root package name */
            public final /* synthetic */ b f2160e;

            public a(b bVar) {
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
                this.f2160e = bVar;
            }

            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeL(1048576, this, view) == null) {
                    this.f2160e.f2159h.L();
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
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = context;
            this.f2159h = qVar;
            e();
        }

        @Override // c.a.b0.v.j0.q.a
        public void a(boolean z) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeZ(1048576, this, z) == null) {
            }
        }

        @Override // c.a.b0.v.j0.q.a
        public void b(@NonNull BdVideoSeries bdVideoSeries) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, bdVideoSeries) == null) {
                String string = this.a.getResources().getString(R.string.nad_not_wifi_tips);
                int a2 = c.a.b0.v.m0.e.a(bdVideoSeries);
                ClarityUrlList clarityList = bdVideoSeries.getClarityList();
                if (a2 >= 0 && clarityList != null && clarityList.size() > 0) {
                    String string2 = this.a.getResources().getString(R.string.nad_video_net_tip_size, String.valueOf(clarityList.get(0).j()));
                    this.f2154c.setText(this.a.getResources().getString(R.string.nad_video_net_tip_duration) + c.a.b0.h0.c.a(a2, false));
                    this.f2155d.setText(string2);
                    this.f2156e.setVisibility(0);
                    this.f2155d.setVisibility(0);
                    this.f2154c.setVisibility(0);
                } else {
                    this.f2156e.setVisibility(8);
                    this.f2155d.setVisibility(8);
                    this.f2154c.setVisibility(8);
                }
                this.f2157f.setText(string);
                this.f2158g.setOnClickListener(new a(this));
            }
        }

        @Override // c.a.b0.v.j0.q.a
        public View c() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? this.f2153b : (View) invokeV.objValue;
        }

        public final void e() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
                ViewGroup viewGroup = (ViewGroup) LayoutInflater.from(this.a).inflate(R.layout.nad_bd_embeded_net_tips_layout, (ViewGroup) null);
                this.f2153b = viewGroup;
                this.f2154c = (TextView) viewGroup.findViewById(R.id.tv_net_duration);
                this.f2155d = (TextView) this.f2153b.findViewById(R.id.tv_net_size);
                this.f2156e = (TextView) this.f2153b.findViewById(R.id.nad_tv_net_divide);
                this.f2157f = (TextView) this.f2153b.findViewById(R.id.tv_net_tips);
                this.f2158g = (Button) this.f2153b.findViewById(R.id.bt_continue_play);
            }
        }
    }

    public q() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.l = BdNetUtils.NetStatus.NET_DOWN;
        FrameLayout frameLayout = new FrameLayout(this.f2135g);
        this.f2151i = frameLayout;
        frameLayout.setVisibility(8);
    }

    public final void K(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, str) == null) {
            String h1 = u().h1();
            StringBuilder sb = new StringBuilder(t().getString(R.string.nad_player_message_network_3g));
            if (!h1.isEmpty()) {
                sb.append("，\n");
                sb.append(str);
                sb.append(h1);
                sb.append("MB");
            }
            c.a.b0.e0.b.a().a(t(), sb.toString());
        }
    }

    public void L() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            F(c.a.b0.v.c0.f.w(LayerEvent.ACTION_CLICK_NET_TIP));
            this.f2151i.setVisibility(8);
            N(true);
        }
    }

    public void M() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            F(c.a.b0.v.c0.f.w(LayerEvent.ACTION_HIDE_CACHE_LOADING));
        }
    }

    public void N(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048579, this, z) == null) {
            c.a.b0.i0.a.c.a().b(z);
        }
    }

    @Override // c.a.b0.v.j0.b, c.a.b0.v.f0.j
    public void d(@NonNull c.a.b0.v.c0.p pVar) {
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
                this.f2151i.setVisibility(8);
                return;
            }
            int g2 = pVar.g(1);
            if (g2 == 904 || g2 == 956) {
                this.f2151i.setVisibility(8);
            }
        }
    }

    @Override // c.a.b0.v.j0.o
    @NonNull
    public View getContentView() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) ? this.f2151i : (View) invokeV.objValue;
    }

    @Override // c.a.b0.v.f0.j
    @Nullable
    public int[] getSubscribeEvent() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) ? new int[]{2, 4, 1, 3} : (int[]) invokeV.objValue;
    }

    @Override // c.a.b0.v.j0.b, c.a.b0.v.f0.j
    public void h(PlayerStatus playerStatus, PlayerStatus playerStatus2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048583, this, playerStatus, playerStatus2) == null) {
            super.h(playerStatus, playerStatus2);
            if (playerStatus == PlayerStatus.PLAYING) {
                this.f2151i.setVisibility(8);
            }
        }
    }

    @Override // c.a.b0.v.j0.b, c.a.b0.v.f0.j
    public void k(@NonNull c.a.b0.v.c0.p pVar) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, pVar) == null) || this.f2152j == null) {
            return;
        }
        if (LayerEvent.ACTION_SWITCH_FULL.equals(pVar.c())) {
            this.f2152j.a(true);
        } else if (LayerEvent.ACTION_SWITCH_HALF.equals(pVar.c())) {
            this.f2152j.a(false);
        }
    }

    @Override // c.a.b0.v.j0.b, c.a.b0.v.f0.j
    public void n(@NonNull c.a.b0.v.c0.p pVar) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048585, this, pVar) == null) && SystemEvent.ACTION_CONNECT_CHANGED.equals(pVar.c())) {
            BdNetUtils.NetStatus a2 = BdNetUtils.a();
            if (a2 == BdNetUtils.NetStatus.NET_MOBILE && !BdNetUtils.h() && this.l != BdNetUtils.NetStatus.NET_MOBILE) {
                if (u().Y() && u().r() > 0 && u().S()) {
                    K(this.f2135g.getString(R.string.nad_video_net_tip_rest_size));
                }
            } else {
                BdNetUtils.NetStatus netStatus = BdNetUtils.NetStatus.NET_WIFI;
                if (a2 == netStatus && this.l != netStatus) {
                    this.f2151i.setVisibility(8);
                    if (u().S() && !u().a0()) {
                        if (u().R()) {
                            u().m0();
                        } else if (u().C() == 0) {
                            u().K0();
                        } else {
                            u().l0();
                        }
                        c.a.b0.e0.b.a().b(t(), R.string.nad_player_message_network_wifi);
                    }
                }
            }
            this.l = a2;
        }
    }

    @Override // c.a.b0.v.j0.j, c.a.b0.v.j0.b, c.a.b0.v.j0.o
    public void onLayerRelease() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048586, this) == null) {
            super.onLayerRelease();
            this.k = null;
            this.f2152j = null;
        }
    }

    @Override // c.a.b0.v.j0.b, c.a.b0.v.f0.j
    public void q(@NonNull c.a.b0.v.c0.p pVar) {
        BdVideoSeries o1;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048587, this, pVar) == null) || !ControlEvent.ACTION_SHOW_TIP.equals(pVar.c()) || u().U0() || (o1 = u().o1()) == null) {
            return;
        }
        if (this.k == null) {
            this.k = new b(this.f2135g, this);
        }
        b bVar = this.k;
        this.f2152j = bVar;
        if (bVar == null) {
            this.f2151i.removeAllViews();
            this.f2151i.setVisibility(8);
            return;
        }
        if (this.f2151i.getChildAt(0) != this.f2152j.c()) {
            this.f2151i.removeAllViews();
            this.f2151i.addView(this.f2152j.c());
        }
        this.f2152j.c().setVisibility(0);
        this.f2152j.b(o1);
        this.f2151i.setVisibility(0);
        u().y().y(true);
        u().y().j(this);
        M();
    }
}
