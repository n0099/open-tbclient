package com.baidu.mobstat;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
/* loaded from: classes15.dex */
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
    
    private int f;

    public abstract j a();

    k(int i) {
        this.f = i;
    }

    @Override // java.lang.Enum
    public String toString() {
        return String.valueOf(this.f);
    }

    /* JADX DEBUG: Don't trust debug lines info. Repeating lines: [116=4, 117=4] */
    public synchronized ArrayList<i> a(int i, int i2) {
        ArrayList<i> arrayList;
        arrayList = new ArrayList<>();
        j jVar = null;
        try {
            jVar = a();
            if (jVar.a()) {
                arrayList = jVar.a(i, i2);
                if (jVar != null) {
                    jVar.close();
                }
            } else if (jVar != null) {
                jVar.close();
            }
        } catch (Exception e) {
            bb.c().b(e);
            if (jVar != null) {
                jVar.close();
            }
        }
        return arrayList;
    }

    /* JADX DEBUG: Don't trust debug lines info. Repeating lines: [149=4, 150=4] */
    public synchronized long a(long j, String str) {
        long j2;
        j2 = -1;
        j jVar = null;
        try {
            jVar = a();
            if (jVar.a()) {
                j2 = jVar.a(String.valueOf(j), str);
                if (jVar != null) {
                    jVar.close();
                }
            } else if (jVar != null) {
                jVar.close();
            }
        } catch (Exception e) {
            bb.c().b(e);
            if (jVar != null) {
                jVar.close();
            }
        }
        return j2;
    }

    /* JADX DEBUG: Don't trust debug lines info. Repeating lines: [253=5, 254=5] */
    public synchronized int a(ArrayList<Long> arrayList) {
        int i;
        int i2 = 0;
        synchronized (this) {
            if (arrayList != null) {
                if (arrayList.size() != 0) {
                    j jVar = null;
                    try {
                        jVar = a();
                    } catch (Exception e) {
                        i = i2;
                        bb.c().b(e);
                        if (jVar != null) {
                            jVar.close();
                        }
                    }
                    if (jVar.a()) {
                        int size = arrayList.size();
                        int i3 = 0;
                        while (i3 < size) {
                            if (jVar.b(arrayList.get(i3).longValue())) {
                                i3++;
                                i2++;
                            } else if (jVar != null) {
                                jVar.close();
                            }
                        }
                        if (jVar != null) {
                            jVar.close();
                            i = i2;
                        } else {
                            i = i2;
                        }
                        i2 = i;
                    } else if (jVar != null) {
                        jVar.close();
                    }
                }
            }
        }
        return i2;
    }

    public synchronized List<String> a(int i) {
        List<String> arrayList;
        arrayList = new ArrayList<>();
        ArrayList<Long> arrayList2 = new ArrayList<>();
        ArrayList<i> arrayList3 = new ArrayList<>();
        a(arrayList, arrayList2, arrayList3, i, 500);
        if (arrayList3.size() != 0 && arrayList.size() == 0 && arrayList2.size() == 0) {
            i iVar = arrayList3.get(0);
            long a = iVar.a();
            String b = iVar.b();
            arrayList2.add(Long.valueOf(a));
            arrayList.add(b);
        }
        int a2 = a(arrayList2);
        if (a2 != arrayList.size()) {
            arrayList = arrayList.subList(0, a2);
        }
        return arrayList;
    }

    private int a(List<String> list, ArrayList<Long> arrayList, ArrayList<i> arrayList2, int i, int i2) {
        int i3 = 0;
        int c = c();
        int i4 = 0;
        int i5 = i2;
        while (c > 0) {
            int i6 = c < i5 ? c : i5;
            ArrayList<i> a = a(i6, i4);
            if (i4 == 0 && a.size() != 0) {
                arrayList2.add(a.get(0));
            }
            Iterator<i> it = a.iterator();
            while (it.hasNext()) {
                i next = it.next();
                long a2 = next.a();
                String b = next.b();
                int length = b.length();
                if (i3 + length > i) {
                    break;
                }
                arrayList.add(Long.valueOf(a2));
                list.add(b);
                i3 += length;
            }
            c -= i6;
            i4 += i6;
            i5 = i6;
        }
        return i3;
    }

    public synchronized boolean b() {
        return c() == 0;
    }

    public synchronized boolean b(int i) {
        return c() >= i;
    }

    /* JADX DEBUG: Another duplicated slice has different insns count: {[IF]}, finally: {[IF, INVOKE] complete} */
    /* JADX DEBUG: Don't trust debug lines info. Repeating lines: [369=4, 370=4] */
    private int c() {
        j jVar = null;
        try {
            try {
                jVar = a();
            } catch (Exception e) {
                bb.c().b(e);
                if (jVar != null) {
                    jVar.close();
                }
            }
            if (jVar.a()) {
                int b = jVar.b();
            }
            if (jVar != null) {
                jVar.close();
            }
            return 0;
        } finally {
            if (jVar != null) {
                jVar.close();
            }
        }
    }
}
