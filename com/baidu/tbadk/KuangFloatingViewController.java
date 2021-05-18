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
import com.alibaba.fastjson.asm.Label;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.frameworkData.IntentConfig;
import com.baidu.tbadk.core.message.BackgroundSwitchMessage;
import com.baidu.tbadk.core.util.RegisterIntentConfigHelper;
import com.baidu.tbadk.core.util.StatisticItem;
import com.baidu.tbadk.core.util.TbadkCoreStatisticKey;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tieba.R;
import d.a.c.e.p.l;
import d.a.k0.p3.c;
/* loaded from: classes3.dex */
public class KuangFloatingViewController {
    public static String STORY_PACKAGE = "com.baidu.tieba.story";
    public static String WRITE_PACKAGE = "com.baidu.tieba.write";
    public static KuangFloatingViewController instance;
    public View mFloatingView;
    public String mInfo;
    public WindowManager wm;
    public CustomMessageListener mBackGroundSwitchListener = new CustomMessageListener(2001011) { // from class: com.baidu.tbadk.KuangFloatingViewController.1
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Boolean data;
            if ((customResponsedMessage instanceof BackgroundSwitchMessage) && (data = ((BackgroundSwitchMessage) customResponsedMessage).getData()) != null && data.booleanValue()) {
                KuangFloatingViewController.this.hideFloatingView();
            }
        }
    };
    public CustomMessageListener writeListener = new CustomMessageListener(2002001) { // from class: com.baidu.tbadk.KuangFloatingViewController.2
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Class<?> intentClass;
            if (customResponsedMessage == null || !(customResponsedMessage.getData() instanceof IntentConfig) || (intentClass = RegisterIntentConfigHelper.getInst().getIntentClass(((IntentConfig) customResponsedMessage.getData()).getClass())) == null) {
                return;
            }
            if (intentClass.getName().contains(KuangFloatingViewController.WRITE_PACKAGE) || intentClass.getName().contains(KuangFloatingViewController.STORY_PACKAGE)) {
                KuangFloatingViewController.this.hideFloatingView();
            }
        }
    };

    public static KuangFloatingViewController getInstance() {
        if (instance == null) {
            instance = new KuangFloatingViewController();
        }
        return instance;
    }

    public void hideFloatingView() {
        if (this.wm == null) {
            this.wm = (WindowManager) TbadkCoreApplication.getInst().getSystemService("window");
        }
        View view = this.mFloatingView;
        if (view == null || view.getParent() == null) {
            return;
        }
        try {
            if (Build.VERSION.SDK_INT >= 23 && !Settings.canDrawOverlays(TbadkCoreApplication.getInst().getContext())) {
                this.wm = null;
                this.mFloatingView = null;
                return;
            }
            this.wm.removeView(this.mFloatingView);
        } catch (SecurityException unused) {
            this.wm = null;
            this.mFloatingView = null;
        }
    }

    public boolean init() {
        View view = this.mFloatingView;
        if (view == null) {
            View inflate = LayoutInflater.from(TbadkCoreApplication.getInst()).inflate(R.layout.floating_view_from_kuang, (ViewGroup) null);
            this.mFloatingView = inflate;
            inflate.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tbadk.KuangFloatingViewController.3
                @Override // android.view.View.OnClickListener
                public void onClick(View view2) {
                    KuangFloatingViewController.this.hideFloatingView();
                    Activity currentActivity = TbadkCoreApplication.getInst().getCurrentActivity();
                    if (currentActivity != null) {
                        currentActivity.moveTaskToBack(true);
                    }
                    TiebaStatic.log(new StatisticItem("c12264").param("obj_source", 1));
                    Intent launchIntentForPackage = TbadkCoreApplication.getInst().getPackageManager().getLaunchIntentForPackage("com.baidu.searchbox");
                    if (launchIntentForPackage != null) {
                        launchIntentForPackage.addFlags(Label.FORWARD_REFERENCE_TYPE_SHORT);
                        TbadkCoreApplication.getInst().startActivity(launchIntentForPackage);
                        TiebaStatic.log(new StatisticItem(TbadkCoreStatisticKey.FLOATING_VIEW_CLICK_KEY).param("obj_type", 1));
                    }
                }
            });
            this.mFloatingView.findViewById(R.id.floating_view_close).setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tbadk.KuangFloatingViewController.4
                @Override // android.view.View.OnClickListener
                public void onClick(View view2) {
                    KuangFloatingViewController.this.hideFloatingView();
                }
            });
        } else if (view.getParent() != null) {
            return false;
        }
        ((TextView) this.mFloatingView.findViewById(R.id.info)).setText(this.mInfo);
        return true;
    }

    public void setInfo(String str) {
        this.mInfo = str;
    }

    public void showFloatingView() {
        WindowManager.LayoutParams layoutParams = new WindowManager.LayoutParams();
        layoutParams.type = c.a(2002);
        layoutParams.flags = 65800;
        layoutParams.format = -3;
        layoutParams.x = 0;
        layoutParams.y = l.g(TbadkCoreApplication.getInst(), R.dimen.ds260) + UtilHelper.getStatusBarHeight();
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
        } catch (SecurityException unused) {
            this.wm = null;
            this.mFloatingView = null;
        }
    }
}
