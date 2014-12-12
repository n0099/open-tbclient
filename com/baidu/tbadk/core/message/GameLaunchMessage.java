package com.baidu.tbadk.core.message;

import android.content.Context;
import com.baidu.adp.framework.message.CustomResponsedMessage;
/* loaded from: classes.dex */
public class GameLaunchMessage extends CustomResponsedMessage<Boolean> {
    public Context context;
    public String gameId;
    public String gameName;
    public String url;

    public GameLaunchMessage() {
        super(2001263);
    }

    public GameLaunchMessage(Context context, String str, String str2, String str3) {
        super(2001263);
        this.context = context;
        this.gameId = str3;
        this.url = str2;
        this.gameName = str;
    }
}
