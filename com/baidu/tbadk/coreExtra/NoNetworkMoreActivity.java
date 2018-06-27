package com.baidu.tbadk.coreExtra;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.text.SpannableString;
import android.text.style.ForegroundColorSpan;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import com.baidu.tbadk.BaseActivity;
import com.baidu.tbadk.core.view.NavigationBar;
import com.baidu.tieba.d;
/* loaded from: classes.dex */
public class NoNetworkMoreActivity extends BaseActivity<NoNetworkMoreActivity> {
    private View aBf;
    private TextView aBg;
    private TextView aBh;
    private NavigationBar mNavigationBar;

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(d.i.no_network_more_view);
        initUI();
    }

    protected void initUI() {
        this.mNavigationBar = (NavigationBar) findViewById(d.g.view_navigation_bar);
        this.aBf = this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON, null);
        this.aBf.setOnClickListener(this);
        this.mNavigationBar.setTitleText(d.k.no_network);
        this.aBg = (TextView) findViewById(d.g.more_item1);
        SpannableString spannableString = new SpannableString(getPageContext().getString(d.k.no_network_guide_content1));
        spannableString.setSpan(new ForegroundColorSpan(Color.parseColor("#262626")), 4, 15, 33);
        this.aBg.setText(spannableString);
        this.aBh = (TextView) findViewById(d.g.more_item2);
        SpannableString spannableString2 = new SpannableString(getPageContext().getString(d.k.no_network_guide_content2));
        spannableString2.setSpan(new ForegroundColorSpan(Color.parseColor("#262626")), 4, 15, 33);
        this.aBh.setText(spannableString2);
        ((Button) findViewById(d.g.network_setting_btn)).setOnClickListener(this);
    }

    @Override // com.baidu.adp.base.BdBaseActivity, android.view.View.OnClickListener
    public void onClick(View view) {
        int id = view.getId();
        if (view == this.aBf) {
            finish();
        } else if (id == d.g.network_setting_btn) {
            startActivity(new Intent("android.settings.SETTINGS"));
            finish();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity
    public void onChangeSkinType(int i) {
        this.mNavigationBar.onChangeSkinType(getPageContext(), i);
    }
}
