package com.baidu.tbadk.core.atomData;

import android.content.Context;
import android.content.Intent;
import com.baidu.tbadk.core.frameworkData.IntentConfig;
/* loaded from: classes.dex */
public class ThreadAttitudeActivityConfig extends IntentConfig {
    public static final String FID = "fid";
    public static final String ST_TYPE = "thread_attitude";
    public static final String TID = "tid";

    public ThreadAttitudeActivityConfig(Context context) {
        super(context);
    }

    public ThreadAttitudeActivityConfig createNormalConfig(long j, long j2) {
        Intent intent = getIntent();
        intent.putExtra("tid", j);
        intent.putExtra("fid", j2);
        return this;
    }
}
