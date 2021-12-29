package c.g;

import android.os.Handler;
import android.os.HandlerThread;
import android.os.Looper;
import android.os.Message;
import androidx.annotation.NonNull;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.fun.ad.sdk.internal.api.utils.LogPrinter;
import com.qq.e.comm.constants.Constants;
import java.io.IOException;
import java.util.Calendar;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Random;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes9.dex */
public class w0 {
    public static /* synthetic */ Interceptable $ic;
    public static final m a;

    /* renamed from: b  reason: collision with root package name */
    public static final Handler f29356b;
    public transient /* synthetic */ FieldHolder $fh;

    /* loaded from: classes9.dex */
    public static class a extends Handler {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public a(Looper looper) {
            super(looper);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {looper};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    super((Looper) newInitContext.callArgs[0]);
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
        }

        /* JADX WARN: Removed duplicated region for block: B:34:0x00be  */
        /* JADX WARN: Removed duplicated region for block: B:42:0x00ea  */
        @Override // android.os.Handler
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public void handleMessage(@NonNull Message message) {
            boolean z;
            long c2;
            p0 a;
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, message) == null) {
                int i2 = message.what;
                int i3 = 101;
                if (i2 == 100) {
                    HashMap hashMap = new HashMap();
                    try {
                        JSONObject jSONObject = new JSONObject();
                        m0.d(jSONObject);
                        Iterator<String> keys = jSONObject.keys();
                        while (keys.hasNext()) {
                            String next = keys.next();
                            hashMap.put(next, jSONObject.get(next));
                        }
                    } catch (JSONException unused) {
                    }
                    try {
                        a = new h0("https://cd.xdplt.com/v2/pr", new n0(hashMap)).a();
                    } catch (IOException | JSONException e2) {
                        LogPrinter.d("cpm exception:" + e2, new Object[0]);
                        LogPrinter.e(e2);
                    }
                    if (a.a != 200) {
                        LogPrinter.d("cpm fail:", new Object[0]);
                    } else {
                        JSONObject jSONObject2 = new JSONObject(a.f29339b);
                        if (jSONObject2.getInt(Constants.KEYS.RET) == 200) {
                            c0.a.edit().putLong("key_cpm_update_date", Calendar.getInstance().getTimeInMillis()).putString("key_ad_cpmcfg", jSONObject2.getJSONObject("data").getJSONArray("cpm").toString()).apply();
                            z = true;
                            if (z) {
                                int i4 = message.arg1;
                                LogPrinter.d("ad cpm config pull times = %1s", Integer.valueOf(i4));
                                int i5 = i4 == 0 ? 10 : i4 <= 2 ? i4 * 5 * 60 : 3600;
                                Message obtainMessage = obtainMessage(100);
                                obtainMessage.arg1 = i4 + 1;
                                sendMessageDelayed(obtainMessage, i5 * 1000);
                                return;
                            }
                            w0.a.b();
                            c2 = w0.c();
                            i3 = 100;
                        }
                    }
                    z = false;
                    if (z) {
                    }
                } else if (i2 != 101) {
                    return;
                } else {
                    w0.a.a();
                    c2 = w0.b();
                }
                sendEmptyMessageDelayed(i3, c2);
            }
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-1579640670, "Lc/g/w0;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-1579640670, "Lc/g/w0;");
                return;
            }
        }
        a = new m();
        HandlerThread handlerThread = new HandlerThread("pull_pid_cpm");
        handlerThread.start();
        f29356b = new a(handlerThread.getLooper());
    }

    public static boolean a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65537, null)) == null) {
            Calendar calendar = Calendar.getInstance();
            int i2 = calendar.get(6);
            int i3 = calendar.get(1);
            calendar.setTimeInMillis(c0.a.getLong("key_cpm_update_date", 0L));
            return i3 == calendar.get(1) && i2 == calendar.get(6);
        }
        return invokeV.booleanValue;
    }

    public static long b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65538, null)) == null) {
            Calendar calendar = Calendar.getInstance();
            long timeInMillis = calendar.getTimeInMillis();
            calendar.add(6, 1);
            calendar.set(11, 0);
            calendar.set(12, 0);
            calendar.set(13, 0);
            long timeInMillis2 = calendar.getTimeInMillis() - timeInMillis;
            if (timeInMillis2 < 0) {
                return 0L;
            }
            return timeInMillis2;
        }
        return invokeV.longValue;
    }

    public static long c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65539, null)) == null) {
            Calendar calendar = Calendar.getInstance();
            Random random = new Random();
            long timeInMillis = calendar.getTimeInMillis();
            int nextInt = random.nextInt(15);
            calendar.set(11, 1);
            calendar.set(12, nextInt);
            if (a()) {
                calendar.add(6, 1);
            }
            long timeInMillis2 = calendar.getTimeInMillis() - timeInMillis;
            if (timeInMillis2 < 0) {
                return 0L;
            }
            return timeInMillis2;
        }
        return invokeV.longValue;
    }
}
