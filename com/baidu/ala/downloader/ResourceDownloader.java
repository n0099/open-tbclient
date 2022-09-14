package com.baidu.ala.downloader;

import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.adp.lib.util.BdNetTypeUtil;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.ala.AlaCmdConfigCustom;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.util.ListUtils;
import com.baidu.tbadk.download.DownloadData;
import com.baidu.tieba.p45;
import com.baidu.tieba.q45;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.io.File;
import java.util.Vector;
/* loaded from: classes.dex */
public class ResourceDownloader {
    public static /* synthetic */ Interceptable $ic;
    public static Vector<String> sResDownloadingTaskList;
    public transient /* synthetic */ FieldHolder $fh;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable == null || (invokeClinit = classClinitInterceptable.invokeClinit(2080744421, "Lcom/baidu/ala/downloader/ResourceDownloader;")) == null) {
            return;
        }
        Interceptable interceptable = invokeClinit.interceptor;
        if (interceptable != null) {
            $ic = interceptable;
        }
        if ((invokeClinit.flags & 1) != 0) {
            classClinitInterceptable.invokePostClinit(2080744421, "Lcom/baidu/ala/downloader/ResourceDownloader;");
        }
    }

    public ResourceDownloader() {
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

    public static void addDownloadingResId(String str) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(65542, null, str) == null) || StringUtils.isNull(str)) {
            return;
        }
        if (sResDownloadingTaskList == null) {
            sResDownloadingTaskList = new Vector<>();
        }
        synchronized (sResDownloadingTaskList) {
            sResDownloadingTaskList.add(str);
        }
    }

    public static boolean checkAndDownloadResZip(String str, String str2, String str3, String str4, String str5, String str6, boolean z) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(65543, null, new Object[]{str, str2, str3, str4, str5, str6, Boolean.valueOf(z)})) == null) {
            if (StringUtils.isNull(str3) || StringUtils.isNull(str2) || StringUtils.isNull(str6)) {
                return false;
            }
            if (DownloaderHelper.checkDirFiles(str4, DownloaderHelper.getAllFileMd5Set(str5 + str3))) {
                if (!DownloaderHelper.existFile(str4)) {
                    new File(str4).mkdirs();
                }
                realDownloadResZip(str, str2, str3, str4, str5, str6, z);
                return true;
            }
            return false;
        }
        return invokeCommon.booleanValue;
    }

    public static void checkAndDownloadResZipInMainThread(String str, String str2, String str3, String str4, String str5, String str6, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(65544, null, new Object[]{str, str2, str3, str4, str5, str6, Boolean.valueOf(z)}) == null) {
            new BdAsyncTask<String, Void, Void>(str, str2, str3, str4, str5, str6, z) { // from class: com.baidu.ala.downloader.ResourceDownloader.1
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;
                public final /* synthetic */ String val$fileMd5Prefix;
                public final /* synthetic */ boolean val$isForceDownload;
                public final /* synthetic */ String val$resDir;
                public final /* synthetic */ String val$resId;
                public final /* synthetic */ String val$resName;
                public final /* synthetic */ String val$url;
                public final /* synthetic */ String val$zipMd5;

                {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {str, str2, str3, str4, str5, str6, Boolean.valueOf(z)};
                        interceptable2.invokeUnInit(65536, newInitContext);
                        int i = newInitContext.flag;
                        if ((i & 1) != 0) {
                            int i2 = i & 2;
                            newInitContext.thisArg = this;
                            interceptable2.invokeInitBody(65536, newInitContext);
                            return;
                        }
                    }
                    this.val$resId = str;
                    this.val$url = str2;
                    this.val$resName = str3;
                    this.val$resDir = str4;
                    this.val$fileMd5Prefix = str5;
                    this.val$zipMd5 = str6;
                    this.val$isForceDownload = z;
                }

                /* JADX DEBUG: Method merged with bridge method */
                @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
                public Void doInBackground(String... strArr) {
                    InterceptResult invokeL;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeL = interceptable2.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, strArr)) == null) {
                        ResourceDownloader.checkAndDownloadResZip(this.val$resId, this.val$url, this.val$resName, this.val$resDir, this.val$fileMd5Prefix, this.val$zipMd5, this.val$isForceDownload);
                        return null;
                    }
                    return (Void) invokeL.objValue;
                }
            }.execute(new String[0]);
        }
    }

    public static boolean checkDirNeedToDownload(String str, String str2) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLL = interceptable.invokeLL(65545, null, str, str2)) == null) ? DownloaderHelper.checkDirFiles(str, DownloaderHelper.getAllFileMd5Set(str2)) : invokeLL.booleanValue;
    }

    public static boolean isResZipDownloading(String str) {
        InterceptResult invokeL;
        boolean contains;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65546, null, str)) == null) {
            if (ListUtils.isEmpty(sResDownloadingTaskList) || StringUtils.isNull(str)) {
                return false;
            }
            synchronized (sResDownloadingTaskList) {
                contains = sResDownloadingTaskList.contains(str);
            }
            return contains;
        }
        return invokeL.booleanValue;
    }

    public static void realDownloadResZip(String str, String str2, String str3, String str4, String str5, String str6, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(65547, null, new Object[]{str, str2, str3, str4, str5, str6, Boolean.valueOf(z)}) == null) {
            if (BdNetTypeUtil.isWifiNet() || z) {
                DownloadData downloadData = new DownloadData();
                downloadData.setId(str);
                downloadData.setName(str3);
                downloadData.setUrl(str2);
                downloadData.setCheck(str6);
                downloadData.setType(19);
                downloadData.setCallback(new p45(z, str4, str5 + str3) { // from class: com.baidu.ala.downloader.ResourceDownloader.2
                    public static /* synthetic */ Interceptable $ic;
                    public transient /* synthetic */ FieldHolder $fh;
                    public final /* synthetic */ String val$fileMd5ListKey;
                    public final /* synthetic */ boolean val$isForceDownload;
                    public final /* synthetic */ String val$targetResDir;

                    {
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 != null) {
                            InitContext newInitContext = TitanRuntime.newInitContext();
                            newInitContext.initArgs = r2;
                            Object[] objArr = {Boolean.valueOf(z), str4, r8};
                            interceptable2.invokeUnInit(65536, newInitContext);
                            int i = newInitContext.flag;
                            if ((i & 1) != 0) {
                                int i2 = i & 2;
                                newInitContext.thisArg = this;
                                interceptable2.invokeInitBody(65536, newInitContext);
                                return;
                            }
                        }
                        this.val$isForceDownload = z;
                        this.val$targetResDir = str4;
                        this.val$fileMd5ListKey = r8;
                    }

                    @Override // com.baidu.tieba.p45
                    public void onFileDownloadFailed(DownloadData downloadData2, int i, String str7) {
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 == null || interceptable2.invokeLIL(1048576, this, downloadData2, i, str7) == null) {
                            ResourceDownloader.removeDownloadingResId(downloadData2.getId());
                            ResourceDownloader.sendDownloadStatusMessage(5, downloadData2);
                            BdLog.e("failed to donwload dynamic zip" + str7);
                        }
                    }

                    @Override // com.baidu.tieba.p45
                    public void onFileDownloadSucceed(DownloadData downloadData2) {
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 == null || interceptable2.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, downloadData2) == null) {
                            new BdAsyncTask<Void, Void, Boolean>(this, downloadData2) { // from class: com.baidu.ala.downloader.ResourceDownloader.2.1
                                public static /* synthetic */ Interceptable $ic;
                                public transient /* synthetic */ FieldHolder $fh;
                                public final /* synthetic */ AnonymousClass2 this$0;
                                public final /* synthetic */ DownloadData val$data;

                                {
                                    Interceptable interceptable3 = $ic;
                                    if (interceptable3 != null) {
                                        InitContext newInitContext = TitanRuntime.newInitContext();
                                        newInitContext.initArgs = r2;
                                        Object[] objArr = {this, downloadData2};
                                        interceptable3.invokeUnInit(65536, newInitContext);
                                        int i = newInitContext.flag;
                                        if ((i & 1) != 0) {
                                            int i2 = i & 2;
                                            newInitContext.thisArg = this;
                                            interceptable3.invokeInitBody(65536, newInitContext);
                                            return;
                                        }
                                    }
                                    this.this$0 = this;
                                    this.val$data = downloadData2;
                                }

                                @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
                                public void onCancelled() {
                                    Interceptable interceptable3 = $ic;
                                    if (interceptable3 == null || interceptable3.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
                                        super.onCancelled();
                                        ResourceDownloader.removeDownloadingResId(this.val$data.getId());
                                    }
                                }

                                /* JADX DEBUG: Method merged with bridge method */
                                @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
                                public Boolean doInBackground(Void... voidArr) {
                                    InterceptResult invokeL;
                                    Interceptable interceptable3 = $ic;
                                    if (interceptable3 == null || (invokeL = interceptable3.invokeL(1048576, this, voidArr)) == null) {
                                        if (this.val$data.getPath() == null) {
                                            return Boolean.FALSE;
                                        }
                                        if (!new File(this.val$data.getPath()).exists()) {
                                            return Boolean.FALSE;
                                        }
                                        boolean unZipFile = DownloaderHelper.unZipFile(this.val$data.getPath(), this.this$0.val$targetResDir);
                                        if (unZipFile) {
                                            AnonymousClass2 anonymousClass2 = this.this$0;
                                            DownloaderHelper.saveAllFileMd5ToSharePreference(anonymousClass2.val$fileMd5ListKey, anonymousClass2.val$targetResDir);
                                            ResourceDownloader.sendDownloadStatusMessage(4, this.val$data);
                                        }
                                        return Boolean.valueOf(unZipFile);
                                    }
                                    return (Boolean) invokeL.objValue;
                                }

                                /* JADX DEBUG: Method merged with bridge method */
                                @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
                                public void onPostExecute(Boolean bool) {
                                    Interceptable interceptable3 = $ic;
                                    if (interceptable3 == null || interceptable3.invokeL(1048579, this, bool) == null) {
                                        ResourceDownloader.removeDownloadingResId(this.val$data.getId());
                                        if (bool.booleanValue()) {
                                            if (DownloaderHelper.existFile(this.this$0.val$targetResDir)) {
                                                return;
                                            }
                                            BdLog.e("zip empty");
                                            return;
                                        }
                                        BdLog.e("failed to unzip");
                                    }
                                }
                            }.execute(new Void[0]);
                        }
                    }

                    @Override // com.baidu.tieba.p45
                    public boolean onFileDownloaded(DownloadData downloadData2) {
                        InterceptResult invokeL;
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 == null || (invokeL = interceptable2.invokeL(Constants.METHOD_SEND_USER_MSG, this, downloadData2)) == null) {
                            ResourceDownloader.sendDownloadStatusMessage(3, downloadData2);
                            return true;
                        }
                        return invokeL.booleanValue;
                    }

                    @Override // com.baidu.tieba.p45
                    public void onFileUpdateProgress(DownloadData downloadData2) {
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 == null || interceptable2.invokeL(1048579, this, downloadData2) == null) {
                            ResourceDownloader.sendDownloadStatusMessage(2, downloadData2);
                        }
                    }

                    @Override // com.baidu.tieba.p45
                    public boolean onPreDownload(DownloadData downloadData2) {
                        InterceptResult invokeL;
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 == null || (invokeL = interceptable2.invokeL(1048580, this, downloadData2)) == null) {
                            if (BdNetTypeUtil.isWifiNet() || this.val$isForceDownload) {
                                ResourceDownloader.sendDownloadStatusMessage(1, downloadData2);
                                return true;
                            }
                            return false;
                        }
                        return invokeL.booleanValue;
                    }
                });
                new BdAsyncTask<Void, Void, Boolean>(str, str4, downloadData, str4 + "/" + str3 + ".zip") { // from class: com.baidu.ala.downloader.ResourceDownloader.3
                    public static /* synthetic */ Interceptable $ic;
                    public transient /* synthetic */ FieldHolder $fh;
                    public final /* synthetic */ DownloadData val$downloadData;
                    public final /* synthetic */ String val$resId;
                    public final /* synthetic */ String val$targetResDir;
                    public final /* synthetic */ String val$targetResPath;

                    {
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 != null) {
                            InitContext newInitContext = TitanRuntime.newInitContext();
                            newInitContext.initArgs = r2;
                            Object[] objArr = {str, str4, downloadData, r9};
                            interceptable2.invokeUnInit(65536, newInitContext);
                            int i = newInitContext.flag;
                            if ((i & 1) != 0) {
                                int i2 = i & 2;
                                newInitContext.thisArg = this;
                                interceptable2.invokeInitBody(65536, newInitContext);
                                return;
                            }
                        }
                        this.val$resId = str;
                        this.val$targetResDir = str4;
                        this.val$downloadData = downloadData;
                        this.val$targetResPath = r9;
                    }

                    /* JADX DEBUG: Method merged with bridge method */
                    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
                    public void onPostExecute(Boolean bool) {
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 == null || interceptable2.invokeL(Constants.METHOD_SEND_USER_MSG, this, bool) == null) {
                        }
                    }

                    /* JADX DEBUG: Method merged with bridge method */
                    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
                    public Boolean doInBackground(Void... voidArr) {
                        InterceptResult invokeL;
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 == null || (invokeL = interceptable2.invokeL(1048576, this, voidArr)) == null) {
                            if (!ResourceDownloader.isResZipDownloading(this.val$resId)) {
                                ResourceDownloader.addDownloadingResId(this.val$resId);
                                DownloaderHelper.cleanDir(new File(this.val$targetResDir));
                                this.val$downloadData.setPath(this.val$targetResPath);
                                q45.k().l(this.val$downloadData);
                                return Boolean.TRUE;
                            }
                            return Boolean.FALSE;
                        }
                        return (Boolean) invokeL.objValue;
                    }
                }.execute(new Void[0]);
            }
        }
    }

    public static void removeDownloadingResId(String str) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(65548, null, str) == null) || sResDownloadingTaskList == null || StringUtils.isNull(str)) {
            return;
        }
        synchronized (sResDownloadingTaskList) {
            sResDownloadingTaskList.remove(str);
        }
        if (sResDownloadingTaskList.size() == 0) {
            sResDownloadingTaskList = null;
        }
    }

    public static void sendDownloadStatusMessage(int i, DownloadData downloadData) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIL(65549, null, i, downloadData) == null) {
            WrapDownloadData wrapDownloadData = new WrapDownloadData();
            wrapDownloadData.status = i;
            wrapDownloadData.data = downloadData;
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(AlaCmdConfigCustom.CMD_ALA_RES_ZIP_DOWNLOADED_STATUS, wrapDownloadData));
        }
    }
}
