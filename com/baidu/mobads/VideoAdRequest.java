package com.baidu.mobads;

import com.baidu.mobads.VideoAdView;
/* loaded from: classes10.dex */
public class VideoAdRequest {
    private VideoAdView.VideoDuration aOU;
    private VideoAdView.VideoSize aOV;
    private boolean b;

    private VideoAdRequest(Builder builder) {
        this.aOU = builder.aOU;
        this.b = builder.b;
        this.aOV = builder.aOV;
    }

    /* loaded from: classes10.dex */
    public static class Builder {
        private VideoAdView.VideoDuration aOU;
        private VideoAdView.VideoSize aOV;
        private boolean b = false;

        public Builder setVideoDuration(VideoAdView.VideoDuration videoDuration) {
            this.aOU = videoDuration;
            return this;
        }

        public Builder isShowCountdown(boolean z) {
            this.b = z;
            return this;
        }

        public Builder setVideoSize(VideoAdView.VideoSize videoSize) {
            this.aOV = videoSize;
            return this;
        }

        public VideoAdRequest build() {
            return new VideoAdRequest(this);
        }
    }
}
