package c.a.b0.s.j0;

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
import c.a.b0.h0.t;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.nadcore.player.constants.PlayerStatus;
import com.baidu.nadcore.player.utils.BdNetUtils;
import com.baidu.nadcore.video.plugin.videoplayer.model.BdVideoSeries;
import com.baidu.nadcore.video.plugin.videoplayer.model.ClarityUrlList;
import com.baidu.searchbox.player.event.ControlEvent;
import com.baidu.searchbox.player.event.LayerEvent;
import com.baidu.searchbox.player.event.PlayerEvent;
import com.baidu.searchbox.player.event.SystemEvent;
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
    public FrameLayout f1991i;

    /* renamed from: j  reason: collision with root package name */
    public a f1992j;

    /* renamed from: k  reason: collision with root package name */
    public b f1993k;
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
        public ViewGroup f1994b;

        /* renamed from: c  reason: collision with root package name */
        public TextView f1995c;

        /* renamed from: d  reason: collision with root package name */
        public TextView f1996d;

        /* renamed from: e  reason: collision with root package name */
        public TextView f1997e;

        /* renamed from: f  reason: collision with root package name */
        public TextView f1998f;

        /* renamed from: g  reason: collision with root package name */
        public Button f1999g;

        /* renamed from: h  reason: collision with root package name */
        public final q f2000h;

        /* loaded from: classes.dex */
        public class a implements View.OnClickListener {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: e  reason: collision with root package name */
            public final /* synthetic */ b f2001e;

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
                this.f2001e = bVar;
            }

            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeL(1048576, this, view) == null) {
                    this.f2001e.f2000h.S();
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
            this.f2000h = qVar;
            e();
        }

        @Override // c.a.b0.s.j0.q.a
        public void a(boolean z) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeZ(1048576, this, z) == null) {
            }
        }

        @Override // c.a.b0.s.j0.q.a
        public void b(@NonNull BdVideoSeries bdVideoSeries) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, bdVideoSeries) == null) {
                String string = this.a.getResources().getString(t.nad_not_wifi_tips);
                int a2 = c.a.b0.s.m0.e.a(bdVideoSeries);
                ClarityUrlList clarityList = bdVideoSeries.getClarityList();
                if (a2 >= 0 && clarityList != null && clarityList.size() > 0) {
                    String string2 = this.a.getResources().getString(t.nad_video_net_tip_size, String.valueOf(clarityList.get(0).j()));
                    this.f1995c.setText(this.a.getResources().getString(t.nad_video_net_tip_duration) + c.a.b0.d0.c.a(a2, false));
                    this.f1996d.setText(string2);
                    this.f1997e.setVisibility(0);
                    this.f1996d.setVisibility(0);
                    this.f1995c.setVisibility(0);
                } else {
                    this.f1997e.setVisibility(8);
                    this.f1996d.setVisibility(8);
                    this.f1995c.setVisibility(8);
                }
                this.f1998f.setText(string);
                this.f1999g.setOnClickListener(new a(this));
            }
        }

        @Override // c.a.b0.s.j0.q.a
        public View c() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? this.f1994b : (View) invokeV.objValue;
        }

        public final void e() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
                ViewGroup viewGroup = (ViewGroup) LayoutInflater.from(this.a).inflate(c.a.b0.h0.s.nad_bd_embeded_net_tips_layout, (ViewGroup) null);
                this.f1994b = viewGroup;
                this.f1995c = (TextView) viewGroup.findViewById(c.a.b0.h0.r.tv_net_duration);
                this.f1996d = (TextView) this.f1994b.findViewById(c.a.b0.h0.r.tv_net_size);
                this.f1997e = (TextView) this.f1994b.findViewById(c.a.b0.h0.r.nad_tv_net_divide);
                this.f1998f = (TextView) this.f1994b.findViewById(c.a.b0.h0.r.tv_net_tips);
                this.f1999g = (Button) this.f1994b.findViewById(c.a.b0.h0.r.bt_continue_play);
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
        FrameLayout frameLayout = new FrameLayout(this.f1969g);
        this.f1991i = frameLayout;
        frameLayout.setVisibility(8);
    }

    public final void Q(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, str) == null) {
            String h1 = v().h1();
            StringBuilder sb = new StringBuilder(u().getString(t.nad_player_message_network_3g));
            if (!h1.isEmpty()) {
                sb.append("，\n");
                sb.append(str);
                sb.append(h1);
                sb.append("MB");
            }
            c.a.b0.b0.b.a().a(u(), sb.toString());
        }
    }

    public void S() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            G(c.a.b0.s.c0.f.w(LayerEvent.ACTION_CLICK_NET_TIP));
            this.f1991i.setVisibility(8);
            V(true);
        }
    }

    public void T() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            G(c.a.b0.s.c0.f.w(LayerEvent.ACTION_HIDE_CACHE_LOADING));
        }
    }

    public void V(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048579, this, z) == null) {
            c.a.b0.e0.a.c.a().b(z);
        }
    }

    @Override // c.a.b0.s.j0.b, c.a.b0.s.f0.j
    public void e(@NonNull c.a.b0.s.c0.p pVar) {
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
                this.f1991i.setVisibility(8);
                return;
            }
            int g2 = pVar.g(1);
            if (g2 == 904 || g2 == 956) {
                this.f1991i.setVisibility(8);
            }
        }
    }

    @Override // c.a.b0.s.j0.o
    @NonNull
    public View getContentView() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) ? this.f1991i : (View) invokeV.objValue;
    }

    @Override // c.a.b0.s.f0.j
    @Nullable
    public int[] getSubscribeEvent() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) ? new int[]{2, 4, 1, 3} : (int[]) invokeV.objValue;
    }

    @Override // c.a.b0.s.j0.b, c.a.b0.s.f0.j
    public void i(PlayerStatus playerStatus, PlayerStatus playerStatus2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048583, this, playerStatus, playerStatus2) == null) {
            super.i(playerStatus, playerStatus2);
            if (playerStatus == PlayerStatus.PLAYING) {
                this.f1991i.setVisibility(8);
            }
        }
    }

    @Override // c.a.b0.s.j0.b, c.a.b0.s.f0.j
    public void l(@NonNull c.a.b0.s.c0.p pVar) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, pVar) == null) || this.f1992j == null) {
            return;
        }
        if (LayerEvent.ACTION_SWITCH_FULL.equals(pVar.c())) {
            this.f1992j.a(true);
        } else if (LayerEvent.ACTION_SWITCH_HALF.equals(pVar.c())) {
            this.f1992j.a(false);
        }
    }

    @Override // c.a.b0.s.j0.b, c.a.b0.s.f0.j
    public void o(@NonNull c.a.b0.s.c0.p pVar) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048585, this, pVar) == null) && SystemEvent.ACTION_CONNECT_CHANGED.equals(pVar.c())) {
            BdNetUtils.NetStatus a2 = BdNetUtils.a();
            if (a2 == BdNetUtils.NetStatus.NET_MOBILE && !BdNetUtils.h() && this.l != BdNetUtils.NetStatus.NET_MOBILE) {
                if (v().Y() && v().r() > 0 && v().S()) {
                    Q(this.f1969g.getString(t.nad_video_net_tip_rest_size));
                }
            } else {
                BdNetUtils.NetStatus netStatus = BdNetUtils.NetStatus.NET_WIFI;
                if (a2 == netStatus && this.l != netStatus) {
                    this.f1991i.setVisibility(8);
                    if (v().S() && !v().a0()) {
                        if (v().R()) {
                            v().m0();
                        } else if (v().C() == 0) {
                            v().K0();
                        } else {
                            v().l0();
                        }
                        c.a.b0.b0.b.a().b(u(), t.nad_player_message_network_wifi);
                    }
                }
            }
            this.l = a2;
        }
    }

    @Override // c.a.b0.s.j0.j, c.a.b0.s.j0.b, c.a.b0.s.j0.o
    public void onLayerRelease() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048586, this) == null) {
            super.onLayerRelease();
            this.f1993k = null;
            this.f1992j = null;
        }
    }

    @Override // c.a.b0.s.j0.b, c.a.b0.s.f0.j
    public void r(@NonNull c.a.b0.s.c0.p pVar) {
        BdVideoSeries o1;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048587, this, pVar) == null) || !ControlEvent.ACTION_SHOW_TIP.equals(pVar.c()) || v().U0() || (o1 = v().o1()) == null) {
            return;
        }
        if (this.f1993k == null) {
            this.f1993k = new b(this.f1969g, this);
        }
        b bVar = this.f1993k;
        this.f1992j = bVar;
        if (bVar == null) {
            this.f1991i.removeAllViews();
            this.f1991i.setVisibility(8);
            return;
        }
        if (this.f1991i.getChildAt(0) != this.f1992j.c()) {
            this.f1991i.removeAllViews();
            this.f1991i.addView(this.f1992j.c());
        }
        this.f1992j.c().setVisibility(0);
        this.f1992j.b(o1);
        this.f1991i.setVisibility(0);
        v().y().y(true);
        v().y().j(this);
        T();
    }
}
