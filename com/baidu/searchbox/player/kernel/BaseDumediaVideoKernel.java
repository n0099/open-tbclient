package com.baidu.searchbox.player.kernel;

import android.net.Uri;
import android.text.TextUtils;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.baidu.cyberplayer.sdk.CyberPlayerManager;
import com.baidu.searchbox.player.interfaces.IDnsProcessListener;
import com.baidu.searchbox.player.model.BasicVideoSeries;
import com.baidu.searchbox.player.model.BasicVideoSeriesExt;
import com.baidu.searchbox.player.model.MPDUrlModel;
import com.baidu.searchbox.player.model.VideoUrlModel;
import java.util.List;
/* loaded from: classes4.dex */
public abstract class BaseDumediaVideoKernel extends AbsVideoKernel {
    public final DumediaInfoConverter mConverter = new DumediaInfoConverter(this);

    public abstract void setVideoViewCallBack(DumediaInfoConverter dumediaInfoConverter);

    /* loaded from: classes4.dex */
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
        String encodedUrl = ((MPDUrlModel) getVideoUrlModel()).getEncodedUrl();
        if (!TextUtils.isEmpty(encodedUrl)) {
            return Uri.parse(encodedUrl);
        }
        if (!TextUtils.isEmpty(((MPDUrlModel) getVideoUrlModel()).getVideoUrl())) {
            return Uri.parse(((MPDUrlModel) getVideoUrlModel()).getVideoUrl());
        }
        return null;
    }

    @Override // com.baidu.searchbox.player.kernel.AbsVideoKernel
    public void setKernelCallBack(IKernelPlayer iKernelPlayer) {
        this.mConverter.setPlayerCallback(iKernelPlayer);
        setVideoViewCallBack(this.mConverter);
    }

    @Override // com.baidu.searchbox.player.kernel.AbsVideoKernel
    @NonNull
    public VideoUrlModel transformVideoUrlModel(@Nullable BasicVideoSeries basicVideoSeries) {
        MPDUrlModel mPDUrlModel = new MPDUrlModel();
        if (basicVideoSeries != null) {
            mPDUrlModel.setVid(basicVideoSeries.getVid());
            mPDUrlModel.setVideoUrl(basicVideoSeries.getPlayUrl());
            mPDUrlModel.setEncodedUrl(basicVideoSeries.getEncodedUrl());
            mPDUrlModel.setNeedPrepare(basicVideoSeries.isNeedPrepare());
            mPDUrlModel.setPlayerStageType(basicVideoSeries.getPlayerStageType());
            mPDUrlModel.setOnlyCompareUriPath(BasicVideoSeriesExt.isOnlyCompareUriPath(basicVideoSeries));
        }
        if (!TextUtils.isEmpty(getKLogId()) && TextUtils.equals(getVideoUrlModel().getVid(), mPDUrlModel.getVid())) {
            mPDUrlModel.setKLogId(getVideoUrlModel().getKLogId());
        }
        return mPDUrlModel;
    }
}
