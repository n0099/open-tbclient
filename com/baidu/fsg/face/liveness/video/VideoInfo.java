package com.baidu.fsg.face.liveness.video;

import android.media.MediaExtractor;
import android.media.MediaFormat;
import android.os.Parcel;
import android.os.Parcelable;
import android.text.TextUtils;
import com.baidu.fsg.base.utils.LogUtil;
import com.kwai.video.player.misc.IMediaFormat;
/* loaded from: classes5.dex */
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
    private String f2307a;

    /* renamed from: b  reason: collision with root package name */
    private int f2308b;
    private int c;
    private int d;
    private long e;
    private int f;

    public String a() {
        return this.f2307a;
    }

    public void a(String str) {
        this.f2307a = str;
    }

    public int b() {
        return this.f2308b;
    }

    public void a(int i) {
        this.f2308b = i;
    }

    public int c() {
        return this.c;
    }

    public void b(int i) {
        this.c = i;
    }

    public VideoInfo() {
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(this.f2307a);
        parcel.writeInt(this.f2308b);
        parcel.writeInt(this.c);
        parcel.writeLong(this.e);
        parcel.writeFloat(this.d);
        parcel.writeInt(this.f);
    }

    protected VideoInfo(Parcel parcel) {
        this.f2307a = parcel.readString();
        this.f2308b = parcel.readInt();
        this.c = parcel.readInt();
        this.e = parcel.readLong();
        this.d = parcel.readInt();
        this.f = parcel.readInt();
    }

    public long d() {
        return this.e;
    }

    public void a(long j) {
        this.e = j;
    }

    public int e() {
        return this.d;
    }

    public void c(int i) {
        this.d = i;
    }

    public int f() {
        return this.f;
    }

    public void d(int i) {
        this.f = i;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* renamed from: g */
    public VideoInfo clone() {
        VideoInfo videoInfo = new VideoInfo();
        videoInfo.f = this.f;
        videoInfo.d = this.d;
        videoInfo.e = this.e;
        videoInfo.c = this.c;
        videoInfo.f2308b = this.f2308b;
        videoInfo.f2307a = this.f2307a;
        return videoInfo;
    }

    public static void a(String str, VideoInfo videoInfo) {
        if (!TextUtils.isEmpty(str) && videoInfo != null) {
            videoInfo.a(str);
            MediaExtractor mediaExtractor = new MediaExtractor();
            try {
                mediaExtractor.setDataSource(str);
                MediaFormat trackFormat = mediaExtractor.getTrackFormat(a(mediaExtractor, false));
                videoInfo.c(trackFormat.containsKey("frame-rate") ? trackFormat.getInteger("frame-rate") : 0);
                videoInfo.a(trackFormat.containsKey("durationUs") ? trackFormat.getLong("durationUs") / 1000 : 0L);
                videoInfo.a(trackFormat.getInteger("width"));
                videoInfo.b(trackFormat.getInteger("height"));
                videoInfo.d(trackFormat.containsKey("rotation-degrees") ? trackFormat.getInteger("rotation-degrees") : 0);
            } catch (Exception e) {
                LogUtil.e(e.toString());
            } finally {
                mediaExtractor.release();
            }
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
            } else if (string.startsWith("video/")) {
                return i;
            }
        }
        return -5;
    }

    public String toString() {
        return "VideoInfo{videoPath='" + this.f2307a + "', videoWidth=" + this.f2308b + ", videoHeight=" + this.c + ", frameRate=" + this.d + ", duration=" + this.e + ", videoRotation=" + this.f + '}';
    }
}
