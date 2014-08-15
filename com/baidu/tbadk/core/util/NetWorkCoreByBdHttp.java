package com.baidu.tbadk.core.util;

import android.content.Context;
import android.os.Build;
import android.os.Handler;
import android.support.v4.view.accessibility.AccessibilityEventCompat;
import android.text.TextUtils;
import com.baidu.adp.lib.network.http.BdHttpCancelException;
import com.baidu.adp.lib.network.willdelete.BdHttpErrorException;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.TbadkApplication;
import com.baidu.tbadk.core.data.ErrorData;
import com.baidu.tbadk.core.util.UtilHelper;
import java.net.SocketException;
import java.net.SocketTimeoutException;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Timer;
import org.apache.http.message.BasicNameValuePair;
/* loaded from: classes.dex */
public class NetWorkCoreByBdHttp implements v {
    private static int b = AccessibilityEventCompat.TYPE_TOUCH_INTERACTION_END;
    private static /* synthetic */ int[] e;
    protected final com.baidu.adp.lib.network.willdelete.a a = new com.baidu.adp.lib.network.willdelete.a();
    private Context c;
    private final com.baidu.tbadk.core.util.httpNet.e d;

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

    static /* synthetic */ int[] h() {
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

    public NetWorkCoreByBdHttp(com.baidu.tbadk.core.util.httpNet.e eVar) {
        i();
        this.c = TbadkApplication.m252getInst().getApp();
        this.d = eVar;
        com.baidu.adp.lib.network.willdelete.e.a().b("bdtb for Android " + TbConfig.getVersion());
        if (Integer.parseInt(Build.VERSION.SDK) < 8) {
            System.setProperty("http.keepAlive", "false");
        }
    }

    private int a(UtilHelper.NetworkStateInfo networkStateInfo) {
        switch (h()[networkStateInfo.ordinal()]) {
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

    private void i() {
        this.c = null;
    }

    @Override // com.baidu.tbadk.core.util.v
    public boolean c() {
        return this.a.c();
    }

    @Override // com.baidu.tbadk.core.util.v
    public void b() {
        this.a.a();
        try {
            int a = ak.a(this.d.a().a().a);
            if (a > 0) {
                ak.a().a(a, 1);
            }
        } catch (Throwable th) {
            BdLog.e(th.getMessage());
        }
    }

    /* JADX DEBUG: Don't trust debug lines info. Repeating lines: [438=12] */
    /* JADX WARN: Removed duplicated region for block: B:124:0x070a  */
    /* JADX WARN: Removed duplicated region for block: B:36:0x0156  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:86:0x041d -> B:87:0x041e). Please submit an issue!!! */
    @Override // com.baidu.tbadk.core.util.v
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public byte[] e() {
        com.baidu.adp.lib.network.willdelete.f fVar;
        byte[] bArr;
        String str;
        String str2;
        boolean z = true;
        com.baidu.adp.lib.network.willdelete.e.a().c(TbadkApplication.getCurrentAccount());
        try {
            int a = ak.a(this.d.a().a().a);
            if (a > 0) {
                ak.a().a(a);
            }
        } catch (Exception e2) {
            BdLog.e(e2.getMessage());
        }
        try {
            try {
                if (this.d.a().a().b == null || this.d.a().a().b.size() <= 0 || this.d.a().e) {
                    str = this.d.a().a().a;
                } else {
                    StringBuilder sb = new StringBuilder(30);
                    sb.append(this.d.a().a().a);
                    if (this.d.a().a().a.indexOf("?") < 0) {
                        sb.append("?");
                    } else if (!this.d.a().a().a.endsWith("?") && !this.d.a().a().a.endsWith("&")) {
                        sb.append("&");
                    }
                    for (int i = 0; i < this.d.a().a().b.size(); i++) {
                        if (i != 0) {
                            sb.append("&");
                        }
                        sb.append(this.d.a().a().b.get(i).getName());
                        sb.append("=");
                        sb.append(ba.d(this.d.a().a().b.get(i).getValue()));
                    }
                    str = sb.toString();
                }
                TbConfig.getDebugSwitch();
                if ((!this.d.a().a().d || this.d.a().a().e) && !this.d.a().e) {
                    z = false;
                }
            } finally {
                ak.b(this.d.a().a().a);
            }
        } catch (BdHttpCancelException e3) {
            e = e3;
            fVar = null;
        } catch (BdHttpErrorException e4) {
            e = e4;
            fVar = null;
        } catch (SocketException e5) {
            e = e5;
            fVar = null;
        } catch (Exception e6) {
            e = e6;
            fVar = null;
        } catch (OutOfMemoryError e7) {
            e = e7;
            fVar = null;
        } catch (SocketTimeoutException e8) {
            e = e8;
            fVar = null;
        }
        if (this.a.c()) {
            throw new BdHttpCancelException();
        }
        long j = new Date().getTime();
        fVar = com.baidu.adp.lib.network.willdelete.e.a().a(str, z, 5, 100, -1, new ag(this), this.a, j());
        if (fVar != null) {
            try {
                if (fVar.c != null) {
                    this.d.c().a = fVar.c;
                }
            } catch (BdHttpCancelException e9) {
                e = e9;
                this.d.b().c = this.c.getResources().getString(com.baidu.tieba.x.neterror);
                this.d.b().d = String.valueOf(String.valueOf(this.d.b().a)) + "|retryCount:" + (this.d.c().a != null ? this.d.c().a.e : -1) + "|" + e.getClass() + "|" + e.getMessage();
                this.d.b().a = -14;
                ak.b(this.d.a().a().a);
                if (fVar != null) {
                }
                return bArr;
            } catch (BdHttpErrorException e10) {
                e = e10;
                this.d.b().c = this.c.getResources().getString(com.baidu.tieba.x.neterror);
                this.d.b().d = String.valueOf(String.valueOf(this.d.b().a)) + "|retryCount:" + (this.d.c().a != null ? this.d.c().a.e : -1) + "|" + e.getClass() + "|" + e.getMessage();
                this.d.b().a = e.getHttpResponseCode();
                TiebaStatic.net(this.d);
                ak.b(this.d.a().a().a);
                if (fVar != null) {
                }
                return bArr;
            } catch (OutOfMemoryError e11) {
                e = e11;
                this.d.b().c = this.c.getResources().getString(com.baidu.tieba.x.memoryerror);
                this.d.b().d = String.valueOf(String.valueOf(this.d.b().a)) + "|retryCount:" + (this.d.c().a == null ? -1 : this.d.c().a.e) + "|" + e.getClass() + "|" + e.getMessage();
                this.d.b().a = -15;
                BdLog.e(e.getMessage());
                TiebaStatic.net(this.d);
                ak.b(this.d.a().a().a);
                if (fVar != null) {
                }
                return bArr;
            } catch (SocketException e12) {
                e = e12;
                this.d.b().c = this.c.getResources().getString(com.baidu.tieba.x.neterror);
                this.d.b().d = String.valueOf(String.valueOf(this.d.b().a)) + "|retryCount:" + (this.d.c().a != null ? this.d.c().a.e : -1) + "|" + e.getClass() + "|" + e.getMessage();
                this.d.b().a = -12;
                TiebaStatic.net(this.d);
                ak.b(this.d.a().a().a);
                if (fVar != null) {
                }
                return bArr;
            } catch (SocketTimeoutException e13) {
                e = e13;
                this.d.b().c = this.c.getResources().getString(com.baidu.tieba.x.neterror);
                this.d.b().d = String.valueOf(String.valueOf(this.d.b().a)) + "|retryCount:" + (this.d.c().a != null ? this.d.c().a.e : -1) + "|" + e.getClass() + "|" + e.getMessage();
                this.d.b().a = -13;
                TiebaStatic.net(this.d);
                ak.b(this.d.a().a().a);
                if (fVar != null) {
                }
                return bArr;
            } catch (Exception e14) {
                e = e14;
                this.d.b().c = this.c.getResources().getString(com.baidu.tieba.x.neterror);
                this.d.b().d = String.valueOf(String.valueOf(this.d.b().a)) + "|retryCount:" + (this.d.c().a != null ? this.d.c().a.e : -1) + "|" + e.getClass() + "|" + e.getMessage();
                this.d.b().a = -10;
                BdLog.e(e.getMessage());
                TiebaStatic.net(this.d);
                ak.b(this.d.a().a().a);
                if (fVar != null) {
                }
                return bArr;
            }
        }
        if (fVar == null) {
            ak.b(this.d.a().a().a);
            return null;
        }
        this.d.b().a = fVar.a;
        if (this.d.b().a != 200) {
            this.d.b().c = this.c.getResources().getString(com.baidu.tieba.x.neterror);
            this.d.b().d = String.valueOf(String.valueOf(this.d.b().a)) + "|retryCount:" + (this.d.c().a == null ? -1 : this.d.c().a.e);
            TiebaStatic.net(this.d);
            ak.b(this.d.a().a().a);
            return null;
        }
        if (TbadkApplication.m252getInst().isMainProcess(true) && (str2 = fVar.b) != null) {
            try {
                int parseInt = Integer.parseInt(str2);
                if (parseInt > b) {
                    this.d.b().a = -11;
                    TiebaStatic.net(this.d);
                    ak.b(this.d.a().a().a);
                    bArr = null;
                } else {
                    int i2 = parseInt * 10;
                    if (i2 > 0) {
                        BdLog.isDebugMode();
                        if (!com.baidu.tbadk.imageManager.e.a().c(i2)) {
                            BdLog.d("Image download cacelled. out of memory. url:[" + this.d.a().a().a + "], size:" + i2);
                            this.d.b().a = -16;
                            TiebaStatic.net(this.d);
                            ak.b(this.d.a().a().a);
                            ak.b(this.d.a().a().a);
                            bArr = null;
                        }
                    }
                }
            } catch (Throwable th) {
            }
            return bArr;
        }
        ao aoVar = new ao();
        aoVar.e = a(UtilHelper.getNetStatusInfo(this.c));
        aoVar.c = this.d.c().a.b;
        aoVar.b = new Date().getTime() - j;
        aoVar.d = this.d.c().a.e;
        aoVar.a = 2;
        an.a(aoVar);
        an.a.set(this.d.c().a.e);
        TiebaStatic.net(this.d);
        ak.b(this.d.a().a().a);
        if (fVar != null) {
            this.d.a().a().h = fVar.e;
            bArr = fVar.d;
        } else {
            bArr = null;
        }
        return bArr;
    }

    public void a(String str) {
        this.d.b().b = -1;
        if (str != null) {
            try {
                ErrorData errorData = new ErrorData();
                errorData.parserJson(str);
                this.d.b().b = errorData.getError_code();
                if (this.d.b().b == -1) {
                    this.d.b().c = this.c.getString(com.baidu.tieba.x.error_unkown_try_again);
                } else if (this.d.b().b != 0) {
                    this.d.b().c = errorData.getError_msg();
                }
            } catch (Exception e2) {
                BdLog.e(e2.getMessage());
                this.d.b().c = this.c.getString(com.baidu.tieba.x.error_unkown_try_again);
            }
        }
    }

    @Override // com.baidu.tbadk.core.util.v
    public String f() {
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
            BdLog.e(e3.getMessage());
            return str;
        } catch (OutOfMemoryError e8) {
            e2 = e8;
            BdLog.e(e2.getMessage());
            return str;
        }
    }

    /* JADX DEBUG: Don't trust debug lines info. Repeating lines: [665=12] */
    @Override // com.baidu.tbadk.core.util.v
    public String d() {
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
            int a = ak.a(this.d.a().a().a);
            if (a > 0) {
                ak.a().a(a);
            }
        } catch (Exception e8) {
            BdLog.e(e8.getMessage());
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
                sb.append(ba.d(value));
                sb2.append(name);
                sb2.append("=");
                sb2.append(value);
            }
            i = i2 + 1;
        }
        if (this.d.a().a().f) {
            sb2.append("tiebaclient!!!");
            String a2 = ba.a(sb2.toString());
            if (sb.length() > 0) {
                sb.append("&");
            }
            sb.append("sign=");
            sb.append(a2);
        }
        String sb3 = sb.toString();
        TbConfig.getDebugSwitch();
        try {
            try {
                if (this.a.c()) {
                    ak.b(this.d.a().a().a);
                    return null;
                }
                com.baidu.adp.lib.network.willdelete.f a3 = com.baidu.adp.lib.network.willdelete.e.a().a(this.d.a().a().a, sb3.getBytes(), this.d.a().a().d, 5, -1, (com.baidu.adp.lib.network.willdelete.d) null, this.a, j());
                if (a3 == null) {
                    throw new BdHttpCancelException();
                }
                if (a3.c != null) {
                    this.d.c().a = a3.c;
                }
                this.d.b().a = a3.a;
                if (this.d.b().a != 200) {
                    this.d.b().d = String.valueOf(String.valueOf(this.d.b().a)) + "|retryCount:" + (this.d.c().a == null ? -1 : this.d.c().a.e);
                    TiebaStatic.net(this.d);
                    ak.b(this.d.a().a().a);
                    return null;
                } else if (this.a.c()) {
                    ak.b(this.d.a().a().a);
                    return null;
                } else {
                    str = new String(a3.d, "utf-8");
                    try {
                        if (this.d.a().a().f && this.d.a().a().g) {
                            a(str);
                        }
                        ao aoVar = new ao();
                        aoVar.e = a(UtilHelper.getNetStatusInfo(this.c));
                        aoVar.c = this.d.c().a.b;
                        aoVar.b = this.d.c().a.f;
                        aoVar.d = this.d.c().a.e;
                        aoVar.a = 1;
                        an.a(aoVar);
                        an.a.set(this.d.c().a.e);
                        TiebaStatic.net(this.d);
                        return str;
                    } catch (BdHttpCancelException e9) {
                        e7 = e9;
                        this.d.b().c = this.c.getResources().getString(com.baidu.tieba.x.neterror);
                        this.d.b().d = String.valueOf(String.valueOf(this.d.b().a)) + "|retryCount:" + (this.d.c().a != null ? this.d.c().a.e : -1) + "|" + e7.getClass() + "|" + e7.getMessage();
                        this.d.b().a = -14;
                        return str;
                    } catch (BdHttpErrorException e10) {
                        e6 = e10;
                        this.d.b().c = this.c.getResources().getString(com.baidu.tieba.x.neterror);
                        this.d.b().d = String.valueOf(String.valueOf(this.d.b().a)) + "|retryCount:" + (this.d.c().a == null ? -1 : this.d.c().a.e) + "|" + e6.getClass() + "|" + e6.getMessage();
                        this.d.b().a = e6.getHttpResponseCode();
                        TiebaStatic.net(this.d);
                        return str;
                    } catch (SocketException e11) {
                        e4 = e11;
                        this.d.b().a = -12;
                        this.d.b().c = this.c.getResources().getString(com.baidu.tieba.x.neterror);
                        BdLog.e(e4.getMessage());
                        TiebaStatic.net(this.d);
                        return str;
                    } catch (Exception e12) {
                        e2 = e12;
                        this.d.b().a = -10;
                        this.d.b().c = this.c.getResources().getString(com.baidu.tieba.x.neterror);
                        BdLog.e(e2.getMessage());
                        TiebaStatic.net(this.d);
                        return str;
                    } catch (OutOfMemoryError e13) {
                        e5 = e13;
                        this.d.b().a = -15;
                        this.d.b().c = this.c.getResources().getString(com.baidu.tieba.x.memoryerror);
                        BdLog.e(e5.getMessage());
                        TiebaStatic.net(this.d);
                        return str;
                    } catch (SocketTimeoutException e14) {
                        e3 = e14;
                        this.d.b().a = -13;
                        this.d.b().c = this.c.getResources().getString(com.baidu.tieba.x.neterror);
                        BdLog.e(e3.getMessage());
                        TiebaStatic.net(this.d);
                        return str;
                    } catch (Throwable th2) {
                        th = th2;
                        this.d.b().a = -10;
                        this.d.b().c = this.c.getResources().getString(com.baidu.tieba.x.neterror);
                        BdLog.e(th.getMessage());
                        TiebaStatic.net(this.d);
                        return str;
                    }
                }
            } finally {
                ak.b(this.d.a().a().a);
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

    /* JADX DEBUG: Don't trust debug lines info. Repeating lines: [768=9] */
    @Override // com.baidu.tbadk.core.util.v
    public String g() {
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
                com.baidu.adp.lib.network.willdelete.f a = com.baidu.adp.lib.network.willdelete.e.a().a(this.d.a().a().a, this.d.a().a().d, this.d.a().a().b, this.d.a().a().c, 5, -1, null, this.a, null, j());
                this.d.b().a = a.a;
                new Timer().schedule(new ai(this, null), 45000L);
                if (this.d.b().a != 200) {
                    this.d.b().d = String.valueOf(String.valueOf(this.d.b().a)) + "|retryCount:" + (this.d.c().a == null ? -1 : this.d.c().a.e);
                    TiebaStatic.net(this.d);
                    return null;
                } else if (this.a.c()) {
                    throw new BdHttpCancelException();
                } else {
                    str = new String(a.d, a.e);
                    try {
                        a(str);
                        TiebaStatic.net(this.d);
                        return str;
                    } catch (BdHttpCancelException e6) {
                        e5 = e6;
                        this.d.b().c = this.c.getResources().getString(com.baidu.tieba.x.neterror);
                        this.d.b().d = String.valueOf(String.valueOf(this.d.b().a)) + "|retryCount:" + (this.d.c().a != null ? this.d.c().a.e : -1) + "|" + e5.getClass() + "|" + e5.getMessage();
                        this.d.b().a = -14;
                        return str;
                    } catch (BdHttpErrorException e7) {
                        e4 = e7;
                        this.d.b().c = this.c.getResources().getString(com.baidu.tieba.x.neterror);
                        this.d.b().d = String.valueOf(String.valueOf(this.d.b().a)) + "|retryCount:" + (this.d.c().a == null ? -1 : this.d.c().a.e) + "|" + e4.getClass() + "|" + e4.getMessage();
                        this.d.b().a = e4.getHttpResponseCode();
                        TiebaStatic.net(this.d);
                        return str;
                    } catch (OutOfMemoryError e8) {
                        e3 = e8;
                        this.d.b().a = -15;
                        this.d.b().c = this.c.getResources().getString(com.baidu.tieba.x.memoryerror);
                        BdLog.e(e3.getMessage());
                        TiebaStatic.net(this.d);
                        return str;
                    } catch (SocketException e9) {
                        this.d.b().a = -12;
                        this.d.b().c = this.c.getResources().getString(com.baidu.tieba.x.neterror);
                        TiebaStatic.net(this.d);
                        return str;
                    } catch (SocketTimeoutException e10) {
                        this.d.b().a = -13;
                        this.d.b().c = this.c.getResources().getString(com.baidu.tieba.x.neterror);
                        TiebaStatic.net(this.d);
                        return str;
                    } catch (Exception e11) {
                        e2 = e11;
                        this.d.b().a = -10;
                        this.d.b().c = this.c.getResources().getString(com.baidu.tieba.x.neterror);
                        BdLog.e(e2.getMessage());
                        TiebaStatic.net(this.d);
                        return str;
                    }
                }
            } finally {
                new Timer().schedule(new ai(this, null), 0L);
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

    /* JADX DEBUG: Don't trust debug lines info. Repeating lines: [844=5] */
    @Override // com.baidu.tbadk.core.util.v
    public boolean a(String str, Handler handler, int i, int i2, int i3) {
        try {
            if (this.a.c()) {
                TiebaStatic.net(this.d);
                return false;
            }
            return com.baidu.adp.lib.network.willdelete.e.a().a(this.d.a().a().a, s.g(str).getAbsolutePath(), false, i2, i3, -1, new ah(this, handler, i), this.a, j());
        } catch (Exception e2) {
            this.d.b().a = -10;
            this.d.b().c = this.c.getResources().getString(com.baidu.tieba.x.neterror);
            BdLog.e(e2.getMessage());
            return false;
        } catch (OutOfMemoryError e3) {
            this.d.b().a = -15;
            this.d.b().c = this.c.getResources().getString(com.baidu.tieba.x.memoryerror);
            BdLog.e(e3.getMessage());
            return false;
        } finally {
            TiebaStatic.net(this.d);
        }
        TiebaStatic.net(this.d);
    }

    @Override // com.baidu.tbadk.core.util.v
    public ArrayList<BasicNameValuePair> a() {
        return this.d.a().a().b;
    }

    @Override // com.baidu.tbadk.core.util.v
    public void a(ArrayList<BasicNameValuePair> arrayList) {
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

    @Override // com.baidu.tbadk.core.util.v
    public void a(String str, String str2) {
        a(new BasicNameValuePair(str, str2));
    }

    @Override // com.baidu.tbadk.core.util.v
    public void a(String str, byte[] bArr) {
        if (this.d.a().a().c == null) {
            this.d.a().a().c = new HashMap<>();
        }
        this.d.a().a().c.put(str, bArr);
    }

    @Override // com.baidu.tbadk.core.util.v
    public void a(BasicNameValuePair basicNameValuePair) {
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

    private int a(ArrayList<BasicNameValuePair> arrayList, String str) {
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

    private LinkedList<BasicNameValuePair> j() {
        if (this.d != null) {
            LinkedList<BasicNameValuePair> linkedList = new LinkedList<>();
            if (!TextUtils.isEmpty(this.d.a().a().i)) {
                linkedList.add(new BasicNameValuePair("sid", this.d.a().a().i));
            }
            if (!TextUtils.isEmpty(this.d.a().a().j)) {
                linkedList.add(new BasicNameValuePair("net", this.d.a().a().j));
                return linkedList;
            }
            return linkedList;
        }
        return null;
    }
}
