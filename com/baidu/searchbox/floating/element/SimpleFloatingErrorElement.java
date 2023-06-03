package com.baidu.searchbox.floating.element;

import android.annotation.SuppressLint;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;
import androidx.core.view.ViewCompat;
import com.baidu.searchbox.floating.element.SimpleFloatingErrorElement;
import com.baidu.searchbox.floating.event.FloatingLayerEvent;
import com.baidu.searchbox.player.constants.PlayerStatus;
import com.baidu.searchbox.player.element.AbsElement;
import com.baidu.searchbox.player.event.LayerEvent;
import com.baidu.searchbox.player.event.SystemEvent;
import com.baidu.searchbox.player.event.VideoEvent;
import com.baidu.searchbox.player.helper.NetUtils;
import com.baidu.searchbox.player.utils.BdPlayerUtils;
import com.baidu.tieba.R;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.Interceptable;
import kotlin.Lazy;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0017\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\b\u0010\t\u001a\u00020\u0004H\u0016J\b\u0010\n\u001a\u00020\u000bH\u0002J\b\u0010\f\u001a\u00020\u000bH\u0016J\u0010\u0010\r\u001a\u00020\u000b2\u0006\u0010\u000e\u001a\u00020\u000fH\u0014J\u0010\u0010\u0010\u001a\u00020\u000b2\u0006\u0010\u000e\u001a\u00020\u000fH\u0016J\u0010\u0010\u0011\u001a\u00020\u000b2\u0006\u0010\u0012\u001a\u00020\u0013H\u0016J\u001c\u0010\u0014\u001a\u00020\u000b2\b\u0010\u0015\u001a\u0004\u0018\u00010\u00162\b\u0010\u0017\u001a\u0004\u0018\u00010\u0016H\u0016J\b\u0010\u0018\u001a\u00020\u000bH\u0002J\b\u0010\u0019\u001a\u00020\u000bH\u0002R\u001b\u0010\u0003\u001a\u00020\u00048BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u0007\u0010\b\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u001a"}, d2 = {"Lcom/baidu/searchbox/floating/element/SimpleFloatingErrorElement;", "Lcom/baidu/searchbox/player/element/AbsElement;", "()V", "view", "Landroid/view/View;", "getView", "()Landroid/view/View;", "view$delegate", "Lkotlin/Lazy;", "getContentView", "hide", "", "initElement", "onConnectChanged", "event", "Lcom/baidu/searchbox/player/event/VideoEvent;", "onEventNotify", "onParentVisibleChanged", "visibility", "", "onPlayerStatusChanged", "status", "Lcom/baidu/searchbox/player/constants/PlayerStatus;", "old", "show", "syncStatus", "floating-view_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
@SuppressLint({"InflateParams"})
/* loaded from: classes3.dex */
public class SimpleFloatingErrorElement extends AbsElement {
    public final Lazy view$delegate = BdPlayerUtils.lazyNone(new Function0<View>() { // from class: com.baidu.searchbox.floating.element.SimpleFloatingErrorElement$view$2
        {
            super(0);
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // kotlin.jvm.functions.Function0
        public final View invoke() {
            View inflate = LayoutInflater.from(SimpleFloatingErrorElement.this.getContext()).inflate(R.layout.obfuscated_res_0x7f0d016a, (ViewGroup) null);
            Intrinsics.checkNotNull(inflate);
            return inflate;
        }
    });

    @Metadata(k = 3, mv = {1, 6, 0}, xi = 48)
    /* loaded from: classes3.dex */
    public /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;
        public static final /* synthetic */ int[] $EnumSwitchMapping$1;

        static {
            int[] iArr = new int[NetUtils.NetStatus.values().length];
            iArr[NetUtils.NetStatus.NET_WIFI.ordinal()] = 1;
            iArr[NetUtils.NetStatus.NET_MOBILE.ordinal()] = 2;
            $EnumSwitchMapping$0 = iArr;
            int[] iArr2 = new int[PlayerStatus.values().length];
            iArr2[PlayerStatus.PLAYING.ordinal()] = 1;
            iArr2[PlayerStatus.PAUSE.ordinal()] = 2;
            iArr2[PlayerStatus.COMPLETE.ordinal()] = 3;
            iArr2[PlayerStatus.ERROR.ordinal()] = 4;
            $EnumSwitchMapping$1 = iArr2;
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

    private final void show() {
        getView().setVisibility(0);
    }

    private final void syncStatus() {
        if (getVideoPlayer().isError()) {
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
        getView().setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.jo1
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            @Override // android.view.View.OnClickListener
            public final void onClick(View view2) {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeL(1048576, this, view2) == null) {
                    SimpleFloatingErrorElement.m88initElement$lambda0(SimpleFloatingErrorElement.this, view2);
                }
            }
        });
        getView().setVisibility(8);
    }

    /* renamed from: initElement$lambda-0  reason: not valid java name */
    public static final void m88initElement$lambda0(SimpleFloatingErrorElement this$0, View view2) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.getVideoPlayer().setVideoUrl(this$0.getVideoPlayer().getVideoUrl());
        this$0.getVideoPlayer().start();
        this$0.getView().setVisibility(8);
    }

    @Override // com.baidu.searchbox.player.element.AbsElement, com.baidu.searchbox.player.element.IElement
    public void onPlayerStatusChanged(PlayerStatus playerStatus, PlayerStatus playerStatus2) {
        int i;
        if (playerStatus == null) {
            i = -1;
        } else {
            i = WhenMappings.$EnumSwitchMapping$1[playerStatus.ordinal()];
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

    public void onConnectChanged(VideoEvent event) {
        int i;
        Intrinsics.checkNotNullParameter(event, "event");
        Object extra = event.getExtra(1);
        if (!(extra instanceof NetUtils.NetStatus)) {
            extra = null;
        }
        NetUtils.NetStatus netStatus = (NetUtils.NetStatus) extra;
        if (netStatus == null) {
            i = -1;
        } else {
            i = WhenMappings.$EnumSwitchMapping$0[netStatus.ordinal()];
        }
        if (i != 1) {
            if (i == 2) {
                Toast.makeText(getContext(), (int) R.string.obfuscated_res_0x7f0f1086, 0).show();
                return;
            }
            return;
        }
        Toast.makeText(getContext(), (int) R.string.obfuscated_res_0x7f0f1087, 0).show();
    }

    @Override // com.baidu.searchbox.player.element.AbsElement, com.baidu.searchbox.player.element.IElement
    public void onEventNotify(VideoEvent event) {
        Intrinsics.checkNotNullParameter(event, "event");
        String action = event.getAction();
        int hashCode = action.hashCode();
        if (hashCode != 552510122) {
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
        } else if (action.equals(SystemEvent.ACTION_CONNECT_CHANGED)) {
            onConnectChanged(event);
        }
    }
}
