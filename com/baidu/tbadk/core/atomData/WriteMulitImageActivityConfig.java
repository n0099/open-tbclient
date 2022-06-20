package com.baidu.tbadk.core.atomData;

import android.app.Activity;
import android.content.Context;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.frameworkData.IntentAction;
import com.baidu.tbadk.core.frameworkData.IntentConfig;
import com.baidu.tbadk.img.WriteImagesInfo;
import com.baidu.tieba.frs.ForumWriteData;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes3.dex */
public class WriteMulitImageActivityConfig extends IntentConfig {
    public static /* synthetic */ Interceptable $ic = null;
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
    public transient /* synthetic */ FieldHolder $fh;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public WriteMulitImageActivityConfig(Activity activity, int i, WriteImagesInfo writeImagesInfo, int i2) {
        super(activity);
        int size;
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {activity, Integer.valueOf(i), writeImagesInfo, Integer.valueOf(i2)};
            interceptable.invokeUnInit(65536, newInitContext);
            int i3 = newInitContext.flag;
            if ((i3 & 1) != 0) {
                int i4 = i3 & 2;
                super((Context) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        setIntentAction(IntentAction.ActivityForResult);
        setRequestCode(i);
        if (writeImagesInfo != null && writeImagesInfo.getChosedFiles() != null && (size = writeImagesInfo.getChosedFiles().size()) >= 1 && i2 >= 0 && i2 < size) {
            getIntent().putExtra(EXTRA_WRITE_IMG_INFO_JSON_STR, writeImagesInfo.toJsonString());
            getIntent().putExtra(EXTRA_IMG_CURRENT_INDEX, i2);
            getIntent().putExtra(SKIN_TYPE, TbadkCoreApplication.getInst().getSkinType());
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public WriteMulitImageActivityConfig(Activity activity, int i, WriteImagesInfo writeImagesInfo, int i2, ForumWriteData forumWriteData, int i3) {
        super(activity);
        int size;
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {activity, Integer.valueOf(i), writeImagesInfo, Integer.valueOf(i2), forumWriteData, Integer.valueOf(i3)};
            interceptable.invokeUnInit(65537, newInitContext);
            int i4 = newInitContext.flag;
            if ((i4 & 1) != 0) {
                int i5 = i4 & 2;
                super((Context) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        setIntentAction(IntentAction.ActivityForResult);
        setRequestCode(i);
        if (writeImagesInfo != null && writeImagesInfo.getChosedFiles() != null && (size = writeImagesInfo.getChosedFiles().size()) >= 1 && i2 >= 0 && i2 < size) {
            getIntent().putExtra(EXTRA_WRITE_IMG_INFO_JSON_STR, writeImagesInfo.toJsonString());
            getIntent().putExtra(EXTRA_IMG_CURRENT_INDEX, i2);
            getIntent().putExtra(FOURM_WRITE_DATA, forumWriteData);
            getIntent().putExtra(FOURM_WRITE_ENTRANCE, i3);
            getIntent().putExtra(SKIN_TYPE, TbadkCoreApplication.getInst().getSkinType());
        }
    }
}
