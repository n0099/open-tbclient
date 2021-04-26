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
import com.baidu.tieba.R;
/* loaded from: classes3.dex */
public class NoNetworkMoreActivity extends BaseActivity<NoNetworkMoreActivity> {
    public View mBack;
    public NavigationBar mNavigationBar;
    public TextView more1;
    public TextView more2;

    public void initUI() {
        NavigationBar navigationBar = (NavigationBar) findViewById(R.id.view_navigation_bar);
        this.mNavigationBar = navigationBar;
        View addSystemImageButton = navigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON, null);
        this.mBack = addSystemImageButton;
        addSystemImageButton.setOnClickListener(this);
        this.mNavigationBar.setTitleText(R.string.no_network);
        this.more1 = (TextView) findViewById(R.id.more_item1);
        SpannableString spannableString = new SpannableString(getPageContext().getString(R.string.no_network_guide_content1));
        spannableString.setSpan(new ForegroundColorSpan(Color.parseColor("#262626")), 4, 15, 33);
        this.more1.setText(spannableString);
        this.more2 = (TextView) findViewById(R.id.more_item2);
        SpannableString spannableString2 = new SpannableString(getPageContext().getString(R.string.no_network_guide_content2));
        spannableString2.setSpan(new ForegroundColorSpan(Color.parseColor("#262626")), 4, 15, 33);
        this.more2.setText(spannableString2);
        ((Button) findViewById(R.id.network_setting_btn)).setOnClickListener(this);
    }

    @Override // com.baidu.tbadk.BaseActivity
    public void onChangeSkinType(int i2) {
        this.mNavigationBar.onChangeSkinType(getPageContext(), i2);
    }

    @Override // com.baidu.adp.base.BdBaseActivity, android.view.View.OnClickListener
    public void onClick(View view) {
        int id = view.getId();
        if (view == this.mBack) {
            finish();
        } else if (id == R.id.network_setting_btn) {
            startActivity(new Intent("android.settings.SETTINGS"));
            finish();
        }
    }

    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(R.layout.no_network_more_view);
        initUI();
    }
}
