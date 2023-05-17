package com.baidu.mobstat;

import android.content.Context;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
/* loaded from: classes3.dex */
public enum k {
    AP_LIST(0) { // from class: com.baidu.mobstat.k.1
        @Override // com.baidu.mobstat.k
        public j a(Context context) {
            return new m(context);
        }
    },
    APP_LIST(1) { // from class: com.baidu.mobstat.k.2
        @Override // com.baidu.mobstat.k
        public j a(Context context) {
            return new p(context);
        }
    },
    APP_TRACE(2) { // from class: com.baidu.mobstat.k.3
        @Override // com.baidu.mobstat.k
        public j a(Context context) {
            return new q(context);
        }
    },
    APP_CHANGE(3) { // from class: com.baidu.mobstat.k.4
        @Override // com.baidu.mobstat.k
        public j a(Context context) {
            return new o(context);
        }
    },
    APP_APK(4) { // from class: com.baidu.mobstat.k.5
        @Override // com.baidu.mobstat.k
        public j a(Context context) {
            return new n(context);
        }
    };
    
    public int f;

    public abstract j a(Context context);

    k(int i) {
        this.f = i;
    }

    private int a(Context context, List<String> list, ArrayList<Long> arrayList, ArrayList<i> arrayList2, int i, int i2) {
        int c = c(context);
        int i3 = 0;
        int i4 = 0;
        while (c > 0) {
            if (c < i2) {
                i2 = c;
            }
            ArrayList<i> a = a(context, i2, i4);
            if (i4 == 0 && a.size() != 0) {
                arrayList2.add(a.get(0));
            }
            Iterator<i> it = a.iterator();
            while (it.hasNext()) {
                i next = it.next();
                long a2 = next.a();
                String b = next.b();
                int length = b.length() + i3;
                if (length > i) {
                    break;
                }
                arrayList.add(Long.valueOf(a2));
                list.add(b);
                i3 = length;
            }
            c -= i2;
            i4 += i2;
        }
        return i3;
    }

    /* JADX DEBUG: Another duplicated slice has different insns count: {[IF]}, finally: {[IF, INVOKE] complete} */
    private int c(Context context) {
        j jVar = null;
        try {
            try {
                jVar = a(context);
            } catch (Exception e) {
                ba.c().b(e);
                if (jVar == null) {
                    return 0;
                }
            }
            if (jVar.a()) {
                int b = jVar.b();
                if (jVar != null) {
                    jVar.close();
                }
                return b;
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

    public synchronized boolean b(Context context) {
        boolean z;
        if (c(context) == 0) {
            z = true;
        } else {
            z = false;
        }
        return z;
    }

    @Override // java.lang.Enum
    public String toString() {
        return String.valueOf(this.f);
    }

    public synchronized int a(Context context, ArrayList<Long> arrayList) {
        int i = 0;
        if (arrayList != null) {
            if (arrayList.size() != 0) {
                j jVar = null;
                try {
                    jVar = a(context);
                } catch (Exception e) {
                    e = e;
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
                    } catch (Exception e2) {
                        e = e2;
                        i = i2;
                        ba.c().b(e);
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
    public synchronized long a(Context context, long j, String str) {
        long j2 = -1;
        j jVar = null;
        try {
            jVar = a(context);
            if (!jVar.a()) {
                if (jVar != null) {
                    jVar.close();
                }
                return -1L;
            }
            j2 = jVar.a(String.valueOf(j), str);
        } catch (Exception e) {
            ba.c().b(e);
        }
    }

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
    public synchronized ArrayList<i> a(Context context, int i, int i2) {
        ArrayList<i> arrayList = new ArrayList<>();
        j jVar = null;
        try {
            jVar = a(context);
            if (!jVar.a()) {
                if (jVar != null) {
                    jVar.close();
                }
                return arrayList;
            }
            arrayList = jVar.a(i, i2);
        } catch (Exception e) {
            ba.c().b(e);
        }
    }

    public synchronized List<String> a(Context context, int i) {
        List<String> arrayList;
        arrayList = new ArrayList<>();
        ArrayList<Long> arrayList2 = new ArrayList<>();
        ArrayList<i> arrayList3 = new ArrayList<>();
        a(context, arrayList, arrayList2, arrayList3, i, 500);
        if (arrayList3.size() != 0 && arrayList.size() == 0 && arrayList2.size() == 0) {
            i iVar = arrayList3.get(0);
            long a = iVar.a();
            String b = iVar.b();
            arrayList2.add(Long.valueOf(a));
            arrayList.add(b);
        }
        int a2 = a(context, arrayList2);
        if (a2 != arrayList.size()) {
            arrayList = arrayList.subList(0, a2);
        }
        return arrayList;
    }

    public synchronized boolean b(Context context, int i) {
        boolean z;
        if (c(context) >= i) {
            z = true;
        } else {
            z = false;
        }
        return z;
    }
}
