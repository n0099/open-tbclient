package com.baidu.searchbox.floating.element;

import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import androidx.core.view.ViewCompat;
import com.baidu.searchbox.floating.event.FloatingLayerEvent;
import com.baidu.searchbox.floating.utils.UtilsKt;
import com.baidu.searchbox.player.constants.PlayerStatus;
import com.baidu.searchbox.player.element.PlayButtonElement;
import com.baidu.searchbox.player.event.LayerEvent;
import com.baidu.searchbox.player.event.VideoEvent;
import com.baidu.tieba.R;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\b\u0016\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\b\u0010\u0003\u001a\u00020\u0004H\u0016J\u0012\u0010\u0005\u001a\u00020\u00042\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007H\u0016J\u0010\u0010\b\u001a\u00020\u00042\u0006\u0010\t\u001a\u00020\nH\u0016J\u0010\u0010\u000b\u001a\u00020\u00042\u0006\u0010\f\u001a\u00020\rH\u0016J\u0010\u0010\u000e\u001a\u00020\u00042\u0006\u0010\u000f\u001a\u00020\u0010H\u0014¨\u0006\u0011"}, d2 = {"Lcom/baidu/searchbox/floating/element/SimpleFloatingPlayButtonElement;", "Lcom/baidu/searchbox/player/element/PlayButtonElement;", "()V", "initElement", "", "onClick", "v", "Landroid/view/View;", "onEventNotify", "event", "Lcom/baidu/searchbox/player/event/VideoEvent;", "onParentVisibleChanged", "visibility", "", "setPlayIcon", "isPlaying", "", "floating-view_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes3.dex */
public class SimpleFloatingPlayButtonElement extends PlayButtonElement {
    @Override // com.baidu.searchbox.player.element.PlayButtonElement, com.baidu.searchbox.player.element.AbsElement
    public void initElement() {
        ImageView imageView = new ImageView(getContext());
        int floatingButtonWidth = UtilsKt.floatingButtonWidth(imageView);
        imageView.setLayoutParams(new ViewGroup.LayoutParams(floatingButtonWidth, floatingButtonWidth));
        imageView.setOnClickListener(this);
        setPlayBtn(imageView);
        getPlayBtn().setId(ViewCompat.generateViewId());
    }

    @Override // com.baidu.searchbox.player.element.PlayButtonElement, android.view.View.OnClickListener
    public void onClick(View view2) {
        super.onClick(view2);
        getVideoPlayer().sendEvent(LayerEvent.obtainEvent(LayerEvent.ACTION_FLOATING_PLAY_CLICK));
        getVideoPlayer().getStatEventTrigger().onFloatingPlayClick(getVideoPlayer().isPause());
    }

    @Override // com.baidu.searchbox.player.element.AbsElement
    public void onParentVisibleChanged(int i) {
        if (i == 0 && !PlayerStatus.isActiveStatus(getVideoPlayer().getStatus())) {
            return;
        }
        super.onParentVisibleChanged(i);
    }

    @Override // com.baidu.searchbox.player.element.PlayButtonElement
    public void setPlayIcon(boolean z) {
        if (z) {
            getPlayBtn().setImageResource(R.drawable.obfuscated_res_0x7f08027a);
        } else {
            getPlayBtn().setImageResource(R.drawable.obfuscated_res_0x7f08027b);
        }
    }

    @Override // com.baidu.searchbox.player.element.PlayButtonElement, com.baidu.searchbox.player.element.AbsElement, com.baidu.searchbox.player.element.IElement
    public void onEventNotify(VideoEvent event) {
        float f;
        Intrinsics.checkNotNullParameter(event, "event");
        super.onEventNotify(event);
        String action = event.getAction();
        int hashCode = action.hashCode();
        if (hashCode != 952368377) {
            if (hashCode != 1019148811) {
                if (hashCode != 1409909918 || !action.equals(LayerEvent.ACTION_SWITCH_FLOATING)) {
                    return;
                }
            } else if (!action.equals(LayerEvent.ACTION_FLOATING_SHOWN)) {
                return;
            }
            setPlayIcon(getVideoPlayer().isPlaying());
        } else if (action.equals(FloatingLayerEvent.ACTION_FLOATING_GESTURE)) {
            boolean booleanExtra = event.getBooleanExtra(1);
            ImageView playBtn = getPlayBtn();
            if (booleanExtra) {
                f = 0.0f;
            } else {
                f = 1.0f;
            }
            playBtn.setAlpha(f);
        }
    }
}
