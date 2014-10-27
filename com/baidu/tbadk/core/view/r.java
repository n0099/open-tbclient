package com.baidu.tbadk.core.view;

import com.baidu.tbadk.core.view.NoDataViewFactory;
/* loaded from: classes.dex */
public class r {
    NoDataViewFactory.ImgType Ih = NoDataViewFactory.ImgType.NONE;
    int mHeight = -1;

    private r() {
    }

    public static r a(NoDataViewFactory.ImgType imgType, int i) {
        r rVar = new r();
        rVar.Ih = imgType;
        rVar.mHeight = i;
        return rVar;
    }

    public static r a(NoDataViewFactory.ImgType imgType) {
        r rVar = new r();
        rVar.Ih = imgType;
        return rVar;
    }
}
