package com.baidu.live;

import android.os.Bundle;
import android.os.Handler;
import android.text.TextUtils;
import android.view.MotionEvent;
import android.view.ViewConfiguration;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.live.feedpage.interfaces.ILiveFeedPageInvoke;
import com.baidu.tieba.e90;
import com.baidu.tieba.k90;
import com.baidu.tieba.pb0;
import com.baidu.tieba.q90;
import com.baidu.tieba.rb0;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes2.dex */
public class LiveFeedPageActivity extends AppCompatActivity {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public e90 a;
    public final int b;
    public Handler c;
    public int d;
    public float e;
    public float f;
    public float g;
    public float h;
    public boolean i;
    public boolean j;
    public boolean k;
    public boolean l;

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
        this.b = pb0.a().b();
    }

    @Override // android.app.Activity, android.view.Window.Callback
    public boolean dispatchTouchEvent(MotionEvent motionEvent) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, motionEvent)) == null) {
            if (motionEvent.getAction() == 0) {
                this.e = motionEvent.getX();
                this.f = motionEvent.getY();
                boolean z = false;
                this.i = q90.g(this.a.z(), (int) this.e, (int) this.f) && !this.a.z().canScrollHorizontally(-1);
                this.k = q90.g(this.a.C(), (int) this.e, (int) this.f) && !this.a.C().canScrollHorizontally(-1);
                this.l = q90.g(this.a.B(), (int) this.e, (int) this.f) && !this.a.B().canScrollHorizontally(-1);
                if (q90.g(this.a.D(), (int) this.e, (int) this.f) && this.a.P()) {
                    z = true;
                }
                this.j = z;
            }
            if (motionEvent.getAction() == 1) {
                this.g = motionEvent.getX();
                float y = motionEvent.getY();
                this.h = y;
                float f = this.g - this.e;
                float abs = Math.abs(y - this.f);
                if (f > this.d && f * 0.5d > abs) {
                    if (this.i && !this.a.z().canScrollHorizontally(-1)) {
                        finish();
                    } else if (this.j && this.a.P()) {
                        finish();
                    } else if (this.k && !this.a.C().canScrollHorizontally(-1)) {
                        finish();
                    } else if (this.l && !this.a.B().canScrollHorizontally(-1)) {
                        finish();
                    }
                }
            }
            return super.dispatchTouchEvent(motionEvent);
        }
        return invokeL.booleanValue;
    }

    @Override // androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public void onCreate(@Nullable Bundle bundle) {
        String str;
        String str2;
        String str3;
        boolean z;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, bundle) == null) {
            rb0.g(this);
            super.onCreate(bundle);
            this.d = ViewConfiguration.get(this).getScaledTouchSlop();
            if (bundle != null) {
                finish();
            }
            String str4 = null;
            if (getIntent() != null) {
                String stringExtra = getIntent().getStringExtra("source");
                str4 = getIntent().getStringExtra("scheme_next");
                String stringExtra2 = getIntent().getStringExtra("tab_extend_subtype");
                String stringExtra3 = getIntent().getStringExtra("tab_extend_thirdtype");
                str = stringExtra2;
                z = getIntent().getBooleanExtra("tab_extend_scroll_to_tab", false);
                str3 = stringExtra;
                str2 = stringExtra3;
            } else {
                str = "";
                str2 = str;
                str3 = str2;
                z = false;
            }
            e90 e90Var = new e90(this, this.b, getSupportFragmentManager(), LiveFeedPageSdk.IMMERSION, str3, false, str, str2, z);
            this.a = e90Var;
            setContentView(e90Var.A());
            this.a.Q();
            k90.u(this, str3, "chenjinshi");
            if (TextUtils.isEmpty(str4)) {
                return;
            }
            if (this.c == null) {
                this.c = new Handler();
            }
            this.c.postDelayed(new Runnable(this, str4) { // from class: com.baidu.live.LiveFeedPageActivity.1
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;
                public final /* synthetic */ String a;
                public final /* synthetic */ LiveFeedPageActivity b;

                {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {this, str4};
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
                    this.a = str4;
                }

                @Override // java.lang.Runnable
                public void run() {
                    ILiveFeedPageInvoke invoker;
                    Interceptable interceptable2 = $ic;
                    if (!(interceptable2 == null || interceptable2.invokeV(1048576, this) == null) || (invoker = LiveFeedPageSdk.getInstance().getInvoker()) == null) {
                        return;
                    }
                    invoker.invokeScheme(this.b, this.a);
                }
            }, 350L);
        }
    }

    @Override // androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onDestroy() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            super.onDestroy();
            Handler handler = this.c;
            if (handler != null) {
                handler.removeCallbacksAndMessages(null);
            }
            e90 e90Var = this.a;
            if (e90Var != null) {
                e90Var.T();
            }
        }
    }

    @Override // androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onPause() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
            super.onPause();
            e90 e90Var = this.a;
            if (e90Var != null) {
                e90Var.a0();
                this.a.e0(false);
            }
        }
    }

    @Override // androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onResume() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
            super.onResume();
            e90 e90Var = this.a;
            if (e90Var != null) {
                e90Var.b0();
                this.a.e0(true);
            }
        }
    }
}
