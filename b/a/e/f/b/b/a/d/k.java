package b.a.e.f.b.b.a.d;

import android.util.SparseArray;
import com.baidu.adp.lib.OrmObject.toolsystem.orm.object.OrmObject;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.lang.reflect.Type;
import java.util.Iterator;
import java.util.Map;
import org.json.JSONObject;
/* loaded from: classes.dex */
public class k implements h {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public JSONObject f1653a;

    public k(JSONObject jSONObject) {
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
        this.f1653a = jSONObject;
    }

    @Override // b.a.e.f.b.b.a.d.h
    public Object a(b.a.e.f.b.b.a.e.c cVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, cVar)) == null) {
            Class<?> a2 = cVar.a();
            Type[] b2 = cVar.b();
            if (b.a.e.f.b.a.a.e(a2, Map.class)) {
                Map<String, Object> b3 = b.a.e.f.b.b.a.e.a.b(cVar, this.f1653a.length());
                if (b3 != null) {
                    Iterator<String> keys = this.f1653a.keys();
                    while (keys.hasNext()) {
                        String next = keys.next();
                        if (next instanceof String) {
                            String str = next;
                            Object a3 = b.a.e.f.b.b.a.e.g.a(this.f1653a.opt(str)).a(new b.a.e.f.b.b.a.e.c(b2[1]));
                            if (a3 != null) {
                                b3.put(str, a3);
                            }
                        }
                    }
                }
                return b3;
            } else if (a2 == SparseArray.class) {
                SparseArray sparseArray = new SparseArray(this.f1653a.length());
                Iterator<String> keys2 = this.f1653a.keys();
                while (keys2.hasNext()) {
                    String next2 = keys2.next();
                    if (next2 instanceof String) {
                        String str2 = next2;
                        try {
                            int parseInt = Integer.parseInt(str2);
                            Object a4 = b.a.e.f.b.b.a.e.g.a(this.f1653a.opt(String.valueOf(str2))).a(new b.a.e.f.b.b.a.e.c(b2[0]));
                            if (a4 != null) {
                                sparseArray.put(parseInt, a4);
                            }
                        } catch (NumberFormatException e2) {
                            e2.printStackTrace();
                        }
                    }
                }
                return sparseArray;
            } else if (b.a.e.f.b.a.a.e(a2, b.a.e.f.b.b.a.a.a.class)) {
                return OrmObject.objectWithJson(this.f1653a, a2);
            } else {
                return null;
            }
        }
        return invokeL.objValue;
    }
}
