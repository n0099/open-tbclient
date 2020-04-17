package com.baidu.mobads;

import com.baidu.mobads.VideoAdView;
/* loaded from: classes10.dex */
public class VideoAdRequest {
    private boolean b;
    private VideoAdView.VideoDuration bla;
    private VideoAdView.VideoSize blb;

    private VideoAdRequest(Builder builder) {
        this.bla = builder.bla;
        this.b = builder.b;
        this.blb = builder.blb;
    }

    /* loaded from: classes10.dex */
    public static class Builder {
        private boolean b = false;
        private VideoAdView.VideoDuration bla;
        private VideoAdView.VideoSize blb;

        public Builder setVideoDuration(VideoAdView.VideoDuration videoDuration) {
            this.bla = videoDuration;
            return this;
        }

        public Builder isShowCountdown(boolean z) {
            this.b = z;
            return this;
        }

        public Builder setVideoSize(VideoAdView.VideoSize videoSize) {
            this.blb = videoSize;
            return this;
        }

        public VideoAdRequest build() {
            return new VideoAdRequest(this);
        }
    }
}
