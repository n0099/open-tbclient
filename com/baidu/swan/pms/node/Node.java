package com.baidu.swan.pms.node;

import android.text.TextUtils;
import com.baidu.tieba.jm4;
import com.baidu.tieba.km4;
import com.baidu.tieba.on4;
import com.baidu.tieba.pm4;
import com.baidu.tieba.pn4;
import com.baidu.tieba.qm4;
import com.baidu.tieba.tm4;
import com.baidu.tieba.tn4;
import com.baidu.tieba.um4;
import com.baidu.tieba.un4;
/* loaded from: classes4.dex */
public enum Node {
    HOST("host", on4.class, pn4.class),
    PACKAGE("package", tn4.class, un4.class, true),
    CERES("ceres", pm4.class, qm4.class),
    COMMON("common", tm4.class, um4.class);
    
    public static final String TAG = "LXNODE";
    public boolean mIsDataArray;
    public String mName;
    public Class<? extends km4> mParamsProvider;
    public Class<? extends jm4> mProcessor;

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

    public static km4 getProvider(Node node) {
        Class<? extends km4> paramsProvider;
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

    public Class<? extends km4> getParamsProvider() {
        return this.mParamsProvider;
    }

    public Class<? extends jm4> getProcessor() {
        return this.mProcessor;
    }

    public boolean isDataArray() {
        return this.mIsDataArray;
    }
}
