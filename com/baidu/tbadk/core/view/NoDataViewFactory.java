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
        final a aEp;
        final a aEq;
        final int aEr;

        private b(a aVar) {
            this.aEp = aVar.aEp;
            this.aEq = aVar.aEq;
            this.aEr = aVar.aEr;
        }

        /* loaded from: classes.dex */
        public static class a {
            private a aEp = null;
            private a aEq = null;
            private int aEr = -1;

            public a b(a aVar) {
                this.aEp = aVar;
                return this;
            }

            public a dX(int i) {
                this.aEr = i;
                return this;
            }

            public b DQ() {
                return new b(this);
            }
        }

        public static b a(a aVar) {
            a aVar2 = new a();
            aVar2.b(aVar);
            return aVar2.DQ();
        }

        public static b a(a aVar, int i) {
            a aVar2 = new a();
            aVar2.b(aVar);
            aVar2.dX(i);
            return aVar2.DQ();
        }
    }

    /* loaded from: classes.dex */
    public static class a {
        View.OnClickListener aEo;
        String mText;

        public a(String str, View.OnClickListener onClickListener) {
            this.mText = str;
            this.aEo = onClickListener;
        }
    }

    /* loaded from: classes.dex */
    public static class c {
        final int aEm;
        final ImgType aEs;
        final int mHeight;
        final int mMarginTop;
        final int mWidth;

        private c(a aVar) {
            this.aEs = aVar.aEs;
            this.mMarginTop = aVar.mMarginTop;
            this.aEm = aVar.aEm;
            this.mHeight = aVar.mHeight;
            this.mWidth = aVar.mWidth;
        }

        /* loaded from: classes.dex */
        public static class a {
            private ImgType aEs = ImgType.NONE;
            private int mMarginTop = -1;
            private int aEm = -1;
            private int mHeight = -1;
            private int mWidth = -1;

            public a b(ImgType imgType) {
                this.aEs = imgType;
                return this;
            }

            public a dY(int i) {
                this.mMarginTop = i;
                return this;
            }

            public a dZ(int i) {
                this.aEm = i;
                return this;
            }

            public a ea(int i) {
                this.mHeight = i;
                return this;
            }

            public a eb(int i) {
                this.mWidth = i;
                return this;
            }

            public c DR() {
                return new c(this);
            }
        }

        public static c a(ImgType imgType, int i) {
            a aVar = new a();
            aVar.b(imgType);
            aVar.dY(i);
            return aVar.DR();
        }

        public static c a(ImgType imgType, int i, int i2, int i3, int i4) {
            a aVar = new a();
            aVar.b(imgType);
            aVar.dZ(i);
            aVar.dY(i2);
            aVar.ea(i3);
            aVar.eb(i4);
            return aVar.DR();
        }

        public static c a(ImgType imgType) {
            a aVar = new a();
            aVar.b(imgType);
            return aVar.DR();
        }
    }

    /* loaded from: classes.dex */
    public static class d {
        final String aEt;
        final int aEu;
        final int aEv;
        final String anq;
        final String mTitle;

        private d(a aVar) {
            this.mTitle = aVar.mTitle;
            this.anq = aVar.anq;
            this.aEt = aVar.aEt;
            this.aEu = aVar.aEw;
            this.aEv = aVar.aEv;
        }

        /* loaded from: classes.dex */
        public static class a {
            private String mTitle = null;
            private String anq = null;
            private String aEt = null;
            private int aEw = -1;
            private int aEv = 0;

            public a fW(String str) {
                this.mTitle = str;
                return this;
            }

            public a fX(String str) {
                this.anq = str;
                return this;
            }

            public a ed(int i) {
                this.aEw = i;
                return this;
            }

            public d DS() {
                return new d(this);
            }
        }

        public static d F(int i, int i2) {
            a aVar = new a();
            aVar.fX(TbadkCoreApplication.getInst().getResources().getString(i));
            aVar.ed(i2);
            return aVar.DS();
        }

        public static d ec(int i) {
            return fV(TbadkCoreApplication.getInst().getResources().getString(i));
        }

        public static d G(int i, int i2) {
            return aA(TbadkCoreApplication.getInst().getResources().getString(i), TbadkCoreApplication.getInst().getResources().getString(i2));
        }

        public static d fV(String str) {
            a aVar = new a();
            aVar.fX(str);
            return aVar.DS();
        }

        public static d aA(String str, String str2) {
            a aVar = new a();
            aVar.fX(str);
            aVar.fW(str2);
            return aVar.DS();
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
