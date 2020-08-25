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
/* loaded from: classes6.dex */
public class a {
    private static volatile a bFZ;
    private long bGa;
    private com.baidu.poly.a.l.c bGb;
    private com.baidu.poly.widget.c bGc;
    private com.baidu.poly.widget.c bGd;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: com.baidu.poly.a.j.a$a  reason: collision with other inner class name */
    /* loaded from: classes6.dex */
    public class C0267a extends com.baidu.poly.a.a.a<JSONObject> {
        final /* synthetic */ m bFU;
        final /* synthetic */ boolean bFV;
        final /* synthetic */ Context bFW;
        final /* synthetic */ Bundle bFX;

        C0267a(m mVar, boolean z, Context context, Bundle bundle) {
            this.bFU = mVar;
            this.bFV = z;
            this.bFW = context;
            this.bFX = bundle;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.poly.a.a.a
        public void a(JSONObject jSONObject) {
            int optInt = jSONObject.optInt("payStatus", 3);
            a.this.c("1", String.valueOf(optInt));
            if (optInt == 2) {
                this.bFU.a(0, com.baidu.poly.util.b.a(0, jSONObject.optString("payOrderNo"), jSONObject.optString("msg")));
            } else if (this.bFV) {
                a.this.a(this.bFW, this.bFX, this.bFU);
            } else {
                a.this.a(this.bFW, this.bFU);
            }
        }

        @Override // com.baidu.poly.a.a.a
        public void a(Throwable th, String str) {
            a.this.c("2", str);
            this.bFU.a("get trade state failed : " + str, (String) null);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes6.dex */
    public class b implements View.OnClickListener {
        final /* synthetic */ m bFU;

        b(m mVar) {
            this.bFU = mVar;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            a.this.bGc.dismiss();
            com.baidu.poly.a.h.d.a(new com.baidu.poly.a.h.b(TbEnum.SystemMessage.EVENT_ID_INTRO_MODIFY).hY("1"));
            this.bFU.a(3, "pay failed , click choose window");
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes6.dex */
    public class c implements View.OnClickListener {
        final /* synthetic */ m bFU;
        final /* synthetic */ Context bFW;
        final /* synthetic */ Bundle bFX;

        c(Context context, Bundle bundle, m mVar) {
            this.bFW = context;
            this.bFX = bundle;
            this.bFU = mVar;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            a.this.bGc.dismiss();
            com.baidu.poly.a.h.d.a(new com.baidu.poly.a.h.b(TbEnum.SystemMessage.EVENT_ID_INTRO_MODIFY).hY("2"));
            a.this.a(this.bFW, this.bFX, this.bFU, false);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes6.dex */
    public class d implements View.OnClickListener {
        d() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (a.this.bGd == null || !a.this.bGd.isShowing()) {
                return;
            }
            a.this.bGd.dismiss();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes6.dex */
    public class e implements c.b {
        final /* synthetic */ m bFU;

        e(m mVar) {
            this.bFU = mVar;
        }

        @Override // com.baidu.poly.widget.c.b
        public void onDismiss() {
            this.bFU.a(3, "pay failed , click error window");
        }
    }

    private a() {
    }

    public static a Um() {
        if (bFZ == null) {
            synchronized (a.class) {
                if (bFZ == null) {
                    bFZ = new a();
                }
            }
        }
        return bFZ;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c(String str, String str2) {
        com.baidu.poly.a.l.a.a(this.bGb);
        try {
            if (this.bGa != 0) {
                JSONObject jSONObject = new JSONObject();
                if (!TextUtils.isEmpty(str)) {
                    jSONObject.put("rt", str);
                }
                if (!TextUtils.isEmpty(str2)) {
                    jSONObject.put("msg", str2);
                }
                Long valueOf = Long.valueOf(System.currentTimeMillis() - this.bGa);
                if (valueOf.longValue() >= 0) {
                    jSONObject.put("du", String.valueOf(valueOf));
                }
                com.baidu.poly.a.h.d.a(new com.baidu.poly.a.h.b(TbEnum.SystemMessage.EVENT_ID_GROUP_JOIN).ae(jSONObject));
            }
        } catch (JSONException e2) {
            if (com.baidu.poly.util.d.bGI) {
                e2.printStackTrace();
            }
        } finally {
            this.bGa = 0L;
        }
    }

    public void a(Context context, Bundle bundle, m mVar, boolean z) {
        if (context != null && bundle != null && mVar != null) {
            FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-2, -2);
            layoutParams.gravity = 17;
            this.bGb = com.baidu.poly.a.l.a.a((ViewGroup) a((Activity) context), layoutParams, (String) null, -1L);
            this.bGa = System.currentTimeMillis();
            com.baidu.poly.a.b.b.TT().c(bundle, new C0267a(mVar, z, context, bundle));
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
        this.bGc = new com.baidu.poly.widget.c(inflate, -1, -1, true);
        this.bGc.setClippingEnabled(false);
        this.bGc.setOutsideTouchable(false);
        ((TextView) inflate.findViewById(b.e.bt_pay_meet_problems)).setOnClickListener(new b(mVar));
        ((TextView) inflate.findViewById(b.e.bt_pay_already_finish)).setOnClickListener(new c(context, bundle, mVar));
        this.bGc.showAtLocation(((Activity) context).getWindow().getDecorView(), 0, 0, 0);
        com.baidu.poly.a.h.d.a(new com.baidu.poly.a.h.b(TbEnum.SystemMessage.EVENT_ID_NOTICE_MODIFY));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(Context context, m mVar) {
        View inflate = View.inflate(mVar.getContext(), b.f.default_pop_window, null);
        ((TextView) inflate.findViewById(b.e.pop_title)).setText(b.g.pay_failed);
        ((TextView) inflate.findViewById(b.e.pop_tips)).setText(b.g.pay_failed_sub_text);
        this.bGd = new com.baidu.poly.widget.c(inflate, -1, -1, true);
        this.bGd.setClippingEnabled(false);
        this.bGd.setOutsideTouchable(false);
        this.bGd.setBackgroundDrawable(new ColorDrawable(0));
        ((TextView) inflate.findViewById(b.e.pop_button)).setOnClickListener(new d());
        this.bGd.a(new e(mVar));
        this.bGd.showAtLocation(((Activity) context).getWindow().getDecorView(), 0, 0, 0);
    }
}
