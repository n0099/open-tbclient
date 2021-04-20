package com.baidu.swan.pms.node;

import android.text.TextUtils;
import d.b.g0.l.f;
import d.b.g0.l.m.j.c;
import d.b.g0.l.m.j.d;
import d.b.g0.l.m.k.e;
/* loaded from: classes3.dex */
public enum Node {
    HOST("host", c.class, d.class),
    PACKAGE("package", d.b.g0.l.m.k.d.class, e.class, true),
    CERES("ceres", d.b.g0.l.m.h.c.class, d.b.g0.l.m.h.d.class),
    COMMON("common", d.b.g0.l.m.i.c.class, d.b.g0.l.m.i.d.class);
    
    public static final String TAG = "LXNODE";
    public boolean mIsDataArray;
    public String mName;
    public Class<? extends d.b.g0.l.m.e> mParamsProvider;
    public Class<? extends d.b.g0.l.m.d> mProcessor;

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

    public static d.b.g0.l.m.e getProvider(Node node) {
        Class<? extends d.b.g0.l.m.e> paramsProvider;
        if (node == null || (paramsProvider = node.getParamsProvider()) == null) {
            return null;
        }
        try {
            return paramsProvider.newInstance();
        } catch (IllegalAccessException | InstantiationException e2) {
            if (f.f49281a) {
                e2.printStackTrace();
            }
            return null;
        }
    }

    public String getName() {
        return this.mName;
    }

    public Class<? extends d.b.g0.l.m.e> getParamsProvider() {
        return this.mParamsProvider;
    }

    public Class<? extends d.b.g0.l.m.d> getProcessor() {
        return this.mProcessor;
    }

    public boolean isDataArray() {
        return this.mIsDataArray;
    }

    Node(String str, Class cls, Class cls2) {
        this.mName = str;
        this.mParamsProvider = cls;
        this.mProcessor = cls2;
        this.mIsDataArray = false;
    }
}
