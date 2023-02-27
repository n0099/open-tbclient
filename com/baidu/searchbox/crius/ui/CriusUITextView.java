package com.baidu.searchbox.crius.ui;

import android.content.Context;
import android.graphics.Paint;
import android.text.TextUtils;
import android.view.View;
import com.baidu.android.util.devices.DeviceUtils;
import com.baidu.crius.CriusNode;
import com.baidu.searchbox.common.runtime.AppRuntime;
import com.baidu.searchbox.crius.parser.CriusData;
import view.CriusTextView;
/* loaded from: classes2.dex */
public class CriusUITextView extends CriusUI<CriusTextView> {
    public static final String TAG = "CriusUITextView";

    public CriusUITextView(Context context, CriusData criusData) {
        super(context, criusData);
    }

    private int getLabelTop(int i, int i2) {
        float f = i;
        CriusData criusData = this.renderObject;
        if (criusData != null && !TextUtils.isEmpty(criusData.text) && getView() != null) {
            Paint paint = new Paint();
            paint.setTextSize(DeviceUtils.ScreenInfo.dp2px(AppRuntime.getAppContext(), (float) this.renderObject.fontSize()));
            paint.measureText(this.renderObject.text);
            Paint.FontMetrics fontMetrics = paint.getFontMetrics();
            float f2 = fontMetrics.ascent;
            f += getView().getBaseline() + f2 + (((fontMetrics.descent - f2) - i2) / 2.0f);
        }
        return (int) f;
    }

    @Override // com.baidu.searchbox.crius.ui.CriusUI, com.baidu.searchbox.crius.ui.RenderImplInterface
    public void layout(float f, float f2) {
        CriusData prefixLabel;
        View view2;
        super.layout(f, f2);
        CriusData criusData = this.renderObject;
        if (criusData != null && (prefixLabel = criusData.getPrefixLabel()) != null && prefixLabel.getUI() != null && (view2 = prefixLabel.getUI().getView()) != null && view2.getMeasuredWidth() > 0 && view2.getMeasuredHeight() > 0) {
            CriusNode criusNode = this.renderObject.criusNode;
            int round = Math.round(f + criusNode.getLayoutX());
            int labelTop = getLabelTop(Math.round(f2 + criusNode.getLayoutY()), view2.getMeasuredHeight());
            view2.layout(round, labelTop, view2.getMeasuredWidth() + round, view2.getMeasuredHeight() + labelTop);
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.searchbox.crius.ui.CriusUI
    public CriusTextView createView(Context context) {
        new CriusTextView(context).setIncludeFontPadding(true);
        return new CriusTextView(context);
    }
}
