package com.baidu.swan.apps.view.coverview.subview;

import android.content.Context;
import android.graphics.Color;
import android.support.annotation.NonNull;
import android.text.TextPaint;
import android.view.View;
import android.widget.TextView;
import com.baidu.live.adp.widget.HorizontalTranslateLayout;
import com.baidu.swan.apps.an.z;
import com.baidu.swan.apps.b;
import com.baidu.swan.apps.view.coverview.b.c;
import com.baidu.swan.apps.view.coverview.subview.CoverViewHelper;
import org.json.JSONObject;
/* loaded from: classes2.dex */
public class TextCoverView extends TextView implements a {
    private static final boolean DEBUG = b.DEBUG;
    private CoverViewHelper bvt;
    private com.baidu.swan.apps.view.coverview.b.a bvu;

    public TextCoverView(Context context) {
        super(context);
        this.bvt = new CoverViewHelper();
    }

    @Override // com.baidu.swan.apps.view.coverview.subview.a
    public void a(@NonNull com.baidu.swan.apps.view.coverview.b.a aVar) {
        if (aVar != null) {
            this.bvu = aVar;
            this.bvt.ax(this);
            JSONObject jSONObject = aVar.aEB;
            if (jSONObject != null) {
                this.bvt.a(this, jSONObject);
                if (getParent() != null && (getParent() instanceof View)) {
                    this.bvt.c((View) getParent(), jSONObject);
                }
                c(aVar);
            }
        }
    }

    @Override // com.baidu.swan.apps.view.coverview.subview.a
    public void setAlpha(@NonNull com.baidu.swan.apps.view.coverview.b.a aVar) {
        if (aVar.aEB != null && getParent() != null && (getParent() instanceof View)) {
            this.bvt.b((View) getParent(), aVar.aEB);
        }
    }

    @Override // com.baidu.swan.apps.view.coverview.subview.a
    public void setModel(@NonNull com.baidu.swan.apps.view.coverview.b.a aVar) {
        if (aVar != null) {
            this.bvu = aVar;
            this.bvt.ax(this);
        }
    }

    @Override // com.baidu.swan.apps.view.coverview.subview.a
    public void setOnActionCallback(com.baidu.swan.apps.view.coverview.a aVar) {
        this.bvt.setOnActionCallback(aVar);
    }

    @Override // com.baidu.swan.apps.view.coverview.subview.a
    public CoverViewHelper.a getClickPosition() {
        return this.bvt.getClickPosition();
    }

    @Override // com.baidu.swan.apps.view.coverview.subview.a
    public com.baidu.swan.apps.view.coverview.b.a getModel() {
        return this.bvu;
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    protected void c(@NonNull com.baidu.swan.apps.view.coverview.b.a aVar) {
        char c;
        int i;
        boolean z;
        boolean z2;
        JSONObject jSONObject = aVar.aEB;
        if (jSONObject != null) {
            if (aVar instanceof c) {
                setText(((c) aVar).text);
            }
            try {
                setTextColor(Color.parseColor(jSONObject.optString("color")));
            } catch (Exception e) {
                com.baidu.swan.apps.console.c.e("CoverView", "text color occurs exception", e);
            }
            int optInt = jSONObject.optInt("fontSize");
            if (optInt > 0) {
                setTextSize(1, optInt);
            }
            int S = z.S((float) jSONObject.optDouble("lineSpace", 0.0d));
            if (S > 0) {
                setPadding(getPaddingLeft(), getPaddingTop() + (S / 2), getPaddingRight(), getPaddingBottom());
                setLineSpacing(S, 1.0f);
            }
            String optString = jSONObject.optString("textAlign");
            switch (optString.hashCode()) {
                case -1364013995:
                    if (optString.equals("center")) {
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
                    if (optString.equals(HorizontalTranslateLayout.RIGHT)) {
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
                    i = 53;
                    break;
                case 1:
                    i = 49;
                    break;
                default:
                    i = 51;
                    break;
            }
            setGravity(i);
            String optString2 = jSONObject.optString("fontWeight");
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
                    if (optString2.equals("bold")) {
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
            String optString3 = jSONObject.optString("whiteSpace");
            switch (optString3.hashCode()) {
                case -1039745817:
                    if (optString3.equals("normal")) {
                        z2 = false;
                        break;
                    }
                    z2 = true;
                    break;
                case -1039592053:
                    if (optString3.equals("nowrap")) {
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
