package com.baidu.searchbox.logsystem.basic.eventhandler;

import android.content.Context;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.baidu.searchbox.logsystem.logsys.LogFile;
import com.baidu.searchbox.logsystem.logsys.eventscene.EventObject;
import com.baidu.searchbox.logsystem.logsys.eventscene.handler.DeviceEventSceneHandler;
import com.baidu.searchbox.logsystem.util.Utility;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.io.File;
import java.util.HashSet;
import java.util.Set;
/* loaded from: classes5.dex */
public class SOEventSceneSceneHandler extends DeviceEventSceneHandler {
    public static /* synthetic */ Interceptable $ic = null;
    public static final String SO_CRASH = "UnsatisfiedLinkError";
    public static final String SO_FILE_INFO = "sofileinfo";
    public transient /* synthetic */ FieldHolder $fh;

    public SOEventSceneSceneHandler() {
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

    @Override // com.baidu.searchbox.logsystem.logsys.eventscene.handler.BaseEventSceneHandler, com.baidu.searchbox.logsystem.logsys.eventscene.handler.EventSceneHandler
    @Nullable
    public Set<LogFile> getCustomizedSnapshots(@NonNull Context context, @NonNull File file, @NonNull EventObject eventObject) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(1048576, this, context, file, eventObject)) == null) {
            if (eventObject.mEventLog.contains(SO_CRASH)) {
                File file2 = new File(file, SO_FILE_INFO);
                if (Utility.createNewEmptyFile(file2)) {
                    HashSet hashSet = new HashSet(1);
                    Utility.obtainInstalledSoInfo(context, file2);
                    hashSet.add(new LogFile(file2));
                    return hashSet;
                }
            }
            return null;
        }
        return (Set) invokeLLL.objValue;
    }
}
