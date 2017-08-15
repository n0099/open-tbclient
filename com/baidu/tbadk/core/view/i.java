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
    private int alY;
    private int alZ;
    private int ama;
    private int amb;
    private int amc;
    private PopupWindow ame;
    private View amf;
    private TextView amg;
    private TextView amh;
    private g ami;
    private boolean amj;
    private ViewGroup mContentView;
    private Context mContext;
    private int mWindowHeight;
    private TbPageContext oV;
    private PopupWindow alV = null;
    private an alW = null;
    private SparseArray<String> alK = null;
    private List<g.a> alX = new ArrayList();
    private h.a amd = null;
    private CompoundButton.OnCheckedChangeListener alN = new CompoundButton.OnCheckedChangeListener() { // from class: com.baidu.tbadk.core.view.i.1
        @Override // android.widget.CompoundButton.OnCheckedChangeListener
        public void onCheckedChanged(CompoundButton compoundButton, boolean z) {
            if (i.this.amd != null) {
                i.this.amd.a(i.this.alW, compoundButton, z);
            }
            if (compoundButton.getTag() instanceof g.a) {
                g.a aVar = (g.a) compoundButton.getTag();
                if (z) {
                    if (!i.this.alX.contains(aVar)) {
                        i.this.alX.add(aVar);
                    }
                } else {
                    i.this.alX.remove(aVar);
                }
            }
            i.this.wO();
        }
    };
    private View.OnClickListener amk = new View.OnClickListener() { // from class: com.baidu.tbadk.core.view.i.2
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (i.this.alW != null && i.this.alV != null) {
                ArrayList<Integer> arrayList = new ArrayList<>();
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.NEG_FEED_BACK_DELETE, i.this.l(arrayList)));
                i.this.wM();
                c cVar = new c();
                cVar.alo = 1500L;
                cVar.d(i.this.mContext.getResources().getString(d.l.reduce_related_thread_recommend));
                if (i.this.amd != null) {
                    i.this.amd.a(arrayList, i.this.alW);
                }
            }
        }
    };
    private PopupWindow.OnDismissListener aml = new PopupWindow.OnDismissListener() { // from class: com.baidu.tbadk.core.view.i.3
        @Override // android.widget.PopupWindow.OnDismissListener
        public void onDismiss() {
            if (i.this.ame != null) {
                i.this.ame.dismiss();
                i.this.ame = null;
            }
        }
    };
    private CustomMessageListener amm = new CustomMessageListener(CmdConfigCustom.CMD_HIDE_NEGATIVE_FEED_BACK_WIN) { // from class: com.baidu.tbadk.core.view.i.4
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            i.this.wM();
        }
    };

    public i(TbPageContext tbPageContext, View view) {
        this.mContext = null;
        this.mContext = tbPageContext.getPageActivity();
        this.oV = tbPageContext;
        this.amf = view;
        init();
    }

    private void init() {
        this.amb = com.baidu.adp.lib.util.k.g(this.mContext, d.f.ds36);
        this.amc = com.baidu.adp.lib.util.k.g(this.mContext, d.f.ds6);
        this.alY = com.baidu.adp.lib.util.k.ag(this.mContext) - (this.amb * 2);
        this.ama = com.baidu.adp.lib.util.k.g(this.mContext, d.f.ds120);
        this.ami = new g(this.oV);
        this.ami.a(this.alN);
        this.oV.registerListener(this.amm);
    }

    public void setUniqueId(BdUniqueId bdUniqueId) {
        if (bdUniqueId != null) {
            if (this.amm != null) {
                this.amm.setTag(bdUniqueId);
            }
            MessageManager.getInstance().registerListener(this.amm);
        }
    }

    public void wL() {
        if (this.mContext != null && this.alK != null && this.alK.size() != 0) {
            View contentView = getContentView();
            this.mWindowHeight = wN();
            this.alV = new PopupWindow(contentView, this.alY, this.mWindowHeight);
            this.alV.setFocusable(true);
            this.alV.setTouchable(true);
            this.alV.setOnDismissListener(this.aml);
            resetState();
            this.ame = new PopupWindow(LayoutInflater.from(this.mContext).inflate(d.j.view_negative_feedback_bottom, (ViewGroup) null), -1, -1);
            this.ame.showAtLocation(this.amf, 0, 0, 0);
            int[] iArr = new int[2];
            boolean a = a(this.mContext, this.amf, this.mWindowHeight, this.alY, this.ama, this.amc, iArr);
            if (iArr[0] != 0 || iArr[1] != 0) {
                if (a) {
                    this.alV.setAnimationStyle(d.m.scale_rb2lt_anim);
                    ai.a(this.alV, d.g.bg_home_feedback_under);
                } else {
                    this.alV.setAnimationStyle(d.m.scale_rt2lb_anim);
                    ai.a(this.alV, d.g.bg_home_feedback_top);
                }
                this.alV.showAtLocation(this.amf, 0, iArr[0] - this.amb, iArr[1]);
                if (this.amd != null) {
                    this.amd.a(this.alW);
                }
                this.amj = true;
            }
        }
    }

    private View getContentView() {
        if (this.mContext == null) {
            return null;
        }
        if (this.mContentView == null) {
            this.mContentView = (ViewGroup) LayoutInflater.from(this.mContext).inflate(d.j.neg_feedback_popupwindow, (ViewGroup) null);
            this.amg = (TextView) this.mContentView.findViewById(d.h.head_text);
            this.amh = (TextView) this.mContentView.findViewById(d.h.uninterested_text);
            this.amh.setOnClickListener(this.amk);
            ai.c(this.amg, d.e.cp_cont_d, 1);
            ai.c(this.amh, d.e.cp_link_tip_a, 1);
        }
        View view = this.ami.getView();
        if (view != null && view.getParent() == null) {
            this.mContentView.addView(view);
        }
        return this.mContentView;
    }

    private int wN() {
        if (this.mContentView == null) {
            return 0;
        }
        this.mContentView.measure(0, 0);
        this.alZ = this.mContentView.getMeasuredHeight() + com.baidu.adp.lib.util.k.g(this.mContext, d.f.ds12);
        return this.alZ;
    }

    private boolean a(Context context, View view, int i, int i2, int i3, int i4, int[] iArr) {
        if (context == null || view == null || iArr == null || iArr.length != 2) {
            return false;
        }
        int[] iArr2 = new int[2];
        view.getLocationOnScreen(iArr2);
        int height = view.getHeight();
        int ah = com.baidu.adp.lib.util.k.ah(context);
        int ag = com.baidu.adp.lib.util.k.ag(context);
        boolean z = ((ah - iArr2[1]) - height) - i3 < i;
        iArr[0] = ag - i2;
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
        if (this.alW == null || arrayList == null) {
            return null;
        }
        StringBuilder sb = new StringBuilder();
        if (!u.v(this.alX)) {
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 < this.alX.size()) {
                    g.a aVar = this.alX.get(i2);
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
            jSONObject.put("tid", this.alW.getTid());
            if (sb.length() != 0) {
                jSONObject.put("dislike_ids", sb.toString());
            }
            jSONObject.put("fid", this.alW.getFid());
            jSONObject.put("click_time", System.currentTimeMillis());
            return jSONObject;
        }
        jSONObject.put("tid", this.alW.getTid());
        if (sb.length() != 0) {
        }
        jSONObject.put("fid", this.alW.getFid());
        jSONObject.put("click_time", System.currentTimeMillis());
        return jSONObject;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void wO() {
        int size = this.alX.size();
        if (size > 0) {
            String string = this.mContext.getResources().getString(d.l.feedback_selected_reason, Integer.valueOf(size));
            SpannableString spannableString = new SpannableString(string);
            UtilHelper.setSpan(spannableString, string, String.valueOf(size), new ForegroundColorSpan(ai.getColor(d.e.cp_link_tip_a)));
            this.amg.setText(spannableString);
            this.amh.setText(this.mContext.getResources().getString(d.l.confirm));
            return;
        }
        this.amg.setText(this.mContext.getResources().getString(d.l.tell_us_reason));
        this.amh.setText(this.mContext.getResources().getString(d.l.not_interested));
    }

    public void setData(an anVar) {
        if (anVar != null) {
            this.alW = anVar;
            this.alK = anVar.qw();
            this.ami.setData(anVar);
        }
    }

    public void setFirstRowSingleColumn(boolean z) {
        this.ami.setFirstRowSingleColumn(z);
    }

    public void setEventCallback(h.a aVar) {
        this.amd = aVar;
    }

    public void setDefaultReasonArray(String[] strArr) {
        this.ami.setDefaultReasonArray(strArr);
    }

    public void wM() {
        if (this.alV != null) {
            this.alV.dismiss();
            this.alV = null;
        }
        if (this.ame != null) {
            this.ame.dismiss();
            this.ame = null;
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void onDetachedFromWindow() {
        MessageManager.getInstance().unRegisterListener(this.amm);
        wM();
    }

    private void resetState() {
        if (this.amj && this.alX.size() != 0) {
            this.alX.clear();
            wO();
        }
    }
}
