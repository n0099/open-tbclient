package com.badlogic.gdx.graphics.glutils;

import c.b.b.f;
import com.badlogic.gdx.Application;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.spswitch.emotion.resource.EmotionResourceInfo;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
/* loaded from: classes3.dex */
public class GLVersion {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public int a;

    /* renamed from: b  reason: collision with root package name */
    public final Type f29761b;

    /* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
    /* loaded from: classes3.dex */
    public static final class Type {
        public static final /* synthetic */ Type[] $VALUES;
        public static /* synthetic */ Interceptable $ic;
        public static final Type GLES;
        public static final Type NONE;
        public static final Type OpenGL;
        public static final Type WebGL;
        public transient /* synthetic */ FieldHolder $fh;

        static {
            InterceptResult invokeClinit;
            ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
            if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1045868313, "Lcom/badlogic/gdx/graphics/glutils/GLVersion$Type;")) != null) {
                Interceptable interceptable = invokeClinit.interceptor;
                if (interceptable != null) {
                    $ic = interceptable;
                }
                if ((invokeClinit.flags & 1) != 0) {
                    classClinitInterceptable.invokePostClinit(1045868313, "Lcom/badlogic/gdx/graphics/glutils/GLVersion$Type;");
                    return;
                }
            }
            OpenGL = new Type("OpenGL", 0);
            GLES = new Type("GLES", 1);
            WebGL = new Type("WebGL", 2);
            Type type = new Type("NONE", 3);
            NONE = type;
            $VALUES = new Type[]{OpenGL, GLES, WebGL, type};
        }

        public Type(String str, int i2) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {str, Integer.valueOf(i2)};
                interceptable.invokeUnInit(65537, newInitContext);
                int i3 = newInitContext.flag;
                if ((i3 & 1) != 0) {
                    int i4 = i3 & 2;
                    Object[] objArr2 = newInitContext.callArgs;
                    String str2 = (String) objArr2[0];
                    ((Integer) objArr2[1]).intValue();
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65537, newInitContext);
                }
            }
        }

        public static Type valueOf(String str) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeL = interceptable.invokeL(65538, null, str)) == null) ? (Type) Enum.valueOf(Type.class, str) : (Type) invokeL.objValue;
        }

        public static Type[] values() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(65539, null)) == null) ? (Type[]) $VALUES.clone() : (Type[]) invokeV.objValue;
        }
    }

    public GLVersion(Application.ApplicationType applicationType, String str, String str2, String str3) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {applicationType, str, str2, str3};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        if (applicationType == Application.ApplicationType.Android) {
            this.f29761b = Type.GLES;
        } else if (applicationType == Application.ApplicationType.iOS) {
            this.f29761b = Type.GLES;
        } else if (applicationType == Application.ApplicationType.Desktop) {
            this.f29761b = Type.OpenGL;
        } else if (applicationType == Application.ApplicationType.Applet) {
            this.f29761b = Type.OpenGL;
        } else if (applicationType == Application.ApplicationType.WebGL) {
            this.f29761b = Type.WebGL;
        } else {
            this.f29761b = Type.NONE;
        }
        Type type = this.f29761b;
        if (type == Type.GLES) {
            a("OpenGL ES (\\d(\\.\\d){0,2})", str);
        } else if (type == Type.WebGL) {
            a("WebGL (\\d(\\.\\d){0,2})", str);
        } else if (type == Type.OpenGL) {
            a("(\\d(\\.\\d){0,2})", str);
        } else {
            this.a = -1;
        }
    }

    public final void a(String str, String str2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048576, this, str, str2) == null) {
            Matcher matcher = Pattern.compile(str).matcher(str2);
            if (matcher.find()) {
                String[] split = matcher.group(1).split(EmotionResourceInfo.VERSION_NAME_SEPARATOR_REGEX);
                this.a = c(split[0], 2);
                if (split.length >= 2) {
                    c(split[1], 0);
                }
                if (split.length < 3) {
                    return;
                }
                c(split[2], 0);
                return;
            }
            Application application = f.a;
            application.log("GLVersion", "Invalid version string: " + str2);
            this.a = 2;
        }
    }

    public int b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.a : invokeV.intValue;
    }

    public final int c(String str, int i2) {
        InterceptResult invokeLI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLI = interceptable.invokeLI(Constants.METHOD_SEND_USER_MSG, this, str, i2)) == null) {
            try {
                return Integer.parseInt(str);
            } catch (NumberFormatException unused) {
                Application application = f.a;
                application.error("LibGDX GL", "Error parsing number: " + str + ", assuming: " + i2);
                return i2;
            }
        }
        return invokeLI.intValue;
    }

    public Type getType() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? this.f29761b : (Type) invokeV.objValue;
    }
}
