package b.a.p0.q.g.c;

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
/* loaded from: classes4.dex */
public class h extends b<b.a.p0.q.i.i> {
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

    @Override // b.a.p0.q.g.c.b
    public List<b.a.p0.q.i.i> e(Cursor cursor) {
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
    @Override // b.a.p0.q.g.c.b
    /* renamed from: f */
    public ContentValues c(b.a.p0.q.i.i iVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048579, this, iVar)) == null) {
            ContentValues a2 = super.a(iVar);
            a2.put("max_age", Long.valueOf(iVar.o));
            a2.put("token", iVar.p);
            a2.put("domains", iVar.q);
            a2.put("app_key", iVar.r);
            a2.put("app_name", iVar.s);
            return a2;
        }
        return (ContentValues) invokeL.objValue;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // b.a.p0.q.g.c.b
    /* renamed from: g */
    public b.a.p0.q.i.i d(Cursor cursor) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048580, this, cursor)) == null) {
            if (cursor == null || cursor.getCount() <= 0 || !cursor.moveToFirst()) {
                return null;
            }
            return h(cursor);
        }
        return (b.a.p0.q.i.i) invokeL.objValue;
    }

    public final b.a.p0.q.i.i h(Cursor cursor) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048581, this, cursor)) == null) {
            if (cursor != null) {
                int columnIndex = cursor.getColumnIndex("max_age");
                int columnIndex2 = cursor.getColumnIndex("token");
                int columnIndex3 = cursor.getColumnIndex("domains");
                int columnIndex4 = cursor.getColumnIndex("app_key");
                int columnIndex5 = cursor.getColumnIndex("app_name");
                b.a.p0.q.i.i iVar = new b.a.p0.q.i.i();
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
        return (b.a.p0.q.i.i) invokeL.objValue;
    }
}
