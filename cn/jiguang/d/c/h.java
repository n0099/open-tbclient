package cn.jiguang.d.c;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
/* loaded from: classes3.dex */
public final class h implements Cloneable {
    private static m[] lR = new m[0];
    private static l[] lS = new l[0];
    private int c;
    private g lP;
    private List[] lQ;

    public h() {
        this(new g());
    }

    private h(d dVar) {
        this(new g(dVar));
        for (int i = 0; i < 4; i++) {
            try {
                int b = this.lP.b(i);
                if (b > 0) {
                    this.lQ[i] = new ArrayList(b);
                }
                for (int i2 = 0; i2 < b; i2++) {
                    this.lQ[i].add(m.a(dVar, i));
                }
            } catch (t e) {
                throw e;
            }
        }
        this.c = dVar.a();
    }

    private h(g gVar) {
        this.lQ = new List[4];
        this.lP = gVar;
    }

    public h(byte[] bArr) {
        this(new d(bArr));
    }

    public static h b(m mVar) {
        h hVar = new h();
        if (hVar.lQ[0] == null) {
            hVar.lQ[0] = new LinkedList();
        }
        hVar.lP.a(0);
        hVar.lQ[0].add(mVar);
        return hVar;
    }

    public final byte[] b(int i) {
        int i2;
        int i3;
        int i4;
        e eVar = new e();
        this.lP.a(eVar);
        b bVar = new b();
        this.lP.a();
        int i5 = 0;
        while (true) {
            int i6 = i5;
            if (i6 >= 4) {
                this.c = eVar.a();
                return eVar.b();
            }
            if (this.lQ[i6] != null) {
                int size = this.lQ[i6].size();
                int a = eVar.a();
                int i7 = 0;
                int i8 = 0;
                m mVar = null;
                int i9 = 0;
                while (true) {
                    if (i9 < size) {
                        m mVar2 = (m) this.lQ[i6].get(i9);
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

    public final m bQ() {
        List list = this.lQ[0];
        if (list == null || list.size() == 0) {
            return null;
        }
        return (m) list.get(0);
    }

    public final Object clone() {
        h hVar = new h();
        for (int i = 0; i < this.lQ.length; i++) {
            if (this.lQ[i] != null) {
                hVar.lQ[i] = new LinkedList(this.lQ[i]);
            }
        }
        hVar.lP = (g) this.lP.clone();
        hVar.c = this.c;
        return hVar;
    }

    public final l[] m(int i) {
        m[] mVarArr;
        boolean z;
        if (this.lQ[1] == null) {
            return lS;
        }
        LinkedList linkedList = new LinkedList();
        if (this.lQ[1] == null) {
            mVarArr = lR;
        } else {
            List list = this.lQ[1];
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
