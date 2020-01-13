package com.baidu.swan.games.screenrecord.a;

import android.util.Log;
import com.baidu.swan.apps.as.m;
import com.baidu.swan.games.screenrecord.a.a;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
/* loaded from: classes10.dex */
public class e {
    private static final boolean DEBUG = com.baidu.swan.apps.b.DEBUG;
    private ArrayList<a> cnO;
    private int cnP;
    private String mSavePath;
    private String mVideoPath;

    public e(ArrayList<b> arrayList, String str, String str2) {
        if (DEBUG) {
            Log.d("ClipVideoTask", "videoPath=" + str + "clipList=" + arrayList);
        }
        this.cnO = o(arrayList);
        this.mVideoPath = str;
        this.mSavePath = str2;
        this.cnP = this.cnO.size();
    }

    public void a(final c cVar) {
        if (cVar != null) {
            m.postOnSerial(new Runnable() { // from class: com.baidu.swan.games.screenrecord.a.e.1
                @Override // java.lang.Runnable
                public void run() {
                    ArrayList<long[]> anf = e.this.anf();
                    d dVar = new d();
                    dVar.videoPath = e.this.mVideoPath;
                    dVar.cnN = anf;
                    dVar.clipPath = e.this.mSavePath;
                    com.baidu.swan.games.l.a.amu().a(dVar, cVar);
                }
            }, "clipVideo");
        }
    }

    private ArrayList<a> o(ArrayList<b> arrayList) {
        a ane;
        ArrayList<a> arrayList2 = new ArrayList<>();
        if (arrayList == null || arrayList.size() == 0) {
            return arrayList2;
        }
        Iterator<b> it = arrayList.iterator();
        while (it.hasNext()) {
            b next = it.next();
            if (next != null && (ane = next.ane()) != null) {
                arrayList2.add(ane);
            }
        }
        return arrayList2;
    }

    public ArrayList<long[]> anf() {
        ArrayList<long[]> arrayList = new ArrayList<>();
        if (this.cnP == 0) {
            return arrayList;
        }
        if (DEBUG) {
            Log.d("ClipVideoTask", "mergeRange mRangeList = " + this.cnO);
        }
        Collections.sort(this.cnO, new a.C0337a());
        a aVar = this.cnO.get(0);
        for (int i = 1; i < this.cnP; i++) {
            a aVar2 = this.cnO.get(i);
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
