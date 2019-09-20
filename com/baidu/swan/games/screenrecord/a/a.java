package com.baidu.swan.games.screenrecord.a;

import java.util.Comparator;
/* loaded from: classes2.dex */
public class a {
    public long bkY;
    public long bkZ;

    public static long[] a(a aVar) {
        if (aVar == null) {
            return null;
        }
        return new long[]{aVar.bkY, aVar.bkZ};
    }

    public boolean b(a aVar) {
        if (this.bkY > aVar.bkZ || this.bkZ < aVar.bkY) {
            return false;
        }
        this.bkY = Math.min(this.bkY, aVar.bkY);
        this.bkZ = Math.max(this.bkZ, aVar.bkZ);
        return true;
    }

    /* renamed from: com.baidu.swan.games.screenrecord.a.a$a  reason: collision with other inner class name */
    /* loaded from: classes2.dex */
    public static class C0226a implements Comparator<a> {
        /* JADX DEBUG: Method merged with bridge method */
        @Override // java.util.Comparator
        /* renamed from: a */
        public int compare(a aVar, a aVar2) {
            return (int) (aVar.bkY - aVar2.bkY);
        }
    }
}
