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
    public Map<String, String> B;
    public CyberPlayerManager.OnPreparedListener a;
    public CyberPlayerManager.OnCompletionListener b;
    public CyberPlayerManager.OnBufferingUpdateListener c;
    public CyberPlayerManager.OnSeekCompleteListener d;
    public CyberPlayerManager.OnVideoSizeChangedListener e;
    public CyberPlayerManager.OnInfoListener f;
    public CyberPlayerManager.OnMediaSourceChangedListener g;
    public Surface h;
    public CyberPlayerManager.HttpDNS i;
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
    public boolean u = false;
    public boolean v = false;
    public int w = -1;
    public int x = 0;
    public int y = 0;
    public Uri z = null;
    public String A = null;
    public int C = Integer.MIN_VALUE;
    public String D = null;
    public String E = null;

    public CyberPlayerManager.HttpDNS dns() {
        return this.i;
    }

    public String getClarityInfo() {
        return this.D;
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
        return this.B;
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
        return this.h;
    }

    public Uri getInstanceUri() {
        return this.z;
    }

    public String getInstanceUrl() {
        return this.A;
    }

    public float getLRVolume() {
        float f = this.l;
        float f2 = this.m;
        return f > f2 ? f : f2;
    }

    public int getMediaSourceRank() {
        return this.C;
    }

    public CyberPlayerManager.OnBufferingUpdateListener getOnBufferingUpdateListener() {
        return this.c;
    }

    public CyberPlayerManager.OnCompletionListener getOnCompletionListener() {
        return this.b;
    }

    public CyberPlayerManager.OnInfoListener getOnInfoListener() {
        return this.f;
    }

    public CyberPlayerManager.OnMediaSourceChangedListener getOnMediaSourceChangedListener() {
        return this.g;
    }

    public CyberPlayerManager.OnPreparedListener getOnPreparedListener() {
        return this.a;
    }

    public CyberPlayerManager.OnSeekCompleteListener getOnSeekCompleteListener() {
        return this.d;
    }

    public CyberPlayerManager.OnVideoSizeChangedListener getOnVideoSizeChangedListener() {
        return this.e;
    }

    public String getPlayJson() {
        return this.E;
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

    public boolean isProcessDied() {
        return this.u;
    }

    public boolean isRemote() {
        return this.v;
    }

    public boolean needActiveInstance() {
        return this.w == 0;
    }

    public void release() {
        this.a = null;
        this.f = null;
        this.d = null;
        this.c = null;
        this.e = null;
        this.a = null;
        this.g = null;
        this.h = null;
        this.i = null;
        this.B = null;
        this.z = null;
    }

    public void setClarityInfo(String str) {
        this.D = str;
    }

    public void setMediaSourceRank(int i) {
        this.C = i;
    }

    public void setOnBufferingUpdateListener(CyberPlayerManager.OnBufferingUpdateListener onBufferingUpdateListener) {
        this.c = onBufferingUpdateListener;
    }

    public void setOnCompletionListener(CyberPlayerManager.OnCompletionListener onCompletionListener) {
        this.b = onCompletionListener;
    }

    public void setOnInfoListener(CyberPlayerManager.OnInfoListener onInfoListener) {
        this.f = onInfoListener;
    }

    public void setOnMediaSourceChangedListener(CyberPlayerManager.OnMediaSourceChangedListener onMediaSourceChangedListener) {
        this.g = onMediaSourceChangedListener;
    }

    public void setOnPreparedListener(CyberPlayerManager.OnPreparedListener onPreparedListener) {
        this.a = onPreparedListener;
    }

    public void setOnSeekCompleteListener(CyberPlayerManager.OnSeekCompleteListener onSeekCompleteListener) {
        this.d = onSeekCompleteListener;
    }

    public void setOnVideoSizeChangedListener(CyberPlayerManager.OnVideoSizeChangedListener onVideoSizeChangedListener) {
        this.e = onVideoSizeChangedListener;
    }

    public void setPlayJson(String str) {
        this.E = str;
    }

    public void setProcessDied(boolean z) {
        this.u = z;
    }

    public void updateDataSource(Context context, Uri uri, Map<String, String> map) {
        this.q = context;
        this.z = uri;
        this.B = map;
    }

    public void updateDataSource(String str, Map<String, String> map) {
        this.A = str;
        this.B = map;
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
        this.h = surface;
    }
}
