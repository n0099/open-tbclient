package com.baidu.mobads;

import com.baidu.mobads.VideoAdView;
/* loaded from: classes10.dex */
public class VideoAdRequest {
    private boolean b;
    private VideoAdView.VideoDuration bsB;
    private VideoAdView.VideoSize bsC;

    private VideoAdRequest(Builder builder) {
        this.bsB = builder.bsB;
        this.b = builder.b;
        this.bsC = builder.bsC;
    }

    /* loaded from: classes10.dex */
    public static class Builder {
        private boolean b = false;
        private VideoAdView.VideoDuration bsB;
        private VideoAdView.VideoSize bsC;

        public Builder setVideoDuration(VideoAdView.VideoDuration videoDuration) {
            this.bsB = videoDuration;
            return this;
        }

        public Builder isShowCountdown(boolean z) {
            this.b = z;
            return this;
        }

        public Builder setVideoSize(VideoAdView.VideoSize videoSize) {
            this.bsC = videoSize;
            return this;
        }

        public VideoAdRequest build() {
            return new VideoAdRequest(this);
        }
    }
}
