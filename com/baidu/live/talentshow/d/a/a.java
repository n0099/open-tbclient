package com.baidu.live.talentshow.d.a;

import com.baidu.live.adp.lib.util.BdLog;
import com.baidu.live.talentshow.d.d;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
/* loaded from: classes4.dex */
public class a {
    private ArrayList<Integer> bCy = new ArrayList<>();
    private ArrayList<b> bCz = new ArrayList<>();
    private boolean bCA = false;

    /* renamed from: com.baidu.live.talentshow.d.a.a$a  reason: collision with other inner class name */
    /* loaded from: classes4.dex */
    public interface InterfaceC0213a {
        void b(b bVar);
    }

    public a() {
        Ul();
    }

    public synchronized int Uj() {
        int intValue;
        if (this.bCy.size() == 0) {
            BdLog.e("BCVideoChat getNextIndex fail");
            intValue = -1;
        } else {
            this.bCy.remove(0);
            intValue = this.bCy.get(0).intValue();
        }
        return intValue;
    }

    public synchronized boolean isEmpty() {
        return this.bCz.isEmpty();
    }

    public synchronized boolean isFull() {
        return this.bCz.size() == 2;
    }

    public synchronized void reset() {
        this.bCz.clear();
        this.bCA = false;
        Ul();
    }

    public synchronized boolean bl(long j) {
        boolean z;
        if (isEmpty()) {
            z = true;
        } else {
            if (this.bCz.size() > 0) {
                Iterator<b> it = this.bCz.iterator();
                while (it.hasNext()) {
                    b next = it.next();
                    if (next != null && next.bCC != null && next.bCC.aCp == j) {
                        BdLog.e("BCVideoChat add user duplicate imUK=" + j);
                        z = false;
                        break;
                    } else if (next.status != d.bBZ && next.status != d.bCa) {
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
        return this.bCz.size();
    }

    public synchronized void c(b bVar) {
        if (bVar != null) {
            this.bCz.add(bVar);
            BdLog.d("BCVideoChat addUser=" + bVar.bCC.aCp + " current=" + bVar.status);
        }
    }

    public void cU(boolean z) {
        this.bCA = z;
    }

    public boolean Uk() {
        return this.bCA;
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
    public synchronized boolean i(long j, int i) {
        boolean z;
        boolean z2 = false;
        synchronized (this) {
            if (j != 0) {
                Iterator<b> it = this.bCz.iterator();
                while (true) {
                    if (!it.hasNext()) {
                        z = false;
                        break;
                    }
                    b next = it.next();
                    if (next != null && next.bCC != null && next.bCC.aCp == j) {
                        break;
                    }
                }
                z2 = z;
            }
        }
        return z2;
    }

    public synchronized void a(int i, InterfaceC0213a interfaceC0213a) {
        Iterator<b> it = this.bCz.iterator();
        while (it.hasNext()) {
            b next = it.next();
            if (next != null && next.status == i && interfaceC0213a != null) {
                interfaceC0213a.b(next);
            }
        }
    }

    public synchronized boolean fL(int i) {
        boolean z;
        Iterator<b> it = this.bCz.iterator();
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
        r5.bCy.add(java.lang.Integer.valueOf(r0.index));
        Um();
     */
    /* JADX WARN: Code restructure failed: missing block: B:19:0x0060, code lost:
        r5.bCz.remove(r0);
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public synchronized void bm(long j) {
        if (j != 0) {
            Iterator<b> it = this.bCz.iterator();
            while (true) {
                if (!it.hasNext()) {
                    break;
                }
                b next = it.next();
                if (next != null && next.bCC != null && next.bCC.aCp == j) {
                    break;
                }
            }
        }
    }

    public synchronized b fM(int i) {
        b bVar;
        Iterator<b> it = this.bCz.iterator();
        while (true) {
            if (!it.hasNext()) {
                bVar = null;
                break;
            }
            bVar = it.next();
            if (bVar != null && bVar.bCC != null && bVar.index == i) {
                break;
            }
        }
        return bVar;
    }

    public synchronized b bn(long j) {
        b bVar;
        Iterator<b> it = this.bCz.iterator();
        while (true) {
            if (!it.hasNext()) {
                bVar = null;
                break;
            }
            bVar = it.next();
            if (bVar != null && bVar.bCC != null && bVar.bCC.aCp == j) {
                break;
            }
        }
        return bVar;
    }

    private synchronized void Ul() {
        this.bCy.clear();
        for (int i = 1; i <= 2; i++) {
            this.bCy.add(Integer.valueOf(i));
        }
        Um();
    }

    private synchronized void Um() {
        Collections.sort(this.bCy, new Comparator<Integer>() { // from class: com.baidu.live.talentshow.d.a.a.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // java.util.Comparator
            public int compare(Integer num, Integer num2) {
                return num.intValue() > num2.intValue() ? 1 : -1;
            }
        });
    }
}
