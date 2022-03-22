package c.a.d.f.b.b.a.d;

import android.util.SparseArray;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.lang.reflect.Array;
import java.lang.reflect.Type;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.Set;
import org.json.JSONArray;
/* loaded from: classes.dex */
public class j implements h {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public JSONArray a;

    public j(JSONArray jSONArray) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {jSONArray};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.a = jSONArray;
    }

    @Override // c.a.d.f.b.b.a.d.h
    public Object a(c.a.d.f.b.b.a.e.c cVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, cVar)) == null) {
            Class<?> a = cVar.a();
            Type[] b2 = cVar.b();
            if (a.isArray()) {
                Class<?> componentType = a.getComponentType();
                Object newInstance = Array.newInstance(componentType, this.a.length());
                int length = this.a.length();
                for (int i = 0; i < length; i++) {
                    Object a2 = c.a.d.f.b.b.a.e.g.a(this.a.opt(i)).a(new c.a.d.f.b.b.a.e.c(componentType));
                    if (a2 != null) {
                        Array.set(newInstance, i, a2);
                    }
                }
                return newInstance;
            } else if (b2 == null || b2.length < 1) {
                return null;
            } else {
                if (c.a.d.f.b.a.a.e(a, List.class)) {
                    List<Object> a3 = c.a.d.f.b.b.a.e.a.a(cVar, this.a.length());
                    if (a3 != null) {
                        int length2 = this.a.length();
                        for (int i2 = 0; i2 < length2; i2++) {
                            Object a4 = c.a.d.f.b.b.a.e.g.a(this.a.opt(i2)).a(new c.a.d.f.b.b.a.e.c(b2[0]));
                            if (a4 != null) {
                                a3.add(a4);
                            }
                        }
                    }
                    return a3;
                } else if (c.a.d.f.b.a.a.e(a, Set.class)) {
                    Set<Object> d2 = c.a.d.f.b.b.a.e.a.d(cVar, this.a.length());
                    if (d2 != null) {
                        int length3 = this.a.length();
                        for (int i3 = 0; i3 < length3; i3++) {
                            Object a5 = c.a.d.f.b.b.a.e.g.a(this.a.opt(i3)).a(new c.a.d.f.b.b.a.e.c(b2[0]));
                            if (a5 != null) {
                                d2.add(a5);
                            }
                        }
                    }
                    return d2;
                } else if (c.a.d.f.b.a.a.e(a, Map.class)) {
                    Map<String, Object> b3 = c.a.d.f.b.b.a.e.a.b(cVar, this.a.length());
                    if (b3 != null) {
                        int length4 = this.a.length();
                        for (int i4 = 0; i4 < length4; i4++) {
                            Object a6 = c.a.d.f.b.b.a.e.g.a(this.a.opt(i4)).a(new c.a.d.f.b.b.a.e.c(b2[0]));
                            if (a6 != null) {
                                b3.put(String.valueOf(i4), a6);
                            }
                        }
                    }
                    return b3;
                } else if (c.a.d.f.b.a.a.e(a, Queue.class)) {
                    Queue<Object> c2 = c.a.d.f.b.b.a.e.a.c(cVar, this.a.length());
                    if (c2 != null) {
                        int length5 = this.a.length();
                        for (int i5 = 0; i5 < length5; i5++) {
                            Object a7 = c.a.d.f.b.b.a.e.g.a(this.a.opt(i5)).a(new c.a.d.f.b.b.a.e.c(b2[0]));
                            if (a7 != null) {
                                c2.add(a7);
                            }
                        }
                    }
                    return c2;
                } else if (a == SparseArray.class) {
                    SparseArray sparseArray = new SparseArray(this.a.length());
                    int length6 = this.a.length();
                    for (int i6 = 0; i6 < length6; i6++) {
                        Object a8 = c.a.d.f.b.b.a.e.g.a(this.a.opt(i6)).a(new c.a.d.f.b.b.a.e.c(b2[0]));
                        if (a8 != null) {
                            sparseArray.put(i6, a8);
                        }
                    }
                    return sparseArray;
                } else {
                    return null;
                }
            }
        }
        return invokeL.objValue;
    }
}
