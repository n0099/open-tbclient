package com.baidu.mario.a.a;

import com.baidu.mario.a.e;
import java.nio.ByteBuffer;
/* loaded from: classes2.dex */
public interface b {
    void a(boolean z, e eVar);

    void onAudioFrameAvailable(ByteBuffer byteBuffer, int i, long j);

    void onAudioStop(boolean z);
}
