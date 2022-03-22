package c.a.a0.v.h0;

import android.text.TextUtils;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.view.InputDeviceCompat;
import c.a.a0.v.c0.p;
import c.a.a0.v.f0.d;
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
public class h extends c.a.a0.v.o0.a {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: d  reason: collision with root package name */
    public final HashMap<String, String> f1728d;

    /* renamed from: e  reason: collision with root package name */
    public final HashMap<String, String> f1729e;

    public h() {
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
        this.f1728d = new HashMap<>();
        this.f1729e = new HashMap<>();
    }

    @Override // c.a.a0.v.o0.a, c.a.a0.v.f0.j
    public void a(@NonNull p pVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, pVar) == null) {
            p(pVar);
        }
    }

    @Override // c.a.a0.v.o0.a, c.a.a0.v.f0.j
    public void d(@NonNull p pVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, pVar) == null) {
            p(pVar);
        }
    }

    @Override // c.a.a0.v.f0.j
    @Nullable
    public int[] getSubscribeEvent() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? new int[]{2, 4, 6} : (int[]) invokeV.objValue;
    }

    @Override // c.a.a0.v.o0.a
    public void m() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
            super.m();
            this.f1728d.clear();
            this.f1729e.clear();
        }
    }

    public final void p(@NonNull p pVar) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048580, this, pVar) == null) && w()) {
            c.a.a0.v.m0.a aVar = new c.a.a0.v.m0.a();
            aVar.h(p.a(pVar));
            aVar.b(v());
            aVar.c(s());
            aVar.d(r());
            aVar.e(u());
            aVar.g(t());
            c.a.a0.v.f fVar = (c.a.a0.v.f) i();
            BdVideoSeries o1 = fVar == null ? null : fVar.o1();
            if (o1 != null) {
                String extLog = o1.getExtLog();
                String str = this.f1728d.get(extLog);
                String str2 = this.f1729e.get(extLog);
                if (str == null) {
                    JSONObject b2 = c.a.a0.x.b.b(extLog);
                    String optString = b2.optString("ad_extra_param");
                    String optString2 = b2.optString(BdVideoAd.AD_VIDEO_DAPAGE);
                    this.f1728d.put(extLog, optString);
                    this.f1729e.put(extLog, optString2);
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

    @Override // c.a.a0.v.o0.a, c.a.a0.v.f0.j
    public void q(@NonNull p pVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048581, this, pVar) == null) {
            p(pVar);
        }
    }

    public final String r() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) {
            if (i() == null) {
                return "0";
            }
            if (i().K() != null && i().K().f1812e > 0) {
                return String.valueOf(i().K().f1812e);
            }
            return String.valueOf(i().r());
        }
        return (String) invokeV.objValue;
    }

    public final String s() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) ? i() == null ? "0" : String.valueOf(i().C()) : (String) invokeV.objValue;
    }

    public final String t() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) ? i() == null ? "0" : String.valueOf(i().D()) : (String) invokeV.objValue;
    }

    public final String u() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048585, this)) == null) {
            if (i() == null) {
                return "0";
            }
            return String.valueOf(i().K() != null ? i().K().f1811d : 0);
        }
        return (String) invokeV.objValue;
    }

    public final String v() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048586, this)) == null) ? ((i() instanceof c.a.a0.v.f) && ((c.a.a0.v.f) i()).l1() == 0) ? "1" : "0" : (String) invokeV.objValue;
    }

    public final boolean w() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048587, this)) == null) {
            if (i() instanceof c.a.a0.v.f) {
                c.a.a0.v.f fVar = (c.a.a0.v.f) i();
                return (fVar.o1() == null || TextUtils.isEmpty(fVar.o1().getExtLog())) ? false : true;
            }
            return false;
        }
        return invokeV.booleanValue;
    }
}
