package com.baidu.tbadk.core.view;

import com.baidu.tbadk.core.view.NoDataViewFactory;
/* loaded from: classes.dex */
public class v {
    NoDataViewFactory.ImgType YF = NoDataViewFactory.ImgType.NONE;
    int mHeight = -1;

    private v() {
    }

    public static v a(NoDataViewFactory.ImgType imgType, int i) {
        v vVar = new v();
        vVar.YF = imgType;
        vVar.mHeight = i;
        return vVar;
    }

    public static v a(NoDataViewFactory.ImgType imgType) {
        v vVar = new v();
        vVar.YF = imgType;
        return vVar;
    }
}
