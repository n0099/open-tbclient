package c.a.d.f.b.b.a.d;

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
    public String a;

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
        this.a = str;
    }

    @Override // c.a.d.f.b.b.a.d.h
    public Object a(c.a.d.f.b.b.a.e.c cVar) {
        Class<?> a;
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, cVar)) == null) {
            try {
                a = cVar.a();
            } catch (NumberFormatException e2) {
                e2.printStackTrace();
                return null;
            }
            if (a != Byte.class && a != Byte.TYPE) {
                if (a != Short.class && a != Short.TYPE) {
                    if (a != Integer.class && a != Integer.TYPE) {
                        if (a != Long.class && a != Long.TYPE) {
                            if (a != Float.class && a != Float.TYPE) {
                                if (a != Double.class && a != Double.TYPE) {
                                    if (a != Character.class && a != Character.TYPE) {
                                        if (a != Boolean.class && a != Boolean.TYPE) {
                                            if (a == String.class) {
                                                return this.a;
                                            }
                                            if (a == char[].class) {
                                                return this.a.toCharArray();
                                            }
                                            if (a == byte[].class) {
                                                try {
                                                    return c.a.d.f.p.e.e(this.a, 0);
                                                } catch (IOException e3) {
                                                    e3.printStackTrace();
                                                    return null;
                                                }
                                            } else if (c.a.d.f.b.a.a.e(a, OrmObject.class)) {
                                                return OrmObject.objectWithJsonStr(this.a, a);
                                            } else {
                                                if (c.a.d.f.b.a.a.e(a, List.class)) {
                                                    try {
                                                        return new j(new JSONArray(this.a)).a(cVar);
                                                    } catch (JSONException e4) {
                                                        e4.printStackTrace();
                                                        return null;
                                                    }
                                                } else if (a.isArray()) {
                                                    try {
                                                        return new j(new JSONArray(this.a)).a(cVar);
                                                    } catch (JSONException e5) {
                                                        e5.printStackTrace();
                                                        return null;
                                                    }
                                                } else if (c.a.d.f.b.a.a.e(a, Queue.class)) {
                                                    try {
                                                        return new j(new JSONArray(this.a)).a(cVar);
                                                    } catch (JSONException e6) {
                                                        e6.printStackTrace();
                                                        return null;
                                                    }
                                                } else if (c.a.d.f.b.a.a.e(a, Set.class)) {
                                                    try {
                                                        return new j(new JSONArray(this.a)).a(cVar);
                                                    } catch (JSONException e7) {
                                                        e7.printStackTrace();
                                                        return null;
                                                    }
                                                } else if (c.a.d.f.b.a.a.e(a, Map.class)) {
                                                    try {
                                                        return new k(new JSONObject(this.a)).a(cVar);
                                                    } catch (JSONException e8) {
                                                        e8.printStackTrace();
                                                        return null;
                                                    }
                                                } else if (c.a.d.f.b.a.a.e(a, SparseArray.class)) {
                                                    try {
                                                        return new k(new JSONObject(this.a)).a(cVar);
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
                                        return Boolean.valueOf(Boolean.parseBoolean(this.a));
                                    }
                                    return Character.valueOf(this.a.charAt(0));
                                }
                                return Double.valueOf(Double.parseDouble(this.a));
                            }
                            return Float.valueOf(Float.parseFloat(this.a));
                        }
                        return Long.valueOf(Long.parseLong(this.a));
                    }
                    return Integer.valueOf(Integer.parseInt(this.a));
                }
                return Short.valueOf(Short.parseShort(this.a));
            }
            return Byte.valueOf(Byte.parseByte(this.a));
        }
        return invokeL.objValue;
    }
}
