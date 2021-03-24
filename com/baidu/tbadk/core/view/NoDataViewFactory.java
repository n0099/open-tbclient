package com.baidu.tbadk.core.view;

import android.content.Context;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import com.baidu.tbadk.core.TbadkCoreApplication;
/* loaded from: classes3.dex */
public class NoDataViewFactory {

    /* loaded from: classes3.dex */
    public enum ImgType {
        NONE,
        CREATE,
        NODATA,
        FINDBAR,
        COLLECTION,
        EMOTION,
        SINGALL,
        GIFT,
        WEBVIEW,
        LOCAL,
        ANTI,
        NETERROR
    }

    /* loaded from: classes3.dex */
    public static class b {

        /* renamed from: a  reason: collision with root package name */
        public View.OnClickListener f13404a;

        /* renamed from: b  reason: collision with root package name */
        public String f13405b;

        public b(String str, View.OnClickListener onClickListener) {
            this.f13405b = str;
            this.f13404a = onClickListener;
        }
    }

    /* loaded from: classes3.dex */
    public static class c {

        /* renamed from: a  reason: collision with root package name */
        public final b f13406a;

        /* renamed from: b  reason: collision with root package name */
        public final b f13407b;

        /* renamed from: c  reason: collision with root package name */
        public final int f13408c;

        /* loaded from: classes3.dex */
        public static class a {

            /* renamed from: a  reason: collision with root package name */
            public b f13409a = null;

            /* renamed from: b  reason: collision with root package name */
            public b f13410b = null;

            /* renamed from: c  reason: collision with root package name */
            public int f13411c = -1;

            public a d(int i) {
                this.f13411c = i;
                return this;
            }

            public c e() {
                return new c(this);
            }

            public a f(b bVar) {
                this.f13409a = bVar;
                return this;
            }
        }

        public static c a(b bVar) {
            a aVar = new a();
            aVar.f(bVar);
            return aVar.e();
        }

        public static c b(b bVar, int i) {
            a aVar = new a();
            aVar.f(bVar);
            aVar.d(i);
            return aVar.e();
        }

        public c(a aVar) {
            this.f13406a = aVar.f13409a;
            this.f13407b = aVar.f13410b;
            this.f13408c = aVar.f13411c;
        }
    }

    /* loaded from: classes3.dex */
    public static class d {

        /* renamed from: a  reason: collision with root package name */
        public final ImgType f13412a;

        /* renamed from: b  reason: collision with root package name */
        public final int f13413b;

        /* renamed from: c  reason: collision with root package name */
        public final int f13414c;

        /* renamed from: d  reason: collision with root package name */
        public final int f13415d;

        /* renamed from: e  reason: collision with root package name */
        public final int f13416e;

        /* loaded from: classes3.dex */
        public static class a {

            /* renamed from: a  reason: collision with root package name */
            public ImgType f13417a = ImgType.NONE;

            /* renamed from: b  reason: collision with root package name */
            public int f13418b = -1;

            /* renamed from: c  reason: collision with root package name */
            public int f13419c = -1;

            /* renamed from: d  reason: collision with root package name */
            public int f13420d = -1;

            /* renamed from: e  reason: collision with root package name */
            public int f13421e = -1;

            public d f() {
                return new d(this);
            }

            public a g(int i) {
                this.f13420d = i;
                return this;
            }

            public a h(int i) {
                this.f13419c = i;
                return this;
            }

            public a i(ImgType imgType) {
                this.f13417a = imgType;
                return this;
            }

            public a j(int i) {
                this.f13418b = i;
                return this;
            }

            public a k(int i) {
                this.f13421e = i;
                return this;
            }
        }

        public static d a(ImgType imgType) {
            a aVar = new a();
            aVar.i(imgType);
            return aVar.f();
        }

        public static d b(ImgType imgType, int i) {
            a aVar = new a();
            aVar.i(imgType);
            aVar.j(i);
            return aVar.f();
        }

        public static d c(ImgType imgType, int i, int i2, int i3, int i4) {
            a aVar = new a();
            aVar.i(imgType);
            aVar.h(i);
            aVar.j(i2);
            aVar.g(i3);
            aVar.k(i4);
            return aVar.f();
        }

        public d(a aVar) {
            this.f13412a = aVar.f13417a;
            this.f13413b = aVar.f13418b;
            this.f13414c = aVar.f13419c;
            this.f13415d = aVar.f13420d;
            this.f13416e = aVar.f13421e;
        }
    }

    /* loaded from: classes3.dex */
    public static class e {

        /* renamed from: a  reason: collision with root package name */
        public final String f13422a;

        /* renamed from: b  reason: collision with root package name */
        public final String f13423b;

        /* renamed from: c  reason: collision with root package name */
        public final String f13424c;

        /* renamed from: d  reason: collision with root package name */
        public final int f13425d;

        /* renamed from: e  reason: collision with root package name */
        public final int f13426e;

        /* loaded from: classes3.dex */
        public static class a {

            /* renamed from: a  reason: collision with root package name */
            public String f13427a = null;

            /* renamed from: b  reason: collision with root package name */
            public String f13428b = null;

            /* renamed from: c  reason: collision with root package name */
            public String f13429c = null;

            /* renamed from: d  reason: collision with root package name */
            public int f13430d = -1;

            /* renamed from: e  reason: collision with root package name */
            public int f13431e = 0;

            public e f() {
                return new e(this);
            }

            public a g(String str) {
                this.f13428b = str;
                return this;
            }

            public a h(String str) {
                this.f13427a = str;
                return this;
            }

            public a i(int i) {
                this.f13430d = i;
                return this;
            }
        }

        public static e a(int i) {
            return c(TbadkCoreApplication.getInst().getResources().getString(i));
        }

        public static e b(int i, int i2) {
            return d(TbadkCoreApplication.getInst().getResources().getString(i), TbadkCoreApplication.getInst().getResources().getString(i2));
        }

        public static e c(String str) {
            a aVar = new a();
            aVar.g(str);
            return aVar.f();
        }

        public static e d(String str, String str2) {
            a aVar = new a();
            aVar.g(str);
            aVar.h(str2);
            return aVar.f();
        }

        public static e e(int i, int i2) {
            a aVar = new a();
            aVar.g(TbadkCoreApplication.getInst().getResources().getString(i));
            aVar.i(i2);
            return aVar.f();
        }

        public e(a aVar) {
            this.f13422a = aVar.f13427a;
            this.f13423b = aVar.f13428b;
            this.f13424c = aVar.f13429c;
            this.f13425d = aVar.f13430d;
            this.f13426e = aVar.f13431e;
        }
    }

    public static NoDataView a(Context context, View view, d dVar, e eVar, c cVar) {
        return b(context, view, dVar, eVar, cVar, false);
    }

    public static NoDataView b(Context context, View view, d dVar, e eVar, c cVar, boolean z) {
        NoDataView noDataView = new NoDataView(context);
        noDataView.c(cVar, dVar, eVar);
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
