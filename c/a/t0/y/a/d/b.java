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
    public String f25610b;

    /* renamed from: c  reason: collision with root package name */
    public String f25611c;

    /* renamed from: d  reason: collision with root package name */
    public String f25612d;

    /* renamed from: e  reason: collision with root package name */
    public String f25613e;

    /* renamed from: f  reason: collision with root package name */
    public String f25614f;

    /* renamed from: g  reason: collision with root package name */
    public int f25615g;

    /* renamed from: h  reason: collision with root package name */
    public int f25616h;

    /* renamed from: i  reason: collision with root package name */
    public int f25617i;

    /* renamed from: j  reason: collision with root package name */
    public long f25618j;
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
        this.f25612d = "";
        this.f25611c = "";
        this.f25613e = "";
        this.f25614f = "";
        this.f25610b = "";
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
            bVar.f25610b = adInfo.redirectUrl;
            bVar.f25618j = adInfo.startShowTime;
            bVar.k = adInfo.endShowTime;
            bVar.f25612d = adInfo.videoLocalPath;
            bVar.f25613e = adInfo.videoJumpUrl;
            bVar.f25614f = adInfo.videoMd5;
            bVar.f25615g = adInfo.videoDuration;
            bVar.f25616h = adInfo.videoWidth;
            bVar.f25617i = adInfo.videoHight;
            bVar.f25611c = adInfo.adVideoUrl;
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
                bVar.f25610b = jSONObject.optString("redirectUrl");
                bVar.f25612d = jSONObject.optString("videoLocalPath");
                bVar.f25618j = jSONObject.optLong("startShowTime");
                bVar.k = jSONObject.optLong("endShowTime");
                bVar.f25613e = jSONObject.optString("videoJumpUrl");
                bVar.f25614f = jSONObject.optString("videoMd5");
                bVar.f25615g = jSONObject.optInt(QzonePublish.PUBLISH_TO_QZONE_VIDEO_DURATION);
                bVar.f25616h = jSONObject.optInt("videoWidth");
                bVar.f25617i = jSONObject.optInt("videoHeight");
                bVar.f25611c = jSONObject.optString("adVideoUrl");
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
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? (System.currentTimeMillis() / 1000 >= this.f25618j && System.currentTimeMillis() / 1000 <= this.k) || (this.f25618j == 0 && this.k == 0) : invokeV.booleanValue;
    }

    public boolean d() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? !TextUtils.isEmpty(this.f25612d) : invokeV.booleanValue;
    }

    public String toString() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.put("adImgUrl", this.a);
                jSONObject.put("redirectUrl", this.f25610b);
                jSONObject.put("videoLocalPath", this.f25612d);
                jSONObject.put("startShowTime", this.f25618j);
                jSONObject.put("endShowTime", this.k);
                jSONObject.put("videoMd5", this.f25614f);
                jSONObject.put("videoJumpUrl", this.f25613e);
                jSONObject.put(QzonePublish.PUBLISH_TO_QZONE_VIDEO_DURATION, this.f25615g);
                jSONObject.put("videoWidth", this.f25616h);
                jSONObject.put("videoHeight", this.f25617i);
                jSONObject.put("adVideoUrl", this.f25611c);
            } catch (JSONException e2) {
                e2.printStackTrace();
            }
            return jSONObject.toString();
        }
        return (String) invokeV.objValue;
    }
}
