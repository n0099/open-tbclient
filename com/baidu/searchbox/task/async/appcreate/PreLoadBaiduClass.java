package com.baidu.searchbox.task.async.appcreate;

import android.util.Log;
import com.baidu.searchbox.performance.speed.SpeedRuntimeProvider;
import com.baidu.searchbox.performance.speed.task.LaunchTask;
import com.facebook.drawee.backends.pipeline.Fresco;
import com.facebook.imagepipeline.core.ImagePipelineFactory;
/* loaded from: classes4.dex */
public class PreLoadBaiduClass extends LaunchTask {
    @Override // com.baidu.searchbox.performance.speed.task.LaunchTask
    public String getName() {
        return "PreLoadBaiduClass";
    }

    @Override // com.baidu.searchbox.performance.speed.task.LaunchTask
    public int getProcess() {
        return -1;
    }

    @Override // com.baidu.searchbox.performance.speed.task.LaunchTask
    public void execute() {
        try {
            Class.forName("com.baidu.tieba.uk1");
        } catch (ClassNotFoundException e) {
            Log.e(LaunchTask.TAG, "preLoadClass exception " + e.toString());
            e.printStackTrace();
        }
        try {
            Class.forName("androidx.recyclerview.widget.RecyclerView");
        } catch (ClassNotFoundException e2) {
            Log.e(LaunchTask.TAG, "preLoadClass exception " + e2.toString());
            e2.printStackTrace();
        }
        try {
            Class.forName("androidx.recyclerview.widget.LinearLayoutManager");
        } catch (ClassNotFoundException e3) {
            Log.e(LaunchTask.TAG, "preLoadClass exception " + e3.toString());
            e3.printStackTrace();
        }
        try {
            Class.forName(SpeedRuntimeProvider.MAIN_ACTIVITY_NAME);
        } catch (ClassNotFoundException e4) {
            Log.e(LaunchTask.TAG, "preLoadClass exception " + e4.toString());
            e4.printStackTrace();
        }
        try {
            Class.forName("com.baidu.tieba.hea");
        } catch (ClassNotFoundException e5) {
            Log.e(LaunchTask.TAG, "preLoadClass exception " + e5.toString());
            e5.printStackTrace();
        }
        try {
            Class.forName("com.baidu.tbadk.core.tabHost.FragmentTabHost");
        } catch (ClassNotFoundException e6) {
            Log.e(LaunchTask.TAG, "preLoadClass exception " + e6.toString());
            e6.printStackTrace();
        }
        try {
            Class.forName("com.baidu.sapi2.utils.SapiUtils");
        } catch (ClassNotFoundException e7) {
            Log.e(LaunchTask.TAG, "preLoadClass exception " + e7.toString());
            e7.printStackTrace();
        }
        if (Fresco.hasBeenInitialized()) {
            ImagePipelineFactory.getInstance().getImagePipeline();
        }
        try {
            Class.forName("com.baidu.webkit.sdk.WebView");
        } catch (ClassNotFoundException e8) {
            Log.e(LaunchTask.TAG, "preLoadClass exception " + e8.toString());
            e8.printStackTrace();
        }
    }
}
