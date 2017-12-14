package com.baidu.tbadk.core.atomData;

import android.content.Context;
import com.baidu.tbadk.core.frameworkData.IntentConfig;
/* loaded from: classes.dex */
public class VideoMiddlePageActivityConfig extends IntentConfig {
    public static final String FROM_CONCERN_TAB = "concern_tab";
    public static final String FROM_FRS = "frs";
    public static final String FROM_INDEX = "index";
    public static final String PARAM_FROM = "PARAM_FROM";
    public static final String PARAM_ID = "PARAM_FID";
    public static final String PARAM_ST_TYPE = "st_type";
    public static final String PARAM_YUELAOU_LACATION = "yuelaou_locate";

    public VideoMiddlePageActivityConfig(Context context, String str, String str2, String str3, String str4) {
        super(context);
        getIntent().putExtra("PARAM_FID", str2);
        getIntent().putExtra("st_type", str3);
        getIntent().putExtra("yuelaou_locate", str4);
        getIntent().putExtra("PARAM_FROM", str);
    }
}
