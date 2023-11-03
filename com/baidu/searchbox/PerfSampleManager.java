package com.baidu.searchbox;

import android.text.TextUtils;
import com.baidu.pyramid.annotation.Inject;
import com.baidu.searchbox.anr.ubc.ANRPerfSampleCallback;
import com.baidu.searchbox.block.ubc.BlockPerfSampleCallback;
import com.baidu.searchbox.fluency.ubc.FpsPerfSampleCallback;
import com.baidu.searchbox.logsystem.exceptionhandler.impl.ExceptionPerfSampleCallback;
import com.baidu.searchbox.ruka.ubc.LooperPerfSampleCallback;
import com.baidu.tieba.lf1;
import com.baidu.tieba.nf1;
import com.baidu.tieba.pf1;
import com.baidu.tieba.tka;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes3.dex */
public class PerfSampleManager {
    @Inject(force = false)
    public pf1<IPerfSampleCallback> mCallbackList;

    /* loaded from: classes3.dex */
    public interface IPerfSampleCallback {
        String getSampleFlag();
    }

    /* loaded from: classes3.dex */
    public class IPerfSampleCallback_PerfSampleManager_ListProvider implements lf1 {
        @Override // com.baidu.tieba.lf1
        public Object get() {
            ArrayList arrayList = new ArrayList();
            arrayList.add(new ANRPerfSampleCallback());
            arrayList.add(new BlockPerfSampleCallback());
            arrayList.add(new FpsPerfSampleCallback());
            arrayList.add(new ExceptionPerfSampleCallback());
            arrayList.add(new LooperPerfSampleCallback());
            arrayList.add(new tka());
            return arrayList;
        }
    }

    public void initmCallbackList() {
        nf1 b = nf1.b();
        this.mCallbackList = b;
        b.a(new IPerfSampleCallback_PerfSampleManager_ListProvider());
    }

    public PerfSampleManager() {
        initmCallbackList();
    }

    public String getSampleFlag() {
        List<IPerfSampleCallback> list;
        pf1<IPerfSampleCallback> pf1Var = this.mCallbackList;
        String str = 0;
        if (pf1Var != null && (list = pf1Var.getList()) != null && list.size() != 0) {
            for (int i = 0; i < list.size(); i++) {
                String sampleFlag = list.get(i).getSampleFlag();
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
}
