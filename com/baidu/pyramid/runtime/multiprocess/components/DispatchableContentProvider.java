package com.baidu.pyramid.runtime.multiprocess.components;

import android.content.ContentProvider;
import android.content.ContentProviderOperation;
import android.content.ContentProviderResult;
import android.content.ContentValues;
import android.content.Context;
import android.content.OperationApplicationException;
import android.content.UriMatcher;
import android.content.pm.ProviderInfo;
import android.content.res.AssetFileDescriptor;
import android.content.res.Configuration;
import android.database.Cursor;
import android.net.Uri;
import android.os.Bundle;
import android.os.CancellationSignal;
import android.os.ParcelFileDescriptor;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tieba.cf1;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
/* loaded from: classes2.dex */
public abstract class DispatchableContentProvider extends ContentProvider {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public a a;
    public ArrayList<cf1> b;
    public String c;
    public volatile boolean d;
    public final Object e;

    /* loaded from: classes2.dex */
    public static class a extends UriMatcher {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public int a;
        public int b;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public a(int i) {
            super(i);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {Integer.valueOf(i)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    super(((Integer) newInitContext.callArgs[0]).intValue());
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
        }

        public final void a(int i) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeI(1048576, this, i) == null) {
                if (i < this.b || i > this.a) {
                    throw new IllegalArgumentException("The minCode is : " + this.b + "The maxCode is : " + this.a + "The error code is : " + i);
                }
            }
        }

        @Override // android.content.UriMatcher
        public void addURI(String str, String str2, int i) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLLI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str, str2, i) == null) {
                a(i);
                super.addURI(str, str2, i);
            }
        }
    }

    public DispatchableContentProvider() {
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
        this.d = false;
        this.e = new Object();
    }

    public final cf1 a(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048576, this, i)) == null) {
            int size = this.b.size() - 1;
            int i2 = 0;
            while (i2 <= size) {
                int i3 = (i2 + size) / 2;
                cf1 cf1Var = this.b.get(i3);
                if (i >= cf1Var.h() && i <= cf1Var.g()) {
                    return cf1Var;
                }
                if (i < cf1Var.h()) {
                    size = i3 - 1;
                } else {
                    i2 = i3 + 1;
                }
            }
            return null;
        }
        return (cf1) invokeI.objValue;
    }

    @Override // android.content.ContentProvider
    public ContentProviderResult[] applyBatch(ArrayList<ContentProviderOperation> arrayList) throws OperationApplicationException {
        InterceptResult invokeL;
        cf1 a2;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, arrayList)) == null) {
            d();
            if (arrayList == null) {
                return null;
            }
            HashMap hashMap = new HashMap();
            Iterator<ContentProviderOperation> it = arrayList.iterator();
            while (it.hasNext()) {
                ContentProviderOperation next = it.next();
                Uri uri = next.getUri();
                if (uri != null && (a2 = a(this.a.match(uri))) != null) {
                    a2.e(uri, 0);
                    ArrayList arrayList2 = (ArrayList) hashMap.get(a2);
                    if (arrayList2 == null) {
                        arrayList2 = new ArrayList();
                        hashMap.put(a2, arrayList2);
                    }
                    arrayList2.add(next);
                }
            }
            ArrayList arrayList3 = new ArrayList();
            for (Map.Entry entry : hashMap.entrySet()) {
                for (ContentProviderResult contentProviderResult : ((cf1) entry.getKey()).a((ArrayList) entry.getValue())) {
                    arrayList3.add(contentProviderResult);
                }
            }
            if (arrayList3.size() > 0) {
                ContentProviderResult[] contentProviderResultArr = new ContentProviderResult[arrayList3.size()];
                arrayList3.toArray(contentProviderResultArr);
                return contentProviderResultArr;
            }
            return super.applyBatch(arrayList);
        }
        return (ContentProviderResult[]) invokeL.objValue;
    }

    @Override // android.content.ContentProvider
    public void attachInfo(Context context, ProviderInfo providerInfo) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(Constants.METHOD_SEND_USER_MSG, this, context, providerInfo) == null) {
            d();
            Iterator<cf1> it = this.b.iterator();
            while (it.hasNext()) {
                it.next().b(this);
            }
            super.attachInfo(context, providerInfo);
        }
    }

    public abstract String b();

    @Override // android.content.ContentProvider
    public int bulkInsert(Uri uri, ContentValues[] contentValuesArr) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048580, this, uri, contentValuesArr)) == null) {
            d();
            int match = this.a.match(uri);
            cf1 a2 = a(match);
            if (a2 != null) {
                a2.e(uri, 6);
                return a2.c(match, uri, contentValuesArr);
            }
            throw new IllegalArgumentException();
        }
        return invokeLL.intValue;
    }

    public abstract List<cf1> c();

    @Override // android.content.ContentProvider
    public Bundle call(String str, String str2, Bundle bundle) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(1048582, this, str, str2, bundle)) == null) {
            d();
            Iterator<cf1> it = this.b.iterator();
            while (it.hasNext()) {
                cf1 next = it.next();
                if (next.d(str, str2, bundle)) {
                    next.e(null, 3);
                    return next.call(str, str2, bundle);
                }
            }
            return null;
        }
        return (Bundle) invokeLLL.objValue;
    }

    public final void d() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048583, this) == null) || this.d) {
            return;
        }
        synchronized (this.e) {
            if (this.d) {
                return;
            }
            this.d = true;
            String b = b();
            this.c = b;
            if (b != null) {
                this.a = new a(-1);
                this.b = new ArrayList<>();
                List<cf1> c = c();
                if (c != null) {
                    for (cf1 cf1Var : c) {
                        e(cf1Var);
                        this.a.b = cf1Var.h();
                        this.a.a = cf1Var.g();
                        cf1Var.f(this.a, this.c);
                    }
                }
                Iterator<cf1> it = this.b.iterator();
                while (it.hasNext()) {
                    it.next().j();
                }
                return;
            }
            throw new IllegalStateException();
        }
    }

    @Override // android.content.ContentProvider
    public int delete(Uri uri, String str, String[] strArr) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(InputDeviceCompat.SOURCE_TOUCHPAD, this, uri, str, strArr)) == null) {
            d();
            int match = this.a.match(uri);
            cf1 a2 = a(match);
            if (a2 != null) {
                a2.e(uri, 5);
                return a2.delete(match, uri, str, strArr);
            }
            throw new IllegalArgumentException();
        }
        return invokeLLL.intValue;
    }

    public final void e(cf1 cf1Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048585, this, cf1Var) == null) {
            if (cf1Var.h() <= cf1Var.g()) {
                int size = this.b.size();
                int i = 0;
                for (int i2 = 0; i2 < size; i2++) {
                    if (cf1Var.h() > this.b.get(i2).g()) {
                        i = i2 + 1;
                    }
                }
                if (i < size - 1 && cf1Var.g() >= this.b.get(i).h()) {
                    throw new IllegalArgumentException();
                }
                this.b.add(i, cf1Var);
                return;
            }
            throw new IllegalArgumentException();
        }
    }

    @Override // android.content.ContentProvider
    public String getType(Uri uri) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048586, this, uri)) == null) {
            d();
            int match = this.a.match(uri);
            cf1 a2 = a(match);
            if (a2 != null) {
                a2.e(uri, 4);
                return a2.getType(match, uri);
            }
            throw new IllegalArgumentException();
        }
        return (String) invokeL.objValue;
    }

    @Override // android.content.ContentProvider
    public Uri insert(Uri uri, ContentValues contentValues) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048587, this, uri, contentValues)) == null) {
            d();
            int match = this.a.match(uri);
            cf1 a2 = a(match);
            if (a2 != null) {
                a2.e(uri, 1);
                return a2.insert(match, uri, contentValues);
            }
            throw new IllegalArgumentException();
        }
        return (Uri) invokeLL.objValue;
    }

    @Override // android.content.ContentProvider, android.content.ComponentCallbacks
    public void onConfigurationChanged(Configuration configuration) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048588, this, configuration) == null) {
            d();
            super.onConfigurationChanged(configuration);
            Iterator<cf1> it = this.b.iterator();
            while (it.hasNext()) {
                it.next().i(configuration);
            }
        }
    }

    @Override // android.content.ContentProvider
    public boolean onCreate() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048589, this)) == null) {
            return true;
        }
        return invokeV.booleanValue;
    }

    @Override // android.content.ContentProvider
    public AssetFileDescriptor openAssetFile(Uri uri, String str) throws FileNotFoundException {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048590, this, uri, str)) == null) {
            d();
            int match = this.a.match(uri);
            cf1 a2 = a(match);
            if (a2 != null) {
                a2.e(uri, 7);
                a2.k(match, uri, str);
                throw null;
            }
            throw new IllegalArgumentException();
        }
        return (AssetFileDescriptor) invokeLL.objValue;
    }

    @Override // android.content.ContentProvider
    public ParcelFileDescriptor openFile(Uri uri, String str) throws FileNotFoundException {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048592, this, uri, str)) == null) {
            d();
            int match = this.a.match(uri);
            cf1 a2 = a(match);
            if (a2 != null) {
                a2.m(match, uri, str);
                throw null;
            }
            throw new IllegalArgumentException();
        }
        return (ParcelFileDescriptor) invokeLL.objValue;
    }

    @Override // android.content.ContentProvider
    public Cursor query(Uri uri, String[] strArr, String str, String[] strArr2, String str2) {
        InterceptResult invokeLLLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLLLL = interceptable.invokeLLLLL(1048593, this, uri, strArr, str, strArr2, str2)) == null) {
            d();
            int match = this.a.match(uri);
            cf1 a2 = a(match);
            if (a2 != null) {
                a2.e(uri, 0);
                return a2.query(match, uri, strArr, str, strArr2, str2);
            }
            throw new IllegalArgumentException();
        }
        return (Cursor) invokeLLLLL.objValue;
    }

    @Override // android.content.ContentProvider
    public int update(Uri uri, ContentValues contentValues, String str, String[] strArr) {
        InterceptResult invokeLLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLLL = interceptable.invokeLLLL(1048595, this, uri, contentValues, str, strArr)) == null) {
            d();
            int match = this.a.match(uri);
            cf1 a2 = a(match);
            if (a2 != null) {
                a2.e(uri, 2);
                return a2.update(match, uri, contentValues, str, strArr);
            }
            throw new IllegalArgumentException();
        }
        return invokeLLLL.intValue;
    }

    @Override // android.content.ContentProvider
    public AssetFileDescriptor openAssetFile(Uri uri, String str, CancellationSignal cancellationSignal) throws FileNotFoundException {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(1048591, this, uri, str, cancellationSignal)) == null) {
            d();
            int match = this.a.match(uri);
            cf1 a2 = a(match);
            if (a2 != null) {
                a2.e(uri, 7);
                a2.l(match, uri, str, cancellationSignal);
                throw null;
            }
            throw new IllegalArgumentException();
        }
        return (AssetFileDescriptor) invokeLLL.objValue;
    }

    @Override // android.content.ContentProvider
    public Cursor query(Uri uri, String[] strArr, String str, String[] strArr2, String str2, CancellationSignal cancellationSignal) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048594, this, new Object[]{uri, strArr, str, strArr2, str2, cancellationSignal})) == null) {
            d();
            int match = this.a.match(uri);
            cf1 a2 = a(match);
            if (a2 != null) {
                a2.e(uri, 0);
                return a2.query(match, uri, strArr, str, strArr2, str2, cancellationSignal);
            }
            throw new IllegalArgumentException();
        }
        return (Cursor) invokeCommon.objValue;
    }
}
