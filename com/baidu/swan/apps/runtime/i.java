package com.baidu.swan.apps.runtime;

import android.os.Bundle;
import android.text.TextUtils;
import com.baidu.swan.apps.runtime.i;
/* loaded from: classes10.dex */
public abstract class i<SelfT extends i<SelfT>> extends com.baidu.swan.apps.x.b.a.c<SelfT> {
    public final String id;

    /* loaded from: classes10.dex */
    public static final class a extends i<a> {
        public a(String str) {
            super(str);
        }

        public a(String str, Bundle bundle) {
            super(str, bundle);
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.swan.apps.as.d.d
        /* renamed from: aaM */
        public a Tp() {
            return this;
        }
    }

    public i(String str) {
        this(str, null);
    }

    public i(String str, Bundle bundle) {
        super(bundle);
        this.id = TextUtils.isEmpty(str) ? "" : str;
    }

    @Override // com.baidu.swan.apps.x.b.a.c
    public String toString() {
        return String.format("Event(%s) Ext => %s", this.id, super.toString());
    }
}
