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
        LOCAL
    }

    /* loaded from: classes.dex */
    public static class b {
        final a alg;
        final a alh;
        final int ali;

        private b(a aVar) {
            this.alg = aVar.alg;
            this.alh = aVar.alh;
            this.ali = aVar.ali;
        }

        /* loaded from: classes.dex */
        public static class a {
            private a alg = null;
            private a alh = null;
            private int ali = -1;

            public a b(a aVar) {
                this.alg = aVar;
                return this;
            }

            public a dk(int i) {
                this.ali = i;
                return this;
            }

            public b wd() {
                return new b(this);
            }
        }

        public static b a(a aVar) {
            a aVar2 = new a();
            aVar2.b(aVar);
            return aVar2.wd();
        }

        public static b a(a aVar, int i) {
            a aVar2 = new a();
            aVar2.b(aVar);
            aVar2.dk(i);
            return aVar2.wd();
        }
    }

    /* loaded from: classes.dex */
    public static class a {
        String aer;
        View.OnClickListener alf;

        public a(String str, View.OnClickListener onClickListener) {
            this.aer = str;
            this.alf = onClickListener;
        }
    }

    /* loaded from: classes.dex */
    public static class c {
        final int ald;
        final ImgType alj;
        final int alk;
        final int mHeight;
        final int mWidth;

        private c(a aVar) {
            this.alj = aVar.alj;
            this.alk = aVar.alk;
            this.ald = aVar.ald;
            this.mHeight = aVar.mHeight;
            this.mWidth = aVar.mWidth;
        }

        /* loaded from: classes.dex */
        public static class a {
            private ImgType alj = ImgType.NONE;
            private int alk = -1;
            private int ald = -1;
            private int mHeight = -1;
            private int mWidth = -1;

            public a b(ImgType imgType) {
                this.alj = imgType;
                return this;
            }

            public a dl(int i) {
                this.alk = i;
                return this;
            }

            public a dm(int i) {
                this.ald = i;
                return this;
            }

            public a dn(int i) {
                this.mHeight = i;
                return this;
            }

            /* renamed from: do  reason: not valid java name */
            public a m10do(int i) {
                this.mWidth = i;
                return this;
            }

            public c we() {
                return new c(this);
            }
        }

        public static c a(ImgType imgType, int i) {
            a aVar = new a();
            aVar.b(imgType);
            aVar.dl(i);
            return aVar.we();
        }

        public static c a(ImgType imgType, int i, int i2, int i3, int i4) {
            a aVar = new a();
            aVar.b(imgType);
            aVar.dm(i);
            aVar.dl(i2);
            aVar.dn(i3);
            aVar.m10do(i4);
            return aVar.we();
        }

        public static c a(ImgType imgType) {
            a aVar = new a();
            aVar.b(imgType);
            return aVar.we();
        }
    }

    /* loaded from: classes.dex */
    public static class d {
        final String VG;
        final String aln;
        final int alo;
        final int alp;
        final String mTitle;

        private d(a aVar) {
            this.mTitle = aVar.mTitle;
            this.VG = aVar.VG;
            this.aln = aVar.aln;
            this.alo = aVar.alq;
            this.alp = aVar.alp;
        }

        /* loaded from: classes.dex */
        public static class a {
            private String mTitle = null;
            private String VG = null;
            private String aln = null;
            private int alq = -1;
            private int alp = 0;

            public a ej(String str) {
                this.mTitle = str;
                return this;
            }

            public a ek(String str) {
                this.VG = str;
                return this;
            }

            public a dq(int i) {
                this.alq = i;
                return this;
            }

            public a dr(int i) {
                this.alp = i;
                return this;
            }

            public d wf() {
                return new d(this);
            }
        }

        public static d C(int i, int i2) {
            a aVar = new a();
            aVar.ek(TbadkCoreApplication.getInst().getResources().getString(i));
            aVar.dq(i2);
            return aVar.wf();
        }

        public static d dp(int i) {
            return ei(TbadkCoreApplication.getInst().getResources().getString(i));
        }

        public static d D(int i, int i2) {
            return af(TbadkCoreApplication.getInst().getResources().getString(i), TbadkCoreApplication.getInst().getResources().getString(i2));
        }

        public static d ei(String str) {
            a aVar = new a();
            aVar.ek(str);
            return aVar.wf();
        }

        public static d af(String str, String str2) {
            a aVar = new a();
            aVar.ek(str);
            aVar.ej(str2);
            return aVar.wf();
        }

        public static d b(int i, String str, String str2) {
            a aVar = new a();
            aVar.ek(str);
            aVar.ej(str2);
            aVar.dr(i);
            return aVar.wf();
        }
    }

    public static f a(Context context, View view, c cVar, d dVar, b bVar) {
        return a(context, view, cVar, dVar, bVar, false);
    }

    public static f a(Context context, View view, c cVar, d dVar, b bVar, boolean z) {
        f fVar = new f(context);
        fVar.a(bVar, cVar, dVar);
        if (view != null) {
            if (view instanceof RelativeLayout) {
                RelativeLayout relativeLayout = (RelativeLayout) view;
                if (z) {
                    relativeLayout.addView(fVar, 0);
                } else {
                    relativeLayout.addView(fVar);
                }
                RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) fVar.getLayoutParams();
                layoutParams.width = -1;
                layoutParams.height = -1;
                layoutParams.addRule(14);
                fVar.setLayoutParams(layoutParams);
            } else if (view instanceof LinearLayout) {
                ((LinearLayout) view).addView(fVar);
                LinearLayout.LayoutParams layoutParams2 = (LinearLayout.LayoutParams) fVar.getLayoutParams();
                layoutParams2.gravity = 1;
                fVar.setLayoutParams(layoutParams2);
            } else if (view instanceof FrameLayout) {
                ((FrameLayout) view).addView(fVar, 0);
            }
        }
        fVar.setVisibility(8);
        return fVar;
    }
}
