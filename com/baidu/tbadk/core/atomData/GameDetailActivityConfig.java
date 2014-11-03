package com.baidu.tbadk.core.atomData;

import android.content.Context;
import android.content.Intent;
import com.baidu.tbadk.core.frameworkData.a;
/* loaded from: classes.dex */
public class GameDetailActivityConfig extends a {
    public static final String GAME_ID_KEY = "game_id_key";
    public static final String SOURCE = "source";

    public GameDetailActivityConfig(Context context, String str) {
        this(context, str, "");
    }

    public GameDetailActivityConfig(Context context, String str, String str2) {
        super(context);
        Intent intent = getIntent();
        intent.putExtra(GAME_ID_KEY, str);
        intent.putExtra(SOURCE, str2);
    }
}
