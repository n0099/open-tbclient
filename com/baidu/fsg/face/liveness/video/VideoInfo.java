package com.baidu.fsg.face.liveness.video;

import android.media.MediaExtractor;
import android.media.MediaFormat;
import android.os.Parcel;
import android.os.Parcelable;
import android.text.TextUtils;
import com.baidu.fsg.base.utils.LogUtil;
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
        public VideoInfo[] newArray(int i2) {
            return new VideoInfo[i2];
        }
    };

    /* renamed from: a  reason: collision with root package name */
    public String f5943a;

    /* renamed from: b  reason: collision with root package name */
    public int f5944b;

    /* renamed from: c  reason: collision with root package name */
    public int f5945c;

    /* renamed from: d  reason: collision with root package name */
    public int f5946d;

    /* renamed from: e  reason: collision with root package name */
    public long f5947e;

    /* renamed from: f  reason: collision with root package name */
    public int f5948f;

    public VideoInfo() {
    }

    public String a() {
        return this.f5943a;
    }

    public int b() {
        return this.f5944b;
    }

    public int c() {
        return this.f5945c;
    }

    public long d() {
        return this.f5947e;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public int e() {
        return this.f5946d;
    }

    public int f() {
        return this.f5948f;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* renamed from: g */
    public VideoInfo clone() {
        VideoInfo videoInfo = new VideoInfo();
        videoInfo.f5948f = this.f5948f;
        videoInfo.f5946d = this.f5946d;
        videoInfo.f5947e = this.f5947e;
        videoInfo.f5945c = this.f5945c;
        videoInfo.f5944b = this.f5944b;
        videoInfo.f5943a = this.f5943a;
        return videoInfo;
    }

    public String toString() {
        return "VideoInfo{videoPath='" + this.f5943a + "', videoWidth=" + this.f5944b + ", videoHeight=" + this.f5945c + ", frameRate=" + this.f5946d + ", duration=" + this.f5947e + ", videoRotation=" + this.f5948f + '}';
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i2) {
        parcel.writeString(this.f5943a);
        parcel.writeInt(this.f5944b);
        parcel.writeInt(this.f5945c);
        parcel.writeLong(this.f5947e);
        parcel.writeFloat(this.f5946d);
        parcel.writeInt(this.f5948f);
    }

    public VideoInfo(Parcel parcel) {
        this.f5943a = parcel.readString();
        this.f5944b = parcel.readInt();
        this.f5945c = parcel.readInt();
        this.f5947e = parcel.readLong();
        this.f5946d = parcel.readInt();
        this.f5948f = parcel.readInt();
    }

    public void a(String str) {
        this.f5943a = str;
    }

    public void b(int i2) {
        this.f5945c = i2;
    }

    public void c(int i2) {
        this.f5946d = i2;
    }

    public void d(int i2) {
        this.f5948f = i2;
    }

    public void a(int i2) {
        this.f5944b = i2;
    }

    public void a(long j) {
        this.f5947e = j;
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
        for (int i2 = 0; i2 < trackCount; i2++) {
            String string = mediaExtractor.getTrackFormat(i2).getString("mime");
            if (z) {
                if (string.startsWith("audio/")) {
                    return i2;
                }
            } else if (string.startsWith(FileUtils.VIDEO_FILE_START)) {
                return i2;
            }
        }
        return -5;
    }
}
