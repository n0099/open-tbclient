package c.a.c0.s.h0;

import android.text.TextUtils;
import androidx.core.view.InputDeviceCompat;
import c.a.c0.s.c0.p;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.nadcore.video.plugin.videoplayer.model.BdVideoSeries;
import com.baidu.searchbox.player.event.LayerEvent;
import com.baidu.searchbox.player.event.PlayerEvent;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.Map;
/* loaded from: classes.dex */
public class j extends b implements c.a.c0.s.f0.e {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: b  reason: collision with root package name */
    public i f1974b;

    /* renamed from: c  reason: collision with root package name */
    public Object f1975c;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public j(Map<String, String> map, Object obj) {
        super(map);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {map, obj};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                super((Map) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f1975c = obj;
    }

    @Override // c.a.c0.s.f0.a
    public void a(boolean z) {
        i iVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeZ(1048576, this, z) == null) || (iVar = this.f1974b) == null) {
            return;
        }
        iVar.k(z);
    }

    @Override // c.a.c0.s.f0.b
    public boolean b(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str)) == null) {
            if (!TextUtils.isEmpty(str) && this.a != null && PlayerEvent.ACTION_ON_COMPLETE.equals(str)) {
                this.a.V(0);
                i iVar = new i(this.a, this.f1975c);
                this.f1974b = iVar;
                iVar.e();
                if (k()) {
                    if (this.f1974b.i()) {
                        this.a.V(0);
                        this.a.u().y().y(true);
                        return true;
                    }
                    this.a.V(8);
                }
            }
            return false;
        }
        return invokeL.booleanValue;
    }

    @Override // c.a.c0.s.f0.e
    public void e(Object obj) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, obj) == null) {
            this.f1975c = obj;
        }
    }

    @Override // c.a.c0.s.h0.b
    public void f(p pVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, pVar) == null) {
        }
    }

    @Override // c.a.c0.s.h0.b
    public void g(p pVar) {
        char c2;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, pVar) == null) {
            String c3 = pVar.c();
            int hashCode = c3.hashCode();
            if (hashCode == -552621273) {
                if (c3.equals(LayerEvent.ACTION_SWITCH_FULL)) {
                    c2 = 0;
                }
                c2 = 65535;
            } else if (hashCode != -552580917) {
                if (hashCode == 851534116 && c3.equals(LayerEvent.ACTION_NIGHT_MODEL_CHANGED)) {
                    c2 = 2;
                }
                c2 = 65535;
            } else {
                if (c3.equals(LayerEvent.ACTION_SWITCH_HALF)) {
                    c2 = 1;
                }
                c2 = 65535;
            }
            if (c2 == 0) {
                a(false);
            } else if (c2 == 1) {
                a(true);
            } else if (c2 != 2) {
            } else {
                l(pVar.d(17));
            }
        }
    }

    @Override // c.a.c0.s.h0.b
    public void h(p pVar) {
        char c2;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048581, this, pVar) == null) {
            String c3 = pVar.c();
            int hashCode = c3.hashCode();
            if (hashCode != -1759675333) {
                if (hashCode == -882902390 && c3.equals(PlayerEvent.ACTION_SET_DATA_SOURCE)) {
                    c2 = 0;
                }
                c2 = 65535;
            } else {
                if (c3.equals(PlayerEvent.ACTION_GO_BACK_OR_FOREGROUND)) {
                    c2 = 1;
                }
                c2 = 65535;
            }
            if (c2 != 0) {
                if (c2 == 1 && this.a.Q() && this.f1974b != null) {
                    if (!pVar.d(4)) {
                        this.f1974b.m();
                        return;
                    } else {
                        this.f1974b.l();
                        return;
                    }
                }
                return;
            }
            this.a.V(8);
        }
    }

    @Override // c.a.c0.s.h0.b
    public void i(p pVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048582, this, pVar) == null) {
        }
    }

    public final boolean k() {
        InterceptResult invokeV;
        BdVideoSeries o1;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) {
            c.a.c0.s.j0.f fVar = this.a;
            return (fVar == null || (o1 = fVar.u().o1()) == null || o1.getVideoAd() == null || o1.getVideoAd().fullItemAdData == null) ? false : true;
        }
        return invokeV.booleanValue;
    }

    public void l(boolean z) {
        i iVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeZ(InputDeviceCompat.SOURCE_TOUCHPAD, this, z) == null) || (iVar = this.f1974b) == null) {
            return;
        }
        iVar.j(z);
    }

    public final void m() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048585, this) == null) || this.f1974b == null) {
            return;
        }
        this.f1974b = null;
    }

    @Override // c.a.c0.s.f0.a
    public void onDestroy() {
        c.a.c0.s.j0.f fVar;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048586, this) == null) {
            if (this.f1974b != null && (fVar = this.a) != null && fVar.Q()) {
                this.f1974b.f();
            }
            i iVar = this.f1974b;
            if (iVar != null) {
                iVar.c();
                m();
            }
            this.a = null;
        }
    }

    @Override // c.a.c0.s.f0.a
    public void onLayerRelease() {
        i iVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048587, this) == null) || (iVar = this.f1974b) == null) {
            return;
        }
        iVar.f();
    }
}
