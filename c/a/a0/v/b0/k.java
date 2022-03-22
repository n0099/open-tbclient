package c.a.a0.v.b0;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.searchbox.player.event.LayerEvent;
import com.baidu.searchbox.player.event.PlayerEvent;
import com.baidu.tieba.R;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes.dex */
public class k extends g {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: b  reason: collision with root package name */
    public View f1669b;

    /* renamed from: c  reason: collision with root package name */
    public View f1670c;

    /* renamed from: d  reason: collision with root package name */
    public View f1671d;

    /* renamed from: e  reason: collision with root package name */
    public boolean f1672e;

    public k() {
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
        this.f1672e = true;
    }

    @Override // c.a.a0.v.b0.h
    @NonNull
    public View getContentView() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.f1669b : (View) invokeV.objValue;
    }

    @Override // c.a.a0.v.b0.a
    public void i() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            View inflate = LayoutInflater.from(getContext()).inflate(R.layout.obfuscated_res_0x7f0d059d, (ViewGroup) null);
            this.f1669b = inflate;
            this.f1670c = inflate.findViewById(R.id.obfuscated_res_0x7f090c08);
            this.f1671d = this.f1669b.findViewById(R.id.obfuscated_res_0x7f090bfd);
        }
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    @Override // c.a.a0.v.b0.a
    public void k(@NonNull c.a.a0.v.c0.p pVar) {
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
                this.f1669b.setVisibility(0);
            } else if (c2 == 1 || c2 == 2 || c2 == 3) {
                this.f1669b.setVisibility(8);
            }
        }
    }

    @Override // c.a.a0.v.b0.g
    public void s(boolean z, boolean z2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048579, this, new Object[]{Boolean.valueOf(z), Boolean.valueOf(z2)}) == null) {
            if (z) {
                if (this.f1672e) {
                    this.f1669b.setVisibility(0);
                    this.f1670c.setVisibility(0);
                    this.f1671d.setVisibility(0);
                    return;
                }
                this.f1669b.setVisibility(8);
                return;
            }
            this.f1669b.setVisibility(8);
        }
    }
}
