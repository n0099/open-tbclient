package com.baidu.tbadk.core.message;

import android.content.Context;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.tbadk.core.frameworkData.CmdConfigCustom;
/* loaded from: classes.dex */
public class GameLaunchMessage extends CustomResponsedMessage<Boolean> {
    public Context context;
    public String gameId;
    public String gameName;
    public String url;

    public GameLaunchMessage() {
        super(CmdConfigCustom.CMD_GAME_LAUNCH);
    }

    public GameLaunchMessage(Context context, String str, String str2, String str3) {
        super(CmdConfigCustom.CMD_GAME_LAUNCH);
        this.context = context;
        this.gameId = str3;
        this.url = str2;
        this.gameName = str;
    }
}
