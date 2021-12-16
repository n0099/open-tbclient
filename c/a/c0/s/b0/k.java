package c.a.c0.s.b0;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import c.a.c0.h0.r;
import c.a.c0.h0.s;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.searchbox.player.event.LayerEvent;
import com.baidu.searchbox.player.event.PlayerEvent;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes.dex */
public class k extends g {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: f  reason: collision with root package name */
    public View f1905f;

    /* renamed from: g  reason: collision with root package name */
    public View f1906g;

    /* renamed from: h  reason: collision with root package name */
    public View f1907h;

    /* renamed from: i  reason: collision with root package name */
    public boolean f1908i;

    public k() {
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
        this.f1908i = true;
    }

    @Override // c.a.c0.s.b0.a
    public void f() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            View inflate = LayoutInflater.from(getContext()).inflate(s.nad_bd_layer_control_bg, (ViewGroup) null);
            this.f1905f = inflate;
            this.f1906g = inflate.findViewById(r.full_top_shadow);
            this.f1907h = this.f1905f.findViewById(r.full_bottom_shadow);
        }
    }

    @Override // c.a.c0.s.b0.h
    @NonNull
    public View getContentView() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.f1905f : (View) invokeV.objValue;
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    @Override // c.a.c0.s.b0.a
    public void h(@NonNull c.a.c0.s.c0.p pVar) {
        char c2;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, pVar) == null) {
            String c3 = pVar.c();
            switch (c3.hashCode()) {
                case -1043170264:
                    if (c3.equals(PlayerEvent.ACTION_PLAYER_ATTACH)) {
                        c2 = 2;
                        break;
                    }
                    c2 = 65535;
                    break;
                case -552621273:
                    if (c3.equals(LayerEvent.ACTION_SWITCH_FULL)) {
                        c2 = 1;
                        break;
                    }
                    c2 = 65535;
                    break;
                case -552580917:
                    if (c3.equals(LayerEvent.ACTION_SWITCH_HALF)) {
                        c2 = 0;
                        break;
                    }
                    c2 = 65535;
                    break;
                case -56310521:
                    if (c3.equals(LayerEvent.ACTION_VIDEO_VIEW_CHANGED)) {
                        c2 = 3;
                        break;
                    }
                    c2 = 65535;
                    break;
                default:
                    c2 = 65535;
                    break;
            }
            if (c2 == 0) {
                this.f1905f.setVisibility(0);
            } else if (c2 == 1 || c2 == 2 || c2 == 3) {
                this.f1905f.setVisibility(8);
            }
        }
    }

    @Override // c.a.c0.s.b0.g
    public void p(boolean z, boolean z2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048579, this, new Object[]{Boolean.valueOf(z), Boolean.valueOf(z2)}) == null) {
            if (z) {
                if (this.f1908i) {
                    this.f1905f.setVisibility(0);
                    this.f1906g.setVisibility(0);
                    this.f1907h.setVisibility(0);
                    return;
                }
                this.f1905f.setVisibility(8);
                return;
            }
            this.f1905f.setVisibility(8);
        }
    }
}
