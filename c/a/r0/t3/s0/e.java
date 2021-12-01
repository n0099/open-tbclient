package c.a.r0.t3.s0;

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
/* loaded from: classes6.dex */
public class e {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public long a;

    /* renamed from: b  reason: collision with root package name */
    public long f24006b;

    /* renamed from: c  reason: collision with root package name */
    public int f24007c;

    /* renamed from: d  reason: collision with root package name */
    public String f24008d;

    /* renamed from: e  reason: collision with root package name */
    public String f24009e;

    /* renamed from: f  reason: collision with root package name */
    public int f24010f;

    /* renamed from: g  reason: collision with root package name */
    public String f24011g;

    /* renamed from: h  reason: collision with root package name */
    public String f24012h;

    /* renamed from: i  reason: collision with root package name */
    public long f24013i;

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
        this.f24009e = videoInfo.getVideoPath();
        this.f24010f = videoInfo.getVideoDuration();
    }

    public JSONObject a() throws JSONException {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("startTime", this.a);
            jSONObject.put("endTime", this.f24006b);
            jSONObject.put("errorCode", this.f24007c);
            jSONObject.put("errorMessage", this.f24008d);
            jSONObject.put(PackageTable.MD5, this.f24011g);
            jSONObject.put("url", this.f24012h);
            jSONObject.put("path", this.f24009e);
            jSONObject.put("duration", this.f24010f);
            jSONObject.put("size", this.f24013i);
            return jSONObject;
        }
        return (JSONObject) invokeV.objValue;
    }
}
