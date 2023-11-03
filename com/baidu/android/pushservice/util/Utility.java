package com.baidu.android.pushservice.util;

import android.annotation.SuppressLint;
import android.app.ActivityManager;
import android.app.AlarmManager;
import android.app.PendingIntent;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.pm.PermissionInfo;
import android.content.pm.ProviderInfo;
import android.content.pm.ResolveInfo;
import android.content.pm.ServiceInfo;
import android.graphics.Bitmap;
import android.graphics.BitmapShader;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffXfermode;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.Shader;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
import android.net.Uri;
import android.os.BatteryManager;
import android.os.Build;
import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.Process;
import android.os.SystemClock;
import android.os.SystemProperties;
import android.text.TextUtils;
import android.util.Base64;
import android.util.DisplayMetrics;
import android.util.Log;
import android.util.TypedValue;
import android.view.WindowManager;
import androidx.core.app.NotificationCompat;
import com.baidu.android.common.util.DeviceId;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.android.pushservice.PushManager;
import com.baidu.android.pushservice.PushSettings;
import com.baidu.android.pushservice.a0.i;
import com.baidu.android.pushservice.a0.m;
import com.baidu.android.pushservice.e;
import com.baidu.android.pushservice.f;
import com.baidu.android.pushservice.j;
import com.baidu.android.pushservice.jni.BaiduAppSSOJni;
import com.baidu.android.pushservice.jni.PushSocket;
import com.baidu.android.pushservice.message.LocalPushMsg;
import com.baidu.android.pushservice.message.PublicMsg;
import com.baidu.android.pushservice.pull.ClientEventInfo;
import com.baidu.android.util.devices.RomUtils;
import com.baidu.sapi2.SapiOptions;
import com.baidu.searchbox.download.apkcheck.ApkCheckUBCManagerKt;
import com.baidu.searchbox.performance.speed.task.LaunchTaskConstants;
import com.baidu.searchbox.wordscommand.util.CommandUBCHelper;
import com.baidu.tbadk.core.atomData.ForbidActivityConfig;
import com.baidu.tbadk.core.util.RomTypeUtil;
import com.facebook.cache.disk.DefaultDiskStorage;
import com.google.protobuf.ByteString;
import com.heytap.msp.push.HeytapPushManager;
import com.heytap.msp.push.callback.ICallBackResultService;
import com.huawei.hms.framework.network.grs.local.model.CountryCodeBean;
import com.kuaishou.weapon.p0.h;
import com.meizu.cloud.pushsdk.constants.PushConstants;
import com.vivo.push.IPushActionListener;
import com.vivo.push.PushClient;
import com.xiaomi.mipush.sdk.MiPushClient;
import java.io.BufferedReader;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.zip.GZIPInputStream;
import org.json.JSONObject;
@SuppressLint({"WorldReadableFiles"})
/* loaded from: classes.dex */
public final class Utility {
    public static int a = -1;
    public static final String[] b = {h.a, "android.permission.ACCESS_NETWORK_STATE"};

    /* loaded from: classes.dex */
    public static class a implements ICallBackResultService {
        public final /* synthetic */ Context a;

        /* renamed from: com.baidu.android.pushservice.util.Utility$a$a  reason: collision with other inner class name */
        /* loaded from: classes.dex */
        public class C0038a extends com.baidu.android.pushservice.z.c {
            public final /* synthetic */ int c;
            public final /* synthetic */ String d;

            public C0038a(int i, String str) {
                this.c = i;
                this.d = str;
            }

            @Override // com.baidu.android.pushservice.z.c
            public void a() {
                if (this.c != 0 || TextUtils.isEmpty(this.d)) {
                    e.z(a.this.a);
                } else {
                    e.a(a.this.a, this.d);
                }
            }
        }

        public a(Context context) {
            this.a = context;
        }

        @Override // com.heytap.msp.push.callback.ICallBackResultService
        public void onError(int i, String str) {
        }

        @Override // com.heytap.msp.push.callback.ICallBackResultService
        public void onGetNotificationStatus(int i, int i2) {
        }

        @Override // com.heytap.msp.push.callback.ICallBackResultService
        public void onGetPushStatus(int i, int i2) {
        }

        @Override // com.heytap.msp.push.callback.ICallBackResultService
        public void onRegister(int i, String str) {
            com.baidu.android.pushservice.z.e.a().a(new C0038a(i, str));
        }

        @Override // com.heytap.msp.push.callback.ICallBackResultService
        public void onSetPushTime(int i, String str) {
        }

        @Override // com.heytap.msp.push.callback.ICallBackResultService
        public void onUnRegister(int i) {
        }
    }

    /* loaded from: classes.dex */
    public static class b implements IPushActionListener {
        public final /* synthetic */ Context a;
        public final /* synthetic */ boolean b;

        public b(Context context, boolean z) {
            this.a = context;
            this.b = z;
        }

        @Override // com.vivo.push.IPushActionListener
        public void onStateChanged(int i) {
            if (i == 101) {
                e.a(this.a, 0);
                if (this.b) {
                    return;
                }
                com.baidu.android.pushservice.a.a(this.a, true);
                i.b(this.a, "vi_push_proxy_mode", 0);
                PushManager.enableVivoProxy(this.a, false);
                Utility.a(this.a, true, true);
                return;
            }
            if (i == 0 || i == 1) {
                i.b(this.a, "vi_push_proxy_mode", 1);
                if (!this.b && !com.baidu.android.pushservice.l.d.q(this.a)) {
                    com.baidu.android.pushservice.a.a(this.a, false);
                }
                String regId = PushClient.getInstance(this.a).getRegId();
                if (!TextUtils.isEmpty(regId)) {
                    e.a(this.a, regId);
                    return;
                }
            }
            e.z(this.a);
        }
    }

    /* loaded from: classes.dex */
    public static class c extends com.baidu.android.pushservice.z.c {
        public final /* synthetic */ boolean c;
        public final /* synthetic */ Context d;
        public final /* synthetic */ ClientEventInfo e;

        public c(boolean z, Context context, ClientEventInfo clientEventInfo) {
            this.c = z;
            this.d = context;
            this.e = clientEventInfo;
        }

        @Override // com.baidu.android.pushservice.z.c
        public void a() {
            if (!this.c || com.baidu.android.pushservice.y.c.b(this.d, this.e)) {
                Utility.v(this.d);
            }
        }
    }

    /* loaded from: classes.dex */
    public static class d implements com.baidu.android.pushservice.n.b {
        public final /* synthetic */ Context a;

        public d(Context context) {
            this.a = context;
        }

        @Override // com.baidu.android.pushservice.n.b
        public List<LocalPushMsg> a(List<LocalPushMsg> list) {
            ArrayList arrayList = new ArrayList();
            if (list != null && !list.isEmpty()) {
                LocalPushMsg localPushMsg = list.get(0);
                Intent intent = new Intent();
                intent.putExtra("app_id", localPushMsg.a());
                intent.putExtra("msg_id", localPushMsg.f());
                intent.putExtra("message", localPushMsg.e().getBytes());
                intent.putExtra("message_string", localPushMsg.e());
                intent.putExtra(ForbidActivityConfig.CHAT_MSG_ID, localPushMsg.f());
                intent.putExtra("baidu_message_type", localPushMsg.g());
                intent.putExtra("baidu_message_body", localPushMsg.e().getBytes());
                intent.putExtra("baidu_message_secur_info", localPushMsg.i());
                intent.putExtra(Constants.EXTRA_NOTIFY_ID, localPushMsg.h());
                intent.putExtra("connect_source", 4);
                intent.putExtra("from_local_msg", true);
                Context context = this.a;
                Utility.c(context, intent, "com.baidu.android.pushservice.action.MESSAGE", context.getPackageName());
                arrayList.add(localPushMsg);
            }
            return arrayList;
        }
    }

    public static String A(Context context) {
        PackageInfo h = h(context, context.getPackageName());
        return h != null ? h.versionName : "";
    }

    public static boolean B(Context context) {
        boolean z;
        try {
            List<ActivityManager.RunningAppProcessInfo> runningAppProcesses = ((ActivityManager) context.getSystemService("activity")).getRunningAppProcesses();
            if (runningAppProcesses == null || runningAppProcesses.size() <= 0) {
                return true;
            }
            loop0: while (true) {
                z = true;
                for (ActivityManager.RunningAppProcessInfo runningAppProcessInfo : runningAppProcesses) {
                    try {
                        if (runningAppProcessInfo.processName.equals(context.getPackageName())) {
                            String str = runningAppProcessInfo.processName;
                            if (runningAppProcessInfo.importance != 400 && (runningAppProcessInfo.importance == 100 || runningAppProcessInfo.importance == 200)) {
                                z = false;
                            }
                        }
                    } catch (Exception unused) {
                    }
                }
                break loop0;
            }
            return z;
        } catch (Exception unused2) {
            return true;
        }
    }

    public static boolean C(Context context) {
        String a2 = com.baidu.android.pushservice.a.a(context);
        if (SapiOptions.KEY_CACHE_ENABLED.equals(a2)) {
            return false;
        }
        if ("disabled".equals(a2)) {
            return true;
        }
        return a(context, context.getPackageName(), "DisableService");
    }

    public static boolean D(Context context) {
        PackageInfo h;
        try {
            if (Build.VERSION.SDK_INT < 24 || (h = h(context, context.getPackageName())) == null) {
                return false;
            }
            return h.applicationInfo.targetSdkVersion >= 24;
        } catch (Exception unused) {
            return false;
        }
    }

    public static boolean E(Context context) {
        PackageInfo h;
        try {
            if (Build.VERSION.SDK_INT < 26 || (h = h(context, context.getPackageName())) == null) {
                return false;
            }
            return h.applicationInfo.targetSdkVersion >= 26;
        } catch (Exception unused) {
            return false;
        }
    }

    public static boolean F(Context context) {
        PackageInfo h;
        try {
            if (Build.VERSION.SDK_INT < 31 || (h = h(context, context.getPackageName())) == null) {
                return false;
            }
            return h.applicationInfo.targetSdkVersion >= 31;
        } catch (Exception unused) {
            return false;
        }
    }

    public static boolean G(Context context) {
        try {
            return a(context, true).contains("HONOR");
        } catch (Exception unused) {
            return false;
        }
    }

    public static boolean H(Context context) {
        try {
            String a2 = a(context, true);
            if (!a2.contains("HUAWEI") && !b()) {
                if (!a2.contains("HONOR")) {
                    return false;
                }
            }
            return true;
        } catch (Exception unused) {
            return false;
        }
    }

    public static boolean I(Context context) {
        int myPid = Process.myPid();
        List<ActivityManager.RunningAppProcessInfo> runningAppProcesses = ((ActivityManager) context.getSystemService("activity")).getRunningAppProcesses();
        if (runningAppProcesses == null || runningAppProcesses.size() <= 0) {
            return false;
        }
        for (ActivityManager.RunningAppProcessInfo runningAppProcessInfo : runningAppProcesses) {
            if (runningAppProcessInfo.pid == myPid) {
                return context.getPackageName().equals(runningAppProcessInfo.processName);
            }
        }
        return false;
    }

    public static boolean J(Context context) {
        try {
            return a(context, true).contains("MEIZU");
        } catch (Exception unused) {
            return false;
        }
    }

    public static boolean K(Context context) {
        try {
            String a2 = a(context, true);
            if (TextUtils.isEmpty(a2)) {
                return false;
            }
            return a2.contains("NEXUS");
        } catch (Exception unused) {
            return false;
        }
    }

    public static boolean L(Context context) {
        try {
            return a(context, true).contains(RomUtils.ROM_NUBIA);
        } catch (Exception unused) {
            return false;
        }
    }

    public static boolean M(Context context) {
        try {
            return a(context, true).contains(RomTypeUtil.ROM_ONEPLUS);
        } catch (Exception unused) {
            return false;
        }
    }

    public static boolean N(Context context) {
        try {
            return a(context, true).contains("OPPO");
        } catch (Exception unused) {
            return false;
        }
    }

    public static boolean O(Context context) {
        return H(context) || N(context) || S(context) || T(context) || J(context) || M(context) || P(context);
    }

    public static boolean P(Context context) {
        try {
            return a(context, true).contains("REALME");
        } catch (Exception unused) {
            return false;
        }
    }

    public static boolean Q(Context context) {
        try {
            return a(context, true).contains("SAMSUNG");
        } catch (Exception unused) {
            return false;
        }
    }

    public static boolean R(Context context) {
        return S(context) || H(context) || N(context) || M(context) || P(context);
    }

    public static boolean S(Context context) {
        try {
            return a(context, true).contains("VIVO");
        } catch (Exception unused) {
            return false;
        }
    }

    public static boolean T(Context context) {
        try {
            return a(context, true).contains(RomUtils.ROM_XIAOMI);
        } catch (Exception unused) {
            return false;
        }
    }

    public static boolean U(Context context) {
        return L(context) || M(context);
    }

    public static void V(Context context) {
        Intent b2 = m.b(context);
        b2.putExtra("method", "pushservice_quit");
        b2.setPackage(context.getPackageName());
        String b3 = b(context, context.getPackageName(), "com.baidu.android.pushservice.action.METHOD");
        if (!TextUtils.isEmpty(b3)) {
            b2.setClassName(context.getPackageName(), b3);
        }
        context.sendBroadcast(b2);
    }

    public static void W(Context context) {
        if (context == null) {
            return;
        }
        Context applicationContext = context.getApplicationContext();
        Intent intent = new Intent("com.huawei.android.push.intent.REGISTER");
        intent.putExtra("pkg_name", applicationContext.getPackageName());
        intent.putExtra("is_hms", true);
        intent.setFlags(32);
        applicationContext.sendBroadcast(intent);
    }

    public static void X(Context context) {
        a(context, 300000L);
    }

    public static void Y(Context context) {
        Intent intent = new Intent("com.baidu.android.pushservice.action.METHOD");
        intent.putExtra("method", "com.baidu.android.pushservice.action.SEND_APPSTAT");
        com.baidu.android.pushservice.h.a(context.getApplicationContext()).c(intent);
    }

    public static int a(int i) {
        return Build.VERSION.SDK_INT >= 23 ? i | 67108864 : i;
    }

    public static int a(Context context, float f) {
        return (int) TypedValue.applyDimension(1, f, context.getResources().getDisplayMetrics());
    }

    public static int a(Context context, Intent intent, String str, String str2) {
        intent.setFlags(32);
        if (!TextUtils.isEmpty(str)) {
            intent.setAction(str);
        }
        if (!TextUtils.isEmpty(str2)) {
            intent.setPackage(str2);
        }
        return new com.baidu.android.pushservice.a0.c(context, intent, str2).d().a();
    }

    public static Bitmap a(int i, int i2, String str) {
        Bitmap createBitmap = Bitmap.createBitmap(i, i2, Bitmap.Config.ARGB_8888);
        createBitmap.eraseColor(Color.parseColor(str));
        return createBitmap;
    }

    public static Bitmap a(Bitmap bitmap) {
        int width = bitmap.getWidth();
        int height = bitmap.getHeight();
        if (width >= height) {
            width = height;
        }
        return Bitmap.createBitmap(bitmap, (bitmap.getWidth() - width) / 2, (bitmap.getHeight() - width) / 2, width, width);
    }

    public static Bitmap a(Bitmap bitmap, float f, float f2) {
        int width = bitmap.getWidth();
        int height = bitmap.getHeight();
        Matrix matrix = new Matrix();
        matrix.postScale(f / width, f2 / height);
        return Bitmap.createBitmap(bitmap, 0, 0, width, height, matrix, true);
    }

    public static Bitmap a(Bitmap bitmap, int i, int i2) {
        int width = bitmap.getWidth();
        int height = bitmap.getHeight();
        Bitmap createBitmap = Bitmap.createBitmap(width, height, Bitmap.Config.ARGB_8888);
        Canvas canvas = new Canvas(createBitmap);
        Paint paint = new Paint();
        Rect rect = new Rect(0, 0, width, height);
        RectF rectF = new RectF(rect);
        paint.setAntiAlias(true);
        float f = i;
        canvas.drawRoundRect(rectF, f, f, paint);
        paint.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.SRC_IN));
        canvas.drawBitmap(bitmap, (Rect) null, rect, paint);
        if (i2 != 1) {
            if (i2 == 2) {
                int i3 = width - i;
                return Bitmap.createBitmap(createBitmap, i3, 0, i3, height);
            } else if (i2 != 3) {
                if (i2 != 4) {
                    return createBitmap;
                }
                int i4 = height - i;
                return Bitmap.createBitmap(createBitmap, 0, i4, width, i4);
            } else {
                return Bitmap.createBitmap(createBitmap, 0, 0, width, height - i);
            }
        }
        return Bitmap.createBitmap(createBitmap, 0, 0, width - i, height);
    }

    public static Bitmap a(Bitmap bitmap, boolean z, float f) {
        return a(bitmap, z, f, true, true, true, true);
    }

    public static Bitmap a(Bitmap bitmap, boolean z, float f, boolean z2, boolean z3, boolean z4, boolean z5) {
        if (bitmap == null) {
            return null;
        }
        if (z) {
            bitmap = a(bitmap);
        }
        Shader.TileMode tileMode = Shader.TileMode.CLAMP;
        BitmapShader bitmapShader = new BitmapShader(bitmap, tileMode, tileMode);
        Bitmap createBitmap = Bitmap.createBitmap(bitmap.getWidth(), bitmap.getHeight(), Bitmap.Config.ARGB_8888);
        Canvas canvas = new Canvas(createBitmap);
        Paint paint = new Paint();
        paint.setAntiAlias(true);
        paint.setShader(bitmapShader);
        canvas.drawRoundRect(new RectF(0.0f, 0.0f, bitmap.getWidth(), bitmap.getHeight()), f, f, paint);
        if (!z2) {
            canvas.drawRect(0.0f, 0.0f, f, f, paint);
        }
        if (!z3) {
            canvas.drawRect(canvas.getWidth() - f, 0.0f, canvas.getWidth(), f, paint);
        }
        if (!z5) {
            canvas.drawRect(0.0f, canvas.getHeight() - f, f, canvas.getHeight(), paint);
        }
        if (!z4) {
            canvas.drawRect(canvas.getWidth() - f, canvas.getHeight() - f, canvas.getWidth(), canvas.getHeight(), paint);
        }
        return createBitmap;
    }

    public static Bitmap a(Drawable drawable, int i, int i2) {
        if (i <= 0 || i2 <= 0) {
            return null;
        }
        drawable.setBounds(0, 0, i, i2);
        Bitmap createBitmap = Bitmap.createBitmap(i, i2, drawable.getOpacity() != -1 ? Bitmap.Config.ARGB_8888 : Bitmap.Config.RGB_565);
        drawable.draw(new Canvas(createBitmap));
        return createBitmap;
    }

    public static GradientDrawable a(int i, int i2, int i3, String str, String str2) {
        int parseColor = !TextUtils.isEmpty(str) ? Color.parseColor(str) : -1;
        int parseColor2 = Color.parseColor(str2);
        GradientDrawable gradientDrawable = new GradientDrawable();
        gradientDrawable.setColor(parseColor2);
        if (-1 == i3) {
            i3 = 0;
        }
        gradientDrawable.setShape(i3);
        if (i2 > 0) {
            gradientDrawable.setCornerRadius(i2);
        }
        if (i > 0 && -1 != parseColor) {
            gradientDrawable.setStroke(i, parseColor);
        }
        return gradientDrawable;
    }

    public static ByteString a(Context context, int i, String str) {
        String str2;
        JSONObject jSONObject = new JSONObject();
        try {
            if (i == -1) {
                jSONObject.put("iid", str);
            } else {
                jSONObject.put("cuid", DeviceId.getCUID(context));
            }
            str2 = Base64.encodeToString(BaiduAppSSOJni.encryptAES(jSONObject.toString(), 1), 2);
        } catch (Exception unused) {
            str2 = "";
        }
        return ByteString.copyFromUtf8(str2);
    }

    public static <T> T a(byte[] bArr, Parcelable.Creator<T> creator) {
        if (bArr == null) {
            return null;
        }
        Parcel obtain = Parcel.obtain();
        obtain.unmarshall(bArr, 0, bArr.length);
        obtain.setDataPosition(0);
        T createFromParcel = creator.createFromParcel(obtain);
        obtain.recycle();
        return createFromParcel;
    }

    public static String a() {
        try {
            Class<?> cls = Class.forName(CountryCodeBean.ANDRIOD_SYSTEMPROP);
            return (String) cls.getDeclaredMethod(CommandUBCHelper.COMMAND_UBC_SOURCE_RECEIVE, String.class).invoke(cls, "ro.build.version.incremental");
        } catch (Exception unused) {
            return "";
        }
    }

    public static String a(Context context, int i) {
        return i == -1 ? i.c(context, "cid") : j.a(context).a();
    }

    public static String a(Context context, InputStream inputStream) {
        if (inputStream == null) {
            return null;
        }
        InputStreamReader inputStreamReader = new InputStreamReader(inputStream);
        BufferedReader bufferedReader = new BufferedReader(inputStreamReader);
        StringBuilder sb = new StringBuilder();
        while (true) {
            try {
                String readLine = bufferedReader.readLine();
                if (readLine == null) {
                    break;
                }
                sb.append(readLine);
            } catch (IOException unused) {
                com.baidu.android.pushservice.q.c.a(context, inputStream, inputStreamReader, bufferedReader);
            } catch (Throwable th) {
                com.baidu.android.pushservice.q.c.a(context, inputStream, inputStreamReader, bufferedReader);
                throw th;
            }
        }
        com.baidu.android.pushservice.q.c.a(context, inputStream, inputStreamReader, bufferedReader);
        return sb.toString();
    }

    public static String a(Context context, boolean z) {
        try {
            String c2 = i.c(context, "bd_push_device_manufacturer");
            try {
                if (TextUtils.isEmpty(c2)) {
                    c2 = Build.MANUFACTURER;
                    i.b(context, "bd_push_device_manufacturer", c2);
                }
                if (z) {
                    c2 = c2.toUpperCase();
                }
                return "CMDC,LIANTONG,TIANYI,TDTECH".contains(c2.toUpperCase()) ? b() ? "HUAWEI" : c2 : c2;
            } catch (Exception unused) {
                return c2;
            }
        } catch (Exception unused2) {
            return "";
        }
    }

    public static String a(byte[] bArr, String str) {
        String str2 = null;
        if (bArr != null && bArr.length != 0) {
            ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
            ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream(bArr);
            try {
                GZIPInputStream gZIPInputStream = new GZIPInputStream(byteArrayInputStream);
                byte[] bArr2 = new byte[256];
                while (true) {
                    int read = gZIPInputStream.read(bArr2);
                    if (read < 0) {
                        break;
                    }
                    byteArrayOutputStream.write(bArr2, 0, read);
                }
                str2 = byteArrayOutputStream.toString(str);
            } catch (IOException unused) {
            } catch (Throwable th) {
                try {
                    byteArrayInputStream.close();
                    byteArrayOutputStream.close();
                } catch (IOException unused2) {
                }
                throw th;
            }
            try {
                byteArrayInputStream.close();
                byteArrayOutputStream.close();
            } catch (IOException unused3) {
            }
        }
        return str2;
    }

    public static void a(Context context, long j) {
        Context applicationContext = context.getApplicationContext();
        Intent b2 = m.b(applicationContext);
        String packageName = applicationContext.getPackageName();
        String b3 = b(applicationContext, packageName, b2.getAction());
        if (!TextUtils.isEmpty(packageName) && !TextUtils.isEmpty(b3)) {
            b2.setClassName(packageName, b3);
        }
        a(applicationContext, b2, j);
    }

    public static void a(Context context, Intent intent, long j) {
        PendingIntent broadcast = PendingIntent.getBroadcast(context, 0, intent, a((int) LaunchTaskConstants.OTHER_PROCESS));
        AlarmManager alarmManager = (AlarmManager) context.getSystemService(NotificationCompat.CATEGORY_ALARM);
        alarmManager.cancel(broadcast);
        alarmManager.set(3, SystemClock.elapsedRealtime() + j, broadcast);
    }

    public static void a(Context context, Intent intent, String str) {
        String action;
        if (context == null || intent == null || str == null || (action = intent.getAction()) == null || !action.startsWith("com.baidu.android.pushservice.action")) {
            return;
        }
        String b2 = b(context, str, action);
        if (context.getPackageName().equals(str) && !TextUtils.isEmpty(b2)) {
            a(context, str, b2, intent);
            return;
        }
        context.sendBroadcast(intent);
        if (action.equals("com.baidu.android.pushservice.action.notification.SHOW")) {
            String str2 = intent.getStringExtra(ForbidActivityConfig.CHAT_MSG_ID) + " sendBroadcast to recevier=" + b2;
        }
    }

    public static void a(Context context, ClientEventInfo clientEventInfo, boolean z) {
        if (clientEventInfo.getSource() != 4) {
            return;
        }
        com.baidu.android.pushservice.z.e.a().a(new c(z, context, clientEventInfo));
    }

    public static void a(Context context, String str, int i) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        try {
            PackageManager packageManager = context.getPackageManager();
            PackageInfo packageInfo = packageManager.getPackageInfo(context.getPackageName(), 520);
            if (packageInfo.providers != null) {
                for (ProviderInfo providerInfo : packageInfo.providers) {
                    if (str.equals(providerInfo.name)) {
                        ComponentName componentName = new ComponentName(context, str);
                        if (packageManager.getComponentEnabledSetting(componentName) != i) {
                            packageManager.setComponentEnabledSetting(componentName, i, 1);
                            return;
                        }
                        return;
                    }
                }
            }
        } catch (Throwable unused) {
        }
    }

    public static void a(Context context, String str, Intent intent) {
        String action = intent == null ? "" : intent.getAction();
        if (f.a(context).i()) {
            int a2 = i.a(context, "com.baidu.android.pushservice.PushManager.LOGIN_TYPE", 0);
            String c2 = i.c(context, "com.baidu.android.pushservice.PushManager.LONGIN_VALUE");
            if (TextUtils.isEmpty(c2)) {
                return;
            }
            PushManager.startWorkWithSource(context, a2, c2, new ClientEventInfo(4, str, action));
        }
    }

    public static void a(Context context, String str, String str2, Intent intent) {
        try {
            Class<?> cls = Class.forName(str2);
            Object newInstance = cls.getConstructor(new Class[0]).newInstance(new Object[0]);
            Method method = cls.getMethod("onReceive", Context.class, Intent.class);
            intent.setClassName(str, str2);
            method.invoke(newInstance, context.getApplicationContext(), intent);
            String action = intent.getAction();
            if (TextUtils.isEmpty(action) || !action.equals("com.baidu.android.pushservice.action.notification.SHOW")) {
                return;
            }
            String str3 = intent.getStringExtra(ForbidActivityConfig.CHAT_MSG_ID) + " reflectrecevier=" + str2;
        } catch (Exception unused) {
        }
    }

    public static void a(Context context, boolean z, boolean z2) {
        com.baidu.android.pushservice.u.a.a("Utility", context.getPackageName() + ": updateServiceInfo isForce = " + z + ",isSend = " + z2, context.getApplicationContext());
        if (z) {
            i.b(context, "com.baidu.android.pushservice.SDK_INT_VERSION", (int) com.baidu.android.pushservice.a.a());
        }
        if (z2) {
            m.a(context);
        }
    }

    public static void a(Intent intent, Context context) {
        a(context, context.getPackageName(), b(context, context.getPackageName(), "com.baidu.android.pushservice.action.MESSAGE"), intent);
    }

    public static boolean a(int i, int i2, int i3, int i4) {
        int i5 = Calendar.getInstance(Locale.CHINA).get(11);
        int i6 = Calendar.getInstance(Locale.CHINA).get(12);
        if (i < i3) {
            if (i >= i5 || i5 >= i3) {
                if (i5 != i || i6 < i2) {
                    return i5 == i3 && i6 <= i4;
                }
                return true;
            }
            return true;
        } else if (i <= i3) {
            return i == i5 && i6 >= i2 && i4 >= i6;
        } else if ((i5 <= i || i5 >= 24) && i5 >= i3) {
            if (i5 != i || i6 < i2) {
                return i5 == i3 && i6 <= i4;
            }
            return true;
        } else {
            return true;
        }
    }

    public static boolean a(Context context, PackageManager packageManager, String[] strArr) {
        if (T(context) && PushSettings.m(context)) {
            try {
                String str = context.getPackageName() + ".permission.MIPUSH_RECEIVE";
                if (!a(str, strArr)) {
                    com.baidu.android.pushservice.u.a.b("Utility", "the permission [ " + str + " ] for xiaomi proxy need is not exist, please check!", context);
                    return true;
                }
                PermissionInfo[] permissionInfoArr = packageManager.getPackageInfo(context.getPackageName(), 4096).permissions;
                if (permissionInfoArr != null && permissionInfoArr.length > 0) {
                    boolean z = false;
                    for (PermissionInfo permissionInfo : permissionInfoArr) {
                        if (permissionInfo.name.equals(str)) {
                            if (permissionInfo.protectionLevel == 2) {
                                z = true;
                            } else {
                                Log.e("BDPushSDK-Utility", "xiaomi proxy permission is not signature,  please check!");
                            }
                        }
                    }
                    if (!z) {
                        return true;
                    }
                }
            } catch (Exception unused) {
            }
        }
        return false;
    }

    public static boolean a(Context context, PublicMsg publicMsg) {
        if (publicMsg != null) {
            String a2 = com.baidu.android.pushservice.a0.f.a((publicMsg.mAppId + publicMsg.mMsgId + publicMsg.mUrl + publicMsg.mDescription + publicMsg.mTitle + publicMsg.mOpenType).getBytes(), false);
            if (TextUtils.isEmpty(a2)) {
                return false;
            }
            String c2 = com.baidu.android.pushservice.m.d.c(context, context.getPackageName(), publicMsg.mMsgId);
            return !TextUtils.isEmpty(c2) && c2.equals(a2);
        }
        return false;
    }

    public static boolean a(Context context, String str) {
        boolean z;
        boolean z2;
        try {
        } catch (Exception unused) {
            z = false;
        }
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        z = com.baidu.android.pushservice.m.b.b(context, str);
        try {
            z2 = l(context, str);
        } catch (Exception unused2) {
            z2 = false;
            return z ? false : false;
        }
        if (z && z2) {
            return true;
        }
    }

    public static boolean a(Context context, String str, String str2) {
        ApplicationInfo applicationInfo;
        Bundle bundle;
        PackageManager packageManager;
        try {
            packageManager = context.getPackageManager();
        } catch (Exception unused) {
            applicationInfo = null;
        }
        if (packageManager == null) {
            return false;
        }
        applicationInfo = packageManager.getApplicationInfo(str, 128);
        if (applicationInfo == null || (bundle = applicationInfo.metaData) == null || !bundle.containsKey(str2)) {
            return false;
        }
        return applicationInfo.metaData.getBoolean(str2);
    }

    public static boolean a(Context context, String str, String str2, String str3, String str4, String str5) {
        String a2 = PushSettings.a(context);
        if (!TextUtils.isEmpty(a2)) {
            str2 = a2;
        }
        if (str == null) {
            str = "";
        }
        String str6 = str2 + str + str3 + str4 + str5;
        if (TextUtils.isEmpty(str6)) {
            return false;
        }
        String a3 = com.baidu.android.pushservice.a0.f.a(str6.getBytes(), false);
        if (TextUtils.isEmpty(a3)) {
            return false;
        }
        String b2 = com.baidu.android.pushservice.m.d.b(context, context.getPackageName(), a3);
        return !TextUtils.isEmpty(b2) && b2.equals(a3);
    }

    public static boolean a(Context context, String str, String str2, boolean z) {
        PackageManager packageManager;
        Intent intent = new Intent(str);
        intent.setPackage(context.getPackageName());
        try {
            packageManager = context.getPackageManager();
        } catch (Exception e) {
            com.baidu.android.pushservice.u.a.b("Utility", "error  " + e.getMessage(), context);
        }
        if (packageManager == null) {
            return false;
        }
        if (z) {
            List<ResolveInfo> queryBroadcastReceivers = packageManager.queryBroadcastReceivers(intent, 576);
            if (queryBroadcastReceivers.size() < 1) {
                Log.e("BDPushSDK-Utility", str2 + " is not exist or did not declared " + str);
                return false;
            }
            for (ResolveInfo resolveInfo : queryBroadcastReceivers) {
                if (str2.equals(resolveInfo.activityInfo.name)) {
                    return true;
                }
            }
        } else {
            List<ResolveInfo> queryIntentServices = packageManager.queryIntentServices(intent, 576);
            if (queryIntentServices.size() < 1) {
                Log.e("BDPushSDK-Utility", str2 + " is not exist or did not declared " + str);
                return false;
            }
            for (ResolveInfo resolveInfo2 : queryIntentServices) {
                if (str2.equals(resolveInfo2.serviceInfo.name)) {
                    return true;
                }
            }
        }
        return false;
    }

    public static boolean a(Context context, byte[] bArr, String str, byte[] bArr2) {
        if (bArr == null || str == null || bArr2 == null) {
            return false;
        }
        String str2 = new String(bArr);
        return e.a(context, str2, str + new String(bArr2));
    }

    public static boolean a(String str) {
        if (TextUtils.isEmpty(str) || str.contains(" ")) {
            Log.e("BDPushSDK-Utility", "api_key is  incorrect, please check ! ");
            return false;
        }
        return true;
    }

    public static boolean a(String str, String str2) {
        return Pattern.compile(str2).matcher(str).find();
    }

    public static boolean a(String str, String[] strArr) {
        for (String str2 : strArr) {
            if (str.equals(str2)) {
                return true;
            }
        }
        return false;
    }

    public static byte[] a(Parcelable parcelable) {
        Parcel obtain = Parcel.obtain();
        parcelable.writeToParcel(obtain, 0);
        byte[] marshall = obtain.marshall();
        obtain.recycle();
        return marshall;
    }

    public static byte[] a(byte[] bArr, byte[] bArr2) {
        byte[] bArr3 = new byte[bArr.length + bArr2.length];
        System.arraycopy(bArr, 0, bArr3, 0, bArr.length);
        System.arraycopy(bArr2, 0, bArr3, bArr.length, bArr2.length);
        return bArr3;
    }

    public static int b(Context context, int i, String str) {
        JSONObject jSONObject = new JSONObject();
        try {
            if (i == -1) {
                jSONObject.put("iid", str);
            } else {
                jSONObject.put("cuid", DeviceId.getCUID(context));
            }
            return jSONObject.toString().length();
        } catch (Exception unused) {
            return 0;
        }
    }

    public static String b(Context context, String str, String str2) {
        List<ResolveInfo> list;
        PackageManager packageManager;
        if (TextUtils.isEmpty(str) || TextUtils.isEmpty(str2)) {
            return null;
        }
        Intent intent = new Intent(str2);
        intent.setPackage(str);
        try {
            packageManager = context.getPackageManager();
        } catch (Exception unused) {
            list = null;
        }
        if (packageManager == null) {
            return null;
        }
        list = packageManager.queryBroadcastReceivers(intent, 576);
        if (list == null || list.size() <= 0) {
            return null;
        }
        return list.get(0).activityInfo.name;
    }

    public static String b(String str) {
        try {
            if (!TextUtils.isEmpty(str)) {
                byte[] decode = Base64.decode(str.getBytes(), 2);
                return new String(BaiduAppSSOJni.decryptAES(decode, decode.length, 0), "utf-8");
            }
        } catch (Exception | UnsatisfiedLinkError unused) {
        }
        return "";
    }

    public static void b(Context context, Intent intent, String str, String str2) {
        try {
            Uri data = intent.getData();
            if (data != null) {
                String e = e(context, data.toString());
                Intent intent2 = new Intent();
                String stringExtra = intent.getStringExtra("hwtitle");
                String stringExtra2 = intent.getStringExtra("hwcontent");
                if (!TextUtils.isEmpty(stringExtra) && !TextUtils.isEmpty(stringExtra2)) {
                    intent2.putExtra("notification_title", stringExtra);
                    intent2.putExtra("notification_content", stringExtra2);
                }
                intent2.putExtra("extra_extra_custom_content", e);
                intent2.putExtra("proxy_mode", 5);
                intent2.putExtra("proxy_check_info", str);
                intent2.putExtra("proxy_sign_info", str2);
                com.baidu.android.pushservice.n.c.a().a(context, false, 1, e);
                c(context, intent2, "com.baidu.android.pushservice.action.notification.CLICK", context.getPackageName());
            }
        } catch (Exception unused) {
        }
    }

    public static void b(Context context, String str, int i) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        try {
            PackageManager packageManager = context.getPackageManager();
            PackageInfo packageInfo = packageManager.getPackageInfo(context.getPackageName(), 516);
            if (packageInfo.services != null) {
                for (ServiceInfo serviceInfo : packageInfo.services) {
                    if (str.equals(serviceInfo.name)) {
                        ComponentName componentName = new ComponentName(context, str);
                        if (packageManager.getComponentEnabledSetting(componentName) != i) {
                            packageManager.setComponentEnabledSetting(componentName, i, 1);
                            return;
                        }
                        return;
                    }
                }
            }
        } catch (Throwable unused) {
        }
    }

    public static void b(Context context, boolean z) {
        if (context == null) {
            return;
        }
        try {
            PushClient.getInstance(context).initialize();
            PushClient.getInstance(context).turnOnPush(new b(context, z));
        } catch (Throwable unused) {
        }
    }

    public static boolean b() {
        if (Build.VERSION.SDK_INT >= 19) {
            return (TextUtils.isEmpty(d("ro.build.version.emui")) && TextUtils.isEmpty(d("hw_sc.build.platform.version"))) ? false : true;
        }
        return false;
    }

    public static synchronized boolean b(Context context) {
        boolean z;
        synchronized (Utility.class) {
            if (a == -1) {
                try {
                    a = context.getSharedPreferences("com.baidu.pushservice.BIND_CACHE", 0).getBoolean("bind_status", false) ? 1 : 0;
                } catch (Exception unused) {
                }
            }
            z = a == 1;
        }
        return z;
    }

    public static boolean b(Context context, PublicMsg publicMsg) {
        return com.baidu.android.pushservice.m.d.a(context, new com.baidu.android.pushservice.m.e(publicMsg.mMsgId, com.baidu.android.pushservice.a0.f.a((publicMsg.mAppId + publicMsg.mMsgId + publicMsg.mUrl + publicMsg.mDescription + publicMsg.mTitle + publicMsg.mOpenType).getBytes(), false), publicMsg.mAppId));
    }

    public static boolean b(Context context, String str) {
        List<ResolveInfo> list;
        PackageManager packageManager;
        Intent intent = new Intent("com.baidu.android.pushservice.action.PUSH_SERVICE");
        intent.setPackage(str);
        try {
            packageManager = context.getPackageManager();
        } catch (Exception unused) {
            list = null;
        }
        if (packageManager == null) {
            return false;
        }
        list = packageManager.queryIntentServices(intent, 576);
        return list != null && list.size() > 0;
    }

    public static String c(Context context, String str) {
        String str2;
        if (PushSocket.a()) {
            String i = i(context);
            if (!TextUtils.equals("com.baidu.android.pushservice.CHECK_SDK_RESULT_OK", i)) {
                Log.e("BDPushSDK-Utility", i);
                return i;
            } else if (a(str)) {
                l(context);
                return S(context) ? "com.baidu.android.pushservice.CHECK_SDK_RESULT_OK" : (c(context) && g(context)) ? "com.baidu.android.pushservice.CHECK_SDK_RESULT_OK" : "check CommandService Enable failed";
            } else {
                str2 = "check Apikey failed";
            }
        } else {
            str2 = "check socket library failed";
        }
        Log.e("BDPushSDK-Utility", str2);
        return str2;
    }

    public static String c(String str) {
        try {
            return new String(Base64.encode(BaiduAppSSOJni.encryptAES(str, 0), 2), "utf-8");
        } catch (Exception | UnsatisfiedLinkError unused) {
            return "";
        }
    }

    public static void c() {
        HeytapPushManager.requestNotificationPermission();
    }

    public static void c(Context context, Intent intent, String str, String str2) {
        intent.setFlags(32);
        try {
            if (!TextUtils.isEmpty(str)) {
                intent.setAction(str);
            }
            if (!TextUtils.isEmpty(str2)) {
                intent.setPackage(str2);
            }
            a(context, intent, str2);
        } catch (Exception unused) {
        }
    }

    public static void c(Context context, String str, int i) {
        if (context == null) {
            return;
        }
        Intent b2 = m.b(context);
        b2.putExtra("method", "com.baidu.android.pushservice.action.SEND_ACK");
        b2.putExtra("bd.cross.request.RESULT_CODE", i);
        b2.putExtra(ForbidActivityConfig.CHAT_MSG_ID, str);
        b2.setPackage(context.getPackageName());
        String b3 = b(context, context.getPackageName(), "com.baidu.android.pushservice.action.METHOD");
        if (!TextUtils.isEmpty(b3)) {
            b2.setClassName(context.getPackageName(), b3);
        }
        context.sendBroadcast(b2);
    }

    public static void c(Context context, String str, String str2) {
        if (context == null) {
            return;
        }
        try {
            com.meizu.cloud.pushsdk.PushManager.register(context.getApplicationContext(), str, str2);
        } catch (Exception unused) {
        }
    }

    public static synchronized void c(Context context, boolean z) {
        synchronized (Utility.class) {
            try {
                a = z ? 1 : 0;
                SharedPreferences.Editor edit = context.getSharedPreferences("com.baidu.pushservice.BIND_CACHE", 0).edit();
                edit.putBoolean("bind_status", z);
                edit.commit();
            } catch (Exception unused) {
            }
        }
    }

    public static boolean c(Context context) {
        try {
            return !TextUtils.isEmpty(context.getPackageManager().getServiceInfo(new ComponentName(context, "com.baidu.android.pushservice.CommandService"), 128).name);
        } catch (Exception unused) {
            return false;
        }
    }

    public static String d(Context context, String str) {
        if (context == null) {
            return null;
        }
        try {
            String i = com.baidu.android.pushservice.m.d.i(context);
            if (TextUtils.isEmpty(i)) {
                return null;
            }
            ArrayList<com.baidu.android.pushservice.k.e> e = com.baidu.android.pushservice.k.b.a(context).e(b(i));
            if (e != null) {
                Iterator<com.baidu.android.pushservice.k.e> it = e.iterator();
                while (it.hasNext()) {
                    com.baidu.android.pushservice.k.e next = it.next();
                    if (next.b().equals(str)) {
                        return next.a();
                    }
                }
                return null;
            }
            return null;
        } catch (Exception unused) {
            return null;
        }
    }

    public static String d(String str) {
        try {
            return (String) Class.forName(CountryCodeBean.ANDRIOD_SYSTEMPROP).getDeclaredMethod(CommandUBCHelper.COMMAND_UBC_SOURCE_RECEIVE, String.class).invoke(null, str);
        } catch (Exception unused) {
            return "";
        }
    }

    public static void d(Context context, String str, String str2) {
        if (context == null) {
            return;
        }
        try {
            HeytapPushManager.init(context, true);
            HeytapPushManager.register(context, str, str2, new a(context));
        } catch (Throwable unused) {
        }
    }

    public static boolean d(Context context) {
        boolean z = false;
        try {
            PackageInfo packageInfo = context.getPackageManager().getPackageInfo(context.getPackageName(), 4);
            if (packageInfo.services != null) {
                ServiceInfo[] serviceInfoArr = packageInfo.services;
                int length = serviceInfoArr.length;
                int i = 0;
                while (true) {
                    if (i >= length) {
                        break;
                    } else if (serviceInfoArr[i].name.equals("com.baidu.android.pushservice.job.PushJobService")) {
                        z = true;
                        break;
                    } else {
                        i++;
                    }
                }
                return !z;
            }
        } catch (Exception unused) {
        }
        return false;
    }

    /* JADX WARN: Code restructure failed: missing block: B:9:0x001c, code lost:
        if (r2 > 0) goto L10;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static String e(Context context, String str) {
        try {
            if (!TextUtils.isEmpty(str) && str.contains("baidupush://bdpush/hwnotify?bdpush_hwmsgbody=")) {
                int f = str.contains("bdpush_hwsigninfo") ? f(context, str) : str.length();
                return str.substring(45, f);
            }
        } catch (Exception unused) {
        }
        return null;
    }

    public static String e(String str) {
        String str2;
        try {
            if (Build.VERSION.SDK_INT >= 28) {
                str2 = SystemProperties.get(str);
            } else {
                Class<?> cls = Class.forName(CountryCodeBean.ANDRIOD_SYSTEMPROP);
                str2 = (String) cls.getDeclaredMethod(CommandUBCHelper.COMMAND_UBC_SOURCE_RECEIVE, String.class).invoke(cls, str);
            }
            return str2;
        } catch (Exception unused) {
            return "";
        }
    }

    public static void e(Context context, String str, String str2) {
        if (context == null) {
            return;
        }
        try {
            MiPushClient.registerPush(context.getApplicationContext(), str, str2);
        } catch (Throwable unused) {
        }
    }

    public static boolean e(Context context) {
        try {
            if (J(context) && PushSettings.j(context)) {
                PackageInfo packageInfo = context.getPackageManager().getPackageInfo(context.getPackageName(), 4);
                if (packageInfo.services != null) {
                    boolean z = false;
                    for (ServiceInfo serviceInfo : packageInfo.services) {
                        if (serviceInfo.name.equals("com.meizu.cloud.pushsdk.NotificationService")) {
                            z = true;
                        }
                    }
                    return !z;
                }
            }
        } catch (Exception unused) {
        }
        return false;
    }

    public static int f(Context context, String str) {
        int indexOf;
        int i = 0;
        do {
            try {
                indexOf = str.indexOf("#Intent;");
                if (indexOf != -1) {
                    int i2 = indexOf + 8;
                    i += i2;
                    str = str.substring(i2);
                    continue;
                }
            } catch (Exception unused) {
                return i;
            }
        } while (indexOf != -1);
        return i > 0 ? i - 8 : i;
    }

    public static void f(Context context, String str, String str2) {
        if (context == null) {
            return;
        }
        int a2 = i.a(context, "com.baidu.android.pushservice.PushManager.LOGIN_TYPE", 0);
        String c2 = i.c(context, "com.baidu.android.pushservice.PushManager.LONGIN_VALUE");
        if (TextUtils.isEmpty(c2)) {
            return;
        }
        PushManager.startWorkWithSource(context, a2, c2, new ClientEventInfo(4, str, str2));
    }

    public static boolean f(Context context) {
        ServiceInfo[] serviceInfoArr;
        try {
            if ((N(context) || M(context) || P(context)) && PushSettings.k(context)) {
                PackageInfo packageInfo = context.getPackageManager().getPackageInfo(context.getPackageName(), 4);
                if (packageInfo.services != null) {
                    boolean z = false;
                    boolean z2 = false;
                    for (ServiceInfo serviceInfo : packageInfo.services) {
                        if (serviceInfo.name.equals("com.heytap.msp.push.service.DataMessageCallbackService")) {
                            z = true;
                        }
                        if (serviceInfo.name.equals("com.heytap.msp.push.service.CompatibleDataMessageCallbackService")) {
                            z2 = true;
                        }
                    }
                    return (z && z2) ? false : true;
                }
                return false;
            }
            return false;
        } catch (Exception unused) {
            return false;
        }
    }

    public static boolean f(String str) {
        return (str == null || str.isEmpty() || !str.matches("^(1\\d{2}|2[0-4]\\d|25[0-5]|[1-9]\\d|[1-9])\\.(1\\d{2}|2[0-4]\\d|25[0-5]|[1-9]\\d|\\d)\\.(1\\d{2}|2[0-4]\\d|25[0-5]|[1-9]\\d|\\d)\\.(1\\d{2}|2[0-4]\\d|25[0-5]|[1-9]\\d|\\d)$")) ? false : true;
    }

    public static int g(Context context, String str) {
        if (context == null || TextUtils.isEmpty(str)) {
            return 0;
        }
        try {
            if (str.equals(context.getPackageName())) {
                return com.baidu.android.pushservice.a.a();
            }
            return -1;
        } catch (Exception unused) {
            return -1;
        }
    }

    public static boolean g(Context context) {
        ProviderInfo providerInfo;
        String str;
        String str2;
        try {
            PackageManager packageManager = context.getPackageManager();
            ComponentName componentName = new ComponentName(context, "com.baidu.android.pushservice.PushInfoProvider");
            new ProviderInfo();
            providerInfo = packageManager.getProviderInfo(componentName, 128);
            str = providerInfo.name;
            str2 = providerInfo.authority;
            com.baidu.android.pushservice.u.a.c("Utility", "provider name  = " + str + "  export  = " + providerInfo.exported + " provider authorities = " + str2, context.getApplicationContext());
        } catch (Exception unused) {
        }
        if (TextUtils.isEmpty(str)) {
            Log.e("BDPushSDK-Utility", "com.baidu.android.pushservice.PushInfoProvider did not declared, please check ! ");
            return false;
        }
        if (!TextUtils.isEmpty(str2) && str2.endsWith("bdpush")) {
            TextUtils.isEmpty(providerInfo.writePermission);
            return true;
        }
        Log.e("BDPushSDK-Utility", "com.baidu.android.pushservice.PushInfoProvider bdpush authority is required, please check !");
        return false;
    }

    public static String getIIdBindChannelId(Context context) {
        return i.c(context, "cid");
    }

    public static PackageInfo h(Context context, String str) {
        try {
            PackageManager packageManager = context.getPackageManager();
            if (packageManager != null) {
                return packageManager.getPackageInfo(str, 0);
            }
            return null;
        } catch (Exception unused) {
            return null;
        }
    }

    public static String h(Context context) {
        String str;
        if (n(context)) {
            str = "xiaomi service is not found or wrong  declared, please check!";
        } else if (f(context)) {
            str = "oppo service is not found or wrong  declared, please check!";
        } else if (e(context)) {
            str = "meizu service is not found or wrong  declared, please check!";
        } else if (!m(context)) {
            return a(context, "com.baidu.android.pushservice.action.PUSH_SERVICE", "com.baidu.android.pushservice.PushService", false) ? "com.baidu.android.pushservice.CHECK_SDK_RESULT_OK" : "com.baidu.android.pushservice.PushService is not exist or did not declared com.baidu.android.pushservice.action.PUSH_SERVICE";
        } else {
            str = "vivo service is not found or wrong  declared, please check!";
        }
        Log.e("BDPushSDK-Utility", str);
        return str;
    }

    public static String i(Context context) {
        String j = j(context);
        if (TextUtils.equals("com.baidu.android.pushservice.CHECK_SDK_RESULT_OK", j)) {
            String k = k(context);
            if (TextUtils.equals("com.baidu.android.pushservice.CHECK_SDK_RESULT_OK", k)) {
                String h = h(context);
                return !TextUtils.equals("com.baidu.android.pushservice.CHECK_SDK_RESULT_OK", h) ? h : "com.baidu.android.pushservice.CHECK_SDK_RESULT_OK";
            }
            return k;
        }
        return j;
    }

    /* JADX WARN: Code restructure failed: missing block: B:80:0x013f, code lost:
        if (r4.find() != false) goto L29;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static String i(Context context, String str) {
        String group;
        Matcher matcher;
        String str2 = "";
        if (O(context)) {
            String str3 = str.contains(RomUtils.ROM_XIAOMI) ? "ro.miui.ui.version.code" : str.contains("HUAWEI") ? "ro.build.version.emui" : str.contains("MEIZU") ? "ro.build.flyme.version" : (str.contains("OPPO") || str.contains("REALME")) ? "ro.build.version.opporom" : str.contains("VIVO") ? "ro.vivo.os.version" : str.contains(RomTypeUtil.ROM_ONEPLUS) ? "ro.rom.version" : str.contains("HONOR") ? "ro.build.version.magic" : "";
            try {
                if (Build.VERSION.SDK_INT >= 28) {
                    str2 = SystemProperties.get(str3);
                } else {
                    Class<?> cls = Class.forName(CountryCodeBean.ANDRIOD_SYSTEMPROP);
                    str2 = (String) cls.getDeclaredMethod(CommandUBCHelper.COMMAND_UBC_SOURCE_RECEIVE, String.class).invoke(cls, str3);
                }
                if (str.contains("HUAWEI") && !TextUtils.isEmpty(str2)) {
                    return (a(str2, "\\d+\\.\\d+$") || Build.VERSION.SDK_INT < 21) ? str2.substring(str2.indexOf("_") + 1, str2.length()) : com.baidu.down.utils.Constants.SDK_VER;
                }
                if (str.contains("HONOR")) {
                    matcher = Pattern.compile("\\d+(\\.\\d+)?").matcher(str2);
                    if (matcher.find()) {
                    }
                } else if (str.contains("MEIZU")) {
                    if (TextUtils.isEmpty(str2)) {
                        str2 = Build.DISPLAY;
                    }
                    matcher = Pattern.compile("\\d+(\\.\\d+)?").matcher(str2);
                    if (matcher.find()) {
                    }
                } else {
                    if (!str.contains("OPPO") && !str.contains("REALME")) {
                        if (str.contains("VIVO") && !TextUtils.isEmpty(str2)) {
                            matcher = Pattern.compile("^\\d+(\\.\\d+)?").matcher(str2);
                            if (matcher.find()) {
                            }
                        } else if (str.contains(RomTypeUtil.ROM_ONEPLUS)) {
                            if (TextUtils.isEmpty(str2)) {
                                str2 = e("ro.build.version.oplusrom");
                            }
                            if (!TextUtils.isEmpty(str2)) {
                                matcher = Pattern.compile("\\d+(\\.\\d+)?").matcher(str2);
                            }
                        }
                    }
                    if (TextUtils.isEmpty(str2)) {
                        str2 = e("ro.build.version.oplusrom");
                    }
                    if (!TextUtils.isEmpty(str2)) {
                        Matcher matcher2 = Pattern.compile("^V(\\d+\\.?\\d*)").matcher(str2);
                        if (matcher2.find()) {
                            group = matcher2.group(1);
                            return group;
                        }
                    }
                }
                group = matcher.group();
                return group;
            } catch (Throwable unused) {
                if (Build.VERSION.SDK_INT >= 21 && str.contains("HUAWEI")) {
                    return com.baidu.down.utils.Constants.SDK_VER;
                }
                if (str.contains("HUAWEI")) {
                    return "1.0";
                }
                if (str.contains(RomUtils.ROM_XIAOMI)) {
                    return "4.0";
                }
                if (str.contains("MEIZU")) {
                    return "6.0";
                }
                if (str.contains("OPPO") || str.contains("REALME")) {
                    return "3.0";
                }
                if (str.contains("VIVO")) {
                    return "3.2";
                }
                if (str.contains("HONOR")) {
                    return "5.0";
                }
            }
        }
        return str2;
    }

    public static int j(Context context, String str) {
        try {
            PackageInfo h = h(context, str);
            if (h != null) {
                return h.applicationInfo.targetSdkVersion;
            }
        } catch (Exception unused) {
        }
        return 0;
    }

    public static String j(Context context) {
        String[] strArr;
        try {
            PackageManager packageManager = context.getPackageManager();
            if (packageManager == null) {
                return "pm is null";
            }
            String[] strArr2 = packageManager.getPackageInfo(context.getPackageName(), 4096).requestedPermissions;
            if (strArr2 == null) {
                Log.e("BDPushSDK-Utility", "Permissions Push-SDK need are not exist !");
                return "Permissions Push-SDK need are not exist !";
            } else if (a(context, packageManager, strArr2)) {
                Log.e("BDPushSDK-Utility", "permission Push-SDK for xiaomi proxy need is not exist !");
                return "permission Push-SDK for xiaomi proxy need is not exist !";
            } else {
                for (String str : b) {
                    if (!a(str, strArr2)) {
                        String str2 = str + " permission Push-SDK need is not exist !";
                        Log.e("BDPushSDK-Utility", str2);
                        return str2;
                    }
                }
                return "com.baidu.android.pushservice.CHECK_SDK_RESULT_OK";
            }
        } catch (Exception e) {
            return "checkSDKPermissions exception " + e.getMessage();
        }
    }

    public static int k(Context context, String str) {
        PackageInfo h = h(context, str);
        if (h != null) {
            return h.versionCode;
        }
        return 0;
    }

    public static String k(Context context) {
        String str;
        if (!a(context, "com.baidu.android.pushservice.action.notification.SHOW", "com.baidu.android.pushservice.PushServiceReceiver", true)) {
            str = "com.baidu.android.pushservice.PushServiceReceiver is not exist or did not declared com.baidu.android.pushservice.action.notification.SHOW";
        } else if (a(context, "com.baidu.android.pushservice.action.METHOD", "com.baidu.android.pushservice.RegistrationReceiver", true)) {
            return "com.baidu.android.pushservice.CHECK_SDK_RESULT_OK";
        } else {
            str = "com.baidu.android.pushservice.RegistrationReceiver is not exist or did not declared com.baidu.android.pushservice.action.METHOD";
        }
        Log.e("BDPushSDK-Utility", str);
        return str;
    }

    public static boolean l(Context context) {
        try {
            Intent intent = new Intent("com.baidu.android.pushservice.action.notification.CLICK");
            intent.setPackage(context.getPackageName());
            PackageManager packageManager = context.getPackageManager();
            if (packageManager == null) {
                return false;
            }
            List<ResolveInfo> queryBroadcastReceivers = packageManager.queryBroadcastReceivers(intent, 576);
            if (queryBroadcastReceivers.size() < 1) {
                return false;
            }
            String str = queryBroadcastReceivers.get(0).activityInfo.name;
            boolean z = queryBroadcastReceivers.get(0).activityInfo.enabled;
            if (a(context, "com.baidu.android.pushservice.action.MESSAGE", str, true) && a(context, "com.baidu.android.pushservice.action.RECEIVE", str, true)) {
                if (H(context) && PushSettings.h(context)) {
                    if (!a(context, "com.huawei.android.push.intent.RECEIVE", str, true)) {
                        Log.e("BDPushSDK-Utility", str + " did not declared com.huawei.android.push.intent.RECEIVE");
                        return false;
                    } else if (PushSettings.i(context)) {
                        if (!a(context, "com.huawei.intent.action.PUSH", str, true)) {
                            Log.e("BDPushSDK-Utility", str + " did not declared com.huawei.intent.action.PUSH");
                            return false;
                        } else if (!a(context, "com.huawei.android.push.intent.REGISTRATION", str, true)) {
                            Log.e("BDPushSDK-Utility", str + " did not declared com.huawei.android.push.intent.REGISTRATION");
                            return false;
                        }
                    }
                } else if (T(context) && PushSettings.m(context)) {
                    if (!a(context, "com.xiaomi.mipush.RECEIVE_MESSAGE", "com.baidu.android.pushservice.PushPatchMessageReceiver", true) || !a(context, "com.xiaomi.mipush.MESSAGE_ARRIVED", "com.baidu.android.pushservice.PushPatchMessageReceiver", true) || !a(context, "com.xiaomi.mipush.ERROR", "com.baidu.android.pushservice.PushPatchMessageReceiver", true)) {
                        return false;
                    }
                } else if (J(context) && PushSettings.j(context)) {
                    if (!a(context, PushConstants.MZ_PUSH_ON_MESSAGE_ACTION, "com.baidu.android.pushservice.MzPushPatchMessageReceiver", true)) {
                        return false;
                    }
                    if (!a(context, PushConstants.MZ_PUSH_ON_REGISTER_ACTION, "com.baidu.android.pushservice.MzPushPatchMessageReceiver", true)) {
                        Log.e("BDPushSDK-Utility", "com.baidu.android.pushservice.MzPushPatchMessageReceiver did not declared " + PushConstants.MZ_PUSH_ON_REGISTER_ACTION);
                        return false;
                    } else if (!a(context, PushConstants.MZ_PUSH_ON_UNREGISTER_ACTION, "com.baidu.android.pushservice.MzPushPatchMessageReceiver", true)) {
                        Log.e("BDPushSDK-Utility", "com.baidu.android.pushservice.MzPushPatchMessageReceiver did not declared " + PushConstants.MZ_PUSH_ON_UNREGISTER_ACTION);
                        return false;
                    }
                } else if ((N(context) || M(context) || P(context)) && PushSettings.k(context)) {
                    if (!a(context, "com.heytap.mcs.action.RECEIVE_MCS_MESSAGE", "com.heytap.msp.push.service.DataMessageCallbackService", false)) {
                        Log.e("BDPushSDK-Utility", "com.heytap.msp.push.service.DataMessageCallbackService did not declared com.heytap.mcs.action.RECEIVE_MCS_MESSAGE");
                        return false;
                    } else if (!a(context, "com.heytap.msp.push.RECEIVE_MCS_MESSAGE", "com.heytap.msp.push.service.DataMessageCallbackService", false)) {
                        Log.e("BDPushSDK-Utility", "com.heytap.msp.push.service.DataMessageCallbackService did not declared com.heytap.msp.push.RECEIVE_MCS_MESSAGE");
                        return false;
                    } else if (!a(context, "com.coloros.mcs.action.RECEIVE_MCS_MESSAGE", "com.heytap.msp.push.service.CompatibleDataMessageCallbackService", false)) {
                        Log.e("BDPushSDK-Utility", "com.heytap.msp.push.service.CompatibleDataMessageCallbackService did not declared com.coloros.mcs.action.RECEIVE_MCS_MESSAGE");
                        return false;
                    }
                } else if (S(context) && PushSettings.l(context) && !a(context, "com.vivo.pushclient.action.RECEIVE", "com.baidu.android.pushservice.viproxy.ViPushMessageReceiver", true)) {
                    return false;
                }
                int componentEnabledSetting = packageManager.getComponentEnabledSetting(new ComponentName(context.getPackageName(), str));
                boolean z2 = componentEnabledSetting == 1 || (componentEnabledSetting == 0 && z);
                if (z2) {
                    return z2;
                }
                try {
                    Log.e("BDPushSDK-Utility", str + " is disable, please check!");
                    return z2;
                } catch (Exception unused) {
                    return z2;
                }
            }
            Log.e("BDPushSDK-Utility", str + " did not declared com.baidu.android.pushservice.action.MESSAGE or com.baidu.android.pushservice.action.RECEIVE");
            return false;
        } catch (Exception unused2) {
            return false;
        }
    }

    public static boolean l(Context context, String str) {
        String c2 = i.c(context, "com.baidu.android.pushservice.MESSAGE_IDS_RECEIVED");
        if (!TextUtils.isEmpty(c2)) {
            if (c2.contains(str)) {
                return true;
            }
            if (c2.length() > 1000) {
                c2 = c2.substring(500);
            }
            str = c2 + ":" + str;
        }
        i.b(context, "com.baidu.android.pushservice.MESSAGE_IDS_RECEIVED", str);
        return false;
    }

    public static boolean m(Context context) {
        try {
            if (S(context) && PushSettings.l(context)) {
                PackageInfo packageInfo = context.getPackageManager().getPackageInfo(context.getPackageName(), 4);
                if (packageInfo.services != null) {
                    boolean z = false;
                    for (ServiceInfo serviceInfo : packageInfo.services) {
                        if (serviceInfo.name.equals("com.vivo.push.sdk.service.CommandClientService")) {
                            z = true;
                        }
                    }
                    return !z;
                }
            }
        } catch (Exception unused) {
        }
        return false;
    }

    public static boolean m(Context context, String str) {
        if (context != null && !TextUtils.isEmpty(str)) {
            try {
                context.getPackageManager().getApplicationInfo(str, 8192);
                return true;
            } catch (Exception unused) {
            }
        }
        return false;
    }

    public static boolean n(Context context) {
        ServiceInfo[] serviceInfoArr;
        try {
            if (T(context) && PushSettings.m(context)) {
                PackageInfo packageInfo = context.getPackageManager().getPackageInfo(context.getPackageName(), 4);
                if (packageInfo.services != null) {
                    boolean z = false;
                    boolean z2 = false;
                    for (ServiceInfo serviceInfo : packageInfo.services) {
                        if (serviceInfo.name.equals("com.xiaomi.mipush.sdk.PushMessageHandler")) {
                            z2 = true;
                        }
                        if (serviceInfo.name.equals("com.xiaomi.mipush.sdk.MessageHandleService")) {
                            z = true;
                        }
                    }
                    return (z && z2) ? false : true;
                }
                return false;
            }
            return false;
        } catch (Exception unused) {
            return false;
        }
    }

    public static boolean n(Context context, String str) {
        ApplicationInfo applicationInfo;
        Bundle bundle;
        PackageManager packageManager;
        try {
            packageManager = context.getPackageManager();
        } catch (Exception unused) {
            applicationInfo = null;
        }
        if (packageManager == null) {
            return false;
        }
        applicationInfo = packageManager.getApplicationInfo(str, 128);
        if (applicationInfo == null || (bundle = applicationInfo.metaData) == null) {
            return false;
        }
        return bundle.getBoolean("IsBaiduApp");
    }

    public static Bitmap o(Context context) {
        try {
            Drawable drawable = context.getResources().getDrawable(context.getPackageManager().getPackageInfo(context.getPackageName(), 0).applicationInfo.icon);
            int intrinsicWidth = drawable.getIntrinsicWidth();
            int intrinsicHeight = drawable.getIntrinsicHeight();
            Bitmap createBitmap = Bitmap.createBitmap(intrinsicWidth, intrinsicHeight, drawable.getOpacity() != -1 ? Bitmap.Config.ARGB_8888 : Bitmap.Config.RGB_565);
            try {
                Canvas canvas = new Canvas(createBitmap);
                drawable.setBounds(0, 0, intrinsicWidth, intrinsicHeight);
                drawable.draw(canvas);
                return createBitmap;
            } catch (Exception unused) {
                return createBitmap;
            }
        } catch (Exception unused2) {
            return null;
        }
    }

    public static boolean o(Context context, String str) {
        int[] a2;
        if (context == null || TextUtils.isEmpty(str) || (a2 = com.baidu.android.pushservice.m.b.a(context, str)) == null || 4 != a2.length) {
            return false;
        }
        return a(a2[0], a2[1], a2[2], a2[3]);
    }

    public static int p(Context context, String str) {
        long parseLong;
        try {
            try {
                parseLong = Long.parseLong(str);
            } catch (Exception unused) {
                return 0;
            }
        } catch (Exception unused2) {
            if (str.length() > 0) {
                str = str.substring(1);
            }
            parseLong = Long.parseLong(str);
        }
        return (int) parseLong;
    }

    public static String p(Context context) {
        return context.getSharedPreferences("com.baidu.pushservice.BIND_CACHE", 0).getString("appid", "");
    }

    public static String q(Context context) {
        try {
            ApplicationInfo applicationInfo = context.getPackageManager().getApplicationInfo(context.getPackageName(), 128);
            return ((Object) applicationInfo.loadLabel(context.getPackageManager())) + "";
        } catch (Exception unused) {
            return "";
        }
    }

    public static String r(Context context) {
        try {
            return context.getPackageManager().getPackageInfo(context.getPackageName(), 0).versionName;
        } catch (PackageManager.NameNotFoundException unused) {
            return "";
        }
    }

    public static int s(Context context) {
        try {
            if (Build.VERSION.SDK_INT >= 23) {
                return ((BatteryManager) context.getSystemService("batterymanager")).getIntProperty(4);
            }
        } catch (Exception unused) {
        }
        return 0;
    }

    public static int[] t(Context context) {
        DisplayMetrics displayMetrics = new DisplayMetrics();
        WindowManager windowManager = (WindowManager) context.getSystemService(ApkCheckUBCManagerKt.VALUE_WINDOW);
        if (windowManager != null) {
            windowManager.getDefaultDisplay().getMetrics(displayMetrics);
        }
        return new int[]{displayMetrics.heightPixels, displayMetrics.widthPixels};
    }

    public static long u(Context context) {
        try {
            return context.getPackageManager().getPackageInfo(context.getPackageName(), 0).lastUpdateTime / 1000;
        } catch (Exception unused) {
            return 0L;
        }
    }

    public static void v(Context context) {
        com.baidu.android.pushservice.n.c.a().a(context, new d(context));
    }

    public static String w(Context context) {
        String deviceID = DeviceId.getDeviceID(context);
        if (D(context)) {
            return com.baidu.android.pushservice.a0.f.a(("com.baidu.pushservice.single_conn" + context.getPackageName() + "v3" + deviceID).getBytes(), false);
        }
        return com.baidu.android.pushservice.a0.f.a(("com.baidu.pushservice.single_conn" + context.getPackageName() + DefaultDiskStorage.DEFAULT_DISK_STORAGE_VERSION_PREFIX + deviceID).getBytes(), false);
    }

    public static int x(Context context) {
        String a2 = com.baidu.android.pushservice.m.d.a(context, "privacy");
        if (TextUtils.isEmpty(a2)) {
            return 0;
        }
        return Integer.parseInt(a2);
    }

    public static String y(Context context) {
        String str;
        String a2 = a(context, true);
        String str2 = "";
        String str3 = a2.contains(RomUtils.ROM_XIAOMI) ? "ro.build.version.incremental" : (a2.contains("HUAWEI") || a2.contains("HONOR")) ? "ro.build.version.emui" : a2.contains("MEIZU") ? "ro.build.flyme.version" : (a2.contains("OPPO") || a2.contains("REALME")) ? "ro.build.version.opporom" : a2.contains("VIVO") ? "ro.vivo.os.version" : a2.contains(RomTypeUtil.ROM_ONEPLUS) ? "ro.rom.version" : "";
        try {
            if (Build.VERSION.SDK_INT >= 28) {
                str = SystemProperties.get(str3);
            } else {
                Class<?> cls = Class.forName(CountryCodeBean.ANDRIOD_SYSTEMPROP);
                str = (String) cls.getDeclaredMethod(CommandUBCHelper.COMMAND_UBC_SOURCE_RECEIVE, String.class).invoke(cls, str3);
            }
            str2 = str;
        } catch (Throwable unused) {
            if (Build.VERSION.SDK_INT >= 21 && (a2.contains("HUAWEI") || a2.contains("HONOR"))) {
                str2 = "EmotionUI_notfound";
            } else if (a2.contains(RomUtils.ROM_XIAOMI)) {
                str2 = "MIUI_notfound";
            } else if (a2.contains("OPPO") || a2.contains("REALME")) {
                str2 = "ColorOS_notfound";
            } else if (a2.contains("VIVO")) {
                str2 = "FuntouchOS_notfound";
            } else if (a2.contains("MEIZU")) {
                str2 = "FlymeOS_notfound";
            }
        }
        return ((M(context) || P(context) || N(context)) && TextUtils.isEmpty(str2)) ? e("ro.build.version.oplusrom") : str2;
    }

    public static String z(Context context) {
        return i(context, a(context, true));
    }
}
