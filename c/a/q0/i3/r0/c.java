package c.a.q0.i3.r0;

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
    public float A;
    public long B;
    public long C;
    public b D;
    public f E;
    public e F;
    public a G;

    /* renamed from: a  reason: collision with root package name */
    public long f20498a;

    /* renamed from: b  reason: collision with root package name */
    public long f20499b;

    /* renamed from: c  reason: collision with root package name */
    public long f20500c;

    /* renamed from: d  reason: collision with root package name */
    public long f20501d;

    /* renamed from: e  reason: collision with root package name */
    public int f20502e;

    /* renamed from: f  reason: collision with root package name */
    public String f20503f;

    /* renamed from: g  reason: collision with root package name */
    public long f20504g;

    /* renamed from: h  reason: collision with root package name */
    public int f20505h;

    /* renamed from: i  reason: collision with root package name */
    public int f20506i;

    /* renamed from: j  reason: collision with root package name */
    public int f20507j;
    public int k;
    public String l;
    public float m;
    public long n;
    public int o;
    public long p;
    public int q;
    public int r;
    public int s;
    public int t;
    public String u;
    public float v;
    public long w;
    public long x;
    public int y;
    public String z;

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
                long j2 = asyncPublishStatData.f20499b;
                if (j2 > 0) {
                    this.f20499b = j2;
                } else {
                    this.f20499b = asyncPublishStatData.f20498a;
                }
            }
            this.f20498a = writeData.startPublishTime();
            this.f20500c = writeData.startPublishTime();
            return;
        }
        throw new RuntimeException("writeData must is async mode(has startPublishTime)");
    }

    public JSONObject a() throws JSONException {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("id", this.f20498a);
            jSONObject.put("parentId", this.f20499b);
            jSONObject.put("startTime", this.f20500c);
            return jSONObject;
        }
        return (JSONObject) invokeV.objValue;
    }

    public JSONObject b() throws JSONException {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("id", this.f20498a);
            jSONObject.put("parentId", this.f20499b);
            jSONObject.put("startTime", this.f20500c);
            jSONObject.put("endTime", this.f20501d);
            jSONObject.put("errorCode", this.f20502e);
            jSONObject.put("errorMessage", this.f20503f);
            jSONObject.put("sendThreadDuration", this.f20504g);
            jSONObject.put("haveImage", this.f20505h);
            jSONObject.put("haveVideo", this.f20506i);
            jSONObject.put("haveVoice", this.f20507j);
            b bVar = this.D;
            if (bVar != null) {
                jSONObject.put("imagesData", bVar.a());
                jSONObject.put("imageErrorCode", this.k);
                jSONObject.put("imageErrorMessage", this.l);
                jSONObject.put("imageUploadRate", this.m);
                jSONObject.put("imageUploadDuration", this.n);
                jSONObject.put("imageCount", this.o);
                jSONObject.put("imageSize", this.p);
                jSONObject.put("needImageParallel", this.q);
                jSONObject.put("imageChunkSize", this.r);
                jSONObject.put("imageUploadConcurrency", this.s);
            }
            f fVar = this.E;
            if (fVar != null) {
                jSONObject.put("voiceData", fVar.a());
                jSONObject.put("voiceErrorCode", this.y);
                jSONObject.put("voiceErrorMessage", this.z);
                jSONObject.put("voiceUploadRate", this.A);
                jSONObject.put("voiceUploadDuration", this.B);
                jSONObject.put("voiceSize", this.C);
            }
            e eVar = this.F;
            if (eVar != null) {
                jSONObject.put("videoData", eVar.a());
                jSONObject.put("videoErrorCode", this.t);
                jSONObject.put("videoErrorMessage", this.u);
                jSONObject.put("videoUploadRate", this.v);
                jSONObject.put("videoUploadDuration", this.w);
                jSONObject.put(QzonePublish.PUBLISH_TO_QZONE_VIDEO_SIZE, this.x);
            }
            a aVar = this.G;
            if (aVar != null) {
                jSONObject.put("videoFirstFrame", aVar.a());
            }
            return jSONObject;
        }
        return (JSONObject) invokeV.objValue;
    }
}
