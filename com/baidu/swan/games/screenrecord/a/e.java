package com.baidu.swan.games.screenrecord.a;

import android.util.Log;
import com.baidu.swan.apps.an.j;
import com.baidu.swan.games.f.g;
import com.baidu.swan.games.screenrecord.a.a;
import java.io.File;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
/* loaded from: classes2.dex */
public class e {
    private static final boolean DEBUG = com.baidu.swan.apps.b.DEBUG;
    private static final String bDT = "bdfile://tmp" + File.separator + "videoClip_%s.mp4";
    private String aFy;
    private ArrayList<a> bDU;
    private int bDV;

    public e(ArrayList<b> arrayList, String str) {
        if (DEBUG) {
            Log.d("ClipVideoTask", "videoPath=" + str + "clipList=" + arrayList);
        }
        this.bDU = m(arrayList);
        this.aFy = str;
        this.bDV = this.bDU.size();
    }

    public void a(final c cVar) {
        if (cVar != null) {
            j.c(new Runnable() { // from class: com.baidu.swan.games.screenrecord.a.e.1
                @Override // java.lang.Runnable
                public void run() {
                    ArrayList<long[]> XU = e.this.XU();
                    d dVar = new d();
                    dVar.videoPath = e.this.aFy;
                    dVar.bDR = XU;
                    dVar.bDS = g.jW(String.format(e.bDT, Long.valueOf(System.currentTimeMillis())));
                    com.baidu.swan.games.j.a.Xr().a(dVar, cVar);
                }
            }, "clipVideo");
        }
    }

    private ArrayList<a> m(ArrayList<b> arrayList) {
        a XT;
        ArrayList<a> arrayList2 = new ArrayList<>();
        if (arrayList == null || arrayList.size() == 0) {
            return arrayList2;
        }
        Iterator<b> it = arrayList.iterator();
        while (it.hasNext()) {
            b next = it.next();
            if (next != null && (XT = next.XT()) != null) {
                arrayList2.add(XT);
            }
        }
        return arrayList2;
    }

    public ArrayList<long[]> XU() {
        ArrayList<long[]> arrayList = new ArrayList<>();
        if (this.bDV == 0) {
            return arrayList;
        }
        if (DEBUG) {
            Log.d("ClipVideoTask", "mergeRange mRangeList = " + this.bDU);
        }
        Collections.sort(this.bDU, new a.C0258a());
        a aVar = this.bDU.get(0);
        for (int i = 1; i < this.bDV; i++) {
            a aVar2 = this.bDU.get(i);
            if (!aVar.b(aVar2)) {
                arrayList.add(a.a(aVar));
                aVar = aVar2;
            }
        }
        arrayList.add(a.a(aVar));
        if (DEBUG) {
            Log.d("ClipVideoTask", "mergeRange mergeList = " + arrayList);
        }
        return arrayList;
    }
}
