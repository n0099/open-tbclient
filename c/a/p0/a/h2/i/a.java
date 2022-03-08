package c.a.p0.a.h2.i;

import android.content.Context;
import android.os.Build;
import c.a.p0.a.f.d.n;
import c.a.p0.a.p2.o;
import c.a.p0.a.p2.q0;
import c.a.p0.a.v1.e;
import c.a.p0.a.v1.f.z;
import c.a.p0.x.b;
import com.baidu.cyberplayer.sdk.statistics.DpStatConstants;
import com.baidu.searchbox.datacollector.growth.utils.UBCEncryptor;
import com.baidu.searchbox.unitedscheme.CallbackHandler;
import com.baidu.searchbox.unitedscheme.UnitedSchemeBaseDispatcher;
import com.baidu.searchbox.unitedscheme.UnitedSchemeEntity;
import com.baidu.searchbox.unitedscheme.utils.UnitedSchemeUtility;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.baidu.wallet.base.iddetect.UrlOcrConfig;
import java.util.UUID;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes.dex */
public class a extends z {
    public static /* synthetic */ Interceptable $ic;

    /* renamed from: c  reason: collision with root package name */
    public static final boolean f5629c;
    public transient /* synthetic */ FieldHolder $fh;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1144186542, "Lc/a/p0/a/h2/i/a;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1144186542, "Lc/a/p0/a/h2/i/a;");
                return;
            }
        }
        f5629c = c.a.p0.a.a.a;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public a(e eVar) {
        super(eVar, "/swanAPI/getSystemRiskInfo");
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {eVar};
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                Object[] objArr2 = newInitContext.callArgs;
                super((UnitedSchemeBaseDispatcher) objArr2[0], (String) objArr2[1]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
    }

    @Override // c.a.p0.a.v1.f.z
    public boolean d(Context context, UnitedSchemeEntity unitedSchemeEntity, CallbackHandler callbackHandler, c.a.p0.a.t1.e eVar) {
        InterceptResult invokeLLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLLL = interceptable.invokeLLLL(1048576, this, context, unitedSchemeEntity, callbackHandler, eVar)) == null) {
            n h0 = c.a.p0.a.s0.a.h0();
            JSONObject jSONObject = new JSONObject();
            if (context == null) {
                try {
                    context = c.a.p0.a.s0.a.c();
                } catch (JSONException e2) {
                    e2.printStackTrace();
                }
            }
            String str = "";
            jSONObject.put(DpStatConstants.KEY_USER_ID, h0 == null ? "" : h0.h(context));
            jSONObject.put("zid", h0 == null ? "" : c.a.p0.a.s0.a.G0().a(context));
            jSONObject.put("idfa", "");
            jSONObject.put("imei", q0.r());
            jSONObject.put("appkey", eVar == null ? "" : eVar.N());
            jSONObject.put(UrlOcrConfig.IdCardKey.OS, "android");
            jSONObject.put("osVersion", Build.VERSION.RELEASE);
            jSONObject.put("hostName", context.getPackageName());
            jSONObject.put("hostVersion", q0.D());
            jSONObject.put("model", Build.MODEL);
            jSONObject.put("uuid", b.b(context).a());
            jSONObject.put("timestamp", String.valueOf(System.currentTimeMillis() / 1000));
            if (h0 != null) {
                str = h0.i(context);
            }
            jSONObject.put("cuid", str);
            if (f5629c) {
                jSONObject.toString();
            }
            String b2 = c.a.p0.x.d.b.b(UUID.randomUUID().toString().getBytes(), false);
            String a = o.a(b2, jSONObject.toString(), UBCEncryptor.TRANSFORMATION, "4c6579b50ff05adb");
            String d2 = o.d("MIGfMA0GCSqGSIb3DQEBAQUAA4GNADCBiQKBgQCjP7b5s3ozPgXpS7d9k2dGaie8KLNmCbhybWPxVjLTmN4Jj3c7GnwdzyIQOix7t95Kipd75AXcnP2c4vUnmXPpZwh6ejNAmiGLkLE7fobPCZKfI3aTweSKxIav3QPHMaZrra1aiGtnZ+rTHXD3chBpNCGbuAEUqN+psHjvnHO72QIDAQAB", b2, "RSA/ECB/PKCS1Padding");
            if (f5629c) {
                String str2 = "aesKey=" + b2 + ", aesValue=" + a + ", rsaKey=" + d2;
            }
            JSONObject jSONObject2 = new JSONObject();
            JSONObject jSONObject3 = new JSONObject();
            try {
                jSONObject3.put("key", d2);
                jSONObject3.put("value", a);
                jSONObject2.put("content", jSONObject3);
            } catch (JSONException e3) {
                e3.printStackTrace();
            }
            UnitedSchemeUtility.callCallback(callbackHandler, unitedSchemeEntity, UnitedSchemeUtility.wrapCallbackParams(jSONObject2, 0));
            return true;
        }
        return invokeLLLL.booleanValue;
    }
}
