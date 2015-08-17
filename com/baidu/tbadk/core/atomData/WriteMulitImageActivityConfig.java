package com.baidu.tbadk.core.atomData;

import android.app.Activity;
import com.baidu.tbadk.core.frameworkData.IntentAction;
import com.baidu.tbadk.core.frameworkData.IntentConfig;
import com.baidu.tbadk.img.WriteImagesInfo;
/* loaded from: classes.dex */
public class WriteMulitImageActivityConfig extends IntentConfig {
    public static final String EXTRA_IMG_CURRENT_INDEX = "CurrentImgIndex";
    public static final String EXTRA_WRITE_IMG_INFO_JSON_STR = "WriteImgsInfoJsonStr";

    public WriteMulitImageActivityConfig(Activity activity, int i, WriteImagesInfo writeImagesInfo, int i2) {
        super(activity);
        int size;
        setIntentAction(IntentAction.ActivityForResult);
        setRequestCode(i);
        if (writeImagesInfo != null && writeImagesInfo.getChosedFiles() != null && (size = writeImagesInfo.getChosedFiles().size()) >= 1 && i2 >= 0 && i2 < size) {
            getIntent().putExtra(EXTRA_WRITE_IMG_INFO_JSON_STR, writeImagesInfo.toJsonString());
            getIntent().putExtra(EXTRA_IMG_CURRENT_INDEX, i2);
        }
    }
}
