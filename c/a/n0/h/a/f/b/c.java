package c.a.n0.h.a.f.b;

import android.content.Context;
import android.widget.FrameLayout;
import androidx.annotation.NonNull;
import c.a.n0.h.a.e.f;
/* loaded from: classes.dex */
public interface c {
    void a(FrameLayout frameLayout);

    void d(boolean z);

    c e(Context context, @NonNull c.a.n0.h.a.b.b bVar);

    void g(f fVar);

    int getCurrentPosition();

    int getDuration();

    void h(c.a.n0.h.a.b.b bVar);

    boolean isEnd();

    boolean isPlaying();

    void mute(boolean z);

    void pause();

    void resume();

    void stop();
}
