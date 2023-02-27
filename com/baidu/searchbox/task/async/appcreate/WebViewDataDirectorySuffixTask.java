package com.baidu.searchbox.task.async.appcreate;

import android.os.Build;
import android.webkit.WebView;
import com.baidu.searchbox.performance.speed.task.LaunchTask;
import com.baidu.searchbox.process.ipc.util.ProcessUtils;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
/* loaded from: classes2.dex */
public class WebViewDataDirectorySuffixTask extends LaunchTask {
    @Override // com.baidu.searchbox.performance.speed.task.LaunchTask
    public String getName() {
        return "Ignore_WebViewDataDirectorySuffix";
    }

    @Override // com.baidu.searchbox.performance.speed.task.LaunchTask
    public int getProcess() {
        return -1;
    }

    @Override // com.baidu.searchbox.performance.speed.task.LaunchTask
    public void execute() {
        setWebViewDataDirectorySuffix();
    }

    private void setWebViewDataDirectorySuffix() {
        if (Build.VERSION.SDK_INT >= 28) {
            try {
                Method declaredMethod = WebView.class.getDeclaredMethod("setDataDirectorySuffix", String.class);
                if (declaredMethod != null) {
                    declaredMethod.setAccessible(true);
                    declaredMethod.invoke(null, ProcessUtils.getCurProcessName());
                }
            } catch (IllegalAccessException e) {
                e.printStackTrace();
            } catch (NoSuchMethodException e2) {
                e2.printStackTrace();
            } catch (InvocationTargetException e3) {
                e3.printStackTrace();
            }
        }
    }
}
