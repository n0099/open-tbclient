package com.baidu.swan.games.screenrecord.a;

import android.util.Log;
import com.baidu.swan.apps.ap.p;
import com.baidu.swan.games.screenrecord.a.a;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
/* loaded from: classes8.dex */
public class e {
    private static final boolean DEBUG = com.baidu.swan.apps.b.DEBUG;
    private ArrayList<a> dwA;
    private int dwB;
    private String mSavePath;
    private String mVideoPath;

    public e(ArrayList<b> arrayList, String str, String str2) {
        if (DEBUG) {
            Log.d("ClipVideoTask", "videoPath=" + str + "clipList=" + arrayList);
        }
        this.dwA = v(arrayList);
        this.mVideoPath = str;
        this.mSavePath = str2;
        this.dwB = this.dwA.size();
    }

    public void a(final c cVar) {
        if (cVar != null) {
            p.postOnSerial(new Runnable() { // from class: com.baidu.swan.games.screenrecord.a.e.1
                @Override // java.lang.Runnable
                public void run() {
                    ArrayList<long[]> aPf = e.this.aPf();
                    d dVar = new d();
                    dVar.videoPath = e.this.mVideoPath;
                    dVar.dwz = aPf;
                    dVar.clipPath = e.this.mSavePath;
                    com.baidu.swan.games.m.a.aOq().a(dVar, cVar);
                }
            }, "clipVideo");
        }
    }

    private ArrayList<a> v(ArrayList<b> arrayList) {
        a aPe;
        ArrayList<a> arrayList2 = new ArrayList<>();
        if (arrayList == null || arrayList.size() == 0) {
            return arrayList2;
        }
        Iterator<b> it = arrayList.iterator();
        while (it.hasNext()) {
            b next = it.next();
            if (next != null && (aPe = next.aPe()) != null) {
                arrayList2.add(aPe);
            }
        }
        return arrayList2;
    }

    public ArrayList<long[]> aPf() {
        ArrayList<long[]> arrayList = new ArrayList<>();
        if (this.dwB == 0) {
            return arrayList;
        }
        if (DEBUG) {
            Log.d("ClipVideoTask", "mergeRange mRangeList = " + this.dwA);
        }
        Collections.sort(this.dwA, new a.C0505a());
        a aVar = this.dwA.get(0);
        for (int i = 1; i < this.dwB; i++) {
            a aVar2 = this.dwA.get(i);
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
