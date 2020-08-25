package com.baidu.tbadk.core.atomData;

import android.content.Context;
import com.baidu.tbadk.core.data.GameShareData;
import com.baidu.tbadk.core.frameworkData.IntentConfig;
/* loaded from: classes2.dex */
public class GameShareActivityConfig extends IntentConfig {
    public static final String KEY_GAME_SHARE_DATA = "key_share_Data";

    public GameShareActivityConfig(Context context, GameShareData gameShareData) {
        super(context);
        getIntent().putExtra(KEY_GAME_SHARE_DATA, gameShareData);
    }
}
