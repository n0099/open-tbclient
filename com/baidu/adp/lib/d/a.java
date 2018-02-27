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
    private static a aiC = null;
    public long aiA = 10000;
    public long aiB = 0;
    private long aiD = ReportUserInfoModel.TIME_INTERVAL;
    private boolean aiE = false;
    private boolean aiF = false;
    private boolean aiG = false;
    private int errorCode = 4;
    private Address aiH = null;
    private ArrayList<SoftReference<InterfaceC0017a>> aiI = null;
    private ArrayList<com.baidu.adp.lib.d.b> aiJ = new ArrayList<>();
    private Handler handler = null;
    private b aiK = new b() { // from class: com.baidu.adp.lib.d.a.1
        @Override // com.baidu.adp.lib.d.a.b
        public void a(int i, String str, Address address, long j, boolean z) {
            a.this.aiB = j;
            a.this.aiH = address;
            a.this.aiE = z;
            a.this.errorCode = i;
            a.this.mJ();
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

    public static a mG() {
        if (aiC == null) {
            synchronized (a.class) {
                if (aiC == null) {
                    aiC = new a();
                }
            }
        }
        return aiC;
    }

    public void a(com.baidu.adp.lib.d.b bVar) {
        if (bVar != null) {
            synchronized (this.aiJ) {
                if (!this.aiJ.contains(bVar)) {
                    bVar.a(this.aiK);
                    this.aiJ.add(bVar);
                }
            }
        }
    }

    public void b(com.baidu.adp.lib.d.b bVar) {
        if (bVar != null) {
            synchronized (this.aiJ) {
                bVar.destroy();
                this.aiJ.remove(bVar);
            }
        }
    }

    public void initial() {
        this.aiI = new ArrayList<>();
        mH();
    }

    private void mH() {
        this.handler = new Handler(Looper.getMainLooper(), new Handler.Callback() { // from class: com.baidu.adp.lib.d.a.2
            @Override // android.os.Handler.Callback
            public boolean handleMessage(Message message) {
                switch (message.what) {
                    case 0:
                        a.this.mJ();
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

    public long mI() {
        return this.aiA;
    }

    public Address an(boolean z) {
        return e(z, false);
    }

    public Address e(boolean z, boolean z2) {
        if (System.currentTimeMillis() - this.aiB > this.aiD) {
            this.aiH = null;
        }
        if (this.aiH != null && !z && ((z2 && this.aiE) || !z2)) {
            return this.aiH;
        }
        this.aiH = null;
        if (!this.aiG) {
            ao(z2);
            return null;
        } else if (this.aiG && z2 && !this.aiF) {
            mJ();
            ao(z2);
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
        if (System.currentTimeMillis() - this.aiB > this.aiD) {
            this.aiH = null;
        }
        if (this.aiH != null && !z && ((z2 && this.aiE) || !z2)) {
            if (interfaceC0017a != null) {
                interfaceC0017a.b(0, "", this.aiH);
            }
            return this.aiH;
        }
        if (interfaceC0017a != null) {
            synchronized (this.aiI) {
                int i = 0;
                while (true) {
                    if (i >= this.aiI.size()) {
                        z3 = false;
                        break;
                    }
                    SoftReference<InterfaceC0017a> softReference = this.aiI.get(i);
                    if (softReference == null || (interfaceC0017a2 = softReference.get()) == null || !interfaceC0017a2.equals(interfaceC0017a)) {
                        i++;
                    } else {
                        z3 = true;
                        break;
                    }
                }
                if (!z3) {
                    if (this.aiI.size() >= 100) {
                        this.aiI.remove(0);
                    }
                    this.aiI.add(new SoftReference<>(interfaceC0017a));
                }
            }
            if (!this.aiG) {
                ao(z2);
                return null;
            } else if (this.aiG && z2 && !this.aiF) {
                mJ();
                ao(z2);
                return null;
            }
        }
        return null;
    }

    public void a(InterfaceC0017a interfaceC0017a) {
        InterfaceC0017a interfaceC0017a2;
        synchronized (this.aiI) {
            int i = 0;
            while (true) {
                if (i < this.aiI.size()) {
                    SoftReference<InterfaceC0017a> softReference = this.aiI.get(i);
                    if (softReference == null || (interfaceC0017a2 = softReference.get()) == null || !interfaceC0017a2.equals(interfaceC0017a)) {
                        i++;
                    } else {
                        this.aiI.remove(softReference);
                        break;
                    }
                } else {
                    break;
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void mJ() {
        if (this.handler.hasMessages(0)) {
            this.handler.removeMessages(0);
        }
        this.aiG = false;
        Iterator<com.baidu.adp.lib.d.b> it = this.aiJ.iterator();
        while (it.hasNext()) {
            com.baidu.adp.lib.d.b next = it.next();
            if (next != null) {
                try {
                    next.mK();
                } catch (Exception e) {
                    BdLog.e(e.getMessage());
                }
            }
        }
    }

    private void ao(boolean z) {
        if (this.handler.hasMessages(0)) {
            this.handler.removeMessages(0);
        }
        this.errorCode = 4;
        this.aiF = z;
        this.aiG = true;
        if (this.aiJ == null || this.aiJ.isEmpty()) {
            this.errorCode = 6;
            this.handler.sendMessage(this.handler.obtainMessage(0));
            return;
        }
        Iterator<com.baidu.adp.lib.d.b> it = this.aiJ.iterator();
        while (it.hasNext()) {
            com.baidu.adp.lib.d.b next = it.next();
            if (next != null) {
                try {
                    next.ap(z);
                } catch (Exception e) {
                    BdLog.e(e.getMessage());
                }
            }
        }
        this.handler.sendMessageDelayed(this.handler.obtainMessage(0), this.aiA);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(int i, String str, Address address) {
        InterfaceC0017a interfaceC0017a;
        int i2 = 0;
        if (this.handler.hasMessages(0)) {
            this.handler.removeMessages(0);
        }
        if (this.aiI != null) {
            synchronized (this.aiI) {
                while (true) {
                    int i3 = i2;
                    if (i3 < this.aiI.size()) {
                        SoftReference<InterfaceC0017a> softReference = this.aiI.get(i3);
                        if (softReference != null && (interfaceC0017a = softReference.get()) != null) {
                            interfaceC0017a.b(i, str, address);
                        }
                        i2 = i3 + 1;
                    } else {
                        this.aiI.clear();
                    }
                }
            }
        }
    }
}
