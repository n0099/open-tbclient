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
import com.baidu.tbadk.core.util.an;
import com.baidu.tbadk.core.util.ar;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tbadk.widget.richText.TbRichTextView;
import com.baidu.tieba.R;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes.dex */
public class b {
    private TextView aeD;
    private final ThreadAchievementShareInfo dDR;
    private final ThreadAchievementShareInfo.ParamBean dDS;
    private TextView dEA;
    private TextView dEB;
    private TextView dEC;
    private TextView dED;
    private TbRichTextView dEx;
    private com.baidu.tbadk.widget.richText.a dEy;
    private TbImageView dEz;
    private final Context mContext;
    private final View mRoot;

    public b(Context context, ThreadAchievementShareInfo threadAchievementShareInfo) {
        this.mContext = context;
        this.mRoot = LayoutInflater.from(context).inflate(R.layout.normal_interaction_achievement, (ViewGroup) null);
        this.dDR = threadAchievementShareInfo;
        this.dDS = threadAchievementShareInfo.getParams();
        initUI();
        initData();
    }

    private void initData() {
        if (this.dDS.getContent() != null && this.dDS.getContent().size() != 0) {
            JSONArray jSONArray = new JSONArray();
            ThreadAchievementShareInfo.ContentBean contentBean = null;
            for (ThreadAchievementShareInfo.ContentBean contentBean2 : this.dDS.getContent()) {
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
            if (!TextUtils.isEmpty(this.dDS.getThread_title())) {
                this.aeD.setText(this.dDS.getThread_title());
                this.aeD.setVisibility(0);
                this.dEx.setMaxLines(6);
            } else {
                ((LinearLayout.LayoutParams) this.dEx.getLayoutParams()).topMargin = l.getDimens(this.mContext, R.dimen.tbds20);
                this.dEx.setMaxLines(8);
            }
            this.dEx.setTextEllipsize(TextUtils.TruncateAt.END);
            this.dEx.setMinimumHeight(l.getDimens(this.mContext, R.dimen.tbds516));
            if (contentBean != null && !TextUtils.isEmpty(contentBean.getSrc()) && this.dDS.getThread_type().contains(UgcUBCUtils.UGC_TYPE_PIC_BTN)) {
                this.dEz.setVisibility(0);
                this.dEz.setDefaultBgResource(R.color.transparent);
                this.dEz.setScaleType(ImageView.ScaleType.CENTER_CROP);
                this.dEz.setPlaceHolder(2);
                this.dEz.startLoad(contentBean.getSrc(), 10, false);
                if (!TextUtils.isEmpty(this.dDS.getThread_title())) {
                    this.dEx.setVisibility(8);
                } else {
                    this.dEx.setMaxLines(2);
                    this.dEx.setTextEllipsize(TextUtils.TruncateAt.END);
                    this.dEx.setLayoutStrategy(this.dEy);
                    this.dEx.setMinimumHeight(l.getDimens(this.mContext, R.dimen.tbds0));
                }
            }
            this.dEx.setText(TbRichTextView.a(this.mContext, jSONArray, false));
            this.dED.setText(ar.cq(this.dDS.getAgree_num()));
            this.dEA.setText(ar.cq(this.dDS.getPost_num()));
        }
    }

    private void initUI() {
        this.dEA = (TextView) this.mRoot.findViewById(R.id.comment_num);
        this.dEB = (TextView) this.mRoot.findViewById(R.id.comment_desc);
        this.dEC = (TextView) this.mRoot.findViewById(R.id.praise_desc);
        this.dED = (TextView) this.mRoot.findViewById(R.id.praise_num);
        this.aeD = (TextView) this.mRoot.findViewById(R.id.thread_title);
        this.dEz = (TbImageView) this.mRoot.findViewById(R.id.main_img);
        this.dEx = (TbRichTextView) this.mRoot.findViewById(R.id.rich_text);
        this.dED.setTextColor(an.getColor(R.color.cp_other_d));
        this.dEA.setTextColor(an.getColor(R.color.cp_other_d));
        this.dEC.setTextColor(an.getColor(R.color.cp_cont_b));
        this.dEB.setTextColor(an.getColor(R.color.cp_cont_b));
        this.aeD.setTextColor(an.getColor(R.color.cp_cont_b));
        this.dEy = new com.baidu.tbadk.widget.richText.a();
        this.dEy.oD(l.getDimens(this.mContext, R.dimen.tbds38));
        this.dEy.setTextSize(l.getDimens(this.mContext, R.dimen.tbds42));
        this.dEy.oH(l.getDimens(this.mContext, R.dimen.tbds23));
        this.dEy.setLineSpacing(l.getDimens(TbadkCoreApplication.getInst().getContext(), R.dimen.tbds12), 1.0f);
        this.dEy.bf(l.getDimens(TbadkCoreApplication.getInst().getContext(), R.dimen.tbds48), l.getDimens(TbadkCoreApplication.getInst().getContext(), R.dimen.tbds48));
        this.dEx.setLayoutStrategy(this.dEy);
        this.dEx.setTextColor(an.getColor(R.color.cp_cont_b));
    }

    public View getView() {
        return this.mRoot;
    }
}
