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
/* loaded from: classes2.dex */
public class b {
    private TextView afC;
    private final ThreadAchievementShareInfo dSW;
    private final ThreadAchievementShareInfo.ParamBean dSX;
    private TbRichTextView dTC;
    private com.baidu.tbadk.widget.richText.a dTD;
    private TbImageView dTE;
    private TextView dTF;
    private TextView dTG;
    private TextView dTH;
    private TextView dTI;
    private final Context mContext;
    private final View mRoot;

    public b(Context context, ThreadAchievementShareInfo threadAchievementShareInfo) {
        this.mContext = context;
        this.mRoot = LayoutInflater.from(context).inflate(R.layout.normal_interaction_achievement, (ViewGroup) null);
        this.dSW = threadAchievementShareInfo;
        this.dSX = threadAchievementShareInfo.getParams();
        initUI();
        initData();
    }

    private void initData() {
        if (this.dSX.getContent() != null && this.dSX.getContent().size() != 0) {
            JSONArray jSONArray = new JSONArray();
            ThreadAchievementShareInfo.ContentBean contentBean = null;
            for (ThreadAchievementShareInfo.ContentBean contentBean2 : this.dSX.getContent()) {
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
            if (!TextUtils.isEmpty(this.dSX.getThread_title())) {
                this.afC.setText(this.dSX.getThread_title());
                this.afC.setVisibility(0);
                this.dTC.setMaxLines(6);
            } else {
                ((LinearLayout.LayoutParams) this.dTC.getLayoutParams()).topMargin = l.getDimens(this.mContext, R.dimen.tbds20);
                this.dTC.setMaxLines(8);
            }
            this.dTC.setTextEllipsize(TextUtils.TruncateAt.END);
            this.dTC.setMinimumHeight(l.getDimens(this.mContext, R.dimen.tbds516));
            if (contentBean != null && !TextUtils.isEmpty(contentBean.getSrc()) && this.dSX.getThread_type().contains(UgcUBCUtils.UGC_TYPE_PIC_BTN)) {
                this.dTE.setVisibility(0);
                this.dTE.setDefaultBgResource(R.color.transparent);
                this.dTE.setScaleType(ImageView.ScaleType.CENTER_CROP);
                this.dTE.setPlaceHolder(2);
                this.dTE.startLoad(contentBean.getSrc(), 10, false);
                if (!TextUtils.isEmpty(this.dSX.getThread_title())) {
                    this.dTC.setVisibility(8);
                } else {
                    this.dTC.setMaxLines(2);
                    this.dTC.setTextEllipsize(TextUtils.TruncateAt.END);
                    this.dTC.setLayoutStrategy(this.dTD);
                    this.dTC.setMinimumHeight(l.getDimens(this.mContext, R.dimen.tbds0));
                }
            }
            this.dTC.setText(TbRichTextView.a(this.mContext, jSONArray, false));
            this.dTI.setText(at.cU(this.dSX.getAgree_num()));
            this.dTF.setText(at.cU(this.dSX.getPost_num()));
        }
    }

    private void initUI() {
        this.dTF = (TextView) this.mRoot.findViewById(R.id.comment_num);
        this.dTG = (TextView) this.mRoot.findViewById(R.id.comment_desc);
        this.dTH = (TextView) this.mRoot.findViewById(R.id.praise_desc);
        this.dTI = (TextView) this.mRoot.findViewById(R.id.praise_num);
        this.afC = (TextView) this.mRoot.findViewById(R.id.thread_title);
        this.dTE = (TbImageView) this.mRoot.findViewById(R.id.main_img);
        this.dTC = (TbRichTextView) this.mRoot.findViewById(R.id.rich_text);
        this.dTI.setTextColor(ap.getColor(R.color.cp_other_d));
        this.dTF.setTextColor(ap.getColor(R.color.cp_other_d));
        this.dTH.setTextColor(ap.getColor(R.color.cp_cont_b));
        this.dTG.setTextColor(ap.getColor(R.color.cp_cont_b));
        this.afC.setTextColor(ap.getColor(R.color.cp_cont_b));
        this.dTD = new com.baidu.tbadk.widget.richText.a();
        this.dTD.ri(l.getDimens(this.mContext, R.dimen.tbds38));
        this.dTD.setTextSize(l.getDimens(this.mContext, R.dimen.tbds42));
        this.dTD.rm(l.getDimens(this.mContext, R.dimen.tbds23));
        this.dTD.setLineSpacing(l.getDimens(TbadkCoreApplication.getInst().getContext(), R.dimen.tbds12), 1.0f);
        this.dTD.br(l.getDimens(TbadkCoreApplication.getInst().getContext(), R.dimen.tbds48), l.getDimens(TbadkCoreApplication.getInst().getContext(), R.dimen.tbds48));
        this.dTC.setLayoutStrategy(this.dTD);
        this.dTC.setTextColor(ap.getColor(R.color.cp_cont_b));
    }

    public View getView() {
        return this.mRoot;
    }
}
