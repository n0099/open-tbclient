package b.i.b.a.z;

import android.annotation.TargetApi;
import android.os.Looper;
import b.i.b.a.z.b;
import com.google.android.exoplayer2.drm.DrmInitData;
import com.google.android.exoplayer2.drm.DrmSession;
@TargetApi(16)
/* loaded from: classes6.dex */
public interface a<T extends b> {
    void a(DrmSession<T> drmSession);

    boolean b(DrmInitData drmInitData);

    DrmSession<T> c(Looper looper, DrmInitData drmInitData);
}
