package com.baidu.nps.utils;

import androidx.core.view.InputDeviceCompat;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes3.dex */
public class Constant {
    public static /* synthetic */ Interceptable $ic = null;
    public static final int ALLOW_SILENCE_CODE = 1;
    public static final int ALLOW_SILENCE_UPDATE_CODE = 1;
    public static final int ALLOW_WIFIONLY_CODE = 1;
    public static final int MAX_PATCH_TRY_COUNT = 5;
    public transient /* synthetic */ FieldHolder $fh;

    /* loaded from: classes3.dex */
    public static class AUTHORIZATION {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* loaded from: classes3.dex */
        public static class RESULT {
            public static /* synthetic */ Interceptable $ic = null;
            public static final int CANCEL = 2;
            public static final int CONFIRM = 1;
            public transient /* synthetic */ FieldHolder $fh;

            public RESULT() {
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
        }

        /* loaded from: classes3.dex */
        public static class TYPE {
            public static /* synthetic */ Interceptable $ic = null;
            public static final int UPDATE_MOBILE_CONFIRM = 1;
            public transient /* synthetic */ FieldHolder $fh;

            public TYPE() {
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
        }

        public AUTHORIZATION() {
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
    }

    /* loaded from: classes3.dex */
    public static class BUNDLE {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* loaded from: classes3.dex */
        public static class TYPE {
            public static /* synthetic */ Interceptable $ic = null;
            public static final int BUNDLE_TYPE_BACKUP = 4;
            public static final int BUNDLE_TYPE_DOWNLOADED = 2;
            public static final int BUNDLE_TYPE_INSTALLED = 3;
            public static final int BUNDLE_TYPE_UPDATED = 1;
            public transient /* synthetic */ FieldHolder $fh;

            public TYPE() {
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
        }

        public BUNDLE() {
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
    }

    /* loaded from: classes3.dex */
    public static class EXCEPTION {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* loaded from: classes3.dex */
        public static class ID {
            public static /* synthetic */ Interceptable $ic = null;
            public static final int LOAD_COMPONENT_CLASS = 2;
            public static final int PKG_MGR_MODULE_INIT = 3;
            public static final int PKG_MGR_UBI_PARSE_TIMESTAMP = 1;
            public transient /* synthetic */ FieldHolder $fh;

            public ID() {
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
        }

        public EXCEPTION() {
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
    }

    /* loaded from: classes3.dex */
    public static class FILE {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* loaded from: classes3.dex */
        public static class SUFFIX {
            public static /* synthetic */ Interceptable $ic = null;
            public static final String APK_LIB_SUFFIX = ".so";
            public static final String APK_PATCH_SUFFIX = ".patch";
            public static final String BUNDLE_SUFFIX = ".apk";
            public transient /* synthetic */ FieldHolder $fh;

            public SUFFIX() {
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
        }

        public FILE() {
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
    }

    /* loaded from: classes3.dex */
    public static class ABI {
        public static /* synthetic */ Interceptable $ic = null;
        public static final int ABI_32 = 1;
        public static final int ABI_64 = 2;
        public static final int ABI_ALL = 3;
        public transient /* synthetic */ FieldHolder $fh;

        public ABI() {
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
    }

    /* loaded from: classes3.dex */
    public static class CODE {
        public static /* synthetic */ Interceptable $ic = null;
        public static final int RET_AMBIGUOUS_PKG_NAME = 9;
        public static final int RET_AUTH_ILLEGAL = 56;
        public static final int RET_BUNDLE_CHECK_ERROR = 22;
        public static final int RET_CANCEL = 54;
        public static final int RET_CLASS_INIT_ERROR = 16;
        public static final int RET_CLASS_LOAD_ERROR = 18;
        public static final int RET_COPY_ERROR = 11;
        public static final int RET_DEPENDENCY_NOT_MATCH = 57;
        public static final int RET_DOWNLOAD_BUNDLE_GROUP_NULL_ERROR = 26;
        public static final int RET_DOWNLOAD_CPU_ERROR = 53;
        public static final int RET_DOWNLOAD_HAS_PRESET = 55;
        public static final int RET_DOWNLOAD_NETWOKR_ERROR = 51;
        public static final int RET_DOWNLOAD_NO_DATA = 3;
        public static final int RET_DOWNLOAD_RETBUNDLE_NULL_ERROR = 31;
        public static final int RET_DOWNLOAD_SUB_NOT_COMPATIBLE = 54;
        public static final int RET_DOWNLOAD_SUCCESS = 2;
        public static final int RET_FETCH_RETBUNDLE_NULL_ERROR = 30;
        public static final int RET_FILE_NOT_EXIST = 7;
        public static final int RET_GET_FAILURE = 1;
        public static final int RET_GET_SUCCESS = 0;
        public static final int RET_INIT_PERSET_RETBUNDLE_NULL_ERROR = 32;
        public static final int RET_INSTALL_LOCAL_RETBUNDLE_NULL_ERROR = 29;
        public static final int RET_INSTALL_NATIVE_LIBRARY_ERROR = 12;
        public static final int RET_INSTALL_NEED_RESTART = 50;
        public static final int RET_INSTALL_ONLY_RETBUNDLE_NULL_ERROR = 28;
        public static final int RET_INSTALL_PERSET_RETBUNDLE_NULL_ERROR = 33;
        public static final int RET_INSTALL_RETBUNDLE_NULL_ERROR = 27;
        public static final int RET_INSTALL_SUCCESS = 13;
        public static final int RET_INVALID = -1;
        public static final int RET_INVALID_BUNDLE_INFO = 4;
        public static final int RET_INVALID_FILE_PATH = 6;
        public static final int RET_INVALID_PKG_NAME = 5;
        public static final int RET_INVOKER_INIT_ERROR = 17;
        public static final int RET_INVOKE_SUCCESS = 14;
        public static final int RET_NO_THIS_PKG = 15;
        public static final int RET_OTHER_ERROR = 19;
        public static final int RET_PATCH_ERROR = 52;
        public static final int RET_PKGINFO_LOAD_ERROR = 8;
        public static final int RET_PREPARE_BUNDLE_GROUP_NULL_ERROR = 25;
        public static final int RET_PREPARE_DOWNLOAD_BUNDLE_NULL_ERROR = 23;
        public static final int RET_RESOURCES_HOOK_ERROR = 21;
        public static final int RET_RESOURCES_INIT_ERROR = 20;
        public static final int RET_SIGNATURE_VERIFY_ERROR = 10;
        public static final int RET_UNDER_INSTALL_ERROR = 34;
        public transient /* synthetic */ FieldHolder $fh;

        public CODE() {
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
    }

    /* loaded from: classes3.dex */
    public static class DOWNLOAD {
        public static /* synthetic */ Interceptable $ic = null;
        public static final int DOWNLOAD_NORMAL = 48;
        public static final int DOWNLOAD_SILENCE = 49;
        public static final int DOWNLOAD_TYPE_FULL = 1;
        public static final int DOWNLOAD_TYPE_PATCH = 2;
        public static final int DOWNLOAD_USER_INTERACTIVE = 50;
        public transient /* synthetic */ FieldHolder $fh;

        public DOWNLOAD() {
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
    }

    /* loaded from: classes3.dex */
    public static class FLAG {
        public static /* synthetic */ Interceptable $ic = null;
        public static final int FORCE_UPDATE_ALERT = 16;
        public static final int INSTALL_LOADING = 4;
        public static final int INSTALL_SHOW_DIALOG = 2;
        public static final int SILENT_DOWNLOAD_ALERT = 1;
        public transient /* synthetic */ FieldHolder $fh;

        public FLAG() {
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
    }

    /* loaded from: classes3.dex */
    public static class MSG {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        public static String retMsgBundleNotReady(int i) {
            InterceptResult invokeI;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeI = interceptable.invokeI(65537, null, i)) == null) ? i != 41 ? i != 44 ? i != 46 ? "unkown errcode" : "bundle is broken" : "bundle need to force update" : "bundle is ready" : (String) invokeI.objValue;
        }

        public static String retMsgSuccess() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TRACKBALL, null)) == null) ? "successful invoke" : (String) invokeV.objValue;
        }

        public MSG() {
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

        public static String retMsgErrParam(String str, String str2) {
            InterceptResult invokeLL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLL = interceptable.invokeLL(65538, null, str, str2)) == null) {
                return "invalid package or method, package=" + str + ", method=" + str2;
            }
            return (String) invokeLL.objValue;
        }

        public static String retMsgInvalidPkg(String str) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(65539, null, str)) == null) {
                return "no such bundle with the name of " + str;
            }
            return (String) invokeL.objValue;
        }
    }

    /* loaded from: classes3.dex */
    public static class PLUGIN {
        public static /* synthetic */ Interceptable $ic = null;
        public static final int ALLOW_BACKGROUND_CODE = 0;
        public static final int ALLOW_DIRECTLY_CODE = 1;
        public transient /* synthetic */ FieldHolder $fh;

        public PLUGIN() {
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
    }

    /* loaded from: classes3.dex */
    public static class STATUS {
        public static /* synthetic */ Interceptable $ic = null;
        public static final int PKG_AVAILABLE = 43;
        public static final int PKG_BROKEN = 46;
        public static final int PKG_FORBIDDEN = 42;
        public static final int PKG_NEED_UPDATE = 44;
        public static final int PKG_READY = 41;
        public static final int PKG_RUNNING = 47;
        public static final int SDK_NOT_READY = 45;
        public transient /* synthetic */ FieldHolder $fh;

        public STATUS() {
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
    }

    /* loaded from: classes3.dex */
    public static class TAG {
        public static /* synthetic */ Interceptable $ic = null;
        public static final String PARAM_DOWNLOAD_TYPE = "param_download_type";
        public static final String PARAM_MULTI_BUNDLE_ENABLE = "param_multi_bundle_enable";
        public static final String PARAM_PKG_NAME = "param_pkg_name";
        public static final String PARAM_PKG_STUS = "param_pkg_status";
        public static final String PARAM_VALUE = "param_value";
        public static final String RET_CODE = "ret_code";
        public static final String RET_VALUE = "ret_value";
        public static final String TIME_STAMP = "time_stamp";
        public transient /* synthetic */ FieldHolder $fh;

        public TAG() {
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
    }

    /* loaded from: classes3.dex */
    public static class VERSION {
        public static /* synthetic */ Interceptable $ic = null;
        public static final int INVALID_VERSION = -1;
        public transient /* synthetic */ FieldHolder $fh;

        public VERSION() {
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
    }

    public Constant() {
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
}
