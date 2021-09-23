package c.a.r0.w0.w1.d;

import c.a.e.l.e.n;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONObject;
/* loaded from: classes4.dex */
public class c {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public int f27961a;

    /* renamed from: b  reason: collision with root package name */
    public boolean f27962b;

    /* renamed from: c  reason: collision with root package name */
    public b f27963c;

    /* renamed from: d  reason: collision with root package name */
    public List<n> f27964d;

    public c(JSONObject jSONObject) {
        int length;
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {jSONObject};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        if (jSONObject == null) {
            return;
        }
        this.f27961a = jSONObject.optInt("current_pn");
        this.f27962b = jSONObject.optInt("has_more", 0) == 1;
        JSONObject optJSONObject = jSONObject.optJSONObject("main_comment");
        if (optJSONObject != null) {
            this.f27963c = new b(optJSONObject);
        }
        JSONArray optJSONArray = jSONObject.optJSONArray("sub_comment");
        if (optJSONArray == null || (length = optJSONArray.length()) <= 0) {
            return;
        }
        this.f27964d = new ArrayList(length);
        for (int i4 = 0; i4 < length; i4++) {
            this.f27964d.add(new d(optJSONArray.optJSONObject(i4)));
        }
    }
}
