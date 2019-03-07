package com.baidu.swan.apps.an;

import android.annotation.SuppressLint;
import android.annotation.TargetApi;
import android.content.ClipData;
import android.content.Context;
import android.text.ClipboardManager;
/* loaded from: classes2.dex */
public abstract class ab {
    protected static Context aWu;

    public abstract CharSequence getText();

    public abstract void setText(CharSequence charSequence);

    public static ab ct(Context context) {
        aWu = context.getApplicationContext();
        return com.baidu.swan.apps.an.a.hasHoneycomb() ? new a() : new b();
    }

    /* loaded from: classes2.dex */
    private static class b extends ab {
        private static ClipboardManager aWx = null;

        public b() {
            aWx = (ClipboardManager) aWu.getSystemService("clipboard");
        }

        @Override // com.baidu.swan.apps.an.ab
        public void setText(CharSequence charSequence) {
            aWx.setText(charSequence);
        }

        @Override // com.baidu.swan.apps.an.ab
        public CharSequence getText() {
            return aWx.getText();
        }
    }

    @TargetApi(11)
    /* loaded from: classes2.dex */
    private static class a extends ab {
        private static android.content.ClipboardManager aWv = null;
        private static ClipData aWw = null;

        @SuppressLint({"ServiceCast"})
        public a() {
            aWv = (android.content.ClipboardManager) aWu.getSystemService("clipboard");
        }

        @Override // com.baidu.swan.apps.an.ab
        public void setText(CharSequence charSequence) {
            aWw = ClipData.newPlainText("text/plain", charSequence);
            aWv.setPrimaryClip(aWw);
        }

        @Override // com.baidu.swan.apps.an.ab
        public CharSequence getText() {
            try {
                aWw = aWv.getPrimaryClip();
            } catch (Exception e) {
                if (com.baidu.swan.apps.c.DEBUG) {
                    throw e;
                }
            }
            if (aWw != null && aWw.getItemCount() > 0) {
                return aWw.getItemAt(0).getText();
            }
            return "";
        }
    }
}
