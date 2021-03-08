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
import com.baidu.tbadk.core.util.bf;
import com.baidu.tbadk.mutiprocess.mission.MissionEvent;
/* loaded from: classes.dex */
public class r {
    private static View.OnClickListener mOnClickListener = new View.OnClickListener() { // from class: com.baidu.tbadk.BdToken.r.1
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            TbPageContext<?> bio;
            Object tag = view.getTag();
            if (tag instanceof CompleteTaskToastData) {
                CompleteTaskToastData completeTaskToastData = (CompleteTaskToastData) tag;
                if (!TextUtils.isEmpty(completeTaskToastData.url) && (bio = r.bio()) != null) {
                    bf.bsY().b(bio, new String[]{completeTaskToastData.url});
                    com.baidu.tbadk.BdToken.completeTask.c.aG(completeTaskToastData.activityId, completeTaskToastData.missionId);
                }
            }
        }
    };

    private static boolean isMainProcess() {
        return TbadkCoreApplication.getInst().isMainProcess(true);
    }

    public static void o(int i, long j) {
        if (isMainProcess()) {
            c.bhp().o(i, j);
        } else {
            a(i, j, MissionEvent.MESSAGE_ACTIVITY);
        }
    }

    public static void b(int i, int i2, long j) {
        if (isMainProcess()) {
            c.bhp().q(i, j);
        } else {
            b(i, i2, j, MissionEvent.MESSAGE_RESUME);
        }
    }

    public static void s(int i, long j) {
        if (isMainProcess()) {
            c.bhp().bhA();
        } else {
            a(i, j, MissionEvent.MESSAGE_PAUSE);
        }
    }

    public static void t(int i, long j) {
        if (isMainProcess()) {
            c.bhp().bhC();
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

    public static TbPageContext bio() {
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
        TbPageContext bio;
        if (completeTaskToastData == null || (bio = bio()) == null || bio.getUniqueId() == null || completeTaskToastData.pageId != bio.getUniqueId().getId()) {
            return null;
        }
        com.baidu.tbadk.core.dialog.f c = com.baidu.tbadk.core.dialog.f.c(bio.getPageActivity(), completeTaskToastData.message);
        c.nK(completeTaskToastData.duration);
        c.setOnClickListener(mOnClickListener);
        c.setTag(completeTaskToastData);
        c.bqI();
        return c;
    }

    public static void a(MotionEvent motionEvent, int i, long j) {
        if (motionEvent != null && motionEvent.getAction() == 0) {
            t(i, j);
        }
    }
}
