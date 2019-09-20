package com.baidu.poly.widget;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import com.baidu.poly.a;
import com.baidu.poly.b;
import com.baidu.poly.bean.PayChannel;
import com.baidu.poly.widget.ChannelItemView;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Map;
/* loaded from: classes2.dex */
public class ChannelListView extends FrameLayout implements View.OnClickListener {
    private View RJ;
    private View aiN;
    private TipView aiO;
    private ViewGroup aiP;
    private Bundle aiQ;
    private ProgressButton aiR;
    private a.c aiS;
    private PayChannel[] aiT;
    private boolean aiU;
    private boolean aiV;
    private int aiW;
    private a aiX;

    /* loaded from: classes2.dex */
    public interface a {
        void onClose();
    }

    public ChannelListView(Context context) {
        super(context);
        init();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static PayChannel[] a(String[] strArr, PayChannel[] payChannelArr) {
        if (strArr != null) {
            ArrayList arrayList = new ArrayList(Arrays.asList(payChannelArr));
            for (PayChannel payChannel : payChannelArr) {
                for (String str : strArr) {
                    if (payChannel != null && TextUtils.equals(str, payChannel.getPayChannel())) {
                        arrayList.remove(payChannel);
                    }
                }
            }
            return (PayChannel[]) arrayList.toArray(new PayChannel[arrayList.size()]);
        }
        return payChannelArr;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public PayChannel[] a(PayChannel[] payChannelArr) {
        int i = 0;
        for (PayChannel payChannel : payChannelArr) {
            if (payChannel.isSelected() && (i = i + 1) > 1) {
                payChannel.setSelected(false);
            }
            if (payChannel.isEnable()) {
                this.aiW++;
            }
        }
        if (i == 0) {
            int length = payChannelArr.length;
            int i2 = 0;
            while (true) {
                if (i2 >= length) {
                    break;
                }
                PayChannel payChannel2 = payChannelArr[i2];
                if (!payChannel2.isEnable()) {
                    i2++;
                } else {
                    payChannel2.setSelected(true);
                    break;
                }
            }
        }
        return payChannelArr;
    }

    public ChannelListView j(Bundle bundle) {
        this.aiQ = bundle;
        vb();
        return this;
    }

    public ChannelListView a(a.c cVar) {
        this.aiS = cVar;
        return this;
    }

    public ChannelListView a(a aVar) {
        this.aiX = aVar;
        return this;
    }

    private void init() {
        LayoutInflater.from(getContext()).inflate(b.e.view_channel_list, this);
        this.RJ = findViewById(b.d.bg_view);
        this.aiN = findViewById(b.d.popup_view);
        this.aiO = (TipView) findViewById(b.d.tip_view);
        this.aiP = (ViewGroup) findViewById(b.d.channel_list_view);
        this.aiR = (ProgressButton) findViewById(b.d.pay_button);
        findViewById(b.d.close_button).setOnClickListener(this);
        this.aiR.setOnClickListener(this);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void va() {
        this.aiO.setVisibility(8);
        this.RJ.setVisibility(0);
        this.aiN.setVisibility(0);
        this.RJ.setAlpha(0.0f);
        this.RJ.animate().alpha(0.65f).setDuration(240L).start();
        this.aiN.setAlpha(0.0f);
        this.aiN.setScaleX(0.75f);
        this.aiN.setScaleY(0.75f);
        this.aiN.animate().alpha(1.0f).scaleX(1.0f).scaleY(1.0f).setDuration(240L).start();
        this.aiR.setAlpha(this.aiW == 0 ? 0.2f : 1.0f);
        this.aiR.setEnable(this.aiW != 0);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void g(String str, boolean z) {
        this.aiO.setVisibility(0);
        this.aiO.setText(str);
        this.aiO.setLoading(z);
    }

    private void vb() {
        com.baidu.poly.a.a.a.uK().b(this.aiQ, new com.baidu.poly.a.a<PayChannel[]>() { // from class: com.baidu.poly.widget.ChannelListView.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.poly.a.a
            /* renamed from: c */
            public void onSuccess(PayChannel[] payChannelArr) {
                ChannelListView.this.aiT = ChannelListView.a(ChannelListView.this.aiQ.getStringArray("blockedPayChannels"), payChannelArr);
                if (ChannelListView.this.aiT.length == 1) {
                    ChannelListView.this.a(ChannelListView.this.aiT[0], new com.baidu.poly.a.a<Map<String, String>>() { // from class: com.baidu.poly.widget.ChannelListView.1.1
                        /* JADX DEBUG: Method merged with bridge method */
                        @Override // com.baidu.poly.a.a
                        /* renamed from: k */
                        public void onSuccess(Map<String, String> map) {
                            ChannelListView.this.detach();
                        }
                    });
                    return;
                }
                ChannelListView.this.b(ChannelListView.this.a(ChannelListView.this.aiT));
                ChannelListView.this.va();
            }

            @Override // com.baidu.poly.a.a
            public void d(Throwable th, String str) {
                ChannelListView channelListView = ChannelListView.this;
                if (str == null) {
                    str = "网络不给力，请稍后重试";
                }
                channelListView.g(str, false);
                ChannelListView.this.aiS.onFail("request channel fail");
                ChannelListView.this.postDelayed(new Runnable() { // from class: com.baidu.poly.widget.ChannelListView.1.2
                    @Override // java.lang.Runnable
                    public void run() {
                        ChannelListView.this.detach();
                    }
                }, 1000L);
            }
        });
    }

    public ChannelListView vc() {
        if (!(getContext() instanceof Activity)) {
            throw new IllegalStateException("can not attach to context " + getContext());
        }
        View decorView = ((Activity) getContext()).getWindow().getDecorView();
        if (decorView instanceof ViewGroup) {
            ((ViewGroup) decorView).addView(this);
            g("收银台努力加载中...", true);
        }
        this.aiU = true;
        return this;
    }

    public void detach() {
        this.RJ.animate().alpha(0.0f).setDuration(240L).start();
        this.aiN.animate().alpha(0.0f).setDuration(240L).start();
        postDelayed(new Runnable() { // from class: com.baidu.poly.widget.ChannelListView.2
            @Override // java.lang.Runnable
            public void run() {
                if (ChannelListView.this.getParent() instanceof ViewGroup) {
                    ((ViewGroup) ChannelListView.this.getParent()).removeView(ChannelListView.this);
                }
                ChannelListView.this.aiU = false;
            }
        }, 240L);
        if (this.aiX != null) {
            this.aiX.onClose();
        }
    }

    public void b(final PayChannel[] payChannelArr) {
        if (payChannelArr != null) {
            this.aiP.removeAllViews();
            for (final PayChannel payChannel : payChannelArr) {
                ChannelItemView channelItemView = new ChannelItemView(getContext());
                channelItemView.setChannelInfo(payChannel, new ChannelItemView.a() { // from class: com.baidu.poly.widget.ChannelListView.3
                    @Override // com.baidu.poly.widget.ChannelItemView.a
                    public void uZ() {
                        PayChannel[] payChannelArr2 = payChannelArr;
                        int length = payChannelArr2.length;
                        for (int i = 0; i < length; i++) {
                            PayChannel payChannel2 = payChannelArr2[i];
                            payChannel2.setSelected(payChannel2 == payChannel);
                        }
                        ChannelListView.this.b(payChannelArr);
                    }
                });
                this.aiP.addView(channelItemView);
            }
        }
    }

    public boolean vd() {
        return this.aiU;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        PayChannel[] payChannelArr;
        if (view.getId() == b.d.close_button) {
            if (this.aiS != null) {
                this.aiS.onCancel("支付取消");
            }
            detach();
        } else if (view.getId() == b.d.pay_button && this.aiW != 0) {
            this.aiR.startLoading();
            this.aiV = true;
            for (PayChannel payChannel : this.aiT) {
                if (payChannel.isSelected()) {
                    a(payChannel);
                }
            }
        }
    }

    private void a(PayChannel payChannel) {
        a(payChannel, (com.baidu.poly.a.a<Map<String, String>>) null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(PayChannel payChannel, com.baidu.poly.a.a<Map<String, String>> aVar) {
        com.baidu.poly.d.b.uV().a(this.aiQ, payChannel, new a.c() { // from class: com.baidu.poly.widget.ChannelListView.4
            @Override // com.baidu.poly.a.c
            public void onResult(int i, String str) {
                ChannelListView.this.detach();
                ChannelListView.this.aiV = false;
                ChannelListView.this.aiS.onResult(i, str);
            }

            @Override // com.baidu.poly.a.c
            public void onFail(String str) {
                ChannelListView.this.g(str != null ? str : "网络不给力，请稍后重试", false);
                ChannelListView.this.detach();
                ChannelListView.this.aiV = false;
                if (TextUtils.isEmpty(str)) {
                    ChannelListView.this.aiS.onResult(0, "网络不给力，请稍后重试");
                } else {
                    ChannelListView.this.aiS.onResult(0, str);
                }
            }

            @Override // com.baidu.poly.a.c
            public void onCancel(String str) {
                ChannelListView.this.detach();
                ChannelListView.this.aiV = false;
                ChannelListView.this.aiS.onResult(0, str);
            }
        }, aVar);
    }

    @Override // android.view.ViewGroup, android.view.View
    public boolean dispatchTouchEvent(MotionEvent motionEvent) {
        return this.aiV || super.dispatchTouchEvent(motionEvent);
    }
}
