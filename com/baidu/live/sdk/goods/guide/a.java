package com.baidu.live.sdk.goods.guide;

import android.content.Context;
import android.os.Handler;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.baidu.live.data.bq;
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
/* loaded from: classes11.dex */
public class a {
    private String aYx;
    private View.OnClickListener bAA;
    private View bAB;
    private View bAC;
    private boolean bAD;
    private Handler handler = new Handler();
    private long liveId;
    private Context mContext;
    private String otherParams;
    private long roomId;

    public void setOutClickListener(View.OnClickListener onClickListener) {
        this.bAA = onClickListener;
    }

    public void a(final Context context, AudienceLiveGoodsEnterView audienceLiveGoodsEnterView, long j, long j2, String str, String str2, List<com.baidu.live.sdk.goods.a.a> list) {
        if (audienceLiveGoodsEnterView != null && audienceLiveGoodsEnterView.getRootLayout() != null && audienceLiveGoodsEnterView.getRootLayout().getParent() != null && list != null && !list.isEmpty()) {
            final ViewGroup targetView = audienceLiveGoodsEnterView.getTargetView();
            com.baidu.live.sdk.goods.a.a aVar = list.get((int) (Math.random() * list.size()));
            this.liveId = j;
            this.roomId = j2;
            this.aYx = str;
            this.otherParams = str2;
            bq bqVar = com.baidu.live.af.a.SE().bCb;
            int i = 0;
            if (bqVar != null && bqVar.aRF != null) {
                i = bqVar.aRF.aUs;
            }
            if (i <= 0) {
                i = 7;
            }
            this.mContext = context;
            this.bAC = audienceLiveGoodsEnterView.getRootLayout();
            this.bAB = a(context, aVar);
            this.handler.post(new Runnable() { // from class: com.baidu.live.sdk.goods.guide.a.1
                @Override // java.lang.Runnable
                public void run() {
                    a.this.a(context, targetView, a.this.bAC, a.this.bAB);
                }
            });
            this.handler.postDelayed(new Runnable() { // from class: com.baidu.live.sdk.goods.guide.a.2
                @Override // java.lang.Runnable
                public void run() {
                    a.this.So();
                }
            }, i * 1000);
        }
    }

    private View a(Context context, com.baidu.live.sdk.goods.a.a aVar) {
        View inflate = View.inflate(context, a.g.toast_goods_guide, null);
        TbImageView tbImageView = (TbImageView) inflate.findViewById(a.f.conver_imageView);
        tbImageView.setDefaultBgResource(a.e.sdk_shape_transparent);
        if (!TextUtils.isEmpty(aVar.bAj)) {
            try {
                JSONArray jSONArray = new JSONArray(aVar.bAj);
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
                a.this.So();
                if (a.this.bAA != null) {
                    a.this.bAA.onClick(view);
                }
                LogManager.getLiveGoodsLogger().doClickGoodsGuideLog(a.this.liveId + "", a.this.roomId + "", a.this.aYx, a.this.otherParams);
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
            this.bAD = true;
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
                LogManager.getLiveGoodsLogger().doDisplayGoodsGuideLog(this.liveId + "", this.roomId + "", this.aYx, this.otherParams);
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

    public void el(int i) {
        if (this.bAD && this.handler != null) {
            this.handler.postDelayed(new Runnable() { // from class: com.baidu.live.sdk.goods.guide.a.4
                @Override // java.lang.Runnable
                public void run() {
                    if (a.this.bAD) {
                        a.this.Sn();
                    }
                }
            }, 100L);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Sn() {
        RelativeLayout.LayoutParams layoutParams;
        if (this.bAD && this.bAB != null && this.bAB.getVisibility() == 0 && this.bAB.getParent() != null && this.mContext != null && this.bAC != null && this.bAC.getVisibility() == 0 && (layoutParams = (RelativeLayout.LayoutParams) this.bAB.getLayoutParams()) != null) {
            this.bAB.measure(0, 0);
            int[] iArr = new int[2];
            this.bAC.getLocationInWindow(iArr);
            int width = this.bAC.getWidth();
            if (width <= 0) {
                this.bAC.measure(0, 0);
                width = this.bAC.getMeasuredWidth();
            }
            layoutParams.leftMargin = (((width / 2) + iArr[0]) - (this.bAB.getMeasuredWidth() / 2)) - this.mContext.getResources().getDimensionPixelSize(a.d.sdk_ds10);
            this.bAB.setLayoutParams(layoutParams);
        }
    }

    public void So() {
        this.bAD = false;
        if (this.handler != null) {
            this.handler.removeCallbacksAndMessages(null);
        }
        if (this.bAB != null && this.bAB.getParent() != null) {
            ((ViewGroup) this.bAB.getParent()).removeView(this.bAB);
        }
    }

    public void release() {
        this.bAD = false;
        So();
    }

    public boolean isShow() {
        return this.bAD;
    }
}
