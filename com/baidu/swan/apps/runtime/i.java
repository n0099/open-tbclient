package com.baidu.swan.apps.runtime;

import android.os.Bundle;
import android.text.TextUtils;
import com.baidu.swan.apps.runtime.i;
/* loaded from: classes11.dex */
public abstract class i<SelfT extends i<SelfT>> extends com.baidu.swan.apps.v.b.a.c<SelfT> {
    public final String id;

    /* loaded from: classes11.dex */
    public static final class a extends i<a> {
        public a(String str) {
            super(str);
        }

        public a(String str, Bundle bundle) {
            super(str, bundle);
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.swan.apps.aq.e.d
        /* renamed from: ape */
        public a agG() {
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

    @Override // com.baidu.swan.apps.v.b.a.c
    public String toString() {
        return String.format("Event(%s) Ext => %s", this.id, super.toString());
    }
}
