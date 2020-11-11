package com.baidu.swan.games.screenrecord.a;

import java.util.Comparator;
/* loaded from: classes10.dex */
public class a {
    public long end;
    public long start;

    public static long[] a(a aVar) {
        if (aVar == null) {
            return null;
        }
        return new long[]{aVar.start, aVar.end};
    }

    public boolean b(a aVar) {
        if (this.start > aVar.end || this.end < aVar.start) {
            return false;
        }
        this.start = Math.min(this.start, aVar.start);
        this.end = Math.max(this.end, aVar.end);
        return true;
    }

    /* renamed from: com.baidu.swan.games.screenrecord.a.a$a  reason: collision with other inner class name */
    /* loaded from: classes10.dex */
    public static class C0543a implements Comparator<a> {
        /* JADX DEBUG: Method merged with bridge method */
        @Override // java.util.Comparator
        /* renamed from: a */
        public int compare(a aVar, a aVar2) {
            return (int) (aVar.start - aVar2.start);
        }
    }
}
