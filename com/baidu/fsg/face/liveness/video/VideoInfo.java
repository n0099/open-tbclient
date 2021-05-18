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
    public String f6043a;

    /* renamed from: b  reason: collision with root package name */
    public int f6044b;

    /* renamed from: c  reason: collision with root package name */
    public int f6045c;

    /* renamed from: d  reason: collision with root package name */
    public int f6046d;

    /* renamed from: e  reason: collision with root package name */
    public long f6047e;

    /* renamed from: f  reason: collision with root package name */
    public int f6048f;

    public VideoInfo() {
    }

    public String a() {
        return this.f6043a;
    }

    public int b() {
        return this.f6044b;
    }

    public int c() {
        return this.f6045c;
    }

    public long d() {
        return this.f6047e;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public int e() {
        return this.f6046d;
    }

    public int f() {
        return this.f6048f;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* renamed from: g */
    public VideoInfo clone() {
        VideoInfo videoInfo = new VideoInfo();
        videoInfo.f6048f = this.f6048f;
        videoInfo.f6046d = this.f6046d;
        videoInfo.f6047e = this.f6047e;
        videoInfo.f6045c = this.f6045c;
        videoInfo.f6044b = this.f6044b;
        videoInfo.f6043a = this.f6043a;
        return videoInfo;
    }

    public String toString() {
        return "VideoInfo{videoPath='" + this.f6043a + "', videoWidth=" + this.f6044b + ", videoHeight=" + this.f6045c + ", frameRate=" + this.f6046d + ", duration=" + this.f6047e + ", videoRotation=" + this.f6048f + '}';
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i2) {
        parcel.writeString(this.f6043a);
        parcel.writeInt(this.f6044b);
        parcel.writeInt(this.f6045c);
        parcel.writeLong(this.f6047e);
        parcel.writeFloat(this.f6046d);
        parcel.writeInt(this.f6048f);
    }

    public VideoInfo(Parcel parcel) {
        this.f6043a = parcel.readString();
        this.f6044b = parcel.readInt();
        this.f6045c = parcel.readInt();
        this.f6047e = parcel.readLong();
        this.f6046d = parcel.readInt();
        this.f6048f = parcel.readInt();
    }

    public void a(String str) {
        this.f6043a = str;
    }

    public void b(int i2) {
        this.f6045c = i2;
    }

    public void c(int i2) {
        this.f6046d = i2;
    }

    public void d(int i2) {
        this.f6048f = i2;
    }

    public void a(int i2) {
        this.f6044b = i2;
    }

    public void a(long j) {
        this.f6047e = j;
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
