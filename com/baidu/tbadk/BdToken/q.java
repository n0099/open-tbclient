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
import com.baidu.tbadk.core.util.bb;
/* loaded from: classes.dex */
public class q {
    private static View.OnClickListener mOnClickListener = new View.OnClickListener() { // from class: com.baidu.tbadk.BdToken.q.1
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            TbPageContext<?> ZK;
            Object tag = view.getTag();
            if (tag instanceof CompleteTaskToastData) {
                CompleteTaskToastData completeTaskToastData = (CompleteTaskToastData) tag;
                if (!TextUtils.isEmpty(completeTaskToastData.url) && (ZK = q.ZK()) != null) {
                    bb.ajC().c(ZK, new String[]{completeTaskToastData.url});
                    com.baidu.tbadk.BdToken.completeTask.c.S(completeTaskToastData.activityId, completeTaskToastData.missionId);
                }
            }
        }
    };

    private static boolean isMainProcess() {
        return TbadkCoreApplication.getInst().isMainProcess(true);
    }

    public static void i(int i, long j) {
        if (isMainProcess()) {
            c.Zg().i(i, j);
        } else {
            a(i, j, "onActivity");
        }
    }

    public static void a(int i, int i2, long j) {
        if (isMainProcess()) {
            c.Zg().k(i, j);
        } else {
            a(i, i2, j, "onResume");
        }
    }

    public static void m(int i, long j) {
        if (isMainProcess()) {
            c.Zg().Zl();
        } else {
            a(i, j, "onPause");
        }
    }

    public static void n(int i, long j) {
        if (isMainProcess()) {
            c.Zg().Zn();
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

    public static void a(int i, int i2, long j, String str) {
        Bundle bundle = new Bundle();
        bundle.putString("key_message_type", str);
        bundle.putInt("key_pageType", i);
        bundle.putInt("key_pageId", i2);
        bundle.putLong("thread_id", j);
        com.baidu.tbadk.n.b.a("broadcast_type_mission_message", bundle);
    }

    public static TbPageContext ZK() {
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
        TbPageContext ZK;
        if (completeTaskToastData == null || (ZK = ZK()) == null || ZK.getUniqueId() == null || completeTaskToastData.pageId != ZK.getUniqueId().getId()) {
            return null;
        }
        com.baidu.tbadk.core.dialog.f d = com.baidu.tbadk.core.dialog.f.d(ZK.getPageActivity(), completeTaskToastData.message);
        d.hK(completeTaskToastData.duration);
        d.setOnClickListener(mOnClickListener);
        d.setTag(completeTaskToastData);
        d.agU();
        return d;
    }

    public static void a(MotionEvent motionEvent, int i, long j) {
        if (motionEvent != null && motionEvent.getAction() == 0) {
            n(i, j);
        }
    }
}
