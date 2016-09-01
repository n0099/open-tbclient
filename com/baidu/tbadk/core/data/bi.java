package com.baidu.tbadk.core.data;

import android.text.TextUtils;
import android.view.View;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.tbadk.core.frameworkData.CmdConfigCustom;
import com.baidu.tbadk.core.util.TiebaStatic;
import tbclient.PbContent;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class bi extends com.baidu.tbadk.widget.richText.h {
    final /* synthetic */ bg UL;
    private final /* synthetic */ PbContent UM;
    private final /* synthetic */ boolean UN;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public bi(bg bgVar, int i, String str, PbContent pbContent, boolean z) {
        super(i, str);
        this.UL = bgVar;
        this.UM = pbContent;
        this.UN = z;
    }

    @Override // com.baidu.tbadk.widget.richText.h, android.text.style.ClickableSpan
    public void onClick(View view) {
        if (!TextUtils.isEmpty(this.UM.link)) {
            TiebaStatic.log(new com.baidu.tbadk.core.util.ay("c11455").ab("obj_locate", this.UN ? "pb" : "frs"));
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(this.UN ? CmdConfigCustom.CMD_JUDGE_TO_HOTTOPIC_FROM_PB : CmdConfigCustom.CMD_JUDGE_TO_HOTTOPIC_FROM_FRS, this.UM.link));
        }
    }
}
