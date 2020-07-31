package com.baidu.live.sdk.goods.c;

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
import com.baidu.live.sdk.goods.c.b;
import com.baidu.live.tbadk.TbPageContext;
import com.baidu.live.view.d;
import com.baidu.live.view.web.f;
import com.baidu.searchbox.ugc.model.UgcConstant;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;
/* loaded from: classes4.dex */
public class a implements b.a, c, f {
    private CustomMessageListener aQz;
    private List<String> bdA;
    private HandlerC0180a bdB;
    private CustomMessageListener bdC;
    private b bdx;
    private d bdy;
    private boolean bdz;
    private TbPageContext mPageContext;

    public a(TbPageContext tbPageContext) {
        this.mPageContext = tbPageContext;
        BH();
    }

    @Override // com.baidu.live.sdk.goods.c.c
    public void u(String str, boolean z) {
        this.bdz = z;
        this.bdx = new b(this.mPageContext.getPageActivity());
        this.bdx.a((b.a) this);
        this.bdx.a((f) this);
        this.bdx.Hl().setBackgroundColor(fG(str));
        this.bdx.a(new b.InterfaceC0182b() { // from class: com.baidu.live.sdk.goods.c.a.1
            @Override // com.baidu.live.sdk.goods.c.b.InterfaceC0182b
            public void cb(boolean z2) {
                if (z2) {
                    a.this.Hd();
                }
            }
        });
        this.bdx.show(str);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Hd() {
        if (Build.VERSION.SDK_INT >= 19) {
            Hf();
            if (this.bdB == null) {
                this.bdB = new HandlerC0180a(this);
            }
            if (!this.bdB.hasMessages(1001)) {
                this.bdB.sendEmptyMessageDelayed(1001, 1000L);
            }
        }
    }

    @Override // com.baidu.live.sdk.goods.c.c
    public void resume() {
        if (this.bdx != null && this.bdx.isShowing() && this.bdx.Hl() != null) {
            this.bdx.Hl().onResume();
            if (this.bdz) {
                this.bdx.Hl().reload();
            }
        }
    }

    @Override // com.baidu.live.sdk.goods.c.c
    public void pause() {
        if (this.bdx != null && this.bdx.isShowing() && this.bdx.Hl() != null) {
            this.bdx.Hl().onPause();
        }
    }

    @Override // com.baidu.live.sdk.goods.c.c
    public void release() {
        He();
        MessageManager.getInstance().unRegisterListener(this.aQz);
        Hh();
    }

    @Override // com.baidu.live.sdk.goods.c.b.a
    public boolean a(String str, final JsResult jsResult) {
        this.bdy = new d(this.mPageContext.getPageActivity());
        this.bdy.setCancelable(false);
        this.bdy.setCanceledOnTouchOutside(false);
        this.bdy.cC(false);
        this.bdy.o(this.mPageContext.getString(a.i.sdk_live_disclaimer), str, this.mPageContext.getString(a.i.sdk_live_iknow), this.mPageContext.getString(a.i.sdk_live_cancel));
        this.bdy.a(new d.a() { // from class: com.baidu.live.sdk.goods.c.a.2
            @Override // com.baidu.live.view.d.a
            public void Hj() {
                if (jsResult != null) {
                    jsResult.confirm();
                }
            }

            @Override // com.baidu.live.view.d.a
            public void Hk() {
                if (jsResult != null) {
                    jsResult.cancel();
                }
            }
        });
        this.bdy.show();
        return true;
    }

    private void BH() {
        this.aQz = new CustomMessageListener(2913097) { // from class: com.baidu.live.sdk.goods.c.a.3
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.live.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage.getData() != null && (customResponsedMessage.getData() instanceof String) && TextUtils.equals((String) customResponsedMessage.getData(), "into_end_view")) {
                    a.this.He();
                }
            }
        };
        MessageManager.getInstance().registerListener(this.aQz);
    }

    private int fG(String str) {
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
    public void He() {
        if (this.bdx != null) {
            this.bdx.dismiss();
        }
        if (this.bdy != null) {
            this.bdy.release();
        }
    }

    @Override // com.baidu.live.view.web.f
    public void cN(int i) {
        He();
    }

    private void Hf() {
        if (this.bdA == null) {
            this.bdA = new ArrayList();
        }
        this.bdA.clear();
        if (this.bdC == null) {
            this.bdC = new CustomMessageListener(2913107) { // from class: com.baidu.live.sdk.goods.c.a.4
                /* JADX DEBUG: Method merged with bridge method */
                @Override // com.baidu.live.adp.framework.listener.MessageListener
                public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                    if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof List)) {
                        a.this.bdA.addAll((List) customResponsedMessage.getData());
                    }
                }
            };
            MessageManager.getInstance().registerListener(this.bdC);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Hg() {
        int size;
        String str = null;
        if (this.bdA != null && (size = this.bdA.size()) > 0) {
            JSONArray jSONArray = new JSONArray();
            for (int i = 0; i < size; i++) {
                jSONArray.put(this.bdA.get(i));
            }
            str = jSONArray.toString();
            this.bdA.clear();
        }
        if (this.bdx == null) {
            Hh();
            return;
        }
        if (!TextUtils.isEmpty(str)) {
            try {
                if (Build.VERSION.SDK_INT >= 19) {
                    this.bdx.Hl().evaluateJavascript("javascript:getClientInfo(" + str + ")", null);
                } else {
                    this.bdx.Hl().loadUrl("javascript:getClientInfo(" + str + ")");
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        this.bdB.sendEmptyMessageDelayed(1001, 1000L);
    }

    private void Hh() {
        if (this.bdA != null) {
            this.bdA.clear();
        }
        if (this.bdB != null) {
            this.bdB.removeMessages(1001);
        }
        Hi();
    }

    private void Hi() {
        if (this.bdC != null) {
            MessageManager.getInstance().unRegisterListener(this.bdC);
            this.bdC = null;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: com.baidu.live.sdk.goods.c.a$a  reason: collision with other inner class name */
    /* loaded from: classes4.dex */
    public static class HandlerC0180a extends Handler {
        private final WeakReference<a> bdF;

        HandlerC0180a(a aVar) {
            this.bdF = new WeakReference<>(aVar);
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            super.handleMessage(message);
            if (this.bdF.get() != null && message.what == 1001) {
                this.bdF.get().Hg();
            }
        }
    }
}
