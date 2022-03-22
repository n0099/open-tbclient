package c.a.o0.s.c;

import android.text.TextUtils;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;
/* loaded from: classes2.dex */
public class y {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public List<z> a;

    public y() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
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
                    c.a.o0.r.j0.b.k().y("key_index_tab_info_list", "[]");
                    return;
                }
                JSONArray jSONArray2 = new JSONArray(c.a.o0.r.j0.b.k().q("key_index_tab_info_list", "[]"));
                for (int i = 0; i < jSONArray.length(); i++) {
                    z zVar = new z();
                    z zVar2 = new z();
                    zVar.e(jSONArray.getJSONObject(i));
                    for (int i2 = 0; i2 < jSONArray2.length(); i2++) {
                        zVar2.e(jSONArray2.getJSONObject(i2));
                        if (zVar.f11281c != null && zVar.f11281c.equals(zVar2.f11281c)) {
                            if (!TextUtils.isEmpty(zVar2.f11283e) && zVar2.f11283e.equals(zVar.f11283e)) {
                                z = false;
                                zVar.f11284f = z;
                            }
                            z = true;
                            zVar.f11284f = z;
                        }
                    }
                    if (!zVar.c()) {
                        this.a.add(zVar);
                    }
                }
                c.a.o0.r.j0.b.k().y("key_index_tab_info_list", jSONArray.toString());
            } catch (Exception e2) {
                e2.printStackTrace();
            }
        }
    }
}
