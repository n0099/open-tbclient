package com.baidu.live.sdk.goods.guide;

import android.content.Context;
import android.os.Handler;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.baidu.live.data.be;
import com.baidu.live.sdk.a;
import com.baidu.live.sdk.goods.view.AudienceLiveGoodsEnterView;
import com.baidu.live.tbadk.TbConfig;
import com.baidu.live.tbadk.core.util.StringHelper;
import com.baidu.live.tbadk.log.ILiveGoodsLogger;
import com.baidu.live.tbadk.log.LogManager;
import com.baidu.live.tbadk.ubc.UbcStatConstant;
import com.baidu.live.tbadk.ubc.UbcStatisticItem;
import com.baidu.live.tbadk.ubc.UbcStatisticLiveKey;
import com.baidu.live.tbadk.ubc.UbcStatisticManager;
import com.baidu.live.tbadk.widget.TbImageView;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes7.dex */
public class a {
    private String aNZ;
    private View biA;
    private View biB;
    private boolean biC;
    private View.OnClickListener biz;
    private Handler handler = new Handler();
    private long liveId;
    private Context mContext;
    private String otherParams;
    private long roomId;

    public void setOutClickListener(View.OnClickListener onClickListener) {
        this.biz = onClickListener;
    }

    public void a(final Context context, AudienceLiveGoodsEnterView audienceLiveGoodsEnterView, long j, long j2, String str, String str2, List<com.baidu.live.sdk.goods.a.a> list) {
        if (audienceLiveGoodsEnterView != null && audienceLiveGoodsEnterView.getRootLayout() != null && audienceLiveGoodsEnterView.getRootLayout().getParent() != null && list != null && !list.isEmpty()) {
            final ViewGroup targetView = audienceLiveGoodsEnterView.getTargetView();
            com.baidu.live.sdk.goods.a.a aVar = list.get((int) (Math.random() * list.size()));
            this.liveId = j;
            this.roomId = j2;
            this.aNZ = str;
            this.otherParams = str2;
            be beVar = com.baidu.live.w.a.Nk().bka;
            int i = 0;
            if (beVar != null && beVar.aJC != null) {
                i = beVar.aJC.aLB;
            }
            if (i <= 0) {
                i = 7;
            }
            this.mContext = context;
            this.biB = audienceLiveGoodsEnterView.getRootLayout();
            this.biA = a(context, aVar);
            this.handler.post(new Runnable() { // from class: com.baidu.live.sdk.goods.guide.a.1
                @Override // java.lang.Runnable
                public void run() {
                    a.this.a(context, targetView, a.this.biB, a.this.biA);
                }
            });
            this.handler.postDelayed(new Runnable() { // from class: com.baidu.live.sdk.goods.guide.a.2
                @Override // java.lang.Runnable
                public void run() {
                    a.this.MT();
                }
            }, i * 1000);
        }
    }

    private View a(Context context, com.baidu.live.sdk.goods.a.a aVar) {
        View inflate = View.inflate(context, a.h.toast_goods_guide, null);
        TbImageView tbImageView = (TbImageView) inflate.findViewById(a.g.conver_imageView);
        tbImageView.setDefaultBgResource(a.f.sdk_shape_transparent);
        if (!TextUtils.isEmpty(aVar.bih)) {
            try {
                JSONArray jSONArray = new JSONArray(aVar.bih);
                if (jSONArray.length() > 0) {
                    tbImageView.startLoad(jSONArray.optJSONObject(0).optString("src"), 10, false);
                }
            } catch (JSONException e) {
                e.printStackTrace();
            }
        }
        TextView textView = (TextView) inflate.findViewById(a.g.title_textView);
        TextView textView2 = (TextView) inflate.findViewById(a.g.price_textView);
        String str = aVar.title;
        if (str == null) {
            str = "";
        } else if (str.length() > 8) {
            str = str.substring(0, 8) + StringHelper.STRING_MORE;
        }
        textView.setText(str);
        textView2.setText(aVar.price);
        inflate.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.live.sdk.goods.guide.a.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                a.this.MT();
                if (a.this.biz != null) {
                    a.this.biz.onClick(view);
                }
                LogManager.getLiveGoodsLogger().doClickGoodsGuideLog(a.this.liveId + "", a.this.roomId + "", a.this.aNZ, a.this.otherParams);
                try {
                    JSONObject jSONObject = new JSONObject();
                    jSONObject.put(UbcStatConstant.KEY_CONTENT_EXT_LIVESDK, TbConfig.getVersion());
                    UbcStatisticManager.getInstance().logEvent(new UbcStatisticItem(UbcStatisticLiveKey.KEY_ID_1396, "click", "liveroom", "petal_clk").setContentExt(jSONObject));
                } catch (JSONException e2) {
                    e2.printStackTrace();
                }
            }
        });
        return inflate;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(Context context, ViewGroup viewGroup, View view, View view2) {
        if (viewGroup != null) {
            this.biC = true;
            view2.measure(0, 0);
            int[] iArr = new int[2];
            view.getLocationInWindow(iArr);
            int width = view.getWidth();
            if (width <= 0) {
                view.measure(0, 0);
                width = view.getMeasuredWidth();
            }
            int measuredWidth = (((width / 2) + iArr[0]) - (view2.getMeasuredWidth() / 2)) - context.getResources().getDimensionPixelSize(a.e.sdk_ds10);
            RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, -2);
            layoutParams.addRule(12);
            layoutParams.addRule(9);
            layoutParams.leftMargin = measuredWidth;
            layoutParams.bottomMargin = context.getResources().getDimensionPixelSize(a.e.sdk_ds90);
            viewGroup.addView(view2, layoutParams);
            if (!ILiveGoodsLogger.displayGoodsGuideMap.contains(Long.valueOf(this.liveId))) {
                ILiveGoodsLogger.displayGoodsGuideMap.add(Long.valueOf(this.liveId));
                LogManager.getLiveGoodsLogger().doDisplayGoodsGuideLog(this.liveId + "", this.roomId + "", this.aNZ, this.otherParams);
            }
            UbcStatisticManager.getInstance().logEvent(new UbcStatisticItem(UbcStatisticLiveKey.KEY_ID_1394, "display", "liveroom", "shopcart_show"));
            try {
                JSONObject jSONObject = new JSONObject();
                jSONObject.put(UbcStatConstant.KEY_CONTENT_EXT_LIVESDK, TbConfig.getVersion());
                UbcStatisticManager.getInstance().logSendRequest(new UbcStatisticItem(UbcStatisticLiveKey.KEY_ID_1394, "show", "liveroom", "petal_show").setContentExt(jSONObject));
            } catch (JSONException e) {
                e.printStackTrace();
            }
        }
    }

    public void eD(int i) {
        if (this.biC && this.handler != null) {
            this.handler.postDelayed(new Runnable() { // from class: com.baidu.live.sdk.goods.guide.a.4
                @Override // java.lang.Runnable
                public void run() {
                    if (a.this.biC) {
                        a.this.MS();
                    }
                }
            }, 100L);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void MS() {
        RelativeLayout.LayoutParams layoutParams;
        if (this.biC && this.biA != null && this.biA.getVisibility() == 0 && this.biA.getParent() != null && this.mContext != null && this.biB != null && this.biB.getVisibility() == 0 && (layoutParams = (RelativeLayout.LayoutParams) this.biA.getLayoutParams()) != null) {
            this.biA.measure(0, 0);
            int[] iArr = new int[2];
            this.biB.getLocationInWindow(iArr);
            int width = this.biB.getWidth();
            if (width <= 0) {
                this.biB.measure(0, 0);
                width = this.biB.getMeasuredWidth();
            }
            layoutParams.leftMargin = (((width / 2) + iArr[0]) - (this.biA.getMeasuredWidth() / 2)) - this.mContext.getResources().getDimensionPixelSize(a.e.sdk_ds10);
            this.biA.setLayoutParams(layoutParams);
        }
    }

    public void MT() {
        this.biC = false;
        if (this.handler != null) {
            this.handler.removeCallbacksAndMessages(null);
        }
        if (this.biA != null && this.biA.getParent() != null) {
            ((ViewGroup) this.biA.getParent()).removeView(this.biA);
        }
    }

    public void release() {
        this.biC = false;
        MT();
    }

    public boolean isShow() {
        return this.biC;
    }
}
