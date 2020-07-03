package com.baidu.live.sdk.goods.d;

import android.graphics.Color;
import android.net.Uri;
import android.os.Build;
import android.os.Handler;
import android.os.Message;
import android.support.v4.graphics.ColorUtils;
import android.text.TextUtils;
import android.webkit.JsResult;
import com.baidu.live.adp.framework.MessageManager;
import com.baidu.live.adp.framework.listener.CustomMessageListener;
import com.baidu.live.adp.framework.message.CustomResponsedMessage;
import com.baidu.live.sdk.a;
import com.baidu.live.sdk.goods.d.b;
import com.baidu.live.tbadk.TbPageContext;
import com.baidu.live.view.d;
import com.baidu.live.view.web.f;
import com.baidu.searchbox.ugc.model.UgcConstant;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;
/* loaded from: classes3.dex */
public class a implements b.a, c, f {
    private CustomMessageListener aPg;
    private b bdf;
    private d bdg;
    private boolean bdh;
    private List<String> bdi;
    private HandlerC0178a bdj;
    private CustomMessageListener bdk;
    private TbPageContext mPageContext;

    public a(TbPageContext tbPageContext) {
        this.mPageContext = tbPageContext;
        Bf();
    }

    @Override // com.baidu.live.sdk.goods.d.c
    public void u(String str, boolean z) {
        this.bdh = z;
        this.bdf = new b(this.mPageContext.getPageActivity());
        this.bdf.a((b.a) this);
        this.bdf.a((f) this);
        this.bdf.Hf().setBackgroundColor(fI(str));
        this.bdf.a(new b.InterfaceC0180b() { // from class: com.baidu.live.sdk.goods.d.a.1
            @Override // com.baidu.live.sdk.goods.d.b.InterfaceC0180b
            public void bZ(boolean z2) {
                if (z2) {
                    a.this.GX();
                }
            }
        });
        this.bdf.show(str);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void GX() {
        if (Build.VERSION.SDK_INT >= 19) {
            GZ();
            if (this.bdj == null) {
                this.bdj = new HandlerC0178a(this);
            }
            if (!this.bdj.hasMessages(1001)) {
                this.bdj.sendEmptyMessageDelayed(1001, 1000L);
            }
        }
    }

    @Override // com.baidu.live.sdk.goods.d.c
    public void resume() {
        if (this.bdf != null && this.bdf.isShowing() && this.bdf.Hf() != null) {
            this.bdf.Hf().onResume();
            if (this.bdh) {
                this.bdf.Hf().reload();
            }
        }
    }

    @Override // com.baidu.live.sdk.goods.d.c
    public void pause() {
        if (this.bdf != null && this.bdf.isShowing() && this.bdf.Hf() != null) {
            this.bdf.Hf().onPause();
        }
    }

    @Override // com.baidu.live.sdk.goods.d.c
    public void release() {
        GY();
        MessageManager.getInstance().unRegisterListener(this.aPg);
        Hb();
    }

    @Override // com.baidu.live.sdk.goods.d.b.a
    public boolean a(String str, final JsResult jsResult) {
        this.bdg = new d(this.mPageContext.getPageActivity());
        this.bdg.setCancelable(false);
        this.bdg.setCanceledOnTouchOutside(false);
        this.bdg.cA(false);
        this.bdg.o(this.mPageContext.getString(a.i.sdk_live_disclaimer), str, this.mPageContext.getString(a.i.sdk_live_iknow), this.mPageContext.getString(a.i.sdk_live_cancel));
        this.bdg.a(new d.a() { // from class: com.baidu.live.sdk.goods.d.a.2
            @Override // com.baidu.live.view.d.a
            public void Hd() {
                if (jsResult != null) {
                    jsResult.confirm();
                }
            }

            @Override // com.baidu.live.view.d.a
            public void He() {
                if (jsResult != null) {
                    jsResult.cancel();
                }
            }
        });
        this.bdg.show();
        return true;
    }

    private void Bf() {
        this.aPg = new CustomMessageListener(2913097) { // from class: com.baidu.live.sdk.goods.d.a.3
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.live.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage.getData() != null && (customResponsedMessage.getData() instanceof String) && TextUtils.equals((String) customResponsedMessage.getData(), "into_end_view")) {
                    a.this.GY();
                }
            }
        };
        MessageManager.getInstance().registerListener(this.aPg);
    }

    private int fI(String str) {
        int indexOf;
        String queryParameter = Uri.parse(str).getQueryParameter("background");
        if ((TextUtils.isEmpty(queryParameter) || queryParameter.length() != 8) && (indexOf = str.indexOf("background=")) >= 0 && indexOf + 19 <= str.length()) {
            queryParameter = str.substring(indexOf + 11, indexOf + 19);
        }
        if (TextUtils.isEmpty(queryParameter) || queryParameter.length() != 8) {
            return 0;
        }
        try {
            int parseInt = Integer.parseInt(queryParameter.substring(6, 8), 16);
            return (parseInt < 0 || parseInt > 255) ? 0 : ColorUtils.setAlphaComponent(Color.parseColor(UgcConstant.TOPIC_PATTERN_TAG + queryParameter.substring(0, 6)), parseInt);
        } catch (Exception e) {
            return 0;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void GY() {
        if (this.bdf != null) {
            this.bdf.dismiss();
        }
        if (this.bdg != null) {
            this.bdg.release();
        }
    }

    @Override // com.baidu.live.view.web.f
    public void cM(int i) {
        GY();
    }

    private void GZ() {
        if (this.bdi == null) {
            this.bdi = new ArrayList();
        }
        this.bdi.clear();
        if (this.bdk == null) {
            this.bdk = new CustomMessageListener(2913107) { // from class: com.baidu.live.sdk.goods.d.a.4
                /* JADX DEBUG: Method merged with bridge method */
                @Override // com.baidu.live.adp.framework.listener.MessageListener
                public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                    if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof List)) {
                        a.this.bdi.addAll((List) customResponsedMessage.getData());
                    }
                }
            };
            MessageManager.getInstance().registerListener(this.bdk);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Ha() {
        int size;
        String str = null;
        if (this.bdi != null && (size = this.bdi.size()) > 0) {
            JSONArray jSONArray = new JSONArray();
            for (int i = 0; i < size; i++) {
                jSONArray.put(this.bdi.get(i));
            }
            str = jSONArray.toString();
            this.bdi.clear();
        }
        if (this.bdf == null) {
            Hb();
            return;
        }
        if (!TextUtils.isEmpty(str)) {
            try {
                if (Build.VERSION.SDK_INT >= 19) {
                    this.bdf.Hf().evaluateJavascript("javascript:getClientInfo(" + str + ")", null);
                } else {
                    this.bdf.Hf().loadUrl("javascript:getClientInfo(" + str + ")");
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        this.bdj.sendEmptyMessageDelayed(1001, 1000L);
    }

    private void Hb() {
        if (this.bdi != null) {
            this.bdi.clear();
        }
        if (this.bdj != null) {
            this.bdj.removeMessages(1001);
        }
        Hc();
    }

    private void Hc() {
        if (this.bdk != null) {
            MessageManager.getInstance().unRegisterListener(this.bdk);
            this.bdk = null;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: com.baidu.live.sdk.goods.d.a$a  reason: collision with other inner class name */
    /* loaded from: classes3.dex */
    public static class HandlerC0178a extends Handler {
        private final WeakReference<a> bdn;

        HandlerC0178a(a aVar) {
            this.bdn = new WeakReference<>(aVar);
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            super.handleMessage(message);
            if (this.bdn.get() != null && message.what == 1001) {
                this.bdn.get().Ha();
            }
        }
    }
}
