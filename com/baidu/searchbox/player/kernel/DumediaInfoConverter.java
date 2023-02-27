package com.baidu.searchbox.player.kernel;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.baidu.cyberplayer.sdk.CyberPlayerManager;
/* loaded from: classes2.dex */
public class DumediaInfoConverter implements CyberPlayerManager.OnPreparedListener, CyberPlayerManager.OnCompletionListener, CyberPlayerManager.OnErrorListener, CyberPlayerManager.OnInfoListener, CyberPlayerManager.OnSeekCompleteListener, CyberPlayerManager.OnBufferingUpdateListener, CyberPlayerManager.OnVideoSizeChangedListener, CyberPlayerManager.OnMediaSourceChangedListener {
    public final AbsVideoKernel mKernel;
    public IKernelPlayer mPlayerCallback;

    private int transformInfoWhat(int i) {
        if (i != 701) {
            if (i != 702) {
                if (i != 904) {
                    if (i != 910) {
                        if (i != 924) {
                            if (i != 946) {
                                if (i != 5000) {
                                    if (i != 10009) {
                                        if (i != 10103) {
                                            if (i != 11008) {
                                                if (i != 936) {
                                                    if (i != 937) {
                                                        if (i != 955) {
                                                            if (i != 956) {
                                                                if (i != 11004) {
                                                                    if (i != 11005) {
                                                                        if (i != 12005) {
                                                                            if (i != 12006) {
                                                                                return i;
                                                                            }
                                                                            return 12006;
                                                                        }
                                                                        return 12005;
                                                                    }
                                                                    return 11005;
                                                                }
                                                                return 11004;
                                                            }
                                                            return 956;
                                                        }
                                                        return 955;
                                                    }
                                                    return 937;
                                                }
                                                return 936;
                                            }
                                            return 11008;
                                        }
                                        return 10103;
                                    }
                                    return 10009;
                                }
                                return 5000;
                            }
                            return 946;
                        }
                        return 924;
                    }
                    return 910;
                }
                return 904;
            }
            return 702;
        }
        return 701;
    }

    public DumediaInfoConverter(@NonNull AbsVideoKernel absVideoKernel) {
        this.mKernel = absVideoKernel;
    }

    @Override // com.baidu.cyberplayer.sdk.CyberPlayerManager.OnBufferingUpdateListener
    public void onBufferingUpdate(int i) {
        IKernelPlayer iKernelPlayer = this.mPlayerCallback;
        if (iKernelPlayer != null) {
            iKernelPlayer.onBufferingUpdate(i);
        }
    }

    public void setPlayerCallback(@Nullable IKernelPlayer iKernelPlayer) {
        this.mPlayerCallback = iKernelPlayer;
    }

    private void processInternalAction(int i, Object obj) {
        if (i == 11008) {
            this.mKernel.setKernelLogId(String.valueOf(obj));
        }
    }

    @Override // com.baidu.cyberplayer.sdk.CyberPlayerManager.OnCompletionListener
    public void onCompletion() {
        IKernelPlayer iKernelPlayer = this.mPlayerCallback;
        if (iKernelPlayer != null) {
            iKernelPlayer.onCompletion();
        }
    }

    @Override // com.baidu.cyberplayer.sdk.CyberPlayerManager.OnPreparedListener
    public void onPrepared() {
        IKernelPlayer iKernelPlayer = this.mPlayerCallback;
        if (iKernelPlayer != null) {
            iKernelPlayer.onPrepared();
        }
    }

    @Override // com.baidu.cyberplayer.sdk.CyberPlayerManager.OnSeekCompleteListener
    public void onSeekComplete() {
        IKernelPlayer iKernelPlayer = this.mPlayerCallback;
        if (iKernelPlayer != null) {
            iKernelPlayer.onSeekComplete();
        }
    }

    @Override // com.baidu.cyberplayer.sdk.CyberPlayerManager.OnErrorListener
    public boolean onError(int i, int i2, Object obj) {
        IKernelPlayer iKernelPlayer = this.mPlayerCallback;
        if (iKernelPlayer != null) {
            return iKernelPlayer.onError(i, i2, obj);
        }
        return false;
    }

    @Override // com.baidu.cyberplayer.sdk.CyberPlayerManager.OnInfoListener
    public boolean onInfo(int i, int i2, Object obj) {
        if (this.mPlayerCallback != null) {
            processInternalAction(i, obj);
            return this.mPlayerCallback.onInfo(transformInfoWhat(i), i2, obj);
        }
        return false;
    }

    @Override // com.baidu.cyberplayer.sdk.CyberPlayerManager.OnMediaSourceChangedListener
    public boolean onMediaSourceChanged(int i, int i2, Object obj) {
        IKernelPlayer iKernelPlayer = this.mPlayerCallback;
        if (iKernelPlayer != null) {
            return iKernelPlayer.onMediaSourceChanged(i, i2, obj);
        }
        return false;
    }

    @Override // com.baidu.cyberplayer.sdk.CyberPlayerManager.OnVideoSizeChangedListener
    public void onVideoSizeChanged(int i, int i2, int i3, int i4) {
        IKernelPlayer iKernelPlayer = this.mPlayerCallback;
        if (iKernelPlayer != null) {
            iKernelPlayer.onVideoSizeChanged(i, i2, i3, i4);
        }
    }
}
