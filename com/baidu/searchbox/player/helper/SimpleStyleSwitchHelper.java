package com.baidu.searchbox.player.helper;

import android.app.Activity;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.baidu.searchbox.player.UniversalPlayer;
import com.baidu.searchbox.player.utils.BdActivityUtils;
import com.baidu.searchbox.player.utils.BdViewOpUtils;
/* loaded from: classes3.dex */
public class SimpleStyleSwitchHelper implements IPlayerStyleSwitchHelper {
    private ViewGroup mOriginPlayerContainer;
    private UniversalPlayer mPlayer;

    public SimpleStyleSwitchHelper(@NonNull UniversalPlayer universalPlayer) {
        this.mPlayer = universalPlayer;
    }

    @Override // com.baidu.searchbox.player.helper.IPlayerStyleSwitchHelper
    public void switchToFullStyle() {
        this.mOriginPlayerContainer = this.mPlayer.getAttachedContainer();
        this.mPlayer.setIsFullMode(true);
        Activity activity = this.mPlayer.getActivity();
        BdActivityUtils.requestLandscape(activity, this.mPlayer.isReverseLandscape());
        setKeepScreenOn(activity);
        BdViewOpUtils.attachDecor(activity, this.mPlayer.getLayerContainer());
    }

    @Override // com.baidu.searchbox.player.helper.IPlayerStyleSwitchHelper
    public void switchToNormalStyle() {
        if (this.mOriginPlayerContainer != null) {
            this.mOriginPlayerContainer = this.mPlayer.getAttachedContainer();
            this.mPlayer.setIsFullMode(false);
            BdActivityUtils.requestPortrait(this.mPlayer.getActivity());
            BdViewOpUtils.removeView(this.mPlayer.getLayerContainer());
            BdViewOpUtils.removeChilds(this.mPlayer.getAttachedContainer());
            BdViewOpUtils.attachView(this.mPlayer.getLayerContainer(), this.mOriginPlayerContainer);
        }
    }

    private void setKeepScreenOn(@Nullable Activity activity) {
        if (activity != null) {
            activity.getWindow().addFlags(128);
        }
    }
}
