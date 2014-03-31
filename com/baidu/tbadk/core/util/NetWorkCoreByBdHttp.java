package com.baidu.tbadk.core.util;

import android.content.Context;
import android.os.Build;
import android.os.Handler;
import android.support.v4.view.accessibility.AccessibilityEventCompat;
import android.text.TextUtils;
import com.baidu.adp.lib.network.http.BdHttpCancelException;
import com.baidu.adp.lib.network.willdelete.BdHttpErrorException;
import com.baidu.tbadk.TbadkApplication;
import com.baidu.tbadk.core.data.ErrorData;
import com.baidu.tbadk.core.util.UtilHelper;
import java.io.File;
import java.net.SocketException;
import java.net.SocketTimeoutException;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Timer;
import org.apache.http.message.BasicNameValuePair;
/* loaded from: classes.dex */
public class NetWorkCoreByBdHttp implements z {
    private static int b = AccessibilityEventCompat.TYPE_TOUCH_INTERACTION_END;
    private static /* synthetic */ int[] e;
    protected final com.baidu.adp.lib.network.willdelete.a a = new com.baidu.adp.lib.network.willdelete.a();
    private Context c;
    private final com.baidu.tbadk.core.util.a.a d;

    /* loaded from: classes.dex */
    public enum NetworkState {
        UNAVAIL,
        WIFI,
        MOBILE;

        /* JADX DEBUG: Replace access to removed values field (a) with 'values()' method */
        /* renamed from: values  reason: to resolve conflict with enum method */
        public static NetworkState[] valuesCustom() {
            NetworkState[] valuesCustom = values();
            int length = valuesCustom.length;
            NetworkState[] networkStateArr = new NetworkState[length];
            System.arraycopy(valuesCustom, 0, networkStateArr, 0, length);
            return networkStateArr;
        }
    }

    private static /* synthetic */ int[] i() {
        int[] iArr = e;
        if (iArr == null) {
            iArr = new int[UtilHelper.NetworkStateInfo.valuesCustom().length];
            try {
                iArr[UtilHelper.NetworkStateInfo.ThreeG.ordinal()] = 4;
            } catch (NoSuchFieldError e2) {
            }
            try {
                iArr[UtilHelper.NetworkStateInfo.TwoG.ordinal()] = 3;
            } catch (NoSuchFieldError e3) {
            }
            try {
                iArr[UtilHelper.NetworkStateInfo.UNAVAIL.ordinal()] = 1;
            } catch (NoSuchFieldError e4) {
            }
            try {
                iArr[UtilHelper.NetworkStateInfo.WIFI.ordinal()] = 2;
            } catch (NoSuchFieldError e5) {
            }
            e = iArr;
        }
        return iArr;
    }

    public NetWorkCoreByBdHttp(com.baidu.tbadk.core.util.a.a aVar) {
        this.c = null;
        this.c = TbadkApplication.j().b();
        this.d = aVar;
        com.baidu.adp.lib.network.willdelete.e.a();
        com.baidu.adp.lib.network.willdelete.b.c = "BaiduTieba for Android " + com.baidu.tbadk.core.data.n.c();
        if (Integer.parseInt(Build.VERSION.SDK) < 8) {
            System.setProperty("http.keepAlive", "false");
        }
    }

    private static int a(UtilHelper.NetworkStateInfo networkStateInfo) {
        switch (i()[networkStateInfo.ordinal()]) {
            case 2:
                return 1;
            case 3:
                return 2;
            case 4:
                return 3;
            default:
                return 0;
        }
    }

    @Override // com.baidu.tbadk.core.util.z
    public final boolean c() {
        return this.a.c();
    }

    @Override // com.baidu.tbadk.core.util.z
    public final void b() {
        this.a.a();
        try {
            int a = aq.a(this.d.a().a().a);
            if (a > 0) {
                aq.a().a(a, 1);
            }
        } catch (Throwable th) {
            com.baidu.adp.lib.util.f.b(th.getMessage());
        }
    }

    /* JADX DEBUG: Don't trust debug lines info. Repeating lines: [495=12] */
    /* JADX DEBUG: TODO: convert one arg to string using `String.valueOf()`, args: [(r6v36 long)] */
    /* JADX WARN: Removed duplicated region for block: B:159:0x092b A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:176:0x0327 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:41:0x0187  */
    /* JADX WARN: Removed duplicated region for block: B:69:0x0322 A[Catch: BdHttpCancelException -> 0x00f4, BdHttpErrorException -> 0x01d7, SocketException -> 0x0640, SocketTimeoutException -> 0x06e6, Exception -> 0x078c, OutOfMemoryError -> 0x0852, all -> 0x0918, TRY_LEAVE, TryCatch #13 {all -> 0x0918, blocks: (B:6:0x0026, B:8:0x0036, B:10:0x004a, B:12:0x0056, B:14:0x0084, B:16:0x008b, B:18:0x009f, B:19:0x00a3, B:21:0x00a9, B:22:0x00b6, B:24:0x00c7, B:29:0x00e4, B:31:0x00ee, B:32:0x00f3, B:62:0x02cd, B:64:0x02f2, B:66:0x02f8, B:67:0x031e, B:69:0x0322, B:71:0x0327, B:73:0x032b, B:75:0x0339, B:89:0x0398, B:91:0x03b2, B:94:0x03fc, B:96:0x0432, B:97:0x043f, B:99:0x0449, B:115:0x052e, B:116:0x053d, B:118:0x0596, B:119:0x060a, B:149:0x0855, B:152:0x089f, B:154:0x090b, B:141:0x078f, B:144:0x07d9, B:146:0x0845, B:133:0x06e9, B:136:0x0733, B:138:0x077f, B:125:0x0643, B:128:0x068d, B:130:0x06d9, B:53:0x01da, B:56:0x0224, B:122:0x0632, B:35:0x00f7, B:38:0x0141, B:121:0x0624, B:78:0x0360, B:80:0x0366, B:83:0x0376, B:87:0x0394, B:26:0x00d7, B:59:0x0274, B:60:0x0279, B:45:0x01a4, B:47:0x01ba, B:49:0x01d0, B:61:0x02bd), top: B:175:0x0026 }] */
    /* JADX WARN: Removed duplicated region for block: B:75:0x0339 A[Catch: all -> 0x0918, OutOfMemoryError -> 0x092e, Exception -> 0x0931, SocketTimeoutException -> 0x0934, SocketException -> 0x0937, BdHttpErrorException -> 0x093a, BdHttpCancelException -> 0x093d, TRY_LEAVE, TryCatch #13 {all -> 0x0918, blocks: (B:6:0x0026, B:8:0x0036, B:10:0x004a, B:12:0x0056, B:14:0x0084, B:16:0x008b, B:18:0x009f, B:19:0x00a3, B:21:0x00a9, B:22:0x00b6, B:24:0x00c7, B:29:0x00e4, B:31:0x00ee, B:32:0x00f3, B:62:0x02cd, B:64:0x02f2, B:66:0x02f8, B:67:0x031e, B:69:0x0322, B:71:0x0327, B:73:0x032b, B:75:0x0339, B:89:0x0398, B:91:0x03b2, B:94:0x03fc, B:96:0x0432, B:97:0x043f, B:99:0x0449, B:115:0x052e, B:116:0x053d, B:118:0x0596, B:119:0x060a, B:149:0x0855, B:152:0x089f, B:154:0x090b, B:141:0x078f, B:144:0x07d9, B:146:0x0845, B:133:0x06e9, B:136:0x0733, B:138:0x077f, B:125:0x0643, B:128:0x068d, B:130:0x06d9, B:53:0x01da, B:56:0x0224, B:122:0x0632, B:35:0x00f7, B:38:0x0141, B:121:0x0624, B:78:0x0360, B:80:0x0366, B:83:0x0376, B:87:0x0394, B:26:0x00d7, B:59:0x0274, B:60:0x0279, B:45:0x01a4, B:47:0x01ba, B:49:0x01d0, B:61:0x02bd), top: B:175:0x0026 }] */
    /* JADX WARN: Removed duplicated region for block: B:89:0x0398 A[Catch: all -> 0x0918, OutOfMemoryError -> 0x092e, Exception -> 0x0931, SocketTimeoutException -> 0x0934, SocketException -> 0x0937, BdHttpErrorException -> 0x093a, BdHttpCancelException -> 0x093d, TRY_ENTER, TryCatch #13 {all -> 0x0918, blocks: (B:6:0x0026, B:8:0x0036, B:10:0x004a, B:12:0x0056, B:14:0x0084, B:16:0x008b, B:18:0x009f, B:19:0x00a3, B:21:0x00a9, B:22:0x00b6, B:24:0x00c7, B:29:0x00e4, B:31:0x00ee, B:32:0x00f3, B:62:0x02cd, B:64:0x02f2, B:66:0x02f8, B:67:0x031e, B:69:0x0322, B:71:0x0327, B:73:0x032b, B:75:0x0339, B:89:0x0398, B:91:0x03b2, B:94:0x03fc, B:96:0x0432, B:97:0x043f, B:99:0x0449, B:115:0x052e, B:116:0x053d, B:118:0x0596, B:119:0x060a, B:149:0x0855, B:152:0x089f, B:154:0x090b, B:141:0x078f, B:144:0x07d9, B:146:0x0845, B:133:0x06e9, B:136:0x0733, B:138:0x077f, B:125:0x0643, B:128:0x068d, B:130:0x06d9, B:53:0x01da, B:56:0x0224, B:122:0x0632, B:35:0x00f7, B:38:0x0141, B:121:0x0624, B:78:0x0360, B:80:0x0366, B:83:0x0376, B:87:0x0394, B:26:0x00d7, B:59:0x0274, B:60:0x0279, B:45:0x01a4, B:47:0x01ba, B:49:0x01d0, B:61:0x02bd), top: B:175:0x0026 }] */
    @Override // com.baidu.tbadk.core.util.z
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final byte[] e() {
        com.baidu.adp.lib.network.willdelete.f fVar;
        com.baidu.adp.lib.network.willdelete.f fVar2;
        com.baidu.tbadk.core.util.a.a aVar;
        com.baidu.tbadk.core.util.a.b a;
        com.baidu.tbadk.core.util.a.f a2;
        String str;
        String str2;
        boolean z;
        int i;
        com.baidu.adp.lib.network.willdelete.f fVar3;
        String str3;
        com.baidu.adp.lib.network.willdelete.e.a();
        com.baidu.adp.lib.network.willdelete.b.d = TbadkApplication.E();
        try {
            int a3 = aq.a(this.d.a().a().a);
            if (a3 > 0) {
                aq.a().a(a3);
            }
        } catch (Exception e2) {
            com.baidu.adp.lib.util.f.b(e2.getMessage());
        }
        try {
            try {
                if (this.d.a().a().b == null || this.d.a().a().b.size() <= 0 || this.d.a().e) {
                    str2 = this.d.a().a().a;
                } else {
                    StringBuilder sb = new StringBuilder(30);
                    sb.append(this.d.a().a().a);
                    if (this.d.a().a().a.indexOf("?") < 0) {
                        sb.append("?");
                    } else if (!this.d.a().a().a.endsWith("?") && !this.d.a().a().a.endsWith("&")) {
                        sb.append("&");
                    }
                    for (int i2 = 0; i2 < this.d.a().a().b.size(); i2++) {
                        if (i2 != 0) {
                            sb.append("&");
                        }
                        sb.append(this.d.a().a().b.get(i2).getName());
                        sb.append("=");
                        sb.append(bc.d(this.d.a().a().b.get(i2).getValue()));
                    }
                    str2 = sb.toString();
                }
                if (com.baidu.tbadk.core.data.n.a()) {
                    com.baidu.adp.lib.util.f.e(getClass().getName(), "getNetData", str2);
                }
                z = (this.d.a().a().d && !this.d.a().a().e) || this.d.a().e;
            } finally {
                aq.c(this.d.a().a().a);
            }
        } catch (BdHttpCancelException e3) {
            e = e3;
            fVar2 = null;
        } catch (BdHttpErrorException e4) {
            e = e4;
            fVar = null;
        } catch (SocketException e5) {
            e = e5;
            fVar = null;
        } catch (SocketTimeoutException e6) {
            e = e6;
            fVar = null;
        } catch (Exception e7) {
            e = e7;
            fVar = null;
        } catch (OutOfMemoryError e8) {
            e = e8;
            fVar = null;
        }
        if (this.a.c()) {
            throw new BdHttpCancelException();
        }
        long time = new Date().getTime();
        com.baidu.adp.lib.network.willdelete.e.a();
        am amVar = new am(this, str2, time);
        com.baidu.adp.lib.network.willdelete.a aVar2 = this.a;
        LinkedList<BasicNameValuePair> h = h();
        fVar = com.baidu.adp.lib.network.willdelete.b.a(str2, z, 5, -1, amVar, aVar2, h);
        if (fVar == null || fVar.a != 206) {
            if (fVar != null && fVar.a == 413) {
                fVar.d = com.baidu.adp.lib.network.willdelete.b.a(str2, 0L, com.baidu.adp.lib.network.willdelete.h.a() ? 500000 : 200000, new ArrayList(), 5, 100, -1, amVar, aVar2, h);
                if (fVar.d != null) {
                    i = 200;
                    fVar3 = fVar;
                } else {
                    i = fVar.a;
                    fVar3 = fVar;
                }
            }
            if (amVar != null) {
                amVar.a(fVar);
            }
            if (fVar != null) {
                try {
                    if (fVar.c != null) {
                        this.d.c().a = fVar.c;
                    }
                } catch (BdHttpCancelException e9) {
                    e = e9;
                    fVar2 = fVar;
                    this.d.b().c = this.c.getResources().getString(com.baidu.tbadk.l.neterror);
                    this.d.b().d = String.valueOf(String.valueOf(this.d.b().a)) + "|retryCount:" + (this.d.c().a == null ? -1 : this.d.c().a.e) + "|" + e.getClass() + "|" + e.getMessage();
                    this.d.b().a = -14;
                    aq.c(this.d.a().a().a);
                    fVar = fVar2;
                    if (fVar != null) {
                    }
                } catch (BdHttpErrorException e10) {
                    e = e10;
                    this.d.b().c = this.c.getResources().getString(com.baidu.tbadk.l.neterror);
                    this.d.b().d = String.valueOf(String.valueOf(this.d.b().a)) + "|retryCount:" + (this.d.c().a == null ? -1 : this.d.c().a.e) + "|" + e.getClass() + "|" + e.getMessage();
                    this.d.b().a = e.getHttpResponseCode();
                    TiebaStatic.a(this.d);
                    if (fVar != null) {
                    }
                } catch (Exception e11) {
                    e = e11;
                    this.d.b().c = this.c.getResources().getString(com.baidu.tbadk.l.neterror);
                    this.d.b().d = String.valueOf(String.valueOf(this.d.b().a)) + "|retryCount:" + (this.d.c().a == null ? -1 : this.d.c().a.e) + "|" + e.getClass() + "|" + e.getMessage();
                    this.d.b().a = -10;
                    com.baidu.adp.lib.util.f.b(getClass().getName(), "getNetData", "error = " + e.getMessage());
                    TiebaStatic.a(this.d);
                    aq.c(this.d.a().a().a);
                    if (fVar != null) {
                    }
                } catch (OutOfMemoryError e12) {
                    e = e12;
                    this.d.b().c = this.c.getResources().getString(com.baidu.tbadk.l.memoryerror);
                    this.d.b().d = String.valueOf(String.valueOf(this.d.b().a)) + "|retryCount:" + (this.d.c().a == null ? -1 : this.d.c().a.e) + "|" + e.getClass() + "|" + e.getMessage();
                    this.d.b().a = -15;
                    com.baidu.adp.lib.util.f.b(getClass().getName(), "getNetData", " 内存溢出！error = " + e.getMessage());
                    TiebaStatic.a(this.d);
                    aq.c(this.d.a().a().a);
                    if (fVar != null) {
                    }
                } catch (SocketException e13) {
                    e = e13;
                    this.d.b().c = this.c.getResources().getString(com.baidu.tbadk.l.neterror);
                    this.d.b().d = String.valueOf(String.valueOf(this.d.b().a)) + "|retryCount:" + (this.d.c().a == null ? -1 : this.d.c().a.e) + "|" + e.getClass() + "|" + e.getMessage();
                    this.d.b().a = -12;
                    TiebaStatic.a(this.d);
                    aq.c(this.d.a().a().a);
                    if (fVar != null) {
                    }
                } catch (SocketTimeoutException e14) {
                    e = e14;
                    this.d.b().c = this.c.getResources().getString(com.baidu.tbadk.l.neterror);
                    this.d.b().d = String.valueOf(String.valueOf(this.d.b().a)) + "|retryCount:" + (this.d.c().a == null ? -1 : this.d.c().a.e) + "|" + e.getClass() + "|" + e.getMessage();
                    this.d.b().a = -13;
                    TiebaStatic.a(this.d);
                    aq.c(this.d.a().a().a);
                    if (fVar != null) {
                    }
                }
            }
            if (fVar != null) {
                aq.c(this.d.a().a().a);
                aq.c(this.d.a().a().a);
                return null;
            }
            this.d.b().a = fVar.a;
            if (this.d.b().a != 200) {
                this.d.b().c = this.c.getResources().getString(com.baidu.tbadk.l.neterror);
                this.d.b().d = String.valueOf(String.valueOf(this.d.b().a)) + "|retryCount:" + (this.d.c().a == null ? -1 : this.d.c().a.e);
                TiebaStatic.a(this.d);
                aq.c(this.d.a().a().a);
                aq.c(this.d.a().a().a);
                return null;
            }
            if (TbadkApplication.j().m() && (str3 = fVar.b) != null) {
                try {
                    int parseInt = Integer.parseInt(str3);
                    if (parseInt > b) {
                        this.d.b().a = -11;
                        TiebaStatic.a(this.d);
                        aq.c(this.d.a().a().a);
                        return null;
                    }
                    int i3 = parseInt * 10;
                    if (i3 > 0) {
                        if (com.baidu.adp.lib.util.f.a()) {
                            com.baidu.adp.lib.util.f.e("pre-free memory for downloaded image:[" + this.d.a().a().a + "], size:" + i3);
                        }
                        if (!com.baidu.tbadk.imageManager.e.a().b(i3)) {
                            com.baidu.adp.lib.util.f.e("Image download cacelled. out of memory. url:[" + this.d.a().a().a + "], size:" + i3);
                            this.d.b().a = -16;
                            TiebaStatic.a(this.d);
                            aq.c(this.d.a().a().a);
                            return null;
                        }
                    }
                } catch (Throwable th) {
                    com.baidu.adp.lib.util.f.e(NetWorkCoreByBdHttp.class.getName(), "getNetData", th.getMessage());
                }
            }
            long time2 = new Date().getTime() - time;
            au auVar = new au();
            auVar.e = a(UtilHelper.d(this.c));
            auVar.c = this.d.c().a.b;
            auVar.b = time2;
            auVar.d = this.d.c().a.e;
            auVar.a = 2;
            at.a(auVar);
            at.a.set(this.d.c().a.e);
            if (time2 > 5000) {
                com.baidu.tbadk.core.log.a.a(com.baidu.tbadk.core.log.j.a(str2, new StringBuilder().append(time2).toString(), new StringBuilder(String.valueOf(auVar.c)).toString(), "download OK,|DNS Time" + this.d.c().a.g + "|ConnectTime" + this.d.c().a.c + "|current ip" + UtilHelper.b(UtilHelper.a(str2)) + " retryCount: " + auVar.d, ""));
            }
            TiebaStatic.a(this.d);
            if (fVar != null) {
                this.d.a().a().h = fVar.e;
                return fVar.d;
            }
            return null;
        }
        int length = fVar.d.length;
        int length2 = fVar.d.length;
        ArrayList arrayList = new ArrayList();
        arrayList.add(fVar.d);
        fVar.d = com.baidu.adp.lib.network.willdelete.b.a(str2, length, length2, arrayList, 5, 100, -1, amVar, aVar2, h);
        i = 200;
        fVar3 = fVar;
        fVar3.a = i;
        if (amVar != null) {
        }
        if (fVar != null) {
        }
        if (fVar != null) {
        }
    }

    private void a(String str) {
        this.d.b().b = -1;
        if (str != null) {
            try {
                ErrorData errorData = new ErrorData();
                errorData.parserJson(str);
                this.d.b().b = errorData.getError_code();
                if (this.d.b().b == -1) {
                    this.d.b().c = this.c.getString(com.baidu.tbadk.l.error_unkown_try_again);
                } else if (this.d.b().b != 0) {
                    this.d.b().c = errorData.getError_msg();
                }
            } catch (Exception e2) {
                com.baidu.adp.lib.util.f.b("NetWork", "parseServerCode", "error = " + e2.getMessage());
                this.d.b().c = this.c.getString(com.baidu.tbadk.l.error_unkown_try_again);
            }
        }
    }

    @Override // com.baidu.tbadk.core.util.z
    public final String f() {
        String str;
        OutOfMemoryError e2;
        Exception e3;
        byte[] e4 = e();
        if (e4 == null || this.d.b().a != 200) {
            return null;
        }
        try {
            this.d.a().a().h = TextUtils.isEmpty(this.d.a().a().h) ? "UTF-8" : this.d.a().a().h;
            str = new String(e4, 0, e4.length, this.d.a().a().h);
        } catch (Exception e5) {
            str = null;
            e3 = e5;
        } catch (OutOfMemoryError e6) {
            str = null;
            e2 = e6;
        }
        try {
            a(str);
            return str;
        } catch (Exception e7) {
            e3 = e7;
            com.baidu.adp.lib.util.f.b(getClass().getName(), "getNetString", "error = " + e3.getMessage());
            return str;
        } catch (OutOfMemoryError e8) {
            e2 = e8;
            com.baidu.adp.lib.util.f.b(getClass().getName(), "getNetString", " 内存溢出！error = " + e2.getMessage());
            return str;
        }
    }

    /* JADX DEBUG: Don't trust debug lines info. Repeating lines: [732=12] */
    @Override // com.baidu.tbadk.core.util.z
    public final String d() {
        Throwable th;
        String str;
        Exception e2;
        SocketTimeoutException e3;
        SocketException e4;
        OutOfMemoryError e5;
        BdHttpErrorException e6;
        BdHttpCancelException e7;
        StringBuilder sb = new StringBuilder(1024);
        StringBuilder sb2 = new StringBuilder(1024);
        try {
            int a = aq.a(this.d.a().a().a);
            if (a > 0) {
                aq.a().a(a);
            }
        } catch (Exception e8) {
            com.baidu.adp.lib.util.f.b(e8.getMessage());
        }
        int i = 0;
        while (true) {
            int i2 = i;
            if (this.d.a().a().b == null || i2 >= this.d.a().a().b.size()) {
                break;
            }
            BasicNameValuePair basicNameValuePair = this.d.a().a().b.get(i2);
            if (basicNameValuePair != null) {
                String name = basicNameValuePair.getName();
                String value = basicNameValuePair.getValue();
                if (i2 != 0) {
                    sb.append("&");
                }
                sb.append(String.valueOf(name) + "=");
                sb.append(bc.d(value));
                sb2.append(name);
                sb2.append("=");
                sb2.append(value);
            }
            i = i2 + 1;
        }
        if (this.d.a().a().f) {
            sb2.append("tiebaclient!!!");
            String a2 = bc.a(sb2.toString());
            if (sb.length() > 0) {
                sb.append("&");
            }
            sb.append("sign=");
            sb.append(a2);
        }
        String sb3 = sb.toString();
        if (com.baidu.tbadk.core.data.n.a()) {
            com.baidu.adp.lib.util.f.e(getClass().getName(), "postNetData", String.valueOf(this.d.a().a().a) + "?" + sb3);
        }
        try {
            try {
                if (this.a.c()) {
                    aq.c(this.d.a().a().a);
                    return null;
                }
                com.baidu.adp.lib.network.willdelete.e.a();
                com.baidu.adp.lib.network.willdelete.f a3 = com.baidu.adp.lib.network.willdelete.b.a(this.d.a().a().d, this.d.a().a().a, sb3.getBytes(), 5, -1, null, this.a, h());
                if (a3 == null) {
                    throw new BdHttpCancelException();
                }
                if (a3.c != null) {
                    this.d.c().a = a3.c;
                }
                this.d.b().a = a3.a;
                if (this.d.b().a != 200) {
                    this.d.b().d = String.valueOf(String.valueOf(this.d.b().a)) + "|retryCount:" + (this.d.c().a == null ? -1 : this.d.c().a.e);
                    TiebaStatic.a(this.d);
                    aq.c(this.d.a().a().a);
                    return null;
                } else if (this.a.c()) {
                    aq.c(this.d.a().a().a);
                    return null;
                } else {
                    com.baidu.adp.lib.util.f.a(getClass().getName(), "postNetData", "time = " + String.valueOf(this.d.c().a.f) + "ms");
                    com.baidu.adp.lib.util.f.a(getClass().getName(), "postNetData", "Get data.zise = " + String.valueOf(this.d.c().a.b));
                    str = new String(a3.d, "utf-8");
                    try {
                        if (this.d.a().a().f && this.d.a().a().g) {
                            a(str);
                        }
                        au auVar = new au();
                        auVar.e = a(UtilHelper.d(this.c));
                        auVar.c = this.d.c().a.b;
                        auVar.b = this.d.c().a.f;
                        auVar.d = this.d.c().a.e;
                        auVar.a = 1;
                        at.a(auVar);
                        at.a.set(this.d.c().a.e);
                        TiebaStatic.a(this.d);
                        return str;
                    } catch (BdHttpCancelException e9) {
                        e7 = e9;
                        this.d.b().c = this.c.getResources().getString(com.baidu.tbadk.l.neterror);
                        this.d.b().d = String.valueOf(String.valueOf(this.d.b().a)) + "|retryCount:" + (this.d.c().a != null ? this.d.c().a.e : -1) + "|" + e7.getClass() + "|" + e7.getMessage();
                        this.d.b().a = -14;
                        return str;
                    } catch (BdHttpErrorException e10) {
                        e6 = e10;
                        this.d.b().c = this.c.getResources().getString(com.baidu.tbadk.l.neterror);
                        this.d.b().d = String.valueOf(String.valueOf(this.d.b().a)) + "|retryCount:" + (this.d.c().a == null ? -1 : this.d.c().a.e) + "|" + e6.getClass() + "|" + e6.getMessage();
                        this.d.b().a = e6.getHttpResponseCode();
                        TiebaStatic.a(this.d);
                        return str;
                    } catch (OutOfMemoryError e11) {
                        e5 = e11;
                        this.d.b().a = -15;
                        this.d.b().c = this.c.getResources().getString(com.baidu.tbadk.l.memoryerror);
                        com.baidu.adp.lib.util.f.b(getClass().getName(), "postNetData", " 内存溢出！error = " + e5.getMessage());
                        TiebaStatic.a(this.d);
                        return str;
                    } catch (SocketException e12) {
                        e4 = e12;
                        this.d.b().a = -12;
                        this.d.b().c = this.c.getResources().getString(com.baidu.tbadk.l.neterror);
                        com.baidu.adp.lib.util.f.b(getClass().getName(), "postNetData", "SocketException " + e4.getMessage());
                        TiebaStatic.a(this.d);
                        return str;
                    } catch (SocketTimeoutException e13) {
                        e3 = e13;
                        this.d.b().a = -13;
                        this.d.b().c = this.c.getResources().getString(com.baidu.tbadk.l.neterror);
                        com.baidu.adp.lib.util.f.b(getClass().getName(), "postNetData", "SocketTimeoutException " + e3.getMessage());
                        TiebaStatic.a(this.d);
                        return str;
                    } catch (Exception e14) {
                        e2 = e14;
                        this.d.b().a = -10;
                        this.d.b().c = this.c.getResources().getString(com.baidu.tbadk.l.neterror);
                        com.baidu.adp.lib.util.f.b(getClass().getName(), "postNetData", e2.getMessage());
                        TiebaStatic.a(this.d);
                        return str;
                    } catch (Throwable th2) {
                        th = th2;
                        this.d.b().a = -10;
                        this.d.b().c = this.c.getResources().getString(com.baidu.tbadk.l.neterror);
                        com.baidu.adp.lib.util.f.b(getClass().getName(), "postNetData", th.getMessage());
                        TiebaStatic.a(this.d);
                        return str;
                    }
                }
            } finally {
                aq.c(this.d.a().a().a);
            }
        } catch (BdHttpCancelException e15) {
            e7 = e15;
            str = null;
        } catch (BdHttpErrorException e16) {
            e6 = e16;
            str = null;
        } catch (OutOfMemoryError e17) {
            e5 = e17;
            str = null;
        } catch (SocketException e18) {
            e4 = e18;
            str = null;
        } catch (SocketTimeoutException e19) {
            e3 = e19;
            str = null;
        } catch (Exception e20) {
            e2 = e20;
            str = null;
        } catch (Throwable th3) {
            th = th3;
            str = null;
        }
    }

    /* JADX DEBUG: Don't trust debug lines info. Repeating lines: [838=9] */
    @Override // com.baidu.tbadk.core.util.z
    public final String g() {
        Exception e2;
        String str;
        OutOfMemoryError e3;
        BdHttpErrorException e4;
        BdHttpCancelException e5;
        try {
            try {
                if (this.a.c()) {
                    throw new BdHttpCancelException();
                }
                com.baidu.adp.lib.network.willdelete.e.a();
                com.baidu.adp.lib.network.willdelete.f a = com.baidu.adp.lib.network.willdelete.e.a(this.d.a().a().a, this.d.a().a().d, this.d.a().a().b, this.d.a().a().c, 5, -1, null, this.a, h());
                this.d.b().a = a.a;
                new Timer().schedule(new ao(this, (byte) 0), 45000L);
                if (this.d.b().a != 200) {
                    this.d.b().d = String.valueOf(String.valueOf(this.d.b().a)) + "|retryCount:" + (this.d.c().a == null ? -1 : this.d.c().a.e);
                    TiebaStatic.a(this.d);
                    return null;
                } else if (this.a.c()) {
                    throw new BdHttpCancelException();
                } else {
                    str = new String(a.d, a.e);
                    try {
                        a(str);
                        TiebaStatic.a(this.d);
                        return str;
                    } catch (BdHttpCancelException e6) {
                        e5 = e6;
                        this.d.b().c = this.c.getResources().getString(com.baidu.tbadk.l.neterror);
                        this.d.b().d = String.valueOf(String.valueOf(this.d.b().a)) + "|retryCount:" + (this.d.c().a != null ? this.d.c().a.e : -1) + "|" + e5.getClass() + "|" + e5.getMessage();
                        this.d.b().a = -14;
                        return str;
                    } catch (BdHttpErrorException e7) {
                        e4 = e7;
                        this.d.b().c = this.c.getResources().getString(com.baidu.tbadk.l.neterror);
                        this.d.b().d = String.valueOf(String.valueOf(this.d.b().a)) + "|retryCount:" + (this.d.c().a == null ? -1 : this.d.c().a.e) + "|" + e4.getClass() + "|" + e4.getMessage();
                        this.d.b().a = e4.getHttpResponseCode();
                        TiebaStatic.a(this.d);
                        return str;
                    } catch (SocketException e8) {
                        this.d.b().a = -12;
                        this.d.b().c = this.c.getResources().getString(com.baidu.tbadk.l.neterror);
                        TiebaStatic.a(this.d);
                        return str;
                    } catch (Exception e9) {
                        e2 = e9;
                        this.d.b().a = -10;
                        this.d.b().c = this.c.getResources().getString(com.baidu.tbadk.l.neterror);
                        com.baidu.adp.lib.util.f.b("NetWork", "postMultiNetData", "error = " + e2.getMessage());
                        TiebaStatic.a(this.d);
                        return str;
                    } catch (OutOfMemoryError e10) {
                        e3 = e10;
                        this.d.b().a = -15;
                        this.d.b().c = this.c.getResources().getString(com.baidu.tbadk.l.memoryerror);
                        com.baidu.adp.lib.util.f.b(getClass().getName(), "postMultiNetData", " 内存溢出！error = " + e3.getMessage());
                        TiebaStatic.a(this.d);
                        return str;
                    } catch (SocketTimeoutException e11) {
                        this.d.b().a = -13;
                        this.d.b().c = this.c.getResources().getString(com.baidu.tbadk.l.neterror);
                        TiebaStatic.a(this.d);
                        return str;
                    }
                }
            } finally {
                new Timer().schedule(new ao(this, (byte) 0), 0L);
            }
        } catch (BdHttpCancelException e12) {
            e5 = e12;
            str = null;
        } catch (BdHttpErrorException e13) {
            e4 = e13;
            str = null;
        } catch (OutOfMemoryError e14) {
            e3 = e14;
            str = null;
        } catch (SocketException e15) {
            str = null;
        } catch (SocketTimeoutException e16) {
            str = null;
        } catch (Exception e17) {
            e2 = e17;
            str = null;
        }
    }

    /* JADX DEBUG: Don't trust debug lines info. Repeating lines: [915=5] */
    @Override // com.baidu.tbadk.core.util.z
    public final boolean a(String str, Handler handler, int i, int i2, int i3) {
        boolean z;
        try {
            try {
            } catch (Exception e2) {
                this.d.b().a = -10;
                this.d.b().c = this.c.getResources().getString(com.baidu.tbadk.l.neterror);
                com.baidu.adp.lib.util.f.b("NetWork", "downloadFile", "error = " + e2.getMessage());
                TiebaStatic.a(this.d);
                z = false;
            } catch (OutOfMemoryError e3) {
                this.d.b().a = -15;
                this.d.b().c = this.c.getResources().getString(com.baidu.tbadk.l.memoryerror);
                com.baidu.adp.lib.util.f.b(getClass().getName(), "downloadFile", "error = " + e3.getMessage());
                TiebaStatic.a(this.d);
                z = false;
            }
            if (this.a.c()) {
                return false;
            }
            File g = w.g(str);
            com.baidu.adp.lib.network.willdelete.e.a();
            z = com.baidu.adp.lib.network.willdelete.b.a(this.d.a().a().a, g.getAbsolutePath(), false, i2, i3, -1, (com.baidu.adp.lib.network.willdelete.d) new an(this, handler, i), this.a, h());
            return z;
        } finally {
            TiebaStatic.a(this.d);
        }
    }

    @Override // com.baidu.tbadk.core.util.z
    public final ArrayList<BasicNameValuePair> a() {
        return this.d.a().a().b;
    }

    @Override // com.baidu.tbadk.core.util.z
    public final void a(ArrayList<BasicNameValuePair> arrayList) {
        if (this.d.a().a().b != null) {
            this.d.a().a().b.clear();
        }
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 < arrayList.size()) {
                a(arrayList.get(i2));
                i = i2 + 1;
            } else {
                return;
            }
        }
    }

    @Override // com.baidu.tbadk.core.util.z
    public final void a(String str, String str2) {
        a(new BasicNameValuePair(str, str2));
    }

    @Override // com.baidu.tbadk.core.util.z
    public final void a(String str, byte[] bArr) {
        if (this.d.a().a().c == null) {
            this.d.a().a().c = new HashMap<>();
        }
        this.d.a().a().c.put(str, bArr);
    }

    @Override // com.baidu.tbadk.core.util.z
    public final void a(BasicNameValuePair basicNameValuePair) {
        if (basicNameValuePair != null && basicNameValuePair.getName() != null) {
            if (this.d.a().a().b == null) {
                this.d.a().a().b = new ArrayList<>();
            }
            int a = a(this.d.a().a().b, basicNameValuePair.getName());
            int size = this.d.a().a().b.size();
            if (a >= 0 && a < size) {
                if (basicNameValuePair.getName().equals(this.d.a().a().b.get(a).getName())) {
                    this.d.a().a().b.set(a, basicNameValuePair);
                } else {
                    this.d.a().a().b.add(a, basicNameValuePair);
                }
            } else if (a == size) {
                this.d.a().a().b.add(a, basicNameValuePair);
            }
        }
    }

    private static int a(ArrayList<BasicNameValuePair> arrayList, String str) {
        int i = 0;
        if (arrayList == null || str == null) {
            return -1;
        }
        int size = arrayList.size();
        int i2 = 0;
        while (true) {
            if (i >= size) {
                break;
            }
            int compareTo = str.compareTo(arrayList.get(i).getName());
            if (compareTo < 0) {
                i2 = i;
                break;
            } else if (compareTo == 0) {
                return -1;
            } else {
                i2 = i;
                i++;
            }
        }
        return i >= size ? size : i2;
    }

    private LinkedList<BasicNameValuePair> h() {
        if (this.d != null) {
            LinkedList<BasicNameValuePair> linkedList = new LinkedList<>();
            if (!TextUtils.isEmpty(this.d.a().a().i)) {
                linkedList.add(new BasicNameValuePair("sid", this.d.a().a().i));
            }
            if (!TextUtils.isEmpty(this.d.a().a().j)) {
                linkedList.add(new BasicNameValuePair(com.baidu.loginshare.e.e, this.d.a().a().j));
                return linkedList;
            }
            return linkedList;
        }
        return null;
    }
}
