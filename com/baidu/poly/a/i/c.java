package com.baidu.poly.a.i;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageInfo;
import android.os.Bundle;
import android.os.Handler;
import android.text.TextUtils;
import android.view.View;
import android.widget.Toast;
import com.baidu.poly.a.g.d;
import com.baidu.poly.b;
import com.baidu.poly.widget.PayWebActivity;
import com.baidu.poly.widget.m;
import com.baidu.tieba.ala.live.walletconfig.CashierData;
import java.util.List;
import java.util.Map;
import org.json.JSONObject;
/* loaded from: classes11.dex */
public class c {
    private final String EXTRA_DATA = CashierData.EXT_DATA;
    private final String bvC = "actionType";
    private final String bvD = "payUrl";
    private final String bvE = "H5";
    private b bvF;

    /* loaded from: classes11.dex */
    class a extends com.baidu.poly.a.a.a<Map<String, String>> {
        final /* synthetic */ String bvA;
        final /* synthetic */ m bvl;

        /* JADX INFO: Access modifiers changed from: package-private */
        /* renamed from: com.baidu.poly.a.i.c$a$a  reason: collision with other inner class name */
        /* loaded from: classes11.dex */
        public class RunnableC0239a implements Runnable {
            final /* synthetic */ com.baidu.poly.widget.c bvx;
            final /* synthetic */ String bvy;

            RunnableC0239a(com.baidu.poly.widget.c cVar, String str) {
                this.bvx = cVar;
                this.bvy = str;
            }

            @Override // java.lang.Runnable
            public void run() {
                com.baidu.poly.widget.c cVar = this.bvx;
                if (cVar != null && cVar.isShowing()) {
                    this.bvx.dismiss();
                }
                a.this.bvl.a(0, this.bvy);
            }
        }

        a(String str, m mVar) {
            this.bvA = str;
            this.bvl = mVar;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.poly.a.a.a
        public void a(Map<String, String> map) {
            d.bvg = map.get(CashierData.ORDERID);
            if (!map.containsKey("parentType")) {
                c.this.c(map, this.bvA, this.bvl);
                return;
            }
            String str = map.get("parentType");
            if (TextUtils.isEmpty(str)) {
                c.this.c(map, this.bvA, this.bvl);
            } else if (4 != Integer.parseInt(str)) {
                c.this.c(map, this.bvA, this.bvl);
            } else {
                String a = com.baidu.poly.util.b.a(0, map.get(CashierData.ORDERID), "Successful payment");
                com.baidu.poly.widget.c cVar = new com.baidu.poly.widget.c(View.inflate(this.bvl.getContext(), b.f.pay_success, null), -1, -1, true);
                cVar.setClippingEnabled(false);
                cVar.setFocusable(false);
                cVar.setOutsideTouchable(false);
                cVar.showAtLocation(this.bvl, 0, 0, 0);
                new Handler().postDelayed(new RunnableC0239a(cVar, a), 2000L);
                com.baidu.poly.a.g.a.i("8");
                com.baidu.poly.util.d.info("WalletList->pay() 命中0单元");
            }
        }

        @Override // com.baidu.poly.a.a.a
        public void a(Throwable th, String str) {
            String message;
            if (str != null) {
                message = str;
            } else {
                message = th != null ? th.getMessage() : null;
            }
            this.bvl.a("launchpayment error msg is " + message, str);
            d.a(new com.baidu.poly.a.g.b("1").gx(new com.baidu.poly.a.h.a("launchpayment error --> " + str, th).L()));
        }
    }

    public c(b bVar) {
        this.bvF = bVar;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c(Map<String, String> map, String str, m mVar) {
        String str2 = map.get(CashierData.EXT_DATA);
        if (!TextUtils.isEmpty(str2)) {
            try {
                if (TextUtils.equals(new JSONObject(str2).optString("actionType"), "H5")) {
                    String str3 = map.get("payUrl");
                    if (!TextUtils.isEmpty(str3)) {
                        if (d(mVar.getContext())) {
                            mVar.setWechatH5Pay(true);
                            mVar.setIsPreparePaying(false);
                            a((Activity) mVar.getContext(), str3, map);
                            com.baidu.poly.a.g.a.i("8");
                        } else {
                            Toast.makeText(mVar.getContext(), "您没有安装微信，请选择其他支付方式", 0).show();
                            mVar.a(3, "wx_not_installed");
                        }
                    } else {
                        mVar.a("H5 no corresponding url ", (String) null);
                        com.baidu.poly.a.g.a.a("8", null, "H5 no corresponding url");
                    }
                }
            } catch (Exception e) {
                mVar.a("launchpayment extData analyze failed ", (String) null);
                com.baidu.poly.a.g.a.a("8", null, "launchpayment extData analyze failed");
                return;
            }
        }
        this.bvF.a(map, str, mVar);
    }

    private boolean d(Context context) {
        List<PackageInfo> installedPackages = context.getPackageManager().getInstalledPackages(0);
        if (installedPackages != null) {
            for (int i = 0; i < installedPackages.size(); i++) {
                if (installedPackages.get(i).packageName.equals("com.tencent.mm")) {
                    return true;
                }
            }
            return false;
        }
        return false;
    }

    public void b(Bundle bundle, String str, m mVar) {
        com.baidu.poly.a.b.a.ML().a(bundle, new a(str, mVar), str);
    }

    private void a(Activity activity, String str, Map<String, String> map) {
        if (activity == null || TextUtils.isEmpty(str)) {
            return;
        }
        Intent intent = new Intent(activity, PayWebActivity.class);
        intent.putExtra("load_url", str);
        Bundle bundle = new Bundle();
        for (String str2 : map.keySet()) {
            bundle.putString(str2, map.get(str2));
        }
        intent.putExtra("launch_payment_data", bundle);
        activity.startActivityForResult(intent, 200);
    }
}
