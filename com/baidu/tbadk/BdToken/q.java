package com.baidu.tbadk.BdToken;

import android.app.Activity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.MotionEvent;
import android.view.View;
import com.baidu.tbadk.BaseActivity;
import com.baidu.tbadk.BdToken.completeTask.CompleteTaskToastData;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.BaseFragmentActivity;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.ba;
/* loaded from: classes.dex */
public class q {
    private static View.OnClickListener mOnClickListener = new View.OnClickListener() { // from class: com.baidu.tbadk.BdToken.q.1
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            TbPageContext<?> aeD;
            Object tag = view.getTag();
            if (tag instanceof CompleteTaskToastData) {
                CompleteTaskToastData completeTaskToastData = (CompleteTaskToastData) tag;
                if (!TextUtils.isEmpty(completeTaskToastData.url) && (aeD = q.aeD()) != null) {
                    ba.amQ().b(aeD, new String[]{completeTaskToastData.url});
                    com.baidu.tbadk.BdToken.completeTask.c.Y(completeTaskToastData.activityId, completeTaskToastData.missionId);
                }
            }
        }
    };

    private static boolean isMainProcess() {
        return TbadkCoreApplication.getInst().isMainProcess(true);
    }

    public static void i(int i, long j) {
        if (isMainProcess()) {
            c.adZ().i(i, j);
        } else {
            a(i, j, "onActivity");
        }
    }

    public static void a(int i, int i2, long j) {
        if (isMainProcess()) {
            c.adZ().k(i, j);
        } else {
            b(i, i2, j, "onResume");
        }
    }

    public static void m(int i, long j) {
        if (isMainProcess()) {
            c.adZ().aee();
        } else {
            a(i, j, "onPause");
        }
    }

    public static void n(int i, long j) {
        if (isMainProcess()) {
            c.adZ().aeg();
        } else {
            a(i, j, "onTouch");
        }
    }

    public static void a(int i, long j, String str) {
        Bundle bundle = new Bundle();
        bundle.putString("key_message_type", str);
        bundle.putInt("key_pageId", i);
        bundle.putLong("thread_id", j);
        com.baidu.tbadk.n.b.a("broadcast_type_mission_message", bundle);
    }

    public static void b(int i, int i2, long j, String str) {
        Bundle bundle = new Bundle();
        bundle.putString("key_message_type", str);
        bundle.putInt("key_pageType", i);
        bundle.putInt("key_pageId", i2);
        bundle.putLong("thread_id", j);
        com.baidu.tbadk.n.b.a("broadcast_type_mission_message", bundle);
    }

    public static TbPageContext aeD() {
        Activity currentActivity = TbadkCoreApplication.getInst().getCurrentActivity();
        if (currentActivity instanceof BaseActivity) {
            return ((BaseActivity) currentActivity).getPageContext();
        }
        if (currentActivity instanceof BaseFragmentActivity) {
            return ((BaseFragmentActivity) currentActivity).getPageContext();
        }
        return null;
    }

    public static com.baidu.tbadk.core.dialog.f a(CompleteTaskToastData completeTaskToastData) {
        TbPageContext aeD;
        if (completeTaskToastData == null || (aeD = aeD()) == null || aeD.getUniqueId() == null || completeTaskToastData.pageId != aeD.getUniqueId().getId()) {
            return null;
        }
        com.baidu.tbadk.core.dialog.f d = com.baidu.tbadk.core.dialog.f.d(aeD.getPageActivity(), completeTaskToastData.message);
        d.m22if(completeTaskToastData.duration);
        d.setOnClickListener(mOnClickListener);
        d.setTag(completeTaskToastData);
        d.akX();
        return d;
    }

    public static void a(MotionEvent motionEvent, int i, long j) {
        if (motionEvent != null && motionEvent.getAction() == 0) {
            n(i, j);
        }
    }
}
