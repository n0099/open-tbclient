package com.baidu.searchbox.cloudcontrol.processor;

import android.text.TextUtils;
import com.baidu.searchbox.cloudcontrol.runtime.ICloudControlRegister;
import com.baidu.tieba.q.d;
import java.util.HashMap;
/* loaded from: classes7.dex */
public class DataProcessors {
    private HashMap<String, ICloudControlProcessor> mDataProcessors = new HashMap<>();

    public DataProcessors() {
        collectProcessors();
    }

    public boolean containKey(String str) {
        return this.mDataProcessors.containsKey(str);
    }

    public void addProcessor(String str, ICloudControlProcessor iCloudControlProcessor) {
        if (iCloudControlProcessor != null && !TextUtils.isEmpty(str)) {
            this.mDataProcessors.put(str, iCloudControlProcessor);
        }
    }

    public ICloudControlProcessor getProcessor(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        return this.mDataProcessors.get(str);
    }

    public HashMap<String, ICloudControlProcessor> getProcessors() {
        return this.mDataProcessors;
    }

    public void collectProcessors() {
        ICloudControlRegister cloudControlRegister = getCloudControlRegister();
        if (cloudControlRegister != null) {
            cloudControlRegister.registerAllProcessors(this);
        }
    }

    private ICloudControlRegister getCloudControlRegister() {
        return d.dKb();
    }
}
