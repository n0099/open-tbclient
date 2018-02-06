package android.support.v7.widget;

import android.support.v4.util.Pools;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.n;
import java.util.ArrayList;
import java.util.List;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes2.dex */
public class c implements n.a {
    private Pools.Pool<b> Mi;
    final ArrayList<b> Mj;
    final ArrayList<b> Mk;
    final a Ml;
    Runnable Mm;
    final boolean Mn;
    final n Mo;
    private int Mp;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes2.dex */
    public interface a {
        void B(int i, int i2);

        void C(int i, int i2);

        void D(int i, int i2);

        void E(int i, int i2);

        RecyclerView.ViewHolder bd(int i);

        void e(int i, int i2, Object obj);

        void h(b bVar);

        void i(b bVar);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public c(a aVar) {
        this(aVar, false);
    }

    c(a aVar, boolean z) {
        this.Mi = new Pools.SimplePool(30);
        this.Mj = new ArrayList<>();
        this.Mk = new ArrayList<>();
        this.Mp = 0;
        this.Ml = aVar;
        this.Mn = z;
        this.Mo = new n(this);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void reset() {
        k(this.Mj);
        k(this.Mk);
        this.Mp = 0;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void fB() {
        this.Mo.m(this.Mj);
        int size = this.Mj.size();
        for (int i = 0; i < size; i++) {
            b bVar = this.Mj.get(i);
            switch (bVar.cmd) {
                case 1:
                    e(bVar);
                    break;
                case 2:
                    b(bVar);
                    break;
                case 4:
                    c(bVar);
                    break;
                case 8:
                    a(bVar);
                    break;
            }
            if (this.Mm != null) {
                this.Mm.run();
            }
        }
        this.Mj.clear();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void fC() {
        int size = this.Mk.size();
        for (int i = 0; i < size; i++) {
            this.Ml.i(this.Mk.get(i));
        }
        k(this.Mk);
        this.Mp = 0;
    }

    private void a(b bVar) {
        f(bVar);
    }

    private void b(b bVar) {
        boolean z;
        int i;
        int i2;
        int i3;
        int i4 = bVar.Mq;
        int i5 = bVar.Mq + bVar.Ms;
        char c = 65535;
        int i6 = bVar.Mq;
        int i7 = 0;
        while (i6 < i5) {
            if (this.Ml.bd(i6) != null || aZ(i6)) {
                if (c == 0) {
                    d(a(2, i4, i7, null));
                    z = true;
                } else {
                    z = false;
                }
                c = 1;
            } else {
                if (c == 1) {
                    f(a(2, i4, i7, null));
                    z = true;
                } else {
                    z = false;
                }
                c = 0;
            }
            if (z) {
                i3 = i6 - i7;
                i = i5 - i7;
                i2 = 1;
            } else {
                int i8 = i6;
                i = i5;
                i2 = i7 + 1;
                i3 = i8;
            }
            i7 = i2;
            i5 = i;
            i6 = i3 + 1;
        }
        if (i7 != bVar.Ms) {
            g(bVar);
            bVar = a(2, i4, i7, null);
        }
        if (c == 0) {
            d(bVar);
        } else {
            f(bVar);
        }
    }

    private void c(b bVar) {
        int i;
        int i2;
        boolean z;
        int i3 = bVar.Mq;
        int i4 = bVar.Mq + bVar.Ms;
        int i5 = bVar.Mq;
        boolean z2 = true;
        int i6 = 0;
        while (i5 < i4) {
            if (this.Ml.bd(i5) != null || aZ(i5)) {
                if (!z2) {
                    d(a(4, i3, i6, bVar.Mr));
                    i6 = 0;
                    i3 = i5;
                }
                i = i3;
                i2 = i6;
                z = true;
            } else {
                if (z2) {
                    f(a(4, i3, i6, bVar.Mr));
                    i6 = 0;
                    i3 = i5;
                }
                i = i3;
                i2 = i6;
                z = false;
            }
            i5++;
            boolean z3 = z;
            i6 = i2 + 1;
            i3 = i;
            z2 = z3;
        }
        if (i6 != bVar.Ms) {
            Object obj = bVar.Mr;
            g(bVar);
            bVar = a(4, i3, i6, obj);
        }
        if (!z2) {
            d(bVar);
        } else {
            f(bVar);
        }
    }

    private void d(b bVar) {
        int i;
        boolean z;
        if (bVar.cmd == 1 || bVar.cmd == 8) {
            throw new IllegalArgumentException("should not dispatch add or move for pre layout");
        }
        int x = x(bVar.Mq, bVar.cmd);
        int i2 = bVar.Mq;
        switch (bVar.cmd) {
            case 2:
                i = 0;
                break;
            case 3:
            default:
                throw new IllegalArgumentException("op should be remove or update." + bVar);
            case 4:
                i = 1;
                break;
        }
        int i3 = 1;
        int i4 = x;
        int i5 = i2;
        for (int i6 = 1; i6 < bVar.Ms; i6++) {
            int x2 = x(bVar.Mq + (i * i6), bVar.cmd);
            switch (bVar.cmd) {
                case 2:
                    if (x2 == i4) {
                        z = true;
                        break;
                    } else {
                        z = false;
                        break;
                    }
                case 3:
                default:
                    z = false;
                    break;
                case 4:
                    if (x2 == i4 + 1) {
                        z = true;
                        break;
                    } else {
                        z = false;
                        break;
                    }
            }
            if (z) {
                i3++;
            } else {
                b a2 = a(bVar.cmd, i4, i3, bVar.Mr);
                a(a2, i5);
                g(a2);
                if (bVar.cmd == 4) {
                    i5 += i3;
                }
                i3 = 1;
                i4 = x2;
            }
        }
        Object obj = bVar.Mr;
        g(bVar);
        if (i3 > 0) {
            b a3 = a(bVar.cmd, i4, i3, obj);
            a(a3, i5);
            g(a3);
        }
    }

    void a(b bVar, int i) {
        this.Ml.h(bVar);
        switch (bVar.cmd) {
            case 2:
                this.Ml.B(i, bVar.Ms);
                return;
            case 3:
            default:
                throw new IllegalArgumentException("only remove and update ops can be dispatched in first pass");
            case 4:
                this.Ml.e(i, bVar.Ms, bVar.Mr);
                return;
        }
    }

    private int x(int i, int i2) {
        int i3;
        int i4;
        int i5;
        int i6 = i;
        for (int size = this.Mk.size() - 1; size >= 0; size--) {
            b bVar = this.Mk.get(size);
            if (bVar.cmd == 8) {
                if (bVar.Mq < bVar.Ms) {
                    i3 = bVar.Mq;
                    i4 = bVar.Ms;
                } else {
                    i3 = bVar.Ms;
                    i4 = bVar.Mq;
                }
                if (i6 >= i3 && i6 <= i4) {
                    if (i3 == bVar.Mq) {
                        if (i2 == 1) {
                            bVar.Ms++;
                        } else if (i2 == 2) {
                            bVar.Ms--;
                        }
                        i5 = i6 + 1;
                    } else {
                        if (i2 == 1) {
                            bVar.Mq++;
                        } else if (i2 == 2) {
                            bVar.Mq--;
                        }
                        i5 = i6 - 1;
                    }
                } else {
                    if (i6 < bVar.Mq) {
                        if (i2 == 1) {
                            bVar.Mq++;
                            bVar.Ms++;
                            i5 = i6;
                        } else if (i2 == 2) {
                            bVar.Mq--;
                            bVar.Ms--;
                        }
                    }
                    i5 = i6;
                }
                i6 = i5;
            } else if (bVar.Mq <= i6) {
                if (bVar.cmd == 1) {
                    i6 -= bVar.Ms;
                } else if (bVar.cmd == 2) {
                    i6 += bVar.Ms;
                }
            } else if (i2 == 1) {
                bVar.Mq++;
            } else if (i2 == 2) {
                bVar.Mq--;
            }
        }
        for (int size2 = this.Mk.size() - 1; size2 >= 0; size2--) {
            b bVar2 = this.Mk.get(size2);
            if (bVar2.cmd == 8) {
                if (bVar2.Ms == bVar2.Mq || bVar2.Ms < 0) {
                    this.Mk.remove(size2);
                    g(bVar2);
                }
            } else if (bVar2.Ms <= 0) {
                this.Mk.remove(size2);
                g(bVar2);
            }
        }
        return i6;
    }

    private boolean aZ(int i) {
        int size = this.Mk.size();
        for (int i2 = 0; i2 < size; i2++) {
            b bVar = this.Mk.get(i2);
            if (bVar.cmd == 8) {
                if (y(bVar.Ms, i2 + 1) == i) {
                    return true;
                }
            } else if (bVar.cmd == 1) {
                int i3 = bVar.Mq + bVar.Ms;
                for (int i4 = bVar.Mq; i4 < i3; i4++) {
                    if (y(i4, i2 + 1) == i) {
                        return true;
                    }
                }
                continue;
            } else {
                continue;
            }
        }
        return false;
    }

    private void e(b bVar) {
        f(bVar);
    }

    private void f(b bVar) {
        this.Mk.add(bVar);
        switch (bVar.cmd) {
            case 1:
                this.Ml.D(bVar.Mq, bVar.Ms);
                return;
            case 2:
                this.Ml.C(bVar.Mq, bVar.Ms);
                return;
            case 3:
            case 5:
            case 6:
            case 7:
            default:
                throw new IllegalArgumentException("Unknown update op type for " + bVar);
            case 4:
                this.Ml.e(bVar.Mq, bVar.Ms, bVar.Mr);
                return;
            case 8:
                this.Ml.E(bVar.Mq, bVar.Ms);
                return;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean fD() {
        return this.Mj.size() > 0;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean ba(int i) {
        return (this.Mp & i) != 0;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public int bb(int i) {
        return y(i, 0);
    }

    int y(int i, int i2) {
        int size = this.Mk.size();
        int i3 = i;
        while (i2 < size) {
            b bVar = this.Mk.get(i2);
            if (bVar.cmd == 8) {
                if (bVar.Mq == i3) {
                    i3 = bVar.Ms;
                } else {
                    if (bVar.Mq < i3) {
                        i3--;
                    }
                    if (bVar.Ms <= i3) {
                        i3++;
                    }
                }
            } else if (bVar.Mq > i3) {
                continue;
            } else if (bVar.cmd == 2) {
                if (i3 < bVar.Mq + bVar.Ms) {
                    return -1;
                }
                i3 -= bVar.Ms;
            } else if (bVar.cmd == 1) {
                i3 += bVar.Ms;
            }
            i2++;
        }
        return i3;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean d(int i, int i2, Object obj) {
        if (i2 < 1) {
            return false;
        }
        this.Mj.add(a(4, i, i2, obj));
        this.Mp |= 4;
        return this.Mj.size() == 1;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean z(int i, int i2) {
        if (i2 < 1) {
            return false;
        }
        this.Mj.add(a(1, i, i2, null));
        this.Mp |= 1;
        return this.Mj.size() == 1;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean A(int i, int i2) {
        if (i2 < 1) {
            return false;
        }
        this.Mj.add(a(2, i, i2, null));
        this.Mp |= 2;
        return this.Mj.size() == 1;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean g(int i, int i2, int i3) {
        if (i == i2) {
            return false;
        }
        if (i3 != 1) {
            throw new IllegalArgumentException("Moving more than 1 item is not supported yet");
        }
        this.Mj.add(a(8, i, i2, null));
        this.Mp |= 8;
        return this.Mj.size() == 1;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void fE() {
        fC();
        int size = this.Mj.size();
        for (int i = 0; i < size; i++) {
            b bVar = this.Mj.get(i);
            switch (bVar.cmd) {
                case 1:
                    this.Ml.i(bVar);
                    this.Ml.D(bVar.Mq, bVar.Ms);
                    break;
                case 2:
                    this.Ml.i(bVar);
                    this.Ml.B(bVar.Mq, bVar.Ms);
                    break;
                case 4:
                    this.Ml.i(bVar);
                    this.Ml.e(bVar.Mq, bVar.Ms, bVar.Mr);
                    break;
                case 8:
                    this.Ml.i(bVar);
                    this.Ml.E(bVar.Mq, bVar.Ms);
                    break;
            }
            if (this.Mm != null) {
                this.Mm.run();
            }
        }
        k(this.Mj);
        this.Mp = 0;
    }

    public int bc(int i) {
        int size = this.Mj.size();
        int i2 = i;
        for (int i3 = 0; i3 < size; i3++) {
            b bVar = this.Mj.get(i3);
            switch (bVar.cmd) {
                case 1:
                    if (bVar.Mq <= i2) {
                        i2 += bVar.Ms;
                        break;
                    } else {
                        break;
                    }
                case 2:
                    if (bVar.Mq <= i2) {
                        if (bVar.Mq + bVar.Ms > i2) {
                            return -1;
                        }
                        i2 -= bVar.Ms;
                        break;
                    } else {
                        continue;
                    }
                case 8:
                    if (bVar.Mq == i2) {
                        i2 = bVar.Ms;
                        break;
                    } else {
                        if (bVar.Mq < i2) {
                            i2--;
                        }
                        if (bVar.Ms <= i2) {
                            i2++;
                            break;
                        } else {
                            break;
                        }
                    }
            }
        }
        return i2;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean fF() {
        return (this.Mk.isEmpty() || this.Mj.isEmpty()) ? false : true;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes2.dex */
    public static class b {
        int Mq;
        Object Mr;
        int Ms;
        int cmd;

        b(int i, int i2, int i3, Object obj) {
            this.cmd = i;
            this.Mq = i2;
            this.Ms = i3;
            this.Mr = obj;
        }

        String fG() {
            switch (this.cmd) {
                case 1:
                    return "add";
                case 2:
                    return "rm";
                case 3:
                case 5:
                case 6:
                case 7:
                default:
                    return "??";
                case 4:
                    return "up";
                case 8:
                    return "mv";
            }
        }

        public String toString() {
            return Integer.toHexString(System.identityHashCode(this)) + "[" + fG() + ",s:" + this.Mq + "c:" + this.Ms + ",p:" + this.Mr + "]";
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj == null || getClass() != obj.getClass()) {
                return false;
            }
            b bVar = (b) obj;
            if (this.cmd != bVar.cmd) {
                return false;
            }
            if (this.cmd == 8 && Math.abs(this.Ms - this.Mq) == 1 && this.Ms == bVar.Mq && this.Mq == bVar.Ms) {
                return true;
            }
            if (this.Ms == bVar.Ms && this.Mq == bVar.Mq) {
                return this.Mr != null ? this.Mr.equals(bVar.Mr) : bVar.Mr == null;
            }
            return false;
        }

        public int hashCode() {
            return (((this.cmd * 31) + this.Mq) * 31) + this.Ms;
        }
    }

    @Override // android.support.v7.widget.n.a
    public b a(int i, int i2, int i3, Object obj) {
        b acquire = this.Mi.acquire();
        if (acquire == null) {
            return new b(i, i2, i3, obj);
        }
        acquire.cmd = i;
        acquire.Mq = i2;
        acquire.Ms = i3;
        acquire.Mr = obj;
        return acquire;
    }

    @Override // android.support.v7.widget.n.a
    public void g(b bVar) {
        if (!this.Mn) {
            bVar.Mr = null;
            this.Mi.release(bVar);
        }
    }

    void k(List<b> list) {
        int size = list.size();
        for (int i = 0; i < size; i++) {
            g(list.get(i));
        }
        list.clear();
    }
}
