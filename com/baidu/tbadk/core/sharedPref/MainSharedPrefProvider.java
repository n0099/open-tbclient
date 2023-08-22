package com.baidu.tbadk.core.sharedPref;

import android.content.ContentProvider;
import android.content.ContentValues;
import android.content.Intent;
import android.content.SharedPreferences;
import android.database.Cursor;
import android.net.Uri;
import android.text.TextUtils;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.android.util.KVStorageFactory;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.switchs.UniKVTestSwitch;
import com.baidu.tieba.b95;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.lang.ref.SoftReference;
import java.util.HashMap;
import java.util.Map;
/* loaded from: classes4.dex */
public class MainSharedPrefProvider extends ContentProvider {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public SoftReference<Map<String, String>> a;

    @Override // android.content.ContentProvider
    public boolean onCreate() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048587, this)) == null) {
            return true;
        }
        return invokeV.booleanValue;
    }

    @Override // android.content.ContentProvider
    public Cursor query(Uri uri, String[] strArr, String str, String[] strArr2, String str2) {
        InterceptResult invokeLLLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLLLL = interceptable.invokeLLLLL(1048588, this, uri, strArr, str, strArr2, str2)) == null) {
            return null;
        }
        return (Cursor) invokeLLLLL.objValue;
    }

    @Override // android.content.ContentProvider
    public int update(Uri uri, ContentValues contentValues, String str, String[] strArr) {
        InterceptResult invokeLLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLLL = interceptable.invokeLLLL(1048589, this, uri, contentValues, str, strArr)) == null) {
            return 0;
        }
        return invokeLLLL.intValue;
    }

    public MainSharedPrefProvider() {
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

    public final SharedPreferences c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            try {
                return TbadkCoreApplication.getInst().getSharedPreferences("common_settings2", 0);
            } catch (Exception unused) {
                return null;
            }
        }
        return (SharedPreferences) invokeV.objValue;
    }

    public final SharedPreferences d() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
            try {
                return KVStorageFactory.getSharedPreferences("common_settings2", 0);
            } catch (Exception unused) {
                return null;
            }
        }
        return (SharedPreferences) invokeV.objValue;
    }

    public final boolean a(String str) {
        InterceptResult invokeL;
        Map<String, String> map;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, str)) == null) {
            SoftReference<Map<String, String>> softReference = this.a;
            if (softReference != null && (map = softReference.get()) != null) {
                return map.containsKey(str);
            }
            return false;
        }
        return invokeL.booleanValue;
    }

    public final String b(String str) {
        InterceptResult invokeL;
        Map<String, String> map;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str)) == null) {
            SoftReference<Map<String, String>> softReference = this.a;
            if (softReference != null && (map = softReference.get()) != null) {
                return map.get(str);
            }
            return null;
        }
        return (String) invokeL.objValue;
    }

    public final boolean e(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048581, this, str)) == null) {
            if (str != null && str.length() != 0) {
                int length = b95.o.length;
                for (int i = 0; i < length; i++) {
                    if (str.equals(b95.o[i])) {
                        return true;
                    }
                }
            }
            return false;
        }
        return invokeL.booleanValue;
    }

    public final void f(String str) {
        SoftReference<Map<String, String>> softReference;
        Map<String, String> map;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048582, this, str) == null) && (softReference = this.a) != null && (map = softReference.get()) != null) {
            map.remove(str);
        }
    }

    @Override // android.content.ContentProvider
    public int delete(Uri uri, String str, String[] strArr) {
        InterceptResult invokeLLL;
        SharedPreferences c;
        SharedPreferences d;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(1048580, this, uri, str, strArr)) == null) {
            String lastPathSegment = uri.getLastPathSegment();
            if (lastPathSegment != null && lastPathSegment.length() > 0) {
                if ((UniKVTestSwitch.isTypeSp() || UniKVTestSwitch.isTypeDoubleKv() || UniKVTestSwitch.isTypeDoubleSp()) && (c = c()) != null) {
                    SharedPreferences.Editor edit = c.edit();
                    edit.remove(lastPathSegment);
                    edit.commit();
                }
                if ((UniKVTestSwitch.isTypeDoubleSp() || UniKVTestSwitch.isTypeDoubleKv()) && (d = d()) != null) {
                    SharedPreferences.Editor edit2 = d.edit();
                    edit2.remove(lastPathSegment);
                    edit2.commit();
                }
                f(lastPathSegment);
                if (e(lastPathSegment)) {
                    g(lastPathSegment, null);
                    return 0;
                }
                return 0;
            }
            return 0;
        }
        return invokeLLL.intValue;
    }

    public final void g(String str, String str2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048583, this, str, str2) == null) {
            Intent intent = new Intent();
            intent.setAction(TbConfig.getBroadcastActionChangeSharedPref());
            intent.setPackage(TbadkCoreApplication.getInst().getPackageName());
            intent.putExtra("intent_key", str);
            intent.putExtra("intent_value", str2);
            TbadkCoreApplication.getInst().getApp().sendBroadcast(intent);
        }
    }

    public final void h(String str, String str2) {
        Map<String, String> map;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048585, this, str, str2) == null) {
            SoftReference<Map<String, String>> softReference = this.a;
            if (softReference == null) {
                map = new HashMap<>();
                this.a = new SoftReference<>(map);
            } else {
                map = softReference.get();
                if (map == null) {
                    map = new HashMap<>();
                    this.a = new SoftReference<>(map);
                }
            }
            map.put(str, str2);
        }
    }

    @Override // android.content.ContentProvider
    public String getType(Uri uri) {
        InterceptResult invokeL;
        SharedPreferences c;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, uri)) == null) {
            String lastPathSegment = uri.getLastPathSegment();
            if (lastPathSegment != null && lastPathSegment.length() > 0) {
                if (a(lastPathSegment)) {
                    return b(lastPathSegment);
                }
                if (!UniKVTestSwitch.isTypeSp() && !UniKVTestSwitch.isTypeDoubleSp()) {
                    c = d();
                } else {
                    c = c();
                }
                if (c != null) {
                    return c.getString(lastPathSegment, null);
                }
            }
            return null;
        }
        return (String) invokeL.objValue;
    }

    @Override // android.content.ContentProvider
    public Uri insert(Uri uri, ContentValues contentValues) {
        InterceptResult invokeLL;
        SharedPreferences c;
        SharedPreferences d;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048586, this, uri, contentValues)) == null) {
            String lastPathSegment = uri.getLastPathSegment();
            if (lastPathSegment != null && contentValues != null && contentValues.size() > 0) {
                String asString = contentValues.getAsString(lastPathSegment);
                if (a(lastPathSegment) && TextUtils.equals(asString, b(lastPathSegment))) {
                    return null;
                }
                if ((UniKVTestSwitch.isTypeSp() || UniKVTestSwitch.isTypeDoubleKv() || UniKVTestSwitch.isTypeDoubleSp()) && (c = c()) != null) {
                    SharedPreferences.Editor edit = c.edit();
                    edit.putString(lastPathSegment, asString);
                    edit.commit();
                }
                if ((UniKVTestSwitch.isTypeDoubleSp() || UniKVTestSwitch.isTypeDoubleKv()) && (d = d()) != null) {
                    SharedPreferences.Editor edit2 = d.edit();
                    edit2.putString(lastPathSegment, asString);
                    edit2.commit();
                }
                h(lastPathSegment, asString);
                if (e(lastPathSegment)) {
                    g(lastPathSegment, asString);
                }
            }
            return null;
        }
        return (Uri) invokeLL.objValue;
    }
}
