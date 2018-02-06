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
        final a bbZ;
        final a bca;
        final int bcb;

        private b(a aVar) {
            this.bbZ = aVar.bbZ;
            this.bca = aVar.bca;
            this.bcb = aVar.bcb;
        }

        /* loaded from: classes.dex */
        public static class a {
            private a bbZ = null;
            private a bca = null;
            private int bcb = -1;

            public a b(a aVar) {
                this.bbZ = aVar;
                return this;
            }

            public a gk(int i) {
                this.bcb = i;
                return this;
            }

            public b DX() {
                return new b(this);
            }
        }

        public static b a(a aVar) {
            a aVar2 = new a();
            aVar2.b(aVar);
            return aVar2.DX();
        }

        public static b a(a aVar, int i) {
            a aVar2 = new a();
            aVar2.b(aVar);
            aVar2.gk(i);
            return aVar2.DX();
        }
    }

    /* loaded from: classes.dex */
    public static class a {
        String aUX;
        View.OnClickListener bbY;

        public a(String str, View.OnClickListener onClickListener) {
            this.aUX = str;
            this.bbY = onClickListener;
        }
    }

    /* loaded from: classes.dex */
    public static class c {
        final int bbW;
        final ImgType bcc;
        final int bcd;
        final int mHeight;
        final int mWidth;

        private c(a aVar) {
            this.bcc = aVar.bcc;
            this.bcd = aVar.bcd;
            this.bbW = aVar.bbW;
            this.mHeight = aVar.mHeight;
            this.mWidth = aVar.mWidth;
        }

        /* loaded from: classes.dex */
        public static class a {
            private ImgType bcc = ImgType.NONE;
            private int bcd = -1;
            private int bbW = -1;
            private int mHeight = -1;
            private int mWidth = -1;

            public a b(ImgType imgType) {
                this.bcc = imgType;
                return this;
            }

            public a gl(int i) {
                this.bcd = i;
                return this;
            }

            public a gm(int i) {
                this.bbW = i;
                return this;
            }

            public a gn(int i) {
                this.mHeight = i;
                return this;
            }

            public a go(int i) {
                this.mWidth = i;
                return this;
            }

            public c DY() {
                return new c(this);
            }
        }

        public static c a(ImgType imgType, int i) {
            a aVar = new a();
            aVar.b(imgType);
            aVar.gl(i);
            return aVar.DY();
        }

        public static c a(ImgType imgType, int i, int i2, int i3, int i4) {
            a aVar = new a();
            aVar.b(imgType);
            aVar.gm(i);
            aVar.gl(i2);
            aVar.gn(i3);
            aVar.go(i4);
            return aVar.DY();
        }

        public static c a(ImgType imgType) {
            a aVar = new a();
            aVar.b(imgType);
            return aVar.DY();
        }
    }

    /* loaded from: classes.dex */
    public static class d {
        final String aMk;
        final String bcf;
        final int bcg;
        final int bch;
        final String mTitle;

        private d(a aVar) {
            this.mTitle = aVar.mTitle;
            this.aMk = aVar.aMk;
            this.bcf = aVar.bcf;
            this.bcg = aVar.bci;
            this.bch = aVar.bch;
        }

        /* loaded from: classes.dex */
        public static class a {
            private String mTitle = null;
            private String aMk = null;
            private String bcf = null;
            private int bci = -1;
            private int bch = 0;

            public a eU(String str) {
                this.mTitle = str;
                return this;
            }

            public a eV(String str) {
                this.aMk = str;
                return this;
            }

            public a gq(int i) {
                this.bci = i;
                return this;
            }

            public d DZ() {
                return new d(this);
            }
        }

        public static d aB(int i, int i2) {
            a aVar = new a();
            aVar.eV(TbadkCoreApplication.getInst().getResources().getString(i));
            aVar.gq(i2);
            return aVar.DZ();
        }

        public static d gp(int i) {
            return eT(TbadkCoreApplication.getInst().getResources().getString(i));
        }

        public static d aC(int i, int i2) {
            return ae(TbadkCoreApplication.getInst().getResources().getString(i), TbadkCoreApplication.getInst().getResources().getString(i2));
        }

        public static d eT(String str) {
            a aVar = new a();
            aVar.eV(str);
            return aVar.DZ();
        }

        public static d ae(String str, String str2) {
            a aVar = new a();
            aVar.eV(str);
            aVar.eU(str2);
            return aVar.DZ();
        }
    }

    public static h a(Context context, View view, c cVar, d dVar, b bVar) {
        return a(context, view, cVar, dVar, bVar, false);
    }

    public static h a(Context context, View view, c cVar, d dVar, b bVar, boolean z) {
        h hVar = new h(context);
        hVar.a(bVar, cVar, dVar);
        if (view != null) {
            if (view instanceof RelativeLayout) {
                RelativeLayout relativeLayout = (RelativeLayout) view;
                if (z) {
                    relativeLayout.addView(hVar, 0);
                } else {
                    relativeLayout.addView(hVar);
                }
                RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) hVar.getLayoutParams();
                layoutParams.width = -1;
                layoutParams.height = -1;
                layoutParams.addRule(14);
                hVar.setLayoutParams(layoutParams);
            } else if (view instanceof LinearLayout) {
                ((LinearLayout) view).addView(hVar);
                LinearLayout.LayoutParams layoutParams2 = (LinearLayout.LayoutParams) hVar.getLayoutParams();
                layoutParams2.gravity = 1;
                hVar.setLayoutParams(layoutParams2);
            } else if (view instanceof FrameLayout) {
                ((FrameLayout) view).addView(hVar, 0);
            }
        }
        hVar.setVisibility(8);
        return hVar;
    }
}
