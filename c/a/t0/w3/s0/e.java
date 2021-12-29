package c.a.t0.w3.s0;

import androidx.annotation.NonNull;
import com.baidu.searchbox.pms.db.PackageTable;
import com.baidu.tbadk.coreExtra.data.VideoInfo;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes8.dex */
public class e {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public long a;

    /* renamed from: b  reason: collision with root package name */
    public long f25746b;

    /* renamed from: c  reason: collision with root package name */
    public int f25747c;

    /* renamed from: d  reason: collision with root package name */
    public String f25748d;

    /* renamed from: e  reason: collision with root package name */
    public String f25749e;

    /* renamed from: f  reason: collision with root package name */
    public int f25750f;

    /* renamed from: g  reason: collision with root package name */
    public String f25751g;

    /* renamed from: h  reason: collision with root package name */
    public String f25752h;

    /* renamed from: i  reason: collision with root package name */
    public long f25753i;

    public e(@NonNull VideoInfo videoInfo) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {videoInfo};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.a = System.currentTimeMillis();
        this.f25749e = videoInfo.getVideoPath();
        this.f25750f = videoInfo.getVideoDuration();
    }

    public JSONObject a() throws JSONException {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("startTime", this.a);
            jSONObject.put("endTime", this.f25746b);
            jSONObject.put("errorCode", this.f25747c);
            jSONObject.put("errorMessage", this.f25748d);
            jSONObject.put(PackageTable.MD5, this.f25751g);
            jSONObject.put("url", this.f25752h);
            jSONObject.put("path", this.f25749e);
            jSONObject.put("duration", this.f25750f);
            jSONObject.put("size", this.f25753i);
            return jSONObject;
        }
        return (JSONObject) invokeV.objValue;
    }
}
