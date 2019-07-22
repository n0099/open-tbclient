package com.baidu.swan.apps.view.coverview.subview;

import android.content.Context;
import android.graphics.Color;
import android.support.annotation.NonNull;
import android.text.TextPaint;
import android.view.View;
import android.widget.TextView;
import com.baidu.swan.apps.an.z;
import com.baidu.swan.apps.b;
import com.baidu.swan.apps.view.coverview.b.c;
import com.baidu.swan.apps.view.coverview.subview.CoverViewHelper;
import com.baidu.tieba.pb.interactionpopupwindow.CustomDialogData;
import org.json.JSONObject;
/* loaded from: classes2.dex */
public class TextCoverView extends TextView implements a {
    private static final boolean DEBUG = b.DEBUG;
    private CoverViewHelper bcO;
    private com.baidu.swan.apps.view.coverview.b.a bcP;

    public TextCoverView(Context context) {
        super(context);
        this.bcO = new CoverViewHelper();
    }

    @Override // com.baidu.swan.apps.view.coverview.subview.a
    public void a(@NonNull com.baidu.swan.apps.view.coverview.b.a aVar) {
        if (aVar != null) {
            this.bcP = aVar;
            this.bcO.ar(this);
            JSONObject jSONObject = aVar.akZ;
            if (jSONObject != null) {
                this.bcO.a(this, jSONObject);
                if (getParent() != null && (getParent() instanceof View)) {
                    this.bcO.c((View) getParent(), jSONObject);
                }
                c(aVar);
            }
        }
    }

    @Override // com.baidu.swan.apps.view.coverview.subview.a
    public void setAlpha(@NonNull com.baidu.swan.apps.view.coverview.b.a aVar) {
        if (aVar.akZ != null && getParent() != null && (getParent() instanceof View)) {
            this.bcO.b((View) getParent(), aVar.akZ);
        }
    }

    @Override // com.baidu.swan.apps.view.coverview.subview.a
    public void setModel(@NonNull com.baidu.swan.apps.view.coverview.b.a aVar) {
        if (aVar != null) {
            this.bcP = aVar;
            this.bcO.ar(this);
        }
    }

    @Override // com.baidu.swan.apps.view.coverview.subview.a
    public void setOnActionCallback(com.baidu.swan.apps.view.coverview.a aVar) {
        this.bcO.setOnActionCallback(aVar);
    }

    @Override // com.baidu.swan.apps.view.coverview.subview.a
    public CoverViewHelper.a getClickPosition() {
        return this.bcO.getClickPosition();
    }

    @Override // com.baidu.swan.apps.view.coverview.subview.a
    public com.baidu.swan.apps.view.coverview.b.a getModel() {
        return this.bcP;
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    protected void c(@NonNull com.baidu.swan.apps.view.coverview.b.a aVar) {
        char c;
        int i;
        boolean z;
        boolean z2;
        JSONObject jSONObject = aVar.akZ;
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
            int ad = z.ad((float) jSONObject.optDouble("lineSpace", 0.0d));
            if (ad > 0) {
                setPadding(getPaddingLeft(), getPaddingTop() + (ad / 2), getPaddingRight(), getPaddingBottom());
                setLineSpacing(ad, 1.0f);
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
                    if (optString.equals(CustomDialogData.POS_LEFT)) {
                        c = 2;
                        break;
                    }
                    c = 65535;
                    break;
                case 108511772:
                    if (optString.equals("right")) {
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
