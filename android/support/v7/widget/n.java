package android.support.v7.widget;

import android.support.v7.widget.c;
import java.util.List;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes2.dex */
public class n {
    final a QV;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes2.dex */
    public interface a {
        c.b a(int i, int i2, int i3, Object obj);

        void g(c.b bVar);
    }

    public n(a aVar) {
        this.QV = aVar;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void m(List<c.b> list) {
        while (true) {
            int n = n(list);
            if (n != -1) {
                a(list, n, n + 1);
            } else {
                return;
            }
        }
    }

    private void a(List<c.b> list, int i, int i2) {
        c.b bVar = list.get(i);
        c.b bVar2 = list.get(i2);
        switch (bVar2.cmd) {
            case 1:
                b(list, i, bVar, i2, bVar2);
                return;
            case 2:
                a(list, i, bVar, i2, bVar2);
                return;
            case 3:
            default:
                return;
            case 4:
                c(list, i, bVar, i2, bVar2);
                return;
        }
    }

    void a(List<c.b> list, int i, c.b bVar, int i2, c.b bVar2) {
        boolean z;
        c.b bVar3;
        boolean z2 = false;
        if (bVar.Mr < bVar.Mt) {
            z = bVar2.Mr == bVar.Mr && bVar2.Mt == bVar.Mt - bVar.Mr;
        } else if (bVar2.Mr == bVar.Mt + 1 && bVar2.Mt == bVar.Mr - bVar.Mt) {
            z2 = true;
            z = true;
        } else {
            z = false;
            z2 = true;
        }
        if (bVar.Mt < bVar2.Mr) {
            bVar2.Mr--;
        } else if (bVar.Mt < bVar2.Mr + bVar2.Mt) {
            bVar2.Mt--;
            bVar.cmd = 2;
            bVar.Mt = 1;
            if (bVar2.Mt == 0) {
                list.remove(i2);
                this.QV.g(bVar2);
                return;
            }
            return;
        }
        if (bVar.Mr <= bVar2.Mr) {
            bVar2.Mr++;
            bVar3 = null;
        } else if (bVar.Mr < bVar2.Mr + bVar2.Mt) {
            bVar3 = this.QV.a(2, bVar.Mr + 1, (bVar2.Mr + bVar2.Mt) - bVar.Mr, null);
            bVar2.Mt = bVar.Mr - bVar2.Mr;
        } else {
            bVar3 = null;
        }
        if (z) {
            list.set(i, bVar2);
            list.remove(i2);
            this.QV.g(bVar);
            return;
        }
        if (z2) {
            if (bVar3 != null) {
                if (bVar.Mr > bVar3.Mr) {
                    bVar.Mr -= bVar3.Mt;
                }
                if (bVar.Mt > bVar3.Mr) {
                    bVar.Mt -= bVar3.Mt;
                }
            }
            if (bVar.Mr > bVar2.Mr) {
                bVar.Mr -= bVar2.Mt;
            }
            if (bVar.Mt > bVar2.Mr) {
                bVar.Mt -= bVar2.Mt;
            }
        } else {
            if (bVar3 != null) {
                if (bVar.Mr >= bVar3.Mr) {
                    bVar.Mr -= bVar3.Mt;
                }
                if (bVar.Mt >= bVar3.Mr) {
                    bVar.Mt -= bVar3.Mt;
                }
            }
            if (bVar.Mr >= bVar2.Mr) {
                bVar.Mr -= bVar2.Mt;
            }
            if (bVar.Mt >= bVar2.Mr) {
                bVar.Mt -= bVar2.Mt;
            }
        }
        list.set(i, bVar2);
        if (bVar.Mr != bVar.Mt) {
            list.set(i2, bVar);
        } else {
            list.remove(i2);
        }
        if (bVar3 != null) {
            list.add(i, bVar3);
        }
    }

    private void b(List<c.b> list, int i, c.b bVar, int i2, c.b bVar2) {
        int i3 = 0;
        if (bVar.Mt < bVar2.Mr) {
            i3 = -1;
        }
        if (bVar.Mr < bVar2.Mr) {
            i3++;
        }
        if (bVar2.Mr <= bVar.Mr) {
            bVar.Mr += bVar2.Mt;
        }
        if (bVar2.Mr <= bVar.Mt) {
            bVar.Mt += bVar2.Mt;
        }
        bVar2.Mr = i3 + bVar2.Mr;
        list.set(i, bVar2);
        list.set(i2, bVar);
    }

    void c(List<c.b> list, int i, c.b bVar, int i2, c.b bVar2) {
        c.b bVar3;
        c.b bVar4 = null;
        if (bVar.Mt < bVar2.Mr) {
            bVar2.Mr--;
            bVar3 = null;
        } else if (bVar.Mt < bVar2.Mr + bVar2.Mt) {
            bVar2.Mt--;
            bVar3 = this.QV.a(4, bVar.Mr, 1, bVar2.Ms);
        } else {
            bVar3 = null;
        }
        if (bVar.Mr <= bVar2.Mr) {
            bVar2.Mr++;
        } else if (bVar.Mr < bVar2.Mr + bVar2.Mt) {
            int i3 = (bVar2.Mr + bVar2.Mt) - bVar.Mr;
            bVar4 = this.QV.a(4, bVar.Mr + 1, i3, bVar2.Ms);
            bVar2.Mt -= i3;
        }
        list.set(i2, bVar);
        if (bVar2.Mt > 0) {
            list.set(i, bVar2);
        } else {
            list.remove(i);
            this.QV.g(bVar2);
        }
        if (bVar3 != null) {
            list.add(i, bVar3);
        }
        if (bVar4 != null) {
            list.add(i, bVar4);
        }
    }

    private int n(List<c.b> list) {
        boolean z;
        boolean z2 = false;
        int size = list.size() - 1;
        while (size >= 0) {
            if (list.get(size).cmd == 8) {
                if (z2) {
                    return size;
                }
                z = z2;
            } else {
                z = true;
            }
            size--;
            z2 = z;
        }
        return -1;
    }
}
