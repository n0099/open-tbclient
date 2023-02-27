package com.baidu.searchbox.player.kernel;

import android.net.Uri;
import android.text.TextUtils;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.baidu.cyberplayer.sdk.CyberPlayerManager;
import com.baidu.searchbox.player.interfaces.IDnsProcessListener;
import com.baidu.searchbox.player.model.MPDUrlModel;
import com.baidu.searchbox.player.model.VideoUrlModel;
import java.util.List;
/* loaded from: classes2.dex */
public abstract class BaseDumediaVideoKernel extends AbsVideoKernel {
    public final DumediaInfoConverter mConverter = new DumediaInfoConverter(this);

    public abstract void setVideoViewCallBack(DumediaInfoConverter dumediaInfoConverter);

    /* loaded from: classes2.dex */
    public static final class CyberPlayerHttpDNS implements CyberPlayerManager.HttpDNS {
        public final IDnsProcessListener dns;

        public CyberPlayerHttpDNS(@NonNull IDnsProcessListener iDnsProcessListener) {
            this.dns = iDnsProcessListener;
        }

        @Override // com.baidu.cyberplayer.sdk.CyberPlayerManager.HttpDNS
        public List<String> getIpList(String str) {
            return this.dns.getIpList(str, false);
        }
    }

    @Nullable
    public Uri getVideoUri() {
        VideoUrlModel videoUrlModel = this.mUrlModel;
        if (videoUrlModel instanceof MPDUrlModel) {
            String str = ((MPDUrlModel) videoUrlModel).mpdUrl;
            if (!TextUtils.isEmpty(str)) {
                return Uri.parse(str);
            }
            return null;
        } else if (videoUrlModel != null && !TextUtils.isEmpty(videoUrlModel.videoUrl)) {
            return Uri.parse(this.mUrlModel.videoUrl);
        } else {
            return null;
        }
    }

    @Override // com.baidu.searchbox.player.kernel.AbsVideoKernel
    public void setKernelCallBack(IKernelPlayer iKernelPlayer) {
        this.mConverter.setPlayerCallback(iKernelPlayer);
        setVideoViewCallBack(this.mConverter);
    }
}
