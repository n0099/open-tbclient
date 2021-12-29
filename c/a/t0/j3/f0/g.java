package c.a.t0.j3.f0;

import android.app.Application;
import android.app.PendingIntent;
import android.content.Intent;
import android.text.TextUtils;
import androidx.core.view.InputDeviceCompat;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.nps.utils.Constant;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.FileHelper;
import com.baidu.tbadk.core.util.NotificationHelper;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tbadk.download.DownloadData;
import com.baidu.tbadk.download.DownloadMessage;
import com.baidu.tieba.R;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.io.File;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
/* loaded from: classes7.dex */
public class g {
    public static /* synthetic */ Interceptable $ic;

    /* renamed from: c  reason: collision with root package name */
    public static g f18779c;

    /* renamed from: d  reason: collision with root package name */
    public static DownloadData f18780d;

    /* renamed from: e  reason: collision with root package name */
    public static List<DownloadData> f18781e;

    /* renamed from: f  reason: collision with root package name */
    public static HashMap<String, Integer> f18782f;
    public transient /* synthetic */ FieldHolder $fh;
    public b a;

    /* renamed from: b  reason: collision with root package name */
    public HashMap<String, i> f18783b;

    /* loaded from: classes7.dex */
    public static /* synthetic */ class a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
    }

    /* loaded from: classes7.dex */
    public class b extends BdAsyncTask<DownloadData, DownloadData, DownloadData> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ g a;

        public b(g gVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {gVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = gVar;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: b */
        public DownloadData doInBackground(DownloadData... downloadDataArr) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, downloadDataArr)) == null) {
                DownloadData downloadData = downloadDataArr[0];
                if (downloadData == null) {
                    return downloadData;
                }
                String id = downloadData.getId();
                String name = downloadData.getName();
                if (c.a.d.f.p.m.isEmpty(id) || c.a.d.f.p.m.isEmpty(name)) {
                    return downloadData;
                }
                boolean isForceDownload = downloadData.isForceDownload();
                String str = id.replace(".", "_") + Constant.FILE.SUFFIX.BUNDLE_SUFFIX;
                String j2 = g.j(str);
                File GetFile = FileHelper.GetFile(str);
                if (!isForceDownload && GetFile != null) {
                    DownloadData downloadData2 = new DownloadData(id);
                    downloadData2.setName(str);
                    downloadData2.setPath(j2);
                    downloadData2.setStatus(3);
                    return downloadData2;
                }
                downloadData.setCallback(new c.a.s0.w.a());
                downloadData.setStatusMsg(TbadkCoreApplication.getCurrentAccount());
                downloadData.setType(12);
                downloadData.setPath(j2);
                return downloadData;
            }
            return (DownloadData) invokeL.objValue;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: c */
        public void onPostExecute(DownloadData downloadData) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, downloadData) == null) {
                super.onPostExecute(downloadData);
                this.a.a = null;
                if (downloadData != null) {
                    if (downloadData.getStatus() == 3) {
                        this.a.r(downloadData);
                        if (downloadData.isNeedInvokeApk()) {
                            Application app = TbadkCoreApplication.getInst().getApp();
                            UtilHelper.install_apk(app, downloadData.getId().replace(".", "_") + Constant.FILE.SUFFIX.BUNDLE_SUFFIX);
                        }
                    } else {
                        f.f().h(downloadData);
                        if (this.a.i(downloadData.getId(), downloadData.getName()) <= 0) {
                            if (downloadData.getDownloadStaticsData() != null) {
                                downloadData.getDownloadStaticsData().setDa_range("0");
                            }
                            if (downloadData.isNeedNotify()) {
                                String string = TbadkCoreApplication.getInst().getApp().getResources().getString(R.string.download_will_begin);
                                i iVar = new i(downloadData, 0);
                                this.a.f18783b.put(downloadData.getUrl(), iVar);
                                Application app2 = TbadkCoreApplication.getInst().getApp();
                                int notifyId = downloadData.getNotifyId();
                                NotificationHelper.showProgressNotification(app2, notifyId, downloadData.getUser_name() + string, 0, string, downloadData.getUser_name(), this.a.h(downloadData.getAction()), false, iVar.b(), false);
                            }
                        } else if (downloadData.getDownloadStaticsData() != null) {
                            downloadData.getDownloadStaticsData().setDa_range("1");
                        }
                    }
                    DownloadData unused = g.f18780d = null;
                    if (g.f18781e.isEmpty()) {
                        return;
                    }
                    g.f18781e.remove(0);
                    this.a.t();
                }
            }
        }

        public /* synthetic */ b(g gVar, a aVar) {
            this(gVar);
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1494972192, "Lc/a/t0/j3/f0/g;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1494972192, "Lc/a/t0/j3/f0/g;");
                return;
            }
        }
        f18781e = new LinkedList();
        f18782f = new HashMap<>();
    }

    public g() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.a = null;
        this.f18783b = new HashMap<>();
    }

    public static String j(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65544, null, str)) == null) {
            StringBuilder sb = new StringBuilder();
            sb.append(FileHelper.getCacheDir());
            File file = new File(sb.toString());
            if (!file.exists()) {
                file.mkdirs();
            }
            sb.append("/");
            sb.append(str);
            return sb.toString();
        }
        return (String) invokeL.objValue;
    }

    public static g l() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65545, null)) == null) {
            synchronized (g.class) {
                if (f18779c == null) {
                    f18779c = new g();
                }
            }
            return f18779c;
        }
        return (g) invokeV.objValue;
    }

    public static Integer m(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65546, null, str)) == null) {
            if (f18782f.containsKey(str)) {
                return f18782f.get(str);
            }
            Integer valueOf = Integer.valueOf(BdUniqueId.gen().getId());
            f18782f.put(str, valueOf);
            return valueOf;
        }
        return (Integer) invokeL.objValue;
    }

    public void g(String str, String str2) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(1048576, this, str, str2) == null) || StringUtils.isNull(str)) {
            return;
        }
        DownloadData downloadData = null;
        for (DownloadData downloadData2 : f.f().e()) {
            if (downloadData2.getId() != null && downloadData2.getId().equals(str2)) {
                downloadData = downloadData2;
            }
        }
        f.f().d(str);
        if (downloadData != null) {
            int i2 = i(downloadData.getId(), downloadData.getName());
            String str3 = i2 + "%";
            if (downloadData == null || i2 < 0) {
                return;
            }
            i iVar = this.f18783b.get(downloadData.getUrl());
            if (iVar == null) {
                iVar = new i(downloadData, i2);
            }
            iVar.d();
            NotificationHelper.showProgressNotification(TbadkCoreApplication.getInst().getApp(), downloadData.getNotifyId(), null, 0, str3, downloadData.getUser_name(), h(downloadData.getAction()), false, iVar.b(), false);
        }
    }

    public final PendingIntent h(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str)) == null) {
            if (TextUtils.isEmpty(str)) {
                return null;
            }
            Intent intent = new Intent(str);
            intent.addCategory("android.intent.category.DEFAULT");
            intent.setFlags(268435456);
            return PendingIntent.getActivity(TbadkCoreApplication.getInst(), 0, intent, 0);
        }
        return (PendingIntent) invokeL.objValue;
    }

    public int i(String str, String str2) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(Constants.METHOD_SEND_USER_MSG, this, str, str2)) == null) {
            long k2 = k(str, str2);
            long j2 = TbadkCoreApplication.getInst().getSharedPreferences("app_download_progress", 0).getLong(str, 0L);
            if (0 == j2) {
                return -1;
            }
            if (k2 > j2) {
                return 0;
            }
            return (int) ((k2 * 100) / j2);
        }
        return invokeLL.intValue;
    }

    public long k(String str, String str2) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048579, this, str, str2)) == null) {
            String str3 = str + "_" + str2 + ".tmp";
            File GetFile = FileHelper.GetFile(str3);
            if (GetFile == null) {
                GetFile = FileHelper.GetFileInCache(str3);
            }
            if (GetFile != null && GetFile.exists() && GetFile.isFile()) {
                return GetFile.length();
            }
            return -1L;
        }
        return invokeLL.longValue;
    }

    public boolean n(String str, String str2) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048580, this, str, str2)) == null) {
            if (TbadkCoreApplication.getInst().getSharedPreferences("app_download_progress", 0).getLong(str, 0L) == 0) {
                return false;
            }
            String str3 = str + "_" + str2 + ".tmp";
            File GetFile = FileHelper.GetFile(str3);
            if (GetFile == null) {
                GetFile = FileHelper.GetFileInCache(str3);
            }
            return GetFile != null && GetFile.exists() && GetFile.isFile();
        }
        return invokeLL.booleanValue;
    }

    public boolean o(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048581, this, str)) == null) {
            for (DownloadData downloadData : f.f().e()) {
                if (downloadData.getId() != null && downloadData.getId().equals(str) && downloadData.getStatus() == 5) {
                    return true;
                }
            }
            return false;
        }
        return invokeL.booleanValue;
    }

    public boolean p(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048582, this, str)) == null) {
            if (TextUtils.isEmpty(str)) {
                return false;
            }
            StringBuilder sb = new StringBuilder();
            sb.append(str.replace(".", "_"));
            sb.append(Constant.FILE.SUFFIX.BUNDLE_SUFFIX);
            return FileHelper.GetFile(sb.toString()) != null;
        }
        return invokeL.booleanValue;
    }

    public boolean q(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048583, this, str)) == null) {
            for (DownloadData downloadData : f.f().e()) {
                if (downloadData.getId() != null && downloadData.getId().equals(str) && downloadData.getStatus() == 1) {
                    return true;
                }
            }
            return false;
        }
        return invokeL.booleanValue;
    }

    public void r(DownloadData downloadData) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, downloadData) == null) {
            LinkedList linkedList = new LinkedList();
            linkedList.add(downloadData);
            MessageManager.getInstance().dispatchResponsedMessageToUI(new DownloadMessage(linkedList));
        }
    }

    public boolean s(DownloadData downloadData) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048585, this, downloadData)) == null) {
            if (downloadData == null) {
                return false;
            }
            List<DownloadData> e2 = f.f().e();
            if (e2 != null && e2.size() >= 5) {
                downloadData.setStatus(2);
                downloadData.setStatusMsg(TbadkCoreApplication.getInst().getApp().getString(R.string.download_fail_over_max));
                r(downloadData);
                UtilHelper.showToast(TbadkCoreApplication.getInst(), R.string.download_fail_over_max);
                return false;
            }
            f18781e.add(downloadData);
            t();
            return true;
        }
        return invokeL.booleanValue;
    }

    public final void t() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048586, this) == null) && f18780d == null && !f18781e.isEmpty()) {
            DownloadData downloadData = f18781e.get(0);
            f18780d = downloadData;
            if (downloadData != null) {
                b bVar = new b(this, null);
                this.a = bVar;
                bVar.setPriority(3);
                this.a.execute(f18780d);
            }
        }
    }
}
