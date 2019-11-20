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
        final a cou;
        final a cov;
        final int cow;

        private b(a aVar) {
            this.cou = aVar.cou;
            this.cov = aVar.cov;
            this.cow = aVar.cow;
        }

        /* loaded from: classes.dex */
        public static class a {
            private a cou = null;
            private a cov = null;
            private int cow = -1;

            public a b(a aVar) {
                this.cou = aVar;
                return this;
            }

            public a iF(int i) {
                this.cow = i;
                return this;
            }

            public b anF() {
                return new b(this);
            }
        }

        public static b a(a aVar) {
            a aVar2 = new a();
            aVar2.b(aVar);
            return aVar2.anF();
        }

        public static b a(a aVar, int i) {
            a aVar2 = new a();
            aVar2.b(aVar);
            aVar2.iF(i);
            return aVar2.anF();
        }
    }

    /* loaded from: classes.dex */
    public static class a {
        View.OnClickListener cot;
        String mText;

        public a(String str, View.OnClickListener onClickListener) {
            this.mText = str;
            this.cot = onClickListener;
        }
    }

    /* loaded from: classes.dex */
    public static class c {
        final int biB;
        final int cor;
        final ImgType cox;
        final int mHeight;
        final int mWidth;

        private c(a aVar) {
            this.cox = aVar.cox;
            this.biB = aVar.biB;
            this.cor = aVar.cor;
            this.mHeight = aVar.mHeight;
            this.mWidth = aVar.mWidth;
        }

        /* loaded from: classes.dex */
        public static class a {
            private ImgType cox = ImgType.NONE;
            private int biB = -1;
            private int cor = -1;
            private int mHeight = -1;
            private int mWidth = -1;

            public a b(ImgType imgType) {
                this.cox = imgType;
                return this;
            }

            public a iG(int i) {
                this.biB = i;
                return this;
            }

            public a iH(int i) {
                this.cor = i;
                return this;
            }

            public a iI(int i) {
                this.mHeight = i;
                return this;
            }

            public a iJ(int i) {
                this.mWidth = i;
                return this;
            }

            public c anG() {
                return new c(this);
            }
        }

        public static c a(ImgType imgType, int i) {
            a aVar = new a();
            aVar.b(imgType);
            aVar.iG(i);
            return aVar.anG();
        }

        public static c a(ImgType imgType, int i, int i2, int i3, int i4) {
            a aVar = new a();
            aVar.b(imgType);
            aVar.iH(i);
            aVar.iG(i2);
            aVar.iI(i3);
            aVar.iJ(i4);
            return aVar.anG();
        }

        public static c a(ImgType imgType) {
            a aVar = new a();
            aVar.b(imgType);
            return aVar.anG();
        }
    }

    /* loaded from: classes.dex */
    public static class d {
        final String bXU;
        final int coA;
        final String coy;
        final int coz;
        final String mTitle;

        private d(a aVar) {
            this.mTitle = aVar.mTitle;
            this.bXU = aVar.bXU;
            this.coy = aVar.coy;
            this.coz = aVar.coB;
            this.coA = aVar.coA;
        }

        /* loaded from: classes.dex */
        public static class a {
            private String mTitle = null;
            private String bXU = null;
            private String coy = null;
            private int coB = -1;
            private int coA = 0;

            public a ox(String str) {
                this.mTitle = str;
                return this;
            }

            public a oy(String str) {
                this.bXU = str;
                return this;
            }

            public a iL(int i) {
                this.coB = i;
                return this;
            }

            public d anH() {
                return new d(this);
            }
        }

        public static d ah(int i, int i2) {
            a aVar = new a();
            aVar.oy(TbadkCoreApplication.getInst().getResources().getString(i));
            aVar.iL(i2);
            return aVar.anH();
        }

        public static d iK(int i) {
            return ow(TbadkCoreApplication.getInst().getResources().getString(i));
        }

        public static d ai(int i, int i2) {
            return bU(TbadkCoreApplication.getInst().getResources().getString(i), TbadkCoreApplication.getInst().getResources().getString(i2));
        }

        public static d ow(String str) {
            a aVar = new a();
            aVar.oy(str);
            return aVar.anH();
        }

        public static d bU(String str, String str2) {
            a aVar = new a();
            aVar.oy(str);
            aVar.ox(str2);
            return aVar.anH();
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
