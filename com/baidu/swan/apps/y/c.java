package com.baidu.swan.apps.y;

import android.graphics.Bitmap;
import android.graphics.Rect;
/* loaded from: classes2.dex */
public class c {
    private Bitmap aBK;
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
        return this.aBK;
    }

    public Rect getRect() {
        return this.mRect;
    }

    /* loaded from: classes2.dex */
    public static class a {
        private c aBL = new c();

        public a fj(String str) {
            this.aBL.mUrl = str;
            return this;
        }

        public a h(Bitmap bitmap) {
            this.aBL.aBK = bitmap;
            return this;
        }

        public a e(Rect rect) {
            this.aBL.mRect = rect;
            return this;
        }

        public a fk(String str) {
            this.aBL.mToken = str;
            return this;
        }

        public c EQ() {
            return this.aBL;
        }
    }
}
