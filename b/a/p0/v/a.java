package b.a.p0.v;

import android.graphics.Bitmap;
import android.media.MediaPlayer;
import android.view.View;
/* loaded from: classes4.dex */
public interface a {

    /* renamed from: b.a.p0.v.a$a  reason: collision with other inner class name */
    /* loaded from: classes4.dex */
    public interface InterfaceC0626a {
        void a(b bVar);

        void b(b bVar, int i2, int i3);

        void c(b bVar, int i2, int i3, int i4);
    }

    /* loaded from: classes4.dex */
    public interface b {
        void a(MediaPlayer mediaPlayer);

        a b();
    }

    void addRenderCallback(InterfaceC0626a interfaceC0626a);

    Bitmap getBitmap();

    View getView();

    void release();

    void removeRenderCallback(InterfaceC0626a interfaceC0626a);

    void setAspectRatio(int i2);

    void setVideoSize(int i2, int i3);
}
