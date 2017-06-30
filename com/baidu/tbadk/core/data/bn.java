package com.baidu.tbadk.core.data;

import android.view.View;
import tbclient.PbContent;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class bn extends com.baidu.tbadk.widget.richText.b {
    final /* synthetic */ bm Zj;
    private final /* synthetic */ PbContent Zk;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public bn(bm bmVar, int i, String str, PbContent pbContent) {
        super(i, str);
        this.Zj = bmVar;
        this.Zk = pbContent;
    }

    @Override // com.baidu.tbadk.widget.richText.b, android.text.style.ClickableSpan
    public void onClick(View view) {
        this.Zj.cD(this.Zk.link);
    }
}
