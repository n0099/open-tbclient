package com.baidu.tbadk;

import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.lib.util.k;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.frameworkData.CmdConfigCustom;
import com.baidu.tbadk.core.message.BackgroundSwitchMessage;
import com.baidu.tbadk.core.sharedPref.b;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.au;
import com.baidu.tieba.w;
/* loaded from: classes.dex */
public class KuangFloatingViewController {
    private static KuangFloatingViewController instance = null;
    CustomMessageListener backGroundSwitchListener = new CustomMessageListener(CmdConfigCustom.CMD_BACKGROUND_SWTICH) { // from class: com.baidu.tbadk.KuangFloatingViewController.1
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Boolean data;
            if ((customResponsedMessage instanceof BackgroundSwitchMessage) && (data = ((BackgroundSwitchMessage) customResponsedMessage).getData()) != null && data.booleanValue()) {
                KuangFloatingViewController.this.hideFloatingView();
            }
        }
    };
    private View mFloatingView;
    private WindowManager wm;

    public static KuangFloatingViewController getInstance() {
        if (instance == null) {
            instance = new KuangFloatingViewController();
        }
        return instance;
    }

    public void showFloatingView() {
        int i = b.getInstance().getInt("show_kuang_floating_view_time", 0);
        if (i <= 0) {
            b.getInstance().putInt("show_kuang_floating_view_time", i + 1);
            if (this.mFloatingView == null) {
                this.mFloatingView = LayoutInflater.from(TbadkCoreApplication.m9getInst()).inflate(w.j.floating_view_from_kuang, (ViewGroup) null);
                this.mFloatingView.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tbadk.KuangFloatingViewController.2
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view) {
                        KuangFloatingViewController.this.hideFloatingView();
                        Intent launchIntentForPackage = TbadkCoreApplication.m9getInst().getPackageManager().getLaunchIntentForPackage("com.baidu.searchbox");
                        if (launchIntentForPackage != null) {
                            TbadkCoreApplication.m9getInst().startActivity(launchIntentForPackage);
                            TiebaStatic.log(new au("C12265").r("obj_type", 1));
                        }
                    }
                });
                this.mFloatingView.findViewById(w.h.floating_view_close).setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tbadk.KuangFloatingViewController.3
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view) {
                        KuangFloatingViewController.this.hideFloatingView();
                        TiebaStatic.log(new au("C12265").r("obj_type", 2));
                    }
                });
            } else if (this.mFloatingView.getParent() != null) {
                return;
            }
            WindowManager.LayoutParams layoutParams = new WindowManager.LayoutParams();
            layoutParams.type = 2002;
            layoutParams.flags = 8;
            layoutParams.format = -3;
            layoutParams.x = 0;
            layoutParams.y = k.g(TbadkCoreApplication.m9getInst(), w.f.ds260);
            layoutParams.width = -2;
            layoutParams.height = -2;
            layoutParams.gravity = 51;
            if (this.wm == null) {
                this.wm = (WindowManager) TbadkCoreApplication.m9getInst().getSystemService("window");
            }
            this.wm.addView(this.mFloatingView, layoutParams);
            TiebaStatic.log("C12266");
            MessageManager.getInstance().registerListener(this.backGroundSwitchListener);
        }
    }

    public void hideFloatingView() {
        if (this.wm == null) {
            this.wm = (WindowManager) TbadkCoreApplication.m9getInst().getSystemService("window");
        }
        if (this.mFloatingView != null && this.mFloatingView.getParent() != null) {
            this.wm.removeView(this.mFloatingView);
        }
    }
}
