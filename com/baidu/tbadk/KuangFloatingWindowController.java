package com.baidu.tbadk;

import android.app.Activity;
import android.content.Intent;
import android.os.Build;
import android.provider.Settings;
import android.util.DisplayMetrics;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import com.alibaba.fastjson.asm.Label;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.message.ConfigChangeMessage;
import com.baidu.tbadk.core.message.KeyBoardSwitchMessage;
import com.baidu.tbadk.core.message.WindowSwitchMessage;
import com.baidu.tieba.R;
import d.b.c.e.p.l;
import d.b.i0.p3.c;
/* loaded from: classes3.dex */
public class KuangFloatingWindowController {
    public static boolean currentStatus = false;
    public static KuangFloatingWindowController instance;
    public View mFloatingView;
    public WindowManager manager;
    public CustomMessageListener mKeyBoardSwitchListener = new CustomMessageListener(2001013) { // from class: com.baidu.tbadk.KuangFloatingWindowController.1
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Boolean data;
            if ((customResponsedMessage instanceof KeyBoardSwitchMessage) && (data = ((KeyBoardSwitchMessage) customResponsedMessage).getData()) != null) {
                if (!data.booleanValue()) {
                    KuangFloatingWindowController.this.hideFloatingView();
                } else if (KuangFloatingWindowController.this.init()) {
                    KuangFloatingWindowController.this.showFloatingView();
                }
            }
        }
    };
    public CustomMessageListener mDialogListener = new CustomMessageListener(2001014) { // from class: com.baidu.tbadk.KuangFloatingWindowController.2
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Boolean data;
            if ((customResponsedMessage instanceof WindowSwitchMessage) && (data = ((WindowSwitchMessage) customResponsedMessage).getData()) != null) {
                if (data.booleanValue()) {
                    KuangFloatingWindowController.this.hideFloatingView();
                } else if (KuangFloatingWindowController.this.init()) {
                    KuangFloatingWindowController.this.showFloatingView();
                }
            }
        }
    };
    public CustomMessageListener mConfigChange = new CustomMessageListener(2001015) { // from class: com.baidu.tbadk.KuangFloatingWindowController.3
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Boolean data;
            if ((customResponsedMessage instanceof ConfigChangeMessage) && (data = ((ConfigChangeMessage) customResponsedMessage).getData()) != null && data.booleanValue()) {
                KuangFloatingWindowController.this.hideFloatingView();
                if (KuangFloatingWindowController.this.init()) {
                    KuangFloatingWindowController.this.showFloatingView();
                }
            }
        }
    };

    private int getHeightPx() {
        DisplayMetrics displayMetrics = new DisplayMetrics();
        Activity currentActivity = TbadkCoreApplication.getInst().getCurrentActivity();
        if (currentActivity == null) {
            return l.g(TbadkCoreApplication.getInst(), R.dimen.tbds800);
        }
        WindowManager windowManager = (WindowManager) currentActivity.getSystemService("window");
        windowManager.getDefaultDisplay().getMetrics(displayMetrics);
        int orientation = windowManager.getDefaultDisplay().getOrientation();
        if (orientation != 1 && orientation != 3) {
            return displayMetrics.heightPixels;
        }
        return displayMetrics.widthPixels;
    }

    public static KuangFloatingWindowController getInstance() {
        if (instance == null) {
            instance = new KuangFloatingWindowController();
        }
        return instance;
    }

    public void hideFloatingView() {
        if (this.manager == null) {
            this.manager = (WindowManager) TbadkCoreApplication.getInst().getSystemService("window");
        }
        View view = this.mFloatingView;
        if (view == null || view.getParent() == null) {
            return;
        }
        try {
            if (Build.VERSION.SDK_INT >= 23 && !Settings.canDrawOverlays(TbadkCoreApplication.getInst().getContext())) {
                this.manager = null;
                this.mFloatingView = null;
                return;
            }
            this.manager.removeView(this.mFloatingView);
            currentStatus = false;
        } catch (SecurityException unused) {
            this.manager = null;
            this.mFloatingView = null;
        }
    }

    public boolean init() {
        View view = this.mFloatingView;
        if (view != null) {
            return view.getParent() == null;
        }
        View inflate = LayoutInflater.from(TbadkCoreApplication.getInst()).inflate(R.layout.floating_window_from_kuang, (ViewGroup) null);
        this.mFloatingView = inflate;
        inflate.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tbadk.KuangFloatingWindowController.4
            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                TbSingleton.getInstance().isShowBackLabel = false;
                KuangFloatingWindowController.this.hideFloatingView();
                Activity currentActivity = TbadkCoreApplication.getInst().getCurrentActivity();
                if (currentActivity != null) {
                    currentActivity.moveTaskToBack(true);
                }
                Intent launchIntentForPackage = TbadkCoreApplication.getInst().getPackageManager().getLaunchIntentForPackage("com.baidu.searchbox");
                if (launchIntentForPackage != null) {
                    launchIntentForPackage.addFlags(Label.FORWARD_REFERENCE_TYPE_SHORT);
                    TbadkCoreApplication.getInst().startActivity(launchIntentForPackage);
                }
            }
        });
        return true;
    }

    public void showFloatingView() {
        WindowManager.LayoutParams layoutParams = new WindowManager.LayoutParams();
        layoutParams.type = c.a(2002);
        layoutParams.flags = 65800;
        layoutParams.format = -3;
        layoutParams.x = 0;
        layoutParams.y = (int) (getHeightPx() * 0.75d);
        layoutParams.width = -2;
        layoutParams.height = l.g(TbadkCoreApplication.getInst(), R.dimen.tbds84);
        layoutParams.gravity = 51;
        if (this.manager == null) {
            this.manager = (WindowManager) TbadkCoreApplication.getInst().getSystemService("window");
        }
        try {
            if (Build.VERSION.SDK_INT >= 23 && !Settings.canDrawOverlays(TbadkCoreApplication.getInst().getContext())) {
                this.manager = null;
                this.mFloatingView = null;
            } else if (init()) {
                if (this.mFloatingView != null && this.mFloatingView.getParent() == null) {
                    this.manager.addView(this.mFloatingView, layoutParams);
                    currentStatus = true;
                }
                MessageManager.getInstance().registerListener(this.mKeyBoardSwitchListener);
                MessageManager.getInstance().registerListener(this.mDialogListener);
                MessageManager.getInstance().registerListener(this.mConfigChange);
            }
        } catch (SecurityException unused) {
            this.manager = null;
            this.mFloatingView = null;
        }
    }
}
