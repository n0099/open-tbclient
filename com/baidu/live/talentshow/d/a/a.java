package com.baidu.live.talentshow.d.a;

import com.baidu.live.adp.lib.util.BdLog;
import com.baidu.live.talentshow.d.d;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
/* loaded from: classes4.dex */
public class a {
    private ArrayList<Integer> bxq = new ArrayList<>();
    private ArrayList<b> bxr = new ArrayList<>();
    private boolean bxs = false;

    /* renamed from: com.baidu.live.talentshow.d.a.a$a  reason: collision with other inner class name */
    /* loaded from: classes4.dex */
    public interface InterfaceC0203a {
        void b(b bVar);
    }

    public a() {
        RN();
    }

    public synchronized int RL() {
        int intValue;
        if (this.bxq.size() == 0) {
            BdLog.e("BCVideoChat getNextIndex fail");
            intValue = -1;
        } else {
            this.bxq.remove(0);
            intValue = this.bxq.get(0).intValue();
        }
        return intValue;
    }

    public synchronized boolean isEmpty() {
        return this.bxr.isEmpty();
    }

    public synchronized boolean isFull() {
        return this.bxr.size() == 2;
    }

    public synchronized void reset() {
        this.bxr.clear();
        this.bxs = false;
        RN();
    }

    public synchronized boolean aN(long j) {
        boolean z;
        if (isEmpty()) {
            z = true;
        } else {
            if (this.bxr.size() > 0) {
                Iterator<b> it = this.bxr.iterator();
                while (it.hasNext()) {
                    b next = it.next();
                    if (next != null && next.bxu != null && next.bxu.azK == j) {
                        BdLog.e("BCVideoChat add user duplicate imUK=" + j);
                        z = false;
                        break;
                    } else if (next.status != d.bwR && next.status != d.bwS) {
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
        return this.bxr.size();
    }

    public synchronized void c(b bVar) {
        if (bVar != null) {
            this.bxr.add(bVar);
            BdLog.d("BCVideoChat addUser=" + bVar.bxu.azK + " current=" + bVar.status);
        }
    }

    public void cG(boolean z) {
        this.bxs = z;
    }

    public boolean RM() {
        return this.bxs;
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
                Iterator<b> it = this.bxr.iterator();
                while (true) {
                    if (!it.hasNext()) {
                        z = false;
                        break;
                    }
                    b next = it.next();
                    if (next != null && next.bxu != null && next.bxu.azK == j) {
                        break;
                    }
                }
                z2 = z;
            }
        }
        return z2;
    }

    public synchronized void a(int i, InterfaceC0203a interfaceC0203a) {
        Iterator<b> it = this.bxr.iterator();
        while (it.hasNext()) {
            b next = it.next();
            if (next != null && next.status == i && interfaceC0203a != null) {
                interfaceC0203a.b(next);
            }
        }
    }

    public synchronized boolean fn(int i) {
        boolean z;
        Iterator<b> it = this.bxr.iterator();
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
        r5.bxq.add(java.lang.Integer.valueOf(r0.index));
        RO();
     */
    /* JADX WARN: Code restructure failed: missing block: B:19:0x0060, code lost:
        r5.bxr.remove(r0);
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public synchronized void aO(long j) {
        if (j != 0) {
            Iterator<b> it = this.bxr.iterator();
            while (true) {
                if (!it.hasNext()) {
                    break;
                }
                b next = it.next();
                if (next != null && next.bxu != null && next.bxu.azK == j) {
                    break;
                }
            }
        }
    }

    public synchronized b fo(int i) {
        b bVar;
        Iterator<b> it = this.bxr.iterator();
        while (true) {
            if (!it.hasNext()) {
                bVar = null;
                break;
            }
            bVar = it.next();
            if (bVar != null && bVar.bxu != null && bVar.index == i) {
                break;
            }
        }
        return bVar;
    }

    public synchronized b aP(long j) {
        b bVar;
        Iterator<b> it = this.bxr.iterator();
        while (true) {
            if (!it.hasNext()) {
                bVar = null;
                break;
            }
            bVar = it.next();
            if (bVar != null && bVar.bxu != null && bVar.bxu.azK == j) {
                break;
            }
        }
        return bVar;
    }

    private synchronized void RN() {
        this.bxq.clear();
        for (int i = 1; i <= 2; i++) {
            this.bxq.add(Integer.valueOf(i));
        }
        RO();
    }

    private synchronized void RO() {
        Collections.sort(this.bxq, new Comparator<Integer>() { // from class: com.baidu.live.talentshow.d.a.a.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // java.util.Comparator
            public int compare(Integer num, Integer num2) {
                return num.intValue() > num2.intValue() ? 1 : -1;
            }
        });
    }
}
