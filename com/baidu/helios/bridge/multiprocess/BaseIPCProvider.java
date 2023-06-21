package com.baidu.helios.bridge.multiprocess;

import android.content.ContentProvider;
import android.content.ContentValues;
import android.content.UriMatcher;
import android.database.Cursor;
import android.net.Uri;
import android.os.Bundle;
import android.os.RemoteException;
import android.text.TextUtils;
import android.util.Log;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.helios.bridge.multiprocess.e;
import com.baidu.tieba.n30;
import com.baidu.tieba.s30;
import com.baidu.tieba.t30;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes3.dex */
public abstract class BaseIPCProvider extends ContentProvider {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public e a;
    public UriMatcher b;

    public BaseIPCProvider() {
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
        this.b = new UriMatcher(-1);
    }

    public final String a(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, str)) == null) {
            return str + c();
        }
        return (String) invokeL.objValue;
    }

    public final synchronized void b() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            synchronized (this) {
                if (this.a == null) {
                    this.a = new e.b(this) { // from class: com.baidu.helios.bridge.multiprocess.BaseIPCProvider.1
                        public static /* synthetic */ Interceptable $ic;
                        public transient /* synthetic */ FieldHolder $fh;
                        public final /* synthetic */ BaseIPCProvider a;
                        public t30 f;

                        /* renamed from: com.baidu.helios.bridge.multiprocess.BaseIPCProvider$1$a */
                        /* loaded from: classes3.dex */
                        public class a implements n30.c<String> {
                            public static /* synthetic */ Interceptable $ic;
                            public transient /* synthetic */ FieldHolder $fh;
                            public final /* synthetic */ f a;

                            public a(AnonymousClass1 anonymousClass1, f fVar) {
                                Interceptable interceptable = $ic;
                                if (interceptable != null) {
                                    InitContext newInitContext = TitanRuntime.newInitContext();
                                    newInitContext.initArgs = r2;
                                    Object[] objArr = {anonymousClass1, fVar};
                                    interceptable.invokeUnInit(65536, newInitContext);
                                    int i = newInitContext.flag;
                                    if ((i & 1) != 0) {
                                        int i2 = i & 2;
                                        newInitContext.thisArg = this;
                                        interceptable.invokeInitBody(65536, newInitContext);
                                        return;
                                    }
                                }
                                this.a = fVar;
                            }

                            @Override // com.baidu.tieba.n30.c
                            public void a(int i, Exception exc, Bundle bundle) {
                                Interceptable interceptable = $ic;
                                if (interceptable == null || interceptable.invokeILL(1048576, this, i, exc, bundle) == null) {
                                    try {
                                        this.a.a(i, bundle);
                                    } catch (RemoteException unused) {
                                    }
                                }
                            }

                            /* JADX DEBUG: Method merged with bridge method */
                            @Override // com.baidu.tieba.n30.c
                            /* renamed from: b */
                            public void onResult(String str, Bundle bundle) {
                                Interceptable interceptable = $ic;
                                if (interceptable == null || interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str, bundle) == null) {
                                    try {
                                        this.a.a(str, bundle);
                                    } catch (RemoteException unused) {
                                    }
                                }
                            }
                        }

                        {
                            Interceptable interceptable2 = $ic;
                            if (interceptable2 != null) {
                                InitContext newInitContext = TitanRuntime.newInitContext();
                                newInitContext.initArgs = r2;
                                Object[] objArr = {this};
                                interceptable2.invokeUnInit(65536, newInitContext);
                                int i = newInitContext.flag;
                                if ((i & 1) != 0) {
                                    int i2 = i & 2;
                                    newInitContext.thisArg = this;
                                    interceptable2.invokeInitBody(65536, newInitContext);
                                    return;
                                }
                            }
                            this.a = this;
                            this.f = new t30(this.a.getContext().getApplicationContext());
                        }

                        @Override // com.baidu.helios.bridge.multiprocess.e
                        public Bundle a(String str, Bundle bundle) {
                            InterceptResult invokeLL;
                            Interceptable interceptable2 = $ic;
                            if (interceptable2 == null || (invokeLL = interceptable2.invokeLL(1048576, this, str, bundle)) == null) {
                                n30.d g = this.f.a().g(str, bundle);
                                if (g == null) {
                                    return null;
                                }
                                return g.k(g);
                            }
                            return (Bundle) invokeLL.objValue;
                        }

                        @Override // com.baidu.helios.bridge.multiprocess.e
                        public void a() {
                            Interceptable interceptable2 = $ic;
                            if (interceptable2 == null || interceptable2.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
                                this.f.a().d();
                            }
                        }

                        @Override // com.baidu.helios.bridge.multiprocess.e
                        public void a(String str, Bundle bundle, f fVar) {
                            Interceptable interceptable2 = $ic;
                            if (interceptable2 == null || interceptable2.invokeLLL(Constants.METHOD_SEND_USER_MSG, this, str, bundle, fVar) == null) {
                                this.f.a().a(str, bundle, new a(this, fVar));
                            }
                        }

                        @Override // com.baidu.helios.bridge.multiprocess.e
                        public boolean a(String str) {
                            InterceptResult invokeL;
                            Interceptable interceptable2 = $ic;
                            return (interceptable2 == null || (invokeL = interceptable2.invokeL(1048579, this, str)) == null) ? this.f.a().e(str) : invokeL.booleanValue;
                        }
                    };
                }
            }
        }
    }

    public abstract String c();

    @Override // android.content.ContentProvider
    public Bundle call(String str, String str2, Bundle bundle) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(1048579, this, str, str2, bundle)) == null) {
            Log.i("Helios", "provider call");
            if (TextUtils.isEmpty(str)) {
                return null;
            }
            Bundle bundle2 = new Bundle();
            char c = 65535;
            if (str.hashCode() == -1722610639 && str.equals("_method_get_bridge")) {
                c = 0;
            }
            if (c != 0) {
                return null;
            }
            b();
            g.n(bundle2, this.a.asBinder());
            return bundle2;
        }
        return (Bundle) invokeLLL.objValue;
    }

    @Override // android.content.ContentProvider
    public int delete(Uri uri, String str, String[] strArr) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(1048580, this, uri, str, strArr)) == null) {
            return 0;
        }
        return invokeLLL.intValue;
    }

    @Override // android.content.ContentProvider
    public String getType(Uri uri) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048581, this, uri)) == null) {
            return null;
        }
        return (String) invokeL.objValue;
    }

    @Override // android.content.ContentProvider
    public Uri insert(Uri uri, ContentValues contentValues) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048582, this, uri, contentValues)) == null) {
            return null;
        }
        return (Uri) invokeLL.objValue;
    }

    @Override // android.content.ContentProvider
    public boolean onCreate() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) {
            this.b.addURI(a(getContext().getPackageName()), "ipc/method/get_bridge", 0);
            Log.i("Helios", "provider onCreate");
            return true;
        }
        return invokeV.booleanValue;
    }

    @Override // android.content.ContentProvider
    public Cursor query(Uri uri, String[] strArr, String str, String[] strArr2, String str2) {
        InterceptResult invokeLLLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLLLL = interceptable.invokeLLLLL(InputDeviceCompat.SOURCE_TOUCHPAD, this, uri, strArr, str, strArr2, str2)) == null) {
            int match = this.b.match(uri);
            Log.i("Helios", "provider query, code = " + match);
            if (match != 0) {
                return null;
            }
            b();
            Bundle bundle = new Bundle();
            g.n(bundle, this.a.asBinder());
            return new s30(bundle);
        }
        return (Cursor) invokeLLLLL.objValue;
    }

    @Override // android.content.ContentProvider
    public int update(Uri uri, ContentValues contentValues, String str, String[] strArr) {
        InterceptResult invokeLLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLLL = interceptable.invokeLLLL(1048585, this, uri, contentValues, str, strArr)) == null) {
            return 0;
        }
        return invokeLLLL.intValue;
    }
}
