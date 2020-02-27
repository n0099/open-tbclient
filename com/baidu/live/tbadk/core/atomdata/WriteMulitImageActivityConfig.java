package com.baidu.live.tbadk.core.atomdata;

import android.app.Activity;
import com.baidu.live.tbadk.core.TbadkCoreApplication;
import com.baidu.live.tbadk.core.frameworkdata.IntentAction;
import com.baidu.live.tbadk.core.frameworkdata.IntentConfig;
import com.baidu.live.tbadk.img.WriteImagesInfo;
/* loaded from: classes3.dex */
public class WriteMulitImageActivityConfig extends IntentConfig {
    public static final int ENTRANCE_ALBUM = 2;
    public static final int ENTRANCE_CHOOSE_TAB = 1;
    public static final int ENTRANCE_NONE = 0;
    public static final int ENTRANCE_OTHER = 3;
    public static final String EXTRA_IMG_CURRENT_INDEX = "CurrentImgIndex";
    public static final String EXTRA_WRITE_IMG_INFO_JSON_STR = "WriteImgsInfoJsonStr";
    public static final String FILENAME = "file_name";
    public static final String FOURM_WRITE_DATA = "FourmWriteData";
    public static final String FOURM_WRITE_ENTRANCE = "FourmWriteIndex";
    public static final String SKIN_TYPE = "skinType";

    public WriteMulitImageActivityConfig(Activity activity, int i, WriteImagesInfo writeImagesInfo, int i2) {
        super(activity);
        int size;
        setIntentAction(IntentAction.ActivityForResult);
        setRequestCode(i);
        if (writeImagesInfo != null && writeImagesInfo.getChosedFiles() != null && (size = writeImagesInfo.getChosedFiles().size()) >= 1 && i2 >= 0 && i2 < size) {
            getIntent().putExtra("WriteImgsInfoJsonStr", writeImagesInfo.toJsonString());
            getIntent().putExtra("CurrentImgIndex", i2);
            getIntent().putExtra("skinType", TbadkCoreApplication.getInst().getSkinType());
        }
    }
}
