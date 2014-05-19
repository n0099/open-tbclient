package com.baidu.tbadk.core.util;

import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.TbadkApplication;
import com.baidu.tbadk.core.data.AccountData;
import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.util.ArrayList;
import org.apache.http.message.BasicNameValuePair;
/* loaded from: classes.dex */
public class al {
    private com.baidu.tbadk.core.util.a.a a = null;
    private aa b = null;
    private al c = null;
    private av d = null;
    private int e = 0;

    private void k() {
        this.a = new com.baidu.tbadk.core.util.a.a();
        this.b = aq.a().a(this.a);
        this.c = null;
        this.a.a().a().j = com.baidu.tbadk.core.util.a.g.a();
        this.a.a().a().i = this.a.a().f;
    }

    public com.baidu.tbadk.core.util.a.a a() {
        return this.a;
    }

    public al() {
        k();
    }

    public al(String str) {
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
        BdLog.i("NetWork", "modSessionData", "== BDUSS:" + currentBduss);
        BdLog.i("NetWork", "modSessionData", "== TBS:" + TbadkApplication.m252getInst().getTbs());
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
            this.d = au.a();
        }
        if (this.d != null) {
            this.b.a("stTime", String.valueOf(this.d.b));
            this.b.a("stSize", String.valueOf(this.d.c));
            this.b.a("stTimesNum", String.valueOf(this.d.d));
            this.b.a("stMode", String.valueOf(this.d.e));
            this.b.a("stMethod", String.valueOf(this.d.a));
        }
        this.e = au.a(0);
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
        String i;
        try {
            BdLog.i(getClass().toString(), TbConfig.ST_TYPE_LOGIN, "=== need auto login");
            TbadkApplication.setCurrentAccount(null, TbadkApplication.m252getInst().getApp().getApplicationContext());
            StringBuilder sb = new StringBuilder(32);
            sb.append(TbConfig.SERVER_ADDRESS);
            sb.append(TbConfig.LOGIN_ADDRESS);
            if (this.c == null) {
                this.c = new al(sb.toString());
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
            i = this.c.i();
        } catch (Exception e) {
            BdLog.detailException("background login failed.", e);
        }
        if (this.c.a().b().b() && i != null) {
            com.baidu.tbadk.core.data.i iVar = new com.baidu.tbadk.core.data.i();
            iVar.a(i);
            String userId = iVar.a().getUserId();
            if (userId == null || userId.length() <= 0) {
                this.a.b().c = TbadkApplication.m252getInst().getApp().getApplicationContext().getString(com.baidu.tieba.u.neterror);
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
        this.b.a("sign", com.baidu.adp.lib.util.g.a(stringBuffer.toString()));
    }

    private String a(int i) {
        String g;
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
        if (g == null && aq.a == 1 && this.a.b().a != 404) {
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
                    aq.b();
                }
            } else {
                BdLog.d("手动取消网络请求");
            }
        }
        if (!this.a.b().a()) {
            au.a(this.d);
            au.b(this.e);
            return g;
        } else if (!this.a.b().b() && this.a.b().b == 1 && this.a.a().b) {
            this.a.b().c = "";
            AccountData currentAccountObj = TbadkApplication.getCurrentAccountObj();
            if (currentAccountObj == null) {
                currentAccountObj = com.baidu.tbadk.core.account.a.c();
            }
            if (currentAccountObj == null) {
                TbadkApplication.m252getInst().handler.sendMessage(TbadkApplication.m252getInst().handler.obtainMessage(1));
                return null;
            } else if (a(currentAccountObj.getAccount(), currentAccountObj.getPassword(), true) == null) {
                if (this.c != null) {
                    this.a.b().c = this.c.f();
                    return null;
                }
                return g;
            } else {
                return b(i);
            }
        } else {
            return g;
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
        BdLog.d("NetWork", "uploadImage", "upload image");
        try {
            InputStream h = x.h(str);
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
