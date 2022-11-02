package com.baidu.swan.game.guide.install;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import androidx.annotation.Nullable;
import com.baidu.tieba.R;
import com.baidu.tieba.eh3;
import com.baidu.tieba.nh3;
import com.baidu.tieba.wu3;
import com.baidu.tieba.yh3;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.sina.weibo.sdk.share.BaseActivity;
@SuppressLint({BaseActivity.TAG})
/* loaded from: classes3.dex */
public class GameNowInstallAntiBlockingActivity extends Activity {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public String a;

    /* loaded from: classes3.dex */
    public class a implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ GameNowInstallAntiBlockingActivity a;

        public a(GameNowInstallAntiBlockingActivity gameNowInstallAntiBlockingActivity) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {gameNowInstallAntiBlockingActivity};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = gameNowInstallAntiBlockingActivity;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view2) == null) {
                TextUtils.equals(this.a.a, "authorize");
                this.a.finish();
            }
        }
    }

    public GameNowInstallAntiBlockingActivity() {
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

    @Override // android.app.Activity
    public void onCreate(@Nullable Bundle bundle) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, bundle) == null) {
            int c0 = yh3.c0(this);
            super.onCreate(bundle);
            yh3.g(this, c0);
            wu3.q();
            setContentView(R.layout.obfuscated_res_0x7f0d00b2);
            Intent intent = getIntent();
            if (intent != null) {
                this.a = intent.getStringExtra("type");
                intent.getStringExtra("packageName");
                eh3.d(intent.getStringExtra("ubc_params"));
            }
            ImageView imageView = (ImageView) findViewById(R.id.obfuscated_res_0x7f090f6a);
            View findViewById = findViewById(R.id.obfuscated_res_0x7f090f6c);
            if (TextUtils.equals(this.a, "authorize")) {
                FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, getResources().getDimensionPixelOffset(R.dimen.obfuscated_res_0x7f07014d));
                layoutParams.gravity = 80;
                imageView.setLayoutParams(layoutParams);
                findViewById(R.id.obfuscated_res_0x7f090f6b).setVisibility(0);
                imageView.setImageResource(R.drawable.obfuscated_res_0x7f08017e);
                findViewById(R.id.obfuscated_res_0x7f090f68).setBackgroundResource(R.color.obfuscated_res_0x7f0603ca);
                wu3.n();
            } else {
                FrameLayout.LayoutParams layoutParams2 = new FrameLayout.LayoutParams(-1, getResources().getDimensionPixelOffset(R.dimen.obfuscated_res_0x7f07014c));
                layoutParams2.gravity = 80;
                imageView.setLayoutParams(layoutParams2);
                findViewById(R.id.obfuscated_res_0x7f090f6b).setVisibility(8);
                if (nh3.m()) {
                    imageView.setImageResource(R.drawable.obfuscated_res_0x7f08017c);
                } else if (nh3.n()) {
                    imageView.setImageResource(R.drawable.obfuscated_res_0x7f08017d);
                } else if (nh3.r()) {
                    imageView.setImageResource(R.drawable.obfuscated_res_0x7f08017f);
                } else {
                    imageView.setImageResource(R.drawable.obfuscated_res_0x7f08017b);
                }
                findViewById(R.id.obfuscated_res_0x7f090f68).setBackgroundResource(R.color.obfuscated_res_0x7f060399);
                wu3.o();
            }
            findViewById.setOnClickListener(new a(this));
        }
    }
}
