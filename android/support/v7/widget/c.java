package android.support.v7.widget;

import android.support.v4.util.Pools;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.n;
import java.util.ArrayList;
import java.util.List;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes2.dex */
public class c implements n.a {
    private Pools.Pool<b> Md;
    final ArrayList<b> Me;
    final ArrayList<b> Mf;
    final a Mg;
    Runnable Mh;
    final boolean Mi;
    final n Mj;
    private int Mk;

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
        this.Md = new Pools.SimplePool(30);
        this.Me = new ArrayList<>();
        this.Mf = new ArrayList<>();
        this.Mk = 0;
        this.Mg = aVar;
        this.Mi = z;
        this.Mj = new n(this);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void reset() {
        k(this.Me);
        k(this.Mf);
        this.Mk = 0;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void fB() {
        this.Mj.m(this.Me);
        int size = this.Me.size();
        for (int i = 0; i < size; i++) {
            b bVar = this.Me.get(i);
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
            if (this.Mh != null) {
                this.Mh.run();
            }
        }
        this.Me.clear();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void fC() {
        int size = this.Mf.size();
        for (int i = 0; i < size; i++) {
            this.Mg.i(this.Mf.get(i));
        }
        k(this.Mf);
        this.Mk = 0;
    }

    private void a(b bVar) {
        f(bVar);
    }

    private void b(b bVar) {
        boolean z;
        int i;
        int i2;
        int i3;
        int i4 = bVar.Ml;
        int i5 = bVar.Ml + bVar.Mn;
        char c = 65535;
        int i6 = bVar.Ml;
        int i7 = 0;
        while (i6 < i5) {
            if (this.Mg.bd(i6) != null || aZ(i6)) {
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
        if (i7 != bVar.Mn) {
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
        int i3 = bVar.Ml;
        int i4 = bVar.Ml + bVar.Mn;
        int i5 = bVar.Ml;
        boolean z2 = true;
        int i6 = 0;
        while (i5 < i4) {
            if (this.Mg.bd(i5) != null || aZ(i5)) {
                if (!z2) {
                    d(a(4, i3, i6, bVar.Mm));
                    i6 = 0;
                    i3 = i5;
                }
                i = i3;
                i2 = i6;
                z = true;
            } else {
                if (z2) {
                    f(a(4, i3, i6, bVar.Mm));
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
        if (i6 != bVar.Mn) {
            Object obj = bVar.Mm;
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
        int x = x(bVar.Ml, bVar.cmd);
        int i2 = bVar.Ml;
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
        for (int i6 = 1; i6 < bVar.Mn; i6++) {
            int x2 = x(bVar.Ml + (i * i6), bVar.cmd);
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
                b a2 = a(bVar.cmd, i4, i3, bVar.Mm);
                a(a2, i5);
                g(a2);
                if (bVar.cmd == 4) {
                    i5 += i3;
                }
                i3 = 1;
                i4 = x2;
            }
        }
        Object obj = bVar.Mm;
        g(bVar);
        if (i3 > 0) {
            b a3 = a(bVar.cmd, i4, i3, obj);
            a(a3, i5);
            g(a3);
        }
    }

    void a(b bVar, int i) {
        this.Mg.h(bVar);
        switch (bVar.cmd) {
            case 2:
                this.Mg.B(i, bVar.Mn);
                return;
            case 3:
            default:
                throw new IllegalArgumentException("only remove and update ops can be dispatched in first pass");
            case 4:
                this.Mg.e(i, bVar.Mn, bVar.Mm);
                return;
        }
    }

    private int x(int i, int i2) {
        int i3;
        int i4;
        int i5;
        int i6 = i;
        for (int size = this.Mf.size() - 1; size >= 0; size--) {
            b bVar = this.Mf.get(size);
            if (bVar.cmd == 8) {
                if (bVar.Ml < bVar.Mn) {
                    i3 = bVar.Ml;
                    i4 = bVar.Mn;
                } else {
                    i3 = bVar.Mn;
                    i4 = bVar.Ml;
                }
                if (i6 >= i3 && i6 <= i4) {
                    if (i3 == bVar.Ml) {
                        if (i2 == 1) {
                            bVar.Mn++;
                        } else if (i2 == 2) {
                            bVar.Mn--;
                        }
                        i5 = i6 + 1;
                    } else {
                        if (i2 == 1) {
                            bVar.Ml++;
                        } else if (i2 == 2) {
                            bVar.Ml--;
                        }
                        i5 = i6 - 1;
                    }
                } else {
                    if (i6 < bVar.Ml) {
                        if (i2 == 1) {
                            bVar.Ml++;
                            bVar.Mn++;
                            i5 = i6;
                        } else if (i2 == 2) {
                            bVar.Ml--;
                            bVar.Mn--;
                        }
                    }
                    i5 = i6;
                }
                i6 = i5;
            } else if (bVar.Ml <= i6) {
                if (bVar.cmd == 1) {
                    i6 -= bVar.Mn;
                } else if (bVar.cmd == 2) {
                    i6 += bVar.Mn;
                }
            } else if (i2 == 1) {
                bVar.Ml++;
            } else if (i2 == 2) {
                bVar.Ml--;
            }
        }
        for (int size2 = this.Mf.size() - 1; size2 >= 0; size2--) {
            b bVar2 = this.Mf.get(size2);
            if (bVar2.cmd == 8) {
                if (bVar2.Mn == bVar2.Ml || bVar2.Mn < 0) {
                    this.Mf.remove(size2);
                    g(bVar2);
                }
            } else if (bVar2.Mn <= 0) {
                this.Mf.remove(size2);
                g(bVar2);
            }
        }
        return i6;
    }

    private boolean aZ(int i) {
        int size = this.Mf.size();
        for (int i2 = 0; i2 < size; i2++) {
            b bVar = this.Mf.get(i2);
            if (bVar.cmd == 8) {
                if (y(bVar.Mn, i2 + 1) == i) {
                    return true;
                }
            } else if (bVar.cmd == 1) {
                int i3 = bVar.Ml + bVar.Mn;
                for (int i4 = bVar.Ml; i4 < i3; i4++) {
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
        this.Mf.add(bVar);
        switch (bVar.cmd) {
            case 1:
                this.Mg.D(bVar.Ml, bVar.Mn);
                return;
            case 2:
                this.Mg.C(bVar.Ml, bVar.Mn);
                return;
            case 3:
            case 5:
            case 6:
            case 7:
            default:
                throw new IllegalArgumentException("Unknown update op type for " + bVar);
            case 4:
                this.Mg.e(bVar.Ml, bVar.Mn, bVar.Mm);
                return;
            case 8:
                this.Mg.E(bVar.Ml, bVar.Mn);
                return;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean fD() {
        return this.Me.size() > 0;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean ba(int i) {
        return (this.Mk & i) != 0;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public int bb(int i) {
        return y(i, 0);
    }

    int y(int i, int i2) {
        int size = this.Mf.size();
        int i3 = i;
        while (i2 < size) {
            b bVar = this.Mf.get(i2);
            if (bVar.cmd == 8) {
                if (bVar.Ml == i3) {
                    i3 = bVar.Mn;
                } else {
                    if (bVar.Ml < i3) {
                        i3--;
                    }
                    if (bVar.Mn <= i3) {
                        i3++;
                    }
                }
            } else if (bVar.Ml > i3) {
                continue;
            } else if (bVar.cmd == 2) {
                if (i3 < bVar.Ml + bVar.Mn) {
                    return -1;
                }
                i3 -= bVar.Mn;
            } else if (bVar.cmd == 1) {
                i3 += bVar.Mn;
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
        this.Me.add(a(4, i, i2, obj));
        this.Mk |= 4;
        return this.Me.size() == 1;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean z(int i, int i2) {
        if (i2 < 1) {
            return false;
        }
        this.Me.add(a(1, i, i2, null));
        this.Mk |= 1;
        return this.Me.size() == 1;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean A(int i, int i2) {
        if (i2 < 1) {
            return false;
        }
        this.Me.add(a(2, i, i2, null));
        this.Mk |= 2;
        return this.Me.size() == 1;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean g(int i, int i2, int i3) {
        if (i == i2) {
            return false;
        }
        if (i3 != 1) {
            throw new IllegalArgumentException("Moving more than 1 item is not supported yet");
        }
        this.Me.add(a(8, i, i2, null));
        this.Mk |= 8;
        return this.Me.size() == 1;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void fE() {
        fC();
        int size = this.Me.size();
        for (int i = 0; i < size; i++) {
            b bVar = this.Me.get(i);
            switch (bVar.cmd) {
                case 1:
                    this.Mg.i(bVar);
                    this.Mg.D(bVar.Ml, bVar.Mn);
                    break;
                case 2:
                    this.Mg.i(bVar);
                    this.Mg.B(bVar.Ml, bVar.Mn);
                    break;
                case 4:
                    this.Mg.i(bVar);
                    this.Mg.e(bVar.Ml, bVar.Mn, bVar.Mm);
                    break;
                case 8:
                    this.Mg.i(bVar);
                    this.Mg.E(bVar.Ml, bVar.Mn);
                    break;
            }
            if (this.Mh != null) {
                this.Mh.run();
            }
        }
        k(this.Me);
        this.Mk = 0;
    }

    public int bc(int i) {
        int size = this.Me.size();
        int i2 = i;
        for (int i3 = 0; i3 < size; i3++) {
            b bVar = this.Me.get(i3);
            switch (bVar.cmd) {
                case 1:
                    if (bVar.Ml <= i2) {
                        i2 += bVar.Mn;
                        break;
                    } else {
                        break;
                    }
                case 2:
                    if (bVar.Ml <= i2) {
                        if (bVar.Ml + bVar.Mn > i2) {
                            return -1;
                        }
                        i2 -= bVar.Mn;
                        break;
                    } else {
                        continue;
                    }
                case 8:
                    if (bVar.Ml == i2) {
                        i2 = bVar.Mn;
                        break;
                    } else {
                        if (bVar.Ml < i2) {
                            i2--;
                        }
                        if (bVar.Mn <= i2) {
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
        return (this.Mf.isEmpty() || this.Me.isEmpty()) ? false : true;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes2.dex */
    public static class b {
        int Ml;
        Object Mm;
        int Mn;
        int cmd;

        b(int i, int i2, int i3, Object obj) {
            this.cmd = i;
            this.Ml = i2;
            this.Mn = i3;
            this.Mm = obj;
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
            return Integer.toHexString(System.identityHashCode(this)) + "[" + fG() + ",s:" + this.Ml + "c:" + this.Mn + ",p:" + this.Mm + "]";
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
            if (this.cmd == 8 && Math.abs(this.Mn - this.Ml) == 1 && this.Mn == bVar.Ml && this.Ml == bVar.Mn) {
                return true;
            }
            if (this.Mn == bVar.Mn && this.Ml == bVar.Ml) {
                return this.Mm != null ? this.Mm.equals(bVar.Mm) : bVar.Mm == null;
            }
            return false;
        }

        public int hashCode() {
            return (((this.cmd * 31) + this.Ml) * 31) + this.Mn;
        }
    }

    @Override // android.support.v7.widget.n.a
    public b a(int i, int i2, int i3, Object obj) {
        b acquire = this.Md.acquire();
        if (acquire == null) {
            return new b(i, i2, i3, obj);
        }
        acquire.cmd = i;
        acquire.Ml = i2;
        acquire.Mn = i3;
        acquire.Mm = obj;
        return acquire;
    }

    @Override // android.support.v7.widget.n.a
    public void g(b bVar) {
        if (!this.Mi) {
            bVar.Mm = null;
            this.Md.release(bVar);
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
