package com.baidu.helios.ids.gaid;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.os.Handler;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Looper;
import android.os.Message;
import android.os.Parcel;
import android.text.TextUtils;
import b.a.r.g.d.a;
import b.a.r.h.a;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.mobstat.dxmpay.Config;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicBoolean;
import org.json.JSONObject;
/* loaded from: classes7.dex */
public class GaidProvider extends b.a.r.h.a {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: d  reason: collision with root package name */
    public a.C0733a f38499d;

    /* renamed from: e  reason: collision with root package name */
    public c f38500e;

    /* renamed from: f  reason: collision with root package name */
    public f f38501f;

    /* renamed from: g  reason: collision with root package name */
    public b f38502g;

    /* renamed from: h  reason: collision with root package name */
    public List<a.d<String>> f38503h;

    /* renamed from: i  reason: collision with root package name */
    public g f38504i;

    /* loaded from: classes7.dex */
    public class a implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ a.d f38505e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ GaidProvider f38506f;

        public a(GaidProvider gaidProvider, a.d dVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {gaidProvider, dVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f38506f = gaidProvider;
            this.f38505e = dVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                if (this.f38506f.f38502g.f38507a.get()) {
                    this.f38506f.j(this.f38505e);
                } else {
                    this.f38506f.f38503h.add(this.f38505e);
                }
            }
        }
    }

    /* loaded from: classes7.dex */
    public class b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public AtomicBoolean f38507a;

        public b(GaidProvider gaidProvider) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {gaidProvider};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f38507a = new AtomicBoolean(false);
        }
    }

    /* loaded from: classes7.dex */
    public class c {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public long f38508a;

        /* renamed from: b  reason: collision with root package name */
        public boolean f38509b;

        /* renamed from: c  reason: collision with root package name */
        public b.a.r.g.c.a.e f38510c;

        /* renamed from: d  reason: collision with root package name */
        public String f38511d;

        /* renamed from: e  reason: collision with root package name */
        public ArrayList<String> f38512e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ GaidProvider f38513f;

        public c(GaidProvider gaidProvider) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {gaidProvider};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f38513f = gaidProvider;
            this.f38509b = true;
            this.f38510c = new b.a.r.g.c.a.e();
            this.f38512e = new ArrayList<>();
        }

        public String a() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.f38511d : (String) invokeV.objValue;
        }

        public void b(long j, long j2) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeCommon(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, new Object[]{Long.valueOf(j), Long.valueOf(j2)}) == null) && this.f38510c.c(j, j2)) {
                this.f38509b = true;
            }
        }

        public void c(String str) {
            String str2;
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, str) == null) || (str2 = this.f38511d) == str) {
                return;
            }
            if (str == null || !str.equals(str2)) {
                this.f38511d = str;
                this.f38509b = true;
            }
        }

        public long d() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? this.f38508a : invokeV.longValue;
        }

        public void e(long j) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeJ(1048580, this, j) == null) || this.f38508a == j) {
                return;
            }
            this.f38508a = j;
            this.f38509b = true;
        }

        public void f(String str) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048581, this, str) == null) || this.f38512e.contains(str)) {
                return;
            }
            this.f38512e.add(str);
            this.f38509b = true;
        }

        public boolean g() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) {
                String g2 = this.f38513f.f38499d.g("cache.dat", true);
                if (!TextUtils.isEmpty(g2)) {
                    try {
                        JSONObject jSONObject = new JSONObject(g2);
                        this.f38511d = jSONObject.optString("form_id");
                        this.f38508a = jSONObject.getLong("lst_fe_ts");
                        jSONObject.getInt("c_form_ver");
                        this.f38510c.b(jSONObject.getLong("flags"));
                        this.f38512e.clear();
                        JSONObject optJSONObject = jSONObject.optJSONObject("his_form_ids");
                        if (optJSONObject != null) {
                            int i2 = optJSONObject.getInt("count");
                            for (int i3 = 0; i3 < i2; i3++) {
                                String string = optJSONObject.getString("id_" + i3);
                                if (TextUtils.isEmpty(string)) {
                                    this.f38512e.clear();
                                    return false;
                                }
                                this.f38512e.add(string);
                            }
                        }
                        return true;
                    } catch (Exception unused) {
                    }
                }
                return false;
            }
            return invokeV.booleanValue;
        }

        public boolean h() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) {
                if (this.f38509b) {
                    try {
                        JSONObject jSONObject = new JSONObject();
                        jSONObject.put("form_id", this.f38511d);
                        jSONObject.put("lst_fe_ts", this.f38508a);
                        jSONObject.put("c_form_ver", 1);
                        jSONObject.put("flags", this.f38510c.d());
                        int size = this.f38512e.size();
                        if (size > 0) {
                            int min = Math.min(size, 5);
                            JSONObject jSONObject2 = new JSONObject();
                            jSONObject.put("his_form_ids", jSONObject2);
                            jSONObject2.put("count", min);
                            for (int i2 = 0; i2 < min; i2++) {
                                jSONObject2.put("id_" + i2, this.f38512e.get((size - min) + i2));
                            }
                        }
                        this.f38513f.f38499d.i("cache.dat", jSONObject.toString(), true);
                        this.f38509b = false;
                        return true;
                    } catch (Exception unused) {
                    }
                }
                return false;
            }
            return invokeV.booleanValue;
        }
    }

    /* loaded from: classes7.dex */
    public static class d implements IInterface {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public IBinder f38514a;

        /* renamed from: b  reason: collision with root package name */
        public String f38515b;

        public d(IBinder iBinder) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {iBinder};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f38514a = iBinder;
            try {
                this.f38515b = com.baidu.helios.ids.gaid.c.a(b.a.r.h.d.a.c());
            } catch (Exception e2) {
                e2.printStackTrace();
            }
        }

        public String a() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(this.f38515b);
                    this.f38514a.transact(1, obtain, obtain2, 0);
                    obtain2.readException();
                    return obtain2.readString();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }
            return (String) invokeV.objValue;
        }

        public boolean a(boolean z) {
            InterceptResult invokeZ;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeZ = interceptable.invokeZ(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, z)) == null) {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(this.f38515b);
                    obtain.writeInt(z ? 1 : 0);
                    this.f38514a.transact(2, obtain, obtain2, 0);
                    obtain2.readException();
                    return obtain2.readInt() != 0;
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }
            return invokeZ.booleanValue;
        }

        @Override // android.os.IInterface
        public IBinder asBinder() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? this.f38514a : (IBinder) invokeV.objValue;
        }
    }

    /* loaded from: classes7.dex */
    public class e implements ServiceConnection {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ GaidProvider f38516e;

        /* loaded from: classes7.dex */
        public class a implements Runnable {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: e  reason: collision with root package name */
            public final /* synthetic */ IBinder f38517e;

            /* renamed from: f  reason: collision with root package name */
            public final /* synthetic */ e f38518f;

            /* renamed from: com.baidu.helios.ids.gaid.GaidProvider$e$a$a  reason: collision with other inner class name */
            /* loaded from: classes7.dex */
            public class RunnableC1619a implements Runnable {
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;

                /* renamed from: e  reason: collision with root package name */
                public final /* synthetic */ String f38519e;

                /* renamed from: f  reason: collision with root package name */
                public final /* synthetic */ boolean f38520f;

                /* renamed from: g  reason: collision with root package name */
                public final /* synthetic */ a f38521g;

                public RunnableC1619a(a aVar, String str, boolean z) {
                    Interceptable interceptable = $ic;
                    if (interceptable != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {aVar, str, Boolean.valueOf(z)};
                        interceptable.invokeUnInit(65536, newInitContext);
                        int i2 = newInitContext.flag;
                        if ((i2 & 1) != 0) {
                            int i3 = i2 & 2;
                            newInitContext.thisArg = this;
                            interceptable.invokeInitBody(65536, newInitContext);
                            return;
                        }
                    }
                    this.f38521g = aVar;
                    this.f38519e = str;
                    this.f38520f = z;
                }

                @Override // java.lang.Runnable
                public void run() {
                    Interceptable interceptable = $ic;
                    if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                        if (!this.f38521g.f38518f.f38516e.f38502g.f38507a.get()) {
                            this.f38521g.f38518f.f38516e.i();
                            this.f38521g.f38518f.f38516e.f38502g.f38507a.set(true);
                        }
                        this.f38521g.f38518f.f38516e.f38500e.b(this.f38520f ? 1L : 2L, 3L);
                        if (!TextUtils.isEmpty(this.f38519e)) {
                            try {
                                String b2 = b.a.r.h.a.b("A20", new b.a.r.g.c.a.b("ABCDEFGHIJKLMNOPQRSTUVWXYZ234567=", false, false).b(this.f38519e.getBytes("UTF-8")));
                                this.f38521g.f38518f.f38516e.f38500e.c(b2);
                                this.f38521g.f38518f.f38516e.f38500e.f(b2);
                            } catch (Exception unused) {
                            }
                        }
                        this.f38521g.f38518f.f38516e.f38500e.h();
                    }
                }
            }

            public a(e eVar, IBinder iBinder) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {eVar, iBinder};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i2 = newInitContext.flag;
                    if ((i2 & 1) != 0) {
                        int i3 = i2 & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.f38518f = eVar;
                this.f38517e = iBinder;
            }

            @Override // java.lang.Runnable
            public void run() {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                    try {
                        d dVar = new d(this.f38517e);
                        String a2 = dVar.a();
                        boolean a3 = dVar.a(false);
                        if (this.f38518f.f38516e.f38504i != null) {
                            this.f38518f.f38516e.f38504i.removeMessages(0);
                        }
                        this.f38518f.f38516e.f14556b.f14563d.submit(new RunnableC1619a(this, a2, a3));
                        this.f38518f.f38516e.f14556b.f14560a.unbindService(this.f38518f);
                    } catch (Exception unused) {
                    }
                }
            }
        }

        public e(GaidProvider gaidProvider) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {gaidProvider};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f38516e = gaidProvider;
        }

        @Override // android.content.ServiceConnection
        public void onServiceConnected(ComponentName componentName, IBinder iBinder) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(1048576, this, componentName, iBinder) == null) {
                this.f38516e.f14556b.f14564e.submit(new a(this, iBinder));
            }
        }

        @Override // android.content.ServiceConnection
        public void onServiceDisconnected(ComponentName componentName) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, componentName) == null) {
            }
        }
    }

    /* loaded from: classes7.dex */
    public static class f {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public String f38522a;

        /* renamed from: b  reason: collision with root package name */
        public String f38523b;

        public f() {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            try {
                this.f38522a = com.baidu.helios.ids.gaid.c.a(b.a.r.h.d.a.a());
                this.f38523b = com.baidu.helios.ids.gaid.c.a(b.a.r.h.d.a.b());
            } catch (Exception unused) {
            }
        }

        public /* synthetic */ f(a aVar) {
            this();
        }

        public final String a() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.f38522a : (String) invokeV.objValue;
        }

        public final String c() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.f38523b : (String) invokeV.objValue;
        }
    }

    /* loaded from: classes7.dex */
    public class g extends Handler {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ GaidProvider f38524a;

        /* loaded from: classes7.dex */
        public class a implements Runnable {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: e  reason: collision with root package name */
            public final /* synthetic */ g f38525e;

            public a(g gVar) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {gVar};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i2 = newInitContext.flag;
                    if ((i2 & 1) != 0) {
                        int i3 = i2 & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.f38525e = gVar;
            }

            @Override // java.lang.Runnable
            public void run() {
                Interceptable interceptable = $ic;
                if (!(interceptable == null || interceptable.invokeV(1048576, this) == null) || this.f38525e.f38524a.f38502g.f38507a.get()) {
                    return;
                }
                this.f38525e.f38524a.f38502g.f38507a.set(true);
                this.f38525e.f38524a.i();
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public g(GaidProvider gaidProvider, Looper looper) {
            super(looper);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {gaidProvider, looper};
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
            this.f38524a = gaidProvider;
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, message) == null) && message.what == 0) {
                this.f38524a.f14556b.f14563d.submit(new a(this));
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public GaidProvider() {
        super(Config.GAID);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                super((String) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f38500e = new c(this);
        this.f38503h = new ArrayList();
    }

    @Override // b.a.r.h.a
    public String c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.f38500e.a() : (String) invokeV.objValue;
    }

    @Override // b.a.r.h.a
    public void f(a.c cVar) {
        String a2;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, cVar) == null) {
            b bVar = new b(this);
            this.f38502g = bVar;
            this.f38499d = this.f14555a.f(Config.GAID);
            Context context = this.f14556b.f14560a;
            this.f38501f = new f(null);
            PackageManager packageManager = context.getPackageManager();
            try {
                a2 = this.f38501f.a();
            } catch (PackageManager.NameNotFoundException unused) {
            }
            if (a2 == null) {
                bVar.f38507a.set(true);
                return;
            }
            packageManager.getPackageInfo(a2, 0);
            this.f38500e.g();
            long currentTimeMillis = System.currentTimeMillis();
            if (Math.abs(currentTimeMillis - this.f38500e.d()) > 604800000) {
                this.f38500e.e(currentTimeMillis);
                this.f38500e.h();
                try {
                    String c2 = this.f38501f.c();
                    if (c2 == null) {
                        bVar.f38507a.set(true);
                        return;
                    } else if (!context.bindService(new Intent(c2).setPackage(a2), new e(this), 1)) {
                        bVar.f38507a.set(true);
                        return;
                    } else {
                        g gVar = new g(this, Looper.getMainLooper());
                        this.f38504i = gVar;
                        gVar.sendEmptyMessageDelayed(0, 50000L);
                        return;
                    }
                } catch (Exception unused2) {
                    bVar.f38507a.set(true);
                    return;
                }
            }
            bVar.f38507a.set(true);
        }
    }

    @Override // b.a.r.h.a
    public void g(a.d<String> dVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, dVar) == null) {
            this.f14556b.f14563d.submit(new a(this, dVar));
        }
    }

    public void i() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
            for (a.d<String> dVar : this.f38503h) {
                j(dVar);
            }
            this.f38503h.clear();
        }
    }

    public final void j(a.d<String> dVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, dVar) == null) {
            Bundle bundle = new Bundle();
            if (TextUtils.isEmpty(this.f38500e.a())) {
                dVar.a(-1, null, bundle);
            } else {
                dVar.onResult(this.f38500e.a(), bundle);
            }
        }
    }
}
