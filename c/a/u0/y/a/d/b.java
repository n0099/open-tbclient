package c.a.u0.y.a.d;

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
    public String f25287b;

    /* renamed from: c  reason: collision with root package name */
    public String f25288c;

    /* renamed from: d  reason: collision with root package name */
    public String f25289d;

    /* renamed from: e  reason: collision with root package name */
    public String f25290e;

    /* renamed from: f  reason: collision with root package name */
    public String f25291f;

    /* renamed from: g  reason: collision with root package name */
    public int f25292g;

    /* renamed from: h  reason: collision with root package name */
    public int f25293h;

    /* renamed from: i  reason: collision with root package name */
    public int f25294i;

    /* renamed from: j  reason: collision with root package name */
    public long f25295j;
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
        this.f25289d = "";
        this.f25288c = "";
        this.f25290e = "";
        this.f25291f = "";
        this.f25287b = "";
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
            bVar.f25287b = adInfo.redirectUrl;
            bVar.f25295j = adInfo.startShowTime;
            bVar.k = adInfo.endShowTime;
            bVar.f25289d = adInfo.videoLocalPath;
            bVar.f25290e = adInfo.videoJumpUrl;
            bVar.f25291f = adInfo.videoMd5;
            bVar.f25292g = adInfo.videoDuration;
            bVar.f25293h = adInfo.videoWidth;
            bVar.f25294i = adInfo.videoHight;
            bVar.f25288c = adInfo.adVideoUrl;
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
                bVar.f25287b = jSONObject.optString("redirectUrl");
                bVar.f25289d = jSONObject.optString("videoLocalPath");
                bVar.f25295j = jSONObject.optLong("startShowTime");
                bVar.k = jSONObject.optLong("endShowTime");
                bVar.f25290e = jSONObject.optString("videoJumpUrl");
                bVar.f25291f = jSONObject.optString("videoMd5");
                bVar.f25292g = jSONObject.optInt(QzonePublish.PUBLISH_TO_QZONE_VIDEO_DURATION);
                bVar.f25293h = jSONObject.optInt("videoWidth");
                bVar.f25294i = jSONObject.optInt("videoHeight");
                bVar.f25288c = jSONObject.optString("adVideoUrl");
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
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? (System.currentTimeMillis() / 1000 >= this.f25295j && System.currentTimeMillis() / 1000 <= this.k) || (this.f25295j == 0 && this.k == 0) : invokeV.booleanValue;
    }

    public boolean d() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? !TextUtils.isEmpty(this.f25289d) : invokeV.booleanValue;
    }

    public String toString() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.put("adImgUrl", this.a);
                jSONObject.put("redirectUrl", this.f25287b);
                jSONObject.put("videoLocalPath", this.f25289d);
                jSONObject.put("startShowTime", this.f25295j);
                jSONObject.put("endShowTime", this.k);
                jSONObject.put("videoMd5", this.f25291f);
                jSONObject.put("videoJumpUrl", this.f25290e);
                jSONObject.put(QzonePublish.PUBLISH_TO_QZONE_VIDEO_DURATION, this.f25292g);
                jSONObject.put("videoWidth", this.f25293h);
                jSONObject.put("videoHeight", this.f25294i);
                jSONObject.put("adVideoUrl", this.f25288c);
            } catch (JSONException e2) {
                e2.printStackTrace();
            }
            return jSONObject.toString();
        }
        return (String) invokeV.objValue;
    }
}
