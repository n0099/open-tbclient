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
    public long f21086a;

    /* renamed from: b  reason: collision with root package name */
    public long f21087b;

    /* renamed from: c  reason: collision with root package name */
    public int f21088c;

    /* renamed from: d  reason: collision with root package name */
    public String f21089d;

    /* renamed from: e  reason: collision with root package name */
    public String f21090e;

    /* renamed from: f  reason: collision with root package name */
    public int f21091f;

    /* renamed from: g  reason: collision with root package name */
    public String f21092g;

    /* renamed from: h  reason: collision with root package name */
    public String f21093h;

    /* renamed from: i  reason: collision with root package name */
    public long f21094i;

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
        this.f21086a = System.currentTimeMillis();
        this.f21090e = videoInfo.getVideoPath();
        this.f21091f = videoInfo.getVideoDuration();
    }

    public JSONObject a() throws JSONException {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("startTime", this.f21086a);
            jSONObject.put("endTime", this.f21087b);
            jSONObject.put("errorCode", this.f21088c);
            jSONObject.put("errorMessage", this.f21089d);
            jSONObject.put(PackageTable.MD5, this.f21092g);
            jSONObject.put("url", this.f21093h);
            jSONObject.put("path", this.f21090e);
            jSONObject.put("duration", this.f21091f);
            jSONObject.put("size", this.f21094i);
            return jSONObject;
        }
        return (JSONObject) invokeV.objValue;
    }
}
