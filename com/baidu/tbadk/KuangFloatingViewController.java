package com.baidu.tbadk;

import android.app.Activity;
import android.os.Build;
import android.provider.Settings;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.lib.util.l;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.frameworkData.CmdConfigCustom;
import com.baidu.tbadk.core.frameworkData.IntentConfig;
import com.baidu.tbadk.core.message.BackgroundSwitchMessage;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tbadk.core.util.ah;
import com.baidu.tbadk.core.util.ak;
import com.baidu.tieba.d;
/* loaded from: classes.dex */
public class KuangFloatingViewController {
    private View mFloatingView;
    private WindowManager wm;
    private static KuangFloatingViewController instance = null;
    private static String WRITE_PACKAGE = "com.baidu.tieba.write";
    private static String STORY_PACKAGE = "com.baidu.tieba.story";
    private boolean needShowFloatingView = false;
    CustomMessageListener backGroundSwitchListener = new CustomMessageListener(CmdConfigCustom.CMD_BACKGROUND_SWTICH) { // from class: com.baidu.tbadk.KuangFloatingViewController.1
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Boolean data;
            if ((customResponsedMessage instanceof BackgroundSwitchMessage) && (data = ((BackgroundSwitchMessage) customResponsedMessage).getData()) != null) {
                if (!data.booleanValue()) {
                    if (KuangFloatingViewController.this.canShowFloatingView() && KuangFloatingViewController.this.init()) {
                        KuangFloatingViewController.this.showFloatingView();
                        return;
                    }
                    return;
                }
                KuangFloatingViewController.this.hideFloatingView();
            }
        }
    };
    CustomMessageListener writeListener = new CustomMessageListener(CmdConfigCustom.START_GO_ACTION) { // from class: com.baidu.tbadk.KuangFloatingViewController.2
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Class<?> intentClass;
            if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof IntentConfig) && (intentClass = ah.CC().getIntentClass(((IntentConfig) customResponsedMessage.getData()).getClass())) != null) {
                if (intentClass.getName().contains(KuangFloatingViewController.WRITE_PACKAGE) || intentClass.getName().contains(KuangFloatingViewController.STORY_PACKAGE)) {
                    KuangFloatingViewController.this.hideFloatingView();
                }
            }
        }
    };

    public void setNeedShowFloatingView(boolean z) {
        this.needShowFloatingView = z;
    }

    public static KuangFloatingViewController getInstance() {
        if (instance == null) {
            instance = new KuangFloatingViewController();
        }
        return instance;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean canShowFloatingView() {
        String topActivityClassName = UtilHelper.getTopActivityClassName();
        return (topActivityClassName == null || topActivityClassName.contains(WRITE_PACKAGE) || topActivityClassName.contains(STORY_PACKAGE)) ? false : true;
    }

    public boolean init() {
        if (this.needShowFloatingView) {
            if (this.mFloatingView == null) {
                this.mFloatingView = LayoutInflater.from(TbadkCoreApplication.getInst()).inflate(d.h.floating_view_from_kuang, (ViewGroup) null);
                this.mFloatingView.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tbadk.KuangFloatingViewController.3
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view) {
                        KuangFloatingViewController.this.hideFloatingView();
                        KuangFloatingViewController.this.needShowFloatingView = false;
                        Activity currentActivity = TbadkCoreApplication.getInst().getCurrentActivity();
                        if (currentActivity != null) {
                            currentActivity.moveTaskToBack(true);
                        }
                    }
                });
                this.mFloatingView.findViewById(d.g.floating_view_close).setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tbadk.KuangFloatingViewController.4
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view) {
                        KuangFloatingViewController.this.hideFloatingView();
                        KuangFloatingViewController.this.needShowFloatingView = false;
                        TiebaStatic.log(new ak("C12265").s("obj_type", 2));
                    }
                });
            } else if (this.mFloatingView.getParent() != null) {
                return false;
            }
            return true;
        }
        return false;
    }

    public void showFloatingView() {
        WindowManager.LayoutParams layoutParams = new WindowManager.LayoutParams();
        layoutParams.type = 2002;
        layoutParams.flags = 65800;
        layoutParams.format = -3;
        layoutParams.x = 0;
        layoutParams.y = l.s(TbadkCoreApplication.getInst(), d.e.ds260) + UtilHelper.getStatusBarHeight();
        layoutParams.width = -2;
        layoutParams.height = -2;
        layoutParams.gravity = 51;
        if (this.wm == null) {
            this.wm = (WindowManager) TbadkCoreApplication.getInst().getSystemService("window");
        }
        try {
            if (Build.VERSION.SDK_INT >= 23 && !Settings.canDrawOverlays(TbadkCoreApplication.getInst().getContext())) {
                this.wm = null;
                this.mFloatingView = null;
            } else if (init()) {
                if (this.mFloatingView != null && this.mFloatingView.getParent() == null) {
                    this.wm.addView(this.mFloatingView, layoutParams);
                }
                TiebaStatic.log("C12266");
                MessageManager.getInstance().registerListener(this.backGroundSwitchListener);
                MessageManager.getInstance().registerListener(this.writeListener);
            }
        } catch (SecurityException e) {
            this.wm = null;
            this.mFloatingView = null;
        }
    }

    public void hideFloatingView() {
        if (this.wm == null) {
            this.wm = (WindowManager) TbadkCoreApplication.getInst().getSystemService("window");
        }
        if (this.mFloatingView != null && this.mFloatingView.getParent() != null) {
            try {
                if (Build.VERSION.SDK_INT >= 23 && !Settings.canDrawOverlays(TbadkCoreApplication.getInst().getContext())) {
                    this.wm = null;
                    this.mFloatingView = null;
                } else {
                    this.wm.removeView(this.mFloatingView);
                }
            } catch (SecurityException e) {
                this.wm = null;
                this.mFloatingView = null;
            }
        }
    }
}
