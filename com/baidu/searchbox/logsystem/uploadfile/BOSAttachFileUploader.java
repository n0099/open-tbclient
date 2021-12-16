package com.baidu.searchbox.logsystem.uploadfile;

import androidx.annotation.NonNull;
import com.baidu.pyramid.annotation.Service;
import com.baidu.pyramid.annotation.Singleton;
import com.baidu.searchbox.aperf.bosuploader.BOSResponseEntity;
import com.baidu.searchbox.aperf.bosuploader.BOSUploader;
import com.baidu.searchbox.aperf.bosuploader.UploadUrlListener;
import com.baidu.searchbox.logsystem.basic.upload.BaseAttachFileUploader;
import com.baidu.searchbox.logsystem.basic.upload.ResponseEntity;
import com.baidu.searchbox.logsystem.basic.upload.identity.LokiIdentityManager;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.io.File;
@Singleton
@Service
/* loaded from: classes10.dex */
public class BOSAttachFileUploader extends BaseAttachFileUploader {
    public static /* synthetic */ Interceptable $ic = null;
    public static final String BIZ_CRASH = "crash";
    public transient /* synthetic */ FieldHolder $fh;

    public BOSAttachFileUploader() {
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

    @Override // com.baidu.searchbox.logsystem.basic.upload.BaseAttachFileUploader
    public ResponseEntity uploadSync(@NonNull String str, @NonNull File file) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048576, this, str, file)) == null) {
            BOSResponseEntity uploadFileSync = BOSUploader.getInstance().uploadFileSync("crash", str, file, new UploadUrlListener(this) { // from class: com.baidu.searchbox.logsystem.uploadfile.BOSAttachFileUploader.1
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;
                public final /* synthetic */ BOSAttachFileUploader this$0;

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

                @Override // com.baidu.searchbox.aperf.bosuploader.UploadUrlListener
                public String processUrl() {
                    InterceptResult invokeV;
                    Interceptable interceptable2 = $ic;
                    return (interceptable2 == null || (invokeV = interceptable2.invokeV(1048576, this)) == null) ? LokiIdentityManager.getInstance().processUrl(UploadUrlListener.BASE_UPLOAD_URL) : (String) invokeV.objValue;
                }
            });
            return new ResponseEntity(uploadFileSync.isSuccess(), uploadFileSync.getMessage());
        }
        return (ResponseEntity) invokeLL.objValue;
    }
}
