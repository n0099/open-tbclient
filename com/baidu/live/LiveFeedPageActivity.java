package com.baidu.live;

import android.os.Bundle;
import android.os.Handler;
import android.text.TextUtils;
import android.view.MotionEvent;
import android.view.ViewConfiguration;
import androidx.appcompat.app.AppCompatActivity;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.live.feedpage.interfaces.ILiveFeedPageInvoke;
import com.baidu.tieba.dc0;
import com.baidu.tieba.ea0;
import com.baidu.tieba.fc0;
import com.baidu.tieba.s90;
import com.baidu.tieba.y90;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes2.dex */
public class LiveFeedPageActivity extends AppCompatActivity {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public s90 a;
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
        this.b = dc0.a().b();
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
            s90 s90Var = this.a;
            if (s90Var != null) {
                s90Var.T();
            }
        }
    }

    @Override // androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onPause() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
            super.onPause();
            s90 s90Var = this.a;
            if (s90Var != null) {
                s90Var.a0();
                this.a.e0(false);
            }
        }
    }

    @Override // androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onResume() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
            super.onResume();
            s90 s90Var = this.a;
            if (s90Var != null) {
                s90Var.b0();
                this.a.e0(true);
            }
        }
    }

    @Override // android.app.Activity, android.view.Window.Callback
    public boolean dispatchTouchEvent(MotionEvent motionEvent) {
        InterceptResult invokeL;
        boolean z;
        boolean z2;
        boolean z3;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, motionEvent)) == null) {
            if (motionEvent.getAction() == 0) {
                this.e = motionEvent.getX();
                this.f = motionEvent.getY();
                boolean z4 = false;
                if (ea0.g(this.a.z(), (int) this.e, (int) this.f) && !this.a.z().canScrollHorizontally(-1)) {
                    z = true;
                } else {
                    z = false;
                }
                this.i = z;
                if (ea0.g(this.a.C(), (int) this.e, (int) this.f) && !this.a.C().canScrollHorizontally(-1)) {
                    z2 = true;
                } else {
                    z2 = false;
                }
                this.k = z2;
                if (ea0.g(this.a.B(), (int) this.e, (int) this.f) && !this.a.B().canScrollHorizontally(-1)) {
                    z3 = true;
                } else {
                    z3 = false;
                }
                this.l = z3;
                if (ea0.g(this.a.D(), (int) this.e, (int) this.f) && this.a.P()) {
                    z4 = true;
                }
                this.j = z4;
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
    public void onCreate(Bundle bundle) {
        String str;
        String str2;
        String str3;
        boolean z;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, bundle) == null) {
            fc0.g(this);
            super.onCreate(bundle);
            this.d = ViewConfiguration.get(this).getScaledTouchSlop();
            if (bundle != null) {
                finish();
            }
            String str4 = null;
            if (getIntent() == null) {
                str = "";
                str2 = str;
                str3 = str2;
                z = false;
            } else {
                String stringExtra = getIntent().getStringExtra("source");
                str4 = getIntent().getStringExtra("scheme_next");
                String stringExtra2 = getIntent().getStringExtra("tab_extend_subtype");
                String stringExtra3 = getIntent().getStringExtra("tab_extend_thirdtype");
                str = stringExtra2;
                z = getIntent().getBooleanExtra("tab_extend_scroll_to_tab", false);
                str3 = stringExtra;
                str2 = stringExtra3;
            }
            s90 s90Var = new s90(this, this.b, getSupportFragmentManager(), LiveFeedPageSdk.IMMERSION, str3, false, str, str2, z);
            this.a = s90Var;
            setContentView(s90Var.A());
            this.a.Q();
            y90.u(this, str3, "chenjinshi");
            if (!TextUtils.isEmpty(str4)) {
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
                        if ((interceptable2 == null || interceptable2.invokeV(1048576, this) == null) && (invoker = LiveFeedPageSdk.getInstance().getInvoker()) != null) {
                            invoker.invokeScheme(this.b, this.a);
                        }
                    }
                }, 350L);
            }
        }
    }
}
