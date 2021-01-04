package com.baidu.live.im.view;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.LinearGradient;
import android.graphics.Paint;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffXfermode;
import android.graphics.Shader;
import android.graphics.drawable.ColorDrawable;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewConfiguration;
import android.widget.AbsListView;
import com.baidu.live.adp.framework.MessageManager;
import com.baidu.live.adp.framework.message.CustomMessage;
import com.baidu.live.adp.framework.message.CustomResponsedMessage;
import com.baidu.live.adp.widget.listview.BdTypeListView;
import com.baidu.live.im.j;
import com.baidu.live.sdk.a;
import com.baidu.live.tbadk.TbPageContext;
import com.baidu.live.tbadk.core.frameworkdata.CmdConfigCustom;
import java.util.List;
/* loaded from: classes11.dex */
public class ALAImMsgListView extends BdTypeListView implements j {
    private boolean bgw;
    private boolean boU;
    private float brm;
    private float brn;
    private com.baidu.live.im.a.a bro;
    private boolean brp;
    private boolean brq;
    private Paint brr;
    private int brs;
    private a brt;
    private boolean bru;
    private int direction;
    private boolean isScrolling;
    private boolean showShadow;

    /* loaded from: classes11.dex */
    public interface a {
        void Oo();
    }

    public ALAImMsgListView(Context context) {
        super(context);
        this.isScrolling = false;
        this.brp = true;
        this.brq = false;
        this.showShadow = false;
        this.bru = false;
        this.bgw = false;
        init();
    }

    public ALAImMsgListView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.isScrolling = false;
        this.brp = true;
        this.brq = false;
        this.showShadow = false;
        this.bru = false;
        this.bgw = false;
        init();
    }

    public ALAImMsgListView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.isScrolling = false;
        this.brp = true;
        this.brq = false;
        this.showShadow = false;
        this.bru = false;
        this.bgw = false;
        init();
    }

    public void setMode(boolean z) {
        this.bro.setMode(z);
    }

    public void setPageContext(TbPageContext tbPageContext) {
        if (this.bro == null) {
            this.bro = new com.baidu.live.im.a.a(tbPageContext, this);
        }
    }

    private void init() {
        setLayerType(1, null);
        setCacheColorHint(0);
        setDivider(new ColorDrawable(getResources().getColor(17170445)));
        setDividerHeight(getResources().getDimensionPixelSize(a.d.sdk_ds8));
        setSelector(17170445);
        setFastScrollEnabled(false);
        setVerticalScrollBarEnabled(false);
        setOnScrollListener(new AbsListView.OnScrollListener() { // from class: com.baidu.live.im.view.ALAImMsgListView.1
            @Override // android.widget.AbsListView.OnScrollListener
            public void onScrollStateChanged(AbsListView absListView, int i) {
                View childAt;
                if (i == 0 && !ALAImMsgListView.this.showShadow && (childAt = absListView.getChildAt(0)) != null && childAt.getTop() < 0) {
                    ALAImMsgListView.this.showShadow = true;
                    ALAImMsgListView.this.invalidate();
                }
                if (i == 1) {
                    ALAImMsgListView.this.bru = true;
                } else if (i == 0 && ALAImMsgListView.this.bru) {
                    ALAImMsgListView.this.bru = false;
                    ALAImMsgListView.this.Om();
                }
            }

            @Override // android.widget.AbsListView.OnScrollListener
            public void onScroll(AbsListView absListView, int i, int i2, int i3) {
            }
        });
        CustomResponsedMessage runTask = MessageManager.getInstance().runTask(new CustomMessage<>(CmdConfigCustom.CMD_GET_LIVE_IS_MIX), Boolean.class);
        if (runTask != null && runTask.getData() != null) {
            this.bgw = ((Boolean) runTask.getData()).booleanValue();
        }
    }

    @Override // com.baidu.live.im.j
    public void setMsgData(List<com.baidu.live.im.data.b> list) {
        if (this.bro != null) {
            this.bro.setDatas(list);
            this.bro.notifyDataSetChanged();
        }
    }

    public boolean Ol() {
        return this.brq;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Om() {
        if (getLastVisiblePosition() + 1 == getCount()) {
            this.brq = false;
            if (this.brt != null) {
                this.brt.Oo();
            }
        } else {
            this.brq = true;
        }
        this.brp = this.brq ? false : true;
    }

    public void On() {
        this.isScrolling = false;
        this.brp = true;
        this.brq = false;
        smoothScrollToPosition(getBottom());
    }

    @Override // com.baidu.live.im.j
    public void Mz() {
        if (!this.isScrolling && this.brp) {
            post(new Runnable() { // from class: com.baidu.live.im.view.ALAImMsgListView.2
                @Override // java.lang.Runnable
                public void run() {
                    ALAImMsgListView.this.smoothScrollToPosition(ALAImMsgListView.this.getBottom());
                }
            });
        }
    }

    public void LI() {
        this.showShadow = false;
        this.brq = false;
        if (this.bro != null) {
            this.bro.LI();
        }
    }

    @Override // com.baidu.live.im.j
    public void a(String str, String str2, boolean z, String str3, String str4) {
        if (this.bro != null) {
            this.bro.a(str, str2, z, str3, str4);
        }
    }

    @Override // com.baidu.live.im.j
    public void setNeedTopAlphaShade(boolean z) {
        if (z) {
            this.brs = getResources().getDimensionPixelSize(a.d.sdk_ds50);
            this.brr = new Paint();
            this.brr.setStyle(Paint.Style.FILL_AND_STROKE);
            this.brr.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.MULTIPLY));
            this.brr.setShader(new LinearGradient(0.0f, 0.0f, 0.0f, this.brs, getResources().getColor(a.c.sdk_white_alpha0), getResources().getColor(a.c.sdk_white_alpha100), Shader.TileMode.CLAMP));
        } else {
            this.brs = 0;
            this.brr = null;
        }
        invalidate();
    }

    @Override // com.baidu.live.im.j
    public void onKeyboardVisibilityChanged(boolean z) {
    }

    public void setLogData(String str, String str2) {
    }

    public void Ng() {
        this.brq = false;
        this.brp = true;
        if (this.bro != null) {
            this.bro.release();
        }
    }

    @Override // com.baidu.live.im.j
    public View getView() {
        return this;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.live.adp.widget.listview.BdListView, android.widget.ListView, android.widget.AbsListView, android.view.ViewGroup, android.view.View
    public void dispatchDraw(Canvas canvas) {
        super.dispatchDraw(canvas);
        if (this.brr != null && this.showShadow) {
            canvas.drawRect(0.0f, 0.0f, getWidth(), this.brs, this.brr);
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    public boolean dispatchTouchEvent(MotionEvent motionEvent) {
        int x = (int) motionEvent.getX();
        int y = (int) motionEvent.getY();
        if (motionEvent.getAction() == 0) {
            this.brm = motionEvent.getX();
            this.brn = motionEvent.getY();
            this.direction = 0;
            this.brp = false;
            getParent().requestDisallowInterceptTouchEvent(true);
        } else if (motionEvent.getAction() == 2) {
            if (Math.abs(this.brm - x) > 20.0f || Math.abs(this.brn - y) > 20.0f) {
                this.brp = false;
            }
            if (this.direction == 0 && (Math.abs(x - this.brm) > ViewConfiguration.get(getContext()).getScaledTouchSlop() || Math.abs(y - this.brn) > ViewConfiguration.get(getContext()).getScaledTouchSlop())) {
                if (Math.abs(y - this.brn) * 0.5f > Math.abs(x - this.brm)) {
                    this.direction = 1;
                    if (y > this.brn) {
                        if (!canScrollVertically(-1)) {
                            getParent().requestDisallowInterceptTouchEvent(false);
                            return false;
                        }
                    } else if (!canScrollVertically(1)) {
                        getParent().requestDisallowInterceptTouchEvent(false);
                        return false;
                    }
                } else {
                    this.direction = 2;
                    getParent().requestDisallowInterceptTouchEvent(false);
                    return false;
                }
            }
        } else if (motionEvent.getAction() == 3 || motionEvent.getAction() == 1) {
            Om();
            getParent().requestDisallowInterceptTouchEvent(false);
        }
        return super.dispatchTouchEvent(motionEvent);
    }

    public void setFromMaster(boolean z) {
        this.boU = z;
        if (this.bro != null) {
            this.bro.setFromMaster(this.boU);
        }
    }

    public void setOnUserMoveToBottomIMCallBack(a aVar) {
        this.brt = aVar;
    }

    public com.baidu.live.im.a.a getAdapterManager() {
        return this.bro;
    }
}
