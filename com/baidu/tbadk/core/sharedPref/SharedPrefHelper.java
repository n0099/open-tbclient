package com.baidu.tbadk.core.sharedPref;

import android.app.ActivityManager;
import android.app.Application;
import android.content.ContentResolver;
import android.content.ContentValues;
import android.content.SharedPreferences;
import android.net.Uri;
import android.os.Build;
import android.os.Process;
import android.text.TextUtils;
import androidx.core.view.InputDeviceCompat;
import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.adp.lib.util.BdUtilHelper;
import com.baidu.android.common.others.lang.StringUtil;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.android.util.KVStorageFactory;
import com.baidu.searchbox.downloads.DownloadConstants;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.PermissionUtil;
import com.baidu.tbadk.switchs.UniKVTestSwitch;
import com.baidu.tieba.compatible.EditorHelper;
import com.baidu.tieba.u85;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
/* loaded from: classes4.dex */
public class SharedPrefHelper {
    public static /* synthetic */ Interceptable $ic;
    public static ContentResolver mContentResolver;
    public static HashMap<String, String> mProcessMap;
    public static SharedPrefHelper spHelper;
    public transient /* synthetic */ FieldHolder $fh;
    public String cachedPrefix;
    public ConcurrentHashMap<String, Object> kvMap;
    public String mFile;
    public String mProcess;
    public SharedPreferences mSP;

    /* loaded from: classes4.dex */
    public class a extends BdAsyncTask<Void, Void, Void> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ Uri a;
        public final /* synthetic */ ContentValues b;
        public final /* synthetic */ SharedPrefHelper c;

        public a(SharedPrefHelper sharedPrefHelper, Uri uri, ContentValues contentValues) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {sharedPrefHelper, uri, contentValues};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.c = sharedPrefHelper;
            this.a = uri;
            this.b = contentValues;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public Void doInBackground(Void... voidArr) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, voidArr)) == null) {
                this.c.setValueInner(this.a, this.b);
                return null;
            }
            return (Void) invokeL.objValue;
        }
    }

    /* loaded from: classes4.dex */
    public class b extends BdAsyncTask<Void, Void, Void> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ Uri a;
        public final /* synthetic */ SharedPrefHelper b;

        public b(SharedPrefHelper sharedPrefHelper, Uri uri) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {sharedPrefHelper, uri};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = sharedPrefHelper;
            this.a = uri;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public Void doInBackground(Void... voidArr) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, voidArr)) == null) {
                this.b.deleteValueInner(this.a);
                return null;
            }
            return (Void) invokeL.objValue;
        }
    }

    public SharedPrefHelper() {
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
        this.cachedPrefix = null;
        this.kvMap = new ConcurrentHashMap<>();
        HashMap<String, String> hashMap = new HashMap<>();
        mProcessMap = hashMap;
        hashMap.put(u85.a, "settings2");
        mProcessMap.put(u85.b, "remote_settings2");
        mProcessMap.put(u85.c, "bdservice_settings2");
        mProcessMap.put(u85.d, u85.h);
        mProcessMap.put(u85.e, u85.j);
        mProcessMap.put(u85.f, u85.l);
        mContentResolver = TbadkCoreApplication.getInst().getContext().getContentResolver();
    }

    public synchronized SharedPreferences getSharedPreferences() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048586, this)) == null) {
            synchronized (this) {
                if (!PermissionUtil.isBrowseMode() && PermissionUtil.isAgreePrivacyPolicy()) {
                    if (this.mFile == null || this.mFile.length() == 0) {
                        if (this.mProcess == null || this.mProcess.length() == 0) {
                            this.mProcess = getProcessName();
                        }
                        if (mProcessMap.containsKey(this.mProcess)) {
                            this.mFile = mProcessMap.get(this.mProcess);
                        } else {
                            this.mFile = "settings2";
                        }
                    }
                    return TbadkCoreApplication.getInst().getSharedPreferences(this.mFile, 0);
                }
                return TbadkCoreApplication.getInst().getSharedPreferences("settings2", 0);
            }
        }
        return (SharedPreferences) invokeV.objValue;
    }

    public synchronized SharedPreferences getSharedPreferencesKV() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048587, this)) == null) {
            synchronized (this) {
                if (!PermissionUtil.isBrowseMode() && PermissionUtil.isAgreePrivacyPolicy()) {
                    if (this.mFile == null || this.mFile.length() == 0) {
                        if (this.mProcess == null || this.mProcess.length() == 0) {
                            this.mProcess = getProcessName();
                        }
                        if (mProcessMap.containsKey(this.mProcess)) {
                            this.mFile = mProcessMap.get(this.mProcess);
                        } else {
                            this.mFile = "settings2";
                        }
                    }
                    return KVStorageFactory.getSharedPreferences(this.mFile, 0);
                }
                return KVStorageFactory.getSharedPreferences("settings2", 0);
            }
        }
        return (SharedPreferences) invokeV.objValue;
    }

    private void putBooleanInternal(String str, boolean z, SharedPreferences sharedPreferences) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(65548, this, new Object[]{str, Boolean.valueOf(z), sharedPreferences}) == null) {
            SharedPreferences.Editor edit = sharedPreferences.edit();
            edit.putBoolean(str, z);
            edit.commit();
        }
    }

    private void putFloatInternal(String str, float f, SharedPreferences sharedPreferences) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(65550, this, new Object[]{str, Float.valueOf(f), sharedPreferences}) == null) {
            SharedPreferences.Editor edit = sharedPreferences.edit();
            edit.putFloat(str, f);
            edit.commit();
        }
    }

    private void putIntInternal(String str, int i, SharedPreferences sharedPreferences) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLIL(65551, this, str, i, sharedPreferences) == null) {
            SharedPreferences.Editor edit = sharedPreferences.edit();
            edit.putInt(str, i);
            edit.commit();
        }
    }

    private void putLongInternal(String str, long j, SharedPreferences sharedPreferences) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(65552, this, new Object[]{str, Long.valueOf(j), sharedPreferences}) == null) {
            SharedPreferences.Editor edit = sharedPreferences.edit();
            edit.putLong(str, j);
            edit.commit();
        }
    }

    private void putStringInternal(String str, String str2, SharedPreferences sharedPreferences) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(65553, this, str, str2, sharedPreferences) == null) {
            SharedPreferences.Editor edit = sharedPreferences.edit();
            edit.putString(str, str2);
            edit.commit();
        }
    }

    private void syncPutIntInternal(String str, int i, SharedPreferences sharedPreferences) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLIL(65562, this, str, i, sharedPreferences) == null) {
            SharedPreferences.Editor edit = sharedPreferences.edit();
            edit.putInt(str, i);
            edit.commit();
        }
    }

    private void syncPutLongInternal(String str, long j, SharedPreferences sharedPreferences) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(65563, this, new Object[]{str, Long.valueOf(j), sharedPreferences}) == null) {
            SharedPreferences.Editor edit = sharedPreferences.edit();
            edit.putLong(str, j);
            edit.commit();
        }
    }

    private void putData(String str, Object obj) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLL(65549, this, str, obj) == null) && str != null && obj != null) {
            this.kvMap.put(str, obj);
            commit();
        }
    }

    private void putValue(String str, String str2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65557, this, str, str2) == null) {
            Uri parse = Uri.parse(getContentPrefix() + str);
            ContentValues contentValues = new ContentValues();
            contentValues.put(str, str2);
            setValue(parse, contentValues);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setValueInner(Uri uri, ContentValues contentValues) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65560, this, uri, contentValues) == null) {
            try {
                mContentResolver.insert(uri, contentValues);
            } catch (Exception e) {
                BdLog.detailException(e);
            }
        }
    }

    public void removeInternal(String str, SharedPreferences sharedPreferences) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048597, this, str, sharedPreferences) == null) {
            EditorHelper.remove(sharedPreferences, str);
        }
    }

    public void setValue(Uri uri, ContentValues contentValues) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048598, this, uri, contentValues) == null) {
            if (BdUtilHelper.isMainThread()) {
                new a(this, uri, contentValues).execute(new Void[0]);
            } else {
                setValueInner(uri, contentValues);
            }
        }
    }

    private boolean checkIsCommon(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65539, this, str)) == null) {
            if (str != null && str.length() != 0) {
                int length = u85.n.length;
                for (int i = 0; i < length; i++) {
                    if (str.equals(u85.n[i])) {
                        return true;
                    }
                }
            }
            return false;
        }
        return invokeL.booleanValue;
    }

    private void clearInternal(SharedPreferences sharedPreferences) {
        SharedPreferences.Editor edit;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(65541, this, sharedPreferences) == null) && (edit = sharedPreferences.edit()) != null) {
            edit.clear();
            edit.commit();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void deleteValueInner(Uri uri) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65543, this, uri) == null) {
            try {
                mContentResolver.delete(uri, null, null);
            } catch (SecurityException e) {
                BdLog.detailException(e);
            }
        }
    }

    public static String getSharedPrefKeyWithAccount(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65546, null, str)) == null) {
            return str + "_" + TbadkCoreApplication.getCurrentAccount();
        }
        return (String) invokeL.objValue;
    }

    private String getValue(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65547, this, str)) == null) {
            return getValue(Uri.parse(getContentPrefix() + str));
        }
        return (String) invokeL.objValue;
    }

    private void removeValue(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65559, this, str) == null) {
            deleteValue(Uri.parse(getContentPrefix() + str));
        }
    }

    public void deleteValue(Uri uri) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, uri) == null) {
            if (BdUtilHelper.isMainThread()) {
                new b(this, uri).execute(new Void[0]);
            } else {
                deleteValueInner(uri);
            }
        }
    }

    private void clearByAccountInternal(String str, SharedPreferences sharedPreferences) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLL(InputDeviceCompat.SOURCE_TRACKBALL, this, str, sharedPreferences) == null) && !TextUtils.isEmpty(str) && sharedPreferences != null) {
            Set<String> keySet = sharedPreferences.getAll().keySet();
            SharedPreferences.Editor edit = sharedPreferences.edit();
            for (String str2 : keySet) {
                if (str2.endsWith("_" + str)) {
                    edit.remove(str2);
                }
            }
            if (Build.VERSION.SDK_INT >= 9) {
                edit.apply();
            } else {
                edit.commit();
            }
        }
    }

    public boolean getBoolean(String str, boolean z) {
        InterceptResult invokeLZ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLZ = interceptable.invokeLZ(1048580, this, str, z)) == null) {
            if (checkIsCommon(str)) {
                String value = getValue(str);
                if (value == null) {
                    return z;
                }
                try {
                    return Boolean.parseBoolean(value);
                } catch (NumberFormatException e) {
                    e.printStackTrace();
                    return z;
                }
            }
            Object obj = this.kvMap.get(str);
            if (obj instanceof Boolean) {
                return ((Boolean) obj).booleanValue();
            }
            if (!UniKVTestSwitch.isTypeSp() && !UniKVTestSwitch.isTypeDoubleSp()) {
                this.mSP = getSharedPreferencesKV();
            } else {
                this.mSP = getSharedPreferences();
            }
            return this.mSP.getBoolean(str, z);
        }
        return invokeLZ.booleanValue;
    }

    public float getFloat(String str, float f) {
        InterceptResult invokeLF;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLF = interceptable.invokeLF(1048583, this, str, f)) == null) {
            if (checkIsCommon(str)) {
                String value = getValue(str);
                if (value == null) {
                    return f;
                }
                try {
                    return Float.parseFloat(value);
                } catch (NumberFormatException e) {
                    e.printStackTrace();
                    return f;
                }
            }
            Object obj = this.kvMap.get(str);
            if (obj instanceof Float) {
                return ((Float) obj).floatValue();
            }
            if (!UniKVTestSwitch.isTypeSp() && !UniKVTestSwitch.isTypeDoubleSp()) {
                this.mSP = getSharedPreferencesKV();
            } else {
                this.mSP = getSharedPreferences();
            }
            return this.mSP.getFloat(str, f);
        }
        return invokeLF.floatValue;
    }

    public int getInt(String str, int i) {
        InterceptResult invokeLI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLI = interceptable.invokeLI(InputDeviceCompat.SOURCE_TOUCHPAD, this, str, i)) == null) {
            if (checkIsCommon(str)) {
                String value = getValue(str);
                if (value == null) {
                    return i;
                }
                try {
                    return Integer.parseInt(value);
                } catch (NumberFormatException e) {
                    e.printStackTrace();
                    return i;
                }
            }
            Object obj = this.kvMap.get(str);
            if (obj instanceof Integer) {
                return ((Integer) obj).intValue();
            }
            if (!UniKVTestSwitch.isTypeSp() && !UniKVTestSwitch.isTypeDoubleSp()) {
                this.mSP = getSharedPreferencesKV();
            } else {
                this.mSP = getSharedPreferences();
            }
            return this.mSP.getInt(str, i);
        }
        return invokeLI.intValue;
    }

    public long getLong(String str, long j) {
        InterceptResult invokeLJ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLJ = interceptable.invokeLJ(1048585, this, str, j)) == null) {
            if (checkIsCommon(str)) {
                String value = getValue(str);
                if (value == null) {
                    return j;
                }
                try {
                    return Long.parseLong(value);
                } catch (NumberFormatException e) {
                    e.printStackTrace();
                    return j;
                }
            }
            Object obj = this.kvMap.get(str);
            if (obj instanceof Long) {
                return ((Long) obj).longValue();
            }
            if (!UniKVTestSwitch.isTypeSp() && !UniKVTestSwitch.isTypeDoubleSp()) {
                this.mSP = getSharedPreferencesKV();
            } else {
                this.mSP = getSharedPreferences();
            }
            try {
                return this.mSP.getLong(str, j);
            } catch (ClassCastException e2) {
                BdLog.e(e2);
                return j;
            }
        }
        return invokeLJ.longValue;
    }

    public String getString(String str, String str2) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048588, this, str, str2)) == null) {
            if (checkIsCommon(str)) {
                String value = getValue(str);
                if (value != null) {
                    return value;
                }
                return str2;
            }
            Object obj = this.kvMap.get(str);
            if (obj instanceof String) {
                return (String) obj;
            }
            if (!UniKVTestSwitch.isTypeSp() && !UniKVTestSwitch.isTypeDoubleSp()) {
                this.mSP = getSharedPreferencesKV();
            } else {
                this.mSP = getSharedPreferences();
            }
            return this.mSP.getString(str, str2);
        }
        return (String) invokeLL.objValue;
    }

    public void putBoolean(String str, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLZ(1048591, this, str, z) == null) {
            if (checkIsCommon(str)) {
                putValue(str, z);
            } else if (BdUtilHelper.isMainThread()) {
                putData(str, Boolean.valueOf(z));
            } else {
                if (UniKVTestSwitch.isTypeSp() || UniKVTestSwitch.isTypeDoubleKv() || UniKVTestSwitch.isTypeDoubleSp()) {
                    putBooleanInternal(str, z, getSharedPreferences());
                }
                if (UniKVTestSwitch.isTypeDoubleSp() || UniKVTestSwitch.isTypeDoubleKv()) {
                    putBooleanInternal(str, z, getSharedPreferencesKV());
                }
            }
        }
    }

    public void putFloat(String str, float f) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLF(1048592, this, str, f) == null) {
            if (checkIsCommon(str)) {
                putValue(str, f);
            } else if (BdUtilHelper.isMainThread()) {
                putData(str, Float.valueOf(f));
            } else {
                if (UniKVTestSwitch.isTypeSp() || UniKVTestSwitch.isTypeDoubleKv() || UniKVTestSwitch.isTypeDoubleSp()) {
                    putFloatInternal(str, f, getSharedPreferences());
                }
                if (UniKVTestSwitch.isTypeDoubleSp() || UniKVTestSwitch.isTypeDoubleKv()) {
                    putFloatInternal(str, f, getSharedPreferencesKV());
                }
            }
        }
    }

    public void putInt(String str, int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLI(1048593, this, str, i) == null) {
            if (checkIsCommon(str)) {
                putValue(str, i);
            } else if (BdUtilHelper.isMainThread()) {
                putData(str, Integer.valueOf(i));
            } else {
                if (UniKVTestSwitch.isTypeSp() || UniKVTestSwitch.isTypeDoubleKv() || UniKVTestSwitch.isTypeDoubleSp()) {
                    putIntInternal(str, i, getSharedPreferences());
                }
                if (UniKVTestSwitch.isTypeDoubleSp() || UniKVTestSwitch.isTypeDoubleKv()) {
                    putIntInternal(str, i, getSharedPreferencesKV());
                }
            }
        }
    }

    public void putLong(String str, long j) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLJ(1048594, this, str, j) == null) {
            if (checkIsCommon(str)) {
                putValue(str, j);
            } else if (BdUtilHelper.isMainThread()) {
                putData(str, Long.valueOf(j));
            } else {
                if (UniKVTestSwitch.isTypeSp() || UniKVTestSwitch.isTypeDoubleKv() || UniKVTestSwitch.isTypeDoubleSp()) {
                    putLongInternal(str, j, getSharedPreferences());
                }
                if (UniKVTestSwitch.isTypeDoubleSp() || UniKVTestSwitch.isTypeDoubleKv()) {
                    putLongInternal(str, j, getSharedPreferencesKV());
                }
            }
        }
    }

    public void putString(String str, String str2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048595, this, str, str2) == null) {
            if (checkIsCommon(str)) {
                putValue(str, str2);
            } else if (StringUtil.NULL_STRING.equals(str2)) {
                remove(str);
            } else if (BdUtilHelper.isMainThread()) {
                putData(str, str2);
            } else {
                if (UniKVTestSwitch.isTypeSp() || UniKVTestSwitch.isTypeDoubleKv() || UniKVTestSwitch.isTypeDoubleSp()) {
                    putStringInternal(str, str2, getSharedPreferences());
                }
                if (UniKVTestSwitch.isTypeDoubleSp() || UniKVTestSwitch.isTypeDoubleKv()) {
                    putStringInternal(str, str2, getSharedPreferencesKV());
                }
            }
        }
    }

    private void commitInternal(SharedPreferences sharedPreferences) {
        SharedPreferences.Editor edit;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(65542, this, sharedPreferences) != null) || sharedPreferences == null || (edit = sharedPreferences.edit()) == null) {
            return;
        }
        for (Map.Entry<String, Object> entry : this.kvMap.entrySet()) {
            if (entry != null) {
                String valueOf = String.valueOf(entry.getKey());
                Object value = entry.getValue();
                if (value instanceof String) {
                    edit.putString(valueOf, (String) value);
                } else if (value instanceof Integer) {
                    edit.putInt(valueOf, ((Integer) value).intValue());
                } else if (value instanceof Long) {
                    edit.putLong(valueOf, ((Long) value).longValue());
                } else if (value instanceof Boolean) {
                    edit.putBoolean(valueOf, ((Boolean) value).booleanValue());
                } else if (value instanceof Float) {
                    edit.putFloat(valueOf, ((Float) value).floatValue());
                }
            }
        }
        if (Build.VERSION.SDK_INT >= 9) {
            edit.apply();
        } else {
            edit.commit();
        }
    }

    private void syncCommitInternal(SharedPreferences sharedPreferences) {
        SharedPreferences.Editor edit;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(65561, this, sharedPreferences) != null) || sharedPreferences == null || (edit = sharedPreferences.edit()) == null) {
            return;
        }
        for (Map.Entry<String, Object> entry : this.kvMap.entrySet()) {
            if (entry != null) {
                String valueOf = String.valueOf(entry.getKey());
                Object value = entry.getValue();
                if (value instanceof String) {
                    edit.putString(valueOf, (String) value);
                } else if (value instanceof Integer) {
                    edit.putInt(valueOf, ((Integer) value).intValue());
                } else if (value instanceof Long) {
                    edit.putLong(valueOf, ((Long) value).longValue());
                } else if (value instanceof Boolean) {
                    edit.putBoolean(valueOf, ((Boolean) value).booleanValue());
                } else if (value instanceof Float) {
                    edit.putFloat(valueOf, ((Float) value).floatValue());
                }
            }
        }
        edit.commit();
    }

    public static synchronized SharedPrefHelper getInstance() {
        InterceptResult invokeV;
        SharedPrefHelper sharedPrefHelper;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65544, null)) == null) {
            synchronized (SharedPrefHelper.class) {
                if (spHelper == null) {
                    spHelper = new SharedPrefHelper();
                }
                sharedPrefHelper = spHelper;
            }
            return sharedPrefHelper;
        }
        return (SharedPrefHelper) invokeV.objValue;
    }

    public ContentResolver getContentResolver() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) {
            return mContentResolver;
        }
        return (ContentResolver) invokeV.objValue;
    }

    private String getProcessName() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65545, this)) == null) {
            if (Build.VERSION.SDK_INT >= 28) {
                return Application.getProcessName();
            }
            String str = u85.a;
            ActivityManager activityManager = (ActivityManager) TbadkCoreApplication.getInst().getSystemService("activity");
            if (activityManager != null) {
                List<ActivityManager.RunningAppProcessInfo> runningAppProcesses = activityManager.getRunningAppProcesses();
                int myPid = Process.myPid();
                if (runningAppProcesses != null) {
                    for (ActivityManager.RunningAppProcessInfo runningAppProcessInfo : runningAppProcesses) {
                        if (runningAppProcessInfo != null && runningAppProcessInfo.pid == myPid) {
                            return runningAppProcessInfo.processName;
                        }
                    }
                    return str;
                }
                return str;
            }
            return str;
        }
        return (String) invokeV.objValue;
    }

    public void commit() {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) != null) || this.kvMap.isEmpty()) {
            return;
        }
        if (UniKVTestSwitch.isTypeSp() || UniKVTestSwitch.isTypeDoubleKv() || UniKVTestSwitch.isTypeDoubleSp()) {
            commitInternal(getSharedPreferences());
        }
        if (UniKVTestSwitch.isTypeDoubleSp() || UniKVTestSwitch.isTypeDoubleKv()) {
            commitInternal(getSharedPreferencesKV());
        }
        this.kvMap.clear();
    }

    public String getContentPrefix() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) {
            if (this.cachedPrefix == null) {
                String packageName = TbadkCoreApplication.getInst().getContext().getPackageName();
                if ("com.baidu.tieba".equals(packageName)) {
                    this.cachedPrefix = "content://com.baidu.tbadk.core.sharedPref.MainSharedPrefProvider/";
                } else {
                    this.cachedPrefix = DownloadConstants.LOCAL_DATA_URI_PREFIX + packageName + ".sharedPref.MainSharedPrefProvider/";
                }
            }
            return this.cachedPrefix;
        }
        return (String) invokeV.objValue;
    }

    public void syncCommit() {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeV(1048599, this) != null) || this.kvMap.isEmpty()) {
            return;
        }
        if (UniKVTestSwitch.isTypeSp() || UniKVTestSwitch.isTypeDoubleKv() || UniKVTestSwitch.isTypeDoubleSp()) {
            syncCommitInternal(getSharedPreferences());
        }
        if (UniKVTestSwitch.isTypeDoubleSp() || UniKVTestSwitch.isTypeDoubleKv()) {
            syncCommitInternal(getSharedPreferencesKV());
        }
        this.kvMap.clear();
    }

    private void putValue(String str, float f) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLF(65554, this, str, f) == null) {
            Uri parse = Uri.parse(getContentPrefix() + str);
            ContentValues contentValues = new ContentValues();
            contentValues.put(str, String.valueOf(f));
            setValue(parse, contentValues);
        }
    }

    public void syncPutInt(String str, int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLI(1048600, this, str, i) == null) {
            if (UniKVTestSwitch.isTypeSp() || UniKVTestSwitch.isTypeDoubleKv() || UniKVTestSwitch.isTypeDoubleSp()) {
                syncPutIntInternal(str, i, getSharedPreferences());
            }
            if (UniKVTestSwitch.isTypeDoubleSp() || UniKVTestSwitch.isTypeDoubleKv()) {
                syncPutIntInternal(str, i, getSharedPreferencesKV());
            }
        }
    }

    public void syncPutLong(String str, long j) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLJ(1048601, this, str, j) == null) {
            if (UniKVTestSwitch.isTypeSp() || UniKVTestSwitch.isTypeDoubleKv() || UniKVTestSwitch.isTypeDoubleSp()) {
                syncPutLongInternal(str, j, getSharedPreferences());
            }
            if (UniKVTestSwitch.isTypeDoubleSp() || UniKVTestSwitch.isTypeDoubleKv()) {
                syncPutLongInternal(str, j, getSharedPreferencesKV());
            }
        }
    }

    private void putValue(String str, int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLI(65555, this, str, i) == null) {
            Uri parse = Uri.parse(getContentPrefix() + str);
            ContentValues contentValues = new ContentValues();
            contentValues.put(str, String.valueOf(i));
            setValue(parse, contentValues);
        }
    }

    private void putValue(String str, long j) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLJ(65556, this, str, j) == null) {
            Uri parse = Uri.parse(getContentPrefix() + str);
            ContentValues contentValues = new ContentValues();
            contentValues.put(str, String.valueOf(j));
            setValue(parse, contentValues);
        }
    }

    private void putValue(String str, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLZ(65558, this, str, z) == null) {
            Uri parse = Uri.parse(getContentPrefix() + str);
            ContentValues contentValues = new ContentValues();
            contentValues.put(str, String.valueOf(z));
            setValue(parse, contentValues);
        }
    }

    public void clear() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            if (UniKVTestSwitch.isTypeSp() || UniKVTestSwitch.isTypeDoubleKv() || UniKVTestSwitch.isTypeDoubleSp()) {
                clearInternal(getSharedPreferences());
            }
            if (UniKVTestSwitch.isTypeDoubleSp() || UniKVTestSwitch.isTypeDoubleKv()) {
                clearInternal(getSharedPreferencesKV());
            }
        }
    }

    public void clearByAccount(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str) == null) {
            if (UniKVTestSwitch.isTypeSp() || UniKVTestSwitch.isTypeDoubleKv() || UniKVTestSwitch.isTypeDoubleSp()) {
                clearByAccountInternal(str, getSharedPreferences());
            }
            if (UniKVTestSwitch.isTypeDoubleSp() || UniKVTestSwitch.isTypeDoubleKv()) {
                clearByAccountInternal(str, getSharedPreferencesKV());
            }
        }
    }

    public String getValue(Uri uri) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048589, this, uri)) == null) {
            try {
                return mContentResolver.getType(uri);
            } catch (SecurityException e) {
                BdLog.detailException(e);
                return null;
            }
        }
        return (String) invokeL.objValue;
    }

    public boolean isContains(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048590, this, str)) == null) {
            if (checkIsCommon(str)) {
                return false;
            }
            if (!UniKVTestSwitch.isTypeSp() && !UniKVTestSwitch.isTypeDoubleSp()) {
                if (!this.kvMap.containsKey(str) && !getSharedPreferencesKV().contains(str)) {
                    return false;
                }
                return true;
            } else if (!this.kvMap.containsKey(str) && !getSharedPreferences().contains(str)) {
                return false;
            } else {
                return true;
            }
        }
        return invokeL.booleanValue;
    }

    public void remove(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048596, this, str) == null) {
            if (checkIsCommon(str)) {
                removeValue(str);
            } else if (this.kvMap.containsKey(str)) {
                this.kvMap.remove(str);
            } else {
                if (UniKVTestSwitch.isTypeSp() || UniKVTestSwitch.isTypeDoubleKv() || UniKVTestSwitch.isTypeDoubleSp()) {
                    removeInternal(str, getSharedPreferences());
                }
                if (UniKVTestSwitch.isTypeDoubleSp() || UniKVTestSwitch.isTypeDoubleKv()) {
                    removeInternal(str, getSharedPreferencesKV());
                }
            }
        }
    }
}
