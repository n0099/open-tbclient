package com.baidu.mobads;

import com.baidu.mobads.VideoAdView;
/* loaded from: classes10.dex */
public class VideoAdRequest {
    private VideoAdView.VideoDuration aOV;
    private VideoAdView.VideoSize aOW;
    private boolean b;

    private VideoAdRequest(Builder builder) {
        this.aOV = builder.aOV;
        this.b = builder.b;
        this.aOW = builder.aOW;
    }

    /* loaded from: classes10.dex */
    public static class Builder {
        private VideoAdView.VideoDuration aOV;
        private VideoAdView.VideoSize aOW;
        private boolean b = false;

        public Builder setVideoDuration(VideoAdView.VideoDuration videoDuration) {
            this.aOV = videoDuration;
            return this;
        }

        public Builder isShowCountdown(boolean z) {
            this.b = z;
            return this;
        }

        public Builder setVideoSize(VideoAdView.VideoSize videoSize) {
            this.aOW = videoSize;
            return this;
        }

        public VideoAdRequest build() {
            return new VideoAdRequest(this);
        }
    }
}
