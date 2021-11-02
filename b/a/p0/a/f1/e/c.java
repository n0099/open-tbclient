package b.a.p0.a.f1.e;

import android.app.Application;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import androidx.core.view.InputDeviceCompat;
import b.a.p0.a.f1.e.c;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.searchbox.unitedscheme.utils.UnitedSchemeConstants;
import com.baidu.swan.apps.SwanAppLauncherActivity;
import com.baidu.swan.apps.favordata.SwanFavorItemData;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import org.apache.commons.lang3.text.ExtendedMessageFormat;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes.dex */
public abstract class c<SelfT extends c<SelfT>> extends e<SelfT> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* loaded from: classes.dex */
    public static final class a extends c<a> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        public a() {
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

        @Override // b.a.p0.a.v2.e1.d
        public /* bridge */ /* synthetic */ b.a.p0.a.v2.e1.d a() {
            e1();
            return this;
        }

        public a e1() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this : (a) invokeV.objValue;
        }

        @Override // b.a.p0.a.f1.e.c, b.a.p0.a.f1.e.f.c
        public /* bridge */ /* synthetic */ b.a.p0.a.f1.e.f.c update(Bundle bundle) {
            return super.update(bundle);
        }
    }

    public c() {
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

    public static String a1(String str, int i2, JSONObject jSONObject) {
        InterceptResult invokeLIL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLIL = interceptable.invokeLIL(65537, null, str, i2, jSONObject)) == null) {
            String str2 = i2 == 1 ? SwanFavorItemData.SCHEME_AUTHORITY_SWAN_GAME : "swan";
            if (jSONObject == null) {
                jSONObject = new JSONObject();
            }
            Uri.Builder builder = new Uri.Builder();
            builder.scheme(UnitedSchemeConstants.UNITED_SCHEME).authority(str2).appendPath(str).appendQueryParameter("_baiduboxapp", jSONObject.toString()).build();
            return builder.toString();
        }
        return (String) invokeLIL.objValue;
    }

    public static c b1(Bundle bundle) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65538, null, bundle)) == null) {
            a aVar = new a();
            aVar.update(bundle);
            return aVar;
        }
        return (c) invokeL.objValue;
    }

    public static Intent c1(Context context, c cVar) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65539, null, context, cVar)) == null) {
            if (context == null || cVar == null) {
                return null;
            }
            Intent intent = new Intent();
            intent.setAction(SwanAppLauncherActivity.SWAN_APP_LAUNCH_ACTION);
            intent.setComponent(new ComponentName(context, SwanAppLauncherActivity.class));
            if (context instanceof Application) {
                intent.setFlags(268435456);
            }
            intent.putExtras(cVar.C());
            return intent;
        }
        return (Intent) invokeLL.objValue;
    }

    public static String d1(String str, String str2, int i2) {
        InterceptResult invokeLLI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLI = interceptable.invokeLLI(InputDeviceCompat.SOURCE_TRACKBALL, null, str, str2, i2)) == null) {
            String str3 = i2 == 1 ? SwanFavorItemData.SCHEME_AUTHORITY_SWAN_GAME : "swan";
            Uri.Builder builder = new Uri.Builder();
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.put("from", str2);
            } catch (JSONException e2) {
                e2.printStackTrace();
            }
            builder.scheme(UnitedSchemeConstants.UNITED_SCHEME).authority(str3).appendPath(str).appendQueryParameter("_baiduboxapp", jSONObject.toString()).build();
            return builder.toString();
        }
        return (String) invokeLLI.objValue;
    }

    @Override // b.a.p0.a.f1.e.f.c
    public String toString() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            return "SwanAppLaunchParams{appId='" + G() + ExtendedMessageFormat.QUOTE + ", from='" + S() + ExtendedMessageFormat.QUOTE + ", page='" + d0() + ExtendedMessageFormat.QUOTE + ", isDebug=" + l0() + ", extraData=" + O() + ", clickId='" + K() + ExtendedMessageFormat.QUOTE + ", launchScheme='" + V() + ExtendedMessageFormat.QUOTE + ", notInHistory='" + b0() + ExtendedMessageFormat.QUOTE + ExtendedMessageFormat.END_FE;
        }
        return (String) invokeV.objValue;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // b.a.p0.a.f1.e.f.c
    public SelfT update(Bundle bundle) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, bundle)) == null) {
            b.a.p0.a.e0.f.b.h(bundle);
            return (SelfT) super.update(bundle);
        }
        return (SelfT) invokeL.objValue;
    }
}
