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
import android.os.RemoteException;
import android.text.TextUtils;
import c.a.r.h.d.a;
import c.a.r.j.a;
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
/* loaded from: classes10.dex */
public class GaidProvider extends c.a.r.j.a {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: d  reason: collision with root package name */
    public a.C0259a f34576d;

    /* renamed from: e  reason: collision with root package name */
    public c f34577e;

    /* renamed from: f  reason: collision with root package name */
    public f f34578f;

    /* renamed from: g  reason: collision with root package name */
    public b f34579g;

    /* renamed from: h  reason: collision with root package name */
    public List<a.c<String>> f34580h;

    /* renamed from: i  reason: collision with root package name */
    public g f34581i;

    /* loaded from: classes10.dex */
    public class a implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ a.c f34582e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ GaidProvider f34583f;

        public a(GaidProvider gaidProvider, a.c cVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {gaidProvider, cVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f34583f = gaidProvider;
            this.f34582e = cVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                if (this.f34583f.f34579g.a.get()) {
                    this.f34583f.j(this.f34582e);
                } else {
                    this.f34583f.f34580h.add(this.f34582e);
                }
            }
        }
    }

    /* loaded from: classes10.dex */
    public class b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public AtomicBoolean a;

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
            this.a = new AtomicBoolean(false);
        }
    }

    /* loaded from: classes10.dex */
    public class c {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public long a;

        /* renamed from: b  reason: collision with root package name */
        public boolean f34584b;

        /* renamed from: c  reason: collision with root package name */
        public c.a.r.h.c.a.e f34585c;

        /* renamed from: d  reason: collision with root package name */
        public String f34586d;

        /* renamed from: e  reason: collision with root package name */
        public ArrayList<String> f34587e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ GaidProvider f34588f;

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
            this.f34588f = gaidProvider;
            this.f34584b = true;
            this.f34585c = new c.a.r.h.c.a.e();
            this.f34587e = new ArrayList<>();
        }

        public String a() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.f34586d : (String) invokeV.objValue;
        }

        public void b(long j2, long j3) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeCommon(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, new Object[]{Long.valueOf(j2), Long.valueOf(j3)}) == null) && this.f34585c.c(j2, j3)) {
                this.f34584b = true;
            }
        }

        public void c(String str) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, str) == null) || this.f34587e.contains(str)) {
                return;
            }
            this.f34587e.add(str);
            this.f34584b = true;
        }

        public long d() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? this.a : invokeV.longValue;
        }

        public void e(long j2) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeJ(1048580, this, j2) == null) || this.a == j2) {
                return;
            }
            this.a = j2;
            this.f34584b = true;
        }

        public void f(String str) {
            String str2;
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048581, this, str) == null) || (str2 = this.f34586d) == str) {
                return;
            }
            if (str == null || !str.equals(str2)) {
                this.f34586d = str;
                this.f34584b = true;
            }
        }

        public boolean g() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) {
                if (this.f34584b) {
                    try {
                        JSONObject jSONObject = new JSONObject();
                        jSONObject.put("form_id", this.f34586d);
                        jSONObject.put("lst_fe_ts", this.a);
                        jSONObject.put("c_form_ver", 1);
                        jSONObject.put("flags", this.f34585c.d());
                        int size = this.f34587e.size();
                        if (size > 0) {
                            int min = Math.min(size, 5);
                            JSONObject jSONObject2 = new JSONObject();
                            jSONObject.put("his_form_ids", jSONObject2);
                            jSONObject2.put("count", min);
                            for (int i2 = 0; i2 < min; i2++) {
                                jSONObject2.put("id_" + i2, this.f34587e.get((size - min) + i2));
                            }
                        }
                        this.f34588f.f34576d.i("cache.dat", jSONObject.toString(), true);
                        this.f34584b = false;
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
                String g2 = this.f34588f.f34576d.g("cache.dat", true);
                if (!TextUtils.isEmpty(g2)) {
                    try {
                        JSONObject jSONObject = new JSONObject(g2);
                        this.f34586d = jSONObject.optString("form_id");
                        this.a = jSONObject.getLong("lst_fe_ts");
                        jSONObject.getInt("c_form_ver");
                        this.f34585c.b(jSONObject.getLong("flags"));
                        this.f34587e.clear();
                        JSONObject optJSONObject = jSONObject.optJSONObject("his_form_ids");
                        if (optJSONObject != null) {
                            int i2 = optJSONObject.getInt("count");
                            for (int i3 = 0; i3 < i2; i3++) {
                                String string = optJSONObject.getString("id_" + i3);
                                if (TextUtils.isEmpty(string)) {
                                    this.f34587e.clear();
                                    return false;
                                }
                                this.f34587e.add(string);
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
    }

    /* loaded from: classes10.dex */
    public class d implements ServiceConnection {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ GaidProvider f34589e;

        /* loaded from: classes10.dex */
        public class a implements Runnable {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: e  reason: collision with root package name */
            public final /* synthetic */ IBinder f34590e;

            /* renamed from: f  reason: collision with root package name */
            public final /* synthetic */ d f34591f;

            /* renamed from: com.baidu.helios.ids.gaid.GaidProvider$d$a$a  reason: collision with other inner class name */
            /* loaded from: classes10.dex */
            public class RunnableC1815a implements Runnable {
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;

                /* renamed from: e  reason: collision with root package name */
                public final /* synthetic */ String f34592e;

                /* renamed from: f  reason: collision with root package name */
                public final /* synthetic */ boolean f34593f;

                /* renamed from: g  reason: collision with root package name */
                public final /* synthetic */ a f34594g;

                public RunnableC1815a(a aVar, String str, boolean z) {
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
                    this.f34594g = aVar;
                    this.f34592e = str;
                    this.f34593f = z;
                }

                @Override // java.lang.Runnable
                public void run() {
                    Interceptable interceptable = $ic;
                    if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                        if (!this.f34594g.f34591f.f34589e.f34579g.a.get()) {
                            this.f34594g.f34591f.f34589e.i();
                            this.f34594g.f34591f.f34589e.f34579g.a.set(true);
                        }
                        this.f34594g.f34591f.f34589e.f34577e.b(this.f34593f ? 1L : 2L, 3L);
                        if (!TextUtils.isEmpty(this.f34592e)) {
                            try {
                                String b2 = c.a.r.j.a.b("A20", new c.a.r.h.c.a.b("ABCDEFGHIJKLMNOPQRSTUVWXYZ234567=", false, false).b(this.f34592e.getBytes("UTF-8")));
                                this.f34594g.f34591f.f34589e.f34577e.f(b2);
                                this.f34594g.f34591f.f34589e.f34577e.c(b2);
                            } catch (Exception unused) {
                            }
                        }
                        this.f34594g.f34591f.f34589e.f34577e.g();
                    }
                }
            }

            public a(d dVar, IBinder iBinder) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {dVar, iBinder};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i2 = newInitContext.flag;
                    if ((i2 & 1) != 0) {
                        int i3 = i2 & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.f34591f = dVar;
                this.f34590e = iBinder;
            }

            @Override // java.lang.Runnable
            public void run() {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                    try {
                        e eVar = new e(this.f34590e);
                        String a = eVar.a();
                        boolean a2 = eVar.a(false);
                        if (this.f34591f.f34589e.f34581i != null) {
                            this.f34591f.f34589e.f34581i.removeMessages(0);
                        }
                        this.f34591f.f34589e.f5116b.f5120d.submit(new RunnableC1815a(this, a, a2));
                        this.f34591f.f34589e.f5116b.a.unbindService(this.f34591f);
                    } catch (Exception unused) {
                    }
                }
            }
        }

        public d(GaidProvider gaidProvider) {
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
            this.f34589e = gaidProvider;
        }

        @Override // android.content.ServiceConnection
        public void onServiceConnected(ComponentName componentName, IBinder iBinder) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(1048576, this, componentName, iBinder) == null) {
                this.f34589e.f5116b.f5121e.submit(new a(this, iBinder));
            }
        }

        @Override // android.content.ServiceConnection
        public void onServiceDisconnected(ComponentName componentName) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, componentName) == null) {
            }
        }
    }

    /* loaded from: classes10.dex */
    public static class e implements IInterface {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public IBinder a;

        /* renamed from: b  reason: collision with root package name */
        public String f34595b;

        public e(IBinder iBinder) {
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
            this.a = iBinder;
            try {
                this.f34595b = com.baidu.helios.ids.gaid.c.a(c.a.r.j.d.a.a());
            } catch (Exception e2) {
                e2.printStackTrace();
            }
        }

        public String a() throws RemoteException {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(this.f34595b);
                    this.a.transact(1, obtain, obtain2, 0);
                    obtain2.readException();
                    return obtain2.readString();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }
            return (String) invokeV.objValue;
        }

        public boolean a(boolean z) throws RemoteException {
            InterceptResult invokeZ;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeZ = interceptable.invokeZ(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, z)) == null) {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(this.f34595b);
                    obtain.writeInt(z ? 1 : 0);
                    this.a.transact(2, obtain, obtain2, 0);
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
            return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? this.a : (IBinder) invokeV.objValue;
        }
    }

    /* loaded from: classes10.dex */
    public static class f {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public String a;

        /* renamed from: b  reason: collision with root package name */
        public String f34596b;

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
                this.a = com.baidu.helios.ids.gaid.c.a(c.a.r.j.d.a.b());
                this.f34596b = com.baidu.helios.ids.gaid.c.a(c.a.r.j.d.a.c());
            } catch (Exception unused) {
            }
        }

        public /* synthetic */ f(a aVar) {
            this();
        }

        public final String a() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.a : (String) invokeV.objValue;
        }

        public final String c() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.f34596b : (String) invokeV.objValue;
        }
    }

    /* loaded from: classes10.dex */
    public class g extends Handler {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ GaidProvider a;

        /* loaded from: classes10.dex */
        public class a implements Runnable {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: e  reason: collision with root package name */
            public final /* synthetic */ g f34597e;

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
                this.f34597e = gVar;
            }

            @Override // java.lang.Runnable
            public void run() {
                Interceptable interceptable = $ic;
                if (!(interceptable == null || interceptable.invokeV(1048576, this) == null) || this.f34597e.a.f34579g.a.get()) {
                    return;
                }
                this.f34597e.a.f34579g.a.set(true);
                this.f34597e.a.i();
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
            this.a = gaidProvider;
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, message) == null) && message.what == 0) {
                this.a.f5116b.f5120d.submit(new a(this));
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
        this.f34577e = new c(this);
        this.f34580h = new ArrayList();
    }

    @Override // c.a.r.j.a
    public String c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.f34577e.a() : (String) invokeV.objValue;
    }

    @Override // c.a.r.j.a
    public void f(a.b bVar) {
        String a2;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, bVar) == null) {
            b bVar2 = new b(this);
            this.f34579g = bVar2;
            this.f34576d = this.a.f(Config.GAID);
            Context context = this.f5116b.a;
            this.f34578f = new f(null);
            PackageManager packageManager = context.getPackageManager();
            try {
                a2 = this.f34578f.a();
            } catch (PackageManager.NameNotFoundException unused) {
            }
            if (a2 == null) {
                bVar2.a.set(true);
                return;
            }
            packageManager.getPackageInfo(a2, 0);
            this.f34577e.h();
            long currentTimeMillis = System.currentTimeMillis();
            if (Math.abs(currentTimeMillis - this.f34577e.d()) > 604800000) {
                this.f34577e.e(currentTimeMillis);
                this.f34577e.g();
                try {
                    String c2 = this.f34578f.c();
                    if (c2 == null) {
                        bVar2.a.set(true);
                        return;
                    } else if (!context.bindService(new Intent(c2).setPackage(a2), new d(this), 1)) {
                        bVar2.a.set(true);
                        return;
                    } else {
                        g gVar = new g(this, Looper.getMainLooper());
                        this.f34581i = gVar;
                        gVar.sendEmptyMessageDelayed(0, 50000L);
                        return;
                    }
                } catch (Exception unused2) {
                    bVar2.a.set(true);
                    return;
                }
            }
            bVar2.a.set(true);
        }
    }

    @Override // c.a.r.j.a
    public void g(a.c<String> cVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, cVar) == null) {
            this.f5116b.f5120d.submit(new a(this, cVar));
        }
    }

    public void i() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
            for (a.c<String> cVar : this.f34580h) {
                j(cVar);
            }
            this.f34580h.clear();
        }
    }

    public final void j(a.c<String> cVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, cVar) == null) {
            Bundle bundle = new Bundle();
            if (TextUtils.isEmpty(this.f34577e.a())) {
                cVar.a(-1, null, bundle);
            } else {
                cVar.onResult(this.f34577e.a(), bundle);
            }
        }
    }
}
