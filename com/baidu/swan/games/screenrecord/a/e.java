package com.baidu.swan.games.screenrecord.a;

import android.util.Log;
import com.baidu.swan.apps.ap.p;
import com.baidu.swan.games.screenrecord.a.a;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
/* loaded from: classes10.dex */
public class e {
    private static final boolean DEBUG = com.baidu.swan.apps.b.DEBUG;
    private ArrayList<a> dYV;
    private int dYW;
    private String mSavePath;
    private String mVideoPath;

    public e(ArrayList<b> arrayList, String str, String str2) {
        if (DEBUG) {
            Log.d("ClipVideoTask", "videoPath=" + str + "clipList=" + arrayList);
        }
        this.dYV = v(arrayList);
        this.mVideoPath = str;
        this.mSavePath = str2;
        this.dYW = this.dYV.size();
    }

    public void a(final c cVar) {
        if (cVar != null) {
            p.postOnSerial(new Runnable() { // from class: com.baidu.swan.games.screenrecord.a.e.1
                @Override // java.lang.Runnable
                public void run() {
                    ArrayList<long[]> aWT = e.this.aWT();
                    d dVar = new d();
                    dVar.videoPath = e.this.mVideoPath;
                    dVar.dYU = aWT;
                    dVar.clipPath = e.this.mSavePath;
                    com.baidu.swan.games.m.a.aWe().a(dVar, cVar);
                }
            }, "clipVideo");
        }
    }

    private ArrayList<a> v(ArrayList<b> arrayList) {
        a aWS;
        ArrayList<a> arrayList2 = new ArrayList<>();
        if (arrayList == null || arrayList.size() == 0) {
            return arrayList2;
        }
        Iterator<b> it = arrayList.iterator();
        while (it.hasNext()) {
            b next = it.next();
            if (next != null && (aWS = next.aWS()) != null) {
                arrayList2.add(aWS);
            }
        }
        return arrayList2;
    }

    public ArrayList<long[]> aWT() {
        ArrayList<long[]> arrayList = new ArrayList<>();
        if (this.dYW == 0) {
            return arrayList;
        }
        if (DEBUG) {
            Log.d("ClipVideoTask", "mergeRange mRangeList = " + this.dYV);
        }
        Collections.sort(this.dYV, new a.C0543a());
        a aVar = this.dYV.get(0);
        for (int i = 1; i < this.dYW; i++) {
            a aVar2 = this.dYV.get(i);
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
