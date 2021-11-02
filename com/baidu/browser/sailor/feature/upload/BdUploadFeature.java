package com.baidu.browser.sailor.feature.upload;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.webkit.ValueCallback;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.browser.core.INoProGuard;
import com.baidu.browser.sailor.BdSailorConfig;
import com.baidu.browser.sailor.feature.a;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.baidu.webkit.sdk.Log;
import com.baidu.webkit.sdk.WebChromeClient;
import java.util.HashMap;
import java.util.Map;
/* loaded from: classes7.dex */
public class BdUploadFeature extends a implements INoProGuard, IUploadFile {
    public static /* synthetic */ Interceptable $ic = null;
    public static final int FILE_SELECTED = 11;
    public transient /* synthetic */ FieldHolder $fh;
    public Map<Activity, BdUploadHandler> mUploadHandlers;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public BdUploadFeature(Context context) {
        super(context);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                super((Context) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.mUploadHandlers = new HashMap();
    }

    @Override // com.baidu.browser.sailor.feature.upload.IUploadFile
    public void cancelUpload(Activity activity) {
        BdUploadHandler uploadHandler;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048576, this, activity) == null) || (uploadHandler = getUploadHandler(activity)) == null) {
            return;
        }
        uploadHandler.cancelUpload();
        this.mUploadHandlers.remove(activity);
    }

    @Override // com.baidu.browser.sailor.feature.a
    public String getName() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? BdSailorConfig.SAILOR_BASE_UPLOAD : (String) invokeV.objValue;
    }

    public BdUploadHandler getUploadHandler(Activity activity) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, activity)) == null) {
            Map<Activity, BdUploadHandler> map = this.mUploadHandlers;
            if (map == null || map.size() <= 0) {
                return null;
            }
            return this.mUploadHandlers.get(activity);
        }
        return (BdUploadHandler) invokeL.objValue;
    }

    public BdUploadHandler makeUploadHandler(Activity activity) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048579, this, activity)) == null) {
            BdUploadHandler uploadHandler = getUploadHandler(activity);
            if (uploadHandler == null) {
                BdUploadHandler bdUploadHandler = new BdUploadHandler(activity);
                this.mUploadHandlers.put(activity, bdUploadHandler);
                return bdUploadHandler;
            }
            return uploadHandler;
        }
        return (BdUploadHandler) invokeL.objValue;
    }

    public void onDestroy(Activity activity) {
        Map<Activity, BdUploadHandler> map;
        BdUploadHandler bdUploadHandler;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048580, this, activity) == null) || activity == null || (map = this.mUploadHandlers) == null || map.size() <= 0 || (bdUploadHandler = this.mUploadHandlers.get(activity)) == null) {
            return;
        }
        this.mUploadHandlers.remove(activity);
        if (bdUploadHandler.handled()) {
            return;
        }
        bdUploadHandler.onResult(0, null);
    }

    @Override // com.baidu.browser.sailor.feature.upload.IUploadFile
    public void onOpenFileChooser(Activity activity, ValueCallback<Uri> valueCallback) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(1048581, this, activity, valueCallback) == null) || activity == null) {
            return;
        }
        makeUploadHandler(activity).onOpenFileChooser(valueCallback, "");
    }

    @Override // com.baidu.browser.sailor.feature.upload.IUploadFile
    public void onOpenFileChooser(Activity activity, ValueCallback<Uri[]> valueCallback, WebChromeClient.FileChooserParams fileChooserParams) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLLL(1048582, this, activity, valueCallback, fileChooserParams) == null) || activity == null) {
            return;
        }
        BdUploadHandler makeUploadHandler = makeUploadHandler(activity);
        if (fileChooserParams != null) {
            makeUploadHandler.onOpenFileChooser(valueCallback, fileChooserParams);
        }
    }

    @Override // com.baidu.browser.sailor.feature.upload.IUploadFile
    public void onResult(Activity activity, int i2, Intent intent) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLIL(1048583, this, activity, i2, intent) == null) {
            BdUploadHandler uploadHandler = getUploadHandler(activity);
            if (uploadHandler == null) {
                Log.d("BdUploadHandler is null.");
                return;
            }
            uploadHandler.onResult(i2, intent);
            this.mUploadHandlers.remove(activity);
        }
    }

    @Override // com.baidu.browser.sailor.feature.upload.IUploadFile
    public void onResult(Activity activity, Uri uri) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(InputDeviceCompat.SOURCE_TOUCHPAD, this, activity, uri) == null) {
            BdUploadHandler uploadHandler = getUploadHandler(activity);
            if (uploadHandler == null) {
                Log.d("BdUploadHandler is null.");
                return;
            }
            uploadHandler.onResult(uri);
            this.mUploadHandlers.remove(activity);
        }
    }

    public boolean openFileChooser(Activity activity, ValueCallback<Uri> valueCallback) {
        InterceptResult invokeLL;
        Map<Activity, BdUploadHandler> map;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048585, this, activity, valueCallback)) == null) {
            boolean openFileChooser = activity != null ? makeUploadHandler(activity).openFileChooser(valueCallback, "") : false;
            if (!openFileChooser) {
                valueCallback.onReceiveValue(null);
                if (activity != null && (map = this.mUploadHandlers) != null) {
                    map.remove(activity);
                }
            }
            return openFileChooser;
        }
        return invokeLL.booleanValue;
    }

    /* JADX WARN: Removed duplicated region for block: B:10:0x0014  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public boolean openFileChooser(Activity activity, ValueCallback<Uri[]> valueCallback, WebChromeClient.FileChooserParams fileChooserParams) {
        InterceptResult invokeLLL;
        boolean z;
        Map<Activity, BdUploadHandler> map;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(1048586, this, activity, valueCallback, fileChooserParams)) == null) {
            if (activity != null) {
                BdUploadHandler makeUploadHandler = makeUploadHandler(activity);
                if (fileChooserParams != null) {
                    z = makeUploadHandler.openFileChooser(valueCallback, fileChooserParams);
                    if (!z) {
                        valueCallback.onReceiveValue(null);
                        if (activity != null && (map = this.mUploadHandlers) != null) {
                            map.remove(activity);
                        }
                    }
                    return z;
                }
            }
            z = false;
            if (!z) {
            }
            return z;
        }
        return invokeLLL.booleanValue;
    }

    public boolean openFileChooser(Activity activity, ValueCallback<Uri> valueCallback, String str) {
        InterceptResult invokeLLL;
        Map<Activity, BdUploadHandler> map;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(1048587, this, activity, valueCallback, str)) == null) {
            boolean openFileChooser = activity != null ? makeUploadHandler(activity).openFileChooser(valueCallback, str) : false;
            if (!openFileChooser) {
                valueCallback.onReceiveValue(null);
                if (activity != null && (map = this.mUploadHandlers) != null) {
                    map.remove(activity);
                }
            }
            return openFileChooser;
        }
        return invokeLLL.booleanValue;
    }

    public boolean openFileChooser(Activity activity, ValueCallback<Uri> valueCallback, String str, String str2) {
        InterceptResult invokeLLLL;
        Map<Activity, BdUploadHandler> map;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLLL = interceptable.invokeLLLL(1048588, this, activity, valueCallback, str, str2)) == null) {
            boolean openFileChooser = activity != null ? makeUploadHandler(activity).openFileChooser(valueCallback, str, str2) : false;
            if (!openFileChooser) {
                valueCallback.onReceiveValue(null);
                if (activity != null && (map = this.mUploadHandlers) != null) {
                    map.remove(activity);
                }
            }
            return openFileChooser;
        }
        return invokeLLLL.booleanValue;
    }

    @Override // com.baidu.browser.sailor.feature.upload.IUploadFile
    public boolean startCameraActivityForResult(Activity activity) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048589, this, activity)) == null) {
            BdUploadHandler uploadHandler = getUploadHandler(activity);
            if (uploadHandler != null) {
                return uploadHandler.startActivityForResult(uploadHandler.createCameraIntent(), 11);
            }
            return false;
        }
        return invokeL.booleanValue;
    }

    @Override // com.baidu.browser.sailor.feature.upload.IUploadFile
    public boolean startImageActivityForResult(Activity activity) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048590, this, activity)) == null) {
            BdUploadHandler uploadHandler = getUploadHandler(activity);
            if (uploadHandler != null) {
                return uploadHandler.startActivityForResult(uploadHandler.createOpenableIntent(BdUploadHandler.IMAGE_MIME_TYPE), 11);
            }
            return false;
        }
        return invokeL.booleanValue;
    }
}
