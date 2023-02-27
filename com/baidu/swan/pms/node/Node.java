package com.baidu.swan.pms.node;

import android.text.TextUtils;
import com.baidu.tieba.cm4;
import com.baidu.tieba.dl4;
import com.baidu.tieba.dm4;
import com.baidu.tieba.el4;
import com.baidu.tieba.hl4;
import com.baidu.tieba.hm4;
import com.baidu.tieba.il4;
import com.baidu.tieba.im4;
import com.baidu.tieba.xk4;
import com.baidu.tieba.yk4;
/* loaded from: classes3.dex */
public enum Node {
    HOST("host", cm4.class, dm4.class),
    PACKAGE("package", hm4.class, im4.class, true),
    CERES("ceres", dl4.class, el4.class),
    COMMON("common", hl4.class, il4.class);
    
    public static final String TAG = "LXNODE";
    public boolean mIsDataArray;
    public String mName;
    public Class<? extends yk4> mParamsProvider;
    public Class<? extends xk4> mProcessor;

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

    public static yk4 getProvider(Node node) {
        Class<? extends yk4> paramsProvider;
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

    public Class<? extends yk4> getParamsProvider() {
        return this.mParamsProvider;
    }

    public Class<? extends xk4> getProcessor() {
        return this.mProcessor;
    }

    public boolean isDataArray() {
        return this.mIsDataArray;
    }
}
