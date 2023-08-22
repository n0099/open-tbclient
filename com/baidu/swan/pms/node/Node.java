package com.baidu.swan.pms.node;

import android.text.TextUtils;
import com.baidu.tieba.om4;
import com.baidu.tieba.pm4;
import com.baidu.tieba.tn4;
import com.baidu.tieba.um4;
import com.baidu.tieba.un4;
import com.baidu.tieba.vm4;
import com.baidu.tieba.ym4;
import com.baidu.tieba.yn4;
import com.baidu.tieba.zm4;
import com.baidu.tieba.zn4;
/* loaded from: classes4.dex */
public enum Node {
    HOST("host", tn4.class, un4.class),
    PACKAGE("package", yn4.class, zn4.class, true),
    CERES("ceres", um4.class, vm4.class),
    COMMON("common", ym4.class, zm4.class);
    
    public static final String TAG = "LXNODE";
    public boolean mIsDataArray;
    public String mName;
    public Class<? extends pm4> mParamsProvider;
    public Class<? extends om4> mProcessor;

    Node(String str, Class cls, Class cls2) {
        this.mName = str;
        this.mParamsProvider = cls;
        this.mProcessor = cls2;
        this.mIsDataArray = false;
    }

    Node(String str, Class cls, Class cls2, boolean z) {
        this.mName = str;
        this.mParamsProvider = cls;
        this.mProcessor = cls2;
        this.mIsDataArray = z;
    }

    public static Node getNodeByConfigName(String str) {
        Node[] values;
        for (Node node : values()) {
            if (node != null && TextUtils.equals(node.getName(), str)) {
                return node;
            }
        }
        return null;
    }

    public static pm4 getProvider(Node node) {
        Class<? extends pm4> paramsProvider;
        if (node == null || (paramsProvider = node.getParamsProvider()) == null) {
            return null;
        }
        try {
            return paramsProvider.newInstance();
        } catch (IllegalAccessException | InstantiationException unused) {
            return null;
        }
    }

    public String getName() {
        return this.mName;
    }

    public Class<? extends pm4> getParamsProvider() {
        return this.mParamsProvider;
    }

    public Class<? extends om4> getProcessor() {
        return this.mProcessor;
    }

    public boolean isDataArray() {
        return this.mIsDataArray;
    }
}
