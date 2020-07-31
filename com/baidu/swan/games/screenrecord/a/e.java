package com.baidu.swan.games.screenrecord.a;

import android.util.Log;
import com.baidu.swan.apps.aq.p;
import com.baidu.swan.games.screenrecord.a.a;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
/* loaded from: classes7.dex */
public class e {
    private static final boolean DEBUG = com.baidu.swan.apps.b.DEBUG;
    private ArrayList<a> dmv;
    private int dmw;
    private String mSavePath;
    private String mVideoPath;

    public e(ArrayList<b> arrayList, String str, String str2) {
        if (DEBUG) {
            Log.d("ClipVideoTask", "videoPath=" + str + "clipList=" + arrayList);
        }
        this.dmv = q(arrayList);
        this.mVideoPath = str;
        this.mSavePath = str2;
        this.dmw = this.dmv.size();
    }

    public void a(final c cVar) {
        if (cVar != null) {
            p.postOnSerial(new Runnable() { // from class: com.baidu.swan.games.screenrecord.a.e.1
                @Override // java.lang.Runnable
                public void run() {
                    ArrayList<long[]> aGo = e.this.aGo();
                    d dVar = new d();
                    dVar.videoPath = e.this.mVideoPath;
                    dVar.dmu = aGo;
                    dVar.clipPath = e.this.mSavePath;
                    com.baidu.swan.games.m.a.aFB().a(dVar, cVar);
                }
            }, "clipVideo");
        }
    }

    private ArrayList<a> q(ArrayList<b> arrayList) {
        a aGn;
        ArrayList<a> arrayList2 = new ArrayList<>();
        if (arrayList == null || arrayList.size() == 0) {
            return arrayList2;
        }
        Iterator<b> it = arrayList.iterator();
        while (it.hasNext()) {
            b next = it.next();
            if (next != null && (aGn = next.aGn()) != null) {
                arrayList2.add(aGn);
            }
        }
        return arrayList2;
    }

    public ArrayList<long[]> aGo() {
        ArrayList<long[]> arrayList = new ArrayList<>();
        if (this.dmw == 0) {
            return arrayList;
        }
        if (DEBUG) {
            Log.d("ClipVideoTask", "mergeRange mRangeList = " + this.dmv);
        }
        Collections.sort(this.dmv, new a.C0457a());
        a aVar = this.dmv.get(0);
        for (int i = 1; i < this.dmw; i++) {
            a aVar2 = this.dmv.get(i);
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
