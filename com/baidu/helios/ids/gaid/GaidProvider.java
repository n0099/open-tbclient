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
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import d.a.t.g.d.a;
import d.a.t.h.a;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicBoolean;
import org.json.JSONObject;
/* loaded from: classes3.dex */
public class GaidProvider extends d.a.t.h.a {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: d  reason: collision with root package name */
    public a.C1937a f6291d;

    /* renamed from: e  reason: collision with root package name */
    public c f6292e;

    /* renamed from: f  reason: collision with root package name */
    public f f6293f;

    /* renamed from: g  reason: collision with root package name */
    public b f6294g;

    /* renamed from: h  reason: collision with root package name */
    public List<a.d<String>> f6295h;

    /* renamed from: i  reason: collision with root package name */
    public g f6296i;

    /* loaded from: classes3.dex */
    public class a implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ a.d f6297e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ GaidProvider f6298f;

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
            this.f6298f = gaidProvider;
            this.f6297e = dVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                if (this.f6298f.f6294g.f6299a.get()) {
                    this.f6298f.j(this.f6297e);
                } else {
                    this.f6298f.f6295h.add(this.f6297e);
                }
            }
        }
    }

    /* loaded from: classes3.dex */
    public class b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public AtomicBoolean f6299a;

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
            this.f6299a = new AtomicBoolean(false);
        }
    }

    /* loaded from: classes3.dex */
    public class c {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public long f6300a;

        /* renamed from: b  reason: collision with root package name */
        public boolean f6301b;

        /* renamed from: c  reason: collision with root package name */
        public d.a.t.g.c.a.e f6302c;

        /* renamed from: d  reason: collision with root package name */
        public String f6303d;

        /* renamed from: e  reason: collision with root package name */
        public ArrayList<String> f6304e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ GaidProvider f6305f;

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
            this.f6305f = gaidProvider;
            this.f6301b = true;
            this.f6302c = new d.a.t.g.c.a.e();
            this.f6304e = new ArrayList<>();
        }

        public String a() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.f6303d : (String) invokeV.objValue;
        }

        public void b(long j, long j2) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeCommon(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, new Object[]{Long.valueOf(j), Long.valueOf(j2)}) == null) && this.f6302c.c(j, j2)) {
                this.f6301b = true;
            }
        }

        public void c(String str) {
            String str2;
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, str) == null) || (str2 = this.f6303d) == str) {
                return;
            }
            if (str == null || !str.equals(str2)) {
                this.f6303d = str;
                this.f6301b = true;
            }
        }

        public long d() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? this.f6300a : invokeV.longValue;
        }

        public void e(long j) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeJ(1048580, this, j) == null) || this.f6300a == j) {
                return;
            }
            this.f6300a = j;
            this.f6301b = true;
        }

        public void f(String str) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048581, this, str) == null) || this.f6304e.contains(str)) {
                return;
            }
            this.f6304e.add(str);
            this.f6301b = true;
        }

        public boolean g() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) {
                String g2 = this.f6305f.f6291d.g("cache.dat", true);
                if (!TextUtils.isEmpty(g2)) {
                    try {
                        JSONObject jSONObject = new JSONObject(g2);
                        this.f6303d = jSONObject.optString("form_id");
                        this.f6300a = jSONObject.getLong("lst_fe_ts");
                        jSONObject.getInt("c_form_ver");
                        this.f6302c.b(jSONObject.getLong("flags"));
                        this.f6304e.clear();
                        JSONObject optJSONObject = jSONObject.optJSONObject("his_form_ids");
                        if (optJSONObject != null) {
                            int i2 = optJSONObject.getInt("count");
                            for (int i3 = 0; i3 < i2; i3++) {
                                String string = optJSONObject.getString("id_" + i3);
                                if (TextUtils.isEmpty(string)) {
                                    this.f6304e.clear();
                                    return false;
                                }
                                this.f6304e.add(string);
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
                if (this.f6301b) {
                    try {
                        JSONObject jSONObject = new JSONObject();
                        jSONObject.put("form_id", this.f6303d);
                        jSONObject.put("lst_fe_ts", this.f6300a);
                        jSONObject.put("c_form_ver", 1);
                        jSONObject.put("flags", this.f6302c.d());
                        int size = this.f6304e.size();
                        if (size > 0) {
                            int min = Math.min(size, 5);
                            JSONObject jSONObject2 = new JSONObject();
                            jSONObject.put("his_form_ids", jSONObject2);
                            jSONObject2.put("count", min);
                            for (int i2 = 0; i2 < min; i2++) {
                                jSONObject2.put("id_" + i2, this.f6304e.get((size - min) + i2));
                            }
                        }
                        this.f6305f.f6291d.i("cache.dat", jSONObject.toString(), true);
                        this.f6301b = false;
                        return true;
                    } catch (Exception unused) {
                    }
                }
                return false;
            }
            return invokeV.booleanValue;
        }
    }

    /* loaded from: classes3.dex */
    public static class d implements IInterface {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public IBinder f6306a;

        /* renamed from: b  reason: collision with root package name */
        public String f6307b;

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
            this.f6306a = iBinder;
            try {
                this.f6307b = com.baidu.helios.ids.gaid.c.a(d.a.t.h.d.a.c());
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
                    obtain.writeInterfaceToken(this.f6307b);
                    this.f6306a.transact(1, obtain, obtain2, 0);
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
                    obtain.writeInterfaceToken(this.f6307b);
                    obtain.writeInt(z ? 1 : 0);
                    this.f6306a.transact(2, obtain, obtain2, 0);
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
            return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? this.f6306a : (IBinder) invokeV.objValue;
        }
    }

    /* loaded from: classes3.dex */
    public class e implements ServiceConnection {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ GaidProvider f6308e;

        /* loaded from: classes3.dex */
        public class a implements Runnable {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: e  reason: collision with root package name */
            public final /* synthetic */ IBinder f6309e;

            /* renamed from: f  reason: collision with root package name */
            public final /* synthetic */ e f6310f;

            /* renamed from: com.baidu.helios.ids.gaid.GaidProvider$e$a$a  reason: collision with other inner class name */
            /* loaded from: classes3.dex */
            public class RunnableC0106a implements Runnable {
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;

                /* renamed from: e  reason: collision with root package name */
                public final /* synthetic */ String f6311e;

                /* renamed from: f  reason: collision with root package name */
                public final /* synthetic */ boolean f6312f;

                /* renamed from: g  reason: collision with root package name */
                public final /* synthetic */ a f6313g;

                public RunnableC0106a(a aVar, String str, boolean z) {
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
                    this.f6313g = aVar;
                    this.f6311e = str;
                    this.f6312f = z;
                }

                @Override // java.lang.Runnable
                public void run() {
                    Interceptable interceptable = $ic;
                    if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                        if (!this.f6313g.f6310f.f6308e.f6294g.f6299a.get()) {
                            this.f6313g.f6310f.f6308e.i();
                            this.f6313g.f6310f.f6308e.f6294g.f6299a.set(true);
                        }
                        this.f6313g.f6310f.f6308e.f6292e.b(this.f6312f ? 1L : 2L, 3L);
                        if (!TextUtils.isEmpty(this.f6311e)) {
                            try {
                                String b2 = d.a.t.h.a.b("A20", new d.a.t.g.c.a.b("ABCDEFGHIJKLMNOPQRSTUVWXYZ234567=", false, false).b(this.f6311e.getBytes("UTF-8")));
                                this.f6313g.f6310f.f6308e.f6292e.c(b2);
                                this.f6313g.f6310f.f6308e.f6292e.f(b2);
                            } catch (Exception unused) {
                            }
                        }
                        this.f6313g.f6310f.f6308e.f6292e.h();
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
                this.f6310f = eVar;
                this.f6309e = iBinder;
            }

            @Override // java.lang.Runnable
            public void run() {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                    try {
                        d dVar = new d(this.f6309e);
                        String a2 = dVar.a();
                        boolean a3 = dVar.a(false);
                        if (this.f6310f.f6308e.f6296i != null) {
                            this.f6310f.f6308e.f6296i.removeMessages(0);
                        }
                        this.f6310f.f6308e.f70387b.f70394d.submit(new RunnableC0106a(this, a2, a3));
                        this.f6310f.f6308e.f70387b.f70391a.unbindService(this.f6310f);
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
            this.f6308e = gaidProvider;
        }

        @Override // android.content.ServiceConnection
        public void onServiceConnected(ComponentName componentName, IBinder iBinder) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(1048576, this, componentName, iBinder) == null) {
                this.f6308e.f70387b.f70395e.submit(new a(this, iBinder));
            }
        }

        @Override // android.content.ServiceConnection
        public void onServiceDisconnected(ComponentName componentName) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, componentName) == null) {
            }
        }
    }

    /* loaded from: classes3.dex */
    public static class f {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public String f6314a;

        /* renamed from: b  reason: collision with root package name */
        public String f6315b;

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
                this.f6314a = com.baidu.helios.ids.gaid.c.a(d.a.t.h.d.a.a());
                this.f6315b = com.baidu.helios.ids.gaid.c.a(d.a.t.h.d.a.b());
            } catch (Exception unused) {
            }
        }

        public /* synthetic */ f(a aVar) {
            this();
        }

        public final String a() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.f6314a : (String) invokeV.objValue;
        }

        public final String c() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.f6315b : (String) invokeV.objValue;
        }
    }

    /* loaded from: classes3.dex */
    public class g extends Handler {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ GaidProvider f6316a;

        /* loaded from: classes3.dex */
        public class a implements Runnable {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: e  reason: collision with root package name */
            public final /* synthetic */ g f6317e;

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
                this.f6317e = gVar;
            }

            @Override // java.lang.Runnable
            public void run() {
                Interceptable interceptable = $ic;
                if (!(interceptable == null || interceptable.invokeV(1048576, this) == null) || this.f6317e.f6316a.f6294g.f6299a.get()) {
                    return;
                }
                this.f6317e.f6316a.f6294g.f6299a.set(true);
                this.f6317e.f6316a.i();
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
            this.f6316a = gaidProvider;
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, message) == null) && message.what == 0) {
                this.f6316a.f70387b.f70394d.submit(new a(this));
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public GaidProvider() {
        super("gaid");
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
        this.f6292e = new c(this);
        this.f6295h = new ArrayList();
    }

    @Override // d.a.t.h.a
    public String c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.f6292e.a() : (String) invokeV.objValue;
    }

    @Override // d.a.t.h.a
    public void f(a.c cVar) {
        String a2;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, cVar) == null) {
            b bVar = new b(this);
            this.f6294g = bVar;
            this.f6291d = this.f70386a.f("gaid");
            Context context = this.f70387b.f70391a;
            this.f6293f = new f(null);
            PackageManager packageManager = context.getPackageManager();
            try {
                a2 = this.f6293f.a();
            } catch (PackageManager.NameNotFoundException unused) {
            }
            if (a2 == null) {
                bVar.f6299a.set(true);
                return;
            }
            packageManager.getPackageInfo(a2, 0);
            this.f6292e.g();
            long currentTimeMillis = System.currentTimeMillis();
            if (Math.abs(currentTimeMillis - this.f6292e.d()) > 604800000) {
                this.f6292e.e(currentTimeMillis);
                this.f6292e.h();
                try {
                    String c2 = this.f6293f.c();
                    if (c2 == null) {
                        bVar.f6299a.set(true);
                        return;
                    } else if (!context.bindService(new Intent(c2).setPackage(a2), new e(this), 1)) {
                        bVar.f6299a.set(true);
                        return;
                    } else {
                        g gVar = new g(this, Looper.getMainLooper());
                        this.f6296i = gVar;
                        gVar.sendEmptyMessageDelayed(0, 50000L);
                        return;
                    }
                } catch (Exception unused2) {
                    bVar.f6299a.set(true);
                    return;
                }
            }
            bVar.f6299a.set(true);
        }
    }

    @Override // d.a.t.h.a
    public void g(a.d<String> dVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, dVar) == null) {
            this.f70387b.f70394d.submit(new a(this, dVar));
        }
    }

    public void i() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
            for (a.d<String> dVar : this.f6295h) {
                j(dVar);
            }
            this.f6295h.clear();
        }
    }

    public final void j(a.d<String> dVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, dVar) == null) {
            Bundle bundle = new Bundle();
            if (TextUtils.isEmpty(this.f6292e.a())) {
                dVar.b(-1, null, bundle);
            } else {
                dVar.a(this.f6292e.a(), bundle);
            }
        }
    }
}
