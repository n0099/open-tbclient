package com.baidu.tbadk.core.atomData;

import android.content.Context;
/* loaded from: classes.dex */
public class x extends cc {
    public x(Context context, String str, String str2, String str3, boolean z) {
        super(context, str, str2, z);
        getIntent().putExtra("tag_game_id", str3);
    }
}
