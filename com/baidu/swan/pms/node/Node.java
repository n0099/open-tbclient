package com.baidu.swan.pms.node;

import android.text.TextUtils;
import com.baidu.tieba.fj4;
import com.baidu.tieba.gj4;
import com.baidu.tieba.kk4;
import com.baidu.tieba.lj4;
import com.baidu.tieba.lk4;
import com.baidu.tieba.mj4;
import com.baidu.tieba.pj4;
import com.baidu.tieba.pk4;
import com.baidu.tieba.qj4;
import com.baidu.tieba.qk4;
/* loaded from: classes3.dex */
public enum Node {
    HOST("host", kk4.class, lk4.class),
    PACKAGE("package", pk4.class, qk4.class, true),
    CERES("ceres", lj4.class, mj4.class),
    COMMON("common", pj4.class, qj4.class);
    
    public static final String TAG = "LXNODE";
    public boolean mIsDataArray;
    public String mName;
    public Class<? extends gj4> mParamsProvider;
    public Class<? extends fj4> mProcessor;

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

    public static gj4 getProvider(Node node) {
        Class<? extends gj4> paramsProvider;
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

    public Class<? extends gj4> getParamsProvider() {
        return this.mParamsProvider;
    }

    public Class<? extends fj4> getProcessor() {
        return this.mProcessor;
    }

    public boolean isDataArray() {
        return this.mIsDataArray;
    }
}
