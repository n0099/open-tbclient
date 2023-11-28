package com.baidu.swan.pms.node;

import android.text.TextUtils;
import com.baidu.tieba.ci4;
import com.baidu.tieba.cj4;
import com.baidu.tieba.di4;
import com.baidu.tieba.dj4;
import com.baidu.tieba.sh4;
import com.baidu.tieba.th4;
import com.baidu.tieba.xi4;
import com.baidu.tieba.yh4;
import com.baidu.tieba.yi4;
import com.baidu.tieba.zh4;
/* loaded from: classes4.dex */
public enum Node {
    HOST("host", xi4.class, yi4.class),
    PACKAGE("package", cj4.class, dj4.class, true),
    CERES("ceres", yh4.class, zh4.class),
    COMMON("common", ci4.class, di4.class);
    
    public static final String TAG = "LXNODE";
    public boolean mIsDataArray;
    public String mName;
    public Class<? extends th4> mParamsProvider;
    public Class<? extends sh4> mProcessor;

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

    public static th4 getProvider(Node node) {
        Class<? extends th4> paramsProvider;
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

    public Class<? extends th4> getParamsProvider() {
        return this.mParamsProvider;
    }

    public Class<? extends sh4> getProcessor() {
        return this.mProcessor;
    }

    public boolean isDataArray() {
        return this.mIsDataArray;
    }
}
