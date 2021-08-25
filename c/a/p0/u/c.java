package c.a.p0.u;

import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import org.json.JSONObject;
import tbclient.TailInfo;
/* loaded from: classes3.dex */
public class c {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public c() {
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
        if (interceptable == null || interceptable.invokeL(1048576, this, jSONObject) == null) {
            try {
                jSONObject.optString("icon_url");
                jSONObject.optString("icon_link");
                jSONObject.optString("content");
                jSONObject.optInt("tail_type");
            } catch (Exception e2) {
                e2.printStackTrace();
            }
        }
    }

    public void b(TailInfo tailInfo) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, tailInfo) == null) {
            try {
                String str = tailInfo.icon_url;
                String str2 = tailInfo.icon_link;
                String str3 = tailInfo.content;
                tailInfo.tail_type.intValue();
            } catch (Exception e2) {
                e2.printStackTrace();
            }
        }
    }
}
