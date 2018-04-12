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
    private static a sY = null;
    public long sW = 10000;
    public long sX = 0;
    private long sZ = ReportUserInfoModel.TIME_INTERVAL;
    private boolean tb = false;
    private boolean tc = false;
    private boolean td = false;
    private int errorCode = 4;
    private Address te = null;
    private ArrayList<SoftReference<InterfaceC0006a>> tf = null;
    private ArrayList<com.baidu.adp.lib.d.b> tg = new ArrayList<>();
    private Handler handler = null;
    private b th = new b() { // from class: com.baidu.adp.lib.d.a.1
        @Override // com.baidu.adp.lib.d.a.b
        public void a(int i, String str, Address address, long j, boolean z) {
            a.this.sX = j;
            a.this.te = address;
            a.this.tb = z;
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
        if (sY == null) {
            synchronized (a.class) {
                if (sY == null) {
                    sY = new a();
                }
            }
        }
        return sY;
    }

    public void a(com.baidu.adp.lib.d.b bVar) {
        if (bVar != null) {
            synchronized (this.tg) {
                if (!this.tg.contains(bVar)) {
                    bVar.a(this.th);
                    this.tg.add(bVar);
                }
            }
        }
    }

    public void b(com.baidu.adp.lib.d.b bVar) {
        if (bVar != null) {
            synchronized (this.tg) {
                bVar.destroy();
                this.tg.remove(bVar);
            }
        }
    }

    public void initial() {
        this.tf = new ArrayList<>();
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
        return this.sW;
    }

    public Address G(boolean z) {
        return b(z, false);
    }

    public Address b(boolean z, boolean z2) {
        if (System.currentTimeMillis() - this.sX > this.sZ) {
            this.te = null;
        }
        if (this.te != null && !z && ((z2 && this.tb) || !z2)) {
            return this.te;
        }
        this.te = null;
        if (!this.td) {
            H(z2);
            return null;
        } else if (this.td && z2 && !this.tc) {
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
        if (System.currentTimeMillis() - this.sX > this.sZ) {
            this.te = null;
        }
        if (this.te != null && !z && ((z2 && this.tb) || !z2)) {
            if (interfaceC0006a != null) {
                interfaceC0006a.b(0, "", this.te);
            }
            return this.te;
        }
        if (interfaceC0006a != null) {
            synchronized (this.tf) {
                int i = 0;
                while (true) {
                    if (i >= this.tf.size()) {
                        z3 = false;
                        break;
                    }
                    SoftReference<InterfaceC0006a> softReference = this.tf.get(i);
                    if (softReference == null || (interfaceC0006a2 = softReference.get()) == null || !interfaceC0006a2.equals(interfaceC0006a)) {
                        i++;
                    } else {
                        z3 = true;
                        break;
                    }
                }
                if (!z3) {
                    if (this.tf.size() >= 100) {
                        this.tf.remove(0);
                    }
                    this.tf.add(new SoftReference<>(interfaceC0006a));
                }
            }
            if (!this.td) {
                H(z2);
                return null;
            } else if (this.td && z2 && !this.tc) {
                eN();
                H(z2);
                return null;
            }
        }
        return null;
    }

    public void a(InterfaceC0006a interfaceC0006a) {
        InterfaceC0006a interfaceC0006a2;
        synchronized (this.tf) {
            int i = 0;
            while (true) {
                if (i < this.tf.size()) {
                    SoftReference<InterfaceC0006a> softReference = this.tf.get(i);
                    if (softReference == null || (interfaceC0006a2 = softReference.get()) == null || !interfaceC0006a2.equals(interfaceC0006a)) {
                        i++;
                    } else {
                        this.tf.remove(softReference);
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
        this.td = false;
        Iterator<com.baidu.adp.lib.d.b> it = this.tg.iterator();
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
        this.tc = z;
        this.td = true;
        if (this.tg == null || this.tg.isEmpty()) {
            this.errorCode = 6;
            this.handler.sendMessage(this.handler.obtainMessage(0));
            return;
        }
        Iterator<com.baidu.adp.lib.d.b> it = this.tg.iterator();
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
        this.handler.sendMessageDelayed(this.handler.obtainMessage(0), this.sW);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(int i, String str, Address address) {
        InterfaceC0006a interfaceC0006a;
        int i2 = 0;
        if (this.handler.hasMessages(0)) {
            this.handler.removeMessages(0);
        }
        if (this.tf != null) {
            synchronized (this.tf) {
                while (true) {
                    int i3 = i2;
                    if (i3 < this.tf.size()) {
                        SoftReference<InterfaceC0006a> softReference = this.tf.get(i3);
                        if (softReference != null && (interfaceC0006a = softReference.get()) != null) {
                            interfaceC0006a.b(i, str, address);
                        }
                        i2 = i3 + 1;
                    } else {
                        this.tf.clear();
                    }
                }
            }
        }
    }
}
