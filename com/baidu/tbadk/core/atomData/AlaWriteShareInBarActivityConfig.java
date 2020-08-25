package com.baidu.tbadk.core.atomData;

import android.content.Context;
import com.baidu.tbadk.core.data.TransmitForumData;
import com.baidu.tbadk.core.frameworkData.IntentConfig;
import java.util.ArrayList;
/* loaded from: classes2.dex */
public class AlaWriteShareInBarActivityConfig extends IntentConfig {
    public static final String EXTRA_KEY_FORUM_LIST = "extra_key_forum_list";
    public static final String EXTRA_KEY_LIVE_ID = "extra_key_live_id";

    public AlaWriteShareInBarActivityConfig(Context context, ArrayList<TransmitForumData> arrayList, String str) {
        super(context);
        getIntent().putExtra(EXTRA_KEY_FORUM_LIST, arrayList);
        getIntent().putExtra("extra_key_live_id", str);
    }
}
