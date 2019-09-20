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
    private static final String blf = "bdfile://tmp" + File.separator + "videoClip_%s.mp4";
    private String amf;
    private ArrayList<a> blg;
    private int blh;

    public e(ArrayList<b> arrayList, String str) {
        if (DEBUG) {
            Log.d("ClipVideoTask", "videoPath=" + str + "clipList=" + arrayList);
        }
        this.blg = j(arrayList);
        this.amf = str;
        this.blh = this.blg.size();
    }

    public void a(final c cVar) {
        if (cVar != null) {
            j.c(new Runnable() { // from class: com.baidu.swan.games.screenrecord.a.e.1
                @Override // java.lang.Runnable
                public void run() {
                    ArrayList<long[]> Td = e.this.Td();
                    d dVar = new d();
                    dVar.videoPath = e.this.amf;
                    dVar.bld = Td;
                    dVar.ble = g.jt(String.format(e.blf, Long.valueOf(System.currentTimeMillis())));
                    com.baidu.swan.games.j.a.SA().a(dVar, cVar);
                }
            }, "clipVideo");
        }
    }

    private ArrayList<a> j(ArrayList<b> arrayList) {
        a Tc;
        ArrayList<a> arrayList2 = new ArrayList<>();
        if (arrayList == null || arrayList.size() == 0) {
            return arrayList2;
        }
        Iterator<b> it = arrayList.iterator();
        while (it.hasNext()) {
            b next = it.next();
            if (next != null && (Tc = next.Tc()) != null) {
                arrayList2.add(Tc);
            }
        }
        return arrayList2;
    }

    public ArrayList<long[]> Td() {
        ArrayList<long[]> arrayList = new ArrayList<>();
        if (this.blh == 0) {
            return arrayList;
        }
        if (DEBUG) {
            Log.d("ClipVideoTask", "mergeRange mRangeList = " + this.blg);
        }
        Collections.sort(this.blg, new a.C0226a());
        a aVar = this.blg.get(0);
        for (int i = 1; i < this.blh; i++) {
            a aVar2 = this.blg.get(i);
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
