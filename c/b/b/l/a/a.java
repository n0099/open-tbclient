package c.b.b.l.a;

import android.content.Context;
import android.os.Handler;
import android.view.Window;
import android.view.WindowManager;
import c.b.b.q.g0;
import com.badlogic.gdx.Application;
/* loaded from: classes7.dex */
public interface a extends Application {
    Window getApplicationWindow();

    Context getContext();

    c.b.b.q.a<Runnable> getExecutedRunnables();

    Handler getHandler();

    m getInput();

    g0<c.b.b.h> getLifecycleListeners();

    c.b.b.q.a<Runnable> getRunnables();

    WindowManager getWindowManager();

    void useImmersiveMode(boolean z);
}
