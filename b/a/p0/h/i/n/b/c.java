package b.a.p0.h.i.n.b;

import android.content.Context;
import android.widget.FrameLayout;
import androidx.annotation.NonNull;
import b.a.p0.h.i.m.f;
/* loaded from: classes.dex */
public interface c {
    void a(FrameLayout frameLayout);

    void d(boolean z);

    c e(Context context, @NonNull b.a.p0.h.i.j.a aVar);

    void g(f fVar);

    int getCurrentPosition();

    int getDuration();

    void h(b.a.p0.h.i.j.a aVar);

    boolean isEnd();

    boolean isPlaying();

    void mute(boolean z);

    void pause();

    void resume();

    void stop();
}
