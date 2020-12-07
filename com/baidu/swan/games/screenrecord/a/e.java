package com.baidu.swan.games.screenrecord.a;

import android.util.Log;
import com.baidu.swan.apps.ap.p;
import com.baidu.swan.games.screenrecord.a.a;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
/* loaded from: classes25.dex */
public class e {
    private static final boolean DEBUG = com.baidu.swan.apps.b.DEBUG;
    private ArrayList<a> eem;
    private int een;
    private String mSavePath;
    private String mVideoPath;

    public e(ArrayList<b> arrayList, String str, String str2) {
        if (DEBUG) {
            Log.d("ClipVideoTask", "videoPath=" + str + "clipList=" + arrayList);
        }
        this.eem = v(arrayList);
        this.mVideoPath = str;
        this.mSavePath = str2;
        this.een = this.eem.size();
    }

    public void a(final c cVar) {
        if (cVar != null) {
            p.postOnSerial(new Runnable() { // from class: com.baidu.swan.games.screenrecord.a.e.1
                @Override // java.lang.Runnable
                public void run() {
                    ArrayList<long[]> aZq = e.this.aZq();
                    d dVar = new d();
                    dVar.videoPath = e.this.mVideoPath;
                    dVar.eel = aZq;
                    dVar.clipPath = e.this.mSavePath;
                    com.baidu.swan.games.m.a.aYB().a(dVar, cVar);
                }
            }, "clipVideo");
        }
    }

    private ArrayList<a> v(ArrayList<b> arrayList) {
        a aZp;
        ArrayList<a> arrayList2 = new ArrayList<>();
        if (arrayList == null || arrayList.size() == 0) {
            return arrayList2;
        }
        Iterator<b> it = arrayList.iterator();
        while (it.hasNext()) {
            b next = it.next();
            if (next != null && (aZp = next.aZp()) != null) {
                arrayList2.add(aZp);
            }
        }
        return arrayList2;
    }

    public ArrayList<long[]> aZq() {
        ArrayList<long[]> arrayList = new ArrayList<>();
        if (this.een == 0) {
            return arrayList;
        }
        if (DEBUG) {
            Log.d("ClipVideoTask", "mergeRange mRangeList = " + this.eem);
        }
        Collections.sort(this.eem, new a.C0553a());
        a aVar = this.eem.get(0);
        for (int i = 1; i < this.een; i++) {
            a aVar2 = this.eem.get(i);
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
