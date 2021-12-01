package c.a.r0.d1.h2.d;

import c.a.d.m.e.n;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONObject;
/* loaded from: classes5.dex */
public class c {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public int a;

    /* renamed from: b  reason: collision with root package name */
    public boolean f15550b;

    /* renamed from: c  reason: collision with root package name */
    public b f15551c;

    /* renamed from: d  reason: collision with root package name */
    public List<n> f15552d;

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
        this.a = jSONObject.optInt("current_pn");
        this.f15550b = jSONObject.optInt("has_more", 0) == 1;
        JSONObject optJSONObject = jSONObject.optJSONObject("main_comment");
        if (optJSONObject != null) {
            this.f15551c = new b(optJSONObject);
        }
        JSONArray optJSONArray = jSONObject.optJSONArray("sub_comment");
        if (optJSONArray == null || (length = optJSONArray.length()) <= 0) {
            return;
        }
        this.f15552d = new ArrayList(length);
        for (int i4 = 0; i4 < length; i4++) {
            this.f15552d.add(new d(optJSONArray.optJSONObject(i4)));
        }
    }
}
