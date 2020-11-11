package com.baidu.live.talentshow.d.a;

import com.baidu.live.adp.lib.util.BdLog;
import com.baidu.live.talentshow.d.d;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
/* loaded from: classes4.dex */
public class a {
    private ArrayList<Integer> bzb = new ArrayList<>();
    private ArrayList<b> bzc = new ArrayList<>();
    private boolean bzd = false;

    /* renamed from: com.baidu.live.talentshow.d.a.a$a  reason: collision with other inner class name */
    /* loaded from: classes4.dex */
    public interface InterfaceC0205a {
        void b(b bVar);
    }

    public a() {
        Sw();
    }

    public synchronized int Su() {
        int intValue;
        if (this.bzb.size() == 0) {
            BdLog.e("BCVideoChat getNextIndex fail");
            intValue = -1;
        } else {
            this.bzb.remove(0);
            intValue = this.bzb.get(0).intValue();
        }
        return intValue;
    }

    public synchronized boolean isEmpty() {
        return this.bzc.isEmpty();
    }

    public synchronized boolean isFull() {
        return this.bzc.size() == 2;
    }

    public synchronized void reset() {
        this.bzc.clear();
        this.bzd = false;
        Sw();
    }

    public synchronized boolean aN(long j) {
        boolean z;
        if (isEmpty()) {
            z = true;
        } else {
            if (this.bzc.size() > 0) {
                Iterator<b> it = this.bzc.iterator();
                while (it.hasNext()) {
                    b next = it.next();
                    if (next != null && next.bzf != null && next.bzf.aBv == j) {
                        BdLog.e("BCVideoChat add user duplicate imUK=" + j);
                        z = false;
                        break;
                    } else if (next.status != d.byC && next.status != d.byD) {
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
        return this.bzc.size();
    }

    public synchronized void c(b bVar) {
        if (bVar != null) {
            this.bzc.add(bVar);
            BdLog.d("BCVideoChat addUser=" + bVar.bzf.aBv + " current=" + bVar.status);
        }
    }

    public void cE(boolean z) {
        this.bzd = z;
    }

    public boolean Sv() {
        return this.bzd;
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
                Iterator<b> it = this.bzc.iterator();
                while (true) {
                    if (!it.hasNext()) {
                        z = false;
                        break;
                    }
                    b next = it.next();
                    if (next != null && next.bzf != null && next.bzf.aBv == j) {
                        break;
                    }
                }
                z2 = z;
            }
        }
        return z2;
    }

    public synchronized void a(int i, InterfaceC0205a interfaceC0205a) {
        Iterator<b> it = this.bzc.iterator();
        while (it.hasNext()) {
            b next = it.next();
            if (next != null && next.status == i && interfaceC0205a != null) {
                interfaceC0205a.b(next);
            }
        }
    }

    public synchronized boolean fr(int i) {
        boolean z;
        Iterator<b> it = this.bzc.iterator();
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
        r5.bzb.add(java.lang.Integer.valueOf(r0.index));
        Sx();
     */
    /* JADX WARN: Code restructure failed: missing block: B:19:0x0060, code lost:
        r5.bzc.remove(r0);
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public synchronized void aO(long j) {
        if (j != 0) {
            Iterator<b> it = this.bzc.iterator();
            while (true) {
                if (!it.hasNext()) {
                    break;
                }
                b next = it.next();
                if (next != null && next.bzf != null && next.bzf.aBv == j) {
                    break;
                }
            }
        }
    }

    public synchronized b fs(int i) {
        b bVar;
        Iterator<b> it = this.bzc.iterator();
        while (true) {
            if (!it.hasNext()) {
                bVar = null;
                break;
            }
            bVar = it.next();
            if (bVar != null && bVar.bzf != null && bVar.index == i) {
                break;
            }
        }
        return bVar;
    }

    public synchronized b aP(long j) {
        b bVar;
        Iterator<b> it = this.bzc.iterator();
        while (true) {
            if (!it.hasNext()) {
                bVar = null;
                break;
            }
            bVar = it.next();
            if (bVar != null && bVar.bzf != null && bVar.bzf.aBv == j) {
                break;
            }
        }
        return bVar;
    }

    private synchronized void Sw() {
        this.bzb.clear();
        for (int i = 1; i <= 2; i++) {
            this.bzb.add(Integer.valueOf(i));
        }
        Sx();
    }

    private synchronized void Sx() {
        Collections.sort(this.bzb, new Comparator<Integer>() { // from class: com.baidu.live.talentshow.d.a.a.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // java.util.Comparator
            public int compare(Integer num, Integer num2) {
                return num.intValue() > num2.intValue() ? 1 : -1;
            }
        });
    }
}
