package com.baidu.cyberplayer.sdk;

import android.content.Context;
import android.net.Uri;
import android.view.Surface;
import com.baidu.cyberplayer.sdk.CyberPlayerManager;
import java.util.Map;
@Keep
/* loaded from: classes4.dex */
public class MediaInstanceState {
    public static final int INSTANCE_STATE_ACTIVE = 1;
    public static final int INSTANCE_STATE_INACTIVE = 0;
    private Map<String, String> A;

    /* renamed from: a  reason: collision with root package name */
    private CyberPlayerManager.OnPreparedListener f1715a;

    /* renamed from: b  reason: collision with root package name */
    private CyberPlayerManager.OnCompletionListener f1716b;
    private CyberPlayerManager.OnBufferingUpdateListener c;
    private CyberPlayerManager.OnSeekCompleteListener d;
    private CyberPlayerManager.OnVideoSizeChangedListener e;
    private CyberPlayerManager.OnInfoListener f;
    private CyberPlayerManager.OnMediaSourceChangedListener g;
    private Surface h;
    private CyberPlayerManager.HttpDNS i;
    private Uri z;
    private int j = -1;
    private int k = 0;
    private float l = -1.0f;
    private float m = -1.0f;
    private long n = 0;
    private long o = 0;
    private int p = 0;
    private Context q = null;
    private boolean r = false;
    private boolean s = false;
    private boolean t = false;
    private int u = 0;
    private boolean v = false;
    private int w = -1;
    private int x = 0;
    private int y = 0;
    private int B = Integer.MIN_VALUE;
    private String C = null;
    private String D = null;

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
        return this.h;
    }

    public Uri getInstanceUri() {
        return this.z;
    }

    public float getLRVolume() {
        return this.l > this.m ? this.l : this.m;
    }

    public int getMediaSourceRank() {
        return this.B;
    }

    public CyberPlayerManager.OnBufferingUpdateListener getOnBufferingUpdateListener() {
        return this.c;
    }

    public CyberPlayerManager.OnCompletionListener getOnCompletionListener() {
        return this.f1716b;
    }

    public CyberPlayerManager.OnInfoListener getOnInfoListener() {
        return this.f;
    }

    public CyberPlayerManager.OnMediaSourceChangedListener getOnMediaSourceChangedListener() {
        return this.g;
    }

    public CyberPlayerManager.OnPreparedListener getOnPreparedListener() {
        return this.f1715a;
    }

    public CyberPlayerManager.OnSeekCompleteListener getOnSeekCompleteListener() {
        return this.d;
    }

    public CyberPlayerManager.OnVideoSizeChangedListener getOnVideoSizeChangedListener() {
        return this.e;
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
        this.f1715a = null;
        this.f = null;
        this.d = null;
        this.c = null;
        this.e = null;
        this.f1715a = null;
        this.g = null;
        this.h = null;
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
        this.c = onBufferingUpdateListener;
    }

    public void setOnCompletionListener(CyberPlayerManager.OnCompletionListener onCompletionListener) {
        this.f1716b = onCompletionListener;
    }

    public void setOnInfoListener(CyberPlayerManager.OnInfoListener onInfoListener) {
        this.f = onInfoListener;
    }

    public void setOnMediaSourceChangedListener(CyberPlayerManager.OnMediaSourceChangedListener onMediaSourceChangedListener) {
        this.g = onMediaSourceChangedListener;
    }

    public void setOnPreparedListener(CyberPlayerManager.OnPreparedListener onPreparedListener) {
        this.f1715a = onPreparedListener;
    }

    public void setOnSeekCompleteListener(CyberPlayerManager.OnSeekCompleteListener onSeekCompleteListener) {
        this.d = onSeekCompleteListener;
    }

    public void setOnVideoSizeChangedListener(CyberPlayerManager.OnVideoSizeChangedListener onVideoSizeChangedListener) {
        this.e = onVideoSizeChangedListener;
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
            this.j = 0;
        } else {
            this.j = i;
        }
        this.k = i2;
    }

    public void updateSurface(Surface surface) {
        this.h = surface;
    }
}
