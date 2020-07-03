package com.baidu.live.c;

import android.content.Context;
import com.baidu.live.tbadk.core.frameworkdata.IntentConfig;
/* loaded from: classes3.dex */
public class i extends IntentConfig {
    public i(Context context, String str, String str2, String str3, String str4) {
        super(context);
        getIntent().putExtra("title", str);
        getIntent().putExtra("des", str2);
        getIntent().putExtra("leftbt", str3);
        getIntent().putExtra("rightbt", str4);
    }
}
