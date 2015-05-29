package com.baidu.tbadk.core.atomData;

import android.content.Context;
import com.baidu.tbadk.core.frameworkData.c;
/* loaded from: classes.dex */
public class PbChosenActivityConfig extends c {
    public static final String KEY_FROM = "from";
    public static final String KEY_SHARE_URL = "share_url";
    public static final String KEY_TID = "ftid";
    public static final int PBCHOSEN_FROM_NATIVE = 1;
    public static final int PBCHOSEN_FROM_PUSH = 2;

    public PbChosenActivityConfig(Context context, long j, String str) {
        this(context, j, str, 1);
    }

    public PbChosenActivityConfig(Context context, long j, String str, int i) {
        super(context);
        getIntent().putExtra(KEY_TID, j);
        getIntent().putExtra(KEY_SHARE_URL, str);
        getIntent().putExtra("from", i);
    }
}
