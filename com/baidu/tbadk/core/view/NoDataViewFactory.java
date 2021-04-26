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
        public View.OnClickListener f13012a;

        /* renamed from: b  reason: collision with root package name */
        public String f13013b;

        public b(String str, View.OnClickListener onClickListener) {
            this.f13013b = str;
            this.f13012a = onClickListener;
        }
    }

    /* loaded from: classes3.dex */
    public static class c {

        /* renamed from: a  reason: collision with root package name */
        public final b f13014a;

        /* renamed from: b  reason: collision with root package name */
        public final b f13015b;

        /* renamed from: c  reason: collision with root package name */
        public final int f13016c;

        /* loaded from: classes3.dex */
        public static class a {

            /* renamed from: a  reason: collision with root package name */
            public b f13017a = null;

            /* renamed from: b  reason: collision with root package name */
            public b f13018b = null;

            /* renamed from: c  reason: collision with root package name */
            public int f13019c = -1;

            public a d(int i2) {
                this.f13019c = i2;
                return this;
            }

            public c e() {
                return new c(this);
            }

            public a f(b bVar) {
                this.f13017a = bVar;
                return this;
            }
        }

        public static c a(b bVar) {
            a aVar = new a();
            aVar.f(bVar);
            return aVar.e();
        }

        public static c b(b bVar, int i2) {
            a aVar = new a();
            aVar.f(bVar);
            aVar.d(i2);
            return aVar.e();
        }

        public c(a aVar) {
            this.f13014a = aVar.f13017a;
            this.f13015b = aVar.f13018b;
            this.f13016c = aVar.f13019c;
        }
    }

    /* loaded from: classes3.dex */
    public static class d {

        /* renamed from: a  reason: collision with root package name */
        public final ImgType f13020a;

        /* renamed from: b  reason: collision with root package name */
        public final int f13021b;

        /* renamed from: c  reason: collision with root package name */
        public final int f13022c;

        /* renamed from: d  reason: collision with root package name */
        public final int f13023d;

        /* renamed from: e  reason: collision with root package name */
        public final int f13024e;

        /* loaded from: classes3.dex */
        public static class a {

            /* renamed from: a  reason: collision with root package name */
            public ImgType f13025a = ImgType.NONE;

            /* renamed from: b  reason: collision with root package name */
            public int f13026b = -1;

            /* renamed from: c  reason: collision with root package name */
            public int f13027c = -1;

            /* renamed from: d  reason: collision with root package name */
            public int f13028d = -1;

            /* renamed from: e  reason: collision with root package name */
            public int f13029e = -1;

            public d f() {
                return new d(this);
            }

            public a g(int i2) {
                this.f13028d = i2;
                return this;
            }

            public a h(int i2) {
                this.f13027c = i2;
                return this;
            }

            public a i(ImgType imgType) {
                this.f13025a = imgType;
                return this;
            }

            public a j(int i2) {
                this.f13026b = i2;
                return this;
            }

            public a k(int i2) {
                this.f13029e = i2;
                return this;
            }
        }

        public static d a(ImgType imgType) {
            a aVar = new a();
            aVar.i(imgType);
            return aVar.f();
        }

        public static d b(ImgType imgType, int i2) {
            a aVar = new a();
            aVar.i(imgType);
            aVar.j(i2);
            return aVar.f();
        }

        public static d c(ImgType imgType, int i2, int i3, int i4, int i5) {
            a aVar = new a();
            aVar.i(imgType);
            aVar.h(i2);
            aVar.j(i3);
            aVar.g(i4);
            aVar.k(i5);
            return aVar.f();
        }

        public d(a aVar) {
            this.f13020a = aVar.f13025a;
            this.f13021b = aVar.f13026b;
            this.f13022c = aVar.f13027c;
            this.f13023d = aVar.f13028d;
            this.f13024e = aVar.f13029e;
        }
    }

    /* loaded from: classes3.dex */
    public static class e {

        /* renamed from: a  reason: collision with root package name */
        public final String f13030a;

        /* renamed from: b  reason: collision with root package name */
        public final String f13031b;

        /* renamed from: c  reason: collision with root package name */
        public final String f13032c;

        /* renamed from: d  reason: collision with root package name */
        public final int f13033d;

        /* renamed from: e  reason: collision with root package name */
        public final int f13034e;

        /* loaded from: classes3.dex */
        public static class a {

            /* renamed from: a  reason: collision with root package name */
            public String f13035a = null;

            /* renamed from: b  reason: collision with root package name */
            public String f13036b = null;

            /* renamed from: c  reason: collision with root package name */
            public String f13037c = null;

            /* renamed from: d  reason: collision with root package name */
            public int f13038d = -1;

            /* renamed from: e  reason: collision with root package name */
            public int f13039e = 0;

            public e f() {
                return new e(this);
            }

            public a g(String str) {
                this.f13036b = str;
                return this;
            }

            public a h(String str) {
                this.f13035a = str;
                return this;
            }

            public a i(int i2) {
                this.f13038d = i2;
                return this;
            }
        }

        public static e a(int i2) {
            return c(TbadkCoreApplication.getInst().getResources().getString(i2));
        }

        public static e b(int i2, int i3) {
            return d(TbadkCoreApplication.getInst().getResources().getString(i2), TbadkCoreApplication.getInst().getResources().getString(i3));
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

        public static e e(int i2, int i3) {
            a aVar = new a();
            aVar.g(TbadkCoreApplication.getInst().getResources().getString(i2));
            aVar.i(i3);
            return aVar.f();
        }

        public e(a aVar) {
            this.f13030a = aVar.f13035a;
            this.f13031b = aVar.f13036b;
            this.f13032c = aVar.f13037c;
            this.f13033d = aVar.f13038d;
            this.f13034e = aVar.f13039e;
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
