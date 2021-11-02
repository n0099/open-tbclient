package b.a.r0.z3.l;

import android.hardware.Camera;
import com.faceunity.encoder.TextureMovieEncoder;
/* loaded from: classes6.dex */
public interface f {

    /* loaded from: classes6.dex */
    public interface a {
        void a(boolean z, String str);
    }

    void setOnEncoderStatusUpdateListener(TextureMovieEncoder.OnEncoderStatusUpdateListener onEncoderStatusUpdateListener);

    void setPreviewSize(int i2, int i3);

    void startPreview(Camera camera);

    void startRecord(Camera camera);

    void stopPreview(Camera camera);

    void stopRecord(Camera camera);

    void takePicture(a aVar);
}
