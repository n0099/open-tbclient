package c.a.r0.u.a.f;

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
    public String f25080a;

    /* renamed from: b  reason: collision with root package name */
    public String f25081b;

    /* renamed from: c  reason: collision with root package name */
    public String f25082c;

    /* renamed from: d  reason: collision with root package name */
    public String f25083d;

    /* renamed from: e  reason: collision with root package name */
    public String f25084e;

    /* renamed from: f  reason: collision with root package name */
    public String f25085f;

    /* renamed from: g  reason: collision with root package name */
    public int f25086g;

    /* renamed from: h  reason: collision with root package name */
    public int f25087h;

    /* renamed from: i  reason: collision with root package name */
    public int f25088i;

    /* renamed from: j  reason: collision with root package name */
    public long f25089j;
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
        this.f25083d = "";
        this.f25082c = "";
        this.f25084e = "";
        this.f25085f = "";
        this.f25081b = "";
        this.f25080a = "";
    }

    public static b a(AdInfo adInfo) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65537, null, adInfo)) == null) {
            b bVar = new b();
            if (adInfo == null) {
                return bVar;
            }
            bVar.f25080a = adInfo.adImgUrl;
            bVar.f25081b = adInfo.redirectUrl;
            bVar.f25089j = adInfo.startShowTime;
            bVar.k = adInfo.endShowTime;
            bVar.f25083d = adInfo.videoLocalPath;
            bVar.f25084e = adInfo.videoJumpUrl;
            bVar.f25085f = adInfo.videoMd5;
            bVar.f25086g = adInfo.videoDuration;
            bVar.f25087h = adInfo.videoWidth;
            bVar.f25088i = adInfo.videoHight;
            bVar.f25082c = adInfo.adVideoUrl;
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
                bVar.f25080a = jSONObject.optString("adImgUrl");
                bVar.f25081b = jSONObject.optString("redirectUrl");
                bVar.f25083d = jSONObject.optString("videoLocalPath");
                bVar.f25089j = jSONObject.optLong("startShowTime");
                bVar.k = jSONObject.optLong("endShowTime");
                bVar.f25084e = jSONObject.optString("videoJumpUrl");
                bVar.f25085f = jSONObject.optString("videoMd5");
                bVar.f25086g = jSONObject.optInt(QzonePublish.PUBLISH_TO_QZONE_VIDEO_DURATION);
                bVar.f25087h = jSONObject.optInt("videoWidth");
                bVar.f25088i = jSONObject.optInt("videoHeight");
                bVar.f25082c = jSONObject.optString("adVideoUrl");
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
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? (System.currentTimeMillis() / 1000 >= this.f25089j && System.currentTimeMillis() / 1000 <= this.k) || (this.f25089j == 0 && this.k == 0) : invokeV.booleanValue;
    }

    public boolean d() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? !TextUtils.isEmpty(this.f25083d) : invokeV.booleanValue;
    }

    public String toString() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.put("adImgUrl", this.f25080a);
                jSONObject.put("redirectUrl", this.f25081b);
                jSONObject.put("videoLocalPath", this.f25083d);
                jSONObject.put("startShowTime", this.f25089j);
                jSONObject.put("endShowTime", this.k);
                jSONObject.put("videoMd5", this.f25085f);
                jSONObject.put("videoJumpUrl", this.f25084e);
                jSONObject.put(QzonePublish.PUBLISH_TO_QZONE_VIDEO_DURATION, this.f25086g);
                jSONObject.put("videoWidth", this.f25087h);
                jSONObject.put("videoHeight", this.f25088i);
                jSONObject.put("adVideoUrl", this.f25082c);
            } catch (JSONException e2) {
                e2.printStackTrace();
            }
            return jSONObject.toString();
        }
        return (String) invokeV.objValue;
    }
}
