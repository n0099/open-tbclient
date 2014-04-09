package com.baidu.tbadk.core.util;

import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import com.baidu.tbadk.TbadkApplication;
import com.baidu.tbadk.core.data.AccountData;
import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.util.ArrayList;
import org.apache.http.message.BasicNameValuePair;
/* loaded from: classes.dex */
public final class ak {
    private com.baidu.tbadk.core.util.a.a a = null;
    private z b = null;
    private ak c = null;
    private au d = null;
    private int e = 0;

    private void k() {
        this.a = new com.baidu.tbadk.core.util.a.a();
        ap.a();
        this.b = ap.a(this.a);
        this.c = null;
        this.a.a().a().j = com.baidu.tbadk.core.util.a.g.a();
        this.a.a().a().i = this.a.a().f;
    }

    public final com.baidu.tbadk.core.util.a.a a() {
        return this.a;
    }

    public ak() {
        k();
    }

    public ak(String str) {
        k();
        this.a.a().a().a = str;
    }

    public final void a(String str) {
        this.a.a().a().a = str;
    }

    public final void a(ArrayList<BasicNameValuePair> arrayList) {
        this.b.a(arrayList);
    }

    public final void a(String str, String str2) {
        this.b.a(str, str2);
    }

    public final void a(BasicNameValuePair basicNameValuePair) {
        this.b.a(basicNameValuePair);
    }

    public final void a(String str, byte[] bArr) {
        this.b.a(str, bArr);
    }

    private void l() {
        String D = TbadkApplication.D();
        BasicNameValuePair basicNameValuePair = new BasicNameValuePair("BDUSS", D);
        TbadkApplication.j();
        BasicNameValuePair basicNameValuePair2 = new BasicNameValuePair("tbs", TbadkApplication.A());
        com.baidu.adp.lib.util.f.a("NetWork", "modSessionData", "== BDUSS:" + D);
        StringBuilder sb = new StringBuilder("== TBS:");
        TbadkApplication.j();
        com.baidu.adp.lib.util.f.a("NetWork", "modSessionData", sb.append(TbadkApplication.A()).toString());
        if (D != null) {
            ArrayList<BasicNameValuePair> a = this.b.a();
            int size = a.size();
            for (int i = 0; i < size; i++) {
                BasicNameValuePair basicNameValuePair3 = a.get(i);
                if (basicNameValuePair3.getName().equals("BDUSS")) {
                    a.set(i, basicNameValuePair);
                } else if (basicNameValuePair3.getName().equals("tbs")) {
                    a.set(i, basicNameValuePair2);
                }
            }
        }
    }

    public final int b() {
        return this.a.c().a.b;
    }

    private void m() {
        if (this.d == null) {
            this.d = at.a();
        }
        if (this.d != null) {
            this.b.a("stTime", String.valueOf(this.d.b));
            this.b.a("stSize", String.valueOf(this.d.c));
            this.b.a("stTimesNum", String.valueOf(this.d.d));
            this.b.a("stMode", String.valueOf(this.d.e));
            this.b.a("stMethod", String.valueOf(this.d.a));
        }
        this.e = at.a(0);
        if (this.e == 0 && this.d != null) {
            this.e = this.d.d;
        }
        this.b.a("stErrorNums", String.valueOf(this.e));
    }

    public final boolean c() {
        return this.a.b().a();
    }

    public final int d() {
        return this.a.b().b;
    }

    public final int e() {
        return this.a.b().a;
    }

    public final String f() {
        return this.a.b().c;
    }

    public final void g() {
        while (true) {
            if (this.b != null) {
                this.b.b();
            }
            if (this.c != null) {
                this = this.c;
            } else {
                return;
            }
        }
    }

    private com.baidu.tbadk.core.data.h a(String str, String str2, boolean z) {
        String i;
        try {
            com.baidu.adp.lib.util.f.a(getClass().toString(), "login", "=== need auto login");
            TbadkApplication.a((AccountData) null, TbadkApplication.j().b().getApplicationContext());
            StringBuilder sb = new StringBuilder(32);
            sb.append(com.baidu.tbadk.core.data.n.a);
            sb.append("c/s/login");
            if (this.c == null) {
                this.c = new ak(sb.toString());
            } else {
                this.c.g();
            }
            this.c.a.a().d = false;
            this.c.a.a().c = false;
            this.c.a.a().b = false;
            this.c.a("un", str);
            this.c.a("passwd", str2);
            this.c.a("isphone", "0");
            this.c.a("channel_id", TbadkApplication.j().S());
            this.c.a("channel_uid", TbadkApplication.j().R());
            this.c.a.a().a().d = true;
            i = this.c.i();
        } catch (Exception e) {
            com.baidu.adp.lib.util.f.b(getClass().toString(), "login", e.getMessage());
        }
        if (this.c.a.b().b() && i != null) {
            com.baidu.tbadk.core.data.h hVar = new com.baidu.tbadk.core.data.h();
            hVar.a(i);
            String userId = hVar.a().getUserId();
            if (userId == null || userId.length() <= 0) {
                this.a.b().c = TbadkApplication.j().b().getApplicationContext().getString(com.baidu.tbadk.l.neterror);
                return null;
            }
            AccountData accountData = new AccountData();
            accountData.setAccount(hVar.a().getUserName());
            if (hVar.a().getPassword() != null) {
                accountData.setPassword(hVar.a().getPassword());
            } else {
                accountData.setPassword(str2);
            }
            accountData.setID(hVar.a().getUserId());
            accountData.setBDUSS(hVar.a().getBDUSS());
            accountData.setPortrait(hVar.a().getPortrait());
            accountData.setIsActive(1);
            if (hVar.b() != null) {
                accountData.setTbs(hVar.b().getTbs());
            }
            com.baidu.tbadk.core.a.o.a(accountData);
            TbadkApplication.a(accountData, TbadkApplication.j().b().getApplicationContext());
            return hVar;
        }
        if (this.c.c()) {
            switch (this.c.d()) {
                case 1:
                case 2:
                case 5:
                    Message obtainMessage = TbadkApplication.j().F.obtainMessage(1);
                    Bundle bundle = new Bundle();
                    bundle.putString("account", str);
                    obtainMessage.setData(bundle);
                    TbadkApplication.j().F.sendMessage(obtainMessage);
                    break;
            }
            return null;
        }
        return null;
    }

    public final byte[] h() {
        if (!this.a.a().e) {
            this.a.a().b(this.b);
        }
        return this.b.e();
    }

    private String a(int i) {
        String g;
        switch (i) {
            case 1:
                if (this.a.a().d) {
                    this.a.a().b(this.b);
                }
                m();
                g = this.b.f();
                break;
            case 2:
                if (this.a.a().c) {
                    this.a.a().a(this.b);
                }
                if (this.a.a().d) {
                    this.a.a().b(this.b);
                }
                m();
                g = this.b.d();
                break;
            case 3:
                if (this.a.a().c) {
                    this.a.a().a(this.b);
                }
                if (this.a.a().d) {
                    this.a.a().b(this.b);
                }
                StringBuffer stringBuffer = new StringBuffer(1024);
                ArrayList<BasicNameValuePair> a = this.b.a();
                for (int i2 = 0; a != null && i2 < a.size(); i2++) {
                    BasicNameValuePair basicNameValuePair = a.get(i2);
                    if (basicNameValuePair != null) {
                        String name = basicNameValuePair.getName();
                        String value = basicNameValuePair.getValue();
                        stringBuffer.append(String.valueOf(name) + "=");
                        stringBuffer.append(value);
                    }
                }
                stringBuffer.append("tiebaclient!!!");
                this.b.a("sign", com.baidu.adp.lib.util.h.a(stringBuffer.toString()));
                g = this.b.g();
                break;
            default:
                return null;
        }
        if (g == null && ap.a == 1 && this.a.b().a != 404) {
            if (!this.b.c()) {
                this.b = new NetWorkCore(this.a);
                switch (i) {
                    case 1:
                        if (this.a.a().d) {
                            this.a.a().b(this.b);
                        }
                        m();
                        g = this.b.f();
                        break;
                    case 2:
                        if (this.a.a().c) {
                            this.a.a().a(this.b);
                        }
                        if (this.a.a().d) {
                            this.a.a().b(this.b);
                        }
                        m();
                        g = this.b.d();
                        break;
                    case 3:
                        if (this.a.a().c) {
                            this.a.a().a(this.b);
                        }
                        if (this.a.a().d) {
                            this.a.a().b(this.b);
                        }
                        g = this.b.g();
                        break;
                    default:
                        return null;
                }
                if (g != null && this.a.b().b()) {
                    ap.b();
                }
            } else {
                com.baidu.adp.lib.util.f.e("手动取消网络请求");
            }
        }
        if (!this.a.b().a()) {
            at.a(this.d);
            at.b(this.e);
            return g;
        } else if (this.a.b().b()) {
            return g;
        } else {
            if (this.a.b().b == 1 && this.a.a().b) {
                this.a.b().c = "";
                AccountData N = TbadkApplication.N();
                if (N == null) {
                    N = com.baidu.tbadk.core.a.o.c();
                }
                if (N == null) {
                    TbadkApplication.j().F.sendMessage(TbadkApplication.j().F.obtainMessage(1));
                    return null;
                } else if (a(N.getAccount(), N.getPassword(), true) == null) {
                    if (this.c != null) {
                        this.a.b().c = this.c.f();
                        return null;
                    }
                    return null;
                } else {
                    l();
                    switch (i) {
                        case 1:
                            g = this.b.f();
                            break;
                        case 2:
                            g = this.b.d();
                            break;
                        case 3:
                            g = this.b.g();
                            break;
                        default:
                            g = null;
                            break;
                    }
                }
            }
            return g;
        }
    }

    public final String i() {
        return a(2);
    }

    public final String j() {
        return a(3);
    }

    public final String b(String str) {
        byte[] bArr;
        com.baidu.adp.lib.util.f.e("NetWork", "uploadImage", "upload image");
        try {
            InputStream h = w.h(str);
            byte[] bArr2 = new byte[5120];
            ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream(5120);
            while (true) {
                int read = h.read(bArr2);
                if (read == -1) {
                    break;
                }
                byteArrayOutputStream.write(bArr2, 0, read);
            }
            bArr = byteArrayOutputStream.toByteArray();
        } catch (Exception e) {
            bArr = null;
        }
        if (bArr == null || bArr.length <= 0) {
            return null;
        }
        a("pic", bArr);
        return j();
    }

    public final boolean a(String str, Handler handler, int i) {
        return a(str, handler, i, 5, 100);
    }

    public final boolean a(String str, Handler handler, int i, int i2, int i3) {
        this.a.a().a(this.b);
        return this.b.a(str, handler, i, i2, i3);
    }
}
