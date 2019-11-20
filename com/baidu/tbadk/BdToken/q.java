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
            TbPageContext<?> aeB;
            Object tag = view.getTag();
            if (tag instanceof CompleteTaskToastData) {
                CompleteTaskToastData completeTaskToastData = (CompleteTaskToastData) tag;
                if (!TextUtils.isEmpty(completeTaskToastData.url) && (aeB = q.aeB()) != null) {
                    ba.amO().b(aeB, new String[]{completeTaskToastData.url});
                    com.baidu.tbadk.BdToken.completeTask.c.W(completeTaskToastData.activityId, completeTaskToastData.missionId);
                }
            }
        }
    };

    private static boolean isMainProcess() {
        return TbadkCoreApplication.getInst().isMainProcess(true);
    }

    public static void g(int i, long j) {
        if (isMainProcess()) {
            c.adX().g(i, j);
        } else {
            a(i, j, "onActivity");
        }
    }

    public static void a(int i, int i2, long j) {
        if (isMainProcess()) {
            c.adX().i(i, j);
        } else {
            b(i, i2, j, "onResume");
        }
    }

    public static void k(int i, long j) {
        if (isMainProcess()) {
            c.adX().aec();
        } else {
            a(i, j, "onPause");
        }
    }

    public static void l(int i, long j) {
        if (isMainProcess()) {
            c.adX().aee();
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

    public static TbPageContext aeB() {
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
        TbPageContext aeB;
        if (completeTaskToastData == null || (aeB = aeB()) == null || aeB.getUniqueId() == null || completeTaskToastData.pageId != aeB.getUniqueId().getId()) {
            return null;
        }
        com.baidu.tbadk.core.dialog.f d = com.baidu.tbadk.core.dialog.f.d(aeB.getPageActivity(), completeTaskToastData.message);
        d.ie(completeTaskToastData.duration);
        d.setOnClickListener(mOnClickListener);
        d.setTag(completeTaskToastData);
        d.akV();
        return d;
    }

    public static void a(MotionEvent motionEvent, int i, long j) {
        if (motionEvent != null && motionEvent.getAction() == 0) {
            l(i, j);
        }
    }
}
