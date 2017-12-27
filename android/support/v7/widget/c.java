package android.support.v7.widget;

import android.support.v4.util.Pools;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.n;
import java.util.ArrayList;
import java.util.List;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes2.dex */
public class c implements n.a {
    private Pools.Pool<b> Mj;
    final ArrayList<b> Mk;
    final ArrayList<b> Ml;
    final a Mm;
    Runnable Mn;
    final boolean Mo;
    final n Mp;
    private int Mq;

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
        this.Mj = new Pools.SimplePool(30);
        this.Mk = new ArrayList<>();
        this.Ml = new ArrayList<>();
        this.Mq = 0;
        this.Mm = aVar;
        this.Mo = z;
        this.Mp = new n(this);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void reset() {
        k(this.Mk);
        k(this.Ml);
        this.Mq = 0;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void fB() {
        this.Mp.m(this.Mk);
        int size = this.Mk.size();
        for (int i = 0; i < size; i++) {
            b bVar = this.Mk.get(i);
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
            if (this.Mn != null) {
                this.Mn.run();
            }
        }
        this.Mk.clear();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void fC() {
        int size = this.Ml.size();
        for (int i = 0; i < size; i++) {
            this.Mm.i(this.Ml.get(i));
        }
        k(this.Ml);
        this.Mq = 0;
    }

    private void a(b bVar) {
        f(bVar);
    }

    private void b(b bVar) {
        boolean z;
        int i;
        int i2;
        int i3;
        int i4 = bVar.Mr;
        int i5 = bVar.Mr + bVar.Mt;
        char c = 65535;
        int i6 = bVar.Mr;
        int i7 = 0;
        while (i6 < i5) {
            if (this.Mm.bd(i6) != null || aZ(i6)) {
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
        if (i7 != bVar.Mt) {
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
        int i3 = bVar.Mr;
        int i4 = bVar.Mr + bVar.Mt;
        int i5 = bVar.Mr;
        boolean z2 = true;
        int i6 = 0;
        while (i5 < i4) {
            if (this.Mm.bd(i5) != null || aZ(i5)) {
                if (!z2) {
                    d(a(4, i3, i6, bVar.Ms));
                    i6 = 0;
                    i3 = i5;
                }
                i = i3;
                i2 = i6;
                z = true;
            } else {
                if (z2) {
                    f(a(4, i3, i6, bVar.Ms));
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
        if (i6 != bVar.Mt) {
            Object obj = bVar.Ms;
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
        int x = x(bVar.Mr, bVar.cmd);
        int i2 = bVar.Mr;
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
        for (int i6 = 1; i6 < bVar.Mt; i6++) {
            int x2 = x(bVar.Mr + (i * i6), bVar.cmd);
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
                b a2 = a(bVar.cmd, i4, i3, bVar.Ms);
                a(a2, i5);
                g(a2);
                if (bVar.cmd == 4) {
                    i5 += i3;
                }
                i3 = 1;
                i4 = x2;
            }
        }
        Object obj = bVar.Ms;
        g(bVar);
        if (i3 > 0) {
            b a3 = a(bVar.cmd, i4, i3, obj);
            a(a3, i5);
            g(a3);
        }
    }

    void a(b bVar, int i) {
        this.Mm.h(bVar);
        switch (bVar.cmd) {
            case 2:
                this.Mm.B(i, bVar.Mt);
                return;
            case 3:
            default:
                throw new IllegalArgumentException("only remove and update ops can be dispatched in first pass");
            case 4:
                this.Mm.e(i, bVar.Mt, bVar.Ms);
                return;
        }
    }

    private int x(int i, int i2) {
        int i3;
        int i4;
        int i5;
        int i6 = i;
        for (int size = this.Ml.size() - 1; size >= 0; size--) {
            b bVar = this.Ml.get(size);
            if (bVar.cmd == 8) {
                if (bVar.Mr < bVar.Mt) {
                    i3 = bVar.Mr;
                    i4 = bVar.Mt;
                } else {
                    i3 = bVar.Mt;
                    i4 = bVar.Mr;
                }
                if (i6 >= i3 && i6 <= i4) {
                    if (i3 == bVar.Mr) {
                        if (i2 == 1) {
                            bVar.Mt++;
                        } else if (i2 == 2) {
                            bVar.Mt--;
                        }
                        i5 = i6 + 1;
                    } else {
                        if (i2 == 1) {
                            bVar.Mr++;
                        } else if (i2 == 2) {
                            bVar.Mr--;
                        }
                        i5 = i6 - 1;
                    }
                } else {
                    if (i6 < bVar.Mr) {
                        if (i2 == 1) {
                            bVar.Mr++;
                            bVar.Mt++;
                            i5 = i6;
                        } else if (i2 == 2) {
                            bVar.Mr--;
                            bVar.Mt--;
                        }
                    }
                    i5 = i6;
                }
                i6 = i5;
            } else if (bVar.Mr <= i6) {
                if (bVar.cmd == 1) {
                    i6 -= bVar.Mt;
                } else if (bVar.cmd == 2) {
                    i6 += bVar.Mt;
                }
            } else if (i2 == 1) {
                bVar.Mr++;
            } else if (i2 == 2) {
                bVar.Mr--;
            }
        }
        for (int size2 = this.Ml.size() - 1; size2 >= 0; size2--) {
            b bVar2 = this.Ml.get(size2);
            if (bVar2.cmd == 8) {
                if (bVar2.Mt == bVar2.Mr || bVar2.Mt < 0) {
                    this.Ml.remove(size2);
                    g(bVar2);
                }
            } else if (bVar2.Mt <= 0) {
                this.Ml.remove(size2);
                g(bVar2);
            }
        }
        return i6;
    }

    private boolean aZ(int i) {
        int size = this.Ml.size();
        for (int i2 = 0; i2 < size; i2++) {
            b bVar = this.Ml.get(i2);
            if (bVar.cmd == 8) {
                if (y(bVar.Mt, i2 + 1) == i) {
                    return true;
                }
            } else if (bVar.cmd == 1) {
                int i3 = bVar.Mr + bVar.Mt;
                for (int i4 = bVar.Mr; i4 < i3; i4++) {
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
        this.Ml.add(bVar);
        switch (bVar.cmd) {
            case 1:
                this.Mm.D(bVar.Mr, bVar.Mt);
                return;
            case 2:
                this.Mm.C(bVar.Mr, bVar.Mt);
                return;
            case 3:
            case 5:
            case 6:
            case 7:
            default:
                throw new IllegalArgumentException("Unknown update op type for " + bVar);
            case 4:
                this.Mm.e(bVar.Mr, bVar.Mt, bVar.Ms);
                return;
            case 8:
                this.Mm.E(bVar.Mr, bVar.Mt);
                return;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean fD() {
        return this.Mk.size() > 0;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean ba(int i) {
        return (this.Mq & i) != 0;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public int bb(int i) {
        return y(i, 0);
    }

    int y(int i, int i2) {
        int size = this.Ml.size();
        int i3 = i;
        while (i2 < size) {
            b bVar = this.Ml.get(i2);
            if (bVar.cmd == 8) {
                if (bVar.Mr == i3) {
                    i3 = bVar.Mt;
                } else {
                    if (bVar.Mr < i3) {
                        i3--;
                    }
                    if (bVar.Mt <= i3) {
                        i3++;
                    }
                }
            } else if (bVar.Mr > i3) {
                continue;
            } else if (bVar.cmd == 2) {
                if (i3 < bVar.Mr + bVar.Mt) {
                    return -1;
                }
                i3 -= bVar.Mt;
            } else if (bVar.cmd == 1) {
                i3 += bVar.Mt;
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
        this.Mk.add(a(4, i, i2, obj));
        this.Mq |= 4;
        return this.Mk.size() == 1;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean z(int i, int i2) {
        if (i2 < 1) {
            return false;
        }
        this.Mk.add(a(1, i, i2, null));
        this.Mq |= 1;
        return this.Mk.size() == 1;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean A(int i, int i2) {
        if (i2 < 1) {
            return false;
        }
        this.Mk.add(a(2, i, i2, null));
        this.Mq |= 2;
        return this.Mk.size() == 1;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean g(int i, int i2, int i3) {
        if (i == i2) {
            return false;
        }
        if (i3 != 1) {
            throw new IllegalArgumentException("Moving more than 1 item is not supported yet");
        }
        this.Mk.add(a(8, i, i2, null));
        this.Mq |= 8;
        return this.Mk.size() == 1;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void fE() {
        fC();
        int size = this.Mk.size();
        for (int i = 0; i < size; i++) {
            b bVar = this.Mk.get(i);
            switch (bVar.cmd) {
                case 1:
                    this.Mm.i(bVar);
                    this.Mm.D(bVar.Mr, bVar.Mt);
                    break;
                case 2:
                    this.Mm.i(bVar);
                    this.Mm.B(bVar.Mr, bVar.Mt);
                    break;
                case 4:
                    this.Mm.i(bVar);
                    this.Mm.e(bVar.Mr, bVar.Mt, bVar.Ms);
                    break;
                case 8:
                    this.Mm.i(bVar);
                    this.Mm.E(bVar.Mr, bVar.Mt);
                    break;
            }
            if (this.Mn != null) {
                this.Mn.run();
            }
        }
        k(this.Mk);
        this.Mq = 0;
    }

    public int bc(int i) {
        int size = this.Mk.size();
        int i2 = i;
        for (int i3 = 0; i3 < size; i3++) {
            b bVar = this.Mk.get(i3);
            switch (bVar.cmd) {
                case 1:
                    if (bVar.Mr <= i2) {
                        i2 += bVar.Mt;
                        break;
                    } else {
                        break;
                    }
                case 2:
                    if (bVar.Mr <= i2) {
                        if (bVar.Mr + bVar.Mt > i2) {
                            return -1;
                        }
                        i2 -= bVar.Mt;
                        break;
                    } else {
                        continue;
                    }
                case 8:
                    if (bVar.Mr == i2) {
                        i2 = bVar.Mt;
                        break;
                    } else {
                        if (bVar.Mr < i2) {
                            i2--;
                        }
                        if (bVar.Mt <= i2) {
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
        return (this.Ml.isEmpty() || this.Mk.isEmpty()) ? false : true;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes2.dex */
    public static class b {
        int Mr;
        Object Ms;
        int Mt;
        int cmd;

        b(int i, int i2, int i3, Object obj) {
            this.cmd = i;
            this.Mr = i2;
            this.Mt = i3;
            this.Ms = obj;
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
            return Integer.toHexString(System.identityHashCode(this)) + "[" + fG() + ",s:" + this.Mr + "c:" + this.Mt + ",p:" + this.Ms + "]";
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
            if (this.cmd == 8 && Math.abs(this.Mt - this.Mr) == 1 && this.Mt == bVar.Mr && this.Mr == bVar.Mt) {
                return true;
            }
            if (this.Mt == bVar.Mt && this.Mr == bVar.Mr) {
                return this.Ms != null ? this.Ms.equals(bVar.Ms) : bVar.Ms == null;
            }
            return false;
        }

        public int hashCode() {
            return (((this.cmd * 31) + this.Mr) * 31) + this.Mt;
        }
    }

    @Override // android.support.v7.widget.n.a
    public b a(int i, int i2, int i3, Object obj) {
        b acquire = this.Mj.acquire();
        if (acquire == null) {
            return new b(i, i2, i3, obj);
        }
        acquire.cmd = i;
        acquire.Mr = i2;
        acquire.Mt = i3;
        acquire.Ms = obj;
        return acquire;
    }

    @Override // android.support.v7.widget.n.a
    public void g(b bVar) {
        if (!this.Mo) {
            bVar.Ms = null;
            this.Mj.release(bVar);
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
