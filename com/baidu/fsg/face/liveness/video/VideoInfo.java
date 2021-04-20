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
    public String f6022a;

    /* renamed from: b  reason: collision with root package name */
    public int f6023b;

    /* renamed from: c  reason: collision with root package name */
    public int f6024c;

    /* renamed from: d  reason: collision with root package name */
    public int f6025d;

    /* renamed from: e  reason: collision with root package name */
    public long f6026e;

    /* renamed from: f  reason: collision with root package name */
    public int f6027f;

    public VideoInfo() {
    }

    public String a() {
        return this.f6022a;
    }

    public int b() {
        return this.f6023b;
    }

    public int c() {
        return this.f6024c;
    }

    public long d() {
        return this.f6026e;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public int e() {
        return this.f6025d;
    }

    public int f() {
        return this.f6027f;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* renamed from: g */
    public VideoInfo clone() {
        VideoInfo videoInfo = new VideoInfo();
        videoInfo.f6027f = this.f6027f;
        videoInfo.f6025d = this.f6025d;
        videoInfo.f6026e = this.f6026e;
        videoInfo.f6024c = this.f6024c;
        videoInfo.f6023b = this.f6023b;
        videoInfo.f6022a = this.f6022a;
        return videoInfo;
    }

    public String toString() {
        return "VideoInfo{videoPath='" + this.f6022a + "', videoWidth=" + this.f6023b + ", videoHeight=" + this.f6024c + ", frameRate=" + this.f6025d + ", duration=" + this.f6026e + ", videoRotation=" + this.f6027f + '}';
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(this.f6022a);
        parcel.writeInt(this.f6023b);
        parcel.writeInt(this.f6024c);
        parcel.writeLong(this.f6026e);
        parcel.writeFloat(this.f6025d);
        parcel.writeInt(this.f6027f);
    }

    public VideoInfo(Parcel parcel) {
        this.f6022a = parcel.readString();
        this.f6023b = parcel.readInt();
        this.f6024c = parcel.readInt();
        this.f6026e = parcel.readLong();
        this.f6025d = parcel.readInt();
        this.f6027f = parcel.readInt();
    }

    public void a(String str) {
        this.f6022a = str;
    }

    public void b(int i) {
        this.f6024c = i;
    }

    public void c(int i) {
        this.f6025d = i;
    }

    public void d(int i) {
        this.f6027f = i;
    }

    public void a(int i) {
        this.f6023b = i;
    }

    public void a(long j) {
        this.f6026e = j;
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
