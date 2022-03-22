package c.a.n0.y;

import android.graphics.Bitmap;
import android.media.MediaPlayer;
import android.view.View;
/* loaded from: classes2.dex */
public interface a {

    /* renamed from: c.a.n0.y.a$a  reason: collision with other inner class name */
    /* loaded from: classes2.dex */
    public interface InterfaceC0769a {
        void a(b bVar);

        void b(b bVar, int i, int i2);

        void c(b bVar, int i, int i2, int i3);
    }

    /* loaded from: classes2.dex */
    public interface b {
        void a(MediaPlayer mediaPlayer);

        a b();
    }

    void a(InterfaceC0769a interfaceC0769a);

    void b(InterfaceC0769a interfaceC0769a);

    Bitmap getBitmap();

    View getView();

    void release();

    void setAspectRatio(int i);

    void setVideoSize(int i, int i2);
}
