package com.badlogic.gdx.graphics.g2d;

import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.mobstat.Config;
import com.baidu.sapi2.utils.enums.ShareDirectionType;
import com.baidu.searchbox.crius.constants.CriusAttrConstants;
import com.baidu.tieba.a4;
import com.baidu.tieba.a7;
import com.baidu.tieba.e1;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.io.BufferedReader;
import java.io.IOException;
/* loaded from: classes.dex */
public class ParticleEmitter {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public float A;
    public String B;
    public a7<String> C;
    public int D;
    public boolean[] E;
    public boolean F;
    public boolean G;
    public boolean H;
    public int I;
    public boolean J;
    public int K;
    public int L;
    public int M;
    public int N;
    public int O;
    public int P;
    public int Q;
    public float R;
    public float S;
    public float T;
    public float U;
    public float V;
    public float W;
    public float X;
    public float Y;
    public boolean Z;
    public f a;
    public boolean a0;
    public c b;
    public boolean b0;
    public f c;
    public boolean c0;
    public c d;
    public g e;
    public g f;
    public g g;
    public g h;
    public g i;
    public g j;
    public g k;
    public g l;
    public g m;
    public b n;
    public f o;
    public f p;
    public g q;
    public g r;
    public h s;
    public float t;
    public a7<a4> u;
    public SpriteMode v;
    public d[] w;
    public int x;
    public int y;
    public float z;

    /* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
    /* loaded from: classes.dex */
    public static final class SpawnEllipseSide {
        public static final /* synthetic */ SpawnEllipseSide[] $VALUES;
        public static /* synthetic */ Interceptable $ic;
        public static final SpawnEllipseSide both;
        public static final SpawnEllipseSide bottom;
        public static final SpawnEllipseSide top;
        public transient /* synthetic */ FieldHolder $fh;

        static {
            InterceptResult invokeClinit;
            ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
            if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(120984347, "Lcom/badlogic/gdx/graphics/g2d/ParticleEmitter$SpawnEllipseSide;")) != null) {
                Interceptable interceptable = invokeClinit.interceptor;
                if (interceptable != null) {
                    $ic = interceptable;
                }
                if ((invokeClinit.flags & 1) != 0) {
                    classClinitInterceptable.invokePostClinit(120984347, "Lcom/badlogic/gdx/graphics/g2d/ParticleEmitter$SpawnEllipseSide;");
                    return;
                }
            }
            both = new SpawnEllipseSide(ShareDirectionType.BOTH, 0);
            top = new SpawnEllipseSide("top", 1);
            SpawnEllipseSide spawnEllipseSide = new SpawnEllipseSide("bottom", 2);
            bottom = spawnEllipseSide;
            $VALUES = new SpawnEllipseSide[]{both, top, spawnEllipseSide};
        }

        public SpawnEllipseSide(String str, int i) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {str, Integer.valueOf(i)};
                interceptable.invokeUnInit(65537, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    Object[] objArr2 = newInitContext.callArgs;
                    String str2 = (String) objArr2[0];
                    ((Integer) objArr2[1]).intValue();
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65537, newInitContext);
                }
            }
        }

        public static SpawnEllipseSide valueOf(String str) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeL = interceptable.invokeL(65538, null, str)) == null) ? (SpawnEllipseSide) Enum.valueOf(SpawnEllipseSide.class, str) : (SpawnEllipseSide) invokeL.objValue;
        }

        public static SpawnEllipseSide[] values() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(65539, null)) == null) ? (SpawnEllipseSide[]) $VALUES.clone() : (SpawnEllipseSide[]) invokeV.objValue;
        }
    }

    /* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
    /* loaded from: classes.dex */
    public static final class SpawnShape {
        public static final /* synthetic */ SpawnShape[] $VALUES;
        public static /* synthetic */ Interceptable $ic;
        public static final SpawnShape ellipse;
        public static final SpawnShape line;
        public static final SpawnShape point;
        public static final SpawnShape square;
        public transient /* synthetic */ FieldHolder $fh;

        static {
            InterceptResult invokeClinit;
            ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
            if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(2025131791, "Lcom/badlogic/gdx/graphics/g2d/ParticleEmitter$SpawnShape;")) != null) {
                Interceptable interceptable = invokeClinit.interceptor;
                if (interceptable != null) {
                    $ic = interceptable;
                }
                if ((invokeClinit.flags & 1) != 0) {
                    classClinitInterceptable.invokePostClinit(2025131791, "Lcom/badlogic/gdx/graphics/g2d/ParticleEmitter$SpawnShape;");
                    return;
                }
            }
            point = new SpawnShape(Config.EVENT_HEAT_POINT, 0);
            line = new SpawnShape("line", 1);
            square = new SpawnShape("square", 2);
            SpawnShape spawnShape = new SpawnShape("ellipse", 3);
            ellipse = spawnShape;
            $VALUES = new SpawnShape[]{point, line, square, spawnShape};
        }

        public SpawnShape(String str, int i) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {str, Integer.valueOf(i)};
                interceptable.invokeUnInit(65537, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    Object[] objArr2 = newInitContext.callArgs;
                    String str2 = (String) objArr2[0];
                    ((Integer) objArr2[1]).intValue();
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65537, newInitContext);
                }
            }
        }

        public static SpawnShape valueOf(String str) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeL = interceptable.invokeL(65538, null, str)) == null) ? (SpawnShape) Enum.valueOf(SpawnShape.class, str) : (SpawnShape) invokeL.objValue;
        }

        public static SpawnShape[] values() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(65539, null)) == null) ? (SpawnShape[]) $VALUES.clone() : (SpawnShape[]) invokeV.objValue;
        }
    }

    /* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
    /* loaded from: classes.dex */
    public static final class SpriteMode {
        public static final /* synthetic */ SpriteMode[] $VALUES;
        public static /* synthetic */ Interceptable $ic;
        public static final SpriteMode animated;
        public static final SpriteMode random;
        public static final SpriteMode single;
        public transient /* synthetic */ FieldHolder $fh;

        static {
            InterceptResult invokeClinit;
            ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
            if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-40481235, "Lcom/badlogic/gdx/graphics/g2d/ParticleEmitter$SpriteMode;")) != null) {
                Interceptable interceptable = invokeClinit.interceptor;
                if (interceptable != null) {
                    $ic = interceptable;
                }
                if ((invokeClinit.flags & 1) != 0) {
                    classClinitInterceptable.invokePostClinit(-40481235, "Lcom/badlogic/gdx/graphics/g2d/ParticleEmitter$SpriteMode;");
                    return;
                }
            }
            single = new SpriteMode("single", 0);
            random = new SpriteMode("random", 1);
            SpriteMode spriteMode = new SpriteMode("animated", 2);
            animated = spriteMode;
            $VALUES = new SpriteMode[]{single, random, spriteMode};
        }

        public SpriteMode(String str, int i) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {str, Integer.valueOf(i)};
                interceptable.invokeUnInit(65537, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    Object[] objArr2 = newInitContext.callArgs;
                    String str2 = (String) objArr2[0];
                    ((Integer) objArr2[1]).intValue();
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65537, newInitContext);
                }
            }
        }

        public static SpriteMode valueOf(String str) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeL = interceptable.invokeL(65538, null, str)) == null) ? (SpriteMode) Enum.valueOf(SpriteMode.class, str) : (SpriteMode) invokeL.objValue;
        }

        public static SpriteMode[] values() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(65539, null)) == null) ? (SpriteMode[]) $VALUES.clone() : (SpriteMode[]) invokeV.objValue;
        }
    }

    /* loaded from: classes.dex */
    public static /* synthetic */ class a {
        public static /* synthetic */ Interceptable $ic;
        public static final /* synthetic */ int[] a;
        public static final /* synthetic */ int[] b;
        public static final /* synthetic */ int[] c;
        public transient /* synthetic */ FieldHolder $fh;

        static {
            InterceptResult invokeClinit;
            ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
            if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-556557408, "Lcom/badlogic/gdx/graphics/g2d/ParticleEmitter$a;")) != null) {
                Interceptable interceptable = invokeClinit.interceptor;
                if (interceptable != null) {
                    $ic = interceptable;
                }
                if ((invokeClinit.flags & 1) != 0) {
                    classClinitInterceptable.invokePostClinit(-556557408, "Lcom/badlogic/gdx/graphics/g2d/ParticleEmitter$a;");
                    return;
                }
            }
            int[] iArr = new int[SpawnShape.values().length];
            c = iArr;
            try {
                iArr[SpawnShape.square.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                c[SpawnShape.ellipse.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                c[SpawnShape.line.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            int[] iArr2 = new int[SpawnEllipseSide.values().length];
            b = iArr2;
            try {
                iArr2[SpawnEllipseSide.top.ordinal()] = 1;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                b[SpawnEllipseSide.bottom.ordinal()] = 2;
            } catch (NoSuchFieldError unused5) {
            }
            int[] iArr3 = new int[SpriteMode.values().length];
            a = iArr3;
            try {
                iArr3[SpriteMode.single.ordinal()] = 1;
            } catch (NoSuchFieldError unused6) {
            }
            try {
                a[SpriteMode.animated.ordinal()] = 2;
            } catch (NoSuchFieldError unused7) {
            }
            try {
                a[SpriteMode.random.ordinal()] = 3;
            } catch (NoSuchFieldError unused8) {
            }
        }
    }

    /* loaded from: classes.dex */
    public static class b extends e {
        public static /* synthetic */ Interceptable $ic;
        public static float[] e;
        public transient /* synthetic */ FieldHolder $fh;
        public float[] c;
        public float[] d;

        static {
            InterceptResult invokeClinit;
            ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
            if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-556557377, "Lcom/badlogic/gdx/graphics/g2d/ParticleEmitter$b;")) != null) {
                Interceptable interceptable = invokeClinit.interceptor;
                if (interceptable != null) {
                    $ic = interceptable;
                }
                if ((invokeClinit.flags & 1) != 0) {
                    classClinitInterceptable.invokePostClinit(-556557377, "Lcom/badlogic/gdx/graphics/g2d/ParticleEmitter$b;");
                    return;
                }
            }
            e = new float[4];
        }

        public b() {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                interceptable.invokeUnInit(65537, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65537, newInitContext);
                    return;
                }
            }
            this.c = new float[]{1.0f, 1.0f, 1.0f};
            this.d = new float[]{0.0f};
            this.b = true;
        }

        @Override // com.badlogic.gdx.graphics.g2d.ParticleEmitter.e
        public void a(BufferedReader bufferedReader) throws IOException {
            Interceptable interceptable = $ic;
            if (interceptable != null && interceptable.invokeL(1048576, this, bufferedReader) != null) {
                return;
            }
            super.a(bufferedReader);
            if (!this.a) {
                return;
            }
            this.c = new float[ParticleEmitter.n(bufferedReader, "colorsCount")];
            int i = 0;
            int i2 = 0;
            while (true) {
                float[] fArr = this.c;
                if (i2 >= fArr.length) {
                    break;
                }
                fArr[i2] = ParticleEmitter.m(bufferedReader, "colors" + i2);
                i2++;
            }
            this.d = new float[ParticleEmitter.n(bufferedReader, "timelineCount")];
            while (true) {
                float[] fArr2 = this.d;
                if (i >= fArr2.length) {
                    return;
                }
                fArr2[i] = ParticleEmitter.m(bufferedReader, "timeline" + i);
                i++;
            }
        }

        public float[] d(float f) {
            InterceptResult invokeF;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeF = interceptable.invokeF(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, f)) == null) {
                float[] fArr = this.d;
                int length = fArr.length;
                int i = 1;
                int i2 = 0;
                while (true) {
                    if (i >= length) {
                        i = -1;
                        break;
                    } else if (fArr[i] > f) {
                        break;
                    } else {
                        i2 = i;
                        i++;
                    }
                }
                float f2 = fArr[i2];
                int i3 = i2 * 3;
                float[] fArr2 = this.c;
                float f3 = fArr2[i3];
                float f4 = fArr2[i3 + 1];
                float f5 = fArr2[i3 + 2];
                if (i == -1) {
                    float[] fArr3 = e;
                    fArr3[0] = f3;
                    fArr3[1] = f4;
                    fArr3[2] = f5;
                    return fArr3;
                }
                float f6 = (f - f2) / (fArr[i] - f2);
                int i4 = i * 3;
                float[] fArr4 = e;
                fArr4[0] = f3 + ((fArr2[i4] - f3) * f6);
                fArr4[1] = f4 + ((fArr2[i4 + 1] - f4) * f6);
                fArr4[2] = f5 + ((fArr2[i4 + 2] - f5) * f6);
                return fArr4;
            }
            return (float[]) invokeF.objValue;
        }
    }

    /* loaded from: classes.dex */
    public static class c extends g {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public boolean j;

        public c() {
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

        @Override // com.badlogic.gdx.graphics.g2d.ParticleEmitter.g, com.badlogic.gdx.graphics.g2d.ParticleEmitter.f, com.badlogic.gdx.graphics.g2d.ParticleEmitter.e
        public void a(BufferedReader bufferedReader) throws IOException {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, bufferedReader) == null) {
                super.a(bufferedReader);
                if (bufferedReader.markSupported()) {
                    bufferedReader.mark(100);
                }
                String readLine = bufferedReader.readLine();
                if (readLine != null) {
                    if (readLine.contains("independent")) {
                        this.j = Boolean.parseBoolean(ParticleEmitter.p(readLine));
                        return;
                    } else if (bufferedReader.markSupported()) {
                        bufferedReader.reset();
                        return;
                    } else {
                        e1.a.error("ParticleEmitter", "The loaded particle effect descriptor file uses an old invalid format. Please download the latest version of the Particle Editor tool and recreate the file by loading and saving it again.");
                        throw new IOException("The loaded particle effect descriptor file uses an old invalid format. Please download the latest version of the Particle Editor tool and recreate the file by loading and saving it again.");
                    }
                }
                throw new IOException("Missing value: independent");
            }
        }
    }

    /* loaded from: classes.dex */
    public static class d extends a4 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public float A;
        public float B;
        public float C;
        public float D;
        public float E;
        public float F;
        public float G;
        public float H;
        public float I;
        public float J;
        public float K;
        public float L;
        public float M;
        public float[] N;
        public int O;
        public int t;
        public int u;
        public float v;
        public float w;
        public float x;
        public float y;
        public float z;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public d(a4 a4Var) {
            super(a4Var);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {a4Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    super((a4) newInitContext.callArgs[0]);
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
        }
    }

    /* loaded from: classes.dex */
    public static class e {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public boolean a;
        public boolean b;

        public e() {
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

        public void a(BufferedReader bufferedReader) throws IOException {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, bufferedReader) == null) {
                if (!this.b) {
                    this.a = ParticleEmitter.k(bufferedReader, "active");
                } else {
                    this.a = true;
                }
            }
        }

        public void b(boolean z) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeZ(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, z) == null) {
                this.a = z;
            }
        }

        public void c(boolean z) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeZ(Constants.METHOD_SEND_USER_MSG, this, z) == null) {
                this.b = z;
            }
        }
    }

    /* loaded from: classes.dex */
    public static class f extends e {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public float c;
        public float d;

        public f() {
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

        @Override // com.badlogic.gdx.graphics.g2d.ParticleEmitter.e
        public void a(BufferedReader bufferedReader) throws IOException {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, bufferedReader) == null) {
                super.a(bufferedReader);
                if (this.a) {
                    this.c = ParticleEmitter.m(bufferedReader, "lowMin");
                    this.d = ParticleEmitter.m(bufferedReader, "lowMax");
                }
            }
        }

        public float d() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
                float f = this.c;
                return f + ((this.d - f) * com.badlogic.gdx.math.d.k());
            }
            return invokeV.floatValue;
        }
    }

    /* loaded from: classes.dex */
    public static class g extends f {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public float[] e;
        public float[] f;
        public float g;
        public float h;
        public boolean i;

        public g() {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.e = new float[]{1.0f};
            this.f = new float[]{0.0f};
        }

        @Override // com.badlogic.gdx.graphics.g2d.ParticleEmitter.f, com.badlogic.gdx.graphics.g2d.ParticleEmitter.e
        public void a(BufferedReader bufferedReader) throws IOException {
            Interceptable interceptable = $ic;
            if (interceptable != null && interceptable.invokeL(1048576, this, bufferedReader) != null) {
                return;
            }
            super.a(bufferedReader);
            if (!this.a) {
                return;
            }
            this.g = ParticleEmitter.m(bufferedReader, "highMin");
            this.h = ParticleEmitter.m(bufferedReader, "highMax");
            this.i = ParticleEmitter.k(bufferedReader, CriusAttrConstants.RELATIVE);
            this.e = new float[ParticleEmitter.n(bufferedReader, "scalingCount")];
            int i = 0;
            int i2 = 0;
            while (true) {
                float[] fArr = this.e;
                if (i2 >= fArr.length) {
                    break;
                }
                fArr[i2] = ParticleEmitter.m(bufferedReader, "scaling" + i2);
                i2++;
            }
            this.f = new float[ParticleEmitter.n(bufferedReader, "timelineCount")];
            while (true) {
                float[] fArr2 = this.f;
                if (i >= fArr2.length) {
                    return;
                }
                fArr2[i] = ParticleEmitter.m(bufferedReader, "timeline" + i);
                i++;
            }
        }

        public float e(float f) {
            InterceptResult invokeF;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeF = interceptable.invokeF(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, f)) == null) {
                float[] fArr = this.f;
                int length = fArr.length;
                int i = 1;
                while (true) {
                    if (i >= length) {
                        i = -1;
                        break;
                    } else if (fArr[i] > f) {
                        break;
                    } else {
                        i++;
                    }
                }
                if (i == -1) {
                    return this.e[length - 1];
                }
                float[] fArr2 = this.e;
                int i2 = i - 1;
                float f2 = fArr2[i2];
                float f3 = fArr[i2];
                return f2 + ((fArr2[i] - f2) * ((f - f3) / (fArr[i] - f3)));
            }
            return invokeF.floatValue;
        }

        public boolean f() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? this.i : invokeV.booleanValue;
        }

        public float g() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
                float f = this.g;
                return f + ((this.h - f) * com.badlogic.gdx.math.d.k());
            }
            return invokeV.floatValue;
        }
    }

    /* loaded from: classes.dex */
    public static class h extends e {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public SpawnShape c;
        public boolean d;
        public SpawnEllipseSide e;

        public h() {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.c = SpawnShape.point;
            this.e = SpawnEllipseSide.both;
        }

        @Override // com.badlogic.gdx.graphics.g2d.ParticleEmitter.e
        public void a(BufferedReader bufferedReader) throws IOException {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, bufferedReader) == null) {
                super.a(bufferedReader);
                if (this.a) {
                    SpawnShape valueOf = SpawnShape.valueOf(ParticleEmitter.o(bufferedReader, "shape"));
                    this.c = valueOf;
                    if (valueOf == SpawnShape.ellipse) {
                        this.d = ParticleEmitter.k(bufferedReader, "edges");
                        this.e = SpawnEllipseSide.valueOf(ParticleEmitter.o(bufferedReader, "side"));
                    }
                }
            }
        }
    }

    public ParticleEmitter() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.a = new f();
        this.b = new c();
        this.c = new f();
        this.d = new c();
        this.e = new g();
        this.f = new g();
        this.g = new g();
        this.h = new g();
        this.i = new g();
        this.j = new g();
        this.k = new g();
        this.l = new g();
        this.m = new g();
        this.n = new b();
        this.o = new g();
        this.p = new g();
        this.q = new g();
        this.r = new g();
        this.s = new h();
        this.v = SpriteMode.single;
        this.y = 4;
        this.V = 1.0f;
        this.b0 = true;
        this.c0 = false;
        h();
    }

    public static boolean k(BufferedReader bufferedReader, String str) throws IOException {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLL = interceptable.invokeLL(65538, null, bufferedReader, str)) == null) ? Boolean.parseBoolean(o(bufferedReader, str)) : invokeLL.booleanValue;
    }

    public static boolean l(String str) throws IOException {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65539, null, str)) == null) ? Boolean.parseBoolean(p(str)) : invokeL.booleanValue;
    }

    public static float m(BufferedReader bufferedReader, String str) throws IOException {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLL = interceptable.invokeLL(InputDeviceCompat.SOURCE_TRACKBALL, null, bufferedReader, str)) == null) ? Float.parseFloat(o(bufferedReader, str)) : invokeLL.floatValue;
    }

    public static int n(BufferedReader bufferedReader, String str) throws IOException {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLL = interceptable.invokeLL(65541, null, bufferedReader, str)) == null) ? Integer.parseInt(o(bufferedReader, str)) : invokeLL.intValue;
    }

    public static String o(BufferedReader bufferedReader, String str) throws IOException {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65542, null, bufferedReader, str)) == null) {
            String readLine = bufferedReader.readLine();
            if (readLine != null) {
                return p(readLine);
            }
            throw new IOException("Missing value: " + str);
        }
        return (String) invokeLL.objValue;
    }

    public static String p(String str) throws IOException {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65543, null, str)) == null) ? str.substring(str.indexOf(":") + 1).trim() : (String) invokeL.objValue;
    }

    public final void a(int i) {
        a4 f2;
        float f3;
        float l;
        float l2;
        float f4;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048576, this, i) == null) {
            int i2 = a.a[this.v.ordinal()];
            if (i2 != 1 && i2 != 2) {
                f2 = i2 != 3 ? null : this.u.h();
            } else {
                f2 = this.u.f();
            }
            d[] dVarArr = this.w;
            d dVar = dVarArr[i];
            if (dVar == null) {
                dVar = j(f2);
                dVarArr[i] = dVar;
                dVar.a(this.G, this.H);
            } else {
                dVar.r(f2);
            }
            float f5 = this.W / this.V;
            int i3 = this.I;
            if (this.d.j) {
                e();
            }
            if (this.b.j) {
                d();
            }
            int e2 = this.P + ((int) (this.Q * this.d.e(f5)));
            dVar.t = e2;
            dVar.u = e2;
            g gVar = this.i;
            if (gVar.a) {
                dVar.B = gVar.d();
                dVar.C = this.i.g();
                if (!this.i.f()) {
                    dVar.C -= dVar.B;
                }
            }
            dVar.D = this.j.d();
            dVar.E = this.j.g();
            if (!this.j.f()) {
                dVar.E -= dVar.D;
            }
            int i4 = i3 & 2;
            if (i4 == 0) {
                f3 = dVar.D + (dVar.E * this.j.e(0.0f));
                dVar.D = f3;
                dVar.F = com.badlogic.gdx.math.d.d(f3);
                dVar.G = com.badlogic.gdx.math.d.p(f3);
            } else {
                f3 = 0.0f;
            }
            float n = f2.n();
            float k = f2.k();
            dVar.v = this.f.d() / n;
            dVar.w = this.f.g() / n;
            if (!this.f.f()) {
                dVar.w -= dVar.v;
            }
            g gVar2 = this.g;
            if (gVar2.a) {
                dVar.x = gVar2.d() / k;
                dVar.y = this.g.g() / k;
                if (!this.g.f()) {
                    dVar.y -= dVar.x;
                }
                dVar.y(dVar.v + (dVar.w * this.f.e(0.0f)), dVar.x + (dVar.y * this.g.e(0.0f)));
            } else {
                dVar.x(dVar.v + (dVar.w * this.f.e(0.0f)));
            }
            g gVar3 = this.h;
            if (gVar3.a) {
                dVar.z = gVar3.d();
                dVar.A = this.h.g();
                if (!this.h.f()) {
                    dVar.A -= dVar.z;
                }
                float e3 = dVar.z + (dVar.A * this.h.e(0.0f));
                if (this.a0) {
                    e3 += f3;
                }
                dVar.w(e3);
            }
            g gVar4 = this.k;
            if (gVar4.a) {
                dVar.J = gVar4.d();
                dVar.K = this.k.g();
                if (!this.k.f()) {
                    dVar.K -= dVar.J;
                }
            }
            g gVar5 = this.l;
            if (gVar5.a) {
                dVar.L = gVar5.d();
                dVar.M = this.l.g();
                if (!this.l.f()) {
                    dVar.M -= dVar.L;
                }
            }
            float[] fArr = dVar.N;
            if (fArr == null) {
                fArr = new float[3];
                dVar.N = fArr;
            }
            float[] d2 = this.n.d(0.0f);
            fArr[0] = d2[0];
            fArr[1] = d2[1];
            fArr[2] = d2[2];
            dVar.H = this.m.d();
            dVar.I = this.m.g() - dVar.H;
            float f6 = this.z;
            f fVar = this.o;
            if (fVar.a) {
                f6 += fVar.d();
            }
            float f7 = this.A;
            f fVar2 = this.p;
            if (fVar2.a) {
                f7 += fVar2.d();
            }
            int i5 = a.c[this.s.c.ordinal()];
            if (i5 == 1) {
                float e4 = this.R + (this.S * this.q.e(f5));
                float e5 = this.T + (this.U * this.r.e(f5));
                f6 += com.badlogic.gdx.math.d.l(e4) - (e4 / 2.0f);
                f7 += com.badlogic.gdx.math.d.l(e5) - (e5 / 2.0f);
            } else if (i5 == 2) {
                float e6 = this.R + (this.S * this.q.e(f5));
                float f8 = e6 / 2.0f;
                float e7 = (this.T + (this.U * this.r.e(f5))) / 2.0f;
                if (f8 != 0.0f && e7 != 0.0f) {
                    float f9 = f8 / e7;
                    h hVar = this.s;
                    if (hVar.d) {
                        int i6 = a.b[hVar.e.ordinal()];
                        if (i6 == 1) {
                            f4 = -com.badlogic.gdx.math.d.l(179.0f);
                        } else if (i6 != 2) {
                            f4 = com.badlogic.gdx.math.d.l(360.0f);
                        } else {
                            f4 = com.badlogic.gdx.math.d.l(179.0f);
                        }
                        float d3 = com.badlogic.gdx.math.d.d(f4);
                        float p = com.badlogic.gdx.math.d.p(f4);
                        f6 += d3 * f8;
                        f7 += (f8 * p) / f9;
                        if (i4 == 0) {
                            dVar.D = f4;
                            dVar.F = d3;
                            dVar.G = p;
                        }
                    } else {
                        float f10 = f8 * f8;
                        do {
                            l = com.badlogic.gdx.math.d.l(e6) - f8;
                            l2 = com.badlogic.gdx.math.d.l(e6) - f8;
                        } while ((l * l) + (l2 * l2) > f10);
                        f6 += l;
                        f7 += l2 / f9;
                    }
                }
            } else if (i5 == 3) {
                float e8 = this.R + (this.S * this.q.e(f5));
                float e9 = this.T + (this.U * this.r.e(f5));
                if (e8 != 0.0f) {
                    float k2 = com.badlogic.gdx.math.d.k() * e8;
                    f6 += k2;
                    f7 += k2 * (e9 / e8);
                } else {
                    f7 += e9 * com.badlogic.gdx.math.d.k();
                }
            }
            dVar.s(f6 - (n / 2.0f), f7 - (k / 2.0f), n, k);
            int e10 = (int) (this.N + (this.O * this.b.e(f5)));
            if (e10 > 0) {
                int i7 = dVar.u;
                if (e10 >= i7) {
                    e10 = i7 - 1;
                }
                v(dVar, e10 / 1000.0f, e10);
            }
        }
    }

    public void b() {
        int i;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) || (i = this.D) == this.y) {
            return;
        }
        boolean[] zArr = this.E;
        int length = zArr.length;
        for (int i2 = 0; i2 < length; i2++) {
            if (!zArr[i2]) {
                a(i2);
                zArr[i2] = true;
                this.D = i + 1;
                return;
            }
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:12:0x001d, code lost:
        a(r3);
        r0[r3] = true;
        r2 = r2 + 1;
        r3 = r3 + 1;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void c(int i) {
        int min;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeI(Constants.METHOD_SEND_USER_MSG, this, i) == null) || (min = Math.min(i, this.y - this.D)) == 0) {
            return;
        }
        boolean[] zArr = this.E;
        int length = zArr.length;
        int i2 = 0;
        int i3 = 0;
        loop0: while (i2 < min) {
            while (i3 < length) {
                if (!zArr[i3]) {
                    break;
                }
                i3++;
            }
            break loop0;
        }
        this.D += min;
    }

    public final void d() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
            c cVar = this.b;
            this.N = cVar.a ? (int) cVar.d() : 0;
            this.O = (int) this.b.g();
            if (this.b.f()) {
                return;
            }
            this.O -= this.N;
        }
    }

    public final void e() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
            this.P = (int) this.d.d();
            this.Q = (int) this.d.g();
            if (this.d.f()) {
                return;
            }
            this.Q -= this.P;
        }
    }

    public a7<String> f() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) ? this.C : (a7) invokeV.objValue;
    }

    public a7<a4> g() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) ? this.u : (a7) invokeV.objValue;
    }

    public final void h() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048583, this) == null) {
            this.u = new a7<>();
            this.C = new a7<>();
            this.c.c(true);
            this.e.c(true);
            this.d.c(true);
            this.f.c(true);
            this.m.c(true);
            this.s.c(true);
            this.q.c(true);
            this.r.c(true);
        }
    }

    public void i(BufferedReader bufferedReader) throws IOException {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, bufferedReader) == null) {
            try {
                this.B = o(bufferedReader, "name");
                bufferedReader.readLine();
                this.a.a(bufferedReader);
                bufferedReader.readLine();
                this.c.a(bufferedReader);
                bufferedReader.readLine();
                t(n(bufferedReader, "minParticleCount"));
                s(n(bufferedReader, "maxParticleCount"));
                bufferedReader.readLine();
                this.e.a(bufferedReader);
                bufferedReader.readLine();
                this.d.a(bufferedReader);
                bufferedReader.readLine();
                this.b.a(bufferedReader);
                bufferedReader.readLine();
                this.o.a(bufferedReader);
                bufferedReader.readLine();
                this.p.a(bufferedReader);
                bufferedReader.readLine();
                this.s.a(bufferedReader);
                bufferedReader.readLine();
                this.q.a(bufferedReader);
                bufferedReader.readLine();
                this.r.a(bufferedReader);
                if (bufferedReader.readLine().trim().equals("- Scale -")) {
                    this.f.a(bufferedReader);
                    this.g.b(false);
                } else {
                    this.f.a(bufferedReader);
                    bufferedReader.readLine();
                    this.g.a(bufferedReader);
                }
                bufferedReader.readLine();
                this.i.a(bufferedReader);
                bufferedReader.readLine();
                this.j.a(bufferedReader);
                bufferedReader.readLine();
                this.h.a(bufferedReader);
                bufferedReader.readLine();
                this.k.a(bufferedReader);
                bufferedReader.readLine();
                this.l.a(bufferedReader);
                bufferedReader.readLine();
                this.n.a(bufferedReader);
                bufferedReader.readLine();
                this.m.a(bufferedReader);
                bufferedReader.readLine();
                k(bufferedReader, "attached");
                this.Z = k(bufferedReader, "continuous");
                this.a0 = k(bufferedReader, "aligned");
                this.b0 = k(bufferedReader, "additive");
                k(bufferedReader, "behind");
                String readLine = bufferedReader.readLine();
                if (readLine.startsWith("premultipliedAlpha")) {
                    this.c0 = l(readLine);
                    readLine = bufferedReader.readLine();
                }
                if (readLine.startsWith("spriteMode")) {
                    this.v = SpriteMode.valueOf(p(readLine));
                    bufferedReader.readLine();
                }
                a7<String> a7Var = new a7<>();
                while (true) {
                    String readLine2 = bufferedReader.readLine();
                    if (readLine2 == null || readLine2.isEmpty()) {
                        break;
                    }
                    a7Var.a(readLine2);
                }
                r(a7Var);
            } catch (RuntimeException e2) {
                if (this.B == null) {
                    throw e2;
                }
                throw new RuntimeException("Error parsing emitter: " + this.B, e2);
            }
        }
    }

    public d j(a4 a4Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(1048585, this, a4Var)) == null) ? new d(a4Var) : (d) invokeL.objValue;
    }

    public final void q() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048586, this) == null) {
            f fVar = this.a;
            this.X = fVar.a ? fVar.d() : 0.0f;
            this.Y = 0.0f;
            this.W -= this.V;
            this.V = this.c.d();
            this.K = (int) this.e.d();
            this.L = (int) this.e.g();
            if (!this.e.f()) {
                this.L -= this.K;
            }
            if (!this.d.j) {
                e();
            }
            if (!this.b.j) {
                d();
            }
            this.R = this.q.d();
            this.S = this.q.g();
            if (!this.q.f()) {
                this.S -= this.R;
            }
            this.T = this.r.d();
            this.U = this.r.g();
            if (!this.r.f()) {
                this.U -= this.T;
            }
            this.I = 0;
            g gVar = this.j;
            if (gVar.a && gVar.f.length > 1) {
                this.I = 0 | 2;
            }
            if (this.i.a) {
                this.I |= 8;
            }
            if (this.f.f.length > 1) {
                this.I |= 1;
            }
            g gVar2 = this.g;
            if (gVar2.a && gVar2.f.length > 1) {
                this.I |= 1;
            }
            g gVar3 = this.h;
            if (gVar3.a && gVar3.f.length > 1) {
                this.I |= 4;
            }
            if (this.k.a) {
                this.I |= 16;
            }
            if (this.l.a) {
                this.I |= 32;
            }
            if (this.n.d.length > 1) {
                this.I |= 64;
            }
            if (this.v == SpriteMode.animated) {
                this.I |= 128;
            }
        }
    }

    public void r(a7<String> a7Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048587, this, a7Var) == null) {
            this.C = a7Var;
        }
    }

    public void s(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048588, this, i) == null) {
            this.y = i;
            this.E = new boolean[i];
            this.D = 0;
            this.w = new d[i];
        }
    }

    public void t(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048589, this, i) == null) {
            this.x = i;
        }
    }

    public void u(a7<a4> a7Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048590, this, a7Var) == null) {
            this.u = a7Var;
            if (a7Var.b == 0) {
                return;
            }
            int length = this.w.length;
            for (int i = 0; i < length; i++) {
                d dVar = this.w[i];
                if (dVar == null) {
                    return;
                }
                a4 a4Var = null;
                int i2 = a.a[this.v.ordinal()];
                if (i2 == 1) {
                    a4Var = a7Var.f();
                } else if (i2 == 2) {
                    float f2 = 1.0f - (dVar.u / dVar.t);
                    int i3 = a7Var.b;
                    int min = Math.min((int) (f2 * i3), i3 - 1);
                    dVar.O = min;
                    a4Var = a7Var.get(min);
                } else if (i2 == 3) {
                    a4Var = a7Var.h();
                }
                dVar.i(a4Var);
                dVar.v(a4Var.l(), a4Var.m());
            }
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:25:0x004d  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void update(float f2) {
        boolean z;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeF(1048591, this, f2) == null) {
            float f3 = this.t + (f2 * 1000.0f);
            this.t = f3;
            if (f3 < 1.0f) {
                return;
            }
            int i = (int) f3;
            float f4 = i;
            this.t = f3 - f4;
            float f5 = this.Y;
            if (f5 < this.X) {
                this.Y = f5 + f4;
            } else {
                if (this.F) {
                    this.F = false;
                    b();
                }
                float f6 = this.W;
                if (f6 < this.V) {
                    this.W = f6 + f4;
                } else if (!this.Z || this.J) {
                    z = true;
                    if (!z) {
                        this.M += i;
                        float e2 = this.K + (this.L * this.e.e(this.W / this.V));
                        if (e2 > 0.0f) {
                            float f7 = 1000.0f / e2;
                            int i2 = this.M;
                            if (i2 >= f7) {
                                int min = Math.min((int) (i2 / f7), this.y - this.D);
                                int i3 = (int) (this.M - (min * f7));
                                this.M = i3;
                                this.M = (int) (i3 % f7);
                                c(min);
                            }
                        }
                        int i4 = this.D;
                        int i5 = this.x;
                        if (i4 < i5) {
                            c(i5 - i4);
                        }
                    }
                } else {
                    q();
                }
                z = false;
                if (!z) {
                }
            }
            boolean[] zArr = this.E;
            int i6 = this.D;
            d[] dVarArr = this.w;
            int length = zArr.length;
            for (int i7 = 0; i7 < length; i7++) {
                if (zArr[i7] && !v(dVarArr[i7], f2, i)) {
                    zArr[i7] = false;
                    i6--;
                }
            }
            this.D = i6;
        }
    }

    public final boolean v(d dVar, float f2, int i) {
        InterceptResult invokeCommon;
        float[] fArr;
        float f3;
        float f4;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048592, this, new Object[]{dVar, Float.valueOf(f2), Integer.valueOf(i)})) == null) {
            int i2 = dVar.u - i;
            if (i2 <= 0) {
                return false;
            }
            dVar.u = i2;
            float f5 = 1.0f - (i2 / dVar.t);
            int i3 = this.I;
            if ((i3 & 1) != 0) {
                if (this.g.a) {
                    dVar.y(dVar.v + (dVar.w * this.f.e(f5)), dVar.x + (dVar.y * this.g.e(f5)));
                } else {
                    dVar.x(dVar.v + (dVar.w * this.f.e(f5)));
                }
            }
            if ((i3 & 8) != 0) {
                float e2 = (dVar.B + (dVar.C * this.i.e(f5))) * f2;
                if ((i3 & 2) != 0) {
                    float e3 = dVar.D + (dVar.E * this.j.e(f5));
                    f3 = com.badlogic.gdx.math.d.d(e3) * e2;
                    f4 = e2 * com.badlogic.gdx.math.d.p(e3);
                    if ((i3 & 4) != 0) {
                        float e4 = dVar.z + (dVar.A * this.h.e(f5));
                        if (this.a0) {
                            e4 += e3;
                        }
                        dVar.w(e4);
                    }
                } else {
                    f3 = e2 * dVar.F;
                    f4 = e2 * dVar.G;
                    if (this.a0 || (i3 & 4) != 0) {
                        float e5 = dVar.z + (dVar.A * this.h.e(f5));
                        if (this.a0) {
                            e5 += dVar.D;
                        }
                        dVar.w(e5);
                    }
                }
                if ((i3 & 16) != 0) {
                    f3 += (dVar.J + (dVar.K * this.k.e(f5))) * f2;
                }
                if ((i3 & 32) != 0) {
                    f4 += (dVar.L + (dVar.M * this.l.e(f5))) * f2;
                }
                dVar.A(f3, f4);
            } else if ((i3 & 4) != 0) {
                dVar.w(dVar.z + (dVar.A * this.h.e(f5)));
            }
            if ((i3 & 64) != 0) {
                fArr = this.n.d(f5);
            } else {
                fArr = dVar.N;
            }
            if (this.c0) {
                float f6 = this.b0 ? 0.0f : 1.0f;
                float e6 = dVar.H + (dVar.I * this.m.e(f5));
                dVar.t(fArr[0] * e6, fArr[1] * e6, fArr[2] * e6, e6 * f6);
            } else {
                dVar.t(fArr[0], fArr[1], fArr[2], dVar.H + (dVar.I * this.m.e(f5)));
            }
            if ((i3 & 128) != 0) {
                int i4 = this.u.b;
                int min = Math.min((int) (f5 * i4), i4 - 1);
                if (dVar.O != min) {
                    a4 a4Var = this.u.get(min);
                    float n = dVar.n();
                    float k = dVar.k();
                    dVar.i(a4Var);
                    dVar.z(a4Var.n(), a4Var.k());
                    dVar.v(a4Var.l(), a4Var.m());
                    dVar.A((n - a4Var.n()) / 2.0f, (k - a4Var.k()) / 2.0f);
                    dVar.O = min;
                }
            }
            return true;
        }
        return invokeCommon.booleanValue;
    }

    public ParticleEmitter(BufferedReader bufferedReader) throws IOException {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {bufferedReader};
            interceptable.invokeUnInit(65537, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.a = new f();
        this.b = new c();
        this.c = new f();
        this.d = new c();
        this.e = new g();
        this.f = new g();
        this.g = new g();
        this.h = new g();
        this.i = new g();
        this.j = new g();
        this.k = new g();
        this.l = new g();
        this.m = new g();
        this.n = new b();
        this.o = new g();
        this.p = new g();
        this.q = new g();
        this.r = new g();
        this.s = new h();
        this.v = SpriteMode.single;
        this.y = 4;
        this.V = 1.0f;
        this.b0 = true;
        this.c0 = false;
        h();
        i(bufferedReader);
    }
}
