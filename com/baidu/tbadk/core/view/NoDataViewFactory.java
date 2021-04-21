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
        public View.OnClickListener f13074a;

        /* renamed from: b  reason: collision with root package name */
        public String f13075b;

        public b(String str, View.OnClickListener onClickListener) {
            this.f13075b = str;
            this.f13074a = onClickListener;
        }
    }

    /* loaded from: classes3.dex */
    public static class c {

        /* renamed from: a  reason: collision with root package name */
        public final b f13076a;

        /* renamed from: b  reason: collision with root package name */
        public final b f13077b;

        /* renamed from: c  reason: collision with root package name */
        public final int f13078c;

        /* loaded from: classes3.dex */
        public static class a {

            /* renamed from: a  reason: collision with root package name */
            public b f13079a = null;

            /* renamed from: b  reason: collision with root package name */
            public b f13080b = null;

            /* renamed from: c  reason: collision with root package name */
            public int f13081c = -1;

            public a d(int i) {
                this.f13081c = i;
                return this;
            }

            public c e() {
                return new c(this);
            }

            public a f(b bVar) {
                this.f13079a = bVar;
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
            this.f13076a = aVar.f13079a;
            this.f13077b = aVar.f13080b;
            this.f13078c = aVar.f13081c;
        }
    }

    /* loaded from: classes3.dex */
    public static class d {

        /* renamed from: a  reason: collision with root package name */
        public final ImgType f13082a;

        /* renamed from: b  reason: collision with root package name */
        public final int f13083b;

        /* renamed from: c  reason: collision with root package name */
        public final int f13084c;

        /* renamed from: d  reason: collision with root package name */
        public final int f13085d;

        /* renamed from: e  reason: collision with root package name */
        public final int f13086e;

        /* loaded from: classes3.dex */
        public static class a {

            /* renamed from: a  reason: collision with root package name */
            public ImgType f13087a = ImgType.NONE;

            /* renamed from: b  reason: collision with root package name */
            public int f13088b = -1;

            /* renamed from: c  reason: collision with root package name */
            public int f13089c = -1;

            /* renamed from: d  reason: collision with root package name */
            public int f13090d = -1;

            /* renamed from: e  reason: collision with root package name */
            public int f13091e = -1;

            public d f() {
                return new d(this);
            }

            public a g(int i) {
                this.f13090d = i;
                return this;
            }

            public a h(int i) {
                this.f13089c = i;
                return this;
            }

            public a i(ImgType imgType) {
                this.f13087a = imgType;
                return this;
            }

            public a j(int i) {
                this.f13088b = i;
                return this;
            }

            public a k(int i) {
                this.f13091e = i;
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
            this.f13082a = aVar.f13087a;
            this.f13083b = aVar.f13088b;
            this.f13084c = aVar.f13089c;
            this.f13085d = aVar.f13090d;
            this.f13086e = aVar.f13091e;
        }
    }

    /* loaded from: classes3.dex */
    public static class e {

        /* renamed from: a  reason: collision with root package name */
        public final String f13092a;

        /* renamed from: b  reason: collision with root package name */
        public final String f13093b;

        /* renamed from: c  reason: collision with root package name */
        public final String f13094c;

        /* renamed from: d  reason: collision with root package name */
        public final int f13095d;

        /* renamed from: e  reason: collision with root package name */
        public final int f13096e;

        /* loaded from: classes3.dex */
        public static class a {

            /* renamed from: a  reason: collision with root package name */
            public String f13097a = null;

            /* renamed from: b  reason: collision with root package name */
            public String f13098b = null;

            /* renamed from: c  reason: collision with root package name */
            public String f13099c = null;

            /* renamed from: d  reason: collision with root package name */
            public int f13100d = -1;

            /* renamed from: e  reason: collision with root package name */
            public int f13101e = 0;

            public e f() {
                return new e(this);
            }

            public a g(String str) {
                this.f13098b = str;
                return this;
            }

            public a h(String str) {
                this.f13097a = str;
                return this;
            }

            public a i(int i) {
                this.f13100d = i;
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
            this.f13092a = aVar.f13097a;
            this.f13093b = aVar.f13098b;
            this.f13094c = aVar.f13099c;
            this.f13095d = aVar.f13100d;
            this.f13096e = aVar.f13101e;
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
