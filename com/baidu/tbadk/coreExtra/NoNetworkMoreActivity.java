package com.baidu.tbadk.coreExtra;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.text.SpannableString;
import android.text.style.ForegroundColorSpan;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import com.baidu.tbadk.a;
import com.baidu.tbadk.core.view.NavigationBar;
import com.baidu.tbadk.j;
import com.baidu.tbadk.k;
import com.baidu.tbadk.l;
/* loaded from: classes.dex */
public class NoNetworkMoreActivity extends a {
    private View a;
    private NavigationBar b;
    private TextView c;
    private TextView d;

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.a, com.baidu.adp.a.a, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(k.no_network_more_view);
        this.b = (NavigationBar) findViewById(j.view_navigation_bar);
        this.a = this.b.a(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON, (View.OnClickListener) null);
        this.a.setOnClickListener(this);
        this.b.a(l.no_network);
        this.c = (TextView) findViewById(j.more_item1);
        SpannableString spannableString = new SpannableString(getString(l.no_network_guide_content1));
        spannableString.setSpan(new ForegroundColorSpan(Color.parseColor("#262626")), 4, 15, 33);
        this.c.setText(spannableString);
        this.d = (TextView) findViewById(j.more_item2);
        SpannableString spannableString2 = new SpannableString(getString(l.no_network_guide_content2));
        spannableString2.setSpan(new ForegroundColorSpan(Color.parseColor("#262626")), 4, 15, 33);
        this.d.setText(spannableString2);
        ((Button) findViewById(j.network_setting_btn)).setOnClickListener(this);
    }

    @Override // com.baidu.adp.a.a, android.view.View.OnClickListener
    public void onClick(View view) {
        int id = view.getId();
        if (view == this.a) {
            finish();
        } else if (id == j.network_setting_btn) {
            startActivity(new Intent("android.settings.SETTINGS"));
            finish();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.a
    public void onChangeSkinType(int i) {
        this.b.b(i);
    }
}
