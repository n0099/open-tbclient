package c.i.b.a.a0.q;

import androidx.core.view.InputDeviceCompat;
import c.i.b.a.i0.v;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.coremedia.iso.boxes.sampleentry.VisualSampleEntry;
import java.io.IOException;
/* loaded from: classes4.dex */
public final class i {
    public static /* synthetic */ Interceptable $ic;

    /* renamed from: a  reason: collision with root package name */
    public static final int[] f32673a;
    public transient /* synthetic */ FieldHolder $fh;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-445121225, "Lc/i/b/a/a0/q/i;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-445121225, "Lc/i/b/a/a0/q/i;");
                return;
            }
        }
        f32673a = new int[]{v.q("isom"), v.q("iso2"), v.q("iso3"), v.q("iso4"), v.q("iso5"), v.q("iso6"), v.q(VisualSampleEntry.TYPE3), v.q("hvc1"), v.q("hev1"), v.q("mp41"), v.q("mp42"), v.q("3g2a"), v.q("3g2b"), v.q("3gr6"), v.q("3gs6"), v.q("3ge6"), v.q("3gg6"), v.q("M4V "), v.q("M4A "), v.q("f4v "), v.q("kddi"), v.q("M4VP"), v.q("qt  "), v.q("MSNV")};
    }

    public static boolean a(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(65537, null, i2)) == null) {
            if ((i2 >>> 8) == v.q("3gp")) {
                return true;
            }
            for (int i3 : f32673a) {
                if (i3 == i2) {
                    return true;
                }
            }
            return false;
        }
        return invokeI.booleanValue;
    }

    public static boolean b(c.i.b.a.a0.f fVar) throws IOException, InterruptedException {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65538, null, fVar)) == null) ? c(fVar, true) : invokeL.booleanValue;
    }

    public static boolean c(c.i.b.a.a0.f fVar, boolean z) throws IOException, InterruptedException {
        InterceptResult invokeLZ;
        boolean z2;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLZ = interceptable.invokeLZ(65539, null, fVar, z)) == null) {
            long length = fVar.getLength();
            long j2 = -1;
            if (length == -1 || length > 4096) {
                length = 4096;
            }
            int i2 = (int) length;
            c.i.b.a.i0.l lVar = new c.i.b.a.i0.l(64);
            int i3 = 0;
            boolean z3 = false;
            while (i3 < i2) {
                lVar.G(8);
                fVar.c(lVar.f33839a, 0, 8);
                long z4 = lVar.z();
                int i4 = lVar.i();
                int i5 = 16;
                if (z4 == 1) {
                    fVar.c(lVar.f33839a, 8, 8);
                    lVar.I(16);
                    z4 = lVar.C();
                } else {
                    if (z4 == 0) {
                        long length2 = fVar.getLength();
                        if (length2 != j2) {
                            z4 = 8 + (length2 - fVar.getPosition());
                        }
                    }
                    i5 = 8;
                }
                long j3 = i5;
                if (z4 < j3) {
                    return false;
                }
                i3 += i5;
                if (i4 != a.C) {
                    if (i4 == a.L || i4 == a.N) {
                        z2 = true;
                        break;
                    } else if ((i3 + z4) - j3 >= i2) {
                        break;
                    } else {
                        int i6 = (int) (z4 - j3);
                        i3 += i6;
                        if (i4 == a.f32579b) {
                            if (i6 < 8) {
                                return false;
                            }
                            lVar.G(i6);
                            fVar.c(lVar.f33839a, 0, i6);
                            int i7 = i6 / 4;
                            int i8 = 0;
                            while (true) {
                                if (i8 >= i7) {
                                    break;
                                }
                                if (i8 == 1) {
                                    lVar.K(4);
                                } else if (a(lVar.i())) {
                                    z3 = true;
                                    break;
                                }
                                i8++;
                            }
                            if (!z3) {
                                return false;
                            }
                        } else if (i6 != 0) {
                            fVar.g(i6);
                        }
                        j2 = -1;
                    }
                }
            }
            z2 = false;
            return z3 && z == z2;
        }
        return invokeLZ.booleanValue;
    }

    public static boolean d(c.i.b.a.a0.f fVar) throws IOException, InterruptedException {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(InputDeviceCompat.SOURCE_TRACKBALL, null, fVar)) == null) ? c(fVar, false) : invokeL.booleanValue;
    }
}
