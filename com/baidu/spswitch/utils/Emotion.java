package com.baidu.spswitch.utils;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.baidu.searchbox.common.runtime.AppRuntime;
import com.baidu.searchbox.elasticthread.ExecutorUtilsExt;
import com.baidu.spswitch.IPanelHeightTarget;
import com.baidu.spswitch.R;
import com.baidu.spswitch.emotion.EmotionType;
import com.baidu.spswitch.emotion.resource.EmotionAPSManager;
import com.baidu.spswitch.utils.BDEmotionPanelManager;
import com.baidu.spswitch.utils.SPSwitchConflictUtil;
import com.baidu.spswitch.utils.SoftInputUtil;
import com.baidu.spswitch.view.SPSwitchPanelLinearLayout;
import java.io.File;
/* loaded from: classes2.dex */
public class Emotion {
    public static void init(boolean z) {
        SPConfig.init(z);
        loadEmotionResIfNeed();
    }

    public static void initEmotionPanel(Activity activity, View view, View view2, ViewGroup viewGroup, boolean z, boolean z2, SoftInputUtil.OnSoftInputShowingListener onSoftInputShowingListener, SPSwitchConflictUtil.SwitchClickListener switchClickListener, BDEmotionPanelManager.OnEmotionClickListener onEmotionClickListener) {
        SPConfig.init(z);
        if (onSoftInputShowingListener == null) {
            onSoftInputShowingListener = new SoftInputUtil.OnSoftInputShowingListener() { // from class: com.baidu.spswitch.utils.Emotion.2
                @Override // com.baidu.spswitch.utils.SoftInputUtil.OnSoftInputShowingListener
                public void onSoftInputShowing(boolean z3) {
                }
            };
        }
        if (switchClickListener == null) {
            switchClickListener = new SPSwitchConflictUtil.SwitchClickListener() { // from class: com.baidu.spswitch.utils.Emotion.3
                @Override // com.baidu.spswitch.utils.SPSwitchConflictUtil.SwitchClickListener
                public void onClickSwitch(View view3, boolean z3) {
                }
            };
        }
        if (onEmotionClickListener == null) {
            onEmotionClickListener = new BDEmotionPanelManager.OnEmotionClickListener() { // from class: com.baidu.spswitch.utils.Emotion.4
                @Override // com.baidu.spswitch.utils.BDEmotionPanelManager.OnEmotionClickListener
                public void onEmotionClick(EmotionType emotionType, int i, String str, String str2) {
                }
            };
        }
        SoftInputUtil.attach(activity, (ViewGroup) activity.findViewById(16908290), (IPanelHeightTarget) viewGroup, onSoftInputShowingListener);
        SPSwitchConflictUtil.attach(activity.getWindow(), viewGroup, view, view2, switchClickListener);
        BDEmotionPanelManager.getInstance().loadInnerEmotionPanel(activity, viewGroup, view2, z2);
        BDEmotionPanelManager.getInstance().setOnEmotionClickListener(onEmotionClickListener);
    }

    public static void loadEmotionResIfNeed() {
        ExecutorUtilsExt.postOnSerial(new Runnable() { // from class: com.baidu.spswitch.utils.Emotion.1
            @Override // java.lang.Runnable
            public void run() {
                File[] restoreFileList = EmotionAPSManager.getRestoreFileList();
                if (restoreFileList == null || restoreFileList.length <= 0) {
                    EmotionAPSManager.getInstance().presetDoAPSProcess();
                } else if (EmotionAPSManager.getInstance().isLoaded()) {
                } else {
                    EmotionAPSManager.getInstance().loadResourcesIfNeeded();
                }
            }
        }, "loadEmotionResIfNeed");
    }

    public static SPSwitchPanelLinearLayout setEmotionPanelAndInit(ViewGroup viewGroup, Activity activity, View view, View view2, boolean z, boolean z2, SoftInputUtil.OnSoftInputShowingListener onSoftInputShowingListener, SPSwitchConflictUtil.SwitchClickListener switchClickListener, BDEmotionPanelManager.OnEmotionClickListener onEmotionClickListener) {
        SPSwitchPanelLinearLayout sPSwitchPanelLinearLayout = (SPSwitchPanelLinearLayout) ((ViewGroup) LayoutInflater.from(AppRuntime.getAppContext()).inflate(R.layout.emotion_only_include_panel_linearlayout, viewGroup, true)).findViewById(R.id.panel_root);
        initEmotionPanel(activity, view, view2, sPSwitchPanelLinearLayout, z, z2, onSoftInputShowingListener, switchClickListener, onEmotionClickListener);
        return sPSwitchPanelLinearLayout;
    }
}
