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
import com.baidu.tbadk.core.util.ai;
import com.baidu.tbadk.core.util.u;
import com.baidu.tbadk.core.view.g;
import com.baidu.tbadk.core.view.h;
import com.baidu.tieba.d;
import com.xiaomi.mipush.sdk.Constants;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONObject;
/* loaded from: classes.dex */
public class i {
    private int akD;
    private int akE;
    private int akF;
    private int akG;
    private int akH;
    private PopupWindow akJ;
    private View akK;
    private TextView akL;
    private TextView akM;
    private g akN;
    private boolean akO;
    private TbPageContext ako;
    private ViewGroup mContentView;
    private Context mContext;
    private int mWindowHeight;
    private PopupWindow akA = null;
    private an akB = null;
    private SparseArray<String> akp = null;
    private List<g.a> akC = new ArrayList();
    private h.a akI = null;
    private CompoundButton.OnCheckedChangeListener aks = new CompoundButton.OnCheckedChangeListener() { // from class: com.baidu.tbadk.core.view.i.1
        @Override // android.widget.CompoundButton.OnCheckedChangeListener
        public void onCheckedChanged(CompoundButton compoundButton, boolean z) {
            if (i.this.akI != null) {
                i.this.akI.a(i.this.akB, compoundButton, z);
            }
            if (compoundButton.getTag() instanceof g.a) {
                g.a aVar = (g.a) compoundButton.getTag();
                if (z) {
                    if (!i.this.akC.contains(aVar)) {
                        i.this.akC.add(aVar);
                    }
                } else {
                    i.this.akC.remove(aVar);
                }
            }
            i.this.wE();
        }
    };
    private View.OnClickListener akP = new View.OnClickListener() { // from class: com.baidu.tbadk.core.view.i.2
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (i.this.akB != null && i.this.akA != null) {
                ArrayList<Integer> arrayList = new ArrayList<>();
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.NEG_FEED_BACK_DELETE, i.this.l(arrayList)));
                i.this.wC();
                c cVar = new c();
                cVar.ajS = 1500L;
                cVar.d(i.this.mContext.getResources().getString(d.l.reduce_related_thread_recommend));
                if (i.this.akI != null) {
                    i.this.akI.a(arrayList, i.this.akB);
                }
            }
        }
    };
    private PopupWindow.OnDismissListener akQ = new PopupWindow.OnDismissListener() { // from class: com.baidu.tbadk.core.view.i.3
        @Override // android.widget.PopupWindow.OnDismissListener
        public void onDismiss() {
            if (i.this.akJ != null) {
                i.this.akJ.dismiss();
                i.this.akJ = null;
            }
        }
    };
    private CustomMessageListener akR = new CustomMessageListener(CmdConfigCustom.CMD_HIDE_NEGATIVE_FEED_BACK_WIN) { // from class: com.baidu.tbadk.core.view.i.4
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            i.this.wC();
        }
    };

    public i(TbPageContext tbPageContext, View view) {
        this.mContext = null;
        this.mContext = tbPageContext.getPageActivity();
        this.ako = tbPageContext;
        this.akK = view;
        init();
    }

    private void init() {
        this.akG = com.baidu.adp.lib.util.k.g(this.mContext, d.f.ds36);
        this.akH = com.baidu.adp.lib.util.k.g(this.mContext, d.f.ds6);
        this.akD = com.baidu.adp.lib.util.k.af(this.mContext) - (this.akG * 2);
        this.akF = com.baidu.adp.lib.util.k.g(this.mContext, d.f.ds120);
        this.akN = new g(this.ako);
        this.akN.a(this.aks);
        this.ako.registerListener(this.akR);
    }

    public void setUniqueId(BdUniqueId bdUniqueId) {
        if (bdUniqueId != null) {
            if (this.akR != null) {
                this.akR.setTag(bdUniqueId);
            }
            MessageManager.getInstance().registerListener(this.akR);
        }
    }

    public void wB() {
        if (this.mContext != null && this.akp != null && this.akp.size() != 0) {
            View contentView = getContentView();
            this.mWindowHeight = wD();
            this.akA = new PopupWindow(contentView, this.akD, this.mWindowHeight);
            this.akA.setFocusable(true);
            this.akA.setTouchable(true);
            this.akA.setOnDismissListener(this.akQ);
            wF();
            this.akJ = new PopupWindow(LayoutInflater.from(this.mContext).inflate(d.j.view_negative_feedback_bottom, (ViewGroup) null), -1, -1);
            this.akJ.showAtLocation(this.akK, 0, 0, 0);
            int[] iArr = new int[2];
            boolean a = a(this.mContext, this.akK, this.mWindowHeight, this.akD, this.akF, this.akH, iArr);
            if (iArr[0] != 0 || iArr[1] != 0) {
                if (a) {
                    this.akA.setAnimationStyle(d.m.scale_rb2lt_anim);
                    ai.a(this.akA, d.g.bg_home_feedback_under);
                } else {
                    this.akA.setAnimationStyle(d.m.scale_rt2lb_anim);
                    ai.a(this.akA, d.g.bg_home_feedback_top);
                }
                this.akA.showAtLocation(this.akK, 0, iArr[0] - this.akG, iArr[1]);
                if (this.akI != null) {
                    this.akI.a(this.akB);
                }
                this.akO = true;
            }
        }
    }

    private View getContentView() {
        if (this.mContext == null) {
            return null;
        }
        if (this.mContentView == null) {
            this.mContentView = (ViewGroup) LayoutInflater.from(this.mContext).inflate(d.j.neg_feedback_popupwindow, (ViewGroup) null);
            this.akL = (TextView) this.mContentView.findViewById(d.h.head_text);
            this.akM = (TextView) this.mContentView.findViewById(d.h.uninterested_text);
            this.akM.setOnClickListener(this.akP);
            ai.c(this.akL, d.e.cp_cont_d, 1);
            ai.c(this.akM, d.e.cp_link_tip_a, 1);
        }
        View view = this.akN.getView();
        if (view != null && view.getParent() == null) {
            this.mContentView.addView(view);
        }
        return this.mContentView;
    }

    private int wD() {
        if (this.mContentView == null) {
            return 0;
        }
        this.mContentView.measure(0, 0);
        this.akE = this.mContentView.getMeasuredHeight() + com.baidu.adp.lib.util.k.g(this.mContext, d.f.ds12);
        return this.akE;
    }

    private boolean a(Context context, View view, int i, int i2, int i3, int i4, int[] iArr) {
        if (context == null || view == null || iArr == null || iArr.length != 2) {
            return false;
        }
        int[] iArr2 = new int[2];
        view.getLocationOnScreen(iArr2);
        int height = view.getHeight();
        int ag = com.baidu.adp.lib.util.k.ag(context);
        int af = com.baidu.adp.lib.util.k.af(context);
        boolean z = ((ag - iArr2[1]) - height) - i3 < i;
        iArr[0] = af - i2;
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
        if (this.akB == null || arrayList == null) {
            return null;
        }
        StringBuilder sb = new StringBuilder();
        if (!u.v(this.akC)) {
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 < this.akC.size()) {
                    g.a aVar = this.akC.get(i2);
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
            jSONObject.put("tid", this.akB.getTid());
            if (sb.length() != 0) {
                jSONObject.put("dislike_ids", sb.toString());
            }
            jSONObject.put("fid", this.akB.getFid());
            jSONObject.put("click_time", System.currentTimeMillis());
            return jSONObject;
        }
        jSONObject.put("tid", this.akB.getTid());
        if (sb.length() != 0) {
        }
        jSONObject.put("fid", this.akB.getFid());
        jSONObject.put("click_time", System.currentTimeMillis());
        return jSONObject;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void wE() {
        int size = this.akC.size();
        if (size > 0) {
            String string = this.mContext.getResources().getString(d.l.feedback_selected_reason, Integer.valueOf(size));
            SpannableString spannableString = new SpannableString(string);
            UtilHelper.setSpan(spannableString, string, String.valueOf(size), new ForegroundColorSpan(ai.getColor(d.e.cp_link_tip_a)));
            this.akL.setText(spannableString);
            this.akM.setText(this.mContext.getResources().getString(d.l.confirm));
            return;
        }
        this.akL.setText(this.mContext.getResources().getString(d.l.tell_us_reason));
        this.akM.setText(this.mContext.getResources().getString(d.l.not_interested));
    }

    public void setData(an anVar) {
        if (anVar != null) {
            this.akB = anVar;
            this.akp = anVar.qm();
            this.akN.setData(anVar);
        }
    }

    public void setFirstRowSingleColumn(boolean z) {
        this.akN.setFirstRowSingleColumn(z);
    }

    public void setEventCallback(h.a aVar) {
        this.akI = aVar;
    }

    public void setDefaultReasonArray(String[] strArr) {
        this.akN.setDefaultReasonArray(strArr);
    }

    public void wC() {
        if (this.akA != null) {
            this.akA.dismiss();
            this.akA = null;
        }
        if (this.akJ != null) {
            this.akJ.dismiss();
            this.akJ = null;
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void onDetachedFromWindow() {
        MessageManager.getInstance().unRegisterListener(this.akR);
        wC();
    }

    private void wF() {
        if (this.akO && this.akC.size() != 0) {
            this.akC.clear();
            wE();
        }
    }
}
