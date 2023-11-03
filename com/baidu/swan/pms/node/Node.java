package com.baidu.swan.pms.node;

import android.text.TextUtils;
import com.baidu.tieba.bi4;
import com.baidu.tieba.bj4;
import com.baidu.tieba.ci4;
import com.baidu.tieba.cj4;
import com.baidu.tieba.rh4;
import com.baidu.tieba.sh4;
import com.baidu.tieba.wi4;
import com.baidu.tieba.xh4;
import com.baidu.tieba.xi4;
import com.baidu.tieba.yh4;
/* loaded from: classes4.dex */
public enum Node {
    HOST("host", wi4.class, xi4.class),
    PACKAGE("package", bj4.class, cj4.class, true),
    CERES("ceres", xh4.class, yh4.class),
    COMMON("common", bi4.class, ci4.class);
    
    public static final String TAG = "LXNODE";
    public boolean mIsDataArray;
    public String mName;
    public Class<? extends sh4> mParamsProvider;
    public Class<? extends rh4> mProcessor;

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

    public static sh4 getProvider(Node node) {
        Class<? extends sh4> paramsProvider;
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

    public Class<? extends sh4> getParamsProvider() {
        return this.mParamsProvider;
    }

    public Class<? extends rh4> getProcessor() {
        return this.mProcessor;
    }

    public boolean isDataArray() {
        return this.mIsDataArray;
    }
}
