package com.baidu.ar.constants;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes5.dex */
public class HttpConstants {
    public static /* synthetic */ Interceptable $ic = null;
    public static final String AIP_APP_ID = "aip_app_id";
    public static final String APP_VERSION = "app_version";
    public static final String AR_KEY = "ar_key";
    public static final String CUID = "cuid";
    public static final String DEVICE_ID = "device_id";
    public static final String DEVICE_TYPE = "device_type";
    public static final String FUNCTION_TYPE = "function_type";
    public static final String HTTP_APP_ID = "app_id";
    public static final String HTTP_AR_VALUE = "ar_value";
    public static final String HTTP_BOARD = "board";
    public static final int HTTP_CONNECT_TIMEOUT = 20000;
    public static final String HTTP_DEVICE_ID = "device_id";
    public static final String HTTP_ENGINE_VERSION = "engine_version";
    public static final String HTTP_GLES_VERSION = "gles_version";
    public static final String HTTP_HARDWARE = "hardware";
    public static final String HTTP_MANUFACTURER = "manufacturer";
    public static final String HTTP_OS_TYPE = "os_type";
    public static final String HTTP_OS_TYPE_OLD = "osType";
    public static final int HTTP_READ_TIMEOUT = 30000;
    public static final String HTTP_SYSTEM_VERSION = "system_version";
    public static final String HTTP_USER_ID = "user_id";
    public static final String IS_AIP = "is_aip";
    public static final String NETWORK_TYPE = "network_type";
    public static final String OS_BRAND = "os_brand";
    public static final String OS_CPU_ABI = "os_cpu_abi";
    public static final String OS_CPU_CUR_FREQ = "os_cpu_cur_freq";
    public static final String OS_CPU_MAX_FREQ = "os_cpu_max_freq";
    public static final String OS_CPU_MIN_FREQ = "os_cpu_min_freq";
    public static final String OS_CPU_NAME = "os_cpu_name";
    public static final String OS_CPU_NUM_CORES = "os_cpu_num_cores";
    public static final String OS_CPU_SUPPORTED_ABIS = "os_cpu_supported_abis";
    public static final String OS_GPU_RENDERER = "os_gpu_renderer";
    public static final String OS_GPU_VENDOR = "os_gpu_vendor";
    public static final String OS_GPU_VERSION = "os_gpu_verion";
    public static final String OS_HAS_GYROSCOPE = "os_has_gyroscope";
    public static final int OS_HAS_GYROSCOPE_VALUE = 1;
    public static final String OS_HEIGHT_PIXELS = "os_height_pixels";
    public static final String OS_MODEL = "os_model";
    public static final String OS_NATIVE_HEAPSIZE = "os_native_heapsize";
    public static final String OS_NATIVE_SENSOR = "os_native_sensor";
    public static final int OS_NOT_HAS_GYROSCOPE_VALUE = 0;
    public static final String OS_RAM_AVAIL_MEMORY = "os_ram_avail_memory";
    public static final String OS_RAM_MEMEORY = "os_ram_memory";
    public static final String OS_ROM_AVAIL_MEMORY = "os_rom_avail_memory";
    public static final String OS_ROM_MEMORY = "os_rom_memory";
    public static final String OS_ROM_SDCARD_AVAIL_MEMORY = "os_sdcard_avail_memory";
    public static final String OS_SCALE_PDI = "os_scale_pdi";
    public static final String OS_SDCARD_MEMORY = "os_sdcard_memory";
    public static final String OS_TYPE_VALUE = "android";
    public static final String OS_VERSION = "os_version";
    public static final String OS_VERSION_RELESE = "os_version_release";
    public static final String OS_VERSION_SDK = "os_version_sdk";
    public static final String OS_WIDTH_PIXELS = "os_width_pixels";
    public static final String SDK_TYPE = "sdk_type";
    public static final String SDK_VERSION_CODE = "sdk_version_code";
    public static final String SDK_VERSION_NAME = "sdk_version_name";
    public static final String SIGN = "sign";
    public static final String TIMESTAMP = "timestamp";
    public transient /* synthetic */ FieldHolder $fh;

    public HttpConstants() {
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
