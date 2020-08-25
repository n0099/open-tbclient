package com.baidu.tbadk.core.atomData;

import android.content.Context;
import com.baidu.tbadk.core.frameworkData.IntentConfig;
/* loaded from: classes2.dex */
public class PbChosenActivityConfig extends IntentConfig {
    public static final String KEY_FROM = "from";
    public static final String KEY_SHARE_URL = "share_url";
    public static final String KEY_TAG_CODE = "tag_code";
    public static final String KEY_THREAD_ID = "thread_id";
    public static final String KEY_TID = "ftid";
    public static final int PBCHOSEN_FROM_NATIVE = 1;
    public static final int PBCHOSEN_FROM_PUSH = 2;

    public PbChosenActivityConfig(Context context, long j, String str) {
        this(context, j, str, 1);
    }

    public PbChosenActivityConfig(Context context, long j, String str, int i) {
        this(context, j, 0L, 0L, str, i);
    }

    public PbChosenActivityConfig(Context context, long j, long j2, long j3, String str, int i) {
        super(context);
        getIntent().putExtra(KEY_TID, j);
        getIntent().putExtra(KEY_SHARE_URL, str);
        getIntent().putExtra("from", i);
        getIntent().putExtra(KEY_TAG_CODE, j2);
        getIntent().putExtra("thread_id", j3);
    }
}
