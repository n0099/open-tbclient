package c.a.q0.i3.r0;

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
/* loaded from: classes3.dex */
public class e {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public long f20508a;

    /* renamed from: b  reason: collision with root package name */
    public long f20509b;

    /* renamed from: c  reason: collision with root package name */
    public int f20510c;

    /* renamed from: d  reason: collision with root package name */
    public String f20511d;

    /* renamed from: e  reason: collision with root package name */
    public String f20512e;

    /* renamed from: f  reason: collision with root package name */
    public int f20513f;

    /* renamed from: g  reason: collision with root package name */
    public String f20514g;

    /* renamed from: h  reason: collision with root package name */
    public String f20515h;

    /* renamed from: i  reason: collision with root package name */
    public long f20516i;

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
        this.f20508a = System.currentTimeMillis();
        this.f20512e = videoInfo.getVideoPath();
        this.f20513f = videoInfo.getVideoDuration();
    }

    public JSONObject a() throws JSONException {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("startTime", this.f20508a);
            jSONObject.put("endTime", this.f20509b);
            jSONObject.put("errorCode", this.f20510c);
            jSONObject.put("errorMessage", this.f20511d);
            jSONObject.put(PackageTable.MD5, this.f20514g);
            jSONObject.put("url", this.f20515h);
            jSONObject.put("path", this.f20512e);
            jSONObject.put("duration", this.f20513f);
            jSONObject.put("size", this.f20516i);
            return jSONObject;
        }
        return (JSONObject) invokeV.objValue;
    }
}
