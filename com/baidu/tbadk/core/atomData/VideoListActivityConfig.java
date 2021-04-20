package com.baidu.tbadk.core.atomData;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import com.alibaba.fastjson.asm.Label;
import com.baidu.tbadk.core.frameworkData.IntentConfig;
import d.b.c.e.p.k;
/* loaded from: classes3.dex */
public class VideoListActivityConfig extends IntentConfig {
    public static final String KEY_FORUM_ID = "KEY_FORUM_ID";
    public static final String KEY_SOURCE = "KEY_SOURCE";
    public static final String KEY_THREAD_ID = "KEY_THREAD_ID";
    public Context mContext;

    public VideoListActivityConfig(Context context) {
        super(context);
        this.mContext = context;
    }

    public VideoListActivityConfig createNormalCfg(String str, String str2, String str3) {
        if (str2 == null) {
            return this;
        }
        Intent intent = getIntent();
        intent.putExtra(KEY_FORUM_ID, str);
        intent.putExtra(KEY_THREAD_ID, str2);
        if (!k.isEmpty(str3)) {
            intent.putExtra(KEY_SOURCE, str3);
        }
        if (!(this.mContext instanceof Activity)) {
            intent.addFlags(Label.FORWARD_REFERENCE_TYPE_SHORT);
        }
        return this;
    }

    public VideoListActivityConfig createNormalCfg(long j, String str) {
        Intent intent = getIntent();
        intent.putExtra("user_id", j);
        if (!k.isEmpty(str)) {
            intent.putExtra(KEY_SOURCE, str);
        }
        if (!(this.mContext instanceof Activity)) {
            intent.addFlags(Label.FORWARD_REFERENCE_TYPE_SHORT);
        }
        return this;
    }
}
