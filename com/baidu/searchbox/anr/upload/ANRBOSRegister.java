package com.baidu.searchbox.anr.upload;

import android.content.Context;
import android.text.TextUtils;
import android.util.Log;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.pyramid.annotation.Service;
import com.baidu.searchbox.anr.impl.ANRInfo;
import com.baidu.searchbox.anr.ioc.IANRRegister;
import com.baidu.searchbox.anr.ubc.UbcANRRegister;
import com.baidu.searchbox.aperf.bosuploader.uploadstrategy.FileUploadStrategy;
import com.baidu.searchbox.config.AppConfig;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.io.File;
import java.util.ArrayList;
import java.util.List;
@Service
/* loaded from: classes3.dex */
public class ANRBOSRegister implements IANRRegister {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public FileUploadStrategy fileUploadStrategy;
    public List<File> uploadFiles;
    public String uploadType;

    public ANRBOSRegister() {
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
        this.uploadType = "anr";
        this.fileUploadStrategy = new FileUploadStrategy();
        this.uploadFiles = new ArrayList();
    }

    private void fileUploadBOS(List<File> list, String str) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(65537, this, list, str) == null) || list.isEmpty() || TextUtils.isEmpty(str)) {
            return;
        }
        this.fileUploadStrategy.upload(list, str, this.uploadType);
    }

    @Override // com.baidu.searchbox.anr.ioc.IANRRegister
    public boolean checkEnable() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? UbcANRRegister.sEnable : invokeV.booleanValue;
    }

    @Override // com.baidu.searchbox.anr.ioc.IANRRegister
    public void onANR(Context context, ANRInfo aNRInfo) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, context, aNRInfo) == null) && checkEnable()) {
            AppConfig.isDebug();
            Log.d("Ruka", "onANR  at ANRBOSRegister");
            this.uploadFiles.clear();
            if (!TextUtils.isEmpty(aNRInfo.getLogcatPath())) {
                File file = new File(aNRInfo.getLogcatPath());
                if (file.exists()) {
                    this.uploadFiles.add(file);
                }
            }
            if (!TextUtils.isEmpty(aNRInfo.getTracesPath())) {
                File file2 = new File(aNRInfo.getTracesPath());
                if (file2.exists() && file2.canRead()) {
                    this.uploadFiles.add(file2);
                    fileUploadBOS(this.uploadFiles, aNRInfo.getLogId());
                    return;
                }
            }
            if (TextUtils.isEmpty(aNRInfo.getAllStackTracePath())) {
                return;
            }
            File file3 = new File(aNRInfo.getAllStackTracePath());
            if (file3.exists()) {
                this.uploadFiles.add(file3);
                fileUploadBOS(this.uploadFiles, aNRInfo.getLogId());
            }
        }
    }

    public void retryUpload() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) && FileUploadStrategy.checkFlag()) {
            this.fileUploadStrategy.upload();
        }
    }
}
