package com.baidu.tbadk.core.message;

import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.tbadk.core.frameworkData.CmdConfigCustom;
/* loaded from: classes.dex */
public class RemindRecommendMessage extends CustomResponsedMessage<Boolean> {
    public boolean isLocal;
    public String name;
    public String picture;
    public String title;
    public String url;

    public RemindRecommendMessage() {
        super(CmdConfigCustom.CMD_SCREEN_DIALOG);
    }

    public RemindRecommendMessage(String str, String str2, String str3, String str4) {
        super(CmdConfigCustom.CMD_SCREEN_DIALOG);
        this.name = str;
        this.url = str3;
        this.title = str2;
        this.picture = str4;
    }
}
