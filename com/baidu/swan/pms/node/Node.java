package com.baidu.swan.pms.node;

import android.text.TextUtils;
import com.baidu.tieba.bn4;
import com.baidu.tieba.bo4;
import com.baidu.tieba.cn4;
import com.baidu.tieba.co4;
import com.baidu.tieba.rm4;
import com.baidu.tieba.sm4;
import com.baidu.tieba.wn4;
import com.baidu.tieba.xm4;
import com.baidu.tieba.xn4;
import com.baidu.tieba.ym4;
/* loaded from: classes4.dex */
public enum Node {
    HOST("host", wn4.class, xn4.class),
    PACKAGE("package", bo4.class, co4.class, true),
    CERES("ceres", xm4.class, ym4.class),
    COMMON("common", bn4.class, cn4.class);
    
    public static final String TAG = "LXNODE";
    public boolean mIsDataArray;
    public String mName;
    public Class<? extends sm4> mParamsProvider;
    public Class<? extends rm4> mProcessor;

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

    public static sm4 getProvider(Node node) {
        Class<? extends sm4> paramsProvider;
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

    public Class<? extends sm4> getParamsProvider() {
        return this.mParamsProvider;
    }

    public Class<? extends rm4> getProcessor() {
        return this.mProcessor;
    }

    public boolean isDataArray() {
        return this.mIsDataArray;
    }
}
