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
    private static a zU = null;
    public long zS = 10000;
    public long zT = 0;
    private long zV = ReportUserInfoModel.TIME_INTERVAL;
    private boolean zW = false;
    private boolean zX = false;
    private boolean zY = false;
    private int errorCode = 4;
    private Address zZ = null;
    private ArrayList<SoftReference<InterfaceC0015a>> Aa = null;
    private ArrayList<com.baidu.adp.lib.d.b> Ab = new ArrayList<>();
    private Handler handler = null;
    private b Ac = new b() { // from class: com.baidu.adp.lib.d.a.1
        @Override // com.baidu.adp.lib.d.a.b
        public void a(int i, String str, Address address, long j, boolean z) {
            a.this.zT = j;
            a.this.zZ = address;
            a.this.zW = z;
            a.this.errorCode = i;
            a.this.ib();
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
    public interface InterfaceC0015a {
        void b(int i, String str, Address address);
    }

    /* loaded from: classes.dex */
    public interface b {
        void a(int i, String str, Address address, long j, boolean z);
    }

    private a() {
    }

    public static a hY() {
        if (zU == null) {
            synchronized (a.class) {
                if (zU == null) {
                    zU = new a();
                }
            }
        }
        return zU;
    }

    public void a(com.baidu.adp.lib.d.b bVar) {
        if (bVar != null) {
            synchronized (this.Ab) {
                if (!this.Ab.contains(bVar)) {
                    bVar.a(this.Ac);
                    this.Ab.add(bVar);
                }
            }
        }
    }

    public void b(com.baidu.adp.lib.d.b bVar) {
        if (bVar != null) {
            synchronized (this.Ab) {
                bVar.destroy();
                this.Ab.remove(bVar);
            }
        }
    }

    public void initial() {
        this.Aa = new ArrayList<>();
        hZ();
    }

    private void hZ() {
        this.handler = new Handler(Looper.getMainLooper(), new Handler.Callback() { // from class: com.baidu.adp.lib.d.a.2
            @Override // android.os.Handler.Callback
            public boolean handleMessage(Message message) {
                switch (message.what) {
                    case 0:
                        a.this.ib();
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

    public long ia() {
        return this.zS;
    }

    public Address X(boolean z) {
        return c(z, false);
    }

    public Address c(boolean z, boolean z2) {
        if (System.currentTimeMillis() - this.zT > this.zV) {
            this.zZ = null;
        }
        if (this.zZ != null && !z && ((z2 && this.zW) || !z2)) {
            return this.zZ;
        }
        this.zZ = null;
        if (!this.zY) {
            Y(z2);
            return null;
        } else if (this.zY && z2 && !this.zX) {
            ib();
            Y(z2);
            return null;
        } else {
            return null;
        }
    }

    public Address a(boolean z, InterfaceC0015a interfaceC0015a) {
        return a(z, false, interfaceC0015a);
    }

    public Address a(boolean z, boolean z2, InterfaceC0015a interfaceC0015a) {
        boolean z3;
        InterfaceC0015a interfaceC0015a2;
        if (System.currentTimeMillis() - this.zT > this.zV) {
            this.zZ = null;
        }
        if (this.zZ != null && !z && ((z2 && this.zW) || !z2)) {
            if (interfaceC0015a != null) {
                interfaceC0015a.b(0, "", this.zZ);
            }
            return this.zZ;
        }
        if (interfaceC0015a != null) {
            synchronized (this.Aa) {
                int i = 0;
                while (true) {
                    if (i >= this.Aa.size()) {
                        z3 = false;
                        break;
                    }
                    SoftReference<InterfaceC0015a> softReference = this.Aa.get(i);
                    if (softReference == null || (interfaceC0015a2 = softReference.get()) == null || !interfaceC0015a2.equals(interfaceC0015a)) {
                        i++;
                    } else {
                        z3 = true;
                        break;
                    }
                }
                if (!z3) {
                    if (this.Aa.size() >= 100) {
                        this.Aa.remove(0);
                    }
                    this.Aa.add(new SoftReference<>(interfaceC0015a));
                }
            }
            if (!this.zY) {
                Y(z2);
                return null;
            } else if (this.zY && z2 && !this.zX) {
                ib();
                Y(z2);
                return null;
            }
        }
        return null;
    }

    public void a(InterfaceC0015a interfaceC0015a) {
        InterfaceC0015a interfaceC0015a2;
        synchronized (this.Aa) {
            int i = 0;
            while (true) {
                if (i < this.Aa.size()) {
                    SoftReference<InterfaceC0015a> softReference = this.Aa.get(i);
                    if (softReference == null || (interfaceC0015a2 = softReference.get()) == null || !interfaceC0015a2.equals(interfaceC0015a)) {
                        i++;
                    } else {
                        this.Aa.remove(softReference);
                        break;
                    }
                } else {
                    break;
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ib() {
        if (this.handler.hasMessages(0)) {
            this.handler.removeMessages(0);
        }
        this.zY = false;
        Iterator<com.baidu.adp.lib.d.b> it = this.Ab.iterator();
        while (it.hasNext()) {
            com.baidu.adp.lib.d.b next = it.next();
            if (next != null) {
                try {
                    next.ic();
                } catch (Exception e) {
                    BdLog.e(e.getMessage());
                }
            }
        }
    }

    private void Y(boolean z) {
        if (this.handler.hasMessages(0)) {
            this.handler.removeMessages(0);
        }
        this.errorCode = 4;
        this.zX = z;
        this.zY = true;
        if (this.Ab == null || this.Ab.isEmpty()) {
            this.errorCode = 6;
            this.handler.sendMessage(this.handler.obtainMessage(0));
            return;
        }
        Iterator<com.baidu.adp.lib.d.b> it = this.Ab.iterator();
        while (it.hasNext()) {
            com.baidu.adp.lib.d.b next = it.next();
            if (next != null) {
                try {
                    next.Z(z);
                } catch (Exception e) {
                    BdLog.e(e.getMessage());
                }
            }
        }
        this.handler.sendMessageDelayed(this.handler.obtainMessage(0), this.zS);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(int i, String str, Address address) {
        InterfaceC0015a interfaceC0015a;
        int i2 = 0;
        if (this.handler.hasMessages(0)) {
            this.handler.removeMessages(0);
        }
        if (this.Aa != null) {
            synchronized (this.Aa) {
                while (true) {
                    int i3 = i2;
                    if (i3 < this.Aa.size()) {
                        SoftReference<InterfaceC0015a> softReference = this.Aa.get(i3);
                        if (softReference != null && (interfaceC0015a = softReference.get()) != null) {
                            interfaceC0015a.b(i, str, address);
                        }
                        i2 = i3 + 1;
                    } else {
                        this.Aa.clear();
                    }
                }
            }
        }
    }
}
