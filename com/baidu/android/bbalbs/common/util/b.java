package com.baidu.android.bbalbs.common.util;

import android.annotation.SuppressLint;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.content.pm.Signature;
import android.os.Build;
import android.os.Bundle;
import android.os.Environment;
import android.os.Process;
import android.os.SystemClock;
import android.provider.Settings;
import android.system.ErrnoException;
import android.system.Os;
import android.text.TextUtils;
import android.util.Log;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.bbalbs.common.security.Base64;
import com.baidu.android.common.util.DeviceId;
import com.baidu.android.imsdk.chatmessage.messages.NetDiskFileMsg;
import com.baidu.android.imsdk.chatmessage.request.IMAudioTransRequest;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.util.ApiReplaceUtil;
import com.baidu.tbadk.core.util.httpNet.HttpRequest;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.kuaishou.weapon.p0.h;
import java.io.BufferedReader;
import java.io.ByteArrayInputStream;
import java.io.CharArrayWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.security.PublicKey;
import java.security.cert.CertificateFactory;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Random;
import java.util.UUID;
import javax.crypto.Cipher;
import org.apache.commons.codec.binary4util.BaseNCodec;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes.dex */
public final class b {
    public static /* synthetic */ Interceptable $ic = null;
    public static final String a;
    public static C0020b e = null;
    public static boolean f = true;
    public transient /* synthetic */ FieldHolder $fh;
    public final Context b;
    public int c;
    public PublicKey d;

    /* loaded from: classes.dex */
    public static class a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public ApplicationInfo a;
        public int b;
        public boolean c;
        public boolean d;

        public a() {
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
            this.b = 0;
            this.c = false;
            this.d = false;
        }

        public /* synthetic */ a(com.baidu.android.bbalbs.common.util.c cVar) {
            this();
        }
    }

    /* renamed from: com.baidu.android.bbalbs.common.util.b$b  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public static class C0020b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public String a;
        public String b;
        public int c;
        public int d;

        public C0020b() {
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
            this.c = 2;
            this.d = 0;
        }

        public /* synthetic */ C0020b(com.baidu.android.bbalbs.common.util.c cVar) {
            this();
        }

        public static boolean a(int i) {
            InterceptResult invokeI;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeI = interceptable.invokeI(65539, null, i)) == null) ? i >= 14 : invokeI.booleanValue;
        }

        public static boolean a(String str) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeL = interceptable.invokeL(InputDeviceCompat.SOURCE_TRACKBALL, null, str)) == null) ? TextUtils.isEmpty(str) : invokeL.booleanValue;
        }

        public static C0020b b(String str) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(65541, null, str)) == null) {
                if (TextUtils.isEmpty(str)) {
                    return null;
                }
                try {
                    JSONObject jSONObject = new JSONObject(str);
                    Iterator<String> keys = jSONObject.keys();
                    String str2 = "0";
                    String str3 = "0";
                    while (keys.hasNext()) {
                        String next = keys.next();
                        if (!b.m("ZGV2aWNlaWQ=").equals(next) && !b.m("dmVy").equals(next)) {
                            str3 = jSONObject.optString(next, "0");
                        }
                    }
                    String string = jSONObject.getString(b.m("ZGV2aWNlaWQ="));
                    int i = jSONObject.getInt(b.m("dmVy"));
                    int length = TextUtils.isEmpty(str3) ? 0 : str3.length();
                    if (!TextUtils.isEmpty(string)) {
                        C0020b c0020b = new C0020b();
                        c0020b.a = string;
                        c0020b.c = i;
                        c0020b.d = length;
                        if (length < 14) {
                            if (!TextUtils.isEmpty(str3)) {
                                str2 = str3;
                            }
                            c0020b.b = str2;
                        }
                        return c0020b;
                    }
                } catch (JSONException e) {
                    b.b(e);
                }
                return null;
            }
            return (C0020b) invokeL.objValue;
        }

        public static C0020b b(String str, String str2) {
            InterceptResult invokeLL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLL = interceptable.invokeLL(65542, null, str, str2)) == null) {
                if (TextUtils.isEmpty(str)) {
                    return null;
                }
                C0020b c0020b = new C0020b();
                c0020b.a = str;
                int length = TextUtils.isEmpty(str2) ? 0 : str2.length();
                c0020b.d = length;
                if (length < 14) {
                    if (TextUtils.isEmpty(str2)) {
                        str2 = "0";
                    }
                    c0020b.b = str2;
                }
                return c0020b;
            }
            return (C0020b) invokeLL.objValue;
        }

        public boolean a() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? a(this.b) : invokeV.booleanValue;
        }

        public boolean b() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? a(this.d) : invokeV.booleanValue;
        }

        public String c() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
                try {
                    return new JSONObject().put(b.m("ZGV2aWNlaWQ="), this.a).put(b.m("aW1laQ=="), this.b).put(b.m("dmVy"), this.c).toString();
                } catch (JSONException e) {
                    b.b(e);
                    return null;
                }
            }
            return (String) invokeV.objValue;
        }

        public String d() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
                String str = this.b;
                if (TextUtils.isEmpty(str)) {
                    str = "0";
                }
                return this.a + "|" + str;
            }
            return (String) invokeV.objValue;
        }
    }

    /* loaded from: classes.dex */
    public static class c {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        public static boolean a(String str, int i) {
            InterceptResult invokeLI;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLI = interceptable.invokeLI(65536, null, str, i)) == null) {
                try {
                    Os.chmod(str, i);
                    return true;
                } catch (ErrnoException e) {
                    b.b(e);
                    return false;
                } catch (Exception e2) {
                    b.b(e2);
                    return false;
                }
            }
            return invokeLI.booleanValue;
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1701138855, "Lcom/baidu/android/bbalbs/common/util/b;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1701138855, "Lcom/baidu/android/bbalbs/common/util/b;");
                return;
            }
        }
        String str = new String(Base64.decode(new byte[]{77, 122, 65, 121, 77, 84, 73, 120, 77, 68, 73, BaseNCodec.PAD_DEFAULT}));
        String str2 = new String(Base64.decode(new byte[]{90, 71, 108, 106, 100, 87, 82, 112, 89, 87, 73, BaseNCodec.PAD_DEFAULT}));
        a = str + str2;
    }

    public b(Context context) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context};
            interceptable.invokeUnInit(65537, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.c = 0;
        this.b = context.getApplicationContext();
        a();
    }

    public static String a(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65539, null, context)) == null) ? b(context).d() : (String) invokeL.objValue;
    }

    public static String a(byte[] bArr) {
        InterceptResult invokeL;
        StringBuilder sb;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65542, null, bArr)) == null) {
            if (bArr != null) {
                String str = "";
                for (byte b : bArr) {
                    String hexString = Integer.toHexString(b & 255);
                    if (hexString.length() == 1) {
                        sb = new StringBuilder();
                        sb.append(str);
                        str = "0";
                    } else {
                        sb = new StringBuilder();
                    }
                    sb.append(str);
                    sb.append(hexString);
                    str = sb.toString();
                }
                return str.toLowerCase();
            }
            throw new IllegalArgumentException("Argument b ( byte array ) is null! ");
        }
        return (String) invokeL.objValue;
    }

    private List<a> a(Intent intent, boolean z) {
        InterceptResult invokeLZ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLZ = interceptable.invokeLZ(65543, this, intent, z)) == null) {
            ArrayList arrayList = new ArrayList();
            PackageManager packageManager = this.b.getPackageManager();
            List<ResolveInfo> queryBroadcastReceivers = packageManager.queryBroadcastReceivers(intent, 0);
            if (queryBroadcastReceivers != null) {
                for (ResolveInfo resolveInfo : queryBroadcastReceivers) {
                    ActivityInfo activityInfo = resolveInfo.activityInfo;
                    if (activityInfo != null && activityInfo.applicationInfo != null) {
                        try {
                            Bundle bundle = packageManager.getReceiverInfo(new ComponentName(resolveInfo.activityInfo.packageName, resolveInfo.activityInfo.name), 128).metaData;
                            if (bundle != null) {
                                String string = bundle.getString("galaxy_data");
                                if (!TextUtils.isEmpty(string)) {
                                    byte[] decode = Base64.decode(string.getBytes(IMAudioTransRequest.CHARSET));
                                    JSONObject jSONObject = new JSONObject(new String(decode));
                                    a aVar = new a(null);
                                    aVar.b = jSONObject.getInt("priority");
                                    aVar.a = resolveInfo.activityInfo.applicationInfo;
                                    if (this.b.getPackageName().equals(resolveInfo.activityInfo.applicationInfo.packageName)) {
                                        aVar.d = true;
                                    }
                                    if (z) {
                                        String string2 = bundle.getString("galaxy_sf");
                                        if (!TextUtils.isEmpty(string2)) {
                                            PackageInfo packageInfo = packageManager.getPackageInfo(resolveInfo.activityInfo.applicationInfo.packageName, 64);
                                            JSONArray jSONArray = jSONObject.getJSONArray("sigs");
                                            int length = jSONArray.length();
                                            String[] strArr = new String[length];
                                            for (int i = 0; i < length; i++) {
                                                strArr[i] = jSONArray.getString(i);
                                            }
                                            if (a(strArr, a(packageInfo.signatures))) {
                                                byte[] a2 = a(Base64.decode(string2.getBytes()), this.d);
                                                if (a2 != null && Arrays.equals(a2, com.baidu.android.bbalbs.common.security.c.a(decode))) {
                                                    aVar.c = true;
                                                }
                                            }
                                        }
                                    }
                                    arrayList.add(aVar);
                                }
                            }
                        } catch (Exception unused) {
                        }
                    }
                }
            }
            Collections.sort(arrayList, new com.baidu.android.bbalbs.common.util.c(this));
            return arrayList;
        }
        return (List) invokeLZ.objValue;
    }

    private void a() {
        ByteArrayInputStream byteArrayInputStream;
        Throwable th;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65544, this) == null) {
            ByteArrayInputStream byteArrayInputStream2 = null;
            try {
                try {
                    byteArrayInputStream = new ByteArrayInputStream(com.baidu.android.bbalbs.common.util.a.a());
                    try {
                        this.d = CertificateFactory.getInstance("X.509").generateCertificate(byteArrayInputStream).getPublicKey();
                        byteArrayInputStream.close();
                    } catch (Exception unused) {
                        byteArrayInputStream2 = byteArrayInputStream;
                        if (byteArrayInputStream2 != null) {
                            byteArrayInputStream2.close();
                        }
                    } catch (Throwable th2) {
                        th = th2;
                        if (byteArrayInputStream != null) {
                            try {
                                byteArrayInputStream.close();
                            } catch (Exception e2) {
                                b(e2);
                            }
                        }
                        throw th;
                    }
                } catch (Exception e3) {
                    b(e3);
                }
            } catch (Exception unused2) {
            } catch (Throwable th3) {
                byteArrayInputStream = null;
                th = th3;
            }
        }
    }

    public static void a(Context context, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLZ(65545, null, context, z) == null) {
            File file = new File(context.getApplicationContext().getFilesDir(), "libcuid.so");
            Context applicationContext = context.getApplicationContext();
            if (file.exists() && (e == null || f != z)) {
                b(applicationContext, z);
            }
            f = z;
        }
    }

    private synchronized void a(C0020b c0020b) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65546, this, c0020b) == null) {
            synchronized (this) {
                new Thread(c(c0020b)).start();
            }
        }
    }

    private boolean a(String[] strArr, String[] strArr2) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65552, this, strArr, strArr2)) == null) {
            if (strArr == null || strArr2 == null || strArr.length != strArr2.length) {
                return false;
            }
            HashSet hashSet = new HashSet();
            for (String str : strArr) {
                hashSet.add(str);
            }
            HashSet hashSet2 = new HashSet();
            for (String str2 : strArr2) {
                hashSet2.add(str2);
            }
            return hashSet.equals(hashSet2);
        }
        return invokeLL.booleanValue;
    }

    public static byte[] a(byte[] bArr, PublicKey publicKey) throws Exception {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65553, null, bArr, publicKey)) == null) {
            Cipher cipher = Cipher.getInstance("RSA/ECB/PKCS1Padding");
            cipher.init(2, publicKey);
            return cipher.doFinal(bArr);
        }
        return (byte[]) invokeLL.objValue;
    }

    private String[] a(Signature[] signatureArr) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65554, this, signatureArr)) == null) {
            int length = signatureArr.length;
            String[] strArr = new String[length];
            for (int i = 0; i < length; i++) {
                strArr[i] = a(com.baidu.android.bbalbs.common.security.c.a(signatureArr[i].toByteArray()));
            }
            return strArr;
        }
        return (String[]) invokeL.objValue;
    }

    private C0020b b() {
        InterceptResult invokeV;
        boolean z;
        String str;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65555, this)) == null) {
            List<a> a2 = a(new Intent("com.baidu.intent.action.GALAXY").setPackage(this.b.getPackageName()), true);
            boolean z2 = false;
            if (a2 == null || a2.size() == 0) {
                for (int i = 0; i < 3; i++) {
                    Log.w(DeviceId.a, "galaxy lib host missing meta-data,make sure you know the right way to integrate galaxy");
                }
                z = false;
            } else {
                z = a2.get(0).c;
                if (!z) {
                    for (int i2 = 0; i2 < 3; i2++) {
                        Log.w(DeviceId.a, "galaxy config err, In the release version of the signature should be matched");
                    }
                }
            }
            File file = new File(this.b.getFilesDir(), "libcuid.so");
            C0020b b = file.exists() ? C0020b.b(j(b(file))) : null;
            if (b == null) {
                this.c |= 16;
                List<a> a3 = a(new Intent("com.baidu.intent.action.GALAXY"), z);
                if (a3 != null) {
                    String str2 = NetDiskFileMsg.JSON_KEY_FILES;
                    File filesDir = this.b.getFilesDir();
                    if (!NetDiskFileMsg.JSON_KEY_FILES.equals(filesDir.getName())) {
                        Log.e(DeviceId.a, "fetal error:: app files dir name is unexpectedly :: " + filesDir.getAbsolutePath());
                        str2 = filesDir.getName();
                    }
                    for (a aVar : a3) {
                        if (!aVar.d) {
                            File file2 = new File(new File(aVar.a.dataDir, str2), "libcuid.so");
                            if (file2.exists() && (b = C0020b.b(j(b(file2)))) != null) {
                                break;
                            }
                        }
                    }
                }
            }
            if (b == null) {
                b = C0020b.b(j(f("com.baidu.deviceid.v2")));
            }
            boolean g = g(h.i);
            if (b == null && g) {
                this.c |= 2;
                b = e();
            }
            if (b == null) {
                this.c |= 8;
                b = d();
            }
            if (b == null && g) {
                this.c |= 1;
                str = l("");
                b = h(str);
                z2 = true;
            } else {
                str = null;
            }
            if (b == null) {
                this.c |= 4;
                if (!z2) {
                    str = l("");
                }
                b = new C0020b(null);
                String c2 = c(this.b);
                b.a = com.baidu.android.bbalbs.common.security.b.a((Build.VERSION.SDK_INT < 23 ? str + c2 + UUID.randomUUID().toString() : "com.baidu" + c2).getBytes(), true);
                b.b = str;
            }
            b(b);
            a(b);
            return b;
        }
        return (C0020b) invokeV.objValue;
    }

    public static C0020b b(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65556, null, context)) == null) {
            if (e == null) {
                synchronized (C0020b.class) {
                    if (e == null) {
                        SystemClock.uptimeMillis();
                        e = new b(context).b();
                        SystemClock.uptimeMillis();
                    }
                }
            }
            return e;
        }
        return (C0020b) invokeL.objValue;
    }

    /* JADX WARN: Removed duplicated region for block: B:46:0x0043 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static String b(File file) {
        InterceptResult invokeL;
        FileReader fileReader;
        Interceptable interceptable = $ic;
        if (interceptable != null && (invokeL = interceptable.invokeL(65558, null, file)) != null) {
            return (String) invokeL.objValue;
        }
        FileReader fileReader2 = null;
        try {
            fileReader = new FileReader(file);
            try {
                try {
                    char[] cArr = new char[8192];
                    CharArrayWriter charArrayWriter = new CharArrayWriter();
                    while (true) {
                        int read = fileReader.read(cArr);
                        if (read <= 0) {
                            break;
                        }
                        charArrayWriter.write(cArr, 0, read);
                    }
                    String charArrayWriter2 = charArrayWriter.toString();
                    try {
                        fileReader.close();
                    } catch (Exception e2) {
                        b(e2);
                    }
                    return charArrayWriter2;
                } catch (Exception e3) {
                    e = e3;
                    b(e);
                    if (fileReader != null) {
                        try {
                            fileReader.close();
                        } catch (Exception e4) {
                            b(e4);
                        }
                    }
                    return null;
                }
            } catch (Throwable th) {
                th = th;
                fileReader2 = fileReader;
                if (fileReader2 != null) {
                    try {
                        fileReader2.close();
                    } catch (Exception e5) {
                        b(e5);
                    }
                }
                throw th;
            }
        } catch (Exception e6) {
            e = e6;
            fileReader = null;
        } catch (Throwable th2) {
            th = th2;
            if (fileReader2 != null) {
            }
            throw th;
        }
    }

    public static void b(Throwable th) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65560, null, th) == null) {
        }
    }

    @SuppressLint({"NewApi"})
    public static boolean b(Context context, boolean z) {
        InterceptResult invokeLZ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLZ = interceptable.invokeLZ(65561, null, context, z)) == null) {
            File file = new File(context.getApplicationContext().getFilesDir(), "libcuid.so");
            if (file.exists()) {
                if (Build.VERSION.SDK_INT >= 21) {
                    return c.a(file.getAbsolutePath(), z ? 436 : 432);
                }
                try {
                    if (z) {
                        return file.setReadable(true, false);
                    }
                    return file.setReadable(false, false) && file.setReadable(true, true);
                } catch (Exception e2) {
                    b(e2);
                    return false;
                }
            }
            return false;
        }
        return invokeLZ.booleanValue;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean b(C0020b c0020b) {
        InterceptResult invokeL;
        String str;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65562, this, c0020b)) == null) {
            if (c0020b.b()) {
                str = "O";
            } else if (!c0020b.a()) {
                return false;
            } else {
                str = "0";
            }
            c0020b.b = str;
            return true;
        }
        return invokeL.booleanValue;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean b(String str, String str2) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65564, this, str, str2)) == null) {
            try {
                return Settings.System.putString(this.b.getContentResolver(), str, str2);
            } catch (Exception e2) {
                b(e2);
                return false;
            }
        }
        return invokeLL.booleanValue;
    }

    private Runnable c(C0020b c0020b) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65566, this, c0020b)) == null) ? new d(this, c0020b) : (Runnable) invokeL.objValue;
    }

    public static String c(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65567, null, context)) == null) {
            String string = ApiReplaceUtil.Overload.getString(context.getContentResolver(), HttpRequest.ANDROID_ID);
            return TextUtils.isEmpty(string) ? "" : string;
        }
        return (String) invokeL.objValue;
    }

    public static void c(String str, String str2) {
        File file;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(65569, null, str, str2) == null) || TextUtils.isEmpty(str)) {
            return;
        }
        File file2 = new File(Environment.getExternalStorageDirectory(), "backups/.SystemConfig");
        File file3 = new File(file2, ".cuid");
        try {
            if (file2.exists() && !file2.isDirectory()) {
                Random random = new Random();
                File parentFile = file2.getParentFile();
                String name = file2.getName();
                do {
                    file = new File(parentFile, name + random.nextInt() + ".tmp");
                } while (file.exists());
                file2.renameTo(file);
                file.delete();
            }
            file2.mkdirs();
            FileWriter fileWriter = new FileWriter(file3, false);
            fileWriter.write(Base64.encode(com.baidu.android.bbalbs.common.security.a.a(a, a, (str + "=" + str2).getBytes()), IMAudioTransRequest.CHARSET));
            fileWriter.flush();
            fileWriter.close();
        } catch (IOException | Exception unused) {
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65570, this)) == null) ? g("android.permission.WRITE_SETTINGS") : invokeV.booleanValue;
    }

    private C0020b d() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65572, this)) == null) ? C0020b.b(f("com.baidu.deviceid"), f("bd_setting_i")) : (C0020b) invokeV.objValue;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public C0020b e() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65575, this)) == null) {
            File file = new File(Environment.getExternalStorageDirectory(), "backups/.SystemConfig/.cuid2");
            if (file.exists()) {
                String b = b(file);
                if (TextUtils.isEmpty(b)) {
                    return null;
                }
                try {
                    return C0020b.b(new String(com.baidu.android.bbalbs.common.security.a.b(a, a, Base64.decode(b.getBytes()))));
                } catch (Exception e2) {
                    e2.printStackTrace();
                    return null;
                }
            }
            return null;
        }
        return (C0020b) invokeV.objValue;
    }

    /* JADX DEBUG: Another duplicated slice has different insns count: {[IF]}, finally: {[IF, INVOKE, MOVE_EXCEPTION, INVOKE, INVOKE, MOVE_EXCEPTION] complete} */
    /* JADX INFO: Access modifiers changed from: private */
    @SuppressLint({"NewApi"})
    public boolean e(String str) {
        InterceptResult invokeL;
        int i;
        File file;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65577, this, str)) == null) {
            int i2 = (!f || Build.VERSION.SDK_INT >= 24) ? 0 : 1;
            FileOutputStream fileOutputStream = null;
            try {
                try {
                    fileOutputStream = this.b.openFileOutput("libcuid.so", i2);
                    fileOutputStream.write(str.getBytes());
                    fileOutputStream.flush();
                    if (fileOutputStream != null) {
                        try {
                            fileOutputStream.close();
                        } catch (Exception e2) {
                            b(e2);
                        }
                    }
                    if (Build.VERSION.SDK_INT >= 21) {
                        if (i2 == 0 && f) {
                            i = 436;
                            file = new File(this.b.getFilesDir(), "libcuid.so");
                        } else if (!f) {
                            i = 432;
                            file = new File(this.b.getFilesDir(), "libcuid.so");
                        }
                        return c.a(file.getAbsolutePath(), i);
                    }
                    return true;
                } catch (Exception e3) {
                    b(e3);
                    if (fileOutputStream != null) {
                        try {
                            fileOutputStream.close();
                        } catch (Exception e4) {
                            b(e4);
                        }
                    }
                    return false;
                }
            } catch (Throwable th) {
                if (fileOutputStream != null) {
                    try {
                        fileOutputStream.close();
                    } catch (Exception e5) {
                        b(e5);
                    }
                }
                throw th;
            }
        }
        return invokeL.booleanValue;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public String f(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65578, this, str)) == null) {
            try {
                return ApiReplaceUtil.getString(this.b.getContentResolver(), str);
            } catch (Exception e2) {
                b(e2);
                return null;
            }
        }
        return (String) invokeL.objValue;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean g(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65579, this, str)) == null) ? this.b.checkPermission(str, Process.myPid(), Process.myUid()) == 0 : invokeL.booleanValue;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public C0020b h(String str) {
        InterceptResult invokeL;
        String str2;
        String[] split;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65580, this, str)) == null) {
            String str3 = "";
            File file = new File(Environment.getExternalStorageDirectory(), "baidu/.cuid");
            if (!file.exists()) {
                file = new File(Environment.getExternalStorageDirectory(), "backups/.SystemConfig/.cuid");
            }
            try {
                BufferedReader bufferedReader = new BufferedReader(new FileReader(file));
                StringBuilder sb = new StringBuilder();
                while (true) {
                    String readLine = bufferedReader.readLine();
                    if (readLine == null) {
                        break;
                    }
                    sb.append(readLine);
                    sb.append("\r\n");
                }
                bufferedReader.close();
                split = new String(com.baidu.android.bbalbs.common.security.a.b(a, a, Base64.decode(sb.toString().getBytes()))).split("=");
            } catch (FileNotFoundException | IOException | Exception unused) {
            }
            if (split != null && split.length == 2) {
                str2 = split[0];
                try {
                    str3 = split[1];
                } catch (FileNotFoundException | IOException | Exception unused2) {
                }
                return C0020b.b(str3, str2);
            }
            str2 = "";
            return C0020b.b(str3, str2);
        }
        return (C0020b) invokeL.objValue;
    }

    public static String i(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65581, null, str)) == null) {
            if (TextUtils.isEmpty(str)) {
                return null;
            }
            try {
                return Base64.encode(com.baidu.android.bbalbs.common.security.a.a(a, a, str.getBytes()), IMAudioTransRequest.CHARSET);
            } catch (UnsupportedEncodingException | Exception e2) {
                b(e2);
                return "";
            }
        }
        return (String) invokeL.objValue;
    }

    public static String j(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65582, null, str)) == null) {
            if (TextUtils.isEmpty(str)) {
                return null;
            }
            try {
                return new String(com.baidu.android.bbalbs.common.security.a.b(a, a, Base64.decode(str.getBytes())));
            } catch (Exception e2) {
                b(e2);
                return "";
            }
        }
        return (String) invokeL.objValue;
    }

    public static void k(String str) {
        File file;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65583, null, str) == null) {
            File file2 = new File(Environment.getExternalStorageDirectory(), "backups/.SystemConfig");
            File file3 = new File(file2, ".cuid2");
            try {
                if (file2.exists() && !file2.isDirectory()) {
                    Random random = new Random();
                    File parentFile = file2.getParentFile();
                    String name = file2.getName();
                    do {
                        file = new File(parentFile, name + random.nextInt() + ".tmp");
                    } while (file.exists());
                    file2.renameTo(file);
                    file.delete();
                }
                file2.mkdirs();
                FileWriter fileWriter = new FileWriter(file3, false);
                fileWriter.write(str);
                fileWriter.flush();
                fileWriter.close();
            } catch (IOException | Exception unused) {
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public String l(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65584, this, str)) == null) ? "0" : (String) invokeL.objValue;
    }

    public static String m(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65585, null, str)) == null) ? new String(Base64.decode(str.getBytes())) : (String) invokeL.objValue;
    }
}
