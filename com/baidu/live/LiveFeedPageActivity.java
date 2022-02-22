package com.baidu.live;

import android.os.Bundle;
import android.os.Handler;
import android.text.TextUtils;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import c.a.y.b.a;
import c.a.y.g.g.b;
import c.a.y.g.g.c;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.mytransformapp.util.LogUtil;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes10.dex */
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
    public a mBaiduLiveTabContainer;

    public LiveFeedPageActivity() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.bdUniqueId = b.a().b();
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
            c.e(this);
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
            a aVar = new a(this, this.bdUniqueId, getSupportFragmentManager(), "immersion", str4, false, str2, str3, z);
            this.mBaiduLiveTabContainer = aVar;
            setContentView(aVar.z());
            this.mBaiduLiveTabContainer.K();
            c.a.y.b.c.a.s(this, str4, "chenjinshi");
            if (!TextUtils.isEmpty(str)) {
                if (this.handler == null) {
                    this.handler = new Handler();
                }
                this.handler.postDelayed(new Runnable(this, str) { // from class: com.baidu.live.LiveFeedPageActivity.1
                    public static /* synthetic */ Interceptable $ic;
                    public transient /* synthetic */ FieldHolder $fh;

                    /* renamed from: e  reason: collision with root package name */
                    public final /* synthetic */ String f34907e;

                    /* renamed from: f  reason: collision with root package name */
                    public final /* synthetic */ LiveFeedPageActivity f34908f;

                    {
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 != null) {
                            InitContext newInitContext = TitanRuntime.newInitContext();
                            newInitContext.initArgs = r2;
                            Object[] objArr = {this, str};
                            interceptable2.invokeUnInit(65536, newInitContext);
                            int i2 = newInitContext.flag;
                            if ((i2 & 1) != 0) {
                                int i3 = i2 & 2;
                                newInitContext.thisArg = this;
                                interceptable2.invokeInitBody(65536, newInitContext);
                                return;
                            }
                        }
                        this.f34908f = this;
                        this.f34907e = str;
                    }

                    @Override // java.lang.Runnable
                    public void run() {
                        c.a.y.d.b.c g2;
                        Interceptable interceptable2 = $ic;
                        if (!(interceptable2 == null || interceptable2.invokeV(1048576, this) == null) || (g2 = LiveFeedPageSdk.f().g()) == null) {
                            return;
                        }
                        g2.invokeScheme(this.f34908f, this.f34907e);
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
            a aVar = this.mBaiduLiveTabContainer;
            if (aVar != null) {
                aVar.P();
            }
        }
    }

    @Override // androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onPause() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            super.onPause();
            a aVar = this.mBaiduLiveTabContainer;
            if (aVar != null) {
                aVar.T();
                this.mBaiduLiveTabContainer.V(false);
            }
        }
    }

    @Override // androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onResume() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
            super.onResume();
            a aVar = this.mBaiduLiveTabContainer;
            if (aVar != null) {
                aVar.U();
                this.mBaiduLiveTabContainer.V(true);
            }
        }
    }
}
