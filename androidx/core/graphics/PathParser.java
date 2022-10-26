package androidx.core.graphics;

import android.graphics.Path;
import android.util.Log;
import androidx.core.view.InputDeviceCompat;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.ArrayList;
/* loaded from: classes.dex */
public class PathParser {
    public static /* synthetic */ Interceptable $ic = null;
    public static final String LOGTAG = "PathParser";
    public transient /* synthetic */ FieldHolder $fh;

    /* loaded from: classes.dex */
    public static class ExtractFloatResult {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public int mEndPosition;
        public boolean mEndWithNegOrDot;

        public ExtractFloatResult() {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                }
            }
        }
    }

    /* loaded from: classes.dex */
    public static class PathDataNode {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public float[] mParams;
        public char mType;

        public PathDataNode(char c, float[] fArr) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {Character.valueOf(c), fArr};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.mType = c;
            this.mParams = fArr;
        }

        public PathDataNode(PathDataNode pathDataNode) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {pathDataNode};
                interceptable.invokeUnInit(65537, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65537, newInitContext);
                    return;
                }
            }
            this.mType = pathDataNode.mType;
            float[] fArr = pathDataNode.mParams;
            this.mParams = PathParser.copyOfRange(fArr, 0, fArr.length);
        }

        /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
        public static void addCommand(Path path, float[] fArr, char c, char c2, float[] fArr2) {
            int i;
            int i2;
            boolean z;
            boolean z2;
            boolean z3;
            boolean z4;
            float f;
            float f2;
            float f3;
            float f4;
            float f5;
            float f6;
            float f7;
            float f8;
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeCommon(65538, null, new Object[]{path, fArr, Character.valueOf(c), Character.valueOf(c2), fArr2}) == null) {
                char c3 = c2;
                float f9 = fArr[0];
                float f10 = fArr[1];
                float f11 = fArr[2];
                float f12 = fArr[3];
                float f13 = fArr[4];
                float f14 = fArr[5];
                switch (c3) {
                    case 'A':
                    case 'a':
                        i = 7;
                        break;
                    case 'C':
                    case 'c':
                        i = 6;
                        break;
                    case 'H':
                    case 'V':
                    case 'h':
                    case 'v':
                        i = 1;
                        break;
                    case 'L':
                    case 'M':
                    case 'T':
                    case 'l':
                    case 'm':
                    case 't':
                    default:
                        i = 2;
                        break;
                    case 'Q':
                    case 'S':
                    case 'q':
                    case 's':
                        i = 4;
                        break;
                    case 'Z':
                    case 'z':
                        path.close();
                        path.moveTo(f13, f14);
                        f9 = f13;
                        f11 = f9;
                        f10 = f14;
                        f12 = f10;
                        i = 2;
                        break;
                }
                float f15 = f9;
                float f16 = f10;
                float f17 = f13;
                float f18 = f14;
                int i3 = 0;
                char c4 = c;
                while (i3 < fArr2.length) {
                    if (c3 != 'A') {
                        if (c3 != 'C') {
                            if (c3 != 'H') {
                                if (c3 != 'Q') {
                                    if (c3 != 'V') {
                                        if (c3 != 'a') {
                                            if (c3 != 'c') {
                                                if (c3 != 'h') {
                                                    if (c3 != 'q') {
                                                        if (c3 != 'v') {
                                                            if (c3 != 'L') {
                                                                if (c3 != 'M') {
                                                                    if (c3 != 'S') {
                                                                        if (c3 != 'T') {
                                                                            if (c3 != 'l') {
                                                                                if (c3 != 'm') {
                                                                                    if (c3 != 's') {
                                                                                        if (c3 == 't') {
                                                                                            if (c4 != 'q' && c4 != 't' && c4 != 'Q' && c4 != 'T') {
                                                                                                f8 = 0.0f;
                                                                                                f7 = 0.0f;
                                                                                            } else {
                                                                                                f7 = f15 - f11;
                                                                                                f8 = f16 - f12;
                                                                                            }
                                                                                            int i4 = i3 + 0;
                                                                                            int i5 = i3 + 1;
                                                                                            path.rQuadTo(f7, f8, fArr2[i4], fArr2[i5]);
                                                                                            float f19 = f7 + f15;
                                                                                            float f20 = f8 + f16;
                                                                                            f15 += fArr2[i4];
                                                                                            f16 += fArr2[i5];
                                                                                            f12 = f20;
                                                                                            f11 = f19;
                                                                                        }
                                                                                    } else {
                                                                                        if (c4 != 'c' && c4 != 's' && c4 != 'C' && c4 != 'S') {
                                                                                            f6 = 0.0f;
                                                                                            f5 = 0.0f;
                                                                                        } else {
                                                                                            float f21 = f15 - f11;
                                                                                            f5 = f16 - f12;
                                                                                            f6 = f21;
                                                                                        }
                                                                                        int i6 = i3 + 0;
                                                                                        int i7 = i3 + 1;
                                                                                        int i8 = i3 + 2;
                                                                                        int i9 = i3 + 3;
                                                                                        path.rCubicTo(f6, f5, fArr2[i6], fArr2[i7], fArr2[i8], fArr2[i9]);
                                                                                        f = fArr2[i6] + f15;
                                                                                        f2 = fArr2[i7] + f16;
                                                                                        f15 += fArr2[i8];
                                                                                        f3 = fArr2[i9];
                                                                                    }
                                                                                } else {
                                                                                    int i10 = i3 + 0;
                                                                                    f15 += fArr2[i10];
                                                                                    int i11 = i3 + 1;
                                                                                    f16 += fArr2[i11];
                                                                                    if (i3 > 0) {
                                                                                        path.rLineTo(fArr2[i10], fArr2[i11]);
                                                                                    } else {
                                                                                        path.rMoveTo(fArr2[i10], fArr2[i11]);
                                                                                        i2 = i3;
                                                                                        f18 = f16;
                                                                                        f17 = f15;
                                                                                    }
                                                                                }
                                                                            } else {
                                                                                int i12 = i3 + 0;
                                                                                int i13 = i3 + 1;
                                                                                path.rLineTo(fArr2[i12], fArr2[i13]);
                                                                                f15 += fArr2[i12];
                                                                                f4 = fArr2[i13];
                                                                            }
                                                                        } else {
                                                                            if (c4 == 'q' || c4 == 't' || c4 == 'Q' || c4 == 'T') {
                                                                                f15 = (f15 * 2.0f) - f11;
                                                                                f16 = (f16 * 2.0f) - f12;
                                                                            }
                                                                            int i14 = i3 + 0;
                                                                            int i15 = i3 + 1;
                                                                            path.quadTo(f15, f16, fArr2[i14], fArr2[i15]);
                                                                            float f22 = fArr2[i14];
                                                                            float f23 = fArr2[i15];
                                                                            i2 = i3;
                                                                            f12 = f16;
                                                                            f11 = f15;
                                                                            f15 = f22;
                                                                            f16 = f23;
                                                                        }
                                                                    } else {
                                                                        if (c4 == 'c' || c4 == 's' || c4 == 'C' || c4 == 'S') {
                                                                            f15 = (f15 * 2.0f) - f11;
                                                                            f16 = (f16 * 2.0f) - f12;
                                                                        }
                                                                        float f24 = f16;
                                                                        int i16 = i3 + 0;
                                                                        int i17 = i3 + 1;
                                                                        int i18 = i3 + 2;
                                                                        int i19 = i3 + 3;
                                                                        path.cubicTo(f15, f24, fArr2[i16], fArr2[i17], fArr2[i18], fArr2[i19]);
                                                                        f = fArr2[i16];
                                                                        f2 = fArr2[i17];
                                                                        f15 = fArr2[i18];
                                                                        f16 = fArr2[i19];
                                                                        f11 = f;
                                                                        f12 = f2;
                                                                    }
                                                                } else {
                                                                    int i20 = i3 + 0;
                                                                    f15 = fArr2[i20];
                                                                    int i21 = i3 + 1;
                                                                    f16 = fArr2[i21];
                                                                    if (i3 > 0) {
                                                                        path.lineTo(fArr2[i20], fArr2[i21]);
                                                                    } else {
                                                                        path.moveTo(fArr2[i20], fArr2[i21]);
                                                                        i2 = i3;
                                                                        f18 = f16;
                                                                        f17 = f15;
                                                                    }
                                                                }
                                                            } else {
                                                                int i22 = i3 + 0;
                                                                int i23 = i3 + 1;
                                                                path.lineTo(fArr2[i22], fArr2[i23]);
                                                                f15 = fArr2[i22];
                                                                f16 = fArr2[i23];
                                                            }
                                                        } else {
                                                            int i24 = i3 + 0;
                                                            path.rLineTo(0.0f, fArr2[i24]);
                                                            f4 = fArr2[i24];
                                                        }
                                                        f16 += f4;
                                                    } else {
                                                        int i25 = i3 + 0;
                                                        int i26 = i3 + 1;
                                                        int i27 = i3 + 2;
                                                        int i28 = i3 + 3;
                                                        path.rQuadTo(fArr2[i25], fArr2[i26], fArr2[i27], fArr2[i28]);
                                                        f = fArr2[i25] + f15;
                                                        f2 = fArr2[i26] + f16;
                                                        f15 += fArr2[i27];
                                                        f3 = fArr2[i28];
                                                    }
                                                } else {
                                                    int i29 = i3 + 0;
                                                    path.rLineTo(fArr2[i29], 0.0f);
                                                    f15 += fArr2[i29];
                                                }
                                                i2 = i3;
                                            } else {
                                                int i30 = i3 + 2;
                                                int i31 = i3 + 3;
                                                int i32 = i3 + 4;
                                                int i33 = i3 + 5;
                                                path.rCubicTo(fArr2[i3 + 0], fArr2[i3 + 1], fArr2[i30], fArr2[i31], fArr2[i32], fArr2[i33]);
                                                f = fArr2[i30] + f15;
                                                f2 = fArr2[i31] + f16;
                                                f15 += fArr2[i32];
                                                f3 = fArr2[i33];
                                            }
                                            f16 += f3;
                                            f11 = f;
                                            f12 = f2;
                                            i2 = i3;
                                        } else {
                                            int i34 = i3 + 5;
                                            float f25 = fArr2[i34] + f15;
                                            int i35 = i3 + 6;
                                            float f26 = fArr2[i35] + f16;
                                            float f27 = fArr2[i3 + 0];
                                            float f28 = fArr2[i3 + 1];
                                            float f29 = fArr2[i3 + 2];
                                            if (fArr2[i3 + 3] != 0.0f) {
                                                z3 = true;
                                            } else {
                                                z3 = false;
                                            }
                                            if (fArr2[i3 + 4] != 0.0f) {
                                                z4 = true;
                                            } else {
                                                z4 = false;
                                            }
                                            i2 = i3;
                                            drawArc(path, f15, f16, f25, f26, f27, f28, f29, z3, z4);
                                            f15 += fArr2[i34];
                                            f16 += fArr2[i35];
                                        }
                                    } else {
                                        i2 = i3;
                                        int i36 = i2 + 0;
                                        path.lineTo(f15, fArr2[i36]);
                                        f16 = fArr2[i36];
                                    }
                                } else {
                                    i2 = i3;
                                    int i37 = i2 + 0;
                                    int i38 = i2 + 1;
                                    int i39 = i2 + 2;
                                    int i40 = i2 + 3;
                                    path.quadTo(fArr2[i37], fArr2[i38], fArr2[i39], fArr2[i40]);
                                    float f30 = fArr2[i37];
                                    float f31 = fArr2[i38];
                                    f15 = fArr2[i39];
                                    f16 = fArr2[i40];
                                    f11 = f30;
                                    f12 = f31;
                                }
                            } else {
                                i2 = i3;
                                int i41 = i2 + 0;
                                path.lineTo(fArr2[i41], f16);
                                f15 = fArr2[i41];
                            }
                        } else {
                            i2 = i3;
                            int i42 = i2 + 2;
                            int i43 = i2 + 3;
                            int i44 = i2 + 4;
                            int i45 = i2 + 5;
                            path.cubicTo(fArr2[i2 + 0], fArr2[i2 + 1], fArr2[i42], fArr2[i43], fArr2[i44], fArr2[i45]);
                            f15 = fArr2[i44];
                            float f32 = fArr2[i45];
                            float f33 = fArr2[i42];
                            float f34 = fArr2[i43];
                            f16 = f32;
                            f12 = f34;
                            f11 = f33;
                        }
                        i3 = i2 + i;
                        c4 = c2;
                        c3 = c4;
                    } else {
                        i2 = i3;
                        float f35 = f16;
                        float f36 = f15;
                        int i46 = i2 + 5;
                        float f37 = fArr2[i46];
                        int i47 = i2 + 6;
                        float f38 = fArr2[i47];
                        float f39 = fArr2[i2 + 0];
                        float f40 = fArr2[i2 + 1];
                        float f41 = fArr2[i2 + 2];
                        if (fArr2[i2 + 3] != 0.0f) {
                            z = true;
                        } else {
                            z = false;
                        }
                        if (fArr2[i2 + 4] != 0.0f) {
                            z2 = true;
                        } else {
                            z2 = false;
                        }
                        drawArc(path, f36, f35, f37, f38, f39, f40, f41, z, z2);
                        f15 = fArr2[i46];
                        f16 = fArr2[i47];
                    }
                    f12 = f16;
                    f11 = f15;
                    i3 = i2 + i;
                    c4 = c2;
                    c3 = c4;
                }
                fArr[0] = f15;
                fArr[1] = f16;
                fArr[2] = f11;
                fArr[3] = f12;
                fArr[4] = f17;
                fArr[5] = f18;
            }
        }

        public static void arcToBezier(Path path, double d, double d2, double d3, double d4, double d5, double d6, double d7, double d8, double d9) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeCommon(65539, null, new Object[]{path, Double.valueOf(d), Double.valueOf(d2), Double.valueOf(d3), Double.valueOf(d4), Double.valueOf(d5), Double.valueOf(d6), Double.valueOf(d7), Double.valueOf(d8), Double.valueOf(d9)}) == null) {
                double d10 = d3;
                int ceil = (int) Math.ceil(Math.abs((d9 * 4.0d) / 3.141592653589793d));
                double cos = Math.cos(d7);
                double sin = Math.sin(d7);
                double cos2 = Math.cos(d8);
                double sin2 = Math.sin(d8);
                double d11 = -d10;
                double d12 = d11 * cos;
                double d13 = d4 * sin;
                double d14 = (d12 * sin2) - (d13 * cos2);
                double d15 = d11 * sin;
                double d16 = d4 * cos;
                double d17 = (sin2 * d15) + (cos2 * d16);
                double d18 = d9 / ceil;
                double d19 = d8;
                double d20 = d17;
                double d21 = d14;
                int i = 0;
                double d22 = d5;
                double d23 = d6;
                while (i < ceil) {
                    double d24 = d19 + d18;
                    double sin3 = Math.sin(d24);
                    double cos3 = Math.cos(d24);
                    double d25 = (d + ((d10 * cos) * cos3)) - (d13 * sin3);
                    double d26 = d2 + (d10 * sin * cos3) + (d16 * sin3);
                    double d27 = (d12 * sin3) - (d13 * cos3);
                    double d28 = (sin3 * d15) + (cos3 * d16);
                    double d29 = d24 - d19;
                    double tan = Math.tan(d29 / 2.0d);
                    double sin4 = (Math.sin(d29) * (Math.sqrt(((tan * 3.0d) * tan) + 4.0d) - 1.0d)) / 3.0d;
                    double d30 = d22 + (d21 * sin4);
                    path.rLineTo(0.0f, 0.0f);
                    path.cubicTo((float) d30, (float) (d23 + (d20 * sin4)), (float) (d25 - (sin4 * d27)), (float) (d26 - (sin4 * d28)), (float) d25, (float) d26);
                    i++;
                    d18 = d18;
                    sin = sin;
                    d22 = d25;
                    d15 = d15;
                    cos = cos;
                    d19 = d24;
                    d20 = d28;
                    d21 = d27;
                    ceil = ceil;
                    d23 = d26;
                    d10 = d3;
                }
            }
        }

        public static void drawArc(Path path, float f, float f2, float f3, float f4, float f5, float f6, float f7, boolean z, boolean z2) {
            double d;
            double d2;
            boolean z3;
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeCommon(InputDeviceCompat.SOURCE_TRACKBALL, null, new Object[]{path, Float.valueOf(f), Float.valueOf(f2), Float.valueOf(f3), Float.valueOf(f4), Float.valueOf(f5), Float.valueOf(f6), Float.valueOf(f7), Boolean.valueOf(z), Boolean.valueOf(z2)}) == null) {
                double radians = Math.toRadians(f7);
                double cos = Math.cos(radians);
                double sin = Math.sin(radians);
                double d3 = f;
                double d4 = d3 * cos;
                double d5 = f2;
                double d6 = f5;
                double d7 = (d4 + (d5 * sin)) / d6;
                double d8 = f6;
                double d9 = (((-f) * sin) + (d5 * cos)) / d8;
                double d10 = f4;
                double d11 = ((f3 * cos) + (d10 * sin)) / d6;
                double d12 = (((-f3) * sin) + (d10 * cos)) / d8;
                double d13 = d7 - d11;
                double d14 = d9 - d12;
                double d15 = (d7 + d11) / 2.0d;
                double d16 = (d9 + d12) / 2.0d;
                double d17 = (d13 * d13) + (d14 * d14);
                if (d17 == 0.0d) {
                    Log.w(PathParser.LOGTAG, " Points are coincident");
                    return;
                }
                double d18 = (1.0d / d17) - 0.25d;
                if (d18 < 0.0d) {
                    Log.w(PathParser.LOGTAG, "Points are too far apart " + d17);
                    float sqrt = (float) (Math.sqrt(d17) / 1.99999d);
                    drawArc(path, f, f2, f3, f4, f5 * sqrt, f6 * sqrt, f7, z, z2);
                    return;
                }
                double sqrt2 = Math.sqrt(d18);
                double d19 = d13 * sqrt2;
                double d20 = sqrt2 * d14;
                if (z == z2) {
                    d = d15 - d20;
                    d2 = d16 + d19;
                } else {
                    d = d15 + d20;
                    d2 = d16 - d19;
                }
                double atan2 = Math.atan2(d9 - d2, d7 - d);
                double atan22 = Math.atan2(d12 - d2, d11 - d) - atan2;
                int i = (atan22 > 0.0d ? 1 : (atan22 == 0.0d ? 0 : -1));
                if (i >= 0) {
                    z3 = true;
                } else {
                    z3 = false;
                }
                if (z2 != z3) {
                    if (i > 0) {
                        atan22 -= 6.283185307179586d;
                    } else {
                        atan22 += 6.283185307179586d;
                    }
                }
                double d21 = d * d6;
                double d22 = d2 * d8;
                arcToBezier(path, (d21 * cos) - (d22 * sin), (d21 * sin) + (d22 * cos), d6, d8, d3, d5, radians, atan2, atan22);
            }
        }

        public static void nodesToPath(PathDataNode[] pathDataNodeArr, Path path) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(65541, null, pathDataNodeArr, path) == null) {
                float[] fArr = new float[6];
                char c = 'm';
                for (int i = 0; i < pathDataNodeArr.length; i++) {
                    addCommand(path, fArr, c, pathDataNodeArr[i].mType, pathDataNodeArr[i].mParams);
                    c = pathDataNodeArr[i].mType;
                }
            }
        }

        public void interpolatePathDataNode(PathDataNode pathDataNode, PathDataNode pathDataNode2, float f) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeCommon(1048576, this, new Object[]{pathDataNode, pathDataNode2, Float.valueOf(f)}) == null) {
                this.mType = pathDataNode.mType;
                int i = 0;
                while (true) {
                    float[] fArr = pathDataNode.mParams;
                    if (i < fArr.length) {
                        this.mParams[i] = (fArr[i] * (1.0f - f)) + (pathDataNode2.mParams[i] * f);
                        i++;
                    } else {
                        return;
                    }
                }
            }
        }
    }

    public PathParser() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
            }
        }
    }

    public static void addNode(ArrayList<PathDataNode> arrayList, char c, float[] fArr) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(65537, null, new Object[]{arrayList, Character.valueOf(c), fArr}) == null) {
            arrayList.add(new PathDataNode(c, fArr));
        }
    }

    public static boolean canMorph(PathDataNode[] pathDataNodeArr, PathDataNode[] pathDataNodeArr2) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65538, null, pathDataNodeArr, pathDataNodeArr2)) == null) {
            if (pathDataNodeArr == null || pathDataNodeArr2 == null || pathDataNodeArr.length != pathDataNodeArr2.length) {
                return false;
            }
            for (int i = 0; i < pathDataNodeArr.length; i++) {
                if (pathDataNodeArr[i].mType != pathDataNodeArr2[i].mType || pathDataNodeArr[i].mParams.length != pathDataNodeArr2[i].mParams.length) {
                    return false;
                }
            }
            return true;
        }
        return invokeLL.booleanValue;
    }

    public static int nextStart(String str, int i) {
        InterceptResult invokeLI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLI = interceptable.invokeLI(65546, null, str, i)) == null) {
            while (i < str.length()) {
                char charAt = str.charAt(i);
                if (((charAt - 'A') * (charAt - 'Z') <= 0 || (charAt - 'a') * (charAt - 'z') <= 0) && charAt != 'e' && charAt != 'E') {
                    return i;
                }
                i++;
            }
            return i;
        }
        return invokeLI.intValue;
    }

    public static void updateNodes(PathDataNode[] pathDataNodeArr, PathDataNode[] pathDataNodeArr2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65547, null, pathDataNodeArr, pathDataNodeArr2) == null) {
            for (int i = 0; i < pathDataNodeArr2.length; i++) {
                pathDataNodeArr[i].mType = pathDataNodeArr2[i].mType;
                for (int i2 = 0; i2 < pathDataNodeArr2[i].mParams.length; i2++) {
                    pathDataNodeArr[i].mParams[i2] = pathDataNodeArr2[i].mParams[i2];
                }
            }
        }
    }

    public static float[] copyOfRange(float[] fArr, int i, int i2) {
        InterceptResult invokeLII;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLII = interceptable.invokeLII(65539, null, fArr, i, i2)) == null) {
            if (i <= i2) {
                int length = fArr.length;
                if (i >= 0 && i <= length) {
                    int i3 = i2 - i;
                    int min = Math.min(i3, length - i);
                    float[] fArr2 = new float[i3];
                    System.arraycopy(fArr, i, fArr2, 0, min);
                    return fArr2;
                }
                throw new ArrayIndexOutOfBoundsException();
            }
            throw new IllegalArgumentException();
        }
        return (float[]) invokeLII.objValue;
    }

    public static PathDataNode[] createNodesFromPathData(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(InputDeviceCompat.SOURCE_TRACKBALL, null, str)) == null) {
            if (str == null) {
                return null;
            }
            ArrayList arrayList = new ArrayList();
            int i = 1;
            int i2 = 0;
            while (i < str.length()) {
                int nextStart = nextStart(str, i);
                String trim = str.substring(i2, nextStart).trim();
                if (trim.length() > 0) {
                    addNode(arrayList, trim.charAt(0), getFloats(trim));
                }
                i2 = nextStart;
                i = nextStart + 1;
            }
            if (i - i2 == 1 && i2 < str.length()) {
                addNode(arrayList, str.charAt(i2), new float[0]);
            }
            return (PathDataNode[]) arrayList.toArray(new PathDataNode[arrayList.size()]);
        }
        return (PathDataNode[]) invokeL.objValue;
    }

    public static float[] getFloats(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65544, null, str)) == null) {
            if (str.charAt(0) != 'z' && str.charAt(0) != 'Z') {
                try {
                    float[] fArr = new float[str.length()];
                    ExtractFloatResult extractFloatResult = new ExtractFloatResult();
                    int length = str.length();
                    int i = 1;
                    int i2 = 0;
                    while (i < length) {
                        extract(str, i, extractFloatResult);
                        int i3 = extractFloatResult.mEndPosition;
                        if (i < i3) {
                            fArr[i2] = Float.parseFloat(str.substring(i, i3));
                            i2++;
                        }
                        if (extractFloatResult.mEndWithNegOrDot) {
                            i = i3;
                        } else {
                            i = i3 + 1;
                        }
                    }
                    return copyOfRange(fArr, 0, i2);
                } catch (NumberFormatException e) {
                    throw new RuntimeException("error in parsing \"" + str + "\"", e);
                }
            }
            return new float[0];
        }
        return (float[]) invokeL.objValue;
    }

    public static Path createPathFromPathData(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65541, null, str)) == null) {
            Path path = new Path();
            PathDataNode[] createNodesFromPathData = createNodesFromPathData(str);
            if (createNodesFromPathData != null) {
                try {
                    PathDataNode.nodesToPath(createNodesFromPathData, path);
                    return path;
                } catch (RuntimeException e) {
                    throw new RuntimeException("Error in parsing " + str, e);
                }
            }
            return null;
        }
        return (Path) invokeL.objValue;
    }

    public static PathDataNode[] deepCopyNodes(PathDataNode[] pathDataNodeArr) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65542, null, pathDataNodeArr)) == null) {
            if (pathDataNodeArr == null) {
                return null;
            }
            PathDataNode[] pathDataNodeArr2 = new PathDataNode[pathDataNodeArr.length];
            for (int i = 0; i < pathDataNodeArr.length; i++) {
                pathDataNodeArr2[i] = new PathDataNode(pathDataNodeArr[i]);
            }
            return pathDataNodeArr2;
        }
        return (PathDataNode[]) invokeL.objValue;
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Removed duplicated region for block: B:26:0x003e A[LOOP:0: B:5:0x000b->B:26:0x003e, LOOP_END] */
    /* JADX WARN: Removed duplicated region for block: B:33:0x0041 A[SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static void extract(String str, int i, ExtractFloatResult extractFloatResult) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLIL(65543, null, str, i, extractFloatResult) == null) {
            extractFloatResult.mEndWithNegOrDot = false;
            boolean z = false;
            boolean z2 = false;
            boolean z3 = false;
            for (int i2 = i; i2 < str.length(); i2++) {
                char charAt = str.charAt(i2);
                if (charAt != ' ') {
                    if (charAt != 'E' && charAt != 'e') {
                        switch (charAt) {
                            case ',':
                                break;
                            case '-':
                                if (i2 != i && !z) {
                                    extractFloatResult.mEndWithNegOrDot = true;
                                    break;
                                }
                                z = false;
                                break;
                            case '.':
                                if (!z2) {
                                    z = false;
                                    z2 = true;
                                    break;
                                } else {
                                    extractFloatResult.mEndWithNegOrDot = true;
                                    break;
                                }
                            default:
                                z = false;
                                break;
                        }
                    } else {
                        z = true;
                    }
                    if (!z3) {
                        extractFloatResult.mEndPosition = i2;
                    }
                }
                z = false;
                z3 = true;
                if (!z3) {
                }
            }
            extractFloatResult.mEndPosition = i2;
        }
    }

    public static boolean interpolatePathDataNodes(PathDataNode[] pathDataNodeArr, PathDataNode[] pathDataNodeArr2, PathDataNode[] pathDataNodeArr3, float f) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(65545, null, new Object[]{pathDataNodeArr, pathDataNodeArr2, pathDataNodeArr3, Float.valueOf(f)})) == null) {
            if (pathDataNodeArr != null && pathDataNodeArr2 != null && pathDataNodeArr3 != null) {
                if (pathDataNodeArr.length == pathDataNodeArr2.length && pathDataNodeArr2.length == pathDataNodeArr3.length) {
                    if (!canMorph(pathDataNodeArr2, pathDataNodeArr3)) {
                        return false;
                    }
                    for (int i = 0; i < pathDataNodeArr.length; i++) {
                        pathDataNodeArr[i].interpolatePathDataNode(pathDataNodeArr2[i], pathDataNodeArr3[i], f);
                    }
                    return true;
                }
                throw new IllegalArgumentException("The nodes to be interpolated and resulting nodes must have the same length");
            }
            throw new IllegalArgumentException("The nodes to be interpolated and resulting nodes cannot be null");
        }
        return invokeCommon.booleanValue;
    }
}
