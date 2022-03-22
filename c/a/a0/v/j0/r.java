package c.a.a0.v.j0;

import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.FrameLayout;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.view.InputDeviceCompat;
import c.a.a0.h0.f;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.nadcore.player.constants.PlayerStatus;
import com.baidu.nadcore.video.plugin.videoplayer.model.BdVideoSeries;
import com.baidu.nadcore.widget.AdImageView;
import com.baidu.searchbox.player.event.LayerEvent;
import com.baidu.searchbox.player.event.PlayerEvent;
import com.baidu.tieba.R;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes.dex */
public class r extends j {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: e  reason: collision with root package name */
    public AdImageView f1775e;

    /* loaded from: classes.dex */
    public class a implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ r a;

        public a(r rVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {rVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = rVar;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view) == null) {
                this.a.u().l();
            }
        }
    }

    public r() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
            }
        }
    }

    @Override // c.a.a0.v.j0.b
    public void B() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            super.B();
            AdImageView adImageView = (AdImageView) LayoutInflater.from(this.f1743c).inflate(R.layout.obfuscated_res_0x7f0d059e, x()).findViewById(R.id.obfuscated_res_0x7f090e7d);
            this.f1775e = adImageView;
            adImageView.setVisibility(8);
            if (this.f1775e.getLayoutParams() instanceof FrameLayout.LayoutParams) {
                ((FrameLayout.LayoutParams) this.f1775e.getLayoutParams()).gravity = 17;
            }
        }
    }

    @Override // c.a.a0.v.j0.b
    public void F(c.a.a0.v.c0.p pVar) {
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
    public final void K(boolean z) {
        int i;
        Interceptable interceptable = $ic;
        if (interceptable != null && interceptable.invokeZ(Constants.METHOD_SEND_USER_MSG, this, z) != null) {
            return;
        }
        int i2 = -1;
        if (z) {
            if (f.c.c(this.f1743c) < f.c.e(this.f1743c)) {
                i2 = (f.c.c(this.f1743c) * 16) / 9;
            } else {
                i = (f.c.e(this.f1743c) * 9) / 16;
                if (this.f1775e.getLayoutParams() == null) {
                    this.f1775e.getLayoutParams().width = i2;
                    this.f1775e.getLayoutParams().height = i;
                    return;
                }
                return;
            }
        }
        i = -1;
        if (this.f1775e.getLayoutParams() == null) {
        }
    }

    public final void L() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
            c.a.a0.v.v0.h.a("hidePoster()");
            this.f1775e.setVisibility(8);
        }
    }

    public final void M() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
            c.a.a0.v.v0.h.a("loadPoster()");
            BdVideoSeries o1 = u().o1();
            String poster = o1 != null ? o1.getPoster() : "";
            if (TextUtils.isEmpty(poster)) {
                this.f1775e.setVisibility(8);
                return;
            }
            this.f1775e.k(poster);
            K(u().V0());
            this.f1775e.setOnClickListener(new a(this));
        }
    }

    public final void N() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048581, this) == null) {
            c.a.a0.v.v0.h.a("showPoster()");
            this.f1775e.setVisibility(0);
        }
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    @Override // c.a.a0.v.j0.b, c.a.a0.v.f0.j
    public void d(@NonNull c.a.a0.v.c0.p pVar) {
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
                    L();
                }
            } else if (c2 == 1 || c2 == 2) {
                M();
            } else if (c2 != 3) {
            } else {
                this.f1775e.g("");
            }
        }
    }

    @Override // c.a.a0.v.j0.o
    @NonNull
    public View getContentView() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) ? x() : (View) invokeV.objValue;
    }

    @Override // c.a.a0.v.f0.j
    @Nullable
    public int[] getSubscribeEvent() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) ? new int[]{4, 2, 5, 3} : (int[]) invokeV.objValue;
    }

    @Override // c.a.a0.v.j0.b, c.a.a0.v.f0.j
    public void h(PlayerStatus playerStatus, PlayerStatus playerStatus2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048585, this, playerStatus, playerStatus2) == null) {
            super.h(playerStatus, playerStatus2);
            if (playerStatus == PlayerStatus.PLAYING) {
                L();
            } else if (playerStatus == PlayerStatus.PREPARING) {
                N();
            }
        }
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    @Override // c.a.a0.v.j0.b, c.a.a0.v.f0.j
    public void k(@NonNull c.a.a0.v.c0.p pVar) {
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
                N();
            } else if (c2 == 1) {
                L();
            } else if (c2 == 2) {
                K(true);
            } else if (c2 != 3) {
            } else {
                K(false);
            }
        }
    }

    @Override // c.a.a0.v.j0.j, c.a.a0.v.j0.b, c.a.a0.v.j0.o
    public void onLayerRelease() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048587, this) == null) {
            super.onLayerRelease();
            this.f1775e.g("");
        }
    }
}
