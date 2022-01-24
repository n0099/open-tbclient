package com.baidu.searchbox.task.sync.appcreate;

import androidx.core.view.InputDeviceCompat;
import c.a.s0.s.i0.b;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.searchbox.performance.speed.task.LaunchTask;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.FileHelper;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.InputStreamReader;
/* loaded from: classes11.dex */
public class InitGlobalDataTask extends LaunchTask {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public InitGlobalDataTask() {
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

    /* JADX WARN: Removed duplicated region for block: B:43:0x007a A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:31:0x0073 -> B:47:0x0076). Please submit an issue!!! */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private void InitFrom() {
        Throwable th;
        BufferedReader bufferedReader;
        Exception e2;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65537, this) == null) {
            BufferedReader bufferedReader2 = null;
            try {
                try {
                    try {
                        String fromByShare = getFromByShare();
                        bufferedReader = new BufferedReader(new InputStreamReader(TbadkCoreApplication.getInst().getResources().getAssets().open("channel"), "gbk"));
                        try {
                            String readLine = bufferedReader.readLine();
                            TbConfig.setCurrentFrom(readLine);
                            if (fromByShare == null) {
                                String fromByFile = getFromByFile();
                                if (fromByFile != null && fromByFile.length() > 0) {
                                    TbConfig.setFrom(fromByFile);
                                    saveFromToShare(fromByFile);
                                } else if (readLine != null && readLine.length() > 0) {
                                    TbConfig.setFrom(readLine);
                                    saveFromToShare(readLine);
                                    saveFromToFile(readLine);
                                }
                            } else {
                                TbConfig.setFrom(fromByShare);
                            }
                            bufferedReader.close();
                        } catch (Exception e3) {
                            e2 = e3;
                            BdLog.e(e2.getMessage());
                            if (bufferedReader != null) {
                                bufferedReader.close();
                            }
                        }
                    } catch (Throwable th2) {
                        th = th2;
                        if (0 != 0) {
                            try {
                                bufferedReader2.close();
                            } catch (Exception e4) {
                                e4.printStackTrace();
                            }
                        }
                        throw th;
                    }
                } catch (Exception e5) {
                    bufferedReader = null;
                    e2 = e5;
                } catch (Throwable th3) {
                    th = th3;
                    if (0 != 0) {
                    }
                    throw th;
                }
            } catch (Exception e6) {
                e6.printStackTrace();
            }
        }
    }

    private String getFromByFile() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65538, this)) == null) {
            String str = null;
            try {
                File GetFile = FileHelper.GetFile(TbConfig.FROM_FILE);
                if (GetFile != null) {
                    BufferedReader bufferedReader = new BufferedReader(new FileReader(GetFile));
                    str = bufferedReader.readLine();
                    bufferedReader.close();
                    return str;
                }
                return null;
            } catch (Exception e2) {
                BdLog.e(e2.getMessage());
                TiebaStatic.file(e2, "TiebaApplication.getFromByFile");
                return str;
            }
        }
        return (String) invokeV.objValue;
    }

    private String getFromByShare() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65539, this)) == null) ? b.k().q("from_id", null) : (String) invokeV.objValue;
    }

    private void saveFromToFile(String str) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TRACKBALL, this, str) == null) || str == null || str.length() <= 0) {
            return;
        }
        try {
            File CreateFile = FileHelper.CreateFile(TbConfig.FROM_FILE);
            if (CreateFile != null) {
                FileWriter fileWriter = new FileWriter(CreateFile);
                fileWriter.append((CharSequence) str);
                fileWriter.flush();
                fileWriter.close();
            }
        } catch (Exception e2) {
            BdLog.e(e2.getMessage());
            TiebaStatic.file(e2, "TiebaApplication.saveFromToFile");
        }
    }

    private void saveFromToShare(String str) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(65541, this, str) == null) || str == null || str.length() <= 0 || !TbadkCoreApplication.getInst().isMainProcess(true)) {
            return;
        }
        b.k().y("from_id", str);
    }

    @Override // com.baidu.searchbox.performance.speed.task.LaunchTask
    public void execute() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            TbadkCoreApplication.setClientId(TbadkCoreApplication.getInst().readClientId(TbadkCoreApplication.getInst().getContext()));
            TbadkCoreApplication.getInst().initImei();
            InitFrom();
        }
    }

    @Override // com.baidu.searchbox.performance.speed.task.LaunchTask
    public String getName() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? "AppCreate_InitGlobalData" : (String) invokeV.objValue;
    }

    @Override // com.baidu.searchbox.performance.speed.task.LaunchTask
    public int getProcess() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            return -1;
        }
        return invokeV.intValue;
    }
}
