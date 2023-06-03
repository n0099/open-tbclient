package com.baidu.searchbox.player.element;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import com.baidu.searchbox.crius.constants.CriusAttrConstants;
import com.baidu.searchbox.player.callback.ISeekBarListener;
import com.baidu.searchbox.player.event.ControlEvent;
import com.baidu.searchbox.player.event.LayerEvent;
import com.baidu.searchbox.player.event.PlayerEvent;
import com.baidu.searchbox.player.event.VideoEvent;
import com.baidu.searchbox.player.utils.BdPlayerUtils;
import com.baidu.searchbox.player.widget.BdPlayerSeekBar;
import com.baidu.searchbox.player.widget.BdThumbSeekBarView;
import com.baidu.tieba.R;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
@Metadata(d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0002\b\b\b\u0016\u0018\u00002\u00020\u00012\u00020\u0002B\u0005¢\u0006\u0002\u0010\u0003J\b\u0010\u0006\u001a\u00020\u0007H\u0016J\b\u0010\b\u001a\u00020\tH\u0016J\b\u0010\n\u001a\u00020\u0007H\u0016J\u0010\u0010\u000b\u001a\u00020\u00072\u0006\u0010\f\u001a\u00020\rH\u0016J\"\u0010\u000e\u001a\u00020\u00072\b\u0010\u0004\u001a\u0004\u0018\u00010\u000f2\u0006\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u0013H\u0016J\b\u0010\u0014\u001a\u00020\u0007H\u0016J\u0012\u0010\u0015\u001a\u00020\u00072\b\u0010\u0004\u001a\u0004\u0018\u00010\u000fH\u0016J\u0012\u0010\u0016\u001a\u00020\u00072\b\u0010\u0004\u001a\u0004\u0018\u00010\u000fH\u0016J \u0010\u0017\u001a\u00020\u00072\u0006\u0010\u0018\u001a\u00020\u00112\u0006\u0010\u0019\u001a\u00020\u00112\u0006\u0010\u001a\u001a\u00020\u0011H\u0004R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082.¢\u0006\u0002\n\u0000¨\u0006\u001b"}, d2 = {"Lcom/baidu/searchbox/player/element/SeekBarElement;", "Lcom/baidu/searchbox/player/element/AbsElement;", "Lcom/baidu/searchbox/player/callback/ISeekBarListener;", "()V", "seekBar", "Lcom/baidu/searchbox/player/widget/BdPlayerSeekBar;", "bindSeekBarDuration", "", "getContentView", "Landroid/view/View;", "initElement", "onEventNotify", "event", "Lcom/baidu/searchbox/player/event/VideoEvent;", "onProgressChanged", "Lcom/baidu/searchbox/player/widget/BdThumbSeekBarView;", "progress", "", "fromUser", "", "onProgressForward", "onStartTrackingTouch", "onStopTrackingTouch", "syncPos", CriusAttrConstants.POSITION, "duration", "buffer", "framework_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes4.dex */
public class SeekBarElement extends AbsElement implements ISeekBarListener {
    public BdPlayerSeekBar seekBar;

    @Override // com.baidu.searchbox.player.callback.ISeekBarListener
    public void onProgressChanged(BdThumbSeekBarView bdThumbSeekBarView, int i, boolean z) {
    }

    @Override // com.baidu.searchbox.player.callback.ISeekBarListener
    public void onProgressForward() {
    }

    @Override // com.baidu.searchbox.player.callback.ISeekBarListener
    public void onStartTrackingTouch(BdThumbSeekBarView bdThumbSeekBarView) {
    }

    public void bindSeekBarDuration() {
        BdPlayerSeekBar bdPlayerSeekBar = this.seekBar;
        if (bdPlayerSeekBar == null) {
            Intrinsics.throwUninitializedPropertyAccessException("seekBar");
            bdPlayerSeekBar = null;
        }
        bdPlayerSeekBar.setDuration(getVideoPlayer().getDuration());
    }

    @Override // com.baidu.searchbox.player.element.IElement
    public View getContentView() {
        BdPlayerSeekBar bdPlayerSeekBar = this.seekBar;
        if (bdPlayerSeekBar == null) {
            Intrinsics.throwUninitializedPropertyAccessException("seekBar");
            return null;
        }
        return bdPlayerSeekBar;
    }

    @Override // com.baidu.searchbox.player.element.AbsElement
    public void initElement() {
        Context context = getContext();
        Intrinsics.checkNotNullExpressionValue(context, "context");
        BdPlayerSeekBar bdPlayerSeekBar = new BdPlayerSeekBar(context, null, 0, 6, null);
        bdPlayerSeekBar.setId(R.id.obfuscated_res_0x7f0903c2);
        this.seekBar = bdPlayerSeekBar;
        if (bdPlayerSeekBar == null) {
            Intrinsics.throwUninitializedPropertyAccessException("seekBar");
            bdPlayerSeekBar = null;
        }
        bdPlayerSeekBar.setSeekBarListener(this);
        int dp2px = BdPlayerUtils.dp2px(bdPlayerSeekBar, 3.0f);
        ViewGroup.MarginLayoutParams marginLayoutParams = new ViewGroup.MarginLayoutParams(-1, BdPlayerUtils.dp2px(bdPlayerSeekBar, 35.0f));
        marginLayoutParams.leftMargin = dp2px;
        marginLayoutParams.rightMargin = dp2px;
        bdPlayerSeekBar.setLayoutParams(marginLayoutParams);
    }

    @Override // com.baidu.searchbox.player.element.AbsElement, com.baidu.searchbox.player.element.IElement
    public void onEventNotify(VideoEvent event) {
        Intrinsics.checkNotNullParameter(event, "event");
        String action = event.getAction();
        BdPlayerSeekBar bdPlayerSeekBar = null;
        switch (action.hashCode()) {
            case -1530009462:
                if (action.equals(ControlEvent.ACTION_SYNC_PROGRESS)) {
                    syncPos(event.getIntExtra(1), event.getIntExtra(2), event.getIntExtra(3));
                    return;
                }
                return;
            case -552621273:
                if (action.equals(LayerEvent.ACTION_SWITCH_FULL)) {
                    BdPlayerSeekBar bdPlayerSeekBar2 = this.seekBar;
                    if (bdPlayerSeekBar2 == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("seekBar");
                    } else {
                        bdPlayerSeekBar = bdPlayerSeekBar2;
                    }
                    bdPlayerSeekBar.switchToFull();
                    return;
                }
                return;
            case -552580917:
                if (action.equals(LayerEvent.ACTION_SWITCH_HALF)) {
                    BdPlayerSeekBar bdPlayerSeekBar3 = this.seekBar;
                    if (bdPlayerSeekBar3 == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("seekBar");
                    } else {
                        bdPlayerSeekBar = bdPlayerSeekBar3;
                    }
                    bdPlayerSeekBar.switchToHalf();
                    return;
                }
                return;
            case -525235558:
                if (action.equals(PlayerEvent.ACTION_ON_PREPARED)) {
                    bindSeekBarDuration();
                    return;
                }
                return;
            case 2064424334:
                if (action.equals(LayerEvent.ACTION_POSITION_SLIDE)) {
                    int intExtra = event.getIntExtra(2);
                    int intExtra2 = event.getIntExtra(3);
                    BdPlayerSeekBar bdPlayerSeekBar4 = this.seekBar;
                    if (bdPlayerSeekBar4 == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("seekBar");
                    } else {
                        bdPlayerSeekBar = bdPlayerSeekBar4;
                    }
                    bdPlayerSeekBar.setPosition(intExtra + intExtra2);
                    return;
                }
                return;
            default:
                return;
        }
    }

    @Override // com.baidu.searchbox.player.callback.ISeekBarListener
    public void onStopTrackingTouch(BdThumbSeekBarView bdThumbSeekBarView) {
        boolean z;
        if (bdThumbSeekBarView != null) {
            BdPlayerSeekBar bdPlayerSeekBar = this.seekBar;
            if (bdPlayerSeekBar == null) {
                Intrinsics.throwUninitializedPropertyAccessException("seekBar");
                bdPlayerSeekBar = null;
            }
            if (bdPlayerSeekBar.getVisibility() == 0) {
                z = true;
            } else {
                z = false;
            }
            if (!z) {
                bdThumbSeekBarView = null;
            }
            if (bdThumbSeekBarView != null) {
                VideoEvent obtainEvent = LayerEvent.obtainEvent(LayerEvent.ACTION_SEEK);
                Intrinsics.checkNotNullExpressionValue(obtainEvent, "obtainEvent(LayerEvent.ACTION_SEEK)");
                obtainEvent.putExtra(1, Integer.valueOf(bdThumbSeekBarView.getProgress()));
                sendEvent(obtainEvent);
            }
        }
    }

    public final void syncPos(int i, int i2, int i3) {
        BdPlayerSeekBar bdPlayerSeekBar = this.seekBar;
        if (bdPlayerSeekBar == null) {
            Intrinsics.throwUninitializedPropertyAccessException("seekBar");
            bdPlayerSeekBar = null;
        }
        bdPlayerSeekBar.syncPos(i, i2, i3);
    }
}
