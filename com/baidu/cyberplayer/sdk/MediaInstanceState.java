package com.baidu.cyberplayer.sdk;

import android.content.Context;
import android.net.Uri;
import android.view.Surface;
import com.baidu.cyberplayer.sdk.CyberPlayerManager;
import java.util.Map;
@Keep
/* loaded from: classes2.dex */
public class MediaInstanceState {
    public static final int INSTANCE_STATE_ACTIVE = 1;
    public static final int INSTANCE_STATE_INACTIVE = 0;
    public Map<String, String> A;

    /* renamed from: a  reason: collision with root package name */
    public CyberPlayerManager.OnPreparedListener f4764a;

    /* renamed from: b  reason: collision with root package name */
    public CyberPlayerManager.OnCompletionListener f4765b;

    /* renamed from: c  reason: collision with root package name */
    public CyberPlayerManager.OnBufferingUpdateListener f4766c;

    /* renamed from: d  reason: collision with root package name */
    public CyberPlayerManager.OnSeekCompleteListener f4767d;

    /* renamed from: e  reason: collision with root package name */
    public CyberPlayerManager.OnVideoSizeChangedListener f4768e;

    /* renamed from: f  reason: collision with root package name */
    public CyberPlayerManager.OnInfoListener f4769f;

    /* renamed from: g  reason: collision with root package name */
    public CyberPlayerManager.OnMediaSourceChangedListener f4770g;

    /* renamed from: h  reason: collision with root package name */
    public Surface f4771h;

    /* renamed from: i  reason: collision with root package name */
    public CyberPlayerManager.HttpDNS f4772i;
    public Uri z;
    public int j = -1;
    public int k = 0;
    public float l = -1.0f;
    public float m = -1.0f;
    public long n = 0;
    public long o = 0;
    public int p = 0;
    public Context q = null;
    public boolean r = false;
    public boolean s = false;
    public boolean t = false;
    public int u = 0;
    public boolean v = false;
    public int w = -1;
    public int x = 0;
    public int y = 0;
    public int B = Integer.MIN_VALUE;
    public String C = null;
    public String D = null;

    public CyberPlayerManager.HttpDNS dns() {
        return this.f4772i;
    }

    public String getClarityInfo() {
        return this.C;
    }

    public int getCurrentPosition() {
        return this.j;
    }

    public int getDecoderMode() {
        return this.p;
    }

    public long getDownLoadSpeed() {
        return this.o;
    }

    public int getDuration() {
        return this.k;
    }

    public Context getInstanceContext() {
        return this.q;
    }

    public Map<String, String> getInstanceHeader() {
        return this.A;
    }

    public int getInstanceStaticsCount(boolean z) {
        if (z) {
            int i2 = this.x + 1;
            this.x = i2;
            return i2;
        }
        int i3 = this.y + 1;
        this.y = i3;
        return i3;
    }

    public Surface getInstanceSurface() {
        return this.f4771h;
    }

    public Uri getInstanceUri() {
        return this.z;
    }

    public float getLRVolume() {
        float f2 = this.l;
        float f3 = this.m;
        return f2 > f3 ? f2 : f3;
    }

    public int getMediaSourceRank() {
        return this.B;
    }

    public CyberPlayerManager.OnBufferingUpdateListener getOnBufferingUpdateListener() {
        return this.f4766c;
    }

    public CyberPlayerManager.OnCompletionListener getOnCompletionListener() {
        return this.f4765b;
    }

    public CyberPlayerManager.OnInfoListener getOnInfoListener() {
        return this.f4769f;
    }

    public CyberPlayerManager.OnMediaSourceChangedListener getOnMediaSourceChangedListener() {
        return this.f4770g;
    }

    public CyberPlayerManager.OnPreparedListener getOnPreparedListener() {
        return this.f4764a;
    }

    public CyberPlayerManager.OnSeekCompleteListener getOnSeekCompleteListener() {
        return this.f4767d;
    }

    public CyberPlayerManager.OnVideoSizeChangedListener getOnVideoSizeChangedListener() {
        return this.f4768e;
    }

    public String getPlayJson() {
        return this.D;
    }

    public boolean getPlayStateByType(int i2) {
        if (i2 == 0) {
            return this.r;
        }
        if (i2 == 1) {
            return this.s;
        }
        return false;
    }

    public long getPlayedTime() {
        return this.n;
    }

    public boolean getPlayingStatus() {
        return this.t;
    }

    public boolean isRemote() {
        return this.v;
    }

    public boolean needActiveInstance() {
        return this.w == 0;
    }

    public void release() {
        this.f4764a = null;
        this.f4769f = null;
        this.f4767d = null;
        this.f4766c = null;
        this.f4768e = null;
        this.f4764a = null;
        this.f4770g = null;
        this.f4771h = null;
        this.f4772i = null;
        this.A = null;
        this.z = null;
    }

    public void setClarityInfo(String str) {
        this.C = str;
    }

    public void setMediaSourceRank(int i2) {
        this.B = i2;
    }

    public void setOnBufferingUpdateListener(CyberPlayerManager.OnBufferingUpdateListener onBufferingUpdateListener) {
        this.f4766c = onBufferingUpdateListener;
    }

    public void setOnCompletionListener(CyberPlayerManager.OnCompletionListener onCompletionListener) {
        this.f4765b = onCompletionListener;
    }

    public void setOnInfoListener(CyberPlayerManager.OnInfoListener onInfoListener) {
        this.f4769f = onInfoListener;
    }

    public void setOnMediaSourceChangedListener(CyberPlayerManager.OnMediaSourceChangedListener onMediaSourceChangedListener) {
        this.f4770g = onMediaSourceChangedListener;
    }

    public void setOnPreparedListener(CyberPlayerManager.OnPreparedListener onPreparedListener) {
        this.f4764a = onPreparedListener;
    }

    public void setOnSeekCompleteListener(CyberPlayerManager.OnSeekCompleteListener onSeekCompleteListener) {
        this.f4767d = onSeekCompleteListener;
    }

    public void setOnVideoSizeChangedListener(CyberPlayerManager.OnVideoSizeChangedListener onVideoSizeChangedListener) {
        this.f4768e = onVideoSizeChangedListener;
    }

    public void setPlayJson(String str) {
        this.D = str;
    }

    public void updateDataSource(Context context, Uri uri, Map<String, String> map) {
        this.q = context;
        this.z = uri;
        this.A = map;
    }

    public void updateDecoderMode(int i2) {
        this.p = i2;
    }

    public void updateDns(CyberPlayerManager.HttpDNS httpDNS) {
        this.f4772i = httpDNS;
    }

    public void updateDownLoadSpeed(long j) {
        this.o = j;
    }

    public void updateInstanceDecodeMode(int i2) {
        this.p = i2;
    }

    public void updateInstanceState(int i2) {
        this.w = i2;
    }

    public void updatePlayStateByType(int i2, boolean z) {
        if (i2 == 0) {
            this.r = z;
        } else if (i2 == 1) {
            this.s = z;
        }
    }

    public void updatePlayedTime(long j) {
        this.n = j;
    }

    public void updatePlayingStatus(boolean z) {
        this.t = z;
    }

    public void updateRemote(boolean z) {
        this.v = z;
    }

    public void updateSeekPos(int i2, int i3) {
        if (i2 >= i3 - 100) {
            i2 = 0;
        }
        this.j = i2;
        this.k = i3;
    }

    public void updateSurface(Surface surface) {
        this.f4771h = surface;
    }
}
