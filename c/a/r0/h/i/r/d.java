package c.a.r0.h.i.r;

import android.text.TextUtils;
import androidx.core.view.InputDeviceCompat;
import c.a.r0.h.i.m.e;
import c.a.r0.h.i.m.h;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.searchbox.common.runtime.AppRuntime;
import com.baidu.searchbox.http.callback.ResponseCallback;
import com.baidu.swan.game.ad.entity.AdElementInfo;
import com.baidu.swan.game.ad.utils.NetworkUtils;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.qq.e.comm.constants.Constants;
import okhttp3.Response;
import org.json.JSONObject;
/* loaded from: classes6.dex */
public class d {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* loaded from: classes6.dex */
    public static class a extends ResponseCallback<c.a.r0.h.i.k.a> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ e a;

        public a(e eVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {eVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = eVar;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.searchbox.http.callback.ResponseCallback
        /* renamed from: a */
        public void onSuccess(c.a.r0.h.i.k.a aVar, int i2) {
            e eVar;
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeLI(1048576, this, aVar, i2) == null) || aVar == null || (eVar = this.a) == null) {
                return;
            }
            eVar.d(aVar.a, aVar.f10596b);
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.searchbox.http.callback.ResponseCallback
        /* renamed from: b */
        public c.a.r0.h.i.k.a parseResponse(Response response, int i2) {
            InterceptResult invokeLI;
            JSONObject optJSONObject;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLI = interceptable.invokeLI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, response, i2)) == null) {
                if (response == null || response.body() == null || !response.isSuccessful()) {
                    return null;
                }
                try {
                    String string = response.body().string();
                    if (!TextUtils.isEmpty(string)) {
                        try {
                            JSONObject jSONObject = new JSONObject(string);
                            if (TextUtils.equals(jSONObject.optString(Constants.KEYS.RET, ""), "0") && (optJSONObject = jSONObject.optJSONObject("data")) != null) {
                                c.a.r0.h.i.k.a aVar = new c.a.r0.h.i.k.a();
                                aVar.a = optJSONObject.optString("clickid");
                                aVar.f10596b = optJSONObject.optString("dstlink");
                                return aVar;
                            }
                            return null;
                        } catch (Exception e2) {
                            e2.printStackTrace();
                        }
                    }
                } catch (Exception | OutOfMemoryError unused) {
                }
                return null;
            }
            return (c.a.r0.h.i.k.a) invokeLI.objValue;
        }

        @Override // com.baidu.searchbox.http.callback.ResponseCallback
        public void onFail(Exception exc) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(com.baidu.android.imsdk.internal.Constants.METHOD_SEND_USER_MSG, this, exc) == null) {
            }
        }
    }

    public static void a(c.a.r0.h.i.r.a aVar, AdElementInfo adElementInfo, h hVar, e eVar) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLLLL(65536, null, aVar, adElementInfo, hVar, eVar) == null) || adElementInfo == null || TextUtils.isEmpty(adElementInfo.getClickUrl())) {
            return;
        }
        String c2 = c(adElementInfo.getClickUrl(), aVar);
        a aVar2 = new a(eVar);
        if (!NetworkUtils.f(AppRuntime.getAppContext()) || hVar == null) {
            return;
        }
        hVar.c(c2, aVar2);
    }

    public static void b(String str, h hVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65537, null, str, hVar) == null) {
            hVar.e(str);
        }
    }

    public static String c(String str, c.a.r0.h.i.r.a aVar) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLL = interceptable.invokeLL(65538, null, str, aVar)) == null) ? aVar == null ? str : str.replaceAll("\\{REQ_WIDTH\\}", aVar.a).replaceAll("\\{REQ_HEIGHT\\}", aVar.f10700b).replaceAll("\\{WIDTH\\}", aVar.f10701c).replaceAll("\\{HEIGHT\\}", aVar.f10702d).replaceAll("\\{DOWN_X\\}", aVar.f10703e).replaceAll("\\{DOWN_Y\\}", aVar.f10704f).replaceAll("\\{UP_X\\}", aVar.f10705g).replaceAll("\\{UP_Y\\}", aVar.f10706h).replaceAll("\\{VIDEO_TIME\\}", aVar.f10707i).replaceAll("\\{BEGIN_TIME\\}", aVar.f10708j).replaceAll("\\{END_TIME\\}", aVar.k).replaceAll("\\{PLAY_FIRST_FRAME\\}", aVar.l).replaceAll("\\{PLAY_LAST_FRAME\\}", aVar.m).replaceAll("\\{SCENE\\}", aVar.n).replaceAll("\\{TYPE\\}", aVar.o).replaceAll("\\{BEHAVIOR\\}", aVar.p).replaceAll("\\{STATUS\\}", aVar.q).replaceAll("\\{CONVERSION_ACTION\\}", aVar.r).replaceAll("\\{CLICK_ID\\}", aVar.s) : (String) invokeLL.objValue;
    }

    public static void d(AdElementInfo adElementInfo, h hVar) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(65539, null, adElementInfo, hVar) == null) || adElementInfo == null) {
            return;
        }
        for (String str : adElementInfo.getThirdClickTrackingUrls()) {
            b(c(str, null), hVar);
        }
    }

    public static void e(c.a.r0.h.i.r.a aVar, AdElementInfo adElementInfo, h hVar) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLLL(InputDeviceCompat.SOURCE_TRACKBALL, null, aVar, adElementInfo, hVar) == null) || adElementInfo == null) {
            return;
        }
        for (String str : adElementInfo.getConversionUrls()) {
            b(c(str, aVar), hVar);
        }
    }

    public static void f(AdElementInfo adElementInfo, h hVar) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(65541, null, adElementInfo, hVar) == null) || adElementInfo == null) {
            return;
        }
        for (String str : adElementInfo.getImpressionUrls()) {
            b(c(str, null), hVar);
        }
    }

    public static void g(c.a.r0.h.i.r.a aVar, AdElementInfo adElementInfo, h hVar) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLLL(65542, null, aVar, adElementInfo, hVar) == null) || adElementInfo == null) {
            return;
        }
        for (String str : adElementInfo.getCloseTrackers()) {
            b(c(str, aVar), hVar);
        }
    }
}
