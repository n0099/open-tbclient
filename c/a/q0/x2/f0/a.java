package c.a.q0.x2.f0;

import android.annotation.SuppressLint;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import c.a.e.e.p.q;
import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.FileHelper;
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
/* loaded from: classes4.dex */
public class a {
    public static /* synthetic */ Interceptable $ic;

    /* renamed from: c  reason: collision with root package name */
    public static a f28722c;

    /* renamed from: d  reason: collision with root package name */
    public static DownloadData f28723d;

    /* renamed from: e  reason: collision with root package name */
    public static List<DownloadData> f28724e;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public b f28725a;
    @SuppressLint({"HandlerLeak"})

    /* renamed from: b  reason: collision with root package name */
    public Handler f28726b;

    /* renamed from: c.a.q0.x2.f0.a$a  reason: collision with other inner class name */
    /* loaded from: classes4.dex */
    public class HandlerC1340a extends Handler {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public HandlerC1340a(a aVar, Looper looper) {
            super(looper);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {aVar, looper};
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
                if (message.what != 900002 || message.arg2 <= 0 || a.f28723d == null) {
                    return;
                }
                a.f28723d.setLength(message.arg1);
                a.f28723d.setSize(message.arg2);
                a.f28723d.setStatus(1);
                if (a.f28723d.getCallback() != null) {
                    a.f28723d.getCallback().onFileUpdateProgress(a.f28723d);
                }
            }
        }
    }

    @SuppressLint({"DefaultLocale"})
    /* loaded from: classes4.dex */
    public class b extends BdAsyncTask<DownloadData, DownloadData, Integer> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public c f28727a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ a f28728b;

        public b(a aVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {aVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f28728b = aVar;
            this.f28727a = new c();
        }

        public void b() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                c cVar = this.f28727a;
                if (cVar != null) {
                    cVar.e();
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
            if (interceptable != null && (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, downloadDataArr)) != null) {
                return (Integer) invokeL.objValue;
            }
            FileInputStream fileInputStream2 = null;
            if (downloadDataArr[0] == null) {
                return null;
            }
            if (downloadDataArr[0].getCallback() != null && !downloadDataArr[0].getCallback().onPreDownload(downloadDataArr[0])) {
                return 0;
            }
            File file = new File(downloadDataArr[0].getPath());
            if (file.exists()) {
                file.delete();
            }
            if (!file.exists()) {
                this.f28727a.f(downloadDataArr[0].getUrl());
                if (Boolean.valueOf(this.f28727a.a(c.a.q0.x2.b.i(downloadDataArr[0].getId(), downloadDataArr[0].getName()), this.f28728b.f28726b, TbConfig.NET_MSG_GETLENTH, 1, 3000)).booleanValue()) {
                    File e2 = c.a.q0.x2.b.e(c.a.q0.x2.b.i(downloadDataArr[0].getId(), downloadDataArr[0].getName()));
                    if (e2 != null) {
                        try {
                            try {
                                String parent = e2.getParent();
                                String parent2 = file.getParent();
                                if (parent.equals(parent2)) {
                                    e2.renameTo(new File(parent2, file.getName()));
                                } else {
                                    c.a.e.e.p.f.f(e2, file);
                                    c.a.e.e.p.f.n(e2);
                                }
                            } catch (IOException unused) {
                                c.a.e.e.p.f.n(file);
                                return 7;
                            }
                        } catch (Exception e3) {
                            e3.printStackTrace();
                            return 7;
                        }
                    } else {
                        return 1;
                    }
                } else {
                    return 3;
                }
            }
            try {
                if (!c.a.e.e.p.k.isEmpty(downloadDataArr[0].getCheck())) {
                    try {
                        fileInputStream = new FileInputStream(downloadDataArr[0].getPath());
                    } catch (FileNotFoundException e4) {
                        e = e4;
                    }
                    try {
                        if (!q.b(fileInputStream).equalsIgnoreCase(downloadDataArr[0].getCheck())) {
                            c.a.e.e.p.f.n(new File(downloadDataArr[0].getPath()));
                            try {
                                fileInputStream.close();
                            } catch (IOException e5) {
                                BdLog.d(e5.getMessage());
                            }
                            return 4;
                        }
                        try {
                            fileInputStream.close();
                        } catch (IOException e6) {
                            BdLog.d(e6.getMessage());
                        }
                    } catch (FileNotFoundException e7) {
                        e = e7;
                        fileInputStream2 = fileInputStream;
                        BdLog.d(e.getMessage());
                        if (fileInputStream2 != null) {
                            try {
                                fileInputStream2.close();
                            } catch (IOException e8) {
                                BdLog.d(e8.getMessage());
                            }
                        }
                        return 6;
                    } catch (Throwable th) {
                        th = th;
                        fileInputStream2 = fileInputStream;
                        if (fileInputStream2 != null) {
                            try {
                                fileInputStream2.close();
                            } catch (IOException e9) {
                                BdLog.d(e9.getMessage());
                            }
                        }
                        throw th;
                    }
                }
                if (downloadDataArr[0].getCallback() == null || downloadDataArr[0].getCallback().onFileDownloaded(downloadDataArr[0])) {
                    return 0;
                }
                return 2;
            } catch (Throwable th2) {
                th = th2;
            }
        }

        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void onCancelled() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
                super.onCancelled();
                this.f28727a.e();
                a.f28723d.setStatus(4);
                a.f28723d.setStatusMsg(null);
                if (a.f28723d.getCallback() != null) {
                    a.f28723d.getCallback().onFileUpdateProgress(a.f28723d);
                }
                if (!c.a.q0.o1.o.k.a.e(a.f28724e)) {
                    c.a.q0.o1.o.k.a.i(a.f28724e, 0);
                }
                DownloadData unused = a.f28723d = null;
                this.f28728b.m();
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void onPostExecute(Integer num) {
            String string;
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048580, this, num) == null) {
                super.onPostExecute((b) num);
                if (num == null) {
                    return;
                }
                if (num.intValue() == 0) {
                    a.f28723d.setStatus(0);
                    if (a.f28723d.getCallback() != null) {
                        a.f28723d.getCallback().onFileUpdateProgress(a.f28723d);
                    }
                    if (a.f28723d.getCallback() != null) {
                        a.f28723d.getCallback().onFileDownloadSucceed(a.f28723d);
                    }
                } else {
                    int intValue = num.intValue();
                    if (intValue == 1) {
                        string = TbadkCoreApplication.getInst().getApp().getString(R.string.download_fail);
                    } else if (intValue == 2) {
                        string = TbadkCoreApplication.getInst().getApp().getString(R.string.download_fail);
                    } else if (intValue == 3) {
                        string = TbadkCoreApplication.getInst().getApp().getString(R.string.download_fail_net);
                    } else if (intValue == 4) {
                        string = TbadkCoreApplication.getInst().getApp().getString(R.string.download_fail);
                    } else if (intValue != 6) {
                        string = intValue != 7 ? null : TbadkCoreApplication.getInst().getApp().getString(R.string.download_fail);
                    } else {
                        string = TbadkCoreApplication.getInst().getApp().getString(R.string.download_fail);
                    }
                    a.f28723d.setStatusMsg(string);
                    a.f28723d.setErrorCode(num.intValue());
                    a.f28723d.setStatus(2);
                    if (a.f28723d.getCallback() != null) {
                        a.f28723d.getCallback().onFileUpdateProgress(a.f28723d);
                    }
                    if (a.f28723d.getCallback() != null) {
                        a.f28723d.getCallback().onFileDownloadFailed(a.f28723d, num.intValue(), string);
                    }
                }
                DownloadData unused = a.f28723d = null;
                if (c.a.q0.o1.o.k.a.e(a.f28724e)) {
                    return;
                }
                c.a.q0.o1.o.k.a.i(a.f28724e, 0);
                this.f28728b.m();
            }
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(332896020, "Lc/a/q0/x2/f0/a;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(332896020, "Lc/a/q0/x2/f0/a;");
                return;
            }
        }
        f28722c = new a();
        f28723d = null;
        f28724e = new LinkedList();
    }

    public a() {
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
        this.f28725a = null;
        this.f28726b = new HandlerC1340a(this, Looper.getMainLooper());
    }

    public static a j() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65543, null)) == null) ? f28722c : (a) invokeV.objValue;
    }

    public void f(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, str) == null) {
            g(str, false);
        }
    }

    public void g(String str, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLZ(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str, z) == null) {
            DownloadData downloadData = f28723d;
            if (downloadData != null && downloadData.getUrl().equals(str)) {
                if (z) {
                    this.f28725a.b();
                    return;
                } else {
                    this.f28725a.cancel(true);
                    return;
                }
            }
            LinkedList<DownloadData> linkedList = new LinkedList();
            Iterator<DownloadData> it = f28724e.iterator();
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
                    c.a.q0.o1.o.k.a.a(linkedList, next);
                }
            }
            for (DownloadData downloadData2 : linkedList) {
                c.a.q0.o1.o.k.a.j(f28724e, downloadData2);
            }
        }
    }

    public void h(DownloadData downloadData) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, downloadData) == null) || downloadData == null) {
            return;
        }
        g(downloadData.getUrl(), true);
        File e2 = c.a.q0.x2.b.e(c.a.q0.x2.b.i(downloadData.getId(), downloadData.getName()));
        if (e2 != null) {
            e2.delete();
        }
    }

    public List<DownloadData> i() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? f28724e : (List) invokeV.objValue;
    }

    public void k(DownloadData downloadData) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048580, this, downloadData) == null) || downloadData == null) {
            return;
        }
        if (!c.a.q0.a.h().u() && !FileHelper.checkSD()) {
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
        for (int i2 = 0; i2 < c.a.q0.o1.o.k.a.k(f28724e); i2++) {
            DownloadData downloadData2 = (DownloadData) c.a.q0.o1.o.k.a.d(f28724e, i2);
            if (downloadData2 != null && downloadData2.getUrl().equals(downloadData.getUrl()) && downloadData2.getId().equals(downloadData.getId())) {
                return;
            }
        }
        downloadData.setStatus(5);
        c.a.q0.o1.o.k.a.a(f28724e, downloadData);
        m();
    }

    public void l(DownloadData downloadData, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLI(1048581, this, downloadData, i2) == null) {
            int type = downloadData.getType();
            int i3 = 0;
            for (DownloadData downloadData2 : f28724e) {
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
            k(downloadData);
        }
    }

    public final void m() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048582, this) == null) && f28723d == null && !c.a.q0.o1.o.k.a.e(f28724e)) {
            DownloadData downloadData = (DownloadData) c.a.q0.o1.o.k.a.d(f28724e, 0);
            f28723d = downloadData;
            if (downloadData != null) {
                b bVar = new b(this);
                this.f28725a = bVar;
                bVar.execute(f28723d);
            }
        }
    }
}
