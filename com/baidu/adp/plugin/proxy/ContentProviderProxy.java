package com.baidu.adp.plugin.proxy;

import android.content.ContentProvider;
import android.content.ContentProviderOperation;
import android.content.ContentProviderResult;
import android.content.ContentValues;
import android.content.Context;
import android.content.OperationApplicationException;
import android.content.pm.ProviderInfo;
import android.content.res.AssetFileDescriptor;
import android.content.res.Configuration;
import android.database.Cursor;
import android.net.Uri;
import android.os.ParcelFileDescriptor;
import androidx.core.view.InputDeviceCompat;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.adp.plugin.Plugin;
import com.baidu.adp.plugin.PluginCenter;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.io.FileNotFoundException;
import java.util.ArrayList;
/* loaded from: classes3.dex */
public class ContentProviderProxy extends ContentProvider {
    public static /* synthetic */ Interceptable $ic = null;
    public static final String CONTENT_PROVIDER_AUTHOR = "content://com.baidu.adp.plugin.provider";
    public static final String PROVIDER_AUTHOR = "com.baidu.adp.plugin.provider";
    public static final String PROVIDER_AUTHOR_SEPARATOR = ";";
    public static final String PROVIDER_FRAGMENT_SEPARATOR = "#";
    public static ContentProviderProxy mContent;
    public transient /* synthetic */ FieldHolder $fh;

    public ContentProviderProxy() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
            }
        }
    }

    public static final Uri convertToContainerUri(Uri uri) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65537, null, uri)) == null) {
            if (uri == null) {
                return null;
            }
            return Uri.parse("content://com.baidu.adp.plugin.provider#" + uri.toString());
        }
        return (Uri) invokeL.objValue;
    }

    public static final Uri convertToPluginUri(Uri uri) {
        InterceptResult invokeL;
        String fragment;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65538, null, uri)) == null) {
            if (uri == null || (fragment = uri.getFragment()) == null) {
                return null;
            }
            return Uri.parse(fragment);
        }
        return (Uri) invokeL.objValue;
    }

    public static ContentProviderProxy getInstance() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65539, null)) == null) ? mContent : (ContentProviderProxy) invokeV.objValue;
    }

    public static ContentProvider queryContentProvider(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(InputDeviceCompat.SOURCE_TRACKBALL, null, str)) == null) {
            ArrayList<Plugin> allPlugins = PluginCenter.getInstance().getAllPlugins();
            if (str != null && allPlugins != null && allPlugins.size() != 0) {
                try {
                    for (Plugin plugin2 : allPlugins) {
                        ContentProvider contentProvider = plugin2.getContentProvider(str);
                        if (contentProvider != null) {
                            return contentProvider;
                        }
                    }
                } catch (Exception e2) {
                    BdLog.e(e2);
                }
            }
            return null;
        }
        return (ContentProvider) invokeL.objValue;
    }

    @Override // android.content.ContentProvider
    public ContentProviderResult[] applyBatch(ArrayList<ContentProviderOperation> arrayList) throws OperationApplicationException {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, arrayList)) == null) ? super.applyBatch(arrayList) : (ContentProviderResult[]) invokeL.objValue;
    }

    @Override // android.content.ContentProvider
    public void attachInfo(Context context, ProviderInfo providerInfo) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, context, providerInfo) == null) {
            super.attachInfo(context, providerInfo);
        }
    }

    @Override // android.content.ContentProvider
    public int bulkInsert(Uri uri, ContentValues[] contentValuesArr) {
        InterceptResult invokeLL;
        ContentProvider queryContentProvider;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(Constants.METHOD_SEND_USER_MSG, this, uri, contentValuesArr)) == null) {
            if (uri == null || (queryContentProvider = queryContentProvider(uri.getAuthority())) == null) {
                return 0;
            }
            return queryContentProvider.bulkInsert(uri, contentValuesArr);
        }
        return invokeLL.intValue;
    }

    @Override // android.content.ContentProvider
    public int delete(Uri uri, String str, String[] strArr) {
        InterceptResult invokeLLL;
        ContentProvider queryContentProvider;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(1048579, this, uri, str, strArr)) == null) {
            if (uri == null || (queryContentProvider = queryContentProvider(uri.getAuthority())) == null) {
                return 0;
            }
            return queryContentProvider.delete(uri, str, strArr);
        }
        return invokeLLL.intValue;
    }

    @Override // android.content.ContentProvider
    public String getType(Uri uri) {
        InterceptResult invokeL;
        ContentProvider queryContentProvider;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048580, this, uri)) == null) {
            if (uri == null || (queryContentProvider = queryContentProvider(uri.getAuthority())) == null) {
                return null;
            }
            return queryContentProvider.getType(uri);
        }
        return (String) invokeL.objValue;
    }

    @Override // android.content.ContentProvider
    public Uri insert(Uri uri, ContentValues contentValues) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048581, this, uri, contentValues)) == null) {
            if (uri == null) {
                return null;
            }
            ContentProvider queryContentProvider = queryContentProvider(uri.getAuthority());
            return queryContentProvider == null ? uri : queryContentProvider.insert(uri, contentValues);
        }
        return (Uri) invokeLL.objValue;
    }

    @Override // android.content.ContentProvider
    public boolean isTemporary() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) ? super.isTemporary() : invokeV.booleanValue;
    }

    @Override // android.content.ContentProvider, android.content.ComponentCallbacks
    public void onConfigurationChanged(Configuration configuration) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048583, this, configuration) == null) {
            super.onConfigurationChanged(configuration);
        }
    }

    @Override // android.content.ContentProvider
    public boolean onCreate() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) {
            mContent = this;
            return true;
        }
        return invokeV.booleanValue;
    }

    @Override // android.content.ContentProvider, android.content.ComponentCallbacks
    public void onLowMemory() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048585, this) == null) {
            super.onLowMemory();
        }
    }

    @Override // android.content.ContentProvider
    public AssetFileDescriptor openAssetFile(Uri uri, String str) throws FileNotFoundException {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLL = interceptable.invokeLL(1048586, this, uri, str)) == null) ? super.openAssetFile(uri, str) : (AssetFileDescriptor) invokeLL.objValue;
    }

    @Override // android.content.ContentProvider
    public ParcelFileDescriptor openFile(Uri uri, String str) throws FileNotFoundException {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLL = interceptable.invokeLL(1048587, this, uri, str)) == null) ? super.openFile(uri, str) : (ParcelFileDescriptor) invokeLL.objValue;
    }

    @Override // android.content.ContentProvider
    public Cursor query(Uri uri, String[] strArr, String str, String[] strArr2, String str2) {
        InterceptResult invokeLLLLL;
        ContentProvider queryContentProvider;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLLLL = interceptable.invokeLLLLL(1048588, this, uri, strArr, str, strArr2, str2)) == null) {
            if (uri == null || (queryContentProvider = queryContentProvider(uri.getAuthority())) == null) {
                return null;
            }
            return queryContentProvider.query(uri, strArr, str, strArr2, str2);
        }
        return (Cursor) invokeLLLLL.objValue;
    }

    @Override // android.content.ContentProvider
    public int update(Uri uri, ContentValues contentValues, String str, String[] strArr) {
        InterceptResult invokeLLLL;
        ContentProvider queryContentProvider;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLLL = interceptable.invokeLLLL(1048589, this, uri, contentValues, str, strArr)) == null) {
            if (uri == null || (queryContentProvider = queryContentProvider(uri.getAuthority())) == null) {
                return 0;
            }
            return queryContentProvider.update(uri, contentValues, str, strArr);
        }
        return invokeLLLL.intValue;
    }
}
