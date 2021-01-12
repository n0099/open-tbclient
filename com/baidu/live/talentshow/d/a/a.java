package com.baidu.live.talentshow.d.a;

import com.baidu.live.adp.lib.util.BdLog;
import com.baidu.live.talentshow.d.d;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
/* loaded from: classes10.dex */
public class a {
    private ArrayList<Integer> bCz = new ArrayList<>();
    private ArrayList<b> bCA = new ArrayList<>();
    private boolean bCB = false;

    /* renamed from: com.baidu.live.talentshow.d.a.a$a  reason: collision with other inner class name */
    /* loaded from: classes10.dex */
    public interface InterfaceC0202a {
        void b(b bVar);
    }

    public a() {
        Rx();
    }

    public synchronized int Rv() {
        int intValue;
        if (this.bCz.size() == 0) {
            BdLog.e("BCVideoChat getNextIndex fail");
            intValue = -1;
        } else {
            this.bCz.remove(0);
            intValue = this.bCz.get(0).intValue();
        }
        return intValue;
    }

    public synchronized boolean isEmpty() {
        return this.bCA.isEmpty();
    }

    public synchronized boolean isFull() {
        return this.bCA.size() == 2;
    }

    public synchronized void reset() {
        this.bCA.clear();
        this.bCB = false;
        Rx();
    }

    public synchronized boolean bl(long j) {
        boolean z;
        if (isEmpty()) {
            z = true;
        } else {
            if (this.bCA.size() > 0) {
                Iterator<b> it = this.bCA.iterator();
                while (it.hasNext()) {
                    b next = it.next();
                    if (next != null && next.bCD != null && next.bCD.axT == j) {
                        BdLog.e("BCVideoChat add user duplicate imUK=" + j);
                        z = false;
                        break;
                    } else if (next.status != d.bCa && next.status != d.bCb) {
                        z = false;
                        break;
                    }
                }
            }
            z = true;
        }
        return z;
    }

    public synchronized int getCount() {
        return this.bCA.size();
    }

    public synchronized void c(b bVar) {
        if (bVar != null) {
            this.bCA.add(bVar);
            BdLog.d("BCVideoChat addUser=" + bVar.bCD.axT + " current=" + bVar.status);
        }
    }

    public void cT(boolean z) {
        this.bCB = z;
    }

    public boolean Rw() {
        return this.bCB;
    }

    /* JADX WARN: Code restructure failed: missing block: B:17:0x002a, code lost:
        com.baidu.live.adp.lib.util.BdLog.d("BCVideoChat status=" + r10 + " current=" + r0.status);
        r0.status = r10;
     */
    /* JADX WARN: Code restructure failed: missing block: B:18:0x0050, code lost:
        r0 = true;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public synchronized boolean j(long j, int i) {
        boolean z;
        boolean z2 = false;
        synchronized (this) {
            if (j != 0) {
                Iterator<b> it = this.bCA.iterator();
                while (true) {
                    if (!it.hasNext()) {
                        z = false;
                        break;
                    }
                    b next = it.next();
                    if (next != null && next.bCD != null && next.bCD.axT == j) {
                        break;
                    }
                }
                z2 = z;
            }
        }
        return z2;
    }

    public synchronized void a(int i, InterfaceC0202a interfaceC0202a) {
        Iterator<b> it = this.bCA.iterator();
        while (it.hasNext()) {
            b next = it.next();
            if (next != null && next.status == i && interfaceC0202a != null) {
                interfaceC0202a.b(next);
            }
        }
    }

    public synchronized boolean eg(int i) {
        boolean z;
        Iterator<b> it = this.bCA.iterator();
        while (true) {
            if (!it.hasNext()) {
                z = false;
                break;
            }
            b next = it.next();
            if (next != null && next.status == i) {
                z = true;
                break;
            }
        }
        return z;
    }

    /* JADX WARN: Code restructure failed: missing block: B:16:0x0029, code lost:
        com.baidu.live.adp.lib.util.BdLog.d("BCVideoChat delUser=" + r6 + " current=" + r0.status);
     */
    /* JADX WARN: Code restructure failed: missing block: B:17:0x0050, code lost:
        if (r0.index == (-1)) goto L23;
     */
    /* JADX WARN: Code restructure failed: missing block: B:18:0x0052, code lost:
        r5.bCz.add(java.lang.Integer.valueOf(r0.index));
        Ry();
     */
    /* JADX WARN: Code restructure failed: missing block: B:19:0x0060, code lost:
        r5.bCA.remove(r0);
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public synchronized void bm(long j) {
        if (j != 0) {
            Iterator<b> it = this.bCA.iterator();
            while (true) {
                if (!it.hasNext()) {
                    break;
                }
                b next = it.next();
                if (next != null && next.bCD != null && next.bCD.axT == j) {
                    break;
                }
            }
        }
    }

    public synchronized b eh(int i) {
        b bVar;
        Iterator<b> it = this.bCA.iterator();
        while (true) {
            if (!it.hasNext()) {
                bVar = null;
                break;
            }
            bVar = it.next();
            if (bVar != null && bVar.bCD != null && bVar.index == i) {
                break;
            }
        }
        return bVar;
    }

    public synchronized b bn(long j) {
        b bVar;
        Iterator<b> it = this.bCA.iterator();
        while (true) {
            if (!it.hasNext()) {
                bVar = null;
                break;
            }
            bVar = it.next();
            if (bVar != null && bVar.bCD != null && bVar.bCD.axT == j) {
                break;
            }
        }
        return bVar;
    }

    private synchronized void Rx() {
        this.bCz.clear();
        for (int i = 1; i <= 2; i++) {
            this.bCz.add(Integer.valueOf(i));
        }
        Ry();
    }

    private synchronized void Ry() {
        Collections.sort(this.bCz, new Comparator<Integer>() { // from class: com.baidu.live.talentshow.d.a.a.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // java.util.Comparator
            /* renamed from: a */
            public int compare(Integer num, Integer num2) {
                return num.intValue() > num2.intValue() ? 1 : -1;
            }
        });
    }
}
