package c.a.r0.z2.f0;

import android.app.Application;
import android.app.PendingIntent;
import android.content.Intent;
import android.text.TextUtils;
import androidx.core.view.InputDeviceCompat;
import c.a.r0.z2.z;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.NotificationHelper;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tbadk.download.DownloadData;
import com.baidu.tbadk.download.DownloadMessage;
import com.baidu.tieba.R;
import com.baidu.tieba.ad.download.state.StopStatus;
import com.baidu.tieba.recapp.report.DownloadStaticsData;
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
/* loaded from: classes4.dex */
public class k {
    public static /* synthetic */ Interceptable $ic;

    /* renamed from: c  reason: collision with root package name */
    public static k f29591c;

    /* renamed from: d  reason: collision with root package name */
    public static DownloadData f29592d;

    /* renamed from: e  reason: collision with root package name */
    public static List<DownloadData> f29593e;

    /* renamed from: f  reason: collision with root package name */
    public static HashMap<String, Integer> f29594f;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public b f29595a;

    /* renamed from: b  reason: collision with root package name */
    public HashMap<String, m> f29596b;

    /* loaded from: classes4.dex */
    public static /* synthetic */ class a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
    }

    /* loaded from: classes4.dex */
    public class b extends BdAsyncTask<DownloadData, DownloadData, DownloadData> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ k f29597a;

        public b(k kVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {kVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f29597a = kVar;
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
                if (c.a.e.e.p.k.isEmpty(id) || c.a.e.e.p.k.isEmpty(name)) {
                    return downloadData;
                }
                boolean isForceDownload = downloadData.isForceDownload();
                String f2 = c.a.r0.z2.b.f(id);
                String h2 = c.a.r0.z2.b.h(id);
                File e2 = c.a.r0.z2.b.e(f2);
                if (!isForceDownload && e2 != null) {
                    DownloadData downloadData2 = new DownloadData(id);
                    downloadData2.setName(f2);
                    downloadData2.setPath(h2);
                    downloadData2.setStatus(3);
                    return downloadData2;
                }
                downloadData.setCallback(new l());
                downloadData.setStatusMsg(TbadkCoreApplication.getCurrentAccount());
                downloadData.setType(12);
                downloadData.setPath(h2);
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
                this.f29597a.f29595a = null;
                if (downloadData != null) {
                    if (downloadData.getStatus() == 3) {
                        String a2 = c.a.r0.r.e.a.a(TbadkCoreApplication.getInst(), downloadData.getPath());
                        c.a.r0.r.e.i.a.f24325a.get().c().onSuccess(downloadData.getId(), downloadData.getPath());
                        this.f29597a.r(downloadData);
                        if (downloadData.isNeedInvokeApk() && !c.a.r0.r.e.a.b(TbadkCoreApplication.getInst(), a2) && !z.b(c.a.r0.z2.b.h(downloadData.getId()))) {
                            c.a.r0.z2.b.c(new File(c.a.r0.z2.b.h(downloadData.getId())));
                        }
                    } else {
                        c.a.r0.r.e.i.a.f24325a.get().c().c(downloadData.getId());
                        c.a.r0.z2.f0.a.j().l(downloadData, 5);
                        if (this.f29597a.j(downloadData.getId(), downloadData.getName()) <= 0) {
                            if (downloadData.getDownloadStaticsData() != null) {
                                downloadData.getDownloadStaticsData().setDa_range("0");
                            }
                            if (downloadData.isNeedNotify()) {
                                String string = TbadkCoreApplication.getInst().getApp().getResources().getString(R.string.download_will_begin);
                                m mVar = new m(downloadData, 0);
                                this.f29597a.f29596b.put(downloadData.getUrl(), mVar);
                                Application app = TbadkCoreApplication.getInst().getApp();
                                int notifyId = downloadData.getNotifyId();
                                NotificationHelper.showProgressNotification(app, notifyId, downloadData.getUser_name() + string, 0, string, downloadData.getUser_name(), this.f29597a.h(downloadData.getAction()), false, mVar.b(), false);
                            }
                        } else {
                            if (downloadData.getDownloadStaticsData() != null) {
                                downloadData.getDownloadStaticsData().setDa_range("1");
                            }
                            this.f29597a.v(downloadData);
                        }
                    }
                    DownloadData unused = k.f29592d = null;
                    if (c.a.r0.q1.o.k.a.e(k.f29593e)) {
                        return;
                    }
                    c.a.r0.q1.o.k.a.i(k.f29593e, 0);
                    this.f29597a.y();
                }
            }
        }

        public /* synthetic */ b(k kVar, a aVar) {
            this(kVar);
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(2021565641, "Lc/a/r0/z2/f0/k;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(2021565641, "Lc/a/r0/z2/f0/k;");
                return;
            }
        }
        f29593e = new LinkedList();
        f29594f = new HashMap<>();
    }

    public k() {
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
        this.f29595a = null;
        this.f29596b = new HashMap<>();
    }

    public static k l() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65544, null)) == null) {
            synchronized (k.class) {
                if (f29591c == null) {
                    f29591c = new k();
                }
            }
            return f29591c;
        }
        return (k) invokeV.objValue;
    }

    public static Integer m(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65545, null, str)) == null) {
            if (f29594f.containsKey(str)) {
                return f29594f.get(str);
            }
            Integer valueOf = Integer.valueOf(BdUniqueId.gen().getId());
            f29594f.put(str, valueOf);
            return valueOf;
        }
        return (Integer) invokeL.objValue;
    }

    public static int n(DownloadData downloadData) {
        InterceptResult invokeL;
        int i2;
        String id;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65546, null, downloadData)) == null) {
            if (c.a.r0.z2.b.j(downloadData.getId())) {
                i2 = 3;
            } else if (l().o(downloadData.getId())) {
                i2 = 5;
            } else if (l().p(downloadData.getId())) {
                i2 = 1;
            } else {
                i2 = c.a.r0.z2.b.k(downloadData.getId(), downloadData.getName()) ? 7 : 6;
            }
            DownloadStaticsData downloadStaticsData = downloadData.getDownloadStaticsData();
            if (downloadStaticsData != null) {
                id = downloadStaticsData.getApk_name();
            } else {
                id = downloadData.getId();
            }
            if (!TextUtils.isEmpty(id) && c.a.r0.a.h().z() && z.q(id)) {
                return 8;
            }
            return i2;
        }
        return invokeL.intValue;
    }

    public void g(String str, String str2, boolean z) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLLZ(1048576, this, str, str2, z) == null) || StringUtils.isNull(str)) {
            return;
        }
        DownloadData downloadData = null;
        for (DownloadData downloadData2 : c.a.r0.z2.f0.a.j().i()) {
            if (downloadData2.getId() != null && downloadData2.getId().equals(str2)) {
                downloadData = downloadData2;
            }
        }
        if (z) {
            c.a.r0.z2.f0.a.j().g(str, true);
        } else {
            c.a.r0.z2.f0.a.j().f(str);
        }
        if (downloadData != null) {
            int j2 = j(downloadData.getId(), downloadData.getName());
            c.a.r0.r.e.i.a.f24325a.get().c().a(str2, j2);
            String str3 = j2 + "%";
            if (downloadData == null || j2 < 0) {
                return;
            }
            m mVar = this.f29596b.get(downloadData.getUrl());
            if (mVar == null) {
                mVar = new m(downloadData, j2);
            }
            mVar.d();
            NotificationHelper.showProgressNotification(TbadkCoreApplication.getInst().getApp(), downloadData.getNotifyId(), null, 0, str3, downloadData.getUser_name(), h(downloadData.getAction()), false, mVar.b(), false);
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

    public void i(DownloadData downloadData) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, downloadData) == null) {
            c.a.r0.z2.f0.a.j().h(downloadData);
            NotificationHelper.cancelNotification(TbadkCoreApplication.getInst().getApp(), downloadData.getNotifyId());
            c.a.r0.r.e.i.a.f24325a.get().c().b(downloadData.getId(), StopStatus.DOWNLOAD_UNSTART);
            r(downloadData);
        }
    }

    public int j(String str, String str2) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048579, this, str, str2)) == null) {
            long k = k(str, str2);
            long j2 = TbadkCoreApplication.getInst().getSharedPreferences("app_download_progress", 0).getLong(str, 0L);
            if (0 == j2) {
                return -1;
            }
            if (k > j2) {
                return 0;
            }
            return (int) ((k * 100) / j2);
        }
        return invokeLL.intValue;
    }

    public long k(String str, String str2) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048580, this, str, str2)) == null) {
            File e2 = c.a.r0.z2.b.e(c.a.r0.z2.b.i(str, str2));
            if (e2 != null && e2.exists() && e2.isFile()) {
                return e2.length();
            }
            return -1L;
        }
        return invokeLL.longValue;
    }

    public boolean o(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048581, this, str)) == null) {
            for (DownloadData downloadData : c.a.r0.z2.f0.a.j().i()) {
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
            for (DownloadData downloadData : c.a.r0.z2.f0.a.j().i()) {
                if (downloadData.getId() != null && downloadData.getId().equals(str) && downloadData.getStatus() == 1) {
                    return true;
                }
            }
            return false;
        }
        return invokeL.booleanValue;
    }

    public void q(DownloadData downloadData) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048583, this, downloadData) == null) || downloadData == null) {
            return;
        }
        s(downloadData);
        c.a.r0.r.e.i.a.f24325a.get().c().b(downloadData.getId(), StopStatus.DOWNLOAD_FAIL);
        m mVar = this.f29596b.get(downloadData.getUrl());
        if (mVar != null) {
            NotificationHelper.showProgressNotification(TbadkCoreApplication.getInst().getApp(), downloadData.getNotifyId(), null, 0, j(downloadData.getId(), downloadData.getName()) + "%", downloadData.getUser_name(), h(downloadData.getAction()), false, mVar.b(), false);
        }
    }

    public void r(DownloadData downloadData) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, downloadData) == null) {
            LinkedList linkedList = new LinkedList();
            linkedList.add(downloadData);
            MessageManager.getInstance().dispatchResponsedMessageToUI(new DownloadMessage(linkedList));
        }
    }

    public void s(DownloadData downloadData) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048585, this, downloadData) == null) || downloadData == null) {
            return;
        }
        m mVar = this.f29596b.get(downloadData.getUrl());
        int j2 = j(downloadData.getId(), downloadData.getName());
        if (mVar == null) {
            mVar = new m(downloadData, j2);
        }
        mVar.d();
    }

    public void t(DownloadData downloadData) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048586, this, downloadData) == null) || downloadData == null) {
            return;
        }
        m mVar = this.f29596b.get(downloadData.getUrl());
        int j2 = j(downloadData.getId(), downloadData.getName());
        if (mVar == null) {
            mVar = new m(downloadData, j2);
        }
        mVar.e();
        NotificationHelper.showProgressNotification(TbadkCoreApplication.getInst().getApp(), downloadData.getNotifyId(), null, 0, j(downloadData.getId(), downloadData.getName()) + "%", downloadData.getUser_name(), h(downloadData.getAction()), false, mVar.b(), false);
    }

    public void u(DownloadData downloadData) {
        String string;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048587, this, downloadData) == null) || downloadData == null) {
            return;
        }
        int errorCode = downloadData.getErrorCode();
        if (errorCode == 1) {
            string = TbadkCoreApplication.getInst().getString(R.string.download_fail_tip_sdcrad);
        } else if (errorCode != 3) {
            string = TbadkCoreApplication.getInst().getString(R.string.download_fail_tip);
        } else {
            string = TbadkCoreApplication.getInst().getString(R.string.download_fail_tip_net);
        }
        String str = string;
        if (downloadData.isNeedNotify()) {
            int process = downloadData.getProcess();
            Application app = TbadkCoreApplication.getInst().getApp();
            int notifyId = downloadData.getNotifyId();
            NotificationHelper.showProgressNotification(app, notifyId, downloadData.getUser_name() + TbadkCoreApplication.getInst().getApp().getResources().getString(R.string.download_fail_tip), process, process + "%", str, h(downloadData.getAction()), false);
        }
    }

    public void v(DownloadData downloadData) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048588, this, downloadData) == null) && downloadData != null && downloadData.isNeedNotify()) {
            int j2 = j(downloadData.getId(), downloadData.getName());
            c.a.r0.r.e.i.a.f24325a.get().c().d(downloadData.getId(), j2);
            String str = j2 + "%";
            m mVar = this.f29596b.get(downloadData.getUrl());
            if (mVar == null) {
                mVar = new m(downloadData, j2);
            }
            int n = n(downloadData);
            if (n == 1) {
                mVar.e();
            } else if (n == 4 || n == 2 || n == 7) {
                mVar.d();
            } else if (n == 6) {
                NotificationHelper.cancelNotification(TbadkCoreApplication.getInst().getApp(), downloadData.getNotifyId());
                return;
            }
            mVar.c(j2);
            NotificationHelper.showProgressNotification(TbadkCoreApplication.getInst().getApp(), downloadData.getNotifyId(), null, 0, str, downloadData.getUser_name(), h(downloadData.getAction()), false, mVar.b(), false);
        }
    }

    public void w(DownloadData downloadData) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048589, this, downloadData) == null) || downloadData == null) {
            return;
        }
        List<DownloadData> i2 = c.a.r0.z2.f0.a.j().i();
        if (i2 != null && i2.size() >= 5) {
            downloadData.setStatus(2);
            downloadData.setStatusMsg(TbadkCoreApplication.getInst().getApp().getString(R.string.download_fail_over_max));
            r(downloadData);
            UtilHelper.showToast(TbadkCoreApplication.getInst(), R.string.download_fail_over_max);
            return;
        }
        c.a.r0.q1.o.k.a.a(f29593e, downloadData);
        y();
    }

    public void x(String str, String str2, String str3, int i2, int i3, String[] strArr, boolean z, boolean z2, boolean z3, String str4, DownloadStaticsData downloadStaticsData, String str5) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048590, this, new Object[]{str, str2, str3, Integer.valueOf(i2), Integer.valueOf(i3), strArr, Boolean.valueOf(z), Boolean.valueOf(z2), Boolean.valueOf(z3), str4, downloadStaticsData, str5}) == null) {
            DownloadData downloadData = new DownloadData(str);
            downloadData.setType(12);
            downloadData.setId(str);
            downloadData.setUrl(str2);
            downloadData.setName(str3);
            downloadData.setTag(strArr);
            downloadData.setPosition(i2);
            downloadData.setNotifyId(i3);
            downloadData.setNeedInvokeApk(z);
            downloadData.setForceDownload(z2);
            downloadData.setNeedNotify(z3);
            downloadData.setApp_icon(str4);
            downloadData.setDownloadStaticsData(downloadStaticsData);
            downloadData.setUser_name(str5);
            w(downloadData);
        }
    }

    public final void y() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048591, this) == null) && f29592d == null && !c.a.r0.q1.o.k.a.e(f29593e)) {
            DownloadData downloadData = (DownloadData) c.a.r0.q1.o.k.a.d(f29593e, 0);
            f29592d = downloadData;
            if (downloadData != null) {
                b bVar = new b(this, null);
                this.f29595a = bVar;
                bVar.setPriority(3);
                this.f29595a.execute(f29592d);
            }
        }
    }
}
