package c.a.p0.n4.l;

import android.hardware.Camera;
import com.faceunity.encoder.TextureMovieEncoder;
/* loaded from: classes2.dex */
public interface f {

    /* loaded from: classes2.dex */
    public interface a {
        void a(boolean z, String str);
    }

    void a(Camera camera);

    void b(Camera camera);

    void c(a aVar);

    void d(Camera camera);

    void e(Camera camera);

    void setOnEncoderStatusUpdateListener(TextureMovieEncoder.OnEncoderStatusUpdateListener onEncoderStatusUpdateListener);

    void setPreviewSize(int i, int i2);
}
