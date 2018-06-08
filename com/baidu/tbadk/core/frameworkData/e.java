package com.baidu.tbadk.core.frameworkData;

import android.util.Log;
import com.baidu.adp.base.BdBaseApplication;
import com.baidu.tbadk.core.util.av;
/* loaded from: classes.dex */
public class e {
    public static void initial() {
        try {
            if (!av.loadStaticClasses()) {
                c.aH(BdBaseApplication.getInst());
                Log.e("Tasks", "============================ Static Class init Failed ================================ ");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
