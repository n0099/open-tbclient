package com.baidu.swan.apps.y;

import android.graphics.Bitmap;
import android.graphics.Rect;
/* loaded from: classes2.dex */
public class c {
    private Bitmap aXQ;
    private Rect mRect;
    private String mToken;
    private String mUrl;

    public String getToken() {
        return this.mToken;
    }

    public String getUrl() {
        return this.mUrl;
    }

    public Bitmap Mu() {
        return this.aXQ;
    }

    public Rect getRect() {
        return this.mRect;
    }

    /* loaded from: classes2.dex */
    public static class a {
        private c aXR = new c();

        public a gg(String str) {
            this.aXR.mUrl = str;
            return this;
        }

        public a j(Bitmap bitmap) {
            this.aXR.aXQ = bitmap;
            return this;
        }

        public a c(Rect rect) {
            this.aXR.mRect = rect;
            return this;
        }

        public a gh(String str) {
            this.aXR.mToken = str;
            return this;
        }

        public c Mv() {
            return this.aXR;
        }
    }
}
