package com.baidu.searchbox;

import android.text.TextUtils;
import java.io.File;
/* loaded from: classes2.dex */
public class NPSPatch {
    public static final String TAG = "NPSPatch";
    public String newMD5;
    public String oldFileName;
    public String patchFileName;

    public NPSPatch(String str, String str2, String str3) {
        this.oldFileName = null;
        this.newMD5 = null;
        this.patchFileName = null;
        if (!TextUtils.isEmpty(str) && !TextUtils.isEmpty(str2) && !TextUtils.isEmpty(str3)) {
            this.oldFileName = str;
            this.patchFileName = str2;
            this.newMD5 = str3;
            return;
        }
        throw new IllegalArgumentException("old file name or patch file name is null.");
    }

    public int bsPatch(String str) {
        int patch = NPSPatchUtils.patch(this.oldFileName, str, this.patchFileName);
        if (patch == 0 && !checkMD5(str)) {
            return 2;
        }
        return patch;
    }

    public boolean checkMD5(String str) {
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        return TextUtils.equals(this.newMD5, NPSPatchUtils.toMd5(new File(str), false));
    }
}
