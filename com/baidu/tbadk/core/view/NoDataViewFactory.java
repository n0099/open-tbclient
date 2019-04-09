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
        final a bQO;
        final a bQP;
        final int bQQ;

        private b(a aVar) {
            this.bQO = aVar.bQO;
            this.bQP = aVar.bQP;
            this.bQQ = aVar.bQQ;
        }

        /* loaded from: classes.dex */
        public static class a {
            private a bQO = null;
            private a bQP = null;
            private int bQQ = -1;

            public a b(a aVar) {
                this.bQO = aVar;
                return this;
            }

            public a hO(int i) {
                this.bQQ = i;
                return this;
            }

            public b aer() {
                return new b(this);
            }
        }

        public static b a(a aVar) {
            a aVar2 = new a();
            aVar2.b(aVar);
            return aVar2.aer();
        }

        public static b a(a aVar, int i) {
            a aVar2 = new a();
            aVar2.b(aVar);
            aVar2.hO(i);
            return aVar2.aer();
        }
    }

    /* loaded from: classes.dex */
    public static class a {
        String alO;
        View.OnClickListener bQN;

        public a(String str, View.OnClickListener onClickListener) {
            this.alO = str;
            this.bQN = onClickListener;
        }
    }

    /* loaded from: classes.dex */
    public static class c {
        final int aMF;
        final int bQL;
        final ImgType bQR;
        final int mHeight;
        final int mWidth;

        private c(a aVar) {
            this.bQR = aVar.bQR;
            this.aMF = aVar.aMF;
            this.bQL = aVar.bQL;
            this.mHeight = aVar.mHeight;
            this.mWidth = aVar.mWidth;
        }

        /* loaded from: classes.dex */
        public static class a {
            private ImgType bQR = ImgType.NONE;
            private int aMF = -1;
            private int bQL = -1;
            private int mHeight = -1;
            private int mWidth = -1;

            public a b(ImgType imgType) {
                this.bQR = imgType;
                return this;
            }

            public a hP(int i) {
                this.aMF = i;
                return this;
            }

            public a hQ(int i) {
                this.bQL = i;
                return this;
            }

            public a hR(int i) {
                this.mHeight = i;
                return this;
            }

            public a hS(int i) {
                this.mWidth = i;
                return this;
            }

            public c aes() {
                return new c(this);
            }
        }

        public static c a(ImgType imgType, int i) {
            a aVar = new a();
            aVar.b(imgType);
            aVar.hP(i);
            return aVar.aes();
        }

        public static c a(ImgType imgType, int i, int i2, int i3, int i4) {
            a aVar = new a();
            aVar.b(imgType);
            aVar.hQ(i);
            aVar.hP(i2);
            aVar.hR(i3);
            aVar.hS(i4);
            return aVar.aes();
        }

        public static c a(ImgType imgType) {
            a aVar = new a();
            aVar.b(imgType);
            return aVar.aes();
        }
    }

    /* loaded from: classes.dex */
    public static class d {
        final String bQS;
        final int bQT;
        final int bQU;
        final String byo;
        final String mTitle;

        private d(a aVar) {
            this.mTitle = aVar.mTitle;
            this.byo = aVar.byo;
            this.bQS = aVar.bQS;
            this.bQT = aVar.bQV;
            this.bQU = aVar.bQU;
        }

        /* loaded from: classes.dex */
        public static class a {
            private String mTitle = null;
            private String byo = null;
            private String bQS = null;
            private int bQV = -1;
            private int bQU = 0;

            public a nq(String str) {
                this.mTitle = str;
                return this;
            }

            public a nr(String str) {
                this.byo = str;
                return this;
            }

            public a hU(int i) {
                this.bQV = i;
                return this;
            }

            public d aet() {
                return new d(this);
            }
        }

        public static d ac(int i, int i2) {
            a aVar = new a();
            aVar.nr(TbadkCoreApplication.getInst().getResources().getString(i));
            aVar.hU(i2);
            return aVar.aet();
        }

        public static d hT(int i) {
            return np(TbadkCoreApplication.getInst().getResources().getString(i));
        }

        public static d ad(int i, int i2) {
            return bM(TbadkCoreApplication.getInst().getResources().getString(i), TbadkCoreApplication.getInst().getResources().getString(i2));
        }

        public static d np(String str) {
            a aVar = new a();
            aVar.nr(str);
            return aVar.aet();
        }

        public static d bM(String str, String str2) {
            a aVar = new a();
            aVar.nr(str);
            aVar.nq(str2);
            return aVar.aet();
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
