package com.baidu.mobads;

import com.baidu.mobads.VideoAdView;
/* loaded from: classes10.dex */
public class VideoAdRequest {
    private boolean b;
    private VideoAdView.VideoDuration blf;
    private VideoAdView.VideoSize blg;

    private VideoAdRequest(Builder builder) {
        this.blf = builder.blf;
        this.b = builder.b;
        this.blg = builder.blg;
    }

    /* loaded from: classes10.dex */
    public static class Builder {
        private boolean b = false;
        private VideoAdView.VideoDuration blf;
        private VideoAdView.VideoSize blg;

        public Builder setVideoDuration(VideoAdView.VideoDuration videoDuration) {
            this.blf = videoDuration;
            return this;
        }

        public Builder isShowCountdown(boolean z) {
            this.b = z;
            return this;
        }

        public Builder setVideoSize(VideoAdView.VideoSize videoSize) {
            this.blg = videoSize;
            return this;
        }

        public VideoAdRequest build() {
            return new VideoAdRequest(this);
        }
    }
}
