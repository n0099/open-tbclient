package com.baidu.swan.pms.node;

import android.text.TextUtils;
import com.baidu.tieba.kn4;
import com.baidu.tieba.ln4;
import com.baidu.tieba.po4;
import com.baidu.tieba.qn4;
import com.baidu.tieba.qo4;
import com.baidu.tieba.rn4;
import com.baidu.tieba.un4;
import com.baidu.tieba.uo4;
import com.baidu.tieba.vn4;
import com.baidu.tieba.vo4;
/* loaded from: classes4.dex */
public enum Node {
    HOST("host", po4.class, qo4.class),
    PACKAGE("package", uo4.class, vo4.class, true),
    CERES("ceres", qn4.class, rn4.class),
    COMMON("common", un4.class, vn4.class);
    
    public static final String TAG = "LXNODE";
    public boolean mIsDataArray;
    public String mName;
    public Class<? extends ln4> mParamsProvider;
    public Class<? extends kn4> mProcessor;

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

    public static ln4 getProvider(Node node) {
        Class<? extends ln4> paramsProvider;
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

    public Class<? extends ln4> getParamsProvider() {
        return this.mParamsProvider;
    }

    public Class<? extends kn4> getProcessor() {
        return this.mProcessor;
    }

    public boolean isDataArray() {
        return this.mIsDataArray;
    }
}
