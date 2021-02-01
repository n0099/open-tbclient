package com.baidu.poly.a.j;

import android.app.Activity;
import android.content.Context;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.TextView;
import com.baidu.live.tbadk.core.util.TbEnum;
import com.baidu.poly.b;
import com.baidu.poly.widget.c;
import com.baidu.poly.widget.m;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes4.dex */
public class a {
    private static volatile a cor;
    private long cos;
    private com.baidu.poly.a.l.c cot;
    private com.baidu.poly.widget.c cou;
    private com.baidu.poly.widget.c cov;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: com.baidu.poly.a.j.a$a  reason: collision with other inner class name */
    /* loaded from: classes4.dex */
    public class C0302a extends com.baidu.poly.a.a.a<JSONObject> {
        final /* synthetic */ m col;

        /* renamed from: com  reason: collision with root package name */
        final /* synthetic */ boolean f4501com;
        final /* synthetic */ Context coo;
        final /* synthetic */ Bundle cop;

        C0302a(m mVar, boolean z, Context context, Bundle bundle) {
            this.col = mVar;
            this.f4501com = z;
            this.coo = context;
            this.cop = bundle;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.poly.a.a.a
        public void a(JSONObject jSONObject) {
            int optInt = jSONObject.optInt("payStatus", 3);
            a.this.c("1", String.valueOf(optInt));
            if (optInt == 2) {
                this.col.a(0, com.baidu.poly.util.b.a(0, jSONObject.optString("payOrderNo"), jSONObject.optString("msg")));
            } else if (this.f4501com) {
                a.this.a(this.coo, this.cop, this.col);
            } else {
                a.this.a(this.coo, this.col);
            }
        }

        @Override // com.baidu.poly.a.a.a
        public void a(Throwable th, String str) {
            a.this.c("2", str);
            this.col.a("get trade state failed : " + str, (String) null);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes4.dex */
    public class b implements View.OnClickListener {
        final /* synthetic */ m col;

        b(m mVar) {
            this.col = mVar;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            a.this.cou.dismiss();
            com.baidu.poly.a.h.d.a(new com.baidu.poly.a.h.b("103").jr("1"));
            this.col.a(3, "pay failed , click choose window");
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes4.dex */
    public class c implements View.OnClickListener {
        final /* synthetic */ m col;
        final /* synthetic */ Context coo;
        final /* synthetic */ Bundle cop;

        c(Context context, Bundle bundle, m mVar) {
            this.coo = context;
            this.cop = bundle;
            this.col = mVar;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            a.this.cou.dismiss();
            com.baidu.poly.a.h.d.a(new com.baidu.poly.a.h.b("103").jr("2"));
            a.this.a(this.coo, this.cop, this.col, false);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes4.dex */
    public class d implements View.OnClickListener {
        d() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (a.this.cov == null || !a.this.cov.isShowing()) {
                return;
            }
            a.this.cov.dismiss();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes4.dex */
    public class e implements c.b {
        final /* synthetic */ m col;

        e(m mVar) {
            this.col = mVar;
        }

        @Override // com.baidu.poly.widget.c.b
        public void onDismiss() {
            this.col.a(3, "pay failed , click error window");
        }
    }

    private a() {
    }

    public static a adB() {
        if (cor == null) {
            synchronized (a.class) {
                if (cor == null) {
                    cor = new a();
                }
            }
        }
        return cor;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c(String str, String str2) {
        com.baidu.poly.a.l.a.a(this.cot);
        try {
            if (this.cos != 0) {
                JSONObject jSONObject = new JSONObject();
                if (!TextUtils.isEmpty(str)) {
                    jSONObject.put("rt", str);
                }
                if (!TextUtils.isEmpty(str2)) {
                    jSONObject.put("msg", str2);
                }
                Long valueOf = Long.valueOf(System.currentTimeMillis() - this.cos);
                if (valueOf.longValue() >= 0) {
                    jSONObject.put("du", String.valueOf(valueOf));
                }
                com.baidu.poly.a.h.d.a(new com.baidu.poly.a.h.b(TbEnum.SystemMessage.EVENT_ID_GROUP_JOIN).az(jSONObject));
            }
        } catch (JSONException e2) {
            if (com.baidu.poly.util.d.cpa) {
                e2.printStackTrace();
            }
        } finally {
            this.cos = 0L;
        }
    }

    public void a(Context context, Bundle bundle, m mVar, boolean z) {
        if (context != null && bundle != null && mVar != null) {
            FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-2, -2);
            layoutParams.gravity = 17;
            this.cot = com.baidu.poly.a.l.a.a((ViewGroup) a((Activity) context), layoutParams, (String) null, -1L);
            this.cos = System.currentTimeMillis();
            com.baidu.poly.a.b.b.adj().c(bundle, new C0302a(mVar, z, context, bundle));
        }
    }

    private View a(Activity activity) {
        if (activity == null || activity.getWindow() == null) {
            return null;
        }
        return activity.getWindow().getDecorView().findViewById(16908290);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(Context context, Bundle bundle, m mVar) {
        View inflate = View.inflate(mVar.getContext(), b.f.pay_confirm, null);
        this.cou = new com.baidu.poly.widget.c(inflate, -1, -1, true);
        this.cou.eo(false);
        this.cou.en(false);
        ((TextView) inflate.findViewById(b.e.bt_pay_meet_problems)).setOnClickListener(new b(mVar));
        ((TextView) inflate.findViewById(b.e.bt_pay_already_finish)).setOnClickListener(new c(context, bundle, mVar));
        this.cou.showAtLocation(((Activity) context).getWindow().getDecorView(), 0, 0, 0);
        com.baidu.poly.a.h.d.a(new com.baidu.poly.a.h.b("102"));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(Context context, m mVar) {
        View inflate = View.inflate(mVar.getContext(), b.f.default_pop_window, null);
        ((TextView) inflate.findViewById(b.e.pop_title)).setText(b.g.pay_failed);
        ((TextView) inflate.findViewById(b.e.pop_tips)).setText(b.g.pay_failed_sub_text);
        this.cov = new com.baidu.poly.widget.c(inflate, -1, -1, true);
        this.cov.eo(false);
        this.cov.en(false);
        this.cov.setBackgroundDrawable(new ColorDrawable(0));
        ((TextView) inflate.findViewById(b.e.pop_button)).setOnClickListener(new d());
        this.cov.a(new e(mVar));
        this.cov.showAtLocation(((Activity) context).getWindow().getDecorView(), 0, 0, 0);
    }
}
