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
    private static final String bDc = "bdfile://tmp" + File.separator + "videoClip_%s.mp4";
    private String aFg;
    private ArrayList<a> bDd;
    private int bDe;

    public e(ArrayList<b> arrayList, String str) {
        if (DEBUG) {
            Log.d("ClipVideoTask", "videoPath=" + str + "clipList=" + arrayList);
        }
        this.bDd = m(arrayList);
        this.aFg = str;
        this.bDe = this.bDd.size();
    }

    public void a(final c cVar) {
        if (cVar != null) {
            j.c(new Runnable() { // from class: com.baidu.swan.games.screenrecord.a.e.1
                @Override // java.lang.Runnable
                public void run() {
                    ArrayList<long[]> XS = e.this.XS();
                    d dVar = new d();
                    dVar.videoPath = e.this.aFg;
                    dVar.bDa = XS;
                    dVar.bDb = g.jW(String.format(e.bDc, Long.valueOf(System.currentTimeMillis())));
                    com.baidu.swan.games.j.a.Xp().a(dVar, cVar);
                }
            }, "clipVideo");
        }
    }

    private ArrayList<a> m(ArrayList<b> arrayList) {
        a XR;
        ArrayList<a> arrayList2 = new ArrayList<>();
        if (arrayList == null || arrayList.size() == 0) {
            return arrayList2;
        }
        Iterator<b> it = arrayList.iterator();
        while (it.hasNext()) {
            b next = it.next();
            if (next != null && (XR = next.XR()) != null) {
                arrayList2.add(XR);
            }
        }
        return arrayList2;
    }

    public ArrayList<long[]> XS() {
        ArrayList<long[]> arrayList = new ArrayList<>();
        if (this.bDe == 0) {
            return arrayList;
        }
        if (DEBUG) {
            Log.d("ClipVideoTask", "mergeRange mRangeList = " + this.bDd);
        }
        Collections.sort(this.bDd, new a.C0258a());
        a aVar = this.bDd.get(0);
        for (int i = 1; i < this.bDe; i++) {
            a aVar2 = this.bDd.get(i);
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
