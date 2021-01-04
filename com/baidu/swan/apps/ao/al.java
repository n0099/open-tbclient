package com.baidu.swan.apps.ao;

import android.annotation.SuppressLint;
import android.annotation.TargetApi;
import android.content.ClipData;
import android.content.Context;
import android.text.ClipboardManager;
/* loaded from: classes9.dex */
public abstract class al {
    protected static Context dRT;

    public abstract CharSequence getText();

    public abstract void setText(CharSequence charSequence);

    public static al dT(Context context) {
        dRT = context.getApplicationContext();
        return c.hasHoneycomb() ? new a() : new b();
    }

    /* loaded from: classes9.dex */
    private static class b extends al {
        private static ClipboardManager dRW = null;

        public b() {
            dRW = (ClipboardManager) dRT.getSystemService("clipboard");
        }

        @Override // com.baidu.swan.apps.ao.al
        public void setText(CharSequence charSequence) {
            dRW.setText(charSequence);
        }

        @Override // com.baidu.swan.apps.ao.al
        public CharSequence getText() {
            return dRW.getText();
        }
    }

    @TargetApi(11)
    /* loaded from: classes9.dex */
    private static class a extends al {
        private static android.content.ClipboardManager dRU = null;
        private static ClipData dRV = null;

        @SuppressLint({"ServiceCast"})
        public a() {
            dRU = (android.content.ClipboardManager) dRT.getSystemService("clipboard");
        }

        @Override // com.baidu.swan.apps.ao.al
        public void setText(CharSequence charSequence) {
            dRV = ClipData.newPlainText("text/plain", charSequence);
            try {
                dRU.setPrimaryClip(dRV);
            } catch (RuntimeException e) {
                if (com.baidu.swan.apps.b.DEBUG) {
                    e.printStackTrace();
                }
            }
        }

        @Override // com.baidu.swan.apps.ao.al
        public CharSequence getText() {
            try {
                dRV = dRU.getPrimaryClip();
            } catch (Exception e) {
                if (com.baidu.swan.apps.b.DEBUG) {
                    throw e;
                }
            }
            if (dRV != null && dRV.getItemCount() > 0) {
                return dRV.getItemAt(0).getText();
            }
            return "";
        }
    }
}
