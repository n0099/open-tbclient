package c.a.o0.v;

import android.graphics.Bitmap;
import android.media.MediaPlayer;
import android.view.View;
/* loaded from: classes3.dex */
public interface a {

    /* renamed from: c.a.o0.v.a$a  reason: collision with other inner class name */
    /* loaded from: classes3.dex */
    public interface InterfaceC0630a {
        void a(b bVar);

        void b(b bVar, int i2, int i3);

        void c(b bVar, int i2, int i3, int i4);
    }

    /* loaded from: classes3.dex */
    public interface b {
        void a(MediaPlayer mediaPlayer);

        a b();
    }

    void addRenderCallback(InterfaceC0630a interfaceC0630a);

    Bitmap getBitmap();

    View getView();

    void release();

    void removeRenderCallback(InterfaceC0630a interfaceC0630a);

    void setAspectRatio(int i2);

    void setVideoSize(int i2, int i3);
}
