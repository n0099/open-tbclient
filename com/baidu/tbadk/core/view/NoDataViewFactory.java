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
        ANTI,
        NETERROR
    }

    /* loaded from: classes.dex */
    public static class b {
        final a bQK;
        final a bQL;
        final int bQM;

        private b(a aVar) {
            this.bQK = aVar.bQK;
            this.bQL = aVar.bQL;
            this.bQM = aVar.bQM;
        }

        /* loaded from: classes.dex */
        public static class a {
            private a bQK = null;
            private a bQL = null;
            private int bQM = -1;

            public a b(a aVar) {
                this.bQK = aVar;
                return this;
            }

            public a hP(int i) {
                this.bQM = i;
                return this;
            }

            public b aeu() {
                return new b(this);
            }
        }

        public static b a(a aVar) {
            a aVar2 = new a();
            aVar2.b(aVar);
            return aVar2.aeu();
        }

        public static b a(a aVar, int i) {
            a aVar2 = new a();
            aVar2.b(aVar);
            aVar2.hP(i);
            return aVar2.aeu();
        }
    }

    /* loaded from: classes.dex */
    public static class a {
        String alI;
        View.OnClickListener bQJ;

        public a(String str, View.OnClickListener onClickListener) {
            this.alI = str;
            this.bQJ = onClickListener;
        }
    }

    /* loaded from: classes.dex */
    public static class c {
        final int aMA;
        final int bQH;
        final ImgType bQN;
        final int mHeight;
        final int mWidth;

        private c(a aVar) {
            this.bQN = aVar.bQN;
            this.aMA = aVar.aMA;
            this.bQH = aVar.bQH;
            this.mHeight = aVar.mHeight;
            this.mWidth = aVar.mWidth;
        }

        /* loaded from: classes.dex */
        public static class a {
            private ImgType bQN = ImgType.NONE;
            private int aMA = -1;
            private int bQH = -1;
            private int mHeight = -1;
            private int mWidth = -1;

            public a b(ImgType imgType) {
                this.bQN = imgType;
                return this;
            }

            public a hQ(int i) {
                this.aMA = i;
                return this;
            }

            public a hR(int i) {
                this.bQH = i;
                return this;
            }

            public a hS(int i) {
                this.mHeight = i;
                return this;
            }

            public a hT(int i) {
                this.mWidth = i;
                return this;
            }

            public c aev() {
                return new c(this);
            }
        }

        public static c a(ImgType imgType, int i) {
            a aVar = new a();
            aVar.b(imgType);
            aVar.hQ(i);
            return aVar.aev();
        }

        public static c a(ImgType imgType, int i, int i2, int i3, int i4) {
            a aVar = new a();
            aVar.b(imgType);
            aVar.hR(i);
            aVar.hQ(i2);
            aVar.hS(i3);
            aVar.hT(i4);
            return aVar.aev();
        }

        public static c a(ImgType imgType) {
            a aVar = new a();
            aVar.b(imgType);
            return aVar.aev();
        }
    }

    /* loaded from: classes.dex */
    public static class d {
        final String bQO;
        final int bQP;
        final int bQQ;
        final String byi;
        final String mTitle;

        private d(a aVar) {
            this.mTitle = aVar.mTitle;
            this.byi = aVar.byi;
            this.bQO = aVar.bQO;
            this.bQP = aVar.bQR;
            this.bQQ = aVar.bQQ;
        }

        /* loaded from: classes.dex */
        public static class a {
            private String mTitle = null;
            private String byi = null;
            private String bQO = null;
            private int bQR = -1;
            private int bQQ = 0;

            public a np(String str) {
                this.mTitle = str;
                return this;
            }

            public a nq(String str) {
                this.byi = str;
                return this;
            }

            public a hV(int i) {
                this.bQR = i;
                return this;
            }

            public d aew() {
                return new d(this);
            }
        }

        public static d ac(int i, int i2) {
            a aVar = new a();
            aVar.nq(TbadkCoreApplication.getInst().getResources().getString(i));
            aVar.hV(i2);
            return aVar.aew();
        }

        public static d hU(int i) {
            return no(TbadkCoreApplication.getInst().getResources().getString(i));
        }

        public static d ad(int i, int i2) {
            return bM(TbadkCoreApplication.getInst().getResources().getString(i), TbadkCoreApplication.getInst().getResources().getString(i2));
        }

        public static d no(String str) {
            a aVar = new a();
            aVar.nq(str);
            return aVar.aew();
        }

        public static d bM(String str, String str2) {
            a aVar = new a();
            aVar.nq(str);
            aVar.np(str2);
            return aVar.aew();
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
