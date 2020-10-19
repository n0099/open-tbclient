package com.baidu.live.gift.widget.panel;

import android.content.Context;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
import android.os.Handler;
import android.os.Message;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.baidu.live.adp.framework.MessageManager;
import com.baidu.live.adp.framework.listener.CustomMessageListener;
import com.baidu.live.adp.framework.message.CustomResponsedMessage;
import com.baidu.live.sdk.a;
/* loaded from: classes4.dex */
public class GiftPanelTabView extends LinearLayout {
    private static final String[] bcT = {"礼物", "背包"};
    private static boolean bdb = false;
    private a bcU;
    private int bcV;
    private int bcW;
    private int bcX;
    private int bcY;
    private int bcZ;
    private b bda;
    private CustomMessageListener bdc;
    private MotionEvent mMotionEvent;

    /* loaded from: classes4.dex */
    public interface a {
        void eh(int i);
    }

    public GiftPanelTabView(Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        this.bda = new b();
        this.bdc = new CustomMessageListener(2913228) { // from class: com.baidu.live.gift.widget.panel.GiftPanelTabView.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.live.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (GiftPanelTabView.this.getChildCount() >= 2) {
                    ImageView imageView = (ImageView) ((FrameLayout) GiftPanelTabView.this.getChildAt(1)).findViewById(a.g.icon_new_unlock_gift);
                    GiftPanelTabView.this.bda.sendMessage((customResponsedMessage.getData() != null && (customResponsedMessage.getData() instanceof Boolean) && ((Boolean) customResponsedMessage.getData()).booleanValue()) ? Message.obtain(GiftPanelTabView.this.bda, 1, imageView) : Message.obtain(GiftPanelTabView.this.bda, 0, imageView));
                }
            }
        };
        init();
    }

    public void setCallback(a aVar) {
        this.bcU = aVar;
    }

    public void setColors(int i, int i2, int i3, int i4) {
        this.bcV = i;
        this.bcW = i2;
        this.bcX = i3;
        this.bcY = i4;
        refreshUI();
    }

    public int getSelect() {
        return this.bcZ;
    }

    public void setSelect(int i) {
        if (i >= 0 && i < getChildCount()) {
            this.bcZ = i;
            refreshUI();
        }
    }

    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        if (motionEvent.getAction() == 1) {
            this.mMotionEvent = MotionEvent.obtain(motionEvent);
        }
        return super.onTouchEvent(motionEvent);
    }

    @Override // android.view.View
    public boolean performClick() {
        if (this.mMotionEvent == null) {
            return super.performClick();
        }
        View findChild = findChild((int) this.mMotionEvent.getX(), (int) this.mMotionEvent.getY());
        this.mMotionEvent = null;
        if (findChild != null) {
            int findPosByView = findPosByView(findChild);
            if (findPosByView == 1) {
                ((ImageView) ((FrameLayout) getChildAt(1)).findViewById(a.g.icon_new_unlock_gift)).setVisibility(8);
                bdb = false;
            }
            if (findPosByView != -1 && findPosByView != this.bcZ && this.bcU != null) {
                this.bcU.eh(findPosByView);
            }
        }
        return true;
    }

    private void init() {
        setClickable(true);
        JC();
        setOrientation(0);
        MessageManager.getInstance().registerListener(this.bdc);
        JD();
        JE();
        JB();
    }

    private void JB() {
        ImageView imageView = (ImageView) ((FrameLayout) getChildAt(1)).findViewById(a.g.icon_new_unlock_gift);
        if (bdb) {
            imageView.setVisibility(0);
        } else {
            imageView.setVisibility(8);
        }
    }

    private void JC() {
        GradientDrawable gradientDrawable = new GradientDrawable();
        gradientDrawable.setColor(0);
        gradientDrawable.setCornerRadius(getResources().getDimensionPixelOffset(a.e.sdk_ds26));
        setBackgroundDrawable(gradientDrawable);
    }

    private void JD() {
        this.bcV = -13815746;
        this.bcW = -15987436;
        this.bcX = -1;
        this.bcY = -13289398;
    }

    private void JE() {
        int dimensionPixelOffset = getResources().getDimensionPixelOffset(a.e.sdk_ds20);
        for (int i = 0; i <= 1; i++) {
            addView(C(i, dimensionPixelOffset), new LinearLayout.LayoutParams(-2, -1));
        }
    }

    private FrameLayout C(int i, int i2) {
        FrameLayout frameLayout = (FrameLayout) LayoutInflater.from(getContext()).inflate(a.h.ala_gift_panel_tab_view, (ViewGroup) null);
        TextView textView = (TextView) frameLayout.findViewById(a.g.text_view);
        textView.setPadding(i2, 0, i2, 0);
        textView.setSelected(false);
        textView.setText(bcT[i]);
        textView.setTextSize(0, getResources().getDimensionPixelOffset(a.e.sdk_fontsize28));
        ((ImageView) frameLayout.findViewById(a.g.icon_new_unlock_gift)).setVisibility(8);
        float dimensionPixelOffset = getResources().getDimensionPixelOffset(a.e.sdk_ds26);
        GradientDrawable gradientDrawable = new GradientDrawable();
        gradientDrawable.setShape(0);
        switch (i) {
            case 0:
                gradientDrawable.setCornerRadii(new float[]{dimensionPixelOffset, dimensionPixelOffset, 0.0f, 0.0f, 0.0f, 0.0f, dimensionPixelOffset, dimensionPixelOffset});
                break;
            case 1:
                gradientDrawable.setCornerRadii(new float[]{0.0f, 0.0f, dimensionPixelOffset, dimensionPixelOffset, dimensionPixelOffset, dimensionPixelOffset, 0.0f, 0.0f});
                break;
        }
        frameLayout.setBackgroundDrawable(gradientDrawable);
        return frameLayout;
    }

    private void refreshUI() {
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 < getChildCount()) {
                View childAt = getChildAt(i2);
                if (childAt != null) {
                    Drawable background = childAt.getBackground();
                    if (background instanceof GradientDrawable) {
                        ((GradientDrawable) background).setColor(i2 == this.bcZ ? this.bcV : this.bcW);
                        childAt.setBackgroundDrawable(background);
                    }
                    if (childAt instanceof FrameLayout) {
                        ((TextView) childAt.findViewById(a.g.text_view)).setTextColor(i2 == this.bcZ ? this.bcX : this.bcY);
                    }
                }
                i = i2 + 1;
            } else {
                return;
            }
        }
    }

    private View findChild(int i, int i2) {
        int childCount = getChildCount();
        for (int i3 = 0; i3 < childCount; i3++) {
            View childAt = getChildAt(i3);
            if (childAt.getVisibility() != 8) {
                Rect rect = new Rect();
                childAt.getHitRect(rect);
                if (rect.contains(i, i2)) {
                    return childAt;
                }
            }
        }
        return null;
    }

    private int findPosByView(View view) {
        int childCount = getChildCount();
        for (int i = 0; i < childCount; i++) {
            if (getChildAt(i) == view) {
                return i;
            }
        }
        return -1;
    }

    public void onDestroy() {
        MessageManager.getInstance().unRegisterListener(this.bdc);
        if (this.bda != null) {
            this.bda.removeCallbacksAndMessages(null);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes4.dex */
    public static class b extends Handler {
        private b() {
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            ImageView imageView = (ImageView) message.obj;
            if (message.what == 1) {
                imageView.setVisibility(0);
                boolean unused = GiftPanelTabView.bdb = true;
                return;
            }
            imageView.setVisibility(8);
            boolean unused2 = GiftPanelTabView.bdb = false;
        }
    }
}
