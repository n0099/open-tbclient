package com.baidu.live.yuyinim.view;

import android.content.Context;
import android.content.res.Configuration;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.appcompat.widget.ActivityChooserView;
import com.baidu.android.imsdk.utils.LogUtils;
import com.baidu.live.adp.lib.util.BdUtilHelper;
import com.baidu.live.im.data.b;
import com.baidu.live.im.j;
import com.baidu.live.sdk.a;
import com.baidu.live.tbadk.TbPageContext;
import com.baidu.live.yuyinim.view.ALAImMsgListView;
import java.util.List;
/* loaded from: classes11.dex */
public class ALaImMsgView extends RelativeLayout implements j {
    private boolean boU;
    private TextView bso;
    private boolean bsq;
    private boolean bsr;
    private int bss;
    private int bst;
    private ALAImEnterView cek;
    private ALAImMsgListView cel;
    private ALAImMsgMoreChatView cem;
    private String mOtherParams;
    private TbPageContext mTbPageContext;
    private String mVid;

    public ALaImMsgView(Context context) {
        super(context);
        this.bsq = false;
        this.bsr = false;
        this.bss = 0;
        init(context);
    }

    public ALaImMsgView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.bsq = false;
        this.bsr = false;
        this.bss = 0;
        init(context);
    }

    public ALaImMsgView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.bsq = false;
        this.bsr = false;
        this.bss = 0;
        init(context);
    }

    public void setPageContext(TbPageContext tbPageContext) {
        this.mTbPageContext = tbPageContext;
        this.cel.setPageContext(tbPageContext);
    }

    private void init(Context context) {
        this.cek = new ALAImEnterView(context);
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, context.getResources().getDimensionPixelSize(a.d.sdk_ds52));
        layoutParams.leftMargin = context.getResources().getDimensionPixelSize(a.d.sdk_tbds26);
        addView(this.cek, layoutParams);
        this.cel = new ALAImMsgListView(context);
        this.cel.setOnUserMoveToBottomIMCallBack(new ALAImMsgListView.a() { // from class: com.baidu.live.yuyinim.view.ALaImMsgView.1
            @Override // com.baidu.live.yuyinim.view.ALAImMsgListView.a
            public void Oo() {
                ALaImMsgView.this.bss = 0;
                ALaImMsgView.this.cem.setVisibility(8);
            }
        });
        this.cel.setId(a.f.ala_im_normal_panel);
        RelativeLayout.LayoutParams layoutParams2 = new RelativeLayout.LayoutParams(-1, -2);
        layoutParams2.topMargin = context.getResources().getDimensionPixelSize(a.d.sdk_ds60);
        layoutParams2.leftMargin = context.getResources().getDimensionPixelSize(a.d.sdk_tbds26);
        layoutParams2.addRule(12);
        addView(this.cel, layoutParams2);
        this.cem = new ALAImMsgMoreChatView(context);
        RelativeLayout.LayoutParams layoutParams3 = new RelativeLayout.LayoutParams(-2, context.getResources().getDimensionPixelSize(a.d.sdk_ds60));
        layoutParams3.leftMargin = context.getResources().getDimensionPixelSize(a.d.sdk_ds20);
        layoutParams3.addRule(8, this.cel.getId());
        addView(this.cem, layoutParams3);
        this.cem.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.live.yuyinim.view.ALaImMsgView.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (!ALaImMsgView.this.bsq) {
                    ALaImMsgView.this.bss = 0;
                    if (!ALaImMsgView.this.bsr) {
                        ALaImMsgView.this.bsr = false;
                        ALaImMsgView.this.cem.setVisibility(8);
                        ALaImMsgView.this.cel.On();
                        return;
                    }
                    return;
                }
                BdUtilHelper.hideSoftKeyPad(ALaImMsgView.this.getContext(), ALaImMsgView.this.getView());
            }
        });
    }

    public void setMode(boolean z) {
        this.cel.setMode(z);
    }

    @Override // android.view.View
    protected void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
        if (configuration != null) {
            if (configuration.orientation == 2) {
                this.cel.setMaxHeight(ActivityChooserView.ActivityChooserViewAdapter.MAX_ACTIVITY_COUNT_UNLIMITED);
            } else if (configuration.orientation == 1) {
                this.cel.setMaxHeight(ActivityChooserView.ActivityChooserViewAdapter.MAX_ACTIVITY_COUNT_UNLIMITED);
            }
        }
    }

    @Override // com.baidu.live.im.j
    public View getView() {
        return this;
    }

    @Override // com.baidu.live.im.j
    public void setMsgData(List<b> list) {
        LogUtils.e(">>>>>>", "msgList.size:" + list.size() + " mListView.getData().size():" + this.cel.getData().size() + " newMsgSize: " + this.bss + " lastVisitPos:" + this.bst + " mListView.getLastVisiblePosition():" + this.cel.getLastVisiblePosition());
        if (list != null) {
            if (this.cel.getLastVisiblePosition() > list.size()) {
                this.bst = Math.max(0, this.bst);
            } else {
                this.bst = Math.max(this.cel.getLastVisiblePosition(), this.bst);
            }
            this.bss = Math.max((list.size() - this.bst) - 1, 0);
            this.cel.setMsgData(list);
        }
    }

    public boolean az(List<b> list) {
        return list.size() != this.cel.getData().size();
    }

    public void B(b bVar) {
        this.cek.A(bVar);
    }

    @Override // com.baidu.live.im.j
    public void Mz() {
        this.cel.Mz();
    }

    public void LI() {
        this.bst = 0;
        this.cek.LI();
        this.cel.LI();
    }

    public void Ng() {
        this.cek.release();
        this.cel.Ng();
        this.cem.setVisibility(8);
    }

    @Override // com.baidu.live.im.j
    public void a(String str, String str2, boolean z, String str3, String str4) {
        this.cel.a(str, str2, z, str3, str4);
    }

    @Override // com.baidu.live.im.j
    public void setNeedTopAlphaShade(boolean z) {
        this.cel.setNeedTopAlphaShade(z);
    }

    @Override // com.baidu.live.im.j
    public void onKeyboardVisibilityChanged(boolean z) {
        this.bsq = z;
    }

    public void setLogData(String str, String str2) {
        this.mVid = str != null ? str : "";
        this.mOtherParams = str2 != null ? str2 : "";
        this.cel.setLogData(str, str2);
    }

    public void setFromMaster(boolean z) {
        this.boU = z;
        if (this.cel != null) {
            this.cel.setFromMaster(this.boU);
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    public boolean dispatchTouchEvent(MotionEvent motionEvent) {
        if (motionEvent.getAction() == 0) {
            if (this.bsq) {
                this.bsr = true;
                BdUtilHelper.hideSoftKeyPad(getContext(), getRootView());
            } else {
                this.bsr = false;
            }
        }
        return super.dispatchTouchEvent(motionEvent);
    }

    public void OK() {
        if (this.cel.Ol() && this.bss > 0) {
            this.cem.setVisibility(0);
            this.cem.setNewMessageSize(this.bss);
        }
    }

    public void abL() {
        if (this.bso != null) {
            this.bso.setVisibility(8);
        }
    }
}
