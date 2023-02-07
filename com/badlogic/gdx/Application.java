package com.badlogic.gdx;

import com.baidu.tieba.i1;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes.dex */
public interface Application {
    void debug(String str, String str2);

    void error(String str, String str2);

    void error(String str, String str2, Throwable th);

    i1 getApplicationListener();

    Graphics getGraphics();

    ApplicationType getType();

    void log(String str, String str2);

    void postRunnable(Runnable runnable);

    /* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
    /* loaded from: classes.dex */
    public static final class ApplicationType {
        public static final /* synthetic */ ApplicationType[] $VALUES;
        public static /* synthetic */ Interceptable $ic;
        public static final ApplicationType Android;
        public static final ApplicationType Applet;
        public static final ApplicationType Desktop;
        public static final ApplicationType HeadlessDesktop;
        public static final ApplicationType WebGL;
        public static final ApplicationType iOS;
        public transient /* synthetic */ FieldHolder $fh;

        static {
            InterceptResult invokeClinit;
            ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
            if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(709427509, "Lcom/badlogic/gdx/Application$ApplicationType;")) != null) {
                Interceptable interceptable = invokeClinit.interceptor;
                if (interceptable != null) {
                    $ic = interceptable;
                }
                if ((invokeClinit.flags & 1) != 0) {
                    classClinitInterceptable.invokePostClinit(709427509, "Lcom/badlogic/gdx/Application$ApplicationType;");
                    return;
                }
            }
            Android = new ApplicationType("Android", 0);
            Desktop = new ApplicationType("Desktop", 1);
            HeadlessDesktop = new ApplicationType("HeadlessDesktop", 2);
            Applet = new ApplicationType("Applet", 3);
            WebGL = new ApplicationType("WebGL", 4);
            ApplicationType applicationType = new ApplicationType("iOS", 5);
            iOS = applicationType;
            $VALUES = new ApplicationType[]{Android, Desktop, HeadlessDesktop, Applet, WebGL, applicationType};
        }

        public ApplicationType(String str, int i) {
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

        public static ApplicationType valueOf(String str) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(65538, null, str)) == null) {
                return (ApplicationType) Enum.valueOf(ApplicationType.class, str);
            }
            return (ApplicationType) invokeL.objValue;
        }

        public static ApplicationType[] values() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(65539, null)) == null) {
                return (ApplicationType[]) $VALUES.clone();
            }
            return (ApplicationType[]) invokeV.objValue;
        }
    }
}
