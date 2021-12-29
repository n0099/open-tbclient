package c.a.t0.y.a.d;

import android.text.TextUtils;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tieba.advert.sdk.data.AdInfo;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.tencent.connect.share.QzonePublish;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes8.dex */
public class b {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public String a;

    /* renamed from: b  reason: collision with root package name */
    public String f26394b;

    /* renamed from: c  reason: collision with root package name */
    public String f26395c;

    /* renamed from: d  reason: collision with root package name */
    public String f26396d;

    /* renamed from: e  reason: collision with root package name */
    public String f26397e;

    /* renamed from: f  reason: collision with root package name */
    public String f26398f;

    /* renamed from: g  reason: collision with root package name */
    public int f26399g;

    /* renamed from: h  reason: collision with root package name */
    public int f26400h;

    /* renamed from: i  reason: collision with root package name */
    public int f26401i;

    /* renamed from: j  reason: collision with root package name */
    public long f26402j;

    /* renamed from: k  reason: collision with root package name */
    public long f26403k;

    public b() {
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
        this.f26396d = "";
        this.f26395c = "";
        this.f26397e = "";
        this.f26398f = "";
        this.f26394b = "";
        this.a = "";
    }

    public static b a(AdInfo adInfo) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65537, null, adInfo)) == null) {
            b bVar = new b();
            if (adInfo == null) {
                return bVar;
            }
            bVar.a = adInfo.adImgUrl;
            bVar.f26394b = adInfo.redirectUrl;
            bVar.f26402j = adInfo.startShowTime;
            bVar.f26403k = adInfo.endShowTime;
            bVar.f26396d = adInfo.videoLocalPath;
            bVar.f26397e = adInfo.videoJumpUrl;
            bVar.f26398f = adInfo.videoMd5;
            bVar.f26399g = adInfo.videoDuration;
            bVar.f26400h = adInfo.videoWidth;
            bVar.f26401i = adInfo.videoHight;
            bVar.f26395c = adInfo.adVideoUrl;
            return bVar;
        }
        return (b) invokeL.objValue;
    }

    public static b b(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65538, null, str)) == null) {
            b bVar = new b();
            try {
                JSONObject jSONObject = new JSONObject(str);
                bVar.a = jSONObject.optString("adImgUrl");
                bVar.f26394b = jSONObject.optString("redirectUrl");
                bVar.f26396d = jSONObject.optString("videoLocalPath");
                bVar.f26402j = jSONObject.optLong("startShowTime");
                bVar.f26403k = jSONObject.optLong("endShowTime");
                bVar.f26397e = jSONObject.optString("videoJumpUrl");
                bVar.f26398f = jSONObject.optString("videoMd5");
                bVar.f26399g = jSONObject.optInt(QzonePublish.PUBLISH_TO_QZONE_VIDEO_DURATION);
                bVar.f26400h = jSONObject.optInt("videoWidth");
                bVar.f26401i = jSONObject.optInt("videoHeight");
                bVar.f26395c = jSONObject.optString("adVideoUrl");
            } catch (JSONException e2) {
                e2.printStackTrace();
            }
            return bVar;
        }
        return (b) invokeL.objValue;
    }

    public boolean c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? (System.currentTimeMillis() / 1000 >= this.f26402j && System.currentTimeMillis() / 1000 <= this.f26403k) || (this.f26402j == 0 && this.f26403k == 0) : invokeV.booleanValue;
    }

    public boolean d() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? !TextUtils.isEmpty(this.f26396d) : invokeV.booleanValue;
    }

    public String toString() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.put("adImgUrl", this.a);
                jSONObject.put("redirectUrl", this.f26394b);
                jSONObject.put("videoLocalPath", this.f26396d);
                jSONObject.put("startShowTime", this.f26402j);
                jSONObject.put("endShowTime", this.f26403k);
                jSONObject.put("videoMd5", this.f26398f);
                jSONObject.put("videoJumpUrl", this.f26397e);
                jSONObject.put(QzonePublish.PUBLISH_TO_QZONE_VIDEO_DURATION, this.f26399g);
                jSONObject.put("videoWidth", this.f26400h);
                jSONObject.put("videoHeight", this.f26401i);
                jSONObject.put("adVideoUrl", this.f26395c);
            } catch (JSONException e2) {
                e2.printStackTrace();
            }
            return jSONObject.toString();
        }
        return (String) invokeV.objValue;
    }
}
