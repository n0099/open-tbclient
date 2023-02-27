package com.baidu.searchbox.live.shell.list.basic;

import android.app.Activity;
import android.content.Context;
import android.view.View;
import com.baidu.live.arch.utils.MiniUniqueId;
import com.baidu.searchbox.crius.constants.CriusAttrConstants;
import com.baidu.searchbox.live.data.constant.MixTagConstants;
import com.baidu.searchbox.live.interfaces.mix.IMixActivityInterface;
import com.baidu.searchbox.live.interfaces.mix.IMixShellInterface;
import com.baidu.searchbox.live.util.ListLogKt;
import com.baidu.searchbox.live.widget.LiveContainer;
import com.google.android.exoplayer2.text.webvtt.WebvttCueParser;
import kotlin.Metadata;
import kotlin.TypeCastException;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000R\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b&\u0018\u00002\u00020\u0001B\u001f\u0012\u0006\u0010!\u001a\u00020 \u0012\u0006\u0010#\u001a\u00020\"\u0012\u0006\u0010%\u001a\u00020$¢\u0006\u0004\b&\u0010'J\u000f\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0003\u0010\u0004J\u000f\u0010\u0006\u001a\u00020\u0005H&¢\u0006\u0004\b\u0006\u0010\u0007J\u0011\u0010\t\u001a\u0004\u0018\u00010\bH\u0002¢\u0006\u0004\b\t\u0010\nJ\u0017\u0010\r\u001a\u00020\f2\u0006\u0010\u000b\u001a\u00020\u0005H\u0002¢\u0006\u0004\b\r\u0010\u000eJ\u000f\u0010\u000f\u001a\u00020\fH\u0016¢\u0006\u0004\b\u000f\u0010\u0010J\u0017\u0010\u0013\u001a\u00020\f2\u0006\u0010\u0012\u001a\u00020\u0011H\u0016¢\u0006\u0004\b\u0013\u0010\u0014J\u000f\u0010\u0015\u001a\u00020\fH\u0016¢\u0006\u0004\b\u0015\u0010\u0010J\u000f\u0010\u0016\u001a\u00020\fH\u0016¢\u0006\u0004\b\u0016\u0010\u0010J'\u0010\u001b\u001a\u00020\f2\u0006\u0010\u0018\u001a\u00020\u00172\u0006\u0010\u0012\u001a\u00020\u00112\u0006\u0010\u001a\u001a\u00020\u0019H\u0016¢\u0006\u0004\b\u001b\u0010\u001cJ'\u0010\u001d\u001a\u00020\f2\u0006\u0010\u0018\u001a\u00020\u00172\u0006\u0010\u0012\u001a\u00020\u00112\u0006\u0010\u001a\u001a\u00020\u0019H\u0016¢\u0006\u0004\b\u001d\u0010\u001cR\u0018\u0010\u001e\u001a\u0004\u0018\u00010\b8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u001e\u0010\u001f¨\u0006("}, d2 = {"Lcom/baidu/searchbox/live/shell/list/basic/MixBasicFakeShell;", "Lcom/baidu/searchbox/live/shell/list/basic/AbstractMixFakeShell;", "Landroid/view/View;", "createContainerView", "()Landroid/view/View;", "", "getLiveTemplateId", "()Ljava/lang/String;", "Lcom/baidu/searchbox/live/interfaces/mix/IMixShellInterface;", "getShellImpl", "()Lcom/baidu/searchbox/live/interfaces/mix/IMixShellInterface;", "content", "", "log", "(Ljava/lang/String;)V", "onLiveAttach", "()V", "Lcom/baidu/searchbox/live/widget/LiveContainer$LiveItemModel;", "model", "onLiveBindData", "(Lcom/baidu/searchbox/live/widget/LiveContainer$LiveItemModel;)V", "onLiveDeselected", "onLiveDetach", "", CriusAttrConstants.POSITION, "", "isFromUser", "onLiveSelected", "(ILcom/baidu/searchbox/live/widget/LiveContainer$LiveItemModel;Z)V", "onPageSelected", "mixShellInterfaceImpl", "Lcom/baidu/searchbox/live/interfaces/mix/IMixShellInterface;", "Landroid/content/Context;", "context", "Lcom/baidu/live/arch/utils/MiniUniqueId;", "mixUniqueId", "Lcom/baidu/searchbox/live/interfaces/mix/IMixActivityInterface;", "mixActivity", "<init>", "(Landroid/content/Context;Lcom/baidu/live/arch/utils/MiniUniqueId;Lcom/baidu/searchbox/live/interfaces/mix/IMixActivityInterface;)V", "lib-live-mini-shell_release"}, k = 1, mv = {1, 1, 15}, pn = "", xi = 0, xs = "")
/* loaded from: classes2.dex */
public abstract class MixBasicFakeShell extends AbstractMixFakeShell {
    public IMixShellInterface mixShellInterfaceImpl;

    public abstract String getLiveTemplateId();

    public MixBasicFakeShell(Context context, MiniUniqueId miniUniqueId, IMixActivityInterface iMixActivityInterface) {
        super(context, miniUniqueId, iMixActivityInterface);
    }

    @Override // com.baidu.searchbox.live.shell.list.basic.AbstractMixFakeShell
    public void onLiveSelected(int i, LiveContainer.LiveItemModel liveItemModel, boolean z) {
        super.onLiveSelected(i, liveItemModel, z);
        log("onLiveSelected");
        IMixShellInterface shellImpl = getShellImpl();
        if (shellImpl != null) {
            shellImpl.onLiveSelected(getLiveContainer(), i, liveItemModel, z, null);
        }
    }

    @Override // com.baidu.searchbox.live.shell.list.basic.AbstractMixFakeShell
    public void onPageSelected(int i, LiveContainer.LiveItemModel liveItemModel, boolean z) {
        super.onPageSelected(i, liveItemModel, z);
        log("onPageSelected");
        IMixShellInterface shellImpl = getShellImpl();
        if (shellImpl != null) {
            shellImpl.onPageSelected(getLiveContainer(), i, liveItemModel, z, null);
        }
    }

    private final IMixShellInterface getShellImpl() {
        if (this.mixShellInterfaceImpl == null) {
            IMixActivityInterface mixActivity = getMixActivity();
            Context context = getContext();
            if (context != null) {
                this.mixShellInterfaceImpl = mixActivity.getShell((Activity) context, getLiveTemplateId());
                log("real create impl");
            } else {
                throw new TypeCastException("null cannot be cast to non-null type android.app.Activity");
            }
        }
        return this.mixShellInterfaceImpl;
    }

    @Override // com.baidu.searchbox.live.shell.list.basic.AbstractMixFakeShell
    public View createContainerView() {
        log("createContainerView");
        IMixShellInterface shellImpl = getShellImpl();
        if (shellImpl != null) {
            shellImpl.onCreateView(getLiveContainer(), null);
        }
        return getLiveContainer();
    }

    @Override // com.baidu.searchbox.live.shell.list.basic.AbstractMixFakeShell
    public void onLiveAttach() {
        super.onLiveAttach();
        log("onLiveAttach");
        IMixShellInterface shellImpl = getShellImpl();
        if (shellImpl != null) {
            shellImpl.onLiveAttach(getLiveContainer(), null);
        }
    }

    @Override // com.baidu.searchbox.live.shell.list.basic.AbstractMixFakeShell
    public void onLiveDeselected() {
        super.onLiveDeselected();
        log("onLiveDeselected");
        IMixShellInterface shellImpl = getShellImpl();
        if (shellImpl != null) {
            shellImpl.onLiveDeselected();
        }
    }

    @Override // com.baidu.searchbox.live.shell.list.basic.AbstractMixFakeShell
    public void onLiveDetach() {
        super.onLiveDetach();
        log("onLiveDetach");
        IMixShellInterface shellImpl = getShellImpl();
        if (shellImpl != null) {
            shellImpl.onLiveDetach();
        }
    }

    private final void log(String str) {
        Integer num;
        StringBuilder sb = new StringBuilder();
        sb.append(str);
        sb.append(" mixLiveImpl:");
        IMixShellInterface iMixShellInterface = this.mixShellInterfaceImpl;
        if (iMixShellInterface != null) {
            num = Integer.valueOf(iMixShellInterface.hashCode());
        } else {
            num = null;
        }
        sb.append(num);
        sb.append(" this:");
        sb.append(hashCode());
        sb.append(WebvttCueParser.CHAR_SPACE);
        sb.append("context:");
        sb.append(getContext().hashCode());
        ListLogKt.log(MixTagConstants.MIX_MEDIA_LIVE, sb.toString());
    }

    @Override // com.baidu.searchbox.live.shell.list.basic.AbstractMixFakeShell
    public void onLiveBindData(LiveContainer.LiveItemModel liveItemModel) {
        super.onLiveBindData(liveItemModel);
        log("onLiveBindData");
        IMixShellInterface shellImpl = getShellImpl();
        if (shellImpl != null) {
            shellImpl.onLiveBindData(getLiveContainer(), liveItemModel, null);
        }
    }
}
