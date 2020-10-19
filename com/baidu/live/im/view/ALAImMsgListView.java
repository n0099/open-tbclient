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
    private boolean bhP;
    private float bjr;
    private float bjs;
    private com.baidu.live.im.a.a bjt;
    private boolean bju;
    private boolean bjv;
    private Paint bjw;
    private a bjx;
    private boolean bjy;
    private boolean bjz;
    private int direction;
    private boolean isScrolling;
    private int mShadowHeight;
    private boolean showShadow;

    /* loaded from: classes4.dex */
    public interface a {
        void Md();
    }

    public ALAImMsgListView(Context context) {
        super(context);
        this.isScrolling = false;
        this.bju = true;
        this.bjv = false;
        this.showShadow = false;
        this.bjy = false;
        this.bjz = false;
        init();
    }

    public ALAImMsgListView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.isScrolling = false;
        this.bju = true;
        this.bjv = false;
        this.showShadow = false;
        this.bjy = false;
        this.bjz = false;
        init();
    }

    public ALAImMsgListView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.isScrolling = false;
        this.bju = true;
        this.bjv = false;
        this.showShadow = false;
        this.bjy = false;
        this.bjz = false;
        init();
    }

    public void setMode(boolean z) {
        this.bjt.setMode(z);
    }

    public void setPageContext(TbPageContext tbPageContext) {
        if (this.bjt == null) {
            this.bjt = new com.baidu.live.im.a.a(tbPageContext, this);
        }
    }

    private void init() {
        setLayerType(1, null);
        setCacheColorHint(0);
        setDivider(new ColorDrawable(getResources().getColor(17170445)));
        setDividerHeight(getResources().getDimensionPixelSize(a.e.sdk_ds8));
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
                    ALAImMsgListView.this.bjy = true;
                } else if (i == 0 && ALAImMsgListView.this.bjy) {
                    ALAImMsgListView.this.bjy = false;
                    ALAImMsgListView.this.Ma();
                }
            }

            @Override // android.widget.AbsListView.OnScrollListener
            public void onScroll(AbsListView absListView, int i, int i2, int i3) {
            }
        });
        CustomResponsedMessage runTask = MessageManager.getInstance().runTask(new CustomMessage<>(CmdConfigCustom.CMD_GET_LIVE_IS_MIX), Boolean.class);
        if (runTask != null && runTask.getData() != null) {
            this.bjz = ((Boolean) runTask.getData()).booleanValue();
        }
    }

    @Override // com.baidu.live.im.j
    public void setMsgData(List<com.baidu.live.im.data.a> list) {
        if (this.bjt != null) {
            this.bjt.setDatas(list);
            this.bjt.notifyDataSetChanged();
        }
    }

    public boolean LZ() {
        return this.bjv;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Ma() {
        if (getLastVisiblePosition() + 1 == getCount()) {
            this.bjv = false;
            if (this.bjx != null) {
                this.bjx.Md();
            }
        } else {
            this.bjv = true;
        }
        this.bju = this.bjv ? false : true;
    }

    public void Mb() {
        this.isScrolling = false;
        this.bju = true;
        this.bjv = false;
        smoothScrollToPosition(getBottom());
    }

    @Override // com.baidu.live.im.j
    public void KO() {
        if (!this.isScrolling && this.bju) {
            post(new Runnable() { // from class: com.baidu.live.im.view.ALAImMsgListView.2
                @Override // java.lang.Runnable
                public void run() {
                    ALAImMsgListView.this.smoothScrollToPosition(ALAImMsgListView.this.getBottom());
                }
            });
        }
    }

    public void JY() {
        this.showShadow = false;
        this.bjv = false;
        if (this.bjt != null) {
            this.bjt.JY();
        }
    }

    @Override // com.baidu.live.im.j
    public void b(String str, String str2, boolean z, String str3) {
        if (this.bjt != null) {
            this.bjt.b(str, str2, z, str3);
        }
    }

    @Override // com.baidu.live.im.j
    public void setNeedTopAlphaShade(boolean z) {
        if (z) {
            this.mShadowHeight = getResources().getDimensionPixelSize(a.e.sdk_ds50);
            this.bjw = new Paint();
            this.bjw.setStyle(Paint.Style.FILL_AND_STROKE);
            this.bjw.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.MULTIPLY));
            this.bjw.setShader(new LinearGradient(0.0f, 0.0f, 0.0f, this.mShadowHeight, getResources().getColor(a.d.sdk_white_alpha0), getResources().getColor(a.d.sdk_white_alpha100), Shader.TileMode.CLAMP));
        } else {
            this.mShadowHeight = 0;
            this.bjw = null;
        }
        invalidate();
    }

    @Override // com.baidu.live.im.j
    public void onKeyboardVisibilityChanged(boolean z) {
    }

    public void setLogData(String str, String str2) {
    }

    public void Mc() {
        this.bjv = false;
        this.bju = true;
        if (this.bjt != null) {
            this.bjt.release();
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
        if (this.bjw != null && this.showShadow) {
            canvas.drawRect(0.0f, 0.0f, getWidth(), this.mShadowHeight, this.bjw);
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    public boolean dispatchTouchEvent(MotionEvent motionEvent) {
        int x = (int) motionEvent.getX();
        int y = (int) motionEvent.getY();
        if (motionEvent.getAction() == 0) {
            this.bjr = motionEvent.getX();
            this.bjs = motionEvent.getY();
            this.direction = 0;
            this.bju = false;
            getParent().requestDisallowInterceptTouchEvent(true);
        } else if (motionEvent.getAction() == 2) {
            if (Math.abs(this.bjr - x) > 20.0f || Math.abs(this.bjs - y) > 20.0f) {
                this.bju = false;
            }
            if (this.bjz && this.direction == 0 && (Math.abs(x - this.bjr) > ViewConfiguration.get(getContext()).getScaledTouchSlop() || Math.abs(y - this.bjs) > ViewConfiguration.get(getContext()).getScaledTouchSlop())) {
                if (Math.abs(y - this.bjs) * 0.5f > Math.abs(x - this.bjr)) {
                    this.direction = 1;
                    if (y > this.bjs) {
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
            Ma();
            getParent().requestDisallowInterceptTouchEvent(false);
        }
        return super.dispatchTouchEvent(motionEvent);
    }

    public void setFromMaster(boolean z) {
        this.bhP = z;
        if (this.bjt != null) {
            this.bjt.setFromMaster(this.bhP);
        }
    }

    public void setOnUserMoveToBottomIMCallBack(a aVar) {
        this.bjx = aVar;
    }
}
