package c.a.r0.s0;

import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.download.DownloadData;
import com.baidu.tieba.faceshop.EmotionGroupData;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
/* loaded from: classes3.dex */
public class e implements c.a.q0.w.e {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public e() {
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

    @Override // c.a.q0.w.e
    public void onFileDownloadFailed(DownloadData downloadData, int i2, String str) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLIL(1048576, this, downloadData, i2, str) == null) || i2 == 3) {
            return;
        }
        try {
            File file = new File(downloadData.getPath());
            if (file.exists()) {
                file.delete();
            }
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }

    @Override // c.a.q0.w.e
    public void onFileDownloadSucceed(DownloadData downloadData) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, downloadData) == null) {
            MessageManager.getInstance().runTask(2004603, (Class) null);
            try {
                File file = new File(downloadData.getPath());
                if (file.exists()) {
                    file.delete();
                }
            } catch (Exception e2) {
                e2.printStackTrace();
            }
        }
    }

    @Override // c.a.q0.w.e
    public boolean onFileDownloaded(DownloadData downloadData) {
        InterceptResult invokeL;
        FileInputStream fileInputStream;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, downloadData)) == null) {
            if (downloadData == null) {
                return false;
            }
            FileInputStream fileInputStream2 = null;
            try {
                try {
                    fileInputStream = new FileInputStream(downloadData.getPath());
                } catch (Exception e2) {
                    e = e2;
                }
            } catch (Throwable th) {
                th = th;
            }
            try {
                int g2 = a.c().g(downloadData.getId(), fileInputStream);
                EmotionGroupData j2 = g.k().j(downloadData.getId());
                if (j2 == null) {
                    if (g2 == 0) {
                        try {
                            fileInputStream.close();
                        } catch (IOException e3) {
                            BdLog.detailException(e3);
                        }
                        return false;
                    }
                    j2 = new EmotionGroupData();
                    j2.setBytesLength((int) downloadData.getSize());
                    j2.setBytesReceived((int) downloadData.getLength());
                    j2.setDownloadUrl(downloadData.getUrl());
                    j2.setGroupId(downloadData.getId());
                    j2.setEmotionsCount(g2);
                    j2.setHeight(downloadData.getHeight());
                    j2.setWidth(downloadData.getWidth());
                    j2.setDownloadTime(System.currentTimeMillis());
                    j2.setGroupDesc(downloadData.getDescription());
                    j2.setGroupName(downloadData.getName());
                    j2.setStatus(1);
                    g.k().e(j2);
                }
                g.k().f(downloadData.getStatusMsg(), j2);
                downloadData.setStatusMsg(null);
                try {
                    fileInputStream.close();
                } catch (IOException e4) {
                    BdLog.detailException(e4);
                }
                return true;
            } catch (Exception e5) {
                e = e5;
                fileInputStream2 = fileInputStream;
                BdLog.detailException(e);
                if (fileInputStream2 != null) {
                    try {
                        fileInputStream2.close();
                    } catch (IOException e6) {
                        BdLog.detailException(e6);
                    }
                }
                return false;
            } catch (Throwable th2) {
                th = th2;
                fileInputStream2 = fileInputStream;
                if (fileInputStream2 != null) {
                    try {
                        fileInputStream2.close();
                    } catch (IOException e7) {
                        BdLog.detailException(e7);
                    }
                }
                throw th;
            }
        }
        return invokeL.booleanValue;
    }

    @Override // c.a.q0.w.e
    public void onFileUpdateProgress(DownloadData downloadData) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048579, this, downloadData) == null) || downloadData == null) {
            return;
        }
        f.f().i(downloadData);
    }

    @Override // c.a.q0.w.e
    public boolean onPreDownload(DownloadData downloadData) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048580, this, downloadData)) == null) {
            if (downloadData == null) {
                return false;
            }
            EmotionGroupData j2 = g.k().j(downloadData.getId());
            if (j2 == null || !b.d(downloadData.getId())) {
                return true;
            }
            g.k().f(downloadData.getStatusMsg(), j2);
            downloadData.setStatusMsg(null);
            return false;
        }
        return invokeL.booleanValue;
    }
}
