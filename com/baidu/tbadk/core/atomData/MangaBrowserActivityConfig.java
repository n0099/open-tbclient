package com.baidu.tbadk.core.atomData;

import android.content.Context;
import com.baidu.tbadk.core.frameworkData.IntentConfig;
/* loaded from: classes.dex */
public class MangaBrowserActivityConfig extends IntentConfig {
    public static final int BROWSER_FORM_FRS_HEAD = 4;
    public static final int BROWSER_FROM_BOOK_COVER = 1;
    public static final int BROWSER_FROM_COLLECTION = 3;
    public static final int BROWSER_FROM_DOWN_LIST = 7;
    public static final int BROWSER_FROM_FRS_LIST = 2;
    public static final int BROWSER_FROM_MY_LIKE = 6;
    public static final int BROWSER_FROM_PERSON_INFO = 5;
    public static final String CARTOON_ID = "cartoon_id";
    public static final String CHAPTER_ID = "chapter_id";

    public MangaBrowserActivityConfig(Context context, long j, int i, int i2) {
        super(context);
        getIntent().putExtra("cartoon_id", j);
        getIntent().putExtra(CHAPTER_ID, i);
        getIntent().putExtra("from", i2);
    }
}
