package c.a.r0.z2.f0;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import c.a.e.e.p.q;
import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.mobads.container.util.AdIconUtil;
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
/* loaded from: classes4.dex */
public class f {
    public static /* synthetic */ Interceptable $ic;

    /* renamed from: b  reason: collision with root package name */
    public static f f29565b;

    /* renamed from: c  reason: collision with root package name */
    public static List<c> f29566c;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public int f29567a;

    /* loaded from: classes4.dex */
    public class a implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ DownloadData f29568e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ f f29569f;

        public a(f fVar, DownloadData downloadData) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {fVar, downloadData};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f29569f = fVar;
            this.f29568e = downloadData;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                if (f.f29566c.size() < this.f29569f.f29567a) {
                    this.f29569f.g(this.f29568e);
                    return;
                }
                this.f29568e.setStatus(2);
                this.f29568e.setStatusMsg(TbadkCoreApplication.getInst().getApp().getString(R.string.download_fail_over_max));
                if (this.f29568e.getCallback() != null) {
                    this.f29568e.getCallback().onFileUpdateProgress(this.f29568e);
                }
            }
        }
    }

    /* loaded from: classes4.dex */
    public class b implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ String f29570e;

        public b(f fVar, String str) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {fVar, str};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f29570e = str;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                Iterator it = f.f29566c.iterator();
                while (it.hasNext()) {
                    c cVar = (c) it.next();
                    if (cVar.e().getUrl().equals(this.f29570e)) {
                        cVar.e().setStatus(4);
                        if (cVar.e().getCallback() != null) {
                            cVar.e().getCallback().onFileUpdateProgress(cVar.e());
                        }
                        it.remove();
                        cVar.c();
                        return;
                    }
                }
            }
        }
    }

    /* loaded from: classes4.dex */
    public static class c extends BdAsyncTask<DownloadData, DownloadData, Integer> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public DownloadData f29571a;

        /* renamed from: b  reason: collision with root package name */
        public NetWork f29572b;

        /* renamed from: c  reason: collision with root package name */
        public Handler f29573c;

        /* loaded from: classes4.dex */
        public class a extends Handler {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: a  reason: collision with root package name */
            public final /* synthetic */ c f29574a;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public a(c cVar, Looper looper) {
                super(looper);
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {cVar, looper};
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
                this.f29574a = cVar;
            }

            @Override // android.os.Handler
            public void handleMessage(Message message) {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeL(1048576, this, message) == null) {
                    super.handleMessage(message);
                    if (message.what != 900002 || message.arg2 <= 0 || this.f29574a.f29571a == null) {
                        return;
                    }
                    this.f29574a.f29571a.setLength(message.arg1);
                    this.f29574a.f29571a.setSize(message.arg2);
                    this.f29574a.f29571a.setStatus(1);
                    if (this.f29574a.f29571a.getCallback() != null) {
                        this.f29574a.f29571a.getCallback().onFileUpdateProgress(this.f29574a.f29571a);
                    }
                }
            }
        }

        public c(DownloadData downloadData) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {downloadData};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f29572b = new NetWork();
            this.f29573c = new a(this, Looper.getMainLooper());
            this.f29571a = downloadData;
        }

        public void c() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                NetWork netWork = this.f29572b;
                if (netWork != null) {
                    netWork.setCancel();
                }
                cancel(true);
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: d */
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
                this.f29572b.setUrl(downloadDataArr[0].getUrl());
                NetWork netWork = this.f29572b;
                if (netWork.downloadFile(downloadDataArr[0].getId() + "_" + downloadDataArr[0].getName() + ".tmp", this.f29573c, TbConfig.NET_MSG_GETLENTH, 3, 3000)) {
                    File GetFile = FileHelper.GetFile(downloadDataArr[0].getId() + "_" + downloadDataArr[0].getName() + ".tmp");
                    if (GetFile == null) {
                        GetFile = FileHelper.GetFileInCache(downloadDataArr[0].getId() + "_" + downloadDataArr[0].getName() + ".tmp");
                    }
                    if (GetFile != null) {
                        try {
                            try {
                                String parent = GetFile.getParent();
                                String parent2 = file.getParent();
                                if (parent.equals(parent2)) {
                                    GetFile.renameTo(new File(parent2, file.getName()));
                                } else {
                                    c.a.e.e.p.f.f(GetFile, file);
                                    c.a.e.e.p.f.n(GetFile);
                                }
                            } catch (Exception e2) {
                                e2.printStackTrace();
                                return 7;
                            }
                        } catch (IOException unused) {
                            c.a.e.e.p.f.n(file);
                            c.a.e.e.p.f.n(GetFile);
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
                    } catch (FileNotFoundException e3) {
                        e = e3;
                    }
                    try {
                        if (!q.b(fileInputStream).equalsIgnoreCase(downloadDataArr[0].getCheck())) {
                            c.a.e.e.p.f.n(new File(downloadDataArr[0].getPath()));
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
                    } catch (Throwable th) {
                        th = th;
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
            } catch (Throwable th2) {
                th = th2;
            }
        }

        public DownloadData e() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? this.f29571a : (DownloadData) invokeV.objValue;
        }

        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void onCancelled() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
                super.onCancelled();
                this.f29572b.setCancel();
                this.f29571a.setStatus(4);
                this.f29571a.setStatusMsg(null);
                if (this.f29571a.getCallback() != null) {
                    this.f29571a.getCallback().onFileUpdateProgress(this.f29571a);
                }
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void onPostExecute(Integer num) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048581, this, num) == null) {
                super.onPostExecute((c) num);
                if (num == null) {
                    return;
                }
                if (num.intValue() == 0) {
                    this.f29571a.setStatus(0);
                    if (this.f29571a.getCallback() != null) {
                        this.f29571a.getCallback().onFileUpdateProgress(this.f29571a);
                    }
                    if (this.f29571a.getCallback() != null) {
                        this.f29571a.getCallback().onFileDownloadSucceed(this.f29571a);
                    }
                } else {
                    String str = null;
                    int intValue = num.intValue();
                    if (intValue == 1) {
                        str = TbadkCoreApplication.getInst().getApp().getString(R.string.download_fail);
                    } else if (intValue == 2) {
                        str = TbadkCoreApplication.getInst().getApp().getString(R.string.download_fail);
                    } else if (intValue == 3) {
                        str = TbadkCoreApplication.getInst().getApp().getString(R.string.download_fail_net);
                    } else if (intValue == 4) {
                        str = TbadkCoreApplication.getInst().getApp().getString(R.string.download_fail);
                    } else if (intValue == 6) {
                        str = TbadkCoreApplication.getInst().getApp().getString(R.string.download_fail);
                    } else if (intValue == 7) {
                        str = TbadkCoreApplication.getInst().getApp().getString(R.string.download_fail);
                    }
                    this.f29571a.setStatusMsg(str);
                    this.f29571a.setErrorCode(num.intValue());
                    this.f29571a.setStatus(2);
                    if (this.f29571a.getCallback() != null) {
                        this.f29571a.getCallback().onFileUpdateProgress(this.f29571a);
                    }
                    if (this.f29571a.getCallback() != null) {
                        this.f29571a.getCallback().onFileDownloadFailed(this.f29571a, num.intValue(), str);
                    }
                }
                f.f29566c.remove(this);
            }
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(2021565486, "Lc/a/r0/z2/f0/f;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(2021565486, "Lc/a/r0/z2/f0/f;");
                return;
            }
        }
        f29565b = new f();
        f29566c = new LinkedList();
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
        this.f29567a = 5;
    }

    public static f f() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(AdIconUtil.AD_TEXT_ID, null)) == null) ? f29565b : (f) invokeV.objValue;
    }

    public void d(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, str) == null) {
            c.a.e.e.m.e.a().post(new b(this, str));
        }
    }

    public List<DownloadData> e() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            LinkedList linkedList = new LinkedList();
            for (c cVar : f29566c) {
                linkedList.add(cVar.e());
            }
            return linkedList;
        }
        return (List) invokeV.objValue;
    }

    public final void g(DownloadData downloadData) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, downloadData) == null) || downloadData == null) {
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
        for (int i2 = 0; i2 < f29566c.size(); i2++) {
            DownloadData e2 = f29566c.get(i2).e();
            if (e2 != null && e2.getUrl().equals(downloadData.getUrl()) && e2.getId().equals(downloadData.getId())) {
                return;
            }
        }
        downloadData.setStatus(5);
        if (downloadData.getCallback() != null) {
            downloadData.getCallback().onFileUpdateProgress(downloadData);
        }
        c cVar = new c(downloadData);
        f29566c.add(cVar);
        cVar.execute(downloadData);
    }

    public void h(DownloadData downloadData) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, downloadData) == null) {
            c.a.e.e.m.e.a().post(new a(this, downloadData));
        }
    }
}
