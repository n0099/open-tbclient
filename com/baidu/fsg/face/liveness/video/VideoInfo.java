package com.baidu.fsg.face.liveness.video;

import android.media.MediaExtractor;
import android.media.MediaFormat;
import android.os.Parcel;
import android.os.Parcelable;
import android.text.TextUtils;
import com.baidu.fsg.base.utils.LogUtil;
import com.kwai.video.player.misc.IMediaFormat;
import com.sina.weibo.sdk.utils.FileUtils;
/* loaded from: classes2.dex */
public class VideoInfo implements Parcelable {
    public static final Parcelable.Creator<VideoInfo> CREATOR = new Parcelable.Creator<VideoInfo>() { // from class: com.baidu.fsg.face.liveness.video.VideoInfo.1
        /* JADX DEBUG: Method merged with bridge method */
        @Override // android.os.Parcelable.Creator
        /* renamed from: a */
        public VideoInfo createFromParcel(Parcel parcel) {
            return new VideoInfo(parcel);
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // android.os.Parcelable.Creator
        /* renamed from: a */
        public VideoInfo[] newArray(int i) {
            return new VideoInfo[i];
        }
    };

    /* renamed from: a  reason: collision with root package name */
    public String f5987a;

    /* renamed from: b  reason: collision with root package name */
    public int f5988b;

    /* renamed from: c  reason: collision with root package name */
    public int f5989c;

    /* renamed from: d  reason: collision with root package name */
    public int f5990d;

    /* renamed from: e  reason: collision with root package name */
    public long f5991e;

    /* renamed from: f  reason: collision with root package name */
    public int f5992f;

    public VideoInfo() {
    }

    public String a() {
        return this.f5987a;
    }

    public int b() {
        return this.f5988b;
    }

    public int c() {
        return this.f5989c;
    }

    public long d() {
        return this.f5991e;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public int e() {
        return this.f5990d;
    }

    public int f() {
        return this.f5992f;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* renamed from: g */
    public VideoInfo clone() {
        VideoInfo videoInfo = new VideoInfo();
        videoInfo.f5992f = this.f5992f;
        videoInfo.f5990d = this.f5990d;
        videoInfo.f5991e = this.f5991e;
        videoInfo.f5989c = this.f5989c;
        videoInfo.f5988b = this.f5988b;
        videoInfo.f5987a = this.f5987a;
        return videoInfo;
    }

    public String toString() {
        return "VideoInfo{videoPath='" + this.f5987a + "', videoWidth=" + this.f5988b + ", videoHeight=" + this.f5989c + ", frameRate=" + this.f5990d + ", duration=" + this.f5991e + ", videoRotation=" + this.f5992f + '}';
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(this.f5987a);
        parcel.writeInt(this.f5988b);
        parcel.writeInt(this.f5989c);
        parcel.writeLong(this.f5991e);
        parcel.writeFloat(this.f5990d);
        parcel.writeInt(this.f5992f);
    }

    public VideoInfo(Parcel parcel) {
        this.f5987a = parcel.readString();
        this.f5988b = parcel.readInt();
        this.f5989c = parcel.readInt();
        this.f5991e = parcel.readLong();
        this.f5990d = parcel.readInt();
        this.f5992f = parcel.readInt();
    }

    public void a(String str) {
        this.f5987a = str;
    }

    public void b(int i) {
        this.f5989c = i;
    }

    public void c(int i) {
        this.f5990d = i;
    }

    public void d(int i) {
        this.f5992f = i;
    }

    public void a(int i) {
        this.f5988b = i;
    }

    public void a(long j) {
        this.f5991e = j;
    }

    public static void a(String str, VideoInfo videoInfo) {
        if (TextUtils.isEmpty(str) || videoInfo == null) {
            return;
        }
        videoInfo.a(str);
        MediaExtractor mediaExtractor = new MediaExtractor();
        try {
            try {
                mediaExtractor.setDataSource(str);
                MediaFormat trackFormat = mediaExtractor.getTrackFormat(a(mediaExtractor, false));
                videoInfo.c(trackFormat.containsKey("frame-rate") ? trackFormat.getInteger("frame-rate") : 0);
                videoInfo.a(trackFormat.containsKey("durationUs") ? trackFormat.getLong("durationUs") / 1000 : 0L);
                videoInfo.a(trackFormat.getInteger("width"));
                videoInfo.b(trackFormat.getInteger("height"));
                videoInfo.d(trackFormat.containsKey("rotation-degrees") ? trackFormat.getInteger("rotation-degrees") : 0);
            } catch (Exception e2) {
                LogUtil.e(e2.toString());
            }
        } finally {
            mediaExtractor.release();
        }
    }

    public static int a(MediaExtractor mediaExtractor, boolean z) {
        int trackCount = mediaExtractor.getTrackCount();
        for (int i = 0; i < trackCount; i++) {
            String string = mediaExtractor.getTrackFormat(i).getString(IMediaFormat.KEY_MIME);
            if (z) {
                if (string.startsWith("audio/")) {
                    return i;
                }
            } else if (string.startsWith(FileUtils.VIDEO_FILE_START)) {
                return i;
            }
        }
        return -5;
    }
}
