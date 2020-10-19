package com.baidu.searchbox.ui.animview.praise.resource;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.StateListDrawable;
import android.text.TextUtils;
import com.baidu.searchbox.ui.animview.base.IResourcePackage;
import java.io.File;
import java.util.HashMap;
/* loaded from: classes9.dex */
public class CoolPraiseIconResource {
    private static HashMap<String, Drawable> praiseIconDayList = new HashMap<>();
    private static HashMap<String, Drawable> praiseIconNightList = new HashMap<>();

    public static void storePraiseIconResource(Context context, File file, boolean z) {
        Drawable loadImageFromFile;
        File[] findAllTargetFiles = IResourcePackage.Utils.findAllTargetFiles(file, ComboPraiseProvider.RES_NAME_PRAISE_NUMBER_SUFFIX, true);
        if (findAllTargetFiles != null && findAllTargetFiles.length > 0) {
            for (int i = 0; i < findAllTargetFiles.length; i++) {
                if (findAllTargetFiles[i] != null && (loadImageFromFile = IResourcePackage.Utils.loadImageFromFile(context, findAllTargetFiles[i])) != null) {
                    if (!z) {
                        praiseIconDayList.put(findAllTargetFiles[i].getName(), loadImageFromFile);
                    } else {
                        praiseIconNightList.put(findAllTargetFiles[i].getName(), loadImageFromFile);
                    }
                }
            }
        }
    }

    public static Drawable getPraiseIconByType(String str, boolean z, boolean z2) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        String str2 = "";
        if (!z2) {
            str2 = "un_";
        }
        String str3 = str2 + str;
        if (z) {
            if (praiseIconNightList.get(str3) == null || praiseIconNightList.get("pre_" + str3) == null) {
                return null;
            }
            StateListDrawable stateListDrawable = new StateListDrawable();
            stateListDrawable.addState(new int[]{16842919}, praiseIconNightList.get("pre_" + str3));
            stateListDrawable.addState(new int[0], praiseIconNightList.get(str3));
            return stateListDrawable;
        } else if (praiseIconDayList.get(str3) == null || praiseIconDayList.get("pre_" + str3) == null) {
            return null;
        } else {
            StateListDrawable stateListDrawable2 = new StateListDrawable();
            stateListDrawable2.addState(new int[]{16842919}, praiseIconDayList.get("pre_" + str3));
            stateListDrawable2.addState(new int[0], praiseIconDayList.get(str3));
            return stateListDrawable2;
        }
    }
}
