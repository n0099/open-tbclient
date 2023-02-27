package com.baidu.searchbox.player.helper;

import android.app.Activity;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.baidu.searchbox.player.UniversalPlayer;
import com.baidu.searchbox.player.utils.BdActivityUtils;
import com.baidu.searchbox.player.utils.BdViewOpUtils;
/* loaded from: classes2.dex */
public class SimpleStyleSwitchHelper implements IPlayerStyleSwitchHelper {
    public ViewGroup mOriginPlayerContainer;
    public final UniversalPlayer mPlayer;

    public SimpleStyleSwitchHelper(@NonNull UniversalPlayer universalPlayer) {
        this.mPlayer = universalPlayer;
    }

    private void setKeepScreenOn(@Nullable Activity activity) {
        if (activity != null) {
            activity.getWindow().addFlags(128);
        }
    }

    public boolean adjustRequestLandscape() {
        int videoWidth = this.mPlayer.getVideoWidth();
        int videoHeight = this.mPlayer.getVideoHeight();
        if (videoWidth <= 0 || videoHeight <= 0 || videoWidth > videoHeight) {
            return true;
        }
        return false;
    }

    @Override // com.baidu.searchbox.player.helper.IPlayerStyleSwitchHelper
    public void switchToFullStyle() {
        this.mOriginPlayerContainer = this.mPlayer.getAttachedContainer();
        this.mPlayer.setIsFullMode(true);
        Activity activity = this.mPlayer.getActivity();
        if (adjustRequestLandscape()) {
            BdActivityUtils.requestLandscape(activity, this.mPlayer.isReverseLandscape());
        }
        setKeepScreenOn(activity);
        BdViewOpUtils.attachDecor(activity, this.mPlayer.getLayerContainer());
    }

    @Override // com.baidu.searchbox.player.helper.IPlayerStyleSwitchHelper
    public void switchToNormalStyle() {
        if (this.mOriginPlayerContainer == null) {
            return;
        }
        this.mOriginPlayerContainer = this.mPlayer.getAttachedContainer();
        this.mPlayer.setIsFullMode(false);
        BdActivityUtils.requestPortrait(this.mPlayer.getActivity());
        BdViewOpUtils.removeView(this.mPlayer.getLayerContainer());
        BdViewOpUtils.removeChilds(this.mPlayer.getAttachedContainer());
        BdViewOpUtils.attachView(this.mPlayer.getLayerContainer(), this.mOriginPlayerContainer);
    }
}
