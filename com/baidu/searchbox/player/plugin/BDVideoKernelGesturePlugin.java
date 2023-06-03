package com.baidu.searchbox.player.plugin;

import android.content.Context;
import android.view.View;
import com.baidu.searchbox.player.event.LayerEvent;
import com.baidu.searchbox.player.event.PlayerEvent;
import com.baidu.searchbox.player.event.VideoEvent;
import com.baidu.searchbox.player.view.BdVideoMultipleGesturesDetector;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
@Metadata(d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0015\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\b&\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u0010\u0010\u0010\u001a\u00020\u000b2\u0006\u0010\u0011\u001a\u00020\u0012H\u0016J\n\u0010\u0013\u001a\u0004\u0018\u00010\u000bH\u0016J\n\u0010\u0014\u001a\u0004\u0018\u00010\u0015H\u0016J\b\u0010\u0016\u001a\u00020\u0017H&J\u0010\u0010\u0018\u001a\u00020\u00172\u0006\u0010\u0019\u001a\u00020\u001aH\u0016J\u0010\u0010\u001b\u001a\u00020\u00172\u0006\u0010\u0019\u001a\u00020\u001aH\u0016J\u0012\u0010\u001c\u001a\u00020\u00172\b\b\u0002\u0010\u001d\u001a\u00020\u0006H\u0016R\u001a\u0010\u0005\u001a\u00020\u0006X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0007\"\u0004\b\b\u0010\tR\u001c\u0010\n\u001a\u0004\u0018\u00010\u000bX\u0084\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000f¨\u0006\u001e"}, d2 = {"Lcom/baidu/searchbox/player/plugin/BDVideoKernelGesturePlugin;", "Lcom/baidu/searchbox/player/plugin/AbsPlugin;", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "isAllowRecoverNormal", "", "()Z", "setAllowRecoverNormal", "(Z)V", "kernelGestureDetector", "Lcom/baidu/searchbox/player/view/BdVideoMultipleGesturesDetector;", "getKernelGestureDetector", "()Lcom/baidu/searchbox/player/view/BdVideoMultipleGesturesDetector;", "setKernelGestureDetector", "(Lcom/baidu/searchbox/player/view/BdVideoMultipleGesturesDetector;)V", "createGestureDetector", "renderView", "Landroid/view/View;", "getGestureDetector", "getSubscribeEvent", "", "initGestureDetector", "", "onLayerEventNotify", "event", "Lcom/baidu/searchbox/player/event/VideoEvent;", "onPlayerEventNotify", "recoverVideoViewMatrixChanges", "withAnimation", "framework_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes4.dex */
public abstract class BDVideoKernelGesturePlugin extends AbsPlugin {
    public boolean isAllowRecoverNormal;
    public BdVideoMultipleGesturesDetector kernelGestureDetector;

    public abstract void initGestureDetector();

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public BDVideoKernelGesturePlugin(Context context) {
        super(context);
        Intrinsics.checkNotNullParameter(context, "context");
        this.isAllowRecoverNormal = true;
    }

    public BdVideoMultipleGesturesDetector createGestureDetector(View renderView) {
        Intrinsics.checkNotNullParameter(renderView, "renderView");
        return new BdVideoMultipleGesturesDetector(renderView);
    }

    public void recoverVideoViewMatrixChanges(boolean z) {
        if (!this.isAllowRecoverNormal) {
            return;
        }
        if (!z) {
            BdVideoMultipleGesturesDetector bdVideoMultipleGesturesDetector = this.kernelGestureDetector;
            if (bdVideoMultipleGesturesDetector != null) {
                bdVideoMultipleGesturesDetector.switchNormal();
                return;
            }
            return;
        }
        BdVideoMultipleGesturesDetector bdVideoMultipleGesturesDetector2 = this.kernelGestureDetector;
        if (bdVideoMultipleGesturesDetector2 != null) {
            bdVideoMultipleGesturesDetector2.switchNormalWithAnimation();
        }
    }

    public final void setAllowRecoverNormal(boolean z) {
        this.isAllowRecoverNormal = z;
    }

    public final void setKernelGestureDetector(BdVideoMultipleGesturesDetector bdVideoMultipleGesturesDetector) {
        this.kernelGestureDetector = bdVideoMultipleGesturesDetector;
    }

    public static /* synthetic */ void recoverVideoViewMatrixChanges$default(BDVideoKernelGesturePlugin bDVideoKernelGesturePlugin, boolean z, int i, Object obj) {
        if (obj == null) {
            if ((i & 1) != 0) {
                z = false;
            }
            bDVideoKernelGesturePlugin.recoverVideoViewMatrixChanges(z);
            return;
        }
        throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: recoverVideoViewMatrixChanges");
    }

    public BdVideoMultipleGesturesDetector getGestureDetector() {
        return this.kernelGestureDetector;
    }

    public final BdVideoMultipleGesturesDetector getKernelGestureDetector() {
        return this.kernelGestureDetector;
    }

    @Override // com.baidu.searchbox.player.interfaces.INeuron
    public int[] getSubscribeEvent() {
        return new int[]{3, 4};
    }

    public final boolean isAllowRecoverNormal() {
        return this.isAllowRecoverNormal;
    }

    @Override // com.baidu.searchbox.player.plugin.AbsPlugin, com.baidu.searchbox.player.interfaces.INeuron
    public void onLayerEventNotify(VideoEvent event) {
        Intrinsics.checkNotNullParameter(event, "event");
        String action = event.getAction();
        int hashCode = action.hashCode();
        if (hashCode != -552580917) {
            if (hashCode == 287346615 && action.equals(LayerEvent.ACTION_VIDEO_VIEW_RECOVER)) {
                recoverVideoViewMatrixChanges(event.getBooleanExtra(30, true));
            }
        } else if (action.equals(LayerEvent.ACTION_SWITCH_HALF)) {
            recoverVideoViewMatrixChanges$default(this, false, 1, null);
        }
    }

    @Override // com.baidu.searchbox.player.plugin.AbsPlugin, com.baidu.searchbox.player.interfaces.INeuron
    public void onPlayerEventNotify(VideoEvent event) {
        Context context;
        Intrinsics.checkNotNullParameter(event, "event");
        String action = event.getAction();
        int hashCode = action.hashCode();
        Context context2 = null;
        boolean z = true;
        if (hashCode != -1043170264) {
            if (hashCode != -525235558) {
                if (hashCode != -461848373 || !action.equals(PlayerEvent.ACTION_ON_ERROR)) {
                    return;
                }
            } else if (!action.equals(PlayerEvent.ACTION_ON_PREPARED)) {
                return;
            }
            recoverVideoViewMatrixChanges$default(this, false, 1, null);
        } else if (action.equals(PlayerEvent.ACTION_PLAYER_ATTACH) && (context = getContext()) != null) {
            if (this.kernelGestureDetector != null) {
                z = false;
            }
            if (z) {
                context2 = context;
            }
            if (context2 != null) {
                initGestureDetector();
            }
        }
    }
}
