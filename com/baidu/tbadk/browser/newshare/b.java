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
import com.baidu.tbadk.core.util.ao;
import com.baidu.tbadk.core.util.at;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tbadk.widget.richText.TbRichTextView;
import com.baidu.tieba.R;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes.dex */
public class b {
    private TextView ahn;
    private final ThreadAchievementShareInfo eFO;
    private final ThreadAchievementShareInfo.ParamBean eFP;
    private TextView eGA;
    private TbRichTextView eGu;
    private com.baidu.tbadk.widget.richText.a eGv;
    private TbImageView eGw;
    private TextView eGx;
    private TextView eGy;
    private TextView eGz;
    private final Context mContext;
    private final View mRoot;

    public b(Context context, ThreadAchievementShareInfo threadAchievementShareInfo) {
        this.mContext = context;
        this.mRoot = LayoutInflater.from(context).inflate(R.layout.normal_interaction_achievement, (ViewGroup) null);
        this.eFO = threadAchievementShareInfo;
        this.eFP = threadAchievementShareInfo.getParams();
        initUI();
        initData();
    }

    private void initData() {
        if (this.eFP.getContent() != null && this.eFP.getContent().size() != 0) {
            JSONArray jSONArray = new JSONArray();
            ThreadAchievementShareInfo.ContentBean contentBean = null;
            for (ThreadAchievementShareInfo.ContentBean contentBean2 : this.eFP.getContent()) {
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
            if (!TextUtils.isEmpty(this.eFP.getThread_title())) {
                this.ahn.setText(this.eFP.getThread_title());
                this.ahn.setVisibility(0);
                this.eGu.setMaxLines(6);
            } else {
                ((LinearLayout.LayoutParams) this.eGu.getLayoutParams()).topMargin = l.getDimens(this.mContext, R.dimen.tbds20);
                this.eGu.setMaxLines(8);
            }
            this.eGu.setTextEllipsize(TextUtils.TruncateAt.END);
            this.eGu.setMinimumHeight(l.getDimens(this.mContext, R.dimen.tbds516));
            if (contentBean != null && !TextUtils.isEmpty(contentBean.getSrc()) && this.eFP.getThread_type().contains("pic")) {
                this.eGw.setVisibility(0);
                this.eGw.setDefaultBgResource(R.color.transparent);
                this.eGw.setScaleType(ImageView.ScaleType.CENTER_CROP);
                this.eGw.setPlaceHolder(2);
                this.eGw.startLoad(contentBean.getSrc(), 10, false);
                if (!TextUtils.isEmpty(this.eFP.getThread_title())) {
                    this.eGu.setVisibility(8);
                } else {
                    this.eGu.setMaxLines(2);
                    this.eGu.setTextEllipsize(TextUtils.TruncateAt.END);
                    this.eGu.setLayoutStrategy(this.eGv);
                    this.eGu.setMinimumHeight(l.getDimens(this.mContext, R.dimen.tbds0));
                }
            }
            this.eGu.setText(TbRichTextView.a(this.mContext, jSONArray, false));
            this.eGA.setText(at.ea(this.eFP.getAgree_num()));
            this.eGx.setText(at.ea(this.eFP.getPost_num()));
        }
    }

    private void initUI() {
        this.eGx = (TextView) this.mRoot.findViewById(R.id.comment_num);
        this.eGy = (TextView) this.mRoot.findViewById(R.id.comment_desc);
        this.eGz = (TextView) this.mRoot.findViewById(R.id.praise_desc);
        this.eGA = (TextView) this.mRoot.findViewById(R.id.praise_num);
        this.ahn = (TextView) this.mRoot.findViewById(R.id.thread_title);
        this.eGw = (TbImageView) this.mRoot.findViewById(R.id.main_img);
        this.eGu = (TbRichTextView) this.mRoot.findViewById(R.id.rich_text);
        this.eGA.setTextColor(ao.getColor(R.color.CAM_X0310));
        this.eGx.setTextColor(ao.getColor(R.color.CAM_X0310));
        this.eGz.setTextColor(ao.getColor(R.color.CAM_X0105));
        this.eGy.setTextColor(ao.getColor(R.color.CAM_X0105));
        this.ahn.setTextColor(ao.getColor(R.color.CAM_X0105));
        this.eGv = new com.baidu.tbadk.widget.richText.a();
        this.eGv.rY(l.getDimens(this.mContext, R.dimen.tbds38));
        this.eGv.setTextSize(l.getDimens(this.mContext, R.dimen.tbds42));
        this.eGv.sc(l.getDimens(this.mContext, R.dimen.tbds23));
        this.eGv.setLineSpacing(l.getDimens(TbadkCoreApplication.getInst().getContext(), R.dimen.tbds12), 1.0f);
        this.eGv.br(l.getDimens(TbadkCoreApplication.getInst().getContext(), R.dimen.tbds48), l.getDimens(TbadkCoreApplication.getInst().getContext(), R.dimen.tbds48));
        this.eGu.setLayoutStrategy(this.eGv);
        this.eGu.setTextColor(ao.getColor(R.color.CAM_X0105));
    }

    public View getView() {
        return this.mRoot;
    }
}
