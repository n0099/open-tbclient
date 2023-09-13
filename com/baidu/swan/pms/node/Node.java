package com.baidu.swan.pms.node;

import android.text.TextUtils;
import com.baidu.tieba.cn4;
import com.baidu.tieba.co4;
import com.baidu.tieba.dn4;
import com.baidu.tieba.do4;
import com.baidu.tieba.sm4;
import com.baidu.tieba.tm4;
import com.baidu.tieba.xn4;
import com.baidu.tieba.ym4;
import com.baidu.tieba.yn4;
import com.baidu.tieba.zm4;
/* loaded from: classes4.dex */
public enum Node {
    HOST("host", xn4.class, yn4.class),
    PACKAGE("package", co4.class, do4.class, true),
    CERES("ceres", ym4.class, zm4.class),
    COMMON("common", cn4.class, dn4.class);
    
    public static final String TAG = "LXNODE";
    public boolean mIsDataArray;
    public String mName;
    public Class<? extends tm4> mParamsProvider;
    public Class<? extends sm4> mProcessor;

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

    public static tm4 getProvider(Node node) {
        Class<? extends tm4> paramsProvider;
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

    public Class<? extends tm4> getParamsProvider() {
        return this.mParamsProvider;
    }

    public Class<? extends sm4> getProcessor() {
        return this.mProcessor;
    }

    public boolean isDataArray() {
        return this.mIsDataArray;
    }
}
