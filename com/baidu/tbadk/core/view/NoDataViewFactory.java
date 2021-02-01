package com.baidu.tbadk.core.view;

import android.content.Context;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import com.baidu.tbadk.core.TbadkCoreApplication;
/* loaded from: classes.dex */
public class NoDataViewFactory {

    /* loaded from: classes.dex */
    public enum ImgType {
        NONE,
        CREATE,
        NODATA,
        FINDBAR,
        COLLECTION,
        EMOTION,
        SINGALL,
        GIFT,
        WEBVIEW,
        LOCAL,
        ANTI,
        NETERROR
    }

    /* loaded from: classes.dex */
    public static class b {
        final a fhU;
        final a fhV;
        final int fhW;

        private b(a aVar) {
            this.fhU = aVar.fhU;
            this.fhV = aVar.fhV;
            this.fhW = aVar.fhW;
        }

        /* loaded from: classes.dex */
        public static class a {
            private a fhU = null;
            private a fhV = null;
            private int fhW = -1;

            public a b(a aVar) {
                this.fhU = aVar;
                return this;
            }

            public a pu(int i) {
                this.fhW = i;
                return this;
            }

            public b btZ() {
                return new b(this);
            }
        }

        public static b a(a aVar) {
            a aVar2 = new a();
            aVar2.b(aVar);
            return aVar2.btZ();
        }

        public static b a(a aVar, int i) {
            a aVar2 = new a();
            aVar2.b(aVar);
            aVar2.pu(i);
            return aVar2.btZ();
        }
    }

    /* loaded from: classes.dex */
    public static class a {
        View.OnClickListener fhT;
        String mText;

        public a(String str, View.OnClickListener onClickListener) {
            this.mText = str;
            this.fhT = onClickListener;
        }
    }

    /* loaded from: classes.dex */
    public static class c {
        final int fhL;
        final ImgType fhX;
        final int mHeight;
        final int mMarginTop;
        final int mWidth;

        private c(a aVar) {
            this.fhX = aVar.fhX;
            this.mMarginTop = aVar.mMarginTop;
            this.fhL = aVar.fhL;
            this.mHeight = aVar.mHeight;
            this.mWidth = aVar.mWidth;
        }

        /* loaded from: classes.dex */
        public static class a {
            private ImgType fhX = ImgType.NONE;
            private int mMarginTop = -1;
            private int fhL = -1;
            private int mHeight = -1;
            private int mWidth = -1;

            public a b(ImgType imgType) {
                this.fhX = imgType;
                return this;
            }

            public a pv(int i) {
                this.mMarginTop = i;
                return this;
            }

            public a pw(int i) {
                this.fhL = i;
                return this;
            }

            public a px(int i) {
                this.mHeight = i;
                return this;
            }

            public a py(int i) {
                this.mWidth = i;
                return this;
            }

            public c bua() {
                return new c(this);
            }
        }

        public static c a(ImgType imgType, int i) {
            a aVar = new a();
            aVar.b(imgType);
            aVar.pv(i);
            return aVar.bua();
        }

        public static c a(ImgType imgType, int i, int i2, int i3, int i4) {
            a aVar = new a();
            aVar.b(imgType);
            aVar.pw(i);
            aVar.pv(i2);
            aVar.px(i3);
            aVar.py(i4);
            return aVar.bua();
        }

        public static c a(ImgType imgType) {
            a aVar = new a();
            aVar.b(imgType);
            return aVar.bua();
        }
    }

    /* loaded from: classes.dex */
    public static class d {
        final String fhY;
        final int fhZ;
        final int fia;
        final String mSubTitle;
        final String mTitle;

        private d(a aVar) {
            this.mTitle = aVar.mTitle;
            this.mSubTitle = aVar.mSubTitle;
            this.fhY = aVar.fhY;
            this.fhZ = aVar.fib;
            this.fia = aVar.fia;
        }

        /* loaded from: classes.dex */
        public static class a {
            private String mTitle = null;
            private String mSubTitle = null;
            private String fhY = null;
            private int fib = -1;
            private int fia = 0;

            public a BC(String str) {
                this.mTitle = str;
                return this;
            }

            public a BD(String str) {
                this.mSubTitle = str;
                return this;
            }

            public a pA(int i) {
                this.fib = i;
                return this;
            }

            public d bub() {
                return new d(this);
            }
        }

        public static d aU(int i, int i2) {
            a aVar = new a();
            aVar.BD(TbadkCoreApplication.getInst().getResources().getString(i));
            aVar.pA(i2);
            return aVar.bub();
        }

        public static d pz(int i) {
            return BB(TbadkCoreApplication.getInst().getResources().getString(i));
        }

        public static d aV(int i, int i2) {
            return dS(TbadkCoreApplication.getInst().getResources().getString(i), TbadkCoreApplication.getInst().getResources().getString(i2));
        }

        public static d BB(String str) {
            a aVar = new a();
            aVar.BD(str);
            return aVar.bub();
        }

        public static d dS(String str, String str2) {
            a aVar = new a();
            aVar.BD(str);
            aVar.BC(str2);
            return aVar.bub();
        }
    }

    public static NoDataView a(Context context, View view, c cVar, d dVar, b bVar) {
        return a(context, view, cVar, dVar, bVar, false);
    }

    public static NoDataView a(Context context, View view, c cVar, d dVar, b bVar, boolean z) {
        NoDataView noDataView = new NoDataView(context);
        noDataView.a(bVar, cVar, dVar);
        if (view != null) {
            if (view instanceof RelativeLayout) {
                RelativeLayout relativeLayout = (RelativeLayout) view;
                if (z) {
                    relativeLayout.addView(noDataView, 0);
                } else {
                    relativeLayout.addView(noDataView);
                }
                RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) noDataView.getLayoutParams();
                layoutParams.width = -1;
                layoutParams.height = -1;
                layoutParams.addRule(14);
                noDataView.setLayoutParams(layoutParams);
            } else if (view instanceof LinearLayout) {
                ((LinearLayout) view).addView(noDataView);
                LinearLayout.LayoutParams layoutParams2 = (LinearLayout.LayoutParams) noDataView.getLayoutParams();
                layoutParams2.gravity = 1;
                noDataView.setLayoutParams(layoutParams2);
            } else if (view instanceof FrameLayout) {
                ((FrameLayout) view).addView(noDataView, 0);
            }
        }
        noDataView.setVisibility(8);
        return noDataView;
    }
}
