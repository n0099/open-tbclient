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
/* loaded from: classes5.dex */
public abstract class DispatchableContentProvider extends ContentProvider {
    public static /* synthetic */ Interceptable $ic = null;
    public static final boolean DEBUG = false;
    public static final String TAG = "DispProvider";
    public transient /* synthetic */ FieldHolder $fh;
    public String mAuthority;
    public ArrayList<c.a.h0.b.a.i.a> mContentProviderDelegates;
    public final Object mInitLocker;
    public volatile boolean mIsInit;
    public a mUriMatcher;

    /* loaded from: classes5.dex */
    public static class a extends UriMatcher {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public int f44466a;

        /* renamed from: b  reason: collision with root package name */
        public int f44467b;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public a(int i2) {
            super(i2);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {Integer.valueOf(i2)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i3 = newInitContext.flag;
                if ((i3 & 1) != 0) {
                    int i4 = i3 & 2;
                    super(((Integer) newInitContext.callArgs[0]).intValue());
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
        }

        public final void a(int i2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeI(1048576, this, i2) == null) {
                if (i2 < this.f44467b || i2 > this.f44466a) {
                    throw new IllegalArgumentException("The minCode is : " + this.f44467b + "The maxCode is : " + this.f44466a + "The error code is : " + i2);
                }
            }
        }

        @Override // android.content.UriMatcher
        public void addURI(String str, String str2, int i2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLLI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str, str2, i2) == null) {
                a(i2);
                super.addURI(str, str2, i2);
            }
        }
    }

    public DispatchableContentProvider() {
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
        this.mIsInit = false;
        this.mInitLocker = new Object();
    }

    private c.a.h0.b.a.i.a findContentProviderDelegate(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(65537, this, i2)) == null) {
            int size = this.mContentProviderDelegates.size() - 1;
            int i3 = 0;
            while (i3 <= size) {
                int i4 = (i3 + size) / 2;
                c.a.h0.b.a.i.a aVar = this.mContentProviderDelegates.get(i4);
                if (i2 >= aVar.l() && i2 <= aVar.k()) {
                    return aVar;
                }
                if (i2 < aVar.l()) {
                    size = i4 - 1;
                } else {
                    i3 = i4 + 1;
                }
            }
            return null;
        }
        return (c.a.h0.b.a.i.a) invokeI.objValue;
    }

    private void initIfNeed() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(65538, this) == null) || this.mIsInit) {
            return;
        }
        synchronized (this.mInitLocker) {
            if (this.mIsInit) {
                return;
            }
            this.mIsInit = true;
            String authority = getAuthority();
            this.mAuthority = authority;
            if (authority != null) {
                this.mUriMatcher = new a(-1);
                this.mContentProviderDelegates = new ArrayList<>();
                List<c.a.h0.b.a.i.a> contentProviderDelegates = getContentProviderDelegates();
                if (contentProviderDelegates != null) {
                    for (c.a.h0.b.a.i.a aVar : contentProviderDelegates) {
                        insertContentProviderDelegate(aVar);
                        this.mUriMatcher.f44467b = aVar.l();
                        this.mUriMatcher.f44466a = aVar.k();
                        aVar.h(this.mUriMatcher, this.mAuthority);
                    }
                }
                Iterator<c.a.h0.b.a.i.a> it = this.mContentProviderDelegates.iterator();
                while (it.hasNext()) {
                    it.next().n();
                }
                return;
            }
            throw new IllegalStateException();
        }
    }

    private void insertContentProviderDelegate(c.a.h0.b.a.i.a aVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65539, this, aVar) == null) {
            if (aVar.l() <= aVar.k()) {
                int size = this.mContentProviderDelegates.size();
                int i2 = 0;
                for (int i3 = 0; i3 < size; i3++) {
                    if (aVar.l() > this.mContentProviderDelegates.get(i3).k()) {
                        i2 = i3 + 1;
                    }
                }
                if (i2 < size - 1 && aVar.k() >= this.mContentProviderDelegates.get(i2).l()) {
                    throw new IllegalArgumentException();
                }
                this.mContentProviderDelegates.add(i2, aVar);
                return;
            }
            throw new IllegalArgumentException();
        }
    }

    @Override // android.content.ContentProvider
    public ContentProviderResult[] applyBatch(ArrayList<ContentProviderOperation> arrayList) throws OperationApplicationException {
        InterceptResult invokeL;
        c.a.h0.b.a.i.a findContentProviderDelegate;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, arrayList)) == null) {
            initIfNeed();
            if (arrayList == null) {
                return null;
            }
            HashMap hashMap = new HashMap();
            Iterator<ContentProviderOperation> it = arrayList.iterator();
            while (it.hasNext()) {
                ContentProviderOperation next = it.next();
                Uri uri = next.getUri();
                if (uri != null && (findContentProviderDelegate = findContentProviderDelegate(this.mUriMatcher.match(uri))) != null) {
                    findContentProviderDelegate.g(uri, 0);
                    ArrayList arrayList2 = (ArrayList) hashMap.get(findContentProviderDelegate);
                    if (arrayList2 == null) {
                        arrayList2 = new ArrayList();
                        hashMap.put(findContentProviderDelegate, arrayList2);
                    }
                    arrayList2.add(next);
                }
            }
            ArrayList arrayList3 = new ArrayList();
            for (Map.Entry entry : hashMap.entrySet()) {
                for (ContentProviderResult contentProviderResult : ((c.a.h0.b.a.i.a) entry.getKey()).a((ArrayList) entry.getValue())) {
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
        if (interceptable == null || interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, context, providerInfo) == null) {
            initIfNeed();
            Iterator<c.a.h0.b.a.i.a> it = this.mContentProviderDelegates.iterator();
            while (it.hasNext()) {
                it.next().b(this);
            }
            super.attachInfo(context, providerInfo);
        }
    }

    @Override // android.content.ContentProvider
    public int bulkInsert(Uri uri, ContentValues[] contentValuesArr) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(Constants.METHOD_SEND_USER_MSG, this, uri, contentValuesArr)) == null) {
            initIfNeed();
            int match = this.mUriMatcher.match(uri);
            c.a.h0.b.a.i.a findContentProviderDelegate = findContentProviderDelegate(match);
            if (findContentProviderDelegate != null) {
                findContentProviderDelegate.g(uri, 6);
                return findContentProviderDelegate.c(match, uri, contentValuesArr);
            }
            throw new IllegalArgumentException();
        }
        return invokeLL.intValue;
    }

    @Override // android.content.ContentProvider
    public Bundle call(String str, String str2, Bundle bundle) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(1048579, this, str, str2, bundle)) == null) {
            initIfNeed();
            Iterator<c.a.h0.b.a.i.a> it = this.mContentProviderDelegates.iterator();
            while (it.hasNext()) {
                c.a.h0.b.a.i.a next = it.next();
                if (next.e(str, str2, bundle)) {
                    next.g(null, 3);
                    return next.d(str, str2, bundle);
                }
            }
            return null;
        }
        return (Bundle) invokeLLL.objValue;
    }

    @Override // android.content.ContentProvider
    public int delete(Uri uri, String str, String[] strArr) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(1048580, this, uri, str, strArr)) == null) {
            initIfNeed();
            int match = this.mUriMatcher.match(uri);
            c.a.h0.b.a.i.a findContentProviderDelegate = findContentProviderDelegate(match);
            if (findContentProviderDelegate != null) {
                findContentProviderDelegate.g(uri, 5);
                return findContentProviderDelegate.f(match, uri, str, strArr);
            }
            throw new IllegalArgumentException();
        }
        return invokeLLL.intValue;
    }

    public abstract String getAuthority();

    public abstract List<c.a.h0.b.a.i.a> getContentProviderDelegates();

    @Override // android.content.ContentProvider
    public String getType(Uri uri) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048583, this, uri)) == null) {
            initIfNeed();
            int match = this.mUriMatcher.match(uri);
            c.a.h0.b.a.i.a findContentProviderDelegate = findContentProviderDelegate(match);
            if (findContentProviderDelegate != null) {
                findContentProviderDelegate.g(uri, 4);
                return findContentProviderDelegate.i(match, uri);
            }
            throw new IllegalArgumentException();
        }
        return (String) invokeL.objValue;
    }

    @Override // android.content.ContentProvider
    public Uri insert(Uri uri, ContentValues contentValues) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(InputDeviceCompat.SOURCE_TOUCHPAD, this, uri, contentValues)) == null) {
            initIfNeed();
            int match = this.mUriMatcher.match(uri);
            c.a.h0.b.a.i.a findContentProviderDelegate = findContentProviderDelegate(match);
            if (findContentProviderDelegate != null) {
                findContentProviderDelegate.g(uri, 1);
                return findContentProviderDelegate.j(match, uri, contentValues);
            }
            throw new IllegalArgumentException();
        }
        return (Uri) invokeLL.objValue;
    }

    @Override // android.content.ContentProvider, android.content.ComponentCallbacks
    public void onConfigurationChanged(Configuration configuration) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048585, this, configuration) == null) {
            initIfNeed();
            super.onConfigurationChanged(configuration);
            Iterator<c.a.h0.b.a.i.a> it = this.mContentProviderDelegates.iterator();
            while (it.hasNext()) {
                it.next().m(configuration);
            }
        }
    }

    @Override // android.content.ContentProvider
    public boolean onCreate() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048586, this)) == null) {
            return true;
        }
        return invokeV.booleanValue;
    }

    @Override // android.content.ContentProvider
    public AssetFileDescriptor openAssetFile(Uri uri, String str) throws FileNotFoundException {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048587, this, uri, str)) == null) {
            initIfNeed();
            int match = this.mUriMatcher.match(uri);
            c.a.h0.b.a.i.a findContentProviderDelegate = findContentProviderDelegate(match);
            if (findContentProviderDelegate != null) {
                findContentProviderDelegate.g(uri, 7);
                findContentProviderDelegate.o(match, uri, str);
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
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048589, this, uri, str)) == null) {
            initIfNeed();
            int match = this.mUriMatcher.match(uri);
            c.a.h0.b.a.i.a findContentProviderDelegate = findContentProviderDelegate(match);
            if (findContentProviderDelegate != null) {
                findContentProviderDelegate.q(match, uri, str);
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
        if (interceptable == null || (invokeLLLLL = interceptable.invokeLLLLL(1048590, this, uri, strArr, str, strArr2, str2)) == null) {
            initIfNeed();
            int match = this.mUriMatcher.match(uri);
            c.a.h0.b.a.i.a findContentProviderDelegate = findContentProviderDelegate(match);
            if (findContentProviderDelegate != null) {
                findContentProviderDelegate.g(uri, 0);
                return findContentProviderDelegate.r(match, uri, strArr, str, strArr2, str2);
            }
            throw new IllegalArgumentException();
        }
        return (Cursor) invokeLLLLL.objValue;
    }

    @Override // android.content.ContentProvider
    public int update(Uri uri, ContentValues contentValues, String str, String[] strArr) {
        InterceptResult invokeLLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLLL = interceptable.invokeLLLL(1048592, this, uri, contentValues, str, strArr)) == null) {
            initIfNeed();
            int match = this.mUriMatcher.match(uri);
            c.a.h0.b.a.i.a findContentProviderDelegate = findContentProviderDelegate(match);
            if (findContentProviderDelegate != null) {
                findContentProviderDelegate.g(uri, 2);
                return findContentProviderDelegate.t(match, uri, contentValues, str, strArr);
            }
            throw new IllegalArgumentException();
        }
        return invokeLLLL.intValue;
    }

    @Override // android.content.ContentProvider
    public AssetFileDescriptor openAssetFile(Uri uri, String str, CancellationSignal cancellationSignal) throws FileNotFoundException {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(1048588, this, uri, str, cancellationSignal)) == null) {
            initIfNeed();
            int match = this.mUriMatcher.match(uri);
            c.a.h0.b.a.i.a findContentProviderDelegate = findContentProviderDelegate(match);
            if (findContentProviderDelegate != null) {
                findContentProviderDelegate.g(uri, 7);
                findContentProviderDelegate.p(match, uri, str, cancellationSignal);
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
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048591, this, new Object[]{uri, strArr, str, strArr2, str2, cancellationSignal})) == null) {
            initIfNeed();
            int match = this.mUriMatcher.match(uri);
            c.a.h0.b.a.i.a findContentProviderDelegate = findContentProviderDelegate(match);
            if (findContentProviderDelegate != null) {
                findContentProviderDelegate.g(uri, 0);
                return findContentProviderDelegate.s(match, uri, strArr, str, strArr2, str2, cancellationSignal);
            }
            throw new IllegalArgumentException();
        }
        return (Cursor) invokeCommon.objValue;
    }
}
