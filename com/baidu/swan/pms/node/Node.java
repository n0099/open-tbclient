package com.baidu.swan.pms.node;

import android.text.TextUtils;
import com.baidu.tieba.ej4;
import com.baidu.tieba.fj4;
import com.baidu.tieba.jk4;
import com.baidu.tieba.kj4;
import com.baidu.tieba.kk4;
import com.baidu.tieba.lj4;
import com.baidu.tieba.oj4;
import com.baidu.tieba.ok4;
import com.baidu.tieba.pj4;
import com.baidu.tieba.pk4;
/* loaded from: classes3.dex */
public enum Node {
    HOST("host", jk4.class, kk4.class),
    PACKAGE("package", ok4.class, pk4.class, true),
    CERES("ceres", kj4.class, lj4.class),
    COMMON("common", oj4.class, pj4.class);
    
    public static final String TAG = "LXNODE";
    public boolean mIsDataArray;
    public String mName;
    public Class<? extends fj4> mParamsProvider;
    public Class<? extends ej4> mProcessor;

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

    public static fj4 getProvider(Node node) {
        Class<? extends fj4> paramsProvider;
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

    public Class<? extends fj4> getParamsProvider() {
        return this.mParamsProvider;
    }

    public Class<? extends ej4> getProcessor() {
        return this.mProcessor;
    }

    public boolean isDataArray() {
        return this.mIsDataArray;
    }
}
