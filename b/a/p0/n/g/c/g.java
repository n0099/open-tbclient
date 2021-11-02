package b.a.p0.n.g.c;

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
public class g extends b<b.a.p0.n.h.g> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public g() {
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

    @Override // b.a.p0.n.g.c.b
    public List<b.a.p0.n.h.g> e(Cursor cursor) {
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
    @Override // b.a.p0.n.g.c.b
    /* renamed from: f */
    public ContentValues c(b.a.p0.n.h.g gVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048579, this, gVar)) == null) {
            ContentValues a2 = super.a(gVar);
            a2.put("independent", Integer.valueOf(gVar.r ? 1 : 0));
            a2.put("sub_pkg_name", gVar.p);
            a2.put("app_id", gVar.o);
            return a2;
        }
        return (ContentValues) invokeL.objValue;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // b.a.p0.n.g.c.b
    /* renamed from: g */
    public b.a.p0.n.h.g d(Cursor cursor) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048580, this, cursor)) == null) {
            if (cursor == null || cursor.getCount() <= 0 || !cursor.moveToFirst()) {
                return null;
            }
            return h(cursor);
        }
        return (b.a.p0.n.h.g) invokeL.objValue;
    }

    public final b.a.p0.n.h.g h(Cursor cursor) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048581, this, cursor)) == null) {
            if (cursor != null) {
                int columnIndex = cursor.getColumnIndex("independent");
                int columnIndex2 = cursor.getColumnIndex("sub_pkg_name");
                int columnIndex3 = cursor.getColumnIndex("app_id");
                b.a.p0.n.h.g gVar = new b.a.p0.n.h.g();
                if (b(cursor, gVar)) {
                    gVar.r = cursor.getInt(columnIndex) == 1;
                    gVar.p = cursor.getString(columnIndex2);
                    gVar.o = cursor.getString(columnIndex3);
                    return gVar;
                }
                return null;
            }
            return null;
        }
        return (b.a.p0.n.h.g) invokeL.objValue;
    }
}
