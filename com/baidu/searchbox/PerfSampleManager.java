package com.baidu.searchbox;

import android.text.TextUtils;
import com.baidu.pyramid.annotation.Inject;
import com.baidu.searchbox.anr.ubc.ANRPerfSampleCallback;
import com.baidu.searchbox.block.ubc.BlockPerfSampleCallback;
import com.baidu.searchbox.fluency.ubc.FpsPerfSampleCallback;
import com.baidu.searchbox.logsystem.exceptionhandler.impl.ExceptionPerfSampleCallback;
import com.baidu.searchbox.ruka.ubc.LooperPerfSampleCallback;
import com.baidu.tieba.lk1;
import com.baidu.tieba.nk1;
import com.baidu.tieba.pk1;
import com.baidu.tieba.saa;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes3.dex */
public class PerfSampleManager {
    @Inject(force = false)
    public pk1<IPerfSampleCallback> mCallbackList;

    /* loaded from: classes3.dex */
    public interface IPerfSampleCallback {
        String getSampleFlag();
    }

    /* loaded from: classes3.dex */
    public class IPerfSampleCallback_PerfSampleManager_ListProvider implements lk1 {
        @Override // com.baidu.tieba.lk1
        public Object get() {
            ArrayList arrayList = new ArrayList();
            arrayList.add(new ANRPerfSampleCallback());
            arrayList.add(new BlockPerfSampleCallback());
            arrayList.add(new FpsPerfSampleCallback());
            arrayList.add(new ExceptionPerfSampleCallback());
            arrayList.add(new LooperPerfSampleCallback());
            arrayList.add(new saa());
            return arrayList;
        }
    }

    public void initmCallbackList() {
        nk1 b = nk1.b();
        this.mCallbackList = b;
        b.a(new IPerfSampleCallback_PerfSampleManager_ListProvider());
    }

    public PerfSampleManager() {
        initmCallbackList();
    }

    public String getSampleFlag() {
        List<IPerfSampleCallback> list;
        pk1<IPerfSampleCallback> pk1Var = this.mCallbackList;
        String str = 0;
        if (pk1Var != null && (list = pk1Var.getList()) != null && list.size() != 0) {
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
