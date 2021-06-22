package com.baidu.searchbox.cloudcontrol.processor;

import android.text.TextUtils;
import com.baidu.pyramid.annotation.Autowired;
import com.baidu.pyramid.annotation.Inject;
import com.baidu.searchbox.cloudcontrol.runtime.ICloudControlRegister;
import d.a.o0.z2.d;
import java.util.HashMap;
@Autowired
/* loaded from: classes2.dex */
public class DataProcessors {
    public HashMap<String, ICloudControlProcessor> mDataProcessors = new HashMap<>();

    public DataProcessors() {
        collectProcessors();
    }

    @Inject
    private ICloudControlRegister getCloudControlRegister() {
        return d.a();
    }

    public void addProcessor(String str, ICloudControlProcessor iCloudControlProcessor) {
        if (iCloudControlProcessor == null || TextUtils.isEmpty(str)) {
            return;
        }
        this.mDataProcessors.put(str, iCloudControlProcessor);
    }

    public void collectProcessors() {
        ICloudControlRegister cloudControlRegister = getCloudControlRegister();
        if (cloudControlRegister != null) {
            cloudControlRegister.registerAllProcessors(this);
        }
    }

    public boolean containKey(String str) {
        return this.mDataProcessors.containsKey(str);
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
}
