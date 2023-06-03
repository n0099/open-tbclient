package com.baidu.searchbox.player.kernel;

import android.view.Surface;
import com.baidu.sapi2.views.SmsLoginView;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\u0018\u0000 \f2\u00020\u0001:\u0001\fB\u0005¢\u0006\u0002\u0010\u0002J\b\u0010\u0003\u001a\u00020\u0004H\u0016J\u0012\u0010\u0005\u001a\u00020\u00062\b\u0010\u0007\u001a\u0004\u0018\u00010\bH\u0016J\u0010\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\u0004H\u0016¨\u0006\r"}, d2 = {"Lcom/baidu/searchbox/player/kernel/CyberInlineVideoKernel;", "Lcom/baidu/searchbox/player/kernel/CyberVideoKernel;", "()V", "getKernelType", "", "setSurface", "", "surface", "Landroid/view/Surface;", SmsLoginView.f.j, "", "type", "Companion", "core_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes4.dex */
public final class CyberInlineVideoKernel extends CyberVideoKernel {
    public static final Companion Companion = new Companion(null);
    public static final String KERNEL_TYPE_CYBER_INLINE = "CyberInlineVideoKernel";

    @Override // com.baidu.searchbox.player.kernel.CyberVideoKernel, com.baidu.searchbox.player.kernel.AbsVideoKernel
    public String getKernelType() {
        return KERNEL_TYPE_CYBER_INLINE;
    }

    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000¨\u0006\u0005"}, d2 = {"Lcom/baidu/searchbox/player/kernel/CyberInlineVideoKernel$Companion;", "", "()V", "KERNEL_TYPE_CYBER_INLINE", "", "core_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* loaded from: classes4.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public Companion() {
        }
    }

    @Override // com.baidu.searchbox.player.kernel.AbsVideoKernel
    public void setSurface(Surface surface) {
        this.mVideoView.setExternalSurface(surface);
        printLog("setSurface " + surface);
    }

    @Override // com.baidu.searchbox.player.kernel.CyberVideoKernel, com.baidu.searchbox.player.kernel.AbsVideoKernel, com.baidu.searchbox.player.pool.IPoolItem
    public boolean verify(String type) {
        Intrinsics.checkNotNullParameter(type, "type");
        return Intrinsics.areEqual(KERNEL_TYPE_CYBER_INLINE, type);
    }
}
