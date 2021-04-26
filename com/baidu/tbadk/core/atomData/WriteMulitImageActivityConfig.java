package com.baidu.tbadk.core.atomData;

import android.app.Activity;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.frameworkData.IntentAction;
import com.baidu.tbadk.core.frameworkData.IntentConfig;
import com.baidu.tbadk.img.WriteImagesInfo;
import com.baidu.tieba.frs.ForumWriteData;
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

    public WriteMulitImageActivityConfig(Activity activity, int i2, WriteImagesInfo writeImagesInfo, int i3) {
        super(activity);
        int size;
        setIntentAction(IntentAction.ActivityForResult);
        setRequestCode(i2);
        if (writeImagesInfo != null && writeImagesInfo.getChosedFiles() != null && (size = writeImagesInfo.getChosedFiles().size()) >= 1 && i3 >= 0 && i3 < size) {
            getIntent().putExtra(EXTRA_WRITE_IMG_INFO_JSON_STR, writeImagesInfo.toJsonString());
            getIntent().putExtra(EXTRA_IMG_CURRENT_INDEX, i3);
            getIntent().putExtra(SKIN_TYPE, TbadkCoreApplication.getInst().getSkinType());
        }
    }

    public WriteMulitImageActivityConfig(Activity activity, int i2, WriteImagesInfo writeImagesInfo, int i3, ForumWriteData forumWriteData, int i4) {
        super(activity);
        int size;
        setIntentAction(IntentAction.ActivityForResult);
        setRequestCode(i2);
        if (writeImagesInfo != null && writeImagesInfo.getChosedFiles() != null && (size = writeImagesInfo.getChosedFiles().size()) >= 1 && i3 >= 0 && i3 < size) {
            getIntent().putExtra(EXTRA_WRITE_IMG_INFO_JSON_STR, writeImagesInfo.toJsonString());
            getIntent().putExtra(EXTRA_IMG_CURRENT_INDEX, i3);
            getIntent().putExtra(FOURM_WRITE_DATA, forumWriteData);
            getIntent().putExtra(FOURM_WRITE_ENTRANCE, i4);
            getIntent().putExtra(SKIN_TYPE, TbadkCoreApplication.getInst().getSkinType());
        }
    }
}
