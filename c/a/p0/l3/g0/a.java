package c.a.p0.l3.g0;

import android.annotation.SuppressLint;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import c.a.d.f.p.t;
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
/* loaded from: classes2.dex */
public class a {
    public static /* synthetic */ Interceptable $ic;

    /* renamed from: c  reason: collision with root package name */
    public static a f16132c;

    /* renamed from: d  reason: collision with root package name */
    public static DownloadData f16133d;

    /* renamed from: e  reason: collision with root package name */
    public static List<DownloadData> f16134e;
    public transient /* synthetic */ FieldHolder $fh;
    public b a;
    @SuppressLint({"HandlerLeak"})

    /* renamed from: b  reason: collision with root package name */
    public Handler f16135b;

    /* renamed from: c.a.p0.l3.g0.a$a  reason: collision with other inner class name */
    /* loaded from: classes2.dex */
    public class HandlerC1209a extends Handler {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public HandlerC1209a(a aVar, Looper looper) {
            super(looper);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {aVar, looper};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
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
                if (message.what != 900002 || message.arg2 <= 0 || a.f16133d == null) {
                    return;
                }
                a.f16133d.setLength(message.arg1);
                a.f16133d.setSize(message.arg2);
                a.f16133d.setStatus(1);
                if (a.f16133d.getCallback() != null) {
                    a.f16133d.getCallback().onFileUpdateProgress(a.f16133d);
                }
            }
        }
    }

    @SuppressLint({"DefaultLocale"})
    /* loaded from: classes2.dex */
    public class b extends BdAsyncTask<DownloadData, DownloadData, Integer> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public c a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ a f16136b;

        public b(a aVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {aVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f16136b = aVar;
            this.a = new c();
        }

        public void b() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                c cVar = this.a;
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
                this.a.f(downloadDataArr[0].getUrl());
                if (Boolean.valueOf(this.a.a(c.a.p0.l3.b.i(downloadDataArr[0].getId(), downloadDataArr[0].getName()), this.f16136b.f16135b, TbConfig.NET_MSG_GETLENTH, 1, 3000)).booleanValue()) {
                    File e2 = c.a.p0.l3.b.e(c.a.p0.l3.b.i(downloadDataArr[0].getId(), downloadDataArr[0].getName()));
                    if (e2 != null) {
                        try {
                            try {
                                String parent = e2.getParent();
                                String parent2 = file.getParent();
                                if (parent.equals(parent2)) {
                                    e2.renameTo(new File(parent2, file.getName()));
                                } else {
                                    c.a.d.f.p.h.f(e2, file);
                                    c.a.d.f.p.h.n(e2);
                                }
                            } catch (IOException unused) {
                                c.a.d.f.p.h.n(file);
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
                if (!c.a.d.f.p.m.isEmpty(downloadDataArr[0].getCheck())) {
                    try {
                        fileInputStream = new FileInputStream(downloadDataArr[0].getPath());
                    } catch (FileNotFoundException e4) {
                        e = e4;
                    }
                    try {
                        if (!t.b(fileInputStream).equalsIgnoreCase(downloadDataArr[0].getCheck())) {
                            c.a.d.f.p.h.n(new File(downloadDataArr[0].getPath()));
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
                this.a.e();
                a.f16133d.setStatus(4);
                a.f16133d.setStatusMsg(null);
                if (a.f16133d.getCallback() != null) {
                    a.f16133d.getCallback().onFileUpdateProgress(a.f16133d);
                }
                if (!c.a.p0.b2.o.k.a.e(a.f16134e)) {
                    c.a.p0.b2.o.k.a.i(a.f16134e, 0);
                }
                DownloadData unused = a.f16133d = null;
                this.f16136b.m();
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
                    a.f16133d.setStatus(0);
                    if (a.f16133d.getCallback() != null) {
                        a.f16133d.getCallback().onFileUpdateProgress(a.f16133d);
                    }
                    if (a.f16133d.getCallback() != null) {
                        a.f16133d.getCallback().onFileDownloadSucceed(a.f16133d);
                    }
                } else {
                    int intValue = num.intValue();
                    if (intValue == 1) {
                        string = TbadkCoreApplication.getInst().getApp().getString(R.string.obfuscated_res_0x7f0f04ea);
                    } else if (intValue == 2) {
                        string = TbadkCoreApplication.getInst().getApp().getString(R.string.obfuscated_res_0x7f0f04ea);
                    } else if (intValue == 3) {
                        string = TbadkCoreApplication.getInst().getApp().getString(R.string.obfuscated_res_0x7f0f04eb);
                    } else if (intValue == 4) {
                        string = TbadkCoreApplication.getInst().getApp().getString(R.string.obfuscated_res_0x7f0f04ea);
                    } else if (intValue != 6) {
                        string = intValue != 7 ? null : TbadkCoreApplication.getInst().getApp().getString(R.string.obfuscated_res_0x7f0f04ea);
                    } else {
                        string = TbadkCoreApplication.getInst().getApp().getString(R.string.obfuscated_res_0x7f0f04ea);
                    }
                    a.f16133d.setStatusMsg(string);
                    a.f16133d.setErrorCode(num.intValue());
                    a.f16133d.setStatus(2);
                    if (a.f16133d.getCallback() != null) {
                        a.f16133d.getCallback().onFileUpdateProgress(a.f16133d);
                    }
                    if (a.f16133d.getCallback() != null) {
                        a.f16133d.getCallback().onFileDownloadFailed(a.f16133d, num.intValue(), string);
                    }
                }
                DownloadData unused = a.f16133d = null;
                if (c.a.p0.b2.o.k.a.e(a.f16134e)) {
                    return;
                }
                c.a.p0.b2.o.k.a.i(a.f16134e, 0);
                this.f16136b.m();
            }
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-715580255, "Lc/a/p0/l3/g0/a;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-715580255, "Lc/a/p0/l3/g0/a;");
                return;
            }
        }
        f16132c = new a();
        f16133d = null;
        f16134e = new LinkedList();
    }

    public a() {
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
        this.f16135b = new HandlerC1209a(this, Looper.getMainLooper());
    }

    public static a j() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65543, null)) == null) ? f16132c : (a) invokeV.objValue;
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
            DownloadData downloadData = f16133d;
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
            Iterator<DownloadData> it = f16134e.iterator();
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
                    c.a.p0.b2.o.k.a.a(linkedList, next);
                }
            }
            for (DownloadData downloadData2 : linkedList) {
                c.a.p0.b2.o.k.a.j(f16134e, downloadData2);
            }
        }
    }

    public void h(DownloadData downloadData) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, downloadData) == null) || downloadData == null) {
            return;
        }
        g(downloadData.getUrl(), true);
        File e2 = c.a.p0.l3.b.e(c.a.p0.l3.b.i(downloadData.getId(), downloadData.getName()));
        if (e2 != null) {
            e2.delete();
        }
    }

    public List<DownloadData> i() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? f16134e : (List) invokeV.objValue;
    }

    public void k(DownloadData downloadData) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048580, this, downloadData) == null) || downloadData == null) {
            return;
        }
        if (!c.a.p0.a.h().u() && !FileHelper.checkSD()) {
            downloadData.setStatusMsg(TbadkCoreApplication.getInst().getApp().getString(R.string.obfuscated_res_0x7f0f04ec));
            downloadData.setStatus(2);
        }
        if (downloadData.getStatus() == 2) {
            if (downloadData.getCallback() != null) {
                downloadData.getCallback().onFileUpdateProgress(downloadData);
                return;
            }
            return;
        }
        for (int i = 0; i < c.a.p0.b2.o.k.a.k(f16134e); i++) {
            DownloadData downloadData2 = (DownloadData) c.a.p0.b2.o.k.a.d(f16134e, i);
            if (downloadData2 != null && downloadData2.getUrl().equals(downloadData.getUrl()) && downloadData2.getId().equals(downloadData.getId())) {
                return;
            }
        }
        downloadData.setStatus(5);
        c.a.p0.b2.o.k.a.a(f16134e, downloadData);
        m();
    }

    public void l(DownloadData downloadData, int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLI(1048581, this, downloadData, i) == null) {
            int type = downloadData.getType();
            int i2 = 0;
            for (DownloadData downloadData2 : f16134e) {
                if (downloadData2.getType() == type) {
                    i2++;
                }
            }
            if (i2 >= i) {
                downloadData.setStatus(2);
                downloadData.setStatusMsg(TbadkCoreApplication.getInst().getApp().getString(R.string.obfuscated_res_0x7f0f04ed));
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
        if ((interceptable == null || interceptable.invokeV(1048582, this) == null) && f16133d == null && !c.a.p0.b2.o.k.a.e(f16134e)) {
            DownloadData downloadData = (DownloadData) c.a.p0.b2.o.k.a.d(f16134e, 0);
            f16133d = downloadData;
            if (downloadData != null) {
                b bVar = new b(this);
                this.a = bVar;
                bVar.execute(f16133d);
            }
        }
    }
}
