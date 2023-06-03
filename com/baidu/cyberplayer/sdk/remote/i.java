package com.baidu.cyberplayer.sdk.remote;

import android.content.Context;
import android.net.Uri;
import android.os.Handler;
import android.os.Message;
import android.os.RemoteException;
import android.text.TextUtils;
import android.view.Surface;
import android.view.SurfaceHolder;
import com.baidu.cyberplayer.sdk.CyberLog;
import com.baidu.cyberplayer.sdk.CyberPlayerManager;
import com.baidu.cyberplayer.sdk.PlayerProvider;
import com.baidu.cyberplayer.sdk.context.ICyberMsgHandler;
import com.baidu.cyberplayer.sdk.remote.c;
import com.baidu.cyberplayer.sdk.remote.e;
import com.baidu.cyberplayer.sdk.remote.h;
import com.baidu.cyberplayer.sdk.statistics.DpStatConstants;
import java.io.FileDescriptor;
import java.lang.ref.WeakReference;
import java.util.List;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes3.dex */
public class i extends PlayerProvider implements h.b {
    public c a;
    public CyberPlayerManager.HttpDNS b;
    public CyberPlayerManager.OnPreparedListener c;
    public CyberPlayerManager.OnCompletionListener d;
    public CyberPlayerManager.OnBufferingUpdateListener e;
    public CyberPlayerManager.OnSeekCompleteListener f;
    public CyberPlayerManager.OnVideoSizeChangedListener g;
    public CyberPlayerManager.OnErrorListener h;
    public CyberPlayerManager.OnInfoListener i;
    public CyberPlayerManager.OnMediaSourceChangedListener j;
    public CyberPlayerManager.OnMediaRuntimeInfoListener k;
    public ICyberMsgHandler m;
    public Surface n;
    public b o;
    public boolean p = false;
    public int q = -1;
    public int r = -1;
    public a l = new a(this);

    @Override // com.baidu.cyberplayer.sdk.PlayerProvider
    public boolean isRemotePlayer() {
        return true;
    }

    /* loaded from: classes3.dex */
    public static class a extends Handler {
        public final WeakReference<i> a;

        public a(i iVar) {
            this.a = new WeakReference<>(iVar);
        }

        public static void a(i iVar, String str) {
            Object obj;
            try {
                if (!TextUtils.isEmpty(str) && (obj = new JSONObject(str).get("first_disp_notify_time")) != null && (obj instanceof String)) {
                    long parseLong = Long.parseLong((String) obj);
                    if (parseLong > 0) {
                        long currentTimeMillis = System.currentTimeMillis() - parseLong;
                        CyberLog.i("RemotePlayerProxy", "costTime:" + currentTimeMillis);
                        JSONObject jSONObject = new JSONObject();
                        jSONObject.put("notify_fsp_thread_cost", currentTimeMillis);
                        iVar.sendCommand(1003, DpStatConstants.SESSION_TYPE_FIRST_SCREEN, 0L, jSONObject.toString());
                    }
                }
            } catch (JSONException unused) {
            }
        }

        public i a() {
            WeakReference<i> weakReference = this.a;
            if (weakReference != null) {
                return weakReference.get();
            }
            return null;
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            i iVar = this.a.get();
            if (iVar == null) {
                return;
            }
            switch (message.what) {
                case 0:
                    if (iVar.c != null) {
                        iVar.c.onPrepared();
                        return;
                    }
                    return;
                case 1:
                    if (iVar.d != null) {
                        iVar.d.onCompletion();
                        return;
                    }
                    return;
                case 2:
                    if (iVar.e != null) {
                        iVar.e.onBufferingUpdate(message.arg1);
                        return;
                    }
                    return;
                case 3:
                    if (iVar.f != null) {
                        iVar.f.onSeekComplete();
                        return;
                    }
                    return;
                case 4:
                    if (iVar.g != null) {
                        int[] iArr = (int[]) message.obj;
                        iVar.g.onVideoSizeChanged(iArr[0], iArr[1], iArr[2], iArr[3]);
                        return;
                    }
                    return;
                case 5:
                    if (iVar.h != null) {
                        iVar.h.onError(message.arg1, message.arg2, message.obj);
                        return;
                    }
                    return;
                case 6:
                    if (iVar.i != null) {
                        iVar.i.onInfo(message.arg1, message.arg2, message.obj);
                    }
                    int i = message.arg1;
                    if (904 == i) {
                        a(iVar, (String) message.obj);
                        return;
                    } else if (910 == i) {
                        iVar.r = message.arg2;
                        return;
                    } else {
                        return;
                    }
                case 7:
                    if (iVar.j != null) {
                        iVar.j.onMediaSourceChanged(message.arg1, message.arg2, message.obj);
                        return;
                    }
                    return;
                case 8:
                    if (iVar.k != null) {
                        iVar.k.onRuntimeInfo((String) message.obj);
                        return;
                    }
                    return;
                default:
                    return;
            }
        }
    }

    /* loaded from: classes3.dex */
    public static class b extends e.a {
        public a a;
        public ICyberMsgHandler b;
        public CyberPlayerManager.HttpDNS c;

        public b(a aVar, ICyberMsgHandler iCyberMsgHandler, CyberPlayerManager.HttpDNS httpDNS) {
            this.a = aVar;
            this.c = httpDNS;
            this.b = iCyberMsgHandler;
        }

        @Override // com.baidu.cyberplayer.sdk.remote.e
        public boolean a(int i, int i2, String str) {
            a aVar = this.a;
            if (aVar != null) {
                Message obtain = Message.obtain(aVar, 5);
                obtain.arg1 = i;
                obtain.arg2 = i2;
                obtain.obj = str;
                ICyberMsgHandler iCyberMsgHandler = this.b;
                if (iCyberMsgHandler != null) {
                    iCyberMsgHandler.sendMessage(obtain);
                    return true;
                }
                this.a.sendMessage(obtain);
                return true;
            }
            return true;
        }

        @Override // com.baidu.cyberplayer.sdk.remote.e
        public boolean c(int i, int i2, String str) {
            a aVar = this.a;
            if (aVar != null) {
                Message obtain = Message.obtain(aVar, 7);
                obtain.arg1 = i;
                obtain.arg2 = i2;
                obtain.obj = str;
                ICyberMsgHandler iCyberMsgHandler = this.b;
                if (iCyberMsgHandler != null) {
                    iCyberMsgHandler.sendMessage(obtain);
                    return true;
                }
                this.a.sendMessage(obtain);
                return true;
            }
            return true;
        }

        @Override // com.baidu.cyberplayer.sdk.remote.e
        public void a() {
            a aVar = this.a;
            if (aVar != null) {
                ICyberMsgHandler iCyberMsgHandler = this.b;
                if (iCyberMsgHandler != null) {
                    iCyberMsgHandler.sendEmptyMessage(aVar, 0);
                } else {
                    aVar.sendEmptyMessage(0);
                }
            }
        }

        @Override // com.baidu.cyberplayer.sdk.remote.e
        public synchronized void b() {
            if (this.a != null) {
                if (this.b != null) {
                    this.b.sendEmptyMessage(this.a, 1);
                } else {
                    this.a.sendEmptyMessage(1);
                }
            }
        }

        @Override // com.baidu.cyberplayer.sdk.remote.e
        public void c() {
            a aVar = this.a;
            if (aVar != null) {
                ICyberMsgHandler iCyberMsgHandler = this.b;
                if (iCyberMsgHandler != null) {
                    iCyberMsgHandler.sendEmptyMessage(aVar, 3);
                } else {
                    aVar.sendEmptyMessage(3);
                }
            }
        }

        public void d() {
            this.a = null;
            this.c = null;
        }

        @Override // com.baidu.cyberplayer.sdk.remote.e
        public void a(int i) {
            a aVar = this.a;
            if (aVar != null) {
                Message obtain = Message.obtain(aVar, 2);
                obtain.arg1 = i;
                ICyberMsgHandler iCyberMsgHandler = this.b;
                if (iCyberMsgHandler != null) {
                    iCyberMsgHandler.sendMessage(obtain);
                } else {
                    this.a.sendMessage(obtain);
                }
            }
        }

        @Override // com.baidu.cyberplayer.sdk.remote.e
        public void a(int i, int i2, int i3, int i4) {
            a aVar = this.a;
            if (aVar != null) {
                Message obtain = Message.obtain(aVar, 4);
                obtain.obj = new int[]{i, i2, i3, i4};
                ICyberMsgHandler iCyberMsgHandler = this.b;
                if (iCyberMsgHandler != null) {
                    iCyberMsgHandler.sendMessage(obtain);
                } else {
                    this.a.sendMessage(obtain);
                }
            }
        }

        @Override // com.baidu.cyberplayer.sdk.remote.e
        public void a(String str) {
            a aVar = this.a;
            if (aVar != null) {
                Message obtain = Message.obtain(aVar, 8);
                obtain.obj = str;
                ICyberMsgHandler iCyberMsgHandler = this.b;
                if (iCyberMsgHandler != null) {
                    iCyberMsgHandler.sendMessage(obtain);
                } else {
                    this.a.sendMessage(obtain);
                }
            }
        }

        @Override // com.baidu.cyberplayer.sdk.remote.e
        public void a(String str, List<String> list) {
            if (str.equals("onHttpDNS")) {
                if (this.c != null && list != null && list.size() > 0) {
                    list.clear();
                    List<String> ipList = this.c.getIpList(list.get(0));
                    if (ipList != null) {
                        list.addAll(ipList);
                    }
                } else if (list != null) {
                    list.clear();
                }
            }
        }

        @Override // com.baidu.cyberplayer.sdk.remote.e
        public boolean b(int i, int i2, String str) {
            i a;
            a aVar = this.a;
            if (aVar != null) {
                if (904 == i && (a = aVar.a()) != null && a.p) {
                    a.i.onInfo(CyberPlayerManager.MEDIA_INFO_FIRST_DISP_INTERVAL_SUB_T, i2, str);
                }
                Message obtain = Message.obtain(this.a, 6);
                obtain.arg1 = i;
                obtain.arg2 = i2;
                obtain.obj = str;
                ICyberMsgHandler iCyberMsgHandler = this.b;
                if (iCyberMsgHandler != null) {
                    iCyberMsgHandler.sendMessage(obtain);
                    return true;
                }
                this.a.sendMessage(obtain);
                return true;
            }
            return true;
        }
    }

    public i(c cVar, CyberPlayerManager.HttpDNS httpDNS) {
        this.a = cVar;
        this.b = httpDNS;
        if (CyberPlayerManager.getCyberMediaContext() != null) {
            this.m = CyberPlayerManager.getCyberMediaContext().getCyberMsgHandler();
        }
        b bVar = new b(this.l, this.m, httpDNS);
        this.o = bVar;
        c cVar2 = this.a;
        if (cVar2 != null) {
            try {
                cVar2.a(bVar);
                h.a().a(this);
            } catch (RemoteException e) {
                e.printStackTrace();
            }
        }
    }

    @Override // com.baidu.cyberplayer.sdk.PlayerProvider
    public void changeProxyDynamic(String str, boolean z) {
        c cVar = this.a;
        if (cVar == null) {
            return;
        }
        try {
            cVar.a(str, z);
        } catch (RemoteException e) {
            e.printStackTrace();
            CyberPlayerManager.OnErrorListener onErrorListener = this.h;
            if (onErrorListener != null) {
                onErrorListener.onError(CyberPlayerManager.MEDIA_ERROR_REMOTE_EXCEPTION, CyberPlayerManager.MEDIA_ERROR_REMOTE_EXCEPTION, "changeProxyDynamic(String, boolean)");
            }
        }
    }

    @Override // com.baidu.cyberplayer.sdk.PlayerProvider
    public void seekTo(long j, int i) {
        c cVar = this.a;
        if (cVar == null) {
            return;
        }
        try {
            cVar.a(j, i);
        } catch (RemoteException e) {
            e.printStackTrace();
            CyberPlayerManager.OnErrorListener onErrorListener = this.h;
            if (onErrorListener != null) {
                onErrorListener.onError(CyberPlayerManager.MEDIA_ERROR_REMOTE_EXCEPTION, CyberPlayerManager.MEDIA_ERROR_REMOTE_EXCEPTION, "seekTo(long)");
            }
        }
    }

    @Override // com.baidu.cyberplayer.sdk.PlayerProvider
    public void setDataSource(Context context, Uri uri) {
        a(uri, (Map<String, String>) null);
    }

    @Override // com.baidu.cyberplayer.sdk.PlayerProvider
    public void setOption(String str, long j) {
        setOption(str, String.valueOf(j));
    }

    @Override // com.baidu.cyberplayer.sdk.PlayerProvider
    public void setVolume(float f, float f2) {
        c cVar = this.a;
        if (cVar == null) {
            return;
        }
        try {
            cVar.a(f, f2);
        } catch (RemoteException e) {
            e.printStackTrace();
            CyberPlayerManager.OnErrorListener onErrorListener = this.h;
            if (onErrorListener != null) {
                onErrorListener.onError(CyberPlayerManager.MEDIA_ERROR_REMOTE_EXCEPTION, CyberPlayerManager.MEDIA_ERROR_REMOTE_EXCEPTION, "setVolume(float, float)");
            }
        }
    }

    @Override // com.baidu.cyberplayer.sdk.PlayerProvider
    public void setWakeMode(Context context, int i) {
        c cVar = this.a;
        if (cVar == null) {
            return;
        }
        try {
            cVar.a(i);
        } catch (RemoteException e) {
            e.printStackTrace();
            CyberPlayerManager.OnErrorListener onErrorListener = this.h;
            if (onErrorListener != null) {
                onErrorListener.onError(CyberPlayerManager.MEDIA_ERROR_REMOTE_EXCEPTION, CyberPlayerManager.MEDIA_ERROR_REMOTE_EXCEPTION, "setWakeMode()");
            }
        }
    }

    @Override // com.baidu.cyberplayer.sdk.PlayerProvider
    public void switchMediaSource(int i, CyberPlayerManager.MediaSourceSwitchMode mediaSourceSwitchMode) {
        c cVar = this.a;
        if (cVar != null) {
            try {
                cVar.a(i, mediaSourceSwitchMode.ordinal());
            } catch (RemoteException e) {
                e.printStackTrace();
            }
        }
    }

    @Override // com.baidu.cyberplayer.sdk.PlayerProvider
    public void updateDisplaySize(int i, int i2) {
        try {
            if (this.a != null) {
                this.a.b(i, i2);
            }
        } catch (RemoteException e) {
            e.printStackTrace();
        }
    }

    @Override // com.baidu.cyberplayer.sdk.PlayerProvider
    public void getMediaRuntimeInfo(CyberPlayerManager.OnMediaRuntimeInfoListener onMediaRuntimeInfoListener) {
        c cVar = this.a;
        if (cVar == null) {
            return;
        }
        this.k = onMediaRuntimeInfoListener;
        try {
            cVar.r();
        } catch (Exception unused) {
        }
    }

    @Override // com.baidu.cyberplayer.sdk.PlayerProvider
    public void seekTo(long j) {
        seekTo(j, 3);
    }

    @Override // com.baidu.cyberplayer.sdk.PlayerProvider
    public void setClarityInfo(String str) {
        c cVar = this.a;
        if (cVar != null) {
            try {
                cVar.a(str);
            } catch (RemoteException e) {
                e.printStackTrace();
            }
        }
    }

    @Override // com.baidu.cyberplayer.sdk.PlayerProvider
    public void setDataSource(FileDescriptor fileDescriptor) {
        CyberPlayerManager.OnErrorListener onErrorListener = this.h;
        if (onErrorListener != null) {
            onErrorListener.onError(CyberPlayerManager.MEDIA_ERROR_REMOTE_EXCEPTION, CyberPlayerManager.MEDIA_ERROR_REMOTE_EXCEPTION, "setDataSource(FileDescriptor)");
        }
    }

    @Override // com.baidu.cyberplayer.sdk.PlayerProvider
    public void setDisplay(SurfaceHolder surfaceHolder) {
        Surface surface;
        if (this.a == null) {
            return;
        }
        if (surfaceHolder != null) {
            try {
                surface = surfaceHolder.getSurface();
            } catch (RemoteException e) {
                e.printStackTrace();
                CyberPlayerManager.OnErrorListener onErrorListener = this.h;
                if (onErrorListener != null) {
                    onErrorListener.onError(CyberPlayerManager.MEDIA_ERROR_REMOTE_EXCEPTION, CyberPlayerManager.MEDIA_ERROR_REMOTE_EXCEPTION, "setDisplay()");
                    return;
                }
                return;
            }
        } else {
            surface = null;
        }
        this.a.a(surface);
    }

    @Override // com.baidu.cyberplayer.sdk.PlayerProvider
    public void setEnableDumediaUA(boolean z) {
        c cVar = this.a;
        if (cVar == null) {
            return;
        }
        try {
            cVar.c(z);
        } catch (RemoteException e) {
            e.printStackTrace();
            CyberPlayerManager.OnErrorListener onErrorListener = this.h;
            if (onErrorListener != null) {
                onErrorListener.onError(CyberPlayerManager.MEDIA_ERROR_REMOTE_EXCEPTION, CyberPlayerManager.MEDIA_ERROR_REMOTE_EXCEPTION, "setEnableDumediaUA(boolean)");
            }
        }
    }

    @Override // com.baidu.cyberplayer.sdk.PlayerProvider
    public void setLooping(boolean z) {
        c cVar = this.a;
        if (cVar == null) {
            return;
        }
        try {
            cVar.b(z);
        } catch (RemoteException e) {
            e.printStackTrace();
            CyberPlayerManager.OnErrorListener onErrorListener = this.h;
            if (onErrorListener != null) {
                onErrorListener.onError(CyberPlayerManager.MEDIA_ERROR_REMOTE_EXCEPTION, CyberPlayerManager.MEDIA_ERROR_REMOTE_EXCEPTION, "setLooping(boolean)");
            }
        }
    }

    @Override // com.baidu.cyberplayer.sdk.PlayerProvider
    public void setOnBufferingUpdateListener(CyberPlayerManager.OnBufferingUpdateListener onBufferingUpdateListener) {
        this.e = onBufferingUpdateListener;
    }

    @Override // com.baidu.cyberplayer.sdk.PlayerProvider
    public void setOnCompletionListener(CyberPlayerManager.OnCompletionListener onCompletionListener) {
        this.d = onCompletionListener;
    }

    @Override // com.baidu.cyberplayer.sdk.PlayerProvider
    public void setOnErrorListener(CyberPlayerManager.OnErrorListener onErrorListener) {
        this.h = onErrorListener;
    }

    @Override // com.baidu.cyberplayer.sdk.PlayerProvider
    public void setOnInfoListener(CyberPlayerManager.OnInfoListener onInfoListener) {
        this.i = onInfoListener;
    }

    @Override // com.baidu.cyberplayer.sdk.PlayerProvider
    public void setOnMediaSourceChangedListener(CyberPlayerManager.OnMediaSourceChangedListener onMediaSourceChangedListener) {
        this.j = onMediaSourceChangedListener;
    }

    @Override // com.baidu.cyberplayer.sdk.PlayerProvider
    public void setOnPreparedListener(CyberPlayerManager.OnPreparedListener onPreparedListener) {
        this.c = onPreparedListener;
    }

    @Override // com.baidu.cyberplayer.sdk.PlayerProvider
    public void setOnSeekCompleteListener(CyberPlayerManager.OnSeekCompleteListener onSeekCompleteListener) {
        this.f = onSeekCompleteListener;
    }

    @Override // com.baidu.cyberplayer.sdk.PlayerProvider
    public void setOnVideoSizeChangedListener(CyberPlayerManager.OnVideoSizeChangedListener onVideoSizeChangedListener) {
        this.g = onVideoSizeChangedListener;
    }

    @Override // com.baidu.cyberplayer.sdk.PlayerProvider
    public void setPlayJson(String str) {
        try {
            if (this.a != null) {
                this.a.b(str);
            }
        } catch (RemoteException e) {
            e.printStackTrace();
            CyberPlayerManager.OnErrorListener onErrorListener = this.h;
            if (onErrorListener != null) {
                onErrorListener.onError(CyberPlayerManager.MEDIA_ERROR_REMOTE_EXCEPTION, CyberPlayerManager.MEDIA_ERROR_REMOTE_EXCEPTION, "setPlayJson(String)");
            }
        }
    }

    @Override // com.baidu.cyberplayer.sdk.PlayerProvider
    public void setScreenOnWhilePlaying(boolean z) {
        c cVar = this.a;
        if (cVar == null) {
            return;
        }
        try {
            cVar.a(z);
        } catch (RemoteException e) {
            e.printStackTrace();
            CyberPlayerManager.OnErrorListener onErrorListener = this.h;
            if (onErrorListener != null) {
                onErrorListener.onError(CyberPlayerManager.MEDIA_ERROR_REMOTE_EXCEPTION, CyberPlayerManager.MEDIA_ERROR_REMOTE_EXCEPTION, "setScreenOnWhilePlaying(boolean)");
            }
        }
    }

    @Override // com.baidu.cyberplayer.sdk.PlayerProvider
    public void setSpeed(float f) {
        c cVar = this.a;
        if (cVar == null) {
            return;
        }
        try {
            cVar.a(f);
        } catch (RemoteException e) {
            e.printStackTrace();
            CyberPlayerManager.OnErrorListener onErrorListener = this.h;
            if (onErrorListener != null) {
                onErrorListener.onError(CyberPlayerManager.MEDIA_ERROR_REMOTE_EXCEPTION, CyberPlayerManager.MEDIA_ERROR_REMOTE_EXCEPTION, "setSpeed(float)");
            }
        }
    }

    @Override // com.baidu.cyberplayer.sdk.PlayerProvider
    public void setSurface(Surface surface) {
        if (this.a == null) {
            return;
        }
        Surface surface2 = this.n;
        if (surface2 == surface && surface2 != null) {
            return;
        }
        try {
            this.a.a(surface);
            this.n = surface;
        } catch (RemoteException e) {
            e.printStackTrace();
            CyberPlayerManager.OnErrorListener onErrorListener = this.h;
            if (onErrorListener != null) {
                onErrorListener.onError(CyberPlayerManager.MEDIA_ERROR_REMOTE_EXCEPTION, CyberPlayerManager.MEDIA_ERROR_REMOTE_EXCEPTION, "setSurface()");
            }
            this.n = null;
        }
    }

    public static i a(int i, CyberPlayerManager.HttpDNS httpDNS) {
        c a2 = c.a.a(h.a().a(i));
        if (a2 != null) {
            return new i(a2, httpDNS);
        }
        return null;
    }

    @Override // com.baidu.cyberplayer.sdk.PlayerProvider
    public void setDataSource(String str, Map<String, String> map) {
        a(Uri.parse(str), map);
    }

    @Override // com.baidu.cyberplayer.sdk.PlayerProvider
    public void setOption(String str, String str2) {
        if (this.a == null) {
            return;
        }
        try {
            if (TextUtils.equals(str, CyberPlayerManager.OPT_FIRST_DISP_NOTIFY_SUB_T)) {
                this.p = TextUtils.equals(str2, "1");
            }
            this.a.a(str, str2);
        } catch (RemoteException e) {
            e.printStackTrace();
            CyberPlayerManager.OnErrorListener onErrorListener = this.h;
            if (onErrorListener != null) {
                onErrorListener.onError(CyberPlayerManager.MEDIA_ERROR_REMOTE_EXCEPTION, CyberPlayerManager.MEDIA_ERROR_REMOTE_EXCEPTION, "setOption(String, String)");
            }
        }
    }

    private void a(Uri uri, Map<String, String> map) {
        c cVar = this.a;
        if (cVar == null) {
            return;
        }
        try {
            cVar.a(new f(uri, map));
        } catch (RemoteException e) {
            e.printStackTrace();
            CyberPlayerManager.OnErrorListener onErrorListener = this.h;
            if (onErrorListener != null) {
                onErrorListener.onError(CyberPlayerManager.MEDIA_ERROR_REMOTE_EXCEPTION, CyberPlayerManager.MEDIA_ERROR_REMOTE_EXCEPTION, "setDataSource(Uri, Map)");
            }
        }
    }

    @Override // com.baidu.cyberplayer.sdk.remote.h.b
    public void a() {
        a aVar = this.l;
        if (aVar != null) {
            Message obtain = Message.obtain(aVar, 5);
            obtain.arg1 = CyberPlayerManager.MEDIA_ERROR_REMOTE_DIED;
            obtain.arg2 = CyberPlayerManager.MEDIA_ERROR_REMOTE_DIED;
            obtain.obj = "binderState=" + h.a().b();
            ICyberMsgHandler iCyberMsgHandler = this.m;
            if (iCyberMsgHandler != null) {
                iCyberMsgHandler.sendMessage(obtain);
            } else {
                this.l.sendMessage(obtain);
            }
        }
    }

    @Override // com.baidu.cyberplayer.sdk.PlayerProvider
    public int getDecodeMode() {
        c cVar = this.a;
        if (cVar != null) {
            try {
                return cVar.a();
            } catch (RemoteException e) {
                e.printStackTrace();
                CyberPlayerManager.OnErrorListener onErrorListener = this.h;
                if (onErrorListener != null) {
                    onErrorListener.onError(CyberPlayerManager.MEDIA_ERROR_REMOTE_EXCEPTION, CyberPlayerManager.MEDIA_ERROR_REMOTE_EXCEPTION, "getDecodeMode() binderState=" + h.a().b());
                }
            }
        }
        return 0;
    }

    @Override // com.baidu.cyberplayer.sdk.PlayerProvider
    public int getCurrentPosition() {
        int i = this.r;
        if (i > -1) {
            return i;
        }
        c cVar = this.a;
        if (cVar != null) {
            try {
                return cVar.j();
            } catch (RemoteException e) {
                e.printStackTrace();
            }
        }
        return 0;
    }

    @Override // com.baidu.cyberplayer.sdk.PlayerProvider
    public int getCurrentPositionSync() {
        c cVar = this.a;
        if (cVar != null) {
            try {
                return cVar.k();
            } catch (RemoteException e) {
                e.printStackTrace();
            }
        }
        return 0;
    }

    @Override // com.baidu.cyberplayer.sdk.PlayerProvider
    public long getDownloadSpeed() {
        c cVar = this.a;
        if (cVar != null) {
            try {
                return cVar.q();
            } catch (RemoteException e) {
                e.printStackTrace();
            }
        }
        return 0L;
    }

    @Override // com.baidu.cyberplayer.sdk.PlayerProvider
    public int getDuration() {
        int i = this.q;
        if (i > -1) {
            return i;
        }
        c cVar = this.a;
        if (cVar != null) {
            try {
                int l = cVar.l();
                this.q = l;
                return l;
            } catch (RemoteException e) {
                e.printStackTrace();
            }
        }
        return 0;
    }

    @Override // com.baidu.cyberplayer.sdk.PlayerProvider
    public long getPlayedTime() {
        c cVar = this.a;
        if (cVar != null) {
            try {
                return cVar.p();
            } catch (RemoteException e) {
                e.printStackTrace();
            }
        }
        return 0L;
    }

    @Override // com.baidu.cyberplayer.sdk.PlayerProvider
    public String getPlayerConfigOptions() {
        c cVar = this.a;
        if (cVar != null) {
            try {
                return cVar.s();
            } catch (RemoteException unused) {
            }
        }
        return "";
    }

    @Override // com.baidu.cyberplayer.sdk.PlayerProvider
    public int getVideoHeight() {
        c cVar = this.a;
        if (cVar != null) {
            try {
                return cVar.h();
            } catch (RemoteException e) {
                e.printStackTrace();
            }
        }
        return 0;
    }

    @Override // com.baidu.cyberplayer.sdk.PlayerProvider
    public int getVideoWidth() {
        c cVar = this.a;
        if (cVar != null) {
            try {
                return cVar.g();
            } catch (RemoteException e) {
                e.printStackTrace();
            }
        }
        return 0;
    }

    @Override // com.baidu.cyberplayer.sdk.PlayerProvider
    public boolean isLooping() {
        c cVar = this.a;
        if (cVar != null) {
            try {
                return cVar.o();
            } catch (RemoteException e) {
                e.printStackTrace();
            }
        }
        return false;
    }

    @Override // com.baidu.cyberplayer.sdk.PlayerProvider
    public boolean isPlaying() {
        c cVar = this.a;
        if (cVar != null) {
            try {
                return cVar.i();
            } catch (RemoteException e) {
                e.printStackTrace();
            }
        }
        return false;
    }

    @Override // com.baidu.cyberplayer.sdk.PlayerProvider
    public void pause() {
        c cVar = this.a;
        if (cVar == null) {
            return;
        }
        try {
            cVar.e();
        } catch (RemoteException e) {
            e.printStackTrace();
            CyberPlayerManager.OnErrorListener onErrorListener = this.h;
            if (onErrorListener != null) {
                onErrorListener.onError(CyberPlayerManager.MEDIA_ERROR_REMOTE_EXCEPTION, CyberPlayerManager.MEDIA_ERROR_REMOTE_EXCEPTION, "pause()");
            }
        }
    }

    @Override // com.baidu.cyberplayer.sdk.PlayerProvider
    public void prepareAsync() {
        c cVar = this.a;
        if (cVar == null) {
            return;
        }
        try {
            cVar.b();
        } catch (RemoteException e) {
            e.printStackTrace();
            CyberPlayerManager.OnErrorListener onErrorListener = this.h;
            if (onErrorListener != null) {
                onErrorListener.onError(CyberPlayerManager.MEDIA_ERROR_REMOTE_EXCEPTION, CyberPlayerManager.MEDIA_ERROR_REMOTE_EXCEPTION, "prepareAsync()");
            }
        }
    }

    @Override // com.baidu.cyberplayer.sdk.PlayerProvider
    public void reset() {
        c cVar = this.a;
        if (cVar == null) {
            return;
        }
        try {
            cVar.n();
            this.l.removeCallbacksAndMessages(null);
            if (this.m != null) {
                this.m.removeCallbacksAndMessages();
            }
        } catch (RemoteException e) {
            e.printStackTrace();
            CyberPlayerManager.OnErrorListener onErrorListener = this.h;
            if (onErrorListener != null) {
                onErrorListener.onError(CyberPlayerManager.MEDIA_ERROR_REMOTE_EXCEPTION, CyberPlayerManager.MEDIA_ERROR_REMOTE_EXCEPTION, "reset()");
            }
        }
        this.q = -1;
        this.r = -1;
    }

    @Override // com.baidu.cyberplayer.sdk.PlayerProvider
    public void start() {
        c cVar = this.a;
        if (cVar == null) {
            return;
        }
        try {
            cVar.c();
        } catch (RemoteException e) {
            e.printStackTrace();
            CyberPlayerManager.OnErrorListener onErrorListener = this.h;
            if (onErrorListener != null) {
                onErrorListener.onError(CyberPlayerManager.MEDIA_ERROR_REMOTE_EXCEPTION, CyberPlayerManager.MEDIA_ERROR_REMOTE_EXCEPTION, "start()");
            }
        }
    }

    @Override // com.baidu.cyberplayer.sdk.PlayerProvider
    public void stepToNextFrame() {
        c cVar = this.a;
        if (cVar == null) {
            return;
        }
        try {
            cVar.f();
        } catch (RemoteException e) {
            e.printStackTrace();
        }
    }

    @Override // com.baidu.cyberplayer.sdk.PlayerProvider
    public void stop() {
        c cVar = this.a;
        if (cVar == null) {
            return;
        }
        try {
            cVar.d();
        } catch (RemoteException e) {
            e.printStackTrace();
        }
    }

    @Override // com.baidu.cyberplayer.sdk.PlayerProvider
    public void muteOrUnmuteAudio(boolean z) {
        c cVar = this.a;
        if (cVar == null) {
            return;
        }
        try {
            cVar.d(z);
        } catch (RemoteException e) {
            e.printStackTrace();
            CyberPlayerManager.OnErrorListener onErrorListener = this.h;
            if (onErrorListener != null) {
                onErrorListener.onError(CyberPlayerManager.MEDIA_ERROR_REMOTE_EXCEPTION, CyberPlayerManager.MEDIA_ERROR_REMOTE_EXCEPTION, "muteOrUnmuteAudio(" + z + ") binderState=" + h.a().b());
            }
        }
    }

    /* JADX DEBUG: Another duplicated slice has different insns count: {[INVOKE, INVOKE, IPUT, IPUT, IGET, INVOKE, IGET, INVOKE, IPUT, IPUT, IGET]}, finally: {[INVOKE, INVOKE, IPUT, IPUT, IGET, INVOKE, IGET, INVOKE, IPUT, IPUT, IGET, IPUT, IPUT, IPUT, IPUT, IPUT, IPUT, IPUT, IPUT, IPUT, IPUT, IPUT, INVOKE, IPUT, IPUT, IPUT, IPUT, IPUT, IPUT, IPUT, IPUT, IPUT, IPUT, IPUT, IPUT, IF] complete} */
    /* JADX WARN: Code restructure failed: missing block: B:15:0x0050, code lost:
        if (r0 == null) goto L10;
     */
    /* JADX WARN: Code restructure failed: missing block: B:16:0x0052, code lost:
        r0.removeCallbacksAndMessages();
        r4.m = null;
     */
    /* JADX WARN: Code restructure failed: missing block: B:17:0x0057, code lost:
        r4.b = null;
        r4.c = null;
        r4.d = null;
        r4.e = null;
        r4.f = null;
        r4.g = null;
        r4.h = null;
        r4.i = null;
        r4.j = null;
        r4.q = -1;
        r4.r = -1;
     */
    /* JADX WARN: Code restructure failed: missing block: B:18:0x006d, code lost:
        return;
     */
    /* JADX WARN: Code restructure failed: missing block: B:8:0x002c, code lost:
        if (r0 != null) goto L12;
     */
    @Override // com.baidu.cyberplayer.sdk.PlayerProvider
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void release() {
        ICyberMsgHandler iCyberMsgHandler;
        c cVar = this.a;
        if (cVar == null) {
            return;
        }
        try {
            try {
                cVar.b(this.o);
                this.a.m();
                h.a().b(this);
                this.a = null;
                this.n = null;
                this.l.removeCallbacksAndMessages(null);
                this.o.d();
                this.o = null;
                this.l = null;
                iCyberMsgHandler = this.m;
            } catch (RemoteException e) {
                e.printStackTrace();
                h.a().b(this);
                this.a = null;
                this.n = null;
                this.l.removeCallbacksAndMessages(null);
                this.o.d();
                this.o = null;
                this.l = null;
                iCyberMsgHandler = this.m;
            }
        } catch (Throwable th) {
            h.a().b(this);
            this.a = null;
            this.n = null;
            this.l.removeCallbacksAndMessages(null);
            this.o.d();
            this.o = null;
            this.l = null;
            ICyberMsgHandler iCyberMsgHandler2 = this.m;
            if (iCyberMsgHandler2 != null) {
                iCyberMsgHandler2.removeCallbacksAndMessages();
                this.m = null;
            }
            this.b = null;
            this.c = null;
            this.d = null;
            this.e = null;
            this.f = null;
            this.g = null;
            this.h = null;
            this.i = null;
            this.j = null;
            this.q = -1;
            this.r = -1;
            throw th;
        }
    }

    @Override // com.baidu.cyberplayer.sdk.PlayerProvider
    public void sendCommand(int i, int i2, long j, String str) {
        c cVar = this.a;
        if (cVar == null) {
            return;
        }
        try {
            cVar.a(i, i2, j, str);
        } catch (RemoteException e) {
            e.printStackTrace();
            CyberPlayerManager.OnErrorListener onErrorListener = this.h;
            if (onErrorListener != null) {
                onErrorListener.onError(CyberPlayerManager.MEDIA_ERROR_REMOTE_EXCEPTION, CyberPlayerManager.MEDIA_ERROR_REMOTE_EXCEPTION, "sendCommand what=" + i + " arg1=" + i2 + " arg2=" + j + " binderState=" + h.a().b());
            }
        }
    }

    @Override // com.baidu.cyberplayer.sdk.PlayerProvider
    public void setDataSource(Context context, Uri uri, Map<String, String> map) {
        a(uri, map);
    }

    @Override // com.baidu.cyberplayer.sdk.PlayerProvider
    public void setDataSource(String str) {
        a(Uri.parse(str), (Map<String, String>) null);
    }
}
