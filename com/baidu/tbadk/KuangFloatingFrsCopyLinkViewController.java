package com.baidu.tbadk;

import android.app.Activity;
import android.os.Build;
import android.provider.Settings;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.baidu.adp.base.a;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.lib.f.e;
import com.baidu.adp.lib.util.l;
import com.baidu.live.tbadk.core.frameworkdata.CmdConfigCustom;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.message.BackgroundSwitchMessage;
import com.baidu.tbadk.core.util.SvgManager;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.ap;
import com.baidu.tbadk.core.util.aq;
import com.baidu.tieba.R;
import com.baidu.tieba.v.c;
import java.util.Map;
/* loaded from: classes.dex */
public class KuangFloatingFrsCopyLinkViewController {
    private static KuangFloatingFrsCopyLinkViewController instance = null;
    private Activity bgTopActivity;
    private ImageView floatingViewArrow;
    private ImageView floatingViewIcon;
    private LinearLayout floatingViewMain;
    private TextView floatingViewTitle;
    private boolean isBackGrouod;
    private View mFloatingView;
    private Runnable runnable;
    private Activity topActivity;
    private WindowManager wm;
    private CustomMessageListener mBackGroundSwitchListener = new CustomMessageListener(CmdConfigCustom.CMD_BACKGROUND_SWTICH) { // from class: com.baidu.tbadk.KuangFloatingFrsCopyLinkViewController.1
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Boolean data;
            if ((customResponsedMessage instanceof BackgroundSwitchMessage) && (data = ((BackgroundSwitchMessage) customResponsedMessage).getData()) != null) {
                if (data.booleanValue()) {
                    KuangFloatingFrsCopyLinkViewController.this.isBackGrouod = true;
                    if (KuangFloatingFrsCopyLinkViewController.this.topActivity != null) {
                        KuangFloatingFrsCopyLinkViewController.this.bgTopActivity = KuangFloatingFrsCopyLinkViewController.this.topActivity;
                    }
                    KuangFloatingFrsCopyLinkViewController.this.hideFloatingView(true);
                    return;
                }
                KuangFloatingFrsCopyLinkViewController.this.isBackGrouod = false;
                if (KuangFloatingFrsCopyLinkViewController.this.bgTopActivity != null) {
                    KuangFloatingFrsCopyLinkViewController.this.topActivity = KuangFloatingFrsCopyLinkViewController.this.bgTopActivity;
                    KuangFloatingFrsCopyLinkViewController.this.bgTopActivity = null;
                    if (a.lg().m(KuangFloatingFrsCopyLinkViewController.this.topActivity) != -1) {
                        KuangFloatingFrsCopyLinkViewController.this.init();
                        KuangFloatingFrsCopyLinkViewController.this.showFloatingView(false);
                    }
                }
            }
        }
    };
    private CustomMessageListener mForumBcastEditShowLiner = new CustomMessageListener(2921478) { // from class: com.baidu.tbadk.KuangFloatingFrsCopyLinkViewController.2
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Map map;
            if (customResponsedMessage != null && customResponsedMessage.getData() != null && (map = (Map) customResponsedMessage.getData()) != null) {
                String str = (String) map.get("lifeCycle");
                if ("BarBroadcastEdit".equals((String) map.get("name"))) {
                    if ("0".equals(str) || "1".equals(str)) {
                        KuangFloatingFrsCopyLinkViewController.this.hideFloatingView(false);
                    }
                }
            }
        }
    };
    private CustomMessageListener skinChangeListener = new CustomMessageListener(CmdConfigCustom.CMD_SKIN_TYPE_CHANGE) { // from class: com.baidu.tbadk.KuangFloatingFrsCopyLinkViewController.3
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && customResponsedMessage.getCmd() == 2001304 && (customResponsedMessage.getData() instanceof Integer) && KuangFloatingFrsCopyLinkViewController.this.mFloatingView != null) {
                KuangFloatingFrsCopyLinkViewController.this.changeSkin();
            }
        }
    };

    public static KuangFloatingFrsCopyLinkViewController getInstance() {
        if (instance == null) {
            instance = new KuangFloatingFrsCopyLinkViewController();
        }
        return instance;
    }

    public boolean init() {
        if (this.mFloatingView == null) {
            this.mFloatingView = LayoutInflater.from(TbadkCoreApplication.getInst()).inflate(R.layout.floating_view_from_bcast_copy_link, (ViewGroup) null);
            this.mFloatingView.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tbadk.KuangFloatingFrsCopyLinkViewController.4
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    int m;
                    int size;
                    if (KuangFloatingFrsCopyLinkViewController.this.topActivity != null && (m = a.lg().m(KuangFloatingFrsCopyLinkViewController.this.topActivity)) != -1 && m < a.lg().getSize() && (size = a.lg().getSize() - m) >= 0) {
                        a.lg().Y(size);
                    }
                    TiebaStatic.log(new aq("c13881").u("uid", TbadkCoreApplication.getCurrentAccountId()));
                    KuangFloatingFrsCopyLinkViewController.this.hideFloatingView(false);
                }
            });
            this.floatingViewIcon = (ImageView) this.mFloatingView.findViewById(R.id.floating_view_icon);
            this.floatingViewTitle = (TextView) this.mFloatingView.findViewById(R.id.floating_view_title);
            this.floatingViewArrow = (ImageView) this.mFloatingView.findViewById(R.id.floating_view_arrow);
            this.floatingViewMain = (LinearLayout) this.mFloatingView.findViewById(R.id.floating_view_main);
            this.floatingViewTitle.setText(R.string.frs_forum_bcast_return_info);
            changeSkin();
        } else if (this.mFloatingView.getParent() != null) {
            return false;
        }
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void changeSkin() {
        ap.setViewTextColor(this.floatingViewTitle, R.color.cp_cont_a);
        ap.setImageResource(this.floatingViewIcon, R.drawable.pic_float_return_broadcast32);
        SvgManager.bmU().a(this.floatingViewArrow, R.drawable.ic_icon_mybar_pure_list_arrow16_right, R.color.cp_cont_a, SvgManager.SvgResourceStateType.NORMAL);
        com.baidu.tbadk.core.util.e.a.bnv().oP(R.color.cp_link_tip_d).oO(0).oW(211).Z(l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds52)).ab(l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds52)).bf(this.floatingViewMain);
    }

    public void showFloatingView(boolean z) {
        WindowManager.LayoutParams layoutParams = new WindowManager.LayoutParams();
        layoutParams.type = c.JQ(2002);
        layoutParams.flags = 65800;
        layoutParams.format = -3;
        layoutParams.x = 0;
        layoutParams.y = l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds144);
        layoutParams.width = -2;
        layoutParams.height = -2;
        layoutParams.gravity = 85;
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
                    if (z) {
                        this.topActivity = a.lg().currentActivity();
                    }
                }
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921473, 0));
                MessageManager.getInstance().registerListener(this.mBackGroundSwitchListener);
                MessageManager.getInstance().registerListener(this.skinChangeListener);
                MessageManager.getInstance().registerListener(this.mForumBcastEditShowLiner);
            }
        } catch (SecurityException e) {
            this.wm = null;
            this.mFloatingView = null;
        }
    }

    public void hideFloatingView(boolean z) {
        if (this.wm == null) {
            this.wm = (WindowManager) TbadkCoreApplication.getInst().getSystemService("window");
        }
        if (this.mFloatingView != null && this.mFloatingView.getParent() != null) {
            try {
                if (Build.VERSION.SDK_INT >= 23 && !Settings.canDrawOverlays(TbadkCoreApplication.getInst().getContext())) {
                    if (this.wm != null && this.mFloatingView != null) {
                        this.wm.removeView(this.mFloatingView);
                    }
                    this.wm = null;
                    this.mFloatingView = null;
                    return;
                }
                this.wm.removeView(this.mFloatingView);
                this.mFloatingView = null;
                this.wm = null;
                if (!z && !this.isBackGrouod) {
                    this.runnable = new Runnable() { // from class: com.baidu.tbadk.KuangFloatingFrsCopyLinkViewController.5
                        @Override // java.lang.Runnable
                        public void run() {
                            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921473, 1));
                        }
                    };
                    e.mY().postDelayed(this.runnable, 300L);
                }
            } catch (SecurityException e) {
                this.wm = null;
                this.mFloatingView = null;
            }
        }
    }

    public boolean isFloatCopyViewShow() {
        return (this.wm == null || this.mFloatingView == null || this.mFloatingView.getParent() == null) ? false : true;
    }

    public void onDestory() {
        hideFloatingView(false);
        this.bgTopActivity = null;
        this.topActivity = null;
        instance = null;
        if (this.runnable != null) {
            e.mY().removeCallbacks(this.runnable);
        }
    }
}
