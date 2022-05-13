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
import com.repackage.nc1;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
/* loaded from: classes2.dex */
public abstract class DispatchableContentProvider extends ContentProvider {
    public static /* synthetic */ Interceptable $ic = null;
    public static final boolean DEBUG = false;
    public static final String TAG = "DispProvider";
    public transient /* synthetic */ FieldHolder $fh;
    public String mAuthority;
    public ArrayList<nc1> mContentProviderDelegates;
    public final Object mInitLocker;
    public volatile boolean mIsInit;
    public a mUriMatcher;

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
        this.mIsInit = false;
        this.mInitLocker = new Object();
    }

    private nc1 findContentProviderDelegate(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(65537, this, i)) == null) {
            int size = this.mContentProviderDelegates.size() - 1;
            int i2 = 0;
            while (i2 <= size) {
                int i3 = (i2 + size) / 2;
                nc1 nc1Var = this.mContentProviderDelegates.get(i3);
                if (i >= nc1Var.h() && i <= nc1Var.g()) {
                    return nc1Var;
                }
                if (i < nc1Var.h()) {
                    size = i3 - 1;
                } else {
                    i2 = i3 + 1;
                }
            }
            return null;
        }
        return (nc1) invokeI.objValue;
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
                List<nc1> contentProviderDelegates = getContentProviderDelegates();
                if (contentProviderDelegates != null) {
                    for (nc1 nc1Var : contentProviderDelegates) {
                        insertContentProviderDelegate(nc1Var);
                        this.mUriMatcher.b = nc1Var.h();
                        this.mUriMatcher.a = nc1Var.g();
                        nc1Var.f(this.mUriMatcher, this.mAuthority);
                    }
                }
                Iterator<nc1> it = this.mContentProviderDelegates.iterator();
                while (it.hasNext()) {
                    it.next().j();
                }
                return;
            }
            throw new IllegalStateException();
        }
    }

    private void insertContentProviderDelegate(nc1 nc1Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65539, this, nc1Var) == null) {
            if (nc1Var.h() <= nc1Var.g()) {
                int size = this.mContentProviderDelegates.size();
                int i = 0;
                for (int i2 = 0; i2 < size; i2++) {
                    if (nc1Var.h() > this.mContentProviderDelegates.get(i2).g()) {
                        i = i2 + 1;
                    }
                }
                if (i < size - 1 && nc1Var.g() >= this.mContentProviderDelegates.get(i).h()) {
                    throw new IllegalArgumentException();
                }
                this.mContentProviderDelegates.add(i, nc1Var);
                return;
            }
            throw new IllegalArgumentException();
        }
    }

    @Override // android.content.ContentProvider
    public ContentProviderResult[] applyBatch(ArrayList<ContentProviderOperation> arrayList) throws OperationApplicationException {
        InterceptResult invokeL;
        nc1 findContentProviderDelegate;
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
                    findContentProviderDelegate.e(uri, 0);
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
                for (ContentProviderResult contentProviderResult : ((nc1) entry.getKey()).a((ArrayList) entry.getValue())) {
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
            Iterator<nc1> it = this.mContentProviderDelegates.iterator();
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
            nc1 findContentProviderDelegate = findContentProviderDelegate(match);
            if (findContentProviderDelegate != null) {
                findContentProviderDelegate.e(uri, 6);
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
            Iterator<nc1> it = this.mContentProviderDelegates.iterator();
            while (it.hasNext()) {
                nc1 next = it.next();
                if (next.d(str, str2, bundle)) {
                    next.e(null, 3);
                    return next.call(str, str2, bundle);
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
            nc1 findContentProviderDelegate = findContentProviderDelegate(match);
            if (findContentProviderDelegate != null) {
                findContentProviderDelegate.e(uri, 5);
                return findContentProviderDelegate.delete(match, uri, str, strArr);
            }
            throw new IllegalArgumentException();
        }
        return invokeLLL.intValue;
    }

    public abstract String getAuthority();

    public abstract List<nc1> getContentProviderDelegates();

    @Override // android.content.ContentProvider
    public String getType(Uri uri) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048583, this, uri)) == null) {
            initIfNeed();
            int match = this.mUriMatcher.match(uri);
            nc1 findContentProviderDelegate = findContentProviderDelegate(match);
            if (findContentProviderDelegate != null) {
                findContentProviderDelegate.e(uri, 4);
                return findContentProviderDelegate.getType(match, uri);
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
            nc1 findContentProviderDelegate = findContentProviderDelegate(match);
            if (findContentProviderDelegate != null) {
                findContentProviderDelegate.e(uri, 1);
                return findContentProviderDelegate.insert(match, uri, contentValues);
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
            Iterator<nc1> it = this.mContentProviderDelegates.iterator();
            while (it.hasNext()) {
                it.next().i(configuration);
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
            nc1 findContentProviderDelegate = findContentProviderDelegate(match);
            if (findContentProviderDelegate != null) {
                findContentProviderDelegate.e(uri, 7);
                findContentProviderDelegate.k(match, uri, str);
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
            nc1 findContentProviderDelegate = findContentProviderDelegate(match);
            if (findContentProviderDelegate != null) {
                findContentProviderDelegate.m(match, uri, str);
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
            nc1 findContentProviderDelegate = findContentProviderDelegate(match);
            if (findContentProviderDelegate != null) {
                findContentProviderDelegate.e(uri, 0);
                return findContentProviderDelegate.query(match, uri, strArr, str, strArr2, str2);
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
            nc1 findContentProviderDelegate = findContentProviderDelegate(match);
            if (findContentProviderDelegate != null) {
                findContentProviderDelegate.e(uri, 2);
                return findContentProviderDelegate.update(match, uri, contentValues, str, strArr);
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
            nc1 findContentProviderDelegate = findContentProviderDelegate(match);
            if (findContentProviderDelegate != null) {
                findContentProviderDelegate.e(uri, 7);
                findContentProviderDelegate.l(match, uri, str, cancellationSignal);
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
            nc1 findContentProviderDelegate = findContentProviderDelegate(match);
            if (findContentProviderDelegate != null) {
                findContentProviderDelegate.e(uri, 0);
                return findContentProviderDelegate.query(match, uri, strArr, str, strArr2, str2, cancellationSignal);
            }
            throw new IllegalArgumentException();
        }
        return (Cursor) invokeCommon.objValue;
    }
}
