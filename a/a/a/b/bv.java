package a.a.a.b;

import android.media.AudioRecord;
import android.media.MediaCodec;
import android.util.Log;
import d.a.k.a.a;
import java.nio.ByteBuffer;
import java.util.Arrays;
/* loaded from: classes.dex */
public class bv implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ a f1414a;

    public bv(a aVar) {
        this.f1414a = aVar;
    }

    @Override // java.lang.Runnable
    public void run() {
        a aVar = this.f1414a;
        while (aVar.f44197g && aVar.f44192b != null && !Thread.interrupted()) {
            if (aVar.f44193c) {
                AudioRecord audioRecord = aVar.f44192b;
                byte[] bArr = aVar.f44191a;
                int read = audioRecord.read(bArr, 0, bArr.length);
                if (read <= 0 || (aVar.f44196f && read != aVar.f44191a.length)) {
                    Log.w("AudioCaptureDevice", "[AudioRecord] warning, no data to read or wrong data size.");
                } else {
                    if (aVar.f44194d) {
                        Arrays.fill(aVar.f44191a, (byte) 0);
                    }
                    if (aVar.f44198h != null) {
                        MediaCodec.BufferInfo bufferInfo = new MediaCodec.BufferInfo();
                        bufferInfo.size = read;
                        bufferInfo.offset = 0;
                        bufferInfo.presentationTimeUs = (System.nanoTime() - aVar.f44195e) / 1000;
                        ByteBuffer allocate = ByteBuffer.allocate(read);
                        allocate.put(aVar.f44191a, 0, read);
                        allocate.flip();
                        aVar.f44198h.a(allocate, bufferInfo);
                    }
                }
            } else {
                try {
                    Thread.sleep(25L);
                } catch (Exception unused) {
                }
            }
        }
    }
}
