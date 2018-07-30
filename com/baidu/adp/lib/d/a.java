package com.baidu.adp.lib.d;

import android.location.Address;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import com.baidu.adp.R;
import com.baidu.adp.base.BdBaseApplication;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tieba.model.ReportUserInfoModel;
import java.lang.ref.SoftReference;
import java.util.ArrayList;
import java.util.Iterator;
/* loaded from: classes.dex */
public class a {
    private static a za = null;
    public long yY = 10000;
    public long yZ = 0;
    private long zb = ReportUserInfoModel.TIME_INTERVAL;
    private boolean zc = false;
    private boolean zd = false;
    private boolean ze = false;
    private int errorCode = 4;
    private Address zf = null;
    private ArrayList<SoftReference<InterfaceC0014a>> zg = null;
    private ArrayList<com.baidu.adp.lib.d.b> zh = new ArrayList<>();
    private Handler handler = null;
    private b zi = new b() { // from class: com.baidu.adp.lib.d.a.1
        @Override // com.baidu.adp.lib.d.a.b
        public void a(int i, String str, Address address, long j, boolean z) {
            a.this.yZ = j;
            a.this.zf = address;
            a.this.zc = z;
            a.this.errorCode = i;
            a.this.hE();
            switch (i) {
                case 1:
                    if (StringUtils.isNull(str)) {
                        str = BdBaseApplication.getInst().getResources().getString(R.string.location_gps_offline);
                        break;
                    }
                    break;
                case 2:
                    if (StringUtils.isNull(str)) {
                        str = BdBaseApplication.getInst().getResources().getString(R.string.location_net_offline);
                        break;
                    }
                    break;
                case 3:
                    if (StringUtils.isNull(str)) {
                        str = BdBaseApplication.getInst().getResources().getString(R.string.location_all_offline);
                        break;
                    }
                    break;
                case 4:
                    if (StringUtils.isNull(str)) {
                        str = BdBaseApplication.getInst().getResources().getString(R.string.location_out_time);
                        break;
                    }
                    break;
            }
            a.this.a(i, str, address);
        }
    };

    /* renamed from: com.baidu.adp.lib.d.a$a  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public interface InterfaceC0014a {
        void b(int i, String str, Address address);
    }

    /* loaded from: classes.dex */
    public interface b {
        void a(int i, String str, Address address, long j, boolean z);
    }

    private a() {
    }

    public static a hB() {
        if (za == null) {
            synchronized (a.class) {
                if (za == null) {
                    za = new a();
                }
            }
        }
        return za;
    }

    public void a(com.baidu.adp.lib.d.b bVar) {
        if (bVar != null) {
            synchronized (this.zh) {
                if (!this.zh.contains(bVar)) {
                    bVar.a(this.zi);
                    this.zh.add(bVar);
                }
            }
        }
    }

    public void b(com.baidu.adp.lib.d.b bVar) {
        if (bVar != null) {
            synchronized (this.zh) {
                bVar.destroy();
                this.zh.remove(bVar);
            }
        }
    }

    public void initial() {
        this.zg = new ArrayList<>();
        hC();
    }

    private void hC() {
        this.handler = new Handler(Looper.getMainLooper(), new Handler.Callback() { // from class: com.baidu.adp.lib.d.a.2
            @Override // android.os.Handler.Callback
            public boolean handleMessage(Message message) {
                switch (message.what) {
                    case 0:
                        a.this.hE();
                        String str = "";
                        switch (a.this.errorCode) {
                            case 1:
                                str = BdBaseApplication.getInst().getResources().getString(R.string.location_gps_offline);
                                break;
                            case 2:
                                str = BdBaseApplication.getInst().getResources().getString(R.string.location_net_offline);
                                break;
                            case 3:
                                str = BdBaseApplication.getInst().getResources().getString(R.string.location_all_offline);
                                break;
                            case 4:
                                str = BdBaseApplication.getInst().getResources().getString(R.string.location_out_time);
                                break;
                            case 6:
                                str = BdBaseApplication.getInst().getResources().getString(R.string.location_out_time);
                                break;
                        }
                        a.this.a(a.this.errorCode, str, (Address) null);
                        return false;
                    default:
                        return false;
                }
            }
        });
    }

    public long hD() {
        return this.yY;
    }

    public Address H(boolean z) {
        return b(z, false);
    }

    public Address b(boolean z, boolean z2) {
        if (System.currentTimeMillis() - this.yZ > this.zb) {
            this.zf = null;
        }
        if (this.zf != null && !z && ((z2 && this.zc) || !z2)) {
            return this.zf;
        }
        this.zf = null;
        if (!this.ze) {
            I(z2);
            return null;
        } else if (this.ze && z2 && !this.zd) {
            hE();
            I(z2);
            return null;
        } else {
            return null;
        }
    }

    public Address a(boolean z, InterfaceC0014a interfaceC0014a) {
        return a(z, false, interfaceC0014a);
    }

    public Address a(boolean z, boolean z2, InterfaceC0014a interfaceC0014a) {
        boolean z3;
        InterfaceC0014a interfaceC0014a2;
        if (System.currentTimeMillis() - this.yZ > this.zb) {
            this.zf = null;
        }
        if (this.zf != null && !z && ((z2 && this.zc) || !z2)) {
            if (interfaceC0014a != null) {
                interfaceC0014a.b(0, "", this.zf);
            }
            return this.zf;
        }
        if (interfaceC0014a != null) {
            synchronized (this.zg) {
                int i = 0;
                while (true) {
                    if (i >= this.zg.size()) {
                        z3 = false;
                        break;
                    }
                    SoftReference<InterfaceC0014a> softReference = this.zg.get(i);
                    if (softReference == null || (interfaceC0014a2 = softReference.get()) == null || !interfaceC0014a2.equals(interfaceC0014a)) {
                        i++;
                    } else {
                        z3 = true;
                        break;
                    }
                }
                if (!z3) {
                    if (this.zg.size() >= 100) {
                        this.zg.remove(0);
                    }
                    this.zg.add(new SoftReference<>(interfaceC0014a));
                }
            }
            if (!this.ze) {
                I(z2);
                return null;
            } else if (this.ze && z2 && !this.zd) {
                hE();
                I(z2);
                return null;
            }
        }
        return null;
    }

    public void a(InterfaceC0014a interfaceC0014a) {
        InterfaceC0014a interfaceC0014a2;
        synchronized (this.zg) {
            int i = 0;
            while (true) {
                if (i < this.zg.size()) {
                    SoftReference<InterfaceC0014a> softReference = this.zg.get(i);
                    if (softReference == null || (interfaceC0014a2 = softReference.get()) == null || !interfaceC0014a2.equals(interfaceC0014a)) {
                        i++;
                    } else {
                        this.zg.remove(softReference);
                        break;
                    }
                } else {
                    break;
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void hE() {
        if (this.handler.hasMessages(0)) {
            this.handler.removeMessages(0);
        }
        this.ze = false;
        Iterator<com.baidu.adp.lib.d.b> it = this.zh.iterator();
        while (it.hasNext()) {
            com.baidu.adp.lib.d.b next = it.next();
            if (next != null) {
                try {
                    next.hF();
                } catch (Exception e) {
                    BdLog.e(e.getMessage());
                }
            }
        }
    }

    private void I(boolean z) {
        if (this.handler.hasMessages(0)) {
            this.handler.removeMessages(0);
        }
        this.errorCode = 4;
        this.zd = z;
        this.ze = true;
        if (this.zh == null || this.zh.isEmpty()) {
            this.errorCode = 6;
            this.handler.sendMessage(this.handler.obtainMessage(0));
            return;
        }
        Iterator<com.baidu.adp.lib.d.b> it = this.zh.iterator();
        while (it.hasNext()) {
            com.baidu.adp.lib.d.b next = it.next();
            if (next != null) {
                try {
                    next.J(z);
                } catch (Exception e) {
                    BdLog.e(e.getMessage());
                }
            }
        }
        this.handler.sendMessageDelayed(this.handler.obtainMessage(0), this.yY);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(int i, String str, Address address) {
        InterfaceC0014a interfaceC0014a;
        int i2 = 0;
        if (this.handler.hasMessages(0)) {
            this.handler.removeMessages(0);
        }
        if (this.zg != null) {
            synchronized (this.zg) {
                while (true) {
                    int i3 = i2;
                    if (i3 < this.zg.size()) {
                        SoftReference<InterfaceC0014a> softReference = this.zg.get(i3);
                        if (softReference != null && (interfaceC0014a = softReference.get()) != null) {
                            interfaceC0014a.b(i, str, address);
                        }
                        i2 = i3 + 1;
                    } else {
                        this.zg.clear();
                    }
                }
            }
        }
    }
}
