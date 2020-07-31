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
import com.baidu.tbadk.core.util.ao;
import com.baidu.tbadk.core.util.as;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tbadk.widget.richText.TbRichTextView;
import com.baidu.tieba.R;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes.dex */
public class b {
    private TextView aet;
    private final ThreadAchievementShareInfo dJO;
    private final ThreadAchievementShareInfo.ParamBean dJP;
    private TextView dKA;
    private TbRichTextView dKu;
    private com.baidu.tbadk.widget.richText.a dKv;
    private TbImageView dKw;
    private TextView dKx;
    private TextView dKy;
    private TextView dKz;
    private final Context mContext;
    private final View mRoot;

    public b(Context context, ThreadAchievementShareInfo threadAchievementShareInfo) {
        this.mContext = context;
        this.mRoot = LayoutInflater.from(context).inflate(R.layout.normal_interaction_achievement, (ViewGroup) null);
        this.dJO = threadAchievementShareInfo;
        this.dJP = threadAchievementShareInfo.getParams();
        initUI();
        initData();
    }

    private void initData() {
        if (this.dJP.getContent() != null && this.dJP.getContent().size() != 0) {
            JSONArray jSONArray = new JSONArray();
            ThreadAchievementShareInfo.ContentBean contentBean = null;
            for (ThreadAchievementShareInfo.ContentBean contentBean2 : this.dJP.getContent()) {
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
            if (!TextUtils.isEmpty(this.dJP.getThread_title())) {
                this.aet.setText(this.dJP.getThread_title());
                this.aet.setVisibility(0);
                this.dKu.setMaxLines(6);
            } else {
                ((LinearLayout.LayoutParams) this.dKu.getLayoutParams()).topMargin = l.getDimens(this.mContext, R.dimen.tbds20);
                this.dKu.setMaxLines(8);
            }
            this.dKu.setTextEllipsize(TextUtils.TruncateAt.END);
            this.dKu.setMinimumHeight(l.getDimens(this.mContext, R.dimen.tbds516));
            if (contentBean != null && !TextUtils.isEmpty(contentBean.getSrc()) && this.dJP.getThread_type().contains(UgcUBCUtils.UGC_TYPE_PIC_BTN)) {
                this.dKw.setVisibility(0);
                this.dKw.setDefaultBgResource(R.color.transparent);
                this.dKw.setScaleType(ImageView.ScaleType.CENTER_CROP);
                this.dKw.setPlaceHolder(2);
                this.dKw.startLoad(contentBean.getSrc(), 10, false);
                if (!TextUtils.isEmpty(this.dJP.getThread_title())) {
                    this.dKu.setVisibility(8);
                } else {
                    this.dKu.setMaxLines(2);
                    this.dKu.setTextEllipsize(TextUtils.TruncateAt.END);
                    this.dKu.setLayoutStrategy(this.dKv);
                    this.dKu.setMinimumHeight(l.getDimens(this.mContext, R.dimen.tbds0));
                }
            }
            this.dKu.setText(TbRichTextView.a(this.mContext, jSONArray, false));
            this.dKA.setText(as.cJ(this.dJP.getAgree_num()));
            this.dKx.setText(as.cJ(this.dJP.getPost_num()));
        }
    }

    private void initUI() {
        this.dKx = (TextView) this.mRoot.findViewById(R.id.comment_num);
        this.dKy = (TextView) this.mRoot.findViewById(R.id.comment_desc);
        this.dKz = (TextView) this.mRoot.findViewById(R.id.praise_desc);
        this.dKA = (TextView) this.mRoot.findViewById(R.id.praise_num);
        this.aet = (TextView) this.mRoot.findViewById(R.id.thread_title);
        this.dKw = (TbImageView) this.mRoot.findViewById(R.id.main_img);
        this.dKu = (TbRichTextView) this.mRoot.findViewById(R.id.rich_text);
        this.dKA.setTextColor(ao.getColor(R.color.cp_other_d));
        this.dKx.setTextColor(ao.getColor(R.color.cp_other_d));
        this.dKz.setTextColor(ao.getColor(R.color.cp_cont_b));
        this.dKy.setTextColor(ao.getColor(R.color.cp_cont_b));
        this.aet.setTextColor(ao.getColor(R.color.cp_cont_b));
        this.dKv = new com.baidu.tbadk.widget.richText.a();
        this.dKv.oW(l.getDimens(this.mContext, R.dimen.tbds38));
        this.dKv.setTextSize(l.getDimens(this.mContext, R.dimen.tbds42));
        this.dKv.pa(l.getDimens(this.mContext, R.dimen.tbds23));
        this.dKv.setLineSpacing(l.getDimens(TbadkCoreApplication.getInst().getContext(), R.dimen.tbds12), 1.0f);
        this.dKv.bi(l.getDimens(TbadkCoreApplication.getInst().getContext(), R.dimen.tbds48), l.getDimens(TbadkCoreApplication.getInst().getContext(), R.dimen.tbds48));
        this.dKu.setLayoutStrategy(this.dKv);
        this.dKu.setTextColor(ao.getColor(R.color.cp_cont_b));
    }

    public View getView() {
        return this.mRoot;
    }
}
