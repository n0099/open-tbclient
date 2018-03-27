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
        final a bbP;
        final a bbQ;
        final int bbR;

        private b(a aVar) {
            this.bbP = aVar.bbP;
            this.bbQ = aVar.bbQ;
            this.bbR = aVar.bbR;
        }

        /* loaded from: classes.dex */
        public static class a {
            private a bbP = null;
            private a bbQ = null;
            private int bbR = -1;

            public a b(a aVar) {
                this.bbP = aVar;
                return this;
            }

            public a gk(int i) {
                this.bbR = i;
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
        String aUN;
        View.OnClickListener bbO;

        public a(String str, View.OnClickListener onClickListener) {
            this.aUN = str;
            this.bbO = onClickListener;
        }
    }

    /* loaded from: classes.dex */
    public static class c {
        final int bbM;
        final ImgType bbS;
        final int bbT;
        final int mHeight;
        final int mWidth;

        private c(a aVar) {
            this.bbS = aVar.bbS;
            this.bbT = aVar.bbT;
            this.bbM = aVar.bbM;
            this.mHeight = aVar.mHeight;
            this.mWidth = aVar.mWidth;
        }

        /* loaded from: classes.dex */
        public static class a {
            private ImgType bbS = ImgType.NONE;
            private int bbT = -1;
            private int bbM = -1;
            private int mHeight = -1;
            private int mWidth = -1;

            public a b(ImgType imgType) {
                this.bbS = imgType;
                return this;
            }

            public a gl(int i) {
                this.bbT = i;
                return this;
            }

            public a gm(int i) {
                this.bbM = i;
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
        final String aMa;
        final String bbV;
        final int bbW;
        final int bbX;
        final String mTitle;

        private d(a aVar) {
            this.mTitle = aVar.mTitle;
            this.aMa = aVar.aMa;
            this.bbV = aVar.bbV;
            this.bbW = aVar.bbY;
            this.bbX = aVar.bbX;
        }

        /* loaded from: classes.dex */
        public static class a {
            private String mTitle = null;
            private String aMa = null;
            private String bbV = null;
            private int bbY = -1;
            private int bbX = 0;

            public a eU(String str) {
                this.mTitle = str;
                return this;
            }

            public a eV(String str) {
                this.aMa = str;
                return this;
            }

            public a gq(int i) {
                this.bbY = i;
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
