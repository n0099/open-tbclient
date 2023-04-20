package com.baidu.swan.pms.node;

import android.text.TextUtils;
import com.baidu.tieba.gj4;
import com.baidu.tieba.hj4;
import com.baidu.tieba.lk4;
import com.baidu.tieba.mj4;
import com.baidu.tieba.mk4;
import com.baidu.tieba.nj4;
import com.baidu.tieba.qj4;
import com.baidu.tieba.qk4;
import com.baidu.tieba.rj4;
import com.baidu.tieba.rk4;
/* loaded from: classes3.dex */
public enum Node {
    HOST("host", lk4.class, mk4.class),
    PACKAGE("package", qk4.class, rk4.class, true),
    CERES("ceres", mj4.class, nj4.class),
    COMMON("common", qj4.class, rj4.class);
    
    public static final String TAG = "LXNODE";
    public boolean mIsDataArray;
    public String mName;
    public Class<? extends hj4> mParamsProvider;
    public Class<? extends gj4> mProcessor;

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

    public static hj4 getProvider(Node node) {
        Class<? extends hj4> paramsProvider;
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

    public Class<? extends hj4> getParamsProvider() {
        return this.mParamsProvider;
    }

    public Class<? extends gj4> getProcessor() {
        return this.mProcessor;
    }

    public boolean isDataArray() {
        return this.mIsDataArray;
    }
}
