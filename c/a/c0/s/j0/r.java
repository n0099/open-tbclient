package c.a.c0.s.j0;

import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.FrameLayout;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.view.InputDeviceCompat;
import c.a.c0.d0.f;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.nadcore.player.constants.PlayerStatus;
import com.baidu.nadcore.video.plugin.videoplayer.model.BdVideoSeries;
import com.baidu.nadcore.widget.AdImageView;
import com.baidu.searchbox.player.event.LayerEvent;
import com.baidu.searchbox.player.event.PlayerEvent;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes.dex */
public class r extends j {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: i  reason: collision with root package name */
    public AdImageView f2020i;

    /* loaded from: classes.dex */
    public class a implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ r f2021e;

        public a(r rVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {rVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f2021e = rVar;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view) == null) {
                this.f2021e.u().l();
            }
        }
    }

    public r() {
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

    @Override // c.a.c0.s.j0.b
    public void B() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            super.B();
            AdImageView adImageView = (AdImageView) LayoutInflater.from(this.f1987g).inflate(c.a.c0.h0.s.nad_bd_layer_poster_layout, x()).findViewById(c.a.c0.h0.r.image_poster);
            this.f2020i = adImageView;
            adImageView.setVisibility(8);
            if (this.f2020i.getLayoutParams() instanceof FrameLayout.LayoutParams) {
                ((FrameLayout.LayoutParams) this.f2020i.getLayoutParams()).gravity = 17;
            }
        }
    }

    @Override // c.a.c0.s.j0.b
    public void F(c.a.c0.s.c0.p pVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, pVar) == null) {
            super.F(pVar);
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:13:0x0035  */
    /* JADX WARN: Removed duplicated region for block: B:18:? A[RETURN, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final void O(boolean z) {
        int i2;
        Interceptable interceptable = $ic;
        if (interceptable != null && interceptable.invokeZ(Constants.METHOD_SEND_USER_MSG, this, z) != null) {
            return;
        }
        int i3 = -1;
        if (z) {
            if (f.c.c(this.f1987g) < f.c.e(this.f1987g)) {
                i3 = (f.c.c(this.f1987g) * 16) / 9;
            } else {
                i2 = (f.c.e(this.f1987g) * 9) / 16;
                if (this.f2020i.getLayoutParams() == null) {
                    this.f2020i.getLayoutParams().width = i3;
                    this.f2020i.getLayoutParams().height = i2;
                    return;
                }
                return;
            }
        }
        i2 = -1;
        if (this.f2020i.getLayoutParams() == null) {
        }
    }

    public final void Q() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
            c.a.c0.s.v0.h.a("hidePoster()");
            this.f2020i.setVisibility(8);
        }
    }

    public final void S() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
            c.a.c0.s.v0.h.a("loadPoster()");
            BdVideoSeries o1 = u().o1();
            String poster = o1 != null ? o1.getPoster() : "";
            if (TextUtils.isEmpty(poster)) {
                this.f2020i.setVisibility(8);
                return;
            }
            this.f2020i.preloadImage(poster);
            O(u().V0());
            this.f2020i.setOnClickListener(new a(this));
        }
    }

    public final void T() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048581, this) == null) {
            c.a.c0.s.v0.h.a("showPoster()");
            this.f2020i.setVisibility(0);
        }
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    @Override // c.a.c0.s.j0.b, c.a.c0.s.f0.j
    public void d(@NonNull c.a.c0.s.c0.p pVar) {
        char c2;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048582, this, pVar) == null) {
            String c3 = pVar.c();
            switch (c3.hashCode()) {
                case -1043170264:
                    if (c3.equals(PlayerEvent.ACTION_PLAYER_ATTACH)) {
                        c2 = 2;
                        break;
                    }
                    c2 = 65535;
                    break;
                case -971135626:
                    if (c3.equals(PlayerEvent.ACTION_PLAYER_DETACH)) {
                        c2 = 3;
                        break;
                    }
                    c2 = 65535;
                    break;
                case -882902390:
                    if (c3.equals(PlayerEvent.ACTION_SET_DATA_SOURCE)) {
                        c2 = 1;
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
                default:
                    c2 = 65535;
                    break;
            }
            if (c2 == 0) {
                int g2 = pVar.g(1);
                if (g2 == 904 || g2 == 956) {
                    Q();
                }
            } else if (c2 == 1 || c2 == 2) {
                S();
            } else if (c2 != 3) {
            } else {
                this.f2020i.displayImage("");
            }
        }
    }

    @Override // c.a.c0.s.j0.o
    @NonNull
    public View getContentView() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) ? x() : (View) invokeV.objValue;
    }

    @Override // c.a.c0.s.f0.j
    @Nullable
    public int[] getSubscribeEvent() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) ? new int[]{4, 2, 5, 3} : (int[]) invokeV.objValue;
    }

    @Override // c.a.c0.s.j0.b, c.a.c0.s.f0.j
    public void h(PlayerStatus playerStatus, PlayerStatus playerStatus2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048585, this, playerStatus, playerStatus2) == null) {
            super.h(playerStatus, playerStatus2);
            if (playerStatus == PlayerStatus.PLAYING) {
                Q();
            } else if (playerStatus == PlayerStatus.PREPARING) {
                T();
            }
        }
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    @Override // c.a.c0.s.j0.b, c.a.c0.s.f0.j
    public void k(@NonNull c.a.c0.s.c0.p pVar) {
        char c2;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048586, this, pVar) == null) {
            String c3 = pVar.c();
            switch (c3.hashCode()) {
                case -552621273:
                    if (c3.equals(LayerEvent.ACTION_SWITCH_FULL)) {
                        c2 = 2;
                        break;
                    }
                    c2 = 65535;
                    break;
                case -552580917:
                    if (c3.equals(LayerEvent.ACTION_SWITCH_HALF)) {
                        c2 = 3;
                        break;
                    }
                    c2 = 65535;
                    break;
                case 1554330967:
                    if (c3.equals(LayerEvent.ACTION_HIDE_POSTER)) {
                        c2 = 1;
                        break;
                    }
                    c2 = 65535;
                    break;
                case 2062901052:
                    if (c3.equals(LayerEvent.ACTION_SHOW_POSTER)) {
                        c2 = 0;
                        break;
                    }
                    c2 = 65535;
                    break;
                default:
                    c2 = 65535;
                    break;
            }
            if (c2 == 0) {
                T();
            } else if (c2 == 1) {
                Q();
            } else if (c2 == 2) {
                O(true);
            } else if (c2 != 3) {
            } else {
                O(false);
            }
        }
    }

    @Override // c.a.c0.s.j0.j, c.a.c0.s.j0.b, c.a.c0.s.j0.o
    public void onLayerRelease() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048587, this) == null) {
            super.onLayerRelease();
            this.f2020i.displayImage("");
        }
    }
}
