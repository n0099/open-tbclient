package com.baidu.mobads;

import com.baidu.mobads.VideoAdView;
/* loaded from: classes20.dex */
public class VideoAdRequest {
    private boolean b;
    private VideoAdView.VideoDuration bDv;
    private VideoAdView.VideoSize bDw;

    private VideoAdRequest(Builder builder) {
        this.bDv = builder.bDv;
        this.b = builder.b;
        this.bDw = builder.bDw;
    }

    /* loaded from: classes20.dex */
    public static class Builder {
        private boolean b = false;
        private VideoAdView.VideoDuration bDv;
        private VideoAdView.VideoSize bDw;

        public Builder setVideoDuration(VideoAdView.VideoDuration videoDuration) {
            this.bDv = videoDuration;
            return this;
        }

        public Builder isShowCountdown(boolean z) {
            this.b = z;
            return this;
        }

        public Builder setVideoSize(VideoAdView.VideoSize videoSize) {
            this.bDw = videoSize;
            return this;
        }

        public VideoAdRequest build() {
            return new VideoAdRequest(this);
        }
    }
}
