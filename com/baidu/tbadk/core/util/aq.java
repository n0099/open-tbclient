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
import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import org.apache.http.message.BasicNameValuePair;
/* loaded from: classes.dex */
public class aq {
    private com.baidu.tbadk.core.util.httpNet.c a = null;
    private ac b = null;
    private aq c = null;
    private ba d = null;
    private int e = 0;

    private void k() {
        this.a = new com.baidu.tbadk.core.util.httpNet.c();
        this.b = av.a().a(this.a);
        this.c = null;
        this.a.a().a().j = com.baidu.tbadk.core.util.httpNet.h.a();
        this.a.a().a().i = this.a.a().f;
    }

    public com.baidu.tbadk.core.util.httpNet.c a() {
        return this.a;
    }

    public aq() {
        k();
    }

    public aq(String str) {
        k();
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

    private void l() {
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

    public int b() {
        return this.a.c().a.b;
    }

    private void m() {
        if (this.d == null) {
            this.d = az.a();
        }
        if (this.d != null) {
            this.b.a("stTime", String.valueOf(this.d.b));
            this.b.a("stSize", String.valueOf(this.d.c));
            this.b.a("stTimesNum", String.valueOf(this.d.d));
            this.b.a("stMode", String.valueOf(this.d.e));
            this.b.a("stMethod", String.valueOf(this.d.a));
        }
        this.e = az.a(0);
        if (this.e == 0 && this.d != null) {
            this.e = this.d.d;
        }
        this.b.a("stErrorNums", String.valueOf(this.e));
    }

    public boolean c() {
        return this.a.b().a();
    }

    public int d() {
        return this.a.b().b;
    }

    public int e() {
        return this.a.b().a;
    }

    public String f() {
        return this.a.b().c;
    }

    public void g() {
        if (this.b != null) {
            this.b.b();
        }
        if (this.c != null) {
            this.c.g();
        }
    }

    public com.baidu.tbadk.core.data.i a(String str, String str2, boolean z) {
        try {
            TbadkApplication.setCurrentAccount(null, TbadkApplication.m252getInst().getApp().getApplicationContext());
        } catch (Exception e) {
            BdLog.detailException(e);
        }
        if (TextUtils.isEmpty(str) || TextUtils.isEmpty(str2)) {
            return null;
        }
        StringBuilder sb = new StringBuilder(32);
        sb.append(TbConfig.SERVER_ADDRESS);
        sb.append(TbConfig.LOGIN_ADDRESS);
        if (this.c == null) {
            this.c = new aq(sb.toString());
        } else {
            this.c.g();
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
        String i = this.c.i();
        if (this.c.a().b().b() && i != null) {
            com.baidu.tbadk.core.data.i iVar = new com.baidu.tbadk.core.data.i();
            iVar.a(i);
            String userId = iVar.a().getUserId();
            if (userId == null || userId.length() <= 0) {
                this.a.b().c = TbadkApplication.m252getInst().getApp().getApplicationContext().getString(com.baidu.tieba.y.neterror);
                return null;
            }
            AccountData accountData = new AccountData();
            accountData.setAccount(iVar.a().getUserName());
            if (iVar.a().getPassword() != null) {
                accountData.setPassword(iVar.a().getPassword());
            } else {
                accountData.setPassword(str2);
            }
            accountData.setID(iVar.a().getUserId());
            accountData.setBDUSS(iVar.a().getBDUSS());
            accountData.setPortrait(iVar.a().getPortrait());
            accountData.setIsActive(1);
            if (iVar.b() != null) {
                accountData.setTbs(iVar.b().getTbs());
            }
            com.baidu.tbadk.core.account.a.a(accountData);
            TbadkApplication.setCurrentAccount(accountData, TbadkApplication.m252getInst().getApp().getApplicationContext());
            return iVar;
        }
        if (this.c.c()) {
            switch (this.c.d()) {
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

    public byte[] h() {
        if (!this.a.a().e) {
            this.a.a().b(this.b);
        }
        return this.b.e();
    }

    private void n() {
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
                m();
                g = this.b.f();
                break;
            case 2:
                if (a().a().c) {
                    a().a().a(this.b);
                }
                if (a().a().d) {
                    this.a.a().b(this.b);
                }
                m();
                g = this.b.d();
                break;
            case 3:
                if (a().a().c) {
                    a().a().a(this.b);
                }
                if (a().a().d) {
                    this.a.a().b(this.b);
                }
                n();
                g = this.b.g();
                break;
            default:
                return null;
        }
        if (g == null && av.a == 1 && this.a.b().a != 404 && this.a.b().a < 500) {
            if (!this.b.c()) {
                this.b = new NetWorkCore(this.a);
                switch (i) {
                    case 1:
                        if (a().a().d) {
                            this.a.a().b(this.b);
                        }
                        m();
                        g = this.b.f();
                        break;
                    case 2:
                        if (a().a().c) {
                            a().a().a(this.b);
                        }
                        if (a().a().d) {
                            this.a.a().b(this.b);
                        }
                        m();
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
                    av.b();
                    str = g;
                    if (this.a.b().a()) {
                        az.a(this.d);
                        az.b(this.e);
                        return str;
                    } else if (!this.a.b().b() && this.a.b().b == 1 && this.a.a().b) {
                        String str2 = this.a.b().c;
                        this.a.b().c = "";
                        AccountData currentAccountObj = TbadkApplication.getCurrentAccountObj();
                        AccountData c = currentAccountObj == null ? com.baidu.tbadk.core.account.a.c() : currentAccountObj;
                        if (c == null) {
                            TbadkApplication.m252getInst().handler.sendMessage(TbadkApplication.m252getInst().handler.obtainMessage(1));
                            return null;
                        }
                        com.baidu.tbadk.core.data.i a = a(c.getAccount(), c.getPassword(), true);
                        com.baidu.tbadk.core.account.a.a(c.getAccount());
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
                                this.a.b().c = this.c.f();
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
        l();
        switch (i) {
            case 1:
                return this.b.f();
            case 2:
                return this.b.d();
            case 3:
                return this.b.g();
            default:
                return null;
        }
    }

    public String i() {
        return a(2);
    }

    public String j() {
        return a(3);
    }

    public String b(String str) {
        byte[] bArr;
        try {
            InputStream h = z.h(str);
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

    public boolean a(String str, Handler handler, int i) {
        return a(str, handler, i, 5, 100);
    }

    public boolean a(String str, Handler handler, int i, int i2, int i3) {
        a().a().a(this.b);
        return this.b.a(str, handler, i, i2, i3);
    }
}
