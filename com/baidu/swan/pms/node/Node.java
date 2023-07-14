package com.baidu.swan.pms.node;

import android.text.TextUtils;
import com.baidu.tieba.gn4;
import com.baidu.tieba.hn4;
import com.baidu.tieba.lo4;
import com.baidu.tieba.mn4;
import com.baidu.tieba.mo4;
import com.baidu.tieba.nn4;
import com.baidu.tieba.qn4;
import com.baidu.tieba.qo4;
import com.baidu.tieba.rn4;
import com.baidu.tieba.ro4;
/* loaded from: classes4.dex */
public enum Node {
    HOST("host", lo4.class, mo4.class),
    PACKAGE("package", qo4.class, ro4.class, true),
    CERES("ceres", mn4.class, nn4.class),
    COMMON("common", qn4.class, rn4.class);
    
    public static final String TAG = "LXNODE";
    public boolean mIsDataArray;
    public String mName;
    public Class<? extends hn4> mParamsProvider;
    public Class<? extends gn4> mProcessor;

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

    public static hn4 getProvider(Node node) {
        Class<? extends hn4> paramsProvider;
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

    public Class<? extends hn4> getParamsProvider() {
        return this.mParamsProvider;
    }

    public Class<? extends gn4> getProcessor() {
        return this.mProcessor;
    }

    public boolean isDataArray() {
        return this.mIsDataArray;
    }
}
