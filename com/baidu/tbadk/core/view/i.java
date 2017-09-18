package com.baidu.tbadk.core.view;

import android.content.Context;
import android.text.SpannableString;
import android.text.style.ForegroundColorSpan;
import android.util.SparseArray;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CompoundButton;
import android.widget.PopupWindow;
import android.widget.TextView;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.data.an;
import com.baidu.tbadk.core.frameworkData.CmdConfigCustom;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tbadk.core.util.aj;
import com.baidu.tbadk.core.util.v;
import com.baidu.tbadk.core.view.g;
import com.baidu.tbadk.core.view.h;
import com.baidu.tieba.d;
import com.xiaomi.mipush.sdk.Constants;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONObject;
/* loaded from: classes.dex */
public class i {
    private g alA;
    private boolean alB;
    private int alr;
    private int als;
    private int alt;
    private int alu;
    private PopupWindow alw;
    private View alx;
    private TextView aly;
    private TextView alz;
    private ViewGroup mContentView;
    private Context mContext;
    private TbPageContext mF;
    private int mWindowHeight;
    private int mYOffset;
    private PopupWindow alo = null;
    private an alp = null;
    private SparseArray<String> alc = null;
    private List<g.a> alq = new ArrayList();
    private h.a alv = null;
    private CompoundButton.OnCheckedChangeListener alf = new CompoundButton.OnCheckedChangeListener() { // from class: com.baidu.tbadk.core.view.i.1
        @Override // android.widget.CompoundButton.OnCheckedChangeListener
        public void onCheckedChanged(CompoundButton compoundButton, boolean z) {
            if (i.this.alv != null) {
                i.this.alv.a(i.this.alp, compoundButton, z);
            }
            if (compoundButton.getTag() instanceof g.a) {
                g.a aVar = (g.a) compoundButton.getTag();
                if (z) {
                    if (!i.this.alq.contains(aVar)) {
                        i.this.alq.add(aVar);
                    }
                } else {
                    i.this.alq.remove(aVar);
                }
            }
            i.this.wM();
        }
    };
    private View.OnClickListener alC = new View.OnClickListener() { // from class: com.baidu.tbadk.core.view.i.2
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (i.this.alp != null && i.this.alo != null) {
                ArrayList<Integer> arrayList = new ArrayList<>();
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.NEG_FEED_BACK_DELETE, i.this.l(arrayList)));
                i.this.wK();
                c cVar = new c();
                cVar.akG = 1500L;
                cVar.d(i.this.mContext.getResources().getString(d.l.reduce_related_thread_recommend));
                if (i.this.alv != null) {
                    i.this.alv.a(arrayList, i.this.alp);
                }
            }
        }
    };
    private PopupWindow.OnDismissListener alD = new PopupWindow.OnDismissListener() { // from class: com.baidu.tbadk.core.view.i.3
        @Override // android.widget.PopupWindow.OnDismissListener
        public void onDismiss() {
            if (i.this.alw != null) {
                i.this.alw.dismiss();
                i.this.alw = null;
            }
        }
    };
    private CustomMessageListener alE = new CustomMessageListener(CmdConfigCustom.CMD_HIDE_NEGATIVE_FEED_BACK_WIN) { // from class: com.baidu.tbadk.core.view.i.4
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            i.this.wK();
        }
    };

    public i(TbPageContext tbPageContext, View view) {
        this.mContext = null;
        this.mContext = tbPageContext.getPageActivity();
        this.mF = tbPageContext;
        this.alx = view;
        init();
    }

    private void init() {
        this.alu = com.baidu.adp.lib.util.k.f(this.mContext, d.f.ds36);
        this.mYOffset = com.baidu.adp.lib.util.k.f(this.mContext, d.f.ds6);
        this.alr = com.baidu.adp.lib.util.k.ae(this.mContext) - (this.alu * 2);
        this.alt = com.baidu.adp.lib.util.k.f(this.mContext, d.f.ds120);
        this.alA = new g(this.mF);
        this.alA.a(this.alf);
        this.mF.registerListener(this.alE);
    }

    public void setUniqueId(BdUniqueId bdUniqueId) {
        if (bdUniqueId != null) {
            if (this.alE != null) {
                this.alE.setTag(bdUniqueId);
            }
            MessageManager.getInstance().registerListener(this.alE);
        }
    }

    public void wJ() {
        if (this.mContext != null && this.alc != null && this.alc.size() != 0) {
            View contentView = getContentView();
            this.mWindowHeight = wL();
            this.alo = new PopupWindow(contentView, this.alr, this.mWindowHeight);
            this.alo.setFocusable(true);
            this.alo.setTouchable(true);
            this.alo.setOnDismissListener(this.alD);
            wN();
            this.alw = new PopupWindow(LayoutInflater.from(this.mContext).inflate(d.j.view_negative_feedback_bottom, (ViewGroup) null), -1, -1);
            this.alw.showAtLocation(this.alx, 0, 0, 0);
            int[] iArr = new int[2];
            boolean a = a(this.mContext, this.alx, this.mWindowHeight, this.alr, this.alt, this.mYOffset, iArr);
            if (iArr[0] != 0 || iArr[1] != 0) {
                if (a) {
                    this.alo.setAnimationStyle(d.m.scale_rb2lt_anim);
                    aj.a(this.alo, d.g.bg_home_feedback_under);
                } else {
                    this.alo.setAnimationStyle(d.m.scale_rt2lb_anim);
                    aj.a(this.alo, d.g.bg_home_feedback_top);
                }
                this.alo.showAtLocation(this.alx, 0, iArr[0] - this.alu, iArr[1]);
                if (this.alv != null) {
                    this.alv.a(this.alp);
                }
                this.alB = true;
            }
        }
    }

    private View getContentView() {
        if (this.mContext == null) {
            return null;
        }
        if (this.mContentView == null) {
            this.mContentView = (ViewGroup) LayoutInflater.from(this.mContext).inflate(d.j.neg_feedback_popupwindow, (ViewGroup) null);
            this.aly = (TextView) this.mContentView.findViewById(d.h.head_text);
            this.alz = (TextView) this.mContentView.findViewById(d.h.uninterested_text);
            this.alz.setOnClickListener(this.alC);
            aj.c(this.aly, d.e.cp_cont_d, 1);
            aj.c(this.alz, d.e.cp_link_tip_a, 1);
        }
        View view = this.alA.getView();
        if (view != null && view.getParent() == null) {
            this.mContentView.addView(view);
        }
        return this.mContentView;
    }

    private int wL() {
        if (this.mContentView == null) {
            return 0;
        }
        this.mContentView.measure(0, 0);
        this.als = this.mContentView.getMeasuredHeight() + com.baidu.adp.lib.util.k.f(this.mContext, d.f.ds12);
        return this.als;
    }

    private boolean a(Context context, View view, int i, int i2, int i3, int i4, int[] iArr) {
        if (context == null || view == null || iArr == null || iArr.length != 2) {
            return false;
        }
        int[] iArr2 = new int[2];
        view.getLocationOnScreen(iArr2);
        int height = view.getHeight();
        int af = com.baidu.adp.lib.util.k.af(context);
        int ae = com.baidu.adp.lib.util.k.ae(context);
        boolean z = ((af - iArr2[1]) - height) - i3 < i;
        iArr[0] = ae - i2;
        if (z) {
            iArr[1] = (iArr2[1] - i) - i4;
            return z;
        }
        iArr[1] = iArr2[1] + height + i4;
        return z;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Can't wrap try/catch for region: R(8:4|(7:6|(2:7|(3:9|(2:11|(2:13|14)(1:16))(1:17)|15)(0))|19|(1:21)|22|23|24)(0)|18|19|(0)|22|23|24) */
    /* JADX WARN: Code restructure failed: missing block: B:23:0x0084, code lost:
        r0 = move-exception;
     */
    /* JADX WARN: Code restructure failed: missing block: B:24:0x0085, code lost:
        r0.printStackTrace();
     */
    /* JADX WARN: Removed duplicated region for block: B:20:0x0062 A[Catch: Exception -> 0x0084, TryCatch #0 {Exception -> 0x0084, blocks: (B:18:0x0050, B:20:0x0062, B:21:0x006c), top: B:25:0x0050 }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public JSONObject l(ArrayList<Integer> arrayList) {
        JSONObject jSONObject = new JSONObject();
        if (this.alp == null || arrayList == null) {
            return null;
        }
        StringBuilder sb = new StringBuilder();
        if (!v.v(this.alq)) {
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 < this.alq.size()) {
                    g.a aVar = this.alq.get(i2);
                    if (aVar != null) {
                        arrayList.add(Integer.valueOf(aVar.id));
                        if (sb.length() != 0) {
                            sb.append(Constants.ACCEPT_TIME_SEPARATOR_SP);
                        }
                    }
                    sb.append(String.valueOf(aVar.id));
                    i = i2 + 1;
                }
            }
            jSONObject.put("tid", this.alp.getTid());
            if (sb.length() != 0) {
                jSONObject.put("dislike_ids", sb.toString());
            }
            jSONObject.put("fid", this.alp.getFid());
            jSONObject.put("click_time", System.currentTimeMillis());
            return jSONObject;
        }
        jSONObject.put("tid", this.alp.getTid());
        if (sb.length() != 0) {
        }
        jSONObject.put("fid", this.alp.getFid());
        jSONObject.put("click_time", System.currentTimeMillis());
        return jSONObject;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void wM() {
        int size = this.alq.size();
        if (size > 0) {
            String string = this.mContext.getResources().getString(d.l.feedback_selected_reason, Integer.valueOf(size));
            SpannableString spannableString = new SpannableString(string);
            UtilHelper.setSpan(spannableString, string, String.valueOf(size), new ForegroundColorSpan(aj.getColor(d.e.cp_link_tip_a)));
            this.aly.setText(spannableString);
            this.alz.setText(this.mContext.getResources().getString(d.l.confirm));
            return;
        }
        this.aly.setText(this.mContext.getResources().getString(d.l.tell_us_reason));
        this.alz.setText(this.mContext.getResources().getString(d.l.not_interested));
    }

    public void setData(an anVar) {
        if (anVar != null) {
            this.alp = anVar;
            this.alc = anVar.qs();
            this.alA.setData(anVar);
        }
    }

    public void setFirstRowSingleColumn(boolean z) {
        this.alA.setFirstRowSingleColumn(z);
    }

    public void setEventCallback(h.a aVar) {
        this.alv = aVar;
    }

    public void setDefaultReasonArray(String[] strArr) {
        this.alA.setDefaultReasonArray(strArr);
    }

    public void wK() {
        if (this.alo != null) {
            this.alo.dismiss();
            this.alo = null;
        }
        if (this.alw != null) {
            this.alw.dismiss();
            this.alw = null;
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void onDetachedFromWindow() {
        MessageManager.getInstance().unRegisterListener(this.alE);
        wK();
    }

    private void wN() {
        if (this.alB && this.alq.size() != 0) {
            this.alq.clear();
            wM();
        }
    }
}
