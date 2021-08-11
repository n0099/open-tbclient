package c.a.p0.w3.l;

import android.hardware.Camera;
import com.faceunity.encoder.TextureMovieEncoder;
/* loaded from: classes4.dex */
public interface g {

    /* loaded from: classes4.dex */
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
