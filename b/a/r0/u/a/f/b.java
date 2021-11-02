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
    public String f23924a;

    /* renamed from: b  reason: collision with root package name */
    public String f23925b;

    /* renamed from: c  reason: collision with root package name */
    public String f23926c;

    /* renamed from: d  reason: collision with root package name */
    public String f23927d;

    /* renamed from: e  reason: collision with root package name */
    public String f23928e;

    /* renamed from: f  reason: collision with root package name */
    public String f23929f;

    /* renamed from: g  reason: collision with root package name */
    public int f23930g;

    /* renamed from: h  reason: collision with root package name */
    public int f23931h;

    /* renamed from: i  reason: collision with root package name */
    public int f23932i;
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
        this.f23927d = "";
        this.f23926c = "";
        this.f23928e = "";
        this.f23929f = "";
        this.f23925b = "";
        this.f23924a = "";
    }

    public static b a(AdInfo adInfo) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65537, null, adInfo)) == null) {
            b bVar = new b();
            if (adInfo == null) {
                return bVar;
            }
            bVar.f23924a = adInfo.adImgUrl;
            bVar.f23925b = adInfo.redirectUrl;
            bVar.j = adInfo.startShowTime;
            bVar.k = adInfo.endShowTime;
            bVar.f23927d = adInfo.videoLocalPath;
            bVar.f23928e = adInfo.videoJumpUrl;
            bVar.f23929f = adInfo.videoMd5;
            bVar.f23930g = adInfo.videoDuration;
            bVar.f23931h = adInfo.videoWidth;
            bVar.f23932i = adInfo.videoHight;
            bVar.f23926c = adInfo.adVideoUrl;
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
                bVar.f23924a = jSONObject.optString("adImgUrl");
                bVar.f23925b = jSONObject.optString("redirectUrl");
                bVar.f23927d = jSONObject.optString("videoLocalPath");
                bVar.j = jSONObject.optLong("startShowTime");
                bVar.k = jSONObject.optLong("endShowTime");
                bVar.f23928e = jSONObject.optString("videoJumpUrl");
                bVar.f23929f = jSONObject.optString("videoMd5");
                bVar.f23930g = jSONObject.optInt(QzonePublish.PUBLISH_TO_QZONE_VIDEO_DURATION);
                bVar.f23931h = jSONObject.optInt("videoWidth");
                bVar.f23932i = jSONObject.optInt("videoHeight");
                bVar.f23926c = jSONObject.optString("adVideoUrl");
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
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? !TextUtils.isEmpty(this.f23927d) : invokeV.booleanValue;
    }

    public String toString() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.put("adImgUrl", this.f23924a);
                jSONObject.put("redirectUrl", this.f23925b);
                jSONObject.put("videoLocalPath", this.f23927d);
                jSONObject.put("startShowTime", this.j);
                jSONObject.put("endShowTime", this.k);
                jSONObject.put("videoMd5", this.f23929f);
                jSONObject.put("videoJumpUrl", this.f23928e);
                jSONObject.put(QzonePublish.PUBLISH_TO_QZONE_VIDEO_DURATION, this.f23930g);
                jSONObject.put("videoWidth", this.f23931h);
                jSONObject.put("videoHeight", this.f23932i);
                jSONObject.put("adVideoUrl", this.f23926c);
            } catch (JSONException e2) {
                e2.printStackTrace();
            }
            return jSONObject.toString();
        }
        return (String) invokeV.objValue;
    }
}
