package c.a.s0.t.c;

import android.text.TextUtils;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;
/* loaded from: classes6.dex */
public class z {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public List<a0> a;

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
            this.a = new ArrayList();
            try {
                if (jSONArray == null) {
                    c.a.s0.s.h0.b.k().y("key_index_tab_info_list", "[]");
                    return;
                }
                JSONArray jSONArray2 = new JSONArray(c.a.s0.s.h0.b.k().q("key_index_tab_info_list", "[]"));
                for (int i2 = 0; i2 < jSONArray.length(); i2++) {
                    a0 a0Var = new a0();
                    a0 a0Var2 = new a0();
                    a0Var.e(jSONArray.getJSONObject(i2));
                    for (int i3 = 0; i3 < jSONArray2.length(); i3++) {
                        a0Var2.e(jSONArray2.getJSONObject(i3));
                        if (a0Var.f13788c != null && a0Var.f13788c.equals(a0Var2.f13788c)) {
                            if (!TextUtils.isEmpty(a0Var2.f13790e) && a0Var2.f13790e.equals(a0Var.f13790e)) {
                                z = false;
                                a0Var.f13791f = z;
                            }
                            z = true;
                            a0Var.f13791f = z;
                        }
                    }
                    if (!a0Var.c()) {
                        this.a.add(a0Var);
                    }
                }
                c.a.s0.s.h0.b.k().y("key_index_tab_info_list", jSONArray.toString());
            } catch (Exception e2) {
                e2.printStackTrace();
            }
        }
    }
}
