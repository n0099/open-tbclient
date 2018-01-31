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
    private static a aiJ = null;
    public long aiH = 10000;
    public long aiI = 0;
    private long aiK = ReportUserInfoModel.TIME_INTERVAL;
    private boolean aiL = false;
    private boolean aiM = false;
    private boolean aiN = false;
    private int errorCode = 4;
    private Address aiO = null;
    private ArrayList<SoftReference<InterfaceC0017a>> aiP = null;
    private ArrayList<com.baidu.adp.lib.d.b> aiQ = new ArrayList<>();
    private Handler handler = null;
    private b aiR = new b() { // from class: com.baidu.adp.lib.d.a.1
        @Override // com.baidu.adp.lib.d.a.b
        public void a(int i, String str, Address address, long j, boolean z) {
            a.this.aiI = j;
            a.this.aiO = address;
            a.this.aiL = z;
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
        if (aiJ == null) {
            synchronized (a.class) {
                if (aiJ == null) {
                    aiJ = new a();
                }
            }
        }
        return aiJ;
    }

    public void a(com.baidu.adp.lib.d.b bVar) {
        if (bVar != null) {
            synchronized (this.aiQ) {
                if (!this.aiQ.contains(bVar)) {
                    bVar.a(this.aiR);
                    this.aiQ.add(bVar);
                }
            }
        }
    }

    public void b(com.baidu.adp.lib.d.b bVar) {
        if (bVar != null) {
            synchronized (this.aiQ) {
                bVar.destroy();
                this.aiQ.remove(bVar);
            }
        }
    }

    public void initial() {
        this.aiP = new ArrayList<>();
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
        return this.aiH;
    }

    public Address ak(boolean z) {
        return e(z, false);
    }

    public Address e(boolean z, boolean z2) {
        if (System.currentTimeMillis() - this.aiI > this.aiK) {
            this.aiO = null;
        }
        if (this.aiO != null && !z && ((z2 && this.aiL) || !z2)) {
            return this.aiO;
        }
        this.aiO = null;
        if (!this.aiN) {
            al(z2);
            return null;
        } else if (this.aiN && z2 && !this.aiM) {
            mJ();
            al(z2);
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
        if (System.currentTimeMillis() - this.aiI > this.aiK) {
            this.aiO = null;
        }
        if (this.aiO != null && !z && ((z2 && this.aiL) || !z2)) {
            if (interfaceC0017a != null) {
                interfaceC0017a.b(0, "", this.aiO);
            }
            return this.aiO;
        }
        if (interfaceC0017a != null) {
            synchronized (this.aiP) {
                int i = 0;
                while (true) {
                    if (i >= this.aiP.size()) {
                        z3 = false;
                        break;
                    }
                    SoftReference<InterfaceC0017a> softReference = this.aiP.get(i);
                    if (softReference == null || (interfaceC0017a2 = softReference.get()) == null || !interfaceC0017a2.equals(interfaceC0017a)) {
                        i++;
                    } else {
                        z3 = true;
                        break;
                    }
                }
                if (!z3) {
                    if (this.aiP.size() >= 100) {
                        this.aiP.remove(0);
                    }
                    this.aiP.add(new SoftReference<>(interfaceC0017a));
                }
            }
            if (!this.aiN) {
                al(z2);
                return null;
            } else if (this.aiN && z2 && !this.aiM) {
                mJ();
                al(z2);
                return null;
            }
        }
        return null;
    }

    public void a(InterfaceC0017a interfaceC0017a) {
        InterfaceC0017a interfaceC0017a2;
        synchronized (this.aiP) {
            int i = 0;
            while (true) {
                if (i < this.aiP.size()) {
                    SoftReference<InterfaceC0017a> softReference = this.aiP.get(i);
                    if (softReference == null || (interfaceC0017a2 = softReference.get()) == null || !interfaceC0017a2.equals(interfaceC0017a)) {
                        i++;
                    } else {
                        this.aiP.remove(softReference);
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
        this.aiN = false;
        Iterator<com.baidu.adp.lib.d.b> it = this.aiQ.iterator();
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

    private void al(boolean z) {
        if (this.handler.hasMessages(0)) {
            this.handler.removeMessages(0);
        }
        this.errorCode = 4;
        this.aiM = z;
        this.aiN = true;
        if (this.aiQ == null || this.aiQ.isEmpty()) {
            this.errorCode = 6;
            this.handler.sendMessage(this.handler.obtainMessage(0));
            return;
        }
        Iterator<com.baidu.adp.lib.d.b> it = this.aiQ.iterator();
        while (it.hasNext()) {
            com.baidu.adp.lib.d.b next = it.next();
            if (next != null) {
                try {
                    next.am(z);
                } catch (Exception e) {
                    BdLog.e(e.getMessage());
                }
            }
        }
        this.handler.sendMessageDelayed(this.handler.obtainMessage(0), this.aiH);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(int i, String str, Address address) {
        InterfaceC0017a interfaceC0017a;
        int i2 = 0;
        if (this.handler.hasMessages(0)) {
            this.handler.removeMessages(0);
        }
        if (this.aiP != null) {
            synchronized (this.aiP) {
                while (true) {
                    int i3 = i2;
                    if (i3 < this.aiP.size()) {
                        SoftReference<InterfaceC0017a> softReference = this.aiP.get(i3);
                        if (softReference != null && (interfaceC0017a = softReference.get()) != null) {
                            interfaceC0017a.b(i, str, address);
                        }
                        i2 = i3 + 1;
                    } else {
                        this.aiP.clear();
                    }
                }
            }
        }
    }
}
