package b.a.q0.w;

import android.content.SharedPreferences;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.swan.apps.core.prefetch.PrefetchEvent;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.NotificationHelper;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tbadk.download.DownloadData;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes4.dex */
public class a implements e {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public a() {
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

    @Override // b.a.q0.w.e
    public void onFileDownloadFailed(DownloadData downloadData, int i2, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLIL(1048576, this, downloadData, i2, str) == null) {
            b.a.r0.a3.f0.e n = b.a.r0.a3.f0.e.n();
            if (i2 == 3) {
                n.v(downloadData);
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2016484, downloadData));
            } else {
                n.B(downloadData);
            }
            b.a(downloadData);
            b.a.r0.a3.f0.e.n().y(downloadData);
        }
    }

    @Override // b.a.q0.w.e
    public void onFileDownloadSucceed(DownloadData downloadData) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, downloadData) == null) || downloadData == null) {
            return;
        }
        String[] tag = downloadData.getTag();
        if (tag != null && tag.length == 3) {
            String str = tag[0];
            String str2 = tag[1];
            TiebaStatic.eventStat(TbadkCoreApplication.getInst().getApp(), "dl_game_success", PrefetchEvent.STATE_CLICK, 1, "dev_id", downloadData.getId(), "ref_id", str, "is_detail", tag[2], "ref_type", str2);
        }
        b.c(downloadData);
        NotificationHelper.cancelNotification(TbadkCoreApplication.getInst().getApp(), downloadData.getNotifyId());
        b.a.r0.a3.f0.e.n().y(downloadData);
        if (downloadData.isNeedInvokeApk()) {
            UtilHelper.install_apk(TbadkCoreApplication.getInst().getApp(), downloadData.getId().replace(".", "_") + ".apk");
        }
    }

    @Override // b.a.q0.w.e
    public boolean onFileDownloaded(DownloadData downloadData) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, downloadData)) == null) {
            if (downloadData == null) {
                return false;
            }
            downloadData.setStatusMsg(null);
            return true;
        }
        return invokeL.booleanValue;
    }

    @Override // b.a.q0.w.e
    public void onFileUpdateProgress(DownloadData downloadData) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048579, this, downloadData) == null) || downloadData == null) {
            return;
        }
        SharedPreferences sharedPreferences = TbadkCoreApplication.getInst().getSharedPreferences("app_download_progress", 0);
        long j = sharedPreferences.getLong(downloadData.getId(), 0L);
        if (j <= 1 || (downloadData.getSize() > 1 && j != downloadData.getSize())) {
            SharedPreferences.Editor edit = sharedPreferences.edit();
            edit.putLong(downloadData.getId(), downloadData.getSize());
            edit.commit();
        }
        b.a.r0.a3.f0.e.n().C(downloadData);
        b.a.r0.a3.f0.e.n().y(downloadData);
    }

    @Override // b.a.q0.w.e
    public boolean onPreDownload(DownloadData downloadData) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048580, this, downloadData)) == null) {
            if (downloadData == null) {
                return false;
            }
            downloadData.setStatusMsg(null);
            return true;
        }
        return invokeL.booleanValue;
    }
}
