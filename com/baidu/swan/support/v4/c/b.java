package com.baidu.swan.support.v4.c;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
/* loaded from: classes2.dex */
class b {

    /* loaded from: classes2.dex */
    static class a implements LayoutInflater.Factory {
        final e bNI;

        /* JADX INFO: Access modifiers changed from: package-private */
        public a(e eVar) {
            this.bNI = eVar;
        }

        @Override // android.view.LayoutInflater.Factory
        public View onCreateView(String str, Context context, AttributeSet attributeSet) {
            return this.bNI.onCreateView(null, str, context, attributeSet);
        }

        public String toString() {
            return getClass().getName() + "{" + this.bNI + "}";
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void a(LayoutInflater layoutInflater, e eVar) {
        layoutInflater.setFactory(eVar != null ? new a(eVar) : null);
    }
}
