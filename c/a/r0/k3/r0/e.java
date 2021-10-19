package c.a.r0.k3.r0;

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
    public long f21265a;

    /* renamed from: b  reason: collision with root package name */
    public long f21266b;

    /* renamed from: c  reason: collision with root package name */
    public int f21267c;

    /* renamed from: d  reason: collision with root package name */
    public String f21268d;

    /* renamed from: e  reason: collision with root package name */
    public String f21269e;

    /* renamed from: f  reason: collision with root package name */
    public int f21270f;

    /* renamed from: g  reason: collision with root package name */
    public String f21271g;

    /* renamed from: h  reason: collision with root package name */
    public String f21272h;

    /* renamed from: i  reason: collision with root package name */
    public long f21273i;

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
        this.f21265a = System.currentTimeMillis();
        this.f21269e = videoInfo.getVideoPath();
        this.f21270f = videoInfo.getVideoDuration();
    }

    public JSONObject a() throws JSONException {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("startTime", this.f21265a);
            jSONObject.put("endTime", this.f21266b);
            jSONObject.put("errorCode", this.f21267c);
            jSONObject.put("errorMessage", this.f21268d);
            jSONObject.put(PackageTable.MD5, this.f21271g);
            jSONObject.put("url", this.f21272h);
            jSONObject.put("path", this.f21269e);
            jSONObject.put("duration", this.f21270f);
            jSONObject.put("size", this.f21273i);
            return jSONObject;
        }
        return (JSONObject) invokeV.objValue;
    }
}
