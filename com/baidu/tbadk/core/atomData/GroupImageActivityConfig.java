package com.baidu.tbadk.core.atomData;

import android.content.Context;
import com.baidu.tbadk.core.frameworkData.IntentConfig;
import com.baidu.tbadk.coreExtra.view.ImageUrlData;
import java.util.ArrayList;
import java.util.HashMap;
/* loaded from: classes.dex */
public class GroupImageActivityConfig extends IntentConfig {
    public GroupImageActivityConfig(Context context, String str, ArrayList<String> arrayList, long j) {
        super(context);
        getIntent().putExtra("curImgUrl", str);
        getIntent().putExtra("groupId", String.valueOf(j));
        getIntent().putExtra("url", arrayList);
    }

    public GroupImageActivityConfig(Context context, String str, ArrayList<String> arrayList, long j, HashMap<String, ImageUrlData> hashMap) {
        super(context);
        getIntent().putExtra("curImgUrl", str);
        getIntent().putExtra("groupId", String.valueOf(j));
        getIntent().putExtra("url", arrayList);
        getIntent().putExtra("assistUrls", hashMap);
    }
}
