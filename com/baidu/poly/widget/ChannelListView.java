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
    private View TH;
    private int ahA;
    private a ahB;
    private View ahr;
    private TipView ahs;
    private ViewGroup aht;
    private Bundle ahu;
    private ProgressButton ahv;
    private a.c ahw;
    private PayChannel[] ahx;
    private boolean ahy;
    private boolean ahz;

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
                this.ahA++;
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
        this.ahu = bundle;
        tN();
        return this;
    }

    public ChannelListView a(a.c cVar) {
        this.ahw = cVar;
        return this;
    }

    public ChannelListView a(a aVar) {
        this.ahB = aVar;
        return this;
    }

    private void init() {
        LayoutInflater.from(getContext()).inflate(b.d.view_channel_list, this);
        this.TH = findViewById(b.c.bg_view);
        this.ahr = findViewById(b.c.popup_view);
        this.ahs = (TipView) findViewById(b.c.tip_view);
        this.aht = (ViewGroup) findViewById(b.c.channel_list_view);
        this.ahv = (ProgressButton) findViewById(b.c.pay_button);
        findViewById(b.c.close_button).setOnClickListener(this);
        this.ahv.setOnClickListener(this);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void tM() {
        this.ahs.setVisibility(8);
        this.TH.setVisibility(0);
        this.ahr.setVisibility(0);
        this.TH.setAlpha(0.0f);
        this.TH.animate().alpha(0.65f).setDuration(240L).start();
        this.ahr.setAlpha(0.0f);
        this.ahr.setScaleX(0.75f);
        this.ahr.setScaleY(0.75f);
        this.ahr.animate().alpha(1.0f).scaleX(1.0f).scaleY(1.0f).setDuration(240L).start();
        this.ahv.setAlpha(this.ahA == 0 ? 0.2f : 1.0f);
        this.ahv.setEnable(this.ahA != 0);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void h(String str, boolean z) {
        this.ahs.setVisibility(0);
        this.ahs.setText(str);
        this.ahs.setLoading(z);
    }

    private void tN() {
        com.baidu.poly.a.a.a.tw().c(this.ahu, new com.baidu.poly.a.a<PayChannel[]>() { // from class: com.baidu.poly.widget.ChannelListView.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.poly.a.a
            /* renamed from: c */
            public void onSuccess(PayChannel[] payChannelArr) {
                ChannelListView.this.ahx = ChannelListView.a(ChannelListView.this.ahu.getStringArray("blockedPayChannels"), payChannelArr);
                if (ChannelListView.this.ahx.length == 1) {
                    ChannelListView.this.a(ChannelListView.this.ahx[0], new com.baidu.poly.a.a<Map<String, String>>() { // from class: com.baidu.poly.widget.ChannelListView.1.1
                        /* JADX DEBUG: Method merged with bridge method */
                        @Override // com.baidu.poly.a.a
                        /* renamed from: k */
                        public void onSuccess(Map<String, String> map) {
                            ChannelListView.this.detach();
                        }
                    });
                    return;
                }
                ChannelListView.this.b(ChannelListView.this.a(ChannelListView.this.ahx));
                ChannelListView.this.tM();
            }

            @Override // com.baidu.poly.a.a
            public void d(Throwable th, String str) {
                ChannelListView channelListView = ChannelListView.this;
                if (str == null) {
                    str = "网络不给力，请稍后重试";
                }
                channelListView.h(str, false);
                ChannelListView.this.ahw.onFail("request channel fail");
                ChannelListView.this.postDelayed(new Runnable() { // from class: com.baidu.poly.widget.ChannelListView.1.2
                    @Override // java.lang.Runnable
                    public void run() {
                        ChannelListView.this.detach();
                    }
                }, 1000L);
            }
        });
    }

    public ChannelListView tO() {
        if (!(getContext() instanceof Activity)) {
            throw new IllegalStateException("can not attach to context " + getContext());
        }
        View decorView = ((Activity) getContext()).getWindow().getDecorView();
        if (decorView instanceof ViewGroup) {
            ((ViewGroup) decorView).addView(this);
            h("收银台努力加载中...", true);
        }
        this.ahy = true;
        return this;
    }

    public void detach() {
        this.TH.animate().alpha(0.0f).setDuration(240L).start();
        this.ahr.animate().alpha(0.0f).setDuration(240L).start();
        postDelayed(new Runnable() { // from class: com.baidu.poly.widget.ChannelListView.2
            @Override // java.lang.Runnable
            public void run() {
                if (ChannelListView.this.getParent() instanceof ViewGroup) {
                    ((ViewGroup) ChannelListView.this.getParent()).removeView(ChannelListView.this);
                }
                ChannelListView.this.ahy = false;
            }
        }, 240L);
        if (this.ahB != null) {
            this.ahB.onClose();
        }
    }

    public void b(final PayChannel[] payChannelArr) {
        if (payChannelArr != null) {
            this.aht.removeAllViews();
            for (final PayChannel payChannel : payChannelArr) {
                ChannelItemView channelItemView = new ChannelItemView(getContext());
                channelItemView.setChannelInfo(payChannel, new ChannelItemView.a() { // from class: com.baidu.poly.widget.ChannelListView.3
                    @Override // com.baidu.poly.widget.ChannelItemView.a
                    public void tL() {
                        PayChannel[] payChannelArr2 = payChannelArr;
                        int length = payChannelArr2.length;
                        for (int i = 0; i < length; i++) {
                            PayChannel payChannel2 = payChannelArr2[i];
                            payChannel2.setSelected(payChannel2 == payChannel);
                        }
                        ChannelListView.this.b(payChannelArr);
                    }
                });
                this.aht.addView(channelItemView);
            }
        }
    }

    public boolean tP() {
        return this.ahy;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        PayChannel[] payChannelArr;
        if (view.getId() == b.c.close_button) {
            if (this.ahw != null) {
                this.ahw.onCancel("支付取消");
            }
            detach();
        } else if (view.getId() == b.c.pay_button && this.ahA != 0) {
            this.ahv.startLoading();
            this.ahz = true;
            for (PayChannel payChannel : this.ahx) {
                if (payChannel.isSelected()) {
                    a(payChannel);
                    detach();
                }
            }
        }
    }

    private void a(PayChannel payChannel) {
        a(payChannel, (com.baidu.poly.a.a<Map<String, String>>) null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(PayChannel payChannel, com.baidu.poly.a.a<Map<String, String>> aVar) {
        com.baidu.poly.d.b.tH().a(this.ahu, payChannel.getPayChannel(), new a.c() { // from class: com.baidu.poly.widget.ChannelListView.4
            @Override // com.baidu.poly.a.c
            public void onResult(int i, String str) {
                ChannelListView.this.detach();
                ChannelListView.this.ahz = false;
                ChannelListView.this.ahw.onResult(i, str);
            }

            @Override // com.baidu.poly.a.c
            public void onFail(String str) {
                ChannelListView.this.h(str != null ? str : "网络不给力，请稍后重试", false);
                ChannelListView.this.detach();
                ChannelListView.this.ahz = false;
                if (TextUtils.isEmpty(str)) {
                    ChannelListView.this.ahw.onResult(0, "网络不给力，请稍后重试");
                } else {
                    ChannelListView.this.ahw.onResult(0, str);
                }
            }

            @Override // com.baidu.poly.a.c
            public void onCancel(String str) {
                ChannelListView.this.detach();
                ChannelListView.this.ahz = false;
                ChannelListView.this.ahw.onResult(0, str);
            }
        }, aVar);
    }

    @Override // android.view.ViewGroup, android.view.View
    public boolean dispatchTouchEvent(MotionEvent motionEvent) {
        return this.ahz || super.dispatchTouchEvent(motionEvent);
    }
}
