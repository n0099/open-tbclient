package b.a.p0.j.u.c;

import android.content.Context;
import androidx.annotation.NonNull;
import com.baidu.swan.apps.scheme.actions.SwanAppDownloadAction;
/* loaded from: classes4.dex */
public interface c {
    boolean a(@NonNull Context context, @NonNull SwanAppDownloadAction.SwanAppDownloadType swanAppDownloadType, @NonNull b.a.p0.h.i.k.f.a aVar);

    boolean b(Context context, String str, String str2, String str3);

    boolean c();

    String getPackageName();

    void init();
}
