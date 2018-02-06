package android.support.v7.widget;

import android.support.v7.widget.c;
import java.util.List;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes2.dex */
public class n {
    final a QU;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes2.dex */
    public interface a {
        c.b a(int i, int i2, int i3, Object obj);

        void g(c.b bVar);
    }

    public n(a aVar) {
        this.QU = aVar;
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
        if (bVar.Mq < bVar.Ms) {
            z = bVar2.Mq == bVar.Mq && bVar2.Ms == bVar.Ms - bVar.Mq;
        } else if (bVar2.Mq == bVar.Ms + 1 && bVar2.Ms == bVar.Mq - bVar.Ms) {
            z2 = true;
            z = true;
        } else {
            z = false;
            z2 = true;
        }
        if (bVar.Ms < bVar2.Mq) {
            bVar2.Mq--;
        } else if (bVar.Ms < bVar2.Mq + bVar2.Ms) {
            bVar2.Ms--;
            bVar.cmd = 2;
            bVar.Ms = 1;
            if (bVar2.Ms == 0) {
                list.remove(i2);
                this.QU.g(bVar2);
                return;
            }
            return;
        }
        if (bVar.Mq <= bVar2.Mq) {
            bVar2.Mq++;
            bVar3 = null;
        } else if (bVar.Mq < bVar2.Mq + bVar2.Ms) {
            bVar3 = this.QU.a(2, bVar.Mq + 1, (bVar2.Mq + bVar2.Ms) - bVar.Mq, null);
            bVar2.Ms = bVar.Mq - bVar2.Mq;
        } else {
            bVar3 = null;
        }
        if (z) {
            list.set(i, bVar2);
            list.remove(i2);
            this.QU.g(bVar);
            return;
        }
        if (z2) {
            if (bVar3 != null) {
                if (bVar.Mq > bVar3.Mq) {
                    bVar.Mq -= bVar3.Ms;
                }
                if (bVar.Ms > bVar3.Mq) {
                    bVar.Ms -= bVar3.Ms;
                }
            }
            if (bVar.Mq > bVar2.Mq) {
                bVar.Mq -= bVar2.Ms;
            }
            if (bVar.Ms > bVar2.Mq) {
                bVar.Ms -= bVar2.Ms;
            }
        } else {
            if (bVar3 != null) {
                if (bVar.Mq >= bVar3.Mq) {
                    bVar.Mq -= bVar3.Ms;
                }
                if (bVar.Ms >= bVar3.Mq) {
                    bVar.Ms -= bVar3.Ms;
                }
            }
            if (bVar.Mq >= bVar2.Mq) {
                bVar.Mq -= bVar2.Ms;
            }
            if (bVar.Ms >= bVar2.Mq) {
                bVar.Ms -= bVar2.Ms;
            }
        }
        list.set(i, bVar2);
        if (bVar.Mq != bVar.Ms) {
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
        if (bVar.Ms < bVar2.Mq) {
            i3 = -1;
        }
        if (bVar.Mq < bVar2.Mq) {
            i3++;
        }
        if (bVar2.Mq <= bVar.Mq) {
            bVar.Mq += bVar2.Ms;
        }
        if (bVar2.Mq <= bVar.Ms) {
            bVar.Ms += bVar2.Ms;
        }
        bVar2.Mq = i3 + bVar2.Mq;
        list.set(i, bVar2);
        list.set(i2, bVar);
    }

    void c(List<c.b> list, int i, c.b bVar, int i2, c.b bVar2) {
        c.b bVar3;
        c.b bVar4 = null;
        if (bVar.Ms < bVar2.Mq) {
            bVar2.Mq--;
            bVar3 = null;
        } else if (bVar.Ms < bVar2.Mq + bVar2.Ms) {
            bVar2.Ms--;
            bVar3 = this.QU.a(4, bVar.Mq, 1, bVar2.Mr);
        } else {
            bVar3 = null;
        }
        if (bVar.Mq <= bVar2.Mq) {
            bVar2.Mq++;
        } else if (bVar.Mq < bVar2.Mq + bVar2.Ms) {
            int i3 = (bVar2.Mq + bVar2.Ms) - bVar.Mq;
            bVar4 = this.QU.a(4, bVar.Mq + 1, i3, bVar2.Mr);
            bVar2.Ms -= i3;
        }
        list.set(i2, bVar);
        if (bVar2.Ms > 0) {
            list.set(i, bVar2);
        } else {
            list.remove(i);
            this.QU.g(bVar2);
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
