package b.a.r0.m3.s0;

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
    public long f22681a;

    /* renamed from: b  reason: collision with root package name */
    public long f22682b;

    /* renamed from: c  reason: collision with root package name */
    public int f22683c;

    /* renamed from: d  reason: collision with root package name */
    public String f22684d;

    /* renamed from: e  reason: collision with root package name */
    public String f22685e;

    /* renamed from: f  reason: collision with root package name */
    public int f22686f;

    /* renamed from: g  reason: collision with root package name */
    public String f22687g;

    /* renamed from: h  reason: collision with root package name */
    public String f22688h;

    /* renamed from: i  reason: collision with root package name */
    public long f22689i;

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
        this.f22681a = System.currentTimeMillis();
        this.f22685e = videoInfo.getVideoPath();
        this.f22686f = videoInfo.getVideoDuration();
    }

    public JSONObject a() throws JSONException {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("startTime", this.f22681a);
            jSONObject.put("endTime", this.f22682b);
            jSONObject.put("errorCode", this.f22683c);
            jSONObject.put("errorMessage", this.f22684d);
            jSONObject.put(PackageTable.MD5, this.f22687g);
            jSONObject.put("url", this.f22688h);
            jSONObject.put("path", this.f22685e);
            jSONObject.put("duration", this.f22686f);
            jSONObject.put("size", this.f22689i);
            return jSONObject;
        }
        return (JSONObject) invokeV.objValue;
    }
}
