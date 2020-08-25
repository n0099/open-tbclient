package com.baidu.searchbox.suspensionball;

import android.content.Context;
import android.text.TextUtils;
import com.baidu.searchbox.suspensionball.ioc.SuspensionBallRuntime;
/* loaded from: classes3.dex */
public class SuspensionBallDispatcher {
    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean invoke(Context context, SuspensionBallEntity suspensionBallEntity) {
        if (suspensionBallEntity == null || TextUtils.isEmpty(suspensionBallEntity.scheme)) {
            return false;
        }
        SuspensionBallUbc.clickSuspensionBall(suspensionBallEntity.page);
        suspensionBallEntity.clickTimes++;
        if (suspensionBallEntity.clickTimes == 1) {
            SuspensionBallUbc.timeAddToClick(System.currentTimeMillis() - suspensionBallEntity.createTime);
        }
        return SuspensionBallRuntime.getDispatcher().invoke(context, suspensionBallEntity.scheme);
    }
}
