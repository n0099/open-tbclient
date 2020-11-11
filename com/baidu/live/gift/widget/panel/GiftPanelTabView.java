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
    private static final String[] bfE = {"礼物", "背包"};
    private static boolean bfM = false;
    private a bfF;
    private int bfG;
    private int bfH;
    private int bfI;
    private int bfJ;
    private int bfK;
    private b bfL;
    private CustomMessageListener bfN;
    private MotionEvent mMotionEvent;

    /* loaded from: classes4.dex */
    public interface a {
        void ei(int i);
    }

    public GiftPanelTabView(Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        this.bfL = new b();
        this.bfN = new CustomMessageListener(2913228) { // from class: com.baidu.live.gift.widget.panel.GiftPanelTabView.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.live.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (GiftPanelTabView.this.getChildCount() >= 2) {
                    ImageView imageView = (ImageView) ((FrameLayout) GiftPanelTabView.this.getChildAt(1)).findViewById(a.f.icon_new_unlock_gift);
                    GiftPanelTabView.this.bfL.sendMessage((customResponsedMessage.getData() != null && (customResponsedMessage.getData() instanceof Boolean) && ((Boolean) customResponsedMessage.getData()).booleanValue()) ? Message.obtain(GiftPanelTabView.this.bfL, 1, imageView) : Message.obtain(GiftPanelTabView.this.bfL, 0, imageView));
                }
            }
        };
        init();
    }

    public void setCallback(a aVar) {
        this.bfF = aVar;
    }

    public void setColors(int i, int i2, int i3, int i4) {
        this.bfG = i;
        this.bfH = i2;
        this.bfI = i3;
        this.bfJ = i4;
        refreshUI();
    }

    public int getSelect() {
        return this.bfK;
    }

    public void setSelect(int i) {
        if (i >= 0 && i < getChildCount()) {
            this.bfK = i;
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
                ((ImageView) ((FrameLayout) getChildAt(1)).findViewById(a.f.icon_new_unlock_gift)).setVisibility(8);
                bfM = false;
            }
            if (findPosByView != -1 && findPosByView != this.bfK && this.bfF != null) {
                this.bfF.ei(findPosByView);
            }
        }
        return true;
    }

    private void init() {
        setClickable(true);
        Kv();
        setOrientation(0);
        MessageManager.getInstance().registerListener(this.bfN);
        Kw();
        Kx();
        Ku();
    }

    private void Ku() {
        ImageView imageView = (ImageView) ((FrameLayout) getChildAt(1)).findViewById(a.f.icon_new_unlock_gift);
        if (bfM) {
            imageView.setVisibility(0);
        } else {
            imageView.setVisibility(8);
        }
    }

    private void Kv() {
        GradientDrawable gradientDrawable = new GradientDrawable();
        gradientDrawable.setColor(0);
        gradientDrawable.setCornerRadius(getResources().getDimensionPixelOffset(a.d.sdk_ds26));
        setBackgroundDrawable(gradientDrawable);
    }

    private void Kw() {
        this.bfG = -13815746;
        this.bfH = -15987436;
        this.bfI = -1;
        this.bfJ = -13289398;
    }

    private void Kx() {
        int dimensionPixelOffset = getResources().getDimensionPixelOffset(a.d.sdk_ds20);
        for (int i = 0; i <= 1; i++) {
            addView(C(i, dimensionPixelOffset), new LinearLayout.LayoutParams(-2, -1));
        }
    }

    private FrameLayout C(int i, int i2) {
        FrameLayout frameLayout = (FrameLayout) LayoutInflater.from(getContext()).inflate(a.g.ala_gift_panel_tab_view, (ViewGroup) null);
        TextView textView = (TextView) frameLayout.findViewById(a.f.text_view);
        textView.setPadding(i2, 0, i2, 0);
        textView.setSelected(false);
        textView.setText(bfE[i]);
        textView.setTextSize(0, getResources().getDimensionPixelOffset(a.d.sdk_fontsize28));
        ((ImageView) frameLayout.findViewById(a.f.icon_new_unlock_gift)).setVisibility(8);
        float dimensionPixelOffset = getResources().getDimensionPixelOffset(a.d.sdk_ds26);
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
                        ((GradientDrawable) background).setColor(i2 == this.bfK ? this.bfG : this.bfH);
                        childAt.setBackgroundDrawable(background);
                    }
                    if (childAt instanceof FrameLayout) {
                        ((TextView) childAt.findViewById(a.f.text_view)).setTextColor(i2 == this.bfK ? this.bfI : this.bfJ);
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
        MessageManager.getInstance().unRegisterListener(this.bfN);
        if (this.bfL != null) {
            this.bfL.removeCallbacksAndMessages(null);
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
                boolean unused = GiftPanelTabView.bfM = true;
                return;
            }
            imageView.setVisibility(8);
            boolean unused2 = GiftPanelTabView.bfM = false;
        }
    }
}
