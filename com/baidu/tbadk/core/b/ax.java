package com.baidu.tbadk.core.b;

import com.baidu.tbadk.core.frameworkData.IntentAction;
import com.baidu.tbadk.img.WriteImagesInfo;
/* loaded from: classes.dex */
public class ax extends com.baidu.tbadk.core.frameworkData.a {
    public ax(com.baidu.tbadk.a aVar, int i, WriteImagesInfo writeImagesInfo, int i2) {
        super(aVar);
        int size;
        a(IntentAction.ActivityForResult);
        a(12012);
        if (writeImagesInfo != null && writeImagesInfo.getChosedFiles() != null && (size = writeImagesInfo.getChosedFiles().size()) > 0 && i2 >= 0 && i2 < size) {
            d().putExtra("WriteImgsInfoJsonStr", writeImagesInfo.toJsonString());
            d().putExtra("CurrentImgIndex", i2);
        }
    }
}
