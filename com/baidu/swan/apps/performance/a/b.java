package com.baidu.swan.apps.performance.a;

import android.text.TextUtils;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;
/* loaded from: classes7.dex */
public class b implements d {
    private c czb;
    private long czc;
    private LinkedHashMap<String, List<a>> cyZ = new LinkedHashMap<>();
    private HashMap<String, a> mCache = new HashMap<>();
    private SimpleDateFormat cza = new SimpleDateFormat("HH:mm:ss:SSS", Locale.getDefault());
    private boolean mIsWorking = false;

    /* JADX INFO: Access modifiers changed from: package-private */
    public b(c cVar) {
        this.czb = cVar;
    }

    @Override // com.baidu.swan.apps.performance.a.e
    public synchronized void start(long j) {
        if (this.cyZ.size() > 0) {
            this.cyZ.clear();
        }
        if (this.mCache.size() > 0) {
            this.mCache.clear();
        }
        this.mIsWorking = true;
        this.czc = System.currentTimeMillis();
    }

    @Override // com.baidu.swan.apps.performance.a.e
    public synchronized void bl(long j) {
        this.mIsWorking = false;
    }

    @Override // com.baidu.swan.apps.performance.a.d
    public synchronized void iI(String str) {
        if (this.mIsWorking && !TextUtils.isEmpty(str)) {
            List<a> list = this.cyZ.get(str);
            if (list == null) {
                list = new ArrayList<>();
                this.cyZ.put(str, list);
            }
            a aVar = new a();
            aVar.setStart(System.currentTimeMillis());
            aVar.nq(str);
            list.add(aVar);
            this.mCache.put(Thread.currentThread().getName(), aVar);
        }
    }

    @Override // com.baidu.swan.apps.performance.a.d
    public synchronized void iJ(String str) {
        String name;
        a aVar;
        if (this.mIsWorking && !TextUtils.isEmpty(str) && this.cyZ.get(str) != null && (aVar = this.mCache.get((name = Thread.currentThread().getName()))) != null) {
            aVar.setEnd(System.currentTimeMillis());
            this.mCache.remove(name);
        }
    }

    @Override // com.baidu.swan.apps.performance.a.d
    public synchronized String format() {
        String str;
        int i;
        int i2;
        long aog;
        int i3;
        if (this.cyZ == null || this.cyZ.size() <= 0) {
            str = "";
        } else {
            StringBuilder sb = new StringBuilder("api marker start time " + this.cza.format(Long.valueOf(this.czc)) + "\n\n");
            long j = 0;
            int i4 = 0;
            int i5 = 0;
            for (Map.Entry<String, List<a>> entry : this.cyZ.entrySet()) {
                List<a> value = entry.getValue();
                if (value != null && value.size() > 0) {
                    long j2 = 0;
                    int i6 = 0;
                    StringBuilder sb2 = new StringBuilder();
                    for (a aVar : value) {
                        if (this.czb == null || this.czb.a(aVar)) {
                            sb2.append("----- start time ").append(this.cza.format(Long.valueOf(aVar.getStart()))).append("\n");
                            sb2.append("----- end time ").append(this.cza.format(Long.valueOf(aVar.getEnd()))).append("\n");
                            sb2.append("----- cost time ").append(aVar.aog()).append("ms\n");
                            sb2.append("----------------------------\n");
                            j += aVar.aog();
                            i2 = i6 + 1;
                            aog = j2 + aVar.aog();
                            i3 = i5 + 1;
                        } else {
                            i2 = i6;
                            aog = j2;
                            i3 = i5;
                        }
                        i6 = i2;
                        i5 = i3;
                        j2 = aog;
                    }
                    if (i6 > 0) {
                        sb2.append("----------- ").append(i6).append(" times cost ").append(j2).append("ms\n\n");
                        sb.append("=========== call ").append(entry.getKey()).append(" ").append(i6).append(" times\n");
                        sb.append((CharSequence) sb2);
                        i = i4 + 1;
                    } else {
                        i = i4;
                    }
                    i4 = i;
                }
            }
            sb.append("########## call ").append(i4).append(" api, total ").append(i5).append(" times, sum cost ").append(j).append("ms\n");
            str = sb.toString();
            com.baidu.swan.apps.console.c.d("ApiCalledMarker", str);
        }
        return str;
    }
}
