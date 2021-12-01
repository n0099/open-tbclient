package com.baidu.searchbox.bddownload.core;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.io.File;
/* loaded from: classes9.dex */
public abstract class IdentifiedTask {
    public static /* synthetic */ Interceptable $ic = null;
    public static final File EMPTY_FILE;
    public static final String EMPTY_URL = "";
    public transient /* synthetic */ FieldHolder $fh;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-1891518250, "Lcom/baidu/searchbox/bddownload/core/IdentifiedTask;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-1891518250, "Lcom/baidu/searchbox/bddownload/core/IdentifiedTask;");
                return;
            }
        }
        EMPTY_FILE = new File("");
    }

    public IdentifiedTask() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
            }
        }
    }

    public boolean compareIgnoreId(IdentifiedTask identifiedTask) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, identifiedTask)) == null) {
            if (!getUrl().equals(identifiedTask.getUrl()) || getUrl().equals("") || getParentFile().equals(EMPTY_FILE)) {
                return false;
            }
            if (getProvidedPathFile().equals(identifiedTask.getProvidedPathFile())) {
                return true;
            }
            if (getParentFile().equals(identifiedTask.getParentFile())) {
                String filename = getFilename();
                String filename2 = identifiedTask.getFilename();
                return (filename2 == null || filename == null || !filename2.equals(filename)) ? false : true;
            }
            return false;
        }
        return invokeL.booleanValue;
    }

    @Nullable
    public abstract String getFilename();

    public abstract int getId();

    @NonNull
    public abstract File getParentFile();

    @NonNull
    public abstract File getProvidedPathFile();

    @NonNull
    public abstract String getUrl();
}
