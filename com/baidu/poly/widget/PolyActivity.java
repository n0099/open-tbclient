package com.baidu.poly.widget;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.os.Build;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.Window;
import androidx.core.view.InputDeviceCompat;
import com.alibaba.fastjson.asm.Label;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.mobads.container.util.AdIconUtil;
import com.baidu.poly.widget.m;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.google.protobuf.CodedInputStream;
import com.heytap.mcssdk.mode.CommandMessage;
import d.a.d0.a;
import d.a.d0.k.h.d;
import d.a.d0.n.b;
import d.a.d0.o.a.c;
import org.json.JSONArray;
import org.json.JSONObject;
/* loaded from: classes2.dex */
public class PolyActivity extends Activity implements m.l {
    public static /* synthetic */ Interceptable $ic;
    public static c m;
    public static a.b n;
    public static boolean o;
    public static PolyActivity p;
    public transient /* synthetic */ FieldHolder $fh;
    public Bundle arguments;
    public m q;

    public PolyActivity() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
            }
        }
    }

    private String X() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65537, this)) == null) {
            try {
                return getPackageManager().getPackageInfo(getPackageName(), 0).versionName;
            } catch (PackageManager.NameNotFoundException e2) {
                e2.printStackTrace();
                return null;
            }
        }
        return (String) invokeV.objValue;
    }

    public static void Y() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(65538, null) == null) || p == null) {
            return;
        }
        if (n != null) {
            String a2 = b.a(2, null, "repeat_pay_cancel");
            n.a(2, a2);
            d.e(2, a2);
        }
        p.finish();
    }

    private void Z() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65539, this) == null) {
            this.arguments = getIntent().getBundleExtra("pay_arguements");
        }
    }

    public static void a(Context context, c cVar, a.b bVar, Bundle bundle) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLLL(InputDeviceCompat.SOURCE_TRACKBALL, null, context, cVar, bVar, bundle) == null) {
            if (o) {
                Y();
            }
            m = cVar;
            n = bVar;
            Intent intent = new Intent(context, PolyActivity.class);
            intent.putExtra("pay_arguements", bundle);
            if (!(context instanceof Activity)) {
                d.a.d0.n.d.e("!context instanceof Activity");
                intent.addFlags(Label.FORWARD_REFERENCE_TYPE_SHORT);
            }
            context.startActivity(intent);
        }
    }

    private void aa() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(AdIconUtil.AD_TEXT_ID, this) == null) || Build.VERSION.SDK_INT < 21) {
            return;
        }
        Window window = getWindow();
        window.clearFlags(CodedInputStream.DEFAULT_SIZE_LIMIT);
        window.addFlags(Integer.MIN_VALUE);
        window.setStatusBarColor(0);
        window.getDecorView().setSystemUiVisibility(1024);
    }

    private void b(Bundle bundle) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(AdIconUtil.BAIDU_LOGO_ID, this, bundle) == null) || bundle == null) {
            return;
        }
        try {
            String string = bundle.getString("zid");
            if (TextUtils.isEmpty(string)) {
                return;
            }
            bundle.remove("zid");
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("c", bundle.getString("cuid"));
            jSONObject.put("z", string);
            jSONObject.put("mac", d.a.d0.n.a.d());
            jSONObject.put("app", "android");
            jSONObject.put("ver", X());
            bundle.putString("deviceInfo", jSONObject.toString());
        } catch (Exception unused) {
        }
    }

    private Bundle c(Bundle bundle) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65543, this, bundle)) == null) {
            if (bundle == null) {
                return new Bundle();
            }
            d.f42120a = bundle.getString("bduss");
            d.f42121b = bundle.getString("tpOrderId");
            d.f42124e = bundle.getString("nativeAppId");
            bundle.putString("deviceType", "ANDROID");
            bundle.putString("channel", "cashiersdk");
            bundle.putString(CommandMessage.SDK_VERSION, "2.7.7");
            String[] stringArray = bundle.getStringArray("blockedPayChannels");
            if (stringArray != null && stringArray.length > 0) {
                bundle.remove("blockedPayChannels");
                JSONArray jSONArray = new JSONArray();
                for (String str : stringArray) {
                    jSONArray.put(str);
                }
                bundle.putString("bannedChannels", jSONArray.toString());
            }
            b(bundle);
            return bundle;
        }
        return (Bundle) invokeL.objValue;
    }

    private void clear() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65544, this) == null) {
            this.q = null;
            m = null;
            this.arguments = null;
            n = null;
            o = false;
            p = null;
        }
    }

    @Override // android.app.Activity
    public void finish() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            super.finish();
            overridePendingTransition(0, 0);
            clear();
            d.j();
        }
    }

    @Override // android.app.Activity
    public void onActivityResult(int i2, int i3, Intent intent) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIIL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i2, i3, intent) == null) {
            super.onActivityResult(i2, i3, intent);
            if (i2 == 200) {
                if (i3 == -1) {
                    d.a.d0.k.i.a.k().d(this, intent.getExtras(), this.q, true);
                    return;
                }
                m mVar = this.q;
                if (mVar != null) {
                    mVar.g(3, "pay canceled , back from H5. ");
                }
            }
        }
    }

    @Override // android.app.Activity
    public void onBackPressed() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            m mVar = this.q;
            if (mVar == null) {
                super.onBackPressed();
                return;
            }
            if (!mVar.g0()) {
                super.onBackPressed();
            }
            d.a.d0.n.d.e("PolyActivity onBackPressed");
        }
    }

    @Override // com.baidu.poly.widget.m.l
    public void onClose() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
            finish();
        }
    }

    @Override // android.app.Activity
    public void onCreate(Bundle bundle) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, bundle) == null) {
            aa();
            o = true;
            p = this;
            d.a();
            super.onCreate(bundle);
            overridePendingTransition(0, 0);
            Z();
            d.a.d0.n.d.e("PolyActivity onCreate");
        }
    }

    @Override // android.app.Activity
    public void onDestroy() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048581, this) == null) {
            clear();
            super.onDestroy();
        }
    }

    @Override // android.app.Activity
    public void onPause() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048582, this) == null) {
            super.onPause();
        }
    }

    @Override // android.app.Activity
    public void onResume() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048583, this) == null) {
            super.onResume();
        }
    }

    @Override // android.app.Activity
    public void onStop() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this) == null) {
            super.onStop();
        }
    }

    @Override // android.app.Activity, android.view.Window.Callback
    public void onWindowFocusChanged(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048585, this, z) == null) {
            super.onWindowFocusChanged(z);
            if (!z || this.q != null || isFinishing() || this.arguments == null) {
                return;
            }
            m mVar = new m(this);
            this.q = mVar;
            setContentView(mVar);
            this.q.setResultListener(n);
            this.q.setCloseListener(this);
            this.q.setWalletList(new d.a.d0.k.i.c(new d.a.d0.k.i.b(this, m)));
            String string = this.arguments.getString("chosenChannel");
            if (TextUtils.equals(this.arguments.getString("panelType"), "NONE") && !TextUtils.isEmpty(string)) {
                this.q.i(c(this.arguments), string);
                return;
            }
            this.q.h(c(this.arguments));
            this.q.O();
        }
    }
}
