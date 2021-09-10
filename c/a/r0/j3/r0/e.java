package c.a.r0.j3.r0;

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
    public long f21074a;

    /* renamed from: b  reason: collision with root package name */
    public long f21075b;

    /* renamed from: c  reason: collision with root package name */
    public int f21076c;

    /* renamed from: d  reason: collision with root package name */
    public String f21077d;

    /* renamed from: e  reason: collision with root package name */
    public String f21078e;

    /* renamed from: f  reason: collision with root package name */
    public int f21079f;

    /* renamed from: g  reason: collision with root package name */
    public String f21080g;

    /* renamed from: h  reason: collision with root package name */
    public String f21081h;

    /* renamed from: i  reason: collision with root package name */
    public long f21082i;

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
        this.f21074a = System.currentTimeMillis();
        this.f21078e = videoInfo.getVideoPath();
        this.f21079f = videoInfo.getVideoDuration();
    }

    public JSONObject a() throws JSONException {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("startTime", this.f21074a);
            jSONObject.put("endTime", this.f21075b);
            jSONObject.put("errorCode", this.f21076c);
            jSONObject.put("errorMessage", this.f21077d);
            jSONObject.put(PackageTable.MD5, this.f21080g);
            jSONObject.put("url", this.f21081h);
            jSONObject.put("path", this.f21078e);
            jSONObject.put("duration", this.f21079f);
            jSONObject.put("size", this.f21082i);
            return jSONObject;
        }
        return (JSONObject) invokeV.objValue;
    }
}
