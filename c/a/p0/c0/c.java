package c.a.p0.c0;

import com.baidu.tbadk.core.atomData.EmotionDetailActivityConfig;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import org.json.JSONObject;
/* loaded from: classes3.dex */
public class c {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public String f12974a;

    /* renamed from: b  reason: collision with root package name */
    public int f12975b;

    /* renamed from: c  reason: collision with root package name */
    public int f12976c;

    /* renamed from: d  reason: collision with root package name */
    public String f12977d;

    /* renamed from: e  reason: collision with root package name */
    public String f12978e;

    /* renamed from: f  reason: collision with root package name */
    public String f12979f;

    /* renamed from: g  reason: collision with root package name */
    public String f12980g;

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

    public static c a(JSONObject jSONObject) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65537, null, jSONObject)) == null) {
            try {
                c cVar = new c();
                cVar.f12974a = jSONObject.optString(EmotionDetailActivityConfig.EMOTION_PIC_ID_KEY);
                cVar.f12975b = jSONObject.optInt("width");
                cVar.f12976c = jSONObject.optInt("height");
                cVar.f12977d = jSONObject.optString("pic_url");
                cVar.f12978e = jSONObject.optString("thumbnail");
                cVar.f12980g = jSONObject.optString("origin_url");
                return cVar;
            } catch (Exception unused) {
                return null;
            }
        }
        return (c) invokeL.objValue;
    }
}
