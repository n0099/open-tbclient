package c.a.r0.k3.r0;

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
    public long f21240a;

    /* renamed from: b  reason: collision with root package name */
    public long f21241b;

    /* renamed from: c  reason: collision with root package name */
    public int f21242c;

    /* renamed from: d  reason: collision with root package name */
    public String f21243d;

    /* renamed from: e  reason: collision with root package name */
    public String f21244e;

    /* renamed from: f  reason: collision with root package name */
    public long f21245f;

    /* renamed from: g  reason: collision with root package name */
    public float f21246g;

    /* renamed from: h  reason: collision with root package name */
    public String f21247h;

    /* renamed from: i  reason: collision with root package name */
    public long f21248i;

    /* renamed from: j  reason: collision with root package name */
    public int f21249j;
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
        this.f21240a = currentTimeMillis;
    }

    public JSONObject a() throws JSONException {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("startTime", this.f21240a);
            jSONObject.put("endTime", this.f21241b);
            jSONObject.put("uploadRate", this.f21246g);
            jSONObject.put("errorCode", this.f21242c);
            jSONObject.put("errorMessage", this.f21243d);
            jSONObject.put("picId", this.f21244e);
            jSONObject.put("originPath", this.f21247h);
            jSONObject.put("originSize", this.f21248i);
            jSONObject.put("originWidth", this.f21249j);
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
        this.f21240a = System.currentTimeMillis();
        this.f21247h = str;
    }
}
