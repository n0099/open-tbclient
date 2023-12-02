package com.baidu.swan.pms.node;

import android.text.TextUtils;
import com.baidu.tieba.aj4;
import com.baidu.tieba.bi4;
import com.baidu.tieba.bj4;
import com.baidu.tieba.ci4;
import com.baidu.tieba.fi4;
import com.baidu.tieba.fj4;
import com.baidu.tieba.gi4;
import com.baidu.tieba.gj4;
import com.baidu.tieba.vh4;
import com.baidu.tieba.wh4;
/* loaded from: classes4.dex */
public enum Node {
    HOST("host", aj4.class, bj4.class),
    PACKAGE("package", fj4.class, gj4.class, true),
    CERES("ceres", bi4.class, ci4.class),
    COMMON("common", fi4.class, gi4.class);
    
    public static final String TAG = "LXNODE";
    public boolean mIsDataArray;
    public String mName;
    public Class<? extends wh4> mParamsProvider;
    public Class<? extends vh4> mProcessor;

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

    public static wh4 getProvider(Node node) {
        Class<? extends wh4> paramsProvider;
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

    public Class<? extends wh4> getParamsProvider() {
        return this.mParamsProvider;
    }

    public Class<? extends vh4> getProcessor() {
        return this.mProcessor;
    }

    public boolean isDataArray() {
        return this.mIsDataArray;
    }
}
