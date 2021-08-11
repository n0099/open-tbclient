package c.a.n0.n.g.c;

import android.content.ContentValues;
import android.database.Cursor;
import androidx.annotation.NonNull;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.swan.pms.utils.AbiType;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes3.dex */
public class i extends b<c.a.n0.n.h.i> implements Object {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public i() {
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

    public static int f(@NonNull Cursor cursor, @NonNull String str) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLL = interceptable.invokeLL(65537, null, cursor, str)) == null) ? cursor.getColumnIndex(str) : invokeLL.intValue;
    }

    @Override // c.a.n0.n.g.c.b
    public List<c.a.n0.n.h.i> e(Cursor cursor) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, cursor)) == null) {
            ArrayList arrayList = new ArrayList();
            if (cursor == null || cursor.getCount() <= 0 || !cursor.moveToFirst()) {
                return arrayList;
            }
            do {
                arrayList.add(i(cursor));
            } while (cursor.moveToNext());
            return arrayList;
        }
        return (List) invokeL.objValue;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // c.a.n0.n.g.c.b
    /* renamed from: g */
    public ContentValues c(c.a.n0.n.h.i iVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048579, this, iVar)) == null) {
            ContentValues a2 = super.a(iVar);
            a2.put("max_age", Long.valueOf(iVar.o));
            a2.put("abi", iVar.q.id);
            a2.put("lib_name", iVar.p);
            return a2;
        }
        return (ContentValues) invokeL.objValue;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // c.a.n0.n.g.c.b
    /* renamed from: h */
    public c.a.n0.n.h.i d(Cursor cursor) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048580, this, cursor)) == null) {
            if (cursor == null || cursor.getCount() <= 0 || !cursor.moveToFirst()) {
                return null;
            }
            return i(cursor);
        }
        return (c.a.n0.n.h.i) invokeL.objValue;
    }

    public final c.a.n0.n.h.i i(Cursor cursor) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048581, this, cursor)) == null) {
            if (cursor != null) {
                c.a.n0.n.h.i iVar = new c.a.n0.n.h.i();
                if (b(cursor, iVar)) {
                    iVar.o = cursor.getLong(f(cursor, "max_age"));
                    iVar.q = AbiType.findById(cursor.getString(f(cursor, "abi")), null);
                    iVar.p = cursor.getString(f(cursor, "lib_name"));
                    return iVar;
                }
            }
            return null;
        }
        return (c.a.n0.n.h.i) invokeL.objValue;
    }
}
