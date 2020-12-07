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
/* loaded from: classes19.dex */
public class a {
    private static volatile a chM;
    private long chN;
    private com.baidu.poly.a.l.c chO;
    private com.baidu.poly.widget.c chP;
    private com.baidu.poly.widget.c chQ;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: com.baidu.poly.a.j.a$a  reason: collision with other inner class name */
    /* loaded from: classes19.dex */
    public class C0315a extends com.baidu.poly.a.a.a<JSONObject> {
        final /* synthetic */ m chH;
        final /* synthetic */ boolean chI;
        final /* synthetic */ Context chJ;
        final /* synthetic */ Bundle chK;

        C0315a(m mVar, boolean z, Context context, Bundle bundle) {
            this.chH = mVar;
            this.chI = z;
            this.chJ = context;
            this.chK = bundle;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.poly.a.a.a
        public void a(JSONObject jSONObject) {
            int optInt = jSONObject.optInt("payStatus", 3);
            a.this.c("1", String.valueOf(optInt));
            if (optInt == 2) {
                this.chH.a(0, com.baidu.poly.util.b.a(0, jSONObject.optString("payOrderNo"), jSONObject.optString("msg")));
            } else if (this.chI) {
                a.this.a(this.chJ, this.chK, this.chH);
            } else {
                a.this.a(this.chJ, this.chH);
            }
        }

        @Override // com.baidu.poly.a.a.a
        public void a(Throwable th, String str) {
            a.this.c("2", str);
            this.chH.a("get trade state failed : " + str, (String) null);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes19.dex */
    public class b implements View.OnClickListener {
        final /* synthetic */ m chH;

        b(m mVar) {
            this.chH = mVar;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            a.this.chP.dismiss();
            com.baidu.poly.a.h.d.a(new com.baidu.poly.a.h.b(TbEnum.SystemMessage.EVENT_ID_INTRO_MODIFY).kb("1"));
            this.chH.a(3, "pay failed , click choose window");
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes19.dex */
    public class c implements View.OnClickListener {
        final /* synthetic */ m chH;
        final /* synthetic */ Context chJ;
        final /* synthetic */ Bundle chK;

        c(Context context, Bundle bundle, m mVar) {
            this.chJ = context;
            this.chK = bundle;
            this.chH = mVar;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            a.this.chP.dismiss();
            com.baidu.poly.a.h.d.a(new com.baidu.poly.a.h.b(TbEnum.SystemMessage.EVENT_ID_INTRO_MODIFY).kb("2"));
            a.this.a(this.chJ, this.chK, this.chH, false);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes19.dex */
    public class d implements View.OnClickListener {
        d() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (a.this.chQ == null || !a.this.chQ.isShowing()) {
                return;
            }
            a.this.chQ.dismiss();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes19.dex */
    public class e implements c.b {
        final /* synthetic */ m chH;

        e(m mVar) {
            this.chH = mVar;
        }

        @Override // com.baidu.poly.widget.c.b
        public void onDismiss() {
            this.chH.a(3, "pay failed , click error window");
        }
    }

    private a() {
    }

    public static a adK() {
        if (chM == null) {
            synchronized (a.class) {
                if (chM == null) {
                    chM = new a();
                }
            }
        }
        return chM;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c(String str, String str2) {
        com.baidu.poly.a.l.a.a(this.chO);
        try {
            if (this.chN != 0) {
                JSONObject jSONObject = new JSONObject();
                if (!TextUtils.isEmpty(str)) {
                    jSONObject.put("rt", str);
                }
                if (!TextUtils.isEmpty(str2)) {
                    jSONObject.put("msg", str2);
                }
                Long valueOf = Long.valueOf(System.currentTimeMillis() - this.chN);
                if (valueOf.longValue() >= 0) {
                    jSONObject.put("du", String.valueOf(valueOf));
                }
                com.baidu.poly.a.h.d.a(new com.baidu.poly.a.h.b(TbEnum.SystemMessage.EVENT_ID_GROUP_JOIN).ap(jSONObject));
            }
        } catch (JSONException e2) {
            if (com.baidu.poly.util.d.ciw) {
                e2.printStackTrace();
            }
        } finally {
            this.chN = 0L;
        }
    }

    public void a(Context context, Bundle bundle, m mVar, boolean z) {
        if (context != null && bundle != null && mVar != null) {
            FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-2, -2);
            layoutParams.gravity = 17;
            this.chO = com.baidu.poly.a.l.a.a((ViewGroup) a((Activity) context), layoutParams, (String) null, -1L);
            this.chN = System.currentTimeMillis();
            com.baidu.poly.a.b.b.adr().c(bundle, new C0315a(mVar, z, context, bundle));
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
        this.chP = new com.baidu.poly.widget.c(inflate, -1, -1, true);
        this.chP.setClippingEnabled(false);
        this.chP.setOutsideTouchable(false);
        ((TextView) inflate.findViewById(b.e.bt_pay_meet_problems)).setOnClickListener(new b(mVar));
        ((TextView) inflate.findViewById(b.e.bt_pay_already_finish)).setOnClickListener(new c(context, bundle, mVar));
        this.chP.showAtLocation(((Activity) context).getWindow().getDecorView(), 0, 0, 0);
        com.baidu.poly.a.h.d.a(new com.baidu.poly.a.h.b(TbEnum.SystemMessage.EVENT_ID_NOTICE_MODIFY));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(Context context, m mVar) {
        View inflate = View.inflate(mVar.getContext(), b.f.default_pop_window, null);
        ((TextView) inflate.findViewById(b.e.pop_title)).setText(b.g.pay_failed);
        ((TextView) inflate.findViewById(b.e.pop_tips)).setText(b.g.pay_failed_sub_text);
        this.chQ = new com.baidu.poly.widget.c(inflate, -1, -1, true);
        this.chQ.setClippingEnabled(false);
        this.chQ.setOutsideTouchable(false);
        this.chQ.setBackgroundDrawable(new ColorDrawable(0));
        ((TextView) inflate.findViewById(b.e.pop_button)).setOnClickListener(new d());
        this.chQ.a(new e(mVar));
        this.chQ.showAtLocation(((Activity) context).getWindow().getDecorView(), 0, 0, 0);
    }
}
