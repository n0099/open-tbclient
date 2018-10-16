package com.baidu.searchbox.ng.ai.apps.view.container;

import android.content.Context;
import android.support.annotation.NonNull;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import com.baidu.searchbox.ng.ai.apps.model.view.base.AiAppsNaViewModel;
import com.baidu.searchbox.ng.ai.apps.util.AiAppsUtils;
import com.baidu.searchbox.ng.ai.apps.view.container.touch.AiAppsTouchListener;
import com.baidu.searchbox.ng.ai.apps.view.container.util.NAViewUtils;
/* loaded from: classes2.dex */
public class AiAppsNAViewContainer extends FrameLayout {
    private static final boolean DEBUG = false;
    public static final String NO_ID = "No_Id";
    private static final String TAG = "AiAppsNAViewContainer";
    private AiAppsNaViewModel mModel;
    private View mNAView;

    public AiAppsNAViewContainer(@NonNull Context context) {
        super(context);
    }

    public boolean insertView(View view, AiAppsNaViewModel aiAppsNaViewModel) {
        if (view == null || aiAppsNaViewModel == null) {
            return false;
        }
        bindModel(aiAppsNaViewModel);
        addViewInner(view);
        return attach();
    }

    public boolean updateView(@NonNull AiAppsNaViewModel aiAppsNaViewModel) {
        return NAViewUtils.updateNAView(this, aiAppsNaViewModel);
    }

    public boolean removeView() {
        IAiAppsNAViewRoot currentNAViewRoot;
        boolean z = false;
        if (this.mModel != null && (currentNAViewRoot = AiAppsUtils.getCurrentNAViewRoot(this.mModel.slaveId)) != null && (z = NAViewUtils.removeNAViewFromParent(this, currentNAViewRoot))) {
            NAViewUtils.unregisterWidgetFromCache(this, currentNAViewRoot);
            this.mNAView = null;
        }
        return z;
    }

    public View getNAView() {
        return this.mNAView;
    }

    public void bindModel(AiAppsNaViewModel aiAppsNaViewModel) {
        if (aiAppsNaViewModel == null) {
            this.mModel = null;
            return;
        }
        this.mModel = aiAppsNaViewModel.cloneModel();
        setHidden(this.mModel.hidden);
        setGesture(this.mModel.gesture);
    }

    public AiAppsNaViewModel getModel() {
        return this.mModel;
    }

    public void setHidden(boolean z) {
        setVisibility(z ? 8 : 0);
        if (this.mModel != null) {
            this.mModel.hidden = z;
        }
    }

    public void setGesture(boolean z) {
        if (this.mModel != null) {
            this.mModel.gesture = z;
            if (z) {
                setOnTouchListener(new AiAppsTouchListener(this.mModel.slaveId, this.mModel.id, this.mModel.viewType) { // from class: com.baidu.searchbox.ng.ai.apps.view.container.AiAppsNAViewContainer.1
                    @Override // com.baidu.searchbox.ng.ai.apps.view.container.touch.AiAppsTouchListener, android.view.View.OnTouchListener
                    public boolean onTouch(View view, MotionEvent motionEvent) {
                        return AiAppsNAViewContainer.this.mModel != null && AiAppsNAViewContainer.this.mModel.gesture && super.onTouch(view, motionEvent);
                    }
                });
            }
        }
    }

    public String getSlaveId() {
        return this.mModel != null ? this.mModel.slaveId : NO_ID;
    }

    public String getViewId() {
        return this.mModel != null ? this.mModel.id : NO_ID;
    }

    public String getParentId() {
        return this.mModel != null ? this.mModel.parentId : NO_ID;
    }

    public void syncPosition(ViewGroup.MarginLayoutParams marginLayoutParams) {
        if (marginLayoutParams != null && this.mModel != null && this.mModel.position != null) {
            this.mModel.position.setLeft(marginLayoutParams.leftMargin);
            this.mModel.position.setTop(marginLayoutParams.topMargin);
            setLayoutParams(marginLayoutParams);
        }
    }

    public boolean attach() {
        IAiAppsNAViewRoot currentNAViewRoot;
        boolean z = false;
        if (this.mModel != null && (currentNAViewRoot = AiAppsUtils.getCurrentNAViewRoot(this.mModel.slaveId)) != null && (z = NAViewUtils.attachNAViewToParent(this, currentNAViewRoot))) {
            NAViewUtils.registerWidgetToCache(this, currentNAViewRoot);
        }
        return z;
    }

    @Override // android.view.ViewGroup
    public void addView(View view) {
        super.addView(view);
        this.mNAView = view;
    }

    @Override // android.view.ViewGroup
    public void addView(View view, int i) {
        super.addView(view, i);
        this.mNAView = view;
    }

    private void addViewInner(View view) {
        addView(view, generateDefaultLayoutParams());
        this.mNAView = view;
    }
}
