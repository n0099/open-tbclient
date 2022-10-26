package com.baidu.searchbox.pms.download;

import android.text.TextUtils;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.android.util.io.FileUtils;
import com.baidu.searchbox.pms.bean.PackageInfo;
import com.baidu.searchbox.pms.utils.CommonUtils;
import com.baidu.searchbox.pms.utils.DebugUtils;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.io.File;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes2.dex */
public class MergeCallback {
    public static /* synthetic */ Interceptable $ic = null;
    public static final String TAG = "MergeCallback";
    public transient /* synthetic */ FieldHolder $fh;
    public final List list;

    /* loaded from: classes2.dex */
    public class MergeBean {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public InnerCallback callback;
        public PackageInfo info;
        public final /* synthetic */ MergeCallback this$0;

        public MergeBean(MergeCallback mergeCallback, PackageInfo packageInfo, InnerCallback innerCallback) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {mergeCallback, packageInfo, innerCallback};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.this$0 = mergeCallback;
            this.info = packageInfo;
            this.callback = innerCallback;
        }
    }

    public MergeCallback() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.list = new ArrayList();
    }

    public void onRetry() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048582, this) == null) {
            synchronized (this.list) {
                for (MergeBean mergeBean : this.list) {
                    mergeBean.callback.onCancel(mergeBean.info);
                }
            }
        }
    }

    public void onSuccess(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, str) == null) {
            CommonUtils.postThread(new Runnable(this, str) { // from class: com.baidu.searchbox.pms.download.MergeCallback.1
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;
                public final /* synthetic */ MergeCallback this$0;
                public final /* synthetic */ String val$successPath;

                {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {this, str};
                        interceptable2.invokeUnInit(65536, newInitContext);
                        int i = newInitContext.flag;
                        if ((i & 1) != 0) {
                            int i2 = i & 2;
                            newInitContext.thisArg = this;
                            interceptable2.invokeInitBody(65536, newInitContext);
                            return;
                        }
                    }
                    this.this$0 = this;
                    this.val$successPath = str;
                }

                @Override // java.lang.Runnable
                public void run() {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                        synchronized (this.this$0.list) {
                            for (MergeBean mergeBean : this.this$0.list) {
                                mergeBean.info.type = 10;
                                this.this$0.checkCopy(this.val$successPath, mergeBean);
                            }
                            for (MergeBean mergeBean2 : this.this$0.list) {
                                mergeBean2.callback.onSuccess(mergeBean2.info);
                            }
                            this.this$0.list.clear();
                        }
                    }
                }
            }, "MergeCallbackonSuccess");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void checkCopy(String str, MergeBean mergeBean) {
        String str2;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65539, this, str, mergeBean) == null) {
            DebugUtils.log("【下载完成】", mergeBean.info);
            if (!TextUtils.equals(str, mergeBean.info.filePath)) {
                DebugUtils.log("【复制文件】 from:", str, ",to:", mergeBean.info.filePath);
                File file = new File(str);
                File file2 = new File(mergeBean.info.filePath);
                if (file.exists()) {
                    if (file2.exists()) {
                        file2.delete();
                    }
                    long copyFile = FileUtils.copyFile(file, file2);
                    Object[] objArr = new Object[2];
                    if (copyFile > 0) {
                        str2 = "【复制成功】";
                    } else {
                        str2 = "【复制失败】 to:";
                    }
                    objArr[0] = str2;
                    objArr[1] = mergeBean.info.filePath;
                    DebugUtils.log(objArr);
                }
            }
        }
    }

    public void add(PackageInfo packageInfo, InnerCallback innerCallback) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048576, this, packageInfo, innerCallback) == null) {
            synchronized (this.list) {
                this.list.add(new MergeBean(this, packageInfo, innerCallback));
            }
        }
    }

    public void onCancel() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            synchronized (this.list) {
                for (MergeBean mergeBean : this.list) {
                    mergeBean.info.type = 5;
                    mergeBean.callback.onCancel(mergeBean.info);
                }
                this.list.clear();
            }
        }
    }

    public void onPause() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
            synchronized (this.list) {
                for (MergeBean mergeBean : this.list) {
                    mergeBean.info.type = 3;
                    mergeBean.callback.onPause(mergeBean.info);
                }
            }
        }
    }

    public void onResume() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048581, this) == null) {
            synchronized (this.list) {
                for (MergeBean mergeBean : this.list) {
                    mergeBean.info.type = 2;
                    mergeBean.callback.onResume(mergeBean.info);
                }
            }
        }
    }

    public void onStart() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048583, this) == null) {
            synchronized (this.list) {
                for (MergeBean mergeBean : this.list) {
                    mergeBean.info.type = 2;
                    mergeBean.callback.onStart(mergeBean.info);
                }
            }
        }
    }

    public void onError(int i, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIL(Constants.METHOD_SEND_USER_MSG, this, i, str) == null) {
            synchronized (this.list) {
                for (MergeBean mergeBean : this.list) {
                    mergeBean.info.type = 6;
                    mergeBean.callback.onError(mergeBean.info, i, str);
                }
                this.list.clear();
            }
        }
    }

    public void onProgress(long j, long j2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048580, this, new Object[]{Long.valueOf(j), Long.valueOf(j2)}) == null) {
            synchronized (this.list) {
                for (MergeBean mergeBean : this.list) {
                    mergeBean.info.currentSize = j;
                    mergeBean.info.totalSize = j2;
                    mergeBean.callback.onProgress(mergeBean.info, mergeBean.info.currentSize, mergeBean.info.totalSize);
                }
            }
        }
    }
}
