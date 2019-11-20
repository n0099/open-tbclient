package com.baidu.swan.apps.an;

import android.annotation.SuppressLint;
import android.annotation.TargetApi;
import android.content.ClipData;
import android.content.Context;
import android.text.ClipboardManager;
/* loaded from: classes2.dex */
public abstract class ad {
    protected static Context bsT;

    public abstract CharSequence getText();

    public abstract void setText(CharSequence charSequence);

    public static ad bW(Context context) {
        bsT = context.getApplicationContext();
        return com.baidu.swan.apps.an.a.hasHoneycomb() ? new a() : new b();
    }

    /* loaded from: classes2.dex */
    private static class b extends ad {
        private static ClipboardManager bsW = null;

        public b() {
            bsW = (ClipboardManager) bsT.getSystemService("clipboard");
        }

        @Override // com.baidu.swan.apps.an.ad
        public void setText(CharSequence charSequence) {
            bsW.setText(charSequence);
        }

        @Override // com.baidu.swan.apps.an.ad
        public CharSequence getText() {
            return bsW.getText();
        }
    }

    @TargetApi(11)
    /* loaded from: classes2.dex */
    private static class a extends ad {
        private static android.content.ClipboardManager bsU = null;
        private static ClipData bsV = null;

        @SuppressLint({"ServiceCast"})
        public a() {
            bsU = (android.content.ClipboardManager) bsT.getSystemService("clipboard");
        }

        @Override // com.baidu.swan.apps.an.ad
        public void setText(CharSequence charSequence) {
            bsV = ClipData.newPlainText("text/plain", charSequence);
            bsU.setPrimaryClip(bsV);
        }

        @Override // com.baidu.swan.apps.an.ad
        public CharSequence getText() {
            try {
                bsV = bsU.getPrimaryClip();
            } catch (Exception e) {
                if (com.baidu.swan.apps.b.DEBUG) {
                    throw e;
                }
            }
            if (bsV != null && bsV.getItemCount() > 0) {
                return bsV.getItemAt(0).getText();
            }
            return "";
        }
    }
}
