package com.baidu.mobads;

import com.baidu.mobads.VideoAdView;
/* loaded from: classes20.dex */
public class VideoAdRequest {
    private boolean b;
    private VideoAdView.VideoDuration bDs;
    private VideoAdView.VideoSize bDt;

    private VideoAdRequest(Builder builder) {
        this.bDs = builder.bDs;
        this.b = builder.b;
        this.bDt = builder.bDt;
    }

    /* loaded from: classes20.dex */
    public static class Builder {
        private boolean b = false;
        private VideoAdView.VideoDuration bDs;
        private VideoAdView.VideoSize bDt;

        public Builder setVideoDuration(VideoAdView.VideoDuration videoDuration) {
            this.bDs = videoDuration;
            return this;
        }

        public Builder isShowCountdown(boolean z) {
            this.b = z;
            return this;
        }

        public Builder setVideoSize(VideoAdView.VideoSize videoSize) {
            this.bDt = videoSize;
            return this;
        }

        public VideoAdRequest build() {
            return new VideoAdRequest(this);
        }
    }
}
