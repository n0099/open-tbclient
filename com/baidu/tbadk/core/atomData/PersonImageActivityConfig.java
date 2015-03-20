package com.baidu.tbadk.core.atomData;

import android.content.Context;
import com.baidu.tbadk.core.frameworkData.a;
import com.baidu.tbadk.coreExtra.view.ImageUrlData;
import java.util.HashMap;
/* loaded from: classes.dex */
public class PersonImageActivityConfig extends a {
    public PersonImageActivityConfig(Context context, String str) {
        super(context);
        getIntent().putExtra("curImgUrl", str);
    }

    public PersonImageActivityConfig(Context context, String str, HashMap<String, ImageUrlData> hashMap) {
        super(context);
        getIntent().putExtra("curImgUrl", str);
        getIntent().putExtra("assistUrls", hashMap);
    }
}
