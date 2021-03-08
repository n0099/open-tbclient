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
        final a fjw;
        final a fjx;
        final int fjy;

        private b(a aVar) {
            this.fjw = aVar.fjw;
            this.fjx = aVar.fjx;
            this.fjy = aVar.fjy;
        }

        /* loaded from: classes.dex */
        public static class a {
            private a fjw = null;
            private a fjx = null;
            private int fjy = -1;

            public a b(a aVar) {
                this.fjw = aVar;
                return this;
            }

            public a pv(int i) {
                this.fjy = i;
                return this;
            }

            public b buc() {
                return new b(this);
            }
        }

        public static b a(a aVar) {
            a aVar2 = new a();
            aVar2.b(aVar);
            return aVar2.buc();
        }

        public static b a(a aVar, int i) {
            a aVar2 = new a();
            aVar2.b(aVar);
            aVar2.pv(i);
            return aVar2.buc();
        }
    }

    /* loaded from: classes.dex */
    public static class a {
        View.OnClickListener fjv;
        String mText;

        public a(String str, View.OnClickListener onClickListener) {
            this.mText = str;
            this.fjv = onClickListener;
        }
    }

    /* loaded from: classes.dex */
    public static class c {
        final int fjn;
        final ImgType fjz;
        final int mHeight;
        final int mMarginTop;
        final int mWidth;

        private c(a aVar) {
            this.fjz = aVar.fjz;
            this.mMarginTop = aVar.mMarginTop;
            this.fjn = aVar.fjn;
            this.mHeight = aVar.mHeight;
            this.mWidth = aVar.mWidth;
        }

        /* loaded from: classes.dex */
        public static class a {
            private ImgType fjz = ImgType.NONE;
            private int mMarginTop = -1;
            private int fjn = -1;
            private int mHeight = -1;
            private int mWidth = -1;

            public a b(ImgType imgType) {
                this.fjz = imgType;
                return this;
            }

            public a pw(int i) {
                this.mMarginTop = i;
                return this;
            }

            public a px(int i) {
                this.fjn = i;
                return this;
            }

            public a py(int i) {
                this.mHeight = i;
                return this;
            }

            public a pz(int i) {
                this.mWidth = i;
                return this;
            }

            public c bud() {
                return new c(this);
            }
        }

        public static c a(ImgType imgType, int i) {
            a aVar = new a();
            aVar.b(imgType);
            aVar.pw(i);
            return aVar.bud();
        }

        public static c a(ImgType imgType, int i, int i2, int i3, int i4) {
            a aVar = new a();
            aVar.b(imgType);
            aVar.px(i);
            aVar.pw(i2);
            aVar.py(i3);
            aVar.pz(i4);
            return aVar.bud();
        }

        public static c a(ImgType imgType) {
            a aVar = new a();
            aVar.b(imgType);
            return aVar.bud();
        }
    }

    /* loaded from: classes.dex */
    public static class d {
        final String fjA;
        final int fjB;
        final int fjC;
        final String mSubTitle;
        final String mTitle;

        private d(a aVar) {
            this.mTitle = aVar.mTitle;
            this.mSubTitle = aVar.mSubTitle;
            this.fjA = aVar.fjA;
            this.fjB = aVar.fjD;
            this.fjC = aVar.fjC;
        }

        /* loaded from: classes.dex */
        public static class a {
            private String mTitle = null;
            private String mSubTitle = null;
            private String fjA = null;
            private int fjD = -1;
            private int fjC = 0;

            public a BJ(String str) {
                this.mTitle = str;
                return this;
            }

            public a BK(String str) {
                this.mSubTitle = str;
                return this;
            }

            public a pB(int i) {
                this.fjD = i;
                return this;
            }

            public d bue() {
                return new d(this);
            }
        }

        public static d aU(int i, int i2) {
            a aVar = new a();
            aVar.BK(TbadkCoreApplication.getInst().getResources().getString(i));
            aVar.pB(i2);
            return aVar.bue();
        }

        public static d pA(int i) {
            return BI(TbadkCoreApplication.getInst().getResources().getString(i));
        }

        public static d aV(int i, int i2) {
            return dS(TbadkCoreApplication.getInst().getResources().getString(i), TbadkCoreApplication.getInst().getResources().getString(i2));
        }

        public static d BI(String str) {
            a aVar = new a();
            aVar.BK(str);
            return aVar.bue();
        }

        public static d dS(String str, String str2) {
            a aVar = new a();
            aVar.BK(str);
            aVar.BJ(str2);
            return aVar.bue();
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
