package com.baidu.mobads;

import com.baidu.mobads.VideoAdView;
/* loaded from: classes10.dex */
public class VideoAdRequest {
    private VideoAdView.VideoDuration aOT;
    private VideoAdView.VideoSize aOU;
    private boolean b;

    private VideoAdRequest(Builder builder) {
        this.aOT = builder.aOT;
        this.b = builder.b;
        this.aOU = builder.aOU;
    }

    /* loaded from: classes10.dex */
    public static class Builder {
        private VideoAdView.VideoDuration aOT;
        private VideoAdView.VideoSize aOU;
        private boolean b = false;

        public Builder setVideoDuration(VideoAdView.VideoDuration videoDuration) {
            this.aOT = videoDuration;
            return this;
        }

        public Builder isShowCountdown(boolean z) {
            this.b = z;
            return this;
        }

        public Builder setVideoSize(VideoAdView.VideoSize videoSize) {
            this.aOU = videoSize;
            return this;
        }

        public VideoAdRequest build() {
            return new VideoAdRequest(this);
        }
    }
}
