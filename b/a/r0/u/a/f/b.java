package b.a.r0.u.a.f;

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
/* loaded from: classes5.dex */
public class b {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public String f25412a;

    /* renamed from: b  reason: collision with root package name */
    public String f25413b;

    /* renamed from: c  reason: collision with root package name */
    public String f25414c;

    /* renamed from: d  reason: collision with root package name */
    public String f25415d;

    /* renamed from: e  reason: collision with root package name */
    public String f25416e;

    /* renamed from: f  reason: collision with root package name */
    public String f25417f;

    /* renamed from: g  reason: collision with root package name */
    public int f25418g;

    /* renamed from: h  reason: collision with root package name */
    public int f25419h;

    /* renamed from: i  reason: collision with root package name */
    public int f25420i;
    public long j;
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
        this.f25415d = "";
        this.f25414c = "";
        this.f25416e = "";
        this.f25417f = "";
        this.f25413b = "";
        this.f25412a = "";
    }

    public static b a(AdInfo adInfo) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65537, null, adInfo)) == null) {
            b bVar = new b();
            if (adInfo == null) {
                return bVar;
            }
            bVar.f25412a = adInfo.adImgUrl;
            bVar.f25413b = adInfo.redirectUrl;
            bVar.j = adInfo.startShowTime;
            bVar.k = adInfo.endShowTime;
            bVar.f25415d = adInfo.videoLocalPath;
            bVar.f25416e = adInfo.videoJumpUrl;
            bVar.f25417f = adInfo.videoMd5;
            bVar.f25418g = adInfo.videoDuration;
            bVar.f25419h = adInfo.videoWidth;
            bVar.f25420i = adInfo.videoHight;
            bVar.f25414c = adInfo.adVideoUrl;
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
                bVar.f25412a = jSONObject.optString("adImgUrl");
                bVar.f25413b = jSONObject.optString("redirectUrl");
                bVar.f25415d = jSONObject.optString("videoLocalPath");
                bVar.j = jSONObject.optLong("startShowTime");
                bVar.k = jSONObject.optLong("endShowTime");
                bVar.f25416e = jSONObject.optString("videoJumpUrl");
                bVar.f25417f = jSONObject.optString("videoMd5");
                bVar.f25418g = jSONObject.optInt(QzonePublish.PUBLISH_TO_QZONE_VIDEO_DURATION);
                bVar.f25419h = jSONObject.optInt("videoWidth");
                bVar.f25420i = jSONObject.optInt("videoHeight");
                bVar.f25414c = jSONObject.optString("adVideoUrl");
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
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? (System.currentTimeMillis() / 1000 >= this.j && System.currentTimeMillis() / 1000 <= this.k) || (this.j == 0 && this.k == 0) : invokeV.booleanValue;
    }

    public boolean d() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? !TextUtils.isEmpty(this.f25415d) : invokeV.booleanValue;
    }

    public String toString() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.put("adImgUrl", this.f25412a);
                jSONObject.put("redirectUrl", this.f25413b);
                jSONObject.put("videoLocalPath", this.f25415d);
                jSONObject.put("startShowTime", this.j);
                jSONObject.put("endShowTime", this.k);
                jSONObject.put("videoMd5", this.f25417f);
                jSONObject.put("videoJumpUrl", this.f25416e);
                jSONObject.put(QzonePublish.PUBLISH_TO_QZONE_VIDEO_DURATION, this.f25418g);
                jSONObject.put("videoWidth", this.f25419h);
                jSONObject.put("videoHeight", this.f25420i);
                jSONObject.put("adVideoUrl", this.f25414c);
            } catch (JSONException e2) {
                e2.printStackTrace();
            }
            return jSONObject.toString();
        }
        return (String) invokeV.objValue;
    }
}
