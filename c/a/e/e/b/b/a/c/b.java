package c.a.e.e.b.b.a.c;

import android.content.ContentValues;
import android.database.Cursor;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.lang.reflect.Type;
import java.util.Set;
import java.util.TreeSet;
/* loaded from: classes.dex */
public class b implements c {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public Cursor f2091a;

    /* renamed from: b  reason: collision with root package name */
    public final ContentValues f2092b;

    /* renamed from: c  reason: collision with root package name */
    public final Set<String> f2093c;

    public b(Cursor cursor) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {cursor};
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.f2091a = cursor;
        this.f2092b = null;
        this.f2093c = new TreeSet();
        if (cursor != null) {
            int columnCount = cursor.getColumnCount();
            for (int i4 = 0; i4 < columnCount; i4++) {
                String columnName = cursor.getColumnName(i4);
                if (columnName != null) {
                    this.f2093c.add(columnName);
                }
            }
        }
    }

    @Override // c.a.e.e.b.b.a.c.c
    public Set<String> a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.f2093c : (Set) invokeV.objValue;
    }

    @Override // c.a.e.e.b.b.a.c.c
    public void b(String str, Object obj) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str, obj) == null) || str == null) {
            return;
        }
        if (obj == null) {
            this.f2092b.putNull(str);
        } else if (obj.getClass() != Boolean.TYPE && obj.getClass() != Boolean.class) {
            if (obj.getClass() != Byte.TYPE && obj.getClass() != Byte.class) {
                if (obj.getClass() == byte[].class) {
                    this.f2092b.put(str, (byte[]) obj);
                    return;
                } else if (obj.getClass() != Double.TYPE && obj.getClass() != Double.class) {
                    if (obj.getClass() != Float.TYPE && obj.getClass() != Float.class) {
                        if (obj.getClass() != Integer.TYPE && obj.getClass() != Integer.class) {
                            if (obj.getClass() != Long.TYPE && obj.getClass() != Long.class) {
                                if (obj.getClass() != Short.TYPE && obj.getClass() != Short.class) {
                                    if (obj.getClass() == String.class) {
                                        this.f2092b.put(str, (String) obj);
                                        return;
                                    }
                                    return;
                                }
                                this.f2092b.put(str, (Short) obj);
                                return;
                            }
                            this.f2092b.put(str, (Long) obj);
                            return;
                        }
                        this.f2092b.put(str, (Integer) obj);
                        return;
                    }
                    this.f2092b.put(str, (Float) obj);
                    return;
                } else {
                    this.f2092b.put(str, (Double) obj);
                    return;
                }
            }
            this.f2092b.put(str, (Byte) obj);
        } else {
            this.f2092b.put(str, (Boolean) obj);
        }
    }

    @Override // c.a.e.e.b.b.a.c.c
    public Object c(String str, Type type) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(Constants.METHOD_SEND_USER_MSG, this, str, type)) == null) {
            Object d2 = d(str);
            if (d2 != null) {
                c.a.e.e.b.b.a.e.c cVar = new c.a.e.e.b.b.a.e.c(type);
                c.a.e.e.b.b.a.d.h a2 = c.a.e.e.b.b.a.e.g.a(d2);
                return a2 != null ? a2.a(cVar) : d2;
            }
            return d2;
        }
        return invokeLL.objValue;
    }

    public Object d(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048579, this, str)) == null) {
            int columnIndex = this.f2091a.getColumnIndex(str);
            Object obj = null;
            if (columnIndex <= 0 || columnIndex >= this.f2091a.getColumnCount()) {
                return null;
            }
            try {
                obj = Short.valueOf(this.f2091a.getShort(columnIndex));
            } catch (Exception e2) {
                e2.printStackTrace();
            }
            if (obj == null) {
                try {
                    obj = Integer.valueOf(this.f2091a.getInt(columnIndex));
                } catch (Exception e3) {
                    e3.printStackTrace();
                }
            }
            if (obj == null) {
                try {
                    obj = Long.valueOf(this.f2091a.getLong(columnIndex));
                } catch (Exception e4) {
                    e4.printStackTrace();
                }
            }
            if (obj == null) {
                try {
                    obj = Float.valueOf(this.f2091a.getFloat(columnIndex));
                } catch (Exception e5) {
                    e5.printStackTrace();
                }
            }
            if (obj == null) {
                try {
                    obj = Double.valueOf(this.f2091a.getDouble(columnIndex));
                } catch (Exception e6) {
                    e6.printStackTrace();
                }
            }
            if (obj == null) {
                try {
                    obj = this.f2091a.getString(columnIndex);
                } catch (Exception e7) {
                    e7.printStackTrace();
                }
            }
            if (obj == null) {
                try {
                    return this.f2091a.getBlob(columnIndex);
                } catch (Exception e8) {
                    e8.printStackTrace();
                    return obj;
                }
            }
            return obj;
        }
        return invokeL.objValue;
    }

    public b(ContentValues contentValues) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {contentValues};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f2092b = contentValues;
        this.f2093c = new TreeSet();
    }
}
