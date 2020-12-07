package com.baidu.searchbox;

import android.text.TextUtils;
import com.baidu.pyramid.a.a;
import com.baidu.pyramid.a.a.b;
import com.baidu.pyramid.a.a.d;
import com.baidu.searchbox.anr.ubc.ANRPerfSampleCallback;
import com.baidu.searchbox.ruka.ubc.LooperPerfSampleCallback;
import com.baidu.tieba.r.n;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes20.dex */
public class PerfSampleManager {
    private d<IPerfSampleCallback> mCallbackList;

    /* loaded from: classes9.dex */
    public interface IPerfSampleCallback {
        String getSampleFlag();
    }

    /* loaded from: classes20.dex */
    public class IPerfSampleCallback_PerfSampleManager_ListProvider implements a {
        @Override // com.baidu.pyramid.a.a
        public Object get() {
            ArrayList arrayList = new ArrayList();
            arrayList.add(new ANRPerfSampleCallback());
            arrayList.add(new LooperPerfSampleCallback());
            arrayList.add(new n());
            return arrayList;
        }
    }

    public void initmCallbackList() {
        this.mCallbackList = b.afE();
        this.mCallbackList.b(new IPerfSampleCallback_PerfSampleManager_ListProvider());
    }

    public PerfSampleManager() {
        initmCallbackList();
    }

    public String getSampleFlag() {
        List<IPerfSampleCallback> list;
        String str = 0;
        if (this.mCallbackList != null && (list = this.mCallbackList.getList()) != null && list.size() != 0) {
            int i = 0;
            while (i < list.size()) {
                String sampleFlag = list.get(i).getSampleFlag();
                if (!TextUtils.isEmpty(sampleFlag)) {
                    if (!TextUtils.isEmpty(str)) {
                        if (!str.contains(sampleFlag)) {
                            sampleFlag = str + "," + sampleFlag;
                        }
                    }
                    i++;
                    str = sampleFlag;
                }
                sampleFlag = str;
                i++;
                str = sampleFlag;
            }
        }
        return str;
    }
}
