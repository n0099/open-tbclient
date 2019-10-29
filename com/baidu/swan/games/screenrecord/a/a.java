package com.baidu.swan.games.screenrecord.a;

import java.util.Comparator;
/* loaded from: classes2.dex */
public class a {
    public long bDM;
    public long bDN;

    public static long[] a(a aVar) {
        if (aVar == null) {
            return null;
        }
        return new long[]{aVar.bDM, aVar.bDN};
    }

    public boolean b(a aVar) {
        if (this.bDM > aVar.bDN || this.bDN < aVar.bDM) {
            return false;
        }
        this.bDM = Math.min(this.bDM, aVar.bDM);
        this.bDN = Math.max(this.bDN, aVar.bDN);
        return true;
    }

    /* renamed from: com.baidu.swan.games.screenrecord.a.a$a  reason: collision with other inner class name */
    /* loaded from: classes2.dex */
    public static class C0258a implements Comparator<a> {
        /* JADX DEBUG: Method merged with bridge method */
        @Override // java.util.Comparator
        /* renamed from: a */
        public int compare(a aVar, a aVar2) {
            return (int) (aVar.bDM - aVar2.bDM);
        }
    }
}
