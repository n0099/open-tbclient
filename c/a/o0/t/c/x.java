package c.a.o0.t.c;

import android.text.TextUtils;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;
/* loaded from: classes3.dex */
public class x {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public List<y> f14454a;

    public x() {
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
            this.f14454a = new ArrayList();
            try {
                if (jSONArray == null) {
                    c.a.o0.s.d0.b.j().x("key_index_tab_info_list", "[]");
                    return;
                }
                JSONArray jSONArray2 = new JSONArray(c.a.o0.s.d0.b.j().p("key_index_tab_info_list", "[]"));
                for (int i2 = 0; i2 < jSONArray.length(); i2++) {
                    y yVar = new y();
                    y yVar2 = new y();
                    yVar.b(jSONArray.getJSONObject(i2));
                    for (int i3 = 0; i3 < jSONArray2.length(); i3++) {
                        yVar2.b(jSONArray2.getJSONObject(i3));
                        if (yVar.f14457c != null && yVar.f14457c.equals(yVar2.f14457c)) {
                            if (!TextUtils.isEmpty(yVar2.f14459e) && yVar2.f14459e.equals(yVar.f14459e)) {
                                z = false;
                                yVar.f14460f = z;
                            }
                            z = true;
                            yVar.f14460f = z;
                        }
                    }
                    if (!yVar.a()) {
                        this.f14454a.add(yVar);
                    }
                }
                c.a.o0.s.d0.b.j().x("key_index_tab_info_list", jSONArray.toString());
            } catch (Exception e2) {
                e2.printStackTrace();
            }
        }
    }
}
