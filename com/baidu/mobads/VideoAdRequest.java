package com.baidu.mobads;

import com.baidu.mobads.VideoAdView;
/* loaded from: classes7.dex */
public class VideoAdRequest {
    private VideoAdView.VideoDuration aJX;
    private VideoAdView.VideoSize aJY;
    private boolean b;

    private VideoAdRequest(Builder builder) {
        this.aJX = builder.aJX;
        this.b = builder.b;
        this.aJY = builder.aJY;
    }

    /* loaded from: classes7.dex */
    public static class Builder {
        private VideoAdView.VideoDuration aJX;
        private VideoAdView.VideoSize aJY;
        private boolean b = false;

        public Builder setVideoDuration(VideoAdView.VideoDuration videoDuration) {
            this.aJX = videoDuration;
            return this;
        }

        public Builder isShowCountdown(boolean z) {
            this.b = z;
            return this;
        }

        public Builder setVideoSize(VideoAdView.VideoSize videoSize) {
            this.aJY = videoSize;
            return this;
        }

        public VideoAdRequest build() {
            return new VideoAdRequest(this);
        }
    }
}
