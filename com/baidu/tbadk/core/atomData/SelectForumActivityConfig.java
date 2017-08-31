package com.baidu.tbadk.core.atomData;

import android.content.Context;
import com.baidu.tbadk.core.data.TransmitForumData;
import com.baidu.tbadk.core.frameworkData.IntentAction;
import com.baidu.tbadk.core.frameworkData.IntentConfig;
import java.util.ArrayList;
/* loaded from: classes.dex */
public class SelectForumActivityConfig extends IntentConfig {
    public static final String EXTRA_KEY_FROM = "extra_key_from";
    public static final String EXTRA_KEY_LIVE_ID = "extra_key_live_id";
    public static final int FROM_SHARE = 1;
    public static final String KEY_INPUT_FORUM_LIST = "KEY_INTPUT_FORUM_LIST";
    public static final String KEY_OUTPUT_FORUM_LIST = "KEY_OUTPUT_FORUM_LIST";

    public SelectForumActivityConfig(Context context, int i) {
        super(context);
        setRequestCode(i);
        setIntentAction(IntentAction.ActivityForResult);
    }

    public void setForumList(ArrayList<TransmitForumData> arrayList) {
        if (getIntent() != null) {
            getIntent().putParcelableArrayListExtra("KEY_INTPUT_FORUM_LIST", arrayList);
        }
    }

    public void setFrom(int i) {
        if (getIntent() != null) {
            getIntent().putExtra("extra_key_from", i);
        }
    }

    public void setLiveId(long j) {
        if (getIntent() != null) {
            getIntent().putExtra("extra_key_live_id", j);
        }
    }
}
