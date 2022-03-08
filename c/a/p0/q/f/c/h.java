package c.a.p0.q.f.c;

import android.content.ContentValues;
import android.database.Cursor;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes2.dex */
public class h extends b<c.a.p0.q.h.i> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public h() {
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

    @Override // c.a.p0.q.f.c.b
    public List<c.a.p0.q.h.i> e(Cursor cursor) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, cursor)) == null) {
            ArrayList arrayList = new ArrayList();
            if (cursor == null || cursor.getCount() <= 0 || !cursor.moveToFirst()) {
                return arrayList;
            }
            do {
                arrayList.add(h(cursor));
            } while (cursor.moveToNext());
            return arrayList;
        }
        return (List) invokeL.objValue;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // c.a.p0.q.f.c.b
    /* renamed from: f */
    public ContentValues c(c.a.p0.q.h.i iVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048579, this, iVar)) == null) {
            ContentValues a = super.a(iVar);
            a.put("max_age", Long.valueOf(iVar.o));
            a.put("token", iVar.p);
            a.put("domains", iVar.q);
            a.put("app_key", iVar.r);
            a.put("app_name", iVar.s);
            return a;
        }
        return (ContentValues) invokeL.objValue;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // c.a.p0.q.f.c.b
    /* renamed from: g */
    public c.a.p0.q.h.i d(Cursor cursor) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048580, this, cursor)) == null) {
            if (cursor == null || cursor.getCount() <= 0 || !cursor.moveToFirst()) {
                return null;
            }
            return h(cursor);
        }
        return (c.a.p0.q.h.i) invokeL.objValue;
    }

    public final c.a.p0.q.h.i h(Cursor cursor) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048581, this, cursor)) == null) {
            if (cursor != null) {
                int columnIndex = cursor.getColumnIndex("max_age");
                int columnIndex2 = cursor.getColumnIndex("token");
                int columnIndex3 = cursor.getColumnIndex("domains");
                int columnIndex4 = cursor.getColumnIndex("app_key");
                int columnIndex5 = cursor.getColumnIndex("app_name");
                c.a.p0.q.h.i iVar = new c.a.p0.q.h.i();
                if (b(cursor, iVar)) {
                    iVar.o = cursor.getLong(columnIndex);
                    iVar.p = cursor.getString(columnIndex2);
                    iVar.q = cursor.getString(columnIndex3);
                    iVar.r = cursor.getString(columnIndex4);
                    iVar.s = cursor.getString(columnIndex5);
                    return iVar;
                }
                return null;
            }
            return null;
        }
        return (c.a.p0.q.h.i) invokeL.objValue;
    }
}
