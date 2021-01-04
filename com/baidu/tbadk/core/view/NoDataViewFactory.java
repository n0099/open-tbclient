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
        final a fkp;
        final a fkq;
        final int fkr;

        private b(a aVar) {
            this.fkp = aVar.fkp;
            this.fkq = aVar.fkq;
            this.fkr = aVar.fkr;
        }

        /* loaded from: classes.dex */
        public static class a {
            private a fkp = null;
            private a fkq = null;
            private int fkr = -1;

            public a b(a aVar) {
                this.fkp = aVar;
                return this;
            }

            public a qV(int i) {
                this.fkr = i;
                return this;
            }

            public b bxy() {
                return new b(this);
            }
        }

        public static b a(a aVar) {
            a aVar2 = new a();
            aVar2.b(aVar);
            return aVar2.bxy();
        }

        public static b a(a aVar, int i) {
            a aVar2 = new a();
            aVar2.b(aVar);
            aVar2.qV(i);
            return aVar2.bxy();
        }
    }

    /* loaded from: classes.dex */
    public static class a {
        View.OnClickListener fko;
        String mText;

        public a(String str, View.OnClickListener onClickListener) {
            this.mText = str;
            this.fko = onClickListener;
        }
    }

    /* loaded from: classes.dex */
    public static class c {
        final int fkg;
        final ImgType fks;
        final int mHeight;
        final int mMarginTop;
        final int mWidth;

        private c(a aVar) {
            this.fks = aVar.fks;
            this.mMarginTop = aVar.mMarginTop;
            this.fkg = aVar.fkg;
            this.mHeight = aVar.mHeight;
            this.mWidth = aVar.mWidth;
        }

        /* loaded from: classes.dex */
        public static class a {
            private ImgType fks = ImgType.NONE;
            private int mMarginTop = -1;
            private int fkg = -1;
            private int mHeight = -1;
            private int mWidth = -1;

            public a b(ImgType imgType) {
                this.fks = imgType;
                return this;
            }

            public a qW(int i) {
                this.mMarginTop = i;
                return this;
            }

            public a qX(int i) {
                this.fkg = i;
                return this;
            }

            public a qY(int i) {
                this.mHeight = i;
                return this;
            }

            public a qZ(int i) {
                this.mWidth = i;
                return this;
            }

            public c bxz() {
                return new c(this);
            }
        }

        public static c a(ImgType imgType, int i) {
            a aVar = new a();
            aVar.b(imgType);
            aVar.qW(i);
            return aVar.bxz();
        }

        public static c a(ImgType imgType, int i, int i2, int i3, int i4) {
            a aVar = new a();
            aVar.b(imgType);
            aVar.qX(i);
            aVar.qW(i2);
            aVar.qY(i3);
            aVar.qZ(i4);
            return aVar.bxz();
        }

        public static c a(ImgType imgType) {
            a aVar = new a();
            aVar.b(imgType);
            return aVar.bxz();
        }
    }

    /* loaded from: classes.dex */
    public static class d {
        final String fkt;
        final int fku;
        final int fkv;
        final String mSubTitle;
        final String mTitle;

        private d(a aVar) {
            this.mTitle = aVar.mTitle;
            this.mSubTitle = aVar.mSubTitle;
            this.fkt = aVar.fkt;
            this.fku = aVar.fkw;
            this.fkv = aVar.fkv;
        }

        /* loaded from: classes.dex */
        public static class a {
            private String mTitle = null;
            private String mSubTitle = null;
            private String fkt = null;
            private int fkw = -1;
            private int fkv = 0;

            public a Cx(String str) {
                this.mTitle = str;
                return this;
            }

            public a Cy(String str) {
                this.mSubTitle = str;
                return this;
            }

            public a rb(int i) {
                this.fkw = i;
                return this;
            }

            public d bxA() {
                return new d(this);
            }
        }

        public static d aX(int i, int i2) {
            a aVar = new a();
            aVar.Cy(TbadkCoreApplication.getInst().getResources().getString(i));
            aVar.rb(i2);
            return aVar.bxA();
        }

        public static d ra(int i) {
            return Cw(TbadkCoreApplication.getInst().getResources().getString(i));
        }

        public static d aY(int i, int i2) {
            return dY(TbadkCoreApplication.getInst().getResources().getString(i), TbadkCoreApplication.getInst().getResources().getString(i2));
        }

        public static d Cw(String str) {
            a aVar = new a();
            aVar.Cy(str);
            return aVar.bxA();
        }

        public static d dY(String str, String str2) {
            a aVar = new a();
            aVar.Cy(str);
            aVar.Cx(str2);
            return aVar.bxA();
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
