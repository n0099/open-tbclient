package com.baidu.tbadk.core.atomData;

import android.app.Activity;
import com.baidu.tbadk.core.frameworkData.IntentAction;
import com.baidu.tbadk.img.WriteImagesInfo;
/* loaded from: classes.dex */
public class cg extends com.baidu.tbadk.core.frameworkData.a {
    public cg(Activity activity, int i, WriteImagesInfo writeImagesInfo, int i2) {
        super(activity);
        int size;
        setIntentAction(IntentAction.ActivityForResult);
        setRequestCode(i);
        if (writeImagesInfo != null && writeImagesInfo.getChosedFiles() != null && (size = writeImagesInfo.getChosedFiles().size()) >= 1 && i2 >= 0 && i2 < size) {
            getIntent().putExtra("WriteImgsInfoJsonStr", writeImagesInfo.toJsonString());
            getIntent().putExtra("CurrentImgIndex", i2);
        }
    }
}
