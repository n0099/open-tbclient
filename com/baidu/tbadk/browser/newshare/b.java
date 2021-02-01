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
import com.baidu.tbadk.browser.newshare.ThreadAchievementShareInfo;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.ap;
import com.baidu.tbadk.core.util.au;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tbadk.widget.richText.TbRichTextView;
import com.baidu.tieba.R;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes.dex */
public class b {
    private TextView ahb;
    private final ThreadAchievementShareInfo eHU;
    private final ThreadAchievementShareInfo.ParamBean eHV;
    private TbRichTextView eIA;
    private com.baidu.tbadk.widget.richText.a eIB;
    private TbImageView eIC;
    private TextView eID;
    private TextView eIE;
    private TextView eIF;
    private TextView eIG;
    private final Context mContext;
    private final View mRoot;

    public b(Context context, ThreadAchievementShareInfo threadAchievementShareInfo) {
        this.mContext = context;
        this.mRoot = LayoutInflater.from(context).inflate(R.layout.normal_interaction_achievement, (ViewGroup) null);
        this.eHU = threadAchievementShareInfo;
        this.eHV = threadAchievementShareInfo.getParams();
        initUI();
        initData();
    }

    private void initData() {
        if (this.eHV.getContent() != null && this.eHV.getContent().size() != 0) {
            JSONArray jSONArray = new JSONArray();
            ThreadAchievementShareInfo.ContentBean contentBean = null;
            for (ThreadAchievementShareInfo.ContentBean contentBean2 : this.eHV.getContent()) {
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
            if (!TextUtils.isEmpty(this.eHV.getThread_title())) {
                this.ahb.setText(this.eHV.getThread_title());
                this.ahb.setVisibility(0);
                this.eIA.setMaxLines(6);
            } else {
                ((LinearLayout.LayoutParams) this.eIA.getLayoutParams()).topMargin = l.getDimens(this.mContext, R.dimen.tbds20);
                this.eIA.setMaxLines(8);
            }
            this.eIA.setTextEllipsize(TextUtils.TruncateAt.END);
            this.eIA.setMinimumHeight(l.getDimens(this.mContext, R.dimen.tbds516));
            if (contentBean != null && !TextUtils.isEmpty(contentBean.getSrc()) && this.eHV.getThread_type().contains("pic")) {
                this.eIC.setVisibility(0);
                this.eIC.setDefaultBgResource(R.color.transparent);
                this.eIC.setScaleType(ImageView.ScaleType.CENTER_CROP);
                this.eIC.setPlaceHolder(2);
                this.eIC.startLoad(contentBean.getSrc(), 10, false);
                if (!TextUtils.isEmpty(this.eHV.getThread_title())) {
                    this.eIA.setVisibility(8);
                } else {
                    this.eIA.setMaxLines(2);
                    this.eIA.setTextEllipsize(TextUtils.TruncateAt.END);
                    this.eIA.setLayoutStrategy(this.eIB);
                    this.eIA.setMinimumHeight(l.getDimens(this.mContext, R.dimen.tbds0));
                }
            }
            this.eIA.setText(TbRichTextView.a(this.mContext, jSONArray, false));
            this.eIG.setText(au.eg(this.eHV.getAgree_num()));
            this.eID.setText(au.eg(this.eHV.getPost_num()));
        }
    }

    private void initUI() {
        this.eID = (TextView) this.mRoot.findViewById(R.id.comment_num);
        this.eIE = (TextView) this.mRoot.findViewById(R.id.comment_desc);
        this.eIF = (TextView) this.mRoot.findViewById(R.id.praise_desc);
        this.eIG = (TextView) this.mRoot.findViewById(R.id.praise_num);
        this.ahb = (TextView) this.mRoot.findViewById(R.id.thread_title);
        this.eIC = (TbImageView) this.mRoot.findViewById(R.id.main_img);
        this.eIA = (TbRichTextView) this.mRoot.findViewById(R.id.rich_text);
        this.eIG.setTextColor(ap.getColor(R.color.CAM_X0310));
        this.eID.setTextColor(ap.getColor(R.color.CAM_X0310));
        this.eIF.setTextColor(ap.getColor(R.color.CAM_X0105));
        this.eIE.setTextColor(ap.getColor(R.color.CAM_X0105));
        this.ahb.setTextColor(ap.getColor(R.color.CAM_X0105));
        this.eIB = new com.baidu.tbadk.widget.richText.a();
        this.eIB.sd(l.getDimens(this.mContext, R.dimen.tbds38));
        this.eIB.setTextSize(l.getDimens(this.mContext, R.dimen.tbds42));
        this.eIB.sh(l.getDimens(this.mContext, R.dimen.tbds23));
        this.eIB.setLineSpacing(l.getDimens(TbadkCoreApplication.getInst().getContext(), R.dimen.tbds12), 1.0f);
        this.eIB.bo(l.getDimens(TbadkCoreApplication.getInst().getContext(), R.dimen.tbds48), l.getDimens(TbadkCoreApplication.getInst().getContext(), R.dimen.tbds48));
        this.eIA.setLayoutStrategy(this.eIB);
        this.eIA.setTextColor(ap.getColor(R.color.CAM_X0105));
    }

    public View getView() {
        return this.mRoot;
    }
}
