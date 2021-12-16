package c.a.c0.s.j0;

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
import c.a.c0.h0.t;
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
    public FrameLayout f2009i;

    /* renamed from: j  reason: collision with root package name */
    public a f2010j;

    /* renamed from: k  reason: collision with root package name */
    public b f2011k;
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
        public ViewGroup f2012b;

        /* renamed from: c  reason: collision with root package name */
        public TextView f2013c;

        /* renamed from: d  reason: collision with root package name */
        public TextView f2014d;

        /* renamed from: e  reason: collision with root package name */
        public TextView f2015e;

        /* renamed from: f  reason: collision with root package name */
        public TextView f2016f;

        /* renamed from: g  reason: collision with root package name */
        public Button f2017g;

        /* renamed from: h  reason: collision with root package name */
        public final q f2018h;

        /* loaded from: classes.dex */
        public class a implements View.OnClickListener {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: e  reason: collision with root package name */
            public final /* synthetic */ b f2019e;

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
                this.f2019e = bVar;
            }

            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeL(1048576, this, view) == null) {
                    this.f2019e.f2018h.Q();
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
            this.f2018h = qVar;
            e();
        }

        @Override // c.a.c0.s.j0.q.a
        public void a(boolean z) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeZ(1048576, this, z) == null) {
            }
        }

        @Override // c.a.c0.s.j0.q.a
        public void b(@NonNull BdVideoSeries bdVideoSeries) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, bdVideoSeries) == null) {
                String string = this.a.getResources().getString(t.nad_not_wifi_tips);
                int a2 = c.a.c0.s.m0.e.a(bdVideoSeries);
                ClarityUrlList clarityList = bdVideoSeries.getClarityList();
                if (a2 >= 0 && clarityList != null && clarityList.size() > 0) {
                    String string2 = this.a.getResources().getString(t.nad_video_net_tip_size, String.valueOf(clarityList.get(0).j()));
                    this.f2013c.setText(this.a.getResources().getString(t.nad_video_net_tip_duration) + c.a.c0.d0.c.a(a2, false));
                    this.f2014d.setText(string2);
                    this.f2015e.setVisibility(0);
                    this.f2014d.setVisibility(0);
                    this.f2013c.setVisibility(0);
                } else {
                    this.f2015e.setVisibility(8);
                    this.f2014d.setVisibility(8);
                    this.f2013c.setVisibility(8);
                }
                this.f2016f.setText(string);
                this.f2017g.setOnClickListener(new a(this));
            }
        }

        @Override // c.a.c0.s.j0.q.a
        public View c() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? this.f2012b : (View) invokeV.objValue;
        }

        public final void e() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
                ViewGroup viewGroup = (ViewGroup) LayoutInflater.from(this.a).inflate(c.a.c0.h0.s.nad_bd_embeded_net_tips_layout, (ViewGroup) null);
                this.f2012b = viewGroup;
                this.f2013c = (TextView) viewGroup.findViewById(c.a.c0.h0.r.tv_net_duration);
                this.f2014d = (TextView) this.f2012b.findViewById(c.a.c0.h0.r.tv_net_size);
                this.f2015e = (TextView) this.f2012b.findViewById(c.a.c0.h0.r.nad_tv_net_divide);
                this.f2016f = (TextView) this.f2012b.findViewById(c.a.c0.h0.r.tv_net_tips);
                this.f2017g = (Button) this.f2012b.findViewById(c.a.c0.h0.r.bt_continue_play);
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
        FrameLayout frameLayout = new FrameLayout(this.f1987g);
        this.f2009i = frameLayout;
        frameLayout.setVisibility(8);
    }

    public final void O(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, str) == null) {
            String h1 = u().h1();
            StringBuilder sb = new StringBuilder(t().getString(t.nad_player_message_network_3g));
            if (!h1.isEmpty()) {
                sb.append("，\n");
                sb.append(str);
                sb.append(h1);
                sb.append("MB");
            }
            c.a.c0.b0.b.a().a(t(), sb.toString());
        }
    }

    public void Q() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            F(c.a.c0.s.c0.f.w(LayerEvent.ACTION_CLICK_NET_TIP));
            this.f2009i.setVisibility(8);
            T(true);
        }
    }

    public void S() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            F(c.a.c0.s.c0.f.w(LayerEvent.ACTION_HIDE_CACHE_LOADING));
        }
    }

    public void T(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048579, this, z) == null) {
            c.a.c0.e0.a.c.a().b(z);
        }
    }

    @Override // c.a.c0.s.j0.b, c.a.c0.s.f0.j
    public void d(@NonNull c.a.c0.s.c0.p pVar) {
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
                this.f2009i.setVisibility(8);
                return;
            }
            int g2 = pVar.g(1);
            if (g2 == 904 || g2 == 956) {
                this.f2009i.setVisibility(8);
            }
        }
    }

    @Override // c.a.c0.s.j0.o
    @NonNull
    public View getContentView() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) ? this.f2009i : (View) invokeV.objValue;
    }

    @Override // c.a.c0.s.f0.j
    @Nullable
    public int[] getSubscribeEvent() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) ? new int[]{2, 4, 1, 3} : (int[]) invokeV.objValue;
    }

    @Override // c.a.c0.s.j0.b, c.a.c0.s.f0.j
    public void h(PlayerStatus playerStatus, PlayerStatus playerStatus2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048583, this, playerStatus, playerStatus2) == null) {
            super.h(playerStatus, playerStatus2);
            if (playerStatus == PlayerStatus.PLAYING) {
                this.f2009i.setVisibility(8);
            }
        }
    }

    @Override // c.a.c0.s.j0.b, c.a.c0.s.f0.j
    public void k(@NonNull c.a.c0.s.c0.p pVar) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, pVar) == null) || this.f2010j == null) {
            return;
        }
        if (LayerEvent.ACTION_SWITCH_FULL.equals(pVar.c())) {
            this.f2010j.a(true);
        } else if (LayerEvent.ACTION_SWITCH_HALF.equals(pVar.c())) {
            this.f2010j.a(false);
        }
    }

    @Override // c.a.c0.s.j0.b, c.a.c0.s.f0.j
    public void n(@NonNull c.a.c0.s.c0.p pVar) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048585, this, pVar) == null) && SystemEvent.ACTION_CONNECT_CHANGED.equals(pVar.c())) {
            BdNetUtils.NetStatus a2 = BdNetUtils.a();
            if (a2 == BdNetUtils.NetStatus.NET_MOBILE && !BdNetUtils.h() && this.l != BdNetUtils.NetStatus.NET_MOBILE) {
                if (u().Y() && u().r() > 0 && u().S()) {
                    O(this.f1987g.getString(t.nad_video_net_tip_rest_size));
                }
            } else {
                BdNetUtils.NetStatus netStatus = BdNetUtils.NetStatus.NET_WIFI;
                if (a2 == netStatus && this.l != netStatus) {
                    this.f2009i.setVisibility(8);
                    if (u().S() && !u().a0()) {
                        if (u().R()) {
                            u().m0();
                        } else if (u().C() == 0) {
                            u().K0();
                        } else {
                            u().l0();
                        }
                        c.a.c0.b0.b.a().b(t(), t.nad_player_message_network_wifi);
                    }
                }
            }
            this.l = a2;
        }
    }

    @Override // c.a.c0.s.j0.j, c.a.c0.s.j0.b, c.a.c0.s.j0.o
    public void onLayerRelease() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048586, this) == null) {
            super.onLayerRelease();
            this.f2011k = null;
            this.f2010j = null;
        }
    }

    @Override // c.a.c0.s.j0.b, c.a.c0.s.f0.j
    public void q(@NonNull c.a.c0.s.c0.p pVar) {
        BdVideoSeries o1;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048587, this, pVar) == null) || !ControlEvent.ACTION_SHOW_TIP.equals(pVar.c()) || u().U0() || (o1 = u().o1()) == null) {
            return;
        }
        if (this.f2011k == null) {
            this.f2011k = new b(this.f1987g, this);
        }
        b bVar = this.f2011k;
        this.f2010j = bVar;
        if (bVar == null) {
            this.f2009i.removeAllViews();
            this.f2009i.setVisibility(8);
            return;
        }
        if (this.f2009i.getChildAt(0) != this.f2010j.c()) {
            this.f2009i.removeAllViews();
            this.f2009i.addView(this.f2010j.c());
        }
        this.f2010j.c().setVisibility(0);
        this.f2010j.b(o1);
        this.f2009i.setVisibility(0);
        u().y().y(true);
        u().y().j(this);
        S();
    }
}
