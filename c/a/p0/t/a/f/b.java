package c.a.p0.t.a.f;

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
/* loaded from: classes3.dex */
public class b {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public String f24131a;

    /* renamed from: b  reason: collision with root package name */
    public String f24132b;

    /* renamed from: c  reason: collision with root package name */
    public String f24133c;

    /* renamed from: d  reason: collision with root package name */
    public String f24134d;

    /* renamed from: e  reason: collision with root package name */
    public String f24135e;

    /* renamed from: f  reason: collision with root package name */
    public String f24136f;

    /* renamed from: g  reason: collision with root package name */
    public int f24137g;

    /* renamed from: h  reason: collision with root package name */
    public int f24138h;

    /* renamed from: i  reason: collision with root package name */
    public int f24139i;

    /* renamed from: j  reason: collision with root package name */
    public long f24140j;
    public long k;

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
        this.f24134d = "";
        this.f24133c = "";
        this.f24135e = "";
        this.f24136f = "";
        this.f24132b = "";
        this.f24131a = "";
    }

    public static b a(AdInfo adInfo) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65537, null, adInfo)) == null) {
            b bVar = new b();
            if (adInfo == null) {
                return bVar;
            }
            bVar.f24131a = adInfo.adImgUrl;
            bVar.f24132b = adInfo.redirectUrl;
            bVar.f24140j = adInfo.startShowTime;
            bVar.k = adInfo.endShowTime;
            bVar.f24134d = adInfo.videoLocalPath;
            bVar.f24135e = adInfo.videoJumpUrl;
            bVar.f24136f = adInfo.videoMd5;
            bVar.f24137g = adInfo.videoDuration;
            bVar.f24138h = adInfo.videoWidth;
            bVar.f24139i = adInfo.videoHight;
            bVar.f24133c = adInfo.adVideoUrl;
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
                bVar.f24131a = jSONObject.optString("adImgUrl");
                bVar.f24132b = jSONObject.optString("redirectUrl");
                bVar.f24134d = jSONObject.optString("videoLocalPath");
                bVar.f24140j = jSONObject.optLong("startShowTime");
                bVar.k = jSONObject.optLong("endShowTime");
                bVar.f24135e = jSONObject.optString("videoJumpUrl");
                bVar.f24136f = jSONObject.optString("videoMd5");
                bVar.f24137g = jSONObject.optInt(QzonePublish.PUBLISH_TO_QZONE_VIDEO_DURATION);
                bVar.f24138h = jSONObject.optInt("videoWidth");
                bVar.f24139i = jSONObject.optInt("videoHeight");
                bVar.f24133c = jSONObject.optString("adVideoUrl");
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
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? (System.currentTimeMillis() / 1000 >= this.f24140j && System.currentTimeMillis() / 1000 <= this.k) || (this.f24140j == 0 && this.k == 0) : invokeV.booleanValue;
    }

    public boolean d() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? !TextUtils.isEmpty(this.f24134d) : invokeV.booleanValue;
    }

    public String toString() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.put("adImgUrl", this.f24131a);
                jSONObject.put("redirectUrl", this.f24132b);
                jSONObject.put("videoLocalPath", this.f24134d);
                jSONObject.put("startShowTime", this.f24140j);
                jSONObject.put("endShowTime", this.k);
                jSONObject.put("videoMd5", this.f24136f);
                jSONObject.put("videoJumpUrl", this.f24135e);
                jSONObject.put(QzonePublish.PUBLISH_TO_QZONE_VIDEO_DURATION, this.f24137g);
                jSONObject.put("videoWidth", this.f24138h);
                jSONObject.put("videoHeight", this.f24139i);
                jSONObject.put("adVideoUrl", this.f24133c);
            } catch (JSONException e2) {
                e2.printStackTrace();
            }
            return jSONObject.toString();
        }
        return (String) invokeV.objValue;
    }
}
