package com.baidu.swan.apps.an;

import android.annotation.SuppressLint;
import android.annotation.TargetApi;
import android.content.ClipData;
import android.content.Context;
import android.text.ClipboardManager;
/* loaded from: classes2.dex */
public abstract class ad {
    protected static Context baL;

    public abstract CharSequence getText();

    public abstract void setText(CharSequence charSequence);

    public static ad bW(Context context) {
        baL = context.getApplicationContext();
        return com.baidu.swan.apps.an.a.hasHoneycomb() ? new a() : new b();
    }

    /* loaded from: classes2.dex */
    private static class b extends ad {
        private static ClipboardManager baO = null;

        public b() {
            baO = (ClipboardManager) baL.getSystemService("clipboard");
        }

        @Override // com.baidu.swan.apps.an.ad
        public void setText(CharSequence charSequence) {
            baO.setText(charSequence);
        }

        @Override // com.baidu.swan.apps.an.ad
        public CharSequence getText() {
            return baO.getText();
        }
    }

    @TargetApi(11)
    /* loaded from: classes2.dex */
    private static class a extends ad {
        private static android.content.ClipboardManager baM = null;
        private static ClipData baN = null;

        @SuppressLint({"ServiceCast"})
        public a() {
            baM = (android.content.ClipboardManager) baL.getSystemService("clipboard");
        }

        @Override // com.baidu.swan.apps.an.ad
        public void setText(CharSequence charSequence) {
            baN = ClipData.newPlainText("text/plain", charSequence);
            baM.setPrimaryClip(baN);
        }

        @Override // com.baidu.swan.apps.an.ad
        public CharSequence getText() {
            try {
                baN = baM.getPrimaryClip();
            } catch (Exception e) {
                if (com.baidu.swan.apps.b.DEBUG) {
                    throw e;
                }
            }
            if (baN != null && baN.getItemCount() > 0) {
                return baN.getItemAt(0).getText();
            }
            return "";
        }
    }
}
