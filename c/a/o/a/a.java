package c.a.o.a;

import android.content.Context;
import com.baidu.crashpad.ZeusLogUploader;
import com.baidu.crashpad.ZwCrashpad;
import com.baidu.searchbox.common.runtime.AppRuntime;
import com.baidu.searchbox.logsystem.logsys.LogPipelineSingleton;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.Interceptable;
import java.io.File;
/* loaded from: classes3.dex */
public final class a {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public static void a() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65536, null) == null) {
            ZwCrashpad.setEnabled(true);
            File processCrashpadDir = LogPipelineSingleton.getInstance().getProcessCrashpadDir();
            Context appContext = AppRuntime.getAppContext();
            ZwCrashpad.doInit(appContext, new String[]{"0", "0", "0", "0", "0", "0", "0", "true", appContext.getFilesDir().getAbsolutePath(), "0.0.0.0", appContext.getApplicationInfo().nativeLibraryDir, appContext.getApplicationInfo().nativeLibraryDir, processCrashpadDir.getAbsolutePath()});
            ZeusLogUploader.setEnabled(false);
        }
    }
}
