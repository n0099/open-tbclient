package com.baidu.cyberplayer.sdk;

import android.content.Context;
import android.net.Uri;
import android.view.Surface;
import com.baidu.cyberplayer.sdk.CyberPlayerManager;
import java.util.Map;
@Keep
/* loaded from: classes17.dex */
public class MediaInstanceState {
    public static final int INSTANCE_STATE_ACTIVE = 1;
    public static final int INSTANCE_STATE_INACTIVE = 0;

    /* renamed from: a  reason: collision with root package name */
    private CyberPlayerManager.OnPreparedListener f1353a;
    private CyberPlayerManager.OnCompletionListener b;
    private CyberPlayerManager.OnBufferingUpdateListener c;
    private CyberPlayerManager.OnSeekCompleteListener d;
    private CyberPlayerManager.OnVideoSizeChangedListener e;
    private CyberPlayerManager.OnInfoListener f;
    private Surface g;
    private CyberPlayerManager.HttpDNS h;
    private int i = -1;
    private int j = 0;
    private float k = -1.0f;
    private float l = -1.0f;
    private long m = 0;
    private long n = 0;
    private int o = 0;
    private Context p = null;
    private boolean q = false;
    private boolean r = false;
    private boolean s = false;
    private int t = 0;
    private boolean u = false;
    private int v = -1;
    private int w = 0;
    private int x = 0;
    private Uri y;
    private Map<String, String> z;

    public CyberPlayerManager.HttpDNS dns() {
        return this.h;
    }

    public int getCurrentPosition() {
        return this.i;
    }

    public int getDecoderMode() {
        return this.o;
    }

    public long getDownLoadSpeed() {
        return this.n;
    }

    public int getDuration() {
        return this.j;
    }

    public Context getInstanceContext() {
        return this.p;
    }

    public Map<String, String> getInstanceHeader() {
        return this.z;
    }

    public int getInstanceStaticsCount(boolean z) {
        if (z) {
            int i = this.w + 1;
            this.w = i;
            return i;
        }
        int i2 = this.x + 1;
        this.x = i2;
        return i2;
    }

    public Surface getInstanceSurface() {
        return this.g;
    }

    public Uri getInstanceUri() {
        return this.y;
    }

    public float getLRVolume() {
        return this.k > this.l ? this.k : this.l;
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

    public CyberPlayerManager.OnPreparedListener getOnPreparedListener() {
        return this.f1353a;
    }

    public CyberPlayerManager.OnSeekCompleteListener getOnSeekCompleteListener() {
        return this.d;
    }

    public CyberPlayerManager.OnVideoSizeChangedListener getOnVideoSizeChangedListener() {
        return this.e;
    }

    public boolean getPlayStateByType(int i) {
        if (i == 0) {
            return this.q;
        }
        if (i == 1) {
            return this.r;
        }
        return false;
    }

    public long getPlayedTime() {
        return this.m;
    }

    public boolean getPlayingStatus() {
        return this.s;
    }

    public boolean isRemote() {
        return this.u;
    }

    public boolean needActiveInstance() {
        return this.v == 0;
    }

    public void release() {
        this.f1353a = null;
        this.f = null;
        this.d = null;
        this.c = null;
        this.e = null;
        this.f1353a = null;
        this.g = null;
        this.h = null;
        this.z = null;
        this.y = null;
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

    public void setOnPreparedListener(CyberPlayerManager.OnPreparedListener onPreparedListener) {
        this.f1353a = onPreparedListener;
    }

    public void setOnSeekCompleteListener(CyberPlayerManager.OnSeekCompleteListener onSeekCompleteListener) {
        this.d = onSeekCompleteListener;
    }

    public void setOnVideoSizeChangedListener(CyberPlayerManager.OnVideoSizeChangedListener onVideoSizeChangedListener) {
        this.e = onVideoSizeChangedListener;
    }

    public void updateDataSource(Context context, Uri uri, Map<String, String> map) {
        this.p = context;
        this.y = uri;
        this.z = map;
    }

    public void updateDecoderMode(int i) {
        this.o = i;
    }

    public void updateDns(CyberPlayerManager.HttpDNS httpDNS) {
        this.h = httpDNS;
    }

    public void updateDownLoadSpeed(long j) {
        this.n = j;
    }

    public void updateInstanceDecodeMode(int i) {
        this.o = i;
    }

    public void updateInstanceState(int i) {
        this.v = i;
    }

    public void updatePlayStateByType(int i, boolean z) {
        if (i == 0) {
            this.q = z;
        } else if (i == 1) {
            this.r = z;
        }
    }

    public void updatePlayedTime(long j) {
        this.m = j;
    }

    public void updatePlayingStatus(boolean z) {
        this.s = z;
    }

    public void updateRemote(boolean z) {
        this.u = z;
    }

    public void updateSeekPos(int i, int i2) {
        if (i >= i2 - 100) {
            this.i = 0;
        } else {
            this.i = i;
        }
        this.j = i2;
    }

    public void updateSurface(Surface surface) {
        this.g = surface;
    }
}
