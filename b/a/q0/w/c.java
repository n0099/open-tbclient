package b.a.q0.w;

import android.app.Application;
import android.app.PendingIntent;
import android.content.Intent;
import android.text.TextUtils;
import androidx.core.view.InputDeviceCompat;
import b.a.e.e.p.k;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.data.AdvertAppInfo;
import com.baidu.tbadk.core.util.FileHelper;
import com.baidu.tbadk.core.util.ListUtils;
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
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
/* loaded from: classes4.dex */
public class c {
    public static /* synthetic */ Interceptable $ic;

    /* renamed from: b  reason: collision with root package name */
    public static c f14179b;

    /* renamed from: c  reason: collision with root package name */
    public static DownloadData f14180c;

    /* renamed from: d  reason: collision with root package name */
    public static List<DownloadData> f14181d;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public b f14182a;

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
        public final /* synthetic */ c f14183a;

        public b(c cVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {cVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f14183a = cVar;
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
                if (k.isEmpty(id) || k.isEmpty(name)) {
                    return downloadData;
                }
                boolean isForceDownload = downloadData.isForceDownload();
                String str = id.replace(".", "_") + ".apk";
                String o = this.f14183a.o(str);
                File GetFile = FileHelper.GetFile(str);
                if (!isForceDownload && GetFile != null) {
                    DownloadData downloadData2 = new DownloadData(id);
                    downloadData2.setName(str);
                    downloadData2.setPath(o);
                    downloadData2.setStatus(3);
                    return downloadData2;
                }
                downloadData.setCallback(new b.a.q0.w.a());
                downloadData.setStatusMsg(TbadkCoreApplication.getCurrentAccount());
                downloadData.setType(12);
                downloadData.setPath(o);
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
                this.f14183a.f14182a = null;
                if (downloadData != null) {
                    if (downloadData.getStatus() == 3) {
                        this.f14183a.w(downloadData);
                        if (downloadData.isNeedInvokeApk()) {
                            Application app = TbadkCoreApplication.getInst().getApp();
                            UtilHelper.install_apk(app, downloadData.getId().replace(".", "_") + ".apk");
                        }
                    } else {
                        f.k().m(downloadData, 5);
                        int l = this.f14183a.l(downloadData.getId(), downloadData.getName());
                        if (downloadData.isNeedNotify() && l <= 0) {
                            String string = TbadkCoreApplication.getInst().getApp().getResources().getString(R.string.download_will_begin);
                            Application app2 = TbadkCoreApplication.getInst().getApp();
                            int notifyId = downloadData.getNotifyId();
                            NotificationHelper.showProgressNotification(app2, notifyId, downloadData.getName() + string, 0, string, downloadData.getName(), this.f14183a.i(downloadData.getAction()), false);
                        } else {
                            this.f14183a.x(downloadData);
                        }
                    }
                    DownloadData unused = c.f14180c = null;
                    if (c.f14181d.isEmpty()) {
                        return;
                    }
                    c.f14181d.remove(0);
                    this.f14183a.C();
                }
            }
        }

        public /* synthetic */ b(c cVar, a aVar) {
            this(cVar);
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(274760217, "Lb/a/q0/w/c;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(274760217, "Lb/a/q0/w/c;");
                return;
            }
        }
        f14181d = new LinkedList();
    }

    public c() {
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
        this.f14182a = null;
    }

    public static c q() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65544, null)) == null) {
            synchronized (c.class) {
                if (f14179b == null) {
                    f14179b = new c();
                }
            }
            return f14179b;
        }
        return (c) invokeV.objValue;
    }

    public void A(String str, String str2, String str3, int i2, int i3, String[] strArr, boolean z, boolean z2, boolean z3) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048576, this, new Object[]{str, str2, str3, Integer.valueOf(i2), Integer.valueOf(i3), strArr, Boolean.valueOf(z), Boolean.valueOf(z2), Boolean.valueOf(z3)}) == null) {
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
            y(downloadData);
        }
    }

    public void B(String str, String str2, String str3, String[] strArr) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str, str2, str3, strArr) == null) {
            A(str, str2, str3, -1, (int) b.a.e.e.m.b.g(str, 0L), null, true, false, true);
        }
    }

    public final void C() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) && f14180c == null) {
            DownloadData downloadData = (DownloadData) ListUtils.getItem(f14181d, 0);
            f14180c = downloadData;
            if (downloadData != null) {
                b bVar = new b(this, null);
                this.f14182a = bVar;
                bVar.setPriority(3);
                this.f14182a.execute(f14180c);
            }
        }
    }

    public void g(String str, String str2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048579, this, str, str2) == null) {
            h(str, str2, false);
        }
    }

    public void h(String str, String str2, boolean z) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLLZ(1048580, this, str, str2, z) == null) || StringUtils.isNull(str)) {
            return;
        }
        DownloadData downloadData = null;
        for (DownloadData downloadData2 : f.k().j()) {
            if (downloadData2.getId() != null && downloadData2.getId().equals(str2)) {
                downloadData = downloadData2;
            }
        }
        if (z) {
            f.k().h(str, true);
        } else {
            f.k().g(str);
        }
        if (downloadData != null) {
            int l = l(downloadData.getId(), downloadData.getName());
            String str3 = l + "%";
            if (downloadData == null || l < 0 || !downloadData.isNeedNotify()) {
                return;
            }
            NotificationHelper.showProgressNotification(TbadkCoreApplication.getInst().getApp(), downloadData.getNotifyId(), downloadData.getName() + TbadkCoreApplication.getInst().getApp().getResources().getString(R.string.download_cancel), l, str3, downloadData.getName() + TbadkCoreApplication.getInst().getApp().getResources().getString(R.string.download_cancel), i(downloadData.getAction()), false);
        }
    }

    public final PendingIntent i(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048581, this, str)) == null) {
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

    public File j(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048582, this, str)) == null) {
            if (TextUtils.isEmpty(str)) {
                return null;
            }
            return FileHelper.GetFile(str.replace(".", "_") + ".apk");
        }
        return (File) invokeL.objValue;
    }

    public float k(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048583, this, str)) == null) {
            for (DownloadData downloadData : f.k().j()) {
                if (downloadData.getId() != null && downloadData.getId().equals(str)) {
                    return ((float) downloadData.getLength()) / ((float) downloadData.getSize());
                }
            }
            return -1.0f;
        }
        return invokeL.floatValue;
    }

    public int l(String str, String str2) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(InputDeviceCompat.SOURCE_TOUCHPAD, this, str, str2)) == null) {
            long p = p(str, str2);
            long j = TbadkCoreApplication.getInst().getSharedPreferences("app_download_progress", 0).getLong(str, 0L);
            if (0 == j) {
                return -1;
            }
            if (p > j) {
                return 0;
            }
            return (int) ((p * 100) / j);
        }
        return invokeLL.intValue;
    }

    public File m(String str, String str2) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048585, this, str, str2)) == null) {
            if (TextUtils.isEmpty(str) || TextUtils.isEmpty(str2)) {
                return null;
            }
            return FileHelper.GetFileInCache(str + "_" + str2 + ".tmp");
        }
        return (File) invokeLL.objValue;
    }

    public String n(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048586, this, str)) == null) {
            if (str == null || str.length() == 0) {
                return null;
            }
            if (str.contains("?")) {
                str = str.substring(0, str.indexOf("?"));
            }
            String[] split = str.split("/");
            return split[split.length - 1];
        }
        return (String) invokeL.objValue;
    }

    public final String o(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048587, this, str)) == null) {
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

    public long p(String str, String str2) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048588, this, str, str2)) == null) {
            File GetFileInCache = FileHelper.GetFileInCache(str + "_" + str2 + ".tmp");
            if (GetFileInCache != null && GetFileInCache.exists() && GetFileInCache.isFile()) {
                return GetFileInCache.length();
            }
            return -1L;
        }
        return invokeLL.longValue;
    }

    public boolean r(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048589, this, str)) == null) {
            for (DownloadData downloadData : f.k().j()) {
                if (downloadData.getId() != null && downloadData.getId().equals(str) && downloadData.getStatus() == 5) {
                    return true;
                }
            }
            return false;
        }
        return invokeL.booleanValue;
    }

    public boolean s(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048590, this, str)) == null) {
            if (TextUtils.isEmpty(str)) {
                return false;
            }
            StringBuilder sb = new StringBuilder();
            sb.append(str.replace(".", "_"));
            sb.append(".apk");
            return FileHelper.GetFile(sb.toString()) != null;
        }
        return invokeL.booleanValue;
    }

    public boolean t(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048591, this, str)) == null) {
            for (DownloadData downloadData : f.k().j()) {
                if (downloadData.getId() != null && downloadData.getId().equals(str) && downloadData.getStatus() == 1) {
                    return true;
                }
            }
            return false;
        }
        return invokeL.booleanValue;
    }

    public void u(ArrayList<AdvertAppInfo> arrayList) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048592, this, arrayList) == null) {
            try {
                new C0711c(this, null).execute(arrayList);
            } catch (Exception unused) {
            }
        }
    }

    public void v(List<DownloadData> list) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048593, this, list) == null) {
            MessageManager.getInstance().dispatchResponsedMessageToUI(new DownloadMessage(list));
        }
    }

    public void w(DownloadData downloadData) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048594, this, downloadData) == null) {
            LinkedList linkedList = new LinkedList();
            linkedList.add(downloadData);
            b.a.q0.f1.l.a.c().f(linkedList);
            MessageManager.getInstance().dispatchResponsedMessageToUI(new DownloadMessage(linkedList));
        }
    }

    public void x(DownloadData downloadData) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048595, this, downloadData) == null) && downloadData != null && downloadData.isNeedNotify()) {
            int l = l(downloadData.getId(), downloadData.getName());
            NotificationHelper.showProgressNotification(TbadkCoreApplication.getInst().getApp(), downloadData.getNotifyId(), null, l, l + "%", downloadData.getName(), i(downloadData.getAction()), false);
        }
    }

    public void y(DownloadData downloadData) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048596, this, downloadData) == null) || downloadData == null) {
            return;
        }
        List<DownloadData> j = f.k().j();
        if (j != null && j.size() >= 5) {
            downloadData.setStatus(2);
            downloadData.setStatusMsg(TbadkCoreApplication.getInst().getApp().getString(R.string.download_fail_over_max));
            w(downloadData);
            UtilHelper.showToast(TbadkCoreApplication.getInst(), R.string.download_fail_over_max);
            return;
        }
        f14181d.add(downloadData);
        C();
    }

    public void z(String str, String str2, String str3, int i2, int i3) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048597, this, new Object[]{str, str2, str3, Integer.valueOf(i2), Integer.valueOf(i3)}) == null) {
            A(str, str2, str3, i2, i3, null, true, false, true);
        }
    }

    /* renamed from: b.a.q0.w.c$c  reason: collision with other inner class name */
    /* loaded from: classes4.dex */
    public class C0711c extends BdAsyncTask<ArrayList<AdvertAppInfo>, List<DownloadData>, List<DownloadData>> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public ArrayList<AdvertAppInfo> f14184a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ c f14185b;

        public C0711c(c cVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {cVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f14185b = cVar;
            this.f14184a = null;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: b */
        public List<DownloadData> doInBackground(ArrayList<AdvertAppInfo>... arrayListArr) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, arrayListArr)) == null) {
                ArrayList<AdvertAppInfo> arrayList = arrayListArr[0];
                LinkedList linkedList = new LinkedList();
                if (arrayList == null) {
                    return linkedList;
                }
                this.f14184a = arrayList;
                Iterator<AdvertAppInfo> it = arrayList.iterator();
                while (it.hasNext()) {
                    AdvertAppInfo next = it.next();
                    String downloadId = next.getDownloadId();
                    if (FileHelper.GetFile(this.f14185b.n(next.o4)) != null) {
                        DownloadData downloadData = new DownloadData(downloadId);
                        downloadData.setStatus(3);
                        linkedList.add(downloadData);
                    }
                }
                return linkedList;
            }
            return (List) invokeL.objValue;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: c */
        public void onPostExecute(List<DownloadData> list) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, list) == null) {
                super.onPostExecute(list);
                if (list == null) {
                    list = new LinkedList<>();
                }
                for (DownloadData downloadData : f.k().j()) {
                    Iterator<AdvertAppInfo> it = this.f14184a.iterator();
                    while (it.hasNext()) {
                        if (TextUtils.equals(it.next().getDownloadId(), downloadData.getId())) {
                            list.add(downloadData);
                        }
                    }
                }
                this.f14185b.v(list);
                this.f14184a = null;
            }
        }

        public /* synthetic */ C0711c(c cVar, a aVar) {
            this(cVar);
        }
    }
}
