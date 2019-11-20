package com.baidu.mobads;

import android.content.Context;
import android.widget.RelativeLayout;
import com.baidu.mobads.openad.interfaces.event.IOAdEventListener;
import com.davemorrissey.labs.subscaleview.SubsamplingScaleImageView;
/* loaded from: classes5.dex */
public class VideoAdView extends RelativeLayout {
    private IOAdEventListener aAi;
    private f aAj;

    public VideoAdView(Context context) {
        super(context);
        this.aAi = new m(this);
    }

    /* loaded from: classes5.dex */
    public enum VideoDuration {
        DURATION_15_SECONDS(15),
        DURATION_30_SECONDS(30),
        DURATION_45_SECONDS(45);
        
        private int a;

        VideoDuration(int i) {
            this.a = i;
        }

        protected int getValue() {
            return this.a;
        }
    }

    /* loaded from: classes5.dex */
    public enum VideoSize {
        SIZE_16x9(320, SubsamplingScaleImageView.ORIENTATION_180),
        SIZE_4x3(400, 300);
        
        private int a;
        private int b;

        VideoSize(int i, int i2) {
            this.a = i;
            this.b = i2;
        }

        protected int getWidth() {
            return this.a;
        }

        protected int getHeight() {
            return this.b;
        }
    }

    public static void setAppSid(Context context, String str) {
        AdView.setAppSid(context, str);
    }

    public void setListener(f fVar) {
        this.aAj = fVar;
    }
}
