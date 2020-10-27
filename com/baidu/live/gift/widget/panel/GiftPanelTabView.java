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
    private static final String[] bei = {"礼物", "背包"};
    private static boolean beq = false;
    private a bej;
    private int bek;
    private int bel;
    private int bem;
    private int ben;
    private int beo;
    private b bep;
    private CustomMessageListener ber;
    private MotionEvent mMotionEvent;

    /* loaded from: classes4.dex */
    public interface a {
        void ei(int i);
    }

    public GiftPanelTabView(Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        this.bep = new b();
        this.ber = new CustomMessageListener(2913228) { // from class: com.baidu.live.gift.widget.panel.GiftPanelTabView.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.live.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (GiftPanelTabView.this.getChildCount() >= 2) {
                    ImageView imageView = (ImageView) ((FrameLayout) GiftPanelTabView.this.getChildAt(1)).findViewById(a.g.icon_new_unlock_gift);
                    GiftPanelTabView.this.bep.sendMessage((customResponsedMessage.getData() != null && (customResponsedMessage.getData() instanceof Boolean) && ((Boolean) customResponsedMessage.getData()).booleanValue()) ? Message.obtain(GiftPanelTabView.this.bep, 1, imageView) : Message.obtain(GiftPanelTabView.this.bep, 0, imageView));
                }
            }
        };
        init();
    }

    public void setCallback(a aVar) {
        this.bej = aVar;
    }

    public void setColors(int i, int i2, int i3, int i4) {
        this.bek = i;
        this.bel = i2;
        this.bem = i3;
        this.ben = i4;
        refreshUI();
    }

    public int getSelect() {
        return this.beo;
    }

    public void setSelect(int i) {
        if (i >= 0 && i < getChildCount()) {
            this.beo = i;
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
                beq = false;
            }
            if (findPosByView != -1 && findPosByView != this.beo && this.bej != null) {
                this.bej.ei(findPosByView);
            }
        }
        return true;
    }

    private void init() {
        setClickable(true);
        JV();
        setOrientation(0);
        MessageManager.getInstance().registerListener(this.ber);
        JW();
        JX();
        JU();
    }

    private void JU() {
        ImageView imageView = (ImageView) ((FrameLayout) getChildAt(1)).findViewById(a.g.icon_new_unlock_gift);
        if (beq) {
            imageView.setVisibility(0);
        } else {
            imageView.setVisibility(8);
        }
    }

    private void JV() {
        GradientDrawable gradientDrawable = new GradientDrawable();
        gradientDrawable.setColor(0);
        gradientDrawable.setCornerRadius(getResources().getDimensionPixelOffset(a.e.sdk_ds26));
        setBackgroundDrawable(gradientDrawable);
    }

    private void JW() {
        this.bek = -13815746;
        this.bel = -15987436;
        this.bem = -1;
        this.ben = -13289398;
    }

    private void JX() {
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
        textView.setText(bei[i]);
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
                        ((GradientDrawable) background).setColor(i2 == this.beo ? this.bek : this.bel);
                        childAt.setBackgroundDrawable(background);
                    }
                    if (childAt instanceof FrameLayout) {
                        ((TextView) childAt.findViewById(a.g.text_view)).setTextColor(i2 == this.beo ? this.bem : this.ben);
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
        MessageManager.getInstance().unRegisterListener(this.ber);
        if (this.bep != null) {
            this.bep.removeCallbacksAndMessages(null);
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
                boolean unused = GiftPanelTabView.beq = true;
                return;
            }
            imageView.setVisibility(8);
            boolean unused2 = GiftPanelTabView.beq = false;
        }
    }
}
