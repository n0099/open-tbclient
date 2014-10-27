package com.baidu.tbadk.core.atomData;

import android.content.Context;
/* loaded from: classes.dex */
public class GameWebViewActivityConfig extends TbWebViewActivityConfig {
    public static final String TAG_GAME_ID = "tag_game_id";

    public GameWebViewActivityConfig(Context context, String str, String str2, String str3, boolean z) {
        super(context, str, str2, z);
        getIntent().putExtra(TAG_GAME_ID, str3);
    }
}
