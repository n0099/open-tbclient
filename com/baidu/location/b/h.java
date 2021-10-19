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
/* loaded from: classes5.dex */
public class h {
    public static /* synthetic */ Interceptable $ic;

    /* renamed from: c  reason: collision with root package name */
    public static Object f41119c;

    /* renamed from: d  reason: collision with root package name */
    public static h f41120d;

    /* renamed from: e  reason: collision with root package name */
    public static final String f41121e;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public a f41122a;

    /* renamed from: b  reason: collision with root package name */
    public a f41123b;

    /* renamed from: f  reason: collision with root package name */
    public SQLiteDatabase f41124f;

    /* renamed from: g  reason: collision with root package name */
    public boolean f41125g;

    /* renamed from: h  reason: collision with root package name */
    public String f41126h;

    /* renamed from: i  reason: collision with root package name */
    public int f41127i;

    /* loaded from: classes5.dex */
    public class a extends com.baidu.location.e.e {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ h f41128a;

        /* renamed from: b  reason: collision with root package name */
        public String f41129b;

        /* renamed from: c  reason: collision with root package name */
        public String f41130c;

        /* renamed from: d  reason: collision with root package name */
        public boolean f41131d;

        /* renamed from: e  reason: collision with root package name */
        public boolean f41132e;

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
            this.f41128a = hVar;
            this.f41129b = null;
            this.f41130c = null;
            this.f41131d = true;
            this.f41132e = false;
            this.k = new HashMap();
        }

        @Override // com.baidu.location.e.e
        public void a() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.f41346i = 1;
                this.f41345h = com.baidu.location.e.k.e();
                String encodeTp4 = Jni.encodeTp4(this.f41130c);
                this.f41130c = null;
                this.k.put(BaseLocationBox.TYPE, encodeTp4);
            }
        }

        public void a(String str, String str2) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str, str2) == null) || this.f41128a.f41125g) {
                return;
            }
            this.f41128a.f41125g = true;
            this.f41129b = str;
            this.f41130c = str2;
            ExecutorService c2 = v.a().c();
            if (c2 != null) {
                a(c2, com.baidu.location.e.k.f41363f);
            } else {
                b(com.baidu.location.e.k.f41363f);
            }
        }

        @Override // com.baidu.location.e.e
        public void a(boolean z) {
            String str;
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeZ(Constants.METHOD_SEND_USER_MSG, this, z) == null) {
                if (z && (str = this.f41347j) != null) {
                    try {
                        if (this.f41131d) {
                            JSONObject jSONObject = new JSONObject(str);
                            JSONObject jSONObject2 = jSONObject.has("content") ? jSONObject.getJSONObject("content") : null;
                            if (jSONObject2 != null && jSONObject2.has("imo")) {
                                Long valueOf = Long.valueOf(jSONObject2.getJSONObject("imo").getString("mac"));
                                int i2 = jSONObject2.getJSONObject("imo").getInt("mv");
                                if (Jni.encode3(this.f41129b).longValue() == valueOf.longValue()) {
                                    ContentValues contentValues = new ContentValues();
                                    contentValues.put(PushConstants.PUSH_NOTIFICATION_CREATE_TIMES_TAMP, Integer.valueOf((int) (System.currentTimeMillis() / 1000)));
                                    contentValues.put("hst", Integer.valueOf(i2));
                                    try {
                                        SQLiteDatabase sQLiteDatabase = this.f41128a.f41124f;
                                        if (sQLiteDatabase.update("hstdata", contentValues, "id = \"" + valueOf + "\"", null) <= 0) {
                                            contentValues.put("id", valueOf);
                                            this.f41128a.f41124f.insert("hstdata", null, contentValues);
                                        }
                                    } catch (Exception unused) {
                                    }
                                    Bundle bundle = new Bundle();
                                    bundle.putByteArray("mac", this.f41129b.getBytes());
                                    bundle.putInt("hotspot", i2);
                                    this.f41128a.a(bundle);
                                }
                            }
                        }
                    } catch (Exception unused2) {
                    }
                } else if (this.f41131d) {
                    this.f41128a.f();
                }
                Map<String, Object> map = this.k;
                if (map != null) {
                    map.clear();
                }
                this.f41128a.f41125g = false;
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
        f41119c = new Object();
        f41121e = com.baidu.location.e.k.j() + "/hst.db";
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
        this.f41124f = null;
        this.f41125g = false;
        this.f41122a = null;
        this.f41123b = null;
        this.f41126h = null;
        this.f41127i = -2;
    }

    public static h a() {
        InterceptResult invokeV;
        h hVar;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65539, null)) == null) {
            synchronized (f41119c) {
                if (f41120d == null) {
                    f41120d = new h();
                }
                hVar = f41120d;
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
        if (!(interceptable == null || interceptable.invokeL(1048576, this, str) == null) || this.f41125g) {
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
            SQLiteDatabase sQLiteDatabase = this.f41124f;
            if (sQLiteDatabase.update("hstdata", contentValues, "id = \"" + valueOf + "\"", null) <= 0) {
                contentValues.put("id", valueOf);
                this.f41124f.insert("hstdata", null, contentValues);
            }
        } catch (Exception unused) {
        }
    }

    public void b() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            try {
                File file = new File(f41121e);
                if (!file.exists()) {
                    file.createNewFile();
                }
                if (file.exists()) {
                    SQLiteDatabase openOrCreateDatabase = SQLiteDatabase.openOrCreateDatabase(file, (SQLiteDatabase.CursorFactory) null);
                    this.f41124f = openOrCreateDatabase;
                    openOrCreateDatabase.execSQL("CREATE TABLE IF NOT EXISTS hstdata(id Long PRIMARY KEY,hst INT,tt INT);");
                    this.f41124f.setVersion(1);
                }
            } catch (Exception unused) {
                this.f41124f = null;
            }
        }
    }

    public void c() {
        SQLiteDatabase sQLiteDatabase;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) || (sQLiteDatabase = this.f41124f) == null) {
            return;
        }
        try {
            sQLiteDatabase.close();
        } catch (Exception unused) {
        } catch (Throwable th) {
            this.f41124f = null;
            throw th;
        }
        this.f41124f = null;
    }

    /* JADX WARN: Code restructure failed: missing block: B:34:0x007a, code lost:
        if (r3 != null) goto L35;
     */
    /* JADX WARN: Code restructure failed: missing block: B:35:0x007c, code lost:
        r3.close();
     */
    /* JADX WARN: Code restructure failed: missing block: B:42:0x0088, code lost:
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
                if (this.f41125g) {
                    return -3;
                }
                try {
                    if (com.baidu.location.c.i.i() && this.f41124f != null && (k = com.baidu.location.c.i.a().k()) != null && k.getBSSID() != null) {
                        String replace = k.getBSSID().replace(":", "");
                        Long encode3 = Jni.encode3(replace);
                        if (this.f41126h == null || !replace.equals(this.f41126h) || this.f41127i <= -2) {
                            Cursor cursor = null;
                            try {
                                SQLiteDatabase sQLiteDatabase = this.f41124f;
                                cursor = sQLiteDatabase.rawQuery("select * from hstdata where id = \"" + encode3 + "\";", null);
                                if (cursor == null || !cursor.moveToFirst()) {
                                    i2 = -2;
                                } else {
                                    i2 = cursor.getInt(1);
                                    this.f41126h = replace;
                                    this.f41127i = i2;
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
                            i2 = this.f41127i;
                        }
                    }
                } catch (Exception unused3) {
                }
                this.f41127i = i2;
                return i2;
            }
        }
        return invokeV.intValue;
    }

    /* JADX DEBUG: Null dom frontier in handler: Exception -> 0x009a */
    /* JADX WARN: Code restructure failed: missing block: B:27:0x008c, code lost:
        if (r3 == null) goto L28;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void e() {
        WifiInfo k;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048580, this) == null) || this.f41125g) {
            return;
        }
        try {
            if (!com.baidu.location.c.i.i() || this.f41124f == null || (k = com.baidu.location.c.i.a().k()) == null || k.getBSSID() == null) {
                f();
                return;
            }
            String replace = k.getBSSID().replace(":", "");
            Long encode3 = Jni.encode3(replace);
            boolean z = false;
            Cursor cursor = null;
            try {
                SQLiteDatabase sQLiteDatabase = this.f41124f;
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
                    if (this.f41122a == null) {
                        this.f41122a = new a(this);
                    }
                    if (this.f41122a != null) {
                        this.f41122a.a(replace, a(true));
                    }
                }
            }
        } catch (Exception unused3) {
        }
    }
}
