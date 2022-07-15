package com.baidu.live;

import android.os.Bundle;
import android.os.Handler;
import android.text.TextUtils;
import android.view.MotionEvent;
import android.view.ViewConfiguration;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.mytransformapp.util.LogUtil;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.repackage.e80;
import com.repackage.j90;
import com.repackage.ka0;
import com.repackage.ma0;
import com.repackage.t80;
import com.repackage.z70;
/* loaded from: classes2.dex */
public class LiveFeedPageActivity extends AppCompatActivity {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public z70 a;
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
        this.b = ka0.a().b();
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
                this.i = t80.d(this.a.A(), (int) this.e, (int) this.f) && !this.a.A().canScrollHorizontally(-1);
                this.k = t80.d(this.a.D(), (int) this.e, (int) this.f) && !this.a.D().canScrollHorizontally(-1);
                this.l = t80.d(this.a.C(), (int) this.e, (int) this.f) && !this.a.C().canScrollHorizontally(-1);
                if (t80.d(this.a.E(), (int) this.e, (int) this.f) && this.a.P()) {
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
                    if (this.i && !this.a.A().canScrollHorizontally(-1)) {
                        finish();
                    } else if (this.j && this.a.P()) {
                        finish();
                    } else if (this.k && !this.a.D().canScrollHorizontally(-1)) {
                        finish();
                    } else if (this.l && !this.a.C().canScrollHorizontally(-1)) {
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
        String str4;
        boolean z;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, bundle) == null) {
            ma0.e(this);
            super.onCreate(bundle);
            this.d = ViewConfiguration.get(this).getScaledTouchSlop();
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
            z70 z70Var = new z70(this, this.b, getSupportFragmentManager(), "immersion", str4, false, str2, str3, z);
            this.a = z70Var;
            setContentView(z70Var.B());
            this.a.Q();
            e80.t(this, str4, "chenjinshi");
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
                        j90 g;
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
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            super.onDestroy();
            Handler handler = this.c;
            if (handler != null) {
                handler.removeCallbacksAndMessages(null);
            }
            z70 z70Var = this.a;
            if (z70Var != null) {
                z70Var.V();
            }
        }
    }

    @Override // androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onPause() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
            super.onPause();
            z70 z70Var = this.a;
            if (z70Var != null) {
                z70Var.Z();
                this.a.b0(false);
            }
        }
    }

    @Override // androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onResume() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
            super.onResume();
            z70 z70Var = this.a;
            if (z70Var != null) {
                z70Var.a0();
                this.a.b0(true);
            }
        }
    }
}
