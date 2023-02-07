package com.baidu.searchbox.retrieve.core.task;

import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.searchbox.retrieve.inter.upload.IActiveUploadListener;
import com.baidu.searchbox.retrieve.inter.upload.IUploadTask;
import com.baidu.searchbox.retrieve.upload.UploadHelper;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.List;
import org.json.JSONObject;
/* loaded from: classes3.dex */
public class UploadTask implements IUploadTask {
    public static /* synthetic */ Interceptable $ic = null;
    public static final long ACTIVE_START_TIME_DEFAULT = 0;
    public static final long SIZE_LIMIT_DEFAULT = 20480;
    public static final long TIME_DELAY_DEFAULT = 60000;
    public transient /* synthetic */ FieldHolder $fh;

    public UploadTask() {
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

    @Override // com.baidu.searchbox.retrieve.inter.upload.IUploadTask
    public void activeUpload(String str, String str2, List<String> list, long j, long j2, long j3, IActiveUploadListener iActiveUploadListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048576, this, new Object[]{str, str2, list, Long.valueOf(j), Long.valueOf(j2), Long.valueOf(j3), iActiveUploadListener}) == null) {
            UploadHelper.getInstance().activeUpload(str, str2, list, j, j2, j3, iActiveUploadListener);
        }
    }

    @Override // com.baidu.searchbox.retrieve.inter.upload.IUploadTask
    public void fetchUpload(String str, String str2, String str3, long j, long j2, long j3, List<String> list) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(InputDeviceCompat.SOURCE_TOUCHPAD, this, new Object[]{str, str2, str3, Long.valueOf(j), Long.valueOf(j2), Long.valueOf(j3), list}) == null) {
            UploadHelper.getInstance().fetchUpload(str, str2, str3, j, j2, j3, list);
        }
    }

    @Override // com.baidu.searchbox.retrieve.inter.upload.IUploadTask
    public void activeUpload(String str, String str2, List<String> list, IActiveUploadListener iActiveUploadListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str, str2, list, iActiveUploadListener) == null) {
            UploadHelper.getInstance().activeUpload(str, str2, list, SIZE_LIMIT_DEFAULT, 0L, System.currentTimeMillis() + 60000, iActiveUploadListener);
        }
    }

    @Override // com.baidu.searchbox.retrieve.inter.upload.IUploadTask
    public void activeUpload(String str, String str2, List<String> list, String str3, long j, long j2, long j3, JSONObject jSONObject) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(Constants.METHOD_SEND_USER_MSG, this, new Object[]{str, str2, list, str3, Long.valueOf(j), Long.valueOf(j2), Long.valueOf(j3), jSONObject}) == null) {
            UploadHelper.getInstance().activeUpload(str, str2, list, str3, j, j2, j3, jSONObject);
        }
    }

    @Override // com.baidu.searchbox.retrieve.inter.upload.IUploadTask
    public void activeUploadSnapShot(String str, String str2, List<String> list, long j, long j2, long j3, boolean z, IActiveUploadListener iActiveUploadListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048582, this, new Object[]{str, str2, list, Long.valueOf(j), Long.valueOf(j2), Long.valueOf(j3), Boolean.valueOf(z), iActiveUploadListener}) == null) {
            UploadHelper.getInstance().activeUploadSnapShot(str, str2, list, j, j2, j3, z, iActiveUploadListener);
        }
    }

    @Override // com.baidu.searchbox.retrieve.inter.upload.IUploadTask
    public void activeUpload(String str, String str2, List<String> list, JSONObject jSONObject) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLLL(1048579, this, str, str2, list, jSONObject) == null) {
            activeUpload(str, str2, list, str, SIZE_LIMIT_DEFAULT, 0L, System.currentTimeMillis() + 60000, jSONObject);
        }
    }

    @Override // com.baidu.searchbox.retrieve.inter.upload.IUploadTask
    public void activeUploadFile(String str, String str2, List<String> list, long j, IActiveUploadListener iActiveUploadListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048580, this, new Object[]{str, str2, list, Long.valueOf(j), iActiveUploadListener}) == null) {
            UploadHelper.getInstance().activeUploadFile(str, str2, list, j, iActiveUploadListener);
        }
    }

    @Override // com.baidu.searchbox.retrieve.inter.upload.IUploadTask
    public void activeUploadFile(String str, String str2, List<String> list, String str3, long j, JSONObject jSONObject) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048581, this, new Object[]{str, str2, list, str3, Long.valueOf(j), jSONObject}) == null) {
            UploadHelper.getInstance().activeUploadFile(str, str2, list, str3, j, jSONObject);
        }
    }

    @Override // com.baidu.searchbox.retrieve.inter.upload.IUploadTask
    public void activeUploadSnapShot(String str, String str2, List<String> list, String str3, long j, long j2, long j3, boolean z, JSONObject jSONObject) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048583, this, new Object[]{str, str2, list, str3, Long.valueOf(j), Long.valueOf(j2), Long.valueOf(j3), Boolean.valueOf(z), jSONObject}) == null) {
            UploadHelper.getInstance().activeUploadSnapShot(str, str2, list, str3, j, j2, j3, z, jSONObject);
        }
    }
}
