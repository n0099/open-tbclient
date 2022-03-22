package c.a.v0.o.f;

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
/* loaded from: classes3.dex */
public class c {
    public static /* synthetic */ Interceptable $ic;

    /* renamed from: b  reason: collision with root package name */
    public static final int[] f21806b;

    /* renamed from: c  reason: collision with root package name */
    public static int f21807c;

    /* renamed from: d  reason: collision with root package name */
    public static int f21808d;

    /* renamed from: e  reason: collision with root package name */
    public static int f21809e;

    /* renamed from: f  reason: collision with root package name */
    public static c f21810f;

    /* renamed from: g  reason: collision with root package name */
    public static byte[] f21811g;
    public transient /* synthetic */ FieldHolder $fh;
    public AudioRecord a;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1081870512, "Lc/a/v0/o/f/c;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1081870512, "Lc/a/v0/o/f/c;");
                return;
            }
        }
        f21806b = new int[]{1, 0, 5, 7, 6};
        f21807c = RecordConstants.MOVIE_ENCODE_SAMPLE_RATE;
        f21808d = 2048;
        f21809e = 24;
        f21811g = new byte[0];
    }

    public c(int i) {
        int[] iArr;
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {Integer.valueOf(i)};
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        int minBufferSize = AudioRecord.getMinBufferSize(f21807c, 16, 2);
        int i4 = f21808d;
        int i5 = f21809e * i4;
        i5 = i5 < minBufferSize ? ((minBufferSize / i4) + 1) * i4 * 2 : i5;
        if (i != -100) {
            try {
                AudioRecord audioRecord = new AudioRecord(i, f21807c, 16, 2, i5);
                this.a = audioRecord;
                if (audioRecord.getState() != 1) {
                    this.a = null;
                }
            } catch (Exception unused) {
                this.a = null;
            }
            if (this.a != null) {
                c.a.v0.r.c.d("audio_source:(if) ---> " + i);
            }
        }
        if (this.a == null) {
            for (int i6 : f21806b) {
                try {
                    AudioRecord audioRecord2 = new AudioRecord(i6, f21807c, 16, 2, i5);
                    this.a = audioRecord2;
                    if (audioRecord2.getState() != 1) {
                        this.a = null;
                    }
                } catch (Exception unused2) {
                    this.a = null;
                }
                if (this.a != null) {
                    c.a.v0.r.c.d("audio_source:(for) ---> " + i6);
                    return;
                }
            }
        }
    }

    public int a(@NonNull ByteBuffer byteBuffer, int i) {
        InterceptResult invokeLI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLI = interceptable.invokeLI(1048576, this, byteBuffer, i)) == null) {
            AudioRecord audioRecord = this.a;
            if (audioRecord == null) {
                return 0;
            }
            return audioRecord.read(byteBuffer, i);
        }
        return invokeLI.intValue;
    }

    public void b() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) || this.a == null) {
            return;
        }
        synchronized (f21811g) {
            g();
            if (f21810f == this) {
                f21810f = null;
            }
        }
    }

    public void c() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            synchronized (f21811g) {
                if (f21810f == this) {
                    return;
                }
                if (f21810f != null) {
                    f21810f.g();
                    f21810f = null;
                }
                f();
                f21810f = this;
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
