package com.baidu.tbadk.core.message;

import com.baidu.adp.framework.message.CustomResponsedMessage;
/* loaded from: classes.dex */
public class RemindRecommendMessage extends CustomResponsedMessage<Boolean> {
    public boolean isLocal;
    public String name;
    public String picture;
    public String title;
    public String url;

    public RemindRecommendMessage() {
        super(2001355);
    }

    public RemindRecommendMessage(String str, String str2, String str3, String str4) {
        super(2001355);
        this.name = str;
        this.url = str3;
        this.title = str2;
        this.picture = str4;
    }
}
