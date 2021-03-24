package com.baidu.tbadk.core.atomData;

import android.content.Context;
import com.baidu.tbadk.core.frameworkData.IntentConfig;
/* loaded from: classes3.dex */
public class VideoAggregationActivityConfig extends IntentConfig {
    public static final String PARAM_FROM = "PARAM_FROM";
    public static final String PARAM_ID = "PARAM_FID";
    public static final String PARAM_ST_TYPE = "st_type";
    public static final String PARAM_YUELAOU_LACATION = "yuelaou_locate";
    public static final String TYPE_FROM_FRS = "type_from_frs";
    public static final String TYPE_FROM_VIDEO_CARD = "type_from_video_card";

    public VideoAggregationActivityConfig(Context context, String str, String str2, String str3, String str4) {
        super(context);
        getIntent().putExtra("PARAM_FID", str);
        getIntent().putExtra("PARAM_FROM", str2);
        getIntent().putExtra("st_type", str3);
        getIntent().putExtra("yuelaou_locate", str4);
    }
}
