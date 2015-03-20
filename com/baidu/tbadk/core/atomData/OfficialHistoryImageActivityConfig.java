package com.baidu.tbadk.core.atomData;

import android.content.Context;
import com.baidu.tbadk.game.GameInfoData;
/* loaded from: classes.dex */
public class OfficialHistoryImageActivityConfig extends AbsMsgImageActivityConfig {
    public OfficialHistoryImageActivityConfig(Context context, String str, String str2) {
        super(context);
        getIntent().putExtra(AbsMsgImageActivityConfig.CURRENT_URL, str);
        getIntent().putExtra("id", GameInfoData.NOT_FROM_DETAIL);
        getIntent().putExtra(AbsMsgImageActivityConfig.ID_UNIQUE, str2);
    }
}
