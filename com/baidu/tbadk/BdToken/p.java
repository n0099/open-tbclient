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
public class p {
    private static View.OnClickListener mOnClickListener = new View.OnClickListener() { // from class: com.baidu.tbadk.BdToken.p.1
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            TbPageContext<?> YM;
            Object tag = view.getTag();
            if (tag instanceof CompleteTaskToastData) {
                CompleteTaskToastData completeTaskToastData = (CompleteTaskToastData) tag;
                if (!TextUtils.isEmpty(completeTaskToastData.url) && (YM = p.YM()) != null) {
                    ba.aiz().c(YM, new String[]{completeTaskToastData.url});
                    com.baidu.tbadk.BdToken.completeTask.c.P(completeTaskToastData.activityId, completeTaskToastData.missionId);
                }
            }
        }
    };

    private static boolean isMainProcess() {
        return TbadkCoreApplication.getInst().isMainProcess(true);
    }

    public static void i(int i, long j) {
        if (isMainProcess()) {
            c.Yk().i(i, j);
        } else {
            a(i, j, "onActivity");
        }
    }

    public static void a(int i, int i2, long j) {
        if (isMainProcess()) {
            c.Yk().k(i, j);
        } else {
            a(i, i2, j, "onResume");
        }
    }

    public static void m(int i, long j) {
        if (isMainProcess()) {
            c.Yk().Yp();
        } else {
            a(i, j, "onPause");
        }
    }

    public static void n(int i, long j) {
        if (isMainProcess()) {
            c.Yk().Yr();
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

    public static TbPageContext YM() {
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
        TbPageContext YM;
        if (completeTaskToastData == null || (YM = YM()) == null || YM.getUniqueId() == null || completeTaskToastData.pageId != YM.getUniqueId().getId()) {
            return null;
        }
        com.baidu.tbadk.core.dialog.f d = com.baidu.tbadk.core.dialog.f.d(YM.getPageActivity(), completeTaskToastData.message);
        d.hE(completeTaskToastData.duration);
        d.setOnClickListener(mOnClickListener);
        d.setTag(completeTaskToastData);
        d.afS();
        return d;
    }

    public static void a(MotionEvent motionEvent, int i, long j) {
        if (motionEvent != null && motionEvent.getAction() == 0) {
            n(i, j);
        }
    }
}
