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
    private static final String bjU = "bdfile://tmp" + File.separator + "videoClip_%s.mp4";
    private String ald;
    private ArrayList<a> bjV;
    private int bjW;

    public e(ArrayList<b> arrayList, String str) {
        if (DEBUG) {
            Log.d("ClipVideoTask", "videoPath=" + str + "clipList=" + arrayList);
        }
        this.bjV = j(arrayList);
        this.ald = str;
        this.bjW = this.bjV.size();
    }

    public void a(final c cVar) {
        if (cVar != null) {
            j.c(new Runnable() { // from class: com.baidu.swan.games.screenrecord.a.e.1
                @Override // java.lang.Runnable
                public void run() {
                    ArrayList<long[]> Sg = e.this.Sg();
                    d dVar = new d();
                    dVar.videoPath = e.this.ald;
                    dVar.bjS = Sg;
                    dVar.bjT = g.jj(String.format(e.bjU, Long.valueOf(System.currentTimeMillis())));
                    com.baidu.swan.games.j.a.RD().a(dVar, cVar);
                }
            }, "clipVideo");
        }
    }

    private ArrayList<a> j(ArrayList<b> arrayList) {
        a Sf;
        ArrayList<a> arrayList2 = new ArrayList<>();
        if (arrayList == null || arrayList.size() == 0) {
            return arrayList2;
        }
        Iterator<b> it = arrayList.iterator();
        while (it.hasNext()) {
            b next = it.next();
            if (next != null && (Sf = next.Sf()) != null) {
                arrayList2.add(Sf);
            }
        }
        return arrayList2;
    }

    public ArrayList<long[]> Sg() {
        ArrayList<long[]> arrayList = new ArrayList<>();
        if (this.bjW == 0) {
            return arrayList;
        }
        if (DEBUG) {
            Log.d("ClipVideoTask", "mergeRange mRangeList = " + this.bjV);
        }
        Collections.sort(this.bjV, new a.C0215a());
        a aVar = this.bjV.get(0);
        for (int i = 1; i < this.bjW; i++) {
            a aVar2 = this.bjV.get(i);
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
