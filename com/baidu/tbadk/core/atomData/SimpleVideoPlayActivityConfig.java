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

        public a zP(String str) {
            this.videoUrl = str;
            return this;
        }

        public a zQ(String str) {
            this.thumbUrl = str;
            return this;
        }

        public SimpleVideoPlayActivityConfig eQ(Context context) {
            return new SimpleVideoPlayActivityConfig(context, this);
        }
    }
}
