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
        final a ffE;
        final a ffF;
        final int ffG;

        private b(a aVar) {
            this.ffE = aVar.ffE;
            this.ffF = aVar.ffF;
            this.ffG = aVar.ffG;
        }

        /* loaded from: classes.dex */
        public static class a {
            private a ffE = null;
            private a ffF = null;
            private int ffG = -1;

            public a b(a aVar) {
                this.ffE = aVar;
                return this;
            }

            public a pp(int i) {
                this.ffG = i;
                return this;
            }

            public b btF() {
                return new b(this);
            }
        }

        public static b a(a aVar) {
            a aVar2 = new a();
            aVar2.b(aVar);
            return aVar2.btF();
        }

        public static b a(a aVar, int i) {
            a aVar2 = new a();
            aVar2.b(aVar);
            aVar2.pp(i);
            return aVar2.btF();
        }
    }

    /* loaded from: classes.dex */
    public static class a {
        View.OnClickListener ffD;
        String mText;

        public a(String str, View.OnClickListener onClickListener) {
            this.mText = str;
            this.ffD = onClickListener;
        }
    }

    /* loaded from: classes.dex */
    public static class c {
        final ImgType ffH;
        final int ffv;
        final int mHeight;
        final int mMarginTop;
        final int mWidth;

        private c(a aVar) {
            this.ffH = aVar.ffH;
            this.mMarginTop = aVar.mMarginTop;
            this.ffv = aVar.ffv;
            this.mHeight = aVar.mHeight;
            this.mWidth = aVar.mWidth;
        }

        /* loaded from: classes.dex */
        public static class a {
            private ImgType ffH = ImgType.NONE;
            private int mMarginTop = -1;
            private int ffv = -1;
            private int mHeight = -1;
            private int mWidth = -1;

            public a b(ImgType imgType) {
                this.ffH = imgType;
                return this;
            }

            public a pq(int i) {
                this.mMarginTop = i;
                return this;
            }

            public a pr(int i) {
                this.ffv = i;
                return this;
            }

            public a ps(int i) {
                this.mHeight = i;
                return this;
            }

            public a pt(int i) {
                this.mWidth = i;
                return this;
            }

            public c btG() {
                return new c(this);
            }
        }

        public static c a(ImgType imgType, int i) {
            a aVar = new a();
            aVar.b(imgType);
            aVar.pq(i);
            return aVar.btG();
        }

        public static c a(ImgType imgType, int i, int i2, int i3, int i4) {
            a aVar = new a();
            aVar.b(imgType);
            aVar.pr(i);
            aVar.pq(i2);
            aVar.ps(i3);
            aVar.pt(i4);
            return aVar.btG();
        }

        public static c a(ImgType imgType) {
            a aVar = new a();
            aVar.b(imgType);
            return aVar.btG();
        }
    }

    /* loaded from: classes.dex */
    public static class d {
        final String ffI;
        final int ffJ;
        final int ffK;
        final String mSubTitle;
        final String mTitle;

        private d(a aVar) {
            this.mTitle = aVar.mTitle;
            this.mSubTitle = aVar.mSubTitle;
            this.ffI = aVar.ffI;
            this.ffJ = aVar.ffL;
            this.ffK = aVar.ffK;
        }

        /* loaded from: classes.dex */
        public static class a {
            private String mTitle = null;
            private String mSubTitle = null;
            private String ffI = null;
            private int ffL = -1;
            private int ffK = 0;

            public a Bl(String str) {
                this.mTitle = str;
                return this;
            }

            public a Bm(String str) {
                this.mSubTitle = str;
                return this;
            }

            public a pv(int i) {
                this.ffL = i;
                return this;
            }

            public d btH() {
                return new d(this);
            }
        }

        public static d aX(int i, int i2) {
            a aVar = new a();
            aVar.Bm(TbadkCoreApplication.getInst().getResources().getString(i));
            aVar.pv(i2);
            return aVar.btH();
        }

        public static d pu(int i) {
            return Bk(TbadkCoreApplication.getInst().getResources().getString(i));
        }

        public static d aY(int i, int i2) {
            return dX(TbadkCoreApplication.getInst().getResources().getString(i), TbadkCoreApplication.getInst().getResources().getString(i2));
        }

        public static d Bk(String str) {
            a aVar = new a();
            aVar.Bm(str);
            return aVar.btH();
        }

        public static d dX(String str, String str2) {
            a aVar = new a();
            aVar.Bm(str);
            aVar.Bl(str2);
            return aVar.btH();
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
