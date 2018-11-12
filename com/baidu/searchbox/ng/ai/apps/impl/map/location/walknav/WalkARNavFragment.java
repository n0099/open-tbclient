package com.baidu.searchbox.ng.ai.apps.impl.map.location.walknav;

import android.content.Context;
import android.content.Intent;
import android.media.AudioManager;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import com.baidu.mapapi.CoordType;
import com.baidu.mapapi.SDKInitializer;
import com.baidu.mapapi.walknavi.WalkNavigateHelper;
import com.baidu.mapapi.walknavi.adapter.IWNaviStatusListener;
import com.baidu.mapapi.walknavi.adapter.IWTTSPlayer;
import com.baidu.platform.comapi.walknavi.WalkNaviModeSwitchListener;
import com.baidu.searchbox.bdmapsdk.BdMapRuntime;
import com.baidu.searchbox.ng.ai.apps.core.fragment.AiAppsBaseFragment;
import com.baidu.searchbox.ng.ai.apps.core.fragment.AiAppsFragmentManager;
import com.baidu.searchbox.ng.ai.apps.event.message.AiAppsRouteMessage;
import com.baidu.searchbox.ng.ai.apps.lifecycle.AiAppsController;
import com.baidu.tieba.e;
/* loaded from: classes4.dex */
public class WalkARNavFragment extends AiAppsBaseFragment implements AudioManager.OnAudioFocusChangeListener, IWNaviStatusListener, IWTTSPlayer {
    public static final String ACTION_STOP_TTS = "stop_tts";
    private static final String NAV_END_PT_KEY = "endPt";
    private static final String NAV_START_PT_KEY = "startPt";
    private AudioManager mAudioManager;
    private FrameLayout mRootView;
    private WalkNavigateHelper mWNaviHelper;

    public static WalkARNavFragment newInstance(Bundle bundle) {
        WalkARNavFragment walkARNavFragment = new WalkARNavFragment();
        if (bundle != null) {
            walkARNavFragment.setArguments(bundle);
        }
        return walkARNavFragment;
    }

    public void startFragment() {
        AiAppsFragmentManager aiAppsFragmentManager = AiAppsController.getInstance().getAiAppsFragmentManager();
        if (aiAppsFragmentManager != null) {
            aiAppsFragmentManager.createTransaction(AiAppsRouteMessage.TYPE_NAVIGATE_TO).setCustomAnimations(AiAppsFragmentManager.ANIM_ENTER, AiAppsFragmentManager.ANIM_HOLD).pushFragment(this).commitNow();
        }
    }

    private void startNav() {
        SDKInitializer.setCoordType(CoordType.BD09LL);
        try {
            this.mWNaviHelper = WalkNavigateHelper.getInstance();
            View onCreate = this.mWNaviHelper.onCreate(AiAppsController.getInstance().getActivity());
            if (onCreate != null) {
                this.mRootView.addView(onCreate);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        this.mWNaviHelper.setWalkNaviStatusListener(this);
        this.mWNaviHelper.setTTsPlayer(this);
        this.mWNaviHelper.startWalkNavi(AiAppsController.getInstance().getActivity());
    }

    @Override // com.baidu.searchbox.support.v4.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        BdMapRuntime.makeSureMapSDKInit();
        View inflate = layoutInflater.inflate(e.h.walk_arnav_fragment, viewGroup, false);
        this.mRootView = (FrameLayout) inflate;
        startNav();
        if (immersionEnabled()) {
            inflate = initImmersion(inflate);
        }
        return enableSliding(inflate, this);
    }

    @Override // com.baidu.searchbox.support.v4.app.Fragment
    public void onDestroy() {
        super.onDestroy();
        if (this.mWNaviHelper != null) {
            this.mWNaviHelper.quit();
        }
        SDKInitializer.setCoordType(CoordType.GCJ02);
        releaseTTS();
        abandonAudioFocus();
        if (AiAppsController.getInstance().getActivity().getWindow() != null) {
            AiAppsController.getInstance().getActivity().getWindow().clearFlags(128);
        }
        AiAppsController.getInstance().requestCollectionPolicyContinueFlag();
    }

    @Override // com.baidu.searchbox.ng.ai.apps.core.fragment.AiAppsBaseFragment, com.baidu.searchbox.support.v4.app.Fragment
    public void onResume() {
        super.onResume();
        if (this.mWNaviHelper != null) {
            this.mWNaviHelper.resume();
        }
    }

    @Override // com.baidu.searchbox.support.v4.app.Fragment
    public void onPause() {
        super.onPause();
        if (this.mWNaviHelper != null) {
            this.mWNaviHelper.pause();
        }
        AiAppsController.getInstance().requestCollectionPolicyStopFlag();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.searchbox.ng.ai.apps.core.fragment.AiAppsBaseFragment
    public void initActionBar(View view) {
    }

    @Override // com.baidu.searchbox.ng.ai.apps.core.fragment.AiAppsBaseFragment, com.baidu.searchbox.widget.SlideInterceptor
    public boolean isSlidable() {
        return false;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.searchbox.ng.ai.apps.core.fragment.AiAppsBaseFragment
    public boolean isTabFragment() {
        return false;
    }

    @Override // com.baidu.searchbox.ng.ai.apps.core.fragment.AiAppsBaseFragment
    public boolean handleBackPressed() {
        return false;
    }

    @Override // com.baidu.searchbox.ng.ai.apps.core.fragment.AiAppsBaseFragment
    protected void initToolMenu() {
    }

    @Override // com.baidu.searchbox.ng.ai.apps.core.fragment.AiAppsBaseFragment
    protected void onActionBarSettingPressed() {
    }

    @Override // com.baidu.mapapi.walknavi.adapter.IWNaviStatusListener
    public void onWalkNaviModeChange(int i, WalkNaviModeSwitchListener walkNaviModeSwitchListener) {
        this.mWNaviHelper.switchWalkNaviMode(AiAppsController.getInstance().getActivity(), i, walkNaviModeSwitchListener);
    }

    @Override // com.baidu.mapapi.walknavi.adapter.IWNaviStatusListener
    public void onNaviExit() {
    }

    @Override // com.baidu.mapapi.walknavi.adapter.IWTTSPlayer
    public int playTTSText(String str, boolean z) {
        requestAudioFocus(AiAppsController.getInstance().getActivity());
        return 0;
    }

    private void requestAudioFocus(Context context) {
        context.sendBroadcast(new Intent(ACTION_STOP_TTS));
        if (this.mAudioManager == null) {
            this.mAudioManager = (AudioManager) context.getSystemService("audio");
        }
        if (this.mAudioManager != null) {
            this.mAudioManager.requestAudioFocus(this, 3, 2);
        }
    }

    private void abandonAudioFocus() {
        if (this.mAudioManager != null) {
            this.mAudioManager.abandonAudioFocus(this);
        }
    }

    private void releaseTTS() {
    }

    @Override // android.media.AudioManager.OnAudioFocusChangeListener
    public void onAudioFocusChange(int i) {
        switch (i) {
            case -2:
            case -1:
                releaseTTS();
                return;
            case 0:
            case 1:
            default:
                return;
        }
    }
}
