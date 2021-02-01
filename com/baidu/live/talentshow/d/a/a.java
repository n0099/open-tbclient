package com.baidu.live.talentshow.d.a;

import com.baidu.live.adp.lib.util.BdLog;
import com.baidu.live.talentshow.d.d;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
/* loaded from: classes11.dex */
public class a {
    private ArrayList<Integer> bGj = new ArrayList<>();
    private ArrayList<b> bGk = new ArrayList<>();
    private boolean bGl = false;

    /* renamed from: com.baidu.live.talentshow.d.a.a$a  reason: collision with other inner class name */
    /* loaded from: classes11.dex */
    public interface InterfaceC0204a {
        void b(b bVar);
    }

    public a() {
        Te();
    }

    public synchronized int Tc() {
        int intValue;
        if (this.bGj.size() == 0) {
            BdLog.e("BCVideoChat getNextIndex fail");
            intValue = -1;
        } else {
            this.bGj.remove(0);
            intValue = this.bGj.get(0).intValue();
        }
        return intValue;
    }

    public synchronized boolean isEmpty() {
        return this.bGk.isEmpty();
    }

    public synchronized boolean isFull() {
        return this.bGk.size() == 2;
    }

    public synchronized void reset() {
        this.bGk.clear();
        this.bGl = false;
        Te();
    }

    public synchronized boolean bp(long j) {
        boolean z;
        if (isEmpty()) {
            z = true;
        } else {
            if (this.bGk.size() > 0) {
                Iterator<b> it = this.bGk.iterator();
                while (it.hasNext()) {
                    b next = it.next();
                    if (next != null && next.bGn != null && next.bGn.ayk == j) {
                        BdLog.e("BCVideoChat add user duplicate imUK=" + j);
                        z = false;
                        break;
                    } else if (next.status != d.bFJ && next.status != d.bFK) {
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
        return this.bGk.size();
    }

    public synchronized void c(b bVar) {
        if (bVar != null) {
            this.bGk.add(bVar);
            BdLog.d("BCVideoChat addUser=" + bVar.bGn.ayk + " current=" + bVar.status);
        }
    }

    public void db(boolean z) {
        this.bGl = z;
    }

    public boolean Td() {
        return this.bGl;
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
                Iterator<b> it = this.bGk.iterator();
                while (true) {
                    if (!it.hasNext()) {
                        z = false;
                        break;
                    }
                    b next = it.next();
                    if (next != null && next.bGn != null && next.bGn.ayk == j) {
                        break;
                    }
                }
                z2 = z;
            }
        }
        return z2;
    }

    public synchronized void a(int i, InterfaceC0204a interfaceC0204a) {
        Iterator<b> it = this.bGk.iterator();
        while (it.hasNext()) {
            b next = it.next();
            if (next != null && next.status == i && interfaceC0204a != null) {
                interfaceC0204a.b(next);
            }
        }
    }

    public synchronized boolean ek(int i) {
        boolean z;
        Iterator<b> it = this.bGk.iterator();
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
        r5.bGj.add(java.lang.Integer.valueOf(r0.index));
        Tf();
     */
    /* JADX WARN: Code restructure failed: missing block: B:19:0x0060, code lost:
        r5.bGk.remove(r0);
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public synchronized void bq(long j) {
        if (j != 0) {
            Iterator<b> it = this.bGk.iterator();
            while (true) {
                if (!it.hasNext()) {
                    break;
                }
                b next = it.next();
                if (next != null && next.bGn != null && next.bGn.ayk == j) {
                    break;
                }
            }
        }
    }

    public synchronized b el(int i) {
        b bVar;
        Iterator<b> it = this.bGk.iterator();
        while (true) {
            if (!it.hasNext()) {
                bVar = null;
                break;
            }
            bVar = it.next();
            if (bVar != null && bVar.bGn != null && bVar.index == i) {
                break;
            }
        }
        return bVar;
    }

    public synchronized b br(long j) {
        b bVar;
        Iterator<b> it = this.bGk.iterator();
        while (true) {
            if (!it.hasNext()) {
                bVar = null;
                break;
            }
            bVar = it.next();
            if (bVar != null && bVar.bGn != null && bVar.bGn.ayk == j) {
                break;
            }
        }
        return bVar;
    }

    private synchronized void Te() {
        this.bGj.clear();
        for (int i = 1; i <= 2; i++) {
            this.bGj.add(Integer.valueOf(i));
        }
        Tf();
    }

    private synchronized void Tf() {
        Collections.sort(this.bGj, new Comparator<Integer>() { // from class: com.baidu.live.talentshow.d.a.a.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // java.util.Comparator
            /* renamed from: a */
            public int compare(Integer num, Integer num2) {
                return num.intValue() > num2.intValue() ? 1 : -1;
            }
        });
    }
}
