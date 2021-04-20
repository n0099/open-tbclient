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
    public final /* synthetic */ a f1383a;

    public bv(a aVar) {
        this.f1383a = aVar;
    }

    @Override // java.lang.Runnable
    public void run() {
        a aVar = this.f1383a;
        while (aVar.f64538g && aVar.f64533b != null && !Thread.interrupted()) {
            if (aVar.f64534c) {
                AudioRecord audioRecord = aVar.f64533b;
                byte[] bArr = aVar.f64532a;
                int read = audioRecord.read(bArr, 0, bArr.length);
                if (read <= 0 || (aVar.f64537f && read != aVar.f64532a.length)) {
                    Log.w("AudioCaptureDevice", "[AudioRecord] warning, no data to read or wrong data size.");
                } else {
                    if (aVar.f64535d) {
                        Arrays.fill(aVar.f64532a, (byte) 0);
                    }
                    if (aVar.f64539h != null) {
                        MediaCodec.BufferInfo bufferInfo = new MediaCodec.BufferInfo();
                        bufferInfo.size = read;
                        bufferInfo.offset = 0;
                        bufferInfo.presentationTimeUs = (System.nanoTime() - aVar.f64536e) / 1000;
                        ByteBuffer allocate = ByteBuffer.allocate(read);
                        allocate.put(aVar.f64532a, 0, read);
                        allocate.flip();
                        aVar.f64539h.a(allocate, bufferInfo);
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
