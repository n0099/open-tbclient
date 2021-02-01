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
    private boolean beM;
    private boolean bnA;
    private float bqb;
    private float bqc;
    private com.baidu.live.im.a.a bqd;
    private boolean bqe;
    private boolean bqf;
    private Paint bqg;
    private int bqh;
    private a bqi;
    private boolean bqj;
    private int direction;
    private boolean isScrolling;
    private boolean showShadow;

    /* loaded from: classes11.dex */
    public interface a {
        void LR();
    }

    public ALAImMsgListView(Context context) {
        super(context);
        this.isScrolling = false;
        this.bqe = true;
        this.bqf = false;
        this.showShadow = false;
        this.bqj = false;
        this.beM = false;
        init();
    }

    public ALAImMsgListView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.isScrolling = false;
        this.bqe = true;
        this.bqf = false;
        this.showShadow = false;
        this.bqj = false;
        this.beM = false;
        init();
    }

    public ALAImMsgListView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.isScrolling = false;
        this.bqe = true;
        this.bqf = false;
        this.showShadow = false;
        this.bqj = false;
        this.beM = false;
        init();
    }

    public void setMode(boolean z) {
        this.bqd.setMode(z);
    }

    public void setPageContext(TbPageContext tbPageContext) {
        if (this.bqd == null) {
            this.bqd = new com.baidu.live.im.a.a(tbPageContext, this);
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
                    ALAImMsgListView.this.bqj = true;
                } else if (i == 0 && ALAImMsgListView.this.bqj) {
                    ALAImMsgListView.this.bqj = false;
                    ALAImMsgListView.this.LP();
                }
            }

            @Override // android.widget.AbsListView.OnScrollListener
            public void onScroll(AbsListView absListView, int i, int i2, int i3) {
            }
        });
        CustomResponsedMessage runTask = MessageManager.getInstance().runTask(new CustomMessage<>(CmdConfigCustom.CMD_GET_LIVE_IS_MIX), Boolean.class);
        if (runTask != null && runTask.getData() != null) {
            this.beM = ((Boolean) runTask.getData()).booleanValue();
        }
    }

    @Override // com.baidu.live.im.j
    public void setMsgData(List<com.baidu.live.im.data.b> list) {
        if (this.bqd != null) {
            this.bqd.setDatas(list);
            this.bqd.notifyDataSetChanged();
        }
    }

    public boolean LO() {
        return this.bqf;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void LP() {
        if (getLastVisiblePosition() + 1 == getCount()) {
            this.bqf = false;
            if (this.bqi != null) {
                this.bqi.LR();
            }
        } else {
            this.bqf = true;
        }
        this.bqe = this.bqf ? false : true;
    }

    public void LQ() {
        this.isScrolling = false;
        this.bqe = true;
        this.bqf = false;
        smoothScrollToPosition(getBottom());
    }

    @Override // com.baidu.live.im.j
    public void Kc() {
        if (!this.isScrolling && this.bqe) {
            post(new Runnable() { // from class: com.baidu.live.im.view.ALAImMsgListView.2
                @Override // java.lang.Runnable
                public void run() {
                    ALAImMsgListView.this.smoothScrollToPosition(ALAImMsgListView.this.getBottom());
                }
            });
        }
    }

    public void Jg() {
        this.showShadow = false;
        this.bqf = false;
        if (this.bqd != null) {
            this.bqd.Jg();
        }
    }

    @Override // com.baidu.live.im.j
    public void a(String str, String str2, boolean z, String str3, String str4) {
        if (this.bqd != null) {
            this.bqd.a(str, str2, z, str3, str4);
        }
    }

    @Override // com.baidu.live.im.j
    public void setNeedTopAlphaShade(boolean z) {
        if (z) {
            this.bqh = getResources().getDimensionPixelSize(a.d.sdk_ds50);
            this.bqg = new Paint();
            this.bqg.setStyle(Paint.Style.FILL_AND_STROKE);
            this.bqg.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.MULTIPLY));
            this.bqg.setShader(new LinearGradient(0.0f, 0.0f, 0.0f, this.bqh, getResources().getColor(a.c.sdk_white_alpha0), getResources().getColor(a.c.sdk_white_alpha100), Shader.TileMode.CLAMP));
        } else {
            this.bqh = 0;
            this.bqg = null;
        }
        invalidate();
    }

    @Override // com.baidu.live.im.j
    public void onKeyboardVisibilityChanged(boolean z) {
    }

    public void setLogData(String str, String str2) {
    }

    public void KJ() {
        this.bqf = false;
        this.bqe = true;
        if (this.bqd != null) {
            this.bqd.release();
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
        if (this.bqg != null && this.showShadow) {
            canvas.drawRect(0.0f, 0.0f, getWidth(), this.bqh, this.bqg);
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    public boolean dispatchTouchEvent(MotionEvent motionEvent) {
        int x = (int) motionEvent.getX();
        int y = (int) motionEvent.getY();
        if (motionEvent.getAction() == 0) {
            this.bqb = motionEvent.getX();
            this.bqc = motionEvent.getY();
            this.direction = 0;
            this.bqe = false;
            getParent().requestDisallowInterceptTouchEvent(true);
        } else if (motionEvent.getAction() == 2) {
            if (Math.abs(this.bqb - x) > 20.0f || Math.abs(this.bqc - y) > 20.0f) {
                this.bqe = false;
            }
            if (this.direction == 0 && (Math.abs(x - this.bqb) > ViewConfiguration.get(getContext()).getScaledTouchSlop() || Math.abs(y - this.bqc) > ViewConfiguration.get(getContext()).getScaledTouchSlop())) {
                if (Math.abs(y - this.bqc) * 0.5f > Math.abs(x - this.bqb)) {
                    this.direction = 1;
                    if (y > this.bqc) {
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
            LP();
            getParent().requestDisallowInterceptTouchEvent(false);
        }
        return super.dispatchTouchEvent(motionEvent);
    }

    public void setFromMaster(boolean z) {
        this.bnA = z;
        if (this.bqd != null) {
            this.bqd.setFromMaster(this.bnA);
        }
    }

    public void setOnUserMoveToBottomIMCallBack(a aVar) {
        this.bqi = aVar;
    }

    public com.baidu.live.im.a.a getAdapterManager() {
        return this.bqd;
    }
}
