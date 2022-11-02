package com.badlogic.gdx;

import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes.dex */
public interface Graphics {
    boolean a(String str);

    boolean b();

    void c();

    boolean d();

    float e();

    a f();

    /* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
    /* loaded from: classes.dex */
    public static final class GraphicsType {
        public static final /* synthetic */ GraphicsType[] $VALUES;
        public static /* synthetic */ Interceptable $ic;
        public static final GraphicsType AndroidGL;
        public static final GraphicsType JGLFW;
        public static final GraphicsType LWJGL;
        public static final GraphicsType LWJGL3;
        public static final GraphicsType Mock;
        public static final GraphicsType WebGL;
        public static final GraphicsType iOSGL;
        public transient /* synthetic */ FieldHolder $fh;

        static {
            InterceptResult invokeClinit;
            ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
            if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-1602264723, "Lcom/badlogic/gdx/Graphics$GraphicsType;")) != null) {
                Interceptable interceptable = invokeClinit.interceptor;
                if (interceptable != null) {
                    $ic = interceptable;
                }
                if ((invokeClinit.flags & 1) != 0) {
                    classClinitInterceptable.invokePostClinit(-1602264723, "Lcom/badlogic/gdx/Graphics$GraphicsType;");
                    return;
                }
            }
            AndroidGL = new GraphicsType("AndroidGL", 0);
            LWJGL = new GraphicsType("LWJGL", 1);
            WebGL = new GraphicsType("WebGL", 2);
            iOSGL = new GraphicsType("iOSGL", 3);
            JGLFW = new GraphicsType("JGLFW", 4);
            Mock = new GraphicsType("Mock", 5);
            GraphicsType graphicsType = new GraphicsType("LWJGL3", 6);
            LWJGL3 = graphicsType;
            $VALUES = new GraphicsType[]{AndroidGL, LWJGL, WebGL, iOSGL, JGLFW, Mock, graphicsType};
        }

        public GraphicsType(String str, int i) {
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

        public static GraphicsType valueOf(String str) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(65538, null, str)) == null) {
                return (GraphicsType) Enum.valueOf(GraphicsType.class, str);
            }
            return (GraphicsType) invokeL.objValue;
        }

        public static GraphicsType[] values() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(65539, null)) == null) {
                return (GraphicsType[]) $VALUES.clone();
            }
            return (GraphicsType[]) invokeV.objValue;
        }
    }

    /* loaded from: classes.dex */
    public static class a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final int a;
        public final int b;
        public final int c;
        public final int d;

        public a(int i, int i2, int i3, int i4) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(i4)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i5 = newInitContext.flag;
                if ((i5 & 1) != 0) {
                    int i6 = i5 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = i;
            this.b = i2;
            this.c = i3;
            this.d = i4;
        }

        public String toString() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
                return this.a + "x" + this.b + ", bpp: " + this.d + ", hz: " + this.c;
            }
            return (String) invokeV.objValue;
        }
    }
}
