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
import com.baidu.poly.widget.l;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes9.dex */
public class a {
    private static volatile a aMa;
    private long aMb;
    private com.baidu.poly.a.k.c aMc;
    private com.baidu.poly.widget.c aMd;
    private com.baidu.poly.widget.c aMe;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: com.baidu.poly.a.i.a$a  reason: collision with other inner class name */
    /* loaded from: classes9.dex */
    public class C0147a extends com.baidu.poly.a.a.a<JSONObject> {
        final /* synthetic */ l aLV;
        final /* synthetic */ boolean aLW;
        final /* synthetic */ Context aLX;
        final /* synthetic */ Bundle aLY;

        C0147a(l lVar, boolean z, Context context, Bundle bundle) {
            this.aLV = lVar;
            this.aLW = z;
            this.aLX = context;
            this.aLY = bundle;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.poly.a.a.a
        public void a(JSONObject jSONObject) {
            int optInt = jSONObject.optInt("payStatus", 3);
            a.this.b("1", String.valueOf(optInt));
            if (optInt == 2) {
                this.aLV.a(0, com.baidu.poly.util.a.a(0, jSONObject.optString("payOrderNo"), jSONObject.optString("msg")));
            } else if (this.aLW) {
                a.this.a(this.aLX, this.aLY, this.aLV);
            } else {
                a.this.a(this.aLX, this.aLV);
            }
        }

        @Override // com.baidu.poly.a.a.a
        public void a(Throwable th, String str) {
            a.this.b("2", str);
            this.aLV.a("get trade state failed : " + str);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes9.dex */
    public class b implements View.OnClickListener {
        final /* synthetic */ l aLV;

        b(l lVar) {
            this.aLV = lVar;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            a.this.aMd.dismiss();
            com.baidu.poly.a.g.c.a(new com.baidu.poly.a.g.a(TbEnum.SystemMessage.EVENT_ID_INTRO_MODIFY).ex("1"));
            this.aLV.a(3, "pay failed , click choose window");
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes9.dex */
    public class c implements View.OnClickListener {
        final /* synthetic */ l aLV;
        final /* synthetic */ Context aLX;
        final /* synthetic */ Bundle aLY;

        c(Context context, Bundle bundle, l lVar) {
            this.aLX = context;
            this.aLY = bundle;
            this.aLV = lVar;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            a.this.aMd.dismiss();
            com.baidu.poly.a.g.c.a(new com.baidu.poly.a.g.a(TbEnum.SystemMessage.EVENT_ID_INTRO_MODIFY).ex("2"));
            a.this.a(this.aLX, this.aLY, this.aLV, false);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes9.dex */
    public class d implements View.OnClickListener {
        d() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (a.this.aMe == null || !a.this.aMe.isShowing()) {
                return;
            }
            a.this.aMe.dismiss();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes9.dex */
    public class e implements c.b {
        final /* synthetic */ l aLV;

        e(l lVar) {
            this.aLV = lVar;
        }

        @Override // com.baidu.poly.widget.c.b
        public void onDismiss() {
            this.aLV.a(3, "pay failed , click error window");
        }
    }

    private a() {
    }

    public static a BP() {
        if (aMa == null) {
            synchronized (a.class) {
                if (aMa == null) {
                    aMa = new a();
                }
            }
        }
        return aMa;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(String str, String str2) {
        com.baidu.poly.a.k.a.a(this.aMc);
        try {
            if (this.aMb != 0) {
                JSONObject jSONObject = new JSONObject();
                if (!TextUtils.isEmpty(str)) {
                    jSONObject.put("rt", str);
                }
                if (!TextUtils.isEmpty(str2)) {
                    jSONObject.put("msg", str2);
                }
                Long valueOf = Long.valueOf(System.currentTimeMillis() - this.aMb);
                if (valueOf.longValue() >= 0) {
                    jSONObject.put("du", String.valueOf(valueOf));
                }
                com.baidu.poly.a.g.c.a(new com.baidu.poly.a.g.a(TbEnum.SystemMessage.EVENT_ID_GROUP_JOIN).J(jSONObject));
            }
        } catch (JSONException e2) {
            if (com.baidu.poly.util.c.aMK) {
                e2.printStackTrace();
            }
        } finally {
            this.aMb = 0L;
        }
    }

    public void a(Context context, Bundle bundle, l lVar, boolean z) {
        if (context != null && bundle != null && lVar != null) {
            FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-2, -2);
            layoutParams.gravity = 17;
            this.aMc = com.baidu.poly.a.k.a.a((ViewGroup) a((Activity) context), layoutParams, (String) null, -1L);
            this.aMb = System.currentTimeMillis();
            com.baidu.poly.a.b.a.BG().c(bundle, new C0147a(lVar, z, context, bundle));
        }
    }

    private View a(Activity activity) {
        if (activity == null || activity.getWindow() == null) {
            return null;
        }
        return activity.getWindow().getDecorView().findViewById(16908290);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(Context context, Bundle bundle, l lVar) {
        View inflate = View.inflate(lVar.getContext(), b.f.pay_confirm, null);
        this.aMd = new com.baidu.poly.widget.c(inflate, -1, -1, true);
        this.aMd.setClippingEnabled(false);
        this.aMd.setOutsideTouchable(false);
        ((TextView) inflate.findViewById(b.e.bt_pay_meet_problems)).setOnClickListener(new b(lVar));
        ((TextView) inflate.findViewById(b.e.bt_pay_already_finish)).setOnClickListener(new c(context, bundle, lVar));
        this.aMd.showAtLocation(((Activity) context).getWindow().getDecorView(), 0, 0, 0);
        com.baidu.poly.a.g.c.a(new com.baidu.poly.a.g.a(TbEnum.SystemMessage.EVENT_ID_NOTICE_MODIFY));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(Context context, l lVar) {
        View inflate = View.inflate(lVar.getContext(), b.f.default_pop_window, null);
        ((TextView) inflate.findViewById(b.e.pop_title)).setText(b.g.pay_failed);
        ((TextView) inflate.findViewById(b.e.pop_tips)).setText(b.g.pay_failed_sub_text);
        this.aMe = new com.baidu.poly.widget.c(inflate, -1, -1, true);
        this.aMe.setClippingEnabled(false);
        this.aMe.setOutsideTouchable(false);
        this.aMe.setBackgroundDrawable(new ColorDrawable(0));
        ((TextView) inflate.findViewById(b.e.pop_button)).setOnClickListener(new d());
        this.aMe.a(new e(lVar));
        this.aMe.showAtLocation(((Activity) context).getWindow().getDecorView(), 0, 0, 0);
    }
}
