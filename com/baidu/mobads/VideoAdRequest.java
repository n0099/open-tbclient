package com.baidu.mobads;

import com.baidu.mobads.VideoAdView;
/* loaded from: classes20.dex */
public class VideoAdRequest {
    private boolean b;
    private VideoAdView.VideoDuration bxK;
    private VideoAdView.VideoSize bxL;

    private VideoAdRequest(Builder builder) {
        this.bxK = builder.bxK;
        this.b = builder.b;
        this.bxL = builder.bxL;
    }

    /* loaded from: classes20.dex */
    public static class Builder {
        private boolean b = false;
        private VideoAdView.VideoDuration bxK;
        private VideoAdView.VideoSize bxL;

        public Builder setVideoDuration(VideoAdView.VideoDuration videoDuration) {
            this.bxK = videoDuration;
            return this;
        }

        public Builder isShowCountdown(boolean z) {
            this.b = z;
            return this;
        }

        public Builder setVideoSize(VideoAdView.VideoSize videoSize) {
            this.bxL = videoSize;
            return this;
        }

        public VideoAdRequest build() {
            return new VideoAdRequest(this);
        }
    }
}
