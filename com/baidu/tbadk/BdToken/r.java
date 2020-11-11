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
import com.baidu.tbadk.core.util.be;
import com.baidu.tbadk.mutiprocess.mission.MissionEvent;
/* loaded from: classes.dex */
public class r {
    private static View.OnClickListener mOnClickListener = new View.OnClickListener() { // from class: com.baidu.tbadk.BdToken.r.1
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            TbPageContext<?> bhe;
            Object tag = view.getTag();
            if (tag instanceof CompleteTaskToastData) {
                CompleteTaskToastData completeTaskToastData = (CompleteTaskToastData) tag;
                if (!TextUtils.isEmpty(completeTaskToastData.url) && (bhe = r.bhe()) != null) {
                    be.brr().b(bhe, new String[]{completeTaskToastData.url});
                    com.baidu.tbadk.BdToken.completeTask.c.aK(completeTaskToastData.activityId, completeTaskToastData.missionId);
                }
            }
        }
    };

    private static boolean isMainProcess() {
        return TbadkCoreApplication.getInst().isMainProcess(true);
    }

    public static void n(int i, long j) {
        if (isMainProcess()) {
            c.bgf().n(i, j);
        } else {
            f(i, j, MissionEvent.MESSAGE_ACTIVITY);
        }
    }

    public static void a(int i, int i2, long j) {
        if (isMainProcess()) {
            c.bgf().p(i, j);
        } else {
            b(i, i2, j, MissionEvent.MESSAGE_RESUME);
        }
    }

    public static void r(int i, long j) {
        if (isMainProcess()) {
            c.bgf().bgq();
        } else {
            f(i, j, MissionEvent.MESSAGE_PAUSE);
        }
    }

    public static void s(int i, long j) {
        if (isMainProcess()) {
            c.bgf().bgs();
        } else {
            f(i, j, MissionEvent.MESSAGE_TOUCH);
        }
    }

    public static void f(int i, long j, String str) {
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

    public static TbPageContext bhe() {
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
        TbPageContext bhe;
        if (completeTaskToastData == null || (bhe = bhe()) == null || bhe.getUniqueId() == null || completeTaskToastData.pageId != bhe.getUniqueId().getId()) {
            return null;
        }
        com.baidu.tbadk.core.dialog.f c = com.baidu.tbadk.core.dialog.f.c(bhe.getPageActivity(), completeTaskToastData.message);
        c.oI(completeTaskToastData.duration);
        c.setOnClickListener(mOnClickListener);
        c.setTag(completeTaskToastData);
        c.bpm();
        return c;
    }

    public static void a(MotionEvent motionEvent, int i, long j) {
        if (motionEvent != null && motionEvent.getAction() == 0) {
            s(i, j);
        }
    }
}
