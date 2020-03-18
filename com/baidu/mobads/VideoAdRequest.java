package com.baidu.mobads;

import com.baidu.mobads.VideoAdView;
/* loaded from: classes10.dex */
public class VideoAdRequest {
    private VideoAdView.VideoDuration aPj;
    private VideoAdView.VideoSize aPk;
    private boolean b;

    private VideoAdRequest(Builder builder) {
        this.aPj = builder.aPj;
        this.b = builder.b;
        this.aPk = builder.aPk;
    }

    /* loaded from: classes10.dex */
    public static class Builder {
        private VideoAdView.VideoDuration aPj;
        private VideoAdView.VideoSize aPk;
        private boolean b = false;

        public Builder setVideoDuration(VideoAdView.VideoDuration videoDuration) {
            this.aPj = videoDuration;
            return this;
        }

        public Builder isShowCountdown(boolean z) {
            this.b = z;
            return this;
        }

        public Builder setVideoSize(VideoAdView.VideoSize videoSize) {
            this.aPk = videoSize;
            return this;
        }

        public VideoAdRequest build() {
            return new VideoAdRequest(this);
        }
    }
}
