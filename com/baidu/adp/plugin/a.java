package com.baidu.adp.plugin;

import android.graphics.drawable.Drawable;
import com.baidu.adp.base.BdBaseApplication;
import com.baidu.adp.lib.util.BdLog;
/* loaded from: classes.dex */
public class a {
    public static String getString(int i) {
        try {
            return BdBaseApplication.getInst().getResources().getString(i);
        } catch (Exception e) {
            BdLog.e("can not find resources . id is " + i);
            return "";
        }
    }

    public static Drawable getDrawable(int i) {
        try {
            return BdBaseApplication.getInst().getResources().getDrawable(i);
        } catch (Exception e) {
            BdLog.e("can not find resources . id is " + i);
            return null;
        }
    }
}
