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
/* loaded from: classes3.dex */
public class b {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public String a;

    /* renamed from: b  reason: collision with root package name */
    public String f24649b;

    /* renamed from: c  reason: collision with root package name */
    public String f24650c;

    /* renamed from: d  reason: collision with root package name */
    public String f24651d;

    /* renamed from: e  reason: collision with root package name */
    public String f24652e;

    /* renamed from: f  reason: collision with root package name */
    public String f24653f;

    /* renamed from: g  reason: collision with root package name */
    public int f24654g;

    /* renamed from: h  reason: collision with root package name */
    public int f24655h;

    /* renamed from: i  reason: collision with root package name */
    public int f24656i;

    /* renamed from: j  reason: collision with root package name */
    public long f24657j;
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
        this.f24651d = "";
        this.f24650c = "";
        this.f24652e = "";
        this.f24653f = "";
        this.f24649b = "";
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
            bVar.f24649b = adInfo.redirectUrl;
            bVar.f24657j = adInfo.startShowTime;
            bVar.k = adInfo.endShowTime;
            bVar.f24651d = adInfo.videoLocalPath;
            bVar.f24652e = adInfo.videoJumpUrl;
            bVar.f24653f = adInfo.videoMd5;
            bVar.f24654g = adInfo.videoDuration;
            bVar.f24655h = adInfo.videoWidth;
            bVar.f24656i = adInfo.videoHight;
            bVar.f24650c = adInfo.adVideoUrl;
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
                bVar.f24649b = jSONObject.optString("redirectUrl");
                bVar.f24651d = jSONObject.optString("videoLocalPath");
                bVar.f24657j = jSONObject.optLong("startShowTime");
                bVar.k = jSONObject.optLong("endShowTime");
                bVar.f24652e = jSONObject.optString("videoJumpUrl");
                bVar.f24653f = jSONObject.optString("videoMd5");
                bVar.f24654g = jSONObject.optInt(QzonePublish.PUBLISH_TO_QZONE_VIDEO_DURATION);
                bVar.f24655h = jSONObject.optInt("videoWidth");
                bVar.f24656i = jSONObject.optInt("videoHeight");
                bVar.f24650c = jSONObject.optString("adVideoUrl");
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
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? (System.currentTimeMillis() / 1000 >= this.f24657j && System.currentTimeMillis() / 1000 <= this.k) || (this.f24657j == 0 && this.k == 0) : invokeV.booleanValue;
    }

    public boolean d() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? !TextUtils.isEmpty(this.f24651d) : invokeV.booleanValue;
    }

    public String toString() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.put("adImgUrl", this.a);
                jSONObject.put("redirectUrl", this.f24649b);
                jSONObject.put("videoLocalPath", this.f24651d);
                jSONObject.put("startShowTime", this.f24657j);
                jSONObject.put("endShowTime", this.k);
                jSONObject.put("videoMd5", this.f24653f);
                jSONObject.put("videoJumpUrl", this.f24652e);
                jSONObject.put(QzonePublish.PUBLISH_TO_QZONE_VIDEO_DURATION, this.f24654g);
                jSONObject.put("videoWidth", this.f24655h);
                jSONObject.put("videoHeight", this.f24656i);
                jSONObject.put("adVideoUrl", this.f24650c);
            } catch (JSONException e2) {
                e2.printStackTrace();
            }
            return jSONObject.toString();
        }
        return (String) invokeV.objValue;
    }
}
