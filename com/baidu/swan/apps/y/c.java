package com.baidu.swan.apps.y;

import android.graphics.Bitmap;
import android.graphics.Rect;
/* loaded from: classes2.dex */
public class c {
    private Bitmap aEd;
    private Rect mRect;
    private String mToken;
    private String mUrl;

    public String getToken() {
        return this.mToken;
    }

    public String getUrl() {
        return this.mUrl;
    }

    public Bitmap Hw() {
        return this.aEd;
    }

    public Rect getRect() {
        return this.mRect;
    }

    /* loaded from: classes2.dex */
    public static class a {
        private c aEe = new c();

        public a fA(String str) {
            this.aEe.mUrl = str;
            return this;
        }

        public a h(Bitmap bitmap) {
            this.aEe.aEd = bitmap;
            return this;
        }

        public a e(Rect rect) {
            this.aEe.mRect = rect;
            return this;
        }

        public a fB(String str) {
            this.aEe.mToken = str;
            return this;
        }

        public c Hx() {
            return this.aEe;
        }
    }
}
