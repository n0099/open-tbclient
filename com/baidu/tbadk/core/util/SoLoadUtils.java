package com.baidu.tbadk.core.util;

import com.baidu.adp.base.BdBaseApplication;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.searchbox.pms.bean.ErrorInfo;
import com.baidu.searchbox.pms.bean.PackageInfo;
import com.baidu.searchbox.pms.callback.DefaultDownloadCallback;
import com.baidu.searchbox.pms.init.PmsManager;
import com.baidu.searchbox.pms.init.RequestParams;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.repackage.bm;
import com.repackage.mg;
import com.repackage.vl;
import com.repackage.wl;
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

    public static void checkDownloadSo(String str, String str2, String str3) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(65538, null, str, str2, str3) == null) {
            if (StringUtils.isNull(BdBaseApplication.getInst().getResHashMap().get(str))) {
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
                            SoLoadUtils.loadPassFaceSo(this.val$soName);
                        }
                    }
                };
                bm bmVar = new bm(str3) { // from class: com.baidu.tbadk.core.util.SoLoadUtils.2
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

                    @Override // com.repackage.bm
                    public void onSoFileLoaded(String str4) {
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 == null || interceptable2.invokeL(1048576, this, str4) == null) {
                            SoLoadUtils.loadPassFaceSo(this.val$soName);
                        }
                    }
                };
                RequestParams requestParams = new RequestParams();
                requestParams.setRunType(wl.a);
                requestParams.setRunNode("aps");
                requestParams.addChannel(new vl(str2, defaultDownloadCallback, bmVar));
                PmsManager.getInstance().execute(requestParams);
                return;
            }
            loadPassFaceSo(str3);
        }
    }

    public static void loadPassFaceSo(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65539, null, str) == null) {
            mg.a().post(new Runnable(str) { // from class: com.baidu.tbadk.core.util.SoLoadUtils.3
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
                            System.loadLibrary(this.val$soName);
                        } catch (Throwable th) {
                            th.printStackTrace();
                        }
                    }
                }
            });
        }
    }
}
