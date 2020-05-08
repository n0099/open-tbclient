package com.baidu.swan.games.screenrecord.a;

import android.util.Log;
import com.baidu.swan.apps.as.m;
import com.baidu.swan.games.screenrecord.a.a;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
/* loaded from: classes11.dex */
public class e {
    private static final boolean DEBUG = com.baidu.swan.apps.b.DEBUG;
    private ArrayList<a> cRd;
    private int cRe;
    private String mSavePath;
    private String mVideoPath;

    public e(ArrayList<b> arrayList, String str, String str2) {
        if (DEBUG) {
            Log.d("ClipVideoTask", "videoPath=" + str + "clipList=" + arrayList);
        }
        this.cRd = q(arrayList);
        this.mVideoPath = str;
        this.mSavePath = str2;
        this.cRe = this.cRd.size();
    }

    public void a(final c cVar) {
        if (cVar != null) {
            m.postOnSerial(new Runnable() { // from class: com.baidu.swan.games.screenrecord.a.e.1
                @Override // java.lang.Runnable
                public void run() {
                    ArrayList<long[]> axK = e.this.axK();
                    d dVar = new d();
                    dVar.videoPath = e.this.mVideoPath;
                    dVar.cRc = axK;
                    dVar.clipPath = e.this.mSavePath;
                    com.baidu.swan.games.l.a.awZ().a(dVar, cVar);
                }
            }, "clipVideo");
        }
    }

    private ArrayList<a> q(ArrayList<b> arrayList) {
        a axJ;
        ArrayList<a> arrayList2 = new ArrayList<>();
        if (arrayList == null || arrayList.size() == 0) {
            return arrayList2;
        }
        Iterator<b> it = arrayList.iterator();
        while (it.hasNext()) {
            b next = it.next();
            if (next != null && (axJ = next.axJ()) != null) {
                arrayList2.add(axJ);
            }
        }
        return arrayList2;
    }

    public ArrayList<long[]> axK() {
        ArrayList<long[]> arrayList = new ArrayList<>();
        if (this.cRe == 0) {
            return arrayList;
        }
        if (DEBUG) {
            Log.d("ClipVideoTask", "mergeRange mRangeList = " + this.cRd);
        }
        Collections.sort(this.cRd, new a.C0398a());
        a aVar = this.cRd.get(0);
        for (int i = 1; i < this.cRe; i++) {
            a aVar2 = this.cRd.get(i);
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
