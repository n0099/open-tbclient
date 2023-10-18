package com.baidu.mobads.sdk.internal;

import android.app.Activity;
import android.content.Context;
import android.os.CountDownTimer;
import android.view.KeyEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.mobads.sdk.api.AdSize;
import com.baidu.searchbox.live.interfaces.defaultimpl.service.LivePreStartPlayServiceImpl;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes3.dex */
public class dl {
    public static /* synthetic */ Interceptable $ic = null;
    public static final int f = 5;
    public transient /* synthetic */ FieldHolder $fh;
    public final String a;
    public final br b;
    public RelativeLayout c;
    public TextView d;
    public CountDownTimer e;
    public Cdo g;
    public boolean h;
    public boolean i;
    public Activity j;
    public Boolean k;

    private RelativeLayout.LayoutParams h() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65541, this)) == null) {
            return null;
        }
        return (RelativeLayout.LayoutParams) invokeV.objValue;
    }

    public void a() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
        }
    }

    public void a(int i, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeII(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i, i2) == null) {
        }
    }

    public boolean a(int i, KeyEvent keyEvent) {
        InterceptResult invokeIL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeIL = interceptable.invokeIL(1048579, this, i, keyEvent)) == null) {
            return true;
        }
        return invokeIL.booleanValue;
    }

    public dl(Context context, RelativeLayout relativeLayout, Boolean bool, AdSize adSize, String str) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context, relativeLayout, bool, adSize, str};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.a = "html5_intersitial";
        this.h = false;
        this.i = false;
        this.b = br.a();
    }

    private boolean e() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65538, this)) == null) {
            return b();
        }
        return invokeV.booleanValue;
    }

    private View f() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65539, this)) == null) {
            this.e = new dn(this, LivePreStartPlayServiceImpl.PLAYER_TIME_OUT_DURATION, 1000L).start();
            return this.c;
        }
        return (View) invokeV.objValue;
    }

    public boolean b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
            if (AdSize.InterstitialForVideoBeforePlay.getValue() == 0) {
                return true;
            }
            return false;
        }
        return invokeV.booleanValue;
    }

    public void c() {
        Activity activity;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeV(1048581, this) != null) || (activity = this.j) == null) {
            return;
        }
        activity.runOnUiThread(new dm(this));
    }

    public boolean d() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) {
            return this.h;
        }
        return invokeV.booleanValue;
    }

    private void g() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(InputDeviceCompat.SOURCE_TRACKBALL, this) == null) {
            RelativeLayout relativeLayout = this.c;
            if (relativeLayout != null && relativeLayout.getParent() != null) {
                ((ViewGroup) this.c.getParent()).removeView(this.c);
            }
            if (this.e != null) {
                this.b.a("cancel countDownTimer before it finished");
                try {
                    this.e.cancel();
                } catch (Exception e) {
                    this.b.a(e);
                }
            }
        }
    }

    public void a(Activity activity, RelativeLayout relativeLayout) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(Constants.METHOD_SEND_USER_MSG, this, activity, relativeLayout) == null) {
            try {
                this.b.a("showInterstitialAdInit");
                if (this.h && !this.i) {
                    this.i = true;
                    this.h = false;
                    this.j = activity;
                    a();
                    c();
                } else if (this.i) {
                    this.b.b("interstitial ad is showing now");
                } else if (!this.h) {
                    this.b.b("interstitial ad is not ready");
                }
            } catch (Exception e) {
                this.b.a(e);
            }
        }
    }
}
