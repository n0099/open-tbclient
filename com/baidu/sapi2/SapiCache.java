package com.baidu.sapi2;

import android.annotation.TargetApi;
import android.content.Context;
import android.net.Uri;
import android.os.Build;
import android.os.Environment;
import android.text.TextUtils;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.down.request.db.DownloadDataConstants;
import com.baidu.fsg.face.base.b.c;
import com.baidu.mobads.container.util.AdIconUtil;
import com.baidu.pass.common.SecurityUtil;
import com.baidu.pass.http.ReqPriority;
import com.baidu.sapi2.SapiOptions;
import com.baidu.sapi2.httpwrap.HttpClientWrap;
import com.baidu.sapi2.httpwrap.HttpHandlerWrap;
import com.baidu.sapi2.httpwrap.HttpHashMapWrap;
import com.baidu.sapi2.outsdk.OneKeyLoginSdkCall;
import com.baidu.sapi2.share.face.FaceLoginService;
import com.baidu.sapi2.utils.FileUtil;
import com.baidu.sapi2.utils.Log;
import com.baidu.sapi2.utils.SapiDeviceInfo;
import com.baidu.sapi2.utils.SapiUtils;
import com.baidu.sapi2.utils.StatService;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.meizu.cloud.pushsdk.notification.model.AppIconSetting;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.lang.ref.SoftReference;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes5.dex */
public final class SapiCache {
    public static /* synthetic */ Interceptable $ic;
    public static final Map<String, SoftReference<String>> cache;
    public transient /* synthetic */ FieldHolder $fh;
    public Context context;
    public final List<String> newModuleIds;
    public final List<String> oldModuleIds;

    /* loaded from: classes5.dex */
    public interface LoadModuleEventListener {
        void onFailure(SapiOptions.Cache.Module module);

        void onSuccess(SapiOptions.Cache.Module module, String str);
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(359459858, "Lcom/baidu/sapi2/SapiCache;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(359459858, "Lcom/baidu/sapi2/SapiCache;");
                return;
            }
        }
        cache = new ConcurrentHashMap();
    }

    public SapiCache() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.oldModuleIds = new ArrayList();
        this.newModuleIds = new ArrayList();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void initSomeSwitch(SapiOptions sapiOptions) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(AdIconUtil.AD_TEXT_ID, this, sapiOptions) == null) {
            SapiConfiguration sapiConfiguration = SapiAccountManager.getInstance().getSapiConfiguration();
            new FaceLoginService().syncFaceLoginUID(this.context, null);
            resetFileExecPer(sapiOptions.resetFileExecPer);
            if (sapiConfiguration.syncOneKeyLoginInfo) {
                new OneKeyLoginSdkCall().preGetPhoneInfo(sapiConfiguration, "init");
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void reportDi() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(AdIconUtil.BAIDU_LOGO_ID, this) == null) {
            String deviceInfo = SapiDeviceInfo.getDeviceInfo("/static/appsapi/conf/android-conf.txt");
            if (TextUtils.isEmpty(deviceInfo)) {
                return;
            }
            StatService.onEvent("dvif_interface", Collections.singletonMap(AppIconSetting.DEFAULT_LARGE_ICON, deviceInfo));
        }
    }

    public String get(Context context, String str) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048576, this, context, str)) == null) {
            invalidate();
            if (SapiContext.getInstance().getSapiOptions().getCache().isEnabled()) {
                String loadModuleFromMemory = loadModuleFromMemory(str);
                if (TextUtils.isEmpty(loadModuleFromMemory)) {
                    SapiOptions.Cache.Module moduleById = getModuleById(str);
                    if (moduleById != null) {
                        loadModuleFromExternal(moduleById, new LoadModuleEventListener(this, context) { // from class: com.baidu.sapi2.SapiCache.1
                            public static /* synthetic */ Interceptable $ic;
                            public transient /* synthetic */ FieldHolder $fh;
                            public final /* synthetic */ SapiCache this$0;
                            public final /* synthetic */ Context val$context;

                            {
                                Interceptable interceptable2 = $ic;
                                if (interceptable2 != null) {
                                    InitContext newInitContext = TitanRuntime.newInitContext();
                                    newInitContext.initArgs = r2;
                                    Object[] objArr = {this, context};
                                    interceptable2.invokeUnInit(65536, newInitContext);
                                    int i2 = newInitContext.flag;
                                    if ((i2 & 1) != 0) {
                                        int i3 = i2 & 2;
                                        newInitContext.thisArg = this;
                                        interceptable2.invokeInitBody(65536, newInitContext);
                                        return;
                                    }
                                }
                                this.this$0 = this;
                                this.val$context = context;
                            }

                            @Override // com.baidu.sapi2.SapiCache.LoadModuleEventListener
                            public void onFailure(SapiOptions.Cache.Module module) {
                                Interceptable interceptable2 = $ic;
                                if (interceptable2 == null || interceptable2.invokeL(1048576, this, module) == null) {
                                    this.this$0.loadModuleFromInternal(this.val$context, module);
                                }
                            }

                            @Override // com.baidu.sapi2.SapiCache.LoadModuleEventListener
                            public void onSuccess(SapiOptions.Cache.Module module, String str2) {
                                Interceptable interceptable2 = $ic;
                                if (interceptable2 == null || interceptable2.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, module, str2) == null) {
                                    this.this$0.put(module.id, str2);
                                }
                            }
                        });
                    }
                    return loadModuleFromMemory(str);
                }
                return loadModuleFromMemory;
            }
            return null;
        }
        return (String) invokeLL.objValue;
    }

    public String getCacheData(Context context, String str) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLL = interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, context, str)) == null) ? get(context, getCacheModuleId(str)) : (String) invokeLL.objValue;
    }

    public String getCacheModuleId(String str) {
        InterceptResult invokeL;
        String str2;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, str)) == null) {
            Uri parse = Uri.parse(str);
            StringBuilder sb = new StringBuilder();
            sb.append(parse.getHost());
            if (parse.getPort() == -1) {
                str2 = "";
            } else {
                str2 = ":" + parse.getPort();
            }
            sb.append(str2);
            sb.append(parse.getPath());
            String sb2 = sb.toString();
            if (sb2.endsWith(DownloadDataConstants.DEFAULT_DL_HTML_EXTENSION)) {
                return sb2;
            }
            return sb2 + DownloadDataConstants.DEFAULT_DL_HTML_EXTENSION;
        }
        return (String) invokeL.objValue;
    }

    public SapiOptions.Cache.Module getModuleById(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048579, this, str)) == null) {
            for (SapiOptions.Cache.Module module : SapiContext.getInstance().getSapiOptions().getCache().getModules()) {
                if (module.id.equals(str)) {
                    return module;
                }
            }
            return null;
        }
        return (SapiOptions.Cache.Module) invokeL.objValue;
    }

    public void handleCachePage(String str, SapiOptions.Cache.Module module) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(1048580, this, str, module) == null) || TextUtils.isEmpty(module.id) || TextUtils.isEmpty(str) || !module.hash.equals(SecurityUtil.md5(str.getBytes(), false))) {
            return;
        }
        put(module.id, str);
        writeInternal(this.context, SapiOptions.Cache.Module.getInternalFile(module.id), str.getBytes());
        if (SapiUtils.checkRequestPermission("android.permission.WRITE_EXTERNAL_STORAGE", this.context)) {
            writeExternal(SapiOptions.Cache.Module.getExternalFile(module.id), str.getBytes());
        }
    }

    public void handleOptions(String str, SapiOptions sapiOptions) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048581, this, str, sapiOptions) == null) {
            try {
                JSONObject jSONObject = new JSONObject(str);
                SapiOptions fromJSON = SapiOptions.fromJSON(jSONObject);
                SapiContext.getInstance().setSapiOptions(fromJSON);
                SapiContext.getInstance().setPkgSigns(SapiOptions.PkgSigns.fromJSON(jSONObject));
                SapiOptions.Cache cache2 = fromJSON.getCache();
                SapiOptions.Cache cache3 = sapiOptions.getCache();
                initSomeSwitch(fromJSON);
                this.newModuleIds.clear();
                if (cache2.isEnabled()) {
                    for (SapiOptions.Cache.Module module : cache2.getModules()) {
                        this.newModuleIds.add(module.id);
                    }
                    for (SapiOptions.Cache.Module module2 : cache2.getModules()) {
                        SapiOptions.Cache.Module module3 = null;
                        for (SapiOptions.Cache.Module module4 : cache3.getModules()) {
                            if (module4.id.equals(module2.id)) {
                                module3 = module4;
                            }
                        }
                        if (needUpdate(module2, module3)) {
                            loadModuleFromExternal(module2, new LoadModuleEventListener(this, module2, fromJSON, cache3) { // from class: com.baidu.sapi2.SapiCache.4
                                public static /* synthetic */ Interceptable $ic;
                                public transient /* synthetic */ FieldHolder $fh;
                                public final /* synthetic */ SapiCache this$0;
                                public final /* synthetic */ SapiOptions.Cache.Module val$newModule;
                                public final /* synthetic */ SapiOptions val$newOptions;
                                public final /* synthetic */ SapiOptions.Cache val$oldCache;

                                {
                                    Interceptable interceptable2 = $ic;
                                    if (interceptable2 != null) {
                                        InitContext newInitContext = TitanRuntime.newInitContext();
                                        newInitContext.initArgs = r2;
                                        Object[] objArr = {this, module2, fromJSON, cache3};
                                        interceptable2.invokeUnInit(65536, newInitContext);
                                        int i2 = newInitContext.flag;
                                        if ((i2 & 1) != 0) {
                                            int i3 = i2 & 2;
                                            newInitContext.thisArg = this;
                                            interceptable2.invokeInitBody(65536, newInitContext);
                                            return;
                                        }
                                    }
                                    this.this$0 = this;
                                    this.val$newModule = module2;
                                    this.val$newOptions = fromJSON;
                                    this.val$oldCache = cache3;
                                }

                                @Override // com.baidu.sapi2.SapiCache.LoadModuleEventListener
                                public void onFailure(SapiOptions.Cache.Module module5) {
                                    Interceptable interceptable2 = $ic;
                                    if (interceptable2 == null || interceptable2.invokeL(1048576, this, module5) == null) {
                                        new HttpClientWrap().get(this.val$newModule.downloadUrl, ReqPriority.IMMEDIATE, new HttpHashMapWrap(), null, null, new HttpHandlerWrap(this, true) { // from class: com.baidu.sapi2.SapiCache.4.1
                                            public static /* synthetic */ Interceptable $ic;
                                            public transient /* synthetic */ FieldHolder $fh;
                                            public final /* synthetic */ AnonymousClass4 this$1;

                                            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                            {
                                                super(r8);
                                                Interceptable interceptable3 = $ic;
                                                if (interceptable3 != null) {
                                                    InitContext newInitContext = TitanRuntime.newInitContext();
                                                    newInitContext.initArgs = r2;
                                                    Object[] objArr = {this, Boolean.valueOf(r8)};
                                                    interceptable3.invokeUnInit(65536, newInitContext);
                                                    int i2 = newInitContext.flag;
                                                    if ((i2 & 1) != 0) {
                                                        int i3 = i2 & 2;
                                                        super(((Boolean) newInitContext.callArgs[0]).booleanValue());
                                                        newInitContext.thisArg = this;
                                                        interceptable3.invokeInitBody(65536, newInitContext);
                                                        return;
                                                    }
                                                }
                                                this.this$1 = this;
                                            }

                                            @Override // com.baidu.sapi2.httpwrap.HttpHandlerWrap
                                            public void onFailure(Throwable th, int i2, String str2) {
                                                Interceptable interceptable3 = $ic;
                                                if (interceptable3 == null || interceptable3.invokeLIL(1048576, this, th, i2, str2) == null) {
                                                    AnonymousClass4 anonymousClass4 = this.this$1;
                                                    anonymousClass4.val$newOptions.setCache(anonymousClass4.val$oldCache);
                                                    SapiContext.getInstance().setSapiOptions(this.this$1.val$newOptions);
                                                }
                                            }

                                            @Override // com.baidu.sapi2.httpwrap.HttpHandlerWrap
                                            public void onSuccess(int i2, String str2) {
                                                Interceptable interceptable3 = $ic;
                                                if (interceptable3 == null || interceptable3.invokeIL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i2, str2) == null) {
                                                    AnonymousClass4 anonymousClass4 = this.this$1;
                                                    anonymousClass4.this$0.handleCachePage(str2, anonymousClass4.val$newModule);
                                                }
                                            }
                                        });
                                    }
                                }

                                @Override // com.baidu.sapi2.SapiCache.LoadModuleEventListener
                                public void onSuccess(SapiOptions.Cache.Module module5, String str2) {
                                    Interceptable interceptable2 = $ic;
                                    if (!(interceptable2 == null || interceptable2.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, module5, str2) == null) || TextUtils.isEmpty(this.val$newModule.id) || TextUtils.isEmpty(str2)) {
                                        return;
                                    }
                                    this.this$0.put(this.val$newModule.id, str2);
                                    SapiCache sapiCache = this.this$0;
                                    sapiCache.writeInternal(sapiCache.context, SapiOptions.Cache.Module.getInternalFile(this.val$newModule.id), str2.getBytes());
                                }
                            });
                        } else {
                            loadModuleFromExternal(module2, new LoadModuleEventListener(this) { // from class: com.baidu.sapi2.SapiCache.5
                                public static /* synthetic */ Interceptable $ic;
                                public transient /* synthetic */ FieldHolder $fh;
                                public final /* synthetic */ SapiCache this$0;

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
                                    this.this$0 = this;
                                }

                                @Override // com.baidu.sapi2.SapiCache.LoadModuleEventListener
                                public void onFailure(SapiOptions.Cache.Module module5) {
                                    Interceptable interceptable2 = $ic;
                                    if (interceptable2 == null || interceptable2.invokeL(1048576, this, module5) == null) {
                                        String internalFile = SapiOptions.Cache.Module.getInternalFile(module5.id);
                                        String externalFile = SapiOptions.Cache.Module.getExternalFile(module5.id);
                                        if (new File(this.this$0.context.getFilesDir(), internalFile).exists()) {
                                            try {
                                                String loadDataFromInternal = this.this$0.loadDataFromInternal(this.this$0.context, internalFile);
                                                if (Build.VERSION.SDK_INT >= 30 || SapiUtils.checkRequestPermission("android.permission.WRITE_EXTERNAL_STORAGE", this.this$0.context)) {
                                                    this.this$0.writeExternal(externalFile, loadDataFromInternal.getBytes());
                                                }
                                            } catch (Throwable th) {
                                                Log.e(th);
                                            }
                                        }
                                    }
                                }

                                @Override // com.baidu.sapi2.SapiCache.LoadModuleEventListener
                                public void onSuccess(SapiOptions.Cache.Module module5, String str2) {
                                    Interceptable interceptable2 = $ic;
                                    if (interceptable2 == null || interceptable2.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, module5, str2) == null) {
                                    }
                                }
                            });
                        }
                    }
                }
            } catch (JSONException unused) {
            }
        }
    }

    public void init(Context context) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048582, this, context) == null) {
            this.context = context.getApplicationContext();
            SapiOptions sapiOptions = SapiContext.getInstance().getSapiOptions();
            loadCache(sapiOptions);
            syncCache(sapiOptions);
        }
    }

    public void invalidate() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048583, this) == null) {
            ArrayList<String> arrayList = new ArrayList();
            for (String str : this.oldModuleIds) {
                if (!this.newModuleIds.contains(str)) {
                    arrayList.add(str);
                    remove(str);
                }
            }
            for (String str2 : arrayList) {
                if (this.oldModuleIds.contains(str2)) {
                    this.oldModuleIds.remove(str2);
                }
            }
        }
    }

    public void loadCache(SapiOptions sapiOptions) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, sapiOptions) == null) {
            SapiOptions.Cache cache2 = sapiOptions.getCache();
            if (cache2.isEnabled()) {
                for (SapiOptions.Cache.Module module : cache2.getModules()) {
                    this.oldModuleIds.add(module.id);
                }
                this.newModuleIds.addAll(this.oldModuleIds);
                for (SapiOptions.Cache.Module module2 : cache2.getModules()) {
                    loadModuleFromExternal(module2, new LoadModuleEventListener(this) { // from class: com.baidu.sapi2.SapiCache.2
                        public static /* synthetic */ Interceptable $ic;
                        public transient /* synthetic */ FieldHolder $fh;
                        public final /* synthetic */ SapiCache this$0;

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
                            this.this$0 = this;
                        }

                        @Override // com.baidu.sapi2.SapiCache.LoadModuleEventListener
                        public void onFailure(SapiOptions.Cache.Module module3) {
                            Interceptable interceptable2 = $ic;
                            if (interceptable2 == null || interceptable2.invokeL(1048576, this, module3) == null) {
                                SapiCache sapiCache = this.this$0;
                                sapiCache.loadModuleFromInternal(sapiCache.context, module3);
                            }
                        }

                        @Override // com.baidu.sapi2.SapiCache.LoadModuleEventListener
                        public void onSuccess(SapiOptions.Cache.Module module3, String str) {
                            Interceptable interceptable2 = $ic;
                            if (interceptable2 == null || interceptable2.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, module3, str) == null) {
                                this.this$0.put(module3.id, str);
                            }
                        }
                    });
                }
            }
        }
    }

    public String loadDataFromExternal(File file) throws IOException {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(1048585, this, file)) == null) ? FileUtil.read(file.getAbsolutePath()) : (String) invokeL.objValue;
    }

    @TargetApi(4)
    public String loadDataFromInternal(Context context, String str) throws IOException {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048586, this, context, str)) == null) {
            return FileUtil.read(context.getApplicationInfo().dataDir + File.separator + c.f39841g + File.separator + str);
        }
        return (String) invokeLL.objValue;
    }

    public void loadModuleFromExternal(SapiOptions.Cache.Module module, LoadModuleEventListener loadModuleEventListener) {
        File file;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048587, this, module, loadModuleEventListener) == null) {
            if (loadModuleEventListener != null) {
                String externalFile = SapiOptions.Cache.Module.getExternalFile(module.id);
                try {
                    if ("mounted".equals(Environment.getExternalStorageState())) {
                        if (Build.VERSION.SDK_INT >= 30) {
                            file = new File(this.context.getExternalCacheDir(), externalFile);
                        } else {
                            file = new File(Environment.getExternalStorageDirectory(), externalFile);
                        }
                        if (file.exists()) {
                            String loadDataFromExternal = loadDataFromExternal(file);
                            if (SecurityUtil.md5(loadDataFromExternal.getBytes(), false).equals(module.hash)) {
                                loadModuleEventListener.onSuccess(module, loadDataFromExternal);
                                return;
                            } else {
                                loadModuleEventListener.onFailure(module);
                                return;
                            }
                        }
                        loadModuleEventListener.onFailure(module);
                        return;
                    }
                    return;
                } catch (Throwable unused) {
                    loadModuleEventListener.onFailure(module);
                    return;
                }
            }
            throw new IllegalArgumentException(LoadModuleEventListener.class.getName() + "can't be null");
        }
    }

    public void loadModuleFromInternal(Context context, SapiOptions.Cache.Module module) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048588, this, context, module) == null) {
            String internalFile = SapiOptions.Cache.Module.getInternalFile(module.id);
            if (new File(context.getFilesDir(), internalFile).exists()) {
                try {
                    put(module.id, loadDataFromInternal(context, internalFile));
                } catch (Throwable th) {
                    Log.e(th);
                }
            }
        }
    }

    public String loadModuleFromMemory(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048589, this, str)) == null) {
            if (!cache.containsKey(str) || cache.get(str) == null) {
                return null;
            }
            String str2 = cache.get(str).get();
            if (TextUtils.isEmpty(str2)) {
                return null;
            }
            return str2;
        }
        return (String) invokeL.objValue;
    }

    public boolean needUpdate(SapiOptions.Cache.Module module, SapiOptions.Cache.Module module2) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLL = interceptable.invokeLL(1048590, this, module, module2)) == null) ? !TextUtils.isEmpty(module.hash) && (module2 == null || !module.hash.equals(module2.hash)) : invokeLL.booleanValue;
    }

    public void put(String str, String str2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048591, this, str, str2) == null) {
            cache.put(str, new SoftReference<>(str2));
        }
    }

    public void remove(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048592, this, str) == null) {
            cache.remove(str);
        }
    }

    /* JADX DEBUG: Another duplicated slice has different insns count: {[IF]}, finally: {[IF, INVOKE] complete} */
    @TargetApi(4)
    public void resetFileExecPer(boolean z) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeZ(1048593, this, z) == null) && z) {
            String packageDirExecutePer = SapiContext.getInstance().getPackageDirExecutePer();
            if (TextUtils.isEmpty(packageDirExecutePer)) {
                return;
            }
            Process process = null;
            try {
                try {
                    Runtime runtime = Runtime.getRuntime();
                    process = runtime.exec("chmod " + packageDirExecutePer + " " + this.context.getApplicationInfo().dataDir);
                    if (process.waitFor() == 0) {
                        SapiContext.getInstance().setPackageDirExecutePer("");
                    }
                    if (process == null) {
                        return;
                    }
                } catch (Exception e2) {
                    Log.e(e2);
                    if (process == null) {
                        return;
                    }
                }
                process.destroy();
            } catch (Throwable th) {
                if (process != null) {
                    process.destroy();
                }
                throw th;
            }
        }
    }

    public void syncCache(SapiOptions sapiOptions) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048594, this, sapiOptions) == null) {
            HttpHashMapWrap httpHashMapWrap = new HttpHashMapWrap();
            String str = SapiAccountManager.getInstance().getSapiConfiguration().environment.getConfigHttpsUrl() + "/static/appsapi/conf/android-conf.txt";
            HashMap<String, String> hashMap = new HashMap<>();
            hashMap.put("If-None-Match", SapiContext.getInstance().getString(SapiContext.KEY_CONFIG_FILE_ETAG));
            try {
                new HttpClientWrap().get(str, ReqPriority.IMMEDIATE, httpHashMapWrap, hashMap, null, null, 0, new HttpHandlerWrap(this, true, sapiOptions) { // from class: com.baidu.sapi2.SapiCache.3
                    public static /* synthetic */ Interceptable $ic;
                    public transient /* synthetic */ FieldHolder $fh;
                    public final /* synthetic */ SapiCache this$0;
                    public final /* synthetic */ SapiOptions val$oldSapiOptions;

                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    {
                        super(r8);
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 != null) {
                            InitContext newInitContext = TitanRuntime.newInitContext();
                            newInitContext.initArgs = r2;
                            Object[] objArr = {this, Boolean.valueOf(r8), sapiOptions};
                            interceptable2.invokeUnInit(65536, newInitContext);
                            int i2 = newInitContext.flag;
                            if ((i2 & 1) != 0) {
                                int i3 = i2 & 2;
                                super(((Boolean) newInitContext.callArgs[0]).booleanValue());
                                newInitContext.thisArg = this;
                                interceptable2.invokeInitBody(65536, newInitContext);
                                return;
                            }
                        }
                        this.this$0 = this;
                        this.val$oldSapiOptions = sapiOptions;
                    }

                    @Override // com.baidu.sapi2.httpwrap.HttpHandlerWrap
                    public void onFailure(Throwable th, int i2, String str2) {
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 == null || interceptable2.invokeLIL(1048576, this, th, i2, str2) == null) {
                            this.this$0.initSomeSwitch(this.val$oldSapiOptions);
                            this.this$0.reportDi();
                        }
                    }

                    @Override // com.baidu.sapi2.httpwrap.HttpHandlerWrap
                    public void onSuccess(int i2, String str2, HashMap<String, String> hashMap2) {
                        Interceptable interceptable2 = $ic;
                        if (!(interceptable2 == null || interceptable2.invokeILL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i2, str2, hashMap2) == null) || str2 == null) {
                            return;
                        }
                        this.this$0.handleOptions(str2, this.val$oldSapiOptions);
                        if (hashMap2 != null) {
                            SapiContext.getInstance().put(SapiContext.KEY_CONFIG_FILE_ETAG, hashMap2.get("ETag"));
                        }
                        this.this$0.reportDi();
                    }
                });
            } catch (Throwable th) {
                Log.e(th);
            }
        }
    }

    public void writeExternal(String str, byte[] bArr) {
        File file;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048595, this, str, bArr) == null) {
            try {
                if ("mounted".equals(Environment.getExternalStorageState())) {
                    if (Build.VERSION.SDK_INT >= 30) {
                        file = new File(this.context.getExternalCacheDir(), str);
                    } else {
                        file = new File(Environment.getExternalStorageDirectory(), str);
                    }
                    FileUtil.write(file, bArr, false);
                }
            } catch (Throwable th) {
                Log.e(th);
            }
        }
    }

    public void writeInternal(Context context, String str, byte[] bArr) {
        FileOutputStream fileOutputStream;
        Interceptable interceptable = $ic;
        if (interceptable != null && interceptable.invokeLLL(1048596, this, context, str, bArr) != null) {
            return;
        }
        try {
            fileOutputStream = context.openFileOutput(str, 0);
            try {
                fileOutputStream.write(bArr);
                if (fileOutputStream == null) {
                    return;
                }
            } catch (Throwable unused) {
                if (fileOutputStream == null) {
                    return;
                }
                fileOutputStream.close();
            }
        } catch (Throwable unused2) {
            fileOutputStream = null;
        }
        try {
            fileOutputStream.close();
        } catch (Throwable unused3) {
        }
    }
}
