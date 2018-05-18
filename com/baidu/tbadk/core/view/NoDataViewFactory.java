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
        final a anj;
        final a ank;
        final int anl;

        private b(a aVar) {
            this.anj = aVar.anj;
            this.ank = aVar.ank;
            this.anl = aVar.anl;
        }

        /* loaded from: classes.dex */
        public static class a {
            private a anj = null;
            private a ank = null;
            private int anl = -1;

            public a b(a aVar) {
                this.anj = aVar;
                return this;
            }

            public a dk(int i) {
                this.anl = i;
                return this;
            }

            public b wH() {
                return new b(this);
            }
        }

        public static b a(a aVar) {
            a aVar2 = new a();
            aVar2.b(aVar);
            return aVar2.wH();
        }

        public static b a(a aVar, int i) {
            a aVar2 = new a();
            aVar2.b(aVar);
            aVar2.dk(i);
            return aVar2.wH();
        }
    }

    /* loaded from: classes.dex */
    public static class a {
        String agh;
        View.OnClickListener ani;

        public a(String str, View.OnClickListener onClickListener) {
            this.agh = str;
            this.ani = onClickListener;
        }
    }

    /* loaded from: classes.dex */
    public static class c {
        final int ang;
        final ImgType anm;
        final int ann;
        final int mHeight;
        final int mWidth;

        private c(a aVar) {
            this.anm = aVar.anm;
            this.ann = aVar.ann;
            this.ang = aVar.ang;
            this.mHeight = aVar.mHeight;
            this.mWidth = aVar.mWidth;
        }

        /* loaded from: classes.dex */
        public static class a {
            private ImgType anm = ImgType.NONE;
            private int ann = -1;
            private int ang = -1;
            private int mHeight = -1;
            private int mWidth = -1;

            public a b(ImgType imgType) {
                this.anm = imgType;
                return this;
            }

            public a dl(int i) {
                this.ann = i;
                return this;
            }

            public a dm(int i) {
                this.ang = i;
                return this;
            }

            public a dn(int i) {
                this.mHeight = i;
                return this;
            }

            /* renamed from: do  reason: not valid java name */
            public a m16do(int i) {
                this.mWidth = i;
                return this;
            }

            public c wI() {
                return new c(this);
            }
        }

        public static c a(ImgType imgType, int i) {
            a aVar = new a();
            aVar.b(imgType);
            aVar.dl(i);
            return aVar.wI();
        }

        public static c a(ImgType imgType, int i, int i2, int i3, int i4) {
            a aVar = new a();
            aVar.b(imgType);
            aVar.dm(i);
            aVar.dl(i2);
            aVar.dn(i3);
            aVar.m16do(i4);
            return aVar.wI();
        }

        public static c a(ImgType imgType) {
            a aVar = new a();
            aVar.b(imgType);
            return aVar.wI();
        }
    }

    /* loaded from: classes.dex */
    public static class d {
        final String Xw;
        final String ano;
        final int anp;
        final int anq;
        final String mTitle;

        private d(a aVar) {
            this.mTitle = aVar.mTitle;
            this.Xw = aVar.Xw;
            this.ano = aVar.ano;
            this.anp = aVar.anr;
            this.anq = aVar.anq;
        }

        /* loaded from: classes.dex */
        public static class a {
            private String mTitle = null;
            private String Xw = null;
            private String ano = null;
            private int anr = -1;
            private int anq = 0;

            public a eM(String str) {
                this.mTitle = str;
                return this;
            }

            public a eN(String str) {
                this.Xw = str;
                return this;
            }

            public a dq(int i) {
                this.anr = i;
                return this;
            }

            public d wJ() {
                return new d(this);
            }
        }

        public static d B(int i, int i2) {
            a aVar = new a();
            aVar.eN(TbadkCoreApplication.getInst().getResources().getString(i));
            aVar.dq(i2);
            return aVar.wJ();
        }

        public static d dp(int i) {
            return eL(TbadkCoreApplication.getInst().getResources().getString(i));
        }

        public static d C(int i, int i2) {
            return af(TbadkCoreApplication.getInst().getResources().getString(i), TbadkCoreApplication.getInst().getResources().getString(i2));
        }

        public static d eL(String str) {
            a aVar = new a();
            aVar.eN(str);
            return aVar.wJ();
        }

        public static d af(String str, String str2) {
            a aVar = new a();
            aVar.eN(str);
            aVar.eM(str2);
            return aVar.wJ();
        }
    }

    public static NoDataView a(Context context, View view2, c cVar, d dVar, b bVar) {
        return a(context, view2, cVar, dVar, bVar, false);
    }

    public static NoDataView a(Context context, View view2, c cVar, d dVar, b bVar, boolean z) {
        NoDataView noDataView = new NoDataView(context);
        noDataView.a(bVar, cVar, dVar);
        if (view2 != null) {
            if (view2 instanceof RelativeLayout) {
                RelativeLayout relativeLayout = (RelativeLayout) view2;
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
            } else if (view2 instanceof LinearLayout) {
                ((LinearLayout) view2).addView(noDataView);
                LinearLayout.LayoutParams layoutParams2 = (LinearLayout.LayoutParams) noDataView.getLayoutParams();
                layoutParams2.gravity = 1;
                noDataView.setLayoutParams(layoutParams2);
            } else if (view2 instanceof FrameLayout) {
                ((FrameLayout) view2).addView(noDataView, 0);
            }
        }
        noDataView.setVisibility(8);
        return noDataView;
    }
}
