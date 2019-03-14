package com.baidu.swan.apps.y;

import android.graphics.Bitmap;
import android.graphics.Rect;
/* loaded from: classes2.dex */
public class c {
    private Bitmap aBL;
    private Rect mRect;
    private String mToken;
    private String mUrl;

    public String getToken() {
        return this.mToken;
    }

    public String getUrl() {
        return this.mUrl;
    }

    public Bitmap EP() {
        return this.aBL;
    }

    public Rect getRect() {
        return this.mRect;
    }

    /* loaded from: classes2.dex */
    public static class a {
        private c aBM = new c();

        public a fj(String str) {
            this.aBM.mUrl = str;
            return this;
        }

        public a h(Bitmap bitmap) {
            this.aBM.aBL = bitmap;
            return this;
        }

        public a e(Rect rect) {
            this.aBM.mRect = rect;
            return this;
        }

        public a fk(String str) {
            this.aBM.mToken = str;
            return this;
        }

        public c EQ() {
            return this.aBM;
        }
    }
}
