package b.a.q0.t.c;

import android.text.TextUtils;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;
/* loaded from: classes4.dex */
public class z {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public List<a0> f14665a;

    public z() {
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

    public void a(JSONArray jSONArray) {
        boolean z;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, jSONArray) == null) {
            this.f14665a = new ArrayList();
            try {
                if (jSONArray == null) {
                    b.a.q0.s.e0.b.j().x("key_index_tab_info_list", "[]");
                    return;
                }
                JSONArray jSONArray2 = new JSONArray(b.a.q0.s.e0.b.j().p("key_index_tab_info_list", "[]"));
                for (int i2 = 0; i2 < jSONArray.length(); i2++) {
                    a0 a0Var = new a0();
                    a0 a0Var2 = new a0();
                    a0Var.e(jSONArray.getJSONObject(i2));
                    for (int i3 = 0; i3 < jSONArray2.length(); i3++) {
                        a0Var2.e(jSONArray2.getJSONObject(i3));
                        if (a0Var.f14502c != null && a0Var.f14502c.equals(a0Var2.f14502c)) {
                            if (!TextUtils.isEmpty(a0Var2.f14504e) && a0Var2.f14504e.equals(a0Var.f14504e)) {
                                z = false;
                                a0Var.f14505f = z;
                            }
                            z = true;
                            a0Var.f14505f = z;
                        }
                    }
                    if (!a0Var.c()) {
                        this.f14665a.add(a0Var);
                    }
                }
                b.a.q0.s.e0.b.j().x("key_index_tab_info_list", jSONArray.toString());
            } catch (Exception e2) {
                e2.printStackTrace();
            }
        }
    }
}
