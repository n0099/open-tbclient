package com.baidu.media.duplayer;

import android.os.Bundle;
import com.baidu.cyberplayer.sdk.MediaInstanceManagerProvider;
import com.baidu.cyberplayer.sdk.config.CyberCfgManager;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
@Keep
/* loaded from: classes2.dex */
public class MediaInstanceManagerImpl extends MediaInstanceManagerProvider {

    /* renamed from: a  reason: collision with root package name */
    public Map<String, WeakReference<MediaInstanceManagerProvider.OnClientInstanceHandler>> f7948a = new ConcurrentHashMap();

    /* renamed from: b  reason: collision with root package name */
    public List<Integer> f7949b = new ArrayList();

    /* renamed from: c  reason: collision with root package name */
    public int f7950c = 0;

    /* renamed from: d  reason: collision with root package name */
    public int f7951d;

    /* renamed from: e  reason: collision with root package name */
    public boolean f7952e;

    public MediaInstanceManagerImpl() {
        this.f7952e = true;
        int cfgIntValue = CyberCfgManager.getInstance().getCfgIntValue(CyberCfgManager.KEY_INT_MEDIA_INSTANCE_CAP, 4);
        this.f7951d = cfgIntValue;
        if (cfgIntValue <= 0) {
            this.f7952e = false;
        }
    }

    private native int activePlayer(int i);

    private native String getInstanceOption(int i, String str);

    private native Bundle getInstanceStatus(int i, int i2);

    private native int registerPlayer();

    private native void setInstanceCapacity(int i);

    private native void unRegisterPlayer(int i);

    private native void updateInstanceOptions(int i, String str, String str2);

    private native void updateTimestamp(int i, long j);

    @Override // com.baidu.cyberplayer.sdk.MediaInstanceManagerProvider
    public synchronized void activeInstance(int i) {
        MediaInstanceManagerProvider.OnClientInstanceHandler onClientInstanceHandler;
        MediaInstanceManagerProvider.OnClientInstanceHandler onClientInstanceHandler2;
        if (this.f7952e) {
            int activePlayer = activePlayer(i);
            if (activePlayer > 0) {
                if (this.f7949b.contains(Integer.valueOf(i))) {
                    WeakReference<MediaInstanceManagerProvider.OnClientInstanceHandler> weakReference = this.f7948a.get(String.valueOf(i));
                    if (weakReference == null || (onClientInstanceHandler2 = weakReference.get()) == null) {
                        unRegisterPlayer(i);
                        this.f7948a.remove(String.valueOf(i));
                    } else {
                        onClientInstanceHandler2.onResumeInstance();
                    }
                    this.f7949b.remove(Integer.valueOf(i));
                }
                WeakReference<MediaInstanceManagerProvider.OnClientInstanceHandler> weakReference2 = this.f7948a.get(String.valueOf(activePlayer));
                if (weakReference2 == null || (onClientInstanceHandler = weakReference2.get()) == null) {
                    unRegisterPlayer(activePlayer);
                    this.f7948a.remove(String.valueOf(activePlayer));
                } else {
                    onClientInstanceHandler.onDestroyInstance();
                    this.f7949b.add(Integer.valueOf(activePlayer));
                }
            }
        }
    }

    @Override // com.baidu.cyberplayer.sdk.MediaInstanceManagerProvider
    public String getInstanceOptionByKey(int i, String str) {
        if (this.f7952e) {
            return getInstanceOption(i, str);
        }
        return null;
    }

    @Override // com.baidu.cyberplayer.sdk.MediaInstanceManagerProvider
    public Bundle getInstanceStatusByType(int i, int i2) {
        if (this.f7952e) {
            return getInstanceStatus(i, i2);
        }
        return null;
    }

    @Override // com.baidu.cyberplayer.sdk.MediaInstanceManagerProvider
    public synchronized int registerInstance(MediaInstanceManagerProvider.OnClientInstanceHandler onClientInstanceHandler) {
        if (this.f7952e) {
            int registerPlayer = registerPlayer();
            if (registerPlayer > 0 && onClientInstanceHandler != null) {
                this.f7948a.put(String.valueOf(registerPlayer), new WeakReference<>(onClientInstanceHandler));
                if (this.f7950c != this.f7951d) {
                    setInstanceCapacity(this.f7951d);
                    this.f7950c = this.f7951d;
                }
                updateTimestamp(registerPlayer, System.currentTimeMillis());
            }
            return registerPlayer;
        }
        return 0;
    }

    @Override // com.baidu.cyberplayer.sdk.MediaInstanceManagerProvider
    public synchronized void unRegisterInstance(int i) {
        if (this.f7952e) {
            if (this.f7949b.contains(Integer.valueOf(i))) {
                this.f7949b.remove(Integer.valueOf(i));
            }
            unRegisterPlayer(i);
            this.f7948a.remove(String.valueOf(i));
            for (String str : this.f7948a.keySet()) {
                if (this.f7948a.get(str).get() == null) {
                    unRegisterPlayer(Integer.parseInt(str));
                    this.f7948a.remove(str);
                }
            }
        }
    }

    @Override // com.baidu.cyberplayer.sdk.MediaInstanceManagerProvider
    public void updateInstanceTimestamp(int i, long j) {
        if (this.f7952e) {
            updateTimestamp(i, j);
        }
    }

    @Override // com.baidu.cyberplayer.sdk.MediaInstanceManagerProvider
    public void updateStringOption(int i, String str, String str2) {
        if (this.f7952e) {
            updateInstanceOptions(i, str, str2);
        }
    }
}
