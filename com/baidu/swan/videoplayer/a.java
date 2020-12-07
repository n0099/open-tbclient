package com.baidu.swan.videoplayer;

import android.graphics.Bitmap;
import android.media.MediaPlayer;
import android.view.View;
/* loaded from: classes6.dex */
public interface a {

    /* renamed from: com.baidu.swan.videoplayer.a$a  reason: collision with other inner class name */
    /* loaded from: classes6.dex */
    public interface InterfaceC0574a {
        void a(b bVar);

        void a(b bVar, int i, int i2);

        void a(b bVar, int i, int i2, int i3);
    }

    /* loaded from: classes6.dex */
    public interface b {
        void b(MediaPlayer mediaPlayer);

        a bgU();
    }

    void a(InterfaceC0574a interfaceC0574a);

    void b(InterfaceC0574a interfaceC0574a);

    Bitmap getBitmap();

    View getView();

    void release();

    void setAspectRatio(int i);

    void setVideoSize(int i, int i2);
}
