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
/* loaded from: classes9.dex */
public class b {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public String a;

    /* renamed from: b  reason: collision with root package name */
    public String f25337b;

    /* renamed from: c  reason: collision with root package name */
    public String f25338c;

    /* renamed from: d  reason: collision with root package name */
    public String f25339d;

    /* renamed from: e  reason: collision with root package name */
    public String f25340e;

    /* renamed from: f  reason: collision with root package name */
    public String f25341f;

    /* renamed from: g  reason: collision with root package name */
    public int f25342g;

    /* renamed from: h  reason: collision with root package name */
    public int f25343h;

    /* renamed from: i  reason: collision with root package name */
    public int f25344i;

    /* renamed from: j  reason: collision with root package name */
    public long f25345j;
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
        this.f25339d = "";
        this.f25338c = "";
        this.f25340e = "";
        this.f25341f = "";
        this.f25337b = "";
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
            bVar.f25337b = adInfo.redirectUrl;
            bVar.f25345j = adInfo.startShowTime;
            bVar.k = adInfo.endShowTime;
            bVar.f25339d = adInfo.videoLocalPath;
            bVar.f25340e = adInfo.videoJumpUrl;
            bVar.f25341f = adInfo.videoMd5;
            bVar.f25342g = adInfo.videoDuration;
            bVar.f25343h = adInfo.videoWidth;
            bVar.f25344i = adInfo.videoHight;
            bVar.f25338c = adInfo.adVideoUrl;
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
                bVar.f25337b = jSONObject.optString("redirectUrl");
                bVar.f25339d = jSONObject.optString("videoLocalPath");
                bVar.f25345j = jSONObject.optLong("startShowTime");
                bVar.k = jSONObject.optLong("endShowTime");
                bVar.f25340e = jSONObject.optString("videoJumpUrl");
                bVar.f25341f = jSONObject.optString("videoMd5");
                bVar.f25342g = jSONObject.optInt(QzonePublish.PUBLISH_TO_QZONE_VIDEO_DURATION);
                bVar.f25343h = jSONObject.optInt("videoWidth");
                bVar.f25344i = jSONObject.optInt("videoHeight");
                bVar.f25338c = jSONObject.optString("adVideoUrl");
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
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? (System.currentTimeMillis() / 1000 >= this.f25345j && System.currentTimeMillis() / 1000 <= this.k) || (this.f25345j == 0 && this.k == 0) : invokeV.booleanValue;
    }

    public boolean d() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? !TextUtils.isEmpty(this.f25339d) : invokeV.booleanValue;
    }

    public String toString() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.put("adImgUrl", this.a);
                jSONObject.put("redirectUrl", this.f25337b);
                jSONObject.put("videoLocalPath", this.f25339d);
                jSONObject.put("startShowTime", this.f25345j);
                jSONObject.put("endShowTime", this.k);
                jSONObject.put("videoMd5", this.f25341f);
                jSONObject.put("videoJumpUrl", this.f25340e);
                jSONObject.put(QzonePublish.PUBLISH_TO_QZONE_VIDEO_DURATION, this.f25342g);
                jSONObject.put("videoWidth", this.f25343h);
                jSONObject.put("videoHeight", this.f25344i);
                jSONObject.put("adVideoUrl", this.f25338c);
            } catch (JSONException e2) {
                e2.printStackTrace();
            }
            return jSONObject.toString();
        }
        return (String) invokeV.objValue;
    }
}
