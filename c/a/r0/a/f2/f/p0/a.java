package c.a.r0.a.f2.f.p0;

import android.content.Context;
import android.graphics.Bitmap;
import android.text.TextUtils;
import androidx.annotation.NonNull;
import c.a.r0.a.d2.e;
import c.a.r0.a.e0.d;
import c.a.r0.a.f2.f.z;
import c.a.r0.a.o2.b;
import c.a.r0.a.z2.n0;
import c.a.r0.a.z2.q;
import c.a.r0.a.z2.q0;
import c.a.r0.a.z2.w;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.ar.statistic.StatisticConstants;
import com.baidu.searchbox.unitedscheme.CallbackHandler;
import com.baidu.searchbox.unitedscheme.UnitedSchemeBaseDispatcher;
import com.baidu.searchbox.unitedscheme.UnitedSchemeEntity;
import com.baidu.searchbox.unitedscheme.utils.UnitedSchemeUtility;
import com.baidu.spswitch.emotion.resource.EmotionResourceProvider;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes.dex */
public class a extends z {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: c  reason: collision with root package name */
    public String f6291c;

    /* renamed from: c.a.r0.a.f2.f.p0.a$a  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public class RunnableC0326a implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ UnitedSchemeEntity f6292e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ CallbackHandler f6293f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ e f6294g;

        /* renamed from: h  reason: collision with root package name */
        public final /* synthetic */ a f6295h;

        /* renamed from: c.a.r0.a.f2.f.p0.a$a$a  reason: collision with other inner class name */
        /* loaded from: classes.dex */
        public class RunnableC0327a implements Runnable {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: e  reason: collision with root package name */
            public final /* synthetic */ Bitmap f6296e;

            /* renamed from: f  reason: collision with root package name */
            public final /* synthetic */ RunnableC0326a f6297f;

            public RunnableC0327a(RunnableC0326a runnableC0326a, Bitmap bitmap) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {runnableC0326a, bitmap};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i2 = newInitContext.flag;
                    if ((i2 & 1) != 0) {
                        int i3 = i2 & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.f6297f = runnableC0326a;
                this.f6296e = bitmap;
            }

            @Override // java.lang.Runnable
            public void run() {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                    RunnableC0326a runnableC0326a = this.f6297f;
                    runnableC0326a.f6295h.o(this.f6296e, runnableC0326a.f6292e, runnableC0326a.f6293f, runnableC0326a.f6294g);
                }
            }
        }

        public RunnableC0326a(a aVar, UnitedSchemeEntity unitedSchemeEntity, CallbackHandler callbackHandler, e eVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {aVar, unitedSchemeEntity, callbackHandler, eVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f6295h = aVar;
            this.f6292e = unitedSchemeEntity;
            this.f6293f = callbackHandler;
            this.f6294g = eVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                Bitmap y = n0.y();
                if (y == null) {
                    this.f6295h.n(this.f6292e, this.f6293f, "can't get screenshot");
                } else {
                    q.k(new RunnableC0327a(this, y), "savescreenshot");
                }
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public a(c.a.r0.a.f2.e eVar) {
        super(eVar, "/swanAPI/getScreenshot");
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {eVar};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                Object[] objArr2 = newInitContext.callArgs;
                super((UnitedSchemeBaseDispatcher) objArr2[0], (String) objArr2[1]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
    }

    @Override // c.a.r0.a.f2.f.z
    public boolean d(Context context, UnitedSchemeEntity unitedSchemeEntity, CallbackHandler callbackHandler, e eVar) {
        InterceptResult invokeLLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLLL = interceptable.invokeLLLL(1048576, this, context, unitedSchemeEntity, callbackHandler, eVar)) == null) {
            if (eVar == null) {
                d.c("Screenshot", "illegal swanApp");
                unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(201, "illegal swanApp");
                return false;
            }
            String optString = w.d(unitedSchemeEntity.getParam("params")).optString("name");
            this.f6291c = optString;
            if (TextUtils.isEmpty(optString)) {
                d.c("Screenshot", "invalid params");
                unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(202);
                return false;
            }
            m(unitedSchemeEntity, callbackHandler, eVar);
            return true;
        }
        return invokeLLLL.booleanValue;
    }

    public final JSONObject l(boolean z, String str, String str2) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, new Object[]{Boolean.valueOf(z), str, str2})) == null) {
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.put("name", this.f6291c);
                if (!TextUtils.isEmpty(str2)) {
                    jSONObject.put("message", str2);
                }
                if (z) {
                    jSONObject.put("path", str);
                }
            } catch (JSONException e2) {
                e2.printStackTrace();
            }
            return jSONObject;
        }
        return (JSONObject) invokeCommon.objValue;
    }

    public final void m(UnitedSchemeEntity unitedSchemeEntity, CallbackHandler callbackHandler, @NonNull e eVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(Constants.METHOD_SEND_USER_MSG, this, unitedSchemeEntity, callbackHandler, eVar) == null) {
            q0.e0(new RunnableC0326a(this, unitedSchemeEntity, callbackHandler, eVar));
        }
    }

    public final void n(UnitedSchemeEntity unitedSchemeEntity, CallbackHandler callbackHandler, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(1048579, this, unitedSchemeEntity, callbackHandler, str) == null) {
            d.c("Screenshot", str);
            UnitedSchemeUtility.callCallback(callbackHandler, unitedSchemeEntity, UnitedSchemeUtility.wrapCallbackParams(l(false, null, str), 0));
        }
    }

    /* JADX DEBUG: Failed to insert an additional move for type inference into block B:25:0x00ba */
    /* JADX DEBUG: Failed to insert an additional move for type inference into block B:42:0x00dd */
    /* JADX DEBUG: Failed to insert an additional move for type inference into block B:43:0x0077 */
    /* JADX DEBUG: Failed to insert an additional move for type inference into block B:48:0x0077 */
    public final void o(@NonNull Bitmap bitmap, UnitedSchemeEntity unitedSchemeEntity, CallbackHandler callbackHandler, @NonNull e eVar) {
        String x;
        FileOutputStream fileOutputStream;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLLLL(1048580, this, bitmap, unitedSchemeEntity, callbackHandler, eVar) == null) || (x = b.x(eVar.f5660f)) == null) {
            return;
        }
        String str = x + File.separator + StatisticConstants.SCREENSHOT;
        File file = new File(str);
        if (!file.exists() || !file.isDirectory()) {
            file.delete();
            if (!file.mkdir()) {
                n(unitedSchemeEntity, callbackHandler, "mkdir fail");
                return;
            }
        }
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyyMMddHHmmss", Locale.getDefault());
        String str2 = str + File.separator + simpleDateFormat.format(new Date()) + this.f6291c + EmotionResourceProvider.EMOTION_RES_NAME_SUFFIX;
        FileOutputStream fileOutputStream2 = null;
        try {
            try {
                try {
                    fileOutputStream = new FileOutputStream(str2);
                } catch (IOException e2) {
                    e2.printStackTrace();
                    n(unitedSchemeEntity, callbackHandler, "save screenshot fail");
                }
            } catch (FileNotFoundException e3) {
                e = e3;
            }
        } catch (Throwable th) {
            th = th;
        }
        try {
            bitmap.compress(Bitmap.CompressFormat.PNG, 100, fileOutputStream);
            String str3 = "save screenshot to " + str2;
            d.i("Screenshot", str3);
            UnitedSchemeUtility.callCallback(callbackHandler, unitedSchemeEntity, UnitedSchemeUtility.wrapCallbackParams(l(true, b.J(str2, eVar.f5660f), "success"), 0));
            fileOutputStream.close();
            fileOutputStream2 = str3;
        } catch (FileNotFoundException e4) {
            e = e4;
            fileOutputStream2 = fileOutputStream;
            e.printStackTrace();
            n(unitedSchemeEntity, callbackHandler, "save screenshot fail");
            if (fileOutputStream2 != null) {
                fileOutputStream2.close();
                fileOutputStream2 = fileOutputStream2;
            }
        } catch (Throwable th2) {
            th = th2;
            fileOutputStream2 = fileOutputStream;
            if (fileOutputStream2 != null) {
                try {
                    fileOutputStream2.close();
                } catch (IOException e5) {
                    e5.printStackTrace();
                    n(unitedSchemeEntity, callbackHandler, "save screenshot fail");
                }
            }
            throw th;
        }
    }
}
