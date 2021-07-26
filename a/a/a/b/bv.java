package a.a.a.b;

import android.media.AudioRecord;
import android.media.MediaCodec;
import android.util.Log;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import d.a.m.a.a;
import java.nio.ByteBuffer;
import java.util.Arrays;
/* loaded from: classes.dex */
public class bv implements Runnable {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ a f1450a;

    public bv(a aVar) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {aVar};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f1450a = aVar;
    }

    @Override // java.lang.Runnable
    public void run() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            a aVar = this.f1450a;
            while (aVar.f43390g && aVar.f43385b != null && !Thread.interrupted()) {
                if (aVar.f43386c) {
                    AudioRecord audioRecord = aVar.f43385b;
                    byte[] bArr = aVar.f43384a;
                    int read = audioRecord.read(bArr, 0, bArr.length);
                    if (read <= 0 || (aVar.f43389f && read != aVar.f43384a.length)) {
                        Log.w("AudioCaptureDevice", "[AudioRecord] warning, no data to read or wrong data size.");
                    } else {
                        if (aVar.f43387d) {
                            Arrays.fill(aVar.f43384a, (byte) 0);
                        }
                        if (aVar.f43391h != null) {
                            MediaCodec.BufferInfo bufferInfo = new MediaCodec.BufferInfo();
                            bufferInfo.size = read;
                            bufferInfo.offset = 0;
                            bufferInfo.presentationTimeUs = (System.nanoTime() - aVar.f43388e) / 1000;
                            ByteBuffer allocate = ByteBuffer.allocate(read);
                            allocate.put(aVar.f43384a, 0, read);
                            allocate.flip();
                            aVar.f43391h.a(allocate, bufferInfo);
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
}
