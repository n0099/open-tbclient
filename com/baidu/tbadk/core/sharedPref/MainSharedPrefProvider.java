package com.baidu.tbadk.core.sharedPref;

import android.content.ContentProvider;
import android.content.ContentValues;
import android.content.Intent;
import android.content.SharedPreferences;
import android.database.Cursor;
import android.net.Uri;
import android.text.TextUtils;
import androidx.core.view.InputDeviceCompat;
import c.a.t0.s.j0.a;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.lang.ref.SoftReference;
import java.util.HashMap;
import java.util.Map;
/* loaded from: classes11.dex */
public class MainSharedPrefProvider extends ContentProvider {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public SoftReference<Map<String, String>> sCacheMap;

    public MainSharedPrefProvider() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
            }
        }
    }

    private void cleanCachedValued() {
        SoftReference<Map<String, String>> softReference;
        Map<String, String> map;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(65537, this) == null) || (softReference = this.sCacheMap) == null || (map = softReference.get()) == null) {
            return;
        }
        map.clear();
    }

    private boolean containsKey(String str) {
        InterceptResult invokeL;
        Map<String, String> map;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65538, this, str)) == null) {
            SoftReference<Map<String, String>> softReference = this.sCacheMap;
            if (softReference == null || (map = softReference.get()) == null) {
                return false;
            }
            return map.containsKey(str);
        }
        return invokeL.booleanValue;
    }

    private String getCachedValue(String str) {
        InterceptResult invokeL;
        Map<String, String> map;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65539, this, str)) == null) {
            SoftReference<Map<String, String>> softReference = this.sCacheMap;
            if (softReference == null || (map = softReference.get()) == null) {
                return null;
            }
            return map.get(str);
        }
        return (String) invokeL.objValue;
    }

    private SharedPreferences getSharedPreferences() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TRACKBALL, this)) == null) {
            try {
                return getContext().getSharedPreferences("common_settings", 0);
            } catch (Exception unused) {
                return null;
            }
        }
        return (SharedPreferences) invokeV.objValue;
    }

    private boolean needBroadcast(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65541, this, str)) == null) {
            if (str != null && str.length() != 0) {
                int length = a.k.length;
                for (int i2 = 0; i2 < length; i2++) {
                    if (str.equals(a.k[i2])) {
                        return true;
                    }
                }
            }
            return false;
        }
        return invokeL.booleanValue;
    }

    private void removeValueToCached(String str) {
        SoftReference<Map<String, String>> softReference;
        Map<String, String> map;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(65542, this, str) == null) || (softReference = this.sCacheMap) == null || (map = softReference.get()) == null) {
            return;
        }
        map.remove(str);
    }

    private void sendBroadcast(String str, String str2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65543, this, str, str2) == null) {
            Intent intent = new Intent();
            intent.setAction(TbConfig.getBroadcastActionChangeSharedPref());
            intent.setPackage(TbadkCoreApplication.getInst().getPackageName());
            intent.putExtra("intent_key", str);
            intent.putExtra("intent_value", str2);
            TbadkCoreApplication.getInst().getApp().sendBroadcast(intent);
        }
    }

    private void setValueToCached(String str, String str2) {
        Map<String, String> map;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65544, this, str, str2) == null) {
            SoftReference<Map<String, String>> softReference = this.sCacheMap;
            if (softReference == null) {
                map = new HashMap<>();
                this.sCacheMap = new SoftReference<>(map);
            } else {
                map = softReference.get();
                if (map == null) {
                    map = new HashMap<>();
                    this.sCacheMap = new SoftReference<>(map);
                }
            }
            map.put(str, str2);
        }
    }

    @Override // android.content.ContentProvider
    public int delete(Uri uri, String str, String[] strArr) {
        InterceptResult invokeLLL;
        SharedPreferences sharedPreferences;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(1048576, this, uri, str, strArr)) == null) {
            String lastPathSegment = uri.getLastPathSegment();
            if (lastPathSegment == null || lastPathSegment.length() <= 0 || (sharedPreferences = getSharedPreferences()) == null) {
                return 0;
            }
            SharedPreferences.Editor edit = sharedPreferences.edit();
            edit.remove(lastPathSegment);
            edit.commit();
            removeValueToCached(lastPathSegment);
            if (needBroadcast(lastPathSegment)) {
                sendBroadcast(lastPathSegment, null);
                return 0;
            }
            return 0;
        }
        return invokeLLL.intValue;
    }

    @Override // android.content.ContentProvider
    public String getType(Uri uri) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, uri)) == null) {
            String lastPathSegment = uri.getLastPathSegment();
            if (lastPathSegment != null && lastPathSegment.length() > 0) {
                if (containsKey(lastPathSegment)) {
                    return getCachedValue(lastPathSegment);
                }
                SharedPreferences sharedPreferences = getSharedPreferences();
                if (sharedPreferences != null) {
                    return sharedPreferences.getString(lastPathSegment, null);
                }
            }
            return null;
        }
        return (String) invokeL.objValue;
    }

    @Override // android.content.ContentProvider
    public Uri insert(Uri uri, ContentValues contentValues) {
        InterceptResult invokeLL;
        SharedPreferences sharedPreferences;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(Constants.METHOD_SEND_USER_MSG, this, uri, contentValues)) == null) {
            String lastPathSegment = uri.getLastPathSegment();
            if (lastPathSegment != null && contentValues != null && contentValues.size() > 0) {
                String asString = contentValues.getAsString(lastPathSegment);
                if ((!containsKey(lastPathSegment) || !TextUtils.equals(asString, getCachedValue(lastPathSegment))) && (sharedPreferences = getSharedPreferences()) != null) {
                    SharedPreferences.Editor edit = sharedPreferences.edit();
                    edit.putString(lastPathSegment, asString);
                    edit.commit();
                    setValueToCached(lastPathSegment, asString);
                    if (needBroadcast(lastPathSegment)) {
                        sendBroadcast(lastPathSegment, asString);
                    }
                }
            }
            return null;
        }
        return (Uri) invokeLL.objValue;
    }

    @Override // android.content.ContentProvider
    public boolean onCreate() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
            return true;
        }
        return invokeV.booleanValue;
    }

    @Override // android.content.ContentProvider
    public Cursor query(Uri uri, String[] strArr, String str, String[] strArr2, String str2) {
        InterceptResult invokeLLLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLLLL = interceptable.invokeLLLLL(1048580, this, uri, strArr, str, strArr2, str2)) == null) {
            return null;
        }
        return (Cursor) invokeLLLLL.objValue;
    }

    @Override // android.content.ContentProvider
    public int update(Uri uri, ContentValues contentValues, String str, String[] strArr) {
        InterceptResult invokeLLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLLL = interceptable.invokeLLLL(1048581, this, uri, contentValues, str, strArr)) == null) {
            return 0;
        }
        return invokeLLLL.intValue;
    }
}
