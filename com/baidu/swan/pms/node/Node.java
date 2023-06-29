package com.baidu.swan.pms.node;

import android.text.TextUtils;
import com.baidu.tieba.nn4;
import com.baidu.tieba.on4;
import com.baidu.tieba.so4;
import com.baidu.tieba.tn4;
import com.baidu.tieba.to4;
import com.baidu.tieba.un4;
import com.baidu.tieba.xn4;
import com.baidu.tieba.xo4;
import com.baidu.tieba.yn4;
import com.baidu.tieba.yo4;
/* loaded from: classes4.dex */
public enum Node {
    HOST("host", so4.class, to4.class),
    PACKAGE("package", xo4.class, yo4.class, true),
    CERES("ceres", tn4.class, un4.class),
    COMMON("common", xn4.class, yn4.class);
    
    public static final String TAG = "LXNODE";
    public boolean mIsDataArray;
    public String mName;
    public Class<? extends on4> mParamsProvider;
    public Class<? extends nn4> mProcessor;

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

    public static on4 getProvider(Node node) {
        Class<? extends on4> paramsProvider;
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

    public Class<? extends on4> getParamsProvider() {
        return this.mParamsProvider;
    }

    public Class<? extends nn4> getProcessor() {
        return this.mProcessor;
    }

    public boolean isDataArray() {
        return this.mIsDataArray;
    }
}
