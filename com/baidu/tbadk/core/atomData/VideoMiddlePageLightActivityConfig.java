package com.baidu.tbadk.core.atomData;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import com.baidu.tbadk.core.frameworkData.IntentConfig;
import com.baidu.tieba.play.monitor.VideoSerializeVideoThreadInfo;
/* loaded from: classes3.dex */
public class VideoMiddlePageLightActivityConfig extends IntentConfig {
    public static final String FROM_CONCERN_TAB = "concern_tab";
    public static final String FROM_FRS = "frs";
    public static final String FROM_HOTTOPIC = "hottopic";
    public static final String FROM_INDEX = "index";
    public static final String KEY_NID = "key_nid";
    public static final String PARAM_FROM = "PARAM_FROM";
    public static final String PARAM_ID = "PARAM_FID";
    public static final String PARAM_ST_TYPE = "st_type";
    public static final String PARAM_VIDEO_THREAD_INFO = "param_video_thread_info";
    public static final String PARAM_YUELAOU_LACATION = "yuelaou_locate";

    public VideoMiddlePageLightActivityConfig(Context context, String str, String str2, VideoSerializeVideoThreadInfo videoSerializeVideoThreadInfo) {
        super(context);
        getIntent().putExtra("PARAM_FID", str2);
        getIntent().putExtra("PARAM_FROM", str);
        getIntent().putExtra("param_video_thread_info", videoSerializeVideoThreadInfo);
    }

    public void setNid(String str) {
        if (getIntent() != null) {
            getIntent().putExtra("key_nid", str);
        }
    }

    public void setUri(Uri uri) {
        Intent intent = getIntent();
        if (intent != null) {
            intent.putExtra(IntentConfig.KEY_URI, uri);
        }
    }

    public VideoMiddlePageLightActivityConfig(Context context, String str, String str2, String str3, String str4) {
        super(context);
        getIntent().putExtra("PARAM_FID", str2);
        getIntent().putExtra("st_type", str3);
        getIntent().putExtra("yuelaou_locate", str4);
        getIntent().putExtra("PARAM_FROM", str);
    }

    public VideoMiddlePageLightActivityConfig(Context context, String str, String str2, String str3, String str4, VideoSerializeVideoThreadInfo videoSerializeVideoThreadInfo) {
        this(context, str, str2, str3, str4);
        getIntent().putExtra("param_video_thread_info", videoSerializeVideoThreadInfo);
    }
}
