package c.a.q0.d0;

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
    public String f12862a;

    /* renamed from: b  reason: collision with root package name */
    public int f12863b;

    /* renamed from: c  reason: collision with root package name */
    public int f12864c;

    /* renamed from: d  reason: collision with root package name */
    public String f12865d;

    /* renamed from: e  reason: collision with root package name */
    public String f12866e;

    /* renamed from: f  reason: collision with root package name */
    public String f12867f;

    /* renamed from: g  reason: collision with root package name */
    public String f12868g;

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
                cVar.f12862a = jSONObject.optString(EmotionDetailActivityConfig.EMOTION_PIC_ID_KEY);
                cVar.f12863b = jSONObject.optInt("width");
                cVar.f12864c = jSONObject.optInt("height");
                cVar.f12865d = jSONObject.optString("pic_url");
                cVar.f12866e = jSONObject.optString("thumbnail");
                cVar.f12868g = jSONObject.optString("origin_url");
                return cVar;
            } catch (Exception unused) {
                return null;
            }
        }
        return (c) invokeL.objValue;
    }
}
