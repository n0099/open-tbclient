package com.baidu.location.b;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.net.wifi.WifiInfo;
import android.os.Bundle;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.location.Jni;
import com.baidu.mobads.container.util.AdIconUtil;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.googlecode.mp4parser.boxes.ultraviolet.BaseLocationBox;
import com.meizu.cloud.pushsdk.constants.PushConstants;
import java.io.File;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ExecutorService;
import org.json.JSONObject;
/* loaded from: classes2.dex */
public class h {
    public static /* synthetic */ Interceptable $ic;

    /* renamed from: c  reason: collision with root package name */
    public static Object f6607c;

    /* renamed from: d  reason: collision with root package name */
    public static h f6608d;

    /* renamed from: e  reason: collision with root package name */
    public static final String f6609e;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public a f6610a;

    /* renamed from: b  reason: collision with root package name */
    public a f6611b;

    /* renamed from: f  reason: collision with root package name */
    public SQLiteDatabase f6612f;

    /* renamed from: g  reason: collision with root package name */
    public boolean f6613g;

    /* renamed from: h  reason: collision with root package name */
    public String f6614h;

    /* renamed from: i  reason: collision with root package name */
    public int f6615i;

    /* loaded from: classes2.dex */
    public class a extends com.baidu.location.e.e {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ h f6616a;

        /* renamed from: b  reason: collision with root package name */
        public String f6617b;

        /* renamed from: c  reason: collision with root package name */
        public String f6618c;

        /* renamed from: d  reason: collision with root package name */
        public boolean f6619d;

        /* renamed from: e  reason: collision with root package name */
        public boolean f6620e;

        public a(h hVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {hVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f6616a = hVar;
            this.f6617b = null;
            this.f6618c = null;
            this.f6619d = true;
            this.f6620e = false;
            this.k = new HashMap();
        }

        @Override // com.baidu.location.e.e
        public void a() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.f6824i = 1;
                this.f6823h = com.baidu.location.e.k.e();
                String encodeTp4 = Jni.encodeTp4(this.f6618c);
                this.f6618c = null;
                this.k.put(BaseLocationBox.TYPE, encodeTp4);
            }
        }

        public void a(String str, String str2) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str, str2) == null) || this.f6616a.f6613g) {
                return;
            }
            this.f6616a.f6613g = true;
            this.f6617b = str;
            this.f6618c = str2;
            ExecutorService c2 = v.a().c();
            if (c2 != null) {
                a(c2, com.baidu.location.e.k.f6840f);
            } else {
                b(com.baidu.location.e.k.f6840f);
            }
        }

        @Override // com.baidu.location.e.e
        public void a(boolean z) {
            String str;
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeZ(Constants.METHOD_SEND_USER_MSG, this, z) == null) {
                if (z && (str = this.j) != null) {
                    try {
                        if (this.f6619d) {
                            JSONObject jSONObject = new JSONObject(str);
                            JSONObject jSONObject2 = jSONObject.has("content") ? jSONObject.getJSONObject("content") : null;
                            if (jSONObject2 != null && jSONObject2.has("imo")) {
                                Long valueOf = Long.valueOf(jSONObject2.getJSONObject("imo").getString("mac"));
                                int i2 = jSONObject2.getJSONObject("imo").getInt("mv");
                                if (Jni.encode3(this.f6617b).longValue() == valueOf.longValue()) {
                                    ContentValues contentValues = new ContentValues();
                                    contentValues.put(PushConstants.PUSH_NOTIFICATION_CREATE_TIMES_TAMP, Integer.valueOf((int) (System.currentTimeMillis() / 1000)));
                                    contentValues.put("hst", Integer.valueOf(i2));
                                    try {
                                        SQLiteDatabase sQLiteDatabase = this.f6616a.f6612f;
                                        if (sQLiteDatabase.update("hstdata", contentValues, "id = \"" + valueOf + "\"", null) <= 0) {
                                            contentValues.put("id", valueOf);
                                            this.f6616a.f6612f.insert("hstdata", null, contentValues);
                                        }
                                    } catch (Exception unused) {
                                    }
                                    Bundle bundle = new Bundle();
                                    bundle.putByteArray("mac", this.f6617b.getBytes());
                                    bundle.putInt("hotspot", i2);
                                    this.f6616a.a(bundle);
                                }
                            }
                        }
                    } catch (Exception unused2) {
                    }
                } else if (this.f6619d) {
                    this.f6616a.f();
                }
                Map<String, Object> map = this.k;
                if (map != null) {
                    map.clear();
                }
                this.f6616a.f6613g = false;
            }
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1037723500, "Lcom/baidu/location/b/h;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1037723500, "Lcom/baidu/location/b/h;");
                return;
            }
        }
        f6607c = new Object();
        f6609e = com.baidu.location.e.k.j() + "/hst.db";
    }

    public h() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.f6612f = null;
        this.f6613g = false;
        this.f6610a = null;
        this.f6611b = null;
        this.f6614h = null;
        this.f6615i = -2;
    }

    public static h a() {
        InterceptResult invokeV;
        h hVar;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65539, null)) == null) {
            synchronized (f6607c) {
                if (f6608d == null) {
                    f6608d = new h();
                }
                hVar = f6608d;
            }
            return hVar;
        }
        return (h) invokeV.objValue;
    }

    /* JADX WARN: Removed duplicated region for block: B:18:0x0051  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private String a(boolean z) {
        InterceptResult invokeZ;
        String l;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeZ = interceptable.invokeZ(InputDeviceCompat.SOURCE_TRACKBALL, this, z)) == null) {
            com.baidu.location.c.a f2 = com.baidu.location.c.b.a().f();
            com.baidu.location.c.h o = com.baidu.location.c.i.a().o();
            StringBuffer stringBuffer = new StringBuffer(1024);
            if (f2 != null && f2.b()) {
                stringBuffer.append(f2.g());
            }
            if (o == null || o.a() <= 1) {
                if (com.baidu.location.c.i.a().l() != null) {
                    l = com.baidu.location.c.i.a().l();
                }
                if (z) {
                    stringBuffer.append("&imo=1");
                }
                stringBuffer.append(com.baidu.location.e.b.a().a(false));
                stringBuffer.append(com.baidu.location.b.a.a().c());
                return stringBuffer.toString();
            }
            l = o.a(15);
            stringBuffer.append(l);
            if (z) {
            }
            stringBuffer.append(com.baidu.location.e.b.a().a(false));
            stringBuffer.append(com.baidu.location.b.a.a().c());
            return stringBuffer.toString();
        }
        return (String) invokeZ.objValue;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(Bundle bundle) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(AdIconUtil.AD_TEXT_ID, this, bundle) == null) {
            com.baidu.location.b.a.a().a(bundle, 406);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void f() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65546, this) == null) {
            Bundle bundle = new Bundle();
            bundle.putInt("hotspot", -1);
            a(bundle);
        }
    }

    public void a(String str) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048576, this, str) == null) || this.f6613g) {
            return;
        }
        try {
            JSONObject jSONObject = new JSONObject(str);
            JSONObject jSONObject2 = jSONObject.has("content") ? jSONObject.getJSONObject("content") : null;
            if (jSONObject2 == null || !jSONObject2.has("imo")) {
                return;
            }
            Long valueOf = Long.valueOf(jSONObject2.getJSONObject("imo").getString("mac"));
            int i2 = jSONObject2.getJSONObject("imo").getInt("mv");
            ContentValues contentValues = new ContentValues();
            contentValues.put(PushConstants.PUSH_NOTIFICATION_CREATE_TIMES_TAMP, Integer.valueOf((int) (System.currentTimeMillis() / 1000)));
            contentValues.put("hst", Integer.valueOf(i2));
            SQLiteDatabase sQLiteDatabase = this.f6612f;
            if (sQLiteDatabase.update("hstdata", contentValues, "id = \"" + valueOf + "\"", null) <= 0) {
                contentValues.put("id", valueOf);
                this.f6612f.insert("hstdata", null, contentValues);
            }
        } catch (Exception unused) {
        }
    }

    public void b() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            try {
                File file = new File(f6609e);
                if (!file.exists()) {
                    file.createNewFile();
                }
                if (file.exists()) {
                    SQLiteDatabase openOrCreateDatabase = SQLiteDatabase.openOrCreateDatabase(file, (SQLiteDatabase.CursorFactory) null);
                    this.f6612f = openOrCreateDatabase;
                    openOrCreateDatabase.execSQL("CREATE TABLE IF NOT EXISTS hstdata(id Long PRIMARY KEY,hst INT,tt INT);");
                    this.f6612f.setVersion(1);
                }
            } catch (Exception unused) {
                this.f6612f = null;
            }
        }
    }

    public void c() {
        SQLiteDatabase sQLiteDatabase;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) || (sQLiteDatabase = this.f6612f) == null) {
            return;
        }
        try {
            sQLiteDatabase.close();
        } catch (Exception unused) {
        } catch (Throwable th) {
            this.f6612f = null;
            throw th;
        }
        this.f6612f = null;
    }

    /* JADX WARN: Code restructure failed: missing block: B:34:0x007b, code lost:
        if (r3 != null) goto L35;
     */
    /* JADX WARN: Code restructure failed: missing block: B:35:0x007d, code lost:
        r3.close();
     */
    /* JADX WARN: Code restructure failed: missing block: B:42:0x0089, code lost:
        if (r3 == null) goto L47;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public synchronized int d() {
        InterceptResult invokeV;
        WifiInfo k;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
            synchronized (this) {
                int i2 = -3;
                if (this.f6613g) {
                    return -3;
                }
                try {
                    if (com.baidu.location.c.i.i() && this.f6612f != null && (k = com.baidu.location.c.i.a().k()) != null && k.getBSSID() != null) {
                        String replace = k.getBSSID().replace(":", "");
                        Long encode3 = Jni.encode3(replace);
                        if (this.f6614h == null || !replace.equals(this.f6614h) || this.f6615i <= -2) {
                            Cursor cursor = null;
                            try {
                                SQLiteDatabase sQLiteDatabase = this.f6612f;
                                cursor = sQLiteDatabase.rawQuery("select * from hstdata where id = \"" + encode3 + "\";", null);
                                if (cursor == null || !cursor.moveToFirst()) {
                                    i2 = -2;
                                } else {
                                    i2 = cursor.getInt(1);
                                    this.f6614h = replace;
                                    this.f6615i = i2;
                                }
                            } catch (Exception unused) {
                            } catch (Throwable th) {
                                if (cursor != null) {
                                    try {
                                        cursor.close();
                                    } catch (Exception unused2) {
                                    }
                                }
                                throw th;
                            }
                        } else {
                            i2 = this.f6615i;
                        }
                    }
                } catch (Exception unused3) {
                }
                this.f6615i = i2;
                return i2;
            }
        }
        return invokeV.intValue;
    }

    /* JADX DEBUG: Null dom frontier in handler: Exception -> 0x009b */
    /* JADX WARN: Code restructure failed: missing block: B:27:0x008d, code lost:
        if (r3 == null) goto L28;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void e() {
        WifiInfo k;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048580, this) == null) || this.f6613g) {
            return;
        }
        try {
            if (!com.baidu.location.c.i.i() || this.f6612f == null || (k = com.baidu.location.c.i.a().k()) == null || k.getBSSID() == null) {
                f();
                return;
            }
            String replace = k.getBSSID().replace(":", "");
            Long encode3 = Jni.encode3(replace);
            boolean z = false;
            Cursor cursor = null;
            try {
                SQLiteDatabase sQLiteDatabase = this.f6612f;
                cursor = sQLiteDatabase.rawQuery("select * from hstdata where id = \"" + encode3 + "\";", null);
                if (cursor != null && cursor.moveToFirst()) {
                    int i2 = cursor.getInt(1);
                    if ((System.currentTimeMillis() / 1000) - cursor.getInt(2) <= 259200) {
                        Bundle bundle = new Bundle();
                        bundle.putByteArray("mac", replace.getBytes());
                        bundle.putInt("hotspot", i2);
                        a(bundle);
                    }
                }
                z = true;
            } catch (Exception unused) {
                if (cursor != null) {
                    try {
                        cursor.close();
                    } catch (Exception unused2) {
                    }
                }
                if (z) {
                    if (this.f6610a == null) {
                        this.f6610a = new a(this);
                    }
                    if (this.f6610a != null) {
                        this.f6610a.a(replace, a(true));
                    }
                }
            }
        } catch (Exception unused3) {
        }
    }
}
