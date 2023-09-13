package com.badlogic.gdx;

import com.baidu.tieba.d3;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes.dex */
public interface Files {
    d3 a(String str);

    String b();

    d3 d(String str, FileType fileType);

    String e();

    d3 f(String str);

    /* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
    /* loaded from: classes.dex */
    public static final class FileType {
        public static final /* synthetic */ FileType[] $VALUES;
        public static /* synthetic */ Interceptable $ic;
        public static final FileType Absolute;
        public static final FileType Classpath;
        public static final FileType External;
        public static final FileType Internal;
        public static final FileType Local;
        public transient /* synthetic */ FieldHolder $fh;

        static {
            InterceptResult invokeClinit;
            ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
            if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(317126824, "Lcom/badlogic/gdx/Files$FileType;")) != null) {
                Interceptable interceptable = invokeClinit.interceptor;
                if (interceptable != null) {
                    $ic = interceptable;
                }
                if ((invokeClinit.flags & 1) != 0) {
                    classClinitInterceptable.invokePostClinit(317126824, "Lcom/badlogic/gdx/Files$FileType;");
                    return;
                }
            }
            Classpath = new FileType("Classpath", 0);
            Internal = new FileType("Internal", 1);
            External = new FileType("External", 2);
            Absolute = new FileType("Absolute", 3);
            FileType fileType = new FileType("Local", 4);
            Local = fileType;
            $VALUES = new FileType[]{Classpath, Internal, External, Absolute, fileType};
        }

        public FileType(String str, int i) {
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

        public static FileType valueOf(String str) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(65538, null, str)) == null) {
                return (FileType) Enum.valueOf(FileType.class, str);
            }
            return (FileType) invokeL.objValue;
        }

        public static FileType[] values() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(65539, null)) == null) {
                return (FileType[]) $VALUES.clone();
            }
            return (FileType[]) invokeV.objValue;
        }
    }
}
