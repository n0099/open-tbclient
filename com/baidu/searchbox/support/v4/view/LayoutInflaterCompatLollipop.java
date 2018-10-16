package com.baidu.searchbox.support.v4.view;

import android.view.LayoutInflater;
import com.baidu.searchbox.support.v4.view.LayoutInflaterCompatHC;
/* loaded from: classes2.dex */
class LayoutInflaterCompatLollipop {
    LayoutInflaterCompatLollipop() {
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void setFactory(LayoutInflater layoutInflater, LayoutInflaterFactory layoutInflaterFactory) {
        layoutInflater.setFactory2(layoutInflaterFactory != null ? new LayoutInflaterCompatHC.FactoryWrapperHC(layoutInflaterFactory) : null);
    }
}
