package com.baidu.swan.games.screenrecord.a;

import java.util.Comparator;
/* loaded from: classes2.dex */
public class a {
    public long bjN;
    public long bjO;

    public static long[] a(a aVar) {
        if (aVar == null) {
            return null;
        }
        return new long[]{aVar.bjN, aVar.bjO};
    }

    public boolean b(a aVar) {
        if (this.bjN > aVar.bjO || this.bjO < aVar.bjN) {
            return false;
        }
        this.bjN = Math.min(this.bjN, aVar.bjN);
        this.bjO = Math.max(this.bjO, aVar.bjO);
        return true;
    }

    /* renamed from: com.baidu.swan.games.screenrecord.a.a$a  reason: collision with other inner class name */
    /* loaded from: classes2.dex */
    public static class C0215a implements Comparator<a> {
        /* JADX DEBUG: Method merged with bridge method */
        @Override // java.util.Comparator
        /* renamed from: a */
        public int compare(a aVar, a aVar2) {
            return (int) (aVar.bjN - aVar2.bjN);
        }
    }
}
