package a.a.a.b;

import android.media.AudioRecord;
import android.media.MediaCodec;
import android.util.Log;
import d.b.k.a.a;
import java.nio.ByteBuffer;
import java.util.Arrays;
/* loaded from: classes.dex */
public class bv implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ a f1397a;

    public bv(a aVar) {
        this.f1397a = aVar;
    }

    @Override // java.lang.Runnable
    public void run() {
        a aVar = this.f1397a;
        while (aVar.f63838g && aVar.f63833b != null && !Thread.interrupted()) {
            if (aVar.f63834c) {
                AudioRecord audioRecord = aVar.f63833b;
                byte[] bArr = aVar.f63832a;
                int read = audioRecord.read(bArr, 0, bArr.length);
                if (read <= 0 || (aVar.f63837f && read != aVar.f63832a.length)) {
                    Log.w("AudioCaptureDevice", "[AudioRecord] warning, no data to read or wrong data size.");
                } else {
                    if (aVar.f63835d) {
                        Arrays.fill(aVar.f63832a, (byte) 0);
                    }
                    if (aVar.f63839h != null) {
                        MediaCodec.BufferInfo bufferInfo = new MediaCodec.BufferInfo();
                        bufferInfo.size = read;
                        bufferInfo.offset = 0;
                        bufferInfo.presentationTimeUs = (System.nanoTime() - aVar.f63836e) / 1000;
                        ByteBuffer allocate = ByteBuffer.allocate(read);
                        allocate.put(aVar.f63832a, 0, read);
                        allocate.flip();
                        aVar.f63839h.a(allocate, bufferInfo);
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
