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
    private View AG;
    private View aBS;
    private TipView aBT;
    private ViewGroup aBU;
    private Bundle aBV;
    private ProgressButton aBW;
    private a.c aBX;
    private PayChannel[] aBY;
    private boolean aBZ;
    private boolean aCa;
    private int aCb;
    private a aCc;

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
                this.aCb++;
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
        this.aBV = bundle;
        zW();
        return this;
    }

    public ChannelListView a(a.c cVar) {
        this.aBX = cVar;
        return this;
    }

    public ChannelListView a(a aVar) {
        this.aCc = aVar;
        return this;
    }

    private void init() {
        LayoutInflater.from(getContext()).inflate(b.e.view_channel_list, this);
        this.AG = findViewById(b.d.bg_view);
        this.aBS = findViewById(b.d.popup_view);
        this.aBT = (TipView) findViewById(b.d.tip_view);
        this.aBU = (ViewGroup) findViewById(b.d.channel_list_view);
        this.aBW = (ProgressButton) findViewById(b.d.pay_button);
        findViewById(b.d.close_button).setOnClickListener(this);
        this.aBW.setOnClickListener(this);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void zV() {
        this.aBT.setVisibility(8);
        this.AG.setVisibility(0);
        this.aBS.setVisibility(0);
        this.AG.setAlpha(0.0f);
        this.AG.animate().alpha(0.65f).setDuration(240L).start();
        this.aBS.setAlpha(0.0f);
        this.aBS.setScaleX(0.75f);
        this.aBS.setScaleY(0.75f);
        this.aBS.animate().alpha(1.0f).scaleX(1.0f).scaleY(1.0f).setDuration(240L).start();
        this.aBW.setAlpha(this.aCb == 0 ? 0.2f : 1.0f);
        this.aBW.setEnable(this.aCb != 0);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void j(String str, boolean z) {
        this.aBT.setVisibility(0);
        this.aBT.setText(str);
        this.aBT.setLoading(z);
    }

    private void zW() {
        com.baidu.poly.a.a.a.zF().b(this.aBV, new com.baidu.poly.a.a<PayChannel[]>() { // from class: com.baidu.poly.widget.ChannelListView.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.poly.a.a
            /* renamed from: c */
            public void onSuccess(PayChannel[] payChannelArr) {
                ChannelListView.this.aBY = ChannelListView.a(ChannelListView.this.aBV.getStringArray("blockedPayChannels"), payChannelArr);
                if (ChannelListView.this.aBY.length == 1) {
                    ChannelListView.this.a(ChannelListView.this.aBY[0], new com.baidu.poly.a.a<Map<String, String>>() { // from class: com.baidu.poly.widget.ChannelListView.1.1
                        /* JADX DEBUG: Method merged with bridge method */
                        @Override // com.baidu.poly.a.a
                        /* renamed from: l */
                        public void onSuccess(Map<String, String> map) {
                            ChannelListView.this.detach();
                        }
                    });
                    return;
                }
                ChannelListView.this.b(ChannelListView.this.a(ChannelListView.this.aBY));
                ChannelListView.this.zV();
            }

            @Override // com.baidu.poly.a.a
            public void c(Throwable th, String str) {
                ChannelListView channelListView = ChannelListView.this;
                if (str == null) {
                    str = "网络不给力，请稍后重试";
                }
                channelListView.j(str, false);
                ChannelListView.this.aBX.onFail("request channel fail");
                ChannelListView.this.postDelayed(new Runnable() { // from class: com.baidu.poly.widget.ChannelListView.1.2
                    @Override // java.lang.Runnable
                    public void run() {
                        ChannelListView.this.detach();
                    }
                }, 1000L);
            }
        });
    }

    public ChannelListView zX() {
        if (!(getContext() instanceof Activity)) {
            throw new IllegalStateException("can not attach to context " + getContext());
        }
        View decorView = ((Activity) getContext()).getWindow().getDecorView();
        if (decorView instanceof ViewGroup) {
            ((ViewGroup) decorView).addView(this);
            j("收银台努力加载中...", true);
        }
        this.aBZ = true;
        return this;
    }

    public void detach() {
        this.AG.animate().alpha(0.0f).setDuration(240L).start();
        this.aBS.animate().alpha(0.0f).setDuration(240L).start();
        postDelayed(new Runnable() { // from class: com.baidu.poly.widget.ChannelListView.2
            @Override // java.lang.Runnable
            public void run() {
                if (ChannelListView.this.getParent() instanceof ViewGroup) {
                    ((ViewGroup) ChannelListView.this.getParent()).removeView(ChannelListView.this);
                }
                ChannelListView.this.aBZ = false;
            }
        }, 240L);
        if (this.aCc != null) {
            this.aCc.onClose();
        }
    }

    public void b(final PayChannel[] payChannelArr) {
        if (payChannelArr != null) {
            this.aBU.removeAllViews();
            for (final PayChannel payChannel : payChannelArr) {
                ChannelItemView channelItemView = new ChannelItemView(getContext());
                channelItemView.setChannelInfo(payChannel, new ChannelItemView.a() { // from class: com.baidu.poly.widget.ChannelListView.3
                    @Override // com.baidu.poly.widget.ChannelItemView.a
                    public void zU() {
                        PayChannel[] payChannelArr2 = payChannelArr;
                        int length = payChannelArr2.length;
                        for (int i = 0; i < length; i++) {
                            PayChannel payChannel2 = payChannelArr2[i];
                            payChannel2.setSelected(payChannel2 == payChannel);
                        }
                        ChannelListView.this.b(payChannelArr);
                    }
                });
                this.aBU.addView(channelItemView);
            }
        }
    }

    public boolean zY() {
        return this.aBZ;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        PayChannel[] payChannelArr;
        if (view.getId() == b.d.close_button) {
            if (this.aBX != null) {
                this.aBX.onCancel("支付取消");
            }
            detach();
        } else if (view.getId() == b.d.pay_button && this.aCb != 0) {
            this.aBW.startLoading();
            this.aCa = true;
            for (PayChannel payChannel : this.aBY) {
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
        com.baidu.poly.d.b.zQ().a(this.aBV, payChannel, new a.c() { // from class: com.baidu.poly.widget.ChannelListView.4
            @Override // com.baidu.poly.a.c
            public void onResult(int i, String str) {
                ChannelListView.this.detach();
                ChannelListView.this.aCa = false;
                ChannelListView.this.aBX.onResult(i, str);
            }

            @Override // com.baidu.poly.a.c
            public void onFail(String str) {
                ChannelListView.this.j(str != null ? str : "网络不给力，请稍后重试", false);
                ChannelListView.this.detach();
                ChannelListView.this.aCa = false;
                if (TextUtils.isEmpty(str)) {
                    ChannelListView.this.aBX.onResult(0, "网络不给力，请稍后重试");
                } else {
                    ChannelListView.this.aBX.onResult(0, str);
                }
            }

            @Override // com.baidu.poly.a.c
            public void onCancel(String str) {
                ChannelListView.this.detach();
                ChannelListView.this.aCa = false;
                ChannelListView.this.aBX.onResult(0, str);
            }
        }, aVar);
    }

    @Override // android.view.ViewGroup, android.view.View
    public boolean dispatchTouchEvent(MotionEvent motionEvent) {
        return this.aCa || super.dispatchTouchEvent(motionEvent);
    }
}
