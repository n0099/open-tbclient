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
    private ArrayList<a> crS;
    private int crT;
    private String mSavePath;
    private String mVideoPath;

    public e(ArrayList<b> arrayList, String str, String str2) {
        if (DEBUG) {
            Log.d("ClipVideoTask", "videoPath=" + str + "clipList=" + arrayList);
        }
        this.crS = q(arrayList);
        this.mVideoPath = str;
        this.mSavePath = str2;
        this.crT = this.crS.size();
    }

    public void a(final c cVar) {
        if (cVar != null) {
            m.postOnSerial(new Runnable() { // from class: com.baidu.swan.games.screenrecord.a.e.1
                @Override // java.lang.Runnable
                public void run() {
                    ArrayList<long[]> apv = e.this.apv();
                    d dVar = new d();
                    dVar.videoPath = e.this.mVideoPath;
                    dVar.crR = apv;
                    dVar.clipPath = e.this.mSavePath;
                    com.baidu.swan.games.l.a.aoJ().a(dVar, cVar);
                }
            }, "clipVideo");
        }
    }

    private ArrayList<a> q(ArrayList<b> arrayList) {
        a apu;
        ArrayList<a> arrayList2 = new ArrayList<>();
        if (arrayList == null || arrayList.size() == 0) {
            return arrayList2;
        }
        Iterator<b> it = arrayList.iterator();
        while (it.hasNext()) {
            b next = it.next();
            if (next != null && (apu = next.apu()) != null) {
                arrayList2.add(apu);
            }
        }
        return arrayList2;
    }

    public ArrayList<long[]> apv() {
        ArrayList<long[]> arrayList = new ArrayList<>();
        if (this.crT == 0) {
            return arrayList;
        }
        if (DEBUG) {
            Log.d("ClipVideoTask", "mergeRange mRangeList = " + this.crS);
        }
        Collections.sort(this.crS, new a.C0347a());
        a aVar = this.crS.get(0);
        for (int i = 1; i < this.crT; i++) {
            a aVar2 = this.crS.get(i);
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
