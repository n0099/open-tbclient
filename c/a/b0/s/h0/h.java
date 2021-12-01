package c.a.b0.s.h0;

import android.text.TextUtils;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.view.InputDeviceCompat;
import c.a.b0.s.c0.p;
import c.a.b0.s.f0.d;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.nadcore.video.plugin.videoplayer.model.BdVideoAd;
import com.baidu.nadcore.video.plugin.videoplayer.model.BdVideoSeries;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.HashMap;
import org.json.JSONObject;
/* loaded from: classes.dex */
public class h extends c.a.b0.s.o0.a {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: h  reason: collision with root package name */
    public final HashMap<String, String> f1952h;

    /* renamed from: i  reason: collision with root package name */
    public final HashMap<String, String> f1953i;

    public h() {
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
        this.f1952h = new HashMap<>();
        this.f1953i = new HashMap<>();
    }

    @Override // c.a.b0.s.o0.a, c.a.b0.s.f0.j
    public void b(@NonNull p pVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, pVar) == null) {
            q(pVar);
        }
    }

    @Override // c.a.b0.s.o0.a, c.a.b0.s.f0.j
    public void e(@NonNull p pVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, pVar) == null) {
            q(pVar);
        }
    }

    @Override // c.a.b0.s.f0.j
    @Nullable
    public int[] getSubscribeEvent() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? new int[]{2, 4, 6} : (int[]) invokeV.objValue;
    }

    @Override // c.a.b0.s.o0.a
    public void n() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
            super.n();
            this.f1952h.clear();
            this.f1953i.clear();
        }
    }

    public final void q(@NonNull p pVar) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048580, this, pVar) == null) && x()) {
            c.a.b0.s.m0.a aVar = new c.a.b0.s.m0.a();
            aVar.h(p.a(pVar));
            aVar.b(w());
            aVar.c(t());
            aVar.d(s());
            aVar.e(v());
            aVar.g(u());
            c.a.b0.s.f fVar = (c.a.b0.s.f) j();
            BdVideoSeries o1 = fVar == null ? null : fVar.o1();
            if (o1 != null) {
                String extLog = o1.getExtLog();
                String str = this.f1952h.get(extLog);
                String str2 = this.f1953i.get(extLog);
                if (str == null) {
                    JSONObject b2 = c.a.b0.u.b.b(extLog);
                    String optString = b2.optString("ad_extra_param");
                    String optString2 = b2.optString(BdVideoAd.AD_VIDEO_DAPAGE);
                    this.f1952h.put(extLog, optString);
                    this.f1953i.put(extLog, optString2);
                    str2 = optString2;
                    str = optString;
                }
                aVar.f(str);
                aVar.a(str2);
            }
            d.a.a().a(aVar);
            d.a.a().b(aVar);
            p pVar2 = aVar.a;
            if (pVar2 != null) {
                pVar2.o();
            }
        }
    }

    @Override // c.a.b0.s.o0.a, c.a.b0.s.f0.j
    public void r(@NonNull p pVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048581, this, pVar) == null) {
            q(pVar);
        }
    }

    public final String s() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) {
            if (j() == null) {
                return "0";
            }
            if (j().K() != null && j().K().f2043e > 0) {
                return String.valueOf(j().K().f2043e);
            }
            return String.valueOf(j().r());
        }
        return (String) invokeV.objValue;
    }

    public final String t() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) ? j() == null ? "0" : String.valueOf(j().C()) : (String) invokeV.objValue;
    }

    public final String u() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) ? j() == null ? "0" : String.valueOf(j().D()) : (String) invokeV.objValue;
    }

    public final String v() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048585, this)) == null) {
            if (j() == null) {
                return "0";
            }
            return String.valueOf(j().K() != null ? j().K().f2042d : 0);
        }
        return (String) invokeV.objValue;
    }

    public final String w() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048586, this)) == null) ? ((j() instanceof c.a.b0.s.f) && ((c.a.b0.s.f) j()).l1() == 0) ? "1" : "0" : (String) invokeV.objValue;
    }

    public final boolean x() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048587, this)) == null) {
            if (j() instanceof c.a.b0.s.f) {
                c.a.b0.s.f fVar = (c.a.b0.s.f) j();
                return (fVar.o1() == null || TextUtils.isEmpty(fVar.o1().getExtLog())) ? false : true;
            }
            return false;
        }
        return invokeV.booleanValue;
    }
}
