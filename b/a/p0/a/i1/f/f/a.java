package b.a.p0.a.i1.f.f;

import android.media.MediaCodec;
import android.media.MediaCodecInfo;
import android.media.MediaCodecList;
import android.media.MediaCrypto;
import android.media.MediaFormat;
import android.text.TextUtils;
import android.view.Surface;
import b.a.p0.a.k;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.rtc.record.MediaEncodeParams;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.nio.BufferOverflowException;
import java.nio.BufferUnderflowException;
import java.nio.ByteBuffer;
/* loaded from: classes.dex */
public class a {
    public static /* synthetic */ Interceptable $ic;
    public static final boolean j;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public MediaCodec f6154a;

    /* renamed from: b  reason: collision with root package name */
    public ByteBuffer[] f6155b;

    /* renamed from: c  reason: collision with root package name */
    public ByteBuffer[] f6156c;

    /* renamed from: d  reason: collision with root package name */
    public MediaCodec.BufferInfo f6157d;

    /* renamed from: e  reason: collision with root package name */
    public ByteArrayOutputStream f6158e;

    /* renamed from: f  reason: collision with root package name */
    public long f6159f;

    /* renamed from: g  reason: collision with root package name */
    public int f6160g;

    /* renamed from: h  reason: collision with root package name */
    public int f6161h;

    /* renamed from: i  reason: collision with root package name */
    public String f6162i;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1707666973, "Lb/a/p0/a/i1/f/f/a;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1707666973, "Lb/a/p0/a/i1/f/f/a;");
                return;
            }
        }
        j = k.f6397a;
    }

    /* JADX WARN: Removed duplicated region for block: B:26:0x0063  */
    /* JADX WARN: Removed duplicated region for block: B:27:0x0064 A[Catch: IOException -> 0x00ad, TryCatch #0 {IOException -> 0x00ad, blocks: (B:8:0x002c, B:27:0x0064, B:29:0x0082, B:15:0x0045, B:18:0x004f, B:21:0x0059), top: B:38:0x002c }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public a(String str, int i2, int i3, int i4) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {str, Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(i4)};
            interceptable.invokeUnInit(65537, newInitContext);
            int i5 = newInitContext.flag;
            if ((i5 & 1) != 0) {
                int i6 = i5 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.f6159f = 0L;
        char c2 = 0;
        this.f6160g = 0;
        this.f6161h = 0;
        this.f6162i = "aac";
        this.f6160g = i3;
        this.f6161h = i2;
        this.f6158e = new ByteArrayOutputStream();
        if (TextUtils.isEmpty(str)) {
            this.f6162i = "aac";
        } else {
            this.f6162i = str;
        }
        try {
            String str2 = this.f6162i;
            int hashCode = str2.hashCode();
            if (hashCode == 96323) {
                if (str2.equals("aac")) {
                    if (c2 == 0) {
                    }
                }
                c2 = 65535;
                if (c2 == 0) {
                }
            } else if (hashCode != 108272) {
                if (hashCode == 110810 && str2.equals("pcm")) {
                    c2 = 2;
                    if (c2 == 0) {
                        return;
                    }
                    boolean z = j;
                    MediaCodecInfo d2 = d("audio/mp4a-latm");
                    MediaFormat createAudioFormat = MediaFormat.createAudioFormat("audio/mp4a-latm", i3, i2);
                    createAudioFormat.setInteger("bitrate", i4);
                    createAudioFormat.setInteger("aac-profile", 2);
                    createAudioFormat.setInteger("max-input-size", 102400);
                    if (d2 != null) {
                        MediaCodec createByCodecName = MediaCodec.createByCodecName(d2.getName());
                        this.f6154a = createByCodecName;
                        createByCodecName.configure(createAudioFormat, (Surface) null, (MediaCrypto) null, 1);
                        this.f6154a.start();
                        this.f6155b = this.f6154a.getInputBuffers();
                        this.f6156c = this.f6154a.getOutputBuffers();
                        this.f6157d = new MediaCodec.BufferInfo();
                        return;
                    }
                    return;
                }
                c2 = 65535;
                if (c2 == 0) {
                }
            } else {
                if (str2.equals("mp3")) {
                    c2 = 1;
                    if (c2 == 0) {
                    }
                }
                c2 = 65535;
                if (c2 == 0) {
                }
            }
        } catch (IOException e2) {
            e2.printStackTrace();
        }
        e2.printStackTrace();
    }

    public final int a(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048576, this, i2)) == null) {
            switch (i2) {
                case 7350:
                    return 12;
                case 11025:
                    return 10;
                case 12000:
                    return 9;
                case 16000:
                    return 8;
                case 22050:
                    return 7;
                case 24000:
                    return 6;
                case 32000:
                    return 5;
                case 44100:
                    return 4;
                case MediaEncodeParams.AUDIO_SAMPLE_RATE /* 48000 */:
                    return 3;
                case 64000:
                    return 2;
                case 88200:
                    return 1;
                case 96000:
                    return 0;
                default:
                    return 11;
            }
        }
        return invokeI.intValue;
    }

    public final long b(long j2) {
        InterceptResult invokeJ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeJ = interceptable.invokeJ(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, j2)) == null) {
            int i2 = this.f6160g;
            if (i2 == 0) {
                return 0L;
            }
            return (((j2 * 1000) * 90) * 1024) / i2;
        }
        return invokeJ.longValue;
    }

    public final byte[] c(int i2, int i3, int i4, int i5) {
        InterceptResult invokeIIII;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeIIII = interceptable.invokeIIII(Constants.METHOD_SEND_USER_MSG, this, i2, i3, i4, i5)) == null) {
            int i6 = i2 + 7;
            byte[] bArr = new byte[i6];
            int a2 = a(i4);
            bArr[0] = -1;
            bArr[1] = -15;
            bArr[2] = (byte) (((i3 - 1) << 6) + (a2 << 2) + (i5 >> 2));
            bArr[3] = (byte) (((i5 & 3) << 6) + (i6 >> 11));
            bArr[4] = (byte) ((i6 & 2047) >> 3);
            bArr[5] = (byte) (((i6 & 7) << 5) + 31);
            bArr[6] = -4;
            return bArr;
        }
        return (byte[]) invokeIIII.objValue;
    }

    public final MediaCodecInfo d(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048579, this, str)) == null) {
            int codecCount = MediaCodecList.getCodecCount();
            for (int i2 = 0; i2 < codecCount; i2++) {
                MediaCodecInfo codecInfoAt = MediaCodecList.getCodecInfoAt(i2);
                if (codecInfoAt.isEncoder()) {
                    for (String str2 : codecInfoAt.getSupportedTypes()) {
                        if (str2.equalsIgnoreCase(str)) {
                            return codecInfoAt;
                        }
                    }
                    continue;
                }
            }
            return null;
        }
        return (MediaCodecInfo) invokeL.objValue;
    }

    public final byte[] e(byte[] bArr) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048580, this, bArr)) == null) {
            if (this.f6154a != null && bArr != null) {
                boolean z = j;
                int dequeueInputBuffer = this.f6154a.dequeueInputBuffer(-1L);
                if (dequeueInputBuffer >= 0) {
                    ByteBuffer byteBuffer = this.f6155b[dequeueInputBuffer];
                    byteBuffer.clear();
                    try {
                        byteBuffer.put(bArr);
                        byteBuffer.limit(bArr.length);
                        this.f6154a.queueInputBuffer(dequeueInputBuffer, 0, bArr.length, b(this.f6159f), 0);
                        this.f6159f++;
                    } catch (IllegalArgumentException | BufferOverflowException e2) {
                        if (j) {
                            e2.printStackTrace();
                        }
                        return bArr;
                    }
                }
                int dequeueOutputBuffer = this.f6154a.dequeueOutputBuffer(this.f6157d, 0L);
                while (dequeueOutputBuffer >= 0) {
                    MediaCodec.BufferInfo bufferInfo = this.f6157d;
                    int i2 = bufferInfo.size;
                    ByteBuffer byteBuffer2 = this.f6156c[dequeueOutputBuffer];
                    try {
                        byteBuffer2.position(bufferInfo.offset);
                        byteBuffer2.limit(this.f6157d.offset + i2);
                        byte[] c2 = c(i2, 2, this.f6160g, this.f6161h);
                        try {
                            byteBuffer2.get(c2, 7, i2);
                            byteBuffer2.position(this.f6157d.offset);
                            this.f6158e.write(c2);
                            this.f6154a.releaseOutputBuffer(dequeueOutputBuffer, false);
                            dequeueOutputBuffer = this.f6154a.dequeueOutputBuffer(this.f6157d, 0L);
                        } catch (IOException | IllegalArgumentException | BufferUnderflowException e3) {
                            if (j) {
                                e3.printStackTrace();
                            }
                            return bArr;
                        }
                    } catch (IllegalArgumentException e4) {
                        if (j) {
                            e4.printStackTrace();
                        }
                        return bArr;
                    }
                }
                bArr = this.f6158e.toByteArray();
                try {
                    this.f6158e.flush();
                } catch (IOException e5) {
                    if (j) {
                        e5.printStackTrace();
                    }
                }
                this.f6158e.reset();
            }
            return bArr;
        }
        return (byte[]) invokeL.objValue;
    }

    public byte[] f(byte[] bArr) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048581, this, bArr)) == null) {
            if (this.f6154a != null && bArr != null) {
                String str = this.f6162i;
                char c2 = 65535;
                int hashCode = str.hashCode();
                if (hashCode != 96323) {
                    if (hashCode != 108272) {
                        if (hashCode == 110810 && str.equals("pcm")) {
                            c2 = 2;
                        }
                    } else if (str.equals("mp3")) {
                        c2 = 1;
                    }
                } else if (str.equals("aac")) {
                    c2 = 0;
                }
                if (c2 != 0) {
                    if (c2 != 1) {
                        return bArr;
                    }
                    g(bArr);
                    return bArr;
                }
                return e(bArr);
            }
            boolean z = j;
            return bArr;
        }
        return (byte[]) invokeL.objValue;
    }

    public final byte[] g(byte[] bArr) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(1048582, this, bArr)) == null) ? bArr : (byte[]) invokeL.objValue;
    }
}
