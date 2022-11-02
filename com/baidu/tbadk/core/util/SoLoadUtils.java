package com.baidu.tbadk.core.util;

import android.os.Process;
import androidx.annotation.NonNull;
import androidx.core.view.InputDeviceCompat;
import com.baidu.adp.base.BdBaseApplication;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.searchbox.live.interfaces.DI;
import com.baidu.searchbox.pms.bean.ErrorInfo;
import com.baidu.searchbox.pms.bean.PackageInfo;
import com.baidu.searchbox.pms.callback.DefaultDownloadCallback;
import com.baidu.searchbox.pms.init.PmsManager;
import com.baidu.searchbox.pms.init.RequestParams;
import com.baidu.tbadk.util.DataExt;
import com.baidu.tieba.im;
import com.baidu.tieba.jm;
import com.baidu.tieba.mi;
import com.baidu.tieba.om;
import com.baidu.tieba.zg;
import com.baidu.tieba.zx4;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes3.dex */
public class SoLoadUtils {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public SoLoadUtils() {
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

    public static void loadPassFaceSo(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65541, null, str) == null) {
            zg.a().post(new Runnable(str) { // from class: com.baidu.tbadk.core.util.SoLoadUtils.3
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;
                public final /* synthetic */ String val$soName;

                {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {str};
                        interceptable2.invokeUnInit(65536, newInitContext);
                        int i = newInitContext.flag;
                        if ((i & 1) != 0) {
                            int i2 = i & 2;
                            newInitContext.thisArg = this;
                            interceptable2.invokeInitBody(65536, newInitContext);
                            return;
                        }
                    }
                    this.val$soName = str;
                }

                @Override // java.lang.Runnable
                public void run() {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                        try {
                            zx4.a(DI.ACCOUNT, 100L, 0, "SoLoadUtils_loadLibrary_start", 0, "", new Object[0]);
                            System.loadLibrary(this.val$soName);
                            zx4.a(DI.ACCOUNT, 100L, 0, "SoLoadUtils_loadLibrary_end", 0, "", new Object[0]);
                        } catch (Throwable th) {
                            th.printStackTrace();
                            zx4.a(DI.ACCOUNT, 100L, 0, "SoLoadUtils_loadLibrary_error", 1, th.getMessage(), new Object[0]);
                        }
                    }
                }
            });
        }
    }

    public static void checkDownloadSo(String str, String str2, String str3) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(65538, null, str, str2, str3) == null) {
            if (StringUtils.isNull(BdBaseApplication.getInst().getResHashMap().get(str))) {
                zx4.a(DI.ACCOUNT, 100L, 0, "SoLoadUtils_checkDownloadSo_nonSo", 0, "", new Object[0]);
                DefaultDownloadCallback defaultDownloadCallback = new DefaultDownloadCallback(str3) { // from class: com.baidu.tbadk.core.util.SoLoadUtils.1
                    public static /* synthetic */ Interceptable $ic;
                    public transient /* synthetic */ FieldHolder $fh;
                    public final /* synthetic */ String val$soName;

                    {
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 != null) {
                            InitContext newInitContext = TitanRuntime.newInitContext();
                            newInitContext.initArgs = r2;
                            Object[] objArr = {str3};
                            interceptable2.invokeUnInit(65536, newInitContext);
                            int i = newInitContext.flag;
                            if ((i & 1) != 0) {
                                int i2 = i & 2;
                                newInitContext.thisArg = this;
                                interceptable2.invokeInitBody(65536, newInitContext);
                                return;
                            }
                        }
                        this.val$soName = str3;
                    }

                    @Override // com.baidu.searchbox.pms.callback.DefaultDownloadCallback, com.baidu.searchbox.pms.callback.DownloadCallback
                    public void onDownloadSuccess(PackageInfo packageInfo, ErrorInfo errorInfo) {
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 == null || interceptable2.invokeLL(1048576, this, packageInfo, errorInfo) == null) {
                            super.onDownloadSuccess(packageInfo, errorInfo);
                            zx4.a(DI.ACCOUNT, 100L, 0, "SoLoadUtils_checkDownloadSo_nonSo_onDownloadSuccess", 0, "", new Object[0]);
                            SoLoadUtils.loadPassFaceSo(this.val$soName);
                        }
                    }
                };
                om omVar = new om(str3) { // from class: com.baidu.tbadk.core.util.SoLoadUtils.2
                    public static /* synthetic */ Interceptable $ic;
                    public transient /* synthetic */ FieldHolder $fh;
                    public final /* synthetic */ String val$soName;

                    {
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 != null) {
                            InitContext newInitContext = TitanRuntime.newInitContext();
                            newInitContext.initArgs = r2;
                            Object[] objArr = {str3};
                            interceptable2.invokeUnInit(65536, newInitContext);
                            int i = newInitContext.flag;
                            if ((i & 1) != 0) {
                                int i2 = i & 2;
                                newInitContext.thisArg = this;
                                interceptable2.invokeInitBody(65536, newInitContext);
                                return;
                            }
                        }
                        this.val$soName = str3;
                    }

                    @Override // com.baidu.tieba.om
                    public void onSoFileLoaded(String str4) {
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 == null || interceptable2.invokeL(1048576, this, str4) == null) {
                            zx4.a(DI.ACCOUNT, 100L, 0, "SoLoadUtils_checkDownloadSo_nonSo_onSoFileLoaded", 0, "", new Object[0]);
                            SoLoadUtils.loadPassFaceSo(this.val$soName);
                        }
                    }
                };
                RequestParams requestParams = new RequestParams();
                requestParams.setRunType(jm.a);
                requestParams.setRunNode("aps");
                requestParams.addChannel(new im(str2, defaultDownloadCallback, omVar));
                PmsManager.getInstance().execute(requestParams);
                return;
            }
            zx4.a(DI.ACCOUNT, 100L, 0, "SoLoadUtils_checkDownloadSo_hasSo", 0, "", new Object[0]);
            loadPassFaceSo(str3);
        }
    }

    @NonNull
    public static String getCurrSoDownloaded() {
        InterceptResult invokeV;
        String str;
        String[] list;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65539, null)) == null) {
            if (mi.a()) {
                str = "so_64_cache";
            } else {
                str = "so_cache";
            }
            File file = new File(BdBaseApplication.getInst().getFilesDir() + File.separator + str);
            if (file.exists() && (list = file.list()) != null) {
                return DataExt.toJson(list);
            }
            return "";
        }
        return (String) invokeV.objValue;
    }

    @NonNull
    public static String getCurrSoLoaded() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TRACKBALL, null)) == null) {
            int myPid = Process.myPid();
            File file = new File("/proc/" + myPid + "/maps");
            if (file.exists() && file.isFile()) {
                List<String> readFileByLines = readFileByLines(file.getAbsolutePath());
                ArrayList arrayList = new ArrayList();
                for (int i = 0; i < readFileByLines.size(); i++) {
                    String str = readFileByLines.get(i);
                    if (str.startsWith("/data/")) {
                        arrayList.add(str);
                    }
                }
                return DataExt.toJson(arrayList);
            }
            return "";
        }
        return (String) invokeV.objValue;
    }

    @NonNull
    public static List<String> readFileByLines(String str) {
        InterceptResult invokeL;
        int indexOf;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65542, null, str)) == null) {
            ArrayList arrayList = new ArrayList();
            try {
                BufferedReader bufferedReader = new BufferedReader(new FileReader(new File(str)));
                while (true) {
                    String readLine = bufferedReader.readLine();
                    if (readLine == null) {
                        break;
                    } else if (readLine.endsWith(".so") && (indexOf = readLine.indexOf("/")) != -1) {
                        arrayList.add(readLine.substring(indexOf));
                    }
                }
                bufferedReader.close();
            } catch (Exception e) {
                e.printStackTrace();
            }
            return arrayList;
        }
        return (List) invokeL.objValue;
    }
}
