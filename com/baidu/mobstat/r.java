package com.baidu.mobstat;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
/* loaded from: classes6.dex */
public enum r {
    AP_LIST(0) { // from class: com.baidu.mobstat.r.1
        @Override // com.baidu.mobstat.r
        public q a() {
            return new u();
        }
    },
    APP_LIST(1) { // from class: com.baidu.mobstat.r.2
        @Override // com.baidu.mobstat.r
        public q a() {
            return new x();
        }
    },
    APP_TRACE(2) { // from class: com.baidu.mobstat.r.3
        @Override // com.baidu.mobstat.r
        public q a() {
            return new y();
        }
    },
    APP_CHANGE(3) { // from class: com.baidu.mobstat.r.4
        @Override // com.baidu.mobstat.r
        public q a() {
            return new w();
        }
    },
    APP_APK(4) { // from class: com.baidu.mobstat.r.5
        @Override // com.baidu.mobstat.r
        public q a() {
            return new v();
        }
    };
    
    private int f;

    public abstract q a();

    r(int i) {
        this.f = i;
    }

    @Override // java.lang.Enum
    public String toString() {
        return String.valueOf(this.f);
    }

    /* JADX DEBUG: Don't trust debug lines info. Repeating lines: [116=4, 117=4] */
    public synchronized ArrayList<p> a(int i, int i2) {
        ArrayList<p> arrayList;
        arrayList = new ArrayList<>();
        q qVar = null;
        try {
            qVar = a();
            if (qVar.a()) {
                arrayList = qVar.a(i, i2);
                if (qVar != null) {
                    qVar.close();
                }
            } else if (qVar != null) {
                qVar.close();
            }
        } catch (Exception e) {
            bi.c().b(e);
            if (qVar != null) {
                qVar.close();
            }
        }
        return arrayList;
    }

    /* JADX DEBUG: Don't trust debug lines info. Repeating lines: [149=4, 150=4] */
    public synchronized long a(long j, String str) {
        long j2;
        j2 = -1;
        q qVar = null;
        try {
            qVar = a();
            if (qVar.a()) {
                j2 = qVar.a(String.valueOf(j), str);
                if (qVar != null) {
                    qVar.close();
                }
            } else if (qVar != null) {
                qVar.close();
            }
        } catch (Exception e) {
            bi.c().b(e);
            if (qVar != null) {
                qVar.close();
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
                    q qVar = null;
                    try {
                        qVar = a();
                    } catch (Exception e) {
                        i = i2;
                        bi.c().b(e);
                        if (qVar != null) {
                            qVar.close();
                        }
                    }
                    if (qVar.a()) {
                        int size = arrayList.size();
                        int i3 = 0;
                        while (i3 < size) {
                            if (qVar.b(arrayList.get(i3).longValue())) {
                                i3++;
                                i2++;
                            } else if (qVar != null) {
                                qVar.close();
                            }
                        }
                        if (qVar != null) {
                            qVar.close();
                            i = i2;
                        } else {
                            i = i2;
                        }
                        i2 = i;
                    } else if (qVar != null) {
                        qVar.close();
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
        ArrayList<p> arrayList3 = new ArrayList<>();
        a(arrayList, arrayList2, arrayList3, i, 500);
        if (arrayList3.size() != 0 && arrayList.size() == 0 && arrayList2.size() == 0) {
            p pVar = arrayList3.get(0);
            long a = pVar.a();
            String b = pVar.b();
            arrayList2.add(Long.valueOf(a));
            arrayList.add(b);
        }
        int a2 = a(arrayList2);
        if (a2 != arrayList.size()) {
            arrayList = arrayList.subList(0, a2);
        }
        return arrayList;
    }

    private int a(List<String> list, ArrayList<Long> arrayList, ArrayList<p> arrayList2, int i, int i2) {
        int i3 = 0;
        int c = c();
        int i4 = 0;
        int i5 = i2;
        while (c > 0) {
            int i6 = c < i5 ? c : i5;
            ArrayList<p> a = a(i6, i4);
            if (i4 == 0 && a.size() != 0) {
                arrayList2.add(a.get(0));
            }
            Iterator<p> it = a.iterator();
            while (it.hasNext()) {
                p next = it.next();
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
        q qVar = null;
        try {
            try {
                qVar = a();
            } catch (Exception e) {
                bi.c().b(e);
                if (qVar != null) {
                    qVar.close();
                }
            }
            if (qVar.a()) {
                int b = qVar.b();
            }
            if (qVar != null) {
                qVar.close();
            }
            return 0;
        } finally {
            if (qVar != null) {
                qVar.close();
            }
        }
    }
}
