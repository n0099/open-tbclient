package com.baidu.fsg.face.base.b;

import android.annotation.TargetApi;
import android.content.Context;
import android.os.Build;
import android.os.Environment;
import android.text.TextUtils;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.common.logging.Log;
import com.baidu.android.common.security.MD5Util;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.fsg.base.armor.RimArmor;
import com.baidu.fsg.base.downloadmanager.ApollonDownloadManager;
import com.baidu.fsg.base.downloadmanager.DownloadItemInfo;
import com.baidu.fsg.base.restnet.beans.business.core.utils.BdWalletUtils;
import com.baidu.fsg.base.statistics.RimStatisticsUtil;
import com.baidu.fsg.base.utils.LogUtil;
import com.baidu.fsg.face.base.b.b;
import com.baidu.fsg.face.base.b.c;
import com.baidu.fsg.face.base.d.g;
import com.baidu.fsg.face.base.d.k;
import com.baidu.fsg.face.base.d.l;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;
import java.util.concurrent.CountDownLatch;
import java.util.zip.ZipEntry;
import java.util.zip.ZipInputStream;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes8.dex */
public class e {
    public static /* synthetic */ Interceptable $ic = null;
    public static String a = "UpdateSo";
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: b  reason: collision with root package name */
    public Context f34522b;

    /* renamed from: c  reason: collision with root package name */
    public b f34523c;

    /* renamed from: d  reason: collision with root package name */
    public CountDownLatch f34524d;

    /* renamed from: e  reason: collision with root package name */
    public c f34525e;

    /* renamed from: f  reason: collision with root package name */
    public c f34526f;

    /* renamed from: g  reason: collision with root package name */
    public b.a f34527g;

    /* loaded from: classes8.dex */
    public interface a {
        void a(c.a aVar);

        void a(c.a aVar, byte[] bArr);
    }

    /* loaded from: classes8.dex */
    public class b {
        public static /* synthetic */ Interceptable $ic = null;
        public static final String a = "dl_so_zip_version";

        /* renamed from: c  reason: collision with root package name */
        public static final String f34534c = "dl_so_modle_name";

        /* renamed from: d  reason: collision with root package name */
        public static final String f34535d = "dl_so_get_config_success";

        /* renamed from: e  reason: collision with root package name */
        public static final String f34536e = "dl_so_zip_file_success";

        /* renamed from: f  reason: collision with root package name */
        public static final String f34537f = "dl_so_need_update";

        /* renamed from: g  reason: collision with root package name */
        public static final String f34538g = "dl_so_update_from_net";

        /* renamed from: h  reason: collision with root package name */
        public static final String f34539h = "dl_so_exception_info";

        /* renamed from: i  reason: collision with root package name */
        public static final String f34540i = "dl_so_meet_gray";

        /* renamed from: j  reason: collision with root package name */
        public static final String f34541j = "dl_so_zip_enable";
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ e f34542b;

        /* renamed from: k  reason: collision with root package name */
        public String f34543k;
        public boolean l;
        public boolean m;
        public boolean n;
        public boolean o;
        public boolean p;
        public String q;
        public boolean r;

        public b(e eVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {eVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f34542b = eVar;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void b() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(65543, this) == null) {
                for (Map.Entry<String, String> entry : a().entrySet()) {
                    RimStatisticsUtil.onEventWithValue(entry.getKey(), entry.getValue());
                }
                RimStatisticsUtil.getInstance().triggerSending();
            }
        }

        private Map<String, String> a() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(65539, this)) == null) {
                HashMap hashMap = new HashMap();
                hashMap.put(f34534c, this.f34542b.f34527g.a);
                hashMap.put(a, this.f34543k);
                hashMap.put(f34535d, this.l ? "1" : "-1");
                if (this.l) {
                    hashMap.put(f34541j, this.r ? "1" : "-1");
                    hashMap.put(f34537f, this.n ? "1" : "-1");
                }
                if (this.r) {
                    hashMap.put(f34540i, this.o ? "1" : "-1");
                }
                if (this.n) {
                    hashMap.put(f34538g, this.p ? "1" : "-1");
                    hashMap.put(f34536e, this.m ? "1" : "-1");
                }
                hashMap.put(f34539h, this.q);
                return hashMap;
            }
            return (Map) invokeV.objValue;
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable == null || (invokeClinit = classClinitInterceptable.invokeClinit(-365335150, "Lcom/baidu/fsg/face/base/b/e;")) == null) {
            return;
        }
        Interceptable interceptable = invokeClinit.interceptor;
        if (interceptable != null) {
            $ic = interceptable;
        }
        if ((invokeClinit.flags & 1) != 0) {
            classClinitInterceptable.invokePostClinit(-365335150, "Lcom/baidu/fsg/face/base/b/e;");
        }
    }

    public e() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c(c cVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65566, this, cVar) == null) {
            this.f34523c.p = true;
            com.baidu.fsg.face.base.d.d.d(a, "loadFileFromExternal onFailure distributedSdk uri:" + cVar.o.f34520b);
            String str = System.currentTimeMillis() + "";
            long doDownload = ApollonDownloadManager.getInstance(this.f34522b).doDownload(Environment.DIRECTORY_DOWNLOADS, str + "", cVar.o.f34520b, false, false, false, ".zip");
            LogUtil.i(a, "start load engineso file");
            boolean[] zArr = {false};
            if (doDownload != -1) {
                ApollonDownloadManager.getInstance(this.f34522b).registerObserver(this.f34522b, doDownload, new ApollonDownloadManager.DownloadListener(this, doDownload, str, zArr) { // from class: com.baidu.fsg.face.base.b.e.4
                    public static /* synthetic */ Interceptable $ic;
                    public transient /* synthetic */ FieldHolder $fh;
                    public final /* synthetic */ long a;

                    /* renamed from: b  reason: collision with root package name */
                    public final /* synthetic */ String f34530b;

                    /* renamed from: c  reason: collision with root package name */
                    public final /* synthetic */ boolean[] f34531c;

                    /* renamed from: d  reason: collision with root package name */
                    public final /* synthetic */ e f34532d;

                    {
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 != null) {
                            InitContext newInitContext = TitanRuntime.newInitContext();
                            newInitContext.initArgs = r2;
                            Object[] objArr = {this, Long.valueOf(doDownload), str, zArr};
                            interceptable2.invokeUnInit(65536, newInitContext);
                            int i2 = newInitContext.flag;
                            if ((i2 & 1) != 0) {
                                int i3 = i2 & 2;
                                newInitContext.thisArg = this;
                                interceptable2.invokeInitBody(65536, newInitContext);
                                return;
                            }
                        }
                        this.f34532d = this;
                        this.a = doDownload;
                        this.f34530b = str;
                        this.f34531c = zArr;
                    }

                    /* JADX WARN: Removed duplicated region for block: B:46:0x01e6  */
                    /* JADX WARN: Removed duplicated region for block: B:54:0x01f9  */
                    /* JADX WARN: Removed duplicated region for block: B:65:0x01eb A[EXC_TOP_SPLITTER, SYNTHETIC] */
                    /*
                        Code decompiled incorrectly, please refer to instructions dump.
                    */
                    public void onChanged(DownloadItemInfo downloadItemInfo) {
                        FileInputStream fileInputStream;
                        Throwable th;
                        IOException e2;
                        File file;
                        b bVar;
                        StringBuilder sb;
                        Interceptable interceptable2 = $ic;
                        if ((interceptable2 == null || interceptable2.invokeL(1048576, this, downloadItemInfo) == null) && downloadItemInfo.getDownloadState() == 8) {
                            ApollonDownloadManager.getInstance(this.f34532d.f34522b).unregisterObserver(this.f34532d.f34522b, this.a, this);
                            ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
                            try {
                                fileInputStream = new FileInputStream(Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_DOWNLOADS).getAbsolutePath() + "/" + this.f34530b + ".zip");
                                try {
                                    try {
                                        byte[] bArr = new byte[51200];
                                        while (true) {
                                            int read = fileInputStream.read(bArr);
                                            if (read <= 0) {
                                                break;
                                            }
                                            byteArrayOutputStream.write(bArr, 0, read);
                                        }
                                        this.f34532d.a(byteArrayOutputStream.toByteArray());
                                        File file2 = new File(this.f34530b);
                                        if (file2.exists()) {
                                            file2.delete();
                                        }
                                        try {
                                            fileInputStream.close();
                                        } catch (IOException e3) {
                                            e3.printStackTrace();
                                        }
                                    } catch (IOException e4) {
                                        e2 = e4;
                                        e2.printStackTrace();
                                        com.baidu.fsg.face.base.d.d.d(e.a, "distributeFileDownload() onFailure" + e2.toString());
                                        this.f34532d.f34526f.p = true;
                                        com.baidu.fsg.face.base.b.b.a(this.f34532d.f34522b).a(this.f34532d.f34522b, this.f34532d.f34527g.a, this.f34532d.f34526f);
                                        this.f34532d.f34523c.m = false;
                                        this.f34532d.f34523c.q = Log.getStackTraceString(e2);
                                        this.f34532d.f34524d.countDown();
                                        File file3 = new File(this.f34530b);
                                        if (file3.exists()) {
                                            file3.delete();
                                        }
                                        if (fileInputStream != null) {
                                            try {
                                                fileInputStream.close();
                                            } catch (IOException e5) {
                                                e5.printStackTrace();
                                            }
                                        }
                                        if (this.f34531c[0]) {
                                            return;
                                        }
                                        com.baidu.fsg.face.base.d.d.d(e.a, "distributeFileDownload() onFailure" + downloadItemInfo.getDownloadState());
                                        this.f34532d.f34526f.p = true;
                                        com.baidu.fsg.face.base.b.b a2 = com.baidu.fsg.face.base.b.b.a(this.f34532d.f34522b);
                                        e eVar = this.f34532d;
                                        a2.a(eVar.f34522b, eVar.f34527g.a, this.f34532d.f34526f);
                                        this.f34532d.f34523c.m = false;
                                        bVar = this.f34532d.f34523c;
                                        sb = new StringBuilder();
                                        sb.append("distributeFileDownload() onFailure");
                                        sb.append(downloadItemInfo.getDownloadState());
                                        bVar.q = sb.toString();
                                        this.f34532d.f34524d.countDown();
                                    }
                                } catch (Throwable th2) {
                                    th = th2;
                                    file = new File(this.f34530b);
                                    if (file.exists()) {
                                        file.delete();
                                    }
                                    if (fileInputStream != null) {
                                        try {
                                            fileInputStream.close();
                                        } catch (IOException e6) {
                                            e6.printStackTrace();
                                        }
                                    }
                                    if (!this.f34531c[0]) {
                                        com.baidu.fsg.face.base.d.d.d(e.a, "distributeFileDownload() onFailure" + downloadItemInfo.getDownloadState());
                                        this.f34532d.f34526f.p = true;
                                        com.baidu.fsg.face.base.b.b a3 = com.baidu.fsg.face.base.b.b.a(this.f34532d.f34522b);
                                        e eVar2 = this.f34532d;
                                        a3.a(eVar2.f34522b, eVar2.f34527g.a, this.f34532d.f34526f);
                                        this.f34532d.f34523c.m = false;
                                        this.f34532d.f34523c.q = "distributeFileDownload() onFailure" + downloadItemInfo.getDownloadState();
                                        this.f34532d.f34524d.countDown();
                                    }
                                    throw th;
                                }
                            } catch (IOException e7) {
                                fileInputStream = null;
                                e2 = e7;
                            } catch (Throwable th3) {
                                fileInputStream = null;
                                th = th3;
                                file = new File(this.f34530b);
                                if (file.exists()) {
                                }
                                if (fileInputStream != null) {
                                }
                                if (!this.f34531c[0]) {
                                }
                                throw th;
                            }
                            if (this.f34531c[0]) {
                                return;
                            }
                            com.baidu.fsg.face.base.d.d.d(e.a, "distributeFileDownload() onFailure" + downloadItemInfo.getDownloadState());
                            this.f34532d.f34526f.p = true;
                            com.baidu.fsg.face.base.b.b a4 = com.baidu.fsg.face.base.b.b.a(this.f34532d.f34522b);
                            e eVar3 = this.f34532d;
                            a4.a(eVar3.f34522b, eVar3.f34527g.a, this.f34532d.f34526f);
                            this.f34532d.f34523c.m = false;
                            bVar = this.f34532d.f34523c;
                            sb = new StringBuilder();
                            sb.append("distributeFileDownload() onFailure");
                            sb.append(downloadItemInfo.getDownloadState());
                            bVar.q = sb.toString();
                            this.f34532d.f34524d.countDown();
                        }
                    }
                });
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(c cVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65562, this, cVar) == null) {
            a(cVar.o, new a(this, cVar) { // from class: com.baidu.fsg.face.base.b.e.3
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;
                public final /* synthetic */ c a;

                /* renamed from: b  reason: collision with root package name */
                public final /* synthetic */ e f34529b;

                {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {this, cVar};
                        interceptable2.invokeUnInit(65536, newInitContext);
                        int i2 = newInitContext.flag;
                        if ((i2 & 1) != 0) {
                            int i3 = i2 & 2;
                            newInitContext.thisArg = this;
                            interceptable2.invokeInitBody(65536, newInitContext);
                            return;
                        }
                    }
                    this.f34529b = this;
                    this.a = cVar;
                }

                @Override // com.baidu.fsg.face.base.b.e.a
                public void a(c.a aVar, byte[] bArr) {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, aVar, bArr) == null) {
                        e eVar = this.f34529b;
                        Context context = eVar.f34522b;
                        boolean a2 = eVar.a(context, com.baidu.fsg.face.base.b.b.c(context, eVar.f34527g), bArr);
                        if (a2) {
                            this.f34529b.f34523c.p = false;
                            e eVar2 = this.f34529b;
                            String c2 = com.baidu.fsg.face.base.b.b.c(eVar2.f34522b, eVar2.f34527g);
                            e eVar3 = this.f34529b;
                            eVar2.a(c2, com.baidu.fsg.face.base.b.b.a(eVar3.f34522b, eVar3.f34527g));
                            this.a.p = false;
                            com.baidu.fsg.face.base.b.b a3 = com.baidu.fsg.face.base.b.b.a(this.f34529b.f34522b);
                            e eVar4 = this.f34529b;
                            a3.a(eVar4.f34522b, eVar4.f34527g.a, this.a);
                        } else {
                            this.f34529b.c(this.a);
                        }
                        String str = e.a;
                        com.baidu.fsg.face.base.d.d.d(str, "loadFileFromExternal writeFileSuccess:" + a2);
                    }
                }

                @Override // com.baidu.fsg.face.base.b.e.a
                public void a(c.a aVar) {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeL(1048576, this, aVar) == null) {
                        this.f34529b.c(this.a);
                    }
                }
            }, com.baidu.fsg.face.base.b.b.a(this.f34527g));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public byte[] b(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65564, this, str)) == null) {
            try {
                return a(new FileInputStream(new File(str)));
            } catch (IOException e2) {
                com.baidu.fsg.face.base.d.d.d(a, e2);
                return null;
            }
        }
        return (byte[]) invokeL.objValue;
    }

    private byte[] c(String str) throws IOException {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65568, this, str)) == null) ? a(new FileInputStream(new File(Environment.getExternalStorageDirectory(), str))) : (byte[]) invokeL.objValue;
    }

    public void a(Context context, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLI(1048576, this, context, i2) == null) {
            this.f34522b = context;
            this.f34527g = com.baidu.fsg.face.base.b.b.a(i2);
            if ("UpdateSo".equals(a)) {
                a = "UpdateSo-" + this.f34527g.a;
            }
            this.f34523c = new b();
            this.f34524d = new CountDownLatch(1);
            l.a().c(new k(new Runnable(this) { // from class: com.baidu.fsg.face.base.b.e.1
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;
                public final /* synthetic */ e a;

                {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {this};
                        interceptable2.invokeUnInit(65536, newInitContext);
                        int i3 = newInitContext.flag;
                        if ((i3 & 1) != 0) {
                            int i4 = i3 & 2;
                            newInitContext.thisArg = this;
                            interceptable2.invokeInitBody(65536, newInitContext);
                            return;
                        }
                    }
                    this.a = this;
                }

                @Override // java.lang.Runnable
                public void run() {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                        String rimSoDownLoad = BdWalletUtils.getRimSoDownLoad(this.a.f34522b);
                        if (!TextUtils.isEmpty(rimSoDownLoad)) {
                            this.a.a(rimSoDownLoad);
                        }
                        try {
                            this.a.f34524d.await();
                            com.baidu.fsg.face.base.d.d.b(e.a, "begin stat service");
                            this.a.f34523c.b();
                        } catch (InterruptedException e2) {
                            com.baidu.fsg.face.base.d.d.d(e.a, e2);
                        }
                    }
                }
            }));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65548, this, str) == null) {
            l.a().c(new k(new Runnable(this, str) { // from class: com.baidu.fsg.face.base.b.e.2
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;
                public final /* synthetic */ String a;

                /* renamed from: b  reason: collision with root package name */
                public final /* synthetic */ e f34528b;

                {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {this, str};
                        interceptable2.invokeUnInit(65536, newInitContext);
                        int i2 = newInitContext.flag;
                        if ((i2 & 1) != 0) {
                            int i3 = i2 & 2;
                            newInitContext.thisArg = this;
                            interceptable2.invokeInitBody(65536, newInitContext);
                            return;
                        }
                    }
                    this.f34528b = this;
                    this.a = str;
                }

                @Override // java.lang.Runnable
                public void run() {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                        try {
                            this.f34528b.f34525e = c.a(new JSONObject(this.a), this.f34528b.f34527g);
                            this.f34528b.f34526f = com.baidu.fsg.face.base.b.b.a(this.f34528b.f34522b).a(this.f34528b.f34522b, this.f34528b.f34527g.a);
                            if (!TextUtils.isEmpty(this.f34528b.f34526f.n)) {
                                this.f34528b.f34527g.f34504b = this.f34528b.f34527g.f34504b.compareTo(this.f34528b.f34526f.n) < 0 ? this.f34528b.f34526f.n : this.f34528b.f34527g.f34504b;
                            }
                            String str2 = e.a;
                            com.baidu.fsg.face.base.d.d.d(str2, "asyncDistributeConf() newOptions:" + this.f34528b.f34525e.a());
                            String str3 = e.a;
                            com.baidu.fsg.face.base.d.d.d(str3, "asyncDistributeConf() oldOptions:" + this.f34528b.f34526f.a());
                            this.f34528b.f34526f.q = this.f34528b.f34525e.q;
                            this.f34528b.f34526f.r = this.f34528b.f34525e.r;
                            com.baidu.fsg.face.base.b.b.a(this.f34528b.f34522b).a(this.f34528b.f34522b, this.f34528b.f34527g.a, this.f34528b.f34526f);
                            this.f34528b.f34523c.l = true;
                            this.f34528b.f34523c.f34543k = this.f34528b.f34525e.n;
                            if (this.f34528b.f34525e.q && this.f34528b.f34525e.r) {
                                this.f34528b.f34523c.r = true;
                                this.f34528b.a(this.f34528b.f34526f);
                                int i2 = this.f34528b.f34525e.s;
                                this.f34528b.f34525e.s = this.f34528b.f34526f.s;
                                if (!this.f34528b.a(i2, this.f34528b.f34526f)) {
                                    this.f34528b.f34523c.o = false;
                                    this.f34528b.f34523c.n = false;
                                    this.f34528b.f34524d.countDown();
                                    this.f34528b.f34526f.p = true;
                                    com.baidu.fsg.face.base.b.b.a(this.f34528b.f34522b).a(this.f34528b.f34522b, this.f34528b.f34527g.a, this.f34528b.f34526f);
                                    return;
                                }
                                this.f34528b.f34523c.o = true;
                                if (this.f34528b.f34527g.f34504b.compareTo(this.f34528b.f34525e.n) >= 0) {
                                    this.f34528b.f34523c.n = false;
                                    this.f34528b.f34524d.countDown();
                                    this.f34528b.f34526f.p = true;
                                    com.baidu.fsg.face.base.b.b.a(this.f34528b.f34522b).a(this.f34528b.f34522b, this.f34528b.f34527g.a, this.f34528b.f34526f);
                                    return;
                                } else if (this.f34528b.a(this.f34528b.f34525e.o, this.f34528b.f34526f.o)) {
                                    this.f34528b.f34527g.f34504b = this.f34528b.f34525e.n;
                                    this.f34528b.b(this.f34528b.f34525e);
                                    this.f34528b.f34523c.n = true;
                                    return;
                                } else {
                                    this.f34528b.a(this.f34528b.f34525e.o);
                                    this.f34528b.f34523c.n = false;
                                    this.f34528b.f34524d.countDown();
                                    return;
                                }
                            }
                            this.f34528b.f34523c.r = false;
                            this.f34528b.f34523c.n = false;
                            this.f34528b.f34524d.countDown();
                            this.f34528b.f34526f.p = true;
                            com.baidu.fsg.face.base.b.b.a(this.f34528b.f34522b).a(this.f34528b.f34522b, this.f34528b.f34527g.a, this.f34528b.f34526f);
                        } catch (JSONException e2) {
                            com.baidu.fsg.face.base.d.d.d(e.a, e2);
                        }
                    }
                }
            }));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(c cVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65542, this, cVar) == null) {
            if (cVar.o == null) {
                Random random = new Random();
                random.setSeed(System.currentTimeMillis());
                cVar.s = random.nextInt(100);
                com.baidu.fsg.face.base.b.b.a(this.f34522b).a(this.f34522b, this.f34527g.a, cVar);
            }
            String str = a;
            com.baidu.fsg.face.base.d.d.b(str, "current gray = " + cVar.s);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean a(int i2, c cVar) {
        InterceptResult invokeIL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeIL = interceptable.invokeIL(65552, this, i2, cVar)) == null) ? 100 == this.f34525e.s || cVar.s < i2 : invokeIL.booleanValue;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(byte[] bArr) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65551, this, bArr) == null) {
            l.a().c(new k(new Runnable(this, bArr) { // from class: com.baidu.fsg.face.base.b.e.5
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;
                public final /* synthetic */ byte[] a;

                /* renamed from: b  reason: collision with root package name */
                public final /* synthetic */ e f34533b;

                {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {this, bArr};
                        interceptable2.invokeUnInit(65536, newInitContext);
                        int i2 = newInitContext.flag;
                        if ((i2 & 1) != 0) {
                            int i3 = i2 & 2;
                            newInitContext.thisArg = this;
                            interceptable2.invokeInitBody(65536, newInitContext);
                            return;
                        }
                    }
                    this.f34533b = this;
                    this.a = bArr;
                }

                @Override // java.lang.Runnable
                public void run() {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                        try {
                            String str = e.a;
                            com.baidu.fsg.face.base.d.d.d(str, "distributeFileDownload() onSuccess" + this.f34533b.f34525e.o.f34520b + ",:" + com.baidu.fsg.face.base.b.b.c(this.f34533b.f34522b, this.f34533b.f34527g));
                            String md5 = MD5Util.toMd5(this.a, false);
                            String localDecryptProxy = RimArmor.getInstance().localDecryptProxy(this.f34533b.f34525e.o.f34521c);
                            if (localDecryptProxy == null || !localDecryptProxy.equals(md5)) {
                                this.f34533b.f34526f.p = true;
                                com.baidu.fsg.face.base.b.b.a(this.f34533b.f34522b).a(this.f34533b.f34522b, this.f34533b.f34527g.a, this.f34533b.f34526f);
                                this.f34533b.f34523c.m = false;
                                this.f34533b.f34523c.q = "localMd5 is not equals onlineMd5";
                                this.f34533b.f34524d.countDown();
                                return;
                            }
                            if (!this.f34533b.a(this.f34533b.f34522b, com.baidu.fsg.face.base.b.b.c(this.f34533b.f34522b, this.f34533b.f34527g), this.a)) {
                                this.f34533b.f34526f.p = true;
                                com.baidu.fsg.face.base.b.b.a(this.f34533b.f34522b).a(this.f34533b.f34522b, this.f34533b.f34527g.a, this.f34533b.f34526f);
                                this.f34533b.f34523c.m = false;
                                this.f34533b.f34523c.q = "zip file write internal fail";
                                this.f34533b.f34524d.countDown();
                            } else {
                                this.f34533b.a(com.baidu.fsg.face.base.b.b.c(this.f34533b.f34522b, this.f34533b.f34527g), com.baidu.fsg.face.base.b.b.a(this.f34533b.f34522b, this.f34533b.f34527g));
                                this.f34533b.f34525e.p = false;
                                com.baidu.fsg.face.base.b.b.a(this.f34533b.f34522b).a(this.f34533b.f34522b, this.f34533b.f34527g.a, this.f34533b.f34525e);
                            }
                            if (e.a("android.permission.WRITE_EXTERNAL_STORAGE", this.f34533b.f34522b)) {
                                String a2 = com.baidu.fsg.face.base.b.b.a(this.f34533b.f34527g);
                                if (g.b(a2)) {
                                    g.c(a2);
                                }
                                this.f34533b.a(a2, this.a);
                            }
                        } catch (Exception e2) {
                            String str2 = e.a;
                            com.baidu.fsg.face.base.d.d.d(str2, "distributeFileDownload() Exception " + e2.toString());
                            this.f34533b.f34526f.p = true;
                            com.baidu.fsg.face.base.b.b a3 = com.baidu.fsg.face.base.b.b.a(this.f34533b.f34522b);
                            e eVar = this.f34533b;
                            a3.a(eVar.f34522b, eVar.f34527g.a, this.f34533b.f34526f);
                            this.f34533b.f34523c.m = false;
                            this.f34533b.f34523c.q = Log.getStackTraceString(e2);
                            this.f34533b.f34524d.countDown();
                        }
                    }
                }
            }));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(c.a aVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TRACKBALL, this, aVar) == null) {
            a(aVar, new a(this) { // from class: com.baidu.fsg.face.base.b.e.6
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;
                public final /* synthetic */ e a;

                {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {this};
                        interceptable2.invokeUnInit(65536, newInitContext);
                        int i2 = newInitContext.flag;
                        if ((i2 & 1) != 0) {
                            int i3 = i2 & 2;
                            newInitContext.thisArg = this;
                            interceptable2.invokeInitBody(65536, newInitContext);
                            return;
                        }
                    }
                    this.a = this;
                }

                @Override // com.baidu.fsg.face.base.b.e.a
                public void a(c.a aVar2, byte[] bArr) {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, aVar2, bArr) == null) {
                        com.baidu.fsg.face.base.d.d.d(e.a, "copyInternalFileToExternal(), loadFileFromExternal distributed success");
                    }
                }

                @Override // com.baidu.fsg.face.base.b.e.a
                public void a(c.a aVar2) {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeL(1048576, this, aVar2) == null) {
                        e eVar = this.a;
                        String c2 = com.baidu.fsg.face.base.b.b.c(eVar.f34522b, eVar.f34527g);
                        String a2 = com.baidu.fsg.face.base.b.b.a(this.a.f34527g);
                        String str = e.a;
                        com.baidu.fsg.face.base.d.d.d(str, "asyncDistributeConf(), loadFileFromExternal failure internalFile:" + c2);
                        if (g.b(c2)) {
                            byte[] b2 = this.a.b(c2);
                            if (e.a("android.permission.WRITE_EXTERNAL_STORAGE", this.a.f34522b)) {
                                if (g.b(a2)) {
                                    g.c(a2);
                                }
                                this.a.a(a2, b2);
                            }
                        }
                    }
                }
            }, com.baidu.fsg.face.base.b.b.a(this.f34527g));
        }
    }

    private void a(c.a aVar, a aVar2, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(65541, this, aVar, aVar2, str) == null) {
            if (aVar2 != null) {
                try {
                    if ("mounted".equals(Environment.getExternalStorageState()) && new File(Environment.getExternalStorageDirectory(), str).exists()) {
                        byte[] c2 = c(str);
                        String md5 = MD5Util.toMd5(c2, false);
                        String localDecryptProxy = RimArmor.getInstance().localDecryptProxy(aVar.f34521c);
                        if (localDecryptProxy != null && localDecryptProxy.equals(md5)) {
                            aVar2.a(aVar, c2);
                        } else {
                            aVar2.a(aVar);
                        }
                    } else {
                        aVar2.a(aVar);
                    }
                    return;
                } catch (Throwable th) {
                    String str2 = a;
                    com.baidu.fsg.face.base.d.d.d(str2, "loadFileFromExternal() Throwable" + th.toString());
                    aVar2.a(aVar);
                    return;
                }
            }
            throw new IllegalArgumentException(a.class.getName() + "can't be null");
        }
    }

    private byte[] a(InputStream inputStream) throws IOException {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65559, this, inputStream)) == null) {
            try {
                byte[] bArr = new byte[inputStream.available()];
                inputStream.read(bArr);
                return bArr;
            } finally {
                inputStream.close();
            }
        }
        return (byte[]) invokeL.objValue;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean a(Context context, String str, byte[] bArr) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(65553, this, context, str, bArr)) == null) {
            if (g.b(str)) {
                g.c(str);
            }
            File file = new File(str);
            try {
                return g.b(file) && g.a(file, bArr);
            } catch (IOException e2) {
                com.baidu.fsg.face.base.d.d.d(a, e2);
                return false;
            }
        }
        return invokeLLL.booleanValue;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(String str, byte[] bArr) {
        Interceptable interceptable = $ic;
        if (interceptable != null && interceptable.invokeLL(65550, this, str, bArr) != null) {
            return;
        }
        FileOutputStream fileOutputStream = null;
        try {
            if ("mounted".equals(Environment.getExternalStorageState())) {
                File file = new File(Environment.getExternalStorageDirectory(), str);
                if (!file.getParentFile().exists()) {
                    file.getParentFile().mkdirs();
                }
                if (!file.exists()) {
                    file.createNewFile();
                }
                FileOutputStream fileOutputStream2 = new FileOutputStream(file);
                try {
                    fileOutputStream2.write(bArr);
                    fileOutputStream = fileOutputStream2;
                } catch (Throwable th) {
                    fileOutputStream = fileOutputStream2;
                    th = th;
                    try {
                        com.baidu.fsg.face.base.d.d.d(a, th);
                        if (fileOutputStream != null) {
                            try {
                                fileOutputStream.close();
                                return;
                            } catch (Throwable th2) {
                                com.baidu.fsg.face.base.d.d.d(a, th2);
                                return;
                            }
                        }
                        return;
                    } catch (Throwable th3) {
                        if (fileOutputStream != null) {
                            try {
                                fileOutputStream.close();
                            } catch (Throwable th4) {
                                com.baidu.fsg.face.base.d.d.d(a, th4);
                            }
                        }
                        throw th3;
                    }
                }
            }
            if (fileOutputStream != null) {
                try {
                    fileOutputStream.close();
                } catch (Throwable th5) {
                    com.baidu.fsg.face.base.d.d.d(a, th5);
                }
            }
        } catch (Throwable th6) {
            th = th6;
        }
    }

    @TargetApi(23)
    public static boolean a(String str, Context context) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65558, null, str, context)) == null) {
            if (Build.VERSION.SDK_INT < 23 || context.checkSelfPermission(str) != 0) {
                return Build.VERSION.SDK_INT < 23 && context.checkCallingOrSelfPermission(str) == 0;
            }
            return true;
        }
        return invokeLL.booleanValue;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean a(c.a aVar, c.a aVar2) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLL = interceptable.invokeLL(65554, this, aVar, aVar2)) == null) ? aVar2 == null || aVar == null || TextUtils.isEmpty(aVar2.f34521c) || !aVar.f34521c.equals(aVar2.f34521c) : invokeLL.booleanValue;
    }

    /* JADX DEBUG: Failed to insert an additional move for type inference into block B:31:0x0161 */
    /* JADX DEBUG: Failed to insert an additional move for type inference into block B:33:0x0163 */
    /* JADX DEBUG: Failed to insert an additional move for type inference into block B:86:0x0096 */
    /* JADX DEBUG: Failed to insert an additional move for type inference into block B:87:0x0066 */
    /* JADX DEBUG: Failed to insert an additional move for type inference into block B:90:0x0066 */
    /* JADX DEBUG: Multi-variable search result rejected for r1v12, resolved type: java.io.BufferedOutputStream */
    /* JADX DEBUG: Multi-variable search result rejected for r1v13, resolved type: java.io.BufferedOutputStream */
    /* JADX DEBUG: Multi-variable search result rejected for r1v14, resolved type: java.io.BufferedOutputStream */
    /* JADX DEBUG: Multi-variable search result rejected for r1v9, resolved type: java.io.BufferedOutputStream */
    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r1v15 */
    /* JADX WARN: Type inference failed for: r1v19 */
    public void a(String str, String str2) {
        byte[] bArr;
        String name;
        Interceptable interceptable = $ic;
        if (interceptable != null && interceptable.invokeLL(65549, this, str, str2) != null) {
            return;
        }
        this.f34523c.m = true;
        this.f34524d.countDown();
        com.baidu.fsg.face.base.d.d.b(a, "thread name unZipApkSoToLibDir = " + Thread.currentThread().getName());
        com.baidu.fsg.face.base.d.d.a(a, "unZipApkSoToLibDir(), zipFilePath:" + str + ",libDir:" + str2);
        BufferedOutputStream bufferedOutputStream = 0;
        try {
            try {
                ZipInputStream zipInputStream = new ZipInputStream(new BufferedInputStream(new FileInputStream(str)));
                while (true) {
                    try {
                        ZipEntry nextEntry = zipInputStream.getNextEntry();
                        if (nextEntry != null) {
                            try {
                                try {
                                    bArr = new byte[4096];
                                    name = nextEntry.getName();
                                    com.baidu.fsg.face.base.d.d.d(a, "unZipApkSoToLibDir() entryName," + name);
                                } catch (Throwable th) {
                                    th = th;
                                }
                            } catch (Exception e2) {
                                e = e2;
                            }
                            if (name.endsWith(".so")) {
                                int lastIndexOf = name.lastIndexOf("_");
                                String str3 = name.substring(name.lastIndexOf("/") + 1, lastIndexOf) + ".so";
                                com.baidu.fsg.face.base.d.d.a(a, "unZipApkSoToLibDir(),fileName2:" + str3);
                                File file = new File(str2 + File.separator + str3);
                                if (file.exists()) {
                                    file.delete();
                                }
                                File file2 = new File(file.getParent());
                                com.baidu.fsg.face.base.d.d.a(a, "unZipApkSoToLibDir()entryFile" + file.toString() + "entryDir" + file2.toString());
                                if (!file2.exists()) {
                                    com.baidu.fsg.face.base.d.d.a(a, "unZipApkSoToLibDir() not exists");
                                    file2.mkdirs();
                                }
                                BufferedOutputStream bufferedOutputStream2 = new BufferedOutputStream(new FileOutputStream(file), 4096);
                                while (true) {
                                    try {
                                        int read = zipInputStream.read(bArr, 0, 4096);
                                        if (read == -1) {
                                            break;
                                        }
                                        bufferedOutputStream2.write(bArr, 0, read);
                                    } catch (Exception e3) {
                                        e = e3;
                                        bufferedOutputStream = bufferedOutputStream2;
                                        e.printStackTrace();
                                        if (bufferedOutputStream != 0) {
                                            bufferedOutputStream.close();
                                        }
                                    } catch (Throwable th2) {
                                        th = th2;
                                        bufferedOutputStream = bufferedOutputStream2;
                                        if (bufferedOutputStream != 0) {
                                            bufferedOutputStream.close();
                                        }
                                        throw th;
                                    }
                                }
                                bufferedOutputStream2.flush();
                                bufferedOutputStream2.close();
                                bufferedOutputStream = bufferedOutputStream2;
                            } else if (bufferedOutputStream != 0) {
                                bufferedOutputStream.close();
                            }
                        } else {
                            try {
                                zipInputStream.close();
                                return;
                            } catch (IOException e4) {
                                com.baidu.fsg.face.base.d.d.d(a, e4);
                                return;
                            }
                        }
                    } catch (Exception e5) {
                        e = e5;
                        bufferedOutputStream = zipInputStream;
                        com.baidu.fsg.face.base.d.d.d(a, e);
                        if (bufferedOutputStream != null) {
                            try {
                                bufferedOutputStream.close();
                                return;
                            } catch (IOException e6) {
                                com.baidu.fsg.face.base.d.d.d(a, e6);
                                return;
                            }
                        }
                        return;
                    } catch (Throwable th3) {
                        th = th3;
                        bufferedOutputStream = zipInputStream;
                        if (bufferedOutputStream != null) {
                            try {
                                bufferedOutputStream.close();
                            } catch (IOException e7) {
                                com.baidu.fsg.face.base.d.d.d(a, e7);
                            }
                        }
                        throw th;
                    }
                }
            } catch (Throwable th4) {
                th = th4;
            }
        } catch (Exception e8) {
            e = e8;
        }
    }
}
