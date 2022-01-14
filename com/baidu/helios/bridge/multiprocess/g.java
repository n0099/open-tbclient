package com.baidu.helios.bridge.multiprocess;

import android.content.ContentProviderClient;
import android.content.ContentResolver;
import android.content.Context;
import android.database.Cursor;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.os.IBinder;
import android.os.RemoteException;
import androidx.core.view.InputDeviceCompat;
import c.a.r.e.a;
import c.a.r.h.c.a.c;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.helios.bridge.multiprocess.e;
import com.baidu.helios.bridge.multiprocess.f;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes10.dex */
public class g extends c.a.r.e.a implements IBinder.DeathRecipient {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: g  reason: collision with root package name */
    public ContentProviderClient f34511g;

    /* renamed from: h  reason: collision with root package name */
    public e f34512h;

    /* renamed from: i  reason: collision with root package name */
    public c.a.r.e.d.b f34513i;

    /* renamed from: j  reason: collision with root package name */
    public String f34514j;

    /* loaded from: classes10.dex */
    public class a extends f.b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: d  reason: collision with root package name */
        public final /* synthetic */ a.c f34515d;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ g f34516e;

        public a(g gVar, a.c cVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {gVar, cVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f34516e = gVar;
            this.f34515d = cVar;
        }

        @Override // com.baidu.helios.bridge.multiprocess.f
        public void a(int i2, Bundle bundle) throws RemoteException {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeIL(1048576, this, i2, bundle) == null) {
                this.f34515d.a(i2, null, bundle);
            }
        }

        @Override // com.baidu.helios.bridge.multiprocess.f
        public void b(String str, Bundle bundle) throws RemoteException {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str, bundle) == null) {
                this.f34515d.onResult(str, bundle);
            }
        }
    }

    public g(c.a.r.e.d.b bVar, String str) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {bVar, str};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f34513i = bVar;
        this.f34514j = str;
    }

    public static Bundle k(a.d dVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65537, null, dVar)) == null) {
            Bundle bundle = new Bundle();
            bundle.putInt("errcode", dVar.f4778b);
            bundle.putString("id", dVar.a);
            return bundle;
        }
        return (Bundle) invokeL.objValue;
    }

    public static a.d l(Bundle bundle) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65538, null, bundle)) == null) ? new a.d(bundle.getInt("errcode"), bundle.getString("id"), null) : (a.d) invokeL.objValue;
    }

    public static void n(Bundle bundle, IBinder iBinder) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65539, null, bundle, iBinder) == null) {
            if (Build.VERSION.SDK_INT >= 18) {
                bundle.putBinder("bridge_binder", iBinder);
            } else {
                bundle.putParcelable("bridge_binder", new b(iBinder));
            }
        }
    }

    public static IBinder p(Bundle bundle) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(InputDeviceCompat.SOURCE_TRACKBALL, null, bundle)) == null) {
            if (Build.VERSION.SDK_INT >= 18) {
                return bundle.getBinder("bridge_binder");
            }
            try {
                bundle.setClassLoader(b.class.getClassLoader());
                return ((b) bundle.getParcelable("bridge_binder")).a();
            } catch (Exception unused) {
                return null;
            }
        }
        return (IBinder) invokeL.objValue;
    }

    @Override // c.a.r.e.a
    public void a(String str, Bundle bundle, a.c<String> cVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(1048576, this, str, bundle, cVar) == null) {
            try {
                this.f34512h.a(str, bundle, new a(this, cVar));
            } catch (RemoteException e2) {
                e2.printStackTrace();
            }
        }
    }

    @Override // android.os.IBinder.DeathRecipient
    public void binderDied() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            this.f34513i.k();
        }
    }

    @Override // c.a.r.e.a
    public void d() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            try {
                if (this.f34512h != null) {
                    this.f34512h.a();
                }
            } catch (RemoteException unused) {
            }
        }
    }

    @Override // c.a.r.e.a
    public boolean e(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048579, this, str)) == null) {
            try {
                return this.f34512h.a(str);
            } catch (RemoteException unused) {
                return false;
            }
        }
        return invokeL.booleanValue;
    }

    @Override // c.a.r.e.a
    public void f(a.b bVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, bVar) == null) {
            this.f34512h = m(this.f4772e.f4775c);
        }
    }

    @Override // c.a.r.e.a
    public a.d g(String str, Bundle bundle) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048581, this, str, bundle)) == null) {
            try {
                Bundle a2 = this.f34512h.a(str, bundle);
                if (a2 != null) {
                    return l(a2);
                }
            } catch (RemoteException unused) {
            }
            return a.d.a(-1, null);
        }
        return (a.d) invokeLL.objValue;
    }

    public final Bundle h(ContentProviderClient contentProviderClient, Uri uri) {
        InterceptResult invokeLL;
        Cursor cursor;
        Interceptable interceptable = $ic;
        if (interceptable != null && (invokeLL = interceptable.invokeLL(1048582, this, contentProviderClient, uri)) != null) {
            return (Bundle) invokeLL.objValue;
        }
        Cursor cursor2 = null;
        try {
            cursor = contentProviderClient.query(Uri.withAppendedPath(uri, BaseIPCProvider.f34497d), null, null, null, null);
            try {
                Bundle extras = cursor.getExtras();
                c.a(cursor);
                return extras;
            } catch (Exception unused) {
                c.a(cursor);
                return null;
            } catch (Throwable th) {
                th = th;
                cursor2 = cursor;
                c.a(cursor2);
                throw th;
            }
        } catch (Exception unused2) {
            cursor = null;
        } catch (Throwable th2) {
            th = th2;
        }
    }

    public final Bundle i(ContentProviderClient contentProviderClient, String str) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048583, this, contentProviderClient, str)) == null) {
            try {
                if (Build.VERSION.SDK_INT >= 17) {
                    return contentProviderClient.call(str, null, null);
                }
            } catch (Exception unused) {
            }
            return null;
        }
        return (Bundle) invokeLL.objValue;
    }

    public final Bundle j(Context context, boolean z, Uri uri, String str) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(InputDeviceCompat.SOURCE_TOUCHPAD, this, new Object[]{context, Boolean.valueOf(z), uri, str})) == null) {
            ContentResolver contentResolver = context.getContentResolver();
            Bundle bundle = null;
            int i2 = 0;
            while (true) {
                if (i2 >= 2) {
                    break;
                }
                ContentProviderClient acquireContentProviderClient = z ? contentResolver.acquireContentProviderClient(uri) : contentResolver.acquireUnstableContentProviderClient(uri);
                if (acquireContentProviderClient != null && (bundle = i(acquireContentProviderClient, str)) == null) {
                    bundle = h(acquireContentProviderClient, uri);
                }
                if (bundle != null) {
                    this.f34511g = acquireContentProviderClient;
                    break;
                }
                try {
                    Thread.sleep(20L);
                } catch (InterruptedException unused) {
                }
                i2++;
            }
            return bundle;
        }
        return (Bundle) invokeCommon.objValue;
    }

    public final e m(Context context) {
        InterceptResult invokeL;
        IBinder p;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048585, this, context)) == null) {
            Bundle j2 = j(context, false, Uri.parse("content://" + q(context)), BaseIPCProvider.f34499f);
            String str = "remote bridge bundle result is " + j2;
            if (j2 == null || (p = p(j2)) == null) {
                return null;
            }
            return e.b.a(p);
        }
        return (e) invokeL.objValue;
    }

    public boolean o() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048586, this)) == null) ? this.f34512h != null : invokeV.booleanValue;
    }

    public final String q(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048587, this, context)) == null) {
            return context.getPackageName() + this.f34514j;
        }
        return (String) invokeL.objValue;
    }
}
