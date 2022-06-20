package com.baidu.searchbox.util;

import androidx.core.view.InputDeviceCompat;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.FileHelper;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.repackage.ht4;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.InputStreamReader;
/* loaded from: classes2.dex */
public class ChannelInitHelper {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public ChannelInitHelper() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
            }
        }
    }

    public static String getFromByFile() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65537, null)) == null) {
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
            } catch (Exception e) {
                BdLog.e(e.getMessage());
                TiebaStatic.file(e, "TiebaApplication.getFromByFile");
                return str;
            }
        }
        return (String) invokeV.objValue;
    }

    public static String getFromByShare() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65538, null)) == null) ? ht4.k().q("from_id", null) : (String) invokeV.objValue;
    }

    public static boolean hasInitFinish() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65539, null)) == null) ? (TbConfig.getCurrentFrom() == null || TbConfig.getFrom() == null) ? false : true : invokeV.booleanValue;
    }

    /* JADX DEBUG: Failed to insert an additional move for type inference into block B:33:0x0077 */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:43:0x007a A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Type inference failed for: r3v0, types: [com.baidu.titan.sdk.runtime.Interceptable] */
    /* JADX WARN: Type inference failed for: r3v2 */
    /* JADX WARN: Type inference failed for: r3v4, types: [java.io.BufferedReader] */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:31:0x0073 -> B:47:0x0076). Please submit an issue!!! */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static void init() {
        ?? r3;
        Throwable th;
        BufferedReader bufferedReader;
        Exception e;
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            r3 = interceptable;
            if (r3.invokeV(InputDeviceCompat.SOURCE_TRACKBALL, null) != null) {
                return;
            }
        }
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
                    } catch (Exception e2) {
                        e = e2;
                        BdLog.e(e.getMessage());
                        if (bufferedReader != null) {
                            bufferedReader.close();
                        }
                    }
                } catch (Throwable th2) {
                    th = th2;
                    if (r3 != 0) {
                        try {
                            r3.close();
                        } catch (Exception e3) {
                            e3.printStackTrace();
                        }
                    }
                    throw th;
                }
            } catch (Exception e4) {
                bufferedReader = null;
                e = e4;
            } catch (Throwable th3) {
                r3 = 0;
                th = th3;
                if (r3 != 0) {
                }
                throw th;
            }
        } catch (Exception e5) {
            e5.printStackTrace();
        }
    }

    public static void saveFromToFile(String str) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(65541, null, str) == null) || str == null || str.length() <= 0) {
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
        } catch (Exception e) {
            BdLog.e(e.getMessage());
            TiebaStatic.file(e, "TiebaApplication.saveFromToFile");
        }
    }

    public static void saveFromToShare(String str) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(65542, null, str) == null) || str == null || str.length() <= 0 || !TbadkCoreApplication.getInst().isMainProcess(true)) {
            return;
        }
        ht4.k().y("from_id", str);
    }
}
