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
        final a aZZ;
        final a baa;
        final int bab;

        private b(a aVar) {
            this.aZZ = aVar.aZZ;
            this.baa = aVar.baa;
            this.bab = aVar.bab;
        }

        /* loaded from: classes.dex */
        public static class a {
            private a aZZ = null;
            private a baa = null;
            private int bab = -1;

            public a b(a aVar) {
                this.aZZ = aVar;
                return this;
            }

            public a gk(int i) {
                this.bab = i;
                return this;
            }

            public b DK() {
                return new b(this);
            }
        }

        public static b a(a aVar) {
            a aVar2 = new a();
            aVar2.b(aVar);
            return aVar2.DK();
        }

        public static b a(a aVar, int i) {
            a aVar2 = new a();
            aVar2.b(aVar);
            aVar2.gk(i);
            return aVar2.DK();
        }
    }

    /* loaded from: classes.dex */
    public static class a {
        String aTq;
        View.OnClickListener aZY;

        public a(String str, View.OnClickListener onClickListener) {
            this.aTq = str;
            this.aZY = onClickListener;
        }
    }

    /* loaded from: classes.dex */
    public static class c {
        final int aZW;
        final ImgType bac;
        final int bad;
        final int mHeight;
        final int mWidth;

        private c(a aVar) {
            this.bac = aVar.bac;
            this.bad = aVar.bad;
            this.aZW = aVar.aZW;
            this.mHeight = aVar.mHeight;
            this.mWidth = aVar.mWidth;
        }

        /* loaded from: classes.dex */
        public static class a {
            private ImgType bac = ImgType.NONE;
            private int bad = -1;
            private int aZW = -1;
            private int mHeight = -1;
            private int mWidth = -1;

            public a b(ImgType imgType) {
                this.bac = imgType;
                return this;
            }

            public a gl(int i) {
                this.bad = i;
                return this;
            }

            public a gm(int i) {
                this.aZW = i;
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

            public c DL() {
                return new c(this);
            }
        }

        public static c a(ImgType imgType, int i) {
            a aVar = new a();
            aVar.b(imgType);
            aVar.gl(i);
            return aVar.DL();
        }

        public static c a(ImgType imgType, int i, int i2, int i3, int i4) {
            a aVar = new a();
            aVar.b(imgType);
            aVar.gm(i);
            aVar.gl(i2);
            aVar.gn(i3);
            aVar.go(i4);
            return aVar.DL();
        }

        public static c a(ImgType imgType) {
            a aVar = new a();
            aVar.b(imgType);
            return aVar.DL();
        }
    }

    /* loaded from: classes.dex */
    public static class d {
        final String aKP;
        final String baf;
        final int bag;
        final int bah;
        final String mTitle;

        private d(a aVar) {
            this.mTitle = aVar.mTitle;
            this.aKP = aVar.aKP;
            this.baf = aVar.baf;
            this.bag = aVar.bai;
            this.bah = aVar.bah;
        }

        /* loaded from: classes.dex */
        public static class a {
            private String mTitle = null;
            private String aKP = null;
            private String baf = null;
            private int bai = -1;
            private int bah = 0;

            public a eB(String str) {
                this.mTitle = str;
                return this;
            }

            public a eC(String str) {
                this.aKP = str;
                return this;
            }

            public a gq(int i) {
                this.bai = i;
                return this;
            }

            public a gr(int i) {
                this.bah = i;
                return this;
            }

            public d DM() {
                return new d(this);
            }
        }

        public static d aB(int i, int i2) {
            a aVar = new a();
            aVar.eC(TbadkCoreApplication.getInst().getResources().getString(i));
            aVar.gq(i2);
            return aVar.DM();
        }

        public static d gp(int i) {
            return eA(TbadkCoreApplication.getInst().getResources().getString(i));
        }

        public static d aC(int i, int i2) {
            return ae(TbadkCoreApplication.getInst().getResources().getString(i), TbadkCoreApplication.getInst().getResources().getString(i2));
        }

        public static d eA(String str) {
            a aVar = new a();
            aVar.eC(str);
            return aVar.DM();
        }

        public static d ae(String str, String str2) {
            a aVar = new a();
            aVar.eC(str);
            aVar.eB(str2);
            return aVar.DM();
        }

        public static d c(int i, String str, String str2) {
            a aVar = new a();
            aVar.eC(str);
            aVar.eB(str2);
            aVar.gr(i);
            return aVar.DM();
        }
    }

    public static g a(Context context, View view, c cVar, d dVar, b bVar) {
        return a(context, view, cVar, dVar, bVar, false);
    }

    public static g a(Context context, View view, c cVar, d dVar, b bVar, boolean z) {
        g gVar = new g(context);
        gVar.a(bVar, cVar, dVar);
        if (view != null) {
            if (view instanceof RelativeLayout) {
                RelativeLayout relativeLayout = (RelativeLayout) view;
                if (z) {
                    relativeLayout.addView(gVar, 0);
                } else {
                    relativeLayout.addView(gVar);
                }
                RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) gVar.getLayoutParams();
                layoutParams.width = -1;
                layoutParams.height = -1;
                layoutParams.addRule(14);
                gVar.setLayoutParams(layoutParams);
            } else if (view instanceof LinearLayout) {
                ((LinearLayout) view).addView(gVar);
                LinearLayout.LayoutParams layoutParams2 = (LinearLayout.LayoutParams) gVar.getLayoutParams();
                layoutParams2.gravity = 1;
                gVar.setLayoutParams(layoutParams2);
            } else if (view instanceof FrameLayout) {
                ((FrameLayout) view).addView(gVar, 0);
            }
        }
        gVar.setVisibility(8);
        return gVar;
    }
}
