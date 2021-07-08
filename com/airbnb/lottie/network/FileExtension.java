package com.airbnb.lottie.network;

import androidx.core.view.InputDeviceCompat;
import com.airbnb.lottie.utils.Logger;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.mobads.container.util.XAdSimpleImageLoader;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* loaded from: classes.dex */
public final class FileExtension {
    public static final /* synthetic */ FileExtension[] $VALUES;
    public static /* synthetic */ Interceptable $ic;
    public static final FileExtension JSON;
    public static final FileExtension ZIP;
    public transient /* synthetic */ FieldHolder $fh;
    public final String extension;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-1245469088, "Lcom/airbnb/lottie/network/FileExtension;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-1245469088, "Lcom/airbnb/lottie/network/FileExtension;");
                return;
            }
        }
        JSON = new FileExtension("JSON", 0, ".json");
        FileExtension fileExtension = new FileExtension("ZIP", 1, ".zip");
        ZIP = fileExtension;
        $VALUES = new FileExtension[]{JSON, fileExtension};
    }

    public FileExtension(String str, int i2, String str2) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {str, Integer.valueOf(i2), str2};
            interceptable.invokeUnInit(65537, newInitContext);
            int i3 = newInitContext.flag;
            if ((i3 & 1) != 0) {
                int i4 = i3 & 2;
                Object[] objArr2 = newInitContext.callArgs;
                String str3 = (String) objArr2[0];
                ((Integer) objArr2[1]).intValue();
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.extension = str2;
    }

    public static FileExtension forFile(String str) {
        InterceptResult invokeL;
        FileExtension[] values;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65538, null, str)) == null) {
            for (FileExtension fileExtension : values()) {
                if (str.endsWith(fileExtension.extension)) {
                    return fileExtension;
                }
            }
            Logger.warning("Unable to find correct extension for " + str);
            return JSON;
        }
        return (FileExtension) invokeL.objValue;
    }

    public static FileExtension valueOf(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65539, null, str)) == null) ? (FileExtension) Enum.valueOf(FileExtension.class, str) : (FileExtension) invokeL.objValue;
    }

    public static FileExtension[] values() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TRACKBALL, null)) == null) ? (FileExtension[]) $VALUES.clone() : (FileExtension[]) invokeV.objValue;
    }

    public String tempExtension() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            return XAdSimpleImageLoader.TEMP_SUFFIX + this.extension;
        }
        return (String) invokeV.objValue;
    }

    @Override // java.lang.Enum
    public String toString() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.extension : (String) invokeV.objValue;
    }
}
