package b.a.p0.f.i.q;

import android.text.TextUtils;
import androidx.core.view.InputDeviceCompat;
import b.a.p0.f.i.l.g;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.mobads.container.util.AdIconUtil;
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
/* loaded from: classes4.dex */
public class d {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* loaded from: classes4.dex */
    public static class a extends ResponseCallback<b.a.p0.f.i.k.a> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ b.a.p0.f.i.l.d f9899a;

        public a(b.a.p0.f.i.l.d dVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {dVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f9899a = dVar;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.searchbox.http.callback.ResponseCallback
        /* renamed from: a */
        public void onSuccess(b.a.p0.f.i.k.a aVar, int i2) {
            b.a.p0.f.i.l.d dVar;
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeLI(1048576, this, aVar, i2) == null) || aVar == null || (dVar = this.f9899a) == null) {
                return;
            }
            dVar.d(aVar.f9779a, aVar.f9780b);
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.searchbox.http.callback.ResponseCallback
        /* renamed from: b */
        public b.a.p0.f.i.k.a parseResponse(Response response, int i2) {
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
                                b.a.p0.f.i.k.a aVar = new b.a.p0.f.i.k.a();
                                aVar.f9779a = optJSONObject.optString("clickid");
                                aVar.f9780b = optJSONObject.optString("dstlink");
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
            return (b.a.p0.f.i.k.a) invokeLI.objValue;
        }

        @Override // com.baidu.searchbox.http.callback.ResponseCallback
        public void onFail(Exception exc) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(com.baidu.android.imsdk.internal.Constants.METHOD_SEND_USER_MSG, this, exc) == null) {
            }
        }
    }

    public static void a(b.a.p0.f.i.q.a aVar, AdElementInfo adElementInfo, g gVar, b.a.p0.f.i.l.d dVar) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLLLL(65536, null, aVar, adElementInfo, gVar, dVar) == null) || adElementInfo == null || TextUtils.isEmpty(adElementInfo.getClickUrl())) {
            return;
        }
        String c2 = c(adElementInfo.getClickUrl(), aVar);
        a aVar2 = new a(dVar);
        if (!NetworkUtils.f(AppRuntime.getAppContext()) || gVar == null) {
            return;
        }
        gVar.b(c2, aVar2);
    }

    public static void b(String str, g gVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65537, null, str, gVar) == null) {
            gVar.d(str);
        }
    }

    public static String c(String str, b.a.p0.f.i.q.a aVar) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLL = interceptable.invokeLL(65538, null, str, aVar)) == null) ? aVar == null ? str : str.replaceAll("\\{REQ_WIDTH\\}", aVar.f9888a).replaceAll("\\{REQ_HEIGHT\\}", aVar.f9889b).replaceAll("\\{WIDTH\\}", aVar.f9890c).replaceAll("\\{HEIGHT\\}", aVar.f9891d).replaceAll("\\{DOWN_X\\}", aVar.f9892e).replaceAll("\\{DOWN_Y\\}", aVar.f9893f).replaceAll("\\{UP_X\\}", aVar.f9894g).replaceAll("\\{UP_Y\\}", aVar.f9895h).replaceAll("\\{VIDEO_TIME\\}", aVar.f9896i).replaceAll("\\{BEGIN_TIME\\}", aVar.j).replaceAll("\\{END_TIME\\}", aVar.k).replaceAll("\\{PLAY_FIRST_FRAME\\}", aVar.l).replaceAll("\\{PLAY_LAST_FRAME\\}", aVar.m).replaceAll("\\{SCENE\\}", aVar.n).replaceAll("\\{TYPE\\}", aVar.o).replaceAll("\\{BEHAVIOR\\}", aVar.p).replaceAll("\\{STATUS\\}", aVar.q).replaceAll("\\{CONVERSION_ACTION\\}", aVar.r).replaceAll("\\{CLICK_ID\\}", aVar.s) : (String) invokeLL.objValue;
    }

    public static void d(AdElementInfo adElementInfo, g gVar) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(65539, null, adElementInfo, gVar) == null) || adElementInfo == null) {
            return;
        }
        for (String str : adElementInfo.getThirdClickTrackingUrls()) {
            b(c(str, null), gVar);
        }
    }

    public static void e(b.a.p0.f.i.q.a aVar, AdElementInfo adElementInfo, g gVar) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLLL(InputDeviceCompat.SOURCE_TRACKBALL, null, aVar, adElementInfo, gVar) == null) || adElementInfo == null) {
            return;
        }
        for (String str : adElementInfo.getConversionUrls()) {
            b(c(str, aVar), gVar);
        }
    }

    public static void f(AdElementInfo adElementInfo, g gVar) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(AdIconUtil.AD_TEXT_ID, null, adElementInfo, gVar) == null) || adElementInfo == null) {
            return;
        }
        for (String str : adElementInfo.getImpressionUrls()) {
            b(c(str, null), gVar);
        }
    }

    public static void g(b.a.p0.f.i.q.a aVar, AdElementInfo adElementInfo, g gVar) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLLL(AdIconUtil.BAIDU_LOGO_ID, null, aVar, adElementInfo, gVar) == null) || adElementInfo == null) {
            return;
        }
        for (String str : adElementInfo.getCloseTrackers()) {
            b(c(str, aVar), gVar);
        }
    }
}
