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
    private TextView alA;
    private TextView alB;
    private g alC;
    private boolean alD;
    private int als;
    private int alt;
    private int alu;
    private int alv;
    private int alw;
    private PopupWindow aly;
    private View alz;
    private ViewGroup mContentView;
    private Context mContext;
    private TbPageContext mF;
    private int mWindowHeight;
    private PopupWindow alp = null;
    private an alq = null;
    private SparseArray<String> ald = null;
    private List<g.a> alr = new ArrayList();
    private h.a alx = null;
    private CompoundButton.OnCheckedChangeListener alg = new CompoundButton.OnCheckedChangeListener() { // from class: com.baidu.tbadk.core.view.i.1
        @Override // android.widget.CompoundButton.OnCheckedChangeListener
        public void onCheckedChanged(CompoundButton compoundButton, boolean z) {
            if (i.this.alx != null) {
                i.this.alx.a(i.this.alq, compoundButton, z);
            }
            if (compoundButton.getTag() instanceof g.a) {
                g.a aVar = (g.a) compoundButton.getTag();
                if (z) {
                    if (!i.this.alr.contains(aVar)) {
                        i.this.alr.add(aVar);
                    }
                } else {
                    i.this.alr.remove(aVar);
                }
            }
            i.this.wM();
        }
    };
    private View.OnClickListener alE = new View.OnClickListener() { // from class: com.baidu.tbadk.core.view.i.2
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (i.this.alq != null && i.this.alp != null) {
                ArrayList<Integer> arrayList = new ArrayList<>();
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.NEG_FEED_BACK_DELETE, i.this.l(arrayList)));
                i.this.wK();
                c cVar = new c();
                cVar.akH = 1500L;
                cVar.d(i.this.mContext.getResources().getString(d.l.reduce_related_thread_recommend));
                if (i.this.alx != null) {
                    i.this.alx.a(arrayList, i.this.alq);
                }
            }
        }
    };
    private PopupWindow.OnDismissListener alF = new PopupWindow.OnDismissListener() { // from class: com.baidu.tbadk.core.view.i.3
        @Override // android.widget.PopupWindow.OnDismissListener
        public void onDismiss() {
            if (i.this.aly != null) {
                i.this.aly.dismiss();
                i.this.aly = null;
            }
        }
    };
    private CustomMessageListener alG = new CustomMessageListener(CmdConfigCustom.CMD_HIDE_NEGATIVE_FEED_BACK_WIN) { // from class: com.baidu.tbadk.core.view.i.4
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
        this.alz = view;
        init();
    }

    private void init() {
        this.alv = com.baidu.adp.lib.util.k.g(this.mContext, d.f.ds36);
        this.alw = com.baidu.adp.lib.util.k.g(this.mContext, d.f.ds6);
        this.als = com.baidu.adp.lib.util.k.ad(this.mContext) - (this.alv * 2);
        this.alu = com.baidu.adp.lib.util.k.g(this.mContext, d.f.ds120);
        this.alC = new g(this.mF);
        this.alC.a(this.alg);
        this.mF.registerListener(this.alG);
    }

    public void setUniqueId(BdUniqueId bdUniqueId) {
        if (bdUniqueId != null) {
            if (this.alG != null) {
                this.alG.setTag(bdUniqueId);
            }
            MessageManager.getInstance().registerListener(this.alG);
        }
    }

    public void wJ() {
        if (this.mContext != null && this.ald != null && this.ald.size() != 0) {
            View contentView = getContentView();
            this.mWindowHeight = wL();
            this.alp = new PopupWindow(contentView, this.als, this.mWindowHeight);
            this.alp.setFocusable(true);
            this.alp.setTouchable(true);
            this.alp.setOnDismissListener(this.alF);
            wN();
            this.aly = new PopupWindow(LayoutInflater.from(this.mContext).inflate(d.j.view_negative_feedback_bottom, (ViewGroup) null), -1, -1);
            this.aly.showAtLocation(this.alz, 0, 0, 0);
            int[] iArr = new int[2];
            boolean a = a(this.mContext, this.alz, this.mWindowHeight, this.als, this.alu, this.alw, iArr);
            if (iArr[0] != 0 || iArr[1] != 0) {
                if (a) {
                    this.alp.setAnimationStyle(d.m.scale_rb2lt_anim);
                    aj.a(this.alp, d.g.bg_home_feedback_under);
                } else {
                    this.alp.setAnimationStyle(d.m.scale_rt2lb_anim);
                    aj.a(this.alp, d.g.bg_home_feedback_top);
                }
                this.alp.showAtLocation(this.alz, 0, iArr[0] - this.alv, iArr[1]);
                if (this.alx != null) {
                    this.alx.a(this.alq);
                }
                this.alD = true;
            }
        }
    }

    private View getContentView() {
        if (this.mContext == null) {
            return null;
        }
        if (this.mContentView == null) {
            this.mContentView = (ViewGroup) LayoutInflater.from(this.mContext).inflate(d.j.neg_feedback_popupwindow, (ViewGroup) null);
            this.alA = (TextView) this.mContentView.findViewById(d.h.head_text);
            this.alB = (TextView) this.mContentView.findViewById(d.h.uninterested_text);
            this.alB.setOnClickListener(this.alE);
            aj.c(this.alA, d.e.cp_cont_d, 1);
            aj.c(this.alB, d.e.cp_link_tip_a, 1);
        }
        View view = this.alC.getView();
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
        this.alt = this.mContentView.getMeasuredHeight() + com.baidu.adp.lib.util.k.g(this.mContext, d.f.ds12);
        return this.alt;
    }

    private boolean a(Context context, View view, int i, int i2, int i3, int i4, int[] iArr) {
        if (context == null || view == null || iArr == null || iArr.length != 2) {
            return false;
        }
        int[] iArr2 = new int[2];
        view.getLocationOnScreen(iArr2);
        int height = view.getHeight();
        int ae = com.baidu.adp.lib.util.k.ae(context);
        int ad = com.baidu.adp.lib.util.k.ad(context);
        boolean z = ((ae - iArr2[1]) - height) - i3 < i;
        iArr[0] = ad - i2;
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
        if (this.alq == null || arrayList == null) {
            return null;
        }
        StringBuilder sb = new StringBuilder();
        if (!v.v(this.alr)) {
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 < this.alr.size()) {
                    g.a aVar = this.alr.get(i2);
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
            jSONObject.put("tid", this.alq.getTid());
            if (sb.length() != 0) {
                jSONObject.put("dislike_ids", sb.toString());
            }
            jSONObject.put("fid", this.alq.getFid());
            jSONObject.put("click_time", System.currentTimeMillis());
            return jSONObject;
        }
        jSONObject.put("tid", this.alq.getTid());
        if (sb.length() != 0) {
        }
        jSONObject.put("fid", this.alq.getFid());
        jSONObject.put("click_time", System.currentTimeMillis());
        return jSONObject;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void wM() {
        int size = this.alr.size();
        if (size > 0) {
            String string = this.mContext.getResources().getString(d.l.feedback_selected_reason, Integer.valueOf(size));
            SpannableString spannableString = new SpannableString(string);
            UtilHelper.setSpan(spannableString, string, String.valueOf(size), new ForegroundColorSpan(aj.getColor(d.e.cp_link_tip_a)));
            this.alA.setText(spannableString);
            this.alB.setText(this.mContext.getResources().getString(d.l.confirm));
            return;
        }
        this.alA.setText(this.mContext.getResources().getString(d.l.tell_us_reason));
        this.alB.setText(this.mContext.getResources().getString(d.l.not_interested));
    }

    public void setData(an anVar) {
        if (anVar != null) {
            this.alq = anVar;
            this.ald = anVar.qs();
            this.alC.setData(anVar);
        }
    }

    public void setFirstRowSingleColumn(boolean z) {
        this.alC.setFirstRowSingleColumn(z);
    }

    public void setEventCallback(h.a aVar) {
        this.alx = aVar;
    }

    public void setDefaultReasonArray(String[] strArr) {
        this.alC.setDefaultReasonArray(strArr);
    }

    public void wK() {
        if (this.alp != null) {
            this.alp.dismiss();
            this.alp = null;
        }
        if (this.aly != null) {
            this.aly.dismiss();
            this.aly = null;
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void onDetachedFromWindow() {
        MessageManager.getInstance().unRegisterListener(this.alG);
        wK();
    }

    private void wN() {
        if (this.alD && this.alr.size() != 0) {
            this.alr.clear();
            wM();
        }
    }
}
