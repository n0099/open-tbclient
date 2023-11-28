package com.baidu.searchbox.floating.element;

import android.annotation.SuppressLint;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.core.view.ViewCompat;
import com.baidu.searchbox.floating.element.SimpleFloatingRePlayElement;
import com.baidu.searchbox.floating.event.FloatingLayerEvent;
import com.baidu.searchbox.player.constants.PlayerStatus;
import com.baidu.searchbox.player.element.AbsElement;
import com.baidu.searchbox.player.event.LayerEvent;
import com.baidu.searchbox.player.event.VideoEvent;
import com.baidu.searchbox.player.utils.BdPlayerUtils;
import com.baidu.tieba.R;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.Interceptable;
import kotlin.Lazy;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0017\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\b\u0010\t\u001a\u00020\u0004H\u0016J\b\u0010\n\u001a\u00020\u000bH\u0002J\b\u0010\f\u001a\u00020\u000bH\u0016J\u0010\u0010\r\u001a\u00020\u000b2\u0006\u0010\u000e\u001a\u00020\u000fH\u0016J\u0010\u0010\u0010\u001a\u00020\u000b2\u0006\u0010\u0011\u001a\u00020\u0012H\u0016J\u001c\u0010\u0013\u001a\u00020\u000b2\b\u0010\u0014\u001a\u0004\u0018\u00010\u00152\b\u0010\u0016\u001a\u0004\u0018\u00010\u0015H\u0016J\b\u0010\u0017\u001a\u00020\u000bH\u0014J\b\u0010\u0018\u001a\u00020\u000bH\u0014J\b\u0010\u0019\u001a\u00020\u000bH\u0002R\u001b\u0010\u0003\u001a\u00020\u00048BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u0007\u0010\b\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u001a"}, d2 = {"Lcom/baidu/searchbox/floating/element/SimpleFloatingRePlayElement;", "Lcom/baidu/searchbox/player/element/AbsElement;", "()V", "view", "Landroid/view/View;", "getView", "()Landroid/view/View;", "view$delegate", "Lkotlin/Lazy;", "getContentView", "hide", "", "initElement", "onEventNotify", "event", "Lcom/baidu/searchbox/player/event/VideoEvent;", "onParentVisibleChanged", "visibility", "", "onPlayerStatusChanged", "status", "Lcom/baidu/searchbox/player/constants/PlayerStatus;", "old", "onRePlayViewClick", "show", "syncStatus", "floating-view_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
@SuppressLint({"InflateParams"})
/* loaded from: classes3.dex */
public class SimpleFloatingRePlayElement extends AbsElement {
    public final Lazy view$delegate = BdPlayerUtils.lazyNone(new Function0<View>() { // from class: com.baidu.searchbox.floating.element.SimpleFloatingRePlayElement$view$2
        {
            super(0);
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // kotlin.jvm.functions.Function0
        public final View invoke() {
            View inflate = LayoutInflater.from(SimpleFloatingRePlayElement.this.getContext()).inflate(R.layout.obfuscated_res_0x7f0d0176, (ViewGroup) null);
            Intrinsics.checkNotNull(inflate);
            return inflate;
        }
    });

    @Metadata(k = 3, mv = {1, 6, 0}, xi = 48)
    /* loaded from: classes3.dex */
    public /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] iArr = new int[PlayerStatus.values().length];
            iArr[PlayerStatus.PLAYING.ordinal()] = 1;
            iArr[PlayerStatus.PAUSE.ordinal()] = 2;
            iArr[PlayerStatus.ERROR.ordinal()] = 3;
            iArr[PlayerStatus.COMPLETE.ordinal()] = 4;
            $EnumSwitchMapping$0 = iArr;
        }
    }

    @Override // com.baidu.searchbox.player.element.AbsElement
    public void onParentVisibleChanged(int i) {
    }

    private final View getView() {
        return (View) this.view$delegate.getValue();
    }

    private final void hide() {
        getView().setVisibility(8);
    }

    private final void syncStatus() {
        if (getVideoPlayer().isComplete()) {
            show();
        } else {
            hide();
        }
    }

    @Override // com.baidu.searchbox.player.element.IElement
    public View getContentView() {
        return getView();
    }

    @Override // com.baidu.searchbox.player.element.AbsElement
    public void initElement() {
        getView().setId(ViewCompat.generateViewId());
        getView().findViewById(R.id.obfuscated_res_0x7f091d9c).setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.ui1
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            @Override // android.view.View.OnClickListener
            public final void onClick(View view2) {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeL(1048576, this, view2) == null) {
                    SimpleFloatingRePlayElement.m90initElement$lambda0(SimpleFloatingRePlayElement.this, view2);
                }
            }
        });
        getView().setVisibility(8);
    }

    public void onRePlayViewClick() {
        sendEvent(LayerEvent.obtainEvent(LayerEvent.ACTION_CLICK_REPLAY_BUTTON));
        getVideoPlayer().resumePlayer(true);
        hide();
    }

    public void show() {
        if (getVideoPlayer().isComplete()) {
            getView().setVisibility(0);
        }
    }

    /* renamed from: initElement$lambda-0  reason: not valid java name */
    public static final void m90initElement$lambda0(SimpleFloatingRePlayElement this$0, View view2) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.onRePlayViewClick();
    }

    @Override // com.baidu.searchbox.player.element.AbsElement, com.baidu.searchbox.player.element.IElement
    public void onPlayerStatusChanged(PlayerStatus playerStatus, PlayerStatus playerStatus2) {
        int i;
        if (playerStatus == null) {
            i = -1;
        } else {
            i = WhenMappings.$EnumSwitchMapping$0[playerStatus.ordinal()];
        }
        if (i != 1 && i != 2 && i != 3) {
            if (i == 4) {
                show();
                return;
            }
            return;
        }
        hide();
    }

    @Override // com.baidu.searchbox.player.element.AbsElement, com.baidu.searchbox.player.element.IElement
    public void onEventNotify(VideoEvent event) {
        Intrinsics.checkNotNullParameter(event, "event");
        String action = event.getAction();
        int hashCode = action.hashCode();
        if (hashCode != 952368377) {
            if (hashCode == 1409909918 && action.equals(LayerEvent.ACTION_SWITCH_FLOATING)) {
                syncStatus();
            }
        } else if (action.equals(FloatingLayerEvent.ACTION_FLOATING_GESTURE)) {
            if (event.getBooleanExtra(1)) {
                hide();
            } else {
                syncStatus();
            }
        }
    }
}
