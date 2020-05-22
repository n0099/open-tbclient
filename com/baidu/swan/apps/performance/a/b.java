package com.baidu.swan.apps.performance.a;

import android.text.TextUtils;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;
/* loaded from: classes11.dex */
public class b implements d {
    private c crY;
    private long crZ;
    private LinkedHashMap<String, List<a>> crW = new LinkedHashMap<>();
    private HashMap<String, a> mCache = new HashMap<>();
    private SimpleDateFormat crX = new SimpleDateFormat("HH:mm:ss:SSS", Locale.getDefault());
    private boolean mIsWorking = false;

    /* JADX INFO: Access modifiers changed from: package-private */
    public b(c cVar) {
        this.crY = cVar;
    }

    @Override // com.baidu.swan.apps.performance.a.e
    public synchronized void start(long j) {
        if (this.crW.size() > 0) {
            this.crW.clear();
        }
        if (this.mCache.size() > 0) {
            this.mCache.clear();
        }
        this.mIsWorking = true;
        this.crZ = System.currentTimeMillis();
    }

    @Override // com.baidu.swan.apps.performance.a.e
    public synchronized void bh(long j) {
        this.mIsWorking = false;
    }

    @Override // com.baidu.swan.apps.performance.a.d
    public synchronized void iq(String str) {
        if (this.mIsWorking && !TextUtils.isEmpty(str)) {
            List<a> list = this.crW.get(str);
            if (list == null) {
                list = new ArrayList<>();
                this.crW.put(str, list);
            }
            a aVar = new a();
            aVar.setStart(System.currentTimeMillis());
            aVar.mG(str);
            list.add(aVar);
            this.mCache.put(Thread.currentThread().getName(), aVar);
        }
    }

    @Override // com.baidu.swan.apps.performance.a.d
    public synchronized void ir(String str) {
        String name;
        a aVar;
        if (this.mIsWorking && !TextUtils.isEmpty(str) && this.crW.get(str) != null && (aVar = this.mCache.get((name = Thread.currentThread().getName()))) != null) {
            aVar.setEnd(System.currentTimeMillis());
            this.mCache.remove(name);
        }
    }

    @Override // com.baidu.swan.apps.performance.a.d
    public synchronized String format() {
        String str;
        int i;
        int i2;
        long alG;
        int i3;
        if (this.crW == null || this.crW.size() <= 0) {
            str = "";
        } else {
            StringBuilder sb = new StringBuilder("api marker start time " + this.crX.format(Long.valueOf(this.crZ)) + "\n\n");
            long j = 0;
            int i4 = 0;
            int i5 = 0;
            for (Map.Entry<String, List<a>> entry : this.crW.entrySet()) {
                List<a> value = entry.getValue();
                if (value != null && value.size() > 0) {
                    long j2 = 0;
                    int i6 = 0;
                    StringBuilder sb2 = new StringBuilder();
                    for (a aVar : value) {
                        if (this.crY == null || this.crY.a(aVar)) {
                            sb2.append("----- start time ").append(this.crX.format(Long.valueOf(aVar.getStart()))).append("\n");
                            sb2.append("----- end time ").append(this.crX.format(Long.valueOf(aVar.getEnd()))).append("\n");
                            sb2.append("----- cost time ").append(aVar.alG()).append("ms\n");
                            sb2.append("----------------------------\n");
                            j += aVar.alG();
                            i2 = i6 + 1;
                            alG = j2 + aVar.alG();
                            i3 = i5 + 1;
                        } else {
                            i2 = i6;
                            alG = j2;
                            i3 = i5;
                        }
                        i6 = i2;
                        i5 = i3;
                        j2 = alG;
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
            com.baidu.swan.apps.console.c.i("ApiCalledMarker", str);
        }
        return str;
    }
}
