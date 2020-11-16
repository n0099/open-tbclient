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
    private static volatile a cbj;
    private long cbk;
    private com.baidu.poly.a.l.c cbl;
    private com.baidu.poly.widget.c cbm;
    private com.baidu.poly.widget.c cbn;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: com.baidu.poly.a.j.a$a  reason: collision with other inner class name */
    /* loaded from: classes6.dex */
    public class C0304a extends com.baidu.poly.a.a.a<JSONObject> {
        final /* synthetic */ m cbe;
        final /* synthetic */ boolean cbf;
        final /* synthetic */ Context cbg;
        final /* synthetic */ Bundle cbh;

        C0304a(m mVar, boolean z, Context context, Bundle bundle) {
            this.cbe = mVar;
            this.cbf = z;
            this.cbg = context;
            this.cbh = bundle;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.poly.a.a.a
        public void a(JSONObject jSONObject) {
            int optInt = jSONObject.optInt("payStatus", 3);
            a.this.c("1", String.valueOf(optInt));
            if (optInt == 2) {
                this.cbe.a(0, com.baidu.poly.util.b.a(0, jSONObject.optString("payOrderNo"), jSONObject.optString("msg")));
            } else if (this.cbf) {
                a.this.a(this.cbg, this.cbh, this.cbe);
            } else {
                a.this.a(this.cbg, this.cbe);
            }
        }

        @Override // com.baidu.poly.a.a.a
        public void a(Throwable th, String str) {
            a.this.c("2", str);
            this.cbe.a("get trade state failed : " + str, (String) null);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes6.dex */
    public class b implements View.OnClickListener {
        final /* synthetic */ m cbe;

        b(m mVar) {
            this.cbe = mVar;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            a.this.cbm.dismiss();
            com.baidu.poly.a.h.d.a(new com.baidu.poly.a.h.b(TbEnum.SystemMessage.EVENT_ID_INTRO_MODIFY).ju("1"));
            this.cbe.a(3, "pay failed , click choose window");
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes6.dex */
    public class c implements View.OnClickListener {
        final /* synthetic */ m cbe;
        final /* synthetic */ Context cbg;
        final /* synthetic */ Bundle cbh;

        c(Context context, Bundle bundle, m mVar) {
            this.cbg = context;
            this.cbh = bundle;
            this.cbe = mVar;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            a.this.cbm.dismiss();
            com.baidu.poly.a.h.d.a(new com.baidu.poly.a.h.b(TbEnum.SystemMessage.EVENT_ID_INTRO_MODIFY).ju("2"));
            a.this.a(this.cbg, this.cbh, this.cbe, false);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes6.dex */
    public class d implements View.OnClickListener {
        d() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (a.this.cbn == null || !a.this.cbn.isShowing()) {
                return;
            }
            a.this.cbn.dismiss();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes6.dex */
    public class e implements c.b {
        final /* synthetic */ m cbe;

        e(m mVar) {
            this.cbe = mVar;
        }

        @Override // com.baidu.poly.widget.c.b
        public void onDismiss() {
            this.cbe.a(3, "pay failed , click error window");
        }
    }

    private a() {
    }

    public static a aaC() {
        if (cbj == null) {
            synchronized (a.class) {
                if (cbj == null) {
                    cbj = new a();
                }
            }
        }
        return cbj;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c(String str, String str2) {
        com.baidu.poly.a.l.a.a(this.cbl);
        try {
            if (this.cbk != 0) {
                JSONObject jSONObject = new JSONObject();
                if (!TextUtils.isEmpty(str)) {
                    jSONObject.put("rt", str);
                }
                if (!TextUtils.isEmpty(str2)) {
                    jSONObject.put("msg", str2);
                }
                Long valueOf = Long.valueOf(System.currentTimeMillis() - this.cbk);
                if (valueOf.longValue() >= 0) {
                    jSONObject.put("du", String.valueOf(valueOf));
                }
                com.baidu.poly.a.h.d.a(new com.baidu.poly.a.h.b(TbEnum.SystemMessage.EVENT_ID_GROUP_JOIN).an(jSONObject));
            }
        } catch (JSONException e2) {
            if (com.baidu.poly.util.d.cbS) {
                e2.printStackTrace();
            }
        } finally {
            this.cbk = 0L;
        }
    }

    public void a(Context context, Bundle bundle, m mVar, boolean z) {
        if (context != null && bundle != null && mVar != null) {
            FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-2, -2);
            layoutParams.gravity = 17;
            this.cbl = com.baidu.poly.a.l.a.a((ViewGroup) a((Activity) context), layoutParams, (String) null, -1L);
            this.cbk = System.currentTimeMillis();
            com.baidu.poly.a.b.b.aaj().c(bundle, new C0304a(mVar, z, context, bundle));
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
        this.cbm = new com.baidu.poly.widget.c(inflate, -1, -1, true);
        this.cbm.setClippingEnabled(false);
        this.cbm.setOutsideTouchable(false);
        ((TextView) inflate.findViewById(b.e.bt_pay_meet_problems)).setOnClickListener(new b(mVar));
        ((TextView) inflate.findViewById(b.e.bt_pay_already_finish)).setOnClickListener(new c(context, bundle, mVar));
        this.cbm.showAtLocation(((Activity) context).getWindow().getDecorView(), 0, 0, 0);
        com.baidu.poly.a.h.d.a(new com.baidu.poly.a.h.b(TbEnum.SystemMessage.EVENT_ID_NOTICE_MODIFY));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(Context context, m mVar) {
        View inflate = View.inflate(mVar.getContext(), b.f.default_pop_window, null);
        ((TextView) inflate.findViewById(b.e.pop_title)).setText(b.g.pay_failed);
        ((TextView) inflate.findViewById(b.e.pop_tips)).setText(b.g.pay_failed_sub_text);
        this.cbn = new com.baidu.poly.widget.c(inflate, -1, -1, true);
        this.cbn.setClippingEnabled(false);
        this.cbn.setOutsideTouchable(false);
        this.cbn.setBackgroundDrawable(new ColorDrawable(0));
        ((TextView) inflate.findViewById(b.e.pop_button)).setOnClickListener(new d());
        this.cbn.a(new e(mVar));
        this.cbn.showAtLocation(((Activity) context).getWindow().getDecorView(), 0, 0, 0);
    }
}
