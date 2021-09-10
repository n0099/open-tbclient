package c.a.r0.j3.r0;

import androidx.annotation.NonNull;
import com.baidu.tbadk.img.ImageFileInfo;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes3.dex */
public class a {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public long f21049a;

    /* renamed from: b  reason: collision with root package name */
    public long f21050b;

    /* renamed from: c  reason: collision with root package name */
    public int f21051c;

    /* renamed from: d  reason: collision with root package name */
    public String f21052d;

    /* renamed from: e  reason: collision with root package name */
    public String f21053e;

    /* renamed from: f  reason: collision with root package name */
    public long f21054f;

    /* renamed from: g  reason: collision with root package name */
    public float f21055g;

    /* renamed from: h  reason: collision with root package name */
    public String f21056h;

    /* renamed from: i  reason: collision with root package name */
    public long f21057i;

    /* renamed from: j  reason: collision with root package name */
    public int f21058j;
    public int k;
    public boolean l;
    public boolean m;
    public long n;
    public long o;
    public boolean p;
    public String q;
    public String r;
    public int s;
    public int t;
    public long u;

    public a(@NonNull ImageFileInfo imageFileInfo) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {imageFileInfo};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        long currentTimeMillis = System.currentTimeMillis();
        imageFileInfo.startUploadTime = currentTimeMillis;
        this.f21049a = currentTimeMillis;
    }

    public JSONObject a() throws JSONException {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("startTime", this.f21049a);
            jSONObject.put("endTime", this.f21050b);
            jSONObject.put("uploadRate", this.f21055g);
            jSONObject.put("errorCode", this.f21051c);
            jSONObject.put("errorMessage", this.f21052d);
            jSONObject.put("picId", this.f21053e);
            jSONObject.put("originPath", this.f21056h);
            jSONObject.put("originSize", this.f21057i);
            jSONObject.put("originWidth", this.f21058j);
            jSONObject.put("originHeight", this.k);
            jSONObject.put("isLongImage", this.l);
            jSONObject.put("isHeifImage", this.m);
            jSONObject.put("startCompressTime", this.n);
            jSONObject.put("endCompressTime", this.o);
            jSONObject.put("hasActionsWithoutResize", this.p);
            jSONObject.put("uploadImageType", this.q);
            jSONObject.put("compressTempPath", this.r);
            jSONObject.put("compressWidth", this.s);
            jSONObject.put("compressHeight", this.t);
            jSONObject.put("compressSize", this.u);
            return jSONObject;
        }
        return (JSONObject) invokeV.objValue;
    }

    public a(@NonNull String str) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {str};
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.f21049a = System.currentTimeMillis();
        this.f21056h = str;
    }
}
