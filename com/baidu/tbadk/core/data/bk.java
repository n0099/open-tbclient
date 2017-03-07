package com.baidu.tbadk.core.data;

import android.text.TextUtils;
import android.view.View;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.tbadk.core.frameworkData.CmdConfigCustom;
import tbclient.PbContent;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class bk extends com.baidu.tbadk.widget.richText.b {
    final /* synthetic */ bj Zw;
    private final /* synthetic */ PbContent Zx;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public bk(bj bjVar, int i, String str, PbContent pbContent) {
        super(i, str);
        this.Zw = bjVar;
        this.Zx = pbContent;
    }

    @Override // com.baidu.tbadk.widget.richText.b, android.text.style.ClickableSpan
    public void onClick(View view) {
        if (!TextUtils.isEmpty(this.Zx.link)) {
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_START_HOT_TOPIC_ACTIVITY, this.Zx.link));
        }
    }
}
