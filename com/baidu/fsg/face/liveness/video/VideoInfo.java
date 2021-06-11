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
        public VideoInfo[] newArray(int i2) {
            return new VideoInfo[i2];
        }
    };

    /* renamed from: a  reason: collision with root package name */
    public String f5986a;

    /* renamed from: b  reason: collision with root package name */
    public int f5987b;

    /* renamed from: c  reason: collision with root package name */
    public int f5988c;

    /* renamed from: d  reason: collision with root package name */
    public int f5989d;

    /* renamed from: e  reason: collision with root package name */
    public long f5990e;

    /* renamed from: f  reason: collision with root package name */
    public int f5991f;

    public VideoInfo() {
    }

    public String a() {
        return this.f5986a;
    }

    public int b() {
        return this.f5987b;
    }

    public int c() {
        return this.f5988c;
    }

    public long d() {
        return this.f5990e;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public int e() {
        return this.f5989d;
    }

    public int f() {
        return this.f5991f;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* renamed from: g */
    public VideoInfo clone() {
        VideoInfo videoInfo = new VideoInfo();
        videoInfo.f5991f = this.f5991f;
        videoInfo.f5989d = this.f5989d;
        videoInfo.f5990e = this.f5990e;
        videoInfo.f5988c = this.f5988c;
        videoInfo.f5987b = this.f5987b;
        videoInfo.f5986a = this.f5986a;
        return videoInfo;
    }

    public String toString() {
        return "VideoInfo{videoPath='" + this.f5986a + "', videoWidth=" + this.f5987b + ", videoHeight=" + this.f5988c + ", frameRate=" + this.f5989d + ", duration=" + this.f5990e + ", videoRotation=" + this.f5991f + '}';
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i2) {
        parcel.writeString(this.f5986a);
        parcel.writeInt(this.f5987b);
        parcel.writeInt(this.f5988c);
        parcel.writeLong(this.f5990e);
        parcel.writeFloat(this.f5989d);
        parcel.writeInt(this.f5991f);
    }

    public VideoInfo(Parcel parcel) {
        this.f5986a = parcel.readString();
        this.f5987b = parcel.readInt();
        this.f5988c = parcel.readInt();
        this.f5990e = parcel.readLong();
        this.f5989d = parcel.readInt();
        this.f5991f = parcel.readInt();
    }

    public void a(String str) {
        this.f5986a = str;
    }

    public void b(int i2) {
        this.f5988c = i2;
    }

    public void c(int i2) {
        this.f5989d = i2;
    }

    public void d(int i2) {
        this.f5991f = i2;
    }

    public void a(int i2) {
        this.f5987b = i2;
    }

    public void a(long j) {
        this.f5990e = j;
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
            String string = mediaExtractor.getTrackFormat(i2).getString(IMediaFormat.KEY_MIME);
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
