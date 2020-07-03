package com.baidu.mobads;

import com.baidu.mobads.VideoAdView;
/* loaded from: classes10.dex */
public class VideoAdRequest {
    private boolean b;
    private VideoAdView.VideoDuration bxv;
    private VideoAdView.VideoSize bxw;

    private VideoAdRequest(Builder builder) {
        this.bxv = builder.bxv;
        this.b = builder.b;
        this.bxw = builder.bxw;
    }

    /* loaded from: classes10.dex */
    public static class Builder {
        private boolean b = false;
        private VideoAdView.VideoDuration bxv;
        private VideoAdView.VideoSize bxw;

        public Builder setVideoDuration(VideoAdView.VideoDuration videoDuration) {
            this.bxv = videoDuration;
            return this;
        }

        public Builder isShowCountdown(boolean z) {
            this.b = z;
            return this;
        }

        public Builder setVideoSize(VideoAdView.VideoSize videoSize) {
            this.bxw = videoSize;
            return this;
        }

        public VideoAdRequest build() {
            return new VideoAdRequest(this);
        }
    }
}
