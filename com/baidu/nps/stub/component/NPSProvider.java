package com.baidu.nps.stub.component;

import android.annotation.TargetApi;
import android.content.ComponentName;
import android.content.ContentProvider;
import android.content.ContentProviderOperation;
import android.content.ContentProviderResult;
import android.content.ContentValues;
import android.content.OperationApplicationException;
import android.content.pm.PackageManager;
import android.content.pm.ProviderInfo;
import android.content.res.AssetFileDescriptor;
import android.content.res.Configuration;
import android.database.Cursor;
import android.net.Uri;
import android.os.Bundle;
import android.os.CancellationSignal;
import android.os.ParcelFileDescriptor;
import android.text.TextUtils;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.nps.main.manager.NPSManager;
import com.baidu.nps.utils.ContextHolder;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.io.FileDescriptor;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.ArrayList;
/* loaded from: classes10.dex */
public abstract class NPSProvider extends ContentProvider {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public ContentProvider mProviderImpl;

    public NPSProvider() {
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
        this.mProviderImpl = null;
    }

    private synchronized boolean bindProviderImpl(Bundle bundle) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65537, this, bundle)) == null) {
            synchronized (this) {
                if (this.mProviderImpl != null) {
                    return true;
                }
                if (bundle == null) {
                    return false;
                }
                String string = bundle.getString("pkg");
                String string2 = bundle.getString(com.baidu.nps.main.manager.Bundle.EXTRA_KEY_CLAZZ);
                if (!TextUtils.isEmpty(string) && !TextUtils.isEmpty(string2)) {
                    ContentProvider instantiateProvider = NPSManager.getInstance().instantiateProvider(string, string2);
                    if (instantiateProvider == null) {
                        return false;
                    }
                    try {
                        ProviderInfo providerInfo = getContext().getPackageManager().getProviderInfo(new ComponentName(getContext().getPackageName(), getClass().getName()), 0);
                        if (providerInfo == null) {
                            return false;
                        }
                        this.mProviderImpl = instantiateProvider;
                        instantiateProvider.attachInfo(ContextHolder.getApplicationContext(), providerInfo);
                        return true;
                    } catch (PackageManager.NameNotFoundException unused) {
                        return false;
                    }
                }
                return false;
            }
        }
        return invokeL.booleanValue;
    }

    @Override // android.content.ContentProvider
    @TargetApi(29)
    public ContentProviderResult[] applyBatch(String str, ArrayList<ContentProviderOperation> arrayList) throws OperationApplicationException {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048576, this, str, arrayList)) == null) {
            ContentProvider contentProvider = this.mProviderImpl;
            if (contentProvider == null) {
                return null;
            }
            return contentProvider.applyBatch(str, arrayList);
        }
        return (ContentProviderResult[]) invokeLL.objValue;
    }

    @Override // android.content.ContentProvider
    public int bulkInsert(Uri uri, ContentValues[] contentValuesArr) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(Constants.METHOD_SEND_USER_MSG, this, uri, contentValuesArr)) == null) {
            ContentProvider contentProvider = this.mProviderImpl;
            if (contentProvider == null) {
                return -1;
            }
            return contentProvider.bulkInsert(uri, contentValuesArr);
        }
        return invokeLL.intValue;
    }

    @Override // android.content.ContentProvider
    @TargetApi(29)
    public Bundle call(String str, String str2, String str3, Bundle bundle) {
        InterceptResult invokeLLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLLL = interceptable.invokeLLLL(1048580, this, str, str2, str3, bundle)) == null) {
            if (str2.equals(com.baidu.nps.main.manager.Bundle.METHOD_VALUE_BIND_PROVIDER)) {
                bindProviderImpl(bundle);
                return null;
            }
            ContentProvider contentProvider = this.mProviderImpl;
            if (contentProvider == null) {
                return null;
            }
            return contentProvider.call(str, str2, str3, bundle);
        }
        return (Bundle) invokeLLLL.objValue;
    }

    @Override // android.content.ContentProvider
    public Uri canonicalize(Uri uri) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048581, this, uri)) == null) {
            ContentProvider contentProvider = this.mProviderImpl;
            if (contentProvider == null) {
                return null;
            }
            return contentProvider.canonicalize(uri);
        }
        return (Uri) invokeL.objValue;
    }

    @Override // android.content.ContentProvider
    public int delete(Uri uri, String str, String[] strArr) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(1048582, this, uri, str, strArr)) == null) {
            ContentProvider contentProvider = this.mProviderImpl;
            if (contentProvider == null) {
                return 0;
            }
            return contentProvider.delete(uri, str, strArr);
        }
        return invokeLLL.intValue;
    }

    @Override // android.content.ContentProvider
    public void dump(FileDescriptor fileDescriptor, PrintWriter printWriter, String[] strArr) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(1048583, this, fileDescriptor, printWriter, strArr) == null) {
            ContentProvider contentProvider = this.mProviderImpl;
            if (contentProvider == null) {
                super.dump(fileDescriptor, printWriter, strArr);
            } else {
                contentProvider.dump(fileDescriptor, printWriter, strArr);
            }
        }
    }

    @Override // android.content.ContentProvider
    public String[] getStreamTypes(Uri uri, String str) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(InputDeviceCompat.SOURCE_TOUCHPAD, this, uri, str)) == null) {
            ContentProvider contentProvider = this.mProviderImpl;
            if (contentProvider == null) {
                return null;
            }
            return contentProvider.getStreamTypes(uri, str);
        }
        return (String[]) invokeLL.objValue;
    }

    @Override // android.content.ContentProvider
    public String getType(Uri uri) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048585, this, uri)) == null) {
            ContentProvider contentProvider = this.mProviderImpl;
            if (contentProvider == null) {
                return null;
            }
            return contentProvider.getType(uri);
        }
        return (String) invokeL.objValue;
    }

    @Override // android.content.ContentProvider
    public Uri insert(Uri uri, ContentValues contentValues) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048586, this, uri, contentValues)) == null) {
            ContentProvider contentProvider = this.mProviderImpl;
            if (contentProvider == null) {
                return null;
            }
            return contentProvider.insert(uri, contentValues);
        }
        return (Uri) invokeLL.objValue;
    }

    @Override // android.content.ContentProvider, android.content.ComponentCallbacks
    public void onConfigurationChanged(Configuration configuration) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048587, this, configuration) == null) {
            super.onConfigurationChanged(configuration);
            ContentProvider contentProvider = this.mProviderImpl;
            if (contentProvider != null) {
                contentProvider.onConfigurationChanged(configuration);
            }
        }
    }

    @Override // android.content.ContentProvider
    public boolean onCreate() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048588, this)) == null) {
            return false;
        }
        return invokeV.booleanValue;
    }

    @Override // android.content.ContentProvider, android.content.ComponentCallbacks
    public void onLowMemory() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048589, this) == null) {
            super.onLowMemory();
            ContentProvider contentProvider = this.mProviderImpl;
            if (contentProvider != null) {
                contentProvider.onLowMemory();
            }
        }
    }

    @Override // android.content.ContentProvider, android.content.ComponentCallbacks2
    public void onTrimMemory(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048590, this, i2) == null) {
            super.onTrimMemory(i2);
            ContentProvider contentProvider = this.mProviderImpl;
            if (contentProvider != null) {
                contentProvider.onTrimMemory(i2);
            }
        }
    }

    @Override // android.content.ContentProvider
    public AssetFileDescriptor openAssetFile(Uri uri, String str) throws FileNotFoundException {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048591, this, uri, str)) == null) {
            ContentProvider contentProvider = this.mProviderImpl;
            if (contentProvider == null) {
                return null;
            }
            return contentProvider.openAssetFile(uri, str);
        }
        return (AssetFileDescriptor) invokeLL.objValue;
    }

    @Override // android.content.ContentProvider
    public ParcelFileDescriptor openFile(Uri uri, String str) throws FileNotFoundException {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048593, this, uri, str)) == null) {
            ContentProvider contentProvider = this.mProviderImpl;
            if (contentProvider == null) {
                return null;
            }
            return contentProvider.openFile(uri, str);
        }
        return (ParcelFileDescriptor) invokeLL.objValue;
    }

    @Override // android.content.ContentProvider
    public <T> ParcelFileDescriptor openPipeHelper(Uri uri, String str, Bundle bundle, T t, ContentProvider.PipeDataWriter<T> pipeDataWriter) throws FileNotFoundException {
        InterceptResult invokeLLLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLLLL = interceptable.invokeLLLLL(1048595, this, uri, str, bundle, t, pipeDataWriter)) == null) {
            ContentProvider contentProvider = this.mProviderImpl;
            if (contentProvider == null) {
                return null;
            }
            return contentProvider.openPipeHelper(uri, str, bundle, t, pipeDataWriter);
        }
        return (ParcelFileDescriptor) invokeLLLLL.objValue;
    }

    @Override // android.content.ContentProvider
    public AssetFileDescriptor openTypedAssetFile(Uri uri, String str, Bundle bundle) throws FileNotFoundException {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(1048596, this, uri, str, bundle)) == null) {
            ContentProvider contentProvider = this.mProviderImpl;
            if (contentProvider == null) {
                return null;
            }
            return contentProvider.openTypedAssetFile(uri, str, bundle);
        }
        return (AssetFileDescriptor) invokeLLL.objValue;
    }

    @Override // android.content.ContentProvider
    public Cursor query(Uri uri, String[] strArr, String str, String[] strArr2, String str2, CancellationSignal cancellationSignal) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048600, this, new Object[]{uri, strArr, str, strArr2, str2, cancellationSignal})) == null) {
            ContentProvider contentProvider = this.mProviderImpl;
            if (contentProvider == null) {
                return null;
            }
            return contentProvider.query(uri, strArr, str, strArr2, str2, cancellationSignal);
        }
        return (Cursor) invokeCommon.objValue;
    }

    @Override // android.content.ContentProvider
    @TargetApi(26)
    public boolean refresh(Uri uri, Bundle bundle, CancellationSignal cancellationSignal) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(1048601, this, uri, bundle, cancellationSignal)) == null) {
            ContentProvider contentProvider = this.mProviderImpl;
            if (contentProvider == null) {
                return false;
            }
            return contentProvider.refresh(uri, bundle, cancellationSignal);
        }
        return invokeLLL.booleanValue;
    }

    @Override // android.content.ContentProvider
    public void shutdown() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048602, this) == null) {
            ContentProvider contentProvider = this.mProviderImpl;
            if (contentProvider == null) {
                super.shutdown();
            } else {
                contentProvider.shutdown();
            }
        }
    }

    @Override // android.content.ContentProvider
    public Uri uncanonicalize(Uri uri) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048603, this, uri)) == null) {
            ContentProvider contentProvider = this.mProviderImpl;
            if (contentProvider == null) {
                return null;
            }
            return contentProvider.uncanonicalize(uri);
        }
        return (Uri) invokeL.objValue;
    }

    @Override // android.content.ContentProvider
    public int update(Uri uri, ContentValues contentValues, String str, String[] strArr) {
        InterceptResult invokeLLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLLL = interceptable.invokeLLLL(1048604, this, uri, contentValues, str, strArr)) == null) {
            ContentProvider contentProvider = this.mProviderImpl;
            if (contentProvider == null) {
                return 0;
            }
            return contentProvider.update(uri, contentValues, str, strArr);
        }
        return invokeLLLL.intValue;
    }

    @Override // android.content.ContentProvider
    public ContentProviderResult[] applyBatch(ArrayList<ContentProviderOperation> arrayList) throws OperationApplicationException {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, arrayList)) == null) {
            ContentProvider contentProvider = this.mProviderImpl;
            if (contentProvider == null) {
                return null;
            }
            return contentProvider.applyBatch(arrayList);
        }
        return (ContentProviderResult[]) invokeL.objValue;
    }

    @Override // android.content.ContentProvider
    public AssetFileDescriptor openAssetFile(Uri uri, String str, CancellationSignal cancellationSignal) throws FileNotFoundException {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(1048592, this, uri, str, cancellationSignal)) == null) {
            ContentProvider contentProvider = this.mProviderImpl;
            if (contentProvider == null) {
                return null;
            }
            return contentProvider.openAssetFile(uri, str, cancellationSignal);
        }
        return (AssetFileDescriptor) invokeLLL.objValue;
    }

    @Override // android.content.ContentProvider
    public ParcelFileDescriptor openFile(Uri uri, String str, CancellationSignal cancellationSignal) throws FileNotFoundException {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(1048594, this, uri, str, cancellationSignal)) == null) {
            ContentProvider contentProvider = this.mProviderImpl;
            if (contentProvider == null) {
                return null;
            }
            return contentProvider.openFile(uri, str, cancellationSignal);
        }
        return (ParcelFileDescriptor) invokeLLL.objValue;
    }

    @Override // android.content.ContentProvider
    public AssetFileDescriptor openTypedAssetFile(Uri uri, String str, Bundle bundle, CancellationSignal cancellationSignal) throws FileNotFoundException {
        InterceptResult invokeLLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLLL = interceptable.invokeLLLL(1048597, this, uri, str, bundle, cancellationSignal)) == null) {
            ContentProvider contentProvider = this.mProviderImpl;
            if (contentProvider == null) {
                return null;
            }
            return contentProvider.openTypedAssetFile(uri, str, bundle, cancellationSignal);
        }
        return (AssetFileDescriptor) invokeLLLL.objValue;
    }

    @Override // android.content.ContentProvider
    @TargetApi(26)
    public Cursor query(Uri uri, String[] strArr, Bundle bundle, CancellationSignal cancellationSignal) {
        InterceptResult invokeLLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLLL = interceptable.invokeLLLL(1048598, this, uri, strArr, bundle, cancellationSignal)) == null) {
            ContentProvider contentProvider = this.mProviderImpl;
            if (contentProvider == null) {
                return null;
            }
            return contentProvider.query(uri, strArr, bundle, cancellationSignal);
        }
        return (Cursor) invokeLLLL.objValue;
    }

    @Override // android.content.ContentProvider
    public Bundle call(String str, String str2, Bundle bundle) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(1048579, this, str, str2, bundle)) == null) {
            if (str.equals(com.baidu.nps.main.manager.Bundle.METHOD_VALUE_BIND_PROVIDER)) {
                bindProviderImpl(bundle);
                return null;
            }
            ContentProvider contentProvider = this.mProviderImpl;
            if (contentProvider == null) {
                return null;
            }
            return contentProvider.call(str, str2, bundle);
        }
        return (Bundle) invokeLLL.objValue;
    }

    @Override // android.content.ContentProvider
    public Cursor query(Uri uri, String[] strArr, String str, String[] strArr2, String str2) {
        InterceptResult invokeLLLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLLLL = interceptable.invokeLLLLL(1048599, this, uri, strArr, str, strArr2, str2)) == null) {
            ContentProvider contentProvider = this.mProviderImpl;
            if (contentProvider == null) {
                return null;
            }
            return contentProvider.query(uri, strArr, str, strArr2, str2);
        }
        return (Cursor) invokeLLLLL.objValue;
    }
}
