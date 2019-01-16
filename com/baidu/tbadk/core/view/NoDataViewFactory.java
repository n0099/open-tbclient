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
        final a aIs;
        final a aIt;
        final int aIu;

        private b(a aVar) {
            this.aIs = aVar.aIs;
            this.aIt = aVar.aIt;
            this.aIu = aVar.aIu;
        }

        /* loaded from: classes.dex */
        public static class a {
            private a aIs = null;
            private a aIt = null;
            private int aIu = -1;

            public a b(a aVar) {
                this.aIs = aVar;
                return this;
            }

            public a el(int i) {
                this.aIu = i;
                return this;
            }

            public b Fh() {
                return new b(this);
            }
        }

        public static b a(a aVar) {
            a aVar2 = new a();
            aVar2.b(aVar);
            return aVar2.Fh();
        }

        public static b a(a aVar, int i) {
            a aVar2 = new a();
            aVar2.b(aVar);
            aVar2.el(i);
            return aVar2.Fh();
        }
    }

    /* loaded from: classes.dex */
    public static class a {
        View.OnClickListener aIr;
        String mText;

        public a(String str, View.OnClickListener onClickListener) {
            this.mText = str;
            this.aIr = onClickListener;
        }
    }

    /* loaded from: classes.dex */
    public static class c {
        final int aIp;
        final ImgType aIv;
        final int mHeight;
        final int mMarginTop;
        final int mWidth;

        private c(a aVar) {
            this.aIv = aVar.aIv;
            this.mMarginTop = aVar.mMarginTop;
            this.aIp = aVar.aIp;
            this.mHeight = aVar.mHeight;
            this.mWidth = aVar.mWidth;
        }

        /* loaded from: classes.dex */
        public static class a {
            private ImgType aIv = ImgType.NONE;
            private int mMarginTop = -1;
            private int aIp = -1;
            private int mHeight = -1;
            private int mWidth = -1;

            public a b(ImgType imgType) {
                this.aIv = imgType;
                return this;
            }

            public a em(int i) {
                this.mMarginTop = i;
                return this;
            }

            public a en(int i) {
                this.aIp = i;
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

            public c Fi() {
                return new c(this);
            }
        }

        public static c a(ImgType imgType, int i) {
            a aVar = new a();
            aVar.b(imgType);
            aVar.em(i);
            return aVar.Fi();
        }

        public static c a(ImgType imgType, int i, int i2, int i3, int i4) {
            a aVar = new a();
            aVar.b(imgType);
            aVar.en(i);
            aVar.em(i2);
            aVar.eo(i3);
            aVar.ep(i4);
            return aVar.Fi();
        }

        public static c a(ImgType imgType) {
            a aVar = new a();
            aVar.b(imgType);
            return aVar.Fi();
        }
    }

    /* loaded from: classes.dex */
    public static class d {
        final String aIw;
        final int aIx;
        final int aIy;
        final String art;
        final String mTitle;

        private d(a aVar) {
            this.mTitle = aVar.mTitle;
            this.art = aVar.art;
            this.aIw = aVar.aIw;
            this.aIx = aVar.aIz;
            this.aIy = aVar.aIy;
        }

        /* loaded from: classes.dex */
        public static class a {
            private String mTitle = null;
            private String art = null;
            private String aIw = null;
            private int aIz = -1;
            private int aIy = 0;

            public a gD(String str) {
                this.mTitle = str;
                return this;
            }

            public a gE(String str) {
                this.art = str;
                return this;
            }

            public a er(int i) {
                this.aIz = i;
                return this;
            }

            public d Fj() {
                return new d(this);
            }
        }

        public static d G(int i, int i2) {
            a aVar = new a();
            aVar.gE(TbadkCoreApplication.getInst().getResources().getString(i));
            aVar.er(i2);
            return aVar.Fj();
        }

        public static d eq(int i) {
            return gC(TbadkCoreApplication.getInst().getResources().getString(i));
        }

        public static d H(int i, int i2) {
            return aE(TbadkCoreApplication.getInst().getResources().getString(i), TbadkCoreApplication.getInst().getResources().getString(i2));
        }

        public static d gC(String str) {
            a aVar = new a();
            aVar.gE(str);
            return aVar.Fj();
        }

        public static d aE(String str, String str2) {
            a aVar = new a();
            aVar.gE(str);
            aVar.gD(str2);
            return aVar.Fj();
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
