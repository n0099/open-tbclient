package c.a.n0.a.f.d;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import androidx.annotation.NonNull;
/* loaded from: classes.dex */
public interface n {

    /* loaded from: classes.dex */
    public interface a {
        void onFinish();
    }

    /* loaded from: classes.dex */
    public interface b {
        void a(boolean z);

        void b(Exception exc);
    }

    /* loaded from: classes.dex */
    public interface c {
        void a(boolean z);

        void b();
    }

    void a(a aVar);

    void b(Activity activity, Bundle bundle, c.a.n0.a.c.a aVar);

    void c(c.a.n0.a.c.c cVar);

    String d(@NonNull Context context);

    boolean e(Context context);

    String f(@NonNull Context context);

    void g(c cVar);

    String h(Context context);

    String i(@NonNull Context context);

    void j(c.a.n0.a.c.a aVar);
}
