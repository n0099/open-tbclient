package com.baidu.searchbox;

import android.text.TextUtils;
import com.baidu.pyramid.annotation.Inject;
import com.baidu.searchbox.anr.ubc.ANRPerfSampleCallback;
import com.baidu.searchbox.block.ubc.BlockPerfSampleCallback;
import com.baidu.searchbox.fluency.ubc.FpsPerfSampleCallback;
import com.baidu.searchbox.logsystem.exceptionhandler.impl.ExceptionPerfSampleCallback;
import com.baidu.searchbox.ruka.ubc.LooperPerfSampleCallback;
import com.baidu.tieba.ck1;
import com.baidu.tieba.ek1;
import com.baidu.tieba.gk1;
import com.baidu.tieba.t4a;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes3.dex */
public class PerfSampleManager {
    @Inject(force = false)
    public gk1<IPerfSampleCallback> mCallbackList;

    /* loaded from: classes3.dex */
    public interface IPerfSampleCallback {
        String getSampleFlag();
    }

    /* loaded from: classes3.dex */
    public class IPerfSampleCallback_PerfSampleManager_ListProvider implements ck1 {
        @Override // com.baidu.tieba.ck1
        public Object get() {
            ArrayList arrayList = new ArrayList();
            arrayList.add(new ANRPerfSampleCallback());
            arrayList.add(new BlockPerfSampleCallback());
            arrayList.add(new FpsPerfSampleCallback());
            arrayList.add(new ExceptionPerfSampleCallback());
            arrayList.add(new LooperPerfSampleCallback());
            arrayList.add(new t4a());
            return arrayList;
        }
    }

    public void initmCallbackList() {
        ek1 b = ek1.b();
        this.mCallbackList = b;
        b.a(new IPerfSampleCallback_PerfSampleManager_ListProvider());
    }

    public PerfSampleManager() {
        initmCallbackList();
    }

    public String getSampleFlag() {
        List<IPerfSampleCallback> list;
        gk1<IPerfSampleCallback> gk1Var = this.mCallbackList;
        String str = 0;
        if (gk1Var != null && (list = gk1Var.getList()) != null && list.size() != 0) {
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
