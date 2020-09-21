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
import com.baidu.live.adp.framework.message.CustomMessage;
import com.baidu.live.adp.framework.message.CustomResponsedMessage;
import com.baidu.live.adp.framework.task.CustomMessageTask;
import com.baidu.live.sdk.a;
/* loaded from: classes4.dex */
public class GiftPanelTabView extends LinearLayout {
    private a aZA;
    private int aZB;
    private int aZC;
    private int aZD;
    private int aZE;
    private int aZF;
    private b aZG;
    private MotionEvent mMotionEvent;
    private static final String[] aZz = {"礼物", "背包"};
    private static boolean aZH = false;

    /* loaded from: classes4.dex */
    public interface a {
        void ec(int i);
    }

    public GiftPanelTabView(Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        this.aZG = new b();
        init();
    }

    public void setCallback(a aVar) {
        this.aZA = aVar;
    }

    public void setColors(int i, int i2, int i3, int i4) {
        this.aZB = i;
        this.aZC = i2;
        this.aZD = i3;
        this.aZE = i4;
        refreshUI();
    }

    public int getSelect() {
        return this.aZF;
    }

    public void setSelect(int i) {
        if (i >= 0 && i < getChildCount()) {
            this.aZF = i;
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
                aZH = false;
            }
            if (findPosByView != -1 && findPosByView != this.aZF && this.aZA != null) {
                this.aZA.ec(findPosByView);
            }
        }
        return true;
    }

    private void init() {
        setClickable(true);
        IF();
        setOrientation(0);
        initListener();
        IG();
        IH();
        IE();
    }

    private void IE() {
        ImageView imageView = (ImageView) ((FrameLayout) getChildAt(1)).findViewById(a.g.icon_new_unlock_gift);
        if (aZH) {
            imageView.setVisibility(0);
        } else {
            imageView.setVisibility(8);
        }
    }

    private void initListener() {
        MessageManager.getInstance().registerTask(new CustomMessageTask(2913228, new CustomMessageTask.CustomRunnable() { // from class: com.baidu.live.gift.widget.panel.GiftPanelTabView.1
            @Override // com.baidu.live.adp.framework.task.CustomMessageTask.CustomRunnable
            public CustomResponsedMessage<?> run(CustomMessage customMessage) {
                if (GiftPanelTabView.this.getChildCount() >= 2) {
                    ImageView imageView = (ImageView) ((FrameLayout) GiftPanelTabView.this.getChildAt(1)).findViewById(a.g.icon_new_unlock_gift);
                    GiftPanelTabView.this.aZG.sendMessage(((Boolean) customMessage.getData()).booleanValue() ? Message.obtain(GiftPanelTabView.this.aZG, 1, imageView) : Message.obtain(GiftPanelTabView.this.aZG, 0, imageView));
                    return null;
                }
                return null;
            }
        }));
    }

    private void IF() {
        GradientDrawable gradientDrawable = new GradientDrawable();
        gradientDrawable.setColor(0);
        gradientDrawable.setCornerRadius(getResources().getDimensionPixelOffset(a.e.sdk_ds26));
        setBackgroundDrawable(gradientDrawable);
    }

    private void IG() {
        this.aZB = -13815746;
        this.aZC = -15987436;
        this.aZD = -1;
        this.aZE = -13289398;
    }

    private void IH() {
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
        textView.setText(aZz[i]);
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
                        ((GradientDrawable) background).setColor(i2 == this.aZF ? this.aZB : this.aZC);
                        childAt.setBackgroundDrawable(background);
                    }
                    if (childAt instanceof FrameLayout) {
                        ((TextView) childAt.findViewById(a.g.text_view)).setTextColor(i2 == this.aZF ? this.aZD : this.aZE);
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

    /* loaded from: classes4.dex */
    private static class b extends Handler {
        private b() {
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            ImageView imageView = (ImageView) message.obj;
            if (message.what == 1) {
                imageView.setVisibility(0);
                boolean unused = GiftPanelTabView.aZH = true;
                return;
            }
            imageView.setVisibility(8);
            boolean unused2 = GiftPanelTabView.aZH = false;
        }
    }
}
