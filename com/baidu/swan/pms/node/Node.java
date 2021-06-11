package com.baidu.swan.pms.node;

import android.text.TextUtils;
import com.baidu.tieba.service.AsInstallService;
import d.a.l0.n.j.j.c;
import d.a.l0.n.j.j.d;
import d.a.l0.n.j.k.e;
/* loaded from: classes3.dex */
public enum Node {
    HOST("host", c.class, d.class),
    PACKAGE(AsInstallService.SCHEME_PACKAGE_ADDED, d.a.l0.n.j.k.d.class, e.class, true),
    CERES("ceres", d.a.l0.n.j.h.c.class, d.a.l0.n.j.h.d.class),
    COMMON("common", d.a.l0.n.j.i.c.class, d.a.l0.n.j.i.d.class);
    
    public static final String TAG = "LXNODE";
    public boolean mIsDataArray;
    public String mName;
    public Class<? extends d.a.l0.n.j.e> mParamsProvider;
    public Class<? extends d.a.l0.n.j.d> mProcessor;

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

    public static d.a.l0.n.j.e getProvider(Node node) {
        Class<? extends d.a.l0.n.j.e> paramsProvider;
        if (node == null || (paramsProvider = node.getParamsProvider()) == null) {
            return null;
        }
        try {
            return paramsProvider.newInstance();
        } catch (IllegalAccessException | InstantiationException e2) {
            if (d.a.l0.n.c.f51658a) {
                e2.printStackTrace();
            }
            return null;
        }
    }

    public String getName() {
        return this.mName;
    }

    public Class<? extends d.a.l0.n.j.e> getParamsProvider() {
        return this.mParamsProvider;
    }

    public Class<? extends d.a.l0.n.j.d> getProcessor() {
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
