package com.baidu.tbadk.browser;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class n implements com.baidu.adp.lib.guide.b {
    final /* synthetic */ TbWebViewActivity a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public n(TbWebViewActivity tbWebViewActivity) {
        this.a = tbWebViewActivity;
    }

    @Override // com.baidu.adp.lib.guide.b
    public View a(LayoutInflater layoutInflater) {
        View inflate = layoutInflater.inflate(com.baidu.tieba.v.tb_webview_pop_install_plugin, (ViewGroup) null);
        if (inflate != null) {
            inflate.findViewById(com.baidu.tieba.u.install).setOnClickListener(new o(this));
            inflate.findViewById(com.baidu.tieba.u.btn_close);
            inflate.setOnClickListener(new p(this));
        }
        return inflate;
    }

    @Override // com.baidu.adp.lib.guide.b
    public int a() {
        return 2;
    }

    @Override // com.baidu.adp.lib.guide.b
    public int b() {
        return 32;
    }

    @Override // com.baidu.adp.lib.guide.b
    public int c() {
        return 0;
    }

    @Override // com.baidu.adp.lib.guide.b
    public int d() {
        return 0;
    }
}
