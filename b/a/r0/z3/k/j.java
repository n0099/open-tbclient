package b.a.r0.z3.k;

import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.rtc.record.MediaEncodeParams;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.PrintStream;
import java.lang.reflect.Array;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.util.Random;
import kotlin.jvm.internal.ByteCompanionObject;
import org.apache.commons.lang3.StringUtils;
/* loaded from: classes6.dex */
public class j {
    public static /* synthetic */ Interceptable $ic;
    public static final int[] q;
    public static final int[] r;
    public static final int[] s;
    public static final double[][] t;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public ByteOrder f28494a;

    /* renamed from: b  reason: collision with root package name */
    public k f28495b;

    /* renamed from: c  reason: collision with root package name */
    public double f28496c;

    /* renamed from: d  reason: collision with root package name */
    public double f28497d;

    /* renamed from: e  reason: collision with root package name */
    public int f28498e;

    /* renamed from: f  reason: collision with root package name */
    public double[][] f28499f;

    /* renamed from: g  reason: collision with root package name */
    public int f28500g;

    /* renamed from: h  reason: collision with root package name */
    public int f28501h;

    /* renamed from: i  reason: collision with root package name */
    public int f28502i;
    public int j;
    public double[] k;
    public int l;
    public boolean m;
    public int n;
    public long o;
    public long p;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1707928001, "Lb/a/r0/z3/k/j;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1707928001, "Lb/a/r0/z3/k/j;");
                return;
            }
        }
        q = new int[]{0, MediaEncodeParams.AUDIO_SAMPLE_RATE, 44100, 37800, 32000, 22050, MediaEncodeParams.AUDIO_SAMPLE_RATE, 44100};
        r = new int[]{1, 16, 20, 16, 16, 15, 16, 15};
        s = new int[]{8, 18, 27, 8, 8, 8, 10, 9};
        t = new double[][]{new double[]{-1.0d}, new double[]{-2.87207293510437d, 5.041323184967041d, -6.244299411773682d, 5.848398685455322d, -3.706754207611084d, 1.0495119094848633d, 1.1830236911773682d, -2.1126792430877686d, 1.9094531536102295d, -0.9991308450698853d, 0.17090806365013123d, 0.32615602016448975d, -0.39127644896507263d, 0.2687646150588989d, -0.0976761057972908d, 0.023473845794796944d}, new double[]{-2.6773197650909424d, 4.830892562866211d, -6.570110321044922d, 7.4572014808654785d, -6.726327419281006d, 4.848165035247803d, -2.0412089824676514d, -0.7006359100341797d, 2.95375657081604d, -4.080038547515869d, 4.184521675109863d, -3.331181287765503d, 2.117992639541626d, -0.879302978515625d, 0.031759146600961685d, 0.4238278865814209d, -0.4788210391998291d, 0.35490813851356506d, -0.1749683916568756d, 0.06090816855430603d}, new double[]{-1.6335992813110352d, 2.261549234390259d, -2.407702922821045d, 2.634171724319458d, -2.144036293029785d, 1.8153258562088013d, -1.0816224813461304d, 0.703026533126831d, -0.15991993248462677d, -0.04154951870441437d, 0.2941657602787018d, -0.25183168053627014d, 0.27766478061676025d, -0.15785403549671173d, 0.10165894031524658d, -0.016833892092108727d}, new double[]{-0.8290129899978638d, 0.9892265796661377d, -0.5982571244239807d, 1.0028809309005737d, -0.5993821620941162d, 0.7950245141983032d, -0.42723315954208374d, 0.5449252724647522d, -0.3079260587692261d, 0.3687179982662201d, -0.187920480966568d, 0.2261127084493637d, -0.10573341697454453d, 0.11435490846633911d, -0.0388006791472435d, 0.040842197835445404d}, new double[]{-0.06522997468709946d, 0.5498126149177551d, 0.4027854800224304d, 0.3178376853466034d, 0.2820179760456085d, 0.16985194385051727d, 0.15433363616466522d, 0.12507140636444092d, 0.08903945237398148d, 0.06441012024879456d, 0.04714600369334221d, 0.03280523791909218d, 0.028495194390416145d, 0.011695005930960178d, 0.011831838637590408d}, new double[]{-2.3925774097442627d, 3.4350297451019287d, -3.185370922088623d, 1.8117271661758423d, 0.2012477070093155d, -1.4759907722473145d, 1.7210904359817505d, -0.9774670004844666d, 0.13790138065814972d, 0.38185903429985046d, -0.27421241998672485d, -0.06658421456813812d, 0.35223302245140076d, -0.37672343850135803d, 0.23964276909828186d, -0.06867482513189316d}, new double[]{-2.0833916664123535d, 3.0418450832366943d, -3.204789876937866d, 2.757192611694336d, -1.4978630542755127d, 0.34275946021080017d, 0.7173374891281128d, -1.073705792427063d, 1.0225815773010254d, -0.5664999485015869d, 0.20968692004680634d, 0.06537853181362152d, -0.10322438180446625d, 0.06744202226400375d, 0.00495197344571352d}};
    }

    /* JADX WARN: Removed duplicated region for block: B:29:0x007b  */
    /* JADX WARN: Removed duplicated region for block: B:31:0x007e  */
    /* JADX WARN: Removed duplicated region for block: B:37:0x008d  */
    /* JADX WARN: Removed duplicated region for block: B:40:0x0095  */
    /* JADX WARN: Removed duplicated region for block: B:45:0x0164  */
    /* JADX WARN: Removed duplicated region for block: B:47:0x0169  */
    /* JADX WARN: Removed duplicated region for block: B:61:0x01b6  */
    /* JADX WARN: Removed duplicated region for block: B:64:0x01c8  */
    /* JADX WARN: Removed duplicated region for block: B:66:0x01f9  */
    /* JADX WARN: Removed duplicated region for block: B:72:0x0255  */
    /* JADX WARN: Removed duplicated region for block: B:74:0x0260  */
    /* JADX WARN: Removed duplicated region for block: B:77:0x026d  */
    /* JADX WARN: Removed duplicated region for block: B:87:? A[ADDED_TO_REGION, RETURN, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public j(InputStream inputStream, OutputStream outputStream, int i2, int i3, int i4, int i5, int i6, int i7, double d2, int i8, boolean z) throws Exception {
        int i9;
        int i10;
        boolean z2;
        int i11;
        double[] dArr;
        double d3;
        int i12;
        String str;
        int i13;
        double[] dArr2;
        int i14;
        int i15;
        j jVar;
        int i16;
        int i17;
        int i18;
        int i19;
        int i20;
        int i21;
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r4;
            Object[] objArr = {inputStream, outputStream, Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(i4), Integer.valueOf(i5), Integer.valueOf(i6), Integer.valueOf(i7), Double.valueOf(d2), Integer.valueOf(i8), Boolean.valueOf(z)};
            interceptable.invokeUnInit(65537, newInitContext);
            int i22 = newInitContext.flag;
            if ((i22 & 1) != 0) {
                int i23 = i22 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.f28494a = ByteOrder.LITTLE_ENDIAN;
        this.f28495b = new k();
        this.f28496c = 150.0d;
        this.f28497d = 200.0d;
        this.f28498e = 1;
        this.m = false;
        double[] dArr3 = {0.0d};
        if (i8 >= 0 && i8 <= 4) {
            this.m = z;
            if (!z) {
                System.err.printf("Shibatch sampling rate converter version 1.30(high precision/nio)\n\n", new Object[0]);
            }
            if (i4 != 1 && i4 != 2 && i4 != 3 && i4 != 4) {
                throw new IllegalStateException("Error : Only 8bit, 16bit, 24bit and 32bit PCM are supported.");
            }
            int i24 = i5;
            if (i24 == -1) {
                i24 = i4 != 1 ? i4 : 2;
                if (i24 == 4) {
                    i9 = i3;
                    i24 = 3;
                    i9 = i9 == -1 ? i2 : i9;
                    i10 = i8 != -1 ? i24 < i4 ? i24 == 1 ? 4 : 3 : 1 : i8;
                    z2 = this.m;
                    String str2 = StringUtils.LF;
                    if (z2) {
                        String[] strArr = {"none", "no noise shaping", "triangular spectral shape", "ATH based noise shaping", "ATH based noise shaping(less amplitude)"};
                        String[] strArr2 = {"rectangular", "triangular", "gaussian"};
                        dArr = dArr3;
                        System.err.printf("frequency : %d -> %d\n", Integer.valueOf(i2), Integer.valueOf(i9));
                        System.err.printf("attenuation : %gdB\n", Double.valueOf(d2));
                        System.err.printf("bits per sample : %d -> %d\n", Integer.valueOf(i4 * 8), Integer.valueOf(i24 * 8));
                        System.err.printf("nchannels : %d\n", Integer.valueOf(i6));
                        i11 = i24;
                        System.err.printf("length : %d bytes, %g secs\n", Integer.valueOf(i7), Double.valueOf(((i7 / i4) / i6) / i2));
                        if (i10 == 0) {
                            i21 = 0;
                            System.err.printf("dither type : none\n", new Object[0]);
                        } else {
                            i21 = 0;
                            System.err.printf("dither type : %s, %s p.d.f, amp = %g\n", strArr[i10], strArr2[0], Double.valueOf(0.18d));
                        }
                        str2 = StringUtils.LF;
                        System.err.printf(str2, new Object[i21]);
                    } else {
                        i11 = i24;
                        dArr = dArr3;
                    }
                    if (i10 == 0) {
                        int i25 = i11;
                        if (i25 == 1) {
                            i18 = com.alipay.sdk.encrypt.a.f34123g;
                            i16 = 127;
                            i17 = 2;
                        } else {
                            i16 = 0;
                            i17 = 2;
                            i18 = 0;
                        }
                        if (i25 == i17) {
                            i18 = -32768;
                            i16 = 32767;
                        }
                        if (i25 == 3) {
                            i18 = -8388608;
                            i16 = 8388607;
                        }
                        if (i25 == 4) {
                            i20 = Integer.MIN_VALUE;
                            i19 = Integer.MAX_VALUE;
                        } else {
                            i19 = i16;
                            i20 = i18;
                        }
                        str = str2;
                        i13 = i25;
                        dArr2 = dArr;
                        d3 = d2;
                        i12 = i9;
                        h(i9, i6, i20, i19, i10, 0, 0.18d);
                    } else {
                        d3 = d2;
                        i12 = i9;
                        str = str2;
                        i13 = i11;
                        dArr2 = dArr;
                    }
                    if (i2 >= i12) {
                        int i26 = i12;
                        i14 = i6;
                        dArr2[0] = n(inputStream, outputStream, i6, i4, i13, i2, i26, Math.pow(10.0d, (-d3) / 20.0d), (i7 / i4) / i14, false, i10);
                    } else {
                        int i27 = i12;
                        i14 = i6;
                        if (i2 > i27) {
                            dArr2[0] = d(inputStream, outputStream, i6, i4, i13, i2, i27, Math.pow(10.0d, (-d3) / 20.0d), (i7 / i4) / i14, false, i10);
                        } else {
                            i15 = 0;
                            dArr2[0] = i(inputStream, outputStream, i6, i4, i13, Math.pow(10.0d, (-d3) / 20.0d), (i7 / i4) / i14, false, i10);
                            jVar = this;
                            if (!jVar.m) {
                                System.err.printf(str, new Object[i15]);
                            }
                            if (i10 != 0) {
                                jVar.j(i14);
                            }
                            if (dArr2[i15] <= 1.0d || jVar.m) {
                                return;
                            }
                            PrintStream printStream = System.err;
                            Object[] objArr2 = new Object[1];
                            objArr2[i15] = Double.valueOf(Math.log10(dArr2[i15]) * 20.0d);
                            printStream.printf("clipping detected : %gdB\n", objArr2);
                            return;
                        }
                    }
                    jVar = this;
                    i15 = 0;
                    if (!jVar.m) {
                    }
                    if (i10 != 0) {
                    }
                    if (dArr2[i15] <= 1.0d) {
                        return;
                    }
                    return;
                }
            }
            i9 = i3;
            if (i9 == -1) {
            }
            if (i8 != -1) {
            }
            z2 = this.m;
            String str22 = StringUtils.LF;
            if (z2) {
            }
            if (i10 == 0) {
            }
            if (i2 >= i12) {
            }
            jVar = this;
            i15 = 0;
            if (!jVar.m) {
            }
            if (i10 != 0) {
            }
            if (dArr2[i15] <= 1.0d) {
            }
        } else {
            throw new IllegalArgumentException("unrecognized dither type : " + i8);
        }
    }

    public final int a(double d2) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048576, this, new Object[]{Double.valueOf(d2)})) == null) {
            return (int) (d2 >= 0.0d ? d2 + 0.5d : d2 - 0.5d);
        }
        return invokeCommon.intValue;
    }

    public final double b(double d2) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, new Object[]{Double.valueOf(d2)})) == null) {
            if (d2 <= 21.0d) {
                return 0.0d;
            }
            if (d2 <= 50.0d) {
                double d3 = d2 - 21.0d;
                return (Math.pow(d3, 0.4d) * 0.5842d) + (d3 * 0.07886d);
            }
            return (d2 - 8.7d) * 0.1102d;
        }
        return invokeCommon.doubleValue;
    }

    public int c(double d2, double[] dArr, int i2, int i3) {
        InterceptResult invokeCommon;
        int i4;
        double a2;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(Constants.METHOD_SEND_USER_MSG, this, new Object[]{Double.valueOf(d2), dArr, Integer.valueOf(i2), Integer.valueOf(i3)})) == null) {
            if (i2 == 1) {
                double[] dArr2 = this.k;
                int i5 = this.l;
                this.l = i5 + 1;
                double d3 = d2 + dArr2[i5 & 65535];
                int i6 = this.f28502i;
                if (d3 < i6) {
                    double d4 = d3 / i6;
                    if (dArr[0] >= d4) {
                        d4 = dArr[0];
                    }
                    dArr[0] = d4;
                    d3 = this.f28502i;
                }
                int i7 = this.j;
                if (d3 > i7) {
                    double d5 = d3 / i7;
                    if (dArr[0] >= d5) {
                        d5 = dArr[0];
                    }
                    dArr[0] = d5;
                    d3 = this.j;
                }
                return a(d3);
            }
            double d6 = 0.0d;
            int i8 = 0;
            while (true) {
                i4 = this.f28501h;
                if (i8 >= i4) {
                    break;
                }
                d6 += t[this.f28500g][i8] * this.f28499f[i3][i8];
                i8++;
            }
            double d7 = d2 + d6;
            double[] dArr3 = this.k;
            int i9 = this.l;
            this.l = i9 + 1;
            double d8 = dArr3[65535 & i9] + d7;
            for (int i10 = i4 - 2; i10 >= 0; i10--) {
                double[][] dArr4 = this.f28499f;
                dArr4[i3][i10 + 1] = dArr4[i3][i10];
            }
            int i11 = this.f28502i;
            if (d8 < i11) {
                double d9 = d8 / i11;
                if (dArr[0] >= d9) {
                    d9 = dArr[0];
                }
                dArr[0] = d9;
                a2 = this.f28502i;
                double[][] dArr5 = this.f28499f;
                dArr5[i3][0] = a2 - d7;
                if (dArr5[i3][0] > 1.0d) {
                    dArr5[i3][0] = 1.0d;
                }
                double[][] dArr6 = this.f28499f;
                if (dArr6[i3][0] < -1.0d) {
                    dArr6[i3][0] = -1.0d;
                }
            } else {
                int i12 = this.j;
                if (d8 > i12) {
                    double d10 = d8 / i12;
                    if (dArr[0] >= d10) {
                        d10 = dArr[0];
                    }
                    dArr[0] = d10;
                    a2 = this.j;
                    double[][] dArr7 = this.f28499f;
                    dArr7[i3][0] = a2 - d7;
                    if (dArr7[i3][0] > 1.0d) {
                        dArr7[i3][0] = 1.0d;
                    }
                    double[][] dArr8 = this.f28499f;
                    if (dArr8[i3][0] < -1.0d) {
                        dArr8[i3][0] = -1.0d;
                    }
                } else {
                    a2 = a(d8);
                    this.f28499f[i3][0] = a2 - d7;
                }
            }
            return (int) a2;
        }
        return invokeCommon.intValue;
    }

    /* JADX WARN: Removed duplicated region for block: B:103:0x0437 A[LOOP:4: B:101:0x0433->B:103:0x0437, LOOP_END] */
    /* JADX WARN: Removed duplicated region for block: B:106:0x0444 A[ADDED_TO_REGION] */
    /* JADX WARN: Removed duplicated region for block: B:112:0x0451  */
    /* JADX WARN: Removed duplicated region for block: B:144:0x0599  */
    /* JADX WARN: Removed duplicated region for block: B:156:0x05c2  */
    /* JADX WARN: Removed duplicated region for block: B:242:0x0815  */
    /* JADX WARN: Removed duplicated region for block: B:252:0x0871  */
    /* JADX WARN: Removed duplicated region for block: B:266:0x08e5  */
    /* JADX WARN: Removed duplicated region for block: B:269:0x08e9 A[LOOP:14: B:268:0x08e7->B:269:0x08e9, LOOP_END] */
    /* JADX WARN: Removed duplicated region for block: B:272:0x090b A[LOOP:15: B:271:0x0909->B:272:0x090b, LOOP_END] */
    /* JADX WARN: Removed duplicated region for block: B:275:0x091c  */
    /* JADX WARN: Removed duplicated region for block: B:276:0x0925  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public double d(InputStream inputStream, OutputStream outputStream, int i2, int i3, int i4, int i5, int i6, double d2, int i7, boolean z, int i8) throws IOException {
        InterceptResult invokeCommon;
        int i9;
        int i10;
        double d3;
        double d4;
        double d5;
        int i11;
        int i12;
        int[] iArr;
        int i13;
        double[] dArr;
        int i14;
        int i15;
        int[] iArr2;
        int i16;
        double[][] dArr2;
        int i17;
        int i18;
        int[] iArr3;
        int i19;
        j jVar;
        int i20;
        double[][] dArr3;
        int i21;
        ByteBuffer byteBuffer;
        double d6;
        int i22;
        int i23;
        ByteBuffer byteBuffer2;
        int i24;
        int i25;
        int i26;
        int i27;
        int i28;
        int i29;
        double[] dArr4;
        int i30;
        double d7;
        ByteBuffer byteBuffer3;
        j jVar2;
        ByteBuffer byteBuffer4;
        int i31;
        int i32;
        int a2;
        char c2;
        int i33;
        int i34;
        ByteBuffer byteBuffer5;
        int a3;
        char c3;
        int i35;
        int i36;
        int i37;
        int i38;
        int i39;
        int i40;
        double[] dArr5;
        int i41;
        double d8;
        ByteBuffer byteBuffer6;
        int i42;
        int a4;
        char c4;
        double[] dArr6;
        int i43;
        int i44;
        int i45;
        int i46;
        int i47;
        int i48;
        int i49;
        int i50;
        int i51;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048579, this, new Object[]{inputStream, outputStream, Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(i4), Integer.valueOf(i5), Integer.valueOf(i6), Double.valueOf(d2), Integer.valueOf(i7), Boolean.valueOf(z), Integer.valueOf(i8)})) == null) {
            int i52 = i6;
            double[] dArr7 = {0.0d};
            int i53 = this.f28498e;
            double d9 = this.f28496c;
            int e2 = e(i5, i52);
            int i54 = i52 / e2;
            if (i54 == 1) {
                i9 = 1;
            } else if (i54 % 2 == 0) {
                i9 = 2;
            } else if (i54 % 3 != 0) {
                throw new IllegalArgumentException(String.format("Resampling from %dHz to %dHz is not supported.\n%d/gcd(%d,%d)=%d must be divided by 2 or 3.", Integer.valueOf(i5), Integer.valueOf(i6), Integer.valueOf(i6), Integer.valueOf(i5), Integer.valueOf(i6), Integer.valueOf(i54)));
            } else {
                i9 = 3;
            }
            int i55 = i5 * i9;
            double d10 = d9 <= 21.0d ? 0.9222d : (d9 - 7.95d) / 14.36d;
            int i56 = 1;
            while (true) {
                int i57 = i53 * i56;
                if (i57 % 2 == 0) {
                    i57--;
                }
                i10 = i57;
                d3 = i55;
                double d11 = (d3 * d10) / (i10 - 1);
                d4 = i52;
                d5 = (d4 - d11) / 2.0d;
                i11 = i9;
                if (d11 < this.f28497d) {
                    break;
                }
                i56 *= 2;
                i52 = i6;
                d9 = d9;
                i9 = i11;
            }
            double b2 = b(d9);
            double a5 = f.a(b2);
            int i58 = 1;
            while (i58 < i10) {
                i58 *= 2;
            }
            int i59 = i58 * 2;
            double[] dArr8 = new double[i59];
            int i60 = i10 / 2;
            int i61 = -i60;
            while (i61 <= i60) {
                int i62 = i61 + i60;
                int i63 = i60;
                int i64 = i61;
                int i65 = i10;
                double[] dArr9 = dArr8;
                int i66 = i10;
                int i67 = i59;
                dArr9[i62] = ((((o(i61, i65, b2, a5) * g(i64, d5, d3)) * d3) / i5) / i67) * 2.0d;
                i61 = i64 + 1;
                i11 = i11;
                i59 = i67;
                dArr7 = dArr7;
                dArr8 = dArr9;
                i60 = i63;
                i10 = i66;
                i55 = i55;
            }
            int i68 = i61;
            double[] dArr10 = dArr8;
            double[] dArr11 = dArr7;
            int i69 = i55;
            int i70 = i10;
            int i71 = i59;
            int i72 = i11;
            int[] iArr4 = new int[(int) (Math.sqrt(i71) + 2.0d)];
            iArr4[0] = 0;
            int i73 = i71 / 2;
            double[] dArr12 = new double[i73];
            this.f28495b.B(i71, 1, dArr10, iArr4, dArr12);
            if (i72 == 1) {
                int i74 = (i5 / e2) * i52;
                int[] iArr5 = {i5 / i52};
                double[][] dArr13 = (double[][]) Array.newInstance(double.class, 1, 1);
                dArr13[0][0] = 1.0d;
                dArr = dArr12;
                iArr3 = new int[]{0};
                iArr = iArr4;
                i14 = i73;
                i13 = i71;
                i18 = 1;
                i16 = 1;
                dArr2 = dArr13;
                iArr2 = iArr5;
                i17 = i74;
                i19 = i68;
                i15 = 1;
            } else {
                double d12 = this.f28496c;
                int i75 = (i5 / e2) * i52;
                int i76 = i5 / 2;
                double[] dArr14 = dArr12;
                iArr = iArr4;
                int i77 = i73;
                i13 = i71;
                double d13 = (((i69 / 2) - i76) / 2.0d) + i76;
                double d14 = i75;
                int i78 = (int) (((d14 / ((i12 * 2) / 2.0d)) * (d12 > 21.0d ? (d12 - 7.95d) / 14.36d : 0.9222d)) + 1.0d);
                if (i78 % 2 == 0) {
                    i78++;
                }
                int i79 = i78;
                double b3 = b(d12);
                double a6 = f.a(b3);
                int i80 = i75 / i69;
                int i81 = (i79 / i80) + 1;
                int[] iArr6 = new int[i80];
                for (int i82 = 0; i82 < i80; i82++) {
                    iArr6[i82] = i80 - (((i75 / i52) * i82) % i80);
                    if (iArr6[i82] == i80) {
                        iArr6[i82] = 0;
                    }
                }
                int[] iArr7 = new int[i80];
                int i83 = 0;
                while (i83 < i80) {
                    iArr7[i83] = (((i75 / i52) - iArr6[i83]) / i80) + 1;
                    int i84 = i83 + 1;
                    if (iArr6[i84 == i80 ? 0 : i84] == 0) {
                        iArr7[i83] = iArr7[i83] - 1;
                    }
                    i83 = i84;
                }
                double[][] dArr15 = (double[][]) Array.newInstance(double.class, i80, i81);
                int i85 = i79 / 2;
                int i86 = -i85;
                while (i86 <= i85) {
                    int i87 = i86 + i85;
                    int i88 = i86;
                    double d15 = d14;
                    dArr15[i87 % i80][i87 / i80] = ((o(i86, i79, b3, a6) * g(i88, d13, d15)) * d15) / d3;
                    i86 = i88 + 1;
                    iArr7 = iArr7;
                    i85 = i85;
                    i75 = i75;
                    i80 = i80;
                    dArr14 = dArr14;
                    iArr6 = iArr6;
                    d14 = d15;
                    i77 = i77;
                }
                int i89 = i86;
                int[] iArr8 = iArr6;
                dArr = dArr14;
                i14 = i77;
                int i90 = i75;
                int i91 = i80;
                i15 = i79;
                iArr2 = iArr7;
                i16 = i81;
                dArr2 = dArr15;
                i17 = i90;
                i18 = i91;
                iArr3 = iArr8;
                i19 = i89;
            }
            k();
            double[][] dArr16 = (double[][]) Array.newInstance(double.class, i2, i13);
            int i92 = i16 + 1;
            int i93 = i92 + i14;
            int i94 = i19;
            double[][] dArr17 = (double[][]) Array.newInstance(double.class, i2, i93);
            int i95 = ((i14 / i72) + i72 + 1) * i2;
            int i96 = i3;
            ByteBuffer allocate = ByteBuffer.allocate(i95 * i96);
            int i97 = i16;
            double[][] dArr18 = dArr2;
            int i98 = i92;
            int i99 = i18;
            double d16 = i5;
            double d17 = d16;
            double d18 = ((i14 * d4) / d16) + 1.0d;
            int i100 = i4 * i2;
            int[] iArr9 = iArr2;
            double d19 = i100;
            int[] iArr10 = iArr3;
            int i101 = i14;
            ByteBuffer allocate2 = ByteBuffer.allocate((int) (d18 * d19));
            double[] dArr19 = new double[i95];
            double d20 = d19;
            double[] dArr20 = new double[(int) (i2 * d18)];
            int i102 = i100;
            int i103 = (int) (((i70 / 2.0d) / (d3 / d4)) + ((i15 / 2.0d) / (i17 / d4)));
            int i104 = i94;
            ByteBuffer byteBuffer7 = allocate;
            int i105 = 0;
            int i106 = 0;
            int i107 = 0;
            int i108 = 0;
            int i109 = 0;
            boolean z2 = true;
            int i110 = i7;
            int i111 = 0;
            while (true) {
                int i112 = (((i101 + 0) - 1) / i72) + 1;
                int i113 = i104;
                if (i112 + i105 > i110) {
                    i112 = i110 - i105;
                }
                byteBuffer7.position(0);
                int i114 = i96 * i2;
                int i115 = i110;
                byteBuffer7.limit(i114 * i112);
                byte[] bArr = new byte[byteBuffer7.limit()];
                int i116 = i103;
                int read = inputStream.read(bArr);
                int i117 = i106;
                int i118 = read < 0 ? 0 : read;
                int i119 = i118 < byteBuffer7.limit() ? ((i118 / i96) * i2) + i105 : i115;
                byteBuffer7.limit(i118);
                ByteBuffer wrap = ByteBuffer.wrap(bArr);
                wrap.position(i118);
                wrap.flip();
                int i120 = i118 / i114;
                if (i96 == 1) {
                    jVar = this;
                    i20 = i107;
                    dArr3 = dArr17;
                    i21 = i17;
                    byteBuffer = allocate2;
                    d6 = d20;
                    i22 = i72;
                    i23 = 0;
                    while (i23 < i120 * i2) {
                        dArr19[(i2 * 0) + i23] = ((wrap.get(i23) & 255) + com.alipay.sdk.encrypt.a.f34123g) * 0.007874015748031496d;
                        i23++;
                        wrap = wrap;
                    }
                } else if (i96 != 2) {
                    if (i96 == 3) {
                        jVar = this;
                        i21 = i17;
                        byteBuffer = allocate2;
                        d6 = d20;
                        i23 = 0;
                        while (i23 < i120 * i2) {
                            int i121 = i23 * 3;
                            dArr19[(i2 * 0) + i23] = (((wrap.get(i121 + 1) & 255) << 8) | ((wrap.get(i121) & 255) << 0) | ((wrap.get(i121 + 2) & 255) << 16)) * 1.1920930376163766E-7d;
                            i23++;
                            i72 = i72;
                            i107 = i107;
                        }
                        i20 = i107;
                        i22 = i72;
                        byteBuffer2 = wrap;
                    } else if (i96 != 4) {
                        jVar = this;
                        byteBuffer2 = wrap;
                        i20 = i107;
                        dArr3 = dArr17;
                        i21 = i17;
                        byteBuffer = allocate2;
                        d6 = d20;
                        i23 = i113;
                        i22 = i72;
                        while (i23 < i2 * i112) {
                            dArr19[i23] = 0.0d;
                            i23++;
                        }
                        int i122 = i105 + i120;
                        boolean z3 = inputStream.available() >= 0 || i122 >= i119;
                        int i123 = i109;
                        int i124 = i117;
                        i24 = 0;
                        while (i24 < i2) {
                            int i125 = i101;
                            int i126 = 0;
                            int i127 = 0;
                            while (i126 < i125) {
                                dArr16[i24][i126] = dArr19[(i127 * i2) + i24];
                                int i128 = i126 + 1;
                                while (true) {
                                    i51 = i126 + i22;
                                    if (i128 < i51) {
                                        dArr16[i24][i128] = 0.0d;
                                        i128++;
                                    }
                                }
                                i127++;
                                i126 = i51;
                            }
                            int i129 = i13;
                            for (int i130 = i125; i130 < i129; i130++) {
                                dArr16[i24][i130] = 0.0d;
                            }
                            jVar.f28495b.B(i129, 1, dArr16[i24], iArr, dArr);
                            dArr16[i24][0] = dArr10[0] * dArr16[i24][0];
                            dArr16[i24][1] = dArr10[1] * dArr16[i24][1];
                            for (int i131 = 1; i131 < i125; i131++) {
                                int i132 = i131 * 2;
                                int i133 = i132 + 1;
                                dArr16[i24][i132] = (dArr10[i132] * dArr16[i24][i132]) - (dArr10[i133] * dArr16[i24][i133]);
                                dArr16[i24][i133] = (dArr10[i133] * dArr16[i24][i132]) + (dArr10[i132] * dArr16[i24][i133]);
                            }
                            jVar.f28495b.B(i129, -1, dArr16[i24], iArr, dArr);
                            int i134 = 0;
                            while (i134 < i125) {
                                double[] dArr21 = dArr3[i24];
                                int i135 = i98 + i134;
                                dArr21[i135] = dArr21[i135] + dArr16[i24][i134];
                                i134++;
                            }
                            int i136 = i21 / i69;
                            int i137 = i108 / i136;
                            if (i108 % i136 != 0) {
                                i137++;
                            }
                            int length = (dArr3[0].length * i24) + i137;
                            int i138 = i134;
                            int i139 = i117;
                            int i140 = 0;
                            for (char c5 = 0; length - (dArr3[c5].length * i24) < i125 + 1; c5 = 0) {
                                int i141 = iArr10[i139];
                                int i142 = iArr9[i139] + length;
                                i139++;
                                int i143 = i129;
                                int i144 = i99;
                                if (i139 == i144) {
                                    i139 = 0;
                                }
                                i99 = i144;
                                double d21 = 0.0d;
                                int i145 = i97;
                                int i146 = 0;
                                while (i146 < i145) {
                                    d21 += dArr18[i141][i146] * dArr3[length / dArr3[0].length][length % dArr3[0].length];
                                    length++;
                                    i146++;
                                    i141 = i141;
                                    i139 = i139;
                                }
                                dArr20[0 + (i140 * i2) + i24] = d21;
                                i140++;
                                i138 = i146;
                                i97 = i145;
                                length = i142;
                                i129 = i143;
                            }
                            i13 = i129;
                            i24++;
                            jVar = this;
                            i124 = i139;
                            i101 = i125;
                            i123 = i140;
                            i23 = i138;
                        }
                        int i147 = i97;
                        int i148 = i101;
                        int i149 = i108 + ((i21 / i6) * i123);
                        byteBuffer.clear();
                        if (z) {
                            i23 = 0;
                            while (i23 < i123 * i2) {
                                double d22 = dArr20[i23] > 0.0d ? dArr20[i23] : -dArr20[i23];
                                if (dArr11[0] >= d22) {
                                    d22 = dArr11[0];
                                }
                                dArr11[0] = d22;
                                byteBuffer.asDoubleBuffer().put(i23, dArr20[i23]);
                                i23++;
                            }
                        } else {
                            if (i4 == 1) {
                                i25 = i102;
                                i26 = i148;
                                i27 = i147;
                                i28 = i124;
                                i29 = i22;
                                dArr4 = dArr19;
                                i30 = i99;
                                d7 = d17;
                                byteBuffer3 = byteBuffer;
                                jVar2 = this;
                                int i150 = i98;
                                byteBuffer4 = byteBuffer2;
                                i31 = i150;
                                double d23 = d2 * 127.0d;
                                i32 = 0;
                                int i151 = 0;
                                while (i32 < i123 * i2) {
                                    if (i8 != 0) {
                                        a2 = c(dArr20[i32] * d23, dArr11, i8, i151);
                                    } else {
                                        a2 = jVar2.a(dArr20[i32] * d23);
                                        if (a2 < -128) {
                                            double d24 = a2 / (-128.0d);
                                            c2 = 0;
                                            if (dArr11[0] >= d24) {
                                                d24 = dArr11[0];
                                            }
                                            dArr11[0] = d24;
                                            a2 = com.alipay.sdk.encrypt.a.f34123g;
                                        } else {
                                            c2 = 0;
                                        }
                                        if (127 < a2) {
                                            double d25 = a2 / 127.0d;
                                            if (dArr11[c2] >= d25) {
                                                d25 = dArr11[c2];
                                            }
                                            dArr11[c2] = d25;
                                            a2 = 127;
                                        }
                                    }
                                    byteBuffer3.put(i32, (byte) (a2 + 128));
                                    int i152 = i151 + 1;
                                    i151 = i152 == i2 ? 0 : i152;
                                    i32++;
                                }
                            } else if (i4 == 2) {
                                i25 = i102;
                                i26 = i148;
                                i27 = i147;
                                i28 = i124;
                                i29 = i22;
                                dArr4 = dArr19;
                                i30 = i99;
                                d7 = d17;
                                ByteBuffer byteBuffer8 = byteBuffer;
                                jVar2 = this;
                                int i153 = i98;
                                byteBuffer4 = byteBuffer2;
                                i31 = i153;
                                double d26 = d2 * 32767.0d;
                                int i154 = 0;
                                int i155 = 0;
                                while (i154 < i123 * i2) {
                                    if (i8 != 0) {
                                        i34 = i154;
                                        byteBuffer5 = byteBuffer8;
                                        a3 = c(dArr20[i154] * d26, dArr11, i8, i155);
                                    } else {
                                        i34 = i154;
                                        byteBuffer5 = byteBuffer8;
                                        a3 = jVar2.a(dArr20[i34] * d26);
                                        if (a3 < -32768) {
                                            double d27 = a3 / (-32768.0d);
                                            c3 = 0;
                                            if (dArr11[0] >= d27) {
                                                d27 = dArr11[0];
                                            }
                                            dArr11[0] = d27;
                                            a3 = -32768;
                                        } else {
                                            c3 = 0;
                                        }
                                        if (32767 < a3) {
                                            double d28 = a3 / 32767.0d;
                                            if (dArr11[c3] >= d28) {
                                                d28 = dArr11[c3];
                                            }
                                            dArr11[c3] = d28;
                                            a3 = 32767;
                                        }
                                    }
                                    byteBuffer5.order(jVar2.f28494a).asShortBuffer().put(i34, (short) a3);
                                    int i156 = i155 + 1;
                                    i155 = i156 == i2 ? 0 : i156;
                                    i154 = i34 + 1;
                                    byteBuffer8 = byteBuffer5;
                                }
                                i32 = i154;
                                byteBuffer3 = byteBuffer8;
                            } else if (i4 == 3) {
                                double d29 = d2 * 8388607.0d;
                                int i157 = 0;
                                int i158 = 0;
                                while (i157 < i123 * i2) {
                                    if (i8 != 0) {
                                        i36 = i157;
                                        i39 = i124;
                                        i40 = i22;
                                        dArr5 = dArr19;
                                        d8 = d17;
                                        int i159 = i98;
                                        byteBuffer6 = byteBuffer2;
                                        i42 = i159;
                                        i35 = i102;
                                        i37 = i148;
                                        i41 = i99;
                                        i38 = i147;
                                        a4 = c(dArr20[i157] * d29, dArr11, i8, i158);
                                    } else {
                                        i35 = i102;
                                        i36 = i157;
                                        i37 = i148;
                                        i38 = i147;
                                        i39 = i124;
                                        i40 = i22;
                                        dArr5 = dArr19;
                                        i41 = i99;
                                        d8 = d17;
                                        int i160 = i98;
                                        byteBuffer6 = byteBuffer2;
                                        i42 = i160;
                                        a4 = a(dArr20[i36] * d29);
                                        if (a4 < -8388608) {
                                            double d30 = a4 / (-8388608.0d);
                                            c4 = 0;
                                            if (dArr11[0] >= d30) {
                                                d30 = dArr11[0];
                                            }
                                            dArr11[0] = d30;
                                            a4 = -8388608;
                                        } else {
                                            c4 = 0;
                                        }
                                        if (8388607 < a4) {
                                            double d31 = a4 / 8388607.0d;
                                            if (dArr11[c4] >= d31) {
                                                d31 = dArr11[c4];
                                            }
                                            dArr11[c4] = d31;
                                            a4 = 8388607;
                                        }
                                    }
                                    int i161 = i36 * 3;
                                    ByteBuffer byteBuffer9 = byteBuffer;
                                    byteBuffer9.put(i161, (byte) (a4 & 255));
                                    int i162 = a4 >> 8;
                                    byteBuffer9.put(i161 + 1, (byte) (i162 & 255));
                                    byteBuffer9.put(i161 + 2, (byte) ((i162 >> 8) & 255));
                                    int i163 = i158 + 1;
                                    i158 = i163 == i2 ? 0 : i163;
                                    i157 = i36 + 1;
                                    byteBuffer = byteBuffer9;
                                    i124 = i39;
                                    d17 = d8;
                                    dArr19 = dArr5;
                                    i22 = i40;
                                    i102 = i35;
                                    i99 = i41;
                                    i147 = i38;
                                    i148 = i37;
                                    ByteBuffer byteBuffer10 = byteBuffer6;
                                    i98 = i42;
                                    byteBuffer2 = byteBuffer10;
                                }
                                i25 = i102;
                                i26 = i148;
                                i27 = i147;
                                i28 = i124;
                                i29 = i22;
                                dArr4 = dArr19;
                                i30 = i99;
                                d7 = d17;
                                jVar2 = this;
                                int i164 = i98;
                                byteBuffer4 = byteBuffer2;
                                i31 = i164;
                                i33 = i157;
                                byteBuffer3 = byteBuffer;
                                if (z2) {
                                    dArr6 = dArr20;
                                    i43 = i119;
                                    i44 = i20;
                                    if (i123 < i116) {
                                        i103 = i116 - i123;
                                    } else if (z3) {
                                        double d32 = (i122 * d4) / d7;
                                        if (d32 + 2.0d > (i44 + i123) - i116) {
                                            byteBuffer3.position(i25 * i116);
                                            int i165 = i123 - i116;
                                            byteBuffer3.limit(i25 * i165);
                                            jVar2.p(outputStream, byteBuffer3);
                                            i44 += i165;
                                            i103 = i116;
                                        } else {
                                            byteBuffer3.position(i25 * i116);
                                            byteBuffer3.limit((int) (d6 * ((((Math.floor(d32) + 2.0d) + i44) + i123) - i116)));
                                            jVar2.p(outputStream, byteBuffer3);
                                            break;
                                        }
                                    } else {
                                        byteBuffer3.position(i25 * i116);
                                        byteBuffer3.limit(i25 * i123);
                                        jVar2.p(outputStream, byteBuffer3);
                                        i44 += i123 - i116;
                                        i103 = i116;
                                        z2 = false;
                                    }
                                } else {
                                    if (z3) {
                                        double d33 = (i122 * d4) / d7;
                                        i50 = i20 + i123;
                                        dArr6 = dArr20;
                                        i43 = i119;
                                        if (d33 + 2.0d > i50) {
                                            byteBuffer3.position(0);
                                            byteBuffer3.limit(i25 * i123);
                                            jVar2.p(outputStream, byteBuffer3);
                                        } else {
                                            byteBuffer3.position(0);
                                            int floor = (int) (d6 * ((Math.floor(d33) + 2.0d) - i20));
                                            if (floor > 0) {
                                                byteBuffer3.limit(floor);
                                                jVar2.p(outputStream, byteBuffer3);
                                            }
                                        }
                                    } else {
                                        dArr6 = dArr20;
                                        i43 = i119;
                                        byteBuffer3.position(0);
                                        byteBuffer3.limit(i25 * i123);
                                        jVar2.p(outputStream, byteBuffer3);
                                        i50 = i20 + i123;
                                    }
                                    i44 = i50;
                                    i103 = i116;
                                }
                                int i166 = i21 / i69;
                                i45 = (i149 - 1) / i166;
                                i46 = i26;
                                if (i45 > i46) {
                                    i45 = i46;
                                }
                                i47 = 0;
                                while (i47 < i2) {
                                    System.arraycopy(dArr3[i47], i45, dArr3[i47], 0, i93 - i45);
                                    i47++;
                                    i33 = i33;
                                    i44 = i44;
                                }
                                int i167 = i33;
                                int i168 = i44;
                                i108 = i149 - (i45 * i166);
                                for (i48 = 0; i48 < i2; i48++) {
                                    System.arraycopy(dArr16[i48], i46, dArr3[i48], i31, i46);
                                }
                                int i169 = i111 + 1;
                                if ((i111 & 7) == 7) {
                                    i49 = i43;
                                    jVar2.l(i122 / i49);
                                } else {
                                    i49 = i43;
                                }
                                i104 = i167;
                                i110 = i49;
                                i111 = i169;
                                i105 = i122;
                                i101 = i46;
                                dArr20 = dArr6;
                                allocate2 = byteBuffer3;
                                i107 = i168;
                                i106 = i28;
                                byteBuffer7 = byteBuffer4;
                                d17 = d7;
                                dArr19 = dArr4;
                                i72 = i29;
                                i102 = i25;
                                i99 = i30;
                                i97 = i27;
                                d20 = d6;
                                dArr17 = dArr3;
                                i109 = i123;
                                i98 = i31;
                                i17 = i21;
                                i96 = i3;
                            }
                            i33 = i32;
                            if (z2) {
                            }
                            int i1662 = i21 / i69;
                            i45 = (i149 - 1) / i1662;
                            i46 = i26;
                            if (i45 > i46) {
                            }
                            i47 = 0;
                            while (i47 < i2) {
                            }
                            int i1672 = i33;
                            int i1682 = i44;
                            i108 = i149 - (i45 * i1662);
                            while (i48 < i2) {
                            }
                            int i1692 = i111 + 1;
                            if ((i111 & 7) == 7) {
                            }
                            i104 = i1672;
                            i110 = i49;
                            i111 = i1692;
                            i105 = i122;
                            i101 = i46;
                            dArr20 = dArr6;
                            allocate2 = byteBuffer3;
                            i107 = i1682;
                            i106 = i28;
                            byteBuffer7 = byteBuffer4;
                            d17 = d7;
                            dArr19 = dArr4;
                            i72 = i29;
                            i102 = i25;
                            i99 = i30;
                            i97 = i27;
                            d20 = d6;
                            dArr17 = dArr3;
                            i109 = i123;
                            i98 = i31;
                            i17 = i21;
                            i96 = i3;
                        }
                        i25 = i102;
                        i33 = i23;
                        i26 = i148;
                        i27 = i147;
                        i28 = i124;
                        i29 = i22;
                        dArr4 = dArr19;
                        i30 = i99;
                        d7 = d17;
                        byteBuffer3 = byteBuffer;
                        jVar2 = this;
                        int i170 = i98;
                        byteBuffer4 = byteBuffer2;
                        i31 = i170;
                        if (z2) {
                        }
                        int i16622 = i21 / i69;
                        i45 = (i149 - 1) / i16622;
                        i46 = i26;
                        if (i45 > i46) {
                        }
                        i47 = 0;
                        while (i47 < i2) {
                        }
                        int i16722 = i33;
                        int i16822 = i44;
                        i108 = i149 - (i45 * i16622);
                        while (i48 < i2) {
                        }
                        int i16922 = i111 + 1;
                        if ((i111 & 7) == 7) {
                        }
                        i104 = i16722;
                        i110 = i49;
                        i111 = i16922;
                        i105 = i122;
                        i101 = i46;
                        dArr20 = dArr6;
                        allocate2 = byteBuffer3;
                        i107 = i16822;
                        i106 = i28;
                        byteBuffer7 = byteBuffer4;
                        d17 = d7;
                        dArr19 = dArr4;
                        i72 = i29;
                        i102 = i25;
                        i99 = i30;
                        i97 = i27;
                        d20 = d6;
                        dArr17 = dArr3;
                        i109 = i123;
                        i98 = i31;
                        i17 = i21;
                        i96 = i3;
                    } else {
                        i23 = 0;
                        while (i23 < i120 * i2) {
                            dArr19[(i2 * 0) + i23] = wrap.order(this.f28494a).getInt(i23) * 4.656612875245797E-10d;
                            i23++;
                            d20 = d20;
                            i17 = i17;
                            allocate2 = allocate2;
                        }
                        jVar = this;
                        i21 = i17;
                        byteBuffer = allocate2;
                        d6 = d20;
                        byteBuffer2 = wrap;
                        i20 = i107;
                        i22 = i72;
                    }
                    dArr3 = dArr17;
                    while (i23 < i2 * i112) {
                    }
                    int i1222 = i105 + i120;
                    if (inputStream.available() >= 0) {
                    }
                    int i1232 = i109;
                    int i1242 = i117;
                    i24 = 0;
                    while (i24 < i2) {
                    }
                    int i1472 = i97;
                    int i1482 = i101;
                    int i1492 = i108 + ((i21 / i6) * i1232);
                    byteBuffer.clear();
                    if (z) {
                    }
                    i25 = i102;
                    i33 = i23;
                    i26 = i1482;
                    i27 = i1472;
                    i28 = i1242;
                    i29 = i22;
                    dArr4 = dArr19;
                    i30 = i99;
                    d7 = d17;
                    byteBuffer3 = byteBuffer;
                    jVar2 = this;
                    int i1702 = i98;
                    byteBuffer4 = byteBuffer2;
                    i31 = i1702;
                    if (z2) {
                    }
                    int i166222 = i21 / i69;
                    i45 = (i1492 - 1) / i166222;
                    i46 = i26;
                    if (i45 > i46) {
                    }
                    i47 = 0;
                    while (i47 < i2) {
                    }
                    int i167222 = i33;
                    int i168222 = i44;
                    i108 = i1492 - (i45 * i166222);
                    while (i48 < i2) {
                    }
                    int i169222 = i111 + 1;
                    if ((i111 & 7) == 7) {
                    }
                    i104 = i167222;
                    i110 = i49;
                    i111 = i169222;
                    i105 = i1222;
                    i101 = i46;
                    dArr20 = dArr6;
                    allocate2 = byteBuffer3;
                    i107 = i168222;
                    i106 = i28;
                    byteBuffer7 = byteBuffer4;
                    d17 = d7;
                    dArr19 = dArr4;
                    i72 = i29;
                    i102 = i25;
                    i99 = i30;
                    i97 = i27;
                    d20 = d6;
                    dArr17 = dArr3;
                    i109 = i1232;
                    i98 = i31;
                    i17 = i21;
                    i96 = i3;
                } else {
                    jVar = this;
                    i20 = i107;
                    i21 = i17;
                    byteBuffer = allocate2;
                    d6 = d20;
                    i22 = i72;
                    i23 = 0;
                    while (i23 < i120 * i2) {
                        dArr19[(i2 * 0) + i23] = wrap.order(jVar.f28494a).asShortBuffer().get(i23) * 3.051850947599719E-5d;
                        i23++;
                        dArr17 = dArr17;
                    }
                    dArr3 = dArr17;
                }
                byteBuffer2 = wrap;
                while (i23 < i2 * i112) {
                }
                int i12222 = i105 + i120;
                if (inputStream.available() >= 0) {
                }
                int i12322 = i109;
                int i12422 = i117;
                i24 = 0;
                while (i24 < i2) {
                }
                int i14722 = i97;
                int i14822 = i101;
                int i14922 = i108 + ((i21 / i6) * i12322);
                byteBuffer.clear();
                if (z) {
                }
                i25 = i102;
                i33 = i23;
                i26 = i14822;
                i27 = i14722;
                i28 = i12422;
                i29 = i22;
                dArr4 = dArr19;
                i30 = i99;
                d7 = d17;
                byteBuffer3 = byteBuffer;
                jVar2 = this;
                int i17022 = i98;
                byteBuffer4 = byteBuffer2;
                i31 = i17022;
                if (z2) {
                }
                int i1662222 = i21 / i69;
                i45 = (i14922 - 1) / i1662222;
                i46 = i26;
                if (i45 > i46) {
                }
                i47 = 0;
                while (i47 < i2) {
                }
                int i1672222 = i33;
                int i1682222 = i44;
                i108 = i14922 - (i45 * i1662222);
                while (i48 < i2) {
                }
                int i1692222 = i111 + 1;
                if ((i111 & 7) == 7) {
                }
                i104 = i1672222;
                i110 = i49;
                i111 = i1692222;
                i105 = i12222;
                i101 = i46;
                dArr20 = dArr6;
                allocate2 = byteBuffer3;
                i107 = i1682222;
                i106 = i28;
                byteBuffer7 = byteBuffer4;
                d17 = d7;
                dArr19 = dArr4;
                i72 = i29;
                i102 = i25;
                i99 = i30;
                i97 = i27;
                d20 = d6;
                dArr17 = dArr3;
                i109 = i12322;
                i98 = i31;
                i17 = i21;
                i96 = i3;
            }
            jVar2.l(1.0d);
            return dArr11[0];
        }
        return invokeCommon.doubleValue;
    }

    public final int e(int i2, int i3) {
        InterceptResult invokeII;
        Interceptable interceptable = $ic;
        if (interceptable != null && (invokeII = interceptable.invokeII(1048580, this, i2, i3)) != null) {
            return invokeII.intValue;
        }
        while (true) {
            int i4 = i3;
            int i5 = i2;
            i2 = i4;
            if (i2 == 0) {
                return i5;
            }
            i3 = i5 % i2;
        }
    }

    public byte[] f(ByteBuffer byteBuffer) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048581, this, byteBuffer)) == null) {
            int limit = byteBuffer.limit() - byteBuffer.position();
            byte[] bArr = new byte[limit];
            byteBuffer.get(bArr, 0, limit);
            return bArr;
        }
        return (byte[]) invokeL.objValue;
    }

    public final double g(int i2, double d2, double d3) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048582, this, new Object[]{Integer.valueOf(i2), Double.valueOf(d2), Double.valueOf(d3)})) == null) {
            double d4 = 1.0d / d3;
            return d2 * 2.0d * d4 * m(i2 * 6.283185307179586d * d2 * d4);
        }
        return invokeCommon.doubleValue;
    }

    public int h(int i2, int i3, int i4, int i5, int i6, int i7, double d2) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048583, this, new Object[]{Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(i4), Integer.valueOf(i5), Integer.valueOf(i6), Integer.valueOf(i7), Double.valueOf(d2)})) == null) {
            int[] iArr = new int[97];
            int i8 = 1;
            while (i8 < 6 && i2 != q[i8]) {
                i8++;
            }
            if ((i6 == 3 || i6 == 4) && i8 == 6) {
                System.err.printf("Warning: ATH based noise shaping for destination frequency %dHz is not available, using triangular dither\n", Integer.valueOf(i2));
            }
            i8 = (i6 == 2 || i8 == 6) ? 0 : 0;
            if (i6 == 4 && (i8 == 1 || i8 == 2)) {
                i8 += 5;
            }
            this.f28500g = i8;
            this.f28499f = new double[i3];
            this.f28501h = r[i8];
            for (int i9 = 0; i9 < i3; i9++) {
                this.f28499f[i9] = new double[this.f28501h];
            }
            this.f28502i = i4;
            this.j = i5;
            this.k = new double[65536];
            Random random = new Random(System.currentTimeMillis());
            for (int i10 = 0; i10 < 97; i10++) {
                iArr[i10] = random.nextInt();
            }
            if (i7 == 0) {
                for (int i11 = 0; i11 < 65536; i11++) {
                    int nextInt = random.nextInt() % 97;
                    int i12 = iArr[nextInt];
                    iArr[nextInt] = random.nextInt();
                    this.k[i11] = ((i12 / 2.147483647E9d) - 0.5d) * d2;
                }
            } else if (i7 == 1) {
                for (int i13 = 0; i13 < 65536; i13++) {
                    int nextInt2 = random.nextInt() % 97;
                    int i14 = iArr[nextInt2];
                    iArr[nextInt2] = random.nextInt();
                    int nextInt3 = random.nextInt() % 97;
                    int i15 = iArr[nextInt3];
                    iArr[nextInt3] = random.nextInt();
                    this.k[i13] = d2 * ((i14 / 2.147483647E9d) - (i15 / 2.147483647E9d));
                }
            } else if (i7 == 2) {
                boolean z = false;
                double d3 = 0.0d;
                double d4 = 0.0d;
                for (int i16 = 0; i16 < 65536; i16++) {
                    if (!z) {
                        int nextInt4 = random.nextInt() % 97;
                        double d5 = iArr[nextInt4] / 2.147483647E9d;
                        iArr[nextInt4] = random.nextInt();
                        if (d5 == 1.0d) {
                            d5 = 0.0d;
                        }
                        d3 = Math.sqrt(Math.log(1.0d - d5) * (-2.0d));
                        int nextInt5 = random.nextInt() % 97;
                        iArr[nextInt5] = random.nextInt();
                        d4 = 6.283185307179586d * (iArr[nextInt5] / 2.147483647E9d);
                        this.k[i16] = d2 * d3 * Math.cos(d4);
                        z = true;
                    } else {
                        this.k[i16] = d2 * d3 * Math.sin(d4);
                        z = false;
                    }
                }
            }
            this.l = 0;
            if (i6 == 0 || i6 == 1) {
                return 1;
            }
            return s[this.f28500g];
        }
        return invokeCommon.intValue;
    }

    /* JADX WARN: Removed duplicated region for block: B:25:0x013e  */
    /* JADX WARN: Removed duplicated region for block: B:75:0x0260 A[EDGE_INSN: B:75:0x0260->B:68:0x0260 ?: BREAK  , SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public double i(InputStream inputStream, OutputStream outputStream, int i2, int i3, int i4, double d2, int i5, boolean z, int i6) throws IOException {
        InterceptResult invokeCommon;
        double[] dArr;
        int i7;
        int i8;
        ByteBuffer wrap;
        double d3;
        ByteBuffer byteBuffer;
        double d4;
        int i9;
        ByteBuffer byteBuffer2;
        ByteBuffer byteBuffer3;
        int i10;
        int a2;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(InputDeviceCompat.SOURCE_TOUCHPAD, this, new Object[]{inputStream, outputStream, Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(i4), Double.valueOf(d2), Integer.valueOf(i5), Boolean.valueOf(z), Integer.valueOf(i6)})) == null) {
            int i11 = 1;
            int i12 = 0;
            double[] dArr2 = {0.0d};
            k();
            ByteBuffer allocate = z ? ByteBuffer.allocate(8) : null;
            int i13 = 4;
            ByteBuffer allocate2 = ByteBuffer.allocate(4);
            int i14 = 0;
            int i15 = 0;
            while (true) {
                int i16 = i5 * i2;
                if (i14 >= i16) {
                    dArr = dArr2;
                    break;
                }
                if (i3 == i11) {
                    i7 = i16;
                    i8 = i14;
                    dArr = dArr2;
                    allocate2.position(0);
                    allocate2.limit(1);
                    byte[] bArr = new byte[allocate2.limit()];
                    inputStream.read(bArr);
                    wrap = ByteBuffer.wrap(bArr);
                    wrap.position(wrap.limit());
                    wrap.flip();
                    d3 = (wrap.get(0) + ByteCompanionObject.MIN_VALUE) * 0.007874015748031496d;
                } else if (i3 == 2) {
                    i7 = i16;
                    dArr = dArr2;
                    allocate2.position(0);
                    allocate2.limit(2);
                    byte[] bArr2 = new byte[allocate2.limit()];
                    inputStream.read(bArr2);
                    wrap = ByteBuffer.wrap(bArr2);
                    wrap.position(wrap.limit());
                    wrap.flip();
                    i8 = i14;
                    d3 = 3.051850947599719E-5d * wrap.order(this.f28494a).asShortBuffer().get(0);
                } else {
                    if (i3 == 3) {
                        dArr = dArr2;
                        allocate2.position(i12);
                        allocate2.limit(3);
                        byte[] bArr3 = new byte[allocate2.limit()];
                        inputStream.read(bArr3);
                        ByteBuffer wrap2 = ByteBuffer.wrap(bArr3);
                        wrap2.position(wrap2.limit());
                        wrap2.flip();
                        i7 = i16;
                        d4 = 1.1920930376163766E-7d * (((wrap2.get(1) & 255) << 8) | ((wrap2.get(i12) & 255) << i12) | ((wrap2.get(2) & 255) << 16));
                        byteBuffer = wrap2;
                        i8 = i14;
                    } else if (i3 != i13) {
                        byteBuffer = allocate2;
                        i7 = i16;
                        i8 = i14;
                        dArr = dArr2;
                        d4 = 0.0d;
                    } else {
                        allocate2.position(i12);
                        allocate2.limit(i13);
                        byte[] bArr4 = new byte[allocate2.limit()];
                        inputStream.read(bArr4);
                        wrap = ByteBuffer.wrap(bArr4);
                        wrap.position(wrap.limit());
                        wrap.flip();
                        dArr = dArr2;
                        d3 = wrap.order(this.f28494a).asIntBuffer().get(i12) * 4.656612875245797E-10d;
                        i7 = i16;
                        i8 = i14;
                    }
                    if (inputStream.available() != 0) {
                        break;
                    }
                    double d5 = d4 * d2;
                    if (z) {
                        i9 = i7;
                        ByteBuffer byteBuffer4 = allocate;
                        double d6 = d5 > 0.0d ? d5 : -d5;
                        if (dArr[0] >= d6) {
                            d6 = dArr[0];
                        }
                        dArr[0] = d6;
                        byteBuffer2 = byteBuffer4;
                        byteBuffer2.position(0);
                        byteBuffer2.putDouble(d5);
                        byteBuffer2.flip();
                        p(outputStream, byteBuffer2);
                    } else {
                        if (i4 == 1) {
                            i9 = i7;
                            byteBuffer3 = allocate;
                            double d7 = d5 * 127.0d;
                            int c2 = i6 != 0 ? c(d7, dArr, i6, i15) : a(d7);
                            byteBuffer.position(0);
                            byteBuffer.limit(1);
                            byteBuffer.put(0, (byte) (c2 + 128));
                            byteBuffer.flip();
                            p(outputStream, byteBuffer);
                        } else if (i4 == 2) {
                            i9 = i7;
                            byteBuffer3 = allocate;
                            double d8 = d5 * 32767.0d;
                            int c3 = i6 != 0 ? c(d8, dArr, i6, i15) : a(d8);
                            byteBuffer.position(0);
                            byteBuffer.limit(2);
                            byteBuffer.asShortBuffer().put(0, (short) c3);
                            byteBuffer.flip();
                            p(outputStream, byteBuffer);
                        } else if (i4 != 3) {
                            i9 = i7;
                            byteBuffer3 = allocate;
                        } else {
                            double d9 = d5 * 8388607.0d;
                            if (i6 != 0) {
                                i9 = i7;
                                i10 = 3;
                                byteBuffer3 = allocate;
                                a2 = c(d9, dArr, i6, i15);
                            } else {
                                i9 = i7;
                                byteBuffer3 = allocate;
                                i10 = 3;
                                a2 = a(d9);
                            }
                            byteBuffer.position(0);
                            byteBuffer.limit(i10);
                            byteBuffer.put(0, (byte) (a2 & 255));
                            int i17 = a2 >> 8;
                            byteBuffer.put(1, (byte) (i17 & 255));
                            byteBuffer.put(2, (byte) ((i17 >> 8) & 255));
                            byteBuffer.flip();
                            p(outputStream, byteBuffer);
                        }
                        byteBuffer2 = byteBuffer3;
                    }
                    int i18 = i15 + 1;
                    i15 = i18 == i2 ? 0 : i18;
                    int i19 = i8 + 1;
                    if ((262143 & i19) == 0) {
                        l(i19 / i9);
                    }
                    allocate = byteBuffer2;
                    dArr2 = dArr;
                    i13 = 4;
                    i12 = 0;
                    i14 = i19;
                    allocate2 = byteBuffer;
                    i11 = 1;
                }
                double d10 = d3;
                byteBuffer = wrap;
                d4 = d10;
                if (inputStream.available() != 0) {
                }
            }
            l(1.0d);
            return dArr[0];
        }
        return invokeCommon.doubleValue;
    }

    public final void j(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048585, this, i2) == null) {
        }
    }

    public final void k() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048586, this) == null) {
            this.o = System.currentTimeMillis();
            this.p = 0L;
            this.n = -1;
        }
    }

    public final void l(double d2) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeCommon(1048587, this, new Object[]{Double.valueOf(d2)}) == null) || this.m) {
            return;
        }
        long currentTimeMillis = System.currentTimeMillis() - this.o;
        int i2 = d2 == 0.0d ? 0 : (int) ((currentTimeMillis * (1.0d - d2)) / d2);
        int i3 = (int) (d2 * 100.0d);
        if (i3 != this.n || currentTimeMillis != this.p) {
            System.err.printf(" %3d%% processed", Integer.valueOf(i3));
            this.n = i3;
        }
        if (currentTimeMillis != this.p) {
            System.err.printf(", ETA =%4dmsec", Integer.valueOf(i2));
            this.p = currentTimeMillis;
        }
        System.err.printf(StringUtils.CR, new Object[0]);
        System.err.flush();
    }

    public final double m(double d2) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048588, this, new Object[]{Double.valueOf(d2)})) == null) {
            if (d2 == 0.0d) {
                return 1.0d;
            }
            return Math.sin(d2) / d2;
        }
        return invokeCommon.doubleValue;
    }

    /* JADX WARN: Removed duplicated region for block: B:247:0x0854  */
    /* JADX WARN: Removed duplicated region for block: B:256:0x08b8  */
    /* JADX WARN: Removed duplicated region for block: B:271:0x0953  */
    /* JADX WARN: Removed duplicated region for block: B:272:0x095c  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public double n(InputStream inputStream, OutputStream outputStream, int i2, int i3, int i4, int i5, int i6, double d2, int i7, boolean z, int i8) throws IOException {
        InterceptResult invokeCommon;
        int i9;
        int i10;
        double d3;
        double d4;
        int i11;
        double d5;
        int i12;
        int i13;
        ByteBuffer byteBuffer;
        int i14;
        ByteBuffer byteBuffer2;
        int i15;
        double[] dArr;
        double[] dArr2;
        double d6;
        int i16;
        int i17;
        int i18;
        ByteBuffer byteBuffer3;
        int i19;
        int i20;
        int a2;
        char c2;
        int i21;
        int i22;
        int i23;
        ByteBuffer byteBuffer4;
        int a3;
        char c3;
        int i24;
        double[] dArr3;
        double[] dArr4;
        double d7;
        int i25;
        int i26;
        int i27;
        int i28;
        int a4;
        char c4;
        int i29;
        int i30;
        int i31;
        int i32;
        int i33;
        int i34;
        int i35;
        int i36;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048589, this, new Object[]{inputStream, outputStream, Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(i4), Integer.valueOf(i5), Integer.valueOf(i6), Double.valueOf(d2), Integer.valueOf(i7), Boolean.valueOf(z), Integer.valueOf(i8)})) == null) {
            j jVar = this;
            Class<double> cls = double.class;
            double[] dArr5 = {0.0d};
            int i37 = jVar.f28498e;
            double d8 = jVar.f28496c;
            int e2 = i5 / jVar.e(i5, i6);
            int i38 = e2 * i6;
            int i39 = i38 / i6;
            if (i39 == 1) {
                i9 = 1;
            } else if (i39 % 2 == 0) {
                i9 = 2;
            } else if (i39 % 3 != 0) {
                throw new IllegalArgumentException(String.format("Resampling from %dHz to %dHz is not supported.\n%d/gcd(%d,%d)=%d must be divided by 2 or 3.\n", Integer.valueOf(i5), Integer.valueOf(i6), Integer.valueOf(i5), Integer.valueOf(i5), Integer.valueOf(i6), Integer.valueOf(i39)));
            } else {
                i9 = 3;
            }
            int i40 = i6 * i9;
            int i41 = i5 / 2;
            double d9 = (i10 * 2) / 2.0d;
            double d10 = i41;
            int i42 = i37;
            double d11 = d10 + (((i40 / 2) - i41) / 2.0d);
            if (d8 <= 21.0d) {
                d4 = d10;
                d3 = 0.9222d;
            } else {
                d3 = (d8 - 7.95d) / 14.36d;
                d4 = d10;
            }
            double d12 = i38;
            int i43 = (int) (((d12 / d9) * d3) + 1.0d);
            if (i43 % 2 == 0) {
                i43++;
            }
            int i44 = i43;
            double b2 = jVar.b(d8);
            double a5 = f.a(b2);
            int i45 = i38 / i5;
            int i46 = (i44 / i45) + 1;
            int i47 = i45 * i9;
            int[] iArr = new int[i47];
            for (int i48 = 0; i48 < i47; i48++) {
                iArr[i48] = i45 - (((i38 / i40) * i48) % i45);
                if (iArr[i48] == i45) {
                    iArr[i48] = 0;
                }
            }
            int[] iArr2 = new int[i47];
            int i49 = 0;
            while (i49 < i47) {
                int i50 = i47;
                double[] dArr6 = dArr5;
                iArr2[i49] = iArr[i49] < i38 / i40 ? i2 : 0;
                if (iArr[i49] == i45) {
                    iArr[i49] = 0;
                }
                i49++;
                i47 = i50;
                dArr5 = dArr6;
            }
            int i51 = i47;
            double[] dArr7 = dArr5;
            double[][] dArr8 = (double[][]) Array.newInstance((Class<?>) cls, i45, i46);
            int i52 = i44 / 2;
            int i53 = -i52;
            while (i53 <= i52) {
                int i54 = i53 + i52;
                int i55 = i51;
                int i56 = i53;
                dArr8[i54 % i45][i54 / i45] = ((o(i53, i44, b2, a5) * g(i56, d11, d12)) * d12) / i5;
                i53 = i56 + 1;
                jVar = this;
                i40 = i40;
                i46 = i46;
                iArr2 = iArr2;
                i44 = i44;
                i52 = i52;
                i38 = i38;
                iArr = iArr;
                i51 = i55;
                i42 = i42;
            }
            int[] iArr3 = iArr;
            int i57 = i46;
            int i58 = i38;
            int i59 = i40;
            int i60 = i52;
            int[] iArr4 = iArr2;
            j jVar2 = jVar;
            int i61 = i42;
            int i62 = i51;
            double d13 = jVar2.f28496c;
            double d14 = d13 > 21.0d ? (d13 - 7.95d) / 14.36d : 0.9222d;
            int i63 = 1;
            while (true) {
                int i64 = i61 * i63;
                if (i64 % 2 == 0) {
                    i64--;
                }
                i11 = i64;
                d5 = i59;
                if ((d5 * d14) / (i11 - 1) < jVar2.f28497d) {
                    break;
                }
                i63 *= 2;
                jVar2 = jVar2;
                i62 = i62;
                cls = cls;
            }
            double b3 = jVar2.b(d13);
            double a6 = f.a(b3);
            int i65 = 1;
            while (i65 < i11) {
                i65 *= 2;
            }
            int i66 = i65 * 2;
            double[] dArr9 = new double[i66];
            int i67 = i11 / 2;
            int i68 = -i67;
            while (i68 <= i67) {
                double d15 = d5;
                double[] dArr10 = dArr9;
                int i69 = i68;
                double d16 = b3;
                double d17 = b3;
                j jVar3 = jVar2;
                int i70 = i66;
                double o = o(i68, i11, d16, a6);
                d5 = d15;
                dArr10[i68 + i67] = ((o * g(i69, d4, d5)) / i70) * 2.0d;
                i68 = i69 + 1;
                jVar2 = jVar3;
                i66 = i70;
                i67 = i67;
                b3 = d17;
                dArr9 = dArr10;
            }
            int i71 = i68;
            double[] dArr11 = dArr9;
            double d18 = d5;
            j jVar4 = jVar2;
            int i72 = i66;
            int[] iArr5 = new int[(int) (Math.sqrt(i72) + 2.0d)];
            iArr5[0] = 0;
            int i73 = i72 / 2;
            double[] dArr12 = new double[i73];
            jVar4.f28495b.B(i72, 1, dArr11, iArr5, dArr12);
            k();
            int i74 = (i73 / i9) + 1;
            int[] iArr6 = {r4, i74};
            int i75 = i2;
            double[][] dArr13 = (double[][]) Array.newInstance((Class<?>) cls, iArr6);
            double[][] dArr14 = (double[][]) Array.newInstance((Class<?>) cls, i75, i72);
            int i76 = (i73 + i57 + 2) * i75;
            int i77 = i3;
            ByteBuffer allocate = ByteBuffer.allocate(i76 * i77);
            int i78 = i74 * i75;
            ByteBuffer allocate2 = ByteBuffer.allocate(i78 * i4);
            double[] dArr15 = new double[i76];
            double[] dArr16 = new double[i78];
            int i79 = i57;
            int i80 = (int) ((i11 / 2.0d) / (i59 / i6));
            int i81 = (i60 / i45) + 1;
            ByteBuffer byteBuffer5 = allocate;
            int i82 = 0;
            int i83 = 0;
            int i84 = 0;
            int i85 = 0;
            int i86 = 0;
            int i87 = 0;
            boolean z2 = true;
            int i88 = i7;
            int i89 = 0;
            while (true) {
                double[] dArr17 = dArr16;
                double[] dArr18 = dArr15;
                double d19 = i5;
                double d20 = d19;
                int ceil = (int) (((Math.ceil((i73 * d19) / d18) + 1.0d) + i79) - i81);
                int i90 = ceil + i82 > i88 ? i88 - i82 : ceil;
                byteBuffer5.position(0);
                int i91 = i77 * i75;
                byteBuffer5.limit(i90 * i91);
                byte[] bArr = new byte[byteBuffer5.limit()];
                int read = inputStream.read(bArr);
                int i92 = i88;
                int i93 = read < 0 ? 0 : read;
                int i94 = i93 < byteBuffer5.limit() ? ((i93 / i77) * i75) + i82 : i92;
                byteBuffer5.limit(i93);
                ByteBuffer wrap = ByteBuffer.wrap(bArr);
                wrap.position(i93);
                wrap.flip();
                int i95 = i93 / i91;
                if (i77 != 1) {
                    if (i77 == 2) {
                        i13 = i72;
                        byteBuffer = allocate2;
                        i14 = 0;
                        while (i14 < i95 * i75) {
                            dArr18[(i75 * i81) + i14] = wrap.order(jVar4.f28494a).asShortBuffer().get(i14) * 3.051850947599719E-5d;
                            i14++;
                            jVar4 = this;
                            i73 = i73;
                        }
                    } else if (i77 == 3) {
                        byteBuffer = allocate2;
                        i14 = 0;
                        while (i14 < i95 * i75) {
                            int i96 = i14 * 3;
                            dArr18[(i75 * i81) + i14] = ((wrap.get(i96 + 1) << 8) | (wrap.get(i96) << 0) | (wrap.get(i96 + 2) << 16)) * 1.1920930376163766E-7d;
                            i14++;
                            i72 = i72;
                        }
                        i13 = i72;
                    } else if (i77 != 4) {
                        i12 = i73;
                        i13 = i72;
                        i14 = i71;
                        byteBuffer = allocate2;
                    } else {
                        i14 = 0;
                        while (i14 < i95 * i75) {
                            dArr18[(i75 * i81) + i14] = wrap.order(jVar4.f28494a).asIntBuffer().get(i14) * 4.656612875245797E-10d;
                            i14++;
                            allocate2 = allocate2;
                        }
                        byteBuffer = allocate2;
                        i12 = i73;
                        i13 = i72;
                    }
                    i12 = i73;
                } else {
                    i12 = i73;
                    i13 = i72;
                    byteBuffer = allocate2;
                    i14 = 0;
                    while (i14 < i95 * i75) {
                        dArr18[(i75 * i81) + i14] = (wrap.get(i14) - 128.0d) * 0.007874015748031496d;
                        i14++;
                    }
                }
                while (i14 < i75 * ceil) {
                    dArr18[(i75 * i81) + i14] = 0.0d;
                    i14++;
                }
                int i97 = i81 + ceil;
                i82 += i95;
                boolean z3 = i82 >= i94;
                int i98 = ((((i83 - 1) * i5) + i58) / i58) * i75;
                int i99 = i84;
                int i100 = i85;
                int i101 = i86;
                int i102 = 0;
                while (i102 < i75) {
                    int i103 = i98 + i102;
                    if (i79 == 7) {
                        i34 = i62;
                        i35 = i12;
                        i36 = i85;
                        for (int i104 = 0; i104 < i35; i104++) {
                            int i105 = iArr3[i36];
                            dArr14[i102][i104] = (dArr8[i105][0] * dArr18[i103 + (i75 * 0)]) + (dArr8[i105][1] * dArr18[i103 + (i75 * 1)]) + (dArr8[i105][2] * dArr18[i103 + (i75 * 2)]) + (dArr8[i105][3] * dArr18[i103 + (i75 * 3)]) + (dArr8[i105][4] * dArr18[i103 + (i75 * 4)]) + (dArr8[i105][5] * dArr18[i103 + (i75 * 5)]) + (dArr8[i105][6] * dArr18[i103 + (i75 * 6)]);
                            i103 += iArr4[i36];
                            i36++;
                            if (i36 == i34) {
                                i36 = 0;
                            }
                        }
                    } else if (i79 != 9) {
                        i36 = i85;
                        i35 = i12;
                        int i106 = 0;
                        while (i106 < i35) {
                            int i107 = iArr3[i36];
                            int i108 = i103;
                            double d21 = 0.0d;
                            for (int i109 = 0; i109 < i79; i109++) {
                                d21 += dArr8[i107][i109] * dArr18[i108];
                                i108 += i75;
                            }
                            dArr14[i102][i106] = d21;
                            i103 += iArr4[i36];
                            i36++;
                            int i110 = i62;
                            if (i36 == i110) {
                                i36 = 0;
                            }
                            i106++;
                            i62 = i110;
                        }
                        i34 = i62;
                    } else {
                        i34 = i62;
                        i35 = i12;
                        i36 = i85;
                        for (int i111 = 0; i111 < i35; i111++) {
                            int i112 = iArr3[i36];
                            dArr14[i102][i111] = (dArr8[i112][0] * dArr18[i103 + (i75 * 0)]) + (dArr8[i112][1] * dArr18[i103 + (i75 * 1)]) + (dArr8[i112][2] * dArr18[i103 + (i75 * 2)]) + (dArr8[i112][3] * dArr18[i103 + (i75 * 3)]) + (dArr8[i112][4] * dArr18[i103 + (i75 * 4)]) + (dArr8[i112][5] * dArr18[i103 + (i75 * 5)]) + (dArr8[i112][6] * dArr18[i103 + (i75 * 6)]) + (dArr8[i112][7] * dArr18[i103 + (i75 * 7)]) + (dArr8[i112][8] * dArr18[i103 + (i75 * 8)]);
                            i103 += iArr4[i36];
                            i36++;
                            if (i36 == i34) {
                                i36 = 0;
                            }
                        }
                    }
                    int i113 = i13;
                    for (int i114 = i35; i114 < i113; i114++) {
                        dArr14[i102][i114] = 0.0d;
                    }
                    this.f28495b.B(i113, 1, dArr14[i102], iArr5, dArr12);
                    dArr14[i102][0] = dArr11[0] * dArr14[i102][0];
                    dArr14[i102][1] = dArr11[1] * dArr14[i102][1];
                    for (int i115 = 1; i115 < i35; i115++) {
                        int i116 = i115 * 2;
                        int i117 = i116 + 1;
                        dArr14[i102][i116] = (dArr11[i116] * dArr14[i102][i116]) - (dArr11[i117] * dArr14[i102][i117]);
                        dArr14[i102][i117] = (dArr11[i117] * dArr14[i102][i116]) + (dArr11[i116] * dArr14[i102][i117]);
                    }
                    this.f28495b.B(i113, -1, dArr14[i102], iArr5, dArr12);
                    int i118 = i98;
                    int i119 = i86;
                    int i120 = 0;
                    while (i119 < i35) {
                        dArr17[i102 + (i120 * i75)] = dArr13[i102][i120] + dArr14[i102][i119];
                        i119 += i9;
                        i120++;
                    }
                    int i121 = i119 - i35;
                    int i122 = 0;
                    while (i119 < i113) {
                        dArr13[i102][i122] = dArr14[i102][i119];
                        i119 += i9;
                        i122++;
                    }
                    i102++;
                    i14 = i119;
                    i13 = i113;
                    i12 = i35;
                    i100 = i36;
                    i62 = i34;
                    i99 = i120;
                    i98 = i118;
                    i101 = i121;
                }
                int i123 = i62;
                int i124 = i13;
                int i125 = i12;
                int i126 = i83 + ((i125 * e2) / i9);
                byteBuffer.clear();
                if (z) {
                    int i127 = 0;
                    while (i127 < i99 * i75) {
                        double d22 = dArr17[i127] > 0.0d ? dArr17[i127] : -dArr17[i127];
                        if (dArr7[0] >= d22) {
                            d22 = dArr7[0];
                        }
                        dArr7[0] = d22;
                        byteBuffer.asDoubleBuffer().put(i127, dArr17[i127]);
                        i127++;
                        wrap = wrap;
                    }
                    byteBuffer2 = wrap;
                    i15 = i100;
                    dArr = dArr18;
                    dArr2 = dArr17;
                    d6 = d20;
                    i16 = i75;
                    i17 = i101;
                    i18 = i79;
                    byteBuffer3 = byteBuffer;
                    i20 = i127;
                } else {
                    byteBuffer2 = wrap;
                    if (i4 == 1) {
                        i15 = i100;
                        dArr = dArr18;
                        dArr2 = dArr17;
                        d6 = d20;
                        i16 = i75;
                        i17 = i101;
                        i18 = i79;
                        byteBuffer3 = byteBuffer;
                        i19 = i124;
                        double d23 = d2 * 127.0d;
                        i20 = 0;
                        int i128 = 0;
                        while (i20 < i99 * i16) {
                            if (i8 != 0) {
                                a2 = c(dArr2[i20] * d23, dArr7, i8, i128);
                            } else {
                                a2 = a(dArr2[i20] * d23);
                                if (a2 < -128) {
                                    double d24 = a2 / (-128.0d);
                                    c2 = 0;
                                    if (dArr7[0] >= d24) {
                                        d24 = dArr7[0];
                                    }
                                    dArr7[0] = d24;
                                    a2 = com.alipay.sdk.encrypt.a.f34123g;
                                } else {
                                    c2 = 0;
                                }
                                if (127 < a2) {
                                    double d25 = a2 / 127.0d;
                                    if (dArr7[c2] >= d25) {
                                        d25 = dArr7[c2];
                                    }
                                    dArr7[c2] = d25;
                                    a2 = 127;
                                }
                            }
                            byteBuffer3.put(i20, (byte) (a2 + 128));
                            int i129 = i128 + 1;
                            i128 = i129 == i16 ? 0 : i129;
                            i20++;
                        }
                    } else if (i4 == 2) {
                        i15 = i100;
                        dArr = dArr18;
                        dArr2 = dArr17;
                        d6 = d20;
                        i16 = i75;
                        i17 = i101;
                        int i130 = i124;
                        ByteBuffer byteBuffer6 = byteBuffer;
                        double d26 = d2 * 32767.0d;
                        int i131 = 0;
                        int i132 = 0;
                        while (i131 < i99 * i16) {
                            if (i8 != 0) {
                                i21 = i130;
                                i23 = i131;
                                i22 = i79;
                                byteBuffer4 = byteBuffer6;
                                a3 = c(dArr2[i131] * d26, dArr7, i8, i132);
                            } else {
                                i21 = i130;
                                i22 = i79;
                                i23 = i131;
                                byteBuffer4 = byteBuffer6;
                                a3 = a(dArr2[i23] * d26);
                                if (a3 < -32768) {
                                    double d27 = a3 / (-32768.0d);
                                    c3 = 0;
                                    if (dArr7[0] >= d27) {
                                        d27 = dArr7[0];
                                    }
                                    dArr7[0] = d27;
                                    a3 = -32768;
                                } else {
                                    c3 = 0;
                                }
                                if (32767 < a3) {
                                    double d28 = a3 / 32767.0d;
                                    if (dArr7[c3] >= d28) {
                                        d28 = dArr7[c3];
                                    }
                                    dArr7[c3] = d28;
                                    a3 = 32767;
                                }
                            }
                            byteBuffer4.order(this.f28494a).asShortBuffer().put(i23, (short) a3);
                            int i133 = i132 + 1;
                            i132 = i133 == i16 ? 0 : i133;
                            i131 = i23 + 1;
                            byteBuffer6 = byteBuffer4;
                            i130 = i21;
                            i79 = i22;
                        }
                        i19 = i130;
                        i18 = i79;
                        i20 = i131;
                        byteBuffer3 = byteBuffer6;
                    } else if (i4 != 3) {
                        i15 = i100;
                        dArr = dArr18;
                        dArr2 = dArr17;
                        d6 = d20;
                        i16 = i75;
                        i17 = i101;
                        i18 = i79;
                        byteBuffer3 = byteBuffer;
                        i20 = i14;
                    } else {
                        double d29 = d2 * 8388607.0d;
                        int i134 = 0;
                        int i135 = 0;
                        while (i134 < i99 * i75) {
                            if (i8 != 0) {
                                i24 = i100;
                                dArr4 = dArr17;
                                d7 = d20;
                                i27 = i101;
                                dArr3 = dArr18;
                                i25 = i134;
                                i26 = i75;
                                i28 = i124;
                                a4 = c(dArr17[i134] * d29, dArr7, i8, i135);
                            } else {
                                i24 = i100;
                                dArr3 = dArr18;
                                dArr4 = dArr17;
                                d7 = d20;
                                i25 = i134;
                                i26 = i75;
                                i27 = i101;
                                i28 = i124;
                                a4 = a(dArr4[i25] * d29);
                                if (a4 < -8388608) {
                                    double d30 = a4 / (-8388608.0d);
                                    c4 = 0;
                                    if (dArr7[0] >= d30) {
                                        d30 = dArr7[0];
                                    }
                                    dArr7[0] = d30;
                                    a4 = -8388608;
                                } else {
                                    c4 = 0;
                                }
                                if (8388607 < a4) {
                                    double d31 = a4 / 8388607.0d;
                                    if (dArr7[c4] >= d31) {
                                        d31 = dArr7[c4];
                                    }
                                    dArr7[c4] = d31;
                                    a4 = 8388607;
                                }
                            }
                            int i136 = i25 * 3;
                            ByteBuffer byteBuffer7 = byteBuffer;
                            byteBuffer7.put(i136, (byte) (a4 & 255));
                            int i137 = a4 >> 8;
                            byteBuffer7.put(i136 + 1, (byte) (i137 & 255));
                            byteBuffer7.put(i136 + 2, (byte) ((i137 >> 8) & 255));
                            int i138 = i135 + 1;
                            i135 = i138 == i26 ? 0 : i138;
                            i134 = i25 + 1;
                            byteBuffer = byteBuffer7;
                            i75 = i26;
                            i124 = i28;
                            i100 = i24;
                            i101 = i27;
                            dArr18 = dArr3;
                            d20 = d7;
                            dArr17 = dArr4;
                        }
                        i15 = i100;
                        dArr = dArr18;
                        dArr2 = dArr17;
                        d6 = d20;
                        i16 = i75;
                        i17 = i101;
                        i20 = i134;
                        i18 = i79;
                        byteBuffer3 = byteBuffer;
                    }
                    if (z2) {
                        if (z3) {
                            double d32 = (i82 * i6) / d6;
                            int i139 = i89 + i99;
                            i29 = i94;
                            if (d32 + 2.0d > i139) {
                                byteBuffer3.position(0);
                                byteBuffer3.limit(i4 * i16 * i99);
                                p(outputStream, byteBuffer3);
                                i32 = i139;
                            } else {
                                byteBuffer3.position(0);
                                int floor = (int) (i4 * i16 * ((Math.floor(d32) + 2.0d) - i89));
                                if (floor > 0) {
                                    byteBuffer3.limit(floor);
                                    p(outputStream, byteBuffer3);
                                }
                            }
                        } else {
                            i29 = i94;
                            byteBuffer3.position(0);
                            byteBuffer3.limit(i4 * i16 * i99);
                            p(outputStream, byteBuffer3);
                            i32 = i89 + i99;
                        }
                        i30 = i20;
                        i31 = i97;
                    } else {
                        int i140 = i89;
                        i29 = i94;
                        int i141 = i80;
                        if (i99 < i141) {
                            i80 = i141 - i99;
                            i32 = i140;
                            i30 = i20;
                            i31 = i97;
                        } else if (z3) {
                            double d33 = (i82 * i6) / d6;
                            i30 = i20;
                            i31 = i97;
                            if (d33 + 2.0d > (i140 + i99) - i141) {
                                int i142 = i4 * i16;
                                byteBuffer3.position(i142 * i141);
                                byteBuffer3.limit(i142 * i99);
                                p(outputStream, byteBuffer3);
                                i32 = (i99 - i141) + i140;
                                i80 = i141;
                            } else {
                                int i143 = i4 * i16;
                                byteBuffer3.position(i141 * i143);
                                byteBuffer3.limit((int) (i143 * ((Math.floor(d33) + 2.0d) - i140)));
                                p(outputStream, byteBuffer3);
                                break;
                            }
                        } else {
                            i30 = i20;
                            i31 = i97;
                            int i144 = i4 * i16;
                            byteBuffer3.position(i144 * i141);
                            byteBuffer3.limit(i144 * i99);
                            p(outputStream, byteBuffer3);
                            i32 = (i99 - i141) + i140;
                            i80 = i141;
                            z2 = false;
                            int i145 = (i126 - 1) / i45;
                            i81 = i31 - i145;
                            double[] dArr19 = dArr;
                            System.arraycopy(dArr19, i16 * i145, dArr19, 0, i16 * i81);
                            i83 = i126 - (i145 * i45);
                            int i146 = i87 + 1;
                            if ((i87 & 7) == 7) {
                                i33 = i29;
                                l(i82 / i33);
                            } else {
                                i33 = i29;
                            }
                            i89 = i32;
                            i87 = i146;
                            dArr15 = dArr19;
                            i75 = i16;
                            i88 = i33;
                            jVar4 = this;
                            byteBuffer5 = byteBuffer2;
                            i62 = i123;
                            i73 = i125;
                            i72 = i19;
                            dArr16 = dArr2;
                            i85 = i15;
                            i86 = i17;
                            i77 = i3;
                            i84 = i99;
                            i71 = i30;
                            allocate2 = byteBuffer3;
                            i79 = i18;
                        }
                    }
                    int i1452 = (i126 - 1) / i45;
                    i81 = i31 - i1452;
                    double[] dArr192 = dArr;
                    System.arraycopy(dArr192, i16 * i1452, dArr192, 0, i16 * i81);
                    i83 = i126 - (i1452 * i45);
                    int i1462 = i87 + 1;
                    if ((i87 & 7) == 7) {
                    }
                    i89 = i32;
                    i87 = i1462;
                    dArr15 = dArr192;
                    i75 = i16;
                    i88 = i33;
                    jVar4 = this;
                    byteBuffer5 = byteBuffer2;
                    i62 = i123;
                    i73 = i125;
                    i72 = i19;
                    dArr16 = dArr2;
                    i85 = i15;
                    i86 = i17;
                    i77 = i3;
                    i84 = i99;
                    i71 = i30;
                    allocate2 = byteBuffer3;
                    i79 = i18;
                }
                i19 = i124;
                if (z2) {
                }
                int i14522 = (i126 - 1) / i45;
                i81 = i31 - i14522;
                double[] dArr1922 = dArr;
                System.arraycopy(dArr1922, i16 * i14522, dArr1922, 0, i16 * i81);
                i83 = i126 - (i14522 * i45);
                int i14622 = i87 + 1;
                if ((i87 & 7) == 7) {
                }
                i89 = i32;
                i87 = i14622;
                dArr15 = dArr1922;
                i75 = i16;
                i88 = i33;
                jVar4 = this;
                byteBuffer5 = byteBuffer2;
                i62 = i123;
                i73 = i125;
                i72 = i19;
                dArr16 = dArr2;
                i85 = i15;
                i86 = i17;
                i77 = i3;
                i84 = i99;
                i71 = i30;
                allocate2 = byteBuffer3;
                i79 = i18;
            }
            l(1.0d);
            return dArr7[0];
        }
        return invokeCommon.doubleValue;
    }

    public final double o(double d2, int i2, double d3, double d4) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048590, this, new Object[]{Double.valueOf(d2), Integer.valueOf(i2), Double.valueOf(d3), Double.valueOf(d4)})) == null) {
            double d5 = 4.0d * d2 * d2;
            double d6 = i2 - 1.0d;
            return f.a(d3 * Math.sqrt(1.0d - (d5 / (d6 * d6)))) / d4;
        }
        return invokeCommon.doubleValue;
    }

    public void p(OutputStream outputStream, ByteBuffer byteBuffer) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048591, this, outputStream, byteBuffer) == null) {
            try {
                outputStream.write(f(byteBuffer));
            } catch (IOException unused) {
            }
        }
    }
}
