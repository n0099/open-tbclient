package com.baidu.swan.pms.node;

import android.text.TextUtils;
import com.baidu.tieba.jn4;
import com.baidu.tieba.kn4;
import com.baidu.tieba.oo4;
import com.baidu.tieba.pn4;
import com.baidu.tieba.po4;
import com.baidu.tieba.qn4;
import com.baidu.tieba.tn4;
import com.baidu.tieba.to4;
import com.baidu.tieba.un4;
import com.baidu.tieba.uo4;
/* loaded from: classes4.dex */
public enum Node {
    HOST("host", oo4.class, po4.class),
    PACKAGE("package", to4.class, uo4.class, true),
    CERES("ceres", pn4.class, qn4.class),
    COMMON("common", tn4.class, un4.class);
    
    public static final String TAG = "LXNODE";
    public boolean mIsDataArray;
    public String mName;
    public Class<? extends kn4> mParamsProvider;
    public Class<? extends jn4> mProcessor;

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

    public static kn4 getProvider(Node node) {
        Class<? extends kn4> paramsProvider;
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

    public Class<? extends kn4> getParamsProvider() {
        return this.mParamsProvider;
    }

    public Class<? extends jn4> getProcessor() {
        return this.mProcessor;
    }

    public boolean isDataArray() {
        return this.mIsDataArray;
    }
}
