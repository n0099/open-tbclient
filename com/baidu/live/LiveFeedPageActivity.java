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
import com.repackage.c90;
import com.repackage.ca0;
import com.repackage.da0;
import com.repackage.u70;
import com.repackage.z70;
/* loaded from: classes.dex */
public class LiveFeedPageActivity extends AppCompatActivity {
    public static /* synthetic */ Interceptable $ic = null;
    public static final String SCHEME_NEXT = "scheme_next";
    public static final String SOURCE = "source";
    public static final String TAB_EXTEND_SCOLL_TO_TAB = "tab_extend_scroll_to_tab";
    public static final String TAB_EXTEND_SUBTYPE = "tab_extend_subtype";
    public static final String TAB_EXTEND_THIRDTYPE = "tab_extend_thirdtype";
    public transient /* synthetic */ FieldHolder $fh;
    public final int bdUniqueId;
    public Handler handler;
    public u70 mBaiduLiveTabContainer;

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
        this.bdUniqueId = ca0.a().b();
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
            da0.e(this);
            super.onCreate(bundle);
            if (getIntent() != null) {
                String stringExtra = getIntent().getStringExtra("source");
                str = getIntent().getStringExtra(SCHEME_NEXT);
                String stringExtra2 = getIntent().getStringExtra(TAB_EXTEND_SUBTYPE);
                String stringExtra3 = getIntent().getStringExtra(TAB_EXTEND_THIRDTYPE);
                z = getIntent().getBooleanExtra(TAB_EXTEND_SCOLL_TO_TAB, false);
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
            u70 u70Var = new u70(this, this.bdUniqueId, getSupportFragmentManager(), "immersion", str4, false, str2, str3, z);
            this.mBaiduLiveTabContainer = u70Var;
            setContentView(u70Var.z());
            this.mBaiduLiveTabContainer.K();
            z70.s(this, str4, "chenjinshi");
            if (!TextUtils.isEmpty(str)) {
                if (this.handler == null) {
                    this.handler = new Handler();
                }
                this.handler.postDelayed(new Runnable(this, str) { // from class: com.baidu.live.LiveFeedPageActivity.1
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
                        c90 g;
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
            Handler handler = this.handler;
            if (handler != null) {
                handler.removeCallbacksAndMessages(null);
            }
            u70 u70Var = this.mBaiduLiveTabContainer;
            if (u70Var != null) {
                u70Var.P();
            }
        }
    }

    @Override // androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onPause() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            super.onPause();
            u70 u70Var = this.mBaiduLiveTabContainer;
            if (u70Var != null) {
                u70Var.T();
                this.mBaiduLiveTabContainer.V(false);
            }
        }
    }

    @Override // androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onResume() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
            super.onResume();
            u70 u70Var = this.mBaiduLiveTabContainer;
            if (u70Var != null) {
                u70Var.U();
                this.mBaiduLiveTabContainer.V(true);
            }
        }
    }
}
