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
    private ArrayList<a> eix;
    private int eiy;
    private String mSavePath;
    private String mVideoPath;

    public e(ArrayList<b> arrayList, String str, String str2) {
        if (DEBUG) {
            Log.d("ClipVideoTask", "videoPath=" + str + "clipList=" + arrayList);
        }
        this.eix = q(arrayList);
        this.mVideoPath = str;
        this.mSavePath = str2;
        this.eiy = this.eix.size();
    }

    public void a(final c cVar) {
        if (cVar != null) {
            p.postOnSerial(new Runnable() { // from class: com.baidu.swan.games.screenrecord.a.e.1
                @Override // java.lang.Runnable
                public void run() {
                    ArrayList<long[]> aXR = e.this.aXR();
                    d dVar = new d();
                    dVar.videoPath = e.this.mVideoPath;
                    dVar.eiw = aXR;
                    dVar.clipPath = e.this.mSavePath;
                    com.baidu.swan.games.m.a.aXc().a(dVar, cVar);
                }
            }, "clipVideo");
        }
    }

    private ArrayList<a> q(ArrayList<b> arrayList) {
        a aXQ;
        ArrayList<a> arrayList2 = new ArrayList<>();
        if (arrayList == null || arrayList.size() == 0) {
            return arrayList2;
        }
        Iterator<b> it = arrayList.iterator();
        while (it.hasNext()) {
            b next = it.next();
            if (next != null && (aXQ = next.aXQ()) != null) {
                arrayList2.add(aXQ);
            }
        }
        return arrayList2;
    }

    public ArrayList<long[]> aXR() {
        ArrayList<long[]> arrayList = new ArrayList<>();
        if (this.eiy == 0) {
            return arrayList;
        }
        if (DEBUG) {
            Log.d("ClipVideoTask", "mergeRange mRangeList = " + this.eix);
        }
        Collections.sort(this.eix, new a.C0529a());
        a aVar = this.eix.get(0);
        for (int i = 1; i < this.eiy; i++) {
            a aVar2 = this.eix.get(i);
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
