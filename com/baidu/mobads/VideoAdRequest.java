package com.baidu.mobads;

import com.baidu.mobads.VideoAdView;
/* loaded from: classes3.dex */
public class VideoAdRequest {

    /* renamed from: a  reason: collision with root package name */
    private VideoAdView.VideoDuration f3324a;

    /* renamed from: b  reason: collision with root package name */
    private boolean f3325b;
    private VideoAdView.VideoSize c;

    private VideoAdRequest(Builder builder) {
        this.f3324a = builder.f3326a;
        this.f3325b = builder.f3327b;
        this.c = builder.c;
    }

    protected int getVideoDuration() {
        return this.f3324a == null ? VideoAdView.VideoDuration.DURATION_15_SECONDS.getValue() : this.f3324a.getValue();
    }

    protected boolean isShowCountdown() {
        return this.f3325b;
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
        private VideoAdView.VideoDuration f3326a;

        /* renamed from: b  reason: collision with root package name */
        private boolean f3327b = false;
        private VideoAdView.VideoSize c;

        public Builder setVideoDuration(VideoAdView.VideoDuration videoDuration) {
            this.f3326a = videoDuration;
            return this;
        }

        public Builder isShowCountdown(boolean z) {
            this.f3327b = z;
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
