package com.baidu.searchbox.ng.ai.apps.view.coverview.subview;

import android.annotation.SuppressLint;
import android.graphics.Color;
import android.graphics.drawable.GradientDrawable;
import android.support.annotation.NonNull;
import android.view.MotionEvent;
import android.view.View;
import com.baidu.searchbox.ng.ai.apps.console.AiAppsLog;
import com.baidu.searchbox.ng.ai.apps.util.AiAppJSONUtils;
import com.baidu.searchbox.ng.ai.apps.util.AiAppsUIUtils;
import com.baidu.searchbox.ng.ai.apps.view.container.touch.AiAppsTouchListener;
import com.baidu.searchbox.ng.ai.apps.view.coverview.OnActionCallback;
import org.json.JSONArray;
import org.json.JSONObject;
/* loaded from: classes2.dex */
public class CoverViewHelper {
    private static final String BACK_GROUND = "bgColor";
    private static final String BORDER_COLOR = "borderColor";
    private static final String BORDER_RADIUS = "borderRadius";
    private static final String BORDER_WIDTH = "borderWidth";
    private static final boolean DEBUG = false;
    private static final int IDX_PADDING_BOTTOM = 2;
    private static final int IDX_PADDING_LEFT = 3;
    private static final int IDX_PADDING_RIGHT = 1;
    private static final int IDX_PADDING_TOP = 0;
    public static final String OPACITY = "opacity";
    private static final String PADDING = "padding";
    private static final String TAG = "CoverView";
    protected OnActionCallback mActionCallback;
    private ClickPosition mClkPosition = new ClickPosition();

    /* loaded from: classes2.dex */
    public static class ClickPosition {
        public float x;
        public float y;
    }

    /* loaded from: classes2.dex */
    public enum Type {
        TEXT,
        IMAGE
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void bindTouch(final View view) {
        if (!AiAppsTouchListener.isNewCore()) {
            view.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.searchbox.ng.ai.apps.view.coverview.subview.CoverViewHelper.1
                @Override // android.view.View.OnClickListener
                public void onClick(View view2) {
                    if (CoverViewHelper.this.mActionCallback != null) {
                        CoverViewHelper.this.mActionCallback.onAction(2, view, null);
                    }
                }
            });
            view.setOnTouchListener(new View.OnTouchListener() { // from class: com.baidu.searchbox.ng.ai.apps.view.coverview.subview.CoverViewHelper.2
                @Override // android.view.View.OnTouchListener
                @SuppressLint({"ClickableViewAccessibility"})
                public boolean onTouch(View view2, MotionEvent motionEvent) {
                    if (motionEvent.getAction() == 1) {
                        CoverViewHelper.this.mClkPosition.x = motionEvent.getRawX();
                        CoverViewHelper.this.mClkPosition.y = motionEvent.getRawY();
                        return false;
                    }
                    return false;
                }
            });
        }
    }

    public void setOnActionCallback(OnActionCallback onActionCallback) {
        if (this.mActionCallback != onActionCallback) {
            this.mActionCallback = onActionCallback;
        }
    }

    public OnActionCallback getOnActionCallback() {
        return this.mActionCallback;
    }

    public void bindBaseProperty(@NonNull View view, @NonNull JSONObject jSONObject) {
        JSONArray optJSONArray = jSONObject.optJSONArray(PADDING);
        if (optJSONArray != null && optJSONArray.length() == 4) {
            view.setPadding(AiAppsUIUtils.dp2px((float) optJSONArray.optDouble(3, 0.0d)), AiAppsUIUtils.dp2px((float) optJSONArray.optDouble(0, 0.0d)), AiAppsUIUtils.dp2px((float) optJSONArray.optDouble(1, 0.0d)), AiAppsUIUtils.dp2px((float) optJSONArray.optDouble(2, 0.0d)));
        }
        float f = AiAppJSONUtils.getFloat(jSONObject, OPACITY, -1.0f);
        if (f >= 0.0f && f <= 1.0f) {
            view.setAlpha(f);
        }
    }

    public void bindBackground(@NonNull View view, @NonNull JSONObject jSONObject) {
        int i;
        int i2 = 0;
        try {
            i = Color.parseColor(jSONObject.optString(BACK_GROUND));
        } catch (Exception e) {
            AiAppsLog.e("CoverView", "bgColor occurs exception", e);
            i = 0;
        }
        int optInt = jSONObject.optInt(BORDER_RADIUS);
        int optInt2 = jSONObject.optInt(BORDER_WIDTH);
        try {
            i2 = Color.parseColor(jSONObject.optString(BORDER_COLOR));
        } catch (Exception e2) {
            AiAppsLog.e("CoverView", "borderColor occurs exception", e2);
        }
        GradientDrawable gradientDrawable = new GradientDrawable();
        gradientDrawable.setColor(i);
        gradientDrawable.setCornerRadius(optInt);
        gradientDrawable.setStroke(optInt2, i2);
        view.setBackground(gradientDrawable);
    }

    public ClickPosition getClickPosition() {
        return this.mClkPosition;
    }
}
