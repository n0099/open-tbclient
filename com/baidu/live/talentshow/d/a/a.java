package com.baidu.live.talentshow.d.a;

import com.baidu.live.adp.lib.util.BdLog;
import com.baidu.live.talentshow.d.d;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
/* loaded from: classes11.dex */
public class a {
    private ArrayList<Integer> bHl = new ArrayList<>();
    private ArrayList<b> bHm = new ArrayList<>();
    private boolean bHn = false;

    /* renamed from: com.baidu.live.talentshow.d.a.a$a  reason: collision with other inner class name */
    /* loaded from: classes11.dex */
    public interface InterfaceC0211a {
        void b(b bVar);
    }

    public a() {
        Vq();
    }

    public synchronized int Vo() {
        int intValue;
        if (this.bHl.size() == 0) {
            BdLog.e("BCVideoChat getNextIndex fail");
            intValue = -1;
        } else {
            this.bHl.remove(0);
            intValue = this.bHl.get(0).intValue();
        }
        return intValue;
    }

    public synchronized boolean isEmpty() {
        return this.bHm.isEmpty();
    }

    public synchronized boolean isFull() {
        return this.bHm.size() == 2;
    }

    public synchronized void reset() {
        this.bHm.clear();
        this.bHn = false;
        Vq();
    }

    public synchronized boolean bl(long j) {
        boolean z;
        if (isEmpty()) {
            z = true;
        } else {
            if (this.bHm.size() > 0) {
                Iterator<b> it = this.bHm.iterator();
                while (it.hasNext()) {
                    b next = it.next();
                    if (next != null && next.bHp != null && next.bHp.aCG == j) {
                        BdLog.e("BCVideoChat add user duplicate imUK=" + j);
                        z = false;
                        break;
                    } else if (next.status != d.bGM && next.status != d.bGN) {
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
        return this.bHm.size();
    }

    public synchronized void c(b bVar) {
        if (bVar != null) {
            this.bHm.add(bVar);
            BdLog.d("BCVideoChat addUser=" + bVar.bHp.aCG + " current=" + bVar.status);
        }
    }

    public void cX(boolean z) {
        this.bHn = z;
    }

    public boolean Vp() {
        return this.bHn;
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
                Iterator<b> it = this.bHm.iterator();
                while (true) {
                    if (!it.hasNext()) {
                        z = false;
                        break;
                    }
                    b next = it.next();
                    if (next != null && next.bHp != null && next.bHp.aCG == j) {
                        break;
                    }
                }
                z2 = z;
            }
        }
        return z2;
    }

    public synchronized void a(int i, InterfaceC0211a interfaceC0211a) {
        Iterator<b> it = this.bHm.iterator();
        while (it.hasNext()) {
            b next = it.next();
            if (next != null && next.status == i && interfaceC0211a != null) {
                interfaceC0211a.b(next);
            }
        }
    }

    public synchronized boolean fM(int i) {
        boolean z;
        Iterator<b> it = this.bHm.iterator();
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
        r5.bHl.add(java.lang.Integer.valueOf(r0.index));
        Vr();
     */
    /* JADX WARN: Code restructure failed: missing block: B:19:0x0060, code lost:
        r5.bHm.remove(r0);
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public synchronized void bm(long j) {
        if (j != 0) {
            Iterator<b> it = this.bHm.iterator();
            while (true) {
                if (!it.hasNext()) {
                    break;
                }
                b next = it.next();
                if (next != null && next.bHp != null && next.bHp.aCG == j) {
                    break;
                }
            }
        }
    }

    public synchronized b fN(int i) {
        b bVar;
        Iterator<b> it = this.bHm.iterator();
        while (true) {
            if (!it.hasNext()) {
                bVar = null;
                break;
            }
            bVar = it.next();
            if (bVar != null && bVar.bHp != null && bVar.index == i) {
                break;
            }
        }
        return bVar;
    }

    public synchronized b bn(long j) {
        b bVar;
        Iterator<b> it = this.bHm.iterator();
        while (true) {
            if (!it.hasNext()) {
                bVar = null;
                break;
            }
            bVar = it.next();
            if (bVar != null && bVar.bHp != null && bVar.bHp.aCG == j) {
                break;
            }
        }
        return bVar;
    }

    private synchronized void Vq() {
        this.bHl.clear();
        for (int i = 1; i <= 2; i++) {
            this.bHl.add(Integer.valueOf(i));
        }
        Vr();
    }

    private synchronized void Vr() {
        Collections.sort(this.bHl, new Comparator<Integer>() { // from class: com.baidu.live.talentshow.d.a.a.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // java.util.Comparator
            public int compare(Integer num, Integer num2) {
                return num.intValue() > num2.intValue() ? 1 : -1;
            }
        });
    }
}
