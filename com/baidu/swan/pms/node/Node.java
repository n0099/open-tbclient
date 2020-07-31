package com.baidu.swan.pms.node;

import android.text.TextUtils;
/* loaded from: classes19.dex */
public enum Node {
    HOST("host", com.baidu.swan.pms.node.c.c.class, com.baidu.swan.pms.node.c.d.class),
    PACKAGE("package", com.baidu.swan.pms.node.d.c.class, com.baidu.swan.pms.node.d.d.class, true),
    CERES("ceres", com.baidu.swan.pms.node.a.c.class, com.baidu.swan.pms.node.a.d.class),
    COMMON("common", com.baidu.swan.pms.node.b.c.class, com.baidu.swan.pms.node.b.d.class);
    
    public static final String TAG = "LXNODE";
    private boolean mIsDataArray;
    private String mName;
    private Class<? extends d> mParamsProvider;
    private Class<? extends c> mProcessor;

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

    public Class<? extends d> getParamsProvider() {
        return this.mParamsProvider;
    }

    public Class<? extends c> getProcessor() {
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
    public static d getProvider(Node node) {
        Class<? extends d> paramsProvider;
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
