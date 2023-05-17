package com.baidu.swan.pms.node;

import android.text.TextUtils;
import com.baidu.tieba.bl4;
import com.baidu.tieba.bm4;
import com.baidu.tieba.cl4;
import com.baidu.tieba.cm4;
import com.baidu.tieba.rk4;
import com.baidu.tieba.sk4;
import com.baidu.tieba.wl4;
import com.baidu.tieba.xk4;
import com.baidu.tieba.xl4;
import com.baidu.tieba.yk4;
/* loaded from: classes4.dex */
public enum Node {
    HOST("host", wl4.class, xl4.class),
    PACKAGE("package", bm4.class, cm4.class, true),
    CERES("ceres", xk4.class, yk4.class),
    COMMON("common", bl4.class, cl4.class);
    
    public static final String TAG = "LXNODE";
    public boolean mIsDataArray;
    public String mName;
    public Class<? extends sk4> mParamsProvider;
    public Class<? extends rk4> mProcessor;

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

    public static sk4 getProvider(Node node) {
        Class<? extends sk4> paramsProvider;
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

    public Class<? extends sk4> getParamsProvider() {
        return this.mParamsProvider;
    }

    public Class<? extends rk4> getProcessor() {
        return this.mProcessor;
    }

    public boolean isDataArray() {
        return this.mIsDataArray;
    }
}
