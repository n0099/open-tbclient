package com.baidu.tbadk.core.atomData;

import android.content.Context;
import android.content.Intent;
import com.baidu.tbadk.core.frameworkData.IntentConfig;
/* loaded from: classes3.dex */
public class SimpleVideoPlayActivityConfig extends IntentConfig {
    public static final String THUMB_URL = "thumb_url";
    public static final String VIDEO_URL = "video_url";

    /* loaded from: classes3.dex */
    public static final class b {

        /* renamed from: a  reason: collision with root package name */
        public String f12870a;

        /* renamed from: b  reason: collision with root package name */
        public String f12871b;

        public SimpleVideoPlayActivityConfig c(Context context) {
            return new SimpleVideoPlayActivityConfig(context, this);
        }

        public b d(String str) {
            this.f12871b = str;
            return this;
        }

        public b e(String str) {
            this.f12870a = str;
            return this;
        }
    }

    public SimpleVideoPlayActivityConfig(Context context, b bVar) {
        super(context);
        Intent intent;
        if (bVar == null || (intent = getIntent()) == null) {
            return;
        }
        intent.putExtra("video_url", bVar.f12870a);
        intent.putExtra("thumb_url", bVar.f12871b);
    }
}
