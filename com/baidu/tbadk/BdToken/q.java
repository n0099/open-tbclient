package com.baidu.tbadk.BdToken;

import android.app.Activity;
import android.text.TextUtils;
import android.view.MotionEvent;
import android.view.View;
import com.baidu.tbadk.BaseActivity;
import com.baidu.tbadk.BdToken.completeTask.CompleteTaskToastData;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.BaseFragmentActivity;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.ba;
import com.baidu.tbadk.mutiprocess.mission.MissionEvent;
/* loaded from: classes.dex */
public class q {
    private static View.OnClickListener mOnClickListener = new View.OnClickListener() { // from class: com.baidu.tbadk.BdToken.q.1
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            TbPageContext<?> aya;
            Object tag = view.getTag();
            if (tag instanceof CompleteTaskToastData) {
                CompleteTaskToastData completeTaskToastData = (CompleteTaskToastData) tag;
                if (!TextUtils.isEmpty(completeTaskToastData.url) && (aya = q.aya()) != null) {
                    ba.aGE().b(aya, new String[]{completeTaskToastData.url});
                    com.baidu.tbadk.BdToken.completeTask.c.av(completeTaskToastData.activityId, completeTaskToastData.missionId);
                }
            }
        }
    };

    private static boolean isMainProcess() {
        return TbadkCoreApplication.getInst().isMainProcess(true);
    }

    public static void m(int i, long j) {
        if (isMainProcess()) {
            c.axx().m(i, j);
        } else {
            a(i, j, MissionEvent.MESSAGE_ACTIVITY);
        }
    }

    public static void a(int i, int i2, long j) {
        if (isMainProcess()) {
            c.axx().o(i, j);
        } else {
            b(i, i2, j, MissionEvent.MESSAGE_RESUME);
        }
    }

    public static void q(int i, long j) {
        if (isMainProcess()) {
            c.axx().axC();
        } else {
            a(i, j, MissionEvent.MESSAGE_PAUSE);
        }
    }

    public static void r(int i, long j) {
        if (isMainProcess()) {
            c.axx().axE();
        } else {
            a(i, j, MissionEvent.MESSAGE_TOUCH);
        }
    }

    public static void a(int i, long j, String str) {
        MissionEvent missionEvent = new MissionEvent();
        missionEvent.tid = j;
        missionEvent.pageId = i;
        missionEvent.actionType = str;
        com.baidu.tbadk.mutiprocess.g.publishEvent(missionEvent);
    }

    public static void b(int i, int i2, long j, String str) {
        MissionEvent missionEvent = new MissionEvent();
        missionEvent.tid = j;
        missionEvent.pageId = i2;
        missionEvent.pageType = i;
        missionEvent.actionType = str;
        com.baidu.tbadk.mutiprocess.g.publishEvent(missionEvent);
    }

    public static TbPageContext aya() {
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
        TbPageContext aya;
        if (completeTaskToastData == null || (aya = aya()) == null || aya.getUniqueId() == null || completeTaskToastData.pageId != aya.getUniqueId().getId()) {
            return null;
        }
        com.baidu.tbadk.core.dialog.f d = com.baidu.tbadk.core.dialog.f.d(aya.getPageActivity(), completeTaskToastData.message);
        d.kh(completeTaskToastData.duration);
        d.setOnClickListener(mOnClickListener);
        d.setTag(completeTaskToastData);
        d.aEJ();
        return d;
    }

    public static void a(MotionEvent motionEvent, int i, long j) {
        if (motionEvent != null && motionEvent.getAction() == 0) {
            r(i, j);
        }
    }
}
