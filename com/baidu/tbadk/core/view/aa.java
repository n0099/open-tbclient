package com.baidu.tbadk.core.view;

import com.baidu.tbadk.core.view.NoDataViewFactory;
/* loaded from: classes.dex */
public class aa {
    NoDataViewFactory.ImgType Nb = NoDataViewFactory.ImgType.NONE;
    int mHeight = -1;

    private aa() {
    }

    public static aa a(NoDataViewFactory.ImgType imgType, int i) {
        aa aaVar = new aa();
        aaVar.Nb = imgType;
        aaVar.mHeight = i;
        return aaVar;
    }

    public static aa a(NoDataViewFactory.ImgType imgType) {
        aa aaVar = new aa();
        aaVar.Nb = imgType;
        return aaVar;
    }
}
