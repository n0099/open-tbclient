package com.baidu.tbadk.core.atomData;

import android.content.Context;
import com.baidu.tbadk.core.frameworkData.a;
import java.util.ArrayList;
/* loaded from: classes.dex */
public class GroupImageActivityConfig extends a {
    public GroupImageActivityConfig(Context context, String str, ArrayList<String> arrayList, long j) {
        super(context);
        getIntent().putExtra("curImgUrl", str);
        getIntent().putExtra("groupId", String.valueOf(j));
        getIntent().putExtra(ImageViewerConfig.URL, arrayList);
    }
}
