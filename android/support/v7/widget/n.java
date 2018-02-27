package android.support.v7.widget;

import android.support.v7.widget.c;
import java.util.List;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes2.dex */
public class n {
    final a QO;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes2.dex */
    public interface a {
        c.b a(int i, int i2, int i3, Object obj);

        void g(c.b bVar);
    }

    public n(a aVar) {
        this.QO = aVar;
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
        if (bVar.Ml < bVar.Mn) {
            z = bVar2.Ml == bVar.Ml && bVar2.Mn == bVar.Mn - bVar.Ml;
        } else if (bVar2.Ml == bVar.Mn + 1 && bVar2.Mn == bVar.Ml - bVar.Mn) {
            z2 = true;
            z = true;
        } else {
            z = false;
            z2 = true;
        }
        if (bVar.Mn < bVar2.Ml) {
            bVar2.Ml--;
        } else if (bVar.Mn < bVar2.Ml + bVar2.Mn) {
            bVar2.Mn--;
            bVar.cmd = 2;
            bVar.Mn = 1;
            if (bVar2.Mn == 0) {
                list.remove(i2);
                this.QO.g(bVar2);
                return;
            }
            return;
        }
        if (bVar.Ml <= bVar2.Ml) {
            bVar2.Ml++;
            bVar3 = null;
        } else if (bVar.Ml < bVar2.Ml + bVar2.Mn) {
            bVar3 = this.QO.a(2, bVar.Ml + 1, (bVar2.Ml + bVar2.Mn) - bVar.Ml, null);
            bVar2.Mn = bVar.Ml - bVar2.Ml;
        } else {
            bVar3 = null;
        }
        if (z) {
            list.set(i, bVar2);
            list.remove(i2);
            this.QO.g(bVar);
            return;
        }
        if (z2) {
            if (bVar3 != null) {
                if (bVar.Ml > bVar3.Ml) {
                    bVar.Ml -= bVar3.Mn;
                }
                if (bVar.Mn > bVar3.Ml) {
                    bVar.Mn -= bVar3.Mn;
                }
            }
            if (bVar.Ml > bVar2.Ml) {
                bVar.Ml -= bVar2.Mn;
            }
            if (bVar.Mn > bVar2.Ml) {
                bVar.Mn -= bVar2.Mn;
            }
        } else {
            if (bVar3 != null) {
                if (bVar.Ml >= bVar3.Ml) {
                    bVar.Ml -= bVar3.Mn;
                }
                if (bVar.Mn >= bVar3.Ml) {
                    bVar.Mn -= bVar3.Mn;
                }
            }
            if (bVar.Ml >= bVar2.Ml) {
                bVar.Ml -= bVar2.Mn;
            }
            if (bVar.Mn >= bVar2.Ml) {
                bVar.Mn -= bVar2.Mn;
            }
        }
        list.set(i, bVar2);
        if (bVar.Ml != bVar.Mn) {
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
        if (bVar.Mn < bVar2.Ml) {
            i3 = -1;
        }
        if (bVar.Ml < bVar2.Ml) {
            i3++;
        }
        if (bVar2.Ml <= bVar.Ml) {
            bVar.Ml += bVar2.Mn;
        }
        if (bVar2.Ml <= bVar.Mn) {
            bVar.Mn += bVar2.Mn;
        }
        bVar2.Ml = i3 + bVar2.Ml;
        list.set(i, bVar2);
        list.set(i2, bVar);
    }

    void c(List<c.b> list, int i, c.b bVar, int i2, c.b bVar2) {
        c.b bVar3;
        c.b bVar4 = null;
        if (bVar.Mn < bVar2.Ml) {
            bVar2.Ml--;
            bVar3 = null;
        } else if (bVar.Mn < bVar2.Ml + bVar2.Mn) {
            bVar2.Mn--;
            bVar3 = this.QO.a(4, bVar.Ml, 1, bVar2.Mm);
        } else {
            bVar3 = null;
        }
        if (bVar.Ml <= bVar2.Ml) {
            bVar2.Ml++;
        } else if (bVar.Ml < bVar2.Ml + bVar2.Mn) {
            int i3 = (bVar2.Ml + bVar2.Mn) - bVar.Ml;
            bVar4 = this.QO.a(4, bVar.Ml + 1, i3, bVar2.Mm);
            bVar2.Mn -= i3;
        }
        list.set(i2, bVar);
        if (bVar2.Mn > 0) {
            list.set(i, bVar2);
        } else {
            list.remove(i);
            this.QO.g(bVar2);
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
