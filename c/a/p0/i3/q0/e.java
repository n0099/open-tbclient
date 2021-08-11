package c.a.p0.i3.q0;

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
    public long f20176a;

    /* renamed from: b  reason: collision with root package name */
    public long f20177b;

    /* renamed from: c  reason: collision with root package name */
    public int f20178c;

    /* renamed from: d  reason: collision with root package name */
    public String f20179d;

    /* renamed from: e  reason: collision with root package name */
    public String f20180e;

    /* renamed from: f  reason: collision with root package name */
    public int f20181f;

    /* renamed from: g  reason: collision with root package name */
    public String f20182g;

    /* renamed from: h  reason: collision with root package name */
    public String f20183h;

    /* renamed from: i  reason: collision with root package name */
    public long f20184i;

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
        this.f20176a = System.currentTimeMillis();
        this.f20180e = videoInfo.getVideoPath();
        this.f20181f = videoInfo.getVideoDuration();
    }

    public JSONObject a() throws JSONException {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("startTime", this.f20176a);
            jSONObject.put("endTime", this.f20177b);
            jSONObject.put("errorCode", this.f20178c);
            jSONObject.put("errorMessage", this.f20179d);
            jSONObject.put(PackageTable.MD5, this.f20182g);
            jSONObject.put("url", this.f20183h);
            jSONObject.put("path", this.f20180e);
            jSONObject.put("duration", this.f20181f);
            jSONObject.put("size", this.f20184i);
            return jSONObject;
        }
        return (JSONObject) invokeV.objValue;
    }
}
