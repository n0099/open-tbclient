package com.baidu.swan.games.screenrecord.a;

import java.util.Comparator;
/* loaded from: classes2.dex */
public class a {
    public long bkA;
    public long bkB;

    public static long[] a(a aVar) {
        if (aVar == null) {
            return null;
        }
        return new long[]{aVar.bkA, aVar.bkB};
    }

    public boolean b(a aVar) {
        if (this.bkA > aVar.bkB || this.bkB < aVar.bkA) {
            return false;
        }
        this.bkA = Math.min(this.bkA, aVar.bkA);
        this.bkB = Math.max(this.bkB, aVar.bkB);
        return true;
    }

    /* renamed from: com.baidu.swan.games.screenrecord.a.a$a  reason: collision with other inner class name */
    /* loaded from: classes2.dex */
    public static class C0212a implements Comparator<a> {
        /* JADX DEBUG: Method merged with bridge method */
        @Override // java.util.Comparator
        /* renamed from: a */
        public int compare(a aVar, a aVar2) {
            return (int) (aVar.bkA - aVar2.bkA);
        }
    }
}
