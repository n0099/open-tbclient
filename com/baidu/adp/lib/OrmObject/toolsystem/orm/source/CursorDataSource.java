package com.baidu.adp.lib.OrmObject.toolsystem.orm.source;

import android.content.ContentValues;
import android.database.Cursor;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tieba.be;
import com.baidu.tieba.re;
import com.baidu.tieba.td;
import com.baidu.tieba.ve;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.lang.reflect.Type;
import java.util.Set;
import java.util.TreeSet;
/* loaded from: classes.dex */
public class CursorDataSource implements td {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public Cursor jo;
    public final Set<String> keySet;
    public final ContentValues values;

    public CursorDataSource(ContentValues contentValues) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {contentValues};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.values = contentValues;
        this.keySet = new TreeSet();
    }

    public CursorDataSource(Cursor cursor) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {cursor};
            interceptable.invokeUnInit(65537, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.jo = cursor;
        this.values = null;
        this.keySet = new TreeSet();
        if (cursor != null) {
            int columnCount = cursor.getColumnCount();
            for (int i3 = 0; i3 < columnCount; i3++) {
                String columnName = cursor.getColumnName(i3);
                if (columnName != null) {
                    this.keySet.add(columnName);
                }
            }
        }
    }

    @Override // com.baidu.tieba.td
    public Set<String> getKeys() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            return this.keySet;
        }
        return (Set) invokeV.objValue;
    }

    public Object getObject(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str)) == null) {
            int columnIndex = this.jo.getColumnIndex(str);
            Object obj = null;
            if (columnIndex <= 0 || columnIndex >= this.jo.getColumnCount()) {
                return null;
            }
            try {
                obj = Short.valueOf(this.jo.getShort(columnIndex));
            } catch (Exception e) {
                e.printStackTrace();
            }
            if (obj == null) {
                try {
                    obj = Integer.valueOf(this.jo.getInt(columnIndex));
                } catch (Exception e2) {
                    e2.printStackTrace();
                }
            }
            if (obj == null) {
                try {
                    obj = Long.valueOf(this.jo.getLong(columnIndex));
                } catch (Exception e3) {
                    e3.printStackTrace();
                }
            }
            if (obj == null) {
                try {
                    obj = Float.valueOf(this.jo.getFloat(columnIndex));
                } catch (Exception e4) {
                    e4.printStackTrace();
                }
            }
            if (obj == null) {
                try {
                    obj = Double.valueOf(this.jo.getDouble(columnIndex));
                } catch (Exception e5) {
                    e5.printStackTrace();
                }
            }
            if (obj == null) {
                try {
                    obj = this.jo.getString(columnIndex);
                } catch (Exception e6) {
                    e6.printStackTrace();
                }
            }
            if (obj == null) {
                try {
                    return this.jo.getBlob(columnIndex);
                } catch (Exception e7) {
                    e7.printStackTrace();
                    return obj;
                }
            }
            return obj;
        }
        return invokeL.objValue;
    }

    @Override // com.baidu.tieba.td
    public Object getObjectByType(String str, Type type) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(Constants.METHOD_SEND_USER_MSG, this, str, type)) == null) {
            Object object = getObject(str);
            if (object != null) {
                re reVar = new re(type);
                be a = ve.a(object);
                if (a != null) {
                    return a.a(reVar);
                }
                return object;
            }
            return object;
        }
        return invokeLL.objValue;
    }

    @Override // com.baidu.tieba.td
    public void set(String str, Object obj) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLL(1048579, this, str, obj) == null) && str != null) {
            if (obj == null) {
                this.values.putNull(str);
            } else if (obj.getClass() != Boolean.TYPE && obj.getClass() != Boolean.class) {
                if (obj.getClass() != Byte.TYPE && obj.getClass() != Byte.class) {
                    if (obj.getClass() == byte[].class) {
                        this.values.put(str, (byte[]) obj);
                        return;
                    } else if (obj.getClass() != Double.TYPE && obj.getClass() != Double.class) {
                        if (obj.getClass() != Float.TYPE && obj.getClass() != Float.class) {
                            if (obj.getClass() != Integer.TYPE && obj.getClass() != Integer.class) {
                                if (obj.getClass() != Long.TYPE && obj.getClass() != Long.class) {
                                    if (obj.getClass() != Short.TYPE && obj.getClass() != Short.class) {
                                        if (obj.getClass() == String.class) {
                                            this.values.put(str, (String) obj);
                                            return;
                                        }
                                        return;
                                    }
                                    this.values.put(str, (Short) obj);
                                    return;
                                }
                                this.values.put(str, (Long) obj);
                                return;
                            }
                            this.values.put(str, (Integer) obj);
                            return;
                        }
                        this.values.put(str, (Float) obj);
                        return;
                    } else {
                        this.values.put(str, (Double) obj);
                        return;
                    }
                }
                this.values.put(str, (Byte) obj);
            } else {
                this.values.put(str, (Boolean) obj);
            }
        }
    }
}
