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
    public final /* synthetic */ a f1401a;

    public bv(a aVar) {
        this.f1401a = aVar;
    }

    @Override // java.lang.Runnable
    public void run() {
        a aVar = this.f1401a;
        while (aVar.f40521g && aVar.f40516b != null && !Thread.interrupted()) {
            if (aVar.f40517c) {
                AudioRecord audioRecord = aVar.f40516b;
                byte[] bArr = aVar.f40515a;
                int read = audioRecord.read(bArr, 0, bArr.length);
                if (read <= 0 || (aVar.f40520f && read != aVar.f40515a.length)) {
                    Log.w("AudioCaptureDevice", "[AudioRecord] warning, no data to read or wrong data size.");
                } else {
                    if (aVar.f40518d) {
                        Arrays.fill(aVar.f40515a, (byte) 0);
                    }
                    if (aVar.f40522h != null) {
                        MediaCodec.BufferInfo bufferInfo = new MediaCodec.BufferInfo();
                        bufferInfo.size = read;
                        bufferInfo.offset = 0;
                        bufferInfo.presentationTimeUs = (System.nanoTime() - aVar.f40519e) / 1000;
                        ByteBuffer allocate = ByteBuffer.allocate(read);
                        allocate.put(aVar.f40515a, 0, read);
                        allocate.flip();
                        aVar.f40522h.a(allocate, bufferInfo);
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
