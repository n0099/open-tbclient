package com.baidu.searchbox.retrieve.upload;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes4.dex */
public final class UploadConstant {
    public static /* synthetic */ Interceptable $ic = null;
    public static final String AC_UPLOAD_TOKEN = "acupload";
    public static final String CONTENT = "content";
    public static final String DATA = "data";
    public static final String DATA_ID = "data_id";
    public static final String ERRMSG = "errmsg";
    public static final String ERRNO = "errno";
    public static final String FETCH_LOG_TOKEN = "fetchlog";
    public static final String FILEMETA = "filemeta";
    public static final String FILE_ID = "fileid";
    public static final String FILE_TYPE = "filetype";
    public static final String FILE_TYPE_FILE = "2";
    public static final String FILE_TYPE_YALOG = "1";
    public static final String JOB_ID = "jobid";
    public static final String KEY_DATA_ID = "dataId";
    public static final String KEY_FILE_META = "fileMeta";
    public static final String KEY_FILE_TYPE = "fileType";
    public static final String KEY_SOURCE = "source";
    public static final String KEY_SPACE = "space";
    public static final String KEY_TYPE = "type";
    public static final String ORIGIN = "origin";
    public static final String PRODUCT = "product";
    public static final String REQ = "req";
    public static final String RESULT_JOB_ID = "jobid";
    public static final String RESULT_VALID = "valid";
    public static final String SIGN = "sign";
    public static final String SPACE = "space";
    public static final String STATUS = "status";
    public static final String TIMESTAMP = "timestamp";
    public static final String TYPE = "type";
    public static final String UPLOAD_SUCCESS_CODE = "0";
    public static final String UPLOAD_TYPE_ACTIVE = "1";
    public static final String UPLOAD_TYPE_FETCH = "0";
    public static final String VALUE = "value";
    public static final String VERSION = "version";
    public transient /* synthetic */ FieldHolder $fh;

    public UploadConstant() {
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
}
