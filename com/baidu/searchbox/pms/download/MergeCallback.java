package com.baidu.searchbox.pms.download;

import android.text.TextUtils;
import com.baidu.android.util.io.FileUtils;
import com.baidu.searchbox.pms.bean.PackageInfo;
import com.baidu.searchbox.pms.utils.CommonUtils;
import com.baidu.searchbox.pms.utils.DebugUtils;
import java.io.File;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes3.dex */
public class MergeCallback {
    public static final String TAG = "MergeCallback";
    public final List<MergeBean> list = new ArrayList();

    /* loaded from: classes3.dex */
    public class MergeBean {
        public InnerCallback callback;
        public PackageInfo info;

        public MergeBean(PackageInfo packageInfo, InnerCallback innerCallback) {
            this.info = packageInfo;
            this.callback = innerCallback;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void checkCopy(String str, MergeBean mergeBean) {
        DebugUtils.log("【下载完成】", mergeBean.info);
        if (TextUtils.equals(str, mergeBean.info.filePath)) {
            return;
        }
        DebugUtils.log("【复制文件】 from:", str, ",to:", mergeBean.info.filePath);
        File file = new File(str);
        File file2 = new File(mergeBean.info.filePath);
        if (file.exists()) {
            if (file2.exists()) {
                file2.delete();
            }
            long copyFile = FileUtils.copyFile(file, file2);
            Object[] objArr = new Object[2];
            objArr[0] = copyFile > 0 ? "【复制成功】" : "【复制失败】 to:";
            objArr[1] = mergeBean.info.filePath;
            DebugUtils.log(objArr);
        }
    }

    public void add(PackageInfo packageInfo, InnerCallback innerCallback) {
        synchronized (this.list) {
            this.list.add(new MergeBean(packageInfo, innerCallback));
        }
    }

    public void onCancel() {
        synchronized (this.list) {
            for (MergeBean mergeBean : this.list) {
                mergeBean.info.type = 5;
                mergeBean.callback.onCancel(mergeBean.info);
            }
            this.list.clear();
        }
    }

    public void onError(int i, String str) {
        synchronized (this.list) {
            for (MergeBean mergeBean : this.list) {
                mergeBean.info.type = 6;
                mergeBean.callback.onError(mergeBean.info, i, str);
            }
            this.list.clear();
        }
    }

    public void onPause() {
        synchronized (this.list) {
            for (MergeBean mergeBean : this.list) {
                mergeBean.info.type = 3;
                mergeBean.callback.onPause(mergeBean.info);
            }
        }
    }

    public void onProgress(long j, long j2) {
        synchronized (this.list) {
            for (MergeBean mergeBean : this.list) {
                mergeBean.info.currentSize = j;
                mergeBean.info.totalSize = j2;
                mergeBean.callback.onProgress(mergeBean.info, mergeBean.info.currentSize, mergeBean.info.totalSize);
            }
        }
    }

    public void onResume() {
        synchronized (this.list) {
            for (MergeBean mergeBean : this.list) {
                mergeBean.info.type = 2;
                mergeBean.callback.onResume(mergeBean.info);
            }
        }
    }

    public void onRetry() {
        synchronized (this.list) {
            for (MergeBean mergeBean : this.list) {
                mergeBean.callback.onCancel(mergeBean.info);
            }
        }
    }

    public void onStart() {
        synchronized (this.list) {
            for (MergeBean mergeBean : this.list) {
                mergeBean.info.type = 2;
                mergeBean.callback.onStart(mergeBean.info);
            }
        }
    }

    public void onSuccess(final String str) {
        CommonUtils.postThread(new Runnable() { // from class: com.baidu.searchbox.pms.download.MergeCallback.1
            @Override // java.lang.Runnable
            public void run() {
                synchronized (MergeCallback.this.list) {
                    for (MergeBean mergeBean : MergeCallback.this.list) {
                        mergeBean.info.type = 10;
                        MergeCallback.this.checkCopy(str, mergeBean);
                    }
                    for (MergeBean mergeBean2 : MergeCallback.this.list) {
                        mergeBean2.callback.onSuccess(mergeBean2.info);
                    }
                    MergeCallback.this.list.clear();
                }
            }
        }, "MergeCallbackonSuccess");
    }
}
