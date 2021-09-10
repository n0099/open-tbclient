package c.a.p0.a.i1.e;

import android.database.Cursor;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.Interceptable;
/* loaded from: classes.dex */
public final class a {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public static void a(Cursor cursor) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(65536, null, cursor) == null) || cursor == null) {
            return;
        }
        try {
            if (cursor.isClosed()) {
                return;
            }
            cursor.close();
        } catch (Exception unused) {
        }
    }
}
