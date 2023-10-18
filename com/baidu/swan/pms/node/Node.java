package com.baidu.swan.pms.node;

import android.text.TextUtils;
import com.baidu.tieba.ah4;
import com.baidu.tieba.bh4;
import com.baidu.tieba.fi4;
import com.baidu.tieba.gh4;
import com.baidu.tieba.gi4;
import com.baidu.tieba.hh4;
import com.baidu.tieba.kh4;
import com.baidu.tieba.ki4;
import com.baidu.tieba.lh4;
import com.baidu.tieba.li4;
/* loaded from: classes4.dex */
public enum Node {
    HOST("host", fi4.class, gi4.class),
    PACKAGE("package", ki4.class, li4.class, true),
    CERES("ceres", gh4.class, hh4.class),
    COMMON("common", kh4.class, lh4.class);
    
    public static final String TAG = "LXNODE";
    public boolean mIsDataArray;
    public String mName;
    public Class<? extends bh4> mParamsProvider;
    public Class<? extends ah4> mProcessor;

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

    public static bh4 getProvider(Node node) {
        Class<? extends bh4> paramsProvider;
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

    public Class<? extends bh4> getParamsProvider() {
        return this.mParamsProvider;
    }

    public Class<? extends ah4> getProcessor() {
        return this.mProcessor;
    }

    public boolean isDataArray() {
        return this.mIsDataArray;
    }
}
