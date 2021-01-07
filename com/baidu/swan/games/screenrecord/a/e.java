package com.baidu.swan.games.screenrecord.a;

import android.util.Log;
import com.baidu.swan.apps.ao.p;
import com.baidu.swan.games.screenrecord.a.a;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
/* loaded from: classes9.dex */
public class e {
    private static final boolean DEBUG = com.baidu.swan.apps.b.DEBUG;
    private ArrayList<a> enk;
    private int enl;
    private String mSavePath;
    private String mVideoPath;

    public e(ArrayList<b> arrayList, String str, String str2) {
        if (DEBUG) {
            Log.d("ClipVideoTask", "videoPath=" + str + "clipList=" + arrayList);
        }
        this.enk = v(arrayList);
        this.mVideoPath = str;
        this.mSavePath = str2;
        this.enl = this.enk.size();
    }

    public void a(final c cVar) {
        if (cVar != null) {
            p.postOnSerial(new Runnable() { // from class: com.baidu.swan.games.screenrecord.a.e.1
                @Override // java.lang.Runnable
                public void run() {
                    ArrayList<long[]> bbL = e.this.bbL();
                    d dVar = new d();
                    dVar.videoPath = e.this.mVideoPath;
                    dVar.enj = bbL;
                    dVar.clipPath = e.this.mSavePath;
                    com.baidu.swan.games.m.a.baW().a(dVar, cVar);
                }
            }, "clipVideo");
        }
    }

    private ArrayList<a> v(ArrayList<b> arrayList) {
        a bbK;
        ArrayList<a> arrayList2 = new ArrayList<>();
        if (arrayList == null || arrayList.size() == 0) {
            return arrayList2;
        }
        Iterator<b> it = arrayList.iterator();
        while (it.hasNext()) {
            b next = it.next();
            if (next != null && (bbK = next.bbK()) != null) {
                arrayList2.add(bbK);
            }
        }
        return arrayList2;
    }

    public ArrayList<long[]> bbL() {
        ArrayList<long[]> arrayList = new ArrayList<>();
        if (this.enl == 0) {
            return arrayList;
        }
        if (DEBUG) {
            Log.d("ClipVideoTask", "mergeRange mRangeList = " + this.enk);
        }
        Collections.sort(this.enk, new a.C0546a());
        a aVar = this.enk.get(0);
        for (int i = 1; i < this.enl; i++) {
            a aVar2 = this.enk.get(i);
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
