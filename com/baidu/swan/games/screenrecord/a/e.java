package com.baidu.swan.games.screenrecord.a;

import android.util.Log;
import com.baidu.swan.apps.as.m;
import com.baidu.swan.games.screenrecord.a.a;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
/* loaded from: classes9.dex */
public class e {
    private static final boolean DEBUG = com.baidu.swan.apps.b.DEBUG;
    private ArrayList<a> cnB;
    private int cnC;
    private String mSavePath;
    private String mVideoPath;

    public e(ArrayList<b> arrayList, String str, String str2) {
        if (DEBUG) {
            Log.d("ClipVideoTask", "videoPath=" + str + "clipList=" + arrayList);
        }
        this.cnB = o(arrayList);
        this.mVideoPath = str;
        this.mSavePath = str2;
        this.cnC = this.cnB.size();
    }

    public void a(final c cVar) {
        if (cVar != null) {
            m.postOnSerial(new Runnable() { // from class: com.baidu.swan.games.screenrecord.a.e.1
                @Override // java.lang.Runnable
                public void run() {
                    ArrayList<long[]> amM = e.this.amM();
                    d dVar = new d();
                    dVar.videoPath = e.this.mVideoPath;
                    dVar.cnA = amM;
                    dVar.clipPath = e.this.mSavePath;
                    com.baidu.swan.games.l.a.amb().a(dVar, cVar);
                }
            }, "clipVideo");
        }
    }

    private ArrayList<a> o(ArrayList<b> arrayList) {
        a amL;
        ArrayList<a> arrayList2 = new ArrayList<>();
        if (arrayList == null || arrayList.size() == 0) {
            return arrayList2;
        }
        Iterator<b> it = arrayList.iterator();
        while (it.hasNext()) {
            b next = it.next();
            if (next != null && (amL = next.amL()) != null) {
                arrayList2.add(amL);
            }
        }
        return arrayList2;
    }

    public ArrayList<long[]> amM() {
        ArrayList<long[]> arrayList = new ArrayList<>();
        if (this.cnC == 0) {
            return arrayList;
        }
        if (DEBUG) {
            Log.d("ClipVideoTask", "mergeRange mRangeList = " + this.cnB);
        }
        Collections.sort(this.cnB, new a.C0335a());
        a aVar = this.cnB.get(0);
        for (int i = 1; i < this.cnC; i++) {
            a aVar2 = this.cnB.get(i);
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
