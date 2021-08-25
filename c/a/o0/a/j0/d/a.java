package c.a.o0.a.j0.d;

import android.app.Application;
import android.database.sqlite.SQLiteDatabase;
import android.text.TextUtils;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.WorkerThread;
import c.a.o0.a.e0.d;
import com.baidu.swan.apps.database.subscribe.SwanAppSubscribeMsgProvider;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.Interceptable;
/* loaded from: classes.dex */
public final class a {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public static void a(@NonNull SQLiteDatabase sQLiteDatabase) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65536, null, sQLiteDatabase) == null) {
            try {
                sQLiteDatabase.execSQL("CREATE TABLE IF NOT EXISTS swanapp_subscribe_msg(_id INTEGER PRIMARY KEY AUTOINCREMENT,appKey varchar(100) NOT NULL,templateId varchar(50) NOT NULL,title varchar(100) NOT NULL,tips TEXT,result TINYINT default 0);");
            } catch (Exception e2) {
                d.c("SwanAppSubscribeMsg", "createTable", e2);
            }
        }
    }

    @WorkerThread
    public static void b(@Nullable String... strArr) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65537, null, strArr) == null) {
            Application b2 = c.a.o0.a.c1.a.b();
            if (b2 != null && strArr != null) {
                StringBuilder sb = new StringBuilder();
                int length = strArr.length;
                for (int i2 = 0; i2 < length; i2++) {
                    String str = strArr[i2];
                    if (!TextUtils.isEmpty(str)) {
                        sb.append(str);
                        if (i2 < length - 1) {
                            sb.append(",");
                        }
                    }
                }
                int delete = b2.getContentResolver().delete(SwanAppSubscribeMsgProvider.CONTENT_URI, "appKey in (?)", new String[]{sb.toString()});
                d.g("SwanAppSubscribeMsg", "deleteAllByAppKey count=" + delete + ", appKey=" + sb.toString());
                return;
            }
            d.l("SwanAppSubscribeMsg", "deleteAllByAppKey fail");
        }
    }
}
