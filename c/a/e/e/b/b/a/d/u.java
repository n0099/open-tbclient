package c.a.e.e.b.b.a.d;

import android.util.SparseArray;
import com.baidu.adp.lib.OrmObject.toolsystem.orm.object.OrmObject;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.io.IOException;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.Set;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes.dex */
public class u implements h {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public String f2176a;

    public u(String str) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {str};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f2176a = str;
    }

    @Override // c.a.e.e.b.b.a.d.h
    public Object a(c.a.e.e.b.b.a.e.c cVar) {
        Class<?> a2;
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, cVar)) == null) {
            try {
                a2 = cVar.a();
            } catch (NumberFormatException e2) {
                e2.printStackTrace();
                return null;
            }
            if (a2 != Byte.class && a2 != Byte.TYPE) {
                if (a2 != Short.class && a2 != Short.TYPE) {
                    if (a2 != Integer.class && a2 != Integer.TYPE) {
                        if (a2 != Long.class && a2 != Long.TYPE) {
                            if (a2 != Float.class && a2 != Float.TYPE) {
                                if (a2 != Double.class && a2 != Double.TYPE) {
                                    if (a2 != Character.class && a2 != Character.TYPE) {
                                        if (a2 != Boolean.class && a2 != Boolean.TYPE) {
                                            if (a2 == String.class) {
                                                return this.f2176a;
                                            }
                                            if (a2 == char[].class) {
                                                return this.f2176a.toCharArray();
                                            }
                                            if (a2 == byte[].class) {
                                                try {
                                                    return c.a.e.e.p.c.e(this.f2176a, 0);
                                                } catch (IOException e3) {
                                                    e3.printStackTrace();
                                                    return null;
                                                }
                                            } else if (c.a.e.e.b.a.a.e(a2, OrmObject.class)) {
                                                return OrmObject.objectWithJsonStr(this.f2176a, a2);
                                            } else {
                                                if (c.a.e.e.b.a.a.e(a2, List.class)) {
                                                    try {
                                                        return new j(new JSONArray(this.f2176a)).a(cVar);
                                                    } catch (JSONException e4) {
                                                        e4.printStackTrace();
                                                        return null;
                                                    }
                                                } else if (a2.isArray()) {
                                                    try {
                                                        return new j(new JSONArray(this.f2176a)).a(cVar);
                                                    } catch (JSONException e5) {
                                                        e5.printStackTrace();
                                                        return null;
                                                    }
                                                } else if (c.a.e.e.b.a.a.e(a2, Queue.class)) {
                                                    try {
                                                        return new j(new JSONArray(this.f2176a)).a(cVar);
                                                    } catch (JSONException e6) {
                                                        e6.printStackTrace();
                                                        return null;
                                                    }
                                                } else if (c.a.e.e.b.a.a.e(a2, Set.class)) {
                                                    try {
                                                        return new j(new JSONArray(this.f2176a)).a(cVar);
                                                    } catch (JSONException e7) {
                                                        e7.printStackTrace();
                                                        return null;
                                                    }
                                                } else if (c.a.e.e.b.a.a.e(a2, Map.class)) {
                                                    try {
                                                        return new k(new JSONObject(this.f2176a)).a(cVar);
                                                    } catch (JSONException e8) {
                                                        e8.printStackTrace();
                                                        return null;
                                                    }
                                                } else if (c.a.e.e.b.a.a.e(a2, SparseArray.class)) {
                                                    try {
                                                        return new k(new JSONObject(this.f2176a)).a(cVar);
                                                    } catch (JSONException e9) {
                                                        e9.printStackTrace();
                                                        return null;
                                                    }
                                                } else {
                                                    return null;
                                                }
                                            }
                                            e2.printStackTrace();
                                            return null;
                                        }
                                        return Boolean.valueOf(Boolean.parseBoolean(this.f2176a));
                                    }
                                    return Character.valueOf(this.f2176a.charAt(0));
                                }
                                return Double.valueOf(Double.parseDouble(this.f2176a));
                            }
                            return Float.valueOf(Float.parseFloat(this.f2176a));
                        }
                        return Long.valueOf(Long.parseLong(this.f2176a));
                    }
                    return Integer.valueOf(Integer.parseInt(this.f2176a));
                }
                return Short.valueOf(Short.parseShort(this.f2176a));
            }
            return Byte.valueOf(Byte.parseByte(this.f2176a));
        }
        return invokeL.objValue;
    }
}
