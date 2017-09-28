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
        final a alt;
        final a alu;
        final int alv;

        private b(a aVar) {
            this.alt = aVar.alt;
            this.alu = aVar.alu;
            this.alv = aVar.alv;
        }

        /* loaded from: classes.dex */
        public static class a {
            private a alt = null;
            private a alu = null;
            private int alv = -1;

            public a b(a aVar) {
                this.alt = aVar;
                return this;
            }

            public a dl(int i) {
                this.alv = i;
                return this;
            }

            public b wk() {
                return new b(this);
            }
        }

        public static b a(a aVar) {
            a aVar2 = new a();
            aVar2.b(aVar);
            return aVar2.wk();
        }

        public static b a(a aVar, int i) {
            a aVar2 = new a();
            aVar2.b(aVar);
            aVar2.dl(i);
            return aVar2.wk();
        }
    }

    /* loaded from: classes.dex */
    public static class a {
        String aeD;
        View.OnClickListener als;

        public a(String str, View.OnClickListener onClickListener) {
            this.aeD = str;
            this.als = onClickListener;
        }
    }

    /* loaded from: classes.dex */
    public static class c {
        final int alq;
        final ImgType alw;
        final int alx;
        final int mHeight;
        final int mWidth;

        private c(a aVar) {
            this.alw = aVar.alw;
            this.alx = aVar.alx;
            this.alq = aVar.alq;
            this.mHeight = aVar.mHeight;
            this.mWidth = aVar.mWidth;
        }

        /* loaded from: classes.dex */
        public static class a {
            private ImgType alw = ImgType.NONE;
            private int alx = -1;
            private int alq = -1;
            private int mHeight = -1;
            private int mWidth = -1;

            public a b(ImgType imgType) {
                this.alw = imgType;
                return this;
            }

            public a dm(int i) {
                this.alx = i;
                return this;
            }

            public a dn(int i) {
                this.alq = i;
                return this;
            }

            /* renamed from: do  reason: not valid java name */
            public a m10do(int i) {
                this.mHeight = i;
                return this;
            }

            public a dp(int i) {
                this.mWidth = i;
                return this;
            }

            public c wl() {
                return new c(this);
            }
        }

        public static c a(ImgType imgType, int i) {
            a aVar = new a();
            aVar.b(imgType);
            aVar.dm(i);
            return aVar.wl();
        }

        public static c a(ImgType imgType, int i, int i2, int i3, int i4) {
            a aVar = new a();
            aVar.b(imgType);
            aVar.dn(i);
            aVar.dm(i2);
            aVar.m10do(i3);
            aVar.dp(i4);
            return aVar.wl();
        }

        public static c a(ImgType imgType) {
            a aVar = new a();
            aVar.b(imgType);
            return aVar.wl();
        }
    }

    /* loaded from: classes.dex */
    public static class d {
        final String VS;
        final int alA;
        final int alB;
        final String alz;
        final String mTitle;

        private d(a aVar) {
            this.mTitle = aVar.mTitle;
            this.VS = aVar.VS;
            this.alz = aVar.alz;
            this.alA = aVar.alC;
            this.alB = aVar.alB;
        }

        /* loaded from: classes.dex */
        public static class a {
            private String mTitle = null;
            private String VS = null;
            private String alz = null;
            private int alC = -1;
            private int alB = 0;

            public a ek(String str) {
                this.mTitle = str;
                return this;
            }

            public a el(String str) {
                this.VS = str;
                return this;
            }

            public a dr(int i) {
                this.alC = i;
                return this;
            }

            public a ds(int i) {
                this.alB = i;
                return this;
            }

            public d wm() {
                return new d(this);
            }
        }

        public static d C(int i, int i2) {
            a aVar = new a();
            aVar.el(TbadkCoreApplication.getInst().getResources().getString(i));
            aVar.dr(i2);
            return aVar.wm();
        }

        public static d dq(int i) {
            return ej(TbadkCoreApplication.getInst().getResources().getString(i));
        }

        public static d D(int i, int i2) {
            return ag(TbadkCoreApplication.getInst().getResources().getString(i), TbadkCoreApplication.getInst().getResources().getString(i2));
        }

        public static d ej(String str) {
            a aVar = new a();
            aVar.el(str);
            return aVar.wm();
        }

        public static d ag(String str, String str2) {
            a aVar = new a();
            aVar.el(str);
            aVar.ek(str2);
            return aVar.wm();
        }

        public static d b(int i, String str, String str2) {
            a aVar = new a();
            aVar.el(str);
            aVar.ek(str2);
            aVar.ds(i);
            return aVar.wm();
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
