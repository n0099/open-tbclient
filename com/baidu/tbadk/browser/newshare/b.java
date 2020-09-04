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
    private TextView afE;
    private TbRichTextView dTG;
    private com.baidu.tbadk.widget.richText.a dTH;
    private TbImageView dTI;
    private TextView dTJ;
    private TextView dTK;
    private TextView dTL;
    private TextView dTM;
    private final ThreadAchievementShareInfo dTa;
    private final ThreadAchievementShareInfo.ParamBean dTb;
    private final Context mContext;
    private final View mRoot;

    public b(Context context, ThreadAchievementShareInfo threadAchievementShareInfo) {
        this.mContext = context;
        this.mRoot = LayoutInflater.from(context).inflate(R.layout.normal_interaction_achievement, (ViewGroup) null);
        this.dTa = threadAchievementShareInfo;
        this.dTb = threadAchievementShareInfo.getParams();
        initUI();
        initData();
    }

    private void initData() {
        if (this.dTb.getContent() != null && this.dTb.getContent().size() != 0) {
            JSONArray jSONArray = new JSONArray();
            ThreadAchievementShareInfo.ContentBean contentBean = null;
            for (ThreadAchievementShareInfo.ContentBean contentBean2 : this.dTb.getContent()) {
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
            if (!TextUtils.isEmpty(this.dTb.getThread_title())) {
                this.afE.setText(this.dTb.getThread_title());
                this.afE.setVisibility(0);
                this.dTG.setMaxLines(6);
            } else {
                ((LinearLayout.LayoutParams) this.dTG.getLayoutParams()).topMargin = l.getDimens(this.mContext, R.dimen.tbds20);
                this.dTG.setMaxLines(8);
            }
            this.dTG.setTextEllipsize(TextUtils.TruncateAt.END);
            this.dTG.setMinimumHeight(l.getDimens(this.mContext, R.dimen.tbds516));
            if (contentBean != null && !TextUtils.isEmpty(contentBean.getSrc()) && this.dTb.getThread_type().contains(UgcUBCUtils.UGC_TYPE_PIC_BTN)) {
                this.dTI.setVisibility(0);
                this.dTI.setDefaultBgResource(R.color.transparent);
                this.dTI.setScaleType(ImageView.ScaleType.CENTER_CROP);
                this.dTI.setPlaceHolder(2);
                this.dTI.startLoad(contentBean.getSrc(), 10, false);
                if (!TextUtils.isEmpty(this.dTb.getThread_title())) {
                    this.dTG.setVisibility(8);
                } else {
                    this.dTG.setMaxLines(2);
                    this.dTG.setTextEllipsize(TextUtils.TruncateAt.END);
                    this.dTG.setLayoutStrategy(this.dTH);
                    this.dTG.setMinimumHeight(l.getDimens(this.mContext, R.dimen.tbds0));
                }
            }
            this.dTG.setText(TbRichTextView.a(this.mContext, jSONArray, false));
            this.dTM.setText(at.cU(this.dTb.getAgree_num()));
            this.dTJ.setText(at.cU(this.dTb.getPost_num()));
        }
    }

    private void initUI() {
        this.dTJ = (TextView) this.mRoot.findViewById(R.id.comment_num);
        this.dTK = (TextView) this.mRoot.findViewById(R.id.comment_desc);
        this.dTL = (TextView) this.mRoot.findViewById(R.id.praise_desc);
        this.dTM = (TextView) this.mRoot.findViewById(R.id.praise_num);
        this.afE = (TextView) this.mRoot.findViewById(R.id.thread_title);
        this.dTI = (TbImageView) this.mRoot.findViewById(R.id.main_img);
        this.dTG = (TbRichTextView) this.mRoot.findViewById(R.id.rich_text);
        this.dTM.setTextColor(ap.getColor(R.color.cp_other_d));
        this.dTJ.setTextColor(ap.getColor(R.color.cp_other_d));
        this.dTL.setTextColor(ap.getColor(R.color.cp_cont_b));
        this.dTK.setTextColor(ap.getColor(R.color.cp_cont_b));
        this.afE.setTextColor(ap.getColor(R.color.cp_cont_b));
        this.dTH = new com.baidu.tbadk.widget.richText.a();
        this.dTH.ri(l.getDimens(this.mContext, R.dimen.tbds38));
        this.dTH.setTextSize(l.getDimens(this.mContext, R.dimen.tbds42));
        this.dTH.rm(l.getDimens(this.mContext, R.dimen.tbds23));
        this.dTH.setLineSpacing(l.getDimens(TbadkCoreApplication.getInst().getContext(), R.dimen.tbds12), 1.0f);
        this.dTH.br(l.getDimens(TbadkCoreApplication.getInst().getContext(), R.dimen.tbds48), l.getDimens(TbadkCoreApplication.getInst().getContext(), R.dimen.tbds48));
        this.dTG.setLayoutStrategy(this.dTH);
        this.dTG.setTextColor(ap.getColor(R.color.cp_cont_b));
    }

    public View getView() {
        return this.mRoot;
    }
}
