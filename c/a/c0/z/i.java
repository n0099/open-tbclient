package c.a.c0.z;

import android.database.Cursor;
import com.baidu.nadcore.sweetsqlite.Column;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.Interceptable;
/* loaded from: classes.dex */
public class i {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public static void a(Cursor cursor, k... kVarArr) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65536, null, cursor, kVarArr) == null) {
            int i2 = 0;
            for (k kVar : kVarArr) {
                for (Column column : kVar.b().c()) {
                    h.i(column, cursor, i2);
                    i2++;
                }
            }
        }
    }
}
