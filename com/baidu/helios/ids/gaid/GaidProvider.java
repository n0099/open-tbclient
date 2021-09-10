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
import c.a.r.g.d.a;
import c.a.r.h.a;
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
/* loaded from: classes5.dex */
public class GaidProvider extends c.a.r.h.a {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: d  reason: collision with root package name */
    public a.C0737a f40539d;

    /* renamed from: e  reason: collision with root package name */
    public c f40540e;

    /* renamed from: f  reason: collision with root package name */
    public f f40541f;

    /* renamed from: g  reason: collision with root package name */
    public b f40542g;

    /* renamed from: h  reason: collision with root package name */
    public List<a.d<String>> f40543h;

    /* renamed from: i  reason: collision with root package name */
    public g f40544i;

    /* loaded from: classes5.dex */
    public class a implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ a.d f40545e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ GaidProvider f40546f;

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
            this.f40546f = gaidProvider;
            this.f40545e = dVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                if (this.f40546f.f40542g.f40547a.get()) {
                    this.f40546f.j(this.f40545e);
                } else {
                    this.f40546f.f40543h.add(this.f40545e);
                }
            }
        }
    }

    /* loaded from: classes5.dex */
    public class b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public AtomicBoolean f40547a;

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
            this.f40547a = new AtomicBoolean(false);
        }
    }

    /* loaded from: classes5.dex */
    public class c {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public long f40548a;

        /* renamed from: b  reason: collision with root package name */
        public boolean f40549b;

        /* renamed from: c  reason: collision with root package name */
        public c.a.r.g.c.a.e f40550c;

        /* renamed from: d  reason: collision with root package name */
        public String f40551d;

        /* renamed from: e  reason: collision with root package name */
        public ArrayList<String> f40552e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ GaidProvider f40553f;

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
            this.f40553f = gaidProvider;
            this.f40549b = true;
            this.f40550c = new c.a.r.g.c.a.e();
            this.f40552e = new ArrayList<>();
        }

        public String a() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.f40551d : (String) invokeV.objValue;
        }

        public void b(long j2, long j3) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeCommon(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, new Object[]{Long.valueOf(j2), Long.valueOf(j3)}) == null) && this.f40550c.c(j2, j3)) {
                this.f40549b = true;
            }
        }

        public void c(String str) {
            String str2;
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, str) == null) || (str2 = this.f40551d) == str) {
                return;
            }
            if (str == null || !str.equals(str2)) {
                this.f40551d = str;
                this.f40549b = true;
            }
        }

        public long d() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? this.f40548a : invokeV.longValue;
        }

        public void e(long j2) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeJ(1048580, this, j2) == null) || this.f40548a == j2) {
                return;
            }
            this.f40548a = j2;
            this.f40549b = true;
        }

        public void f(String str) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048581, this, str) == null) || this.f40552e.contains(str)) {
                return;
            }
            this.f40552e.add(str);
            this.f40549b = true;
        }

        public boolean g() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) {
                String g2 = this.f40553f.f40539d.g("cache.dat", true);
                if (!TextUtils.isEmpty(g2)) {
                    try {
                        JSONObject jSONObject = new JSONObject(g2);
                        this.f40551d = jSONObject.optString("form_id");
                        this.f40548a = jSONObject.getLong("lst_fe_ts");
                        jSONObject.getInt("c_form_ver");
                        this.f40550c.b(jSONObject.getLong("flags"));
                        this.f40552e.clear();
                        JSONObject optJSONObject = jSONObject.optJSONObject("his_form_ids");
                        if (optJSONObject != null) {
                            int i2 = optJSONObject.getInt("count");
                            for (int i3 = 0; i3 < i2; i3++) {
                                String string = optJSONObject.getString("id_" + i3);
                                if (TextUtils.isEmpty(string)) {
                                    this.f40552e.clear();
                                    return false;
                                }
                                this.f40552e.add(string);
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
                if (this.f40549b) {
                    try {
                        JSONObject jSONObject = new JSONObject();
                        jSONObject.put("form_id", this.f40551d);
                        jSONObject.put("lst_fe_ts", this.f40548a);
                        jSONObject.put("c_form_ver", 1);
                        jSONObject.put("flags", this.f40550c.d());
                        int size = this.f40552e.size();
                        if (size > 0) {
                            int min = Math.min(size, 5);
                            JSONObject jSONObject2 = new JSONObject();
                            jSONObject.put("his_form_ids", jSONObject2);
                            jSONObject2.put("count", min);
                            for (int i2 = 0; i2 < min; i2++) {
                                jSONObject2.put("id_" + i2, this.f40552e.get((size - min) + i2));
                            }
                        }
                        this.f40553f.f40539d.i("cache.dat", jSONObject.toString(), true);
                        this.f40549b = false;
                        return true;
                    } catch (Exception unused) {
                    }
                }
                return false;
            }
            return invokeV.booleanValue;
        }
    }

    /* loaded from: classes5.dex */
    public static class d implements IInterface {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public IBinder f40554a;

        /* renamed from: b  reason: collision with root package name */
        public String f40555b;

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
            this.f40554a = iBinder;
            try {
                this.f40555b = com.baidu.helios.ids.gaid.c.a(c.a.r.h.d.a.c());
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
                    obtain.writeInterfaceToken(this.f40555b);
                    this.f40554a.transact(1, obtain, obtain2, 0);
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
                    obtain.writeInterfaceToken(this.f40555b);
                    obtain.writeInt(z ? 1 : 0);
                    this.f40554a.transact(2, obtain, obtain2, 0);
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
            return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? this.f40554a : (IBinder) invokeV.objValue;
        }
    }

    /* loaded from: classes5.dex */
    public class e implements ServiceConnection {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ GaidProvider f40556e;

        /* loaded from: classes5.dex */
        public class a implements Runnable {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: e  reason: collision with root package name */
            public final /* synthetic */ IBinder f40557e;

            /* renamed from: f  reason: collision with root package name */
            public final /* synthetic */ e f40558f;

            /* renamed from: com.baidu.helios.ids.gaid.GaidProvider$e$a$a  reason: collision with other inner class name */
            /* loaded from: classes5.dex */
            public class RunnableC1658a implements Runnable {
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;

                /* renamed from: e  reason: collision with root package name */
                public final /* synthetic */ String f40559e;

                /* renamed from: f  reason: collision with root package name */
                public final /* synthetic */ boolean f40560f;

                /* renamed from: g  reason: collision with root package name */
                public final /* synthetic */ a f40561g;

                public RunnableC1658a(a aVar, String str, boolean z) {
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
                    this.f40561g = aVar;
                    this.f40559e = str;
                    this.f40560f = z;
                }

                @Override // java.lang.Runnable
                public void run() {
                    Interceptable interceptable = $ic;
                    if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                        if (!this.f40561g.f40558f.f40556e.f40542g.f40547a.get()) {
                            this.f40561g.f40558f.f40556e.i();
                            this.f40561g.f40558f.f40556e.f40542g.f40547a.set(true);
                        }
                        this.f40561g.f40558f.f40556e.f40540e.b(this.f40560f ? 1L : 2L, 3L);
                        if (!TextUtils.isEmpty(this.f40559e)) {
                            try {
                                String b2 = c.a.r.h.a.b("A20", new c.a.r.g.c.a.b("ABCDEFGHIJKLMNOPQRSTUVWXYZ234567=", false, false).b(this.f40559e.getBytes("UTF-8")));
                                this.f40561g.f40558f.f40556e.f40540e.c(b2);
                                this.f40561g.f40558f.f40556e.f40540e.f(b2);
                            } catch (Exception unused) {
                            }
                        }
                        this.f40561g.f40558f.f40556e.f40540e.h();
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
                this.f40558f = eVar;
                this.f40557e = iBinder;
            }

            @Override // java.lang.Runnable
            public void run() {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                    try {
                        d dVar = new d(this.f40557e);
                        String a2 = dVar.a();
                        boolean a3 = dVar.a(false);
                        if (this.f40558f.f40556e.f40544i != null) {
                            this.f40558f.f40556e.f40544i.removeMessages(0);
                        }
                        this.f40558f.f40556e.f15446b.f15453d.submit(new RunnableC1658a(this, a2, a3));
                        this.f40558f.f40556e.f15446b.f15450a.unbindService(this.f40558f);
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
            this.f40556e = gaidProvider;
        }

        @Override // android.content.ServiceConnection
        public void onServiceConnected(ComponentName componentName, IBinder iBinder) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(1048576, this, componentName, iBinder) == null) {
                this.f40556e.f15446b.f15454e.submit(new a(this, iBinder));
            }
        }

        @Override // android.content.ServiceConnection
        public void onServiceDisconnected(ComponentName componentName) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, componentName) == null) {
            }
        }
    }

    /* loaded from: classes5.dex */
    public static class f {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public String f40562a;

        /* renamed from: b  reason: collision with root package name */
        public String f40563b;

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
                this.f40562a = com.baidu.helios.ids.gaid.c.a(c.a.r.h.d.a.a());
                this.f40563b = com.baidu.helios.ids.gaid.c.a(c.a.r.h.d.a.b());
            } catch (Exception unused) {
            }
        }

        public /* synthetic */ f(a aVar) {
            this();
        }

        public final String a() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.f40562a : (String) invokeV.objValue;
        }

        public final String c() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.f40563b : (String) invokeV.objValue;
        }
    }

    /* loaded from: classes5.dex */
    public class g extends Handler {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ GaidProvider f40564a;

        /* loaded from: classes5.dex */
        public class a implements Runnable {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: e  reason: collision with root package name */
            public final /* synthetic */ g f40565e;

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
                this.f40565e = gVar;
            }

            @Override // java.lang.Runnable
            public void run() {
                Interceptable interceptable = $ic;
                if (!(interceptable == null || interceptable.invokeV(1048576, this) == null) || this.f40565e.f40564a.f40542g.f40547a.get()) {
                    return;
                }
                this.f40565e.f40564a.f40542g.f40547a.set(true);
                this.f40565e.f40564a.i();
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
            this.f40564a = gaidProvider;
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, message) == null) && message.what == 0) {
                this.f40564a.f15446b.f15453d.submit(new a(this));
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
        this.f40540e = new c(this);
        this.f40543h = new ArrayList();
    }

    @Override // c.a.r.h.a
    public String c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.f40540e.a() : (String) invokeV.objValue;
    }

    @Override // c.a.r.h.a
    public void f(a.c cVar) {
        String a2;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, cVar) == null) {
            b bVar = new b(this);
            this.f40542g = bVar;
            this.f40539d = this.f15445a.f(Config.GAID);
            Context context = this.f15446b.f15450a;
            this.f40541f = new f(null);
            PackageManager packageManager = context.getPackageManager();
            try {
                a2 = this.f40541f.a();
            } catch (PackageManager.NameNotFoundException unused) {
            }
            if (a2 == null) {
                bVar.f40547a.set(true);
                return;
            }
            packageManager.getPackageInfo(a2, 0);
            this.f40540e.g();
            long currentTimeMillis = System.currentTimeMillis();
            if (Math.abs(currentTimeMillis - this.f40540e.d()) > 604800000) {
                this.f40540e.e(currentTimeMillis);
                this.f40540e.h();
                try {
                    String c2 = this.f40541f.c();
                    if (c2 == null) {
                        bVar.f40547a.set(true);
                        return;
                    } else if (!context.bindService(new Intent(c2).setPackage(a2), new e(this), 1)) {
                        bVar.f40547a.set(true);
                        return;
                    } else {
                        g gVar = new g(this, Looper.getMainLooper());
                        this.f40544i = gVar;
                        gVar.sendEmptyMessageDelayed(0, 50000L);
                        return;
                    }
                } catch (Exception unused2) {
                    bVar.f40547a.set(true);
                    return;
                }
            }
            bVar.f40547a.set(true);
        }
    }

    @Override // c.a.r.h.a
    public void g(a.d<String> dVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, dVar) == null) {
            this.f15446b.f15453d.submit(new a(this, dVar));
        }
    }

    public void i() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
            for (a.d<String> dVar : this.f40543h) {
                j(dVar);
            }
            this.f40543h.clear();
        }
    }

    public final void j(a.d<String> dVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, dVar) == null) {
            Bundle bundle = new Bundle();
            if (TextUtils.isEmpty(this.f40540e.a())) {
                dVar.a(-1, null, bundle);
            } else {
                dVar.onResult(this.f40540e.a(), bundle);
            }
        }
    }
}
