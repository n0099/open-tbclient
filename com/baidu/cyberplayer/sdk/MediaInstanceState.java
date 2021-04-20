package com.baidu.cyberplayer.sdk;

import android.content.Context;
import android.net.Uri;
import android.view.Surface;
import com.baidu.cyberplayer.sdk.CyberPlayerManager;
import java.util.Map;
@Keep
/* loaded from: classes.dex */
public class MediaInstanceState {
    public static final int INSTANCE_STATE_ACTIVE = 1;
    public static final int INSTANCE_STATE_INACTIVE = 0;
    public Map<String, String> A;

    /* renamed from: a  reason: collision with root package name */
    public CyberPlayerManager.OnPreparedListener f4868a;

    /* renamed from: b  reason: collision with root package name */
    public CyberPlayerManager.OnCompletionListener f4869b;

    /* renamed from: c  reason: collision with root package name */
    public CyberPlayerManager.OnBufferingUpdateListener f4870c;

    /* renamed from: d  reason: collision with root package name */
    public CyberPlayerManager.OnSeekCompleteListener f4871d;

    /* renamed from: e  reason: collision with root package name */
    public CyberPlayerManager.OnVideoSizeChangedListener f4872e;

    /* renamed from: f  reason: collision with root package name */
    public CyberPlayerManager.OnInfoListener f4873f;

    /* renamed from: g  reason: collision with root package name */
    public CyberPlayerManager.OnMediaSourceChangedListener f4874g;

    /* renamed from: h  reason: collision with root package name */
    public Surface f4875h;
    public CyberPlayerManager.HttpDNS i;
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
        return this.i;
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
            int i = this.x + 1;
            this.x = i;
            return i;
        }
        int i2 = this.y + 1;
        this.y = i2;
        return i2;
    }

    public Surface getInstanceSurface() {
        return this.f4875h;
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
        return this.f4870c;
    }

    public CyberPlayerManager.OnCompletionListener getOnCompletionListener() {
        return this.f4869b;
    }

    public CyberPlayerManager.OnInfoListener getOnInfoListener() {
        return this.f4873f;
    }

    public CyberPlayerManager.OnMediaSourceChangedListener getOnMediaSourceChangedListener() {
        return this.f4874g;
    }

    public CyberPlayerManager.OnPreparedListener getOnPreparedListener() {
        return this.f4868a;
    }

    public CyberPlayerManager.OnSeekCompleteListener getOnSeekCompleteListener() {
        return this.f4871d;
    }

    public CyberPlayerManager.OnVideoSizeChangedListener getOnVideoSizeChangedListener() {
        return this.f4872e;
    }

    public String getPlayJson() {
        return this.D;
    }

    public boolean getPlayStateByType(int i) {
        if (i == 0) {
            return this.r;
        }
        if (i == 1) {
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
        this.f4868a = null;
        this.f4873f = null;
        this.f4871d = null;
        this.f4870c = null;
        this.f4872e = null;
        this.f4868a = null;
        this.f4874g = null;
        this.f4875h = null;
        this.i = null;
        this.A = null;
        this.z = null;
    }

    public void setClarityInfo(String str) {
        this.C = str;
    }

    public void setMediaSourceRank(int i) {
        this.B = i;
    }

    public void setOnBufferingUpdateListener(CyberPlayerManager.OnBufferingUpdateListener onBufferingUpdateListener) {
        this.f4870c = onBufferingUpdateListener;
    }

    public void setOnCompletionListener(CyberPlayerManager.OnCompletionListener onCompletionListener) {
        this.f4869b = onCompletionListener;
    }

    public void setOnInfoListener(CyberPlayerManager.OnInfoListener onInfoListener) {
        this.f4873f = onInfoListener;
    }

    public void setOnMediaSourceChangedListener(CyberPlayerManager.OnMediaSourceChangedListener onMediaSourceChangedListener) {
        this.f4874g = onMediaSourceChangedListener;
    }

    public void setOnPreparedListener(CyberPlayerManager.OnPreparedListener onPreparedListener) {
        this.f4868a = onPreparedListener;
    }

    public void setOnSeekCompleteListener(CyberPlayerManager.OnSeekCompleteListener onSeekCompleteListener) {
        this.f4871d = onSeekCompleteListener;
    }

    public void setOnVideoSizeChangedListener(CyberPlayerManager.OnVideoSizeChangedListener onVideoSizeChangedListener) {
        this.f4872e = onVideoSizeChangedListener;
    }

    public void setPlayJson(String str) {
        this.D = str;
    }

    public void updateDataSource(Context context, Uri uri, Map<String, String> map) {
        this.q = context;
        this.z = uri;
        this.A = map;
    }

    public void updateDecoderMode(int i) {
        this.p = i;
    }

    public void updateDns(CyberPlayerManager.HttpDNS httpDNS) {
        this.i = httpDNS;
    }

    public void updateDownLoadSpeed(long j) {
        this.o = j;
    }

    public void updateInstanceDecodeMode(int i) {
        this.p = i;
    }

    public void updateInstanceState(int i) {
        this.w = i;
    }

    public void updatePlayStateByType(int i, boolean z) {
        if (i == 0) {
            this.r = z;
        } else if (i == 1) {
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

    public void updateSeekPos(int i, int i2) {
        if (i >= i2 - 100) {
            i = 0;
        }
        this.j = i;
        this.k = i2;
    }

    public void updateSurface(Surface surface) {
        this.f4875h = surface;
    }
}
