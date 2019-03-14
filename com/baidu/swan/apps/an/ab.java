package com.baidu.swan.apps.an;

import android.annotation.SuppressLint;
import android.annotation.TargetApi;
import android.content.ClipData;
import android.content.Context;
import android.text.ClipboardManager;
/* loaded from: classes2.dex */
public abstract class ab {
    protected static Context aWv;

    public abstract CharSequence getText();

    public abstract void setText(CharSequence charSequence);

    public static ab ct(Context context) {
        aWv = context.getApplicationContext();
        return com.baidu.swan.apps.an.a.hasHoneycomb() ? new a() : new b();
    }

    /* loaded from: classes2.dex */
    private static class b extends ab {
        private static ClipboardManager aWy = null;

        public b() {
            aWy = (ClipboardManager) aWv.getSystemService("clipboard");
        }

        @Override // com.baidu.swan.apps.an.ab
        public void setText(CharSequence charSequence) {
            aWy.setText(charSequence);
        }

        @Override // com.baidu.swan.apps.an.ab
        public CharSequence getText() {
            return aWy.getText();
        }
    }

    @TargetApi(11)
    /* loaded from: classes2.dex */
    private static class a extends ab {
        private static android.content.ClipboardManager aWw = null;
        private static ClipData aWx = null;

        @SuppressLint({"ServiceCast"})
        public a() {
            aWw = (android.content.ClipboardManager) aWv.getSystemService("clipboard");
        }

        @Override // com.baidu.swan.apps.an.ab
        public void setText(CharSequence charSequence) {
            aWx = ClipData.newPlainText("text/plain", charSequence);
            aWw.setPrimaryClip(aWx);
        }

        @Override // com.baidu.swan.apps.an.ab
        public CharSequence getText() {
            try {
                aWx = aWw.getPrimaryClip();
            } catch (Exception e) {
                if (com.baidu.swan.apps.b.DEBUG) {
                    throw e;
                }
            }
            if (aWx != null && aWx.getItemCount() > 0) {
                return aWx.getItemAt(0).getText();
            }
            return "";
        }
    }
}
