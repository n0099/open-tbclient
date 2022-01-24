package c.a.s0.s.q;

import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import org.json.JSONObject;
import tbclient.VideoChannelInfo;
/* loaded from: classes6.dex */
public class l2 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public long a;

    /* renamed from: b  reason: collision with root package name */
    public String f13641b;

    public l2() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
            }
        }
    }

    public void a(JSONObject jSONObject) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048576, this, jSONObject) == null) || jSONObject == null) {
            return;
        }
        try {
            this.a = jSONObject.optLong("channel_id", 0L);
            this.f13641b = jSONObject.optString("channel_name");
            jSONObject.optString("channel_avatar");
        } catch (Exception unused) {
        }
    }

    public void b(VideoChannelInfo videoChannelInfo) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, videoChannelInfo) == null) || videoChannelInfo == null || videoChannelInfo.channel_id.longValue() <= 0) {
            return;
        }
        this.a = videoChannelInfo.channel_id.longValue();
        this.f13641b = videoChannelInfo.channel_name;
        String str = videoChannelInfo.channel_avatar;
    }
}
