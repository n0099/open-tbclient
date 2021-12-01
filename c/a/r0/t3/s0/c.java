package c.a.r0.t3.s0;

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
/* loaded from: classes6.dex */
public class c {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public String A;
    public float B;
    public long C;
    public long D;
    public b E;
    public f F;
    public e G;
    public a H;
    public long a;

    /* renamed from: b  reason: collision with root package name */
    public long f23996b;

    /* renamed from: c  reason: collision with root package name */
    public long f23997c;

    /* renamed from: d  reason: collision with root package name */
    public long f23998d;

    /* renamed from: e  reason: collision with root package name */
    public int f23999e;

    /* renamed from: f  reason: collision with root package name */
    public String f24000f;

    /* renamed from: g  reason: collision with root package name */
    public long f24001g;

    /* renamed from: h  reason: collision with root package name */
    public int f24002h;

    /* renamed from: i  reason: collision with root package name */
    public int f24003i;

    /* renamed from: j  reason: collision with root package name */
    public int f24004j;

    /* renamed from: k  reason: collision with root package name */
    public int f24005k;
    public String l;
    public float m;
    public long n;
    public int o;
    public long p;
    public int q;
    public int r;
    public int s;
    public int t;
    public int u;
    public String v;
    public float w;
    public long x;
    public long y;
    public int z;

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
                long j2 = asyncPublishStatData.f23996b;
                if (j2 > 0) {
                    this.f23996b = j2;
                } else {
                    this.f23996b = asyncPublishStatData.a;
                }
            }
            this.a = writeData.startPublishTime();
            this.f23997c = writeData.startPublishTime();
            return;
        }
        throw new RuntimeException("writeData must is async mode(has startPublishTime)");
    }

    public JSONObject a() throws JSONException {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("id", this.a);
            jSONObject.put("parentId", this.f23996b);
            jSONObject.put("startTime", this.f23997c);
            return jSONObject;
        }
        return (JSONObject) invokeV.objValue;
    }

    public JSONObject b() throws JSONException {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("id", this.a);
            jSONObject.put("parentId", this.f23996b);
            jSONObject.put("startTime", this.f23997c);
            jSONObject.put("endTime", this.f23998d);
            jSONObject.put("errorCode", this.f23999e);
            jSONObject.put("errorMessage", this.f24000f);
            jSONObject.put("sendThreadDuration", this.f24001g);
            jSONObject.put("haveImage", this.f24002h);
            jSONObject.put("haveVideo", this.f24003i);
            jSONObject.put("haveVoice", this.f24004j);
            b bVar = this.E;
            if (bVar != null) {
                jSONObject.put("imagesData", bVar.a());
                jSONObject.put("imageErrorCode", this.f24005k);
                jSONObject.put("imageErrorMessage", this.l);
                jSONObject.put("imageUploadRate", this.m);
                jSONObject.put("imageUploadDuration", this.n);
                jSONObject.put("imageCount", this.o);
                jSONObject.put("imageSize", this.p);
                jSONObject.put("needImageParallel", this.q);
                jSONObject.put("imageChunkSize", this.r);
                jSONObject.put("imageUploadConcurrency", this.s);
                jSONObject.put("imageChunkRetry", this.t);
            }
            f fVar = this.F;
            if (fVar != null) {
                jSONObject.put("voiceData", fVar.a());
                jSONObject.put("voiceErrorCode", this.z);
                jSONObject.put("voiceErrorMessage", this.A);
                jSONObject.put("voiceUploadRate", this.B);
                jSONObject.put("voiceUploadDuration", this.C);
                jSONObject.put("voiceSize", this.D);
            }
            e eVar = this.G;
            if (eVar != null) {
                jSONObject.put("videoData", eVar.a());
                jSONObject.put("videoErrorCode", this.u);
                jSONObject.put("videoErrorMessage", this.v);
                jSONObject.put("videoUploadRate", this.w);
                jSONObject.put("videoUploadDuration", this.x);
                jSONObject.put(QzonePublish.PUBLISH_TO_QZONE_VIDEO_SIZE, this.y);
            }
            a aVar = this.H;
            if (aVar != null) {
                jSONObject.put("videoFirstFrame", aVar.a());
            }
            return jSONObject;
        }
        return (JSONObject) invokeV.objValue;
    }
}
