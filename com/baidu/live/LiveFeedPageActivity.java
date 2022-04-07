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
import com.repackage.e90;
import com.repackage.j90;
import com.repackage.ma0;
import com.repackage.mb0;
import com.repackage.nb0;
/* loaded from: classes2.dex */
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
    public e90 mBaiduLiveTabContainer;

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
        this.bdUniqueId = mb0.a().b();
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
            nb0.e(this);
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
            e90 e90Var = new e90(this, this.bdUniqueId, getSupportFragmentManager(), "immersion", str4, false, str2, str3, z);
            this.mBaiduLiveTabContainer = e90Var;
            setContentView(e90Var.z());
            this.mBaiduLiveTabContainer.K();
            j90.s(this, str4, "chenjinshi");
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
                        ma0 g;
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
            e90 e90Var = this.mBaiduLiveTabContainer;
            if (e90Var != null) {
                e90Var.P();
            }
        }
    }

    @Override // androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onPause() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            super.onPause();
            e90 e90Var = this.mBaiduLiveTabContainer;
            if (e90Var != null) {
                e90Var.T();
                this.mBaiduLiveTabContainer.V(false);
            }
        }
    }

    @Override // androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onResume() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
            super.onResume();
            e90 e90Var = this.mBaiduLiveTabContainer;
            if (e90Var != null) {
                e90Var.U();
                this.mBaiduLiveTabContainer.V(true);
            }
        }
    }
}
