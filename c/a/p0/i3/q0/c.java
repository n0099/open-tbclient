package c.a.p0.i3.q0;

import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.coreExtra.data.WriteData;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.tencent.connect.share.QzonePublish;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes3.dex */
public class c {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public b A;
    public f B;
    public e C;
    public a D;

    /* renamed from: a  reason: collision with root package name */
    public long f20166a;

    /* renamed from: b  reason: collision with root package name */
    public long f20167b;

    /* renamed from: c  reason: collision with root package name */
    public long f20168c;

    /* renamed from: d  reason: collision with root package name */
    public long f20169d;

    /* renamed from: e  reason: collision with root package name */
    public int f20170e;

    /* renamed from: f  reason: collision with root package name */
    public String f20171f;

    /* renamed from: g  reason: collision with root package name */
    public long f20172g;

    /* renamed from: h  reason: collision with root package name */
    public int f20173h;

    /* renamed from: i  reason: collision with root package name */
    public int f20174i;

    /* renamed from: j  reason: collision with root package name */
    public int f20175j;
    public int k;
    public String l;
    public float m;
    public long n;
    public int o;
    public long p;
    public int q;
    public String r;
    public float s;
    public long t;
    public long u;
    public int v;
    public String w;
    public float x;
    public long y;
    public long z;

    public c(WriteData writeData) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {writeData};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        if (writeData != null && writeData.startPublishTime() > 0) {
            c asyncPublishStatData = writeData.getAsyncPublishStatData();
            if (asyncPublishStatData != null) {
                long j2 = asyncPublishStatData.f20167b;
                if (j2 > 0) {
                    this.f20167b = j2;
                } else {
                    this.f20167b = asyncPublishStatData.f20166a;
                }
            }
            this.f20166a = writeData.startPublishTime();
            this.f20168c = writeData.startPublishTime();
            return;
        }
        throw new RuntimeException("writeData must is async mode(has startPublishTime)");
    }

    public JSONObject a() throws JSONException {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("id", this.f20166a);
            jSONObject.put("parentId", this.f20167b);
            jSONObject.put("startTime", this.f20168c);
            return jSONObject;
        }
        return (JSONObject) invokeV.objValue;
    }

    public JSONObject b() throws JSONException {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("id", this.f20166a);
            jSONObject.put("parentId", this.f20167b);
            jSONObject.put("startTime", this.f20168c);
            jSONObject.put("endTime", this.f20169d);
            jSONObject.put("errorCode", this.f20170e);
            jSONObject.put("errorMessage", this.f20171f);
            jSONObject.put("sendThreadDuration", this.f20172g);
            jSONObject.put("haveImage", this.f20173h);
            jSONObject.put("haveVideo", this.f20174i);
            jSONObject.put("haveVoice", this.f20175j);
            b bVar = this.A;
            if (bVar != null) {
                jSONObject.put("imagesData", bVar.a());
                jSONObject.put("imageErrorCode", this.k);
                jSONObject.put("imageErrorMessage", this.l);
                jSONObject.put("imageUploadRate", this.m);
                jSONObject.put("imageUploadDuration", this.n);
                jSONObject.put("imageCount", this.o);
                jSONObject.put("imageSize", this.p);
            }
            f fVar = this.B;
            if (fVar != null) {
                jSONObject.put("voiceData", fVar.a());
                jSONObject.put("voiceErrorCode", this.v);
                jSONObject.put("voiceErrorMessage", this.w);
                jSONObject.put("voiceUploadRate", this.x);
                jSONObject.put("voiceUploadDuration", this.y);
                jSONObject.put("voiceSize", this.z);
            }
            e eVar = this.C;
            if (eVar != null) {
                jSONObject.put("videoData", eVar.a());
                jSONObject.put("videoErrorCode", this.q);
                jSONObject.put("videoErrorMessage", this.r);
                jSONObject.put("videoUploadRate", this.s);
                jSONObject.put("videoUploadDuration", this.t);
                jSONObject.put(QzonePublish.PUBLISH_TO_QZONE_VIDEO_SIZE, this.u);
            }
            a aVar = this.D;
            if (aVar != null) {
                jSONObject.put("videoFirstFrame", aVar.a());
            }
            return jSONObject;
        }
        return (JSONObject) invokeV.objValue;
    }
}
