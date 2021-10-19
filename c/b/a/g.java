package c.b.a;

import android.content.Context;
import android.content.SharedPreferences;
import android.provider.Settings;
import com.baidu.mobads.container.adrequest.IAdRequestParam;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.math.BigInteger;
import java.security.SecureRandom;
import org.json.JSONObject;
/* loaded from: classes4.dex */
public class g extends s1 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: e  reason: collision with root package name */
    public final Context f31367e;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public g(Context context) {
        super(false, false);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                Object[] objArr2 = newInitContext.callArgs;
                super(((Boolean) objArr2[0]).booleanValue(), ((Boolean) objArr2[1]).booleanValue());
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f31367e = context;
    }

    @Override // c.b.a.s1
    public boolean b(JSONObject jSONObject) {
        InterceptResult invokeL;
        String str;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, jSONObject)) == null) {
            try {
                str = Settings.Secure.getString(this.f31367e.getContentResolver(), IAdRequestParam.ANDROID_ID);
            } catch (Exception e2) {
                h0.d("", e2);
                str = null;
            }
            if (!z1.q(str) || "9774d56d682e549c".equals(str)) {
                SharedPreferences sharedPreferences = this.f31367e.getSharedPreferences("snssdk_openudid", 0);
                String string = sharedPreferences.getString("openudid", null);
                if (!z1.q(string)) {
                    string = new BigInteger(64, new SecureRandom()).toString(16);
                    if (string.charAt(0) == '-') {
                        string = string.substring(1);
                    }
                    int length = 13 - string.length();
                    if (length > 0) {
                        StringBuilder sb = new StringBuilder();
                        while (length > 0) {
                            sb.append('F');
                            length--;
                        }
                        sb.append(string);
                        string = sb.toString();
                    }
                    try {
                        string = a("openudid.dat", string);
                    } catch (Exception unused) {
                    }
                    SharedPreferences.Editor edit = sharedPreferences.edit();
                    edit.putString("openudid", string);
                    edit.apply();
                }
                str = string;
            }
            jSONObject.put("openudid", str);
            return true;
        }
        return invokeL.booleanValue;
    }
}
