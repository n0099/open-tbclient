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
    public String f6189a;

    /* renamed from: b  reason: collision with root package name */
    public int f6190b;

    /* renamed from: c  reason: collision with root package name */
    public int f6191c;

    /* renamed from: d  reason: collision with root package name */
    public int f6192d;

    /* renamed from: e  reason: collision with root package name */
    public long f6193e;

    /* renamed from: f  reason: collision with root package name */
    public int f6194f;

    public VideoInfo() {
    }

    public String a() {
        return this.f6189a;
    }

    public int b() {
        return this.f6190b;
    }

    public int c() {
        return this.f6191c;
    }

    public long d() {
        return this.f6193e;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public int e() {
        return this.f6192d;
    }

    public int f() {
        return this.f6194f;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* renamed from: g */
    public VideoInfo clone() {
        VideoInfo videoInfo = new VideoInfo();
        videoInfo.f6194f = this.f6194f;
        videoInfo.f6192d = this.f6192d;
        videoInfo.f6193e = this.f6193e;
        videoInfo.f6191c = this.f6191c;
        videoInfo.f6190b = this.f6190b;
        videoInfo.f6189a = this.f6189a;
        return videoInfo;
    }

    public String toString() {
        return "VideoInfo{videoPath='" + this.f6189a + "', videoWidth=" + this.f6190b + ", videoHeight=" + this.f6191c + ", frameRate=" + this.f6192d + ", duration=" + this.f6193e + ", videoRotation=" + this.f6194f + '}';
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i2) {
        parcel.writeString(this.f6189a);
        parcel.writeInt(this.f6190b);
        parcel.writeInt(this.f6191c);
        parcel.writeLong(this.f6193e);
        parcel.writeFloat(this.f6192d);
        parcel.writeInt(this.f6194f);
    }

    public VideoInfo(Parcel parcel) {
        this.f6189a = parcel.readString();
        this.f6190b = parcel.readInt();
        this.f6191c = parcel.readInt();
        this.f6193e = parcel.readLong();
        this.f6192d = parcel.readInt();
        this.f6194f = parcel.readInt();
    }

    public void a(String str) {
        this.f6189a = str;
    }

    public void b(int i2) {
        this.f6191c = i2;
    }

    public void c(int i2) {
        this.f6192d = i2;
    }

    public void d(int i2) {
        this.f6194f = i2;
    }

    public void a(int i2) {
        this.f6190b = i2;
    }

    public void a(long j) {
        this.f6193e = j;
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
