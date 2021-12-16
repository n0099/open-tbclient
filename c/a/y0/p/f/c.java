package c.a.y0.p.f;

import android.media.AudioRecord;
import androidx.annotation.NonNull;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.baidu.ugc.editvideo.record.RecordConstants;
import java.nio.ByteBuffer;
/* loaded from: classes9.dex */
public class c {
    public static /* synthetic */ Interceptable $ic;

    /* renamed from: b  reason: collision with root package name */
    public static final int[] f27551b;

    /* renamed from: c  reason: collision with root package name */
    public static int f27552c;

    /* renamed from: d  reason: collision with root package name */
    public static int f27553d;

    /* renamed from: e  reason: collision with root package name */
    public static int f27554e;

    /* renamed from: f  reason: collision with root package name */
    public static c f27555f;

    /* renamed from: g  reason: collision with root package name */
    public static byte[] f27556g;
    public transient /* synthetic */ FieldHolder $fh;
    public AudioRecord a;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-16896430, "Lc/a/y0/p/f/c;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-16896430, "Lc/a/y0/p/f/c;");
                return;
            }
        }
        f27551b = new int[]{1, 0, 5, 7, 6};
        f27552c = RecordConstants.MOVIE_ENCODE_SAMPLE_RATE;
        f27553d = 2048;
        f27554e = 24;
        f27556g = new byte[0];
    }

    public c(int i2) {
        int[] iArr;
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {Integer.valueOf(i2)};
            interceptable.invokeUnInit(65537, newInitContext);
            int i3 = newInitContext.flag;
            if ((i3 & 1) != 0) {
                int i4 = i3 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        int minBufferSize = AudioRecord.getMinBufferSize(f27552c, 16, 2);
        int i5 = f27553d;
        int i6 = f27554e * i5;
        i6 = i6 < minBufferSize ? ((minBufferSize / i5) + 1) * i5 * 2 : i6;
        if (i2 != -100) {
            try {
                AudioRecord audioRecord = new AudioRecord(i2, f27552c, 16, 2, i6);
                this.a = audioRecord;
                if (audioRecord.getState() != 1) {
                    this.a = null;
                }
            } catch (Exception unused) {
                this.a = null;
            }
            if (this.a != null) {
                c.a.y0.t.c.d("audio_source:(if) ---> " + i2);
            }
        }
        if (this.a == null) {
            for (int i7 : f27551b) {
                try {
                    AudioRecord audioRecord2 = new AudioRecord(i7, f27552c, 16, 2, i6);
                    this.a = audioRecord2;
                    if (audioRecord2.getState() != 1) {
                        this.a = null;
                    }
                } catch (Exception unused2) {
                    this.a = null;
                }
                if (this.a != null) {
                    c.a.y0.t.c.d("audio_source:(for) ---> " + i7);
                    return;
                }
            }
        }
    }

    public int a(@NonNull ByteBuffer byteBuffer, int i2) {
        InterceptResult invokeLI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLI = interceptable.invokeLI(1048576, this, byteBuffer, i2)) == null) {
            AudioRecord audioRecord = this.a;
            if (audioRecord == null) {
                return 0;
            }
            return audioRecord.read(byteBuffer, i2);
        }
        return invokeLI.intValue;
    }

    public void b() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) || this.a == null) {
            return;
        }
        synchronized (f27556g) {
            g();
            if (f27555f == this) {
                f27555f = null;
            }
        }
    }

    public void c() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            synchronized (f27556g) {
                if (f27555f == this) {
                    return;
                }
                if (f27555f != null) {
                    f27555f.g();
                    f27555f = null;
                }
                f();
                f27555f = this;
            }
        }
    }

    public AudioRecord d() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? this.a : (AudioRecord) invokeV.objValue;
    }

    public int e() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
            AudioRecord audioRecord = this.a;
            if (audioRecord != null) {
                return audioRecord.getRecordingState();
            }
            return -1;
        }
        return invokeV.intValue;
    }

    public final void f() {
        AudioRecord audioRecord;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048581, this) == null) || (audioRecord = this.a) == null) {
            return;
        }
        audioRecord.startRecording();
    }

    public final void g() {
        AudioRecord audioRecord;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048582, this) == null) || (audioRecord = this.a) == null) {
            return;
        }
        this.a = null;
        audioRecord.stop();
        audioRecord.release();
    }
}
