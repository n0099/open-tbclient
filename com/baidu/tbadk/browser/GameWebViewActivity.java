package com.baidu.tbadk.browser;

import android.os.Bundle;
import android.view.WindowManager;
import android.widget.RelativeLayout;
import com.baidu.tbadk.TbadkApplication;
/* loaded from: classes.dex */
public class GameWebViewActivity extends TbWebViewActivity {
    private WindowManager a;
    private com.baidu.tbadk.core.view.b b;
    private boolean c = false;

    static {
        TbadkApplication.m252getInst().RegisterIntent(com.baidu.tbadk.core.atomData.w.class, GameWebViewActivity.class);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.browser.TbWebViewActivity, com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.mBottomTool.setVisibility(8);
        RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.mWebViewContainer.getLayoutParams();
        layoutParams.addRule(3, -1);
        this.mShareFriends.setVisibility(8);
        this.mPopWindow.setHeight(-2);
        this.mWebViewContainer.setLayoutParams(layoutParams);
        this.mParent.removeView(this.mNavigationBar);
        this.mParent.addView(this.mNavigationBar, this.mNavigationBar.getLayoutParams());
        this.mNavigationBar.setVisibility(8);
        this.a = (WindowManager) getSystemService("window");
        this.b = new com.baidu.tbadk.core.view.b(this);
        this.b.setBackgroundResource(com.baidu.tieba.t.btn_game_tie_s);
        this.b.setOnClickListener(new b(this));
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.browser.TbWebViewActivity, com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onResume() {
        super.onResume();
        this.a.addView(this.b, this.b.getWindowManagerParams());
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.browser.TbWebViewActivity, com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onPause() {
        super.onPause();
        this.a.removeView(this.b);
    }
}
