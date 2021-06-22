package com.baidu.searchbox;

import android.text.TextUtils;
import com.baidu.pyramid.annotation.Inject;
import com.baidu.searchbox.anr.ubc.ANRPerfSampleCallback;
import com.baidu.searchbox.ruka.ubc.LooperPerfSampleCallback;
import d.a.f0.a.a;
import d.a.f0.a.b.d;
import d.a.o.b.b;
import d.a.o0.z2.p;
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
        @Override // d.a.f0.a.a
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
        List<IPerfSampleCallback> list;
        d<IPerfSampleCallback> dVar = this.mCallbackList;
        String str = 0;
        if (dVar != null && (list = dVar.getList()) != null && list.size() != 0) {
            for (int i2 = 0; i2 < list.size(); i2++) {
                String sampleFlag = list.get(i2).getSampleFlag();
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
        d.a.f0.a.b.b b2 = d.a.f0.a.b.b.b();
        this.mCallbackList = b2;
        b2.a(new IPerfSampleCallback_PerfSampleManager_ListProvider());
    }
}
