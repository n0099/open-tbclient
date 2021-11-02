package com.baidu.live;

import android.os.Bundle;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import b.a.w.b.a;
import b.a.w.e.g.b;
import b.a.w.e.g.c;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes7.dex */
public class LiveFeedPageActivity extends AppCompatActivity {
    public static /* synthetic */ Interceptable $ic = null;
    public static final String SOURCE = "source";
    public transient /* synthetic */ FieldHolder $fh;
    public final int bdUniqueId;
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
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, bundle) == null) {
            c.e(this);
            super.onCreate(bundle);
            String stringExtra = getIntent() != null ? getIntent().getStringExtra("source") : "";
            a aVar = new a(this, this.bdUniqueId, getSupportFragmentManager(), "immersion", stringExtra, false);
            this.mBaiduLiveTabContainer = aVar;
            setContentView(aVar.u());
            this.mBaiduLiveTabContainer.D();
            b.a.w.b.c.a.r(this, stringExtra, "chenjinshi");
        }
    }

    @Override // androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onDestroy() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            super.onDestroy();
            a aVar = this.mBaiduLiveTabContainer;
            if (aVar != null) {
                aVar.F();
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
                aVar.J();
                this.mBaiduLiveTabContainer.L(false);
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
                aVar.K();
                this.mBaiduLiveTabContainer.L(true);
            }
        }
    }
}
