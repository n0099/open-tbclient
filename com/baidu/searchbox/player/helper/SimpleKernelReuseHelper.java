package com.baidu.searchbox.player.helper;

import android.app.Activity;
import com.baidu.searchbox.download.util.LocalFilesFilterKt;
import com.baidu.searchbox.live.interfaces.DI;
import com.baidu.searchbox.player.BDPlayerConfig;
import com.baidu.searchbox.player.BDVideoPlayer;
import com.baidu.searchbox.player.assistant.KernelCacheAssistant;
import com.baidu.searchbox.player.callback.InternalKernelCallback;
import com.baidu.searchbox.player.kernel.AbsVideoKernel;
import com.baidu.searchbox.player.layer.BaseKernelLayer;
import com.baidu.searchbox.player.message.IMessenger;
import com.baidu.searchbox.player.model.BasicVideoSeries;
import com.baidu.searchbox.player.ubc.PlayerStatConstants;
import com.baidu.searchbox.player.utils.BdPlayerUtils;
import com.baidu.searchbox.player.utils.BdVideoLog;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt__StringsJVMKt;
@Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0016\u0018\u0000 '2\u00020\u0001:\u0001'B\u0005¢\u0006\u0002\u0010\u0002J\u001a\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u00102\b\u0010\u0011\u001a\u0004\u0018\u00010\u0004H\u0014J\u0012\u0010\u0012\u001a\u00020\u00042\b\u0010\u0013\u001a\u0004\u0018\u00010\u0014H\u0014J\u001a\u0010\u0015\u001a\u00020\u00042\u0006\u0010\u000f\u001a\u00020\u00102\b\u0010\u0016\u001a\u0004\u0018\u00010\u0004H\u0016J\u001c\u0010\u0017\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u000f\u001a\u00020\u00102\b\u0010\u0018\u001a\u0004\u0018\u00010\u0014H\u0016J\u0010\u0010\u0019\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u0010H\u0016J\"\u0010\u001a\u001a\u00020\u001b2\u0006\u0010\u000f\u001a\u00020\u00102\b\u0010\u0018\u001a\u0004\u0018\u00010\u00142\u0006\u0010\u001c\u001a\u00020\u001bH\u0016J\u0010\u0010\u001d\u001a\u00020\u000e2\b\u0010\u0011\u001a\u0004\u0018\u00010\u0004J\u001a\u0010\u001e\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u00102\b\u0010\u001f\u001a\u0004\u0018\u00010\u0014H\u0016J\u0010\u0010 \u001a\u00020\u000e2\u0006\u0010!\u001a\u00020\u0014H\u0002J\u001a\u0010\"\u001a\u00020\u000e2\b\u0010\u0011\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u000f\u001a\u00020\u0010H\u0016J\u001a\u0010#\u001a\u00020\u000e2\u0006\u0010$\u001a\u00020\u00042\b\u0010%\u001a\u0004\u0018\u00010&H\u0014R\u001c\u0010\u0003\u001a\u0004\u0018\u00010\u0004X\u0084\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR\u0010\u0010\t\u001a\u0004\u0018\u00010\u0004X\u0082\u000e¢\u0006\u0002\n\u0000R\u001c\u0010\n\u001a\u0004\u0018\u00010\u0004X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\u0006\"\u0004\b\f\u0010\b¨\u0006("}, d2 = {"Lcom/baidu/searchbox/player/helper/SimpleKernelReuseHelper;", "Lcom/baidu/searchbox/player/helper/AbsKernelReuseHelper;", "()V", "currentKernelLayer", "Lcom/baidu/searchbox/player/layer/BaseKernelLayer;", "getCurrentKernelLayer", "()Lcom/baidu/searchbox/player/layer/BaseKernelLayer;", "setCurrentKernelLayer", "(Lcom/baidu/searchbox/player/layer/BaseKernelLayer;)V", "lastKernelLayer", "originKernelLayer", "getOriginKernelLayer", "setOriginKernelLayer", "attachKernelToPlayer", "", DI.LIVE_PLAYER, "Lcom/baidu/searchbox/player/BDVideoPlayer;", "kernelLayer", "createBackupKernelLayer", "type", "", "getKernelLayer", "originLayer", "getValidCache", "cacheKey", "onReleaseKernelLayer", "performAutoDetachCache", "", "isForce", "performReleaseKernelLayer", "performSwitchKernel", PlayerStatConstants.STAT_KEY_KERNEL_TYPE, "printLog", LocalFilesFilterKt.FILTER_NAME_LOG, "processCacheKernelLayer", "setupKernelLayer", "kernel", "series", "Lcom/baidu/searchbox/player/model/BasicVideoSeries;", "Companion", "bdvideoplayer-core"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes4.dex */
public class SimpleKernelReuseHelper extends AbsKernelReuseHelper {
    public static final Companion Companion = new Companion(null);
    public static final String TAG = "SimpleKernelReuseHelper";
    public BaseKernelLayer currentKernelLayer;
    public BaseKernelLayer lastKernelLayer;
    public BaseKernelLayer originKernelLayer;

    public void processCacheKernelLayer(BaseKernelLayer baseKernelLayer, BDVideoPlayer player) {
        Intrinsics.checkNotNullParameter(player, "player");
    }

    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000¨\u0006\u0005"}, d2 = {"Lcom/baidu/searchbox/player/helper/SimpleKernelReuseHelper$Companion;", "", "()V", "TAG", "", "bdvideoplayer-core"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* loaded from: classes4.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public Companion() {
        }
    }

    public final BaseKernelLayer getCurrentKernelLayer() {
        return this.currentKernelLayer;
    }

    public final BaseKernelLayer getOriginKernelLayer() {
        return this.originKernelLayer;
    }

    private final void printLog(String str) {
        BdVideoLog.d(TAG, str);
    }

    public BaseKernelLayer createBackupKernelLayer(String str) {
        if (str == null) {
            str = AbsVideoKernel.CYBER_PLAYER;
        }
        return new BaseKernelLayer(str);
    }

    public final void performReleaseKernelLayer(BaseKernelLayer baseKernelLayer) {
        if (baseKernelLayer != null) {
            baseKernelLayer.pause();
            baseKernelLayer.stop();
            baseKernelLayer.release();
        }
    }

    public final void setCurrentKernelLayer(BaseKernelLayer baseKernelLayer) {
        this.currentKernelLayer = baseKernelLayer;
    }

    public final void setOriginKernelLayer(BaseKernelLayer baseKernelLayer) {
        this.originKernelLayer = baseKernelLayer;
    }

    public void attachKernelToPlayer(BDVideoPlayer player, BaseKernelLayer baseKernelLayer) {
        Intrinsics.checkNotNullParameter(player, "player");
        if (baseKernelLayer != null) {
            player.attachKernelLayer(baseKernelLayer);
        }
    }

    @Override // com.baidu.searchbox.player.helper.AbsKernelReuseHelper, com.baidu.searchbox.player.interfaces.IKernelLayerReuseHelper
    public BaseKernelLayer getKernelLayer(BDVideoPlayer player, BaseKernelLayer baseKernelLayer) {
        Intrinsics.checkNotNullParameter(player, "player");
        if (player.isUseCacheEnable()) {
            baseKernelLayer = getValidCache(player, player.getKLayerCacheKey());
            processCacheKernelLayer(baseKernelLayer, player);
        }
        if (baseKernelLayer == null) {
            baseKernelLayer = createBackupKernelLayer(player.getBackupKernelType());
        }
        this.originKernelLayer = baseKernelLayer;
        return baseKernelLayer;
    }

    public void setupKernelLayer(BaseKernelLayer kernel, BasicVideoSeries basicVideoSeries) {
        Intrinsics.checkNotNullParameter(kernel, "kernel");
        if (basicVideoSeries != null) {
            IMessenger messenger = BDPlayerConfig.getMessengerFactory().createMessenger();
            Intrinsics.checkNotNullExpressionValue(messenger, "messenger");
            kernel.attachMessenger(messenger);
            kernel.setKernelCallBack(new InternalKernelCallback(messenger));
            if (basicVideoSeries.isValid()) {
                basicVideoSeries.setNeedPrepare(true);
                kernel.setVideoSeries(basicVideoSeries);
            }
        }
    }

    @Override // com.baidu.searchbox.player.helper.AbsKernelReuseHelper, com.baidu.searchbox.player.interfaces.IKernelLayerReuseHelper
    public BaseKernelLayer getValidCache(BDVideoPlayer player, String str) {
        Boolean bool;
        String str2;
        AbsVideoKernel videoKernel;
        Intrinsics.checkNotNullParameter(player, "player");
        BaseKernelLayer cache = KernelCacheAssistant.get().getCache(str);
        String str3 = null;
        if (cache != null && (videoKernel = cache.getVideoKernel()) != null) {
            bool = Boolean.valueOf(videoKernel.verify(player.getBackupKernelType()));
        } else {
            bool = null;
        }
        boolean z = false;
        if (cache == null) {
            player.setUseCache(false);
            if (player.getPlayerKernelLayer() == null) {
                BaseKernelLayer createBackupKernelLayer = createBackupKernelLayer(player.getBackupKernelType());
                setupKernelLayer(createBackupKernelLayer, player.getVideoSeries());
                return createBackupKernelLayer;
            }
        } else if (Intrinsics.areEqual(bool, Boolean.TRUE)) {
            KernelCacheAssistant.get().removeCache(str);
            player.setUseCache(true);
            BDVideoPlayer bindPlayer = cache.getBindPlayer();
            if (bindPlayer != null) {
                bindPlayer.detachKernelLayer();
            }
            BasicVideoSeries videoSeries = player.getVideoSeries();
            if (videoSeries != null) {
                str2 = videoSeries.getVid();
            } else {
                str2 = null;
            }
            if (!((str2 == null || StringsKt__StringsJVMKt.isBlank(str2)) ? true : true)) {
                String vid = cache.getVid();
                BasicVideoSeries videoSeries2 = player.getVideoSeries();
                if (videoSeries2 != null) {
                    str3 = videoSeries2.getVid();
                }
                if (!Intrinsics.areEqual(vid, str3)) {
                    setupKernelLayer(cache, player.getVideoSeries());
                    return cache;
                }
                return cache;
            }
            return cache;
        } else {
            player.setUseCache(false);
        }
        return null;
    }

    @Override // com.baidu.searchbox.player.interfaces.IKernelLayerReuseHelper
    public void onReleaseKernelLayer(BDVideoPlayer player) {
        Intrinsics.checkNotNullParameter(player, "player");
        performAutoDetachCache(player, player.getKLayerCacheKey(), true);
        BaseKernelLayer detachKernelLayer = player.detachKernelLayer();
        if (detachKernelLayer != null) {
            if (!Intrinsics.areEqual(detachKernelLayer, this.currentKernelLayer)) {
                performReleaseKernelLayer(this.currentKernelLayer);
                this.currentKernelLayer = null;
            } else if (!Intrinsics.areEqual(detachKernelLayer, this.originKernelLayer)) {
                performReleaseKernelLayer(this.originKernelLayer);
                this.originKernelLayer = null;
            }
            performReleaseKernelLayer(this.lastKernelLayer);
            this.lastKernelLayer = null;
            performReleaseKernelLayer(detachKernelLayer);
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:13:0x0027, code lost:
        if (r2 == false) goto L28;
     */
    /* JADX WARN: Code restructure failed: missing block: B:14:0x0029, code lost:
        if (r9 != false) goto L13;
     */
    /* JADX WARN: Code restructure failed: missing block: B:15:0x002b, code lost:
        com.baidu.searchbox.player.utils.BdVideoLog.d(com.baidu.searchbox.player.helper.SimpleKernelReuseHelper.TAG, "performAutoDetachCache begin");
        r0 = r7.getPlayerKernelLayer();
        r2 = r6.originKernelLayer;
     */
    /* JADX WARN: Code restructure failed: missing block: B:16:0x003a, code lost:
        if (r2 == null) goto L27;
     */
    /* JADX WARN: Code restructure failed: missing block: B:17:0x003c, code lost:
        r2 = r2.getBindPlayer();
     */
    /* JADX WARN: Code restructure failed: missing block: B:18:0x0041, code lost:
        r2 = null;
     */
    /* JADX WARN: Code restructure failed: missing block: B:20:0x0048, code lost:
        if (kotlin.jvm.internal.Intrinsics.areEqual(r2, r7) == false) goto L21;
     */
    /* JADX WARN: Code restructure failed: missing block: B:21:0x004a, code lost:
        com.baidu.searchbox.player.utils.BdVideoLog.d(com.baidu.searchbox.player.helper.SimpleKernelReuseHelper.TAG, "autoDetachCache,cacheKey:" + r8 + ", kernelLayer:" + r0);
     */
    /* JADX WARN: Code restructure failed: missing block: B:22:0x0068, code lost:
        if (detachCache(r7, r8) == false) goto L29;
     */
    /* JADX WARN: Code restructure failed: missing block: B:23:0x006a, code lost:
        r6.originKernelLayer = null;
     */
    /* JADX WARN: Code restructure failed: missing block: B:25:0x006f, code lost:
        if (r6.originKernelLayer == null) goto L29;
     */
    /* JADX WARN: Code restructure failed: missing block: B:26:0x0071, code lost:
        com.baidu.searchbox.player.utils.BdVideoLog.d(com.baidu.searchbox.player.helper.SimpleKernelReuseHelper.TAG, "detachCache,cacheKey:" + r8 + ", kernelLayer:" + r0);
        r7 = r6.originKernelLayer;
     */
    /* JADX WARN: Code restructure failed: missing block: B:27:0x008d, code lost:
        if (r7 == null) goto L26;
     */
    /* JADX WARN: Code restructure failed: missing block: B:28:0x008f, code lost:
        r7.pause();
     */
    /* JADX WARN: Code restructure failed: missing block: B:29:0x0092, code lost:
        com.baidu.searchbox.player.assistant.KernelCacheAssistant.get().putCache(r8, r6.originKernelLayer);
        r6.originKernelLayer = null;
     */
    @Override // com.baidu.searchbox.player.helper.AbsKernelReuseHelper
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public boolean performAutoDetachCache(BDVideoPlayer player, String str, boolean z) {
        Intrinsics.checkNotNullParameter(player, "player");
        if (player.isUseCacheEnable() && player.isUseCache()) {
            if (!player.isForeground()) {
                Activity activity = player.getActivity();
                boolean z2 = false;
                if (activity != null && activity.isFinishing()) {
                    z2 = true;
                }
            }
        }
        return true;
    }

    @Override // com.baidu.searchbox.player.interfaces.IKernelLayerReuseHelper
    public void performSwitchKernel(BDVideoPlayer player, String str) {
        String str2;
        AbsVideoKernel videoKernel;
        Intrinsics.checkNotNullParameter(player, "player");
        printLog("目标内核>>>>>> " + str + " 原始内核>>>>>> " + BdPlayerUtils.kernelType(this.originKernelLayer));
        BaseKernelLayer playerKernelLayer = player.getPlayerKernelLayer();
        if (playerKernelLayer != null && (videoKernel = playerKernelLayer.getVideoKernel()) != null) {
            str2 = videoKernel.getKernelType();
        } else {
            str2 = null;
        }
        if (str != null && !Intrinsics.areEqual(str2, str)) {
            if (Intrinsics.areEqual(BdPlayerUtils.kernelType(this.originKernelLayer), str) && !Intrinsics.areEqual(BdPlayerUtils.kernelType(this.originKernelLayer), str2)) {
                printLog("使用原始内核");
                attachKernelToPlayer(player, this.originKernelLayer);
                return;
            }
            BaseKernelLayer baseKernelLayer = this.currentKernelLayer;
            if (baseKernelLayer == null) {
                BaseKernelLayer createBackupKernelLayer = createBackupKernelLayer(str);
                this.currentKernelLayer = createBackupKernelLayer;
                attachKernelToPlayer(player, createBackupKernelLayer);
                if (!player.isUseCache()) {
                    this.lastKernelLayer = this.originKernelLayer;
                }
                printLog("当前内核为空,创建新内核使用 " + str);
                return;
            }
            String kernelType = BdPlayerUtils.kernelType(baseKernelLayer);
            if (!Intrinsics.areEqual(kernelType, str)) {
                printLog("当前内核不符合要求 " + kernelType);
                BaseKernelLayer baseKernelLayer2 = this.lastKernelLayer;
                if (baseKernelLayer2 == null) {
                    printLog("上一个内核为空，创建新内核");
                    this.lastKernelLayer = this.currentKernelLayer;
                    BaseKernelLayer createBackupKernelLayer2 = createBackupKernelLayer(str);
                    this.currentKernelLayer = createBackupKernelLayer2;
                    attachKernelToPlayer(player, createBackupKernelLayer2);
                    printLog("切换后:currentKernel= " + BdPlayerUtils.kernelType(this.currentKernelLayer) + ", lastKernel= " + BdPlayerUtils.kernelType(this.lastKernelLayer));
                    return;
                } else if (Intrinsics.areEqual(BdPlayerUtils.kernelType(baseKernelLayer2), str)) {
                    BaseKernelLayer baseKernelLayer3 = this.lastKernelLayer;
                    printLog("使用上一个内核 切换前: currentKernel= " + BdPlayerUtils.kernelType(this.currentKernelLayer) + ", lastKernel= $" + BdPlayerUtils.kernelType(this.lastKernelLayer));
                    attachKernelToPlayer(player, baseKernelLayer3);
                    this.lastKernelLayer = this.currentKernelLayer;
                    this.currentKernelLayer = baseKernelLayer3;
                    printLog("使用上一个内核 切换后: currentKernel= " + BdPlayerUtils.kernelType(this.currentKernelLayer) + ", lastKernel= $" + BdPlayerUtils.kernelType(this.lastKernelLayer));
                    return;
                } else {
                    BdVideoLog.d(TAG, "所有内核不符合，释放上一个内核 lastKernel= " + BdPlayerUtils.kernelType(this.lastKernelLayer));
                    performReleaseKernelLayer(this.lastKernelLayer);
                    this.lastKernelLayer = this.currentKernelLayer;
                    BaseKernelLayer createBackupKernelLayer3 = createBackupKernelLayer(str);
                    this.currentKernelLayer = createBackupKernelLayer3;
                    attachKernelToPlayer(player, createBackupKernelLayer3);
                    printLog("创建一个新内核: currentKernel= " + BdPlayerUtils.kernelType(this.currentKernelLayer) + ", lastKernel= " + BdPlayerUtils.kernelType(this.lastKernelLayer));
                    return;
                }
            }
            printLog("当前内核符合要求");
            if (!Intrinsics.areEqual(this.lastKernelLayer, player.getPlayerKernelLayer())) {
                printLog("释放上一个playerKernelLayer= " + player.getPlayerKernelLayer() + ", lastKernel= " + BdPlayerUtils.kernelType(this.lastKernelLayer));
                performReleaseKernelLayer(this.lastKernelLayer);
                this.lastKernelLayer = player.getPlayerKernelLayer();
            }
            attachKernelToPlayer(player, this.currentKernelLayer);
            printLog("替换内核currentKernel= " + kernelType + ", lastKernel= " + BdPlayerUtils.kernelType(this.lastKernelLayer));
            return;
        }
        printLog("不需要切换内核, 正在使用的内核 " + str2);
    }
}
