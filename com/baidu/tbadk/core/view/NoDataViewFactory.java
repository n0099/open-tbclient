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
        EMOTION,
        SINGALL,
        GIFT,
        WEBVIEW,
        LOCAL,
        ANTI
    }

    /* loaded from: classes.dex */
    public static class b {
        final a aHQ;
        final a aHR;
        final int aHS;

        private b(a aVar) {
            this.aHQ = aVar.aHQ;
            this.aHR = aVar.aHR;
            this.aHS = aVar.aHS;
        }

        /* loaded from: classes.dex */
        public static class a {
            private a aHQ = null;
            private a aHR = null;
            private int aHS = -1;

            public a b(a aVar) {
                this.aHQ = aVar;
                return this;
            }

            public a el(int i) {
                this.aHS = i;
                return this;
            }

            public b EU() {
                return new b(this);
            }
        }

        public static b a(a aVar) {
            a aVar2 = new a();
            aVar2.b(aVar);
            return aVar2.EU();
        }

        public static b a(a aVar, int i) {
            a aVar2 = new a();
            aVar2.b(aVar);
            aVar2.el(i);
            return aVar2.EU();
        }
    }

    /* loaded from: classes.dex */
    public static class a {
        View.OnClickListener aHP;
        String mText;

        public a(String str, View.OnClickListener onClickListener) {
            this.mText = str;
            this.aHP = onClickListener;
        }
    }

    /* loaded from: classes.dex */
    public static class c {
        final int aHN;
        final ImgType aHT;
        final int mHeight;
        final int mMarginTop;
        final int mWidth;

        private c(a aVar) {
            this.aHT = aVar.aHT;
            this.mMarginTop = aVar.mMarginTop;
            this.aHN = aVar.aHN;
            this.mHeight = aVar.mHeight;
            this.mWidth = aVar.mWidth;
        }

        /* loaded from: classes.dex */
        public static class a {
            private ImgType aHT = ImgType.NONE;
            private int mMarginTop = -1;
            private int aHN = -1;
            private int mHeight = -1;
            private int mWidth = -1;

            public a b(ImgType imgType) {
                this.aHT = imgType;
                return this;
            }

            public a em(int i) {
                this.mMarginTop = i;
                return this;
            }

            public a en(int i) {
                this.aHN = i;
                return this;
            }

            public a eo(int i) {
                this.mHeight = i;
                return this;
            }

            public a ep(int i) {
                this.mWidth = i;
                return this;
            }

            public c EV() {
                return new c(this);
            }
        }

        public static c a(ImgType imgType, int i) {
            a aVar = new a();
            aVar.b(imgType);
            aVar.em(i);
            return aVar.EV();
        }

        public static c a(ImgType imgType, int i, int i2, int i3, int i4) {
            a aVar = new a();
            aVar.b(imgType);
            aVar.en(i);
            aVar.em(i2);
            aVar.eo(i3);
            aVar.ep(i4);
            return aVar.EV();
        }

        public static c a(ImgType imgType) {
            a aVar = new a();
            aVar.b(imgType);
            return aVar.EV();
        }
    }

    /* loaded from: classes.dex */
    public static class d {
        final String aHU;
        final int aHV;
        final int aHW;
        final String aqR;
        final String mTitle;

        private d(a aVar) {
            this.mTitle = aVar.mTitle;
            this.aqR = aVar.aqR;
            this.aHU = aVar.aHU;
            this.aHV = aVar.aHX;
            this.aHW = aVar.aHW;
        }

        /* loaded from: classes.dex */
        public static class a {
            private String mTitle = null;
            private String aqR = null;
            private String aHU = null;
            private int aHX = -1;
            private int aHW = 0;

            public a gp(String str) {
                this.mTitle = str;
                return this;
            }

            public a gq(String str) {
                this.aqR = str;
                return this;
            }

            public a er(int i) {
                this.aHX = i;
                return this;
            }

            public d EW() {
                return new d(this);
            }
        }

        public static d G(int i, int i2) {
            a aVar = new a();
            aVar.gq(TbadkCoreApplication.getInst().getResources().getString(i));
            aVar.er(i2);
            return aVar.EW();
        }

        public static d eq(int i) {
            return go(TbadkCoreApplication.getInst().getResources().getString(i));
        }

        public static d H(int i, int i2) {
            return aD(TbadkCoreApplication.getInst().getResources().getString(i), TbadkCoreApplication.getInst().getResources().getString(i2));
        }

        public static d go(String str) {
            a aVar = new a();
            aVar.gq(str);
            return aVar.EW();
        }

        public static d aD(String str, String str2) {
            a aVar = new a();
            aVar.gq(str);
            aVar.gp(str2);
            return aVar.EW();
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
