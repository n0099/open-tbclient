package com.baidu.tbadk.core.atomData;

import android.content.Context;
import com.baidu.tbadk.core.frameworkData.IntentConfig;
/* loaded from: classes.dex */
public class SquareSearchActivityConfig extends IntentConfig {
    public static final String BACK_SPECIAL = "back_special";
    public static final String FROM = "start_from";
    public static boolean IS_SHOW_RECOMMEND_FORUM = true;
    public static boolean IS_SHOW_LIKE_FORUM = false;

    public SquareSearchActivityConfig(Context context, String str, boolean z) {
        super(context);
        getIntent().putExtra("start_from", str);
        getIntent().putExtra("back_special", z);
    }
}
