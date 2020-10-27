package com.baidu.tbadk;

import android.app.Activity;
import android.content.Intent;
import android.os.Build;
import android.provider.Settings;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.TextView;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.lib.util.l;
import com.baidu.live.tbadk.core.frameworkdata.CmdConfigCustom;
import com.baidu.live.tbadk.core.util.TbadkCoreStatisticKey;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.frameworkData.IntentConfig;
import com.baidu.tbadk.core.message.BackgroundSwitchMessage;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tbadk.core.util.ak;
import com.baidu.tbadk.core.util.aq;
import com.baidu.tieba.R;
import com.baidu.tieba.v.c;
import com.baidu.webkit.internal.GlobalConstants;
/* loaded from: classes.dex */
public class KuangFloatingViewController {
    private View mFloatingView;
    private String mInfo;
    private WindowManager wm;
    private static KuangFloatingViewController instance = null;
    private static String WRITE_PACKAGE = "com.baidu.tieba.write";
    private static String STORY_PACKAGE = "com.baidu.tieba.story";
    private CustomMessageListener mBackGroundSwitchListener = new CustomMessageListener(CmdConfigCustom.CMD_BACKGROUND_SWTICH) { // from class: com.baidu.tbadk.KuangFloatingViewController.1
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Boolean data;
            if ((customResponsedMessage instanceof BackgroundSwitchMessage) && (data = ((BackgroundSwitchMessage) customResponsedMessage).getData()) != null && data.booleanValue()) {
                KuangFloatingViewController.this.hideFloatingView();
            }
        }
    };
    CustomMessageListener writeListener = new CustomMessageListener(CmdConfigCustom.START_GO_ACTION) { // from class: com.baidu.tbadk.KuangFloatingViewController.2
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Class<?> intentClass;
            if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof IntentConfig) && (intentClass = ak.boA().getIntentClass(((IntentConfig) customResponsedMessage.getData()).getClass())) != null) {
                if (intentClass.getName().contains(KuangFloatingViewController.WRITE_PACKAGE) || intentClass.getName().contains(KuangFloatingViewController.STORY_PACKAGE)) {
                    KuangFloatingViewController.this.hideFloatingView();
                }
            }
        }
    };

    public static KuangFloatingViewController getInstance() {
        if (instance == null) {
            instance = new KuangFloatingViewController();
        }
        return instance;
    }

    public boolean init() {
        if (this.mFloatingView == null) {
            this.mFloatingView = LayoutInflater.from(TbadkCoreApplication.getInst()).inflate(R.layout.floating_view_from_kuang, (ViewGroup) null);
            this.mFloatingView.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tbadk.KuangFloatingViewController.3
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    KuangFloatingViewController.this.hideFloatingView();
                    Activity currentActivity = TbadkCoreApplication.getInst().getCurrentActivity();
                    if (currentActivity != null) {
                        currentActivity.moveTaskToBack(true);
                    }
                    TiebaStatic.log(new aq("c12264").aj("obj_source", 1));
                    Intent launchIntentForPackage = TbadkCoreApplication.getInst().getPackageManager().getLaunchIntentForPackage(GlobalConstants.SEARCHBOX_PACKAGE_NAME);
                    if (launchIntentForPackage != null) {
                        launchIntentForPackage.addFlags(268435456);
                        TbadkCoreApplication.getInst().startActivity(launchIntentForPackage);
                        TiebaStatic.log(new aq(TbadkCoreStatisticKey.FLOATING_VIEW_CLICK_KEY).aj("obj_type", 1));
                    }
                }
            });
            this.mFloatingView.findViewById(R.id.floating_view_close).setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tbadk.KuangFloatingViewController.4
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    KuangFloatingViewController.this.hideFloatingView();
                }
            });
        } else if (this.mFloatingView.getParent() != null) {
            return false;
        }
        ((TextView) this.mFloatingView.findViewById(R.id.info)).setText(this.mInfo);
        return true;
    }

    public void showFloatingView() {
        WindowManager.LayoutParams layoutParams = new WindowManager.LayoutParams();
        layoutParams.type = c.Ki(2002);
        layoutParams.flags = 65800;
        layoutParams.format = -3;
        layoutParams.x = 0;
        layoutParams.y = l.getDimens(TbadkCoreApplication.getInst(), R.dimen.ds260) + UtilHelper.getStatusBarHeight();
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
                MessageManager.getInstance().registerListener(this.mBackGroundSwitchListener);
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

    public void setInfo(String str) {
        this.mInfo = str;
    }
}
