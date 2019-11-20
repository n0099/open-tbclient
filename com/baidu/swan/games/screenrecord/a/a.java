package com.baidu.swan.games.screenrecord.a;

import java.util.Comparator;
/* loaded from: classes2.dex */
public class a {
    public long bCV;
    public long bCW;

    public static long[] a(a aVar) {
        if (aVar == null) {
            return null;
        }
        return new long[]{aVar.bCV, aVar.bCW};
    }

    public boolean b(a aVar) {
        if (this.bCV > aVar.bCW || this.bCW < aVar.bCV) {
            return false;
        }
        this.bCV = Math.min(this.bCV, aVar.bCV);
        this.bCW = Math.max(this.bCW, aVar.bCW);
        return true;
    }

    /* renamed from: com.baidu.swan.games.screenrecord.a.a$a  reason: collision with other inner class name */
    /* loaded from: classes2.dex */
    public static class C0258a implements Comparator<a> {
        /* JADX DEBUG: Method merged with bridge method */
        @Override // java.util.Comparator
        /* renamed from: a */
        public int compare(a aVar, a aVar2) {
            return (int) (aVar.bCV - aVar2.bCV);
        }
    }
}
