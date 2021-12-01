package c.a.r0.y.a.d;

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
/* loaded from: classes7.dex */
public class b {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public String a;

    /* renamed from: b  reason: collision with root package name */
    public String f25502b;

    /* renamed from: c  reason: collision with root package name */
    public String f25503c;

    /* renamed from: d  reason: collision with root package name */
    public String f25504d;

    /* renamed from: e  reason: collision with root package name */
    public String f25505e;

    /* renamed from: f  reason: collision with root package name */
    public String f25506f;

    /* renamed from: g  reason: collision with root package name */
    public int f25507g;

    /* renamed from: h  reason: collision with root package name */
    public int f25508h;

    /* renamed from: i  reason: collision with root package name */
    public int f25509i;

    /* renamed from: j  reason: collision with root package name */
    public long f25510j;

    /* renamed from: k  reason: collision with root package name */
    public long f25511k;

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
        this.f25504d = "";
        this.f25503c = "";
        this.f25505e = "";
        this.f25506f = "";
        this.f25502b = "";
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
            bVar.f25502b = adInfo.redirectUrl;
            bVar.f25510j = adInfo.startShowTime;
            bVar.f25511k = adInfo.endShowTime;
            bVar.f25504d = adInfo.videoLocalPath;
            bVar.f25505e = adInfo.videoJumpUrl;
            bVar.f25506f = adInfo.videoMd5;
            bVar.f25507g = adInfo.videoDuration;
            bVar.f25508h = adInfo.videoWidth;
            bVar.f25509i = adInfo.videoHight;
            bVar.f25503c = adInfo.adVideoUrl;
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
                bVar.f25502b = jSONObject.optString("redirectUrl");
                bVar.f25504d = jSONObject.optString("videoLocalPath");
                bVar.f25510j = jSONObject.optLong("startShowTime");
                bVar.f25511k = jSONObject.optLong("endShowTime");
                bVar.f25505e = jSONObject.optString("videoJumpUrl");
                bVar.f25506f = jSONObject.optString("videoMd5");
                bVar.f25507g = jSONObject.optInt(QzonePublish.PUBLISH_TO_QZONE_VIDEO_DURATION);
                bVar.f25508h = jSONObject.optInt("videoWidth");
                bVar.f25509i = jSONObject.optInt("videoHeight");
                bVar.f25503c = jSONObject.optString("adVideoUrl");
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
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? (System.currentTimeMillis() / 1000 >= this.f25510j && System.currentTimeMillis() / 1000 <= this.f25511k) || (this.f25510j == 0 && this.f25511k == 0) : invokeV.booleanValue;
    }

    public boolean d() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? !TextUtils.isEmpty(this.f25504d) : invokeV.booleanValue;
    }

    public String toString() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.put("adImgUrl", this.a);
                jSONObject.put("redirectUrl", this.f25502b);
                jSONObject.put("videoLocalPath", this.f25504d);
                jSONObject.put("startShowTime", this.f25510j);
                jSONObject.put("endShowTime", this.f25511k);
                jSONObject.put("videoMd5", this.f25506f);
                jSONObject.put("videoJumpUrl", this.f25505e);
                jSONObject.put(QzonePublish.PUBLISH_TO_QZONE_VIDEO_DURATION, this.f25507g);
                jSONObject.put("videoWidth", this.f25508h);
                jSONObject.put("videoHeight", this.f25509i);
                jSONObject.put("adVideoUrl", this.f25503c);
            } catch (JSONException e2) {
                e2.printStackTrace();
            }
            return jSONObject.toString();
        }
        return (String) invokeV.objValue;
    }
}
