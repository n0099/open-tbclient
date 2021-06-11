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
    public Map<String, WeakReference<MediaInstanceManagerProvider.OnClientInstanceHandler>> f8031a = new ConcurrentHashMap();

    /* renamed from: b  reason: collision with root package name */
    public List<Integer> f8032b = new ArrayList();

    /* renamed from: c  reason: collision with root package name */
    public int f8033c = 0;

    /* renamed from: d  reason: collision with root package name */
    public int f8034d;

    /* renamed from: e  reason: collision with root package name */
    public boolean f8035e;

    public MediaInstanceManagerImpl() {
        this.f8035e = true;
        int cfgIntValue = CyberCfgManager.getInstance().getCfgIntValue(CyberCfgManager.KEY_INT_MEDIA_INSTANCE_CAP, 4);
        this.f8034d = cfgIntValue;
        if (cfgIntValue <= 0) {
            this.f8035e = false;
        }
    }

    private native int activePlayer(int i2);

    private native String getInstanceOption(int i2, String str);

    private native Bundle getInstanceStatus(int i2, int i3);

    private native int registerPlayer();

    private native void setInstanceCapacity(int i2);

    private native void unRegisterPlayer(int i2);

    private native void updateInstanceOptions(int i2, String str, String str2);

    private native void updateTimestamp(int i2, long j);

    @Override // com.baidu.cyberplayer.sdk.MediaInstanceManagerProvider
    public synchronized void activeInstance(int i2) {
        MediaInstanceManagerProvider.OnClientInstanceHandler onClientInstanceHandler;
        MediaInstanceManagerProvider.OnClientInstanceHandler onClientInstanceHandler2;
        if (this.f8035e) {
            int activePlayer = activePlayer(i2);
            if (activePlayer > 0) {
                if (this.f8032b.contains(Integer.valueOf(i2))) {
                    WeakReference<MediaInstanceManagerProvider.OnClientInstanceHandler> weakReference = this.f8031a.get(String.valueOf(i2));
                    if (weakReference == null || (onClientInstanceHandler2 = weakReference.get()) == null) {
                        unRegisterPlayer(i2);
                        this.f8031a.remove(String.valueOf(i2));
                    } else {
                        onClientInstanceHandler2.onResumeInstance();
                    }
                    this.f8032b.remove(Integer.valueOf(i2));
                }
                WeakReference<MediaInstanceManagerProvider.OnClientInstanceHandler> weakReference2 = this.f8031a.get(String.valueOf(activePlayer));
                if (weakReference2 == null || (onClientInstanceHandler = weakReference2.get()) == null) {
                    unRegisterPlayer(activePlayer);
                    this.f8031a.remove(String.valueOf(activePlayer));
                } else {
                    onClientInstanceHandler.onDestroyInstance();
                    this.f8032b.add(Integer.valueOf(activePlayer));
                }
            }
        }
    }

    @Override // com.baidu.cyberplayer.sdk.MediaInstanceManagerProvider
    public String getInstanceOptionByKey(int i2, String str) {
        if (this.f8035e) {
            return getInstanceOption(i2, str);
        }
        return null;
    }

    @Override // com.baidu.cyberplayer.sdk.MediaInstanceManagerProvider
    public Bundle getInstanceStatusByType(int i2, int i3) {
        if (this.f8035e) {
            return getInstanceStatus(i2, i3);
        }
        return null;
    }

    @Override // com.baidu.cyberplayer.sdk.MediaInstanceManagerProvider
    public synchronized int registerInstance(MediaInstanceManagerProvider.OnClientInstanceHandler onClientInstanceHandler) {
        if (this.f8035e) {
            int registerPlayer = registerPlayer();
            if (registerPlayer > 0 && onClientInstanceHandler != null) {
                this.f8031a.put(String.valueOf(registerPlayer), new WeakReference<>(onClientInstanceHandler));
                if (this.f8033c != this.f8034d) {
                    setInstanceCapacity(this.f8034d);
                    this.f8033c = this.f8034d;
                }
                updateTimestamp(registerPlayer, System.currentTimeMillis());
            }
            return registerPlayer;
        }
        return 0;
    }

    @Override // com.baidu.cyberplayer.sdk.MediaInstanceManagerProvider
    public synchronized void unRegisterInstance(int i2) {
        if (this.f8035e) {
            if (this.f8032b.contains(Integer.valueOf(i2))) {
                this.f8032b.remove(Integer.valueOf(i2));
            }
            unRegisterPlayer(i2);
            this.f8031a.remove(String.valueOf(i2));
            for (String str : this.f8031a.keySet()) {
                if (this.f8031a.get(str).get() == null) {
                    unRegisterPlayer(Integer.parseInt(str));
                    this.f8031a.remove(str);
                }
            }
        }
    }

    @Override // com.baidu.cyberplayer.sdk.MediaInstanceManagerProvider
    public void updateInstanceTimestamp(int i2, long j) {
        if (this.f8035e) {
            updateTimestamp(i2, j);
        }
    }

    @Override // com.baidu.cyberplayer.sdk.MediaInstanceManagerProvider
    public void updateStringOption(int i2, String str, String str2) {
        if (this.f8035e) {
            updateInstanceOptions(i2, str, str2);
        }
    }
}
