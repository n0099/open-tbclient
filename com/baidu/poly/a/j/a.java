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
/* loaded from: classes3.dex */
public class a {
    private static volatile a cka;
    private long ckb;
    private com.baidu.poly.a.l.c ckc;
    private com.baidu.poly.widget.c ckd;
    private com.baidu.poly.widget.c cke;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: com.baidu.poly.a.j.a$a  reason: collision with other inner class name */
    /* loaded from: classes3.dex */
    public class C0298a extends com.baidu.poly.a.a.a<JSONObject> {
        final /* synthetic */ m cjV;
        final /* synthetic */ boolean cjW;
        final /* synthetic */ Context cjX;
        final /* synthetic */ Bundle cjY;

        C0298a(m mVar, boolean z, Context context, Bundle bundle) {
            this.cjV = mVar;
            this.cjW = z;
            this.cjX = context;
            this.cjY = bundle;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.poly.a.a.a
        public void a(JSONObject jSONObject) {
            int optInt = jSONObject.optInt("payStatus", 3);
            a.this.c("1", String.valueOf(optInt));
            if (optInt == 2) {
                this.cjV.a(0, com.baidu.poly.util.b.a(0, jSONObject.optString("payOrderNo"), jSONObject.optString("msg")));
            } else if (this.cjW) {
                a.this.a(this.cjX, this.cjY, this.cjV);
            } else {
                a.this.a(this.cjX, this.cjV);
            }
        }

        @Override // com.baidu.poly.a.a.a
        public void a(Throwable th, String str) {
            a.this.c("2", str);
            this.cjV.a("get trade state failed : " + str, (String) null);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes3.dex */
    public class b implements View.OnClickListener {
        final /* synthetic */ m cjV;

        b(m mVar) {
            this.cjV = mVar;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            a.this.ckd.dismiss();
            com.baidu.poly.a.h.d.a(new com.baidu.poly.a.h.b(TbEnum.SystemMessage.EVENT_ID_INTRO_MODIFY).iM("1"));
            this.cjV.a(3, "pay failed , click choose window");
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes3.dex */
    public class c implements View.OnClickListener {
        final /* synthetic */ m cjV;
        final /* synthetic */ Context cjX;
        final /* synthetic */ Bundle cjY;

        c(Context context, Bundle bundle, m mVar) {
            this.cjX = context;
            this.cjY = bundle;
            this.cjV = mVar;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            a.this.ckd.dismiss();
            com.baidu.poly.a.h.d.a(new com.baidu.poly.a.h.b(TbEnum.SystemMessage.EVENT_ID_INTRO_MODIFY).iM("2"));
            a.this.a(this.cjX, this.cjY, this.cjV, false);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes3.dex */
    public class d implements View.OnClickListener {
        d() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (a.this.cke == null || !a.this.cke.isShowing()) {
                return;
            }
            a.this.cke.dismiss();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes3.dex */
    public class e implements c.b {
        final /* synthetic */ m cjV;

        e(m mVar) {
            this.cjV = mVar;
        }

        @Override // com.baidu.poly.widget.c.b
        public void onDismiss() {
            this.cjV.a(3, "pay failed , click error window");
        }
    }

    private a() {
    }

    public static a abN() {
        if (cka == null) {
            synchronized (a.class) {
                if (cka == null) {
                    cka = new a();
                }
            }
        }
        return cka;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c(String str, String str2) {
        com.baidu.poly.a.l.a.a(this.ckc);
        try {
            if (this.ckb != 0) {
                JSONObject jSONObject = new JSONObject();
                if (!TextUtils.isEmpty(str)) {
                    jSONObject.put("rt", str);
                }
                if (!TextUtils.isEmpty(str2)) {
                    jSONObject.put("msg", str2);
                }
                Long valueOf = Long.valueOf(System.currentTimeMillis() - this.ckb);
                if (valueOf.longValue() >= 0) {
                    jSONObject.put("du", String.valueOf(valueOf));
                }
                com.baidu.poly.a.h.d.a(new com.baidu.poly.a.h.b(TbEnum.SystemMessage.EVENT_ID_GROUP_JOIN).ax(jSONObject));
            }
        } catch (JSONException e2) {
            if (com.baidu.poly.util.d.ckJ) {
                e2.printStackTrace();
            }
        } finally {
            this.ckb = 0L;
        }
    }

    public void a(Context context, Bundle bundle, m mVar, boolean z) {
        if (context != null && bundle != null && mVar != null) {
            FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-2, -2);
            layoutParams.gravity = 17;
            this.ckc = com.baidu.poly.a.l.a.a((ViewGroup) a((Activity) context), layoutParams, (String) null, -1L);
            this.ckb = System.currentTimeMillis();
            com.baidu.poly.a.b.b.abv().c(bundle, new C0298a(mVar, z, context, bundle));
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
        this.ckd = new com.baidu.poly.widget.c(inflate, -1, -1, true);
        this.ckd.ee(false);
        this.ckd.ed(false);
        ((TextView) inflate.findViewById(b.e.bt_pay_meet_problems)).setOnClickListener(new b(mVar));
        ((TextView) inflate.findViewById(b.e.bt_pay_already_finish)).setOnClickListener(new c(context, bundle, mVar));
        this.ckd.showAtLocation(((Activity) context).getWindow().getDecorView(), 0, 0, 0);
        com.baidu.poly.a.h.d.a(new com.baidu.poly.a.h.b(TbEnum.SystemMessage.EVENT_ID_NOTICE_MODIFY));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(Context context, m mVar) {
        View inflate = View.inflate(mVar.getContext(), b.f.default_pop_window, null);
        ((TextView) inflate.findViewById(b.e.pop_title)).setText(b.g.pay_failed);
        ((TextView) inflate.findViewById(b.e.pop_tips)).setText(b.g.pay_failed_sub_text);
        this.cke = new com.baidu.poly.widget.c(inflate, -1, -1, true);
        this.cke.ee(false);
        this.cke.ed(false);
        this.cke.setBackgroundDrawable(new ColorDrawable(0));
        ((TextView) inflate.findViewById(b.e.pop_button)).setOnClickListener(new d());
        this.cke.a(new e(mVar));
        this.cke.showAtLocation(((Activity) context).getWindow().getDecorView(), 0, 0, 0);
    }
}
