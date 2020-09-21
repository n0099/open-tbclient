package com.baidu.swan.games.screenrecord.a;

import android.util.Log;
import com.baidu.swan.apps.ap.p;
import com.baidu.swan.games.screenrecord.a.a;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
/* loaded from: classes3.dex */
public class e {
    private static final boolean DEBUG = com.baidu.swan.apps.b.DEBUG;
    private ArrayList<a> dyF;
    private int dyG;
    private String mSavePath;
    private String mVideoPath;

    public e(ArrayList<b> arrayList, String str, String str2) {
        if (DEBUG) {
            Log.d("ClipVideoTask", "videoPath=" + str + "clipList=" + arrayList);
        }
        this.dyF = v(arrayList);
        this.mVideoPath = str;
        this.mSavePath = str2;
        this.dyG = this.dyF.size();
    }

    public void a(final c cVar) {
        if (cVar != null) {
            p.postOnSerial(new Runnable() { // from class: com.baidu.swan.games.screenrecord.a.e.1
                @Override // java.lang.Runnable
                public void run() {
                    ArrayList<long[]> aPQ = e.this.aPQ();
                    d dVar = new d();
                    dVar.videoPath = e.this.mVideoPath;
                    dVar.dyE = aPQ;
                    dVar.clipPath = e.this.mSavePath;
                    com.baidu.swan.games.m.a.aPb().a(dVar, cVar);
                }
            }, "clipVideo");
        }
    }

    private ArrayList<a> v(ArrayList<b> arrayList) {
        a aPP;
        ArrayList<a> arrayList2 = new ArrayList<>();
        if (arrayList == null || arrayList.size() == 0) {
            return arrayList2;
        }
        Iterator<b> it = arrayList.iterator();
        while (it.hasNext()) {
            b next = it.next();
            if (next != null && (aPP = next.aPP()) != null) {
                arrayList2.add(aPP);
            }
        }
        return arrayList2;
    }

    public ArrayList<long[]> aPQ() {
        ArrayList<long[]> arrayList = new ArrayList<>();
        if (this.dyG == 0) {
            return arrayList;
        }
        if (DEBUG) {
            Log.d("ClipVideoTask", "mergeRange mRangeList = " + this.dyF);
        }
        Collections.sort(this.dyF, new a.C0500a());
        a aVar = this.dyF.get(0);
        for (int i = 1; i < this.dyG; i++) {
            a aVar2 = this.dyF.get(i);
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
