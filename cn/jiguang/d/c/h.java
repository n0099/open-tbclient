package cn.jiguang.d.c;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
/* loaded from: classes3.dex */
public final class h implements Cloneable {
    private static m[] lO = new m[0];
    private static l[] lP = new l[0];
    private int c;
    private g lM;
    private List[] lN;

    public h() {
        this(new g());
    }

    private h(d dVar) {
        this(new g(dVar));
        for (int i = 0; i < 4; i++) {
            try {
                int b = this.lM.b(i);
                if (b > 0) {
                    this.lN[i] = new ArrayList(b);
                }
                for (int i2 = 0; i2 < b; i2++) {
                    this.lN[i].add(m.a(dVar, i));
                }
            } catch (t e) {
                throw e;
            }
        }
        this.c = dVar.a();
    }

    private h(g gVar) {
        this.lN = new List[4];
        this.lM = gVar;
    }

    public h(byte[] bArr) {
        this(new d(bArr));
    }

    public static h b(m mVar) {
        h hVar = new h();
        if (hVar.lN[0] == null) {
            hVar.lN[0] = new LinkedList();
        }
        hVar.lM.a(0);
        hVar.lN[0].add(mVar);
        return hVar;
    }

    public final byte[] b(int i) {
        int i2;
        int i3;
        int i4;
        e eVar = new e();
        this.lM.a(eVar);
        b bVar = new b();
        this.lM.a();
        int i5 = 0;
        while (true) {
            int i6 = i5;
            if (i6 >= 4) {
                this.c = eVar.a();
                return eVar.b();
            }
            if (this.lN[i6] != null) {
                int size = this.lN[i6].size();
                int a = eVar.a();
                int i7 = 0;
                int i8 = 0;
                m mVar = null;
                int i9 = 0;
                while (true) {
                    if (i9 < size) {
                        m mVar2 = (m) this.lN[i6].get(i9);
                        if (i6 == 3) {
                            m mVar3 = mVar;
                            i2 = a;
                            i3 = i7;
                            i4 = i8 + 1;
                            mVar2 = mVar3;
                        } else {
                            if (mVar != null) {
                                if (!(mVar2.d() == mVar.d() && mVar2.e() == mVar.e() && mVar2.b().equals(mVar.b()))) {
                                    a = eVar.a();
                                    i7 = i9;
                                }
                            }
                            mVar2.a(eVar, bVar);
                            if (eVar.a() > 65535) {
                                eVar.a(a);
                                int i10 = (size - i7) + i8;
                                break;
                            }
                            i2 = a;
                            i3 = i7;
                            i4 = i8;
                        }
                        i9++;
                        i8 = i4;
                        i7 = i3;
                        a = i2;
                        mVar = mVar2;
                    }
                }
            }
            i5 = i6 + 1;
        }
    }

    public final m bR() {
        List list = this.lN[0];
        if (list == null || list.size() == 0) {
            return null;
        }
        return (m) list.get(0);
    }

    public final Object clone() {
        h hVar = new h();
        for (int i = 0; i < this.lN.length; i++) {
            if (this.lN[i] != null) {
                hVar.lN[i] = new LinkedList(this.lN[i]);
            }
        }
        hVar.lM = (g) this.lM.clone();
        hVar.c = this.c;
        return hVar;
    }

    public final l[] m(int i) {
        m[] mVarArr;
        boolean z;
        if (this.lN[1] == null) {
            return lP;
        }
        LinkedList linkedList = new LinkedList();
        if (this.lN[1] == null) {
            mVarArr = lO;
        } else {
            List list = this.lN[1];
            mVarArr = (m[]) list.toArray(new m[list.size()]);
        }
        HashSet hashSet = new HashSet();
        for (int i2 = 0; i2 < mVarArr.length; i2++) {
            j b = mVarArr[i2].b();
            if (hashSet.contains(b)) {
                for (int size = linkedList.size() - 1; size >= 0; size--) {
                    l lVar = (l) linkedList.get(size);
                    if (lVar.b().d() == mVarArr[i2].d() && lVar.b().e() == mVarArr[i2].e() && lVar.b().b().equals(b)) {
                        lVar.a(mVarArr[i2]);
                        z = false;
                        break;
                    }
                }
            }
            z = true;
            if (z) {
                linkedList.add(new l(mVarArr[i2]));
                hashSet.add(b);
            }
        }
        return (l[]) linkedList.toArray(new l[linkedList.size()]);
    }
}
