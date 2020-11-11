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
/* loaded from: classes4.dex */
public class ALAImMsgListView extends BdTypeListView implements j {
    private boolean bkG;
    private float bmg;
    private float bmh;
    private com.baidu.live.im.a.a bmi;
    private boolean bmj;
    private boolean bmk;
    private Paint bml;
    private a bmm;
    private boolean bmn;
    private boolean bmo;
    private int direction;
    private boolean isScrolling;
    private int mShadowHeight;
    private boolean showShadow;

    /* loaded from: classes4.dex */
    public interface a {
        void MX();
    }

    public ALAImMsgListView(Context context) {
        super(context);
        this.isScrolling = false;
        this.bmj = true;
        this.bmk = false;
        this.showShadow = false;
        this.bmn = false;
        this.bmo = false;
        init();
    }

    public ALAImMsgListView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.isScrolling = false;
        this.bmj = true;
        this.bmk = false;
        this.showShadow = false;
        this.bmn = false;
        this.bmo = false;
        init();
    }

    public ALAImMsgListView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.isScrolling = false;
        this.bmj = true;
        this.bmk = false;
        this.showShadow = false;
        this.bmn = false;
        this.bmo = false;
        init();
    }

    public void setMode(boolean z) {
        this.bmi.setMode(z);
    }

    public void setPageContext(TbPageContext tbPageContext) {
        if (this.bmi == null) {
            this.bmi = new com.baidu.live.im.a.a(tbPageContext, this);
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
                    ALAImMsgListView.this.bmn = true;
                } else if (i == 0 && ALAImMsgListView.this.bmn) {
                    ALAImMsgListView.this.bmn = false;
                    ALAImMsgListView.this.MU();
                }
            }

            @Override // android.widget.AbsListView.OnScrollListener
            public void onScroll(AbsListView absListView, int i, int i2, int i3) {
            }
        });
        CustomResponsedMessage runTask = MessageManager.getInstance().runTask(new CustomMessage<>(CmdConfigCustom.CMD_GET_LIVE_IS_MIX), Boolean.class);
        if (runTask != null && runTask.getData() != null) {
            this.bmo = ((Boolean) runTask.getData()).booleanValue();
        }
    }

    @Override // com.baidu.live.im.j
    public void setMsgData(List<com.baidu.live.im.data.a> list) {
        if (this.bmi != null) {
            this.bmi.setDatas(list);
            this.bmi.notifyDataSetChanged();
        }
    }

    public boolean MT() {
        return this.bmk;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void MU() {
        if (getLastVisiblePosition() + 1 == getCount()) {
            this.bmk = false;
            if (this.bmm != null) {
                this.bmm.MX();
            }
        } else {
            this.bmk = true;
        }
        this.bmj = this.bmk ? false : true;
    }

    public void MV() {
        this.isScrolling = false;
        this.bmj = true;
        this.bmk = false;
        smoothScrollToPosition(getBottom());
    }

    @Override // com.baidu.live.im.j
    public void LI() {
        if (!this.isScrolling && this.bmj) {
            post(new Runnable() { // from class: com.baidu.live.im.view.ALAImMsgListView.2
                @Override // java.lang.Runnable
                public void run() {
                    ALAImMsgListView.this.smoothScrollToPosition(ALAImMsgListView.this.getBottom());
                }
            });
        }
    }

    public void KS() {
        this.showShadow = false;
        this.bmk = false;
        if (this.bmi != null) {
            this.bmi.KS();
        }
    }

    @Override // com.baidu.live.im.j
    public void b(String str, String str2, boolean z, String str3) {
        if (this.bmi != null) {
            this.bmi.b(str, str2, z, str3);
        }
    }

    @Override // com.baidu.live.im.j
    public void setNeedTopAlphaShade(boolean z) {
        if (z) {
            this.mShadowHeight = getResources().getDimensionPixelSize(a.d.sdk_ds50);
            this.bml = new Paint();
            this.bml.setStyle(Paint.Style.FILL_AND_STROKE);
            this.bml.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.MULTIPLY));
            this.bml.setShader(new LinearGradient(0.0f, 0.0f, 0.0f, this.mShadowHeight, getResources().getColor(a.c.sdk_white_alpha0), getResources().getColor(a.c.sdk_white_alpha100), Shader.TileMode.CLAMP));
        } else {
            this.mShadowHeight = 0;
            this.bml = null;
        }
        invalidate();
    }

    @Override // com.baidu.live.im.j
    public void onKeyboardVisibilityChanged(boolean z) {
    }

    public void setLogData(String str, String str2) {
    }

    public void MW() {
        this.bmk = false;
        this.bmj = true;
        if (this.bmi != null) {
            this.bmi.release();
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
        if (this.bml != null && this.showShadow) {
            canvas.drawRect(0.0f, 0.0f, getWidth(), this.mShadowHeight, this.bml);
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    public boolean dispatchTouchEvent(MotionEvent motionEvent) {
        int x = (int) motionEvent.getX();
        int y = (int) motionEvent.getY();
        if (motionEvent.getAction() == 0) {
            this.bmg = motionEvent.getX();
            this.bmh = motionEvent.getY();
            this.direction = 0;
            this.bmj = false;
            getParent().requestDisallowInterceptTouchEvent(true);
        } else if (motionEvent.getAction() == 2) {
            if (Math.abs(this.bmg - x) > 20.0f || Math.abs(this.bmh - y) > 20.0f) {
                this.bmj = false;
            }
            if (this.bmo && this.direction == 0 && (Math.abs(x - this.bmg) > ViewConfiguration.get(getContext()).getScaledTouchSlop() || Math.abs(y - this.bmh) > ViewConfiguration.get(getContext()).getScaledTouchSlop())) {
                if (Math.abs(y - this.bmh) * 0.5f > Math.abs(x - this.bmg)) {
                    this.direction = 1;
                    if (y > this.bmh) {
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
            MU();
            getParent().requestDisallowInterceptTouchEvent(false);
        }
        return super.dispatchTouchEvent(motionEvent);
    }

    public void setFromMaster(boolean z) {
        this.bkG = z;
        if (this.bmi != null) {
            this.bmi.setFromMaster(this.bkG);
        }
    }

    public void setOnUserMoveToBottomIMCallBack(a aVar) {
        this.bmm = aVar;
    }
}
