package com.baidu.swan.apps.y;

import android.graphics.Bitmap;
import android.graphics.Rect;
/* loaded from: classes2.dex */
public class c {
    private Bitmap aBO;
    private Rect mRect;
    private String mToken;
    private String mUrl;

    public String getToken() {
        return this.mToken;
    }

    public String getUrl() {
        return this.mUrl;
    }

    public Bitmap EN() {
        return this.aBO;
    }

    public Rect getRect() {
        return this.mRect;
    }

    /* loaded from: classes2.dex */
    public static class a {
        private c aBP = new c();

        public a fk(String str) {
            this.aBP.mUrl = str;
            return this;
        }

        public a h(Bitmap bitmap) {
            this.aBP.aBO = bitmap;
            return this;
        }

        public a e(Rect rect) {
            this.aBP.mRect = rect;
            return this;
        }

        public a fl(String str) {
            this.aBP.mToken = str;
            return this;
        }

        public c EO() {
            return this.aBP;
        }
    }
}
