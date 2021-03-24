package com.baidu.tbadk.core.atomData;

import android.content.Context;
import android.content.Intent;
import com.baidu.tbadk.core.frameworkData.IntentConfig;
import com.baidu.tbadk.data.VideoEasterEggData;
/* loaded from: classes3.dex */
public class VideoEasterEggActivityConfig extends IntentConfig {
    public static final String FROM_FRS = "from_frs";
    public static final String FROM_HOTTOPIC = "from_hottopic";
    public static final String FROM_MAINTAB = "from_maintab";
    public static final String FROM_PERSON = "from_person";

    public VideoEasterEggActivityConfig(Context context) {
        super(context);
    }

    public VideoEasterEggActivityConfig createNormalConfig(String str, VideoEasterEggData videoEasterEggData) {
        Intent intent = getIntent();
        intent.putExtra("from", str);
        intent.putExtra(IntentConfig.VIDEO_EASTER_EGG_DATA, videoEasterEggData);
        return this;
    }
}
