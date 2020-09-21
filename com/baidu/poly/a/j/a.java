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
/* loaded from: classes9.dex */
public class a {
    private static volatile a bIe;
    private long bIf;
    private com.baidu.poly.a.l.c bIg;
    private com.baidu.poly.widget.c bIh;
    private com.baidu.poly.widget.c bIi;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: com.baidu.poly.a.j.a$a  reason: collision with other inner class name */
    /* loaded from: classes9.dex */
    public class C0265a extends com.baidu.poly.a.a.a<JSONObject> {
        final /* synthetic */ m bHZ;
        final /* synthetic */ boolean bIa;
        final /* synthetic */ Context bIb;
        final /* synthetic */ Bundle bIc;

        C0265a(m mVar, boolean z, Context context, Bundle bundle) {
            this.bHZ = mVar;
            this.bIa = z;
            this.bIb = context;
            this.bIc = bundle;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.poly.a.a.a
        public void a(JSONObject jSONObject) {
            int optInt = jSONObject.optInt("payStatus", 3);
            a.this.c("1", String.valueOf(optInt));
            if (optInt == 2) {
                this.bHZ.a(0, com.baidu.poly.util.b.a(0, jSONObject.optString("payOrderNo"), jSONObject.optString("msg")));
            } else if (this.bIa) {
                a.this.a(this.bIb, this.bIc, this.bHZ);
            } else {
                a.this.a(this.bIb, this.bHZ);
            }
        }

        @Override // com.baidu.poly.a.a.a
        public void a(Throwable th, String str) {
            a.this.c("2", str);
            this.bHZ.a("get trade state failed : " + str, (String) null);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes9.dex */
    public class b implements View.OnClickListener {
        final /* synthetic */ m bHZ;

        b(m mVar) {
            this.bHZ = mVar;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            a.this.bIh.dismiss();
            com.baidu.poly.a.h.d.a(new com.baidu.poly.a.h.b(TbEnum.SystemMessage.EVENT_ID_INTRO_MODIFY).is("1"));
            this.bHZ.a(3, "pay failed , click choose window");
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes9.dex */
    public class c implements View.OnClickListener {
        final /* synthetic */ m bHZ;
        final /* synthetic */ Context bIb;
        final /* synthetic */ Bundle bIc;

        c(Context context, Bundle bundle, m mVar) {
            this.bIb = context;
            this.bIc = bundle;
            this.bHZ = mVar;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            a.this.bIh.dismiss();
            com.baidu.poly.a.h.d.a(new com.baidu.poly.a.h.b(TbEnum.SystemMessage.EVENT_ID_INTRO_MODIFY).is("2"));
            a.this.a(this.bIb, this.bIc, this.bHZ, false);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes9.dex */
    public class d implements View.OnClickListener {
        d() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (a.this.bIi == null || !a.this.bIi.isShowing()) {
                return;
            }
            a.this.bIi.dismiss();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes9.dex */
    public class e implements c.b {
        final /* synthetic */ m bHZ;

        e(m mVar) {
            this.bHZ = mVar;
        }

        @Override // com.baidu.poly.widget.c.b
        public void onDismiss() {
            this.bHZ.a(3, "pay failed , click error window");
        }
    }

    private a() {
    }

    public static a UV() {
        if (bIe == null) {
            synchronized (a.class) {
                if (bIe == null) {
                    bIe = new a();
                }
            }
        }
        return bIe;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c(String str, String str2) {
        com.baidu.poly.a.l.a.a(this.bIg);
        try {
            if (this.bIf != 0) {
                JSONObject jSONObject = new JSONObject();
                if (!TextUtils.isEmpty(str)) {
                    jSONObject.put("rt", str);
                }
                if (!TextUtils.isEmpty(str2)) {
                    jSONObject.put("msg", str2);
                }
                Long valueOf = Long.valueOf(System.currentTimeMillis() - this.bIf);
                if (valueOf.longValue() >= 0) {
                    jSONObject.put("du", String.valueOf(valueOf));
                }
                com.baidu.poly.a.h.d.a(new com.baidu.poly.a.h.b(TbEnum.SystemMessage.EVENT_ID_GROUP_JOIN).ah(jSONObject));
            }
        } catch (JSONException e2) {
            if (com.baidu.poly.util.d.bIN) {
                e2.printStackTrace();
            }
        } finally {
            this.bIf = 0L;
        }
    }

    public void a(Context context, Bundle bundle, m mVar, boolean z) {
        if (context != null && bundle != null && mVar != null) {
            FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-2, -2);
            layoutParams.gravity = 17;
            this.bIg = com.baidu.poly.a.l.a.a((ViewGroup) a((Activity) context), layoutParams, (String) null, -1L);
            this.bIf = System.currentTimeMillis();
            com.baidu.poly.a.b.b.UC().c(bundle, new C0265a(mVar, z, context, bundle));
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
        this.bIh = new com.baidu.poly.widget.c(inflate, -1, -1, true);
        this.bIh.setClippingEnabled(false);
        this.bIh.setOutsideTouchable(false);
        ((TextView) inflate.findViewById(b.e.bt_pay_meet_problems)).setOnClickListener(new b(mVar));
        ((TextView) inflate.findViewById(b.e.bt_pay_already_finish)).setOnClickListener(new c(context, bundle, mVar));
        this.bIh.showAtLocation(((Activity) context).getWindow().getDecorView(), 0, 0, 0);
        com.baidu.poly.a.h.d.a(new com.baidu.poly.a.h.b(TbEnum.SystemMessage.EVENT_ID_NOTICE_MODIFY));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(Context context, m mVar) {
        View inflate = View.inflate(mVar.getContext(), b.f.default_pop_window, null);
        ((TextView) inflate.findViewById(b.e.pop_title)).setText(b.g.pay_failed);
        ((TextView) inflate.findViewById(b.e.pop_tips)).setText(b.g.pay_failed_sub_text);
        this.bIi = new com.baidu.poly.widget.c(inflate, -1, -1, true);
        this.bIi.setClippingEnabled(false);
        this.bIi.setOutsideTouchable(false);
        this.bIi.setBackgroundDrawable(new ColorDrawable(0));
        ((TextView) inflate.findViewById(b.e.pop_button)).setOnClickListener(new d());
        this.bIi.a(new e(mVar));
        this.bIi.showAtLocation(((Activity) context).getWindow().getDecorView(), 0, 0, 0);
    }
}
