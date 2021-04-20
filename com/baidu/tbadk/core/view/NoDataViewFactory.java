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
        public View.OnClickListener f13066a;

        /* renamed from: b  reason: collision with root package name */
        public String f13067b;

        public b(String str, View.OnClickListener onClickListener) {
            this.f13067b = str;
            this.f13066a = onClickListener;
        }
    }

    /* loaded from: classes3.dex */
    public static class c {

        /* renamed from: a  reason: collision with root package name */
        public final b f13068a;

        /* renamed from: b  reason: collision with root package name */
        public final b f13069b;

        /* renamed from: c  reason: collision with root package name */
        public final int f13070c;

        /* loaded from: classes3.dex */
        public static class a {

            /* renamed from: a  reason: collision with root package name */
            public b f13071a = null;

            /* renamed from: b  reason: collision with root package name */
            public b f13072b = null;

            /* renamed from: c  reason: collision with root package name */
            public int f13073c = -1;

            public a d(int i) {
                this.f13073c = i;
                return this;
            }

            public c e() {
                return new c(this);
            }

            public a f(b bVar) {
                this.f13071a = bVar;
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
            this.f13068a = aVar.f13071a;
            this.f13069b = aVar.f13072b;
            this.f13070c = aVar.f13073c;
        }
    }

    /* loaded from: classes3.dex */
    public static class d {

        /* renamed from: a  reason: collision with root package name */
        public final ImgType f13074a;

        /* renamed from: b  reason: collision with root package name */
        public final int f13075b;

        /* renamed from: c  reason: collision with root package name */
        public final int f13076c;

        /* renamed from: d  reason: collision with root package name */
        public final int f13077d;

        /* renamed from: e  reason: collision with root package name */
        public final int f13078e;

        /* loaded from: classes3.dex */
        public static class a {

            /* renamed from: a  reason: collision with root package name */
            public ImgType f13079a = ImgType.NONE;

            /* renamed from: b  reason: collision with root package name */
            public int f13080b = -1;

            /* renamed from: c  reason: collision with root package name */
            public int f13081c = -1;

            /* renamed from: d  reason: collision with root package name */
            public int f13082d = -1;

            /* renamed from: e  reason: collision with root package name */
            public int f13083e = -1;

            public d f() {
                return new d(this);
            }

            public a g(int i) {
                this.f13082d = i;
                return this;
            }

            public a h(int i) {
                this.f13081c = i;
                return this;
            }

            public a i(ImgType imgType) {
                this.f13079a = imgType;
                return this;
            }

            public a j(int i) {
                this.f13080b = i;
                return this;
            }

            public a k(int i) {
                this.f13083e = i;
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
            this.f13074a = aVar.f13079a;
            this.f13075b = aVar.f13080b;
            this.f13076c = aVar.f13081c;
            this.f13077d = aVar.f13082d;
            this.f13078e = aVar.f13083e;
        }
    }

    /* loaded from: classes3.dex */
    public static class e {

        /* renamed from: a  reason: collision with root package name */
        public final String f13084a;

        /* renamed from: b  reason: collision with root package name */
        public final String f13085b;

        /* renamed from: c  reason: collision with root package name */
        public final String f13086c;

        /* renamed from: d  reason: collision with root package name */
        public final int f13087d;

        /* renamed from: e  reason: collision with root package name */
        public final int f13088e;

        /* loaded from: classes3.dex */
        public static class a {

            /* renamed from: a  reason: collision with root package name */
            public String f13089a = null;

            /* renamed from: b  reason: collision with root package name */
            public String f13090b = null;

            /* renamed from: c  reason: collision with root package name */
            public String f13091c = null;

            /* renamed from: d  reason: collision with root package name */
            public int f13092d = -1;

            /* renamed from: e  reason: collision with root package name */
            public int f13093e = 0;

            public e f() {
                return new e(this);
            }

            public a g(String str) {
                this.f13090b = str;
                return this;
            }

            public a h(String str) {
                this.f13089a = str;
                return this;
            }

            public a i(int i) {
                this.f13092d = i;
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
            this.f13084a = aVar.f13089a;
            this.f13085b = aVar.f13090b;
            this.f13086c = aVar.f13091c;
            this.f13087d = aVar.f13092d;
            this.f13088e = aVar.f13093e;
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
