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
    private static a wC = null;
    public long wA = 10000;
    public long wB = 0;
    private long wD = ReportUserInfoModel.TIME_INTERVAL;
    private boolean wE = false;
    private boolean wF = false;
    private boolean wG = false;
    private int errorCode = 4;
    private Address wH = null;
    private ArrayList<SoftReference<InterfaceC0004a>> wI = null;
    private ArrayList<com.baidu.adp.lib.d.b> wJ = new ArrayList<>();
    private Handler handler = null;
    private b wK = new b() { // from class: com.baidu.adp.lib.d.a.1
        @Override // com.baidu.adp.lib.d.a.b
        public void a(int i, String str, Address address, long j, boolean z) {
            a.this.wB = j;
            a.this.wH = address;
            a.this.wE = z;
            a.this.errorCode = i;
            a.this.fr();
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
    public interface InterfaceC0004a {
        void b(int i, String str, Address address);
    }

    /* loaded from: classes.dex */
    public interface b {
        void a(int i, String str, Address address, long j, boolean z);
    }

    private a() {
    }

    public static a fo() {
        if (wC == null) {
            synchronized (a.class) {
                if (wC == null) {
                    wC = new a();
                }
            }
        }
        return wC;
    }

    public void a(com.baidu.adp.lib.d.b bVar) {
        if (bVar != null) {
            synchronized (this.wJ) {
                if (!this.wJ.contains(bVar)) {
                    bVar.a(this.wK);
                    this.wJ.add(bVar);
                }
            }
        }
    }

    public void b(com.baidu.adp.lib.d.b bVar) {
        if (bVar != null) {
            synchronized (this.wJ) {
                bVar.destroy();
                this.wJ.remove(bVar);
            }
        }
    }

    public void initial() {
        this.wI = new ArrayList<>();
        fp();
    }

    private void fp() {
        this.handler = new Handler(Looper.getMainLooper(), new Handler.Callback() { // from class: com.baidu.adp.lib.d.a.2
            @Override // android.os.Handler.Callback
            public boolean handleMessage(Message message) {
                switch (message.what) {
                    case 0:
                        a.this.fr();
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

    public long fq() {
        return this.wA;
    }

    public Address C(boolean z) {
        return b(z, false);
    }

    public Address b(boolean z, boolean z2) {
        if (System.currentTimeMillis() - this.wB > this.wD) {
            this.wH = null;
        }
        if (this.wH != null && !z && ((z2 && this.wE) || !z2)) {
            return this.wH;
        }
        this.wH = null;
        if (!this.wG) {
            D(z2);
            return null;
        } else if (this.wG && z2 && !this.wF) {
            fr();
            D(z2);
            return null;
        } else {
            return null;
        }
    }

    public Address a(boolean z, InterfaceC0004a interfaceC0004a) {
        return a(z, false, interfaceC0004a);
    }

    public Address a(boolean z, boolean z2, InterfaceC0004a interfaceC0004a) {
        boolean z3;
        InterfaceC0004a interfaceC0004a2;
        if (System.currentTimeMillis() - this.wB > this.wD) {
            this.wH = null;
        }
        if (this.wH != null && !z && ((z2 && this.wE) || !z2)) {
            if (interfaceC0004a != null) {
                interfaceC0004a.b(0, "", this.wH);
            }
            return this.wH;
        }
        if (interfaceC0004a != null) {
            synchronized (this.wI) {
                int i = 0;
                while (true) {
                    if (i >= this.wI.size()) {
                        z3 = false;
                        break;
                    }
                    SoftReference<InterfaceC0004a> softReference = this.wI.get(i);
                    if (softReference == null || (interfaceC0004a2 = softReference.get()) == null || !interfaceC0004a2.equals(interfaceC0004a)) {
                        i++;
                    } else {
                        z3 = true;
                        break;
                    }
                }
                if (!z3) {
                    if (this.wI.size() >= 100) {
                        this.wI.remove(0);
                    }
                    this.wI.add(new SoftReference<>(interfaceC0004a));
                }
            }
            if (!this.wG) {
                D(z2);
                return null;
            } else if (this.wG && z2 && !this.wF) {
                fr();
                D(z2);
                return null;
            }
        }
        return null;
    }

    public void a(InterfaceC0004a interfaceC0004a) {
        InterfaceC0004a interfaceC0004a2;
        synchronized (this.wI) {
            int i = 0;
            while (true) {
                if (i < this.wI.size()) {
                    SoftReference<InterfaceC0004a> softReference = this.wI.get(i);
                    if (softReference == null || (interfaceC0004a2 = softReference.get()) == null || !interfaceC0004a2.equals(interfaceC0004a)) {
                        i++;
                    } else {
                        this.wI.remove(softReference);
                        break;
                    }
                } else {
                    break;
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void fr() {
        if (this.handler.hasMessages(0)) {
            this.handler.removeMessages(0);
        }
        this.wG = false;
        Iterator<com.baidu.adp.lib.d.b> it = this.wJ.iterator();
        while (it.hasNext()) {
            com.baidu.adp.lib.d.b next = it.next();
            if (next != null) {
                try {
                    next.fs();
                } catch (Exception e) {
                    BdLog.e(e.getMessage());
                }
            }
        }
    }

    private void D(boolean z) {
        if (this.handler.hasMessages(0)) {
            this.handler.removeMessages(0);
        }
        this.errorCode = 4;
        this.wF = z;
        this.wG = true;
        if (this.wJ == null || this.wJ.isEmpty()) {
            this.errorCode = 6;
            this.handler.sendMessage(this.handler.obtainMessage(0));
            return;
        }
        Iterator<com.baidu.adp.lib.d.b> it = this.wJ.iterator();
        while (it.hasNext()) {
            com.baidu.adp.lib.d.b next = it.next();
            if (next != null) {
                try {
                    next.E(z);
                } catch (Exception e) {
                    BdLog.e(e.getMessage());
                }
            }
        }
        this.handler.sendMessageDelayed(this.handler.obtainMessage(0), this.wA);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(int i, String str, Address address) {
        InterfaceC0004a interfaceC0004a;
        int i2 = 0;
        if (this.handler.hasMessages(0)) {
            this.handler.removeMessages(0);
        }
        if (this.wI != null) {
            synchronized (this.wI) {
                while (true) {
                    int i3 = i2;
                    if (i3 < this.wI.size()) {
                        SoftReference<InterfaceC0004a> softReference = this.wI.get(i3);
                        if (softReference != null && (interfaceC0004a = softReference.get()) != null) {
                            interfaceC0004a.b(i, str, address);
                        }
                        i2 = i3 + 1;
                    } else {
                        this.wI.clear();
                    }
                }
            }
        }
    }
}
