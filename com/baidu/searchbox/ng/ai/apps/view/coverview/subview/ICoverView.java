package com.baidu.searchbox.ng.ai.apps.view.coverview.subview;

import android.support.annotation.NonNull;
import com.baidu.searchbox.ng.ai.apps.view.coverview.OnActionCallback;
import com.baidu.searchbox.ng.ai.apps.view.coverview.model.CoverViewModel;
import com.baidu.searchbox.ng.ai.apps.view.coverview.subview.CoverViewHelper;
/* loaded from: classes2.dex */
public interface ICoverView {
    void bindModel(@NonNull CoverViewModel coverViewModel);

    CoverViewHelper.ClickPosition getClickPosition();

    CoverViewModel getModel();

    void setModel(@NonNull CoverViewModel coverViewModel);

    void setOnActionCallback(OnActionCallback onActionCallback);
}
