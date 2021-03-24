package com.baidu.searchbox.logsystem.logsys;
/* loaded from: classes3.dex */
public class SnapshotConstant {

    /* loaded from: classes3.dex */
    public static final class DeviceConstants {
        public static final String DEVICE_APP_DB_INFO = "pre_d_db_info";
        public static final String DEVICE_APP_LOGCAT_FILE_NAME = "pre_d_logcat_log";
        public static final String DEVICE_APP_SHARED_FRAGMENT_FILE = "pre_d_fragment_data";
        public static final String DEVICE_INFO = "pre_d_device_info";
    }

    /* loaded from: classes3.dex */
    public static final class DeviceFilePathConstants {
        public static final String DEVICE_BUILD_CONFIG = "/system/build.prop";
        public static final String DEVICE_ION_HEAP = "/sys/kernel/debug/ion/ion_mm_heap";
        public static final String DEVICE_MALI_GPU_MEMORY = "/sys/kernel/debug/mali/gpu_memory";
        public static final String DEVICE_MALI_GPU_MEMORY_0 = "/sys/kernel/debug/mali0/gpu_memory";
        public static final String DEVICE_VERSION = "/proc/version";
    }

    /* loaded from: classes3.dex */
    public static final class ExtConstant {
        public static final String EXT_FILE_PREFIX = "ext_";
    }

    /* loaded from: classes3.dex */
    public static final class LocalConstants {
        public static final String LOCAL_PREFIX = "local_";
        public static final String LOCAL_PROCESS_PATH_NAME_KEEPER = "local_p_path_name_keeper";
    }

    /* loaded from: classes3.dex */
    public static final class ProcessConstants {
        public static final String PROCESS_LOG_BASIC_DATA = "pre_p_log_basicdata";
        public static final String PROCESS_MEM_STATUS = "pre_p_memory_status";
        public static final String PROCESS_RUNNING_STATUS = "pre_p_running_status";
        public static final String PROCESS_SHARED_FRAGMENT_FILE = "pre_p_fragment_data";
        public static final String PROC_FD_INFO = "pre_p_file_descriptor";
        public static final String PROC_MAPS = "pre_p_maps";
        public static final String PROC_SMAPS_FILE = "pre_p_smaps";
        public static final String PROC_STATUS = "pre_p_status";
        public static final String PROC_THREADS_INFO = "pre_p_thread_list";
        public static final String PROC_UI_TRACE = "pre_p_activity_fragment_trace";
    }

    public static void init() {
    }
}
