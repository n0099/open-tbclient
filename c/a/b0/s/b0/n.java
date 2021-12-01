package c.a.b0.s.b0;

import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import androidx.annotation.NonNull;
import c.a.b0.h0.q;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.nadcore.player.constants.PlayerStatus;
import com.baidu.nadcore.video.videoplayer.widget.PlayDrawable;
import com.baidu.searchbox.player.event.ControlEvent;
import com.baidu.searchbox.player.event.LayerEvent;
import com.baidu.searchbox.player.event.PlayerEvent;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes.dex */
public class n extends g implements View.OnClickListener {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: f  reason: collision with root package name */
    public ImageView f1893f;

    /* renamed from: g  reason: collision with root package name */
    public PlayDrawable f1894g;

    /* loaded from: classes.dex */
    public class a implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ boolean f1895e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ n f1896f;

        public a(n nVar, boolean z) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {nVar, Boolean.valueOf(z)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f1896f = nVar;
            this.f1895e = z;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                if (this.f1895e) {
                    this.f1896f.f1893f.setVisibility(0);
                } else {
                    this.f1896f.f1893f.setVisibility(8);
                }
            }
        }
    }

    public n() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
            }
        }
    }

    @Override // c.a.b0.s.b0.a
    public void f() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            this.f1893f = new ImageView(getContext());
            FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(c.a.b0.e0.a.d.b.b(42.0f), c.a.b0.e0.a.d.b.b(42.0f));
            layoutParams.gravity = 17;
            this.f1894g = new PlayDrawable();
            this.f1893f.setLayoutParams(layoutParams);
            this.f1893f.setBackground(getContext().getResources().getDrawable(q.nad_videoplayer_playbtn_bg));
            this.f1893f.setImageDrawable(this.f1894g);
            this.f1893f.setOnClickListener(this);
            this.f1893f.setVisibility(8);
        }
    }

    @Override // c.a.b0.s.b0.h
    @NonNull
    public View getContentView() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.f1893f : (View) invokeV.objValue;
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    @Override // c.a.b0.s.b0.a
    public void h(@NonNull c.a.b0.s.c0.p pVar) {
        char c2;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, pVar) == null) {
            String c3 = pVar.c();
            switch (c3.hashCode()) {
                case -150836531:
                    if (c3.equals(LayerEvent.ACTION_DOUBLE_CLICK)) {
                        c2 = 1;
                        break;
                    }
                    c2 = 65535;
                    break;
                case 14382657:
                    if (c3.equals(ControlEvent.ACTION_STATUS_SYNC)) {
                        c2 = 5;
                        break;
                    }
                    c2 = 65535;
                    break;
                case 154871702:
                    if (c3.equals(PlayerEvent.ACTION_ON_COMPLETE)) {
                        c2 = 6;
                        break;
                    }
                    c2 = 65535;
                    break;
                case 720027695:
                    if (c3.equals(ControlEvent.ACTION_PAUSE)) {
                        c2 = 2;
                        break;
                    }
                    c2 = 65535;
                    break;
                case 723345051:
                    if (c3.equals(ControlEvent.ACTION_START)) {
                        c2 = 4;
                        break;
                    }
                    c2 = 65535;
                    break;
                case 906917140:
                    if (c3.equals(ControlEvent.ACTION_RESUME)) {
                        c2 = 3;
                        break;
                    }
                    c2 = 65535;
                    break;
                case 1370689931:
                    if (c3.equals(PlayerEvent.ACTION_ON_INFO)) {
                        c2 = 0;
                        break;
                    }
                    c2 = 65535;
                    break;
                case 1610373035:
                    if (c3.equals(ControlEvent.ACTION_WAKE_UP_END)) {
                        c2 = 7;
                        break;
                    }
                    c2 = 65535;
                    break;
                default:
                    c2 = 65535;
                    break;
            }
            switch (c2) {
                case 0:
                    int g2 = pVar.g(1);
                    if (g2 != 904 && g2 != 956) {
                        if (702 == g2 && n().Y()) {
                            this.f1894g.q(PlayDrawable.IconState.PAUSE_STATE);
                            return;
                        }
                        return;
                    }
                    this.f1894g.q(PlayDrawable.IconState.PAUSE_STATE);
                    this.f1893f.setImageDrawable(this.f1894g);
                    return;
                case 1:
                    this.f1894g.q(pVar.d(6) ? PlayDrawable.IconState.PAUSE_STATE : PlayDrawable.IconState.PLAY_STATE);
                    return;
                case 2:
                    this.f1894g.q(PlayDrawable.IconState.PLAY_STATE);
                    return;
                case 3:
                    this.f1894g.q(PlayDrawable.IconState.PAUSE_STATE);
                    return;
                case 4:
                    if (this.f1893f.getVisibility() == 0) {
                        this.f1893f.setVisibility(4);
                        return;
                    }
                    return;
                case 5:
                    this.f1894g.q(this.f1873e.v().W() ? PlayDrawable.IconState.PLAY_STATE : PlayDrawable.IconState.PAUSE_STATE);
                    return;
                case 6:
                    this.f1893f.setVisibility(4);
                    return;
                case 7:
                    this.f1893f.setVisibility(0);
                    return;
                default:
                    return;
            }
        }
    }

    @Override // c.a.b0.s.b0.a
    public void k(PlayerStatus playerStatus, PlayerStatus playerStatus2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048579, this, playerStatus, playerStatus2) == null) {
            if (playerStatus != PlayerStatus.PLAYING && playerStatus != PlayerStatus.PREPARED && playerStatus != PlayerStatus.PREPARING) {
                this.f1894g.q(PlayDrawable.IconState.PLAY_STATE);
            } else {
                this.f1894g.q(PlayDrawable.IconState.PAUSE_STATE);
            }
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, view) == null) {
            if (n().Y()) {
                n().f0(1);
                s();
            } else if (n().W()) {
                n().l0();
                t();
            } else {
                n().K0();
            }
            this.f1894g.r(true);
        }
    }

    @Override // c.a.b0.s.b0.g
    public void p(boolean z, boolean z2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048581, this, new Object[]{Boolean.valueOf(z), Boolean.valueOf(z2)}) == null) {
            if (n().V0() && n().f1() == 0) {
                this.f1893f.postDelayed(new a(this, z), 200L);
            } else if (z && !z2) {
                this.f1893f.setVisibility(0);
            } else {
                this.f1893f.setVisibility(8);
            }
        }
    }

    public void s() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048582, this) == null) {
        }
    }

    public void t() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048583, this) == null) {
        }
    }
}
