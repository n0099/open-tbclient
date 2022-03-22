package c.a.p0.l3.g0;

import android.text.TextUtils;
import androidx.core.view.InputDeviceCompat;
import c.a.p0.l3.a0;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.TbadkCoreApplication;
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
/* loaded from: classes2.dex */
public class k {
    public static /* synthetic */ Interceptable $ic;

    /* renamed from: c  reason: collision with root package name */
    public static k f16169c;

    /* renamed from: d  reason: collision with root package name */
    public static DownloadData f16170d;

    /* renamed from: e  reason: collision with root package name */
    public static List<DownloadData> f16171e;

    /* renamed from: f  reason: collision with root package name */
    public static HashMap<String, Integer> f16172f;
    public transient /* synthetic */ FieldHolder $fh;
    public b a;

    /* renamed from: b  reason: collision with root package name */
    public HashMap<String, m> f16173b;

    /* loaded from: classes2.dex */
    public static /* synthetic */ class a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
    }

    /* loaded from: classes2.dex */
    public class b extends BdAsyncTask<DownloadData, DownloadData, DownloadData> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ k a;

        public b(k kVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {kVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = kVar;
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
                String f2 = c.a.p0.l3.b.f(id);
                String h2 = c.a.p0.l3.b.h(id);
                File e2 = c.a.p0.l3.b.e(f2);
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
                this.a.a = null;
                if (downloadData != null) {
                    if (downloadData.getStatus() == 3) {
                        String a = c.a.p0.x.g.a.a(TbadkCoreApplication.getInst(), downloadData.getPath());
                        c.a.p0.x.g.i.a.a.get().c().onSuccess(downloadData.getId(), downloadData.getPath());
                        this.a.p(downloadData);
                        if (downloadData.isNeedInvokeApk() && !c.a.p0.x.g.a.b(TbadkCoreApplication.getInst(), a) && !a0.b(c.a.p0.l3.b.h(downloadData.getId()))) {
                            c.a.p0.l3.b.c(new File(c.a.p0.l3.b.h(downloadData.getId())));
                        }
                    } else {
                        c.a.p0.x.g.i.a.a.get().c().c(downloadData.getId());
                        c.a.p0.l3.g0.a.j().l(downloadData, 5);
                        if (this.a.h(downloadData.getId(), downloadData.getName()) <= 0) {
                            if (downloadData.getDownloadStaticsData() != null) {
                                downloadData.getDownloadStaticsData().setDa_range("0");
                            }
                            if (downloadData.isNeedNotify()) {
                                TbadkCoreApplication.getInst().getApp().getResources().getString(R.string.obfuscated_res_0x7f0f04f9);
                                this.a.f16173b.put(downloadData.getUrl(), new m(downloadData, 0));
                            }
                        } else {
                            if (downloadData.getDownloadStaticsData() != null) {
                                downloadData.getDownloadStaticsData().setDa_range("1");
                            }
                            this.a.t(downloadData);
                        }
                    }
                    DownloadData unused = k.f16170d = null;
                    if (c.a.p0.b2.o.k.a.e(k.f16171e)) {
                        return;
                    }
                    c.a.p0.b2.o.k.a.i(k.f16171e, 0);
                    this.a.w();
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
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-715579945, "Lc/a/p0/l3/g0/k;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-715579945, "Lc/a/p0/l3/g0/k;");
                return;
            }
        }
        f16171e = new LinkedList();
        f16172f = new HashMap<>();
    }

    public k() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65537, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.a = null;
        this.f16173b = new HashMap<>();
    }

    public static k j() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65543, null)) == null) {
            synchronized (k.class) {
                if (f16169c == null) {
                    f16169c = new k();
                }
            }
            return f16169c;
        }
        return (k) invokeV.objValue;
    }

    public static Integer k(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65544, null, str)) == null) {
            if (f16172f.containsKey(str)) {
                return f16172f.get(str);
            }
            Integer valueOf = Integer.valueOf(BdUniqueId.gen().getId());
            f16172f.put(str, valueOf);
            return valueOf;
        }
        return (Integer) invokeL.objValue;
    }

    public static int l(DownloadData downloadData) {
        InterceptResult invokeL;
        int i;
        String id;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65545, null, downloadData)) == null) {
            if (c.a.p0.l3.b.j(downloadData.getId())) {
                i = 3;
            } else if (j().m(downloadData.getId())) {
                i = 5;
            } else if (j().n(downloadData.getId())) {
                i = 1;
            } else {
                i = c.a.p0.l3.b.k(downloadData.getId(), downloadData.getName()) ? 7 : 6;
            }
            DownloadStaticsData downloadStaticsData = downloadData.getDownloadStaticsData();
            if (downloadStaticsData != null) {
                id = downloadStaticsData.getApk_name();
            } else {
                id = downloadData.getId();
            }
            if (!TextUtils.isEmpty(id) && c.a.p0.a.h().B() && a0.r(id)) {
                return 8;
            }
            return i;
        }
        return invokeL.intValue;
    }

    public void f(String str, String str2, boolean z) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLLZ(1048576, this, str, str2, z) == null) || StringUtils.isNull(str)) {
            return;
        }
        DownloadData downloadData = null;
        for (DownloadData downloadData2 : c.a.p0.l3.g0.a.j().i()) {
            if (downloadData2.getId() != null && downloadData2.getId().equals(str2)) {
                downloadData = downloadData2;
            }
        }
        if (z) {
            c.a.p0.l3.g0.a.j().g(str, true);
        } else {
            c.a.p0.l3.g0.a.j().f(str);
        }
        if (downloadData != null) {
            int h2 = h(downloadData.getId(), downloadData.getName());
            c.a.p0.x.g.i.a.a.get().c().a(str2, h2);
            String str3 = h2 + "%";
            if (downloadData == null || h2 < 0) {
                return;
            }
            m mVar = this.f16173b.get(downloadData.getUrl());
            if (mVar == null) {
                mVar = new m(downloadData, h2);
            }
            mVar.c();
        }
    }

    public void g(DownloadData downloadData) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, downloadData) == null) {
            c.a.p0.l3.g0.a.j().h(downloadData);
            c.a.p0.x.g.i.a.a.get().c().b(downloadData.getId(), StopStatus.DOWNLOAD_UNSTART);
            p(downloadData);
        }
    }

    public int h(String str, String str2) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(Constants.METHOD_SEND_USER_MSG, this, str, str2)) == null) {
            long i = i(str, str2);
            long j = TbadkCoreApplication.getInst().getSharedPreferences("app_download_progress", 0).getLong(str, 0L);
            if (0 == j) {
                return -1;
            }
            if (i > j) {
                return 0;
            }
            return (int) ((i * 100) / j);
        }
        return invokeLL.intValue;
    }

    public long i(String str, String str2) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048579, this, str, str2)) == null) {
            File e2 = c.a.p0.l3.b.e(c.a.p0.l3.b.i(str, str2));
            if (e2 != null && e2.exists() && e2.isFile()) {
                return e2.length();
            }
            return -1L;
        }
        return invokeLL.longValue;
    }

    public boolean m(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048580, this, str)) == null) {
            for (DownloadData downloadData : c.a.p0.l3.g0.a.j().i()) {
                if (downloadData.getId() != null && downloadData.getId().equals(str) && downloadData.getStatus() == 5) {
                    return true;
                }
            }
            return false;
        }
        return invokeL.booleanValue;
    }

    public boolean n(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048581, this, str)) == null) {
            for (DownloadData downloadData : c.a.p0.l3.g0.a.j().i()) {
                if (downloadData.getId() != null && downloadData.getId().equals(str) && downloadData.getStatus() == 1) {
                    return true;
                }
            }
            return false;
        }
        return invokeL.booleanValue;
    }

    public void o(DownloadData downloadData) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048582, this, downloadData) == null) || downloadData == null) {
            return;
        }
        q(downloadData);
        c.a.p0.x.g.i.a.a.get().c().b(downloadData.getId(), StopStatus.DOWNLOAD_FAIL);
        this.f16173b.get(downloadData.getUrl());
    }

    public void p(DownloadData downloadData) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048583, this, downloadData) == null) {
            LinkedList linkedList = new LinkedList();
            linkedList.add(downloadData);
            MessageManager.getInstance().dispatchResponsedMessageToUI(new DownloadMessage(linkedList));
        }
    }

    public void q(DownloadData downloadData) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, downloadData) == null) || downloadData == null) {
            return;
        }
        m mVar = this.f16173b.get(downloadData.getUrl());
        int h2 = h(downloadData.getId(), downloadData.getName());
        if (mVar == null) {
            mVar = new m(downloadData, h2);
        }
        mVar.c();
    }

    public void r(DownloadData downloadData) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048585, this, downloadData) == null) || downloadData == null) {
            return;
        }
        m mVar = this.f16173b.get(downloadData.getUrl());
        int h2 = h(downloadData.getId(), downloadData.getName());
        if (mVar == null) {
            mVar = new m(downloadData, h2);
        }
        mVar.d();
    }

    public void s(DownloadData downloadData) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048586, this, downloadData) == null) || downloadData == null) {
            return;
        }
        int errorCode = downloadData.getErrorCode();
        if (errorCode == 1) {
            TbadkCoreApplication.getInst().getString(R.string.obfuscated_res_0x7f0f04f0);
        } else if (errorCode != 3) {
            TbadkCoreApplication.getInst().getString(R.string.obfuscated_res_0x7f0f04ee);
        } else {
            TbadkCoreApplication.getInst().getString(R.string.obfuscated_res_0x7f0f04ef);
        }
    }

    public void t(DownloadData downloadData) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048587, this, downloadData) == null) && downloadData != null && downloadData.isNeedNotify()) {
            int h2 = h(downloadData.getId(), downloadData.getName());
            c.a.p0.x.g.i.a.a.get().c().d(downloadData.getId(), h2);
            String str = h2 + "%";
            m mVar = this.f16173b.get(downloadData.getUrl());
            if (mVar == null) {
                mVar = new m(downloadData, h2);
            }
            int l = l(downloadData);
            if (l == 1) {
                mVar.d();
            } else if (l == 4 || l == 2 || l == 7) {
                mVar.c();
            } else if (l == 6) {
                return;
            }
            mVar.b(h2);
        }
    }

    public void u(DownloadData downloadData) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048588, this, downloadData) == null) || downloadData == null) {
            return;
        }
        List<DownloadData> i = c.a.p0.l3.g0.a.j().i();
        if (i != null && i.size() >= 5) {
            downloadData.setStatus(2);
            downloadData.setStatusMsg(TbadkCoreApplication.getInst().getApp().getString(R.string.obfuscated_res_0x7f0f04ed));
            p(downloadData);
            UtilHelper.showToast(TbadkCoreApplication.getInst(), (int) R.string.obfuscated_res_0x7f0f04ed);
            return;
        }
        c.a.p0.b2.o.k.a.a(f16171e, downloadData);
        w();
    }

    public void v(String str, String str2, String str3, int i, int i2, String[] strArr, boolean z, boolean z2, boolean z3, String str4, DownloadStaticsData downloadStaticsData, String str5) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048589, this, new Object[]{str, str2, str3, Integer.valueOf(i), Integer.valueOf(i2), strArr, Boolean.valueOf(z), Boolean.valueOf(z2), Boolean.valueOf(z3), str4, downloadStaticsData, str5}) == null) {
            DownloadData downloadData = new DownloadData(str);
            downloadData.setType(12);
            downloadData.setId(str);
            downloadData.setUrl(str2);
            downloadData.setName(str3);
            downloadData.setTag(strArr);
            downloadData.setPosition(i);
            downloadData.setNotifyId(i2);
            downloadData.setNeedInvokeApk(z);
            downloadData.setForceDownload(z2);
            downloadData.setNeedNotify(z3);
            downloadData.setApp_icon(str4);
            downloadData.setDownloadStaticsData(downloadStaticsData);
            downloadData.setUser_name(str5);
            u(downloadData);
        }
    }

    public final void w() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048590, this) == null) && f16170d == null && !c.a.p0.b2.o.k.a.e(f16171e)) {
            DownloadData downloadData = (DownloadData) c.a.p0.b2.o.k.a.d(f16171e, 0);
            f16170d = downloadData;
            if (downloadData != null) {
                b bVar = new b(this, null);
                this.a = bVar;
                bVar.setPriority(3);
                this.a.execute(f16170d);
            }
        }
    }
}
