package c.a.o0.q0;

import android.annotation.SuppressLint;
import android.os.Handler;
import android.os.Message;
import android.os.Process;
import android.text.TextUtils;
import androidx.core.view.InputDeviceCompat;
import c.a.e.e.p.f;
import c.a.e.e.p.j;
import c.a.e.e.p.k;
import com.baidu.adp.base.BdBaseApplication;
import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import com.baidu.adp.lib.stats.BdStatisticsManager;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.adp.plugin.packageManager.pluginFileDownload.BdFileDownloadData;
import com.baidu.adp.plugin.util.Util;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.searchbox.launch.stats.SpeedStatsStampTable;
import com.baidu.searchbox.live.interfaces.net.NetWorkError;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.CommonHelper;
import com.baidu.tbadk.core.util.FileHelper;
import com.baidu.tbadk.core.util.NetWork;
import com.baidu.tbadk.core.util.UtilHelper;
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
import java.io.IOException;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
/* loaded from: classes3.dex */
public class c extends c.a.e.h.j.e.b {
    public static /* synthetic */ Interceptable $ic;

    /* renamed from: c  reason: collision with root package name */
    public static c f13461c;

    /* renamed from: d  reason: collision with root package name */
    public static BdFileDownloadData f13462d;

    /* renamed from: e  reason: collision with root package name */
    public static List<BdFileDownloadData> f13463e;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public b f13464a;
    @SuppressLint({"HandlerLeak"})

    /* renamed from: b  reason: collision with root package name */
    public Handler f13465b;

    /* loaded from: classes3.dex */
    public class a extends Handler {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        public a(c cVar) {
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
                }
            }
        }

        @Override // android.os.Handler
        public void dispatchMessage(Message message) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, message) == null) {
                if (message != null && message.what == -1 && (message.obj instanceof c.a.o0.q0.b)) {
                    if (c.f13462d != null) {
                        c.a.o0.q0.b bVar = (c.a.o0.q0.b) message.obj;
                        c.f13462d.setErrorCode(message.arg1);
                        c.f13462d.setAfterHttpDnsUrl(bVar.a());
                        c.f13462d.setStatusMsg(bVar.g());
                        return;
                    }
                    return;
                }
                super.dispatchMessage(message);
            }
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, message) == null) {
                super.handleMessage(message);
                if (message.what != 900002 || message.arg2 <= 0 || c.f13462d == null) {
                    return;
                }
                c.f13462d.setLength(message.arg1);
                c.f13462d.setSize(message.arg2);
                if (c.f13462d.getCallback() != null) {
                    c.f13462d.getCallback().d(c.f13462d);
                }
            }
        }
    }

    @SuppressLint({"DefaultLocale"})
    /* loaded from: classes3.dex */
    public class b extends BdAsyncTask<BdFileDownloadData, BdFileDownloadData, Integer> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public NetWork f13466a;

        /* renamed from: b  reason: collision with root package name */
        public long f13467b;

        /* renamed from: c  reason: collision with root package name */
        public String f13468c;

        /* renamed from: d  reason: collision with root package name */
        public BdFileDownloadData f13469d;

        /* renamed from: e  reason: collision with root package name */
        public String f13470e;

        /* renamed from: f  reason: collision with root package name */
        public String f13471f;

        /* renamed from: g  reason: collision with root package name */
        public String f13472g;

        /* renamed from: h  reason: collision with root package name */
        public String f13473h;

        /* renamed from: i  reason: collision with root package name */
        public long f13474i;

        /* renamed from: j  reason: collision with root package name */
        public long f13475j;
        public long k;
        public final /* synthetic */ c l;

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
            this.l = cVar;
            this.f13466a = new NetWork();
            this.f13467b = -1L;
            this.f13468c = null;
            this.f13470e = null;
            this.f13471f = "";
            this.f13472g = "";
            this.f13473h = "";
        }

        public final boolean b(File file, String str, byte[] bArr) {
            InterceptResult invokeLLL;
            FileInputStream fileInputStream;
            String y;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLLL = interceptable.invokeLLL(1048576, this, file, str, bArr)) == null) {
                if (!file.exists() || file.length() <= 0) {
                    return false;
                }
                FileInputStream fileInputStream2 = null;
                try {
                    try {
                        try {
                            fileInputStream = new FileInputStream(file);
                        } catch (IOException e2) {
                            BdLog.d(e2.getMessage());
                        }
                    } catch (Exception e3) {
                        e = e3;
                    }
                } catch (Throwable th) {
                    th = th;
                }
                try {
                    y = Util.y(fileInputStream, bArr);
                } catch (Exception e4) {
                    e = e4;
                    fileInputStream2 = fileInputStream;
                    BdLog.d(e.getMessage());
                    if (fileInputStream2 != null) {
                        fileInputStream2.close();
                    }
                    return false;
                } catch (Throwable th2) {
                    th = th2;
                    fileInputStream2 = fileInputStream;
                    if (fileInputStream2 != null) {
                        try {
                            fileInputStream2.close();
                        } catch (IOException e5) {
                            BdLog.d(e5.getMessage());
                        }
                    }
                    throw th;
                }
                if (!y.equalsIgnoreCase(str)) {
                    this.f13467b = file.length();
                    this.f13468c = y;
                    f.o(file);
                    this.f13470e = c.a.o0.q0.a.a(file);
                    fileInputStream.close();
                    return false;
                }
                try {
                    fileInputStream.close();
                } catch (IOException e6) {
                    BdLog.d(e6.getMessage());
                }
                return true;
            }
            return invokeLLL.booleanValue;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: c */
        public Integer doInBackground(BdFileDownloadData... bdFileDownloadDataArr) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, bdFileDownloadDataArr)) == null) {
                if (bdFileDownloadDataArr[0] == null) {
                    return 3;
                }
                this.f13469d = bdFileDownloadDataArr[0];
                if (bdFileDownloadDataArr[0].getCallback() != null && !bdFileDownloadDataArr[0].getCallback().b(bdFileDownloadDataArr[0])) {
                    return 0;
                }
                BdLog.i("pluginFileDownloader beging download " + bdFileDownloadDataArr[0].getId());
                if (bdFileDownloadDataArr[0].getPath() != null && bdFileDownloadDataArr[0].getCheck() != null) {
                    this.f13471f = bdFileDownloadDataArr[0].getId();
                    this.f13466a.setUrl(bdFileDownloadDataArr[0].getUrl());
                    this.f13466a.setCanHttpsDownToHttp(true);
                    File file = new File(bdFileDownloadDataArr[0].getPath());
                    if (b(file, bdFileDownloadDataArr[0].getCheck(), null)) {
                        return 0;
                    }
                    if (!file.exists()) {
                        long currentTimeMillis = System.currentTimeMillis();
                        this.f13472g = UtilHelper.getIpFromDomain("tb1.bdstatic.com");
                        int d2 = d(bdFileDownloadDataArr[0], null);
                        if (d2 == 6 || d2 == 7) {
                            d2 = d(bdFileDownloadDataArr[0], null);
                        }
                        this.f13474i = System.currentTimeMillis() - currentTimeMillis;
                        if (d2 != 0) {
                            return Integer.valueOf(d2);
                        }
                    }
                    if (bdFileDownloadDataArr[0].getCallback() == null || bdFileDownloadDataArr[0].getCallback().c(bdFileDownloadDataArr[0])) {
                        if (this.l.o(bdFileDownloadDataArr[0])) {
                            return 0;
                        }
                        return 9;
                    }
                    return 5;
                }
                return 4;
            }
            return (Integer) invokeL.objValue;
        }

        public final int d(BdFileDownloadData bdFileDownloadData, byte[] bArr) {
            InterceptResult invokeLL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLL = interceptable.invokeLL(Constants.METHOD_SEND_USER_MSG, this, bdFileDownloadData, bArr)) == null) {
                BdLog.i("pluginFileDownloader downloadPlugin " + bdFileDownloadData.getPath());
                File file = new File(bdFileDownloadData.getPath());
                File file2 = new File(this.l.m(bdFileDownloadData));
                long length = file2.length();
                if (this.f13466a.downloadFile(this.l.m(bdFileDownloadData), this.l.f13465b, TbConfig.NET_MSG_GETLENTH, 3, 3000, true)) {
                    if (g(file2, file, bArr)) {
                        return b(file, bdFileDownloadData.getCheck(), bArr) ? 0 : 6;
                    }
                    return 8;
                } else if (this.f13466a.getNetContext().getResponse().mNetErrorCode == 416) {
                    if (b(file2, bdFileDownloadData.getCheck(), null)) {
                        if (g(file2, file, bArr)) {
                            return b(file, bdFileDownloadData.getCheck(), bArr) ? 0 : 6;
                        }
                        return 8;
                    }
                    return 7;
                } else {
                    this.f13475j = file2.length();
                    this.k = file2.length() - length;
                    return e();
                }
            }
            return invokeLL.intValue;
        }

        public final int e() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
                if (j.z()) {
                    if (c.f13462d != null) {
                        int errorCode = c.f13462d.getErrorCode();
                        if (errorCode != -100) {
                            switch (errorCode) {
                                case NetWorkError.NETWORK_CONNECT_EXCEPTION /* -22 */:
                                    return SpeedStatsStampTable.REG_RECEIVER_END_STAMP_KEY;
                                case NetWorkError.NETWORK_UNKNOWN_HOST_EXCEPTION /* -21 */:
                                    return SpeedStatsStampTable.REG_RECEIVER_START_STAMP_KEY;
                                case -20:
                                    return SpeedStatsStampTable.CHECK_PLUGIN_ENTRANCE_STATE_END_STAMP_KEY;
                                case -19:
                                    return 3004;
                                default:
                                    switch (errorCode) {
                                        case -15:
                                            return 3005;
                                        case -14:
                                            return 3000;
                                        case -13:
                                            return 3002;
                                        case -12:
                                            return 3001;
                                    }
                            }
                        }
                        return 3003;
                    }
                    return 2;
                }
                return 3006;
            }
            return invokeV.intValue;
        }

        /* JADX WARN: Removed duplicated region for block: B:21:0x0064  */
        /* JADX WARN: Removed duplicated region for block: B:24:0x006b  */
        /* JADX WARN: Removed duplicated region for block: B:31:0x009d  */
        /* JADX WARN: Removed duplicated region for block: B:32:0x00a0  */
        /* JADX WARN: Removed duplicated region for block: B:35:0x00c9  */
        /* JADX WARN: Removed duplicated region for block: B:36:0x00cc  */
        /* JADX WARN: Removed duplicated region for block: B:39:0x011b  */
        /* JADX WARN: Removed duplicated region for block: B:46:0x01c7  */
        /* JADX WARN: Removed duplicated region for block: B:49:0x01eb  */
        /* JADX WARN: Removed duplicated region for block: B:54:? A[RETURN, SYNTHETIC] */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public final void f(Integer num) {
            String string;
            Interceptable interceptable = $ic;
            if (interceptable != null && interceptable.invokeL(1048581, this, num) != null) {
                return;
            }
            String statusMsg = c.f13462d.getStatusMsg();
            int intValue = num.intValue();
            if (intValue != 2) {
                if (intValue != 3 && intValue != 4 && intValue != 5 && intValue != 8 && intValue != 9) {
                    switch (intValue) {
                        case 3000:
                        case 3001:
                        case 3002:
                        case 3003:
                        case 3004:
                        case 3005:
                        case SpeedStatsStampTable.CHECK_PLUGIN_ENTRANCE_STATE_END_STAMP_KEY /* 3007 */:
                        case SpeedStatsStampTable.REG_RECEIVER_START_STAMP_KEY /* 3008 */:
                        case SpeedStatsStampTable.REG_RECEIVER_END_STAMP_KEY /* 3009 */:
                            string = TbadkCoreApplication.getInst().getApp().getString(R.string.download_fail_net);
                            break;
                        case 3006:
                            break;
                        default:
                            string = TbadkCoreApplication.getInst().getApp().getString(R.string.tb_err_unknown);
                            break;
                    }
                } else {
                    string = TbadkCoreApplication.getInst().getApp().getString(R.string.download_fail);
                }
                if (statusMsg == null) {
                    statusMsg = string;
                }
                if (num.intValue() == 8) {
                    statusMsg = statusMsg + "_err-" + this.f13473h;
                }
                if (num.intValue() != 6 || num.intValue() == 7) {
                    String c2 = c.a.o0.q0.a.c(TbadkCoreApplication.getInst());
                    String str = !c.a.o0.q0.a.b() ? "true" : "false";
                    StringBuilder sb = new StringBuilder();
                    sb.append("_downloadfilesize-");
                    sb.append(this.f13467b);
                    sb.append(" ");
                    sb.append("downloadfileMd5-");
                    sb.append(this.f13468c);
                    sb.append(" wishMd5-");
                    BdFileDownloadData bdFileDownloadData = this.f13469d;
                    sb.append(bdFileDownloadData != null ? "" : bdFileDownloadData.getCheck());
                    sb.append("-url_");
                    sb.append(c.f13462d.getUrl());
                    sb.append("-realurl_");
                    sb.append(c.f13462d.getAfterHttpDnsUrl());
                    sb.append("-uploadResult_");
                    sb.append(this.f13470e);
                    sb.append("-Proxy_");
                    sb.append(c2);
                    sb.append("-UsbDebug_");
                    sb.append(str);
                    sb.append("-errorMsg_");
                    sb.append(statusMsg);
                    statusMsg = sb.toString();
                }
                if (statusMsg != null) {
                    StringBuilder sb2 = new StringBuilder();
                    sb2.append("-netType_");
                    sb2.append(j.J());
                    sb2.append("-cost_");
                    sb2.append(this.f13474i);
                    sb2.append("-downloadSize_");
                    sb2.append(this.k);
                    sb2.append("-tempSize_");
                    sb2.append(this.f13475j);
                    sb2.append("-clientIp_");
                    sb2.append(CommonHelper.getIp());
                    sb2.append("-cdnIp_");
                    sb2.append(this.f13472g);
                    sb2.append("-NetChangeTime_");
                    sb2.append(j.l());
                    sb2.append("-syncTime_");
                    sb2.append(TbadkCoreApplication.getInst().getLastSyncFinishTime());
                    if (TbadkCoreApplication.getInst().isInBackground()) {
                        sb2.append("|Background:true");
                    } else {
                        sb2.append("|Background:false|TopActivity:");
                        sb2.append(UtilHelper.getTopActivityClassName());
                    }
                    statusMsg = statusMsg + sb2.toString();
                }
                c.f13462d.setStatusMsg(string);
                c.f13462d.setErrorCode(num.intValue());
                if (c.f13462d.getCallback() != null) {
                    c.f13462d.getCallback().e(c.f13462d, num.intValue(), string, statusMsg);
                }
                c.f13462d.setStatus(2);
                if (c.f13462d.getCallback() == null) {
                    c.f13462d.getCallback().d(c.f13462d);
                    return;
                }
                return;
            }
            string = TbadkCoreApplication.getInst().getApp().getString(R.string.download_fail_net);
            if (statusMsg == null) {
            }
            if (num.intValue() == 8) {
            }
            if (num.intValue() != 6) {
            }
            String c22 = c.a.o0.q0.a.c(TbadkCoreApplication.getInst());
            if (!c.a.o0.q0.a.b()) {
            }
            StringBuilder sb3 = new StringBuilder();
            sb3.append("_downloadfilesize-");
            sb3.append(this.f13467b);
            sb3.append(" ");
            sb3.append("downloadfileMd5-");
            sb3.append(this.f13468c);
            sb3.append(" wishMd5-");
            BdFileDownloadData bdFileDownloadData2 = this.f13469d;
            sb3.append(bdFileDownloadData2 != null ? "" : bdFileDownloadData2.getCheck());
            sb3.append("-url_");
            sb3.append(c.f13462d.getUrl());
            sb3.append("-realurl_");
            sb3.append(c.f13462d.getAfterHttpDnsUrl());
            sb3.append("-uploadResult_");
            sb3.append(this.f13470e);
            sb3.append("-Proxy_");
            sb3.append(c22);
            sb3.append("-UsbDebug_");
            sb3.append(str);
            sb3.append("-errorMsg_");
            sb3.append(statusMsg);
            statusMsg = sb3.toString();
            if (statusMsg != null) {
            }
            c.f13462d.setStatusMsg(string);
            c.f13462d.setErrorCode(num.intValue());
            if (c.f13462d.getCallback() != null) {
            }
            c.f13462d.setStatus(2);
            if (c.f13462d.getCallback() == null) {
            }
        }

        /* JADX WARN: Removed duplicated region for block: B:35:0x0060  */
        /* JADX WARN: Removed duplicated region for block: B:36:0x0063  */
        /* JADX WARN: Removed duplicated region for block: B:39:0x0070 A[Catch: Exception -> 0x00a1, TRY_ENTER, TryCatch #1 {Exception -> 0x00a1, blocks: (B:39:0x0070, B:40:0x0074, B:42:0x007a, B:43:0x007d, B:45:0x0083, B:47:0x0089, B:49:0x0091, B:51:0x0095, B:52:0x009a, B:53:0x009b, B:54:0x00a0), top: B:68:0x006e }] */
        /* JADX WARN: Removed duplicated region for block: B:40:0x0074 A[Catch: Exception -> 0x00a1, TryCatch #1 {Exception -> 0x00a1, blocks: (B:39:0x0070, B:40:0x0074, B:42:0x007a, B:43:0x007d, B:45:0x0083, B:47:0x0089, B:49:0x0091, B:51:0x0095, B:52:0x009a, B:53:0x009b, B:54:0x00a0), top: B:68:0x006e }] */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public final boolean g(File file, File file2, byte[] bArr) {
            InterceptResult invokeLLL;
            Exception exc;
            long j2;
            boolean z;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLLL = interceptable.invokeLLL(1048582, this, file, file2, bArr)) == null) {
                if (file.exists() && file.length() > 0) {
                    try {
                        if (file2.exists()) {
                            file2.delete();
                        }
                        j2 = file.length();
                    } catch (Exception e2) {
                        exc = e2;
                        j2 = 0;
                    }
                    try {
                    } catch (Exception e3) {
                        exc = e3;
                        z = false;
                        c.a.e.h.h.a.b().p("retry_rename_tmp", this.f13471f, !z ? "true" : "false", exc.toString());
                        try {
                            if (!z) {
                            }
                            return true;
                        } catch (Exception e4) {
                            f.o(file2);
                            this.f13473h = "avirom_" + Util.g() + "-filesize_" + j2 + "-exception_" + exc.toString() + "-exception1_" + e4.toString();
                            return false;
                        }
                    }
                    if (c.a.o0.q0.a.d(file, file2, bArr)) {
                        if (file2.exists() && file2.length() != 0) {
                            try {
                                file.delete();
                            } catch (Exception e5) {
                                exc = e5;
                                z = true;
                                c.a.e.h.h.a.b().p("retry_rename_tmp", this.f13471f, !z ? "true" : "false", exc.toString());
                                if (!z) {
                                    file.delete();
                                } else {
                                    if (file2.exists()) {
                                        file2.delete();
                                    }
                                    if (c.a.o0.q0.a.d(file, file2, bArr)) {
                                        if (file2.exists() && file2.length() != 0) {
                                            file.delete();
                                        } else {
                                            throw new Exception("rename fail");
                                        }
                                    } else {
                                        throw new Exception("rename return fail");
                                    }
                                }
                                return true;
                            }
                            return true;
                        }
                        throw new Exception("rename fail");
                    }
                    throw new Exception("rename return fail");
                }
                if (file.exists()) {
                    this.f13473h = "temp_exists";
                    f.o(file);
                }
                return false;
            }
            return invokeLLL.booleanValue;
        }

        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void onCancelled() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048583, this) == null) {
                super.onCancelled();
                this.f13466a.cancelNetConnect();
                c.f13462d.setStatus(4);
                c.f13462d.setStatusMsg(null);
                if (c.f13462d.getCallback() != null) {
                    c.f13462d.getCallback().d(c.f13462d);
                }
                if (!c.f13463e.isEmpty()) {
                    c.f13463e.remove(0);
                }
                BdFileDownloadData unused = c.f13462d = null;
                this.l.p();
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void onPostExecute(Integer num) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, num) == null) {
                super.onPostExecute((b) num);
                if (num == null) {
                    num = -1;
                }
                if (num.intValue() == 0) {
                    if (c.f13462d.getCallback() != null) {
                        c.f13462d.getCallback().a(c.f13462d);
                    }
                    c.f13462d.setStatus(0);
                    if (c.f13462d.getCallback() != null) {
                        c.f13462d.getCallback().d(c.f13462d);
                    }
                } else {
                    f(num);
                }
                BdFileDownloadData unused = c.f13462d = null;
                if (c.f13463e.isEmpty()) {
                    return;
                }
                c.f13463e.remove(0);
                this.l.p();
            }
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(860501472, "Lc/a/o0/q0/c;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(860501472, "Lc/a/o0/q0/c;");
                return;
            }
        }
        f13461c = new c();
        f13462d = null;
        f13463e = new LinkedList();
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
        this.f13464a = null;
        this.f13465b = new a(this);
    }

    public static c n() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65545, null)) == null) ? f13461c : (c) invokeV.objValue;
    }

    @Override // c.a.e.h.j.e.b
    public void a(String str) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048576, this, str) == null) || TextUtils.isEmpty(str)) {
            return;
        }
        BdFileDownloadData bdFileDownloadData = f13462d;
        if (bdFileDownloadData != null && bdFileDownloadData.getId().equals(str)) {
            this.f13464a.cancel(true);
            return;
        }
        LinkedList<BdFileDownloadData> linkedList = new LinkedList();
        Iterator<BdFileDownloadData> it = f13463e.iterator();
        while (true) {
            if (!it.hasNext()) {
                break;
            }
            BdFileDownloadData next = it.next();
            if (next.getId().equals(str)) {
                next.setStatus(4);
                next.setStatusMsg(null);
                if (next.getCallback() != null) {
                    next.getCallback().d(next);
                }
                linkedList.add(next);
            }
        }
        for (BdFileDownloadData bdFileDownloadData2 : linkedList) {
            f13463e.remove(bdFileDownloadData2);
        }
    }

    @Override // c.a.e.h.j.e.b
    public List<BdFileDownloadData> b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? f13463e : (List) invokeV.objValue;
    }

    @Override // c.a.e.h.j.e.b
    public void d(BdFileDownloadData bdFileDownloadData, int i2) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLI(Constants.METHOD_SEND_USER_MSG, this, bdFileDownloadData, i2) == null) || bdFileDownloadData == null) {
            return;
        }
        if (!FileHelper.checkSD() && i2 == 2) {
            bdFileDownloadData.setStatusMsg(TbadkCoreApplication.getInst().getApp().getString(R.string.download_fail_no_sd));
            bdFileDownloadData.setStatus(2);
        }
        if (bdFileDownloadData.getStatus() == 2) {
            if (bdFileDownloadData.getCallback() != null) {
                bdFileDownloadData.getCallback().d(bdFileDownloadData);
                return;
            }
            return;
        }
        BdStatisticsManager bdStatisticsManager = BdStatisticsManager.getInstance();
        BdBaseApplication inst = BdBaseApplication.getInst();
        bdStatisticsManager.eventStat(inst, "plugin_start_download", null, 1, "pname", bdFileDownloadData.getId(), "appver", BdStatisticsManager.getInstance().getAppVersion(), "comment", "downloadByAuto-isBackgrount_" + TbadkCoreApplication.getInst().isInBackground(), "pid", Integer.valueOf(Process.myPid()));
        for (int i3 = 0; i3 < f13463e.size(); i3++) {
            BdFileDownloadData bdFileDownloadData2 = f13463e.get(i3);
            if (bdFileDownloadData2 != null && !k.isEmpty(bdFileDownloadData2.getUrl()) && bdFileDownloadData2.getUrl().equals(bdFileDownloadData.getUrl()) && bdFileDownloadData2.getId().equals(bdFileDownloadData.getId())) {
                return;
            }
        }
        bdFileDownloadData.setStatus(1);
        f13463e.add(bdFileDownloadData);
        p();
    }

    @Override // c.a.e.h.j.e.b
    public void e(BdFileDownloadData bdFileDownloadData, int i2) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLI(1048579, this, bdFileDownloadData, i2) == null) || bdFileDownloadData == null) {
            return;
        }
        if (!FileHelper.checkSD() && i2 == 2) {
            bdFileDownloadData.setStatusMsg(TbadkCoreApplication.getInst().getApp().getString(R.string.download_fail_no_sd));
            bdFileDownloadData.setStatus(2);
        }
        if (bdFileDownloadData.getStatus() == 2) {
            if (bdFileDownloadData.getCallback() != null) {
                bdFileDownloadData.getCallback().d(bdFileDownloadData);
                return;
            }
            return;
        }
        BdStatisticsManager bdStatisticsManager = BdStatisticsManager.getInstance();
        BdBaseApplication inst = BdBaseApplication.getInst();
        bdStatisticsManager.eventStat(inst, "plugin_start_download", null, 1, "pname", bdFileDownloadData.getId(), "appver", BdStatisticsManager.getInstance().getAppVersion(), "comment", "downloadByUser-isBackgrount_" + TbadkCoreApplication.getInst().isInBackground(), "pid", Integer.valueOf(Process.myPid()));
        BdFileDownloadData bdFileDownloadData2 = f13462d;
        if (bdFileDownloadData2 != null && bdFileDownloadData2.getUrl().equals(bdFileDownloadData.getUrl()) && f13462d.getId().equals(bdFileDownloadData.getId())) {
            return;
        }
        for (int i3 = 0; i3 < f13463e.size(); i3++) {
            BdFileDownloadData bdFileDownloadData3 = f13463e.get(i3);
            if (bdFileDownloadData3 != null && bdFileDownloadData3.getUrl().equals(bdFileDownloadData.getUrl()) && bdFileDownloadData3.getId().equals(bdFileDownloadData.getId())) {
                f13463e.remove(i3);
                f13463e.add(0, bdFileDownloadData3);
                return;
            }
        }
        bdFileDownloadData.setStatus(1);
        f13463e.add(0, bdFileDownloadData);
        p();
    }

    public final String m(BdFileDownloadData bdFileDownloadData) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048580, this, bdFileDownloadData)) == null) {
            if (bdFileDownloadData == null) {
                return null;
            }
            return bdFileDownloadData.getPath() + ".tmp";
        }
        return (String) invokeL.objValue;
    }

    public final boolean o(BdFileDownloadData bdFileDownloadData) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048581, this, bdFileDownloadData)) == null) {
            if (bdFileDownloadData == null) {
                return false;
            }
            String path = bdFileDownloadData.getPath();
            return !TextUtils.isEmpty(path) && new File(path).exists();
        }
        return invokeL.booleanValue;
    }

    public final void p() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048582, this) == null) && f13462d == null && !f13463e.isEmpty()) {
            BdFileDownloadData bdFileDownloadData = f13463e.get(0);
            f13462d = bdFileDownloadData;
            if (bdFileDownloadData != null) {
                b bVar = new b(this);
                this.f13464a = bVar;
                bVar.execute(f13462d);
            }
        }
    }
}
