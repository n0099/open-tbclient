package b.a.r0.l3.s0;

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
/* loaded from: classes5.dex */
public class e {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public long f20831a;

    /* renamed from: b  reason: collision with root package name */
    public long f20832b;

    /* renamed from: c  reason: collision with root package name */
    public int f20833c;

    /* renamed from: d  reason: collision with root package name */
    public String f20834d;

    /* renamed from: e  reason: collision with root package name */
    public String f20835e;

    /* renamed from: f  reason: collision with root package name */
    public int f20836f;

    /* renamed from: g  reason: collision with root package name */
    public String f20837g;

    /* renamed from: h  reason: collision with root package name */
    public String f20838h;

    /* renamed from: i  reason: collision with root package name */
    public long f20839i;

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
        this.f20831a = System.currentTimeMillis();
        this.f20835e = videoInfo.getVideoPath();
        this.f20836f = videoInfo.getVideoDuration();
    }

    public JSONObject a() throws JSONException {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("startTime", this.f20831a);
            jSONObject.put("endTime", this.f20832b);
            jSONObject.put("errorCode", this.f20833c);
            jSONObject.put("errorMessage", this.f20834d);
            jSONObject.put(PackageTable.MD5, this.f20837g);
            jSONObject.put("url", this.f20838h);
            jSONObject.put("path", this.f20835e);
            jSONObject.put("duration", this.f20836f);
            jSONObject.put("size", this.f20839i);
            return jSONObject;
        }
        return (JSONObject) invokeV.objValue;
    }
}
