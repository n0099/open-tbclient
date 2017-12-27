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
    private static a aiG = null;
    public long aiE = 10000;
    public long aiF = 0;
    private long aiH = ReportUserInfoModel.TIME_INTERVAL;
    private boolean aiI = false;
    private boolean aiJ = false;
    private boolean aiK = false;
    private int errorCode = 4;
    private Address aiL = null;
    private ArrayList<SoftReference<InterfaceC0017a>> aiM = null;
    private ArrayList<com.baidu.adp.lib.d.b> aiN = new ArrayList<>();
    private Handler handler = null;
    private b aiO = new b() { // from class: com.baidu.adp.lib.d.a.1
        @Override // com.baidu.adp.lib.d.a.b
        public void a(int i, String str, Address address, long j, boolean z) {
            a.this.aiF = j;
            a.this.aiL = address;
            a.this.aiI = z;
            a.this.errorCode = i;
            a.this.mI();
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
    public interface InterfaceC0017a {
        void b(int i, String str, Address address);
    }

    /* loaded from: classes.dex */
    public interface b {
        void a(int i, String str, Address address, long j, boolean z);
    }

    private a() {
    }

    public static a mF() {
        if (aiG == null) {
            synchronized (a.class) {
                if (aiG == null) {
                    aiG = new a();
                }
            }
        }
        return aiG;
    }

    public void a(com.baidu.adp.lib.d.b bVar) {
        if (bVar != null) {
            synchronized (this.aiN) {
                if (!this.aiN.contains(bVar)) {
                    bVar.a(this.aiO);
                    this.aiN.add(bVar);
                }
            }
        }
    }

    public void b(com.baidu.adp.lib.d.b bVar) {
        if (bVar != null) {
            synchronized (this.aiN) {
                bVar.destroy();
                this.aiN.remove(bVar);
            }
        }
    }

    public void initial() {
        this.aiM = new ArrayList<>();
        mG();
    }

    private void mG() {
        this.handler = new Handler(Looper.getMainLooper(), new Handler.Callback() { // from class: com.baidu.adp.lib.d.a.2
            @Override // android.os.Handler.Callback
            public boolean handleMessage(Message message) {
                switch (message.what) {
                    case 0:
                        a.this.mI();
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

    public long mH() {
        return this.aiE;
    }

    public Address aj(boolean z) {
        return e(z, false);
    }

    public Address e(boolean z, boolean z2) {
        if (System.currentTimeMillis() - this.aiF > this.aiH) {
            this.aiL = null;
        }
        if (this.aiL != null && !z && ((z2 && this.aiI) || !z2)) {
            return this.aiL;
        }
        this.aiL = null;
        if (!this.aiK) {
            ak(z2);
            return null;
        } else if (this.aiK && z2 && !this.aiJ) {
            mI();
            ak(z2);
            return null;
        } else {
            return null;
        }
    }

    public Address a(boolean z, InterfaceC0017a interfaceC0017a) {
        return a(z, false, interfaceC0017a);
    }

    public Address a(boolean z, boolean z2, InterfaceC0017a interfaceC0017a) {
        boolean z3;
        InterfaceC0017a interfaceC0017a2;
        if (System.currentTimeMillis() - this.aiF > this.aiH) {
            this.aiL = null;
        }
        if (this.aiL != null && !z && ((z2 && this.aiI) || !z2)) {
            if (interfaceC0017a != null) {
                interfaceC0017a.b(0, "", this.aiL);
            }
            return this.aiL;
        }
        if (interfaceC0017a != null) {
            synchronized (this.aiM) {
                int i = 0;
                while (true) {
                    if (i >= this.aiM.size()) {
                        z3 = false;
                        break;
                    }
                    SoftReference<InterfaceC0017a> softReference = this.aiM.get(i);
                    if (softReference == null || (interfaceC0017a2 = softReference.get()) == null || !interfaceC0017a2.equals(interfaceC0017a)) {
                        i++;
                    } else {
                        z3 = true;
                        break;
                    }
                }
                if (!z3) {
                    if (this.aiM.size() >= 100) {
                        this.aiM.remove(0);
                    }
                    this.aiM.add(new SoftReference<>(interfaceC0017a));
                }
            }
            if (!this.aiK) {
                ak(z2);
                return null;
            } else if (this.aiK && z2 && !this.aiJ) {
                mI();
                ak(z2);
                return null;
            }
        }
        return null;
    }

    public void a(InterfaceC0017a interfaceC0017a) {
        InterfaceC0017a interfaceC0017a2;
        synchronized (this.aiM) {
            int i = 0;
            while (true) {
                if (i < this.aiM.size()) {
                    SoftReference<InterfaceC0017a> softReference = this.aiM.get(i);
                    if (softReference == null || (interfaceC0017a2 = softReference.get()) == null || !interfaceC0017a2.equals(interfaceC0017a)) {
                        i++;
                    } else {
                        this.aiM.remove(softReference);
                        break;
                    }
                } else {
                    break;
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void mI() {
        if (this.handler.hasMessages(0)) {
            this.handler.removeMessages(0);
        }
        this.aiK = false;
        Iterator<com.baidu.adp.lib.d.b> it = this.aiN.iterator();
        while (it.hasNext()) {
            com.baidu.adp.lib.d.b next = it.next();
            if (next != null) {
                try {
                    next.mJ();
                } catch (Exception e) {
                    BdLog.e(e.getMessage());
                }
            }
        }
    }

    private void ak(boolean z) {
        if (this.handler.hasMessages(0)) {
            this.handler.removeMessages(0);
        }
        this.errorCode = 4;
        this.aiJ = z;
        this.aiK = true;
        if (this.aiN == null || this.aiN.isEmpty()) {
            this.errorCode = 6;
            this.handler.sendMessage(this.handler.obtainMessage(0));
            return;
        }
        Iterator<com.baidu.adp.lib.d.b> it = this.aiN.iterator();
        while (it.hasNext()) {
            com.baidu.adp.lib.d.b next = it.next();
            if (next != null) {
                try {
                    next.al(z);
                } catch (Exception e) {
                    BdLog.e(e.getMessage());
                }
            }
        }
        this.handler.sendMessageDelayed(this.handler.obtainMessage(0), this.aiE);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(int i, String str, Address address) {
        InterfaceC0017a interfaceC0017a;
        int i2 = 0;
        if (this.handler.hasMessages(0)) {
            this.handler.removeMessages(0);
        }
        if (this.aiM != null) {
            synchronized (this.aiM) {
                while (true) {
                    int i3 = i2;
                    if (i3 < this.aiM.size()) {
                        SoftReference<InterfaceC0017a> softReference = this.aiM.get(i3);
                        if (softReference != null && (interfaceC0017a = softReference.get()) != null) {
                            interfaceC0017a.b(i, str, address);
                        }
                        i2 = i3 + 1;
                    } else {
                        this.aiM.clear();
                    }
                }
            }
        }
    }
}
