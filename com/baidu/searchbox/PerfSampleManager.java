package com.baidu.searchbox;

import android.text.TextUtils;
import com.baidu.pyramid.annotation.Inject;
import com.baidu.searchbox.anr.ubc.ANRPerfSampleCallback;
import com.baidu.searchbox.block.ubc.BlockPerfSampleCallback;
import com.baidu.searchbox.fluency.ubc.FpsPerfSampleCallback;
import com.baidu.searchbox.logsystem.exceptionhandler.impl.ExceptionPerfSampleCallback;
import com.baidu.searchbox.ruka.ubc.LooperPerfSampleCallback;
import com.baidu.tieba.il9;
import com.baidu.tieba.tj1;
import com.baidu.tieba.vj1;
import com.baidu.tieba.xj1;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes3.dex */
public class PerfSampleManager {
    @Inject(force = false)
    public xj1<IPerfSampleCallback> mCallbackList;

    /* loaded from: classes3.dex */
    public interface IPerfSampleCallback {
        String getSampleFlag();
    }

    /* loaded from: classes3.dex */
    public class IPerfSampleCallback_PerfSampleManager_ListProvider implements tj1 {
        @Override // com.baidu.tieba.tj1
        public Object get() {
            ArrayList arrayList = new ArrayList();
            arrayList.add(new ANRPerfSampleCallback());
            arrayList.add(new BlockPerfSampleCallback());
            arrayList.add(new FpsPerfSampleCallback());
            arrayList.add(new ExceptionPerfSampleCallback());
            arrayList.add(new LooperPerfSampleCallback());
            arrayList.add(new il9());
            return arrayList;
        }
    }

    public void initmCallbackList() {
        vj1 b = vj1.b();
        this.mCallbackList = b;
        b.a(new IPerfSampleCallback_PerfSampleManager_ListProvider());
    }

    public PerfSampleManager() {
        initmCallbackList();
    }

    public String getSampleFlag() {
        List<IPerfSampleCallback> list;
        xj1<IPerfSampleCallback> xj1Var = this.mCallbackList;
        String str = 0;
        if (xj1Var != null && (list = xj1Var.getList()) != null && list.size() != 0) {
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
