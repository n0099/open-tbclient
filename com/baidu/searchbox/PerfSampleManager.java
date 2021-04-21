package com.baidu.searchbox;

import android.text.TextUtils;
import com.baidu.pyramid.annotation.Inject;
import com.baidu.searchbox.anr.ubc.ANRPerfSampleCallback;
import com.baidu.searchbox.ruka.ubc.LooperPerfSampleCallback;
import d.b.c0.a.a;
import d.b.c0.a.b.d;
import d.b.j0.y2.p;
import d.b.o.b.b;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes2.dex */
public class PerfSampleManager {
    @Inject(force = false)
    public d<IPerfSampleCallback> mCallbackList;

    /* loaded from: classes2.dex */
    public interface IPerfSampleCallback {
        String getSampleFlag();
    }

    /* loaded from: classes2.dex */
    public class IPerfSampleCallback_PerfSampleManager_ListProvider implements a {
        @Override // d.b.c0.a.a
        public Object get() {
            ArrayList arrayList = new ArrayList();
            arrayList.add(new b());
            arrayList.add(new ANRPerfSampleCallback());
            arrayList.add(new LooperPerfSampleCallback());
            arrayList.add(new p());
            return arrayList;
        }
    }

    public PerfSampleManager() {
        initmCallbackList();
    }

    public String getSampleFlag() {
        List<IPerfSampleCallback> a2;
        d<IPerfSampleCallback> dVar = this.mCallbackList;
        String str = 0;
        if (dVar != null && (a2 = dVar.a()) != null && a2.size() != 0) {
            for (int i = 0; i < a2.size(); i++) {
                String sampleFlag = a2.get(i).getSampleFlag();
                if (!TextUtils.isEmpty(sampleFlag)) {
                    if (TextUtils.isEmpty(str)) {
                        str = sampleFlag;
                    } else if (!str.contains(sampleFlag)) {
                        str = str + "," + sampleFlag;
                    }
                }
            }
        }
        return str;
    }

    public void initmCallbackList() {
        d.b.c0.a.b.b c2 = d.b.c0.a.b.b.c();
        this.mCallbackList = c2;
        c2.b(new IPerfSampleCallback_PerfSampleManager_ListProvider());
    }
}
