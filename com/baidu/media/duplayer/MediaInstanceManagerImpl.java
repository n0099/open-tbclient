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
/* loaded from: classes18.dex */
public class MediaInstanceManagerImpl extends MediaInstanceManagerProvider {

    /* renamed from: a  reason: collision with root package name */
    private Map<String, WeakReference<MediaInstanceManagerProvider.OnClientInstanceHandler>> f2257a = new ConcurrentHashMap();
    private List<Integer> b = new ArrayList();
    private int c = 0;
    private int d = CyberCfgManager.getInstance().getCfgIntValue(CyberCfgManager.KEY_INT_MEDIA_INSTANCE_CAP, 4);
    private boolean e;

    public MediaInstanceManagerImpl() {
        this.e = true;
        if (this.d <= 0) {
            this.e = false;
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
        int activePlayer;
        MediaInstanceManagerProvider.OnClientInstanceHandler onClientInstanceHandler;
        MediaInstanceManagerProvider.OnClientInstanceHandler onClientInstanceHandler2;
        if (this.e && (activePlayer = activePlayer(i)) > 0) {
            if (this.b.contains(Integer.valueOf(i))) {
                WeakReference<MediaInstanceManagerProvider.OnClientInstanceHandler> weakReference = this.f2257a.get(String.valueOf(i));
                if (weakReference == null || (onClientInstanceHandler2 = weakReference.get()) == null) {
                    unRegisterPlayer(i);
                    this.f2257a.remove(String.valueOf(i));
                } else {
                    onClientInstanceHandler2.onResumeInstance();
                }
                this.b.remove(Integer.valueOf(i));
            }
            WeakReference<MediaInstanceManagerProvider.OnClientInstanceHandler> weakReference2 = this.f2257a.get(String.valueOf(activePlayer));
            if (weakReference2 == null || (onClientInstanceHandler = weakReference2.get()) == null) {
                unRegisterPlayer(activePlayer);
                this.f2257a.remove(String.valueOf(activePlayer));
            } else {
                onClientInstanceHandler.onDestroyInstance();
                this.b.add(Integer.valueOf(activePlayer));
            }
        }
    }

    @Override // com.baidu.cyberplayer.sdk.MediaInstanceManagerProvider
    public String getInstanceOptionByKey(int i, String str) {
        if (this.e) {
            return getInstanceOption(i, str);
        }
        return null;
    }

    @Override // com.baidu.cyberplayer.sdk.MediaInstanceManagerProvider
    public Bundle getInstanceStatusByType(int i, int i2) {
        if (this.e) {
            return getInstanceStatus(i, i2);
        }
        return null;
    }

    @Override // com.baidu.cyberplayer.sdk.MediaInstanceManagerProvider
    public synchronized int registerInstance(MediaInstanceManagerProvider.OnClientInstanceHandler onClientInstanceHandler) {
        int registerPlayer;
        if (this.e) {
            registerPlayer = registerPlayer();
            if (registerPlayer > 0 && onClientInstanceHandler != null) {
                this.f2257a.put(String.valueOf(registerPlayer), new WeakReference<>(onClientInstanceHandler));
                if (this.c != this.d) {
                    setInstanceCapacity(this.d);
                    this.c = this.d;
                }
                updateTimestamp(registerPlayer, System.currentTimeMillis());
            }
        } else {
            registerPlayer = 0;
        }
        return registerPlayer;
    }

    @Override // com.baidu.cyberplayer.sdk.MediaInstanceManagerProvider
    public synchronized void unRegisterInstance(int i) {
        if (this.e) {
            if (this.b.contains(Integer.valueOf(i))) {
                this.b.remove(Integer.valueOf(i));
            }
            unRegisterPlayer(i);
            this.f2257a.remove(String.valueOf(i));
            for (String str : this.f2257a.keySet()) {
                if (this.f2257a.get(str).get() == null) {
                    unRegisterPlayer(Integer.parseInt(str));
                    this.f2257a.remove(str);
                }
            }
        }
    }

    @Override // com.baidu.cyberplayer.sdk.MediaInstanceManagerProvider
    public void updateInstanceTimestamp(int i, long j) {
        if (this.e) {
            updateTimestamp(i, j);
        }
    }

    @Override // com.baidu.cyberplayer.sdk.MediaInstanceManagerProvider
    public void updateStringOption(int i, String str, String str2) {
        if (this.e) {
            updateInstanceOptions(i, str, str2);
        }
    }
}
