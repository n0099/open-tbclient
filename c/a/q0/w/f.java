package c.a.q0.w;

import android.annotation.SuppressLint;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import c.a.d.f.p.k;
import c.a.d.f.p.q;
import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.FileHelper;
import com.baidu.tbadk.core.util.NetWork;
import com.baidu.tbadk.download.DownloadData;
import com.baidu.tieba.R;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
/* loaded from: classes5.dex */
public class f {
    public static /* synthetic */ Interceptable $ic;

    /* renamed from: c  reason: collision with root package name */
    public static f f13673c;

    /* renamed from: d  reason: collision with root package name */
    public static DownloadData f13674d;

    /* renamed from: e  reason: collision with root package name */
    public static List<DownloadData> f13675e;
    public transient /* synthetic */ FieldHolder $fh;
    public b a;
    @SuppressLint({"HandlerLeak"})

    /* renamed from: b  reason: collision with root package name */
    public Handler f13676b;

    /* loaded from: classes5.dex */
    public class a extends Handler {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public a(f fVar, Looper looper) {
            super(looper);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {fVar, looper};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    super((Looper) newInitContext.callArgs[0]);
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, message) == null) {
                super.handleMessage(message);
                if (message.what != 900002 || message.arg2 <= 0 || f.f13674d == null) {
                    return;
                }
                f.f13674d.setLength(message.arg1);
                f.f13674d.setSize(message.arg2);
                f.f13674d.setStatus(1);
                if (f.f13674d.getCallback() != null) {
                    f.f13674d.getCallback().onFileUpdateProgress(f.f13674d);
                }
            }
        }
    }

    @SuppressLint({"DefaultLocale"})
    /* loaded from: classes5.dex */
    public class b extends BdAsyncTask<DownloadData, DownloadData, Integer> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public NetWork a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ f f13677b;

        public b(f fVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {fVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f13677b = fVar;
            this.a = new NetWork();
        }

        public void b() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                NetWork netWork = this.a;
                if (netWork != null) {
                    netWork.setCancel();
                }
                cancel(true);
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: c */
        public Integer doInBackground(DownloadData... downloadDataArr) {
            InterceptResult invokeL;
            FileInputStream fileInputStream;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, downloadDataArr)) == null) {
                if (downloadDataArr[0] == null) {
                    return 1;
                }
                if (downloadDataArr[0].getCallback() != null && !downloadDataArr[0].getCallback().onPreDownload(downloadDataArr[0])) {
                    return 0;
                }
                File file = new File(downloadDataArr[0].getPath());
                if (file.exists()) {
                    file.delete();
                }
                if (!file.exists()) {
                    this.a.setUrl(downloadDataArr[0].getUrl());
                    NetWork netWork = this.a;
                    if (Boolean.valueOf(netWork.downloadFile(downloadDataArr[0].getId() + "_" + downloadDataArr[0].getName() + ".tmp", this.f13677b.f13676b, TbConfig.NET_MSG_GETLENTH, 3, 3000)).booleanValue()) {
                        File GetFileInCache = FileHelper.GetFileInCache(downloadDataArr[0].getId() + "_" + downloadDataArr[0].getName() + ".tmp");
                        if (GetFileInCache == null) {
                            return 1;
                        }
                        try {
                            try {
                                String parent = GetFileInCache.getParent();
                                String parent2 = file.getParent();
                                if (parent.equals(parent2)) {
                                    GetFileInCache.renameTo(new File(parent2, file.getName()));
                                } else {
                                    c.a.d.f.p.f.f(GetFileInCache, file);
                                    c.a.d.f.p.f.n(GetFileInCache);
                                }
                            } catch (IOException unused) {
                                c.a.d.f.p.f.n(file);
                                return 7;
                            }
                        } catch (Exception e2) {
                            e2.printStackTrace();
                            return 7;
                        }
                    } else {
                        return 3;
                    }
                }
                if (!k.isEmpty(downloadDataArr[0].getCheck())) {
                    FileInputStream fileInputStream2 = null;
                    try {
                        try {
                            fileInputStream = new FileInputStream(downloadDataArr[0].getPath());
                        } catch (Throwable th) {
                            th = th;
                        }
                    } catch (FileNotFoundException e3) {
                        e = e3;
                    }
                    try {
                        if (!q.b(fileInputStream).equalsIgnoreCase(downloadDataArr[0].getCheck())) {
                            c.a.d.f.p.f.n(new File(downloadDataArr[0].getPath()));
                            try {
                                fileInputStream.close();
                            } catch (IOException e4) {
                                BdLog.d(e4.getMessage());
                            }
                            return 4;
                        }
                        try {
                            fileInputStream.close();
                        } catch (IOException e5) {
                            BdLog.d(e5.getMessage());
                        }
                    } catch (FileNotFoundException e6) {
                        e = e6;
                        fileInputStream2 = fileInputStream;
                        BdLog.d(e.getMessage());
                        if (fileInputStream2 != null) {
                            try {
                                fileInputStream2.close();
                            } catch (IOException e7) {
                                BdLog.d(e7.getMessage());
                            }
                        }
                        return 6;
                    } catch (Throwable th2) {
                        th = th2;
                        fileInputStream2 = fileInputStream;
                        if (fileInputStream2 != null) {
                            try {
                                fileInputStream2.close();
                            } catch (IOException e8) {
                                BdLog.d(e8.getMessage());
                            }
                        }
                        throw th;
                    }
                }
                if (downloadDataArr[0].getCallback() == null || downloadDataArr[0].getCallback().onFileDownloaded(downloadDataArr[0])) {
                    return 0;
                }
                return 2;
            }
            return (Integer) invokeL.objValue;
        }

        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void onCancelled() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
                super.onCancelled();
                this.a.setCancel();
                if (f.f13674d == null) {
                    return;
                }
                f.f13674d.setStatus(4);
                f.f13674d.setStatusMsg(null);
                if (f.f13674d.getCallback() != null) {
                    f.f13674d.getCallback().onFileUpdateProgress(f.f13674d);
                }
                if (!f.f13675e.isEmpty()) {
                    f.f13675e.remove(0);
                }
                DownloadData unused = f.f13674d = null;
                this.f13677b.n();
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void onPostExecute(Integer num) {
            String string;
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048580, this, num) == null) {
                super.onPostExecute((b) num);
                if (f.f13674d == null || num == null) {
                    return;
                }
                if (num.intValue() == 0) {
                    f.f13674d.setStatus(0);
                    if (f.f13674d.getCallback() != null) {
                        f.f13674d.getCallback().onFileUpdateProgress(f.f13674d);
                    }
                    if (f.f13674d.getCallback() != null) {
                        f.f13674d.getCallback().onFileDownloadSucceed(f.f13674d);
                    }
                } else {
                    int intValue = num.intValue();
                    if (intValue == 1) {
                        string = TbadkCoreApplication.getInst().getApp().getString(R.string.download_fail);
                    } else if (intValue == 2) {
                        string = TbadkCoreApplication.getInst().getApp().getString(R.string.download_fail);
                    } else if (intValue == 3) {
                        string = TbadkCoreApplication.getInst().getApp().getString(R.string.download_error);
                    } else if (intValue == 4) {
                        string = TbadkCoreApplication.getInst().getApp().getString(R.string.download_fail);
                    } else if (intValue != 6) {
                        string = intValue != 7 ? null : TbadkCoreApplication.getInst().getApp().getString(R.string.download_fail);
                    } else {
                        string = TbadkCoreApplication.getInst().getApp().getString(R.string.download_fail);
                    }
                    f.f13674d.setStatusMsg(string);
                    f.f13674d.setErrorCode(num.intValue());
                    f.f13674d.setStatus(2);
                    if (f.f13674d.getCallback() != null) {
                        f.f13674d.getCallback().onFileUpdateProgress(f.f13674d);
                    }
                    if (f.f13674d.getCallback() != null) {
                        f.f13674d.getCallback().onFileDownloadFailed(f.f13674d, num.intValue(), string);
                    }
                }
                DownloadData unused = f.f13674d = null;
                if (f.f13675e.isEmpty()) {
                    return;
                }
                f.f13675e.remove(0);
                this.f13677b.n();
            }
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-1522191049, "Lc/a/q0/w/f;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-1522191049, "Lc/a/q0/w/f;");
                return;
            }
        }
        f13673c = new f();
        f13674d = null;
        f13675e = new LinkedList();
    }

    public f() {
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
        this.f13676b = new a(this, Looper.getMainLooper());
    }

    public static f k() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65543, null)) == null) ? f13673c : (f) invokeV.objValue;
    }

    public void f(String str, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLI(1048576, this, str, i2) == null) {
            DownloadData downloadData = f13674d;
            if (downloadData != null && downloadData.getId().equals(str) && f13674d.getType() == i2) {
                this.a.cancel(true);
                return;
            }
            LinkedList<DownloadData> linkedList = new LinkedList();
            Iterator<DownloadData> it = f13675e.iterator();
            while (true) {
                if (!it.hasNext()) {
                    break;
                }
                DownloadData next = it.next();
                if (next.getId().equals(str) && next.getType() == i2) {
                    next.setStatus(4);
                    next.setStatusMsg(null);
                    if (next.getCallback() != null) {
                        next.getCallback().onFileUpdateProgress(next);
                    }
                    linkedList.add(next);
                }
            }
            for (DownloadData downloadData2 : linkedList) {
                f13675e.remove(downloadData2);
            }
        }
    }

    public void g(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str) == null) {
            h(str, false);
        }
    }

    public void h(String str, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLZ(Constants.METHOD_SEND_USER_MSG, this, str, z) == null) {
            DownloadData downloadData = f13674d;
            if (downloadData != null && downloadData.getUrl().equals(str)) {
                if (z) {
                    this.a.b();
                    return;
                } else {
                    this.a.cancel(true);
                    return;
                }
            }
            LinkedList<DownloadData> linkedList = new LinkedList();
            Iterator<DownloadData> it = f13675e.iterator();
            while (true) {
                if (!it.hasNext()) {
                    break;
                }
                DownloadData next = it.next();
                if (next.getUrl().equals(str)) {
                    next.setStatus(4);
                    if (next.getCallback() != null) {
                        next.getCallback().onFileUpdateProgress(next);
                    }
                    linkedList.add(next);
                }
            }
            for (DownloadData downloadData2 : linkedList) {
                f13675e.remove(downloadData2);
            }
        }
    }

    public void i(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048579, this, i2) == null) {
            DownloadData downloadData = f13674d;
            if (downloadData != null && downloadData.getType() == i2) {
                this.a.cancel(true);
            }
            LinkedList<DownloadData> linkedList = new LinkedList();
            for (DownloadData downloadData2 : f13675e) {
                if (downloadData2.getType() == i2) {
                    downloadData2.setStatus(4);
                    downloadData2.setStatusMsg(null);
                    if (downloadData2.getCallback() != null) {
                        downloadData2.getCallback().onFileUpdateProgress(downloadData2);
                    }
                    linkedList.add(downloadData2);
                }
            }
            for (DownloadData downloadData3 : linkedList) {
                f13675e.remove(downloadData3);
            }
        }
    }

    public List<DownloadData> j() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) ? f13675e : (List) invokeV.objValue;
    }

    public void l(DownloadData downloadData) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048581, this, downloadData) == null) || downloadData == null) {
            return;
        }
        if (!FileHelper.checkSD()) {
            downloadData.setStatusMsg(TbadkCoreApplication.getInst().getApp().getString(R.string.download_fail_no_sd));
            downloadData.setStatus(2);
        }
        if (downloadData.getStatus() == 2) {
            if (downloadData.getCallback() != null) {
                downloadData.getCallback().onFileUpdateProgress(downloadData);
                return;
            }
            return;
        }
        for (int i2 = 0; i2 < f13675e.size(); i2++) {
            DownloadData downloadData2 = null;
            try {
                downloadData2 = f13675e.get(i2);
            } catch (Exception unused) {
            }
            if (downloadData2 != null && downloadData2.getUrl() != null && downloadData.getUrl() != null && downloadData2.getUrl().equals(downloadData.getUrl()) && downloadData2.getId() != null && downloadData.getId() != null && downloadData2.getId().equals(downloadData.getId())) {
                return;
            }
        }
        downloadData.setStatus(5);
        f13675e.add(downloadData);
        n();
    }

    public void m(DownloadData downloadData, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLI(1048582, this, downloadData, i2) == null) {
            int type = downloadData.getType();
            int i3 = 0;
            for (DownloadData downloadData2 : f13675e) {
                if (downloadData2.getType() == type) {
                    i3++;
                }
            }
            if (i3 >= i2) {
                downloadData.setStatus(2);
                downloadData.setStatusMsg(TbadkCoreApplication.getInst().getApp().getString(R.string.download_fail_over_max));
                if (downloadData.getCallback() != null) {
                    downloadData.getCallback().onFileUpdateProgress(downloadData);
                    return;
                }
                return;
            }
            l(downloadData);
        }
    }

    public final void n() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048583, this) == null) && f13674d == null && !f13675e.isEmpty()) {
            try {
                f13674d = f13675e.get(0);
            } catch (Exception e2) {
                BdLog.e(e2);
            }
            if (f13674d != null) {
                b bVar = new b(this);
                this.a = bVar;
                bVar.execute(f13674d);
            }
        }
    }
}
