package com.baidu.tbadk.core.data;

import android.text.TextUtils;
import android.view.View;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.tbadk.core.frameworkData.CmdConfigCustom;
import tbclient.PbContent;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class bj extends com.baidu.tbadk.widget.richText.b {
    final /* synthetic */ bh Uj;
    private final /* synthetic */ PbContent Uk;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public bj(bh bhVar, int i, String str, PbContent pbContent) {
        super(i, str);
        this.Uj = bhVar;
        this.Uk = pbContent;
    }

    @Override // com.baidu.tbadk.widget.richText.b, android.text.style.ClickableSpan
    public void onClick(View view) {
        if (!TextUtils.isEmpty(this.Uk.link)) {
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_START_HOT_TOPIC_ACTIVITY, this.Uk.link));
        }
    }
}
