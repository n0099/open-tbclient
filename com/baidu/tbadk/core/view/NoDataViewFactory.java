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
        public View.OnClickListener f13405a;

        /* renamed from: b  reason: collision with root package name */
        public String f13406b;

        public b(String str, View.OnClickListener onClickListener) {
            this.f13406b = str;
            this.f13405a = onClickListener;
        }
    }

    /* loaded from: classes3.dex */
    public static class c {

        /* renamed from: a  reason: collision with root package name */
        public final b f13407a;

        /* renamed from: b  reason: collision with root package name */
        public final b f13408b;

        /* renamed from: c  reason: collision with root package name */
        public final int f13409c;

        /* loaded from: classes3.dex */
        public static class a {

            /* renamed from: a  reason: collision with root package name */
            public b f13410a = null;

            /* renamed from: b  reason: collision with root package name */
            public b f13411b = null;

            /* renamed from: c  reason: collision with root package name */
            public int f13412c = -1;

            public a d(int i) {
                this.f13412c = i;
                return this;
            }

            public c e() {
                return new c(this);
            }

            public a f(b bVar) {
                this.f13410a = bVar;
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
            this.f13407a = aVar.f13410a;
            this.f13408b = aVar.f13411b;
            this.f13409c = aVar.f13412c;
        }
    }

    /* loaded from: classes3.dex */
    public static class d {

        /* renamed from: a  reason: collision with root package name */
        public final ImgType f13413a;

        /* renamed from: b  reason: collision with root package name */
        public final int f13414b;

        /* renamed from: c  reason: collision with root package name */
        public final int f13415c;

        /* renamed from: d  reason: collision with root package name */
        public final int f13416d;

        /* renamed from: e  reason: collision with root package name */
        public final int f13417e;

        /* loaded from: classes3.dex */
        public static class a {

            /* renamed from: a  reason: collision with root package name */
            public ImgType f13418a = ImgType.NONE;

            /* renamed from: b  reason: collision with root package name */
            public int f13419b = -1;

            /* renamed from: c  reason: collision with root package name */
            public int f13420c = -1;

            /* renamed from: d  reason: collision with root package name */
            public int f13421d = -1;

            /* renamed from: e  reason: collision with root package name */
            public int f13422e = -1;

            public d f() {
                return new d(this);
            }

            public a g(int i) {
                this.f13421d = i;
                return this;
            }

            public a h(int i) {
                this.f13420c = i;
                return this;
            }

            public a i(ImgType imgType) {
                this.f13418a = imgType;
                return this;
            }

            public a j(int i) {
                this.f13419b = i;
                return this;
            }

            public a k(int i) {
                this.f13422e = i;
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
            this.f13413a = aVar.f13418a;
            this.f13414b = aVar.f13419b;
            this.f13415c = aVar.f13420c;
            this.f13416d = aVar.f13421d;
            this.f13417e = aVar.f13422e;
        }
    }

    /* loaded from: classes3.dex */
    public static class e {

        /* renamed from: a  reason: collision with root package name */
        public final String f13423a;

        /* renamed from: b  reason: collision with root package name */
        public final String f13424b;

        /* renamed from: c  reason: collision with root package name */
        public final String f13425c;

        /* renamed from: d  reason: collision with root package name */
        public final int f13426d;

        /* renamed from: e  reason: collision with root package name */
        public final int f13427e;

        /* loaded from: classes3.dex */
        public static class a {

            /* renamed from: a  reason: collision with root package name */
            public String f13428a = null;

            /* renamed from: b  reason: collision with root package name */
            public String f13429b = null;

            /* renamed from: c  reason: collision with root package name */
            public String f13430c = null;

            /* renamed from: d  reason: collision with root package name */
            public int f13431d = -1;

            /* renamed from: e  reason: collision with root package name */
            public int f13432e = 0;

            public e f() {
                return new e(this);
            }

            public a g(String str) {
                this.f13429b = str;
                return this;
            }

            public a h(String str) {
                this.f13428a = str;
                return this;
            }

            public a i(int i) {
                this.f13431d = i;
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
            this.f13423a = aVar.f13428a;
            this.f13424b = aVar.f13429b;
            this.f13425c = aVar.f13430c;
            this.f13426d = aVar.f13431d;
            this.f13427e = aVar.f13432e;
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
