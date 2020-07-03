package com.baidu.poly.a.i;

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
/* loaded from: classes11.dex */
public class a {
    private static volatile a bAh;
    private long anr;
    private com.baidu.poly.a.k.c bAi;
    private com.baidu.poly.widget.c bAj;
    private com.baidu.poly.widget.c bAk;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: com.baidu.poly.a.i.a$a  reason: collision with other inner class name */
    /* loaded from: classes11.dex */
    public class C0243a extends com.baidu.poly.a.a.a<JSONObject> {
        final /* synthetic */ m bAc;
        final /* synthetic */ boolean bAd;
        final /* synthetic */ Context bAe;
        final /* synthetic */ Bundle bAf;

        C0243a(m mVar, boolean z, Context context, Bundle bundle) {
            this.bAc = mVar;
            this.bAd = z;
            this.bAe = context;
            this.bAf = bundle;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.poly.a.a.a
        public void a(JSONObject jSONObject) {
            int optInt = jSONObject.optInt("payStatus", 3);
            a.this.c("1", String.valueOf(optInt));
            if (optInt == 2) {
                this.bAc.a(0, com.baidu.poly.util.b.a(0, jSONObject.optString("payOrderNo"), jSONObject.optString("msg")));
            } else if (this.bAd) {
                a.this.a(this.bAe, this.bAf, this.bAc);
            } else {
                a.this.a(this.bAe, this.bAc);
            }
        }

        @Override // com.baidu.poly.a.a.a
        public void a(Throwable th, String str) {
            a.this.c("2", str);
            this.bAc.a("get trade state failed : " + str, (String) null);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes11.dex */
    public class b implements View.OnClickListener {
        final /* synthetic */ m bAc;

        b(m mVar) {
            this.bAc = mVar;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            a.this.bAj.dismiss();
            com.baidu.poly.a.g.d.a(new com.baidu.poly.a.g.b(TbEnum.SystemMessage.EVENT_ID_INTRO_MODIFY).gF("1"));
            this.bAc.a(3, "pay failed , click choose window");
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes11.dex */
    public class c implements View.OnClickListener {
        final /* synthetic */ m bAc;
        final /* synthetic */ Context bAe;
        final /* synthetic */ Bundle bAf;

        c(Context context, Bundle bundle, m mVar) {
            this.bAe = context;
            this.bAf = bundle;
            this.bAc = mVar;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            a.this.bAj.dismiss();
            com.baidu.poly.a.g.d.a(new com.baidu.poly.a.g.b(TbEnum.SystemMessage.EVENT_ID_INTRO_MODIFY).gF("2"));
            a.this.a(this.bAe, this.bAf, this.bAc, false);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes11.dex */
    public class d implements View.OnClickListener {
        d() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (a.this.bAk == null || !a.this.bAk.isShowing()) {
                return;
            }
            a.this.bAk.dismiss();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes11.dex */
    public class e implements c.b {
        final /* synthetic */ m bAc;

        e(m mVar) {
            this.bAc = mVar;
        }

        @Override // com.baidu.poly.widget.c.b
        public void onDismiss() {
            this.bAc.a(3, "pay failed , click error window");
        }
    }

    private a() {
    }

    public static a Ol() {
        if (bAh == null) {
            synchronized (a.class) {
                if (bAh == null) {
                    bAh = new a();
                }
            }
        }
        return bAh;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c(String str, String str2) {
        com.baidu.poly.a.k.a.a(this.bAi);
        try {
            if (this.anr != 0) {
                JSONObject jSONObject = new JSONObject();
                if (!TextUtils.isEmpty(str)) {
                    jSONObject.put("rt", str);
                }
                if (!TextUtils.isEmpty(str2)) {
                    jSONObject.put("msg", str2);
                }
                Long valueOf = Long.valueOf(System.currentTimeMillis() - this.anr);
                if (valueOf.longValue() >= 0) {
                    jSONObject.put("du", String.valueOf(valueOf));
                }
                com.baidu.poly.a.g.d.a(new com.baidu.poly.a.g.b(TbEnum.SystemMessage.EVENT_ID_GROUP_JOIN).ab(jSONObject));
            }
        } catch (JSONException e2) {
            if (com.baidu.poly.util.d.bAO) {
                e2.printStackTrace();
            }
        } finally {
            this.anr = 0L;
        }
    }

    public void a(Context context, Bundle bundle, m mVar, boolean z) {
        if (context != null && bundle != null && mVar != null) {
            FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-2, -2);
            layoutParams.gravity = 17;
            this.bAi = com.baidu.poly.a.k.a.a((ViewGroup) a((Activity) context), layoutParams, (String) null, -1L);
            this.anr = System.currentTimeMillis();
            com.baidu.poly.a.b.a.NU().c(bundle, new C0243a(mVar, z, context, bundle));
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
        this.bAj = new com.baidu.poly.widget.c(inflate, -1, -1, true);
        this.bAj.setClippingEnabled(false);
        this.bAj.setOutsideTouchable(false);
        ((TextView) inflate.findViewById(b.e.bt_pay_meet_problems)).setOnClickListener(new b(mVar));
        ((TextView) inflate.findViewById(b.e.bt_pay_already_finish)).setOnClickListener(new c(context, bundle, mVar));
        this.bAj.showAtLocation(((Activity) context).getWindow().getDecorView(), 0, 0, 0);
        com.baidu.poly.a.g.d.a(new com.baidu.poly.a.g.b(TbEnum.SystemMessage.EVENT_ID_NOTICE_MODIFY));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(Context context, m mVar) {
        View inflate = View.inflate(mVar.getContext(), b.f.default_pop_window, null);
        ((TextView) inflate.findViewById(b.e.pop_title)).setText(b.g.pay_failed);
        ((TextView) inflate.findViewById(b.e.pop_tips)).setText(b.g.pay_failed_sub_text);
        this.bAk = new com.baidu.poly.widget.c(inflate, -1, -1, true);
        this.bAk.setClippingEnabled(false);
        this.bAk.setOutsideTouchable(false);
        this.bAk.setBackgroundDrawable(new ColorDrawable(0));
        ((TextView) inflate.findViewById(b.e.pop_button)).setOnClickListener(new d());
        this.bAk.a(new e(mVar));
        this.bAk.showAtLocation(((Activity) context).getWindow().getDecorView(), 0, 0, 0);
    }
}
