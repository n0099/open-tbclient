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
import c.a.r.d.a;
import c.a.r.g.c.a.c;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.helios.bridge.multiprocess.e;
import com.baidu.helios.bridge.multiprocess.f;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes5.dex */
public class g extends a implements IBinder.DeathRecipient {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: g  reason: collision with root package name */
    public ContentProviderClient f40277g;

    /* renamed from: h  reason: collision with root package name */
    public e f40278h;

    /* renamed from: i  reason: collision with root package name */
    public c.a.r.d.d.b f40279i;

    /* renamed from: j  reason: collision with root package name */
    public String f40280j;

    public g(c.a.r.d.d.b bVar, String str) {
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
        this.f40279i = bVar;
        this.f40280j = str;
    }

    public static Bundle j(a.d dVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65537, null, dVar)) == null) {
            Bundle bundle = new Bundle();
            bundle.putInt("errcode", dVar.f29132b);
            bundle.putString("id", dVar.f29131a);
            return bundle;
        }
        return (Bundle) invokeL.objValue;
    }

    public static a.d k(Bundle bundle) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65538, null, bundle)) == null) ? new a.d(bundle.getInt("errcode"), bundle.getString("id"), null) : (a.d) invokeL.objValue;
    }

    public static void m(Bundle bundle, IBinder iBinder) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65539, null, bundle, iBinder) == null) {
            if (Build.VERSION.SDK_INT >= 18) {
                bundle.putBinder("bridge_binder", iBinder);
            } else {
                bundle.putParcelable("bridge_binder", new b(iBinder));
            }
        }
    }

    public static IBinder o(Bundle bundle) {
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

    @Override // c.a.r.d.a
    public void a(String str, Bundle bundle, a.c<String> cVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(1048576, this, str, bundle, cVar) == null) {
            try {
                this.f40278h.a(str, bundle, new f.a(this, cVar) { // from class: com.baidu.helios.bridge.multiprocess.g.1
                    public static /* synthetic */ Interceptable $ic;
                    public transient /* synthetic */ FieldHolder $fh;

                    /* renamed from: c  reason: collision with root package name */
                    public final /* synthetic */ a.c f40281c;

                    /* renamed from: d  reason: collision with root package name */
                    public final /* synthetic */ g f40282d;

                    {
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 != null) {
                            InitContext newInitContext = TitanRuntime.newInitContext();
                            newInitContext.initArgs = r2;
                            Object[] objArr = {this, cVar};
                            interceptable2.invokeUnInit(65536, newInitContext);
                            int i2 = newInitContext.flag;
                            if ((i2 & 1) != 0) {
                                int i3 = i2 & 2;
                                newInitContext.thisArg = this;
                                interceptable2.invokeInitBody(65536, newInitContext);
                                return;
                            }
                        }
                        this.f40282d = this;
                        this.f40281c = cVar;
                    }

                    @Override // com.baidu.helios.bridge.multiprocess.f
                    public void a(int i2, Bundle bundle2) {
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 == null || interceptable2.invokeIL(1048576, this, i2, bundle2) == null) {
                            this.f40281c.a(i2, null, bundle2);
                        }
                    }

                    @Override // com.baidu.helios.bridge.multiprocess.f
                    public void a(String str2, Bundle bundle2) {
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 == null || interceptable2.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str2, bundle2) == null) {
                            this.f40281c.onResult(str2, bundle2);
                        }
                    }
                });
            } catch (RemoteException e2) {
                e2.printStackTrace();
            }
        }
    }

    @Override // android.os.IBinder.DeathRecipient
    public void binderDied() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            this.f40279i.j();
        }
    }

    @Override // c.a.r.d.a
    public boolean d(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, str)) == null) {
            try {
                return this.f40278h.a(str);
            } catch (RemoteException unused) {
                return false;
            }
        }
        return invokeL.booleanValue;
    }

    @Override // c.a.r.d.a
    public void e(a.b bVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, bVar) == null) {
            this.f40278h = p(this.f29124e.f29128c);
        }
    }

    @Override // c.a.r.d.a
    public a.d f(String str, Bundle bundle) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048580, this, str, bundle)) == null) {
            try {
                Bundle a2 = this.f40278h.a(str, bundle);
                if (a2 != null) {
                    return k(a2);
                }
            } catch (RemoteException unused) {
            }
            return a.d.a(-1, null);
        }
        return (a.d) invokeLL.objValue;
    }

    public final Bundle g(ContentProviderClient contentProviderClient, Uri uri) {
        InterceptResult invokeLL;
        Cursor cursor;
        Interceptable interceptable = $ic;
        if (interceptable != null && (invokeLL = interceptable.invokeLL(1048581, this, contentProviderClient, uri)) != null) {
            return (Bundle) invokeLL.objValue;
        }
        Cursor cursor2 = null;
        try {
            cursor = contentProviderClient.query(Uri.withAppendedPath(uri, BaseIPCProvider.f40258a), null, null, null, null);
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

    public final Bundle h(ContentProviderClient contentProviderClient, String str) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048582, this, contentProviderClient, str)) == null) {
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

    public final Bundle i(Context context, boolean z, Uri uri, String str) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048583, this, new Object[]{context, Boolean.valueOf(z), uri, str})) == null) {
            ContentResolver contentResolver = context.getContentResolver();
            Bundle bundle = null;
            int i2 = 0;
            while (true) {
                if (i2 >= 2) {
                    break;
                }
                ContentProviderClient acquireContentProviderClient = z ? contentResolver.acquireContentProviderClient(uri) : contentResolver.acquireUnstableContentProviderClient(uri);
                if (acquireContentProviderClient != null && (bundle = h(acquireContentProviderClient, str)) == null) {
                    bundle = g(acquireContentProviderClient, uri);
                }
                if (bundle != null) {
                    this.f40277g = acquireContentProviderClient;
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

    public final String l(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, context)) == null) {
            return context.getPackageName() + this.f40280j;
        }
        return (String) invokeL.objValue;
    }

    public boolean n() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048585, this)) == null) ? this.f40278h != null : invokeV.booleanValue;
    }

    public final e p(Context context) {
        InterceptResult invokeL;
        IBinder o;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048586, this, context)) == null) {
            Bundle i2 = i(context, false, Uri.parse("content://" + l(context)), BaseIPCProvider.f40259b);
            String str = "remote bridge bundle result is " + i2;
            if (i2 == null || (o = o(i2)) == null) {
                return null;
            }
            return e.a.a(o);
        }
        return (e) invokeL.objValue;
    }
}
