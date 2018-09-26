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
    private static a Bw = null;
    public long Bu = 10000;
    public long Bv = 0;
    private long Bx = ReportUserInfoModel.TIME_INTERVAL;
    private boolean By = false;
    private boolean Bz = false;
    private boolean BA = false;
    private int errorCode = 4;
    private Address BB = null;
    private ArrayList<SoftReference<InterfaceC0014a>> BC = null;
    private ArrayList<com.baidu.adp.lib.d.b> BD = new ArrayList<>();
    private Handler handler = null;
    private b BE = new b() { // from class: com.baidu.adp.lib.d.a.1
        @Override // com.baidu.adp.lib.d.a.b
        public void a(int i, String str, Address address, long j, boolean z) {
            a.this.Bv = j;
            a.this.BB = address;
            a.this.By = z;
            a.this.errorCode = i;
            a.this.iK();
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

    public static a iH() {
        if (Bw == null) {
            synchronized (a.class) {
                if (Bw == null) {
                    Bw = new a();
                }
            }
        }
        return Bw;
    }

    public void a(com.baidu.adp.lib.d.b bVar) {
        if (bVar != null) {
            synchronized (this.BD) {
                if (!this.BD.contains(bVar)) {
                    bVar.a(this.BE);
                    this.BD.add(bVar);
                }
            }
        }
    }

    public void b(com.baidu.adp.lib.d.b bVar) {
        if (bVar != null) {
            synchronized (this.BD) {
                bVar.destroy();
                this.BD.remove(bVar);
            }
        }
    }

    public void initial() {
        this.BC = new ArrayList<>();
        iI();
    }

    private void iI() {
        this.handler = new Handler(Looper.getMainLooper(), new Handler.Callback() { // from class: com.baidu.adp.lib.d.a.2
            @Override // android.os.Handler.Callback
            public boolean handleMessage(Message message) {
                switch (message.what) {
                    case 0:
                        a.this.iK();
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

    public long iJ() {
        return this.Bu;
    }

    public Address R(boolean z) {
        return d(z, false);
    }

    public Address d(boolean z, boolean z2) {
        if (System.currentTimeMillis() - this.Bv > this.Bx) {
            this.BB = null;
        }
        if (this.BB != null && !z && ((z2 && this.By) || !z2)) {
            return this.BB;
        }
        this.BB = null;
        if (!this.BA) {
            S(z2);
            return null;
        } else if (this.BA && z2 && !this.Bz) {
            iK();
            S(z2);
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
        if (System.currentTimeMillis() - this.Bv > this.Bx) {
            this.BB = null;
        }
        if (this.BB != null && !z && ((z2 && this.By) || !z2)) {
            if (interfaceC0014a != null) {
                interfaceC0014a.b(0, "", this.BB);
            }
            return this.BB;
        }
        if (interfaceC0014a != null) {
            synchronized (this.BC) {
                int i = 0;
                while (true) {
                    if (i >= this.BC.size()) {
                        z3 = false;
                        break;
                    }
                    SoftReference<InterfaceC0014a> softReference = this.BC.get(i);
                    if (softReference == null || (interfaceC0014a2 = softReference.get()) == null || !interfaceC0014a2.equals(interfaceC0014a)) {
                        i++;
                    } else {
                        z3 = true;
                        break;
                    }
                }
                if (!z3) {
                    if (this.BC.size() >= 100) {
                        this.BC.remove(0);
                    }
                    this.BC.add(new SoftReference<>(interfaceC0014a));
                }
            }
            if (!this.BA) {
                S(z2);
                return null;
            } else if (this.BA && z2 && !this.Bz) {
                iK();
                S(z2);
                return null;
            }
        }
        return null;
    }

    public void a(InterfaceC0014a interfaceC0014a) {
        InterfaceC0014a interfaceC0014a2;
        synchronized (this.BC) {
            int i = 0;
            while (true) {
                if (i < this.BC.size()) {
                    SoftReference<InterfaceC0014a> softReference = this.BC.get(i);
                    if (softReference == null || (interfaceC0014a2 = softReference.get()) == null || !interfaceC0014a2.equals(interfaceC0014a)) {
                        i++;
                    } else {
                        this.BC.remove(softReference);
                        break;
                    }
                } else {
                    break;
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void iK() {
        if (this.handler.hasMessages(0)) {
            this.handler.removeMessages(0);
        }
        this.BA = false;
        Iterator<com.baidu.adp.lib.d.b> it = this.BD.iterator();
        while (it.hasNext()) {
            com.baidu.adp.lib.d.b next = it.next();
            if (next != null) {
                try {
                    next.iL();
                } catch (Exception e) {
                    BdLog.e(e.getMessage());
                }
            }
        }
    }

    private void S(boolean z) {
        if (this.handler.hasMessages(0)) {
            this.handler.removeMessages(0);
        }
        this.errorCode = 4;
        this.Bz = z;
        this.BA = true;
        if (this.BD == null || this.BD.isEmpty()) {
            this.errorCode = 6;
            this.handler.sendMessage(this.handler.obtainMessage(0));
            return;
        }
        Iterator<com.baidu.adp.lib.d.b> it = this.BD.iterator();
        while (it.hasNext()) {
            com.baidu.adp.lib.d.b next = it.next();
            if (next != null) {
                try {
                    next.T(z);
                } catch (Exception e) {
                    BdLog.e(e.getMessage());
                }
            }
        }
        this.handler.sendMessageDelayed(this.handler.obtainMessage(0), this.Bu);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(int i, String str, Address address) {
        InterfaceC0014a interfaceC0014a;
        int i2 = 0;
        if (this.handler.hasMessages(0)) {
            this.handler.removeMessages(0);
        }
        if (this.BC != null) {
            synchronized (this.BC) {
                while (true) {
                    int i3 = i2;
                    if (i3 < this.BC.size()) {
                        SoftReference<InterfaceC0014a> softReference = this.BC.get(i3);
                        if (softReference != null && (interfaceC0014a = softReference.get()) != null) {
                            interfaceC0014a.b(i, str, address);
                        }
                        i2 = i3 + 1;
                    } else {
                        this.BC.clear();
                    }
                }
            }
        }
    }
}
