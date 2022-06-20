package com.baidu.live;

import android.os.Bundle;
import android.os.Handler;
import android.text.TextUtils;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.mytransformapp.util.LogUtil;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.repackage.d80;
import com.repackage.g90;
import com.repackage.ga0;
import com.repackage.ha0;
import com.repackage.y70;
/* loaded from: classes2.dex */
public class LiveFeedPageActivity extends AppCompatActivity {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public y70 a;
    public final int b;
    public Handler c;

    public LiveFeedPageActivity() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.b = ga0.a().b();
    }

    @Override // androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public void onCreate(@Nullable Bundle bundle) {
        String str;
        String str2;
        String str3;
        String str4;
        boolean z;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, bundle) == null) {
            ha0.e(this);
            super.onCreate(bundle);
            if (getIntent() != null) {
                String stringExtra = getIntent().getStringExtra("source");
                str = getIntent().getStringExtra("scheme_next");
                String stringExtra2 = getIntent().getStringExtra("tab_extend_subtype");
                String stringExtra3 = getIntent().getStringExtra("tab_extend_thirdtype");
                z = getIntent().getBooleanExtra("tab_extend_scroll_to_tab", false);
                str4 = stringExtra;
                str2 = stringExtra2;
                str3 = stringExtra3;
            } else {
                str = null;
                str2 = "";
                str3 = str2;
                str4 = str3;
                z = false;
            }
            y70 y70Var = new y70(this, this.b, getSupportFragmentManager(), "immersion", str4, false, str2, str3, z);
            this.a = y70Var;
            setContentView(y70Var.z());
            this.a.K();
            d80.s(this, str4, "chenjinshi");
            if (!TextUtils.isEmpty(str)) {
                if (this.c == null) {
                    this.c = new Handler();
                }
                this.c.postDelayed(new Runnable(this, str) { // from class: com.baidu.live.LiveFeedPageActivity.1
                    public static /* synthetic */ Interceptable $ic;
                    public transient /* synthetic */ FieldHolder $fh;
                    public final /* synthetic */ String a;
                    public final /* synthetic */ LiveFeedPageActivity b;

                    {
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 != null) {
                            InitContext newInitContext = TitanRuntime.newInitContext();
                            newInitContext.initArgs = r2;
                            Object[] objArr = {this, str};
                            interceptable2.invokeUnInit(65536, newInitContext);
                            int i = newInitContext.flag;
                            if ((i & 1) != 0) {
                                int i2 = i & 2;
                                newInitContext.thisArg = this;
                                interceptable2.invokeInitBody(65536, newInitContext);
                                return;
                            }
                        }
                        this.b = this;
                        this.a = str;
                    }

                    @Override // java.lang.Runnable
                    public void run() {
                        g90 g;
                        Interceptable interceptable2 = $ic;
                        if (!(interceptable2 == null || interceptable2.invokeV(1048576, this) == null) || (g = LiveFeedPageSdk.f().g()) == null) {
                            return;
                        }
                        g.invokeScheme(this.b, this.a);
                    }
                }, 350L);
            }
            LogUtil.logActivity(this, "onCreate");
        }
    }

    @Override // androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onDestroy() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            super.onDestroy();
            Handler handler = this.c;
            if (handler != null) {
                handler.removeCallbacksAndMessages(null);
            }
            y70 y70Var = this.a;
            if (y70Var != null) {
                y70Var.P();
            }
        }
    }

    @Override // androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onPause() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            super.onPause();
            y70 y70Var = this.a;
            if (y70Var != null) {
                y70Var.T();
                this.a.V(false);
            }
        }
    }

    @Override // androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onResume() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
            super.onResume();
            y70 y70Var = this.a;
            if (y70Var != null) {
                y70Var.U();
                this.a.V(true);
            }
        }
    }
}
