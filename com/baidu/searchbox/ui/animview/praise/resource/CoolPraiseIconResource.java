package com.baidu.searchbox.ui.animview.praise.resource;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.StateListDrawable;
import android.net.Uri;
import android.text.TextUtils;
import androidx.annotation.Nullable;
import com.baidu.searchbox.common.runtime.AppRuntime;
import com.baidu.searchbox.ui.animview.base.IResourcePackage;
import java.io.File;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
/* loaded from: classes4.dex */
public class CoolPraiseIconResource {
    public static HashMap<String, PraiseIconResource> mPraiseIconDayList = new HashMap<>();
    public static HashMap<String, PraiseIconResource> mPraiseIconNightList = new HashMap<>();
    public static Map<String, List<Uri>> mHeartAnimationRes = new HashMap();
    public static Map<String, String> sStrongAnimList = new HashMap();
    public static HashMap<String, String> sDayIconPathList = new HashMap<>();
    public static HashMap<String, String> sNightIconPathList = new HashMap<>();

    /* loaded from: classes4.dex */
    public static class PraiseIconResource {
        public Drawable drawable;
        public String url;

        public PraiseIconResource(Drawable drawable, String str) {
            this.drawable = drawable;
            this.url = str;
        }
    }

    @Nullable
    public static List<Uri> getContentDoubleClickList() {
        return mHeartAnimationRes.get(ComboPraiseProvider.CONTENT_DOUBLE_CLICK_ANIM);
    }

    @Nullable
    public static List<Uri> getContentMultipleClickList() {
        return mHeartAnimationRes.get(ComboPraiseProvider.CONTENT_MULTIPLE_CLICK_ANIM);
    }

    @Nullable
    public static List<Uri> getIconMultipleClickList() {
        return mHeartAnimationRes.get(ComboPraiseProvider.ICON_MULTIPLE_CLICK_ANIM);
    }

    @Nullable
    public static List<Uri> getIconSingleClickList() {
        return mHeartAnimationRes.get(ComboPraiseProvider.ICON_SINGLE_CLICK_ANIM);
    }

    public static boolean heartAnimResourceExists() {
        if (getContentDoubleClickList() != null && getContentMultipleClickList() != null && getIconSingleClickList() != null && getIconMultipleClickList() != null) {
            return true;
        }
        return false;
    }

    @Deprecated
    public static Drawable getPraiseIconByType(String str, boolean z, boolean z2) {
        String str2;
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        if (!z2) {
            str2 = ComboPraiseProvider.PREFIX_NOT_PRESSED_UNCLICKED;
        } else {
            str2 = "";
        }
        String str3 = str2 + str;
        if (z) {
            if (mPraiseIconNightList.get(str3) == null) {
                return null;
            }
            if (mPraiseIconNightList.get(ComboPraiseProvider.PREFIX_PRESSED_CLICKED + str3) == null) {
                return null;
            }
            PraiseIconResource praiseIconResource = mPraiseIconNightList.get(str3);
            PraiseIconResource praiseIconResource2 = mPraiseIconNightList.get(ComboPraiseProvider.PREFIX_PRESSED_CLICKED + str3);
            if (praiseIconResource == null || praiseIconResource2 == null) {
                return null;
            }
            Drawable drawable = praiseIconResource.drawable;
            Drawable drawable2 = praiseIconResource2.drawable;
            StateListDrawable stateListDrawable = new StateListDrawable();
            stateListDrawable.addState(new int[]{16842919}, drawable2);
            stateListDrawable.addState(new int[0], drawable);
            return stateListDrawable;
        } else if (mPraiseIconDayList.get(str3) == null) {
            return null;
        } else {
            if (mPraiseIconDayList.get(ComboPraiseProvider.PREFIX_PRESSED_CLICKED + str3) == null) {
                return null;
            }
            PraiseIconResource praiseIconResource3 = mPraiseIconDayList.get(str3);
            PraiseIconResource praiseIconResource4 = mPraiseIconDayList.get(ComboPraiseProvider.PREFIX_PRESSED_CLICKED + str3);
            if (praiseIconResource3 == null || praiseIconResource4 == null) {
                return null;
            }
            Drawable drawable3 = praiseIconResource3.drawable;
            Drawable drawable4 = praiseIconResource4.drawable;
            StateListDrawable stateListDrawable2 = new StateListDrawable();
            stateListDrawable2.addState(new int[]{16842919}, drawable4);
            stateListDrawable2.addState(new int[0], drawable3);
            return stateListDrawable2;
        }
    }

    @Nullable
    public static Drawable getPraiseIconDrawableByName(String str, boolean z, boolean z2) {
        String praiseIconUrlByName = getPraiseIconUrlByName(str, z, z2);
        if (praiseIconUrlByName == null) {
            return null;
        }
        File file = new File(praiseIconUrlByName);
        if (!file.exists() || !file.isFile()) {
            return null;
        }
        return IResourcePackage.Utils.loadImageFromFile(AppRuntime.getAppContext(), file);
    }

    public static String getPraiseIconUrlByName(String str, boolean z, boolean z2) {
        if (!TextUtils.isEmpty(str) && sDayIconPathList.size() > 0 && sNightIconPathList.size() > 0) {
            String str2 = str + ".png";
            if (!z) {
                if (!z2) {
                    return sDayIconPathList.get(ComboPraiseProvider.PREFIX_NOT_PRESSED_UNCLICKED + str2);
                }
                return sDayIconPathList.get(str2);
            } else if (!z2) {
                return sNightIconPathList.get(ComboPraiseProvider.PREFIX_NOT_PRESSED_UNCLICKED + str2);
            } else {
                return sNightIconPathList.get(str2);
            }
        }
        return null;
    }

    @Nullable
    public static String getStrongAnimUrlByName(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        Map<String, String> map = sStrongAnimList;
        String str2 = map.get(str + ".webp");
        if (TextUtils.isEmpty(str2)) {
            return null;
        }
        return "file://" + str2;
    }

    public static void storeHeartPraiseAnim(File file, String str) {
        File[] findAllTargetFiles = IResourcePackage.Utils.findAllTargetFiles(file, ".webp", true);
        if (findAllTargetFiles != null && findAllTargetFiles.length > 0) {
            Arrays.sort(findAllTargetFiles);
            ArrayList arrayList = new ArrayList();
            for (File file2 : findAllTargetFiles) {
                arrayList.add(Uri.fromFile(file2));
            }
            mHeartAnimationRes.put(str, arrayList);
        }
    }

    public static void storePraiseIconResource(Context context, File file, boolean z) {
        Drawable loadImageFromFile;
        File[] findAllTargetFiles = IResourcePackage.Utils.findAllTargetFiles(file, ".png", true);
        if (findAllTargetFiles != null && findAllTargetFiles.length > 0) {
            for (File file2 : findAllTargetFiles) {
                if (file2 != null && (loadImageFromFile = IResourcePackage.Utils.loadImageFromFile(context, file2)) != null) {
                    if (!z) {
                        mPraiseIconDayList.put(file2.getName(), new PraiseIconResource(loadImageFromFile, file2.getAbsolutePath()));
                        sDayIconPathList.put(file2.getName(), file2.getAbsolutePath());
                    } else {
                        mPraiseIconNightList.put(file2.getName(), new PraiseIconResource(loadImageFromFile, file2.getAbsolutePath()));
                        sNightIconPathList.put(file2.getName(), file2.getAbsolutePath());
                    }
                }
            }
        }
    }

    public static void storeStrongPraiseAnim(File file) {
        File[] findAllTargetFiles = IResourcePackage.Utils.findAllTargetFiles(file, ".webp", true);
        if (findAllTargetFiles != null && findAllTargetFiles.length > 0) {
            for (File file2 : findAllTargetFiles) {
                if (file2 != null && file2.exists() && file2.isFile()) {
                    sStrongAnimList.put(file2.getName(), file2.getAbsolutePath());
                }
            }
        }
    }
}
