package com.baidu.swan.games.screenrecord.a;

import android.util.Log;
import com.baidu.swan.apps.ao.p;
import com.baidu.swan.games.screenrecord.a.a;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
/* loaded from: classes8.dex */
public class e {
    private static final boolean DEBUG = com.baidu.swan.apps.b.DEBUG;
    private ArrayList<a> emf;
    private int emg;
    private String mSavePath;
    private String mVideoPath;

    public e(ArrayList<b> arrayList, String str, String str2) {
        if (DEBUG) {
            Log.d("ClipVideoTask", "videoPath=" + str + "clipList=" + arrayList);
        }
        this.emf = q(arrayList);
        this.mVideoPath = str;
        this.mSavePath = str2;
        this.emg = this.emf.size();
    }

    public void a(final c cVar) {
        if (cVar != null) {
            p.postOnSerial(new Runnable() { // from class: com.baidu.swan.games.screenrecord.a.e.1
                @Override // java.lang.Runnable
                public void run() {
                    ArrayList<long[]> aYg = e.this.aYg();
                    d dVar = new d();
                    dVar.videoPath = e.this.mVideoPath;
                    dVar.eme = aYg;
                    dVar.clipPath = e.this.mSavePath;
                    com.baidu.swan.games.m.a.aXr().a(dVar, cVar);
                }
            }, "clipVideo");
        }
    }

    private ArrayList<a> q(ArrayList<b> arrayList) {
        a aYf;
        ArrayList<a> arrayList2 = new ArrayList<>();
        if (arrayList == null || arrayList.size() == 0) {
            return arrayList2;
        }
        Iterator<b> it = arrayList.iterator();
        while (it.hasNext()) {
            b next = it.next();
            if (next != null && (aYf = next.aYf()) != null) {
                arrayList2.add(aYf);
            }
        }
        return arrayList2;
    }

    public ArrayList<long[]> aYg() {
        ArrayList<long[]> arrayList = new ArrayList<>();
        if (this.emg == 0) {
            return arrayList;
        }
        if (DEBUG) {
            Log.d("ClipVideoTask", "mergeRange mRangeList = " + this.emf);
        }
        Collections.sort(this.emf, new a.C0532a());
        a aVar = this.emf.get(0);
        for (int i = 1; i < this.emg; i++) {
            a aVar2 = this.emf.get(i);
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
