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
import com.baidu.mobads.container.util.AdIconUtil;
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
/* loaded from: classes5.dex */
public class e {
    public static /* synthetic */ Interceptable $ic = null;

    /* renamed from: a  reason: collision with root package name */
    public static String f39579a = "UpdateSo";
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: b  reason: collision with root package name */
    public Context f39580b;

    /* renamed from: c  reason: collision with root package name */
    public b f39581c;

    /* renamed from: d  reason: collision with root package name */
    public CountDownLatch f39582d;

    /* renamed from: e  reason: collision with root package name */
    public c f39583e;

    /* renamed from: f  reason: collision with root package name */
    public c f39584f;

    /* renamed from: g  reason: collision with root package name */
    public b.a f39585g;

    /* loaded from: classes5.dex */
    public interface a {
        void a(c.a aVar);

        void a(c.a aVar, byte[] bArr);
    }

    /* loaded from: classes5.dex */
    public class b {
        public static /* synthetic */ Interceptable $ic = null;

        /* renamed from: a  reason: collision with root package name */
        public static final String f39598a = "dl_so_zip_version";

        /* renamed from: c  reason: collision with root package name */
        public static final String f39599c = "dl_so_modle_name";

        /* renamed from: d  reason: collision with root package name */
        public static final String f39600d = "dl_so_get_config_success";

        /* renamed from: e  reason: collision with root package name */
        public static final String f39601e = "dl_so_zip_file_success";

        /* renamed from: f  reason: collision with root package name */
        public static final String f39602f = "dl_so_need_update";

        /* renamed from: g  reason: collision with root package name */
        public static final String f39603g = "dl_so_update_from_net";

        /* renamed from: h  reason: collision with root package name */
        public static final String f39604h = "dl_so_exception_info";

        /* renamed from: i  reason: collision with root package name */
        public static final String f39605i = "dl_so_meet_gray";

        /* renamed from: j  reason: collision with root package name */
        public static final String f39606j = "dl_so_zip_enable";
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ e f39607b;
        public String k;
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
            this.f39607b = eVar;
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
                hashMap.put(f39599c, this.f39607b.f39585g.f39559a);
                hashMap.put(f39598a, this.k);
                hashMap.put(f39600d, this.l ? "1" : "-1");
                if (this.l) {
                    hashMap.put(f39606j, this.r ? "1" : "-1");
                    hashMap.put(f39602f, this.n ? "1" : "-1");
                }
                if (this.r) {
                    hashMap.put(f39605i, this.o ? "1" : "-1");
                }
                if (this.n) {
                    hashMap.put(f39603g, this.p ? "1" : "-1");
                    hashMap.put(f39601e, this.m ? "1" : "-1");
                }
                hashMap.put(f39604h, this.q);
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
            this.f39581c.p = true;
            com.baidu.fsg.face.base.d.d.d(f39579a, "loadFileFromExternal onFailure distributedSdk uri:" + cVar.o.f39577b);
            String str = System.currentTimeMillis() + "";
            long doDownload = ApollonDownloadManager.getInstance(this.f39580b).doDownload(Environment.DIRECTORY_DOWNLOADS, str + "", cVar.o.f39577b, false, false, false, ".zip");
            LogUtil.i(f39579a, "start load engineso file");
            boolean[] zArr = {false};
            if (doDownload != -1) {
                ApollonDownloadManager.getInstance(this.f39580b).registerObserver(this.f39580b, doDownload, new ApollonDownloadManager.DownloadListener(this, doDownload, str, zArr) { // from class: com.baidu.fsg.face.base.b.e.4
                    public static /* synthetic */ Interceptable $ic;
                    public transient /* synthetic */ FieldHolder $fh;

                    /* renamed from: a  reason: collision with root package name */
                    public final /* synthetic */ long f39591a;

                    /* renamed from: b  reason: collision with root package name */
                    public final /* synthetic */ String f39592b;

                    /* renamed from: c  reason: collision with root package name */
                    public final /* synthetic */ boolean[] f39593c;

                    /* renamed from: d  reason: collision with root package name */
                    public final /* synthetic */ e f39594d;

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
                        this.f39594d = this;
                        this.f39591a = doDownload;
                        this.f39592b = str;
                        this.f39593c = zArr;
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
                            ApollonDownloadManager.getInstance(this.f39594d.f39580b).unregisterObserver(this.f39594d.f39580b, this.f39591a, this);
                            ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
                            try {
                                fileInputStream = new FileInputStream(Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_DOWNLOADS).getAbsolutePath() + "/" + this.f39592b + ".zip");
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
                                        this.f39594d.a(byteArrayOutputStream.toByteArray());
                                        File file2 = new File(this.f39592b);
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
                                        com.baidu.fsg.face.base.d.d.d(e.f39579a, "distributeFileDownload() onFailure" + e2.toString());
                                        this.f39594d.f39584f.p = true;
                                        com.baidu.fsg.face.base.b.b.a(this.f39594d.f39580b).a(this.f39594d.f39580b, this.f39594d.f39585g.f39559a, this.f39594d.f39584f);
                                        this.f39594d.f39581c.m = false;
                                        this.f39594d.f39581c.q = Log.getStackTraceString(e2);
                                        this.f39594d.f39582d.countDown();
                                        File file3 = new File(this.f39592b);
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
                                        if (this.f39593c[0]) {
                                            return;
                                        }
                                        com.baidu.fsg.face.base.d.d.d(e.f39579a, "distributeFileDownload() onFailure" + downloadItemInfo.getDownloadState());
                                        this.f39594d.f39584f.p = true;
                                        com.baidu.fsg.face.base.b.b a2 = com.baidu.fsg.face.base.b.b.a(this.f39594d.f39580b);
                                        e eVar = this.f39594d;
                                        a2.a(eVar.f39580b, eVar.f39585g.f39559a, this.f39594d.f39584f);
                                        this.f39594d.f39581c.m = false;
                                        bVar = this.f39594d.f39581c;
                                        sb = new StringBuilder();
                                        sb.append("distributeFileDownload() onFailure");
                                        sb.append(downloadItemInfo.getDownloadState());
                                        bVar.q = sb.toString();
                                        this.f39594d.f39582d.countDown();
                                    }
                                } catch (Throwable th2) {
                                    th = th2;
                                    file = new File(this.f39592b);
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
                                    if (!this.f39593c[0]) {
                                        com.baidu.fsg.face.base.d.d.d(e.f39579a, "distributeFileDownload() onFailure" + downloadItemInfo.getDownloadState());
                                        this.f39594d.f39584f.p = true;
                                        com.baidu.fsg.face.base.b.b a3 = com.baidu.fsg.face.base.b.b.a(this.f39594d.f39580b);
                                        e eVar2 = this.f39594d;
                                        a3.a(eVar2.f39580b, eVar2.f39585g.f39559a, this.f39594d.f39584f);
                                        this.f39594d.f39581c.m = false;
                                        this.f39594d.f39581c.q = "distributeFileDownload() onFailure" + downloadItemInfo.getDownloadState();
                                        this.f39594d.f39582d.countDown();
                                    }
                                    throw th;
                                }
                            } catch (IOException e7) {
                                fileInputStream = null;
                                e2 = e7;
                            } catch (Throwable th3) {
                                fileInputStream = null;
                                th = th3;
                                file = new File(this.f39592b);
                                if (file.exists()) {
                                }
                                if (fileInputStream != null) {
                                }
                                if (!this.f39593c[0]) {
                                }
                                throw th;
                            }
                            if (this.f39593c[0]) {
                                return;
                            }
                            com.baidu.fsg.face.base.d.d.d(e.f39579a, "distributeFileDownload() onFailure" + downloadItemInfo.getDownloadState());
                            this.f39594d.f39584f.p = true;
                            com.baidu.fsg.face.base.b.b a4 = com.baidu.fsg.face.base.b.b.a(this.f39594d.f39580b);
                            e eVar3 = this.f39594d;
                            a4.a(eVar3.f39580b, eVar3.f39585g.f39559a, this.f39594d.f39584f);
                            this.f39594d.f39581c.m = false;
                            bVar = this.f39594d.f39581c;
                            sb = new StringBuilder();
                            sb.append("distributeFileDownload() onFailure");
                            sb.append(downloadItemInfo.getDownloadState());
                            bVar.q = sb.toString();
                            this.f39594d.f39582d.countDown();
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

                /* renamed from: a  reason: collision with root package name */
                public final /* synthetic */ c f39589a;

                /* renamed from: b  reason: collision with root package name */
                public final /* synthetic */ e f39590b;

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
                    this.f39590b = this;
                    this.f39589a = cVar;
                }

                @Override // com.baidu.fsg.face.base.b.e.a
                public void a(c.a aVar, byte[] bArr) {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, aVar, bArr) == null) {
                        e eVar = this.f39590b;
                        Context context = eVar.f39580b;
                        boolean a2 = eVar.a(context, com.baidu.fsg.face.base.b.b.c(context, eVar.f39585g), bArr);
                        if (a2) {
                            this.f39590b.f39581c.p = false;
                            e eVar2 = this.f39590b;
                            String c2 = com.baidu.fsg.face.base.b.b.c(eVar2.f39580b, eVar2.f39585g);
                            e eVar3 = this.f39590b;
                            eVar2.a(c2, com.baidu.fsg.face.base.b.b.a(eVar3.f39580b, eVar3.f39585g));
                            this.f39589a.p = false;
                            com.baidu.fsg.face.base.b.b a3 = com.baidu.fsg.face.base.b.b.a(this.f39590b.f39580b);
                            e eVar4 = this.f39590b;
                            a3.a(eVar4.f39580b, eVar4.f39585g.f39559a, this.f39589a);
                        } else {
                            this.f39590b.c(this.f39589a);
                        }
                        String str = e.f39579a;
                        com.baidu.fsg.face.base.d.d.d(str, "loadFileFromExternal writeFileSuccess:" + a2);
                    }
                }

                @Override // com.baidu.fsg.face.base.b.e.a
                public void a(c.a aVar) {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeL(1048576, this, aVar) == null) {
                        this.f39590b.c(this.f39589a);
                    }
                }
            }, com.baidu.fsg.face.base.b.b.a(this.f39585g));
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
                com.baidu.fsg.face.base.d.d.d(f39579a, e2);
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
            this.f39580b = context;
            this.f39585g = com.baidu.fsg.face.base.b.b.a(i2);
            if ("UpdateSo".equals(f39579a)) {
                f39579a = "UpdateSo-" + this.f39585g.f39559a;
            }
            this.f39581c = new b();
            this.f39582d = new CountDownLatch(1);
            l.a().c(new k(new Runnable(this) { // from class: com.baidu.fsg.face.base.b.e.1
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;

                /* renamed from: a  reason: collision with root package name */
                public final /* synthetic */ e f39586a;

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
                    this.f39586a = this;
                }

                @Override // java.lang.Runnable
                public void run() {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                        String rimSoDownLoad = BdWalletUtils.getRimSoDownLoad(this.f39586a.f39580b);
                        if (!TextUtils.isEmpty(rimSoDownLoad)) {
                            this.f39586a.a(rimSoDownLoad);
                        }
                        try {
                            this.f39586a.f39582d.await();
                            com.baidu.fsg.face.base.d.d.b(e.f39579a, "begin stat service");
                            this.f39586a.f39581c.b();
                        } catch (InterruptedException e2) {
                            com.baidu.fsg.face.base.d.d.d(e.f39579a, e2);
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

                /* renamed from: a  reason: collision with root package name */
                public final /* synthetic */ String f39587a;

                /* renamed from: b  reason: collision with root package name */
                public final /* synthetic */ e f39588b;

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
                    this.f39588b = this;
                    this.f39587a = str;
                }

                @Override // java.lang.Runnable
                public void run() {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                        try {
                            this.f39588b.f39583e = c.a(new JSONObject(this.f39587a), this.f39588b.f39585g);
                            this.f39588b.f39584f = com.baidu.fsg.face.base.b.b.a(this.f39588b.f39580b).a(this.f39588b.f39580b, this.f39588b.f39585g.f39559a);
                            if (!TextUtils.isEmpty(this.f39588b.f39584f.n)) {
                                this.f39588b.f39585g.f39560b = this.f39588b.f39585g.f39560b.compareTo(this.f39588b.f39584f.n) < 0 ? this.f39588b.f39584f.n : this.f39588b.f39585g.f39560b;
                            }
                            String str2 = e.f39579a;
                            com.baidu.fsg.face.base.d.d.d(str2, "asyncDistributeConf() newOptions:" + this.f39588b.f39583e.a());
                            String str3 = e.f39579a;
                            com.baidu.fsg.face.base.d.d.d(str3, "asyncDistributeConf() oldOptions:" + this.f39588b.f39584f.a());
                            this.f39588b.f39584f.q = this.f39588b.f39583e.q;
                            this.f39588b.f39584f.r = this.f39588b.f39583e.r;
                            com.baidu.fsg.face.base.b.b.a(this.f39588b.f39580b).a(this.f39588b.f39580b, this.f39588b.f39585g.f39559a, this.f39588b.f39584f);
                            this.f39588b.f39581c.l = true;
                            this.f39588b.f39581c.k = this.f39588b.f39583e.n;
                            if (this.f39588b.f39583e.q && this.f39588b.f39583e.r) {
                                this.f39588b.f39581c.r = true;
                                this.f39588b.a(this.f39588b.f39584f);
                                int i2 = this.f39588b.f39583e.s;
                                this.f39588b.f39583e.s = this.f39588b.f39584f.s;
                                if (!this.f39588b.a(i2, this.f39588b.f39584f)) {
                                    this.f39588b.f39581c.o = false;
                                    this.f39588b.f39581c.n = false;
                                    this.f39588b.f39582d.countDown();
                                    this.f39588b.f39584f.p = true;
                                    com.baidu.fsg.face.base.b.b.a(this.f39588b.f39580b).a(this.f39588b.f39580b, this.f39588b.f39585g.f39559a, this.f39588b.f39584f);
                                    return;
                                }
                                this.f39588b.f39581c.o = true;
                                if (this.f39588b.f39585g.f39560b.compareTo(this.f39588b.f39583e.n) >= 0) {
                                    this.f39588b.f39581c.n = false;
                                    this.f39588b.f39582d.countDown();
                                    this.f39588b.f39584f.p = true;
                                    com.baidu.fsg.face.base.b.b.a(this.f39588b.f39580b).a(this.f39588b.f39580b, this.f39588b.f39585g.f39559a, this.f39588b.f39584f);
                                    return;
                                } else if (this.f39588b.a(this.f39588b.f39583e.o, this.f39588b.f39584f.o)) {
                                    this.f39588b.f39585g.f39560b = this.f39588b.f39583e.n;
                                    this.f39588b.b(this.f39588b.f39583e);
                                    this.f39588b.f39581c.n = true;
                                    return;
                                } else {
                                    this.f39588b.a(this.f39588b.f39583e.o);
                                    this.f39588b.f39581c.n = false;
                                    this.f39588b.f39582d.countDown();
                                    return;
                                }
                            }
                            this.f39588b.f39581c.r = false;
                            this.f39588b.f39581c.n = false;
                            this.f39588b.f39582d.countDown();
                            this.f39588b.f39584f.p = true;
                            com.baidu.fsg.face.base.b.b.a(this.f39588b.f39580b).a(this.f39588b.f39580b, this.f39588b.f39585g.f39559a, this.f39588b.f39584f);
                        } catch (JSONException e2) {
                            com.baidu.fsg.face.base.d.d.d(e.f39579a, e2);
                        }
                    }
                }
            }));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(c cVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(AdIconUtil.BAIDU_LOGO_ID, this, cVar) == null) {
            if (cVar.o == null) {
                Random random = new Random();
                random.setSeed(System.currentTimeMillis());
                cVar.s = random.nextInt(100);
                com.baidu.fsg.face.base.b.b.a(this.f39580b).a(this.f39580b, this.f39585g.f39559a, cVar);
            }
            String str = f39579a;
            com.baidu.fsg.face.base.d.d.b(str, "current gray = " + cVar.s);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean a(int i2, c cVar) {
        InterceptResult invokeIL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeIL = interceptable.invokeIL(65552, this, i2, cVar)) == null) ? 100 == this.f39583e.s || cVar.s < i2 : invokeIL.booleanValue;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(byte[] bArr) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65551, this, bArr) == null) {
            l.a().c(new k(new Runnable(this, bArr) { // from class: com.baidu.fsg.face.base.b.e.5
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;

                /* renamed from: a  reason: collision with root package name */
                public final /* synthetic */ byte[] f39595a;

                /* renamed from: b  reason: collision with root package name */
                public final /* synthetic */ e f39596b;

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
                    this.f39596b = this;
                    this.f39595a = bArr;
                }

                @Override // java.lang.Runnable
                public void run() {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                        try {
                            String str = e.f39579a;
                            com.baidu.fsg.face.base.d.d.d(str, "distributeFileDownload() onSuccess" + this.f39596b.f39583e.o.f39577b + ",:" + com.baidu.fsg.face.base.b.b.c(this.f39596b.f39580b, this.f39596b.f39585g));
                            String md5 = MD5Util.toMd5(this.f39595a, false);
                            String localDecryptProxy = RimArmor.getInstance().localDecryptProxy(this.f39596b.f39583e.o.f39578c);
                            if (localDecryptProxy == null || !localDecryptProxy.equals(md5)) {
                                this.f39596b.f39584f.p = true;
                                com.baidu.fsg.face.base.b.b.a(this.f39596b.f39580b).a(this.f39596b.f39580b, this.f39596b.f39585g.f39559a, this.f39596b.f39584f);
                                this.f39596b.f39581c.m = false;
                                this.f39596b.f39581c.q = "localMd5 is not equals onlineMd5";
                                this.f39596b.f39582d.countDown();
                                return;
                            }
                            if (!this.f39596b.a(this.f39596b.f39580b, com.baidu.fsg.face.base.b.b.c(this.f39596b.f39580b, this.f39596b.f39585g), this.f39595a)) {
                                this.f39596b.f39584f.p = true;
                                com.baidu.fsg.face.base.b.b.a(this.f39596b.f39580b).a(this.f39596b.f39580b, this.f39596b.f39585g.f39559a, this.f39596b.f39584f);
                                this.f39596b.f39581c.m = false;
                                this.f39596b.f39581c.q = "zip file write internal fail";
                                this.f39596b.f39582d.countDown();
                            } else {
                                this.f39596b.a(com.baidu.fsg.face.base.b.b.c(this.f39596b.f39580b, this.f39596b.f39585g), com.baidu.fsg.face.base.b.b.a(this.f39596b.f39580b, this.f39596b.f39585g));
                                this.f39596b.f39583e.p = false;
                                com.baidu.fsg.face.base.b.b.a(this.f39596b.f39580b).a(this.f39596b.f39580b, this.f39596b.f39585g.f39559a, this.f39596b.f39583e);
                            }
                            if (e.a("android.permission.WRITE_EXTERNAL_STORAGE", this.f39596b.f39580b)) {
                                String a2 = com.baidu.fsg.face.base.b.b.a(this.f39596b.f39585g);
                                if (g.a(a2)) {
                                    g.b(a2);
                                }
                                this.f39596b.a(a2, this.f39595a);
                            }
                        } catch (Exception e2) {
                            String str2 = e.f39579a;
                            com.baidu.fsg.face.base.d.d.d(str2, "distributeFileDownload() Exception " + e2.toString());
                            this.f39596b.f39584f.p = true;
                            com.baidu.fsg.face.base.b.b a3 = com.baidu.fsg.face.base.b.b.a(this.f39596b.f39580b);
                            e eVar = this.f39596b;
                            a3.a(eVar.f39580b, eVar.f39585g.f39559a, this.f39596b.f39584f);
                            this.f39596b.f39581c.m = false;
                            this.f39596b.f39581c.q = Log.getStackTraceString(e2);
                            this.f39596b.f39582d.countDown();
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

                /* renamed from: a  reason: collision with root package name */
                public final /* synthetic */ e f39597a;

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
                    this.f39597a = this;
                }

                @Override // com.baidu.fsg.face.base.b.e.a
                public void a(c.a aVar2, byte[] bArr) {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, aVar2, bArr) == null) {
                        com.baidu.fsg.face.base.d.d.d(e.f39579a, "copyInternalFileToExternal(), loadFileFromExternal distributed success");
                    }
                }

                @Override // com.baidu.fsg.face.base.b.e.a
                public void a(c.a aVar2) {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeL(1048576, this, aVar2) == null) {
                        e eVar = this.f39597a;
                        String c2 = com.baidu.fsg.face.base.b.b.c(eVar.f39580b, eVar.f39585g);
                        String a2 = com.baidu.fsg.face.base.b.b.a(this.f39597a.f39585g);
                        String str = e.f39579a;
                        com.baidu.fsg.face.base.d.d.d(str, "asyncDistributeConf(), loadFileFromExternal failure internalFile:" + c2);
                        if (g.a(c2)) {
                            byte[] b2 = this.f39597a.b(c2);
                            if (e.a("android.permission.WRITE_EXTERNAL_STORAGE", this.f39597a.f39580b)) {
                                if (g.a(a2)) {
                                    g.b(a2);
                                }
                                this.f39597a.a(a2, b2);
                            }
                        }
                    }
                }
            }, com.baidu.fsg.face.base.b.b.a(this.f39585g));
        }
    }

    private void a(c.a aVar, a aVar2, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(AdIconUtil.AD_TEXT_ID, this, aVar, aVar2, str) == null) {
            if (aVar2 != null) {
                try {
                    if ("mounted".equals(Environment.getExternalStorageState()) && new File(Environment.getExternalStorageDirectory(), str).exists()) {
                        byte[] c2 = c(str);
                        String md5 = MD5Util.toMd5(c2, false);
                        String localDecryptProxy = RimArmor.getInstance().localDecryptProxy(aVar.f39578c);
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
                    String str2 = f39579a;
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
            if (g.a(str)) {
                g.b(str);
            }
            File file = new File(str);
            try {
                return g.b(file) && g.a(file, bArr);
            } catch (IOException e2) {
                com.baidu.fsg.face.base.d.d.d(f39579a, e2);
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
                        com.baidu.fsg.face.base.d.d.d(f39579a, th);
                        if (fileOutputStream != null) {
                            try {
                                fileOutputStream.close();
                                return;
                            } catch (Throwable th2) {
                                com.baidu.fsg.face.base.d.d.d(f39579a, th2);
                                return;
                            }
                        }
                        return;
                    } catch (Throwable th3) {
                        if (fileOutputStream != null) {
                            try {
                                fileOutputStream.close();
                            } catch (Throwable th4) {
                                com.baidu.fsg.face.base.d.d.d(f39579a, th4);
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
                    com.baidu.fsg.face.base.d.d.d(f39579a, th5);
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
        return (interceptable == null || (invokeLL = interceptable.invokeLL(65554, this, aVar, aVar2)) == null) ? aVar2 == null || aVar == null || TextUtils.isEmpty(aVar2.f39578c) || !aVar.f39578c.equals(aVar2.f39578c) : invokeLL.booleanValue;
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
        this.f39581c.m = true;
        this.f39582d.countDown();
        com.baidu.fsg.face.base.d.d.b(f39579a, "thread name unZipApkSoToLibDir = " + Thread.currentThread().getName());
        com.baidu.fsg.face.base.d.d.a(f39579a, "unZipApkSoToLibDir(), zipFilePath:" + str + ",libDir:" + str2);
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
                                    com.baidu.fsg.face.base.d.d.d(f39579a, "unZipApkSoToLibDir() entryName," + name);
                                } catch (Throwable th) {
                                    th = th;
                                }
                            } catch (Exception e2) {
                                e = e2;
                            }
                            if (name.endsWith(".so")) {
                                int lastIndexOf = name.lastIndexOf("_");
                                String str3 = name.substring(name.lastIndexOf("/") + 1, lastIndexOf) + ".so";
                                com.baidu.fsg.face.base.d.d.a(f39579a, "unZipApkSoToLibDir(),fileName2:" + str3);
                                File file = new File(str2 + File.separator + str3);
                                if (file.exists()) {
                                    file.delete();
                                }
                                File file2 = new File(file.getParent());
                                com.baidu.fsg.face.base.d.d.a(f39579a, "unZipApkSoToLibDir()entryFile" + file.toString() + "entryDir" + file2.toString());
                                if (!file2.exists()) {
                                    com.baidu.fsg.face.base.d.d.a(f39579a, "unZipApkSoToLibDir() not exists");
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
                                com.baidu.fsg.face.base.d.d.d(f39579a, e4);
                                return;
                            }
                        }
                    } catch (Exception e5) {
                        e = e5;
                        bufferedOutputStream = zipInputStream;
                        com.baidu.fsg.face.base.d.d.d(f39579a, e);
                        if (bufferedOutputStream != null) {
                            try {
                                bufferedOutputStream.close();
                                return;
                            } catch (IOException e6) {
                                com.baidu.fsg.face.base.d.d.d(f39579a, e6);
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
                                com.baidu.fsg.face.base.d.d.d(f39579a, e7);
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
