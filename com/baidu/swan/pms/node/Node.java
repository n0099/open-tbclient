package com.baidu.swan.pms.node;

import android.text.TextUtils;
/* loaded from: classes15.dex */
public enum Node {
    HOST("host", com.baidu.swan.pms.node.c.c.class, com.baidu.swan.pms.node.c.d.class),
    PACKAGE("package", com.baidu.swan.pms.node.d.d.class, com.baidu.swan.pms.node.d.e.class, true),
    CERES("ceres", com.baidu.swan.pms.node.a.c.class, com.baidu.swan.pms.node.a.d.class),
    COMMON("common", com.baidu.swan.pms.node.b.c.class, com.baidu.swan.pms.node.b.d.class);
    
    public static final String TAG = "LXNODE";
    private boolean mIsDataArray;
    private String mName;
    private Class<? extends e> mParamsProvider;
    private Class<? extends d> mProcessor;

    Node(String str, Class cls, Class cls2, boolean z) {
        this.mName = str;
        this.mParamsProvider = cls;
        this.mProcessor = cls2;
        this.mIsDataArray = z;
    }

    Node(String str, Class cls, Class cls2) {
        this.mName = str;
        this.mParamsProvider = cls;
        this.mProcessor = cls2;
        this.mIsDataArray = false;
    }

    public String getName() {
        return this.mName;
    }

    public Class<? extends e> getParamsProvider() {
        return this.mParamsProvider;
    }

    public Class<? extends d> getProcessor() {
        return this.mProcessor;
    }

    public boolean isDataArray() {
        return this.mIsDataArray;
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

    /* JADX INFO: Access modifiers changed from: package-private */
    public static e getProvider(Node node) {
        Class<? extends e> paramsProvider;
        if (node != null && (paramsProvider = node.getParamsProvider()) != null) {
            try {
                return paramsProvider.newInstance();
            } catch (IllegalAccessException | InstantiationException e) {
                if (com.baidu.swan.pms.d.DEBUG) {
                    e.printStackTrace();
                }
                return null;
            }
        }
        return null;
    }
}
