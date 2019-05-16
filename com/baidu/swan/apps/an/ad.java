package com.baidu.swan.apps.an;

import android.annotation.SuppressLint;
import android.annotation.TargetApi;
import android.content.ClipData;
import android.content.Context;
import android.text.ClipboardManager;
/* loaded from: classes2.dex */
public abstract class ad {
    protected static Context aZD;

    public abstract CharSequence getText();

    public abstract void setText(CharSequence charSequence);

    public static ad bW(Context context) {
        aZD = context.getApplicationContext();
        return com.baidu.swan.apps.an.a.hasHoneycomb() ? new a() : new b();
    }

    /* loaded from: classes2.dex */
    private static class b extends ad {
        private static ClipboardManager aZG = null;

        public b() {
            aZG = (ClipboardManager) aZD.getSystemService("clipboard");
        }

        @Override // com.baidu.swan.apps.an.ad
        public void setText(CharSequence charSequence) {
            aZG.setText(charSequence);
        }

        @Override // com.baidu.swan.apps.an.ad
        public CharSequence getText() {
            return aZG.getText();
        }
    }

    @TargetApi(11)
    /* loaded from: classes2.dex */
    private static class a extends ad {
        private static android.content.ClipboardManager aZE = null;
        private static ClipData aZF = null;

        @SuppressLint({"ServiceCast"})
        public a() {
            aZE = (android.content.ClipboardManager) aZD.getSystemService("clipboard");
        }

        @Override // com.baidu.swan.apps.an.ad
        public void setText(CharSequence charSequence) {
            aZF = ClipData.newPlainText("text/plain", charSequence);
            aZE.setPrimaryClip(aZF);
        }

        @Override // com.baidu.swan.apps.an.ad
        public CharSequence getText() {
            try {
                aZF = aZE.getPrimaryClip();
            } catch (Exception e) {
                if (com.baidu.swan.apps.b.DEBUG) {
                    throw e;
                }
            }
            if (aZF != null && aZF.getItemCount() > 0) {
                return aZF.getItemAt(0).getText();
            }
            return "";
        }
    }
}
