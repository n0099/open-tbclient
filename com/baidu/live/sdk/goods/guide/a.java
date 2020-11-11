package com.baidu.live.sdk.goods.guide;

import android.content.Context;
import android.os.Handler;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.baidu.live.data.bn;
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
/* loaded from: classes4.dex */
public class a {
    private String aVy;
    private View.OnClickListener bsp;
    private View bsq;
    private View bsr;
    private boolean bss;
    private Handler handler = new Handler();
    private long liveId;
    private Context mContext;
    private String otherParams;
    private long roomId;

    public void setOutClickListener(View.OnClickListener onClickListener) {
        this.bsp = onClickListener;
    }

    public void a(final Context context, AudienceLiveGoodsEnterView audienceLiveGoodsEnterView, long j, long j2, String str, String str2, List<com.baidu.live.sdk.goods.a.a> list) {
        if (audienceLiveGoodsEnterView != null && audienceLiveGoodsEnterView.getRootLayout() != null && audienceLiveGoodsEnterView.getRootLayout().getParent() != null && list != null && !list.isEmpty()) {
            final ViewGroup targetView = audienceLiveGoodsEnterView.getTargetView();
            com.baidu.live.sdk.goods.a.a aVar = list.get((int) (Math.random() * list.size()));
            this.liveId = j;
            this.roomId = j2;
            this.aVy = str;
            this.otherParams = str2;
            bn bnVar = com.baidu.live.aa.a.PQ().btT;
            int i = 0;
            if (bnVar != null && bnVar.aPB != null) {
                i = bnVar.aPB.aSd;
            }
            if (i <= 0) {
                i = 7;
            }
            this.mContext = context;
            this.bsr = audienceLiveGoodsEnterView.getRootLayout();
            this.bsq = a(context, aVar);
            this.handler.post(new Runnable() { // from class: com.baidu.live.sdk.goods.guide.a.1
                @Override // java.lang.Runnable
                public void run() {
                    a.this.a(context, targetView, a.this.bsr, a.this.bsq);
                }
            });
            this.handler.postDelayed(new Runnable() { // from class: com.baidu.live.sdk.goods.guide.a.2
                @Override // java.lang.Runnable
                public void run() {
                    a.this.PA();
                }
            }, i * 1000);
        }
    }

    private View a(Context context, com.baidu.live.sdk.goods.a.a aVar) {
        View inflate = View.inflate(context, a.g.toast_goods_guide, null);
        TbImageView tbImageView = (TbImageView) inflate.findViewById(a.f.conver_imageView);
        tbImageView.setDefaultBgResource(a.e.sdk_shape_transparent);
        if (!TextUtils.isEmpty(aVar.brY)) {
            try {
                JSONArray jSONArray = new JSONArray(aVar.brY);
                if (jSONArray.length() > 0) {
                    tbImageView.startLoad(jSONArray.optJSONObject(0).optString("src"), 10, false);
                }
            } catch (JSONException e) {
                e.printStackTrace();
            }
        }
        TextView textView = (TextView) inflate.findViewById(a.f.title_textView);
        TextView textView2 = (TextView) inflate.findViewById(a.f.price_textView);
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
                a.this.PA();
                if (a.this.bsp != null) {
                    a.this.bsp.onClick(view);
                }
                LogManager.getLiveGoodsLogger().doClickGoodsGuideLog(a.this.liveId + "", a.this.roomId + "", a.this.aVy, a.this.otherParams);
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
            this.bss = true;
            view2.measure(0, 0);
            int[] iArr = new int[2];
            view.getLocationInWindow(iArr);
            int width = view.getWidth();
            if (width <= 0) {
                view.measure(0, 0);
                width = view.getMeasuredWidth();
            }
            int measuredWidth = (((width / 2) + iArr[0]) - (view2.getMeasuredWidth() / 2)) - context.getResources().getDimensionPixelSize(a.d.sdk_ds10);
            RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, -2);
            layoutParams.addRule(12);
            layoutParams.addRule(9);
            layoutParams.leftMargin = measuredWidth;
            layoutParams.bottomMargin = context.getResources().getDimensionPixelSize(a.d.sdk_ds90);
            viewGroup.addView(view2, layoutParams);
            if (!ILiveGoodsLogger.displayGoodsGuideMap.contains(Long.valueOf(this.liveId))) {
                ILiveGoodsLogger.displayGoodsGuideMap.add(Long.valueOf(this.liveId));
                LogManager.getLiveGoodsLogger().doDisplayGoodsGuideLog(this.liveId + "", this.roomId + "", this.aVy, this.otherParams);
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

    public void dX(int i) {
        if (this.bss && this.handler != null) {
            this.handler.postDelayed(new Runnable() { // from class: com.baidu.live.sdk.goods.guide.a.4
                @Override // java.lang.Runnable
                public void run() {
                    if (a.this.bss) {
                        a.this.Pz();
                    }
                }
            }, 100L);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Pz() {
        RelativeLayout.LayoutParams layoutParams;
        if (this.bss && this.bsq != null && this.bsq.getVisibility() == 0 && this.bsq.getParent() != null && this.mContext != null && this.bsr != null && this.bsr.getVisibility() == 0 && (layoutParams = (RelativeLayout.LayoutParams) this.bsq.getLayoutParams()) != null) {
            this.bsq.measure(0, 0);
            int[] iArr = new int[2];
            this.bsr.getLocationInWindow(iArr);
            int width = this.bsr.getWidth();
            if (width <= 0) {
                this.bsr.measure(0, 0);
                width = this.bsr.getMeasuredWidth();
            }
            layoutParams.leftMargin = (((width / 2) + iArr[0]) - (this.bsq.getMeasuredWidth() / 2)) - this.mContext.getResources().getDimensionPixelSize(a.d.sdk_ds10);
            this.bsq.setLayoutParams(layoutParams);
        }
    }

    public void PA() {
        this.bss = false;
        if (this.handler != null) {
            this.handler.removeCallbacksAndMessages(null);
        }
        if (this.bsq != null && this.bsq.getParent() != null) {
            ((ViewGroup) this.bsq.getParent()).removeView(this.bsq);
        }
    }

    public void release() {
        this.bss = false;
        PA();
    }

    public boolean isShow() {
        return this.bss;
    }
}
