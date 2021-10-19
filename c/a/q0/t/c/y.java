package c.a.q0.t.c;

import android.text.TextUtils;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;
/* loaded from: classes3.dex */
public class y {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public List<z> f14793a;

    public y() {
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
            this.f14793a = new ArrayList();
            try {
                if (jSONArray == null) {
                    c.a.q0.s.d0.b.j().x("key_index_tab_info_list", "[]");
                    return;
                }
                JSONArray jSONArray2 = new JSONArray(c.a.q0.s.d0.b.j().p("key_index_tab_info_list", "[]"));
                for (int i2 = 0; i2 < jSONArray.length(); i2++) {
                    z zVar = new z();
                    z zVar2 = new z();
                    zVar.b(jSONArray.getJSONObject(i2));
                    for (int i3 = 0; i3 < jSONArray2.length(); i3++) {
                        zVar2.b(jSONArray2.getJSONObject(i3));
                        if (zVar.f14796c != null && zVar.f14796c.equals(zVar2.f14796c)) {
                            if (!TextUtils.isEmpty(zVar2.f14798e) && zVar2.f14798e.equals(zVar.f14798e)) {
                                z = false;
                                zVar.f14799f = z;
                            }
                            z = true;
                            zVar.f14799f = z;
                        }
                    }
                    if (!zVar.a()) {
                        this.f14793a.add(zVar);
                    }
                }
                c.a.q0.s.d0.b.j().x("key_index_tab_info_list", jSONArray.toString());
            } catch (Exception e2) {
                e2.printStackTrace();
            }
        }
    }
}
