package com.baidu.live.talentshow.d.a;

import com.baidu.live.adp.lib.util.BdLog;
import com.baidu.live.talentshow.d.d;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
/* loaded from: classes10.dex */
public class a {
    private ArrayList<Integer> bHJ = new ArrayList<>();
    private ArrayList<b> bHK = new ArrayList<>();
    private boolean bHL = false;

    /* renamed from: com.baidu.live.talentshow.d.a.a$a  reason: collision with other inner class name */
    /* loaded from: classes10.dex */
    public interface InterfaceC0210a {
        void b(b bVar);
    }

    public a() {
        Th();
    }

    public synchronized int Tf() {
        int intValue;
        if (this.bHJ.size() == 0) {
            BdLog.e("BCVideoChat getNextIndex fail");
            intValue = -1;
        } else {
            this.bHJ.remove(0);
            intValue = this.bHJ.get(0).intValue();
        }
        return intValue;
    }

    public synchronized boolean isEmpty() {
        return this.bHK.isEmpty();
    }

    public synchronized boolean isFull() {
        return this.bHK.size() == 2;
    }

    public synchronized void reset() {
        this.bHK.clear();
        this.bHL = false;
        Th();
    }

    public synchronized boolean bp(long j) {
        boolean z;
        if (isEmpty()) {
            z = true;
        } else {
            if (this.bHK.size() > 0) {
                Iterator<b> it = this.bHK.iterator();
                while (it.hasNext()) {
                    b next = it.next();
                    if (next != null && next.bHN != null && next.bHN.azK == j) {
                        BdLog.e("BCVideoChat add user duplicate imUK=" + j);
                        z = false;
                        break;
                    } else if (next.status != d.bHj && next.status != d.bHk) {
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
        return this.bHK.size();
    }

    public synchronized void c(b bVar) {
        if (bVar != null) {
            this.bHK.add(bVar);
            BdLog.d("BCVideoChat addUser=" + bVar.bHN.azK + " current=" + bVar.status);
        }
    }

    public void db(boolean z) {
        this.bHL = z;
    }

    public boolean Tg() {
        return this.bHL;
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
                Iterator<b> it = this.bHK.iterator();
                while (true) {
                    if (!it.hasNext()) {
                        z = false;
                        break;
                    }
                    b next = it.next();
                    if (next != null && next.bHN != null && next.bHN.azK == j) {
                        break;
                    }
                }
                z2 = z;
            }
        }
        return z2;
    }

    public synchronized void a(int i, InterfaceC0210a interfaceC0210a) {
        Iterator<b> it = this.bHK.iterator();
        while (it.hasNext()) {
            b next = it.next();
            if (next != null && next.status == i && interfaceC0210a != null) {
                interfaceC0210a.b(next);
            }
        }
    }

    public synchronized boolean el(int i) {
        boolean z;
        Iterator<b> it = this.bHK.iterator();
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
        r5.bHJ.add(java.lang.Integer.valueOf(r0.index));
        Ti();
     */
    /* JADX WARN: Code restructure failed: missing block: B:19:0x0060, code lost:
        r5.bHK.remove(r0);
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public synchronized void bq(long j) {
        if (j != 0) {
            Iterator<b> it = this.bHK.iterator();
            while (true) {
                if (!it.hasNext()) {
                    break;
                }
                b next = it.next();
                if (next != null && next.bHN != null && next.bHN.azK == j) {
                    break;
                }
            }
        }
    }

    public synchronized b em(int i) {
        b bVar;
        Iterator<b> it = this.bHK.iterator();
        while (true) {
            if (!it.hasNext()) {
                bVar = null;
                break;
            }
            bVar = it.next();
            if (bVar != null && bVar.bHN != null && bVar.index == i) {
                break;
            }
        }
        return bVar;
    }

    public synchronized b br(long j) {
        b bVar;
        Iterator<b> it = this.bHK.iterator();
        while (true) {
            if (!it.hasNext()) {
                bVar = null;
                break;
            }
            bVar = it.next();
            if (bVar != null && bVar.bHN != null && bVar.bHN.azK == j) {
                break;
            }
        }
        return bVar;
    }

    private synchronized void Th() {
        this.bHJ.clear();
        for (int i = 1; i <= 2; i++) {
            this.bHJ.add(Integer.valueOf(i));
        }
        Ti();
    }

    private synchronized void Ti() {
        Collections.sort(this.bHJ, new Comparator<Integer>() { // from class: com.baidu.live.talentshow.d.a.a.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // java.util.Comparator
            /* renamed from: a */
            public int compare(Integer num, Integer num2) {
                return num.intValue() > num2.intValue() ? 1 : -1;
            }
        });
    }
}
