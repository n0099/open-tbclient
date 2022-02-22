package c.a.h.a.a;

import android.media.AudioRecord;
import com.baidu.rtc.record.MediaEncodeParams;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes.dex */
public class c {
    public static /* synthetic */ Interceptable $ic;

    /* renamed from: e  reason: collision with root package name */
    public static c f3716e;

    /* renamed from: f  reason: collision with root package name */
    public static int[] f3717f;

    /* renamed from: g  reason: collision with root package name */
    public static short[] f3718g;

    /* renamed from: h  reason: collision with root package name */
    public static short[] f3719h;
    public transient /* synthetic */ FieldHolder $fh;
    public int a;

    /* renamed from: b  reason: collision with root package name */
    public short f3720b;

    /* renamed from: c  reason: collision with root package name */
    public short f3721c;

    /* renamed from: d  reason: collision with root package name */
    public int f3722d;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(2030192257, "Lc/a/h/a/a/c;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(2030192257, "Lc/a/h/a/a/c;");
                return;
            }
        }
        f3717f = new int[]{8000, 11025, 16000, 22050, 32000, 44100, 47250, MediaEncodeParams.AUDIO_SAMPLE_RATE};
        f3718g = new short[]{2, 3};
        f3719h = new short[]{2, 16, 12, 3};
    }

    public c() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.f3722d = -2;
    }

    public static c b() {
        InterceptResult invokeV;
        c cVar;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65538, null)) == null) {
            c cVar2 = f3716e;
            if (cVar2 == null) {
                synchronized (c.class) {
                    if (f3716e == null) {
                        f3716e = new c();
                    }
                    cVar = f3716e;
                }
                return cVar;
            }
            return cVar2;
        }
        return (c) invokeV.objValue;
    }

    /* JADX WARN: Removed duplicated region for block: B:125:0x011c A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:77:0x0111  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public AudioRecord a() throws IllegalArgumentException {
        InterceptResult invokeV;
        int[] iArr;
        int i2;
        int i3;
        short[] sArr;
        short s;
        int i4;
        int i5;
        int minBufferSize;
        AudioRecord audioRecord;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            if (this.a > 0 && this.f3720b > 0 && this.f3721c > 0) {
                return new AudioRecord(1, this.a, this.f3721c, this.f3720b, this.f3722d);
            }
            int[] iArr2 = f3717f;
            int length = iArr2.length;
            AudioRecord audioRecord2 = null;
            for (int i6 = 0; i6 < length; i6++) {
                int i7 = iArr2[i6];
                short[] sArr2 = f3718g;
                int length2 = sArr2.length;
                int i8 = 0;
                while (i8 < length2) {
                    short s2 = sArr2[i8];
                    short[] sArr3 = f3719h;
                    int length3 = sArr3.length;
                    AudioRecord audioRecord3 = audioRecord2;
                    int i9 = 0;
                    while (i9 < length3) {
                        short s3 = sArr3[i9];
                        try {
                            minBufferSize = AudioRecord.getMinBufferSize(i7, s3, s2);
                            this.f3722d = minBufferSize;
                        } catch (Throwable th) {
                            th = th;
                            iArr = iArr2;
                            i2 = i9;
                            i3 = length3;
                            sArr = sArr3;
                            s = s2;
                            i4 = i8;
                            i5 = 1;
                        }
                        if (minBufferSize == -2) {
                            if (audioRecord3 == null || audioRecord3.getState() == 1) {
                                iArr = iArr2;
                                i2 = i9;
                                i3 = length3;
                                sArr = sArr3;
                                s = s2;
                                i4 = i8;
                            } else {
                                audioRecord3.release();
                                iArr = iArr2;
                                i2 = i9;
                                i3 = length3;
                                sArr = sArr3;
                                s = s2;
                                i4 = i8;
                                audioRecord3 = null;
                            }
                        } else {
                            int min = Math.min(minBufferSize * 8, 4096);
                            iArr = iArr2;
                            i5 = 1;
                            i2 = i9;
                            i3 = length3;
                            sArr = sArr3;
                            short s4 = s2;
                            i4 = i8;
                            try {
                                audioRecord = new AudioRecord(1, i7, s3, s2, min);
                                try {
                                } catch (Throwable th2) {
                                    th = th2;
                                    s = s4;
                                }
                            } catch (Throwable th3) {
                                th = th3;
                            }
                            try {
                                if (audioRecord.getState() == 1) {
                                    try {
                                        this.a = i7;
                                        try {
                                            this.f3720b = s4;
                                            this.f3721c = s3;
                                            this.f3722d = min;
                                            if (audioRecord.getState() != 1) {
                                                audioRecord.release();
                                            }
                                            return audioRecord;
                                        } catch (Throwable th4) {
                                            th = th4;
                                            audioRecord3 = audioRecord;
                                            s = s4;
                                        }
                                    } catch (Throwable th5) {
                                        th = th5;
                                        audioRecord3 = audioRecord;
                                        s = s4;
                                        th.printStackTrace();
                                        if (audioRecord3 != null) {
                                        }
                                        i9 = i2 + 1;
                                        s2 = s;
                                        length3 = i3;
                                        iArr2 = iArr;
                                        sArr3 = sArr;
                                        i8 = i4;
                                    }
                                } else {
                                    try {
                                        audioRecord.release();
                                    } catch (Throwable th6) {
                                        th = th6;
                                        s = s4;
                                    }
                                    try {
                                        audioRecord3 = new AudioRecord(1, i7, s3, s4, this.f3722d);
                                        try {
                                        } catch (Throwable th7) {
                                            th = th7;
                                            s = s4;
                                        }
                                    } catch (Throwable th8) {
                                        th = th8;
                                        s = s4;
                                        audioRecord3 = audioRecord;
                                        th.printStackTrace();
                                        if (audioRecord3 != null) {
                                        }
                                        i9 = i2 + 1;
                                        s2 = s;
                                        length3 = i3;
                                        iArr2 = iArr;
                                        sArr3 = sArr;
                                        i8 = i4;
                                    }
                                    if (audioRecord3.getState() == 1) {
                                        this.a = i7;
                                        s = s4;
                                        try {
                                            this.f3720b = s;
                                            this.f3721c = s3;
                                            if (audioRecord3.getState() != 1) {
                                                audioRecord3.release();
                                            }
                                            return audioRecord3;
                                        } catch (Throwable th9) {
                                            th = th9;
                                        }
                                    } else {
                                        s = s4;
                                        if (audioRecord3.getState() == 1) {
                                        }
                                        audioRecord3.release();
                                        audioRecord3 = null;
                                    }
                                }
                                th.printStackTrace();
                                if (audioRecord3 != null) {
                                    if (audioRecord3.getState() == i5) {
                                    }
                                    audioRecord3.release();
                                    audioRecord3 = null;
                                }
                            } catch (Throwable th10) {
                                if (audioRecord3 != null && audioRecord3.getState() != i5) {
                                    audioRecord3.release();
                                }
                                throw th10;
                            }
                        }
                        i9 = i2 + 1;
                        s2 = s;
                        length3 = i3;
                        iArr2 = iArr;
                        sArr3 = sArr;
                        i8 = i4;
                    }
                    i8++;
                    audioRecord2 = audioRecord3;
                }
            }
            throw new IllegalArgumentException("getInstance() failed : no suitable audio configurations on this device.");
        }
        return (AudioRecord) invokeV.objValue;
    }
}
