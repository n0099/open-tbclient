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
    private static volatile a coP;
    private long coQ;
    private com.baidu.poly.a.l.c coR;
    private com.baidu.poly.widget.c coS;
    private com.baidu.poly.widget.c coT;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: com.baidu.poly.a.j.a$a  reason: collision with other inner class name */
    /* loaded from: classes4.dex */
    public class C0315a extends com.baidu.poly.a.a.a<JSONObject> {
        final /* synthetic */ m coK;
        final /* synthetic */ boolean coL;
        final /* synthetic */ Context coM;
        final /* synthetic */ Bundle coN;

        C0315a(m mVar, boolean z, Context context, Bundle bundle) {
            this.coK = mVar;
            this.coL = z;
            this.coM = context;
            this.coN = bundle;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.poly.a.a.a
        public void a(JSONObject jSONObject) {
            int optInt = jSONObject.optInt("payStatus", 3);
            a.this.c("1", String.valueOf(optInt));
            if (optInt == 2) {
                this.coK.a(0, com.baidu.poly.util.b.a(0, jSONObject.optString("payOrderNo"), jSONObject.optString("msg")));
            } else if (this.coL) {
                a.this.a(this.coM, this.coN, this.coK);
            } else {
                a.this.a(this.coM, this.coK);
            }
        }

        @Override // com.baidu.poly.a.a.a
        public void a(Throwable th, String str) {
            a.this.c("2", str);
            this.coK.a("get trade state failed : " + str, (String) null);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes4.dex */
    public class b implements View.OnClickListener {
        final /* synthetic */ m coK;

        b(m mVar) {
            this.coK = mVar;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            a.this.coS.dismiss();
            com.baidu.poly.a.h.d.a(new com.baidu.poly.a.h.b(TbEnum.SystemMessage.EVENT_ID_INTRO_MODIFY).jX("1"));
            this.coK.a(3, "pay failed , click choose window");
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes4.dex */
    public class c implements View.OnClickListener {
        final /* synthetic */ m coK;
        final /* synthetic */ Context coM;
        final /* synthetic */ Bundle coN;

        c(Context context, Bundle bundle, m mVar) {
            this.coM = context;
            this.coN = bundle;
            this.coK = mVar;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            a.this.coS.dismiss();
            com.baidu.poly.a.h.d.a(new com.baidu.poly.a.h.b(TbEnum.SystemMessage.EVENT_ID_INTRO_MODIFY).jX("2"));
            a.this.a(this.coM, this.coN, this.coK, false);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes4.dex */
    public class d implements View.OnClickListener {
        d() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (a.this.coT == null || !a.this.coT.isShowing()) {
                return;
            }
            a.this.coT.dismiss();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes4.dex */
    public class e implements c.b {
        final /* synthetic */ m coK;

        e(m mVar) {
            this.coK = mVar;
        }

        @Override // com.baidu.poly.widget.c.b
        public void onDismiss() {
            this.coK.a(3, "pay failed , click error window");
        }
    }

    private a() {
    }

    public static a afG() {
        if (coP == null) {
            synchronized (a.class) {
                if (coP == null) {
                    coP = new a();
                }
            }
        }
        return coP;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c(String str, String str2) {
        com.baidu.poly.a.l.a.a(this.coR);
        try {
            if (this.coQ != 0) {
                JSONObject jSONObject = new JSONObject();
                if (!TextUtils.isEmpty(str)) {
                    jSONObject.put("rt", str);
                }
                if (!TextUtils.isEmpty(str2)) {
                    jSONObject.put("msg", str2);
                }
                Long valueOf = Long.valueOf(System.currentTimeMillis() - this.coQ);
                if (valueOf.longValue() >= 0) {
                    jSONObject.put("du", String.valueOf(valueOf));
                }
                com.baidu.poly.a.h.d.a(new com.baidu.poly.a.h.b(TbEnum.SystemMessage.EVENT_ID_GROUP_JOIN).ax(jSONObject));
            }
        } catch (JSONException e2) {
            if (com.baidu.poly.util.d.cpz) {
                e2.printStackTrace();
            }
        } finally {
            this.coQ = 0L;
        }
    }

    public void a(Context context, Bundle bundle, m mVar, boolean z) {
        if (context != null && bundle != null && mVar != null) {
            FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-2, -2);
            layoutParams.gravity = 17;
            this.coR = com.baidu.poly.a.l.a.a((ViewGroup) a((Activity) context), layoutParams, (String) null, -1L);
            this.coQ = System.currentTimeMillis();
            com.baidu.poly.a.b.b.afo().c(bundle, new C0315a(mVar, z, context, bundle));
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
        this.coS = new com.baidu.poly.widget.c(inflate, -1, -1, true);
        this.coS.ei(false);
        this.coS.eh(false);
        ((TextView) inflate.findViewById(b.e.bt_pay_meet_problems)).setOnClickListener(new b(mVar));
        ((TextView) inflate.findViewById(b.e.bt_pay_already_finish)).setOnClickListener(new c(context, bundle, mVar));
        this.coS.showAtLocation(((Activity) context).getWindow().getDecorView(), 0, 0, 0);
        com.baidu.poly.a.h.d.a(new com.baidu.poly.a.h.b(TbEnum.SystemMessage.EVENT_ID_NOTICE_MODIFY));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(Context context, m mVar) {
        View inflate = View.inflate(mVar.getContext(), b.f.default_pop_window, null);
        ((TextView) inflate.findViewById(b.e.pop_title)).setText(b.g.pay_failed);
        ((TextView) inflate.findViewById(b.e.pop_tips)).setText(b.g.pay_failed_sub_text);
        this.coT = new com.baidu.poly.widget.c(inflate, -1, -1, true);
        this.coT.ei(false);
        this.coT.eh(false);
        this.coT.setBackgroundDrawable(new ColorDrawable(0));
        ((TextView) inflate.findViewById(b.e.pop_button)).setOnClickListener(new d());
        this.coT.a(new e(mVar));
        this.coT.showAtLocation(((Activity) context).getWindow().getDecorView(), 0, 0, 0);
    }
}
