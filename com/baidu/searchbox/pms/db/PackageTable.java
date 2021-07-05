package com.baidu.searchbox.pms.db;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes3.dex */
public class PackageTable {
    public static /* synthetic */ Interceptable $ic = null;
    public static final String CHANNEL_ID = "channel_id";
    public static final String CREATE_TIME = "create_time";
    public static final String CURRENT_SIZE = "current_size";
    public static final String DEPENDENCY_PACKAGE = "dependency_package";
    public static final String DISABLE = "disable";
    public static final String DOWNLOAD_OPTION = "download_option";
    public static final String DOWNLOAD_URL = "download_url";
    public static final String EXTRA_FROM_LOCAL = "extra_local";
    public static final String EXTRA_FROM_SERVER = "extra_server";
    public static final String FILE_PATH = "file_path";
    public static final String ID = "_id";
    public static final String IS_MAIN_ENTRANCE = "is_main_entrance";
    public static final String IS_SILENCE = "is_silence";
    public static final String MAX_HOST_VERSION = "max_host_version";
    public static final String MD5 = "md5";
    public static final String MIN_HOST_VERSION = "min_host_version";
    public static final String NAME = "name";
    public static final String PACKAGE_NAME = "package_name";
    public static final String SIGN = "sign";
    public static final String SIZE = "size";
    public static final String TABLE_NAME = "package_info";
    public static final String TOTAL_SIZE = "total_size";
    public static final String TYPE = "type";
    public static final String UPDATE_SIGN = "update_sign";
    public static final String UPDATE_TIME = "update_time";
    public static final String UPDATE_VERSION = "update_version";
    public static final String VERSION = "version";
    public static final String WIFI = "wifi";
    public transient /* synthetic */ FieldHolder $fh;

    public PackageTable() {
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
