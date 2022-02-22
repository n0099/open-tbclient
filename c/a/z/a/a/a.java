package c.a.z.a.a;

import com.baidu.mario.audio.AudioParams;
import java.nio.ByteBuffer;
/* loaded from: classes9.dex */
public interface a {
    void a(boolean z, AudioParams audioParams);

    void onAudioFrameAvailable(ByteBuffer byteBuffer, int i2, long j2);

    void onAudioStop(boolean z);
}
