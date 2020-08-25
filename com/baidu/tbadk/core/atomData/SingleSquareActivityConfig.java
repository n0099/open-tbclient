package com.baidu.tbadk.core.atomData;

import android.content.Context;
import com.baidu.live.tbadk.pagestayduration.PageStayDurationHelper;
import com.baidu.tbadk.core.frameworkData.IntentConfig;
import java.net.URLEncoder;
/* loaded from: classes2.dex */
public class SingleSquareActivityConfig extends IntentConfig {
    public static final String BACK_SPECIAL = "back_special";
    public static final String PAGE_NAME = "square_page";
    public static final String START_FROM = "start_from";

    public SingleSquareActivityConfig(Context context) {
        super(context);
    }

    public SingleSquareActivityConfig(Context context, String str, boolean z) {
        super(context);
        getIntent().putExtra("start_from", str);
        getIntent().putExtra("back_special", z);
    }

    public static String makeStatisticsParam(String str, String str2) {
        StringBuilder sb = new StringBuilder();
        sb.append(PAGE_NAME);
        try {
            sb.append(URLEncoder.encode("|", "utf-8"));
        } catch (Exception e) {
            e.printStackTrace();
            sb.append("|");
        }
        sb.append(str + PageStayDurationHelper.STAT_SOURCE_TRACE_CONNECTORS + str2);
        return sb.toString();
    }
}
