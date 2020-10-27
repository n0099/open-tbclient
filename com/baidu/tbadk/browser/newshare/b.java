package com.baidu.tbadk.browser.newshare;

import android.content.Context;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.baidu.adp.lib.util.l;
import com.baidu.searchbox.ugc.utils.UgcUBCUtils;
import com.baidu.tbadk.browser.newshare.ThreadAchievementShareInfo;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.ap;
import com.baidu.tbadk.core.util.at;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tbadk.widget.richText.TbRichTextView;
import com.baidu.tieba.R;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes.dex */
public class b {
    private TextView agp;
    private final ThreadAchievementShareInfo epK;
    private final ThreadAchievementShareInfo.ParamBean epL;
    private TbRichTextView eqq;
    private com.baidu.tbadk.widget.richText.a eqr;
    private TbImageView eqs;
    private TextView eqt;
    private TextView equ;
    private TextView eqv;
    private TextView eqw;
    private final Context mContext;
    private final View mRoot;

    public b(Context context, ThreadAchievementShareInfo threadAchievementShareInfo) {
        this.mContext = context;
        this.mRoot = LayoutInflater.from(context).inflate(R.layout.normal_interaction_achievement, (ViewGroup) null);
        this.epK = threadAchievementShareInfo;
        this.epL = threadAchievementShareInfo.getParams();
        initUI();
        initData();
    }

    private void initData() {
        if (this.epL.getContent() != null && this.epL.getContent().size() != 0) {
            JSONArray jSONArray = new JSONArray();
            ThreadAchievementShareInfo.ContentBean contentBean = null;
            for (ThreadAchievementShareInfo.ContentBean contentBean2 : this.epL.getContent()) {
                if (contentBean2.getType() == 0) {
                    JSONObject jSONObject = new JSONObject();
                    try {
                        jSONObject.put("type", "0");
                        jSONObject.put("text", contentBean2.getText());
                    } catch (JSONException e) {
                        e.printStackTrace();
                    }
                    jSONArray.put(jSONObject);
                    contentBean2 = contentBean;
                } else if (contentBean2.getType() != 3) {
                    contentBean2 = contentBean;
                }
                contentBean = contentBean2;
            }
            if (!TextUtils.isEmpty(this.epL.getThread_title())) {
                this.agp.setText(this.epL.getThread_title());
                this.agp.setVisibility(0);
                this.eqq.setMaxLines(6);
            } else {
                ((LinearLayout.LayoutParams) this.eqq.getLayoutParams()).topMargin = l.getDimens(this.mContext, R.dimen.tbds20);
                this.eqq.setMaxLines(8);
            }
            this.eqq.setTextEllipsize(TextUtils.TruncateAt.END);
            this.eqq.setMinimumHeight(l.getDimens(this.mContext, R.dimen.tbds516));
            if (contentBean != null && !TextUtils.isEmpty(contentBean.getSrc()) && this.epL.getThread_type().contains(UgcUBCUtils.UGC_TYPE_PIC_BTN)) {
                this.eqs.setVisibility(0);
                this.eqs.setDefaultBgResource(R.color.transparent);
                this.eqs.setScaleType(ImageView.ScaleType.CENTER_CROP);
                this.eqs.setPlaceHolder(2);
                this.eqs.startLoad(contentBean.getSrc(), 10, false);
                if (!TextUtils.isEmpty(this.epL.getThread_title())) {
                    this.eqq.setVisibility(8);
                } else {
                    this.eqq.setMaxLines(2);
                    this.eqq.setTextEllipsize(TextUtils.TruncateAt.END);
                    this.eqq.setLayoutStrategy(this.eqr);
                    this.eqq.setMinimumHeight(l.getDimens(this.mContext, R.dimen.tbds0));
                }
            }
            this.eqq.setText(TbRichTextView.a(this.mContext, jSONArray, false));
            this.eqw.setText(at.df(this.epL.getAgree_num()));
            this.eqt.setText(at.df(this.epL.getPost_num()));
        }
    }

    private void initUI() {
        this.eqt = (TextView) this.mRoot.findViewById(R.id.comment_num);
        this.equ = (TextView) this.mRoot.findViewById(R.id.comment_desc);
        this.eqv = (TextView) this.mRoot.findViewById(R.id.praise_desc);
        this.eqw = (TextView) this.mRoot.findViewById(R.id.praise_num);
        this.agp = (TextView) this.mRoot.findViewById(R.id.thread_title);
        this.eqs = (TbImageView) this.mRoot.findViewById(R.id.main_img);
        this.eqq = (TbRichTextView) this.mRoot.findViewById(R.id.rich_text);
        this.eqw.setTextColor(ap.getColor(R.color.cp_other_d));
        this.eqt.setTextColor(ap.getColor(R.color.cp_other_d));
        this.eqv.setTextColor(ap.getColor(R.color.cp_cont_b));
        this.equ.setTextColor(ap.getColor(R.color.cp_cont_b));
        this.agp.setTextColor(ap.getColor(R.color.cp_cont_b));
        this.eqr = new com.baidu.tbadk.widget.richText.a();
        this.eqr.si(l.getDimens(this.mContext, R.dimen.tbds38));
        this.eqr.setTextSize(l.getDimens(this.mContext, R.dimen.tbds42));
        this.eqr.sm(l.getDimens(this.mContext, R.dimen.tbds23));
        this.eqr.setLineSpacing(l.getDimens(TbadkCoreApplication.getInst().getContext(), R.dimen.tbds12), 1.0f);
        this.eqr.br(l.getDimens(TbadkCoreApplication.getInst().getContext(), R.dimen.tbds48), l.getDimens(TbadkCoreApplication.getInst().getContext(), R.dimen.tbds48));
        this.eqq.setLayoutStrategy(this.eqr);
        this.eqq.setTextColor(ap.getColor(R.color.cp_cont_b));
    }

    public View getView() {
        return this.mRoot;
    }
}
