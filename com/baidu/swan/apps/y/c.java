package com.baidu.swan.apps.y;

import android.graphics.Bitmap;
import android.graphics.Rect;
/* loaded from: classes2.dex */
public class c {
    private Bitmap aEB;
    private Rect mRect;
    private String mToken;
    private String mUrl;

    public String getToken() {
        return this.mToken;
    }

    public String getUrl() {
        return this.mUrl;
    }

    public Bitmap HA() {
        return this.aEB;
    }

    public Rect getRect() {
        return this.mRect;
    }

    /* loaded from: classes2.dex */
    public static class a {
        private c aEC = new c();

        public a fC(String str) {
            this.aEC.mUrl = str;
            return this;
        }

        public a h(Bitmap bitmap) {
            this.aEC.aEB = bitmap;
            return this;
        }

        public a e(Rect rect) {
            this.aEC.mRect = rect;
            return this;
        }

        public a fD(String str) {
            this.aEC.mToken = str;
            return this;
        }

        public c HB() {
            return this.aEC;
        }
    }
}
