package com.baidu.swan.videoplayer;

import android.graphics.Bitmap;
import android.media.MediaPlayer;
import android.view.View;
/* loaded from: classes11.dex */
public interface a {

    /* renamed from: com.baidu.swan.videoplayer.a$a  reason: collision with other inner class name */
    /* loaded from: classes11.dex */
    public interface InterfaceC0462a {
        void a(b bVar);

        void a(b bVar, int i, int i2);

        void a(b bVar, int i, int i2, int i3);
    }

    /* loaded from: classes11.dex */
    public interface b {
        a aJr();

        void b(MediaPlayer mediaPlayer);
    }

    void a(InterfaceC0462a interfaceC0462a);

    void b(InterfaceC0462a interfaceC0462a);

    Bitmap getBitmap();

    View getView();

    void release();

    void setAspectRatio(int i);

    void setVideoSize(int i, int i2);
}
