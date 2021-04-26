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
    public CyberPlayerManager.OnPreparedListener f4987a;

    /* renamed from: b  reason: collision with root package name */
    public CyberPlayerManager.OnCompletionListener f4988b;

    /* renamed from: c  reason: collision with root package name */
    public CyberPlayerManager.OnBufferingUpdateListener f4989c;

    /* renamed from: d  reason: collision with root package name */
    public CyberPlayerManager.OnSeekCompleteListener f4990d;

    /* renamed from: e  reason: collision with root package name */
    public CyberPlayerManager.OnVideoSizeChangedListener f4991e;

    /* renamed from: f  reason: collision with root package name */
    public CyberPlayerManager.OnInfoListener f4992f;

    /* renamed from: g  reason: collision with root package name */
    public CyberPlayerManager.OnMediaSourceChangedListener f4993g;

    /* renamed from: h  reason: collision with root package name */
    public Surface f4994h;

    /* renamed from: i  reason: collision with root package name */
    public CyberPlayerManager.HttpDNS f4995i;
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
        return this.f4995i;
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
        return this.f4994h;
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
        return this.f4989c;
    }

    public CyberPlayerManager.OnCompletionListener getOnCompletionListener() {
        return this.f4988b;
    }

    public CyberPlayerManager.OnInfoListener getOnInfoListener() {
        return this.f4992f;
    }

    public CyberPlayerManager.OnMediaSourceChangedListener getOnMediaSourceChangedListener() {
        return this.f4993g;
    }

    public CyberPlayerManager.OnPreparedListener getOnPreparedListener() {
        return this.f4987a;
    }

    public CyberPlayerManager.OnSeekCompleteListener getOnSeekCompleteListener() {
        return this.f4990d;
    }

    public CyberPlayerManager.OnVideoSizeChangedListener getOnVideoSizeChangedListener() {
        return this.f4991e;
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
        this.f4987a = null;
        this.f4992f = null;
        this.f4990d = null;
        this.f4989c = null;
        this.f4991e = null;
        this.f4987a = null;
        this.f4993g = null;
        this.f4994h = null;
        this.f4995i = null;
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
        this.f4989c = onBufferingUpdateListener;
    }

    public void setOnCompletionListener(CyberPlayerManager.OnCompletionListener onCompletionListener) {
        this.f4988b = onCompletionListener;
    }

    public void setOnInfoListener(CyberPlayerManager.OnInfoListener onInfoListener) {
        this.f4992f = onInfoListener;
    }

    public void setOnMediaSourceChangedListener(CyberPlayerManager.OnMediaSourceChangedListener onMediaSourceChangedListener) {
        this.f4993g = onMediaSourceChangedListener;
    }

    public void setOnPreparedListener(CyberPlayerManager.OnPreparedListener onPreparedListener) {
        this.f4987a = onPreparedListener;
    }

    public void setOnSeekCompleteListener(CyberPlayerManager.OnSeekCompleteListener onSeekCompleteListener) {
        this.f4990d = onSeekCompleteListener;
    }

    public void setOnVideoSizeChangedListener(CyberPlayerManager.OnVideoSizeChangedListener onVideoSizeChangedListener) {
        this.f4991e = onVideoSizeChangedListener;
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
        this.f4995i = httpDNS;
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
        this.f4994h = surface;
    }
}
