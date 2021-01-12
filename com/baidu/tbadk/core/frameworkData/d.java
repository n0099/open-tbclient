package com.baidu.tbadk.core.frameworkData;

import android.util.Log;
import com.baidu.adp.base.BdBaseApplication;
import com.baidu.adp.framework.a.f;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.tbadk.core.util.bb;
/* loaded from: classes.dex */
public class d {
    private static String[] eVf = {"com.baidu.tieba.aiapps.apps.abtest.SwanAppAbTestStatic", "com.baidu.tieba.advert.sdk.AdvertSDKStatic", "com.baidu.tieba.recapp.RecAppStatic", "com.baidu.tieba.lego.activity.LegoListActivityStatic", "com.baidu.tbadk.core.LaunchStatic", "com.baidu.tieba.emotion.BasePlugInFaceProviderStatic", "com.baidu.tieba.image.ImageViewerActivityStatic", "com.baidu.tieba.im.TiebaIMActivityStatic", "com.baidu.tbadk.plugins.Static", "com.baidu.tieba.imMessageCenter.im.chat.notify.ImMessageCenterDelegateStatic", "com.baidu.tieba.enterForum.home.EnterForumDelegateStatic", "com.baidu.tieba.homepage.framework.RecommendFrsDelegateStatic", "com.baidu.tieba.personCenter.PersonInfoDelegateStatic", "com.baidu.tieba.write.bottomButton.WriteThreadDelegateStatic", "com.baidu.tieba.location.LocationProvidersStatic", "com.baidu.tieba.ala.livecard.Static", "com.baidu.tieba.emotion.PlugInFaceProviderStatic", "com.baidu.tieba.flutter.FlutterStatic"};
    public static boolean eVg;

    public static void initial() {
        try {
            eVg = com.baidu.tbadk.core.sharedPref.b.brx().getInt("static_opt_open", 0) > 0;
            long currentTimeMillis = System.currentTimeMillis();
            if (eVg) {
                if (loadStaticClasses()) {
                    f.L(BdBaseApplication.getInst());
                } else {
                    Log.e("TiebaStaticClassesArray", "load from dex fail ");
                    if (!bb.loadStaticClasses()) {
                        f.loadStaticClass(BdBaseApplication.getInst());
                    }
                }
            } else if (!bb.loadStaticClasses()) {
                f.loadStaticClass(BdBaseApplication.getInst());
            }
            Log.e("Tasks", "load from dex coast time " + (System.currentTimeMillis() - currentTimeMillis));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static boolean loadStaticClasses() {
        String[] strArr;
        try {
            if (eVf.length <= 0) {
                return false;
            }
            for (String str : eVf) {
                long currentTimeMillis = System.currentTimeMillis();
                Class.forName(str);
                Log.e("TiebaStaticClassesArray", str + " " + (System.currentTimeMillis() - currentTimeMillis));
            }
            return true;
        } catch (Throwable th) {
            BdLog.e(th);
            return false;
        }
    }
}
