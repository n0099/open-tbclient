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
        final a awa;
        final a awb;
        final int awc;

        private b(a aVar) {
            this.awa = aVar.awa;
            this.awb = aVar.awb;
            this.awc = aVar.awc;
        }

        /* loaded from: classes.dex */
        public static class a {
            private a awa = null;
            private a awb = null;
            private int awc = -1;

            public a b(a aVar) {
                this.awa = aVar;
                return this;
            }

            public a dn(int i) {
                this.awc = i;
                return this;
            }

            public b Ay() {
                return new b(this);
            }
        }

        public static b a(a aVar) {
            a aVar2 = new a();
            aVar2.b(aVar);
            return aVar2.Ay();
        }

        public static b a(a aVar, int i) {
            a aVar2 = new a();
            aVar2.b(aVar);
            aVar2.dn(i);
            return aVar2.Ay();
        }
    }

    /* loaded from: classes.dex */
    public static class a {
        String aoM;
        View.OnClickListener avZ;

        public a(String str, View.OnClickListener onClickListener) {
            this.aoM = str;
            this.avZ = onClickListener;
        }
    }

    /* loaded from: classes.dex */
    public static class c {
        final int avX;
        final ImgType awd;
        final int awe;
        final int mHeight;
        final int mWidth;

        private c(a aVar) {
            this.awd = aVar.awd;
            this.awe = aVar.awe;
            this.avX = aVar.avX;
            this.mHeight = aVar.mHeight;
            this.mWidth = aVar.mWidth;
        }

        /* loaded from: classes.dex */
        public static class a {
            private ImgType awd = ImgType.NONE;
            private int awe = -1;
            private int avX = -1;
            private int mHeight = -1;
            private int mWidth = -1;

            public a b(ImgType imgType) {
                this.awd = imgType;
                return this;
            }

            /* renamed from: do  reason: not valid java name */
            public a m14do(int i) {
                this.awe = i;
                return this;
            }

            public a dp(int i) {
                this.avX = i;
                return this;
            }

            public a dq(int i) {
                this.mHeight = i;
                return this;
            }

            public a dr(int i) {
                this.mWidth = i;
                return this;
            }

            public c Az() {
                return new c(this);
            }
        }

        public static c a(ImgType imgType, int i) {
            a aVar = new a();
            aVar.b(imgType);
            aVar.m14do(i);
            return aVar.Az();
        }

        public static c a(ImgType imgType, int i, int i2, int i3, int i4) {
            a aVar = new a();
            aVar.b(imgType);
            aVar.dp(i);
            aVar.m14do(i2);
            aVar.dq(i3);
            aVar.dr(i4);
            return aVar.Az();
        }

        public static c a(ImgType imgType) {
            a aVar = new a();
            aVar.b(imgType);
            return aVar.Az();
        }
    }

    /* loaded from: classes.dex */
    public static class d {
        final String afM;
        final String awf;
        final int awg;
        final int awh;
        final String mTitle;

        private d(a aVar) {
            this.mTitle = aVar.mTitle;
            this.afM = aVar.afM;
            this.awf = aVar.awf;
            this.awg = aVar.awi;
            this.awh = aVar.awh;
        }

        /* loaded from: classes.dex */
        public static class a {
            private String mTitle = null;
            private String afM = null;
            private String awf = null;
            private int awi = -1;
            private int awh = 0;

            public a fp(String str) {
                this.mTitle = str;
                return this;
            }

            public a fq(String str) {
                this.afM = str;
                return this;
            }

            public a dt(int i) {
                this.awi = i;
                return this;
            }

            public d AA() {
                return new d(this);
            }
        }

        public static d C(int i, int i2) {
            a aVar = new a();
            aVar.fq(TbadkCoreApplication.getInst().getResources().getString(i));
            aVar.dt(i2);
            return aVar.AA();
        }

        public static d ds(int i) {
            return fo(TbadkCoreApplication.getInst().getResources().getString(i));
        }

        public static d D(int i, int i2) {
            return aj(TbadkCoreApplication.getInst().getResources().getString(i), TbadkCoreApplication.getInst().getResources().getString(i2));
        }

        public static d fo(String str) {
            a aVar = new a();
            aVar.fq(str);
            return aVar.AA();
        }

        public static d aj(String str, String str2) {
            a aVar = new a();
            aVar.fq(str);
            aVar.fp(str2);
            return aVar.AA();
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
