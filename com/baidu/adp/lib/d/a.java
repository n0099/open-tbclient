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
    private static a sX = null;
    public long sV = 10000;
    public long sW = 0;
    private long sY = ReportUserInfoModel.TIME_INTERVAL;
    private boolean sZ = false;
    private boolean tb = false;
    private boolean tc = false;
    private int errorCode = 4;
    private Address td = null;
    private ArrayList<SoftReference<InterfaceC0006a>> te = null;
    private ArrayList<com.baidu.adp.lib.d.b> tf = new ArrayList<>();
    private Handler handler = null;
    private b tg = new b() { // from class: com.baidu.adp.lib.d.a.1
        @Override // com.baidu.adp.lib.d.a.b
        public void a(int i, String str, Address address, long j, boolean z) {
            a.this.sW = j;
            a.this.td = address;
            a.this.sZ = z;
            a.this.errorCode = i;
            a.this.eN();
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
    public interface InterfaceC0006a {
        void b(int i, String str, Address address);
    }

    /* loaded from: classes.dex */
    public interface b {
        void a(int i, String str, Address address, long j, boolean z);
    }

    private a() {
    }

    public static a eK() {
        if (sX == null) {
            synchronized (a.class) {
                if (sX == null) {
                    sX = new a();
                }
            }
        }
        return sX;
    }

    public void a(com.baidu.adp.lib.d.b bVar) {
        if (bVar != null) {
            synchronized (this.tf) {
                if (!this.tf.contains(bVar)) {
                    bVar.a(this.tg);
                    this.tf.add(bVar);
                }
            }
        }
    }

    public void b(com.baidu.adp.lib.d.b bVar) {
        if (bVar != null) {
            synchronized (this.tf) {
                bVar.destroy();
                this.tf.remove(bVar);
            }
        }
    }

    public void initial() {
        this.te = new ArrayList<>();
        eL();
    }

    private void eL() {
        this.handler = new Handler(Looper.getMainLooper(), new Handler.Callback() { // from class: com.baidu.adp.lib.d.a.2
            @Override // android.os.Handler.Callback
            public boolean handleMessage(Message message) {
                switch (message.what) {
                    case 0:
                        a.this.eN();
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

    public long eM() {
        return this.sV;
    }

    public Address G(boolean z) {
        return b(z, false);
    }

    public Address b(boolean z, boolean z2) {
        if (System.currentTimeMillis() - this.sW > this.sY) {
            this.td = null;
        }
        if (this.td != null && !z && ((z2 && this.sZ) || !z2)) {
            return this.td;
        }
        this.td = null;
        if (!this.tc) {
            H(z2);
            return null;
        } else if (this.tc && z2 && !this.tb) {
            eN();
            H(z2);
            return null;
        } else {
            return null;
        }
    }

    public Address a(boolean z, InterfaceC0006a interfaceC0006a) {
        return a(z, false, interfaceC0006a);
    }

    public Address a(boolean z, boolean z2, InterfaceC0006a interfaceC0006a) {
        boolean z3;
        InterfaceC0006a interfaceC0006a2;
        if (System.currentTimeMillis() - this.sW > this.sY) {
            this.td = null;
        }
        if (this.td != null && !z && ((z2 && this.sZ) || !z2)) {
            if (interfaceC0006a != null) {
                interfaceC0006a.b(0, "", this.td);
            }
            return this.td;
        }
        if (interfaceC0006a != null) {
            synchronized (this.te) {
                int i = 0;
                while (true) {
                    if (i >= this.te.size()) {
                        z3 = false;
                        break;
                    }
                    SoftReference<InterfaceC0006a> softReference = this.te.get(i);
                    if (softReference == null || (interfaceC0006a2 = softReference.get()) == null || !interfaceC0006a2.equals(interfaceC0006a)) {
                        i++;
                    } else {
                        z3 = true;
                        break;
                    }
                }
                if (!z3) {
                    if (this.te.size() >= 100) {
                        this.te.remove(0);
                    }
                    this.te.add(new SoftReference<>(interfaceC0006a));
                }
            }
            if (!this.tc) {
                H(z2);
                return null;
            } else if (this.tc && z2 && !this.tb) {
                eN();
                H(z2);
                return null;
            }
        }
        return null;
    }

    public void a(InterfaceC0006a interfaceC0006a) {
        InterfaceC0006a interfaceC0006a2;
        synchronized (this.te) {
            int i = 0;
            while (true) {
                if (i < this.te.size()) {
                    SoftReference<InterfaceC0006a> softReference = this.te.get(i);
                    if (softReference == null || (interfaceC0006a2 = softReference.get()) == null || !interfaceC0006a2.equals(interfaceC0006a)) {
                        i++;
                    } else {
                        this.te.remove(softReference);
                        break;
                    }
                } else {
                    break;
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void eN() {
        if (this.handler.hasMessages(0)) {
            this.handler.removeMessages(0);
        }
        this.tc = false;
        Iterator<com.baidu.adp.lib.d.b> it = this.tf.iterator();
        while (it.hasNext()) {
            com.baidu.adp.lib.d.b next = it.next();
            if (next != null) {
                try {
                    next.eO();
                } catch (Exception e) {
                    BdLog.e(e.getMessage());
                }
            }
        }
    }

    private void H(boolean z) {
        if (this.handler.hasMessages(0)) {
            this.handler.removeMessages(0);
        }
        this.errorCode = 4;
        this.tb = z;
        this.tc = true;
        if (this.tf == null || this.tf.isEmpty()) {
            this.errorCode = 6;
            this.handler.sendMessage(this.handler.obtainMessage(0));
            return;
        }
        Iterator<com.baidu.adp.lib.d.b> it = this.tf.iterator();
        while (it.hasNext()) {
            com.baidu.adp.lib.d.b next = it.next();
            if (next != null) {
                try {
                    next.I(z);
                } catch (Exception e) {
                    BdLog.e(e.getMessage());
                }
            }
        }
        this.handler.sendMessageDelayed(this.handler.obtainMessage(0), this.sV);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(int i, String str, Address address) {
        InterfaceC0006a interfaceC0006a;
        int i2 = 0;
        if (this.handler.hasMessages(0)) {
            this.handler.removeMessages(0);
        }
        if (this.te != null) {
            synchronized (this.te) {
                while (true) {
                    int i3 = i2;
                    if (i3 < this.te.size()) {
                        SoftReference<InterfaceC0006a> softReference = this.te.get(i3);
                        if (softReference != null && (interfaceC0006a = softReference.get()) != null) {
                            interfaceC0006a.b(i, str, address);
                        }
                        i2 = i3 + 1;
                    } else {
                        this.te.clear();
                    }
                }
            }
        }
    }
}
