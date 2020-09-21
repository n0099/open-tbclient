package com.baidu.mobads;

import com.baidu.mobads.VideoAdView;
/* loaded from: classes3.dex */
public class VideoAdRequest {
    private VideoAdView.VideoDuration a;
    private boolean b;
    private VideoAdView.VideoSize c;

    private VideoAdRequest(Builder builder) {
        this.a = builder.a;
        this.b = builder.b;
        this.c = builder.c;
    }

    protected int getVideoDuration() {
        return this.a == null ? VideoAdView.VideoDuration.DURATION_15_SECONDS.getValue() : this.a.getValue();
    }

    protected boolean isShowCountdown() {
        return this.b;
    }

    protected int getVideoWidth() {
        if (this.c == null) {
            this.c = VideoAdView.VideoSize.SIZE_16x9;
        }
        return this.c.getWidth();
    }

    protected int getVideoHeight() {
        if (this.c == null) {
            this.c = VideoAdView.VideoSize.SIZE_16x9;
        }
        return this.c.getHeight();
    }

    /* loaded from: classes3.dex */
    public static class Builder {
        private VideoAdView.VideoDuration a;
        private boolean b = false;
        private VideoAdView.VideoSize c;

        public Builder setVideoDuration(VideoAdView.VideoDuration videoDuration) {
            this.a = videoDuration;
            return this;
        }

        public Builder isShowCountdown(boolean z) {
            this.b = z;
            return this;
        }

        public Builder setVideoSize(VideoAdView.VideoSize videoSize) {
            this.c = videoSize;
            return this;
        }

        public VideoAdRequest build() {
            return new VideoAdRequest(this);
        }
    }
}
