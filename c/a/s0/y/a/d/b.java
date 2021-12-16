package c.a.s0.y.a.d;

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
    public String f25913b;

    /* renamed from: c  reason: collision with root package name */
    public String f25914c;

    /* renamed from: d  reason: collision with root package name */
    public String f25915d;

    /* renamed from: e  reason: collision with root package name */
    public String f25916e;

    /* renamed from: f  reason: collision with root package name */
    public String f25917f;

    /* renamed from: g  reason: collision with root package name */
    public int f25918g;

    /* renamed from: h  reason: collision with root package name */
    public int f25919h;

    /* renamed from: i  reason: collision with root package name */
    public int f25920i;

    /* renamed from: j  reason: collision with root package name */
    public long f25921j;

    /* renamed from: k  reason: collision with root package name */
    public long f25922k;

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
        this.f25915d = "";
        this.f25914c = "";
        this.f25916e = "";
        this.f25917f = "";
        this.f25913b = "";
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
            bVar.f25913b = adInfo.redirectUrl;
            bVar.f25921j = adInfo.startShowTime;
            bVar.f25922k = adInfo.endShowTime;
            bVar.f25915d = adInfo.videoLocalPath;
            bVar.f25916e = adInfo.videoJumpUrl;
            bVar.f25917f = adInfo.videoMd5;
            bVar.f25918g = adInfo.videoDuration;
            bVar.f25919h = adInfo.videoWidth;
            bVar.f25920i = adInfo.videoHight;
            bVar.f25914c = adInfo.adVideoUrl;
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
                bVar.f25913b = jSONObject.optString("redirectUrl");
                bVar.f25915d = jSONObject.optString("videoLocalPath");
                bVar.f25921j = jSONObject.optLong("startShowTime");
                bVar.f25922k = jSONObject.optLong("endShowTime");
                bVar.f25916e = jSONObject.optString("videoJumpUrl");
                bVar.f25917f = jSONObject.optString("videoMd5");
                bVar.f25918g = jSONObject.optInt(QzonePublish.PUBLISH_TO_QZONE_VIDEO_DURATION);
                bVar.f25919h = jSONObject.optInt("videoWidth");
                bVar.f25920i = jSONObject.optInt("videoHeight");
                bVar.f25914c = jSONObject.optString("adVideoUrl");
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
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? (System.currentTimeMillis() / 1000 >= this.f25921j && System.currentTimeMillis() / 1000 <= this.f25922k) || (this.f25921j == 0 && this.f25922k == 0) : invokeV.booleanValue;
    }

    public boolean d() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? !TextUtils.isEmpty(this.f25915d) : invokeV.booleanValue;
    }

    public String toString() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.put("adImgUrl", this.a);
                jSONObject.put("redirectUrl", this.f25913b);
                jSONObject.put("videoLocalPath", this.f25915d);
                jSONObject.put("startShowTime", this.f25921j);
                jSONObject.put("endShowTime", this.f25922k);
                jSONObject.put("videoMd5", this.f25917f);
                jSONObject.put("videoJumpUrl", this.f25916e);
                jSONObject.put(QzonePublish.PUBLISH_TO_QZONE_VIDEO_DURATION, this.f25918g);
                jSONObject.put("videoWidth", this.f25919h);
                jSONObject.put("videoHeight", this.f25920i);
                jSONObject.put("adVideoUrl", this.f25914c);
            } catch (JSONException e2) {
                e2.printStackTrace();
            }
            return jSONObject.toString();
        }
        return (String) invokeV.objValue;
    }
}
