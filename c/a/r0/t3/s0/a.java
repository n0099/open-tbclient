package c.a.r0.t3.s0;

import androidx.annotation.NonNull;
import com.baidu.tbadk.img.ImageFileInfo;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes6.dex */
public class a {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public long a;

    /* renamed from: b  reason: collision with root package name */
    public long f23982b;

    /* renamed from: c  reason: collision with root package name */
    public int f23983c;

    /* renamed from: d  reason: collision with root package name */
    public String f23984d;

    /* renamed from: e  reason: collision with root package name */
    public String f23985e;

    /* renamed from: f  reason: collision with root package name */
    public long f23986f;

    /* renamed from: g  reason: collision with root package name */
    public float f23987g;

    /* renamed from: h  reason: collision with root package name */
    public String f23988h;

    /* renamed from: i  reason: collision with root package name */
    public long f23989i;

    /* renamed from: j  reason: collision with root package name */
    public int f23990j;

    /* renamed from: k  reason: collision with root package name */
    public int f23991k;
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
        this.a = currentTimeMillis;
    }

    public JSONObject a() throws JSONException {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("startTime", this.a);
            jSONObject.put("endTime", this.f23982b);
            jSONObject.put("uploadRate", this.f23987g);
            jSONObject.put("errorCode", this.f23983c);
            jSONObject.put("errorMessage", this.f23984d);
            jSONObject.put("picId", this.f23985e);
            jSONObject.put("originPath", this.f23988h);
            jSONObject.put("originSize", this.f23989i);
            jSONObject.put("originWidth", this.f23990j);
            jSONObject.put("originHeight", this.f23991k);
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
        this.a = System.currentTimeMillis();
        this.f23988h = str;
    }
}
