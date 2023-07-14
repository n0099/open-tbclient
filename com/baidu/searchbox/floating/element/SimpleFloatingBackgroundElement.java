package com.baidu.searchbox.floating.element;

import android.view.View;
import android.view.ViewGroup;
import androidx.core.content.ContextCompat;
import androidx.core.view.ViewCompat;
import com.baidu.searchbox.player.constants.PlayerStatus;
import com.baidu.searchbox.player.element.AbsElement;
import com.baidu.searchbox.player.utils.BdPlayerUtils;
import com.baidu.tieba.R;
import kotlin.Lazy;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0016\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\b\u0010\t\u001a\u00020\u0004H\u0016J\u0006\u0010\n\u001a\u00020\u000bJ\b\u0010\f\u001a\u00020\u000bH\u0016J\u0010\u0010\r\u001a\u00020\u000b2\u0006\u0010\u000e\u001a\u00020\u000fH\u0016J\u001c\u0010\u0010\u001a\u00020\u000b2\b\u0010\u0011\u001a\u0004\u0018\u00010\u00122\b\u0010\u0013\u001a\u0004\u0018\u00010\u0012H\u0016J\u0006\u0010\u0014\u001a\u00020\u000bR\u001b\u0010\u0003\u001a\u00020\u00048BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u0007\u0010\b\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u0015"}, d2 = {"Lcom/baidu/searchbox/floating/element/SimpleFloatingBackgroundElement;", "Lcom/baidu/searchbox/player/element/AbsElement;", "()V", "view", "Landroid/view/View;", "getView", "()Landroid/view/View;", "view$delegate", "Lkotlin/Lazy;", "getContentView", "hide", "", "initElement", "onParentVisibleChanged", "visibility", "", "onPlayerStatusChanged", "status", "Lcom/baidu/searchbox/player/constants/PlayerStatus;", "old", "show", "floating-view_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes3.dex */
public class SimpleFloatingBackgroundElement extends AbsElement {
    public final Lazy view$delegate = BdPlayerUtils.lazyNone(new Function0<View>() { // from class: com.baidu.searchbox.floating.element.SimpleFloatingBackgroundElement$view$2
        {
            super(0);
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // kotlin.jvm.functions.Function0
        public final View invoke() {
            return new View(SimpleFloatingBackgroundElement.this.getContext());
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
            iArr[PlayerStatus.COMPLETE.ordinal()] = 3;
            iArr[PlayerStatus.ERROR.ordinal()] = 4;
            $EnumSwitchMapping$0 = iArr;
        }
    }

    @Override // com.baidu.searchbox.player.element.AbsElement
    public void onParentVisibleChanged(int i) {
    }

    private final View getView() {
        return (View) this.view$delegate.getValue();
    }

    @Override // com.baidu.searchbox.player.element.IElement
    public View getContentView() {
        return getView();
    }

    public final void hide() {
        getView().setVisibility(8);
    }

    public final void show() {
        getView().setVisibility(0);
    }

    @Override // com.baidu.searchbox.player.element.AbsElement
    public void initElement() {
        getView().setId(ViewCompat.generateViewId());
        getView().setLayoutParams(new ViewGroup.LayoutParams(-1, -1));
        getView().setBackgroundColor(ContextCompat.getColor(getContext(), R.color.obfuscated_res_0x7f06094d));
        getView().setVisibility(8);
    }

    @Override // com.baidu.searchbox.player.element.AbsElement, com.baidu.searchbox.player.element.IElement
    public void onPlayerStatusChanged(PlayerStatus playerStatus, PlayerStatus playerStatus2) {
        int i;
        if (playerStatus == null) {
            i = -1;
        } else {
            i = WhenMappings.$EnumSwitchMapping$0[playerStatus.ordinal()];
        }
        if (i != 1 && i != 2) {
            if (i == 3 || i == 4) {
                show();
                return;
            }
            return;
        }
        hide();
    }
}
