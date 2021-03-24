package com.baidu.mobstat;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
/* loaded from: classes2.dex */
public enum k {
    AP_LIST(0) { // from class: com.baidu.mobstat.k.1
        @Override // com.baidu.mobstat.k
        public j a() {
            return new n();
        }
    },
    APP_LIST(1) { // from class: com.baidu.mobstat.k.2
        @Override // com.baidu.mobstat.k
        public j a() {
            return new q();
        }
    },
    APP_TRACE(2) { // from class: com.baidu.mobstat.k.3
        @Override // com.baidu.mobstat.k
        public j a() {
            return new r();
        }
    },
    APP_CHANGE(3) { // from class: com.baidu.mobstat.k.4
        @Override // com.baidu.mobstat.k
        public j a() {
            return new p();
        }
    },
    APP_APK(4) { // from class: com.baidu.mobstat.k.5
        @Override // com.baidu.mobstat.k
        public j a() {
            return new o();
        }
    };
    

    /* renamed from: f  reason: collision with root package name */
    public int f9242f;

    /* JADX DEBUG: Another duplicated slice has different insns count: {[IF]}, finally: {[IF, INVOKE] complete} */
    private int c() {
        j jVar = null;
        try {
            try {
                jVar = a();
            } catch (Exception e2) {
                bb.c().b(e2);
                if (jVar == null) {
                    return 0;
                }
            }
            if (jVar.a()) {
                int b2 = jVar.b();
                if (jVar != null) {
                    jVar.close();
                }
                return b2;
            }
            if (jVar == null) {
                return 0;
            }
            jVar.close();
            return 0;
        } catch (Throwable th) {
            if (jVar != null) {
                jVar.close();
            }
            throw th;
        }
    }

    public abstract j a();

    /* JADX WARN: Code restructure failed: missing block: B:12:0x001c, code lost:
        if (r1 != null) goto L15;
     */
    /* JADX WARN: Code restructure failed: missing block: B:13:0x001e, code lost:
        r1.close();
     */
    /* JADX WARN: Code restructure failed: missing block: B:19:0x002c, code lost:
        if (r1 == null) goto L16;
     */
    /* JADX WARN: Code restructure failed: missing block: B:22:0x0030, code lost:
        return r0;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public synchronized ArrayList<i> a(int i, int i2) {
        ArrayList<i> arrayList = new ArrayList<>();
        j jVar = null;
        try {
            jVar = a();
            if (!jVar.a()) {
                if (jVar != null) {
                    jVar.close();
                }
                return arrayList;
            }
            arrayList = jVar.a(i, i2);
        } catch (Exception e2) {
            bb.c().b(e2);
        }
    }

    public synchronized boolean b() {
        return c() == 0;
    }

    @Override // java.lang.Enum
    public String toString() {
        return String.valueOf(this.f9242f);
    }

    k(int i) {
        this.f9242f = i;
    }

    public synchronized boolean b(int i) {
        return c() >= i;
    }

    /* JADX WARN: Code restructure failed: missing block: B:11:0x001d, code lost:
        if (r2 != null) goto L13;
     */
    /* JADX WARN: Code restructure failed: missing block: B:12:0x001f, code lost:
        r2.close();
     */
    /* JADX WARN: Code restructure failed: missing block: B:18:0x002d, code lost:
        if (r2 == null) goto L14;
     */
    /* JADX WARN: Code restructure failed: missing block: B:21:0x0031, code lost:
        return r0;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public synchronized long a(long j, String str) {
        long j2 = -1;
        j jVar = null;
        try {
            jVar = a();
            if (!jVar.a()) {
                if (jVar != null) {
                    jVar.close();
                }
                return -1L;
            }
            j2 = jVar.a(String.valueOf(j), str);
        } catch (Exception e2) {
            bb.c().b(e2);
        }
    }

    public synchronized int a(ArrayList<Long> arrayList) {
        int i = 0;
        if (arrayList != null) {
            if (arrayList.size() != 0) {
                j jVar = null;
                try {
                    jVar = a();
                } catch (Exception e2) {
                    e = e2;
                }
                if (!jVar.a()) {
                    if (jVar != null) {
                        jVar.close();
                    }
                    return 0;
                }
                int size = arrayList.size();
                int i2 = 0;
                while (i < size) {
                    try {
                        if (!jVar.b(arrayList.get(i).longValue())) {
                            if (jVar != null) {
                                jVar.close();
                            }
                            return i2;
                        }
                        i2++;
                        i++;
                    } catch (Exception e3) {
                        e = e3;
                        i = i2;
                        bb.c().b(e);
                        if (jVar != null) {
                            jVar.close();
                        }
                        i2 = i;
                        return i2;
                    }
                }
                if (jVar != null) {
                    jVar.close();
                }
                return i2;
            }
        }
        return 0;
    }

    public synchronized List<String> a(int i) {
        List<String> arrayList;
        arrayList = new ArrayList<>();
        ArrayList<Long> arrayList2 = new ArrayList<>();
        ArrayList<i> arrayList3 = new ArrayList<>();
        a(arrayList, arrayList2, arrayList3, i, 500);
        if (arrayList3.size() != 0 && arrayList.size() == 0 && arrayList2.size() == 0) {
            i iVar = arrayList3.get(0);
            long a2 = iVar.a();
            String b2 = iVar.b();
            arrayList2.add(Long.valueOf(a2));
            arrayList.add(b2);
        }
        int a3 = a(arrayList2);
        if (a3 != arrayList.size()) {
            arrayList = arrayList.subList(0, a3);
        }
        return arrayList;
    }

    private int a(List<String> list, ArrayList<Long> arrayList, ArrayList<i> arrayList2, int i, int i2) {
        int c2 = c();
        int i3 = 0;
        int i4 = 0;
        while (c2 > 0) {
            if (c2 < i2) {
                i2 = c2;
            }
            ArrayList<i> a2 = a(i2, i4);
            if (i4 == 0 && a2.size() != 0) {
                arrayList2.add(a2.get(0));
            }
            Iterator<i> it = a2.iterator();
            while (it.hasNext()) {
                i next = it.next();
                long a3 = next.a();
                String b2 = next.b();
                int length = b2.length() + i3;
                if (length > i) {
                    break;
                }
                arrayList.add(Long.valueOf(a3));
                list.add(b2);
                i3 = length;
            }
            c2 -= i2;
            i4 += i2;
        }
        return i3;
    }
}
