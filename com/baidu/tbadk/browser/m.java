package com.baidu.tbadk.browser;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class m implements com.baidu.adp.lib.guide.b {
    final /* synthetic */ TbWebViewActivity xA;

    /* JADX INFO: Access modifiers changed from: package-private */
    public m(TbWebViewActivity tbWebViewActivity) {
        this.xA = tbWebViewActivity;
    }

    @Override // com.baidu.adp.lib.guide.b
    public View a(LayoutInflater layoutInflater) {
        View inflate = layoutInflater.inflate(com.baidu.tieba.w.tb_webview_pop_install_plugin, (ViewGroup) null);
        if (inflate != null) {
            inflate.findViewById(com.baidu.tieba.v.install).setOnClickListener(new n(this));
            inflate.findViewById(com.baidu.tieba.v.btn_close);
            inflate.setOnClickListener(new o(this));
        }
        return inflate;
    }

    @Override // com.baidu.adp.lib.guide.b
    public int dy() {
        return 2;
    }

    @Override // com.baidu.adp.lib.guide.b
    public int dz() {
        return 32;
    }

    @Override // com.baidu.adp.lib.guide.b
    public int getXOffset() {
        return 0;
    }

    @Override // com.baidu.adp.lib.guide.b
    public int getYOffset() {
        return 0;
    }
}
