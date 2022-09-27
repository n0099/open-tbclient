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
import android.util.Log;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.common.others.lang.StringUtil;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.helios.bridge.multiprocess.e;
import com.baidu.helios.bridge.multiprocess.f;
import com.baidu.tieba.f50;
import com.baidu.tieba.v20;
import com.baidu.tieba.z20;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes2.dex */
public class g extends v20 implements IBinder.DeathRecipient {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public ContentProviderClient c;
    public e d;
    public z20 e;
    public String f;

    public g(z20 z20Var, String str) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {z20Var, str};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.e = z20Var;
        this.f = str;
    }

    public static Bundle k(v20.d dVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65537, null, dVar)) == null) {
            Bundle bundle = new Bundle();
            bundle.putInt("errcode", dVar.b);
            bundle.putString("id", dVar.a);
            return bundle;
        }
        return (Bundle) invokeL.objValue;
    }

    public static v20.d l(Bundle bundle) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65538, null, bundle)) == null) ? new v20.d(bundle.getInt("errcode"), bundle.getString("id"), null) : (v20.d) invokeL.objValue;
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
            } catch (Exception e) {
                Log.e("Helios-mul", "parcel", e);
                return null;
            }
        }
        return (IBinder) invokeL.objValue;
    }

    @Override // com.baidu.tieba.v20
    public void a(String str, Bundle bundle, v20.c<String> cVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(1048576, this, str, bundle, cVar) == null) {
            try {
                this.d.a(str, bundle, new f.b(this, cVar) { // from class: com.baidu.helios.bridge.multiprocess.g.1
                    public static /* synthetic */ Interceptable $ic;
                    public transient /* synthetic */ FieldHolder $fh;
                    public final /* synthetic */ v20.c c;
                    public final /* synthetic */ g d;

                    {
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 != null) {
                            InitContext newInitContext = TitanRuntime.newInitContext();
                            newInitContext.initArgs = r2;
                            Object[] objArr = {this, cVar};
                            interceptable2.invokeUnInit(65536, newInitContext);
                            int i = newInitContext.flag;
                            if ((i & 1) != 0) {
                                int i2 = i & 2;
                                newInitContext.thisArg = this;
                                interceptable2.invokeInitBody(65536, newInitContext);
                                return;
                            }
                        }
                        this.d = this;
                        this.c = cVar;
                    }

                    @Override // com.baidu.helios.bridge.multiprocess.f
                    public void a(int i, Bundle bundle2) {
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 == null || interceptable2.invokeIL(1048576, this, i, bundle2) == null) {
                            this.c.a(i, null, bundle2);
                        }
                    }

                    @Override // com.baidu.helios.bridge.multiprocess.f
                    public void a(String str2, Bundle bundle2) {
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 == null || interceptable2.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str2, bundle2) == null) {
                            this.c.onResult(str2, bundle2);
                        }
                    }
                });
            } catch (RemoteException e) {
                e.printStackTrace();
            }
        }
    }

    @Override // android.os.IBinder.DeathRecipient
    public void binderDied() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            this.e.k();
        }
    }

    @Override // com.baidu.tieba.v20
    public void d() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            try {
                if (this.d != null) {
                    this.d.a();
                }
            } catch (RemoteException unused) {
            }
        }
    }

    @Override // com.baidu.tieba.v20
    public boolean e(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048579, this, str)) == null) {
            try {
                return this.d.a(str);
            } catch (RemoteException unused) {
                return false;
            }
        }
        return invokeL.booleanValue;
    }

    @Override // com.baidu.tieba.v20
    public void f(v20.b bVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, bVar) == null) {
            this.d = q(this.a.c);
        }
    }

    @Override // com.baidu.tieba.v20
    public v20.d g(String str, Bundle bundle) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048581, this, str, bundle)) == null) {
            try {
                Bundle a = this.d.a(str, bundle);
                if (a != null) {
                    return l(a);
                }
            } catch (RemoteException unused) {
            }
            return v20.d.a(-1, null);
        }
        return (v20.d) invokeLL.objValue;
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
            cursor = contentProviderClient.query(Uri.withAppendedPath(uri, "ipc/method/get_bridge"), null, null, null, null);
            try {
                Bundle extras = cursor.getExtras();
                f50.a(cursor);
                return extras;
            } catch (Exception unused) {
                f50.a(cursor);
                return null;
            } catch (Throwable th) {
                th = th;
                cursor2 = cursor;
                f50.a(cursor2);
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
            int i = 0;
            while (true) {
                if (i >= 2) {
                    break;
                }
                ContentProviderClient acquireContentProviderClient = z ? contentResolver.acquireContentProviderClient(uri) : contentResolver.acquireUnstableContentProviderClient(uri);
                if (acquireContentProviderClient != null && (bundle = i(acquireContentProviderClient, str)) == null) {
                    bundle = h(acquireContentProviderClient, uri);
                }
                if (bundle != null) {
                    this.c = acquireContentProviderClient;
                    break;
                }
                try {
                    Thread.sleep(20L);
                } catch (InterruptedException unused) {
                }
                i++;
            }
            return bundle;
        }
        return (Bundle) invokeCommon.objValue;
    }

    public final String m(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048585, this, context)) == null) {
            return context.getPackageName() + this.f;
        }
        return (String) invokeL.objValue;
    }

    public boolean o() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048586, this)) == null) ? this.d != null : invokeV.booleanValue;
    }

    public final e q(Context context) {
        InterceptResult invokeL;
        IBinder p;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048587, this, context)) == null) {
            Bundle j = j(context, false, Uri.parse("content://" + m(context)), "_method_get_bridge");
            StringBuilder sb = new StringBuilder();
            sb.append("remote bridge bundle result is ");
            sb.append(j);
            Log.i("Helios-mul", sb.toString() == null ? StringUtil.NULL_STRING : "non-null");
            if (j == null || (p = p(j)) == null) {
                return null;
            }
            return e.b.a(p);
        }
        return (e) invokeL.objValue;
    }
}
