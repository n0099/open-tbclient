package com.baidu.sofire;

import android.content.Context;
import com.baidu.sofire.utility.CommonMethods;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.io.File;
import java.util.HashMap;
import java.util.Map;
/* loaded from: classes4.dex */
public class FileDeleteObserverUtils {
    public static /* synthetic */ Interceptable $ic;
    public static Map<String, MyFileObserver> map;
    public transient /* synthetic */ FieldHolder $fh;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1015414, "Lcom/baidu/sofire/FileDeleteObserverUtils;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1015414, "Lcom/baidu/sofire/FileDeleteObserverUtils;");
                return;
            }
        }
        map = new HashMap();
    }

    public FileDeleteObserverUtils() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65537, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
            }
        }
    }

    public static void registerObserver(Context context, int i, File file, File file2) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLILL(65538, null, context, i, file, file2) == null) || file == null) {
            return;
        }
        try {
            if (CommonMethods.isFileExist(file) && file2 != null) {
                if (!CommonMethods.isFileExist(file2)) {
                    CommonMethods.copyFile(file, file2);
                }
                if (map.containsKey(file.getAbsolutePath())) {
                    return;
                }
                MyFileObserver myFileObserver = new MyFileObserver(context, i, file.getAbsolutePath(), file2.getAbsolutePath());
                myFileObserver.startWatching();
                map.put(file.getAbsolutePath(), myFileObserver);
            }
        } catch (Throwable th) {
            CommonMethods.handleNuLException(th);
        }
    }

    public static void unRegisterObserver(File file) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(65539, null, file) == null) || file == null) {
            return;
        }
        try {
            MyFileObserver myFileObserver = map.get(file.getAbsolutePath());
            if (myFileObserver != null) {
                myFileObserver.stopWatching();
                map.remove(file.getAbsolutePath());
                myFileObserver.deleteBackUpFile();
            }
        } catch (Throwable th) {
            CommonMethods.handleNuLException(th);
        }
    }
}
