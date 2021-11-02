package com.baidu.helios.bridge.multiprocess;

import android.content.ContentProvider;
import android.content.ContentValues;
import android.content.UriMatcher;
import android.database.Cursor;
import android.net.Uri;
import android.os.Bundle;
import android.os.RemoteException;
import android.text.TextUtils;
import b.a.r.d.a;
import b.a.r.d.d.c;
import b.a.r.d.d.d;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.helios.bridge.multiprocess.e;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes7.dex */
public abstract class BaseIPCProvider extends ContentProvider {
    public static /* synthetic */ Interceptable $ic = null;

    /* renamed from: a  reason: collision with root package name */
    public static final String f38439a = "ipc/method/get_bridge";

    /* renamed from: b  reason: collision with root package name */
    public static final String f38440b = "_method_get_bridge";

    /* renamed from: c  reason: collision with root package name */
    public static final String f38441c = "Helios";

    /* renamed from: f  reason: collision with root package name */
    public static final int f38442f = 0;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: d  reason: collision with root package name */
    public e f38443d;

    /* renamed from: e  reason: collision with root package name */
    public UriMatcher f38444e;

    public BaseIPCProvider() {
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
        this.f38444e = new UriMatcher(-1);
    }

    private String a(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65537, this, str)) == null) {
            return str + getAuthoritySuffix();
        }
        return (String) invokeL.objValue;
    }

    private synchronized void a() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65538, this) == null) {
            synchronized (this) {
                if (this.f38443d == null) {
                    this.f38443d = new e.a(this) { // from class: com.baidu.helios.bridge.multiprocess.BaseIPCProvider.1
                        public static /* synthetic */ Interceptable $ic;
                        public transient /* synthetic */ FieldHolder $fh;

                        /* renamed from: a  reason: collision with root package name */
                        public final /* synthetic */ BaseIPCProvider f38445a;

                        /* renamed from: e  reason: collision with root package name */
                        public d f38446e;

                        /* renamed from: com.baidu.helios.bridge.multiprocess.BaseIPCProvider$1$a */
                        /* loaded from: classes7.dex */
                        public class a implements a.c<String> {
                            public static /* synthetic */ Interceptable $ic;
                            public transient /* synthetic */ FieldHolder $fh;

                            /* renamed from: a  reason: collision with root package name */
                            public final /* synthetic */ f f38447a;

                            public a(AnonymousClass1 anonymousClass1, f fVar) {
                                Interceptable interceptable = $ic;
                                if (interceptable != null) {
                                    InitContext newInitContext = TitanRuntime.newInitContext();
                                    newInitContext.initArgs = r2;
                                    Object[] objArr = {anonymousClass1, fVar};
                                    interceptable.invokeUnInit(65536, newInitContext);
                                    int i2 = newInitContext.flag;
                                    if ((i2 & 1) != 0) {
                                        int i3 = i2 & 2;
                                        newInitContext.thisArg = this;
                                        interceptable.invokeInitBody(65536, newInitContext);
                                        return;
                                    }
                                }
                                this.f38447a = fVar;
                            }

                            @Override // b.a.r.d.a.c
                            public void a(int i2, Exception exc, Bundle bundle) {
                                Interceptable interceptable = $ic;
                                if (interceptable == null || interceptable.invokeILL(1048576, this, i2, exc, bundle) == null) {
                                    try {
                                        this.f38447a.a(i2, bundle);
                                    } catch (RemoteException unused) {
                                    }
                                }
                            }

                            /* JADX DEBUG: Method merged with bridge method */
                            @Override // b.a.r.d.a.c
                            /* renamed from: b */
                            public void onResult(String str, Bundle bundle) {
                                Interceptable interceptable = $ic;
                                if (interceptable == null || interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str, bundle) == null) {
                                    try {
                                        this.f38447a.a(str, bundle);
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
                                int i2 = newInitContext.flag;
                                if ((i2 & 1) != 0) {
                                    int i3 = i2 & 2;
                                    newInitContext.thisArg = this;
                                    interceptable2.invokeInitBody(65536, newInitContext);
                                    return;
                                }
                            }
                            this.f38445a = this;
                            this.f38446e = new d(this.f38445a.getContext().getApplicationContext());
                        }

                        @Override // com.baidu.helios.bridge.multiprocess.e
                        public Bundle a(String str, Bundle bundle) {
                            InterceptResult invokeLL;
                            Interceptable interceptable2 = $ic;
                            if (interceptable2 == null || (invokeLL = interceptable2.invokeLL(1048576, this, str, bundle)) == null) {
                                a.d f2 = this.f38446e.a().f(str, bundle);
                                if (f2 == null) {
                                    return null;
                                }
                                return g.j(f2);
                            }
                            return (Bundle) invokeLL.objValue;
                        }

                        @Override // com.baidu.helios.bridge.multiprocess.e
                        public void a(String str, Bundle bundle, f fVar) {
                            Interceptable interceptable2 = $ic;
                            if (interceptable2 == null || interceptable2.invokeLLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str, bundle, fVar) == null) {
                                this.f38446e.a().a(str, bundle, new a(this, fVar));
                            }
                        }

                        @Override // com.baidu.helios.bridge.multiprocess.e
                        public boolean a(String str) {
                            InterceptResult invokeL;
                            Interceptable interceptable2 = $ic;
                            return (interceptable2 == null || (invokeL = interceptable2.invokeL(Constants.METHOD_SEND_USER_MSG, this, str)) == null) ? this.f38446e.a().d(str) : invokeL.booleanValue;
                        }
                    };
                }
            }
        }
    }

    @Override // android.content.ContentProvider
    public Bundle call(String str, String str2, Bundle bundle) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(1048576, this, str, str2, bundle)) == null) {
            if (TextUtils.isEmpty(str)) {
                return null;
            }
            Bundle bundle2 = new Bundle();
            char c2 = 65535;
            if (str.hashCode() == -1722610639 && str.equals(f38440b)) {
                c2 = 0;
            }
            if (c2 != 0) {
                return null;
            }
            a();
            g.m(bundle2, this.f38443d.asBinder());
            return bundle2;
        }
        return (Bundle) invokeLLL.objValue;
    }

    @Override // android.content.ContentProvider
    public int delete(Uri uri, String str, String[] strArr) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, uri, str, strArr)) == null) {
            return 0;
        }
        return invokeLLL.intValue;
    }

    public abstract String getAuthoritySuffix();

    @Override // android.content.ContentProvider
    public String getType(Uri uri) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048579, this, uri)) == null) {
            return null;
        }
        return (String) invokeL.objValue;
    }

    @Override // android.content.ContentProvider
    public Uri insert(Uri uri, ContentValues contentValues) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048580, this, uri, contentValues)) == null) {
            return null;
        }
        return (Uri) invokeLL.objValue;
    }

    @Override // android.content.ContentProvider
    public boolean onCreate() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) {
            this.f38444e.addURI(a(getContext().getPackageName()), f38439a, 0);
            return true;
        }
        return invokeV.booleanValue;
    }

    @Override // android.content.ContentProvider
    public Cursor query(Uri uri, String[] strArr, String str, String[] strArr2, String str2) {
        InterceptResult invokeLLLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLLLL = interceptable.invokeLLLLL(1048582, this, uri, strArr, str, strArr2, str2)) == null) {
            int match = this.f38444e.match(uri);
            String str3 = "provider query, code = " + match;
            if (match != 0) {
                return null;
            }
            a();
            Bundle bundle = new Bundle();
            g.m(bundle, this.f38443d.asBinder());
            return new c(bundle);
        }
        return (Cursor) invokeLLLLL.objValue;
    }

    @Override // android.content.ContentProvider
    public int update(Uri uri, ContentValues contentValues, String str, String[] strArr) {
        InterceptResult invokeLLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLLL = interceptable.invokeLLLL(1048583, this, uri, contentValues, str, strArr)) == null) {
            return 0;
        }
        return invokeLLLL.intValue;
    }
}
