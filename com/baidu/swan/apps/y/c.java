package com.baidu.swan.apps.y;

import android.graphics.Bitmap;
import android.graphics.Rect;
/* loaded from: classes2.dex */
public class c {
    private Bitmap aDv;
    private Rect mRect;
    private String mToken;
    private String mUrl;

    public String getToken() {
        return this.mToken;
    }

    public String getUrl() {
        return this.mUrl;
    }

    public Bitmap GL() {
        return this.aDv;
    }

    public Rect getRect() {
        return this.mRect;
    }

    /* loaded from: classes2.dex */
    public static class a {
        private c aDw = new c();

        public a fv(String str) {
            this.aDw.mUrl = str;
            return this;
        }

        public a h(Bitmap bitmap) {
            this.aDw.aDv = bitmap;
            return this;
        }

        public a e(Rect rect) {
            this.aDw.mRect = rect;
            return this;
        }

        public a fw(String str) {
            this.aDw.mToken = str;
            return this;
        }

        public c GM() {
            return this.aDw;
        }
    }
}
