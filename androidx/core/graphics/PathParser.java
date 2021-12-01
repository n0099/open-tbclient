package androidx.core.graphics;

import android.graphics.Path;
import androidx.annotation.Nullable;
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
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                }
            }
        }
    }

    public PathParser() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
            }
        }
    }

    public static void addNode(ArrayList<PathDataNode> arrayList, char c2, float[] fArr) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(65537, null, new Object[]{arrayList, Character.valueOf(c2), fArr}) == null) {
            arrayList.add(new PathDataNode(c2, fArr));
        }
    }

    public static boolean canMorph(@Nullable PathDataNode[] pathDataNodeArr, @Nullable PathDataNode[] pathDataNodeArr2) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65538, null, pathDataNodeArr, pathDataNodeArr2)) == null) {
            if (pathDataNodeArr == null || pathDataNodeArr2 == null || pathDataNodeArr.length != pathDataNodeArr2.length) {
                return false;
            }
            for (int i2 = 0; i2 < pathDataNodeArr.length; i2++) {
                if (pathDataNodeArr[i2].mType != pathDataNodeArr2[i2].mType || pathDataNodeArr[i2].mParams.length != pathDataNodeArr2[i2].mParams.length) {
                    return false;
                }
            }
            return true;
        }
        return invokeLL.booleanValue;
    }

    public static float[] copyOfRange(float[] fArr, int i2, int i3) {
        InterceptResult invokeLII;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLII = interceptable.invokeLII(65539, null, fArr, i2, i3)) == null) {
            if (i2 <= i3) {
                int length = fArr.length;
                if (i2 >= 0 && i2 <= length) {
                    int i4 = i3 - i2;
                    int min = Math.min(i4, length - i2);
                    float[] fArr2 = new float[i4];
                    System.arraycopy(fArr, i2, fArr2, 0, min);
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
            int i2 = 1;
            int i3 = 0;
            while (i2 < str.length()) {
                int nextStart = nextStart(str, i2);
                String trim = str.substring(i3, nextStart).trim();
                if (trim.length() > 0) {
                    addNode(arrayList, trim.charAt(0), getFloats(trim));
                }
                i3 = nextStart;
                i2 = nextStart + 1;
            }
            if (i2 - i3 == 1 && i3 < str.length()) {
                addNode(arrayList, str.charAt(i3), new float[0]);
            }
            return (PathDataNode[]) arrayList.toArray(new PathDataNode[arrayList.size()]);
        }
        return (PathDataNode[]) invokeL.objValue;
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
                } catch (RuntimeException e2) {
                    throw new RuntimeException("Error in parsing " + str, e2);
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
            for (int i2 = 0; i2 < pathDataNodeArr.length; i2++) {
                pathDataNodeArr2[i2] = new PathDataNode(pathDataNodeArr[i2]);
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
    public static void extract(String str, int i2, ExtractFloatResult extractFloatResult) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLIL(65543, null, str, i2, extractFloatResult) == null) {
            extractFloatResult.mEndWithNegOrDot = false;
            boolean z = false;
            boolean z2 = false;
            boolean z3 = false;
            for (int i3 = i2; i3 < str.length(); i3++) {
                char charAt = str.charAt(i3);
                if (charAt != ' ') {
                    if (charAt != 'E' && charAt != 'e') {
                        switch (charAt) {
                            case ',':
                                break;
                            case '-':
                                if (i3 != i2 && !z) {
                                    extractFloatResult.mEndWithNegOrDot = true;
                                    break;
                                }
                                z = false;
                                break;
                            case '.':
                                if (z2) {
                                    extractFloatResult.mEndWithNegOrDot = true;
                                    break;
                                } else {
                                    z = false;
                                    z2 = true;
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
                        extractFloatResult.mEndPosition = i3;
                    }
                }
                z = false;
                z3 = true;
                if (!z3) {
                }
            }
            extractFloatResult.mEndPosition = i3;
        }
    }

    public static float[] getFloats(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65544, null, str)) == null) {
            if (str.charAt(0) == 'z' || str.charAt(0) == 'Z') {
                return new float[0];
            }
            try {
                float[] fArr = new float[str.length()];
                ExtractFloatResult extractFloatResult = new ExtractFloatResult();
                int length = str.length();
                int i2 = 1;
                int i3 = 0;
                while (i2 < length) {
                    extract(str, i2, extractFloatResult);
                    int i4 = extractFloatResult.mEndPosition;
                    if (i2 < i4) {
                        fArr[i3] = Float.parseFloat(str.substring(i2, i4));
                        i3++;
                    }
                    i2 = extractFloatResult.mEndWithNegOrDot ? i4 : i4 + 1;
                }
                return copyOfRange(fArr, 0, i3);
            } catch (NumberFormatException e2) {
                throw new RuntimeException("error in parsing \"" + str + "\"", e2);
            }
        }
        return (float[]) invokeL.objValue;
    }

    public static boolean interpolatePathDataNodes(PathDataNode[] pathDataNodeArr, PathDataNode[] pathDataNodeArr2, PathDataNode[] pathDataNodeArr3, float f2) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(65545, null, new Object[]{pathDataNodeArr, pathDataNodeArr2, pathDataNodeArr3, Float.valueOf(f2)})) == null) {
            if (pathDataNodeArr != null && pathDataNodeArr2 != null && pathDataNodeArr3 != null) {
                if (pathDataNodeArr.length == pathDataNodeArr2.length && pathDataNodeArr2.length == pathDataNodeArr3.length) {
                    if (canMorph(pathDataNodeArr2, pathDataNodeArr3)) {
                        for (int i2 = 0; i2 < pathDataNodeArr.length; i2++) {
                            pathDataNodeArr[i2].interpolatePathDataNode(pathDataNodeArr2[i2], pathDataNodeArr3[i2], f2);
                        }
                        return true;
                    }
                    return false;
                }
                throw new IllegalArgumentException("The nodes to be interpolated and resulting nodes must have the same length");
            }
            throw new IllegalArgumentException("The nodes to be interpolated and resulting nodes cannot be null");
        }
        return invokeCommon.booleanValue;
    }

    public static int nextStart(String str, int i2) {
        InterceptResult invokeLI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLI = interceptable.invokeLI(65546, null, str, i2)) == null) {
            while (i2 < str.length()) {
                char charAt = str.charAt(i2);
                if (((charAt - 'A') * (charAt - 'Z') <= 0 || (charAt - 'a') * (charAt - 'z') <= 0) && charAt != 'e' && charAt != 'E') {
                    return i2;
                }
                i2++;
            }
            return i2;
        }
        return invokeLI.intValue;
    }

    public static void updateNodes(PathDataNode[] pathDataNodeArr, PathDataNode[] pathDataNodeArr2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65547, null, pathDataNodeArr, pathDataNodeArr2) == null) {
            for (int i2 = 0; i2 < pathDataNodeArr2.length; i2++) {
                pathDataNodeArr[i2].mType = pathDataNodeArr2[i2].mType;
                for (int i3 = 0; i3 < pathDataNodeArr2[i2].mParams.length; i3++) {
                    pathDataNodeArr[i2].mParams[i3] = pathDataNodeArr2[i2].mParams[i3];
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

        public PathDataNode(char c2, float[] fArr) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {Character.valueOf(c2), fArr};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.mType = c2;
            this.mParams = fArr;
        }

        /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
        public static void addCommand(Path path, float[] fArr, char c2, char c3, float[] fArr2) {
            int i2;
            int i3;
            float f2;
            float f3;
            float f4;
            float f5;
            float f6;
            float f7;
            float f8;
            float f9;
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeCommon(65538, null, new Object[]{path, fArr, Character.valueOf(c2), Character.valueOf(c3), fArr2}) == null) {
                char c4 = c3;
                float f10 = fArr[0];
                float f11 = fArr[1];
                float f12 = fArr[2];
                float f13 = fArr[3];
                float f14 = fArr[4];
                float f15 = fArr[5];
                switch (c4) {
                    case 'A':
                    case 'a':
                        i2 = 7;
                        break;
                    case 'C':
                    case 'c':
                        i2 = 6;
                        break;
                    case 'H':
                    case 'V':
                    case 'h':
                    case 'v':
                        i2 = 1;
                        break;
                    case 'L':
                    case 'M':
                    case 'T':
                    case 'l':
                    case 'm':
                    case 't':
                    default:
                        i2 = 2;
                        break;
                    case 'Q':
                    case 'S':
                    case 'q':
                    case 's':
                        i2 = 4;
                        break;
                    case 'Z':
                    case 'z':
                        path.close();
                        path.moveTo(f14, f15);
                        f10 = f14;
                        f12 = f10;
                        f11 = f15;
                        f13 = f11;
                        i2 = 2;
                        break;
                }
                float f16 = f10;
                float f17 = f11;
                float f18 = f14;
                float f19 = f15;
                int i4 = 0;
                char c5 = c2;
                while (i4 < fArr2.length) {
                    if (c4 != 'A') {
                        if (c4 == 'C') {
                            i3 = i4;
                            int i5 = i3 + 2;
                            int i6 = i3 + 3;
                            int i7 = i3 + 4;
                            int i8 = i3 + 5;
                            path.cubicTo(fArr2[i3 + 0], fArr2[i3 + 1], fArr2[i5], fArr2[i6], fArr2[i7], fArr2[i8]);
                            f16 = fArr2[i7];
                            float f20 = fArr2[i8];
                            float f21 = fArr2[i5];
                            float f22 = fArr2[i6];
                            f17 = f20;
                            f13 = f22;
                            f12 = f21;
                        } else if (c4 == 'H') {
                            i3 = i4;
                            int i9 = i3 + 0;
                            path.lineTo(fArr2[i9], f17);
                            f16 = fArr2[i9];
                        } else if (c4 == 'Q') {
                            i3 = i4;
                            int i10 = i3 + 0;
                            int i11 = i3 + 1;
                            int i12 = i3 + 2;
                            int i13 = i3 + 3;
                            path.quadTo(fArr2[i10], fArr2[i11], fArr2[i12], fArr2[i13]);
                            float f23 = fArr2[i10];
                            float f24 = fArr2[i11];
                            f16 = fArr2[i12];
                            f17 = fArr2[i13];
                            f12 = f23;
                            f13 = f24;
                        } else if (c4 == 'V') {
                            i3 = i4;
                            int i14 = i3 + 0;
                            path.lineTo(f16, fArr2[i14]);
                            f17 = fArr2[i14];
                        } else if (c4 != 'a') {
                            if (c4 != 'c') {
                                if (c4 == 'h') {
                                    int i15 = i4 + 0;
                                    path.rLineTo(fArr2[i15], 0.0f);
                                    f16 += fArr2[i15];
                                } else if (c4 != 'q') {
                                    if (c4 == 'v') {
                                        int i16 = i4 + 0;
                                        path.rLineTo(0.0f, fArr2[i16]);
                                        f5 = fArr2[i16];
                                    } else if (c4 == 'L') {
                                        int i17 = i4 + 0;
                                        int i18 = i4 + 1;
                                        path.lineTo(fArr2[i17], fArr2[i18]);
                                        f16 = fArr2[i17];
                                        f17 = fArr2[i18];
                                    } else if (c4 == 'M') {
                                        int i19 = i4 + 0;
                                        f16 = fArr2[i19];
                                        int i20 = i4 + 1;
                                        f17 = fArr2[i20];
                                        if (i4 > 0) {
                                            path.lineTo(fArr2[i19], fArr2[i20]);
                                        } else {
                                            path.moveTo(fArr2[i19], fArr2[i20]);
                                            i3 = i4;
                                            f19 = f17;
                                            f18 = f16;
                                        }
                                    } else if (c4 == 'S') {
                                        if (c5 == 'c' || c5 == 's' || c5 == 'C' || c5 == 'S') {
                                            f16 = (f16 * 2.0f) - f12;
                                            f17 = (f17 * 2.0f) - f13;
                                        }
                                        float f25 = f17;
                                        int i21 = i4 + 0;
                                        int i22 = i4 + 1;
                                        int i23 = i4 + 2;
                                        int i24 = i4 + 3;
                                        path.cubicTo(f16, f25, fArr2[i21], fArr2[i22], fArr2[i23], fArr2[i24]);
                                        f2 = fArr2[i21];
                                        f3 = fArr2[i22];
                                        f16 = fArr2[i23];
                                        f17 = fArr2[i24];
                                        f12 = f2;
                                        f13 = f3;
                                    } else if (c4 == 'T') {
                                        if (c5 == 'q' || c5 == 't' || c5 == 'Q' || c5 == 'T') {
                                            f16 = (f16 * 2.0f) - f12;
                                            f17 = (f17 * 2.0f) - f13;
                                        }
                                        int i25 = i4 + 0;
                                        int i26 = i4 + 1;
                                        path.quadTo(f16, f17, fArr2[i25], fArr2[i26]);
                                        float f26 = fArr2[i25];
                                        float f27 = fArr2[i26];
                                        i3 = i4;
                                        f13 = f17;
                                        f12 = f16;
                                        f16 = f26;
                                        f17 = f27;
                                    } else if (c4 == 'l') {
                                        int i27 = i4 + 0;
                                        int i28 = i4 + 1;
                                        path.rLineTo(fArr2[i27], fArr2[i28]);
                                        f16 += fArr2[i27];
                                        f5 = fArr2[i28];
                                    } else if (c4 == 'm') {
                                        int i29 = i4 + 0;
                                        f16 += fArr2[i29];
                                        int i30 = i4 + 1;
                                        f17 += fArr2[i30];
                                        if (i4 > 0) {
                                            path.rLineTo(fArr2[i29], fArr2[i30]);
                                        } else {
                                            path.rMoveTo(fArr2[i29], fArr2[i30]);
                                            i3 = i4;
                                            f19 = f17;
                                            f18 = f16;
                                        }
                                    } else if (c4 == 's') {
                                        if (c5 == 'c' || c5 == 's' || c5 == 'C' || c5 == 'S') {
                                            float f28 = f16 - f12;
                                            f6 = f17 - f13;
                                            f7 = f28;
                                        } else {
                                            f7 = 0.0f;
                                            f6 = 0.0f;
                                        }
                                        int i31 = i4 + 0;
                                        int i32 = i4 + 1;
                                        int i33 = i4 + 2;
                                        int i34 = i4 + 3;
                                        path.rCubicTo(f7, f6, fArr2[i31], fArr2[i32], fArr2[i33], fArr2[i34]);
                                        f2 = fArr2[i31] + f16;
                                        f3 = fArr2[i32] + f17;
                                        f16 += fArr2[i33];
                                        f4 = fArr2[i34];
                                    } else if (c4 == 't') {
                                        if (c5 == 'q' || c5 == 't' || c5 == 'Q' || c5 == 'T') {
                                            f8 = f16 - f12;
                                            f9 = f17 - f13;
                                        } else {
                                            f9 = 0.0f;
                                            f8 = 0.0f;
                                        }
                                        int i35 = i4 + 0;
                                        int i36 = i4 + 1;
                                        path.rQuadTo(f8, f9, fArr2[i35], fArr2[i36]);
                                        float f29 = f8 + f16;
                                        float f30 = f9 + f17;
                                        f16 += fArr2[i35];
                                        f17 += fArr2[i36];
                                        f13 = f30;
                                        f12 = f29;
                                    }
                                    f17 += f5;
                                } else {
                                    int i37 = i4 + 0;
                                    int i38 = i4 + 1;
                                    int i39 = i4 + 2;
                                    int i40 = i4 + 3;
                                    path.rQuadTo(fArr2[i37], fArr2[i38], fArr2[i39], fArr2[i40]);
                                    f2 = fArr2[i37] + f16;
                                    f3 = fArr2[i38] + f17;
                                    f16 += fArr2[i39];
                                    f4 = fArr2[i40];
                                }
                                i3 = i4;
                            } else {
                                int i41 = i4 + 2;
                                int i42 = i4 + 3;
                                int i43 = i4 + 4;
                                int i44 = i4 + 5;
                                path.rCubicTo(fArr2[i4 + 0], fArr2[i4 + 1], fArr2[i41], fArr2[i42], fArr2[i43], fArr2[i44]);
                                f2 = fArr2[i41] + f16;
                                f3 = fArr2[i42] + f17;
                                f16 += fArr2[i43];
                                f4 = fArr2[i44];
                            }
                            f17 += f4;
                            f12 = f2;
                            f13 = f3;
                            i3 = i4;
                        } else {
                            int i45 = i4 + 5;
                            int i46 = i4 + 6;
                            i3 = i4;
                            drawArc(path, f16, f17, fArr2[i45] + f16, fArr2[i46] + f17, fArr2[i4 + 0], fArr2[i4 + 1], fArr2[i4 + 2], fArr2[i4 + 3] != 0.0f, fArr2[i4 + 4] != 0.0f);
                            f16 += fArr2[i45];
                            f17 += fArr2[i46];
                        }
                        i4 = i3 + i2;
                        c5 = c3;
                        c4 = c5;
                    } else {
                        i3 = i4;
                        int i47 = i3 + 5;
                        int i48 = i3 + 6;
                        drawArc(path, f16, f17, fArr2[i47], fArr2[i48], fArr2[i3 + 0], fArr2[i3 + 1], fArr2[i3 + 2], fArr2[i3 + 3] != 0.0f, fArr2[i3 + 4] != 0.0f);
                        f16 = fArr2[i47];
                        f17 = fArr2[i48];
                    }
                    f13 = f17;
                    f12 = f16;
                    i4 = i3 + i2;
                    c5 = c3;
                    c4 = c5;
                }
                fArr[0] = f16;
                fArr[1] = f17;
                fArr[2] = f12;
                fArr[3] = f13;
                fArr[4] = f18;
                fArr[5] = f19;
            }
        }

        public static void arcToBezier(Path path, double d2, double d3, double d4, double d5, double d6, double d7, double d8, double d9, double d10) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeCommon(65539, null, new Object[]{path, Double.valueOf(d2), Double.valueOf(d3), Double.valueOf(d4), Double.valueOf(d5), Double.valueOf(d6), Double.valueOf(d7), Double.valueOf(d8), Double.valueOf(d9), Double.valueOf(d10)}) == null) {
                double d11 = d4;
                int ceil = (int) Math.ceil(Math.abs((d10 * 4.0d) / 3.141592653589793d));
                double cos = Math.cos(d8);
                double sin = Math.sin(d8);
                double cos2 = Math.cos(d9);
                double sin2 = Math.sin(d9);
                double d12 = -d11;
                double d13 = d12 * cos;
                double d14 = d5 * sin;
                double d15 = (d13 * sin2) - (d14 * cos2);
                double d16 = d12 * sin;
                double d17 = d5 * cos;
                double d18 = (sin2 * d16) + (cos2 * d17);
                double d19 = d10 / ceil;
                double d20 = d9;
                double d21 = d18;
                double d22 = d15;
                int i2 = 0;
                double d23 = d6;
                double d24 = d7;
                while (i2 < ceil) {
                    double d25 = d20 + d19;
                    double sin3 = Math.sin(d25);
                    double cos3 = Math.cos(d25);
                    double d26 = (d2 + ((d11 * cos) * cos3)) - (d14 * sin3);
                    double d27 = d3 + (d11 * sin * cos3) + (d17 * sin3);
                    double d28 = (d13 * sin3) - (d14 * cos3);
                    double d29 = (sin3 * d16) + (cos3 * d17);
                    double d30 = d25 - d20;
                    double tan = Math.tan(d30 / 2.0d);
                    double sin4 = (Math.sin(d30) * (Math.sqrt(((tan * 3.0d) * tan) + 4.0d) - 1.0d)) / 3.0d;
                    double d31 = d23 + (d22 * sin4);
                    path.rLineTo(0.0f, 0.0f);
                    path.cubicTo((float) d31, (float) (d24 + (d21 * sin4)), (float) (d26 - (sin4 * d28)), (float) (d27 - (sin4 * d29)), (float) d26, (float) d27);
                    i2++;
                    d19 = d19;
                    sin = sin;
                    d23 = d26;
                    d16 = d16;
                    cos = cos;
                    d20 = d25;
                    d21 = d29;
                    d22 = d28;
                    ceil = ceil;
                    d24 = d27;
                    d11 = d4;
                }
            }
        }

        public static void drawArc(Path path, float f2, float f3, float f4, float f5, float f6, float f7, float f8, boolean z, boolean z2) {
            double d2;
            double d3;
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeCommon(InputDeviceCompat.SOURCE_TRACKBALL, null, new Object[]{path, Float.valueOf(f2), Float.valueOf(f3), Float.valueOf(f4), Float.valueOf(f5), Float.valueOf(f6), Float.valueOf(f7), Float.valueOf(f8), Boolean.valueOf(z), Boolean.valueOf(z2)}) == null) {
                double radians = Math.toRadians(f8);
                double cos = Math.cos(radians);
                double sin = Math.sin(radians);
                double d4 = f2;
                double d5 = d4 * cos;
                double d6 = f3;
                double d7 = f6;
                double d8 = (d5 + (d6 * sin)) / d7;
                double d9 = f7;
                double d10 = (((-f2) * sin) + (d6 * cos)) / d9;
                double d11 = f5;
                double d12 = ((f4 * cos) + (d11 * sin)) / d7;
                double d13 = (((-f4) * sin) + (d11 * cos)) / d9;
                double d14 = d8 - d12;
                double d15 = d10 - d13;
                double d16 = (d8 + d12) / 2.0d;
                double d17 = (d10 + d13) / 2.0d;
                double d18 = (d14 * d14) + (d15 * d15);
                if (d18 == 0.0d) {
                    return;
                }
                double d19 = (1.0d / d18) - 0.25d;
                if (d19 < 0.0d) {
                    String str = "Points are too far apart " + d18;
                    float sqrt = (float) (Math.sqrt(d18) / 1.99999d);
                    drawArc(path, f2, f3, f4, f5, f6 * sqrt, f7 * sqrt, f8, z, z2);
                    return;
                }
                double sqrt2 = Math.sqrt(d19);
                double d20 = d14 * sqrt2;
                double d21 = sqrt2 * d15;
                if (z == z2) {
                    d2 = d16 - d21;
                    d3 = d17 + d20;
                } else {
                    d2 = d16 + d21;
                    d3 = d17 - d20;
                }
                double atan2 = Math.atan2(d10 - d3, d8 - d2);
                double atan22 = Math.atan2(d13 - d3, d12 - d2) - atan2;
                int i2 = (atan22 > 0.0d ? 1 : (atan22 == 0.0d ? 0 : -1));
                if (z2 != (i2 >= 0)) {
                    atan22 = i2 > 0 ? atan22 - 6.283185307179586d : atan22 + 6.283185307179586d;
                }
                double d22 = d2 * d7;
                double d23 = d3 * d9;
                arcToBezier(path, (d22 * cos) - (d23 * sin), (d22 * sin) + (d23 * cos), d7, d9, d4, d6, radians, atan2, atan22);
            }
        }

        public static void nodesToPath(PathDataNode[] pathDataNodeArr, Path path) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(65541, null, pathDataNodeArr, path) == null) {
                float[] fArr = new float[6];
                char c2 = 'm';
                for (int i2 = 0; i2 < pathDataNodeArr.length; i2++) {
                    addCommand(path, fArr, c2, pathDataNodeArr[i2].mType, pathDataNodeArr[i2].mParams);
                    c2 = pathDataNodeArr[i2].mType;
                }
            }
        }

        public void interpolatePathDataNode(PathDataNode pathDataNode, PathDataNode pathDataNode2, float f2) {
            Interceptable interceptable = $ic;
            if (interceptable != null && interceptable.invokeCommon(1048576, this, new Object[]{pathDataNode, pathDataNode2, Float.valueOf(f2)}) != null) {
                return;
            }
            this.mType = pathDataNode.mType;
            int i2 = 0;
            while (true) {
                float[] fArr = pathDataNode.mParams;
                if (i2 >= fArr.length) {
                    return;
                }
                this.mParams[i2] = (fArr[i2] * (1.0f - f2)) + (pathDataNode2.mParams[i2] * f2);
                i2++;
            }
        }

        public PathDataNode(PathDataNode pathDataNode) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {pathDataNode};
                interceptable.invokeUnInit(65537, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65537, newInitContext);
                    return;
                }
            }
            this.mType = pathDataNode.mType;
            float[] fArr = pathDataNode.mParams;
            this.mParams = PathParser.copyOfRange(fArr, 0, fArr.length);
        }
    }
}
