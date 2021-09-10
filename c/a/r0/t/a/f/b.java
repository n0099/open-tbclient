package c.a.r0.t.a.f;

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
    public String f24883a;

    /* renamed from: b  reason: collision with root package name */
    public String f24884b;

    /* renamed from: c  reason: collision with root package name */
    public String f24885c;

    /* renamed from: d  reason: collision with root package name */
    public String f24886d;

    /* renamed from: e  reason: collision with root package name */
    public String f24887e;

    /* renamed from: f  reason: collision with root package name */
    public String f24888f;

    /* renamed from: g  reason: collision with root package name */
    public int f24889g;

    /* renamed from: h  reason: collision with root package name */
    public int f24890h;

    /* renamed from: i  reason: collision with root package name */
    public int f24891i;

    /* renamed from: j  reason: collision with root package name */
    public long f24892j;
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
        this.f24886d = "";
        this.f24885c = "";
        this.f24887e = "";
        this.f24888f = "";
        this.f24884b = "";
        this.f24883a = "";
    }

    public static b a(AdInfo adInfo) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65537, null, adInfo)) == null) {
            b bVar = new b();
            if (adInfo == null) {
                return bVar;
            }
            bVar.f24883a = adInfo.adImgUrl;
            bVar.f24884b = adInfo.redirectUrl;
            bVar.f24892j = adInfo.startShowTime;
            bVar.k = adInfo.endShowTime;
            bVar.f24886d = adInfo.videoLocalPath;
            bVar.f24887e = adInfo.videoJumpUrl;
            bVar.f24888f = adInfo.videoMd5;
            bVar.f24889g = adInfo.videoDuration;
            bVar.f24890h = adInfo.videoWidth;
            bVar.f24891i = adInfo.videoHight;
            bVar.f24885c = adInfo.adVideoUrl;
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
                bVar.f24883a = jSONObject.optString("adImgUrl");
                bVar.f24884b = jSONObject.optString("redirectUrl");
                bVar.f24886d = jSONObject.optString("videoLocalPath");
                bVar.f24892j = jSONObject.optLong("startShowTime");
                bVar.k = jSONObject.optLong("endShowTime");
                bVar.f24887e = jSONObject.optString("videoJumpUrl");
                bVar.f24888f = jSONObject.optString("videoMd5");
                bVar.f24889g = jSONObject.optInt(QzonePublish.PUBLISH_TO_QZONE_VIDEO_DURATION);
                bVar.f24890h = jSONObject.optInt("videoWidth");
                bVar.f24891i = jSONObject.optInt("videoHeight");
                bVar.f24885c = jSONObject.optString("adVideoUrl");
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
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? (System.currentTimeMillis() / 1000 >= this.f24892j && System.currentTimeMillis() / 1000 <= this.k) || (this.f24892j == 0 && this.k == 0) : invokeV.booleanValue;
    }

    public boolean d() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? !TextUtils.isEmpty(this.f24886d) : invokeV.booleanValue;
    }

    public String toString() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.put("adImgUrl", this.f24883a);
                jSONObject.put("redirectUrl", this.f24884b);
                jSONObject.put("videoLocalPath", this.f24886d);
                jSONObject.put("startShowTime", this.f24892j);
                jSONObject.put("endShowTime", this.k);
                jSONObject.put("videoMd5", this.f24888f);
                jSONObject.put("videoJumpUrl", this.f24887e);
                jSONObject.put(QzonePublish.PUBLISH_TO_QZONE_VIDEO_DURATION, this.f24889g);
                jSONObject.put("videoWidth", this.f24890h);
                jSONObject.put("videoHeight", this.f24891i);
                jSONObject.put("adVideoUrl", this.f24885c);
            } catch (JSONException e2) {
                e2.printStackTrace();
            }
            return jSONObject.toString();
        }
        return (String) invokeV.objValue;
    }
}
