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
/* loaded from: classes14.dex */
public class a {
    private static volatile a cpT;
    private long cpU;
    private com.baidu.poly.a.l.c cpV;
    private com.baidu.poly.widget.c cpW;
    private com.baidu.poly.widget.c cpX;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: com.baidu.poly.a.j.a$a  reason: collision with other inner class name */
    /* loaded from: classes14.dex */
    public class C0308a extends com.baidu.poly.a.a.a<JSONObject> {
        final /* synthetic */ m cpO;
        final /* synthetic */ boolean cpP;
        final /* synthetic */ Context cpQ;
        final /* synthetic */ Bundle cpR;

        C0308a(m mVar, boolean z, Context context, Bundle bundle) {
            this.cpO = mVar;
            this.cpP = z;
            this.cpQ = context;
            this.cpR = bundle;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.poly.a.a.a
        public void a(JSONObject jSONObject) {
            int optInt = jSONObject.optInt("payStatus", 3);
            a.this.c("1", String.valueOf(optInt));
            if (optInt == 2) {
                this.cpO.a(0, com.baidu.poly.util.b.a(0, jSONObject.optString("payOrderNo"), jSONObject.optString("msg")));
            } else if (this.cpP) {
                a.this.a(this.cpQ, this.cpR, this.cpO);
            } else {
                a.this.a(this.cpQ, this.cpO);
            }
        }

        @Override // com.baidu.poly.a.a.a
        public void a(Throwable th, String str) {
            a.this.c("2", str);
            this.cpO.a("get trade state failed : " + str, (String) null);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes14.dex */
    public class b implements View.OnClickListener {
        final /* synthetic */ m cpO;

        b(m mVar) {
            this.cpO = mVar;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            a.this.cpW.dismiss();
            com.baidu.poly.a.h.d.a(new com.baidu.poly.a.h.b("103").jx("1"));
            this.cpO.a(3, "pay failed , click choose window");
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes14.dex */
    public class c implements View.OnClickListener {
        final /* synthetic */ m cpO;
        final /* synthetic */ Context cpQ;
        final /* synthetic */ Bundle cpR;

        c(Context context, Bundle bundle, m mVar) {
            this.cpQ = context;
            this.cpR = bundle;
            this.cpO = mVar;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            a.this.cpW.dismiss();
            com.baidu.poly.a.h.d.a(new com.baidu.poly.a.h.b("103").jx("2"));
            a.this.a(this.cpQ, this.cpR, this.cpO, false);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes14.dex */
    public class d implements View.OnClickListener {
        d() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (a.this.cpX == null || !a.this.cpX.isShowing()) {
                return;
            }
            a.this.cpX.dismiss();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes14.dex */
    public class e implements c.b {
        final /* synthetic */ m cpO;

        e(m mVar) {
            this.cpO = mVar;
        }

        @Override // com.baidu.poly.widget.c.b
        public void onDismiss() {
            this.cpO.a(3, "pay failed , click error window");
        }
    }

    private a() {
    }

    public static a adE() {
        if (cpT == null) {
            synchronized (a.class) {
                if (cpT == null) {
                    cpT = new a();
                }
            }
        }
        return cpT;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c(String str, String str2) {
        com.baidu.poly.a.l.a.a(this.cpV);
        try {
            if (this.cpU != 0) {
                JSONObject jSONObject = new JSONObject();
                if (!TextUtils.isEmpty(str)) {
                    jSONObject.put("rt", str);
                }
                if (!TextUtils.isEmpty(str2)) {
                    jSONObject.put("msg", str2);
                }
                Long valueOf = Long.valueOf(System.currentTimeMillis() - this.cpU);
                if (valueOf.longValue() >= 0) {
                    jSONObject.put("du", String.valueOf(valueOf));
                }
                com.baidu.poly.a.h.d.a(new com.baidu.poly.a.h.b(TbEnum.SystemMessage.EVENT_ID_GROUP_JOIN).aB(jSONObject));
            }
        } catch (JSONException e2) {
            if (com.baidu.poly.util.d.cqC) {
                e2.printStackTrace();
            }
        } finally {
            this.cpU = 0L;
        }
    }

    public void a(Context context, Bundle bundle, m mVar, boolean z) {
        if (context != null && bundle != null && mVar != null) {
            FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-2, -2);
            layoutParams.gravity = 17;
            this.cpV = com.baidu.poly.a.l.a.a((ViewGroup) a((Activity) context), layoutParams, (String) null, -1L);
            this.cpU = System.currentTimeMillis();
            com.baidu.poly.a.b.b.adm().c(bundle, new C0308a(mVar, z, context, bundle));
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
        this.cpW = new com.baidu.poly.widget.c(inflate, -1, -1, true);
        this.cpW.eo(false);
        this.cpW.en(false);
        ((TextView) inflate.findViewById(b.e.bt_pay_meet_problems)).setOnClickListener(new b(mVar));
        ((TextView) inflate.findViewById(b.e.bt_pay_already_finish)).setOnClickListener(new c(context, bundle, mVar));
        this.cpW.showAtLocation(((Activity) context).getWindow().getDecorView(), 0, 0, 0);
        com.baidu.poly.a.h.d.a(new com.baidu.poly.a.h.b("102"));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(Context context, m mVar) {
        View inflate = View.inflate(mVar.getContext(), b.f.default_pop_window, null);
        ((TextView) inflate.findViewById(b.e.pop_title)).setText(b.g.pay_failed);
        ((TextView) inflate.findViewById(b.e.pop_tips)).setText(b.g.pay_failed_sub_text);
        this.cpX = new com.baidu.poly.widget.c(inflate, -1, -1, true);
        this.cpX.eo(false);
        this.cpX.en(false);
        this.cpX.setBackgroundDrawable(new ColorDrawable(0));
        ((TextView) inflate.findViewById(b.e.pop_button)).setOnClickListener(new d());
        this.cpX.a(new e(mVar));
        this.cpX.showAtLocation(((Activity) context).getWindow().getDecorView(), 0, 0, 0);
    }
}
