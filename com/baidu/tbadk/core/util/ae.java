package com.baidu.tbadk.core.util;

import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.text.TextUtils;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.sapi2.SapiAccount;
import com.baidu.sapi2.SapiAccountManager;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.TbadkApplication;
import com.baidu.tbadk.core.data.AccountData;
import com.baidu.tbadk.core.relogin.ReloginManager;
import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import org.apache.http.message.BasicNameValuePair;
/* loaded from: classes.dex */
public class ae {
    private com.baidu.tbadk.core.util.httpNet.e a = null;
    private v b = null;
    private ae c = null;
    private ao d = null;
    private int e = 0;

    private void j() {
        this.a = new com.baidu.tbadk.core.util.httpNet.e();
        this.b = aj.a().a(this.a);
        this.c = null;
        this.a.a().a().j = com.baidu.tbadk.core.util.httpNet.j.a();
        this.a.a().a().i = this.a.a().f;
    }

    public com.baidu.tbadk.core.util.httpNet.e a() {
        return this.a;
    }

    public ae() {
        j();
    }

    public ae(String str) {
        j();
        this.a.a().a().a = str;
    }

    public void a(String str) {
        this.a.a().a().a = str;
    }

    public void a(ArrayList<BasicNameValuePair> arrayList) {
        this.b.a(arrayList);
    }

    public void a(String str, String str2) {
        this.b.a(str, str2);
    }

    public void a(BasicNameValuePair basicNameValuePair) {
        this.b.a(basicNameValuePair);
    }

    public void a(String str, byte[] bArr) {
        this.b.a(str, bArr);
    }

    private void k() {
        String currentBduss = TbadkApplication.getCurrentBduss();
        BasicNameValuePair basicNameValuePair = new BasicNameValuePair("BDUSS", currentBduss);
        BasicNameValuePair basicNameValuePair2 = new BasicNameValuePair("tbs", TbadkApplication.m252getInst().getTbs());
        if (currentBduss != null) {
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

    private void l() {
        if (this.d == null) {
            this.d = an.a();
        }
        if (this.d != null) {
            this.b.a("stTime", String.valueOf(this.d.b));
            this.b.a("stSize", String.valueOf(this.d.c));
            this.b.a("stTimesNum", String.valueOf(this.d.d));
            this.b.a("stMode", String.valueOf(this.d.e));
            this.b.a("stMethod", String.valueOf(this.d.a));
        }
        this.e = an.a(0);
        if (this.e == 0 && this.d != null) {
            this.e = this.d.d;
        }
        this.b.a("stErrorNums", String.valueOf(this.e));
    }

    public boolean b() {
        return this.a.b().a();
    }

    public int c() {
        return this.a.b().b;
    }

    public int d() {
        return this.a.b().a;
    }

    public String e() {
        return this.a.b().c;
    }

    public void f() {
        if (this.b != null) {
            this.b.b();
        }
        if (this.c != null) {
            this.c.f();
        }
    }

    private com.baidu.tbadk.core.data.j a(String str, String str2, boolean z) {
        String h;
        if (TextUtils.isEmpty(str) || TextUtils.isEmpty(str2)) {
            return null;
        }
        try {
            TbadkApplication.setCurrentAccount(null, TbadkApplication.m252getInst().getApp().getApplicationContext());
            StringBuilder sb = new StringBuilder(32);
            sb.append(TbConfig.LOGIN_FULL_ADDRESS);
            if (this.c == null) {
                this.c = new ae(sb.toString());
            } else {
                this.c.f();
            }
            this.c.a().a().d = false;
            this.c.a().a().c = false;
            this.c.a().a().b = false;
            this.c.a("un", str);
            this.c.a("passwd", str2);
            this.c.a("isphone", "0");
            this.c.a("channel_id", TbadkApplication.m252getInst().getPushChannelId());
            this.c.a("channel_uid", TbadkApplication.m252getInst().getPushChannelUserId());
            this.c.a().a().a().d = true;
            h = this.c.h();
        } catch (Exception e) {
            BdLog.detailException(e);
        }
        if (this.c.a().b().b() && h != null) {
            com.baidu.tbadk.core.data.j jVar = new com.baidu.tbadk.core.data.j();
            jVar.a(h);
            String userId = jVar.a().getUserId();
            if (userId == null || userId.length() <= 0) {
                this.a.b().c = TbadkApplication.m252getInst().getApp().getApplicationContext().getString(com.baidu.tieba.x.neterror);
                return null;
            }
            AccountData accountData = new AccountData();
            accountData.setAccount(jVar.a().getUserName());
            if (jVar.a().getPassword() != null) {
                accountData.setPassword(jVar.a().getPassword());
            } else {
                accountData.setPassword(str2);
            }
            accountData.setID(jVar.a().getUserId());
            accountData.setBDUSS(jVar.a().getBDUSS());
            accountData.setPortrait(jVar.a().getPortrait());
            accountData.setIsActive(1);
            if (jVar.b() != null) {
                accountData.setTbs(jVar.b().getTbs());
            }
            com.baidu.tbadk.core.account.a.a(accountData);
            TbadkApplication.setBdussAndTbsFromBackgroundInRelogin(accountData, accountData.getBDUSS(), accountData.getTbs());
            TbadkApplication.setCurrentAccount(accountData, TbadkApplication.m252getInst().getApp().getApplicationContext());
            return jVar;
        }
        if (this.c.b()) {
            switch (this.c.c()) {
                case 1:
                case 2:
                case 5:
                    if (z) {
                        Message obtainMessage = TbadkApplication.m252getInst().handler.obtainMessage(1);
                        Bundle bundle = new Bundle();
                        bundle.putString("account", str);
                        obtainMessage.setData(bundle);
                        TbadkApplication.m252getInst().handler.sendMessage(obtainMessage);
                        break;
                    }
                    break;
            }
            return null;
        }
        return null;
    }

    public byte[] g() {
        if (!this.a.a().e) {
            this.a.a().b(this.b);
        }
        return this.b.e();
    }

    private void m() {
        StringBuffer stringBuffer = new StringBuffer(1024);
        ArrayList<BasicNameValuePair> a = this.b.a();
        for (int i = 0; a != null && i < a.size(); i++) {
            BasicNameValuePair basicNameValuePair = a.get(i);
            if (basicNameValuePair != null) {
                String name = basicNameValuePair.getName();
                String value = basicNameValuePair.getValue();
                stringBuffer.append(String.valueOf(name) + "=");
                stringBuffer.append(value);
            }
        }
        stringBuffer.append("tiebaclient!!!");
        this.b.a("sign", com.baidu.adp.lib.util.i.a(stringBuffer.toString()));
    }

    /* JADX WARN: Removed duplicated region for block: B:46:0x010e  */
    /* JADX WARN: Removed duplicated region for block: B:63:0x0195  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private String a(int i) {
        String g;
        String str;
        switch (i) {
            case 1:
                if (a().a().d) {
                    this.a.a().b(this.b);
                }
                l();
                g = this.b.f();
                break;
            case 2:
                if (a().a().c) {
                    a().a().a(this.b);
                }
                if (a().a().d) {
                    this.a.a().b(this.b);
                }
                l();
                g = this.b.d();
                break;
            case 3:
                if (a().a().c) {
                    a().a().a(this.b);
                }
                if (a().a().d) {
                    this.a.a().b(this.b);
                }
                m();
                g = this.b.g();
                break;
            default:
                return null;
        }
        if (g == null && aj.a == 1 && this.a.b().a != 404 && this.a.b().a < 500) {
            if (!this.b.c()) {
                this.b = new NetWorkCore(this.a);
                switch (i) {
                    case 1:
                        if (a().a().d) {
                            this.a.a().b(this.b);
                        }
                        l();
                        g = this.b.f();
                        break;
                    case 2:
                        if (a().a().c) {
                            a().a().a(this.b);
                        }
                        if (a().a().d) {
                            this.a.a().b(this.b);
                        }
                        l();
                        g = this.b.d();
                        break;
                    case 3:
                        if (a().a().c) {
                            a().a().a(this.b);
                        }
                        if (a().a().d) {
                            this.a.a().b(this.b);
                        }
                        g = this.b.g();
                        break;
                    default:
                        return null;
                }
                if (g != null && this.a.b().b()) {
                    aj.b();
                    str = g;
                    if (this.a.b().a()) {
                        an.a(this.d);
                        an.b(this.e);
                        return str;
                    } else if (!this.a.b().b() && this.a.b().b == 1 && this.a.a().b) {
                        String str2 = this.a.b().c;
                        this.a.b().c = "";
                        AccountData currentAccountObj = TbadkApplication.getCurrentAccountObj();
                        AccountData c = currentAccountObj == null ? com.baidu.tbadk.core.account.a.c() : currentAccountObj;
                        if (c == null || TextUtils.isEmpty(c.getAccount())) {
                            TbadkApplication.m252getInst().handler.sendMessage(TbadkApplication.m252getInst().handler.obtainMessage(1));
                            return null;
                        }
                        com.baidu.tbadk.core.account.a.a(c.getAccount());
                        if (ReloginManager.a().d()) {
                            AccountData c2 = ReloginManager.a().c();
                            if (c2 == null) {
                                ReloginManager.a().a(c2);
                                return null;
                            }
                            return b(i);
                        }
                        com.baidu.tbadk.core.data.j a = a(c.getAccount(), c.getPassword(), true);
                        if (!TextUtils.isEmpty(c.getID())) {
                            if (c.getID().equals(TbadkApplication.getCurrentAccount())) {
                                SapiAccountManager.getInstance().logout();
                            } else {
                                List<SapiAccount> loginAccounts = SapiAccountManager.getInstance().getLoginAccounts();
                                if (loginAccounts != null && loginAccounts.size() > 0) {
                                    Iterator<SapiAccount> it = loginAccounts.iterator();
                                    while (true) {
                                        if (it.hasNext()) {
                                            SapiAccount next = it.next();
                                            if (c.getID().equals(next.uid)) {
                                                SapiAccountManager.getInstance().removeLoginAccount(next);
                                            }
                                        }
                                    }
                                }
                            }
                        }
                        if (a == null) {
                            if (this.c != null) {
                                this.a.b().c = this.c.e();
                                return null;
                            }
                            this.a.b().c = str2;
                            return str;
                        }
                        return b(i);
                    } else {
                        return str;
                    }
                }
            } else {
                BdLog.d("手动取消网络请求");
            }
        }
        str = g;
        if (this.a.b().a()) {
        }
    }

    private String b(int i) {
        String g;
        k();
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
                return null;
        }
        if (this.a.b().a()) {
            switch (this.a.b().b) {
                case 1:
                case 2:
                case 5:
                    TbadkApplication.m252getInst().handler.sendMessage(TbadkApplication.m252getInst().handler.obtainMessage(1));
                    this.a.b().c = "";
                    return null;
                case 3:
                case 4:
                default:
                    return g;
            }
        }
        return g;
    }

    public String h() {
        return a(2);
    }

    public String i() {
        return a(3);
    }

    public String b(String str) {
        byte[] bArr;
        try {
            InputStream h = s.h(str);
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
        return i();
    }

    public boolean a(String str, Handler handler, int i) {
        return a(str, handler, i, 5, 100);
    }

    public boolean a(String str, Handler handler, int i, int i2, int i3) {
        a().a().a(this.b);
        return this.b.a(str, handler, i, i2, i3);
    }
}
