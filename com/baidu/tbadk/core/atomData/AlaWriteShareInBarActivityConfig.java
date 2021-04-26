package com.baidu.tbadk.core.atomData;

import android.content.Context;
import com.baidu.tbadk.core.data.TransmitForumData;
import com.baidu.tbadk.core.frameworkData.IntentConfig;
import java.util.ArrayList;
/* loaded from: classes3.dex */
public class AlaWriteShareInBarActivityConfig extends IntentConfig {
    public static final String EXTRA_KEY_FORUM_LIST = "extra_key_forum_list";
    public static final String EXTRA_KEY_LIVE_ID = "extra_key_live_id";
    public static final String EXTRA_KEY_YY_ANCHOR_BDUID = "extra_key_yy_anchor_bduid";

    public AlaWriteShareInBarActivityConfig(Context context, ArrayList<TransmitForumData> arrayList, String str, String str2) {
        super(context);
        getIntent().putExtra(EXTRA_KEY_FORUM_LIST, arrayList);
        getIntent().putExtra("extra_key_live_id", str);
        getIntent().putExtra("extra_key_yy_anchor_bduid", str2);
    }
}
