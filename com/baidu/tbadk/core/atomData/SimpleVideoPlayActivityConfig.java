package com.baidu.tbadk.core.atomData;

import android.content.Context;
import android.content.Intent;
import com.baidu.tbadk.core.frameworkData.IntentConfig;
/* loaded from: classes.dex */
public class SimpleVideoPlayActivityConfig extends IntentConfig {
    public static final String THUMB_URL = "thumb_url";
    public static final String VIDEO_URL = "video_url";

    private SimpleVideoPlayActivityConfig(Context context, a aVar) {
        super(context);
        Intent intent;
        if (aVar != null && (intent = getIntent()) != null) {
            intent.putExtra("video_url", aVar.videoUrl);
            intent.putExtra("thumb_url", aVar.thumbUrl);
        }
    }

    /* loaded from: classes.dex */
    public static final class a {
        private String thumbUrl;
        private String videoUrl;

        public a zy(String str) {
            this.videoUrl = str;
            return this;
        }

        public a zz(String str) {
            this.thumbUrl = str;
            return this;
        }

        public SimpleVideoPlayActivityConfig eR(Context context) {
            return new SimpleVideoPlayActivityConfig(context, this);
        }
    }
}
