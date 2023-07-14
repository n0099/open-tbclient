package com.baidu.tbadk.coreExtra;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.text.SpannableString;
import android.text.style.ForegroundColorSpan;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.BaseActivity;
import com.baidu.tbadk.core.view.NavigationBar;
import com.baidu.tieba.R;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes4.dex */
public class NoNetworkMoreActivity extends BaseActivity<NoNetworkMoreActivity> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public View a;
    public NavigationBar b;
    public TextView c;
    public TextView d;

    public NoNetworkMoreActivity() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
            }
        }
    }

    @Override // com.baidu.tbadk.BaseActivity
    public void onChangeSkinType(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048576, this, i) == null) {
            this.b.onChangeSkinType(getPageContext(), i);
        }
    }

    @Override // com.baidu.adp.base.BdBaseActivity, android.view.View.OnClickListener
    public void onClick(View view2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, view2) == null) {
            int id = view2.getId();
            if (view2 == this.a) {
                finish();
            } else if (id == R.id.network_setting_btn) {
                startActivity(new Intent("android.settings.SETTINGS"));
                finish();
            }
        }
    }

    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, bundle) == null) {
            super.onCreate(bundle);
            setContentView(R.layout.no_network_more_view);
            u1();
        }
    }

    public void u1() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
            NavigationBar navigationBar = (NavigationBar) findViewById(R.id.view_navigation_bar);
            this.b = navigationBar;
            View addSystemImageButton = navigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON, null);
            this.a = addSystemImageButton;
            addSystemImageButton.setOnClickListener(this);
            this.b.setTitleText(R.string.no_network);
            this.c = (TextView) findViewById(R.id.more_item1);
            SpannableString spannableString = new SpannableString(getPageContext().getString(R.string.no_network_guide_content1));
            spannableString.setSpan(new ForegroundColorSpan(Color.parseColor("#262626")), 4, 15, 33);
            this.c.setText(spannableString);
            this.d = (TextView) findViewById(R.id.more_item2);
            SpannableString spannableString2 = new SpannableString(getPageContext().getString(R.string.no_network_guide_content2));
            spannableString2.setSpan(new ForegroundColorSpan(Color.parseColor("#262626")), 4, 15, 33);
            this.d.setText(spannableString2);
            ((Button) findViewById(R.id.network_setting_btn)).setOnClickListener(this);
        }
    }
}
