package com.baidu.tbadk.core.atomData;

import android.content.Context;
import com.baidu.tbadk.core.frameworkData.IntentConfig;
/* loaded from: classes2.dex */
public class BigImgPbActivityConfig extends IntentConfig {
    public static final String BIGPB_URL = "http://tieba.baidu.com/n/drift-bottle/detail";
    public static final String BIG_PB_TID = "big_pb_tid";
    public static final String BIG_PB_USER_NAME = "user_name=";
    public static final String JUHE_URL = "http://tieba.baidu.com/n/drift-bottle/home";
    public static final String MY_BOTTLE_URL = "http://tieba.baidu.com/n/drift-bottle/personal-bottle";
    public static final String OPEN_COMMON = "open_common=";
    public static final String TYPE_RESOURCE = "type_resource";
    public static final int TYPE_RESOURCE_FOR_BIGPB = 1;
    public static final int TYPE_RESOURCE_FOR_JUHE = 2;
    public static final int TYPE_RESOURCE_FOR_MYBOTTLE = 3;

    public BigImgPbActivityConfig(Context context) {
        super(context);
        getIntent().putExtra(TYPE_RESOURCE, 2);
    }

    public BigImgPbActivityConfig(Context context, String str) {
        super(context);
        getIntent().putExtra(TYPE_RESOURCE, 1);
        getIntent().putExtra(BIG_PB_TID, str);
    }
}
