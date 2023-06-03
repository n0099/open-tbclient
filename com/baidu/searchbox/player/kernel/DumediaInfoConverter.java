package com.baidu.searchbox.player.kernel;

import com.baidu.cyberplayer.sdk.CyberPlayerManager;
import com.baidu.searchbox.player.model.VideoUrlModel;
import com.baidu.searchbox.yy.gameassist.GameAssistConstKt;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
@Metadata(d1 = {"\u0000T\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0002\b\r\u0018\u00002\u00020\u00012\u00020\u00022\u00020\u00032\u00020\u00042\u00020\u00052\u00020\u00062\u00020\u00072\u00020\bB\u0011\u0012\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\n¢\u0006\u0002\u0010\u000bJ\u0010\u0010\u0014\u001a\u00020\u00152\u0006\u0010\u0016\u001a\u00020\u0017H\u0016J\b\u0010\u0018\u001a\u00020\u0015H\u0016J\"\u0010\u0019\u001a\u00020\u001a2\u0006\u0010\u0016\u001a\u00020\u00172\u0006\u0010\u001b\u001a\u00020\u00172\b\u0010\u001c\u001a\u0004\u0018\u00010\u001dH\u0016J\"\u0010\u001e\u001a\u00020\u001a2\u0006\u0010\u001f\u001a\u00020\u00172\u0006\u0010 \u001a\u00020\u00172\b\u0010\u001c\u001a\u0004\u0018\u00010\u001dH\u0016J\"\u0010!\u001a\u00020\u001a2\u0006\u0010\u0016\u001a\u00020\u00172\u0006\u0010\u001b\u001a\u00020\u00172\b\u0010\u001c\u001a\u0004\u0018\u00010\u001dH\u0016J\b\u0010\"\u001a\u00020\u0015H\u0016J\b\u0010#\u001a\u00020\u0015H\u0016J(\u0010$\u001a\u00020\u00152\u0006\u0010\u0016\u001a\u00020\u00172\u0006\u0010\u001b\u001a\u00020\u00172\u0006\u0010%\u001a\u00020\u00172\u0006\u0010&\u001a\u00020\u0017H\u0016J\u001a\u0010'\u001a\u00020\u00152\u0006\u0010\u001f\u001a\u00020\u00172\b\u0010(\u001a\u0004\u0018\u00010\u001dH\u0002J\u0010\u0010)\u001a\u00020\u00172\u0006\u0010\u001f\u001a\u00020\u0017H\u0002R\u0013\u0010\t\u001a\u0004\u0018\u00010\n¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u001c\u0010\u000e\u001a\u0004\u0018\u00010\u000fX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0010\u0010\u0011\"\u0004\b\u0012\u0010\u0013¨\u0006*"}, d2 = {"Lcom/baidu/searchbox/player/kernel/DumediaInfoConverter;", "Lcom/baidu/cyberplayer/sdk/CyberPlayerManager$OnPreparedListener;", "Lcom/baidu/cyberplayer/sdk/CyberPlayerManager$OnCompletionListener;", "Lcom/baidu/cyberplayer/sdk/CyberPlayerManager$OnErrorListener;", "Lcom/baidu/cyberplayer/sdk/CyberPlayerManager$OnInfoListener;", "Lcom/baidu/cyberplayer/sdk/CyberPlayerManager$OnSeekCompleteListener;", "Lcom/baidu/cyberplayer/sdk/CyberPlayerManager$OnBufferingUpdateListener;", "Lcom/baidu/cyberplayer/sdk/CyberPlayerManager$OnVideoSizeChangedListener;", "Lcom/baidu/cyberplayer/sdk/CyberPlayerManager$OnMediaSourceChangedListener;", "kernel", "Lcom/baidu/searchbox/player/kernel/AbsVideoKernel;", "(Lcom/baidu/searchbox/player/kernel/AbsVideoKernel;)V", "getKernel", "()Lcom/baidu/searchbox/player/kernel/AbsVideoKernel;", "playerCallback", "Lcom/baidu/searchbox/player/kernel/IKernelPlayer;", "getPlayerCallback", "()Lcom/baidu/searchbox/player/kernel/IKernelPlayer;", "setPlayerCallback", "(Lcom/baidu/searchbox/player/kernel/IKernelPlayer;)V", "onBufferingUpdate", "", "i", "", "onCompletion", GameAssistConstKt.TYPE_CALLBACK_ERROR, "", "i1", "o", "", "onInfo", "what", "extra", "onMediaSourceChanged", "onPrepared", "onSeekComplete", "onVideoSizeChanged", "i2", "i3", "recordKLogId", "obj", "transformInfoWhat", "core_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes4.dex */
public final class DumediaInfoConverter implements CyberPlayerManager.OnPreparedListener, CyberPlayerManager.OnCompletionListener, CyberPlayerManager.OnErrorListener, CyberPlayerManager.OnInfoListener, CyberPlayerManager.OnSeekCompleteListener, CyberPlayerManager.OnBufferingUpdateListener, CyberPlayerManager.OnVideoSizeChangedListener, CyberPlayerManager.OnMediaSourceChangedListener {
    public final AbsVideoKernel kernel;
    public IKernelPlayer playerCallback;

    public DumediaInfoConverter() {
        this(null, 1, null);
    }

    private final int transformInfoWhat(int i) {
        if (i != 701) {
            if (i != 702) {
                if (i != 904) {
                    if (i == 910) {
                        return 910;
                    }
                    if (i == 924) {
                        return 924;
                    }
                    if (i == 946) {
                        return 946;
                    }
                    if (i == 5000) {
                        return 5000;
                    }
                    if (i == 10009) {
                        return 10009;
                    }
                    if (i == 11008) {
                        return 11008;
                    }
                    if (i == 11016) {
                        return 11016;
                    }
                    if (i == 936) {
                        return 936;
                    }
                    if (i == 937) {
                        return 937;
                    }
                    if (i == 955) {
                        return 955;
                    }
                    if (i != 956) {
                        if (i != 10102) {
                            if (i != 10103) {
                                if (i != 12005) {
                                    if (i != 12006) {
                                        if (i != 12009) {
                                            if (i != 12010) {
                                                switch (i) {
                                                    case 11004:
                                                        return 11004;
                                                    case 11005:
                                                        return 11005;
                                                    case 11006:
                                                        return 11006;
                                                    default:
                                                        switch (i) {
                                                            case 11011:
                                                                return 11011;
                                                            case 11012:
                                                                return 11012;
                                                            case 11013:
                                                                return 11013;
                                                            case 11014:
                                                                return 11014;
                                                            default:
                                                                return i;
                                                        }
                                                }
                                            }
                                            return 12010;
                                        }
                                        return 12009;
                                    }
                                    return 12006;
                                }
                                return 12005;
                            }
                            return 10103;
                        }
                        return 10102;
                    }
                }
                return 904;
            }
            return 702;
        }
        return 701;
    }

    public DumediaInfoConverter(AbsVideoKernel absVideoKernel) {
        this.kernel = absVideoKernel;
    }

    @Override // com.baidu.cyberplayer.sdk.CyberPlayerManager.OnBufferingUpdateListener
    public void onBufferingUpdate(int i) {
        IKernelPlayer iKernelPlayer = this.playerCallback;
        if (iKernelPlayer != null) {
            iKernelPlayer.onBufferingUpdate(i);
        }
    }

    public final void setPlayerCallback(IKernelPlayer iKernelPlayer) {
        this.playerCallback = iKernelPlayer;
    }

    public /* synthetic */ DumediaInfoConverter(AbsVideoKernel absVideoKernel, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? null : absVideoKernel);
    }

    @Override // com.baidu.cyberplayer.sdk.CyberPlayerManager.OnErrorListener
    public boolean onError(int i, int i2, Object obj) {
        IKernelPlayer iKernelPlayer = this.playerCallback;
        if (iKernelPlayer != null) {
            return iKernelPlayer.onError(i, i2, obj);
        }
        return false;
    }

    @Override // com.baidu.cyberplayer.sdk.CyberPlayerManager.OnInfoListener
    public boolean onInfo(int i, int i2, Object obj) {
        int transformInfoWhat = transformInfoWhat(i);
        recordKLogId(i, obj);
        IKernelPlayer iKernelPlayer = this.playerCallback;
        if (iKernelPlayer != null) {
            return iKernelPlayer.onInfo(transformInfoWhat, i2, obj);
        }
        return false;
    }

    @Override // com.baidu.cyberplayer.sdk.CyberPlayerManager.OnMediaSourceChangedListener
    public boolean onMediaSourceChanged(int i, int i2, Object obj) {
        IKernelPlayer iKernelPlayer = this.playerCallback;
        if (iKernelPlayer != null) {
            return iKernelPlayer.onMediaSourceChanged(i, i2, obj);
        }
        return false;
    }

    private final void recordKLogId(int i, Object obj) {
        String str;
        AbsVideoKernel absVideoKernel = this.kernel;
        if (absVideoKernel != null && i == 11008) {
            VideoUrlModel videoUrlModel = absVideoKernel.getVideoUrlModel();
            if (obj != null) {
                str = obj.toString();
            } else {
                str = null;
            }
            if (str == null) {
                str = "";
            }
            videoUrlModel.setKLogId(str);
        }
    }

    public final AbsVideoKernel getKernel() {
        return this.kernel;
    }

    public final IKernelPlayer getPlayerCallback() {
        return this.playerCallback;
    }

    @Override // com.baidu.cyberplayer.sdk.CyberPlayerManager.OnCompletionListener
    public void onCompletion() {
        IKernelPlayer iKernelPlayer = this.playerCallback;
        if (iKernelPlayer != null) {
            iKernelPlayer.onCompletion();
        }
    }

    @Override // com.baidu.cyberplayer.sdk.CyberPlayerManager.OnPreparedListener
    public void onPrepared() {
        IKernelPlayer iKernelPlayer = this.playerCallback;
        if (iKernelPlayer != null) {
            iKernelPlayer.onPrepared();
        }
    }

    @Override // com.baidu.cyberplayer.sdk.CyberPlayerManager.OnSeekCompleteListener
    public void onSeekComplete() {
        IKernelPlayer iKernelPlayer = this.playerCallback;
        if (iKernelPlayer != null) {
            iKernelPlayer.onSeekComplete();
        }
    }

    @Override // com.baidu.cyberplayer.sdk.CyberPlayerManager.OnVideoSizeChangedListener
    public void onVideoSizeChanged(int i, int i2, int i3, int i4) {
        IKernelPlayer iKernelPlayer = this.playerCallback;
        if (iKernelPlayer != null) {
            iKernelPlayer.onVideoSizeChanged(i, i2, i3, i4);
        }
    }
}
