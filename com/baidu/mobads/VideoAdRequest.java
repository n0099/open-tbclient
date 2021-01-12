package com.baidu.mobads;

import com.baidu.mobads.VideoAdView;
/* loaded from: classes14.dex */
public class VideoAdRequest {

    /* renamed from: a  reason: collision with root package name */
    private VideoAdView.VideoDuration f3287a;

    /* renamed from: b  reason: collision with root package name */
    private boolean f3288b;
    private VideoAdView.VideoSize c;

    private VideoAdRequest(Builder builder) {
        this.f3287a = builder.f3289a;
        this.f3288b = builder.f3290b;
        this.c = builder.c;
    }

    protected int getVideoDuration() {
        return this.f3287a == null ? VideoAdView.VideoDuration.DURATION_15_SECONDS.getValue() : this.f3287a.getValue();
    }

    protected boolean isShowCountdown() {
        return this.f3288b;
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

    /* loaded from: classes14.dex */
    public static class Builder {

        /* renamed from: a  reason: collision with root package name */
        private VideoAdView.VideoDuration f3289a;

        /* renamed from: b  reason: collision with root package name */
        private boolean f3290b = false;
        private VideoAdView.VideoSize c;

        public Builder setVideoDuration(VideoAdView.VideoDuration videoDuration) {
            this.f3289a = videoDuration;
            return this;
        }

        public Builder isShowCountdown(boolean z) {
            this.f3290b = z;
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
