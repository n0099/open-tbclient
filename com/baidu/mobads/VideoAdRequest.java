package com.baidu.mobads;

import com.baidu.mobads.VideoAdView;
/* loaded from: classes3.dex */
public class VideoAdRequest {

    /* renamed from: a  reason: collision with root package name */
    private VideoAdView.VideoDuration f3325a;

    /* renamed from: b  reason: collision with root package name */
    private boolean f3326b;
    private VideoAdView.VideoSize c;

    private VideoAdRequest(Builder builder) {
        this.f3325a = builder.f3327a;
        this.f3326b = builder.f3328b;
        this.c = builder.c;
    }

    protected int getVideoDuration() {
        return this.f3325a == null ? VideoAdView.VideoDuration.DURATION_15_SECONDS.getValue() : this.f3325a.getValue();
    }

    protected boolean isShowCountdown() {
        return this.f3326b;
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

        /* renamed from: a  reason: collision with root package name */
        private VideoAdView.VideoDuration f3327a;

        /* renamed from: b  reason: collision with root package name */
        private boolean f3328b = false;
        private VideoAdView.VideoSize c;

        public Builder setVideoDuration(VideoAdView.VideoDuration videoDuration) {
            this.f3327a = videoDuration;
            return this;
        }

        public Builder isShowCountdown(boolean z) {
            this.f3328b = z;
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
