package b.a.x0.p.f;

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
/* loaded from: classes6.dex */
public class c {
    public static /* synthetic */ Interceptable $ic;

    /* renamed from: b  reason: collision with root package name */
    public static final int[] f30744b;

    /* renamed from: c  reason: collision with root package name */
    public static int f30745c;

    /* renamed from: d  reason: collision with root package name */
    public static int f30746d;

    /* renamed from: e  reason: collision with root package name */
    public static int f30747e;

    /* renamed from: f  reason: collision with root package name */
    public static c f30748f;

    /* renamed from: g  reason: collision with root package name */
    public static byte[] f30749g;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public AudioRecord f30750a;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(2083961040, "Lb/a/x0/p/f/c;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(2083961040, "Lb/a/x0/p/f/c;");
                return;
            }
        }
        f30744b = new int[]{1, 0, 5, 7, 6};
        f30745c = RecordConstants.MOVIE_ENCODE_SAMPLE_RATE;
        f30746d = 2048;
        f30747e = 24;
        f30749g = new byte[0];
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
        int minBufferSize = AudioRecord.getMinBufferSize(f30745c, 16, 2);
        int i5 = f30746d;
        int i6 = f30747e * i5;
        i6 = i6 < minBufferSize ? ((minBufferSize / i5) + 1) * i5 * 2 : i6;
        if (i2 != -100) {
            try {
                AudioRecord audioRecord = new AudioRecord(i2, f30745c, 16, 2, i6);
                this.f30750a = audioRecord;
                if (audioRecord.getState() != 1) {
                    this.f30750a = null;
                }
            } catch (Exception unused) {
                this.f30750a = null;
            }
            if (this.f30750a != null) {
                b.a.x0.t.c.d("audio_source:(if) ---> " + i2);
            }
        }
        if (this.f30750a == null) {
            for (int i7 : f30744b) {
                try {
                    AudioRecord audioRecord2 = new AudioRecord(i7, f30745c, 16, 2, i6);
                    this.f30750a = audioRecord2;
                    if (audioRecord2.getState() != 1) {
                        this.f30750a = null;
                    }
                } catch (Exception unused2) {
                    this.f30750a = null;
                }
                if (this.f30750a != null) {
                    b.a.x0.t.c.d("audio_source:(for) ---> " + i7);
                    return;
                }
            }
        }
    }

    public int a(@NonNull ByteBuffer byteBuffer, int i2) {
        InterceptResult invokeLI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLI = interceptable.invokeLI(1048576, this, byteBuffer, i2)) == null) {
            AudioRecord audioRecord = this.f30750a;
            if (audioRecord == null) {
                return 0;
            }
            return audioRecord.read(byteBuffer, i2);
        }
        return invokeLI.intValue;
    }

    public void b() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) || this.f30750a == null) {
            return;
        }
        synchronized (f30749g) {
            g();
            if (f30748f == this) {
                f30748f = null;
            }
        }
    }

    public void c() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            synchronized (f30749g) {
                if (f30748f == this) {
                    return;
                }
                if (f30748f != null) {
                    f30748f.g();
                    f30748f = null;
                }
                f();
                f30748f = this;
            }
        }
    }

    public AudioRecord d() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? this.f30750a : (AudioRecord) invokeV.objValue;
    }

    public int e() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
            AudioRecord audioRecord = this.f30750a;
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
        if (!(interceptable == null || interceptable.invokeV(1048581, this) == null) || (audioRecord = this.f30750a) == null) {
            return;
        }
        audioRecord.startRecording();
    }

    public final void g() {
        AudioRecord audioRecord;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048582, this) == null) || (audioRecord = this.f30750a) == null) {
            return;
        }
        this.f30750a = null;
        audioRecord.stop();
        audioRecord.release();
    }
}
