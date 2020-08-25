package com.baidu.tbadk.core.atomData;

import android.content.Context;
import com.baidu.tbadk.core.frameworkData.IntentAction;
import com.baidu.tbadk.core.frameworkData.IntentConfig;
import com.baidu.tbadk.data.BazhuInfoData;
import java.util.ArrayList;
/* loaded from: classes2.dex */
public class SelectSingleForumActivityConfig extends IntentConfig {
    public static final String KEY_INPUT_FORUM_LIST = "KEY_INTPUT_FORUM_LIST";
    public static final String KEY_OUTPUT_FORUM = "KEY_OUTPUT_FORUM";

    public SelectSingleForumActivityConfig(Context context, int i) {
        super(context);
        setRequestCode(i);
        setIntentAction(IntentAction.ActivityForResult);
    }

    public void setForumList(ArrayList<BazhuInfoData.BaInfo> arrayList) {
        if (getIntent() != null) {
            getIntent().putParcelableArrayListExtra("KEY_INTPUT_FORUM_LIST", arrayList);
        }
    }
}
