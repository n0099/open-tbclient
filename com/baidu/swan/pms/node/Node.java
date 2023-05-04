package com.baidu.swan.pms.node;

import android.text.TextUtils;
import com.baidu.tieba.ij4;
import com.baidu.tieba.jj4;
import com.baidu.tieba.nk4;
import com.baidu.tieba.oj4;
import com.baidu.tieba.ok4;
import com.baidu.tieba.pj4;
import com.baidu.tieba.sj4;
import com.baidu.tieba.sk4;
import com.baidu.tieba.tj4;
import com.baidu.tieba.tk4;
/* loaded from: classes3.dex */
public enum Node {
    HOST("host", nk4.class, ok4.class),
    PACKAGE("package", sk4.class, tk4.class, true),
    CERES("ceres", oj4.class, pj4.class),
    COMMON("common", sj4.class, tj4.class);
    
    public static final String TAG = "LXNODE";
    public boolean mIsDataArray;
    public String mName;
    public Class<? extends jj4> mParamsProvider;
    public Class<? extends ij4> mProcessor;

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

    public static jj4 getProvider(Node node) {
        Class<? extends jj4> paramsProvider;
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

    public Class<? extends jj4> getParamsProvider() {
        return this.mParamsProvider;
    }

    public Class<? extends ij4> getProcessor() {
        return this.mProcessor;
    }

    public boolean isDataArray() {
        return this.mIsDataArray;
    }
}
