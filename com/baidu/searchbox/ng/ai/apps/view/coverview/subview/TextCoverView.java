package com.baidu.searchbox.ng.ai.apps.view.coverview.subview;

import android.content.Context;
import android.graphics.Color;
import android.support.annotation.NonNull;
import android.text.TextPaint;
import android.widget.TextView;
import com.baidu.searchbox.ng.ai.apps.console.AiAppsLog;
import com.baidu.searchbox.ng.ai.apps.util.AiAppsUIUtils;
import com.baidu.searchbox.ng.ai.apps.view.coverview.OnActionCallback;
import com.baidu.searchbox.ng.ai.apps.view.coverview.model.CoverViewModel;
import com.baidu.searchbox.ng.ai.apps.view.coverview.model.TextCoverViewModel;
import com.baidu.searchbox.ng.ai.apps.view.coverview.subview.CoverViewHelper;
import org.json.JSONObject;
/* loaded from: classes2.dex */
public class TextCoverView extends TextView implements ICoverView {
    private static final boolean DEBUG = false;
    private static final String FONT_WEIGHT = "fontWeight";
    private static final String FONT_WEIGHT_BOLD = "bold";
    private static final String FONT_WEIGHT_NORMAL = "normal";
    private static final String LINE_BREAK = "lineBreak";
    private static final String LINE_HEIGHT = "lineHeight";
    private static final String TAG = "CoverView";
    private static final String TEXT_ALIGN = "textAlign";
    private static final String TEXT_ALIGN_CENTER = "center";
    private static final String TEXT_ALIGN_LEFT = "left";
    private static final String TEXT_ALIGN_RIGHT = "right";
    private static final String TEXT_COLOR = "color";
    private static final String TEXT_SIZE = "fontSize";
    private static final String WHITE_SPACE = "whiteSpace";
    private static final String WHITE_SPACE_NORMAL = "normal";
    private static final String WHITE_SPACE_NOWRAP = "nowrap";
    private CoverViewHelper mCoverViewHelper;
    private CoverViewModel mModel;

    public TextCoverView(Context context) {
        super(context);
        this.mCoverViewHelper = new CoverViewHelper();
    }

    @Override // com.baidu.searchbox.ng.ai.apps.view.coverview.subview.ICoverView
    public void bindModel(@NonNull CoverViewModel coverViewModel) {
        if (coverViewModel != null) {
            this.mModel = coverViewModel;
            this.mCoverViewHelper.bindTouch(this);
            JSONObject jSONObject = coverViewModel.styleData;
            if (jSONObject != null) {
                this.mCoverViewHelper.bindBackground(this, jSONObject);
                this.mCoverViewHelper.bindBaseProperty(this, jSONObject);
                bindTextStyle(coverViewModel);
            }
        }
    }

    @Override // com.baidu.searchbox.ng.ai.apps.view.coverview.subview.ICoverView
    public void setModel(@NonNull CoverViewModel coverViewModel) {
        if (coverViewModel != null) {
            this.mModel = coverViewModel;
            this.mCoverViewHelper.bindTouch(this);
        }
    }

    @Override // com.baidu.searchbox.ng.ai.apps.view.coverview.subview.ICoverView
    public void setOnActionCallback(OnActionCallback onActionCallback) {
        this.mCoverViewHelper.setOnActionCallback(onActionCallback);
    }

    @Override // com.baidu.searchbox.ng.ai.apps.view.coverview.subview.ICoverView
    public CoverViewHelper.ClickPosition getClickPosition() {
        return this.mCoverViewHelper.getClickPosition();
    }

    @Override // com.baidu.searchbox.ng.ai.apps.view.coverview.subview.ICoverView
    public CoverViewModel getModel() {
        return this.mModel;
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    protected void bindTextStyle(@NonNull CoverViewModel coverViewModel) {
        int dp2px;
        char c;
        int i;
        boolean z;
        boolean z2;
        JSONObject jSONObject = coverViewModel.styleData;
        if (jSONObject != null) {
            if (coverViewModel instanceof TextCoverViewModel) {
                setText(((TextCoverViewModel) coverViewModel).text);
            }
            try {
                setTextColor(Color.parseColor(jSONObject.optString(TEXT_COLOR)));
            } catch (Exception e) {
                AiAppsLog.e("CoverView", "text color occurs exception", e);
            }
            int optInt = jSONObject.optInt(TEXT_SIZE);
            if (optInt > 0) {
                setTextSize(1, optInt);
            }
            if (AiAppsUIUtils.dp2px((float) jSONObject.optDouble(LINE_HEIGHT, 0.0d)) > 0) {
                setLineSpacing(dp2px - getLineHeight(), 1.0f);
            }
            String optString = jSONObject.optString(TEXT_ALIGN);
            switch (optString.hashCode()) {
                case -1364013995:
                    if (optString.equals(TEXT_ALIGN_CENTER)) {
                        c = 1;
                        break;
                    }
                    c = 65535;
                    break;
                case 3317767:
                    if (optString.equals("left")) {
                        c = 2;
                        break;
                    }
                    c = 65535;
                    break;
                case 108511772:
                    if (optString.equals(TEXT_ALIGN_RIGHT)) {
                        c = 0;
                        break;
                    }
                    c = 65535;
                    break;
                default:
                    c = 65535;
                    break;
            }
            switch (c) {
                case 0:
                    i = 5;
                    break;
                case 1:
                    i = 17;
                    break;
                default:
                    i = 3;
                    break;
            }
            setGravity(i);
            String optString2 = jSONObject.optString(FONT_WEIGHT);
            TextPaint paint = getPaint();
            switch (optString2.hashCode()) {
                case -1039745817:
                    if (optString2.equals("normal")) {
                        z = true;
                        break;
                    }
                    z = true;
                    break;
                case 3029637:
                    if (optString2.equals(FONT_WEIGHT_BOLD)) {
                        z = false;
                        break;
                    }
                    z = true;
                    break;
                default:
                    z = true;
                    break;
            }
            switch (z) {
                case false:
                    if (paint != null) {
                        paint.setFakeBoldText(true);
                        break;
                    }
                    break;
                default:
                    if (paint != null) {
                        paint.setFakeBoldText(false);
                        break;
                    }
                    break;
            }
            String optString3 = jSONObject.optString(WHITE_SPACE);
            switch (optString3.hashCode()) {
                case -1039745817:
                    if (optString3.equals("normal")) {
                        z2 = false;
                        break;
                    }
                    z2 = true;
                    break;
                case -1039592053:
                    if (optString3.equals(WHITE_SPACE_NOWRAP)) {
                        z2 = true;
                        break;
                    }
                    z2 = true;
                    break;
                default:
                    z2 = true;
                    break;
            }
            switch (z2) {
                case false:
                    setSingleLine(false);
                    return;
                case true:
                    setSingleLine(true);
                    return;
                default:
                    return;
            }
        }
    }
}
