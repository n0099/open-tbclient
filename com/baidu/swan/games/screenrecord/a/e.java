package com.baidu.swan.games.screenrecord.a;

import android.util.Log;
import com.baidu.swan.apps.aq.n;
import com.baidu.swan.games.screenrecord.a.a;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
/* loaded from: classes11.dex */
public class e {
    private static final boolean DEBUG = com.baidu.swan.apps.b.DEBUG;
    private ArrayList<a> dbZ;
    private int dca;
    private String mSavePath;
    private String mVideoPath;

    public e(ArrayList<b> arrayList, String str, String str2) {
        if (DEBUG) {
            Log.d("ClipVideoTask", "videoPath=" + str + "clipList=" + arrayList);
        }
        this.dbZ = q(arrayList);
        this.mVideoPath = str;
        this.mSavePath = str2;
        this.dca = this.dbZ.size();
    }

    public void a(final c cVar) {
        if (cVar != null) {
            n.postOnSerial(new Runnable() { // from class: com.baidu.swan.games.screenrecord.a.e.1
                @Override // java.lang.Runnable
                public void run() {
                    ArrayList<long[]> aBB = e.this.aBB();
                    d dVar = new d();
                    dVar.videoPath = e.this.mVideoPath;
                    dVar.dbY = aBB;
                    dVar.clipPath = e.this.mSavePath;
                    com.baidu.swan.games.m.a.aAO().a(dVar, cVar);
                }
            }, "clipVideo");
        }
    }

    private ArrayList<a> q(ArrayList<b> arrayList) {
        a aBA;
        ArrayList<a> arrayList2 = new ArrayList<>();
        if (arrayList == null || arrayList.size() == 0) {
            return arrayList2;
        }
        Iterator<b> it = arrayList.iterator();
        while (it.hasNext()) {
            b next = it.next();
            if (next != null && (aBA = next.aBA()) != null) {
                arrayList2.add(aBA);
            }
        }
        return arrayList2;
    }

    public ArrayList<long[]> aBB() {
        ArrayList<long[]> arrayList = new ArrayList<>();
        if (this.dca == 0) {
            return arrayList;
        }
        if (DEBUG) {
            Log.d("ClipVideoTask", "mergeRange mRangeList = " + this.dbZ);
        }
        Collections.sort(this.dbZ, new a.C0438a());
        a aVar = this.dbZ.get(0);
        for (int i = 1; i < this.dca; i++) {
            a aVar2 = this.dbZ.get(i);
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
