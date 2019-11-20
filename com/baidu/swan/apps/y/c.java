package com.baidu.swan.apps.y;

import android.graphics.Bitmap;
import android.graphics.Rect;
/* loaded from: classes2.dex */
public class c {
    private Bitmap aXy;
    private Rect mRect;
    private String mToken;
    private String mUrl;

    public String getToken() {
        return this.mToken;
    }

    public String getUrl() {
        return this.mUrl;
    }

    public Bitmap Mv() {
        return this.aXy;
    }

    public Rect getRect() {
        return this.mRect;
    }

    /* loaded from: classes2.dex */
    public static class a {
        private c aXz = new c();

        public a gg(String str) {
            this.aXz.mUrl = str;
            return this;
        }

        public a j(Bitmap bitmap) {
            this.aXz.aXy = bitmap;
            return this;
        }

        public a c(Rect rect) {
            this.aXz.mRect = rect;
            return this;
        }

        public a gh(String str) {
            this.aXz.mToken = str;
            return this;
        }

        public c Mw() {
            return this.aXz;
        }
    }
}
