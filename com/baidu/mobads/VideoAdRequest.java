package com.baidu.mobads;

import com.baidu.mobads.VideoAdView;
/* loaded from: classes8.dex */
public class VideoAdRequest {
    private VideoAdView.VideoDuration aKP;
    private VideoAdView.VideoSize aKQ;
    private boolean b;

    private VideoAdRequest(Builder builder) {
        this.aKP = builder.aKP;
        this.b = builder.b;
        this.aKQ = builder.aKQ;
    }

    /* loaded from: classes8.dex */
    public static class Builder {
        private VideoAdView.VideoDuration aKP;
        private VideoAdView.VideoSize aKQ;
        private boolean b = false;

        public Builder setVideoDuration(VideoAdView.VideoDuration videoDuration) {
            this.aKP = videoDuration;
            return this;
        }

        public Builder isShowCountdown(boolean z) {
            this.b = z;
            return this;
        }

        public Builder setVideoSize(VideoAdView.VideoSize videoSize) {
            this.aKQ = videoSize;
            return this;
        }

        public VideoAdRequest build() {
            return new VideoAdRequest(this);
        }
    }
}
