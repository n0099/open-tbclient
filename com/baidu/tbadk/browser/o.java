package com.baidu.tbadk.browser;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class o implements com.baidu.adp.lib.guide.b {
    final /* synthetic */ TbWebViewActivity a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public o(TbWebViewActivity tbWebViewActivity) {
        this.a = tbWebViewActivity;
    }

    @Override // com.baidu.adp.lib.guide.b
    public View a(LayoutInflater layoutInflater) {
        View inflate = layoutInflater.inflate(com.baidu.tieba.s.tb_webview_pop_install_plugin, (ViewGroup) null);
        if (inflate != null) {
            inflate.findViewById(com.baidu.tieba.r.install).setOnClickListener(new p(this));
            inflate.findViewById(com.baidu.tieba.r.btn_close);
            inflate.setOnClickListener(new q(this));
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
